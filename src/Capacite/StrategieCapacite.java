package Capacite;

import Cartes.CarteAction;
import Partie.Joueur;

public interface StrategieCapacite {
	public void utiliser(Joueur j, CarteAction c);

	public String getDescription();
}
