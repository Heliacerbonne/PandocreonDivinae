package Capacite;

import Cartes.CarteAction;
import Cartes.GuideSpirituel;
import Cartes.OrigineAction;
import Partie.Joueur;

public class CapaciteDonnerPANbrCroyants implements StrategieCapacite {
	@Override
	public void utiliser(Joueur j, CarteAction c) {
		GuideSpirituel g = (GuideSpirituel) c;
		OrigineAction o = j.demanderOrigine();
		int quantitePA = g.getCroyants().size();
		j.getGpa().ajouterPA(o, quantitePA);
	}

	@Override
	public String getDescription() {
		return "Fait gagner un nombre de points d'Action égal au nombre de cartes de Croyants rattachées. L'Origine des points d'Action est au choix du joueur.";
	}
}
