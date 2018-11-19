package Partie;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Capacite.CapaciteApocalypse;
import Cartes.CarteAction;
import Cartes.ConstructeurCarte;
import Cartes.Divinite;
import Cartes.OrigineAction;

public class Partie {
	private static Partie instance;
	private List<Joueur> joueurs;
	private int joueurCourant;
	private int nbTours = 0;
	private int tourDApocalypse = 1;
	private boolean partieEnCours = true;

	private Partie(int nbJoueur) {
		joueurs = new ArrayList<Joueur>();
		Divinite d = ConstructeurCarte.getInstance().piocherDivinite();
		joueurs.add(new Joueur(d, new InterfaceUtilisateur()));
		for (int i = 0; i < nbJoueur; i++) {
			d = ConstructeurCarte.getInstance().piocherDivinite();
			joueurs.add(new Joueur(d, new JoueurStrategieHasard()));
		}
		Table.init(joueurs);
		for (Joueur j : joueurs) {
			j.completerMain();
		}
		joueurCourant = 0;
	}

	private void prochainJoueur() {
		if (partieEnCours) {
			if (joueurCourant == 0) {
				this.lancerDe();
			}
			joueurs.get(joueurCourant).jouerTour();
		} else {
			Jeu.sc.close();
		}
	}

	public void lancerDe() {
		OrigineAction origine;
		Random r = new Random();
		switch (r.nextInt(3)) {
		case 0:
			origine = OrigineAction.JOUR;
			System.out.println("Le dé est tombé sur la face Jour.");
			break;
		case 1:
			origine = OrigineAction.NUIT;
			System.out.println("Le dé est tombé sur la face Nuit.");
			break;
		case 2:
			origine = OrigineAction.NEANT;
			System.out.println("Le dé est tombé sur la face Néant.");
			break;
		default:
			origine = OrigineAction.VIDE;
		}
		for (Joueur j : joueurs) {
			System.out.println("Joueur " + j.getNom() + ", origine " + j.getDivinite().getOrigine());
			j.getGpa().ajouterPA(origine);
		}
	}

	private void finirTourManche() {
		joueurs.add(joueurs.remove(0));
		joueurCourant = 0;
		++nbTours;
		System.out.println("fin tour" + nbTours);
	}

	public static void init(int nbJoueur) {
		Partie.instance = new Partie(nbJoueur);
		instance.prochainJoueur();
	}

	public static Partie getInstance() {
		return instance;
	}

	public void finirTourJoueur(Joueur joueur) {
		int numJoueur = joueurs.indexOf(joueur);
		if (numJoueur == joueurCourant) {
			for (Joueur j : joueurs) {
				if (j != joueur) {
					j.jouerHorsTour();
				}
			}
			System.out.println(joueurCourant);
			++joueurCourant;
			if (joueurCourant >= joueurs.size()) {
				finirTourManche();
			}
			prochainJoueur();
		}

	}

	public void apocalypse(CapaciteApocalypse apocalypse, CarteAction carte) {
		if (this.nbTours <= this.tourDApocalypse) {
			Table.getInstance().defausser(carte);
		}
		if (joueurs.size() >= 4) {
			int scoreMin = Integer.MAX_VALUE;
			Joueur joueurMin = null;
			int nbJoueurEgalite = 1;
			for (Joueur j : joueurs) {
				int scoreJ = Table.getInstance().getScore(j);
				if (scoreJ < scoreMin) {
					joueurMin = j;
					scoreMin = scoreJ;
					nbJoueurEgalite = 1;
				} else if (scoreJ == scoreMin) {
					nbJoueurEgalite++;
				}
			}
			if (nbJoueurEgalite > 1) {
				Table.getInstance().defausser(carte);
			} else {
				joueurs.remove(joueurMin);
				System.out.println(joueurMin.getNom() + " a perdu.");
			}
		} else {
			int scoreMax = Integer.MIN_VALUE;
			Joueur joueurMax = null;
			int nbJoueurEgalite = 1;
			for (Joueur j : joueurs) {
				int scoreJ = Table.getInstance().getScore(j);
				if (scoreJ > scoreMax) {
					joueurMax = j;
					scoreMax = scoreJ;
					nbJoueurEgalite = 1;
				} else if (scoreJ == scoreMax) {
					nbJoueurEgalite++;
				}
			}
			if (nbJoueurEgalite > 1) {
				Table.getInstance().defausser(carte);
			} else {
				joueurs = new ArrayList<Joueur>();
				joueurs.add(joueurMax);
				System.out.println(joueurMax.getNom() + " a gagné.");
				partieEnCours = false;
			}
		}
		tourDApocalypse = nbTours + 1;
	}

	public List<Joueur> getJoueurs() {
		return joueurs;
	}
}
