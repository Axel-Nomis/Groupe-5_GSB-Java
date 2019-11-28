package gsb.tests;

import java.util.Date;

import gsb.modele.Visiteur;
import gsb.service.VisiteurService;
import gsb.modele.dao.*;

public class VisiteurServiceTest {
	
	
	public static void main(String[] args) {
		Visiteur unVisiteur = VisiteurService.rechercherVisite("a131");
		
	
		System.out.println(unVisiteur.getNom());
		System.out.println(unVisiteur.getPrenom());
		System.out.println(unVisiteur.getAdresse());
		System.out.println(unVisiteur.getTelephone());
		System.out.println(unVisiteur.getDate_entree());
		
	
		

	}
	

}
