package gsb.vue;

	/**
	 * 
	 * @author Marull
	 *
	 */

public class JIFVisiteCons extends JIFVisite {
	
	private static final long serialVersionUID = 1L;
	
	
	public JIFVisiteCons() {
		super();

		pTexte.add(JLreference);
		pTexte.add(JTreference);
		JTreference.setEditable(false);  // on empêche la modification des champs quand on affiche une Visite particulière
		pTexte.add(JLdateVisite);
		pTexte.add(JTdateVisite);
		JTdateVisite.setEditable(false);
		pTexte.add(JLmatricule);
		pTexte.add(JTmatricule);
		JTmatricule.setEditable(false);
		pTexte.add(JLcode);
		pTexte.add(JTcode);
		JTcode.setEditable(false);
		pTexte.add(JLcommentaire);
		pTexte.add(JTcommentaire);
		
		
	}
	

}
