package Capacite;

import Cartes.CarteAction;
import Partie.Joueur;

public class CapaciteVide implements StrategieCapacite {
	private String description;

	public CapaciteVide(String description) {
		this.description = description;
	}

	@Override
	public void utiliser(Joueur j, CarteAction carte) {
		System.out.println("Effet vide apeller par joueur " + j.getNom());
	}

	@Override
	public String getDescription() {
		return description;
	}

}
