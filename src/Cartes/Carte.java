package Cartes;

import Capacite.StrategieCapacite;

public abstract class Carte {
	protected StrategieCapacite capacite;
	protected String nomCarte;

	public Carte(String nomCarte, StrategieCapacite capacite) {
		this.capacite = capacite;
		this.nomCarte = nomCarte;
	}

	public StrategieCapacite getCapacite() {
		return capacite;
	}

	public String getNomCarte() {
		return nomCarte;
	}

	public String toString() {
		return this.getClass() + ", nom de la Carte : " + this.nomCarte + ", sa capacité : "
				+ this.capacite.getDescription();
	}
}
