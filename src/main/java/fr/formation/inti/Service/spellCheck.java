package fr.formation.inti.Service;

import java.text.Normalizer;
import java.text.Normalizer.Form;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;

// Le faire en singleton

@Entity
public class spellCheck<E> {

	public HashMap<String, Set<String>> motsEntres;
	private final static int MAX_ERRORS = 3;

	public spellCheck() {
		this.motsEntres = new HashMap<String, Set<String>>();
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

		int[] motNumeric = spellCheck.convertMot(mot);
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
		String mot = spellCheck.removeAccents(m);
		int[] motNumeric = spellCheck.convertMot(mot);
		this.populate(motNumeric, mot);
	}

	public void populate(int[] motVarieList, String mot) {
		String motVarie = "";
		for (int i : motVarieList) {
			motVarie += String.valueOf(i);
		}
		if (!this.motsEntres.containsKey(motVarie)) {
			this.motsEntres.put(motVarie, new HashSet<String>());
		}
		Set<String> tempList = new HashSet<String>();
		tempList.addAll(motsEntres.get(motVarie));
		tempList.add(mot);
		this.motsEntres.put(motVarie, tempList);
	}

	public Set<String> search(String mDemande) {
		String motDemande = spellCheck.removeAccents(mDemande);
		Set<String> results = new HashSet<String>();
		Set<String> tempResults = new HashSet<String>();
		Set<int[]> motsDemandes = (Set<int[]>) this.populateMotsEntres(motDemande);
		String motDemandeAltered = "";
		if (motDemande.charAt(motDemande.length() - 1) == ('s')) {
			motDemandeAltered = motDemande.substring(0, motDemande.length() - 1);
		} else {
			motDemandeAltered = motDemande + "s";
		}
		motsDemandes.addAll(this.populateMotsEntres(motDemandeAltered));
		motsDemandes.add(spellCheck.convertMot(motDemande));
		motsDemandes.add(spellCheck.convertMot(motDemandeAltered));
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
			if (spellCheck.calcEnchainement(motDemande, match)) {
				results.add(match);
			}
		}
		return results;
	}

	public static boolean calcEnchainement(String motRef1, String motAComparer1) {

		String[] motRef = spellCheck.tokenizationMot(motRef1);
		String[] motAComparer = spellCheck.tokenizationMot(motAComparer1);

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
