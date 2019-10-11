package gsb.service;

import gsb.modele.Visiteur;
import gsb.modele.dao.VisiteurDao;

/**
 * @author Isabelle
 * 23 févr. 2015
 * TODO Pour changer le modèle de ce commentaire de type généré, allez à :
 * Fenêtre - Préférences - Java - Style de code - Modèles de code
 */
public class VisiteurService {
	
	public static Visiteur rechercherVisite(String unMatricule){
		Visiteur unVisiteur = null;
		try{
		if (unMatricule==null) {
            throw new Exception("Donnée obligatoire : matricule");
        }
		unVisiteur = VisiteurDao.rechercher(unMatricule);
		}
		catch(Exception e){
			System.out.println( e.getMessage());
		}
		return unVisiteur;
	}
	
}
