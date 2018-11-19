package Partie;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import Cartes.CarteAction;

public class Main {
	Set<CarteAction> cartes = new HashSet<CarteAction>();
	private Joueur joueur;

	public Main(Joueur joueur) {
		this.joueur = joueur;
	}

	public boolean jouer(CarteAction carte) {
		if (cartes.remove(carte)) {// si la main contient l'objet on le supprime
			carte.poser(joueur);
			System.out.println(carte);
			this.completer();
			return true;
		}
		return false;
	}

	public boolean defausser(CarteAction carte) {
		if (cartes.remove(carte)) {// si la main contient l'objet on le supprime
			Table.getInstance().defausser(carte);
			System.out.println(carte);// on affiche la carte jouée
			return true;
		}
		return false;
	}

	public void completer() {
		while (cartes.size() != 7) {
			cartes.add(Table.getInstance().piocher());
		}
	}

	@Override
	public String toString() {
		String str = "Main [";
		for (CarteAction carte : cartes) {
			str += "\r\n  " + carte;
		}
		str += "\r\n]";
		return str;
	}

	public Set<CarteAction> getCartes() {
		return cartes;
	}

	public void defausser(Collection<CarteAction> liste) {
		for (CarteAction ca : liste) {
			this.defausser(ca);
		}
	}

}
