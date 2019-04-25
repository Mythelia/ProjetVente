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
import fr.formation.inti.interfaces.services.IAnnoncesService;
import fr.formation.inti.interfaces.services.IMotsClefsService;

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
	
	@PostConstruct
	public void init() {
		System.out.println("blabla".hashCode());
		List<MotsClefs> mots_clefs = motClefsService.getAllMotsClefs();
		for (MotsClefs m : mots_clefs) {
			this.addMot(m.getMotClef());
		}

	}

	public SpellCheck() {
		this.motsEntres = new HashMap<String, Set<String>>();
	}

	class BddMotsClesComparator implements Comparator<String> {
		@Override
		public int compare(String a, String b) {
			int inta = Integer.parseInt(a.split(" ")[1]);
			int intb = Integer.parseInt(b.split(" ")[1]);
			return inta - intb;
		}
	}

	public static String removeAccents(String text) {
		return text == null ? null
				: Normalizer.normalize(text, Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "")
						.toLowerCase();
	}

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

	public Set<int[]> populateMotsEntres(String mot) {

		int[] motNumeric = SpellCheck.convertMot(mot);
		Set<int[]> retour = new HashSet<int[]>();
		retour.add(motNumeric);
		int indice = 0;
		for (int col : motNumeric) {
			for (int iter = 0; iter < 2; iter++) {
				int[] var1 = motNumeric.clone();
				int[] var2 = motNumeric.clone();
				var1[indice] += 1;
				retour.add(var1);

				if (var2[indice] != 0) {
					var2[indice] -= 1;

					retour.add(var2);
				}
				for (int i = 0; i < mot.length(); i++) {
					if (i != indice) {
						if (var1[i] != 0) {
							int[] var3 = var1.clone();
							var3[i] -= 1;
							retour.add(var3);
						}
					}
					if (i != indice) {
						if (var2[i] != 0) {
							int[] var4 = var2.clone();
							var4[i] += 1;
							retour.add(var4);
						}
					}
				}
			}
			indice++;
		}
		return retour;
	}

	public void addMot(String m) {
		String mot = SpellCheck.removeAccents(m);
		int[] motNumeric = SpellCheck.convertMot(mot);
		this.populate(motNumeric, mot);
	}

	public void populate(int[] motVarieList, String mot) {
		String motVarie = "";
		for (int i : motVarieList) {
			motVarie += String.valueOf(i);
		}
		Set<String> tempList = new HashSet<String>();
		if (!this.motsEntres.containsKey(motVarie)) {
			this.motsEntres.put(motVarie, new HashSet<String>());
			tempList.add(mot + " 1");
		} else {
			for (String motCompte : motsEntres.get(motVarie)) {
				String[] motTemp = motCompte.split(" ");
				if (!motTemp[0].equals(mot)) {
					tempList.add(motCompte);
				} else {
					tempList.add(mot + " " + String.valueOf(Integer.parseInt(motTemp[1]) + 1));
				}
			}
		}
		this.motsEntres.put(motVarie, tempList);
	}

	public TreeMap<Integer, String> search(String mDemande) {
		String motDemande = SpellCheck.removeAccents(mDemande);
		TreeMap<Integer, String> results = new TreeMap<Integer, String>();
		Set<String> tempResults = new HashSet<String>();
		Set<int[]> motsDemandes = (Set<int[]>) this.populateMotsEntres(motDemande);
		String motDemandeAltered = "";
		if (motDemande.charAt(motDemande.length() - 1) == ('s')) {
			motDemandeAltered = motDemande.substring(0, motDemande.length() - 1);
		} else {
			motDemandeAltered = motDemande + "s";
		}
		motsDemandes.addAll(this.populateMotsEntres(motDemandeAltered));
		motsDemandes.add(SpellCheck.convertMot(motDemande));
		motsDemandes.add(SpellCheck.convertMot(motDemandeAltered));
		for (int[] mot : motsDemandes) {
			String motPossibleString = "";
			for (int i : mot) {
				motPossibleString += String.valueOf(i);
			}
			if (this.motsEntres.containsKey(motPossibleString)) {
				for (String match : this.motsEntres.get(motPossibleString)) {
					tempResults.add(match);
				}
			}
		}
		for (String match : tempResults) {
			String[] matchCompte = match.split(" ");
			if (SpellCheck.calcEnchainement(motDemande, matchCompte[0])) {
				results.put(Integer.valueOf(matchCompte[1]), matchCompte[0]);
			}
		}
		return results;
	}
	
	public Set<Annonces> getAnnonces(String motClef) {

		Set<Annonces> retour = annoService.getAnnoncesByMotClef(motClef);

		return retour;
		
	}

	public static boolean calcEnchainement(String motRef1, String motAComparer1) {

		String[] motRef = SpellCheck.tokenizationMot(motRef1);
		String[] motAComparer = SpellCheck.tokenizationMot(motAComparer1);

		int nombreErreurs = 0;
		int indiceRef = 0;
		int indiceAC = 0;
		int lenRef = motRef.length - 1;
		int lenAC = motAComparer.length - 1;

		while (true) {
			if (indiceAC == lenAC) {
				nombreErreurs++;
				if (lenRef - indiceRef >= 1) {

					if (nombreErreurs < MAX_ERRORS) { // TODO : gerer le cas où il reste des erreurs, à la fin
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
			if (indiceRef == lenRef) {
				nombreErreurs++;
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
			if (motRef[indiceRef].equals(motAComparer[indiceAC])) {
				indiceRef++;
				indiceAC++;
			} else {

				// Lettre manquante
				if (indiceRef + 2 <= lenRef && indiceAC + 1 <= lenAC) {
					if (motRef[indiceRef + 2].equals(motAComparer[indiceAC + 1])) {
						nombreErreurs += 2;
						indiceRef += 2;
						indiceAC += 1;
						continue;
					}
				}
				// Lettre en trop
				if (indiceAC + 2 <= lenAC && indiceRef + 1 <= lenRef) {
					if (motAComparer[indiceAC + 2].equals(motRef[indiceRef + 1])) {
						nombreErreurs += 2;
						indiceRef += 1;
						indiceAC += 2;
						continue;
					}
				} // Lettre diff�rente
				if (indiceAC + 2 <= lenAC && indiceRef + 2 <= lenRef) {
					if (motAComparer[indiceAC + 2].equals(motRef[indiceRef + 2])) {
						nombreErreurs += 2;
						indiceRef += 2;
						indiceAC += 2;
						continue;
					}
				} // Autre cas : fin de mot
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
