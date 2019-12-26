package gsb.modele.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 * @author Marull
 */

import gsb.modele.Visite;

public class VisiteDao {

	/**
	 * 
	 * @param reference
	 * @return
	 */

	public static Visite rechercher(String reference) { // fct qui recherche une Visite avec la reference

		Visite uneVisite = null;

		ResultSet reqSelection = ConnexionMySql
				.execReqSelection("SELECT * from VISITE where Reference ='" + reference + "'");
		// requete sql pour rechercher une Visite
		try {
			if (reqSelection.next()) {
				uneVisite = new Visite(reqSelection.getString(1), reqSelection.getString(2), reqSelection.getString(3),
						reqSelection.getString(4), reqSelection.getString(5));
				// création de l'objet uneVisite qui va récupérer les données d'une Visite
			}
			;
		} catch (Exception e) {
			System.out.println("erreur reqSelection.next() pour la requête - SELECT * from VISITE where Reference ='"
					+ reference + "'");
			e.printStackTrace();
			// message d'erreur en cas d'échec de la requête
		}
		ConnexionMySql.fermerConnexionBd();
		return uneVisite; // on retourne l'objet uneVisite
	}

	/**
	 * 
	 * @param reference
	 */

	public static void supprimer(String reference) {

		try {
			String reqDelete = "DELETE from VISITE where Reference ='" + reference + "'";
			// requete sql pour supprimer une Visite
			ConnexionMySql.execReqDel(reqDelete);
			System.out.println("La Visite à bien été supprimée !");
			// message pour informer la bonne execution de la requete

		} catch (Exception e) {
			System.out.println(
					"erreur reqDelete pour la requête - DELETE from VISITE where Reference ='" + reference + "'");
			e.printStackTrace();
			// message d'erreur en cas d'échec de la réquête
		}
		ConnexionMySql.fermerConnexionBd();
	}

	/**
	 * 
	 * @param reference
	 * @param dateVisite
	 * @param commentaire
	 * @param matriculeVisit
	 * @param codeMed
	 */

	public static void ajouter(String reference, String dateVisite, String commentaire, String matriculeVisit,
			String codeMed) {

		
		String dateparse = Visite.convertirDate(dateVisite);
		// on converti la date avec la fonction convertirDate qui va convertir la date sous le format de la base de donnée

		try {
			String reqInsertion = "INSERT into VISITE values('" + reference + "','" + dateparse + "','" + commentaire
					+ "','" + matriculeVisit + "','" + codeMed + "')";
			// requête sql qui permet d'ajouter une Visite dans la base (les données entrées par l'utilisateur)
			ConnexionMySql.execReqMaj(reqInsertion);
			System.out.println("Votre Visite à bien été prise en compte !");
			// message en cas de réussite

		} catch (Exception e) {
			System.out.println("erreur reqInsertion pour la requête - INSERT into VISITE values('" + reference + "','"
					+ dateVisite + "','" + commentaire + "','" + matriculeVisit + "','" + codeMed + "'");
			e.printStackTrace();
			// message en cas d'échec de la requête
		}
		ConnexionMySql.fermerConnexionBd();
	}

	/**
	 * 
	 * @return
	 */

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

	/**
	 * 
	 * @return
	 */

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
	
	public static ArrayList<Visite> retournerCollectionDesVisitesRefDate(String matricule, String date) {
		
		String dateparse = Visite.convertirDate(date);
		ArrayList<Visite> collectionDesVisites = new ArrayList<Visite>();
		ResultSet reqSelection = ConnexionMySql.execReqSelection("select REFERENCE from VISITE WHERE MATRICULE = '" + matricule + "' AND DATEVISITE = '" + dateparse + "'");
		try {
			while (reqSelection.next()) {
				String matricule2 = reqSelection.getString(1);
				collectionDesVisites.add(VisiteDao.rechercher(matricule2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return collectionDesVisites;
	}
	
	
	
	

}
