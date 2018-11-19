package Partie;

import java.util.*;

import Capacite.Sacrifiable;
import Cartes.CarteAction;
import Cartes.ConstructeurCarte;
import Cartes.Croyants;
import Cartes.GuideSpirituel;

public class Table {
	private static Table instance = new Table();

	private LinkedList<CarteAction> defausse = new LinkedList<CarteAction>();
	private LinkedList<CarteAction> pioche = new LinkedList<CarteAction>();

	private Set<Croyants> centre = new HashSet<Croyants>();
	private Map<Joueur, Set<CarteAction>> zones = new HashMap<Joueur, Set<CarteAction>>();

	private Table() {
		ConstructeurCarte c = ConstructeurCarte.getInstance();
		this.defausse = new LinkedList<CarteAction>();
		this.pioche = c.listeCarteAction();
	}

	public static void init(List<Joueur> joueurs) {
		for (Joueur j : joueurs) {
			instance.zones.put(j, new HashSet<CarteAction>());
		}
	}

	public void poserCentre(Croyants carte) {
		centre.add(carte);
	}

	public void poserZone(Joueur j, CarteAction c) {
		zones.get(j).add(c);
	}

	public CarteAction piocher() {
		CarteAction c = pioche.removeFirst();

		if (pioche.isEmpty()) {
			LinkedList<CarteAction> echange = pioche;
			pioche = defausse;
			defausse = echange;
		}

		return c;
	}

	public void Sacrifier(Sacrifiable s) {

	}

	public static Table getInstance() {
		return instance;
	}

	public void afficherPioche() {
		for (CarteAction c : pioche) {
			System.out.println(c);
		}
	}

	public void defausser(CarteAction c) {
		defausse.add(c);
	}

	public static void main(String[] args) {
		Table table = Table.getInstance();
		table.afficherPioche();
		System.out.println(table.pioche.size());
	}

	public int getScore(Joueur j) {
		int scr = 0;
		for (CarteAction c : zones.get(j)) {
			if (c instanceof GuideSpirituel) {
				GuideSpirituel g = (GuideSpirituel) c;
				scr += g.getScore();
			}
		}
		return scr;
	}

	public Set<CarteAction> getZone(Joueur j) {
		return zones.get(j);
	}

	public void defausser(Joueur j, GuideSpirituel g) {
		if (zones.get(j).remove(g)) {
			defausse.add(g);
		}
	}

	public Set<Croyants> getCentre() {
		return centre;
	}

	public void recuperer(Joueur j, GuideSpirituel gs, Collection<Croyants> croyants) {
		for (Croyants c : croyants) {
			if (centre.remove(c)) {
				gs.add(c);
				this.zones.get(j).add(c);
			}
		}
	}

	public List<Sacrifiable> getSacrifiables(Joueur j) {
		List<Sacrifiable> sacrifiables = new ArrayList<Sacrifiable>();
		for (CarteAction carte : this.zones.get(j)) {
			if (carte instanceof GuideSpirituel) {
				GuideSpirituel guide = (GuideSpirituel) carte;
				sacrifiables.add(guide);
				for (Croyants croyants : guide.getCroyants()) {
					sacrifiables.add(croyants);
				}
			}
		}
		return sacrifiables;
	}

	public void sacrifier(Joueur joueur, Sacrifiable sacrifiable) {
		if (zones.get(joueur).remove(sacrifiable)) {
			sacrifiable.sacrifier(joueur);
		}
	}
}
