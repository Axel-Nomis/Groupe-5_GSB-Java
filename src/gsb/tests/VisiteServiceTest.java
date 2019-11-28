package gsb.tests;

import java.util.Date;

import gsb.modele.Visite;
import gsb.service.VisiteService;
import gsb.modele.dao.*;

public class VisiteServiceTest {
	
	
	public static void main(String[] args) {
		Visite uneVisite = VisiteService.rechercherVisite("v0001");
		System.out.println(uneVisite.getReference());
		System.out.println(uneVisite.getDateVisite());
		System.out.println(uneVisite.getCommentaire());
		
		System.out.println(VisiteurDao.rechercher(uneVisite.getMatriculeVisit()).getNom());
		System.out.println(MedecinDao.rechercher(uneVisite.getCodeMed()).getLaLocalite().getVille());
		System.out.println(uneVisite.getCodeMed());
		
		

	}
	

}
