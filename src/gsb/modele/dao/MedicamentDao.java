package gsb.modele.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import gsb.modele.Medicament;

public class MedicamentDao {
	public static Medicament rechercherMed(String depotLegal){
		Medicament unMedicament=null;
		ResultSet reqSelection = ConnexionMySql.execReqSelection("select * from MEDICAMENT where MED_DEPOTLEGAL ='"+depotLegal+"'");
		try {
			if (reqSelection.next()) {
				unMedicament = new Medicament(reqSelection.getString(1), reqSelection.getString(2), reqSelection.getString(3), reqSelection.getString(4), reqSelection.getString(5), reqSelection.getFloat(6), reqSelection.getString(7), reqSelection.getString(8) );	
			};
			}
		catch(Exception e) {
			System.out.println("erreur reqSelection.next() pour la requête - select * from MEDECIN where CODEMED ='"+depotLegal+"'");
			e.printStackTrace();
			}
		ConnexionMySql.fermerConnexionBd();
		return unMedicament;
	}
	
	public static ArrayList<Medicament> retournerCollectionDesMedecins(){
		ArrayList<Medicament> collectionDesMedicaments = new ArrayList<Medicament>();
		ResultSet reqSelection = ConnexionMySql.execReqSelection("select MED_DEPOTLEGAL from MEDICAMENT");
		try{
		while (reqSelection.next()) {
			String depotLegal = reqSelection.getString(1);
			collectionDesMedicaments.add(MedicamentDao.rechercherMed(depotLegal));
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("erreur retournerCollectionDesMedicaments()");
		}
		return collectionDesMedicaments;
	}
	
	public static HashMap<String,Medicament> retournerDictionnaireDesMedicaments(){
		HashMap<String, Medicament> diccoDesMedicaments = new HashMap<String, Medicament>();
		ResultSet reqSelection = ConnexionMySql.execReqSelection("select MED_DEPOTLEGAL from MEDICAMENT");
		try{
		while (reqSelection.next()) {
			String depotLegal = reqSelection.getString(1);
			diccoDesMedicaments.put(depotLegal, MedicamentDao.rechercherMed(depotLegal));
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("erreur retournerDiccoDesMedicaments()");
		}
		return diccoDesMedicaments;
	}

}
