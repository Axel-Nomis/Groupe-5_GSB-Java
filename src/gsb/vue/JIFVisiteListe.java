/*
 * Cr�� le 23 f�vr. 2015
 *
 * TODO Pour changer le mod�le de ce fichier g�n�r�, allez � :
 * Fen�tre - Pr�f�rences - Java - Style de code - Mod�les de code
 */
package gsb.vue;

import gsb.modele.Medecin;
import gsb.modele.Visite;
import gsb.modele.dao.VisiteDao;
import gsb.modele.dao.MedecinDao;
import gsb.service.VisiteService;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionListener;

/**
 * @author Isabelle 23 f�vr. 2015 TODO Pour changer le mod�le de ce commentaire
 *         de type g�n�r�, allez � : Fen�tre - Pr�f�rences - Java - Style de
 *         code - Mod�les de code
 */
public class JIFVisiteListe extends JInternalFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	// private ArrayList<Medecin> lesMedecins;
	private ArrayList<Visite> lesVisites;

	protected JPanel p;
	protected JPanel q;
	protected JScrollPane scrollPane;	
	protected MenuPrincipal fenetreContainer;

	protected JPanel pTexte;
	protected JPanel pSaisie;
	protected JButton JBafficherFiche;

	protected JLabel JLmatricule;
	protected JLabel JLdateVisite;
	protected JLabel JLreference;

	protected JTextField JTmatricule;
	protected JTextField JTdateVisite;
	protected JTextField JTreference;

	protected JTable table;

	public JIFVisiteListe(MenuPrincipal uneFenetreContainer) {
		
		fenetreContainer = uneFenetreContainer;
		setTitle("Listes des visites");
		
		/*pBoutons = new JPanel();
		pTexte = new JPanel(new GridLayout(3, 2));
		*/
		
		lesVisites = VisiteDao.retournerCollectionDesVisites();

		int nbLignes = lesVisites.size();

		JTable table;

		p = new JPanel(); // panneau principal de la fen�tre
		/*
		JLmatricule = new JLabel("Code visiteur");
		JLdateVisite = new JLabel("Date Visite");
		JTmatricule = new JTextField(20);
		JTmatricule.setMaximumSize(JTmatricule.getPreferredSize());
		JTdateVisite = new JTextField();

		pTexte.add(JLmatricule);
		pTexte.add(JTmatricule);
		pTexte.add(JLdateVisite);
		pTexte.add(JTdateVisite);*/
		
		
		
		
		int i=0;
		String[][] data = new String[nbLignes][3] ;
		for(Visite uneVisite : lesVisites){
			data[i][0] = uneVisite.getReference();
			data[i][1] = uneVisite.getDateVisite();
			data[i][2] = MedecinDao.rechercher(uneVisite.getCodeMed()).getLaLocalite().getVille();
			i++;
			}
		String[] columnNames = {"R�f�rence", "Code m�decin", "Lieu"};
		table = new JTable(data, columnNames);
		
		scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(450, 200));
		p.add(scrollPane);

		


		pTexte = new JPanel();
		pSaisie = new JPanel();
		JLreference = new JLabel("R�f�rence");
		JTreference = new JTextField(10);
		JTreference.setMaximumSize(JTreference.getPreferredSize());
		JBafficherFiche = new JButton("Visite d�taill�");
		JBafficherFiche.addActionListener(this); // source d'�venement
		pTexte.add(JLreference);
		pSaisie.add(JTreference);
		pSaisie.add(JBafficherFiche);
		
		p.add(pTexte);
		p.add(pSaisie);

		
		// mise en forme de la fen�tre
		Container contentPane = getContentPane();
		contentPane.add(p);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object source = arg0.getSource();
		if (source == JBafficherFiche) {
			Visite uneVisite = VisiteDao.rechercher(JTreference.getText());
			if (uneVisite != null) {
   	   				fenetreContainer.ouvrirFenetre(new JIFVisiteFiche(uneVisite));

				
			}
		}
	}
}
