package Cartes;

import Capacite.CapaciteApocalypse;

public class Apocalypse extends CarteAction {
	public Apocalypse(String nomCarte, OrigineAction origine) {
		super(nomCarte, new CapaciteApocalypse(), origine);
	}

	@Override
	public String toString() {
		return "<" + origine.getNom() + "> Apocalypse " + nomCarte + ", capacite : " + capacite.getDescription();
	}
}
