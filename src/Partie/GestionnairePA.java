package Partie;

import java.util.HashMap;
import java.util.Map;

import Cartes.CarteAction;
import Cartes.OrigineAction;
import Cartes.OrigineDivinite;

public class GestionnairePA {
	private Map<OrigineAction, Integer> pa = new HashMap<OrigineAction, Integer>();
	private OrigineDivinite origine;
	private Main main;

	public void ajouterPA(OrigineAction a) {
		switch (a) {
		case JOUR:
			if (OrigineDivinite.JOUR.equals(this.origine)) {
				this.increment(a, 2);
			}
			if (OrigineDivinite.AUBE.equals(this.origine)) {
				this.increment(a, 1);
			}
			break;
		case NUIT:
			if (OrigineDivinite.NUIT.equals(this.origine)) {
				this.increment(a, 2);
			}
			if (OrigineDivinite.CREPUSCULE.equals(this.origine)) {
				this.increment(a, 1);
			}
			break;
		case NEANT:
			if (OrigineDivinite.AUBE.equals(this.origine)) {
				this.increment(a, 1);
			}
			if (OrigineDivinite.CREPUSCULE.equals(this.origine)) {
				this.increment(a, 1);
			}
			break;
		default:
			System.err.println("Le dé a bugué");
		}
		System.out.println(pa);
	}

	public GestionnairePA(Joueur j, Main main) {
		this.pa = new HashMap<OrigineAction, Integer>();
		this.pa.put(OrigineAction.JOUR, 0);
		this.pa.put(OrigineAction.NUIT, 0);
		this.pa.put(OrigineAction.NEANT, 0);
		this.origine = j.getDivinite().getOrigine();
		this.main = main;
	}

	private void increment(OrigineAction o, int number) {
		pa.put(o, pa.get(o) + number);
	}

	private void usePoints(OrigineAction o, int number) {
		pa.put(o, pa.get(o) - number);
	}

	public boolean poser(CarteAction carte) {
		OrigineAction o = carte.getOrigine();
		if (o.equals(OrigineAction.VIDE)) {
			return main.jouer(carte);
		}
		if (pa.get(o) > 0) {
			if (main.jouer(carte)) {
				usePoints(o, 1);
				return true;
			}
		}
		if (o.equals(OrigineAction.NEANT)) {
			if (pa.get(OrigineAction.JOUR) >= 2) {
				if (main.jouer(carte)) {
					usePoints(OrigineAction.JOUR, 2);
					return true;
				}
			} else if (pa.get(OrigineAction.NUIT) >= 2) {
				if (main.jouer(carte)) {
					usePoints(OrigineAction.NUIT, 2);
					return true;
				}
			}
		}
		return false;
	}

	public boolean peutPoser(CarteAction carte) {
		OrigineAction o = carte.getOrigine();
		if (o.equals(OrigineAction.VIDE)) {
			return true;
		}
		if (pa.get(o) > 0) {
			return true;
		}
		if (o.equals(OrigineAction.NEANT)) {
			return (pa.get(OrigineAction.JOUR) >= 2) || (pa.get(OrigineAction.NUIT) >= 2);
		}
		return false;
	}

	@Override
	public String toString() {
		String str = "";
		for (OrigineAction o : this.pa.keySet()) {
			str += pa.get(o) + " PA " + o.getNom() + " ; ";
		}
		return str;
	}

	public void ajouterPA(OrigineAction o, int quantitePA) {
		pa.put(o, pa.get(o) + quantitePA);
	}
}