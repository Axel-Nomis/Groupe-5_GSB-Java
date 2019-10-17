/**
 * 
 */
package gsb.tests.unit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import gsb.modele.Medicament;
import gsb.modele.dao.MedicamentDao;
import junit.framework.TestCase;

/**
 * @author Axel
 *
 */
public class MedicamentDaoTest extends TestCase {
	private Medicament unMedicament;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	protected void setUp() throws Exception {
		unMedicament = new Medicament("3MYC7", "TRIMYCINE", "Triamcinolone (acétonide) + Néomycine + Nystatine",
				"Ce médicament est un corticoïde à activité forte ou très forte associé à  un antibiotique et un antifongique, utilisé en application locale dans certaines atteintes cutanées surinfectées.",
				"Ce médicament est contre-indiqué en cas d'allergie à  l'un des constituants, d'infections de la peau ou de parasitisme non traités, d'acné. Ne pas appliquer sur une plaie, ni sous un pansement occlusif.",
				null, "CRT", "Corticoïde, antibiotique et antifongique à usage local");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	protected void tearDown() throws Exception {
		System.out.println("----------------------------FIN DE TEST----------------------------");
	}

	/**
	 * Test method for
	 * {@link gsb.modele.dao.MedicamentDao#rechercherMed(java.lang.String)}.
	 */
	@Test
	void testRechercherMedOK() {
		System.out.println("----------------------------TEST RECHERCHER MEDICAMENT----------------------------");
		String depotLegalOK = "3MYC7";
		assertNotNull("Médicament trouvé ! ", MedicamentDao.rechercherMed(depotLegalOK));
	}

	/**
	 * Test method for
	 * {@link gsb.modele.dao.MedicamentDao#rechercherMed(java.lang.String)}.
	 */
	@Test
	void testRechercherMedFail() {
		System.out.println("----------------------------TEST RECHERCHER MEDICAMENT----------------------------");
		String depotLegalKO = "3MYC";
		assertNull("Médicament non trouvé ! ", MedicamentDao.rechercherMed(depotLegalKO));
	}

	/**
	 * Test method for
	 * {@link gsb.modele.dao.MedicamentDao#retournerCollectionDesMedicaments()}.
	 */
	@Test
	void testRetournerCollectionDesMedicamentsOK() {
		System.out.println("----------------------------TEST RETOURNER COL MEDICAMENT----------------------------");
		assertNotNull("Collection des médicaments trouvée ! ", MedicamentDao.retournerCollectionDesMedicaments());
	}

	/**
	 * Test method for
	 * {@link gsb.modele.dao.MedicamentDao#retournerDictionnaireDesMedicaments()}.
	 */
	@Test
	void testRetournerDictionnaireDesMedicamentsOK() {
		System.out.println("----------------------------TEST RETOURNER DICO MEDICAMENT----------------------------");
		assertNotNull("Collection des médicaments trouvée ! ", MedicamentDao.retournerDictionnaireDesMedicaments());
	}

}
