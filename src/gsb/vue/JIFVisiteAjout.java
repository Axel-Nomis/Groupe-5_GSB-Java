package gsb.vue;

import gsb.modele.dao.VisiteDao;
import gsb.service.VisiteService;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

	/**
	 * 
	 * @author Marull
	 *
	 */

public class JIFVisiteAjout extends JIFVisite implements ActionListener {

	/**
	 * Commentaire pour <code>serialVersionUID</code>
	 **/

	private static final long serialVersionUID = 1L;

	public JIFVisiteAjout() {
		super(); // on hérite de JIFVisite et donc de ces attributs, méthodes ...

		setTitle("Nouvelle visite dans la base de données"); // titre de la fenêtre

		JBajouterVisite.addActionListener(this); // ajout d'une action (source d'évenement) au bouton ajouterVisite
		JBannulerVisite.addActionListener(this); // ajout d'une action au bouton annulerVisite

		pTexte.add(JLreference); // on utilise l'attribut (JL ET JT) reference de la classe JIFVisite
		pTexte.add(JTreference);
		pTexte.add(JLdateVisite); // on utilise l'attribut (JL ET JT) dateVisite de la classe JIFVisite
		pTexte.add(JTdateVisite);
		pTexte.add(JLcommentaire); // on utilise l'attribut (JL ET JT) commentaire de la classe JIFVisite
		pTexte.add(JTcommentaire);
		pTexte.add(JLmatricule); // on utilise l'attribut (JL ET JT) matricule de la classe JIFVisite
		pTexte.add(JTmatricule);
		pTexte.add(JLcode); // on utilise l'attribut (JL ET JT) code de la classe JIFVisite
		pTexte.add(JTcode);

		pBoutons.add(JBajouterVisite); // on utilise l'attribut bouton ajouterVisite de la classe JIFVisite
		pBoutons.add(JBannulerVisite); // on utilise l'attribut bouton annulerVisite de la classe JIFVisite

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object source = e.getSource();
		if (source == JBajouterVisite) {					// quand l'utilisateur clique sur le bouton Ajouter 

			String ref = JTreference.getText();				// on récupère les données entrées par l'utilisateur dans des variables qui vont être testées
			String dateV = JTdateVisite.getText();
			String comm = JTcommentaire.getText();
			String mat = JTmatricule.getText();
			String code = JTcode.getText();

			int echo = VisiteService.ajoutVisite(ref, dateV, comm, mat, code); // on utilise la fct ajoutVisite de la
																				// classe VisiteService qui va retouner
																				// un code d'erreur qui permettra
																				// d'identifier l'erreur

			switch (echo) { // messages des différentes erreur en fct de la valeur echo

			case -1:
				JOptionPane.showMessageDialog(null, "Vous avez oublié de référencer un ou plusieurs champ(s).",
						"¡¡¡ Attention !!!", JOptionPane.ERROR_MESSAGE);
				break;

			case 0:
				JOptionPane.showMessageDialog(null, "Cette Visite existe déja !", "Attention",
						JOptionPane.WARNING_MESSAGE);
				break;

			case 1:
				VisiteDao.ajouter(ref, dateV, comm, mat, code);
				JOptionPane.showMessageDialog(null, "Votre Visite à bien été prise en compte !.", "Information",
						JOptionPane.INFORMATION_MESSAGE);
				break;

			case 2:
				JOptionPane.showMessageDialog(null,
						"La référence doit être de 5 caractères 1 lettre, suivi de 4 chiffres (ex: v1111).",
						"¡¡¡ Attention !!!", JOptionPane.WARNING_MESSAGE);
				break;

			case 3:
				JOptionPane.showMessageDialog(null,
						"La référence doit commencer par la lettre 'v', pour signifier que c'est une Visite.",
						"¡¡¡ Attention !!!", JOptionPane.QUESTION_MESSAGE);
				break;

			case 4:
				JOptionPane.showMessageDialog(null, "La référene doit contenir 4 chiffres après le v", "Erreur",
						JOptionPane.ERROR_MESSAGE);
				break;

			case 5:
				JOptionPane.showMessageDialog(null, "Problème de conversion, la date ne doit contenir que des chiffres",
						"Erreur", JOptionPane.ERROR_MESSAGE);
				break;

			case 6:
				JOptionPane.showMessageDialog(null,
						"La date n'est pas entrée sous le bon format, "
								+ "qui doit être celui-ci : JJ/MM/AAAA  HH:MM:SS",
						"Attention", JOptionPane.WARNING_MESSAGE);
				break;

			case 7:
				JOptionPane.showMessageDialog(null, "Le matricule du Visiteur n'existe pas dans la base", "Erreur",
						JOptionPane.ERROR_MESSAGE);
				break;

			case 8:
				JOptionPane.showMessageDialog(null, "Le code du Médecin n'existe pas dans la base", "Erreur",
						JOptionPane.ERROR_MESSAGE);
				break;

			}
		}

		else if (source == JBannulerVisite) { // bouton annuler qui utilise la fct de la classe JIFVisite viderText() et
												// qui permet de
												// vider les champs qui contiennent du texte
			this.viderText();

		}

	}

}
