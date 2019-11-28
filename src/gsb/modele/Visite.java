package gsb.modele;

import java.sql.Date;

public class Visite {

	protected String reference;
	protected String dateVisite;
	protected String commentaire;
	protected String matriculeVisit;
	protected String codeMed;

	public Visite(String reference, String dateVisite, String commentaire, String matriculeVisit, String codeMed) {
		this.reference = reference;
		this.dateVisite = dateVisite;
		this.commentaire = commentaire;
		this.matriculeVisit = matriculeVisit;
		this.codeMed = codeMed;
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

	public String getMatriculeVisit() {
		return matriculeVisit;
	}

	public void setMatriculeVisit(String matriculeVisit) {
		this.matriculeVisit = matriculeVisit;
	}

	public String getCodeMed() {
		return codeMed;
	}

	public void setCodeMed(String codeMed) {
		this.codeMed = codeMed;
	}

}
