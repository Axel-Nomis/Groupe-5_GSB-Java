package gsb.tests;

import java.util.HashMap;

import gsb.modele.Medicament;
import gsb.modele.dao.*;

public class MedicamentDaoTest {
	public static void main(String[] args) {

		HashMap<String, Medicament> unDicco = new HashMap<String, Medicament>();
		unDicco = MedicamentDao.retournerDictionnaireDesMedicaments();
		if (unDicco.containsKey("3MYC7")) {
			System.out.println(unDicco.get("3MYC7").getMedNomCommercial());
		}
	}
}
