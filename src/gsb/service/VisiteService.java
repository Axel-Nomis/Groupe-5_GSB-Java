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
				throw new Exception("Donnée obligatoire : reference");
			}
			uneVisite = VisiteDao.rechercher(uneReference);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return uneVisite;
	}

}
