package gsb.modele;

import java.sql.Date;

public class Visite {
	
	protected String reference;
	protected String dateVisite;
	protected String commentaire;
	protected String matricule;
	protected String code;
	
	
	
	public Visite(String reference, String dateVisite, String commentaire,String matricule, String code) {
		this.reference = reference;
		this.dateVisite = dateVisite;
		this.commentaire = commentaire;
		this.matricule = matricule;
		this.code = code;
	}



	public String getReference() {
		return reference;
	}



	public void setReference(String reference) {
		this.reference = reference;
	}



	public String getDateVisite() {
		return dateVisite;
	}



	public void setDateVisite(String dateVisite) {
		this.dateVisite = dateVisite;
	}



	public String getCommentaire() {
		return commentaire;
	}



	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	


	public String getMatricule() {
		return matricule;
	}



	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}



	public String getCode() {
		return code;
	}



	public void setCode(String code) {
		this.code = code;
	}
	
	
	


}
