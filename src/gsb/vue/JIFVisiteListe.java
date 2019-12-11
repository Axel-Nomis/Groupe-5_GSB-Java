/*
 * Créé le 23 févr. 2015
 *
 * TODO Pour changer le modèle de ce fichier généré, allez à :
 * Fenêtre - Préférences - Java - Style de code - Modèles de code
 */
package gsb.vue;

import gsb.modele.Visite;
import gsb.modele.dao.VisiteDao;
import gsb.service.VisiteService;
import gsb.modele.dao.MedecinDao;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

	/**
	 * 
	 * @author Marull
	 *
	 */

public class JIFVisiteListe extends JIFVisite implements ActionListener {

	private static final long serialVersionUID = 1L;

	private ArrayList<Visite> lesVisites;

	protected JScrollPane scrollPane;	
	protected MenuPrincipal fenetreContainer;
	protected JTable table;

	public JIFVisiteListe(MenuPrincipal uneFenetreContainer) {
		super();
		
		fenetreContainer = uneFenetreContainer;
		setTitle("Listes des visites");
		
		lesVisites = VisiteDao.retournerCollectionDesVisites();

		int nbLignes = lesVisites.size();
		
		oTexte.add(JLmatricule);
		oTexte.add(JTmatricule);
		oTexte.add(JLdateVisite);
		oTexte.add(JTdateVisite);
		JTable table;

		
		
		int i=0;
		String[][] data = new String[nbLignes][3] ;
		for(Visite uneVisite : lesVisites){
			data[i][0] = uneVisite.getReference();
			data[i][1] = uneVisite.getDateVisite();
			data[i][2] = MedecinDao.rechercher(uneVisite.getCodeMed()).getLaLocalite().getVille();
			i++;
			}
		String[] columnNames = {"Référence", "Code médecin", "Lieu"};
		table = new JTable(data, columnNames);
		
		scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(475, 275));
		p.add(scrollPane);

		
		JBafficherFiche.addActionListener(this); // source d'évenement
		pBoutons.add(JBafficherFiche);		
		pBoutons.add(JTreference);
		
		p.add(pTexte);
		p.add(pBoutons);

		
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
			Visite uneVisite = VisiteDao.rechercher((JTreference.getText()));
			if (uneVisite != null && VisiteDao.retournerDictionnaireDesVisites().containsKey(JTreference.getText())) {
   	   				fenetreContainer.ouvrirFenetre(new JIFVisiteFiche(uneVisite));
			}   	   				
   	   		else {		
   	   				
   	   			JOptionPane.showMessageDialog(null, "La visite est inexistante dans la base de données.", "Erreur", JOptionPane.ERROR_MESSAGE);
				
   	   		}	
		}
	}
}
