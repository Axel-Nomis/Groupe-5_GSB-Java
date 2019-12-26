package gsb.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import gsb.modele.Visite;
import gsb.modele.dao.MedecinDao;
import gsb.modele.dao.VisiteDao;
import gsb.modele.dao.VisiteurDao;

/**
 * 
 * @author Marull
 *
 */

public class VisiteService {

	/**
	 * 
	 * @param uneReference
	 * @return
	 */

	public static Visite rechercherVisite(String uneReference) { // cette fct g�re les erreurs, quand on recherche une
																	// Visite par la r�f�rence

		Visite uneVisite = null;
		try {
			if (uneReference == null) { // quand la r�f�rence est null on affiche un message
				throw new Exception("Donn�e obligatoire : r�f�rence");
			}

			if (!VisiteDao.retournerDictionnaireDesVisites().containsKey(uneReference)) {

				throw new Exception("La visite est inexistante."); // quand la r�f�rence n'existe pas dans la base
			}

			uneVisite = VisiteDao.rechercher(uneReference); // sinon si elle est existe on execute la fct rechercher de
															// la classe VisiteDao
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return uneVisite;
	}

	/**
	 * 
	 * @param reference
	 * @param dateVisite
	 * @param commentaire
	 * @param matriculeVisit
	 * @param codeMed
	 * @return
	 */
	public static int ajoutVisite(String reference, String dateVisite, String commentaire, String matriculeVisit,
			String codeMed) { // gestion des erreurs de la fct ajoutVisite

		/*
		 * try { if (reference == null) { throw new
		 * Exception("Donn�e obligatoire : r�f�rence"); } else if (dateVisite == null) {
		 * throw new Exception("La date de la Visite doit �tre r�f�renc�e"); } else if
		 * (matriculeVisit == null) { throw new
		 * Exception("Le matricule du Visiteur doit �tre r�f�renc�"); } else if (codeMed
		 * == null) { throw new Exception("Le code du M�decin doit �tre r�f�renc�"); }
		 * 
		 * 
		 * } catch (Exception e) { System.out.println(e.getMessage()); }
		 */

		int res = 1;

		if (reference.length() == 0 || dateVisite.length() == 0 || matriculeVisit.length() == 0
				|| codeMed.length() == 0) {
			System.out.println("Vous avez oubli� de r�f�rencer un champs obligatoire");
			res = -1; // on v�rifie que les champs ne sont pas null
		}

		else if (VisiteDao.retournerDictionnaireDesVisites().containsKey(reference)) {

			System.out.println("Cette Visite existe d�ja !");
			res = 0; // on v�rifie que la visite n'est pas d�ja existante
		} else {

			if (reference.length() != 5) {
				System.out.println("La r�f�rence doit �tre de 5 caract�res (ex: v1111) 1 lettre, suivi de 4 chiffres");
				res = 2; // on v�rifie la longueur de la r�f�rence entr�e
			} else {
				if (reference.charAt(0) != 'v') {
					// Character.isLetter(reference.charAt(0)
					System.out.println(
							"Le premier caract�re n'est pas la lettre v, elle doit �tre inscrite pour faire r�f�rence � la Visite.");
					res = 3; // on v�rifie que la r�f�rence commence bien par le caract�re v
				} else {
					for (int i = 1; i < reference.length(); i++) {
						if (reference.charAt(i) < '0' || reference.charAt(i) > '9') {
							System.out.println(
									"Le caract�re " + i + " : [ " + reference.charAt(i) + " ] n'est pas un chiffre !");
							res = 4; // on v�rifie que les 4 derniers caract�res sont bien des chiffres
						}
					}
				}
			}

			if (dateVisite.length() == 19) {
				SimpleDateFormat date_entree = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); // date entr�e par
																							// l'utilisateur pour
																							// simplifier la
																							// compr�hension
				SimpleDateFormat date_sql = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // date convertie pour
																							// respecter le format de la
																							// base de donn�e
				// 12/12/2012 12:12:12 ======> 2012-12-12 12:12:12
				try {
					Date date = date_entree.parse(dateVisite);
					dateVisite = date_sql.format(date);
					System.out.println(date_sql.format(date));
				} catch (Exception e) { // si la convertion ne marche pas
					System.out.println("Error while parsing date");
					e.printStackTrace();
					res = 5;
				}
			} else {
				System.out.println("Mauvais format de la date"); // si la date est entr�e sous le mauvais format
				res = 6;
			}

			// v�rifier avec la cle du dico (containsKey(param)) que le matricule du
			// Visiteur entr�e existe
			if (!VisiteurDao.retournerDictionnaireDesVisiteurs().containsKey(matriculeVisit)) {

				System.out.println("Le matricule du Visiteur n'existe pas dans la base");
				res = 7;

			}

			// v�rifier avec la cle du dico (containsKey(param)) que le code du M�decin
			// entr�e existe
			else if (!MedecinDao.retournerDictionnaireDesMedecins().containsKey(codeMed)) {

				System.out.println("Le code du M�decin n'existe pas dans la base");
				res = 8;

			}
		}
		return res;
	}

	/**
	 * 
	 * @param uneReference
	 */

	public static void supprimerVisite(String uneReference) { // fct qui permet de supprimer une Visite avec l'aide de
																// la r�f�rence

		try {
			if (uneReference == null) { // on v�rifie que uneR�f�rence � bien �t� entr�e
				throw new Exception("Donn�e obligatoire : r�f�rence");
			} else if (!VisiteDao.retournerDictionnaireDesVisites().containsKey(uneReference)) {
				System.out.println("La visite est inexistante.");
				// on v�rifie que uneR�f�rence existe bien dans la base de donn�es
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
	
	
	

	public static int filtreTab(String unMatricule, String uneDate) {

		int res = 0;
		try {
			
			if (unMatricule.length() == 0 || uneDate.length() == 0) { // on v�rifie que uneR�f�rence � bien �t� entr�e
				// throw new Exception("Donn�e obligatoire : r�f�rence");
				JOptionPane.showMessageDialog(null, "Vous avez oubli� de r�f�rencer un champs obligatoire", "Attention",
						JOptionPane.WARNING_MESSAGE);
				res = 1;
			} else {
				if (!VisiteurDao.retournerDictionnaireDesVisiteurs().containsKey(unMatricule)) {

					JOptionPane.showMessageDialog(null, "Le matricule du visiteur n'existe pas dans la base", "Erreur",
							JOptionPane.ERROR_MESSAGE);
					res = -1;
				}
				
				if (uneDate.length() == 19) {
										
					Visite.convertirDate(uneDate);
					
				} else {
					
					JOptionPane.showMessageDialog(null, "Mauvais Format de la date !"
							+ "Veuillez respecter ce format : JJ/MM/AAAA HH:MM:SS.", "Erreur",
							JOptionPane.ERROR_MESSAGE);
					res = 2;
				}
				

			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return res;
	}

}
