package fr.formation.inti.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.Normalizer;
import java.text.Normalizer.Form;
import java.util.Scanner;

import fr.formation.inti.Dao.MotsClefsDao;
import fr.formation.inti.entities.MotsClefs;

public class testSpell {
	

	public static String removeAccents(String text) {
	    return text == null ? null :
	        Normalizer.normalize(text, Form.NFD)
	            .replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
	}
	public static void main(String[] args) throws IOException {
		SpellCheck sc = new SpellCheck();
//		sc.addMot("voiture");
//		System.out.println(sc.search("voiturres"));
//		for (Object s : sc.motsEntres.keySet()) {
//			System.out.println(s);
//		}
//		System.out.println(sc.motsEntres);


		// TODO : transformer le retour en Set
		// TODO : gerer l'unicité des mots dans les seaux
//		String inputPath = "\\Users\\IN-ST-002\\Liste_mots_fr.txt";
//		BufferedReader reader = new BufferedReader(new FileReader(inputPath));		
//
//		String mot = "";
//		
//		MotsClefsDao mcd = new MotsClefsDao();
//
//
//		System.out.println("ouais");
//		try {
//			while(reader.ready()) {
//				MotsClefs mc = new MotsClefs();
//				mot = reader.readLine();
//				System.out.println(mot);
//				mc.setMotClef(mot);
//				mcd.create(mc);
//				
//			}
//		}
//		catch (NullPointerException e) {
//			System.out.println("null !");
//		}
//
//		finally {reader.close();}

		String inputPath = "\\Users\\IN-ST-002\\Liste_mots_fr.txt";
		BufferedReader reader = new BufferedReader(new FileReader(inputPath));		

		String mot = "";
		
		
		
		long time = System.currentTimeMillis();
		int i = 0;
		long i2 = 0;
		long itemp = 0;
		int mapSize = 0;
		try {
			while(reader.ready()) {
				sc.addMot(reader.readLine());
				i++;
				if (i%1000 == 0) {
					System.out.println("--------------");
					System.out.println(i);
					i2 = System.currentTimeMillis();
					itemp+= i2 - time;
					System.out.println("time used : " + (float) (i2 - time)/1000 + "s");
					System.out.println("Temps total : " + (float) itemp/1000 + "s");
					time = System.currentTimeMillis();
					System.out.println("hashmap size increment : " + (sc.motsEntres.size() - mapSize));
					mapSize = sc.motsEntres.size();
					System.out.println("hashmap total size : " + mapSize);
				}
			}
		}
		catch (NullPointerException e) {
			
		}

		finally {reader.close();}
		Scanner scanner = new Scanner(System.in);
		String input = "";
		while(true) {
			System.out.println("Entrez le mot à chercher");
			input = scanner.nextLine();

			long tempSearch = System.currentTimeMillis();
			System.out.println(sc.search(input));
			System.out.println("research time : " + (float) (System.currentTimeMillis() - tempSearch)/1000 + "s");
			if (input.equals("0")) {
				scanner.close();
				System.exit(0);
			}
		}
	}

}
