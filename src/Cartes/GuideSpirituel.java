package Cartes;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import Capacite.Sacrifiable;
import Capacite.StrategieCapacite;
import Partie.Joueur;
import Partie.Table;

public class GuideSpirituel extends CarteAction implements Sacrifiable {
	private Dogme dogme1;
	private Dogme dogme2;
	private int nbCarteCroyant;
	private List<Croyants> croyants;

	public GuideSpirituel(String nomCarte, Dogme dogme1, Dogme dogme2, OrigineAction origine, int nbCarteCroyant,
			StrategieCapacite capacite) {
		super(nomCarte, capacite, origine);
		this.dogme1 = dogme1;
		this.dogme2 = dogme2;
		this.origine = origine;
		this.nbCarteCroyant = nbCarteCroyant;
		this.croyants = new ArrayList<Croyants>();
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

	public int getNbCarteCroyant() {
		return nbCarteCroyant;
	}

	public void setNbCarteCroyant(int nbCarteCroyant) {
		this.nbCarteCroyant = nbCarteCroyant;
	}

	public void notifierPerte(Croyants c, Joueur j) {
		croyants.remove(c);
		if (croyants.isEmpty()) {
			Table.getInstance().defausser(j, this);
		}
	}

	public int getScore() {
		int scr = 0;
		for (Croyants c : croyants) {
			scr += c.getNbCroyant();
		}
		return scr;
	}

	public void sacrifier(Joueur j) {
		this.capacite.utiliser(j, this);
		for (Croyants c : croyants) {
			Table.getInstance().poserCentre(c);
		}
	}

	public void poser(Joueur j) {
		Table.getInstance().poserZone(j, this);
		this.recupererCroyants(j);
	}

	private void recupererCroyants(Joueur j) {
		Set<Croyants> prenables = new HashSet<Croyants>();
		for (Croyants b : Table.getInstance().getCentre()) {
			if (b.possedeDogme(this.dogme1) || b.possedeDogme(this.dogme2)) {
				prenables.add(b);
			}
		}
		if (prenables.size() <= this.nbCarteCroyant) {
			Table.getInstance().recuperer(j, this, prenables);
		} else {
			Table.getInstance().recuperer(j, this, j.choisirCroyants(prenables, this.nbCarteCroyant));
		}
	}

	public void add(Croyants c) {
		croyants.add(c);
		c.setGuide(this);
	}

	public List<Croyants> getCroyants() {
		return croyants;
	}

	@Override
	public String toString() {
		return "<" + origine.getNom() + "> Guide Spirituel " + nomCarte + " (peut avoir " + nbCarteCroyant
				+ " croyants), dogmes : [" + dogme1 + ", " + dogme2 + "], sacrifice : " + capacite.getDescription();
	}
}
