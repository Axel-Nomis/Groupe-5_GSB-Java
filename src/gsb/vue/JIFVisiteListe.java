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
import java.util.stream.Stream;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

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
	protected DefaultTableModel model;

	public JIFVisiteListe(MenuPrincipal uneFenetreContainer) {
		super();
		
		fenetreContainer = uneFenetreContainer;
		setTitle("Listes des visites");
		
		
		
		
		
		oTexte.add(JLmatricule);
		oTexte.add(JTmatricule);
		oTexte.add(JLdateVisite);
		oTexte.add(JTdateVisite);
		
		
		JTable table;
		
		String[] columnNames = {"Référence", "Code médecin", "Lieu"};
		model = new DefaultTableModel(columnNames,0);
				
		table = new JTable(model);
		
		scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(475, 275));
		p.add(scrollPane);
		
		
		
		JTreference = new JTextField(10);
		JTreference.setMaximumSize(JTreference.getPreferredSize());
		
		

		
		JBafficherFiche.addActionListener(this); // source d'évenement
		JBfiltrer.addActionListener(this); // source d'évenement
		
		pBoutons.add(JLreference);
		pBoutons.add(JTreference);
		pBoutons.add(JBfiltrer);
		pBoutons.add(JBafficherFiche);
		
		
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
		
		else if (source == JBfiltrer) {
			String reference = JTmatricule.getText().toString();
			String date = JTdateVisite.getText().toString();
			
			ArrayList<Visite> testVisite = VisiteDao.retournerCollectionDesVisitesRefDate(reference, date);
			System.out.println(testVisite.size());
			for(Visite uneVisite : testVisite) {
				String data[] = {uneVisite.getReference(), uneVisite.getCodeMed(), MedecinDao.rechercher(uneVisite.getCodeMed()).getLaLocalite().getVille()};
				model.addRow(data);
			}
			
            
            
            
            
		}
	}
}
