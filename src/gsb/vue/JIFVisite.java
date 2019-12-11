package gsb.vue;

import gsb.modele.Visite;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

	/**
	 * 
	 * @author Marull
	 *
	 */

public class JIFVisite extends JInternalFrame {

	/**
	 * Commentaire pour <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = 1L;
	protected JPanel p;
	protected JPanel pTexte;
	protected JPanel oTexte;
	
	
	protected JPanel pBoutons;
	protected JPanel pSaisie;
	protected JButton JBajouterVisite;
	protected JButton JBannulerVisite;
	protected JButton JBafficherLigne;
	protected JButton JBafficherFiche;
	

	protected JLabel JLreference;
	protected JLabel JLdateVisite;
	protected JLabel JLcommentaire;
	protected JLabel JLmatricule;
	protected JLabel JLcode;

	protected JTextField JTreference;
	protected JTextField JTdateVisite;
	protected JTextField JTcommentaire;
	protected JTextField JTmatricule;
	protected JTextField JTcode;

	public JIFVisite() {
		
		p = new JPanel(); 									// panneau principal de la fen�tre
		pBoutons = new JPanel(); 							// panneau supportant les boutons
		pTexte = new JPanel(new GridLayout(9, 2));			// cr�ation d'une grille
		oTexte = new JPanel(new GridLayout(4, 3));
		
		

		JLreference = new JLabel("R�f�rence* :");			// initialisation des labels qui seront utilis�s par les autres classe JIF
		JLdateVisite = new JLabel("Date Visite* :");
		JLcommentaire = new JLabel("Commentaire* :");
		JLmatricule = new JLabel("Matricule visiteur* :");
		JLcode = new JLabel("Code m�decin* :");

		JTreference = new JTextField(20);					// initialisation des zones de textes qui seront utilis�s par les autres classe JIF
		JTreference.setMaximumSize(JTreference.getPreferredSize());
		JTdateVisite = new JTextField();
		JTcommentaire = new JTextField();
		JTmatricule = new JTextField();
		JTcode = new JTextField();

		
		JBajouterVisite = new JButton("Ajouter");			// initialisation des diff�rents bouttons
		JBannulerVisite = new JButton("Annuler");
		JBafficherLigne = new JButton("Filtrer");
		JBafficherFiche = new JButton("Visite d�taill�");
		
		
		p.add(pTexte);
		p.add(oTexte);
		p.add(pBoutons);
		
		Container contentPane = getContentPane();			// mise en forme de la fen�tre
		contentPane.add(p);
		
	}

	public void remplirText(Visite uneVisite) { // m�thode qui permet de remplir les zones de texte � partir des valeurs
												// pass�es en param�tres

		JTreference.setText(uneVisite.getReference());
		JTdateVisite.setText(uneVisite.getDateVisite());
		JTcommentaire.setText(uneVisite.getCommentaire());
		JTmatricule.setText(uneVisite.getMatriculeVisit());
		JTcode.setText(uneVisite.getCodeMed());
	}

	public void viderText() { // m�thode qui permet de vider les zones de texte
		JTreference.setText("");
		JTdateVisite.setText("");
		JTcommentaire.setText("");
		JTmatricule.setText("");
		JTcode.setText("");
	}


}
