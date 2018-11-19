package Capacite;

import java.util.Collection;
import java.util.Set;

import Cartes.CarteAction;
import Cartes.Croyants;
import Cartes.OrigineAction;
import Partie.Joueur;

public interface StrategieDecision {
	public Collection<CarteAction> defausser();

	public void jouer(Collection<CarteAction> zone);

	public Collection<Croyants> choisirCroyants(Set<Croyants> prenables, int limite);

	public void setJoueur(Joueur j);

	public OrigineAction demanderOrigine();

	public void jouerHorsTour();
}
