package Cartes;

import java.util.Collections;
import java.util.LinkedList;

import Capacite.CapaciteApocalypse;
import Capacite.CapaciteDonnerPA;
import Capacite.CapaciteDonnerPANbrCroyants;
import Capacite.CapaciteLancerDe;
import Capacite.CapaciteVide;

public class ConstructeurCarte {
	private static ConstructeurCarte INSTANCE = new ConstructeurCarte();

	protected LinkedList<Croyants> paquetCroyants;
	protected LinkedList<GuideSpirituel> paquetGuides;
	protected LinkedList<Apocalypse> paquetApocalypses;
	protected LinkedList<DeusEx> paquetDeusEx;
	protected LinkedList<Divinite> paquetDivinites;
	protected LinkedList<CarteAction> paquetCartes;

	private ConstructeurCarte() {
		this.paquetCroyants = listeCroyants();
		this.paquetGuides = listeGuide();
		this.paquetApocalypses = listeApocalypse();
		this.paquetDeusEx = listeDeusEx();
		this.paquetDivinites = listeDivinite();

		this.paquetCartes = new LinkedList<CarteAction>();
		paquetCartes.addAll(this.paquetGuides);
		paquetCartes.addAll(this.paquetCroyants);
		paquetCartes.addAll(this.paquetDeusEx);
		paquetCartes.addAll(this.paquetApocalypses);
		Collections.shuffle(paquetCartes);
	}

	public static ConstructeurCarte getInstance() {
		return INSTANCE;
	}

	public LinkedList<Croyants> listeCroyants() {
		paquetCroyants = new LinkedList<Croyants>();
		Croyants Moine1 = new Croyants("Moine", Dogme.HUMAIN, Dogme.NATURE, Dogme.MYSTIQUE, OrigineAction.JOUR, 2,
				new CapaciteDonnerPA(OrigineAction.JOUR, 1));
		paquetCroyants.add(Moine1);
		Croyants Moine2 = new Croyants("Moine", Dogme.HUMAIN, Dogme.CHAOS, Dogme.MYSTIQUE, OrigineAction.JOUR, 2,
				new CapaciteDonnerPA(OrigineAction.JOUR, 1));
		paquetCroyants.add(Moine2);
		Croyants Moine3 = new Croyants("Moine", Dogme.SYMBOLES, Dogme.CHAOS, Dogme.MYSTIQUE, OrigineAction.JOUR, 2,
				new CapaciteDonnerPA(OrigineAction.JOUR, 1));
		paquetCroyants.add(Moine3);
		Croyants Moine4 = new Croyants("Moine", Dogme.SYMBOLES, Dogme.NATURE, Dogme.MYSTIQUE, OrigineAction.JOUR, 2,
				new CapaciteDonnerPA(OrigineAction.JOUR, 1));
		paquetCroyants.add(Moine4);
		Croyants Moine5 = new Croyants("Moine", Dogme.NATURE, Dogme.CHAOS, Dogme.MYSTIQUE, OrigineAction.JOUR, 2,
				new CapaciteDonnerPA(OrigineAction.JOUR, 1));
		paquetCroyants.add(Moine5);

		Croyants Travailleurs1 = new Croyants("Travailleurs", Dogme.SYMBOLES, Dogme.HUMAIN, Dogme.CHAOS,
				OrigineAction.JOUR, 2, new CapaciteVide(
						"Empêche une Divinité possédant le Dogme Nature ou Mystique de sacrifier une de ses cartes de Croyants durant ce tour."));
		paquetCroyants.add(Travailleurs1);
		Croyants Alienes1 = new Croyants("Aliénés", Dogme.SYMBOLES, Dogme.HUMAIN, Dogme.CHAOS, OrigineAction.NEANT, 2,
				new CapaciteVide(
						"Empêche une Divinité possédant le Dogme Nature ou Mystique de sacrifier une de ses cartes de Croyants durant ce tour."));
		paquetCroyants.add(Alienes1);

		Croyants Travailleurs2 = new Croyants("Travailleurs", Dogme.SYMBOLES, Dogme.HUMAIN, Dogme.NATURE,
				OrigineAction.JOUR, 2, new CapaciteVide(
						"Empêche une Divinité possédant le Dogme Chaos ou mystique de sacrifier une de ses cartes de Croyants durant ce tour."));
		paquetCroyants.add(Travailleurs2);
		Croyants Alienes2 = new Croyants("Aliénés", Dogme.SYMBOLES, Dogme.HUMAIN, Dogme.NATURE, OrigineAction.NEANT, 2,
				new CapaciteVide(
						"Empêche une Divinité possédant le Dogme Chaos ou mystique de sacrifier une de ses cartes de Croyants durant ce tour."));
		paquetCroyants.add(Alienes2);

		Croyants Alienes3 = new Croyants("Aliénés", Dogme.MYSTIQUE, Dogme.HUMAIN, Dogme.CHAOS, OrigineAction.NEANT, 2,
				new CapaciteVide("Vous piochez deux cartes au hasard dans la main d'une autre divinité."));
		paquetCroyants.add(Alienes3);

		Croyants Travailleurs3 = new Croyants("Travailleurs", Dogme.HUMAIN, Dogme.CHAOS, Dogme.MYSTIQUE,
				OrigineAction.JOUR, 2,
				new CapaciteVide("Vous piochez deux cartes au hasard dans la main d'une autre Divinité."));
		paquetCroyants.add(Travailleurs3);
		// a partir de la :
		Croyants Ermite1 = new Croyants("Ermite", Dogme.NATURE, Dogme.CHAOS, Dogme.MYSTIQUE, OrigineAction.JOUR, 1,
				new CapaciteVide(
						"Impose le sacrifice d'un Croyant d'un autre joueur, qui choisit la carte. La capacité spéciale du sacrifice est jouée."));
		paquetCroyants.add(Ermite1);
		Croyants Ermite2 = new Croyants("Ermite", Dogme.NATURE, Dogme.SYMBOLES, Dogme.MYSTIQUE, OrigineAction.JOUR, 1,
				new CapaciteVide(
						"Impose le sacrifice d'un Croyant d'un autre joueur, qui choisit la carte. La capacité spéciale du sacrifice est jouée."));
		paquetCroyants.add(Ermite2);
		Croyants Vampire1 = new Croyants("Vampire", Dogme.HUMAIN, Dogme.NATURE, Dogme.SYMBOLES, OrigineAction.NUIT, 1,
				new CapaciteVide(
						"Impose le sacrifice d'un Croyant d'un autre joueur, qui choisit la carte. La capacité spéciale du sacrifice est jouée."));
		paquetCroyants.add(Vampire1);
		Croyants Vampire2 = new Croyants("Vampire", Dogme.HUMAIN, Dogme.MYSTIQUE, Dogme.CHAOS, OrigineAction.NUIT, 1,
				new CapaciteVide(
						"Impose le sacrifice d'un Croyant d'un autre joueur, qui choisit la carte. La capacité spéciale du sacrifice est jouée."));
		paquetCroyants.add(Vampire2);

		Croyants GuerriersSaints = new Croyants("Guerriers Saints", Dogme.NATURE, Dogme.SYMBOLES, Dogme.MYSTIQUE,
				OrigineAction.JOUR, 1, new CapaciteVide(
						"Un Guide Spirituel revient dans la main de sa Divinité. Ses Croyants reviennent au centre de la table."));
		paquetCroyants.add(GuerriersSaints);

		Croyants Intégristes = new Croyants("Intégristes", Dogme.HUMAIN, Dogme.NATURE, Dogme.CHAOS, OrigineAction.JOUR,
				4, new CapaciteVide(
						"Impose le sacrifice d'un Guide Spirituel d'un autre joueur, qui choisit la carte. La capacité spéciale du sacrifice est jouée."));
		paquetCroyants.add(Intégristes);

		Croyants Diplomates = new Croyants("Diplomates", Dogme.SYMBOLES, Dogme.HUMAIN, Dogme.CHAOS, OrigineAction.JOUR,
				4, new CapaciteLancerDe());
		paquetCroyants.add(Diplomates);
		Croyants Revenant = new Croyants("Revenant", Dogme.NATURE, Dogme.HUMAIN, Dogme.MYSTIQUE, OrigineAction.NEANT, 1,
				new CapaciteLancerDe());
		paquetCroyants.add(Revenant);

		Croyants Demons1 = new Croyants("Démons", Dogme.HUMAIN, Dogme.NATURE, Dogme.MYSTIQUE, OrigineAction.NUIT, 2,
				new CapaciteDonnerPA(OrigineAction.NUIT, 1));
		paquetCroyants.add(Demons1);
		Croyants Demons2 = new Croyants("Démons", Dogme.HUMAIN, Dogme.CHAOS, Dogme.MYSTIQUE, OrigineAction.NUIT, 2,
				new CapaciteDonnerPA(OrigineAction.NUIT, 1));
		paquetCroyants.add(Demons2);
		Croyants Demons3 = new Croyants("Démons", Dogme.SYMBOLES, Dogme.CHAOS, Dogme.MYSTIQUE, OrigineAction.NUIT, 2,
				new CapaciteDonnerPA(OrigineAction.NUIT, 1));
		paquetCroyants.add(Demons3);
		Croyants Demons4 = new Croyants("Démons", Dogme.SYMBOLES, Dogme.NATURE, Dogme.MYSTIQUE, OrigineAction.NUIT, 2,
				new CapaciteDonnerPA(OrigineAction.NUIT, 1));
		paquetCroyants.add(Demons4);
		Croyants Demons5 = new Croyants("Démons", Dogme.CHAOS, Dogme.NATURE, Dogme.MYSTIQUE, OrigineAction.NUIT, 2,
				new CapaciteDonnerPA(OrigineAction.NUIT, 1));
		paquetCroyants.add(Demons5);

		Croyants Alchimistes1 = new Croyants("Alchimistes", Dogme.SYMBOLES, Dogme.NATURE, Dogme.CHAOS,
				OrigineAction.NUIT, 2, new CapaciteVide(
						"Empêche une Divinité possédant le Dogme Humain ou Mystique de sacrifier une de ses cartes de Croyants durant ce tour de jeu."));
		paquetCroyants.add(Alchimistes1);

		Croyants Alchimistes2 = new Croyants("Alchimistes", Dogme.MYSTIQUE, Dogme.NATURE, Dogme.CHAOS,
				OrigineAction.NUIT, 2, new CapaciteVide(
						"Empêche une Divinité possédant le Dogme Humain ou Symboles de sacrifier un de ses Guides Spirituels durant ce tour de jeu."));
		paquetCroyants.add(Alchimistes2);

		Croyants Alchimistes3 = new Croyants("Alchimistes", Dogme.SYMBOLES, Dogme.NATURE, Dogme.CHAOS,
				OrigineAction.NUIT, 2,
				new CapaciteVide("Vous piochez deux cartes au hasard dans la main d'une autre Divinité."));
		paquetCroyants.add(Alchimistes3);

		Croyants Lycanthropes = new Croyants("Lycanthropes", Dogme.HUMAIN, Dogme.NATURE, Dogme.CHAOS,
				OrigineAction.NUIT, 4, new CapaciteVide(
						"Retirez tous les Croyants attachés à l'un des Guides Spirituels d'une autre Divinité. Les Croyants reviennent au milieu de la table, le Guide Spirituel est défaussé."));
		paquetCroyants.add(Lycanthropes);

		Croyants Pillards = new Croyants("Pillards", Dogme.MYSTIQUE, Dogme.NATURE, Dogme.SYMBOLES, OrigineAction.NUIT,
				4, new CapaciteVide(
						"Récupérez les points d'Action d'une Divinité n'ayant pas encore joué durant ce tour. Les points d'Action gardent leur Origine. La Divinité perd ses points."));
		paquetCroyants.add(Pillards);

		Croyants Illusionistes = new Croyants("Illusionistes", Dogme.SYMBOLES, Dogme.HUMAIN, Dogme.CHAOS,
				OrigineAction.NUIT, 4, new CapaciteVide(
						"Vous bénéficiez de la capacité spéciale de sacrifice d'une carte de Croyants appartenant à une autre Divinité. La carte en question reste en jeu."));
		paquetCroyants.add(Illusionistes);

		Croyants Esprits1 = new Croyants("Esprits", Dogme.NATURE, Dogme.HUMAIN, Dogme.MYSTIQUE, OrigineAction.NEANT, 2,
				new CapaciteDonnerPA(OrigineAction.NEANT, 1));
		paquetCroyants.add(Esprits1);
		Croyants Esprits2 = new Croyants("Esprits", Dogme.HUMAIN, Dogme.CHAOS, Dogme.MYSTIQUE, OrigineAction.NEANT, 2,
				new CapaciteDonnerPA(OrigineAction.NEANT, 1));
		paquetCroyants.add(Esprits2);
		Croyants Esprits3 = new Croyants("Esprits", Dogme.SYMBOLES, Dogme.CHAOS, Dogme.MYSTIQUE, OrigineAction.NEANT, 2,
				new CapaciteDonnerPA(OrigineAction.NEANT, 1));
		paquetCroyants.add(Esprits3);
		Croyants Esprits4 = new Croyants("Esprits", Dogme.NATURE, Dogme.SYMBOLES, Dogme.MYSTIQUE, OrigineAction.NEANT,
				2, new CapaciteDonnerPA(OrigineAction.NEANT, 1));
		paquetCroyants.add(Esprits4);
		Croyants Esprits5 = new Croyants("Esprits", Dogme.NATURE, Dogme.CHAOS, Dogme.MYSTIQUE, OrigineAction.NEANT, 2,
				new CapaciteDonnerPA(OrigineAction.NEANT, 1));
		paquetCroyants.add(Esprits5);

		Croyants Revolutionnaires = new Croyants("Révolutionnaires", Dogme.HUMAIN, Dogme.CHAOS, Dogme.SYMBOLES,
				OrigineAction.NEANT, 2, new CapaciteVide(
						"Imposez le sacrifice d'une carte de Croyants à autant de Divinités que vous le voulez. Chaque Divinité choisit la carte à sacrifier. Les capacités spéciales sont jouées."));
		paquetCroyants.add(Revolutionnaires);

		Croyants Nihillistes = new Croyants("Nihillistes", Dogme.SYMBOLES, Dogme.CHAOS, Dogme.MYSTIQUE,
				OrigineAction.NEANT, 4,
				new CapaciteVide("Jusqu'à la fin du tour, plus aucune Divinité ne reçoit de points d'Action."));
		paquetCroyants.add(Nihillistes);

		return paquetCroyants;
	}

	public LinkedList<GuideSpirituel> listeGuide() {
		paquetGuides = new LinkedList<GuideSpirituel>();
		GuideSpirituel Martyr1 = new GuideSpirituel("Martyr  ", Dogme.HUMAIN, Dogme.NATURE, OrigineAction.JOUR, 2,
				new CapaciteApocalypse());
		paquetGuides.add(Martyr1);
		GuideSpirituel Martyr2 = new GuideSpirituel("Martyr  ", Dogme.HUMAIN, Dogme.SYMBOLES, OrigineAction.NUIT, 2,
				new CapaciteApocalypse());
		paquetGuides.add(Martyr2);
		GuideSpirituel Martyr3 = new GuideSpirituel("Martyr  ", Dogme.CHAOS, Dogme.NATURE, OrigineAction.NEANT, 2,
				new CapaciteApocalypse());
		paquetGuides.add(Martyr3);

		GuideSpirituel Clerc1 = new GuideSpirituel("Clerc ", Dogme.HUMAIN, Dogme.CHAOS, OrigineAction.JOUR, 2,
				new CapaciteDonnerPANbrCroyants());
		paquetGuides.add(Clerc1);
		GuideSpirituel Clerc2 = new GuideSpirituel("Clerc ", Dogme.CHAOS, Dogme.NATURE, OrigineAction.JOUR, 2,
				new CapaciteDonnerPANbrCroyants());
		paquetGuides.add(Clerc2);
		GuideSpirituel Clerc3 = new GuideSpirituel("Clerc ", Dogme.SYMBOLES, Dogme.NATURE, OrigineAction.NUIT, 2,
				new CapaciteDonnerPANbrCroyants());
		paquetGuides.add(Clerc3);
		GuideSpirituel Clerc4 = new GuideSpirituel("Clerc ", Dogme.SYMBOLES, Dogme.MYSTIQUE, OrigineAction.NUIT, 2,
				new CapaciteDonnerPANbrCroyants());
		paquetGuides.add(Clerc4);
		GuideSpirituel Clerc5 = new GuideSpirituel("Clerc ", Dogme.MYSTIQUE, Dogme.NATURE, OrigineAction.NEANT, 2,
				new CapaciteDonnerPANbrCroyants());
		paquetGuides.add(Clerc5);
		GuideSpirituel Clerc6 = new GuideSpirituel("Clerc ", Dogme.CHAOS, Dogme.SYMBOLES, OrigineAction.NEANT, 2,
				new CapaciteDonnerPANbrCroyants());
		paquetGuides.add(Clerc6);
		GuideSpirituel Clerc7 = new GuideSpirituel("Clerc ", Dogme.CHAOS, Dogme.MYSTIQUE, OrigineAction.JOUR, 2,
				new CapaciteDonnerPANbrCroyants());
		paquetGuides.add(Clerc7);
		GuideSpirituel Clerc8 = new GuideSpirituel("Clerc ", Dogme.HUMAIN, Dogme.NATURE, OrigineAction.NUIT, 2,
				new CapaciteDonnerPANbrCroyants());
		paquetGuides.add(Clerc8);

		GuideSpirituel Shaman = new GuideSpirituel("Shaman ", Dogme.SYMBOLES, Dogme.NATURE, OrigineAction.NUIT, 3,
				new CapaciteVide(
						"Sacrifie tous les Croyants d'Origine Néant d'une Divinité ayant le Dogme Humain. Les capacités spécials sont jouées normalement."));
		paquetGuides.add(Shaman);

		GuideSpirituel Anarchiste = new GuideSpirituel("Anarchiste ", Dogme.HUMAIN, Dogme.CHAOS, OrigineAction.NEANT, 3,
				new CapaciteVide(
						"Sacrifie un Guide Spirituel, si lui ou sa Divinité ne croit pas au Dogme Chaos. Les capacités spéciales sont jouées normalement."));
		paquetGuides.add(Anarchiste);

		GuideSpirituel Paladin = new GuideSpirituel("Paladin ", Dogme.HUMAIN, Dogme.MYSTIQUE, OrigineAction.JOUR, 3,
				new CapaciteVide(
						"Tous les Croyants, d'Origine Nuit ou Néant et ayant le Dogme Nature, actuellement sur la table sont défaussés. Les capacités spéciales ne sont pas jouées."));
		paquetGuides.add(Paladin);

		GuideSpirituel Ascete = new GuideSpirituel("Ascète ", Dogme.HUMAIN, Dogme.SYMBOLES, OrigineAction.NUIT, 1,
				new CapaciteVide(
						"Sacrifie 2 cartes Croyants d'une Divinité ayant le Dogme Humain ou Symboles. Les capacités spéciales sont jouées normalement"));
		paquetGuides.add(Ascete);

		GuideSpirituel Devin = new GuideSpirituel("Devin", Dogme.MYSTIQUE, Dogme.NATURE, OrigineAction.NEANT, 1,
				new CapaciteVide(
						"Oblige une Divinité ayant le Dogme Nature ou Mystique à sacrifier l'un de ses Guides Spirituels"));
		paquetGuides.add(Devin);

		GuideSpirituel Exorciste = new GuideSpirituel("Exorciste", Dogme.MYSTIQUE, Dogme.CHAOS, OrigineAction.JOUR, 1,
				new CapaciteVide(
						"Une Divinité d'Origine Nuit ou ayant les Dogmes Mystique et Chaos reprend dans sa main l'un de ses Guides Spirituels. Les Croyants qui y étaient attachés sont défaussés."));
		paquetGuides.add(Exorciste);

		GuideSpirituel Sorcier = new GuideSpirituel("Sorcier", Dogme.SYMBOLES, Dogme.MYSTIQUE, OrigineAction.NUIT, 3,
				new CapaciteVide(
						"Échangez l'un de vos Guides Spirituels avec un d'une autre Divinité. Vous choisissez les deux guides Spirituels en question. Les Croyants restent attachés aux mêmes cartes."));
		paquetGuides.add(Sorcier);

		GuideSpirituel Tyran = new GuideSpirituel("Tyran", Dogme.CHAOS, Dogme.SYMBOLES, OrigineAction.NEANT, 3,
				new CapaciteVide(
						"Défausse tous les Croyants ayant le Dogme Mystique actuellement au centre de la table."));
		paquetGuides.add(Tyran);

		GuideSpirituel Messie = new GuideSpirituel("Messie", Dogme.HUMAIN, Dogme.MYSTIQUE, OrigineAction.JOUR, 3,
				new CapaciteVide(
						"Le joueur pose le dé de Cosmogonie sur la face qu'il désire et commence un nouveau tour de jeu."));
		paquetGuides.add(Messie);

		return paquetGuides;
	}

	public LinkedList<DeusEx> listeDeusEx() {
		paquetDeusEx = new LinkedList<DeusEx>();
		DeusEx Bouleversement = new DeusEx("Bouleversement", new CapaciteLancerDe(), OrigineAction.VIDE);
		paquetDeusEx.add(Bouleversement);

		DeusEx ColereDivine1 = new DeusEx("Colère divine",
				new CapaciteVide(
						"Détruit une carte Guide Spirituel d'Origine Nuit ou Néant, dont la capacité spéciale n'a pas effet. Les Croyants attachés reviennent au centre de la table."),
				OrigineAction.JOUR);
		paquetDeusEx.add(ColereDivine1);

		DeusEx ColereDivine2 = new DeusEx("Colère divine",
				new CapaciteVide(
						"Détruit une carte Guide Spirituel d'Origine Jour ou Néant, dont la capacité spéciale n'a pas effet. Les Croyants attachés reviennent au centre de la table."),
				OrigineAction.NUIT);
		paquetDeusEx.add(ColereDivine2);

		DeusEx TrouNoir = new DeusEx("Trou noir",
				new CapaciteVide("Aucun autre joueur ne gagne de points d'Action durant ce tour."),
				OrigineAction.NEANT);
		paquetDeusEx.add(TrouNoir);

		DeusEx Stase = new DeusEx("Stase",
				new CapaciteVide(
						"Protège un Guide Spirituel et ses Croyants jusqu'à ce que cette carte soit annulée ou jusqu'à la prochaine tentative d'Apocalypse."),
				OrigineAction.JOUR);
		paquetDeusEx.add(Stase);

		DeusEx OrdreCeleste = new DeusEx("Ordre Céleste",
				new CapaciteVide(
						"Vous récupérez un des Guides Spirituels posés devant une autre Divinité et le placez devant vous avec les Croyants qui y sont attachés."),
				OrigineAction.JOUR);
		paquetDeusEx.add(OrdreCeleste);

		DeusEx Fourberie = new DeusEx("Fourberie",
				new CapaciteVide(
						"Sacrifiez 2 cartes Croyants d'une autre Divinité. Les capacités spéciales ne sont pas jouées."),
				OrigineAction.NUIT);
		paquetDeusEx.add(Fourberie);

		DeusEx Diversion = new DeusEx("Diversion",
				new CapaciteVide("Prenez 3 cartes dans la main d'un autre joueur et incluez-les à votre main."),
				OrigineAction.NUIT);
		paquetDeusEx.add(Diversion);

		DeusEx Concentration = new DeusEx("Concentration",
				new CapaciteVide(
						"Vous récupérez un des Guides Spirituels posés devant une autre Divinité et le placez devant vous avec les Croyants qui y sont attachés"),
				OrigineAction.NEANT);
		paquetDeusEx.add(Concentration);

		DeusEx Phoenix = new DeusEx("Phoenix",
				new CapaciteVide(
						"Permet de bénéficier de la capacité spéciale de l'un de vos Croyants ou Guides Spirituels sans sacrifier la carte."),
				OrigineAction.NEANT);
		paquetDeusEx.add(Phoenix);

		DeusEx InfluenceJour = new DeusEx("Influence Jour",
				new CapaciteVide("Annule la capacité spéciale d'une carte d'Action d'Origine Nuit ou Néant."),
				OrigineAction.VIDE);
		paquetDeusEx.add(InfluenceJour);

		DeusEx InfluenceNuit = new DeusEx("Influence Nuit",
				new CapaciteVide("Annule la capacité spéciale d'une carte d'Action d'Origine Jour ou Néant."),
				OrigineAction.VIDE);
		paquetDeusEx.add(InfluenceNuit);

		DeusEx InfluenceNeant = new DeusEx("Influence Néant",
				new CapaciteVide("Annule la capacité spéciale d'une carte d'Action d'Origine Jour ou Nuit."),
				OrigineAction.VIDE);
		paquetDeusEx.add(InfluenceNeant);

		DeusEx InfluenceNulle1 = new DeusEx("Influence Nulle",
				new CapaciteVide("Annule la capacité spéciale d'une autre carte d'Action."), OrigineAction.VIDE);
		paquetDeusEx.add(InfluenceNulle1);

		DeusEx InfluenceNulle2 = new DeusEx("Influence Nulle",
				new CapaciteVide("Annule la capacité spéciale d'une autre carte d'Action."), OrigineAction.VIDE);
		paquetDeusEx.add(InfluenceNulle2);

		DeusEx Transe = new DeusEx("Colère divine",
				new CapaciteVide(
						"Permet de récupérer les effets bénéfiques d'une carte d'Action posée par une autre Divinité. S'il s'agit d'une carte Croyants ou Guide Spirituel, vous posez la carte devant vous."),
				OrigineAction.VIDE);
		paquetDeusEx.add(Transe);

		DeusEx Miroir = new DeusEx("Miroir",
				new CapaciteVide("Retourne les effets d'une carte d'action sur la divinité qui la possède"),
				OrigineAction.VIDE);
		paquetDeusEx.add(Miroir);

		DeusEx Inquisition = new DeusEx("Inquisition",
				new CapaciteVide(
						"Choisissez un des guides spirituels d'un autre joueur et l'un des votres. Lancez le dè de cosmogonie. Sur jour, , le Guide adverse est sacrifié, sur Nuit le votre est sacrifié, surNéant rien ne se passe."),
				OrigineAction.VIDE);
		paquetDeusEx.add(Inquisition);

		return paquetDeusEx;
	}

	public LinkedList<Apocalypse> listeApocalypse() {
		paquetApocalypses = new LinkedList<Apocalypse>();
		Apocalypse Apocalypse1 = new Apocalypse("Apocalypse", OrigineAction.JOUR);
		paquetApocalypses.add(Apocalypse1);
		Apocalypse Apocalypse2 = new Apocalypse("Apocalypse", OrigineAction.NUIT);
		paquetApocalypses.add(Apocalypse2);
		Apocalypse Apocalypse3 = new Apocalypse("Apocalypse", OrigineAction.NEANT);
		paquetApocalypses.add(Apocalypse3);
		Apocalypse Apocalypse4 = new Apocalypse("Apocalypse", OrigineAction.VIDE);
		paquetApocalypses.add(Apocalypse4);
		Apocalypse Apocalypse5 = new Apocalypse("Apocalypse", OrigineAction.VIDE);
		paquetApocalypses.add(Apocalypse5);

		return paquetApocalypses;
	}

	public LinkedList<Divinite> listeDivinite() {
		paquetDivinites = new LinkedList<Divinite>();
		Divinite Brewalen = new Divinite("Brewalen", Dogme.NATURE, Dogme.HUMAIN, Dogme.MYSTIQUE, OrigineDivinite.JOUR,
				"Premier enfant du Jour, Brewalen cherche à représenter une certaine image de l'harmonie, et tente de mettre en place un statu quo entre les Divinités.",
				new CapaciteVide("Peut empêcher l'utilisation d'une carte Apocalypse. La carte est défaussée."));
		paquetDivinites.add(Brewalen);
		Divinite Divinded = new Divinite("Divinded ", Dogme.NATURE, Dogme.HUMAIN, Dogme.SYMBOLES, OrigineDivinite.JOUR,
				"Défenseur des hommes, quelles que soient leurs croyances, Drinded protège les chefs religieux",
				new CapaciteVide("Peut empêcher le sacrifice d'un des Guides Spirituels de n'importe quel joueur."));
		paquetDivinites.add(Divinded);
		Divinite Yarstur = new Divinite("Yarstur ", Dogme.CHAOS, Dogme.SYMBOLES, Dogme.MYSTIQUE, OrigineDivinite.JOUR,
				"Dernier pur du jour, Yarstur combat le Néant sous toutes ses formes.",
				new CapaciteVide("Peut détruire toutes les cartes de Croyants au centre de la table d'Origine Néant."));
		paquetDivinites.add(Yarstur);
		Divinite Llewella = new Divinite("Llewella ", Dogme.NATURE, Dogme.CHAOS, Dogme.MYSTIQUE, OrigineDivinite.NUIT,
				"Divinité machiavélique et manipulatrice, Killinstred cherche à influencer et contrôler ses ennemis.",
				new CapaciteVide("Peut obliger un joueur à poser une carte Apocalypse s'il en possède une."));
		paquetDivinites.add(Llewella);
		Divinite PuiTara = new Divinite("Pui-Tara ", Dogme.NATURE, Dogme.SYMBOLES, Dogme.MYSTIQUE, OrigineDivinite.NUIT,
				"Pui-Tara est la Divinité sur laquelle l'influence de la Nuit s'est faite la plus forte.",
				new CapaciteVide("Peut détruire toutes les cartes de Croyants au centre de la table d'Origine Jour."));
		paquetDivinites.add(PuiTara);
		Divinite Killinstred = new Divinite("Killinstred ", Dogme.NATURE, Dogme.CHAOS, Dogme.MYSTIQUE,
				OrigineDivinite.NUIT,
				"Divinité machiavélique et manipulatrice, Killinstred cherche à influencer et contrôler ses ennemis.",
				new CapaciteVide("Peut obliger un joueur à poser une carte Apocalypse s'il en possède une."));
		paquetDivinites.add(Killinstred);
		Divinite Gwenghelen = new Divinite("Gwenghelen ", Dogme.HUMAIN, Dogme.SYMBOLES, Dogme.MYSTIQUE,
				OrigineDivinite.AUBE,
				"Première Divinité à recevoir l'influence du Néant, Gwenghelen est celle qui en a reçu le plus de puissance.",
				new CapaciteVide(
						"Récupère autant de points d'Action supplémentaires d'Origine Néant que le nombre de Guides Spirituels que la Divinité possède."));
		paquetDivinites.add(Gwenghelen);
		Divinite Shingva = new Divinite("Shingva ", Dogme.HUMAIN, Dogme.CHAOS, Dogme.MYSTIQUE, OrigineDivinite.AUBE,
				"Perverse et retorse, Shingva est une Divinité que toutes les autres détestent.",
				new CapaciteVide("Peut imposer le sacrifice d'un Guide Spirituel ayant le Dogme Symboles ou Nature."));
		paquetDivinites.add(Shingva);
		Divinite Gorpa = new Divinite("Gorpa ", Dogme.HUMAIN, Dogme.SYMBOLES, Dogme.CHAOS, OrigineDivinite.CREPUSCULE,
				"Divinité joueuse et espiègle, Gorpa aime gêner ses consœurs dans leur recherche de puissance.",
				new CapaciteVide(
						"Peut récupérer les points d'Action d'une autre Divinité en plus des siens. L'autre Divinité ne reçoit aucun point d'Action ce tour-ci."));
		paquetDivinites.add(Gorpa);
		Divinite Romtec = new Divinite("Romtec  ", Dogme.NATURE, Dogme.CHAOS, Dogme.HUMAIN, OrigineDivinite.CREPUSCULE,
				"Romtec est une Divinité individualiste, pour qui chaque être vivant doit garder son libre arbitre.",
				new CapaciteVide("Peut empêcher un joueur de créer un Guide Spirituel. La carte est défaussée."));
		paquetDivinites.add(Romtec);
		Collections.shuffle(paquetDivinites);
		return paquetDivinites;
	}

	public Divinite piocherDivinite() {
		return paquetDivinites.removeFirst();
	}

	public LinkedList<CarteAction> listeCarteAction() {
		return paquetCartes;
	}
}
