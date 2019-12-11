package gsb.tests;

import gsb.modele.dao.VisiteDao;

public class VisiteDaoTest {
	public static void main(String[] args) {
		
		
		System.out.println(VisiteDao.rechercher("v0001").getReference());
		System.out.println(VisiteDao.rechercher("v0001").getDateVisite());
		System.out.println(VisiteDao.rechercher("v0001").getCommentaire());
		System.out.println(VisiteDao.rechercher("v0001").getMatriculeVisit());
		System.out.println(VisiteDao.rechercher("v0001").getCodeMed());
		
		//VisiteDao.ajouter("v0024", "12/12/2012 12:12:12", "VisiteDaoTest", "b13", "m009");
		
		
		//VisiteDao.supprimer("v0024");
		//System.out.println(VisiteDao.rechercher("v0024"));
		
	}
}
