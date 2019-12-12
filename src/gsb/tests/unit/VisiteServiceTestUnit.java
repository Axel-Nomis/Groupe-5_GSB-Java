package gsb.tests.unit;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import gsb.modele.Visite;
import gsb.modele.dao.*;
import gsb.service.VisiteService;
import junit.framework.TestCase;

/**
 * @author Marull
 *
 */

public class VisiteServiceTestUnit extends TestCase {

	private VisiteService uneVisiteService;

	/**
	 *
	 */
	@Before

	protected void setUp() throws Exception {
		super.setUp();

	}

	@After

	public void tearDown() throws Exception {

		System.out.println("--------------------------- fin test --------------------------------");

	}

	/**
	 * 
	 * Test method VisiteService#ajouterVisite
	 * 
	 */

	@Test

	public final void testAjouterVisite() {

		assertEquals("Un ou plusieurs champs null sauf commentaire : ", -1,
				VisiteService.ajoutVisite("", "02/06/2018 00:00:00", "commentaire", "b13", "m009"));

		assertEquals("La Visite existe déja : ", 0,
				VisiteService.ajoutVisite("v0023", "02/06/2018 00:00:00", "", "b13", "m009"));

		// assertEquals("La Visite à bien été prise en compte : ", 1,
		// VisiteService.ajoutVisite("v0030", "02/06/2018 00:00:00", "", "b13",
		// "m009"));

		assertEquals("La référence doit être de 5 caractères : ", 2,
				VisiteService.ajoutVisite("v00246", "02/06/2018 00:00:00", "", "b13", "m009"));

		assertEquals("La référence doit commencer par la lettre v : ", 3,
				VisiteService.ajoutVisite("w0024", "02/06/2018 00:00:00", "", "b13", "m009"));

		assertEquals("La référence doit comporter 4 chiffres sur les derniers caractères : ", 4,
				VisiteService.ajoutVisite("vxxxx", "02/06/2018 00:00:00", "", "b13", "m009"));

		assertEquals("Resultat insertion : ", 5,
				VisiteService.ajoutVisite("v0024", "2018-fr-12 00:00:00", "", "b13", "m009"));

		assertEquals("Resultat insertion : ", 6,
				VisiteService.ajoutVisite("v0024", "2018-06-02 00:00:00", "", "b13", "m009"));

		assertEquals("Matricule de Visiteur inexistant dans la base : ", 7,
				VisiteService.ajoutVisite("v0024", "02/06/2018 00:00:00", "", "z99", "m009"));

		assertEquals("Code de médecin inexistant dans la base : ", 1,
				VisiteService.ajoutVisite("v0024", "02/06/2018 00:00:00", "", "b13", "z999"));

	}

	/**
	 * 
	 * Test method VisiteService#rechercherVisite
	 * 
	 */

	@Test

	public final void testRechercherVisite() {

		assertEquals("Une visite null ", null,
				VisiteService.rechercherVisite(null));

		assertEquals("La visite inexistante : ", null,
				VisiteService.rechercherVisite("v0099"));

		assertEquals("Une visite qui n'est pas correctement entrées : ", null,
				VisiteService.rechercherVisite("v1"));

	}

}
