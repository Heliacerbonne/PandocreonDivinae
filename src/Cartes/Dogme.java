package Cartes;

public enum Dogme {
	HUMAIN("humain"), NATURE("nature"), CHAOS("chaos"), MYSTIQUE("mystique"), SYMBOLES("symboles"), VIDE("");

	private String nom;

	Dogme(String nom) {
		this.nom = nom;
	}

	public String getNom() {
		return nom;
	}
}
