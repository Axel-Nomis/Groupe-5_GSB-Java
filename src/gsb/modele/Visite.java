package gsb.modele;

import java.sql.Date;

public class Visite {
	
	protected String reference;
	protected Date dateVisite;
	protected String commentaire;
	protected Visiteur unVisiteur;
	protected Medecin unMedecin;
	
	
	
	public Visite(String reference, Date dateVisite, String commentaire,Visiteur unVisiteur, Medecin unMedecin) {
		this.reference = reference;
		this.dateVisite = dateVisite;
		this.commentaire = commentaire;
		this.unVisiteur = unVisiteur;
		this.unMedecin = unMedecin;
	}



	public String getReference() {
		return reference;
	}



	public void setReference(String reference) {
		this.reference = reference;
	}



	public Date getDateVisite() {
		return dateVisite;
	}



	public void setDateVisite(Date dateVisite) {
		this.dateVisite = dateVisite;
	}



	public String getCommentaire() {
		return commentaire;
	}



	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}



	public Visiteur getVisiteur() {
		return unVisiteur;
	}



	public void setVisiteur(Visiteur unVisiteur) {
		this.unVisiteur = unVisiteur;
	}



	public Medecin getMedecin() {
		return unMedecin;
	}



	public void setMedecin(Medecin unMedecin) {
		this.unMedecin = unMedecin;
	}
	
	
	


}
