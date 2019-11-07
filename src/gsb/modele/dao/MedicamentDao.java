package gsb.modele.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import gsb.modele.Medicament;

public class MedicamentDao {
	public static Medicament rechercherMed(String depotLegal) {
		Medicament unMedicament = null;
		ResultSet reqSelection = ConnexionMySql
				.execReqSelection("select * from MEDICAMENT where MED_DEPOTLEGAL ='" + depotLegal + "'");
		try {
			if (reqSelection.next()) {
				unMedicament = new Medicament(reqSelection.getString(1), reqSelection.getString(2),
						reqSelection.getString(3), reqSelection.getString(4), reqSelection.getString(5),
						reqSelection.getString(6), reqSelection.getString(7), reqSelection.getString(8));
			}
			;
		} catch (Exception e) {
			System.out.println("erreur reqSelection.next() pour la requête - select * from MEDECIN where CODEMED ='"
					+ depotLegal + "'");
			e.printStackTrace();
		}
		ConnexionMySql.fermerConnexionBd();
		return unMedicament;
	}

	public static ArrayList<Medicament> retournerCollectionDesMedicaments() {
		ArrayList<Medicament> collectionDesMedicaments = new ArrayList<Medicament>();
		ResultSet reqSelection = ConnexionMySql.execReqSelection("select MED_DEPOTLEGAL from MEDICAMENT");
		try {
			while (reqSelection.next()) {
				String depotLegal = reqSelection.getString(1);
				collectionDesMedicaments.add(MedicamentDao.rechercherMed(depotLegal));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("erreur retournerCollectionDesMedicaments()");
		}
		return collectionDesMedicaments;
	}

	public static HashMap<String, Medicament> retournerDictionnaireDesMedicaments() {
		HashMap<String, Medicament> diccoDesMedicaments = new HashMap<String, Medicament>();
		ResultSet reqSelection = ConnexionMySql.execReqSelection("select MED_DEPOTLEGAL from MEDICAMENT");
		try {
			while (reqSelection.next()) {
				String depotLegal = reqSelection.getString(1);
				diccoDesMedicaments.put(depotLegal, MedicamentDao.rechercherMed(depotLegal));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("erreur retournerDiccoDesMedicaments()");
		}
		return diccoDesMedicaments;
	}

	public static int ajouterEchantillon(String uneQuantite, String matriculeVisiteur, String medDepotLegal) {
		int retour = 0;
		int quantiteEntier = 0;

		// tests à effectuer
		// tester l'existance du matricule visiteur dans la table visiteur
		if (!retournerDictionnaireDesMedicaments().containsKey(medDepotLegal)) {
			// Depot legal pas bon
			System.out.println("Ce dépôt légal n'existe pas réessayez");
			retour = -1;
		} else if (!VisiteurDao.retournerDictionnaireDesVisiteurs().containsKey(matriculeVisiteur)) {
			// Matricule Visiteur pas bon
			System.out.println("Ce matricule n'existe pas réessayez");
			retour = -2;
		} else if (uneQuantite != null) {
			// Quantité existe
			try {
				//teste une conversion en int
				quantiteEntier = Integer.parseInt(uneQuantite);
			} catch (Exception e) {
				retour = -3;
				System.out.println("erreur de conversion en entier veuillez saisir un entier");
			}
		}
		if (retour != -1 && retour != -2 && retour != -3) {
			// On peut exécuter la requête si aucune des conditions précédentes n'a été
			// bloqué
			String requeteInsertion = "insert into STOCKER values(" + quantiteEntier + ",'" + matriculeVisiteur + "','"
					+ medDepotLegal + "')";
			retour = ConnexionMySql.execReqMaj(requeteInsertion);
			if (retour == 0) {
				System.out.println("l'échantillon de ce médicament à déjà été fourni pour ce Visiteur");
			}
		}
		return retour;
	}

}
