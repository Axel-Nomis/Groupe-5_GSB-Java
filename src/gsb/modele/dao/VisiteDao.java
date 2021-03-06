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
				.execReqSelection("SELECT * from C##GSBJAVAPROC.VISITE where Reference ='" + reference + "'");
		// requete sql pour rechercher une Visite
		try {
			if (reqSelection.next()) {
				uneVisite = new Visite(reqSelection.getString(1), reqSelection.getString(2), reqSelection.getString(3),
						reqSelection.getString(4), reqSelection.getString(5));
				// cr�ation de l'objet uneVisite qui va r�cup�rer les donn�es d'une Visite
			}
			;
		} catch (Exception e) {
			System.out.println("erreur reqSelection.next() pour la requ�te - SELECT * from VISITE where Reference ='"
					+ reference + "'");
			e.printStackTrace();
			// message d'erreur en cas d'�chec de la requ�te
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
			String reqDelete = "DELETE from C##GSBJAVAPROC.VISITE where Reference ='" + reference + "'";
			// requete sql pour supprimer une Visite
			ConnexionMySql.execReqDel(reqDelete);
			System.out.println("La Visite � bien �t� supprim�e !");
			// message pour informer la bonne execution de la requete

		} catch (Exception e) {
			System.out.println(
					"erreur reqDelete pour la requ�te - DELETE from VISITE where Reference ='" + reference + "'");
			e.printStackTrace();
			// message d'erreur en cas d'�chec de la r�qu�te
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
		// on converti la date avec la fonction convertirDate qui va convertir la date sous le format de la base de donn�e

		try {
			String reqInsertion = "INSERT into C##GSBJAVAPROC.VISITE values('" + reference + "','" + dateparse + "','" + commentaire
					+ "','" + matriculeVisit + "','" + codeMed + "')";
			// requ�te sql qui permet d'ajouter une Visite dans la base (les donn�es entr�es par l'utilisateur)
			ConnexionMySql.execReqMaj(reqInsertion);
			System.out.println("Votre Visite � bien �t� prise en compte !");
			// message en cas de r�ussite

		} catch (Exception e) {
			System.out.println("erreur reqInsertion pour la requ�te - INSERT into C##GSBJAVAPROC.VISITE values('" + reference + "','"
					+ dateVisite + "','" + commentaire + "','" + matriculeVisit + "','" + codeMed + "'");
			e.printStackTrace();
			// message en cas d'�chec de la requ�te
		}
		ConnexionMySql.fermerConnexionBd();
	}

	/**
	 * 
	 * @return
	 */

	public static ArrayList<Visite> retournerCollectionDesVisites() {
		ArrayList<Visite> collectionDesVisites = new ArrayList<Visite>();
		ResultSet reqSelection = ConnexionMySql.execReqSelection("select REFERENCE from C##GSBJAVAPROC.VISITE");
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
		ResultSet reqSelection = ConnexionMySql.execReqSelection("select REFERENCE from C##GSBJAVAPROC.VISITE");
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
		ResultSet reqSelection = ConnexionMySql.execReqSelection("select REFERENCE from C##GSBJAVAPROC.VISITE WHERE MATRICULE = '" + matricule + "' AND DATEVISITE = '" + dateparse + "'");
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
