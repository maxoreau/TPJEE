package fr.ibformation.TPJavaEE.models;

public class Contact {
	private String nom;
	private String prenom;
	private String numero;
	
	public Contact() {
		super();
	}

	public Contact(String prenom, String nom, String numero) {
		super();
		this.prenom = prenom;
		this.nom = nom;
		this.numero = numero;
	}
	
	public Contact(Contact c) {
		super();
		this.prenom = c.prenom;
		this.nom = c.nom;
		this.numero = c.numero;
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}

	@Override
	public String toString() {
		return "Contact [nom=" + nom + ", prenom=" + prenom + ", numero=" + numero + "]";
	}
	
	
	

}
