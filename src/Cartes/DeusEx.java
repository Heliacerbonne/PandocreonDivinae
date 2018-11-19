package Cartes;

import Capacite.StrategieCapacite;

public class DeusEx extends CarteAction {
	public DeusEx(String nomCarte, StrategieCapacite description, OrigineAction origine) {
		super(nomCarte, description, origine);
	}

	@Override
	public String toString() {
		return "<" + origine.getNom() + "> DeusEx " + nomCarte + ", capacite : " + capacite.getDescription();
	}
}
