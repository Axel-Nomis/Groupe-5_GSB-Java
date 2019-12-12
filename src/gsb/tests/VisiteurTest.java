package gsb.tests;

import gsb.modele.Visite;
import gsb.modele.Visiteur;
import gsb.modele.dao.MedecinDao;
import gsb.modele.dao.VisiteurDao;
import gsb.service.VisiteService;
import gsb.service.VisiteurService;

public class VisiteurTest {

	public static void main(String[] args) {
		
		// on teste les fct de la classe Visite et on affiche le résultat
		System.out.println("_____________________________________________________________");
		System.out.println("");
		System.out.println("Test de la classe Visiteur : ");
		System.out.println("");
				
		Visiteur unVisiteur = VisiteurService.rechercherVisite("a131");
		System.out.println(unVisiteur.getMatricule());
		System.out.println(unVisiteur.getNom());
		System.out.println(unVisiteur.getPrenom());
		System.out.println(unVisiteur.getAdresse());
		System.out.println(unVisiteur.getCode_postale());
		System.out.println(unVisiteur.getDate_entree());
		System.out.println(unVisiteur.getCode_unit());
		System.out.println(unVisiteur.getNom_unit());
				
		
		//System.out.println(VisiteurDao.rechercher(uneVisite.getMatriculeVisit()).getNom());
		//System.out.println(MedecinDao.rechercher(uneVisite.getCodeMed()).getLaLocalite().getVille());
		
		// on teste les fct de la classe VisiteurService et on affiche le résultat
		
		System.out.println("_____________________________________________________________");
		System.out.println("");
		System.out.println("Test de la fonction VisiteurDao : ");
		System.out.println("");
		
		
		
		
		// on teste les fct de la classe VisiteurService et on affiche le résultat
		System.out.println("_____________________________________________________________");
		System.out.println("");
		System.out.println("Test de la fonction VisiteurService : ");
		System.out.println("");

		//Visiteur unVisiteur = VisiteurService.rechercherVisite("a131");

		System.out.println(unVisiteur.getNom());
		System.out.println(unVisiteur.getPrenom());
		System.out.println(unVisiteur.getAdresse());
		System.out.println(unVisiteur.getDate_entree());
		System.out.println(unVisiteur.getCode_unit());

	}

}
