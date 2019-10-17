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
		unMedicament = new Medicament("3MYC7", "TRIMYCINE", "Triamcinolone (ac�tonide) + N�omycine + Nystatine",
				"Ce m�dicament est un cortico�de � activit� forte ou tr�s forte associ� �  un antibiotique et un antifongique, utilis� en application locale dans certaines atteintes cutan�es surinfect�es.",
				"Ce m�dicament est contre-indiqu� en cas d'allergie �  l'un des constituants, d'infections de la peau ou de parasitisme non trait�s, d'acn�. Ne pas appliquer sur une plaie, ni sous un pansement occlusif.",
				null, "CRT", "Cortico�de, antibiotique et antifongique � usage local");
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
		assertNotNull("M�dicament trouv� ! ", MedicamentDao.rechercherMed(depotLegalOK));
	}

	/**
	 * Test method for
	 * {@link gsb.modele.dao.MedicamentDao#rechercherMed(java.lang.String)}.
	 */
	@Test
	void testRechercherMedFail() {
		System.out.println("----------------------------TEST RECHERCHER MEDICAMENT----------------------------");
		String depotLegalKO = "3MYC";
		assertNull("M�dicament non trouv� ! ", MedicamentDao.rechercherMed(depotLegalKO));
	}

	/**
	 * Test method for
	 * {@link gsb.modele.dao.MedicamentDao#retournerCollectionDesMedicaments()}.
	 */
	@Test
	void testRetournerCollectionDesMedicamentsOK() {
		System.out.println("----------------------------TEST RETOURNER COL MEDICAMENT----------------------------");
		assertNotNull("Collection des m�dicaments trouv�e ! ", MedicamentDao.retournerCollectionDesMedicaments());
	}

	/**
	 * Test method for
	 * {@link gsb.modele.dao.MedicamentDao#retournerDictionnaireDesMedicaments()}.
	 */
	@Test
	void testRetournerDictionnaireDesMedicamentsOK() {
		System.out.println("----------------------------TEST RETOURNER DICO MEDICAMENT----------------------------");
		assertNotNull("Collection des m�dicaments trouv�e ! ", MedicamentDao.retournerDictionnaireDesMedicaments());
	}

}
