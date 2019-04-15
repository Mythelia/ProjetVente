package fr.formation.inti.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.persistence.Entity;

// Le faire en singleton

@Entity
public class spellCheck<E> {

	private static HashMap<int[], ArrayList<String>> motsEntres = new HashMap<int[], ArrayList<String>>();
	private final static int MAX_ERRORS = 2;

	public spellCheck() {
		this.motsEntres = motsEntres;
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

	public static List<int[]> populateMotsEntres(String mot) {

		int[] motNumeric = new int[26];
		motNumeric = spellCheck.convertMot(mot);
		List<int[]> retour = new ArrayList();
		retour.add(motNumeric);
		int i = 0; // incrémenter l'indice !
		for (int col : motNumeric) {

			int[] var1 = motNumeric.clone();
			int[] var2 = motNumeric.clone();

			var1[i] += 1;
			retour.add(var1);

			if (var2[i] != 0) {
				var2[i] -= 1;
				retour.add(var2);
			}
			for (int j = 0; j < mot.length(); j++) {
				if (j != i && var1[j] != 0) {
					int[] var3 = var1.clone();
					var3[j] -= 1;
					retour.add(var3);

				}
				if (j != i && var2[j] != 0) {
					int[] var4 = var2.clone();
					var4[j] += 1;
					retour.add(var4);

				}
			}
			i++;
		}
		return retour;
	}

	public static void addMot(String mot) {
		List<int[]> retour = spellCheck.populateMotsEntres(mot);
		for (int[] motNumeric : retour) {
			spellCheck.populate(motNumeric, mot);
		}

	}

	public static void populate(int[] motVarie, String mot) {
		if (!motsEntres.containsKey(motVarie)) {
			motsEntres.put(motVarie, new ArrayList<String>());
		}
		motsEntres.get(motVarie).add(mot);
	}

	public static ArrayList<String> search(String motDemande) {
		List<int[]> matchs = spellCheck.populateMotsEntres(motDemande);
		ArrayList<String> result = new ArrayList<String>();
		for (int[] motNumeric : matchs) {
			for (String elem : motsEntres.get(motNumeric)) {
				if (spellCheck.calcEnchainement(motDemande, elem)) {
					result.add(elem);
				}
			}
		}
		return result;
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
				if (lenRef - indiceRef > 1) {
					if (nombreErreurs < MAX_ERRORS - 1) {
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
				if (lenAC - indiceAC > 1) {
					if (nombreErreurs < MAX_ERRORS - 1) {
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
			if (motRef[indiceRef] == motAComparer[indiceAC]) {
				indiceRef++;
				indiceAC++;
			} else {
				if (indiceRef + 2 <= lenRef && indiceAC + 1 <= lenAC) {
					if (motRef[indiceRef + 2] == motAComparer[indiceAC + 1]) {
						nombreErreurs++;
						indiceRef += 2;
						indiceAC += 1;
						continue;
					}

				}
				if (indiceAC + 2 <= lenAC && indiceRef + 1 <= lenRef) {
					if (motAComparer[indiceAC + 2] == motRef[indiceRef + 1]) {
						nombreErreurs++;
						indiceRef += 1;
						indiceAC += 2;
						continue;
					}
				}

			}

		}
	}

	public static String[] tokenizationMot(String mot) {

		String[] tokenList = new String[mot.length() - 1];
		char buff = mot.charAt(0);
		int i = 0;
		for (char c : mot.toCharArray()) {
			if (i == 0) {
				continue;
			}
			tokenList[i] = String.valueOf(buff) + String.valueOf(c);
			buff = c;
		}

		return tokenList;
	}

}
