package Cartes;

import Capacite.StrategieCapacite;
import Partie.Joueur;

public class Divinite extends Carte {
	private Dogme dogme1;
	private Dogme dogme2;
	private Dogme dogme3;
	private String description;
	private OrigineDivinite origine;
	private boolean effetUtilise;

	public Divinite(String nomCarte, Dogme dogme1, Dogme dogme2, Dogme dogme3, OrigineDivinite origine,
			String description, StrategieCapacite capacite) {
		super(nomCarte, capacite);
		this.dogme1 = dogme1;
		this.dogme2 = dogme2;
		this.dogme3 = dogme3;
		this.origine = origine;
		this.description = description;
		this.effetUtilise = false;
	}

	@Override
	public String toString() {
		return "Divinite [dogme1=" + dogme1 + ", dogme2=" + dogme2 + ", dogme3=" + dogme3 + ", description="
				+ description + ", origine=" + origine + ", capacite=" + capacite + ", nomCarte=" + nomCarte + "]";
	}

	public Dogme getDogme1() {
		return dogme1;
	}

	public Dogme getDogme2() {
		return dogme2;
	}

	public Dogme getDogme3() {
		return dogme3;
	}

	public String getDescription1() {
		return description;
	}

	public OrigineDivinite getOrigine() {
		return origine;
	}

	public void utiliserCapacite(Joueur j) {
		if (!effetUtilise) {
			effetUtilise = true;
			this.capacite.utiliser(j, null);
		}
	}

	public boolean estUtilisee() {
		return effetUtilise;
	}
}
