package gsb.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import gsb.modele.Visite;
import gsb.modele.dao.ConnexionMySql;
import gsb.modele.dao.MedecinDao;
import gsb.modele.dao.VisiteDao;
import gsb.modele.dao.VisiteurDao;

/**
 * @author Isabelle 23 f�vr. 2015 TODO Pour changer le mod�le de ce commentaire
 *         de type g�n�r�, allez � : Fen�tre - Pr�f�rences - Java - Style de
 *         code - Mod�les de code
 */
public class VisiteService {

	public static Visite rechercherVisite(String uneReference) {

		Visite uneVisite = null;
		try {
			if (uneReference == null) {
				throw new Exception("Donn�e obligatoire : r�f�rence");
				//System.out.println("Donn�e obligatoire : r�f�rence");
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
				throw new Exception("Donn�e obligatoire : r�f�rence");
			} 
			else if (dateVisite == null) {
				throw new Exception("La date de la Visite doit �tre r�f�renc�e");
			} 
			else if (matriculeVisit == null) {
				throw new Exception("Le matricule du Visiteur doit �tre r�f�renc�");
			}
			else if (codeMed == null) {
				throw new Exception("Le code du M�decin doit �tre r�f�renc�");
			}

			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}*/
		
		
		int res = 1;
		
		
		if(reference.length() == 0 || dateVisite.length() == 0 || matriculeVisit.length() == 0 || codeMed.length() == 0) {
				System.out.println("Vous avez oubli� de r�f�rencer un champs obligatoire");
				res = -1;
		}
		
		else if(VisiteDao.retournerDictionnaireDesVisites().containsKey(reference)){
			
			System.out.println("Cette Visite existe d�ja !");
			res = 0;			
		}else {
		
		
		if(reference.length() != 5){
			System.out.println("La r�f�rence doit �tre de 5 caract�res (ex: v1111) 1 lettre, suivi de 4 chiffres");
			res = 2;
		}else{
			if(reference.charAt(0) != 'v'){
					//Character.isLetter(reference.charAt(0)
					System.out.println("Le premier caract�re n'est pas la lettre v, elle doit �tre inscrite pour faire r�f�rence � la Visite.");
					res = 3;
				}
			else {
				for (int i=1; i<reference.length(); i++) {
					if (reference.charAt(i) < '0' || reference.charAt(i) > '9') {
						System.out.println("Le caract�re " + i + " : [ " +  reference.charAt(i) + " ] n'est pas un chiffre !");
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

			System.out.println("Le code du M�decin n'existe pas dans la base");
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
				throw new Exception("Donn�e obligatoire : r�f�rence");
			}
			else if (!VisiteDao.retournerDictionnaireDesVisites().containsKey(uneReference)) {

			System.out.println("La visite est inexistante.");
		}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	

}
