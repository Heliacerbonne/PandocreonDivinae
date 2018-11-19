package Partie;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import Capacite.Sacrifiable;
import Capacite.StrategieDecision;
import Cartes.Apocalypse;
import Cartes.CarteAction;
import Cartes.Croyants;
import Cartes.OrigineAction;

public class InterfaceUtilisateur implements StrategieDecision {
	private Joueur joueur;

	@Override
	public Collection<CarteAction> defausser() {
		List<CarteAction> defausse = new ArrayList<CarteAction>();
		List<CarteAction> main = new ArrayList<CarteAction>(joueur.getCarte());
		while (true) {
			System.out.println("Phase 1 - Defausse");
			System.out.println("  1. Ajouter une carte a defausser");
			System.out.println("  2. Enlever une carte a defausser");
			System.out.println("  3. Valider");
			int choix = Jeu.getInt("Choix : ", 1, 3);
			switch (choix) {
			case 1:
				System.out.println("Ajouter une carte a defausser");
				System.out.println("  0. Retour");
				this.afficherMenu(main);
				choix = Jeu.getInt("Choix : ", 0, main.size());
				if (choix > 0) {
					defausse.add(main.remove(choix - 1));
				}
				break;
			case 2:
				System.out.println("Enlever une carte a defausser");
				System.out.println("  0. Retour");
				this.afficherMenu(defausse);
				choix = Jeu.getInt("Choix : ", 0, defausse.size());
				if (choix > 0) {
					main.add(defausse.remove(choix - 1));
				}
				break;
			case 3:
				return defausse;
			}
		}
	}

	@Override
	public void jouer(Collection<CarteAction> zone) {
		System.out.println("Phase 2 - Pioche : vous avez 7 cartes en main");
		System.out.println();
		while (true) {
			boolean used = joueur.getDivinite().estUtilisee();
			List<CarteAction> main = new ArrayList<CarteAction>(joueur.getCarte());
			System.out.println("Phase 3 - Jeu");
			System.out.println("  1. Consulter vos informations");
			System.out.println("  2. Poser une carte");
			System.out.println("  3. Sacrifier une carte posee");
			System.out.println("  4. Voir les Croyants au centre de la table");
			System.out.println("  5. Voir les Points de Priere de chaque joueur");
			if (!used) {
				System.out.println("  6. Utiliser l'effet special de la Divinite");
			}
			System.out.println("  " + (used ? 6 : 7) + ". Finir le tour");
			int choix = Jeu.getInt("Choix : ", 1, used ? 6 : 7);
			switch (choix) {
			case 1:
				System.out.println("Vos informations");
				System.out.println();
				System.out.println("- Vos Points d'Action : " + joueur.getGpa());
				System.out.println("- Votre Divinite : " + joueur.getDivinite());
				break;
			case 2:
				System.out.println("Poser une carte");
				System.out.println("  0. Retour");
				this.afficherMenu(main);
				choix = Jeu.getInt("Choix : ", 0, main.size());
				if (choix > 0) {
					CarteAction carte = main.get(choix - 1);
					if (joueur.peutPoser(carte)) {
						joueur.poser(carte);
						if (carte instanceof Apocalypse) {
							joueur.finirTour();
							return;
						}
					} else {
						System.err.println("Vous n'avez pas assez de PA");
					}
				}
				break;
			case 3:
				System.out.println("Sacrifier une carte posee");
				System.out.println("  0. Retour");
				List<Sacrifiable> sacrifiables = Table.getInstance().getSacrifiables(joueur);
				this.afficherMenu(sacrifiables);
				choix = Jeu.getInt("Choix : ", 0, sacrifiables.size());
				if (choix > 0) {
					Table.getInstance().sacrifier(joueur, sacrifiables.get(choix - 1));
				}
				break;
			case 4:
				System.out.println("Croyants au centre de la table : " + Table.getInstance().getCentre().size());
				System.out.println("  0. Retour");
				Collection<Croyants> centre = Table.getInstance().getCentre();
				this.afficherMenu(centre);
				choix = Jeu.getInt("Choix : ", 0, centre.size());
				break;
			case 5:
				for (Joueur j : Partie.getInstance().getJoueurs()) {
					System.out.println("Joueur " + j.getNom() + " : " + Table.getInstance().getScore(j));
				}
				break;
			case 6:
				if (!used) {
					this.joueur.getDivinite().utiliserCapacite(joueur);
					break;
				}
				joueur.finirTour();
				return;
			case 7:
				joueur.finirTour();
				return;
			}
		}
	}

	private void afficherMenu(Collection<?> collection) {
		int i = 0;
		for (Object item : collection) {
			System.out.println("  " + (++i) + ". " + item.toString());
		}
	}

	@Override
	public void setJoueur(Joueur joueur) {
		this.joueur = joueur;
	}

	@Override
	public Collection<Croyants> choisirCroyants(Set<Croyants> prenables, int limite) {
		List<Croyants> choisis = new ArrayList<Croyants>();
		List<Croyants> disponibles = new ArrayList<Croyants>(prenables);
		while (true) {
			System.out.println("Il y a " + prenables.size()
					+ " cartes Croyants, on ne peut en prendre qu'un maximum de " + limite);
			System.out.println("Selection : " + choisis.size() + "/" + limite);
			System.out.println("  1. Selectionner une carte Croyants");
			System.out.println("  2. Deselectionner une carte Croyants");
			System.out.println("  3. Valider");
			int choix = Jeu.getInt("Choix : ", 1, 3);
			switch (choix) {
			case 1:
				System.out.println("Selectionner une carte Croyants");
				System.out.println("  0. Retour");
				this.afficherMenu(disponibles);
				choix = Jeu.getInt("Choix : ", 0, disponibles.size());
				if (choix > 0) {
					choisis.add(disponibles.remove(choix - 1));
				}
				break;
			case 2:
				System.out.println("Deselectionner une carte Croyants");
				System.out.println("  0. Retour");
				this.afficherMenu(choisis);
				choix = Jeu.getInt("Choix : ", 0, choisis.size());
				if (choix > 0) {
					disponibles.add(choisis.remove(choix - 1));
				}
				break;
			case 3:
				if (choisis.size() > limite) {
					System.err.println("Vous ne pouvez pas selectionner autant de Croyants.");
					break;
				} else {
					return choisis;
				}
			}
		}
	}

	@Override
	public OrigineAction demanderOrigine() {
		System.out.println("Choisir une origine pour vous attribuer des PA : ");
		System.out.println("  1. Origine Jour");
		System.out.println("  2. Origine Nuit");
		System.out.println("  3. Origine Néant");
		int choix = Jeu.getInt("Choix : ", 1, 3);
		switch (choix) {
		case 1:
			return OrigineAction.JOUR;
		case 2:
			return OrigineAction.NUIT;
		case 3:
			return OrigineAction.NEANT;
		default:
			return OrigineAction.VIDE;
		}
	}

	@Override
	public void jouerHorsTour() {
		List<CarteAction> main = new ArrayList<CarteAction>(joueur.getCarte());
		List<CarteAction> utilisables = new ArrayList<CarteAction>();
		for (CarteAction carte : main) {
			if (OrigineAction.VIDE.equals(carte.getOrigine())) {
				utilisables.add(carte);
			}
		}
		if (utilisables.isEmpty()) {
			return;
		}
		System.out.println("Voulez-vous jouer hors de votre tour ?");
		System.out.println("  1. Oui");
		System.out.println("  2. Non");
		int choix = Jeu.getInt("Choix : ", 1, 2);
		switch (choix) {
		case 1:
			System.out.println("  0. Annuler");
			afficherMenu(utilisables);
			choix = Jeu.getInt("Choix : ", 0, utilisables.size());
			if (choix > 0) {
				joueur.poser(utilisables.get(choix - 1));
			}
			break;
		case 2:
			return;
		}
	}

}