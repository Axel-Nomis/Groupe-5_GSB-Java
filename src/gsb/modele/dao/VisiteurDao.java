package gsb.modele.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import gsb.modele.Visiteur;

public class VisiteurDao {

	/**
	 * 
	 * @param matricule
	 * @return
	 */

	public static Visiteur rechercher(String matricule) {
		Visiteur unVisiteur = null;
		ResultSet reqSelection = ConnexionMySql
				.execReqSelection("SELECT * from VISITEUR where Matricule ='" + matricule + "'");
		// requete sql pour rechercher une Visite
		try {
			if (reqSelection.next()) {
				unVisiteur = new Visiteur(reqSelection.getString(1), reqSelection.getString(2),
						reqSelection.getString(3), reqSelection.getString(4), reqSelection.getString(5),
						reqSelection.getString(6), reqSelection.getString(7), reqSelection.getString(8), reqSelection.getString(9), reqSelection.getString(10));
				// création de l'objet unVisiteur qui va récupérer les données d'un Visiteur
			}
			;
		} catch (Exception e) {
			System.out.println("erreur reqSelection.next() pour la requête - SELECT * from VISITEUR where Matricule ='"
					+ matricule + "'");
			e.printStackTrace();
			// message d'erreur en cas d'échec de la requête
		}
		ConnexionMySql.fermerConnexionBd();
		return unVisiteur; // on retourne l'objet unVisiteur
	}

	/**
	 * 
	 * @return
	 */

	public static HashMap<String, Visiteur> retournerDictionnaireDesVisiteurs() {
		HashMap<String, Visiteur> diccoDesVisiteurs = new HashMap<String, Visiteur>();
		ResultSet reqSelection = ConnexionMySql.execReqSelection("select MATRICULE from VISITEUR");
		try {
			while (reqSelection.next()) {
				String matricule = reqSelection.getString(1);
				diccoDesVisiteurs.put(matricule, VisiteurDao.rechercher(matricule));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("erreur retournerDiccoDesVisites()");
		}
		return diccoDesVisiteurs;
	}

}
