package Cartes;

public enum OrigineAction {
	JOUR("jour"), NEANT("n�ant"), NUIT("nuit"), VIDE("");

	private String nom;

	OrigineAction(String nom) {
		this.nom = nom;
	}

	public String getNom() {
		return nom;
	}

}
