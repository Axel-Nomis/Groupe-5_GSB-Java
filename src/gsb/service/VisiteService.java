package gsb.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import gsb.modele.Visite;
import gsb.modele.dao.ConnexionMySql;
import gsb.modele.dao.MedecinDao;
import gsb.modele.dao.VisiteDao;
import gsb.modele.dao.VisiteurDao;

/**
 * @author Isabelle 23 févr. 2015 TODO Pour changer le modèle de ce commentaire
 *         de type généré, allez à : Fenêtre - Préférences - Java - Style de
 *         code - Modèles de code
 */
public class VisiteService {

	public static Visite rechercherVisite(String uneReference) {

		Visite uneVisite = null;
		try {
			if (uneReference == null) {
				throw new Exception("Donnée obligatoire : référence");
				//System.out.println("Donnée obligatoire : référence");
				}
				
			if(!VisiteDao.retournerDictionnaireDesVisites().containsKey(uneReference)) {

				throw new Exception("La visite est inexistante.");
				//System.out.println("La visite est inexistante.");
				//res = 2;
			}			
			
		uneVisite = VisiteDao.rechercher(uneReference);			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(uneVisite);
		}
		return uneVisite;
	}

	
	
	
	public static int ajoutVisite(String reference, String dateVisite, String commentaire, String matriculeVisit,
			String codeMed) {
		
		
		/*try {
			if (reference == null) {
				throw new Exception("Donnée obligatoire : référence");
			} 
			else if (dateVisite == null) {
				throw new Exception("La date de la Visite doit être référencée");
			} 
			else if (matriculeVisit == null) {
				throw new Exception("Le matricule du Visiteur doit être référencé");
			}
			else if (codeMed == null) {
				throw new Exception("Le code du Médecin doit être référencé");
			}

			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}*/
		
		
		int res = 1;
		
		
		if(reference.length() == 0 || dateVisite.length() == 0 || matriculeVisit.length() == 0 || codeMed.length() == 0) {
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

		}else {
			res = 1;
		}
		
	}
		return res;
	}
	
	
	
	public static void supprimerVisite(String uneReference) {
		


		try {
			if (uneReference == null) {
				throw new Exception("Donnée obligatoire : référence");
			}
			else if (!VisiteDao.retournerDictionnaireDesVisites().containsKey(uneReference)) {

			System.out.println("La visite est inexistante.");
		}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	

}
