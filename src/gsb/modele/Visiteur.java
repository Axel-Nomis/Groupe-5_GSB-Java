package gsb.modele;

import java.util.Date;

public class Visiteur {
	
	protected String matricule;
	protected String nom;
	protected String prenom;
	protected String login;
	protected String mdp;
	protected String adresse;
	protected String telephone;
	protected Date date_entree;
	protected int prime;
	
	
	
	
	public Visiteur(String matricule, String nom, String prenom, String login, String mdp, String adresse,
			String telephone, Date date_entree, int prime) {
		this.matricule = matricule;
		this.nom = nom;
		this.prenom = prenom;
		this.login = login;
		this.mdp = mdp;
		this.adresse = adresse;
		this.telephone = telephone;
		this.date_entree = date_entree;
		this.prime = prime;
	}




	public String getMatricule() {
		return matricule;
	}




	public void setMatricule(String matricule) {
		this.matricule = matricule;
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




	public String getLogin() {
		return login;
	}




	public void setLogin(String login) {
		this.login = login;
	}




	public String getMdp() {
		return mdp;
	}




	public void setMdp(String mdp) {
		this.mdp = mdp;
	}




	public String getAdresse() {
		return adresse;
	}




	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}




	public String getTelephone() {
		return telephone;
	}




	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}




	public Date getDate_entree() {
		return date_entree;
	}




	public void setDate_entree(Date date_entree) {
		this.date_entree = date_entree;
	}




	public int getPrime() {
		return prime;
	}




	public void setPrime(int prime) {
		this.prime = prime;
	}
	
	

}
