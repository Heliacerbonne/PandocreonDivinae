package Capacite;

import Cartes.CarteAction;
import Partie.Joueur;
import Partie.Partie;

public class CapaciteLancerDe implements StrategieCapacite {
	public void utiliser(Joueur j, CarteAction c) {
		Partie.getInstance().lancerDe();
	}

	@Override
	public String getDescription() {
		return "Relancez le d� de Cosmogonie. Le tour se finit normalement sous la nouvelle influence.";
	}
}
