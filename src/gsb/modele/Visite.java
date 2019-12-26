package gsb.modele;

import java.util.Date;
import java.text.SimpleDateFormat;


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
	

	public static String convertirDate(String dateVisite) { // fct qui permet de supprimer une Visite avec l'aide de
		// la référence

		SimpleDateFormat date_entree = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); // date entrée par l'utilisateur
		// pour simplifier la compréhension
		SimpleDateFormat date_sql = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // date convertie pour respecter le
		// format de la base de données
		System.out.println("Date en entrée : " + dateVisite);
		
					// 12/12/2012 12:12:12 ======> 2005-08-15 12:12:03
		try {
			Date date = date_entree.parse(dateVisite);
			dateVisite = date_sql.format(date);
			System.out.println("Date en sortie : " + date_sql.format(date));
		} catch (Exception e) { // si la convertion ne marche pas
			System.out.println("Error while parsing date");
			e.printStackTrace();
		}
		return dateVisite;

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
