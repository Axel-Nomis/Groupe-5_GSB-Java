package gsb.tests;

import gsb.modele.Visite;
import gsb.modele.dao.MedecinDao;
import gsb.modele.dao.VisiteDao;
import gsb.modele.dao.VisiteurDao;
import gsb.service.VisiteService;

	/**
	 * 
	 * @author Marull
	 *
	 */

public class VisiteTest {

	public static void main(String[] args) {


		// on teste les fct de la classe Visite et on affiche le résultat
		System.out.println("_____________________________________________________________");
		System.out.println("");
		System.out.println("Test de la classe Visite : ");
		System.out.println("");
		
		Visite uneVisite = VisiteService.rechercherVisite("v0001");
		System.out.println(uneVisite.getReference());
		System.out.println(uneVisite.getDateVisite());
		System.out.println(uneVisite.getCommentaire());
		System.out.println(uneVisite.getCodeMed());
		System.out.println(uneVisite.getMatriculeVisit());
		
		
		System.out.println(VisiteurDao.rechercher(uneVisite.getMatriculeVisit()).getNom());
		System.out.println(MedecinDao.rechercher(uneVisite.getCodeMed()).getLaLocalite().getVille());
		
		
		// on teste les fct de la classe VisiteDao et on affiche le résultat
		System.out.println("_____________________________________________________________");
		System.out.println("");
		System.out.println("Test de la fonction VisiteDao : ");
		System.out.println("");
		
				System.out.println(VisiteDao.rechercher("v0001").getReference());
				System.out.println(VisiteDao.rechercher("v0001").getDateVisite());
				System.out.println(VisiteDao.rechercher("v0001").getCommentaire());
				System.out.println(VisiteDao.rechercher("v0001").getMatriculeVisit());
				System.out.println(VisiteDao.rechercher("v0001").getCodeMed());
				
				
				VisiteDao.ajouter("v0030", "12/12/2012 12:12:12", "VisiteDaoTest", "b13", "m009");
				System.out.println(VisiteDao.rechercher("v0030").getReference());
				VisiteDao.supprimer("v0030");
				
				
				
		System.out.println("");
		System.out.println("");
		
		
		
		
		
		// on teste les fct de la classe VisiteService et on affiche le résultat
		System.out.println("_____________________________________________________________");
		System.out.println("");
		System.out.println("Test de la fonction VisiteService : ");
		System.out.println("");
		
				VisiteService.ajoutVisite("v0030", "12/12/2012 12:12:12", "VisiteDaoTest", "b13", "m009");
		
				VisiteService.rechercherVisite("v0030");
				VisiteService.rechercherVisite(null);
				VisiteService.supprimerVisite("v0030");
				VisiteService.supprimerVisite(null);
				
		
		

	}

}
