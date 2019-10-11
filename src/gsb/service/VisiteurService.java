package gsb.service;

import gsb.modele.Visiteur;
import gsb.modele.dao.VisiteurDao;

/**
 * @author Isabelle
 * 23 f�vr. 2015
 * TODO Pour changer le mod�le de ce commentaire de type g�n�r�, allez � :
 * Fen�tre - Pr�f�rences - Java - Style de code - Mod�les de code
 */
public class VisiteurService {
	
	public static Visiteur rechercherVisite(String unMatricule){
		Visiteur unVisiteur = null;
		try{
		if (unMatricule==null) {
            throw new Exception("Donn�e obligatoire : matricule");
        }
		unVisiteur = VisiteurDao.rechercher(unMatricule);
		}
		catch(Exception e){
			System.out.println( e.getMessage());
		}
		return unVisiteur;
	}
	
}
