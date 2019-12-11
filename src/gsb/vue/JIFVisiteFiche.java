package gsb.vue;

import gsb.modele.Visite;
	
	/**
	 * 
	 * @author Marull
	 *
	 */

public class JIFVisiteFiche extends JIFVisiteCons {

	private static final long serialVersionUID = 1L;

	public JIFVisiteFiche(Visite uneVisite) {
		super();
		this.remplirText(uneVisite);

	}
	

}
