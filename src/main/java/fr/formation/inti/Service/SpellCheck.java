package fr.formation.inti.Service;

import java.text.Normalizer;
import java.text.Normalizer.Form;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import fr.formation.inti.entities.Annonces;
import fr.formation.inti.entities.MotsClefs;
import fr.formation.inti.entities.Utilisateurs;
import fr.formation.inti.interfaces.services.IAnnoncesService;
import fr.formation.inti.interfaces.services.IMotsClefsService;
import fr.formation.inti.interfaces.services.IUtilisateursService;

// Le faire en singleton

@Transactional
@Component
public class SpellCheck {

	public HashMap<String, Set<String>> motsEntres;
	private final static int MAX_ERRORS = 3;

	@Autowired
	IMotsClefsService motClefsService;

	@Autowired
	IAnnoncesService annoService;
	@Autowired
	IUtilisateursService utilService;
	
	@PostConstruct
	public void init() {
//		// SpellCheck bean initialization : all keywords are sucked out from database
		List<MotsClefs> mots_clefs = motClefsService.getAllMotsclefs();
		// This block counts announces linked by each keyword
		for (MotsClefs m : mots_clefs) {
			int occurences = motClefsService.countMotClefOccurences(m);
			String mot = m.getMotClef();
			for (int i=0;i<occurences;i++) { // TODO ça bug ici
				this.addMot(mot);
			}
		}		
	}

	public SpellCheck() {
		this.motsEntres = new HashMap<String, Set<String>>();
	}

	// Custom comparator that compares keyword with respect from their occurences
	// count in announce's table
	class BddMotsClesComparator implements Comparator<String> {
		@Override
		public int compare(String a, String b) {
			// String's format is : Word Number, with word being the keyword, and Number its
			// occurences count
			int inta = Integer.parseInt(a.split(" ")[1]);
			int intb = Integer.parseInt(b.split(" ")[1]);
			return inta - intb;
		}
	}

	// Remove every special character
	public static String removeAccents(String text) {
		return text == null ? null
				: Normalizer.normalize(text, Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "")
						.toLowerCase();
	}

	// Convert a word into an 26-integer array
	// in this array, each integer is a letter occurences count
	public static int[] convertMot(String mot) {

		int[] result = new int[26];
		int i = 0;
		for (char ch = 'a'; ch <= 'z'; ch++) {
			result[i] = 0;
			i++;
		}
		for (char c : mot.toCharArray()) {
			i = 0;
			for (char ch = 'a'; ch <= 'z'; ch++) {
				if (c == ch) {
					result[i] += 1;
				}
				i++;
			}
		}
		return result;
	}

	// This method computes possible word's variations by altering an integer array
	public Set<int[]> computeVariations(String mot) {

		// here comes the array
		int[] motNumeric = SpellCheck.convertMot(mot);
		Set<int[]> retour = new HashSet<int[]>();
		retour.add(motNumeric); // the original word is obviously added to possible variations
		int indice = 0; // position tracking in array
		for (int col : motNumeric) {
			int[] var1 = motNumeric.clone();
			int[] var2 = motNumeric.clone();
			var1[indice] += 1; // an extra letter
			retour.add(var1);
			if (var2[indice] != 0) {
				var2[indice] -= 1; // one less letter
				retour.add(var2);
			}
			for (int i = 0; i < motNumeric.length; i++) {
				if (i != indice) {
					if (var1[i] != 0) {
						int[] var3 = var1.clone();
						var3[i] -= 1; // an extra letter and one less letter
						retour.add(var3);
					}
				}
				if (i != indice) {
					int[] var4 = var2.clone();
					var4[i] += 1; // same but in different order
					retour.add(var4);
				}
			}
			indice++;
		}
		return retour;
	}

	// master method that add a string into the hashmap
	public void addMot(String m) {
		String mot = SpellCheck.removeAccents(m);
		int[] motNumeric = SpellCheck.convertMot(mot);
		this.populate(motNumeric, mot);
	}

	// method that update occurences associated with each variation
	public void populate(int[] motVarieList, String mot) {
		String motVarie = "";
		for (int i : motVarieList) {
			motVarie += String.valueOf(i); // Convert the integer array into a string, so it become immutable
		}
		Set<String> tempList = new HashSet<String>();
		if (!this.motsEntres.containsKey(motVarie)) { // if the core hashmap doesn't yet contains this word variation
			this.motsEntres.put(motVarie, new HashSet<String>());
			tempList.add(mot + " 1"); // count initialized
		} else {
			for (String motCompte : motsEntres.get(motVarie)) {
				String[] motTemp = motCompte.split(" "); // getting the list of words associated with this variation
				if (!motTemp[0].equals(mot)) { // if the word is not yet in the list
					tempList.add(motCompte); // its count is left as it is
				} else {
					tempList.add(mot + " " + String.valueOf(Integer.parseInt(motTemp[1]) + 1)); // Otherwise, it's
																								// incremented
				}
			}
		}
		this.motsEntres.put(motVarie, tempList);
	}

	// master method that returns keywords, associated with their occurences count
	public TreeMap<Integer, String> search(String mDemande) {
		String motDemande = SpellCheck.removeAccents(mDemande);
		TreeMap<Integer, String> results = new TreeMap<Integer, String>();
		Set<String> tempResults = new HashSet<String>();
		Set<int[]> motsDemandes = (Set<int[]>) this.computeVariations(motDemande); // word variations computed
		String motDemandeAltered = "";
		if (motDemande.charAt(motDemande.length() - 1) == ('s')) { // plural case management
			motDemandeAltered = motDemande.substring(0, motDemande.length() - 1); // singular
		} else {
			motDemandeAltered = motDemande + "s"; // plural
		}
		motsDemandes.addAll(this.computeVariations(motDemandeAltered)); // plural word variations computed
		motsDemandes.add(SpellCheck.convertMot(motDemande));
		motsDemandes.add(SpellCheck.convertMot(motDemandeAltered)); // original word and its plural inserted
		for (int[] mot : motsDemandes) { // for each possible variation
			String motPossibleString = "";
			for (int i : mot) {
				motPossibleString += String.valueOf(i); // String conversion of integer list symbolizing word variations
			}
			if (this.motsEntres.containsKey(motPossibleString)) { // if this variation is already somewhere
				for (String match : this.motsEntres.get(motPossibleString)) {
					tempResults.add(match); // possible words collected
				}
			}
		}
		for (String match : tempResults) {
			String[] matchCompte = match.split(" "); // Splitting word and occurences count
			if (SpellCheck.calcEnchainement(motDemande, matchCompte[0])) { // calculating letters sequence
				results.put(Integer.valueOf(matchCompte[1]), matchCompte[0]);
			}
		}
		return results;
	}

	// get annonces with respect to keyword
	public Set<Annonces> getAnnonces(String motClef) {

		Set<Annonces> retour = annoService.getAnnoncesByMotClef(motClef);

		return retour;

	}

	// this method compare letter sequences between two words
	public static boolean calcEnchainement(String motRef1, String motAComparer1) {

		String[] motRef = SpellCheck.tokenizationMot(motRef1);
		String[] motAComparer = SpellCheck.tokenizationMot(motAComparer1);

		int nombreErreurs = 0; // number of sequence mismatchs
		int indiceRef = 0; // positionnal index for reference word
		int indiceAC = 0; // positionnal index for other word
		int lenRef = motRef.length - 1; // reference word's length
		int lenAC = motAComparer.length - 1;

		while (true) {
			if (indiceAC == lenAC) { // if we're reaching the other word's end
			
				if (lenRef - indiceRef >= 1) { // if the other word is not yet finished
					nombreErreurs++;
					if (nombreErreurs < MAX_ERRORS) { // if there's not too much mismatchs between letter sequences
						return true;
					}
					return false;
				} else { // if the other word is finished
					if (nombreErreurs > MAX_ERRORS) {
						return false;
					}
					return true;
				}
			}
			if (indiceRef == lenRef) { // same with ref
				if (lenAC - indiceAC >= 1) {
					if (nombreErreurs < MAX_ERRORS) {
						return true;
					}
					return false;
				} else {
					if (nombreErreurs > MAX_ERRORS) {
						return false;
					}
					return true;
				}
			}
			if (motRef[indiceRef].equals(motAComparer[indiceAC])) { // if the currently readed tokens are identical,
																	// everything's fine
				indiceRef++;
				indiceAC++;
			} else { // Error detected !

				// letter left
				if (indiceRef + 2 <= lenRef && indiceAC + 1 <= lenAC) {
					if (motRef[indiceRef + 2].equals(motAComparer[indiceAC + 1])) {
						nombreErreurs += 2;
						indiceRef += 2;
						indiceAC += 1;
						continue;
					}
				}
				// extra letter
				if (indiceAC + 2 <= lenAC && indiceRef + 1 <= lenRef) {
					if (motAComparer[indiceAC + 2].equals(motRef[indiceRef + 1])) {
						nombreErreurs += 2;
						indiceRef += 1;
						indiceAC += 2;
						continue;
					}
				} // different letter
				if (indiceAC + 2 <= lenAC && indiceRef + 2 <= lenRef) {
					if (motAComparer[indiceAC + 2].equals(motRef[indiceRef + 2])) {
						nombreErreurs += 2;
						indiceRef += 2;
						indiceAC += 2;
						continue;
					}
				} // word ending at next iteration
				if (indiceAC + 1 == lenAC && indiceRef + 1 == lenRef) {
					nombreErreurs++;
					indiceRef++;
					indiceAC++;
					continue;
				}
				return false;
			}
		}
	}

	// this method tokenize a word into a sequence of couples of letters
	public static String[] tokenizationMot(String mot) {

		String[] tokenList = new String[mot.length() - 1];
		char buff = mot.charAt(0);
		int i = 0;
		for (char c : mot.toCharArray()) {
			if (i == 0) {
				i++;
				continue;
			}
			tokenList[i - 1] = String.valueOf(buff) + String.valueOf(c);
			buff = c;
			i++;
		}

		return tokenList;
	}

}
