package gsb.modele.dao;

import java.sql.ResultSet;
import java.util.Date;

import gsb.modele.Localite;
import gsb.modele.Visite;
import gsb.modele.Visiteur;
import gsb.modele.Medecin;

public class VisiteDao {
	
	
	public static Visite rechercher(String reference) {
		Visite uneVisite=null;
		Localite uneLocalite= null;
		Visiteur unVisiteur = null;
		Medecin unMedecin = null;
		ResultSet reqSelection = ConnexionMySql.execReqSelection("SELECT * from VISITE where Reference ='"+reference+"'");
		try {
			if (reqSelection.next()) {
				uneLocalite = LocaliteDao.rechercher(reqSelection.getString(5));
				uneVisite = new Visite(reqSelection.getString(1), reqSelection.getDate(2), reqSelection.getString(3), unVisiteur, unMedecin );
			};
			}
		catch(Exception e) {
			System.out.println("erreur reqSelection.next() pour la requête - SELECT * from VISITE where Reference ='"+reference+"'");
			e.printStackTrace();
			}
		ConnexionMySql.fermerConnexionBd();
		return uneVisite;
	}
	
	
	
	
	
	public static Visite ajouter(Visite uneVisite) {
		
		String requeteInsertion;
		String ref= uneVisite.getReference();
		Date date = uneVisite.getDateVisite();
		String comm =  uneVisite.getCommentaire();
		String matVisiteur = uneVisite.getVisiteur().getMatricule();
		String codeMedecin =  uneVisite.getMedecin().getCodeMed();
		                                                    
		requeteInsertion = "INSERT into VISITE values('"+ref+"','"+date+"','"+comm+"','"+matVisiteur+"','"+codeMedecin+"')";
		System.out.println(requeteInsertion);
		int result = ConnexionMySql.execReqMaj(requeteInsertion);
		System.out.println(result);
		ConnexionMySql.fermerConnexionBd();
		return uneVisite;
	}	
	

}
