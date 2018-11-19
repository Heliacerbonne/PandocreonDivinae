package Capacite;

import Cartes.CarteAction;
import Partie.Joueur;
import Partie.Partie;

public class CapaciteApocalypse implements StrategieCapacite {

	@Override
	public void utiliser(Joueur j, CarteAction carte) {
		System.out.println("APOCALYPSE du joueur " + j);
		Partie.getInstance().apocalypse(this,carte);
	}

	@Override
	public String getDescription() {
		return "Apocalypse";
	}

}
