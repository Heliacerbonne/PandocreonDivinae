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
						"Emp�che une Divinit� poss�dant le Dogme Nature ou Mystique de sacrifier une de ses cartes de Croyants durant ce tour."));
		paquetCroyants.add(Travailleurs1);
		Croyants Alienes1 = new Croyants("Ali�n�s", Dogme.SYMBOLES, Dogme.HUMAIN, Dogme.CHAOS, OrigineAction.NEANT, 2,
				new CapaciteVide(
						"Emp�che une Divinit� poss�dant le Dogme Nature ou Mystique de sacrifier une de ses cartes de Croyants durant ce tour."));
		paquetCroyants.add(Alienes1);

		Croyants Travailleurs2 = new Croyants("Travailleurs", Dogme.SYMBOLES, Dogme.HUMAIN, Dogme.NATURE,
				OrigineAction.JOUR, 2, new CapaciteVide(
						"Emp�che une Divinit� poss�dant le Dogme Chaos ou mystique de sacrifier une de ses cartes de Croyants durant ce tour."));
		paquetCroyants.add(Travailleurs2);
		Croyants Alienes2 = new Croyants("Ali�n�s", Dogme.SYMBOLES, Dogme.HUMAIN, Dogme.NATURE, OrigineAction.NEANT, 2,
				new CapaciteVide(
						"Emp�che une Divinit� poss�dant le Dogme Chaos ou mystique de sacrifier une de ses cartes de Croyants durant ce tour."));
		paquetCroyants.add(Alienes2);

		Croyants Alienes3 = new Croyants("Ali�n�s", Dogme.MYSTIQUE, Dogme.HUMAIN, Dogme.CHAOS, OrigineAction.NEANT, 2,
				new CapaciteVide("Vous piochez deux cartes au hasard dans la main d'une autre divinit�."));
		paquetCroyants.add(Alienes3);

		Croyants Travailleurs3 = new Croyants("Travailleurs", Dogme.HUMAIN, Dogme.CHAOS, Dogme.MYSTIQUE,
				OrigineAction.JOUR, 2,
				new CapaciteVide("Vous piochez deux cartes au hasard dans la main d'une autre Divinit�."));
		paquetCroyants.add(Travailleurs3);
		// a partir de la :
		Croyants Ermite1 = new Croyants("Ermite", Dogme.NATURE, Dogme.CHAOS, Dogme.MYSTIQUE, OrigineAction.JOUR, 1,
				new CapaciteVide(
						"Impose le sacrifice d'un Croyant d'un autre joueur, qui choisit la carte. La capacit� sp�ciale du sacrifice est jou�e."));
		paquetCroyants.add(Ermite1);
		Croyants Ermite2 = new Croyants("Ermite", Dogme.NATURE, Dogme.SYMBOLES, Dogme.MYSTIQUE, OrigineAction.JOUR, 1,
				new CapaciteVide(
						"Impose le sacrifice d'un Croyant d'un autre joueur, qui choisit la carte. La capacit� sp�ciale du sacrifice est jou�e."));
		paquetCroyants.add(Ermite2);
		Croyants Vampire1 = new Croyants("Vampire", Dogme.HUMAIN, Dogme.NATURE, Dogme.SYMBOLES, OrigineAction.NUIT, 1,
				new CapaciteVide(
						"Impose le sacrifice d'un Croyant d'un autre joueur, qui choisit la carte. La capacit� sp�ciale du sacrifice est jou�e."));
		paquetCroyants.add(Vampire1);
		Croyants Vampire2 = new Croyants("Vampire", Dogme.HUMAIN, Dogme.MYSTIQUE, Dogme.CHAOS, OrigineAction.NUIT, 1,
				new CapaciteVide(
						"Impose le sacrifice d'un Croyant d'un autre joueur, qui choisit la carte. La capacit� sp�ciale du sacrifice est jou�e."));
		paquetCroyants.add(Vampire2);

		Croyants GuerriersSaints = new Croyants("Guerriers Saints", Dogme.NATURE, Dogme.SYMBOLES, Dogme.MYSTIQUE,
				OrigineAction.JOUR, 1, new CapaciteVide(
						"Un Guide Spirituel revient dans la main de sa Divinit�. Ses Croyants reviennent au centre de la table."));
		paquetCroyants.add(GuerriersSaints);

		Croyants Int�gristes = new Croyants("Int�gristes", Dogme.HUMAIN, Dogme.NATURE, Dogme.CHAOS, OrigineAction.JOUR,
				4, new CapaciteVide(
						"Impose le sacrifice d'un Guide Spirituel d'un autre joueur, qui choisit la carte. La capacit� sp�ciale du sacrifice est jou�e."));
		paquetCroyants.add(Int�gristes);

		Croyants Diplomates = new Croyants("Diplomates", Dogme.SYMBOLES, Dogme.HUMAIN, Dogme.CHAOS, OrigineAction.JOUR,
				4, new CapaciteLancerDe());
		paquetCroyants.add(Diplomates);
		Croyants Revenant = new Croyants("Revenant", Dogme.NATURE, Dogme.HUMAIN, Dogme.MYSTIQUE, OrigineAction.NEANT, 1,
				new CapaciteLancerDe());
		paquetCroyants.add(Revenant);

		Croyants Demons1 = new Croyants("D�mons", Dogme.HUMAIN, Dogme.NATURE, Dogme.MYSTIQUE, OrigineAction.NUIT, 2,
				new CapaciteDonnerPA(OrigineAction.NUIT, 1));
		paquetCroyants.add(Demons1);
		Croyants Demons2 = new Croyants("D�mons", Dogme.HUMAIN, Dogme.CHAOS, Dogme.MYSTIQUE, OrigineAction.NUIT, 2,
				new CapaciteDonnerPA(OrigineAction.NUIT, 1));
		paquetCroyants.add(Demons2);
		Croyants Demons3 = new Croyants("D�mons", Dogme.SYMBOLES, Dogme.CHAOS, Dogme.MYSTIQUE, OrigineAction.NUIT, 2,
				new CapaciteDonnerPA(OrigineAction.NUIT, 1));
		paquetCroyants.add(Demons3);
		Croyants Demons4 = new Croyants("D�mons", Dogme.SYMBOLES, Dogme.NATURE, Dogme.MYSTIQUE, OrigineAction.NUIT, 2,
				new CapaciteDonnerPA(OrigineAction.NUIT, 1));
		paquetCroyants.add(Demons4);
		Croyants Demons5 = new Croyants("D�mons", Dogme.CHAOS, Dogme.NATURE, Dogme.MYSTIQUE, OrigineAction.NUIT, 2,
				new CapaciteDonnerPA(OrigineAction.NUIT, 1));
		paquetCroyants.add(Demons5);

		Croyants Alchimistes1 = new Croyants("Alchimistes", Dogme.SYMBOLES, Dogme.NATURE, Dogme.CHAOS,
				OrigineAction.NUIT, 2, new CapaciteVide(
						"Emp�che une Divinit� poss�dant le Dogme Humain ou Mystique de sacrifier une de ses cartes de Croyants durant ce tour de jeu."));
		paquetCroyants.add(Alchimistes1);

		Croyants Alchimistes2 = new Croyants("Alchimistes", Dogme.MYSTIQUE, Dogme.NATURE, Dogme.CHAOS,
				OrigineAction.NUIT, 2, new CapaciteVide(
						"Emp�che une Divinit� poss�dant le Dogme Humain ou Symboles de sacrifier un de ses Guides Spirituels durant ce tour de jeu."));
		paquetCroyants.add(Alchimistes2);

		Croyants Alchimistes3 = new Croyants("Alchimistes", Dogme.SYMBOLES, Dogme.NATURE, Dogme.CHAOS,
				OrigineAction.NUIT, 2,
				new CapaciteVide("Vous piochez deux cartes au hasard dans la main d'une autre Divinit�."));
		paquetCroyants.add(Alchimistes3);

		Croyants Lycanthropes = new Croyants("Lycanthropes", Dogme.HUMAIN, Dogme.NATURE, Dogme.CHAOS,
				OrigineAction.NUIT, 4, new CapaciteVide(
						"Retirez tous les Croyants attach�s � l'un des Guides Spirituels d'une autre Divinit�. Les Croyants reviennent au milieu de la table, le Guide Spirituel est d�fauss�."));
		paquetCroyants.add(Lycanthropes);

		Croyants Pillards = new Croyants("Pillards", Dogme.MYSTIQUE, Dogme.NATURE, Dogme.SYMBOLES, OrigineAction.NUIT,
				4, new CapaciteVide(
						"R�cup�rez les points d'Action d'une Divinit� n'ayant pas encore jou� durant ce tour. Les points d'Action gardent leur Origine. La Divinit� perd ses points."));
		paquetCroyants.add(Pillards);

		Croyants Illusionistes = new Croyants("Illusionistes", Dogme.SYMBOLES, Dogme.HUMAIN, Dogme.CHAOS,
				OrigineAction.NUIT, 4, new CapaciteVide(
						"Vous b�n�ficiez de la capacit� sp�ciale de sacrifice d'une carte de Croyants appartenant � une autre Divinit�. La carte en question reste en jeu."));
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

		Croyants Revolutionnaires = new Croyants("R�volutionnaires", Dogme.HUMAIN, Dogme.CHAOS, Dogme.SYMBOLES,
				OrigineAction.NEANT, 2, new CapaciteVide(
						"Imposez le sacrifice d'une carte de Croyants � autant de Divinit�s que vous le voulez. Chaque Divinit� choisit la carte � sacrifier. Les capacit�s sp�ciales sont jou�es."));
		paquetCroyants.add(Revolutionnaires);

		Croyants Nihillistes = new Croyants("Nihillistes", Dogme.SYMBOLES, Dogme.CHAOS, Dogme.MYSTIQUE,
				OrigineAction.NEANT, 4,
				new CapaciteVide("Jusqu'� la fin du tour, plus aucune Divinit� ne re�oit de points d'Action."));
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
						"Sacrifie tous les Croyants d'Origine N�ant d'une Divinit� ayant le Dogme Humain. Les capacit�s sp�cials sont jou�es normalement."));
		paquetGuides.add(Shaman);

		GuideSpirituel Anarchiste = new GuideSpirituel("Anarchiste ", Dogme.HUMAIN, Dogme.CHAOS, OrigineAction.NEANT, 3,
				new CapaciteVide(
						"Sacrifie un Guide Spirituel, si lui ou sa Divinit� ne croit pas au Dogme Chaos. Les capacit�s sp�ciales sont jou�es normalement."));
		paquetGuides.add(Anarchiste);

		GuideSpirituel Paladin = new GuideSpirituel("Paladin ", Dogme.HUMAIN, Dogme.MYSTIQUE, OrigineAction.JOUR, 3,
				new CapaciteVide(
						"Tous les Croyants, d'Origine Nuit ou N�ant et ayant le Dogme Nature, actuellement sur la table sont d�fauss�s. Les capacit�s sp�ciales ne sont pas jou�es."));
		paquetGuides.add(Paladin);

		GuideSpirituel Ascete = new GuideSpirituel("Asc�te ", Dogme.HUMAIN, Dogme.SYMBOLES, OrigineAction.NUIT, 1,
				new CapaciteVide(
						"Sacrifie 2 cartes Croyants d'une Divinit� ayant le Dogme Humain ou Symboles. Les capacit�s sp�ciales sont jou�es normalement"));
		paquetGuides.add(Ascete);

		GuideSpirituel Devin = new GuideSpirituel("Devin", Dogme.MYSTIQUE, Dogme.NATURE, OrigineAction.NEANT, 1,
				new CapaciteVide(
						"Oblige une Divinit� ayant le Dogme Nature ou Mystique � sacrifier l'un de ses Guides Spirituels"));
		paquetGuides.add(Devin);

		GuideSpirituel Exorciste = new GuideSpirituel("Exorciste", Dogme.MYSTIQUE, Dogme.CHAOS, OrigineAction.JOUR, 1,
				new CapaciteVide(
						"Une Divinit� d'Origine Nuit ou ayant les Dogmes Mystique et Chaos reprend dans sa main l'un de ses Guides Spirituels. Les Croyants qui y �taient attach�s sont d�fauss�s."));
		paquetGuides.add(Exorciste);

		GuideSpirituel Sorcier = new GuideSpirituel("Sorcier", Dogme.SYMBOLES, Dogme.MYSTIQUE, OrigineAction.NUIT, 3,
				new CapaciteVide(
						"�changez l'un de vos Guides Spirituels avec un d'une autre Divinit�. Vous choisissez les deux guides Spirituels en question. Les Croyants restent attach�s aux m�mes cartes."));
		paquetGuides.add(Sorcier);

		GuideSpirituel Tyran = new GuideSpirituel("Tyran", Dogme.CHAOS, Dogme.SYMBOLES, OrigineAction.NEANT, 3,
				new CapaciteVide(
						"D�fausse tous les Croyants ayant le Dogme Mystique actuellement au centre de la table."));
		paquetGuides.add(Tyran);

		GuideSpirituel Messie = new GuideSpirituel("Messie", Dogme.HUMAIN, Dogme.MYSTIQUE, OrigineAction.JOUR, 3,
				new CapaciteVide(
						"Le joueur pose le d� de Cosmogonie sur la face qu'il d�sire et commence un nouveau tour de jeu."));
		paquetGuides.add(Messie);

		return paquetGuides;
	}

	public LinkedList<DeusEx> listeDeusEx() {
		paquetDeusEx = new LinkedList<DeusEx>();
		DeusEx Bouleversement = new DeusEx("Bouleversement", new CapaciteLancerDe(), OrigineAction.VIDE);
		paquetDeusEx.add(Bouleversement);

		DeusEx ColereDivine1 = new DeusEx("Col�re divine",
				new CapaciteVide(
						"D�truit une carte Guide Spirituel d'Origine Nuit ou N�ant, dont la capacit� sp�ciale n'a pas effet. Les Croyants attach�s reviennent au centre de la table."),
				OrigineAction.JOUR);
		paquetDeusEx.add(ColereDivine1);

		DeusEx ColereDivine2 = new DeusEx("Col�re divine",
				new CapaciteVide(
						"D�truit une carte Guide Spirituel d'Origine Jour ou N�ant, dont la capacit� sp�ciale n'a pas effet. Les Croyants attach�s reviennent au centre de la table."),
				OrigineAction.NUIT);
		paquetDeusEx.add(ColereDivine2);

		DeusEx TrouNoir = new DeusEx("Trou noir",
				new CapaciteVide("Aucun autre joueur ne gagne de points d'Action durant ce tour."),
				OrigineAction.NEANT);
		paquetDeusEx.add(TrouNoir);

		DeusEx Stase = new DeusEx("Stase",
				new CapaciteVide(
						"Prot�ge un Guide Spirituel et ses Croyants jusqu'� ce que cette carte soit annul�e ou jusqu'� la prochaine tentative d'Apocalypse."),
				OrigineAction.JOUR);
		paquetDeusEx.add(Stase);

		DeusEx OrdreCeleste = new DeusEx("Ordre C�leste",
				new CapaciteVide(
						"Vous r�cup�rez un des Guides Spirituels pos�s devant une autre Divinit� et le placez devant vous avec les Croyants qui y sont attach�s."),
				OrigineAction.JOUR);
		paquetDeusEx.add(OrdreCeleste);

		DeusEx Fourberie = new DeusEx("Fourberie",
				new CapaciteVide(
						"Sacrifiez 2 cartes Croyants d'une autre Divinit�. Les capacit�s sp�ciales ne sont pas jou�es."),
				OrigineAction.NUIT);
		paquetDeusEx.add(Fourberie);

		DeusEx Diversion = new DeusEx("Diversion",
				new CapaciteVide("Prenez 3 cartes dans la main d'un autre joueur et incluez-les � votre main."),
				OrigineAction.NUIT);
		paquetDeusEx.add(Diversion);

		DeusEx Concentration = new DeusEx("Concentration",
				new CapaciteVide(
						"Vous r�cup�rez un des Guides Spirituels pos�s devant une autre Divinit� et le placez devant vous avec les Croyants qui y sont attach�s"),
				OrigineAction.NEANT);
		paquetDeusEx.add(Concentration);

		DeusEx Phoenix = new DeusEx("Phoenix",
				new CapaciteVide(
						"Permet de b�n�ficier de la capacit� sp�ciale de l'un de vos Croyants ou Guides Spirituels sans sacrifier la carte."),
				OrigineAction.NEANT);
		paquetDeusEx.add(Phoenix);

		DeusEx InfluenceJour = new DeusEx("Influence Jour",
				new CapaciteVide("Annule la capacit� sp�ciale d'une carte d'Action d'Origine Nuit ou N�ant."),
				OrigineAction.VIDE);
		paquetDeusEx.add(InfluenceJour);

		DeusEx InfluenceNuit = new DeusEx("Influence Nuit",
				new CapaciteVide("Annule la capacit� sp�ciale d'une carte d'Action d'Origine Jour ou N�ant."),
				OrigineAction.VIDE);
		paquetDeusEx.add(InfluenceNuit);

		DeusEx InfluenceNeant = new DeusEx("Influence N�ant",
				new CapaciteVide("Annule la capacit� sp�ciale d'une carte d'Action d'Origine Jour ou Nuit."),
				OrigineAction.VIDE);
		paquetDeusEx.add(InfluenceNeant);

		DeusEx InfluenceNulle1 = new DeusEx("Influence Nulle",
				new CapaciteVide("Annule la capacit� sp�ciale d'une autre carte d'Action."), OrigineAction.VIDE);
		paquetDeusEx.add(InfluenceNulle1);

		DeusEx InfluenceNulle2 = new DeusEx("Influence Nulle",
				new CapaciteVide("Annule la capacit� sp�ciale d'une autre carte d'Action."), OrigineAction.VIDE);
		paquetDeusEx.add(InfluenceNulle2);

		DeusEx Transe = new DeusEx("Col�re divine",
				new CapaciteVide(
						"Permet de r�cup�rer les effets b�n�fiques d'une carte d'Action pos�e par une autre Divinit�. S'il s'agit d'une carte Croyants ou Guide Spirituel, vous posez la carte devant vous."),
				OrigineAction.VIDE);
		paquetDeusEx.add(Transe);

		DeusEx Miroir = new DeusEx("Miroir",
				new CapaciteVide("Retourne les effets d'une carte d'action sur la divinit� qui la poss�de"),
				OrigineAction.VIDE);
		paquetDeusEx.add(Miroir);

		DeusEx Inquisition = new DeusEx("Inquisition",
				new CapaciteVide(
						"Choisissez un des guides spirituels d'un autre joueur et l'un des votres. Lancez le d� de cosmogonie. Sur jour, , le Guide adverse est sacrifi�, sur Nuit le votre est sacrifi�, surN�ant rien ne se passe."),
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
				"Premier enfant du Jour, Brewalen cherche � repr�senter une certaine image de l'harmonie, et tente de mettre en place un statu quo entre les Divinit�s.",
				new CapaciteVide("Peut emp�cher l'utilisation d'une carte Apocalypse. La carte est d�fauss�e."));
		paquetDivinites.add(Brewalen);
		Divinite Divinded = new Divinite("Divinded ", Dogme.NATURE, Dogme.HUMAIN, Dogme.SYMBOLES, OrigineDivinite.JOUR,
				"D�fenseur des hommes, quelles que soient leurs croyances, Drinded prot�ge les chefs religieux",
				new CapaciteVide("Peut emp�cher le sacrifice d'un des Guides Spirituels de n'importe quel joueur."));
		paquetDivinites.add(Divinded);
		Divinite Yarstur = new Divinite("Yarstur ", Dogme.CHAOS, Dogme.SYMBOLES, Dogme.MYSTIQUE, OrigineDivinite.JOUR,
				"Dernier pur du jour, Yarstur combat le N�ant sous toutes ses formes.",
				new CapaciteVide("Peut d�truire toutes les cartes de Croyants au centre de la table d'Origine N�ant."));
		paquetDivinites.add(Yarstur);
		Divinite Llewella = new Divinite("Llewella ", Dogme.NATURE, Dogme.CHAOS, Dogme.MYSTIQUE, OrigineDivinite.NUIT,
				"Divinit� machiav�lique et manipulatrice, Killinstred cherche � influencer et contr�ler ses ennemis.",
				new CapaciteVide("Peut obliger un joueur � poser une carte Apocalypse s'il en poss�de une."));
		paquetDivinites.add(Llewella);
		Divinite PuiTara = new Divinite("Pui-Tara ", Dogme.NATURE, Dogme.SYMBOLES, Dogme.MYSTIQUE, OrigineDivinite.NUIT,
				"Pui-Tara est la Divinit� sur laquelle l'influence de la Nuit s'est faite la plus forte.",
				new CapaciteVide("Peut d�truire toutes les cartes de Croyants au centre de la table d'Origine Jour."));
		paquetDivinites.add(PuiTara);
		Divinite Killinstred = new Divinite("Killinstred ", Dogme.NATURE, Dogme.CHAOS, Dogme.MYSTIQUE,
				OrigineDivinite.NUIT,
				"Divinit� machiav�lique et manipulatrice, Killinstred cherche � influencer et contr�ler ses ennemis.",
				new CapaciteVide("Peut obliger un joueur � poser une carte Apocalypse s'il en poss�de une."));
		paquetDivinites.add(Killinstred);
		Divinite Gwenghelen = new Divinite("Gwenghelen ", Dogme.HUMAIN, Dogme.SYMBOLES, Dogme.MYSTIQUE,
				OrigineDivinite.AUBE,
				"Premi�re Divinit� � recevoir l'influence du N�ant, Gwenghelen est celle qui en a re�u le plus de puissance.",
				new CapaciteVide(
						"R�cup�re autant de points d'Action suppl�mentaires d'Origine N�ant que le nombre de Guides Spirituels que la Divinit� poss�de."));
		paquetDivinites.add(Gwenghelen);
		Divinite Shingva = new Divinite("Shingva ", Dogme.HUMAIN, Dogme.CHAOS, Dogme.MYSTIQUE, OrigineDivinite.AUBE,
				"Perverse et retorse, Shingva est une Divinit� que toutes les autres d�testent.",
				new CapaciteVide("Peut imposer le sacrifice d'un Guide Spirituel ayant le Dogme Symboles ou Nature."));
		paquetDivinites.add(Shingva);
		Divinite Gorpa = new Divinite("Gorpa ", Dogme.HUMAIN, Dogme.SYMBOLES, Dogme.CHAOS, OrigineDivinite.CREPUSCULE,
				"Divinit� joueuse et espi�gle, Gorpa aime g�ner ses cons�urs dans leur recherche de puissance.",
				new CapaciteVide(
						"Peut r�cup�rer les points d'Action d'une autre Divinit� en plus des siens. L'autre Divinit� ne re�oit aucun point d'Action ce tour-ci."));
		paquetDivinites.add(Gorpa);
		Divinite Romtec = new Divinite("Romtec  ", Dogme.NATURE, Dogme.CHAOS, Dogme.HUMAIN, OrigineDivinite.CREPUSCULE,
				"Romtec est une Divinit� individualiste, pour qui chaque �tre vivant doit garder son libre arbitre.",
				new CapaciteVide("Peut emp�cher un joueur de cr�er un Guide Spirituel. La carte est d�fauss�e."));
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
