package gsb.tests;

import gsb.modele.Visite;
import gsb.modele.dao.MedecinDao;
import gsb.modele.dao.VisiteurDao;
import gsb.service.VisiteService;

public class VisiteTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Visite uneVisite = VisiteService.rechercherVisite("v0001");
		System.out.println(uneVisite.getReference());
		System.out.println(uneVisite.getDateVisite());
		System.out.println(uneVisite.getCommentaire());
		
		System.out.println(VisiteurDao.rechercher(uneVisite.getMatriculeVisit()).getNom());
		System.out.println(MedecinDao.rechercher(uneVisite.getCodeMed()).getLaLocalite().getVille());
		System.out.println(uneVisite.getCodeMed());

	}

}
