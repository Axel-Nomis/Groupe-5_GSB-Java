package gsb.tests;

import gsb.modele.dao.VisiteDao;

public class VisiteDaoTestAjout {
	public static void main(String[] args) {
		
		System.out.println(VisiteDao.rechercher("v0026"));
		
	
		System.out.println(VisiteDao.ajouter("v0024", "28/06/1999 12:12:12", "VisiteDaoTest", "b13", "m010"));
		
		
		
	}
}
