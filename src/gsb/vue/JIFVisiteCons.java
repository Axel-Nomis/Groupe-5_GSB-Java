package gsb.vue;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import gsb.modele.Medicament;
import gsb.modele.Visite;
import gsb.modele.dao.MedecinDao;
import gsb.modele.dao.MedicamentDao;
import gsb.modele.dao.VisiteDao;

/**
	 * 
	 * @author Marull
	 *
	 */

public class JIFVisiteCons extends JIFVisite {
	
	private static final long serialVersionUID = 1L;
	private ArrayList<Medicament> lesMedicaments;
	protected JTable table;
	protected JScrollPane scrollPane;	
	
	public JIFVisiteCons() {
		super();
		
		setTitle("Récapitulatif d'une visite"); // titre de la fenêtre
		
		JTable table;
		
		lesMedicaments = MedicamentDao.retournerCollectionDesMedicaments();
		int nbLignes = lesMedicaments.size();
		
		int i = 0;
		int m = 1;
		String[][] data = new String[nbLignes][3] ;
		for(Medicament unMedicament : lesMedicaments){
			data[i][0] = "Médicament " + m;
			data[i][1] = unMedicament.getMedDepotLegal();
			data[i][2] = unMedicament.getMedComposition();
			i++;
			m++;
			}
		String[] columnNames = {"", "Dépôt légal", "Quantité offerte"};
		
		table = new JTable(data, columnNames);
		
		scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(475, 275));
		p.add(scrollPane);
		
		
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
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object source = e.getSource();
		if (source == JBajouterVisite) {
			
			
			
		}
		
	}
	

}
