package gsb.modele.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import gsb.modele.Podium;
import gsb.modele.Visiteur;

public class PodiumDao {
	
	

	public static Podium rechercher(String matricule) {
		Podium unPodium = null;
		ResultSet reqSelection = ConnexionMySql
				.execReqSelection("SELECT * from C##GSBJAVAPROC.PODIUM where VIS_MATRICULE ='" + matricule + "'");
		// requete sql pour rechercher une Visite
		try {
			if (reqSelection.next()) {
				unPodium = new Podium(reqSelection.getString(1), reqSelection.getString(2),
						reqSelection.getString(3), reqSelection.getString(4), reqSelection.getString(5));
				// création de l'objet unVisiteur qui va récupérer les données d'un Visiteur
			}
			;
		} catch (Exception e) {
			System.out.println("erreur reqSelection.next() pour la requête - SELECT * from C##GSBJAVAPROC.PODIUM where Matricule ='"
					+ matricule + "'");
			e.printStackTrace();
			// message d'erreur en cas d'échec de la requête
		}
		ConnexionMySql.fermerConnexionBd();
		return unPodium; // on retourne l'objet unVisiteur
	}
	
		
	public static ArrayList<Podium> retournerCollectionPodium() {
		ArrayList<Podium> collectionUnPodium = new ArrayList<Podium>();
		ResultSet reqSelection = ConnexionMySql.execReqSelection("SELECT VIS_MATRICULE from C##GSBJAVAPROC.PODIUM");
		try {
			while (reqSelection.next()) {
				String matricule = reqSelection.getString(1);
				collectionUnPodium.add(PodiumDao.rechercher(matricule));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("erreur retournerCollectionUnPodium()");
		}
		return collectionUnPodium;
	}

}
