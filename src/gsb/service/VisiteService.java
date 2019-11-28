package gsb.service;

import gsb.modele.Visite;
import gsb.modele.dao.VisiteDao;

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

			uneVisite = VisiteDao.ajouter(uneVisite);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return uneVisite;

	}

}
