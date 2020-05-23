package gsb.vue;

import gsb.modele.Visite;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

	/**
	 * 
	 * @author Marull
	 *
	 */

public class JIFVisiteur extends JInternalFrame {

	/**
	 * Commentaire pour <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = 1L;
	protected JPanel p;
	protected JPanel pTexte;
	protected JPanel pBoutons;
	
	
	
	
	protected JButton JBFermer;
	protected JButton JBafficherFiche;
		

	protected JLabel JLmatricule;
	protected JLabel JLnom;
	protected JLabel JLprenom;

	
	protected JTextField JTmatricule;
	protected JTextField JTnom;
	protected JTextField JTprenom;
	
	
	public JIFVisiteur() {
		
		p = new JPanel(); 									// panneau principal de la fenêtre
		pBoutons = new JPanel(); 							// panneau supportant les boutons
		pTexte = new JPanel(new GridLayout(9, 2));			// création d'une grille
		
		

		JLmatricule = new JLabel("Matricule :");			// initialisation des labels qui seront utilisés par les autres classe JIF
		JLnom = new JLabel("Nom :");
		JLprenom = new JLabel("Prénom :");
		

		JTmatricule = new JTextField(20);					// initialisation des zones de textes qui seront utilisés par les autres classe JIF
		JTmatricule.setMaximumSize(JTmatricule.getPreferredSize());
		JTnom = new JTextField();
		JTprenom = new JTextField();

		
		JBFermer = new JButton("Fermer");			// initialisation des différents bouttons
		JBafficherFiche = new JButton("Visite détaillé");
		
		
		pTexte.add(JLmatricule);
		pTexte.add(JLnom);
		pTexte.add(JLprenom);
		
		pTexte.add(JTmatricule);
		pTexte.add(JTnom);
		pTexte.add(JTprenom);

		
		
		
		p.add(pTexte);
		p.add(pBoutons);
		
		Container contentPane = getContentPane();			// mise en forme de la fenêtre
		contentPane.add(p);
		
	}

	


}
