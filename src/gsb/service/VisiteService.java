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
				throw new Exception("Donn�e obligatoire : reference");
			}
			uneVisite = VisiteDao.rechercher(uneReference);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return uneVisite;
	}

}
