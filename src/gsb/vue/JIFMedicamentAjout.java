package gsb.vue;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JIFMedicamentAjout extends JInternalFrame {
	/**
	 * Commentaire pour <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = 1L;
	protected JPanel p;
	protected JPanel pTexte;
	protected JPanel pBoutons;
	protected JPanel pSaisie;
	protected JButton JBajout;

	protected JLabel JLCodeVisiteur;
	protected JLabel JLDepotLegal;
	protected JLabel JLQuantite;

	protected JTextField JTCodeVisiteur;
	protected JTextField JTDepotLegal;
	protected JTextField JTQuantite;

	public JIFMedicamentAjout() {
		p = new JPanel(); // panneau principal de la fenêtre
		pBoutons = new JPanel(); // panneau supportant les boutons
		pTexte = new JPanel(new GridLayout(3, 2));

		JLCodeVisiteur = new JLabel("Code visiteur");
		JLDepotLegal = new JLabel("Dépot légal");
		JLQuantite = new JLabel("Quantité");

		JTCodeVisiteur = new JTextField(20);
		JTDepotLegal = new JTextField(20);
		JTQuantite = new JTextField(20);

		pTexte.add(JLCodeVisiteur);
		pTexte.add(JTCodeVisiteur);
		pTexte.add(JLDepotLegal);
		pTexte.add(JTDepotLegal);
		pTexte.add(JLQuantite);
		pTexte.add(JTQuantite);

		pSaisie = new JPanel();
		JBajout = new JButton("Ajouter Echantillon");

		// mise en forme de la fenêtre

		p.add(pTexte);
		p.add(pBoutons);
		pBoutons.add(JBajout);
		Container contentPane = getContentPane();
		contentPane.add(p);

	}

}
