package gui;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import io.UtilitaireEntreeSortie;
import io.UtilitaireFichier;
import modele.Boite;
import modele.Disjoncteur;
import javax.swing.JFileChooser;
import javax.swing.JFileChooser;
import javax.swing.JFileChooser;

/*
 * Classe qui contient les sous-programmes pour g�rer les boutons d'option
 * de menu.
 * 
 * S'il y a ajout de bouton, il faut modifier cette classe et y ajouter
 * le comportement d�sir�.
 * 
 * @Author Pierre B�lisle
 * @version H2023
 */
public class UtilitaireGestionMenu {

	// Extension choisie arbitrairement pour les noms de fichier contenant
	// une bo�te.
	public static final String EXTENSION_BOITE = "bte";
	
	public static final String DESC_EXTENSION = "*."+EXTENSION_BOITE;

	/**
	 * L'utilisateur a quitt�, on lui demande si c'est bien ce qu'il veut et 
	 * s'il veut sauvegarder avant de quitter.
	 * 
	 * return Si l'utilisateur poursuit dans sa d�marche de quitter.
	 */
	public static boolean veutSortir(Boite boite){

	    boolean sortie = false;
		
	    String[] buttons = { "Yes","No"};
	    int save = JOptionPane.showOptionDialog(null, "Voulez vous sauvegarder avant de quitter ?", "Sauvegarde",
		        JOptionPane.WARNING_MESSAGE, 0, null, buttons, buttons[1]);
	    if (save == 0) {
	    	sauvegarderBoite(boite);
	    }
	    
	    int rc = JOptionPane.showOptionDialog(null, "Voulez vous vraiment quitter ?", "Confirmation",
	        JOptionPane.WARNING_MESSAGE, 0, null, buttons, buttons[1]);
	    
	    System.out.println(rc);	 
	    if(rc == 0) {
	    	sortie = true;
	    	System.exit(0);
	    }
	    return sortie;
	}

	/**
	 * Ajoute un disjoncteur � la bo�te.
	 * 	
	 * @param boite
	 */
	public static void ajouterDisjoncteur(Boite boite){

		try {
			int ligne = UtilitaireEntreeSortie.entierValide("Entrer la ligne ou inserer un disjoncteur", 1, Boite.NB_LIGNES_MAX);
			int colonne = UtilitaireEntreeSortie.entierValide("Entrer la colonne pour ajouter un disjoncteur", 1, Boite.NB_COLONNES);
			int tension = UtilitaireEntreeSortie.tensionValide();
			
			if(boite.getEmplacementEstVide(colonne, ligne) == true) {
				boite.ajouterDisjoncteur(colonne, ligne, new Disjoncteur(tension));
			}
			else {
				  JOptionPane.showMessageDialog(null, "Pas de place dispo a cet emplacement, choisir un autre");
			}

		}catch(Exception e) {
			System.out.println(e.toString());
		} 
	}

	/**
	 * Ajoute une demande � un disjoncteur.  Si la demande est trop grande, 
	 * le disjoncteur est �teint.
	 * 
	 * @param boite  La boite � consid�rer.
	 */
	public static void ajouterDemande(Boite boite){
		System.out.println("in ajouter demande");

		try {
			int ligne = UtilitaireEntreeSortie.entierValide("Entrer la ligne ou inserer une demnde", 1, Boite.NB_LIGNES_MAX);
			
			//if (ligne != -1 ) { // ligne != min-2 (1-2)
			//entierValide fait deja le check
				int colonne = UtilitaireEntreeSortie.entierValide("Entrer la colonne pour ajouter un", 1, Boite.NB_COLONNES);
				//if (colonne != -1 ) {
				int demande = Integer.parseInt(JOptionPane.showInputDialog("Entrer la demande en WATTS"));
			 
					//si la demande - negative, on retire une demande du disjoncteur.
		
					//on passe la puissance / tension / 0.80 qui equivaut a lampere. 
					//La method ajouterDemande prends un puissance alors il faut reconvertir lampere en puissance, 
					//donc ampere *  tension * 0.80. 
					//donc, on valide lampre en passant la variable (demande / tension / 0.80) = ampere
					//et on ajoute la demande (watts), (demande / tension / 0.80) *( tension * 0.80)
			 
					//if(boite.isAmpereSupMaxAmpere()) {
						//JOptionPane.showMessageDialog(null, "Vous avez depasse le maximum dampere que vous pouvez ajouter dans la boite.");
					//}
					// else if(demande == (demande * -1)) {
					// JOptionPane.showMessageDialog(null, "Vous avez depasse le maximum dampere que vous pouvez ajouter, vous devez enlever une demande");

					// }
					//else {
					boite.getDisjoncteur(colonne, ligne).ajouterDemande(UtilitaireEntreeSortie.ampereValide((demande / boite.getDisjoncteur(colonne, ligne).getTension()) / 0.80)
							* boite.getDisjoncteur(colonne, ligne).getTension() * 0.80);
					JOptionPane.showMessageDialog(null, boite.getDisjoncteur(colonne, ligne).toString());
					
					//}
				//}
			//}
			
		     

			 //regarde si la ampere est valide en passant les valeurs(ampere).
			 //Disjoncteur d = new Disjoncteur();
			 
			 /*il faut verifier la demande, mais po
			 if(u.ampereValide((demande /  boite.getDisjoncteur(colonne, ligne).getTension()) / 0.80) == 0){
			 }
			 //si ampere est valide !=0, on retourne lampere. 
			 //La method retourne lampere alors pour retrouver la puissanc eil faut faire tension * ampere * 0.80.
			 else
				 boite.getDisjoncteur(colonne, ligne).ajouterDemande((demande /  boite.getDisjoncteur(colonne, ligne).getTension() / 0.80)
						 * boite.getDisjoncteur(colonne, ligne).getTension() * 0.80); */
			 
			 
		}catch(Exception e) {
			
		}
	   
	}

	/**
	 * Sert � l'interaction avec l'utilisateur pour obtenir le nom du fichier 
	 * de sauvegarde et sa validation.
	 * 
	 * @return La boite r�cup�rer ou null.
	 */
	public static Boite recupererBoite() {
	//String fichier = JOptionPane.showInputDialog("Le nom du fichier pour recuperer la boite");
	 JFrame frame = new JFrame();
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(frame);
        if (result == JFileChooser.APPROVE_OPTION) {
     
            File file = fileChooser.getSelectedFile();
            System.out.println("Choisir le fichier: " + file.getAbsolutePath());
       
        	String nomFichier = file.getName();
        	if (nomFichier.endsWith(".bte")) {
        		Boite boite = UtilitaireFichier.recupererBoite(nomFichier);
        		return boite;
        	}
        	JOptionPane.showMessageDialog(null, "This file is not a .bte file");
        }
        	return null;
	}

	/**
	 * Sert � l'interaction avec l'utilisateur pour obtenir le nom du fichier 
	 * de sauvegarde et sa validation.
	 * 
	 * @param La bo�te � sauvegarder.
	 */
	//IMPORTANT. AJOUTER LA SAUVEGARDE EN BINAIRE
	public static void sauvegarderBoite(Boite boite) {
		
		JFileChooser fileChooser = new JFileChooser();
		int entree = fileChooser.showSaveDialog(null);
		boolean saveConfirm = false;
		if (entree == JFileChooser.APPROVE_OPTION) {
			File fichierChoisie = fileChooser.getSelectedFile();
			String nomFichier = fichierChoisie.getName();
			
				if(nomFichier!= null && nomFichier.length()>=1 ) {
					saveConfirm = true;
					JOptionPane.showMessageDialog(null, "Boite sauvegarde");
					UtilitaireFichier.sauvegarderDsFichierTexte(boite, nomFichier+".txt");
					UtilitaireFichier.sauvegarderBoite(boite,nomFichier);
				}
		}
		if (saveConfirm = false) {
			JOptionPane.showMessageDialog(null, "Sauvegarde de la boite échoué");
		}
		
		
		//String nomFic = JOptionPane.showInputDialog("Entrez le nom du fichier");
		
		
	}
}