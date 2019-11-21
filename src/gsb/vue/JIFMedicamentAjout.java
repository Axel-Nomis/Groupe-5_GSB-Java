package gsb.vue;

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

import gsb.modele.dao.MedicamentDao;

public class JIFMedicamentAjout extends JInternalFrame implements ActionListener {
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
		JBajout.addActionListener(this);

		// mise en forme de la fenêtre

		p.add(pTexte);
		p.add(pBoutons);
		pBoutons.add(JBajout);
		Container contentPane = getContentPane();
		contentPane.add(p);

	}

	public void actionPerformed(ActionEvent arg0) {
		Object source = arg0.getSource();
		if (source == JBajout) {
			int test = MedicamentDao.ajouterEchantillon(JTQuantite.getText(), JTCodeVisiteur.getText(),
					JTDepotLegal.getText());

			if (test == 1) {
				// afficher réussite
				JOptionPane.showMessageDialog(null, "c'est bon", "Information", JOptionPane.INFORMATION_MESSAGE);
			}
			if (test == 0) {
				// afficher échec
				JOptionPane.showMessageDialog(null, "l'échantillon de ce médicament à déjà été fourni pour ce Visiteur", "Erreur", JOptionPane.ERROR_MESSAGE);
			}
			if (test == -1) {
				// afficher ce dépôt légal n'existe pas réessayez
				JOptionPane.showMessageDialog(null, "ce dépôt légal n'existe pas réessayez", "Erreur",
						JOptionPane.ERROR_MESSAGE);
			}
			if (test == -2) {
				// afficher ce matricule n'existe pas réessayez
				JOptionPane.showMessageDialog(null, "ce matricule n'existe pas réessayez", "Erreur",
						JOptionPane.ERROR_MESSAGE);
			}
			if (test == -3) {
				// afficher erreur de conversion en entier veuillez saisir un entier
				JOptionPane.showMessageDialog(null, "erreur de conversion en entier veuillez saisir un entier",
						"Erreur", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

}
