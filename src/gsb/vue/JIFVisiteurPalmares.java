package gsb.vue;

import gsb.modele.Podium;
import gsb.modele.Visiteur;
import gsb.modele.dao.PodiumDao;
import gsb.modele.dao.VisiteurDao;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;



public class JIFVisiteurPalmares extends JIFVisiteur implements ActionListener {
	
	private static final long serialVersionUID = 1L;

	private ArrayList<Podium> lePodium;
	
	protected JPanel p;
	protected JScrollPane scrollPane;
	protected JPanel pSaisie;	
	protected JButton JBafficherFiche;
	protected MenuPrincipal fenetreContainer;
	
	
	
	public JIFVisiteurPalmares(MenuPrincipal uneFenetreContainer) {
		super();

		fenetreContainer = uneFenetreContainer;
		setTitle("Palmarès");

		fenetreContainer = uneFenetreContainer;
		// récupération des données Medecin dans la collection
		lePodium = PodiumDao.retournerCollectionPodium();

		int nbLignes = lePodium.size();

		JTable table;

		p = new JPanel(); // panneau principal de la fenêtre

		int i = 0;
		String[][] data = new String[nbLignes][5];
		
		for (Podium unPodium : lePodium) {
			data[i][0] = unPodium.getRang();
			data[i][1] = unPodium.getMatricule();
			data[i][2] = unPodium.getNom();
			data[i][3] = unPodium.getPrenom();
			data[i][4] = unPodium.getNbVisite();
			i++;
		}
		String[] columnNames = {"Rang", "Matricule", "Nom", "Prenom", "Nombre de Visite"};
		table = new JTable(data, columnNames);

		scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(400, 200));
		p.add(scrollPane);

		// mise en forme de la fenêtre
		Container contentPane = getContentPane();
		contentPane.add(p);
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	

	
	

}
