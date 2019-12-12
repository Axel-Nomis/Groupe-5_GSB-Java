package gsb.service;

import gsb.modele.Visiteur;
import gsb.modele.dao.VisiteurDao;

	/**
	 * 
	 * @author Marull
	 *
	 */

public class VisiteurService {
	
	/**
	 * 
	 * @param unMatricule
	 * @return
	 */

	public static Visiteur rechercherVisite(String unMatricule) { // cette fct gère les erreurs, quand on recherche un Visiteur par le matricule
		Visiteur unVisiteur = null;
		try {
			if (unMatricule == null) {	// quand le matricule est null on affiche un message
				throw new Exception("Donnée obligatoire : matricule");
			}
			unVisiteur = VisiteurDao.rechercher(unMatricule);// sinon si elle est existe on execute la fct rechercher de la classe VisiteurDao
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return unVisiteur;
	}

}
