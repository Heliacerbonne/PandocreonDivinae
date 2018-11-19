package Partie;

import java.util.Collection;
import java.util.Set;

import Capacite.StrategieDecision;
import Cartes.CarteAction;
import Cartes.Croyants;
import Cartes.Divinite;
import Cartes.OrigineAction;

public class Joueur {
	private Main main;// les cartes dans la main du joueur
	private GestionnairePA gpa;
	private Divinite divinite;
	private StrategieDecision sd;

	public Joueur(Divinite d, StrategieDecision sd) {
		this.divinite = d;
		this.main = new Main(this);
		this.gpa = new GestionnairePA(this, this.main);
		this.sd = sd;
		this.sd.setJoueur(this);
	}

	public void jouerTour() {
		main.defausser(sd.defausser());
		main.completer();
		sd.jouer(Table.getInstance().getZone(this));
	}

	public Set<CarteAction> getCarte() {// obtenir les cartes qui sont dans la main du joueur
		return main.getCartes();
	}

	public Divinite getDivinite() {
		return divinite;
	}

	public String getNom() {
		return this.divinite.getNomCarte();
	}

	public GestionnairePA getGpa() {
		return gpa;
	}

	public boolean peutPoser(CarteAction carte) {
		return this.gpa.peutPoser(carte);
	}

	public void poser(CarteAction carte) {
		this.gpa.poser(carte);
	}

	public String toString() {
		return this.getNom();
	}

	public void completerMain() {
		main.completer();
	}

	public void finirTour() {
		Partie.getInstance().finirTourJoueur(this);
	}

	public Collection<Croyants> choisirCroyants(Set<Croyants> prenables, int nbCarteCroyant) {
		Collection<Croyants> croyants = null;
		do {
			croyants = this.sd.choisirCroyants(prenables, nbCarteCroyant);
		} while (croyants.size() != nbCarteCroyant);
		return croyants;
	}

	public OrigineAction demanderOrigine() {
		return this.sd.demanderOrigine();
	}

	public void jouerHorsTour() {
		sd.jouerHorsTour();
	}
}
