package gsb.modele.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

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
				uneVisite = new Visite(reqSelection.getString(1), reqSelection.getString(2), reqSelection.getString(3), reqSelection.getString(4), reqSelection.getString(5));
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
		String date = uneVisite.getDateVisite();
		String comm =  uneVisite.getCommentaire();
		String matriculeVisiteur = uneVisite.getMatricule();
		String codeMedecin =  uneVisite.getCode();
		                                                    
		requeteInsertion = "INSERT into VISITE values('"+ref+"','"+date+"','"+comm+"','"+matriculeVisiteur+"','"+codeMedecin+"')";
		System.out.println(requeteInsertion);
		int result = ConnexionMySql.execReqMaj(requeteInsertion);
		System.out.println(result);
		ConnexionMySql.fermerConnexionBd();
		return uneVisite;
	}
	
	
	
	public static ArrayList<Visite> retournerCollectionDesVisites(){
		ArrayList<Visite> collectionDesVisites = new ArrayList<Visite>();
		ResultSet reqSelection = ConnexionMySql.execReqSelection("select REFERENCE from VISITE");
		try{
		while (reqSelection.next()) {
			String reference = reqSelection.getString(1);
		    collectionDesVisites.add(VisiteDao.rechercher(reference));
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("erreur retournerCollectionDesVisites()");
		}
		return collectionDesVisites;
	}
	
	
	public static HashMap<String,Visite> retournerDictionnaireDesVisites(){
		HashMap<String, Visite> diccoDesVisites = new HashMap<String, Visite>();
		ResultSet reqSelection = ConnexionMySql.execReqSelection("select REFERENCE from VISITE");
		try{
		while (reqSelection.next()) {
			String reference = reqSelection.getString(1);
		    diccoDesVisites.put(reference, VisiteDao.rechercher(reference));
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("erreur retournerDiccoDesVisites()");
		}
		return diccoDesVisites;
	}
	
	

}
