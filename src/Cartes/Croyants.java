package Cartes;

import Capacite.Sacrifiable;
import Capacite.StrategieCapacite;
import Partie.Joueur;
import Partie.Table;

public class Croyants extends CarteAction implements Sacrifiable {
	private Dogme dogme1;
	private Dogme dogme2;
	private Dogme dogme3;
	private int nbCroyant;
	private GuideSpirituel guide;

	public Croyants(String nomCarte, Dogme dogme1, Dogme dogme2, Dogme dogme3, OrigineAction origine, int nbCroyant,
			StrategieCapacite description) {
		super(nomCarte, description, origine);
		this.dogme1 = dogme1;
		this.dogme2 = dogme2;
		this.dogme3 = dogme3;
		this.origine = origine;
		this.nbCroyant = nbCroyant;
	}

	public Dogme getDogme1() {
		return dogme1;
	}

	public void setDogme1(Dogme dogme1) {
		this.dogme1 = dogme1;
	}

	public Dogme getDogme2() {
		return dogme2;
	}

	public void setDogme2(Dogme dogme2) {
		this.dogme2 = dogme2;
	}

	public Dogme getDogme3() {
		return dogme3;
	}

	public void setDogme3(Dogme dogme3) {
		this.dogme3 = dogme3;
	}

	public int getNbCroyant() {
		return nbCroyant;
	}

	public void setNbCroyant(int nbCroyant) {
		this.nbCroyant = nbCroyant;
	}

	public void poser(Joueur j) {
		Table.getInstance().poserCentre(this);
	}

	public void sacrifier(Joueur j) {
		this.capacite.utiliser(j, this);
		this.guide.notifierPerte(this, j);
	}

	public void setGuide(GuideSpirituel gs) {
		this.guide = gs;
	}

	public boolean possedeDogme(Dogme d) {
		return this.dogme1.equals(d) || this.dogme2.equals(d) || this.dogme3.equals(d);
	}

	@Override
	public String toString() {
		return "<" + origine.getNom() + "> Croyants " + nomCarte + " (" + nbCroyant + " points), dogmes : [" + dogme1
				+ ", " + dogme2 + ", " + dogme3 + "], sacrifice : " + capacite.getDescription();
	}
}
