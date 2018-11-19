package Capacite;

import Cartes.CarteAction;
import Cartes.OrigineAction;
import Partie.Joueur;

public class CapaciteDonnerPA implements StrategieCapacite {
	private OrigineAction o;
	private int quantitePA;

	public CapaciteDonnerPA(OrigineAction o, int quantitePA) {
		this.o = o;
		this.quantitePA = quantitePA;
	}

	@Override
	public void utiliser(Joueur j, CarteAction c) {
		j.getGpa().ajouterPA(o, quantitePA);

	}

	@Override
	public String getDescription() {
		return "Donne " + quantitePA + " point d'Action d'Origine " + o.getNom();
	}

}
