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

		JLreference = new JLabel("Référence");
		JLdateVisite = new JLabel("Date Visite");
		JLcommentaire = new JLabel("Commentaire");
		JLmatricule = new JLabel("Code visiteur");
		JLcode = new JLabel("Code Médecin");

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
		JOptionPane boite_dialogue;
		// TODO Auto-generated method stub
		Object source = e.getSource();
		if (source == JBajouterVisite) {
			Visite uneVisite = new Visite(JTreference.getText(), JTdateVisite.getText(), JTcommentaire.getText(),
					JTmatricule.getText(), JTcode.getText());
			VisiteDao.ajouter(uneVisite);
			if (uneVisite != null) {
				// Boîte du message d'information
				boite_dialogue = new JOptionPane();
				boite_dialogue.showMessageDialog(null, "Votre ajout à bien été pris en compte !!!", "Information", JOptionPane.INFORMATION_MESSAGE);
			}
		}

	}

}
