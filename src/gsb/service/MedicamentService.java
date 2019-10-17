package gsb.service;

import gsb.modele.Medicament;
import gsb.modele.dao.MedicamentDao;

public class MedicamentService {

	public static Medicament rechercherMed(String depotLegal) {
		Medicament unMedicament = null;
		try {
			if (depotLegal == null) {
				throw new Exception("Donn�e obligatoire : d�p�t l�gal");
			}
			unMedicament = MedicamentDao.rechercherMed(depotLegal);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return unMedicament;
	}

}
