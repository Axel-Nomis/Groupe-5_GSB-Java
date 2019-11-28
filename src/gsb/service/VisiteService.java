package gsb.service;

import gsb.modele.Visite;
import gsb.modele.dao.VisiteDao;

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
			}
			uneVisite = VisiteDao.rechercher(uneReference);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return uneVisite;
	}

	
	
	
	public Visite ajoutVisite(String reference, String dateVisite, String commentaire, String matriculeVisit,
			String codeMed) {

		Visite uneVisite = new Visite(reference, dateVisite, commentaire, matriculeVisit, codeMed);

		try {
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

			uneVisite = VisiteDao.ajouter(uneVisite);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return uneVisite;

	}

}
