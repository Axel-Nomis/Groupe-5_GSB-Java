package gsb.modele.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import gsb.modele.Visite;

public class VisiteDao {

	public static Visite rechercher(String reference) {

		Visite uneVisite = null;

		ResultSet reqSelection = ConnexionMySql.execReqSelection("SELECT * from VISITE where Reference ='" + reference + "'");
		try {
			if (reqSelection.next()) {
				uneVisite = new Visite(reqSelection.getString(1), reqSelection.getString(2), reqSelection.getString(3),
						reqSelection.getString(4), reqSelection.getString(5));
			}
			;
		} catch (Exception e) {
			System.out.println("erreur reqSelection.next() pour la requête - SELECT * from VISITE where Reference ='"
					+ reference + "'");
			e.printStackTrace();
		}
		ConnexionMySql.fermerConnexionBd();
		return uneVisite;
	}
	
	
	
	
	public static void supprimer(String reference) {

		
		try {
			String reqDelete = "DELETE from VISITE where Reference ='" + reference + "'";
			ConnexionMySql.execReqDel(reqDelete);
			System.out.println("La Visite à bien été supprimée !");
			
		} catch (Exception e) {
			System.out.println("erreur reqDelete pour la requête - DELETE from VISITE where Reference ='"
					+ reference + "'");
			e.printStackTrace();
		}
		ConnexionMySql.fermerConnexionBd();
	}
	
	
	

	public static void ajouter(String reference, String dateVisite, String commentaire, String matriculeVisit,
			String codeMed) {
		
		SimpleDateFormat date_entree = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss" ); /* tu lui passe le pattern, cf la javadoc pour la signification des lettres */
		SimpleDateFormat date_sql = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss" );
		System.out.println("Date en entrée : " + dateVisite);
			//String textDate = "15/08/2005 12:12:03";
				try {
					   Date date = date_entree.parse(dateVisite);
					   dateVisite = date_sql.format(date);
					   System.out.println("Date en sortie : " + date_sql.format(date));
				} catch (Exception e) {
					   System.out.println("Error while parsing date" );
					   e.printStackTrace();
					}
			
		try {
			String reqInsertion = "INSERT into VISITE values('" + reference + "','" + dateVisite + "','"
					+ commentaire + "','" + matriculeVisit + "','" + codeMed + "')";
			//System.out.println(requeteInsertion);
			ConnexionMySql.execReqMaj(reqInsertion);
			System.out.println("Votre Visite à bien été prise en compte !");
			
		} catch (Exception e) {
			System.out.println("erreur reqInsertion pour la requête - INSERT into VISITE values('" + reference +
					"','" + dateVisite + "','" + commentaire + "','" + matriculeVisit + "','" + codeMed +"'");
			e.printStackTrace();
		}
		ConnexionMySql.fermerConnexionBd();
	}
	
	

	public static ArrayList<Visite> retournerCollectionDesVisites() {
		ArrayList<Visite> collectionDesVisites = new ArrayList<Visite>();
		ResultSet reqSelection = ConnexionMySql.execReqSelection("select REFERENCE from VISITE");
		try {
			while (reqSelection.next()) {
				String reference = reqSelection.getString(1);
				collectionDesVisites.add(VisiteDao.rechercher(reference));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("erreur retournerCollectionDesVisites()");
		}
		return collectionDesVisites;
	}

	public static HashMap<String, Visite> retournerDictionnaireDesVisites() {
		HashMap<String, Visite> diccoDesVisites = new HashMap<String, Visite>();
		ResultSet reqSelection = ConnexionMySql.execReqSelection("select REFERENCE from VISITE");
		try {
			while (reqSelection.next()) {
				String reference = reqSelection.getString(1);
				diccoDesVisites.put(reference, VisiteDao.rechercher(reference));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("erreur retournerDiccoDesVisites()");
		}
		return diccoDesVisites;
	}

}
