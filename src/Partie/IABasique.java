package Partie;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import Capacite.StrategieDecision;
import Cartes.CarteAction;
import Cartes.Croyants;
import Cartes.OrigineAction;

public class IABasique implements StrategieDecision {
	private Joueur joueur;

	@Override
	public Collection<CarteAction> defausser() {
		// On ne defausse aucune carte
		return new HashSet<CarteAction>();
	}

	@Override
	public void jouer(Collection<CarteAction> zone) {
		// TODO Auto-generated method stub
		joueur.finirTour();
	}

	@Override
	public Collection<Croyants> choisirCroyants(Set<Croyants> prenables, int limite) {
		// TODO Auto-generated method stub
		return new HashSet<Croyants>();
	}

	@Override
	public void setJoueur(Joueur j) {
		this.joueur = j;
	}

	@Override
	public OrigineAction demanderOrigine() {
		switch (this.joueur.getDivinite().getOrigine()) {
		case JOUR:
			return OrigineAction.JOUR;
		case NUIT:
			return OrigineAction.NUIT;
		default:
			return OrigineAction.NEANT;
		}
	}

	@Override
	public void jouerHorsTour() {
		return;

	}

}
