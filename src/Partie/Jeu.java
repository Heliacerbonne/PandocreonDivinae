package Partie;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Jeu {
	public static Scanner sc = new Scanner(System.in);

	public static int getInt(String texte, int min, int max) {
		int entree = 0;
		do {
			try {
				System.out.print("\r\n" + texte);
				entree = sc.nextInt();
				if(entree < min || entree > max){
					System.err.println("choix incorrect");
				}
			} catch (InputMismatchException e) {
				System.err.println("nombre invalide");
			}
			sc.nextLine();
		} while (entree < min || entree > max);
		return entree;
	}

	public static void main(String[] args) {
		clearScreen();
		System.out.println("Jeu de carte : Divinae");
		System.out.println();
		System.out.println("1. Créer nouvelle partie");
		System.out.println("2. Quitter");
		System.out.println("3. Règle du jeu");
		System.out.println();
		System.out.println("Faites votre choix");

		int choix = getInt("Choix : ", 1, 3);
		switch (choix) {
		case 1:
			clearScreen();
			choixIA();
			break;
		case 2:
			clearScreen();
			quitter();
			break;
		case 3:
			clearScreen();
			choixRegle();
			break;
		}
	}

	private static void choixIA() {
		int choix = getInt("Entrez le nombre d'IA (1-5) : ", 1, 5);
		Partie.init(choix);
	}

	private static void choixRegle() {
		System.out.println("1. Présentation du jeu");
		System.out.println("2. Début de la partie");
		System.out.println("3. Déroulement d'un tour de jeu");
		System.out.println("4. Les cartes d'action");
		System.out.println("5. Les croyants");
		System.out.println("6. Les guides spirituels");
		System.out.println("7. Les Deus Ex");
		System.out.println("8. L'apocalypse");
		System.out.println("9. Retour");
		System.out.println();
		int choix = getInt("Choix : ", 1, 9);
		if (choix < 9) {
			afficheRegle(choix);
		} else if (choix == 9) {
			main(null);
		}

	}

	private static void afficheRegle(int numRegle) {
		clearScreen();
		try {
			BufferedReader in = new BufferedReader(new FileReader(numRegle + ".txt"));
			String line = in.readLine();
			while (line != null) {
				System.out.println(line);
				line = in.readLine();
			}
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println();
		System.out.println();
		System.out.println("1. Retour");
		getInt("Choix : ", 1, 1);
		choixRegle();
	}

	private static void quitter() {
		System.out.println(" Bye ;)");
		sc.close();
	}

	public static void clearScreen() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}

}