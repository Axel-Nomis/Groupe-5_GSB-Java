package gsb.tests.unit;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import gsb.modele.Visite;
import gsb.modele.dao.*;
import junit.framework.TestCase;

public class VisiteDaoTest extends TestCase {

	private Visite uneVisite;

	@Before

	public void setUp() throws Exception {

		// uneVisite = new Visite("v0030", "2019-14-11", "VisiteTEST U N I T A I R E",
		// "d13", "m010");
		// unVisiteur = new Visiteur("");
		uneVisite = new Visite("v0031", "11/15/2019 00:00:00", "Visite2 --- |||   TEST U N I T A I R E", "d13", "m010");

	}

	@After

	public void tearDown() throws Exception {

		System.out.println("--------------------------- fin test --------------------------------");

	}

	@Test

	public final void testVisite() {

		System.out.println("--------------------------- testVisite --------------------------------");

		assertNotNull("Visite bien instanciée", uneVisite);

	}

	@Test

	public final void testRechercherVisite() {

		System.out.println("--------------------------- testRechercherVisite --------------------------------");
		
		assertEquals("Est ce que l'index est -1", 1, VisiteDao.rechercher("v0031"));

	}

	@Test

	public final void testAjouterVisite() {

		System.out.println("--------------------------- testAjouterVisite --------------------------------");

		VisiteDao.ajouter("v0031", "11/15/2019 00:00:00", "Visite2 --- |||   TEST U N I T A I R E", "d13", "m010");
		// uneVisite.ajouter(uneVisite2);

		assertEquals("Nombre de taches :", 1, uneVisite.getClass());

	}

}
