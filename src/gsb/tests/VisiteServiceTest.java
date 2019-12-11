package gsb.tests;

import gsb.service.VisiteService;

public class VisiteServiceTest {
	
	
	public static void main(String[] args) {
		
		
		//VisiteService.ajoutVisite("v0025", "12/12/2012 12:12:12", "VisiteDaoTest", "b13", "m009");
		
		VisiteService.rechercherVisite("v0001");
		VisiteService.rechercherVisite("v0025");
		VisiteService.rechercherVisite(null);
		VisiteService.rechercherVisite("v0025");
		
		//VisiteService.supprimerVisite("v0040");
		//VisiteService.supprimerVisite(null);
		
		

	}
	

}
