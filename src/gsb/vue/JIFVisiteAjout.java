package gsb.vue;

import gsb.modele.Medecin;
import gsb.modele.Visite;
import gsb.modele.dao.MedecinDao;
import gsb.modele.dao.VisiteDao;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JIFVisiteAjout extends JInternalFrame implements ActionListener {

	/**
	 * Commentaire pour <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = 1L;
	protected JPanel p;
	protected JPanel pTexte;
	protected JPanel pBoutons;
	protected JButton JBajouterVisite;

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

	public JIFVisiteAjout() {

		p = new JPanel(); // panneau principal de la fenêtre
		pBoutons = new JPanel(); // panneau supportant les boutons
		pTexte = new JPanel(new GridLayout(9, 2));

		JLreference = new JLabel("Référence *");
		JLdateVisite = new JLabel("Date Visite *");
		JLcommentaire = new JLabel("Commentaire");
		JLmatricule = new JLabel("Matricule Visiteur *");
		JLcode = new JLabel("Code Médecin *");

		JTreference = new JTextField(20);
		JTreference.setMaximumSize(JTreference.getPreferredSize());
		JTdateVisite = new JTextField();
		JTcommentaire = new JTextField();
		JTmatricule = new JTextField();
		JTcode = new JTextField();

		JBajouterVisite = new JButton("Ajouter");
		JBajouterVisite.addActionListener(this);

		pTexte.add(JLreference);
		pTexte.add(JTreference);
		pTexte.add(JLdateVisite);
		pTexte.add(JTdateVisite);
		pTexte.add(JLcommentaire);
		pTexte.add(JTcommentaire);
		pTexte.add(JLmatricule);
		pTexte.add(JTmatricule);
		pTexte.add(JLcode);
		pTexte.add(JTcode);

		pBoutons.add(JBajouterVisite);

		// mise en forme de la fenêtre

		p.add(pTexte);
		p.add(pBoutons);
		Container contentPane = getContentPane();
		contentPane.add(p);
	}

	public void remplirText(Visite uneVisite) { // méthode qui permet de remplir les zones de texte à partir des valeurs
												// passées en paramètres

		JTreference.setText(uneVisite.getReference());
		JTdateVisite.setText(uneVisite.getDateVisite());
		JTcommentaire.setText(uneVisite.getCommentaire());
		JTmatricule.setText(uneVisite.getMatriculeVisit());
		JTcode.setText(uneVisite.getCodeMed());
	}

	public void viderText() { // méthode qui permet de vider les zones de texte
		JTreference.setText("");
		JTdateVisite.setText("");
		JTcommentaire.setText("");
		JTmatricule.setText("");
		JTcode.setText("");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object source = e.getSource();
		if (source == JBajouterVisite) {
			
			String ref = JTreference.getText();
			String dateV = JTdateVisite.getText();
			String comm = JTcommentaire.getText();
			String mat = JTmatricule.getText();
			String code = JTcode.getText();
			
			int echo = VisiteDao.ajouter(ref, dateV, comm, mat, code);
			
			
			switch(echo) {
			
			case -1:
				JOptionPane.showMessageDialog(null, "Vous avez oublié de référencé un ou plusieurs champ(s).", "¡¡¡ Attention !!!", JOptionPane.PLAIN_MESSAGE);
				break;
			
			case 0:
				JOptionPane.showMessageDialog(null, "Cette Visite existe déja !", "Attention", JOptionPane.WARNING_MESSAGE);
				break;
			
			case 1:
				JOptionPane.showMessageDialog(null, "Votre Visite à bien été prise en compte !.", "Information", JOptionPane.INFORMATION_MESSAGE);
				break;
			
			case 2:
				JOptionPane.showMessageDialog(null, "La référence doit être de 5 caractères 1 lettre, suivi de 4 chiffres (ex: v1111).", "¡¡¡ Attention !!!", JOptionPane.WARNING_MESSAGE);
				break;
			
			case 3:
				JOptionPane.showMessageDialog(null, "La référence doit commencer par la lettre 'v', pour signifier que c'est une Visite.", "¡¡¡ Attention !!!", JOptionPane.QUESTION_MESSAGE);
				break;
				
			case 4:
				JOptionPane.showMessageDialog(null, "La référene doit contenir 4 chiffres après le v", "Erreur", JOptionPane.ERROR_MESSAGE);
				break;
				
			case 5:
				JOptionPane.showMessageDialog(null, "Problème de conversion, la date ne doit contenir que des chiffres", "Erreur", JOptionPane.ERROR_MESSAGE);
				break;
				
			case 6:
				JOptionPane.showMessageDialog(null, "La date n'est pas entrée sous le bon format, "
						+ "qui doit être celui-ci : JJ/MM/AAAA  HH:MM:SS", "Attention", JOptionPane.WARNING_MESSAGE);
				break;	
				
			
			case 7:
				JOptionPane.showMessageDialog(null, "Le matricule du Visiteur n'existe pas dans la base", "Erreur", JOptionPane.ERROR_MESSAGE);
				break;
				
				
			case 8:
				JOptionPane.showMessageDialog(null, "Le code du Médecin n'existe pas dans la base", "Erreur", JOptionPane.ERROR_MESSAGE);
				break;
				
			}
			
			
		}

	}

}
