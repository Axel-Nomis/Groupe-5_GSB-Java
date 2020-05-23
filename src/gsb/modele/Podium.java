package gsb.modele;

/**
 * 
 * @author Marull
 *
 */

public class Podium {

	protected String rang;
	protected String matricule;
	protected String nom;
	protected String prenom;
	protected String nbVisite;

	/**
	 * 
	 * @param matricule
	 * @param nom
	 * @param prenom
	 * @param login
	 * @param mdp
	 * @param adresse
	 * @param code_postale
	 * @param date_entree
	 * @param code_unit
	 * @param nom_unit
	 */

	public Podium(String rang, String matricule, String nom, String prenom, String nbVisite) {
		this.rang = rang;
		this.matricule = matricule;
		this.nom = nom;
		this.prenom = prenom;
		this.nbVisite = nbVisite;
	}
	
	

	public String getRang() {
		return rang;
	}



	public void setRang(String rang) {
		this.rang = rang;
	}



	public String getNbVisite() {
		return nbVisite;
	}



	public void setNbVisite(String nbVisite) {
		this.nbVisite = nbVisite;
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

}