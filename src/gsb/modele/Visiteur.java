package gsb.modele;

/**
 * 
 * @author Marull
 *
 */

public class Visiteur {

	protected String matricule;
	protected String nom;
	protected String prenom;
	protected String login;
	protected String mdp;
	protected String adresse;
	protected String code_postale;
	protected String date_entree;
	protected String code_unit;
	protected String nom_unit;

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

	public Visiteur(String matricule, String nom, String prenom, String login, String mdp, String adresse,
			String code_postale, String date_entree, String code_unit, String nom_unit) {
		this.matricule = matricule;
		this.nom = nom;
		this.prenom = prenom;
		this.login = login;
		this.mdp = mdp;
		this.adresse = adresse;
		this.code_postale = code_postale;
		this.date_entree = date_entree;
		this.code_unit = code_unit;
		this.nom_unit = nom_unit;
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

	public String getCode_postale() {
		return code_postale;
	}

	public void setCode_postale(String code_postale) {
		this.code_postale = code_postale;
	}

	public String getDate_entree() {
		return date_entree;
	}

	public void setDate_entree(String date_entree) {
		this.date_entree = date_entree;
	}

	public String getCode_unit() {
		return code_unit;
	}

	public void setCode_unit(String code_unit) {
		this.code_unit = code_unit;
	}

	public String getNom_unit() {
		return nom_unit;
	}

	public void setNom_unit(String nom_unit) {
		this.nom_unit = nom_unit;
	}

}