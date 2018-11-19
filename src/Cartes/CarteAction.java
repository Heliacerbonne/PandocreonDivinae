package Cartes;

import Capacite.StrategieCapacite;
import Partie.Joueur;
import Partie.Table;

public abstract class CarteAction extends Carte {
	protected OrigineAction origine;

	public CarteAction(String nomCarte, StrategieCapacite capacite, OrigineAction origine) {
		super(nomCarte, capacite);
		this.origine = origine;
	}

	public OrigineAction getOrigine() {
		return origine;
	}

	public void setOrigine(OrigineAction origine) {
		this.origine = origine;
	}

	public void poser(Joueur j) {
		Table.getInstance().poserZone(j, this);
		this.capacite.utiliser(j, this);
	}
}
