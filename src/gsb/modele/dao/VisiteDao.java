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
	
	
	

	public static int ajouter(String reference, String dateVisite, String commentaire, String matriculeVisit,
			String codeMed) {

		int res = 1;
		
		
		if(reference.length() == 0 || dateVisite.length() == 0 || commentaire.length() == 0 || matriculeVisit.length() == 0) {
			System.out.println("Vous avez oublié de référencer un champs obligatoire");
			res = -1;
		}
		else if(VisiteDao.retournerDictionnaireDesVisites().containsKey(reference)){
			
			System.out.println("Cette Visite existe déja !");
			res = 0;			
		}else {
		
		
		if(reference.length() != 5){
			System.out.println("La référence doit être de 5 caractères (ex: v1111) 1 lettre, suivi de 4 chiffres");
			res = 2;
		}else{
			if(reference.charAt(0) != 'v'){
					//Character.isLetter(reference.charAt(0)
					System.out.println("Le premier caractère n'est pas la lettre v, elle doit être inscrite pour faire référence à la Visite.");
					res = 3;
				}
			else {
				for (int i=1; i<reference.length(); i++) {
					if (reference.charAt(i) < '0' || reference.charAt(i) > '9') {
						System.out.println("Le caractère " + i + " : [ " +  reference.charAt(i) + " ] n'est pas un chiffre !");
						res = 4;
					}
				}
			}
		}		
				
		 
		if(dateVisite.length() == 19) {
			SimpleDateFormat date_entree = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss" ); /* tu lui passe le pattern, cf la javadoc pour la signification des lettres */
			SimpleDateFormat date_sql = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss" );
			//String textDate = "15/08/2005 12:12:03";
					try {
					    Date date = date_entree.parse(dateVisite);
					    dateVisite = date_sql.format(date);
					    System.out.println(date_sql.format(date));
					} catch (Exception e) {
					    System.out.println("Error while parsing date" );
					    e.printStackTrace();
					    res = 5;
					}
		}else {
			System.out.println("Mauvais format de la date");
			res = 6;
		}
		
		
				

		// test verifier avec la cle du dico containsKey(param)
		if (!VisiteurDao.retournerDictionnaireDesVisiteurs().containsKey(matriculeVisit)) {

			System.out.println("Le matricule du Visiteur n'existe pas dans la base");
			res = 7;

		}

		else if (!MedecinDao.retournerDictionnaireDesMedecins().containsKey(codeMed)) {

			System.out.println("Le code du Médecin n'existe pas dans la base");
			res = 8;

		}
		
		
		

		if (res == 1) {
			
			
				String requeteInsertion = "INSERT into VISITE values('" + reference + "','" + dateVisite + "','"
						+ commentaire + "','" + matriculeVisit + "','" + codeMed + "')";
				//System.out.println(requeteInsertion);
				res = ConnexionMySql.execReqMaj(requeteInsertion);
				System.out.println(res);
				System.out.println("Votre Visite à bien été prise en compte !");
			ConnexionMySql.fermerConnexionBd();
		}
	}

		return res;
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
