package gsb.vue;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import gsb.modele.Medicament;

public class JIFMedicament extends JInternalFrame {
	/**
	 * Commentaire pour <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = 1L;
	protected JPanel p;
	protected JPanel pTexte;
	protected JPanel pBoutons;

	protected JLabel JLdepotLegal;
	protected JLabel JLnomCommercial;
	protected JLabel JLcomposition;
	protected JLabel JLeffets;
	protected JLabel JLcontreIndications;
	protected JLabel JLmedPrixEchantillon;
	protected JLabel JLcodeFamille;
	protected JLabel JLlibelleFamille;

	protected JTextField JTdepotLegal;
	protected JTextField JTnomCommercial;
	protected JTextField JTcomposition;
	protected JTextField JTeffets;
	protected JTextField JTcontreIndications;
	protected JTextField JTmedPrixEchantillon;
	protected JTextField JTcodeFamille;
	protected JTextField JTlibelleFamille;

	public JIFMedicament() {
		p = new JPanel(); // panneau principal de la fenêtre
		pBoutons = new JPanel(); // panneau supportant les boutons
		pTexte = new JPanel(new GridLayout(8, 2));

		JLdepotLegal = new JLabel("Dépôt légal");
		JLnomCommercial = new JLabel("Nom commercial");
		JLcomposition = new JLabel("Composition");
		JLeffets = new JLabel("Effets");
		JLcontreIndications = new JLabel("Contre-indications");
		JLmedPrixEchantillon = new JLabel("Prix");
		JLcodeFamille = new JLabel("Code famille");
		JLlibelleFamille = new JLabel("Libelle famille");

		JTdepotLegal = new JTextField(20);
		JTnomCommercial = new JTextField(20);
		JTcomposition = new JTextField(20);
		JTeffets = new JTextField(20);
		JTcontreIndications = new JTextField(20);
		JTmedPrixEchantillon = new JTextField(20);
		JTcodeFamille = new JTextField(20);
		JTlibelleFamille = new JTextField(20);

		pTexte.add(JLdepotLegal);
		pTexte.add(JTdepotLegal);
		pTexte.add(JLnomCommercial);
		pTexte.add(JTnomCommercial);
		pTexte.add(JLcomposition);
		pTexte.add(JTcomposition);
		pTexte.add(JLeffets);
		pTexte.add(JTeffets);
		pTexte.add(JLcontreIndications);
		pTexte.add(JTcontreIndications);
		pTexte.add(JLmedPrixEchantillon);
		pTexte.add(JTmedPrixEchantillon);
		pTexte.add(JLcodeFamille);
		pTexte.add(JTcodeFamille);
		pTexte.add(JLlibelleFamille);
		pTexte.add(JTlibelleFamille);

		// mise en forme de la fenêtre

		p.add(pTexte);
		p.add(pBoutons);
		Container contentPane = getContentPane();
		contentPane.add(p);

	}

	public void remplirText(Medicament unMedicament) { // méthode qui permet de remplir les zones de texte à partir des
														// valeurs passées en paramètres
		JTdepotLegal.setText(unMedicament.getMedDepotLegal());
		JTnomCommercial.setText(unMedicament.getMedNomCommercial());
		JTcomposition.setText(unMedicament.getMedComposition());
		JTeffets.setText(unMedicament.getMedEffets());
		JTcontreIndications.setText(unMedicament.getMedContreIndic());
		JTmedPrixEchantillon.setText(unMedicament.getMedPrixEchantillon());
		JTcodeFamille.setText(unMedicament.getFamCode());
		JTlibelleFamille.setText(unMedicament.getFamLibelle());

	}

	public void viderText() { // méthode qui permet de vider les zones de texte
		JTdepotLegal.setText("");
		JTnomCommercial.setText("");
		JTcomposition.setText("");
		JTeffets.setText("");
		JTcontreIndications.setText("");
		JTmedPrixEchantillon.setText("");
		JTcodeFamille.setText("");
		JTlibelleFamille.setText("");
	}
}
