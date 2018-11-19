package Cartes;

public enum OrigineDivinite {
	JOUR("jour"), AUBE("aube"), CREPUSCULE("cr�puscule"), NUIT("nuit"), VIDE("");

	private String nom;

	OrigineDivinite(String nom) {
		this.nom = nom;
	}

	public String getNom() {
		return nom;
	}
}
