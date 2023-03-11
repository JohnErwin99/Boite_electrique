package io;
import java.io.BufferedReader;
import java.io.BufferedWriter;
/**
 * Classe utilitaire qui permet de sauvegarder dans un fichier binaire ou texte.
 * Elle permet aussi de r�cup�rer une boite.
 *
 * @Author Pierre B�lisle
 * @version H2023
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import modele.Boite;

public class UtilitaireFichier {

	// Permet d'�crire dans un fichier texte en colonne et l'ouvrir dans Excel.
	// Il suffit d'�crire un TAB pour changer de colonne.
	private static final String TAB = "\t";

	/**
	 * Sauvegarde la bo�te dans un fichier texte dont on re�oit le nom.
	 * 
	 */
	public static void sauvegarderDsFichierTexte(Boite boite, String nomFic){

		try {
            
            FileWriter OuvreFichier = new FileWriter(nomFic, true);
            BufferedWriter bw = new BufferedWriter(OuvreFichier);
            
            for(int i = 0; i < Boite.NB_LIGNES_MAX; i++) {
            	for(int j = 0; j < Boite.NB_COLONNES; j++) {
            		 bw.write(boite.getDisjoncteur(j, i).toString());
                     bw.newLine();
            	}
            }
            bw.close();
            
			System.out.println("Les donnees de la boite ont ete sauvegarder avec succes");
 
        } catch (Exception ex) {
            ex.printStackTrace();
        }
		
	}

	

	/**
	 * Sauvegarde la bo�te dans le fichier fichier binaire avec le nom re�u.
	 * 
	 * On pr�sume le nom de fichier valide.
	 * 
	 * @param nomFic o� sauvegarder la bo�te.
	 * @param boite La bo�te � sauvegarder.
	 */
	public static void sauvegarderBoite(Boite boite, String nomFic){

		// � �crire

	}
	
	/**
	 * Ouvre le fichier dont le nom correspond � celui re�u.
	 * 
	 * Exception : Le fichier doit contenir une bo�te sauvegarder par
	 * la m�thode sauvegarderBoite.
	 * 
	 * @param nomFic Le nom du fichier � ouvrir
	 * @return La bo�te contenu dans le fichier.
	 */
	public static Boite recupererBoite(String nomFic){

		Boite boite = null;

		 try {
	            FileReader reader = new FileReader(nomFic);
	            BufferedReader bufferedReader = new BufferedReader(reader);
	 
	            String line;
	 
	            while ((line = bufferedReader.readLine()) != null) {
	                System.out.println(line);
	            }
	            reader.close();
	 
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		return boite;
	}
}