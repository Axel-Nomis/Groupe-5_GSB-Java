package gsb.modele.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import gsb.modele.Localite;
import gsb.modele.Medecin;
import gsb.modele.Visite;
import gsb.modele.Visiteur;

public class VisiteurDao {

	public static Visiteur rechercher(String matricule) {
		Visiteur unVisiteur = null;
		Localite uneLocalite = null;
		ResultSet reqSelection = ConnexionMySql
				.execReqSelection("SELECT * from VISITEUR where Matricule ='" + matricule + "'");
		try {
			if (reqSelection.next()) {
				uneLocalite = LocaliteDao.rechercher(reqSelection.getString(5));
				unVisiteur = new Visiteur(reqSelection.getString(1), reqSelection.getString(2),
						reqSelection.getString(3), reqSelection.getString(4), reqSelection.getString(6),
						reqSelection.getString(7), reqSelection.getString(8), reqSelection.getString(9));
			}
			;
		} catch (Exception e) {
			System.out.println("erreur reqSelection.next() pour la requête - SELECT * from VISITEUR where Matricule ='"
					+ matricule + "'");
			e.printStackTrace();
		}
		ConnexionMySql.fermerConnexionBd();
		return unVisiteur;
	}

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
