package Partie;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import Capacite.StrategieDecision;
import Cartes.CarteAction;
import Cartes.Croyants;
import Cartes.OrigineAction;
import Capacite.Sacrifiable;

public class JoueurStrategieHasard implements StrategieDecision {
	private Random r = new Random();
	private Joueur jr;

	@Override
	public Collection<CarteAction> defausser() {
		List<CarteAction> main = new ArrayList<CarteAction>(jr.getCarte());
		Set<CarteAction> defausse = new HashSet<CarteAction>();
		int nbDefausse = r.nextInt(main.size());
		for (int i = 0; i <= nbDefausse; ++i) {
			defausse.add(main.remove(r.nextInt(main.size())));
		}
		System.out.println(jr.getNom() + " a defaussé " + nbDefausse + " cartes");
		return defausse;
	}

	@Override
	public void jouer(Collection<CarteAction> zone) {
		List<Sacrifiable> sacrifiables = Table.getInstance().getSacrifiables(jr);
		if (!sacrifiables.isEmpty()) {
			int nbSacrifices = r.nextInt((int) sacrifiables.size() / 2 + 1);
			for (int i = 0; i <= nbSacrifices; ++i) {
				Sacrifiable c = sacrifiables.remove(r.nextInt(sacrifiables.size()));
				Table.getInstance().sacrifier(jr, c);
				System.out.println(jr.getNom() + " a sacrifié " + c);
			}
		}
		List<CarteAction> posable = getPutables();
		if (!posable.isEmpty()) {
			int nbPuts = r.nextInt(posable.size());
			for (int i = 0; i <= nbPuts; ++i) {
				CarteAction c = posable.remove(r.nextInt(posable.size()));
				jr.poser(c);
				System.out.println(jr.getNom() + " a posé " + c);
			}
		}
		jr.finirTour();
	}

	private List<CarteAction> getPutables() {
		List<CarteAction> hand = new ArrayList<CarteAction>(jr.getCarte());
		List<CarteAction> posable = new ArrayList<CarteAction>();
		for (CarteAction c : hand) {
			if (jr.peutPoser(c)) {
				posable.add(c);
			}
		}
		return posable;
	}

	@Override
	public void setJoueur(Joueur player) {
		this.jr = player;
	}

	@Override
	public Set<Croyants> choisirCroyants(Set<Croyants> prenables, int limite) {
		while (prenables.size() > limite) {
			prenables.remove(r.nextInt(prenables.size()));
		}
		System.out.println(jr.getNom() + " a récupéré " + prenables.size() + " croyants");
		return prenables;
	}

	@Override
	public OrigineAction demanderOrigine() {
		switch (r.nextInt(3)) {
		case 0:
			return OrigineAction.JOUR;
		case 1:
			return OrigineAction.NUIT;
		case 2:
			return OrigineAction.NEANT;
		default:
			return OrigineAction.VIDE;
		}
	}

	@Override
	public void jouerHorsTour() {
		return;

	}
}
