package devoire;

import java.io.Serializable;

public class Compte implements Serializable {

	private static final long serialVersionUID = 1L;
	private int numero;
	private String titulaire;
	private double solde;
	private double decouvertAutorise;

	public Compte(int numero, String titulaire, double solde, double decouvertAutorise) {
		super();
		this.numero = numero;
		this.titulaire = titulaire;
		this.solde = solde;
		this.decouvertAutorise = decouvertAutorise;
	}

	public Compte() {
		super();
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getTitulaire() {
		return titulaire;
	}

	public void setTitulaire(String titulaire) {
		this.titulaire = titulaire;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public double getDecouvertAutorise() {
		return decouvertAutorise;
	}

	public void setDecouvertAutorise(double decouvertAutorise) {
		this.decouvertAutorise = decouvertAutorise;
	}

	@Override
	public String toString() {
		return "Compte [numero=" + numero + ", titulaire=" + titulaire + ", solde=" + solde + ", découvertAutorisé="
				+ decouvertAutorise + "]\n";
	}

}
