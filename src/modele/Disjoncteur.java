package modele;
import java.io.Serializable;

import util.Liste;

/*
* Classe qui regroupe tout qui concerne un
* disjoncteur dans le projet.
*
* On y retrouve les constantes et les  sous-programmes
* li� � un disjoncteur.
* 
* Impl�mente l'interface Serializable pour la sauvegarde
* dans un fichier binaire. 
* 
* @suthor Pierre B�lisle
* @version Copyright H2023
*/
public class Disjoncteur implements Serializable{

	/**
	 * Enl�ve un "warning". On ne g�re pas les versions.
	 */
	private static final long serialVersionUID = 1L;
	
	
    // �tat possible d'un disjoncteur.
	public static final int ALLUME = 1;
	public static final int ETEINT = 0;
	
	// Choix d'amp�rages possibles.
	private static final int MIN_AMPERAGE = 15;
	private static final int MAX_AMPERAGE = 60;
	

	// Tous les amp�rages permis dans un tableau.  
	public static final int AMPERAGES_PERMIS[] =
		                               {MIN_AMPERAGE, 20, 40, 50, MAX_AMPERAGE};

	// Construction d'une cha�ne avec les amp�rages permis. Sert � valider.
	public static final  String CHAINE_AMPERAGE_PERMIS = 
			"15/20/40/50/60";
	
	// Les tensions possibles.
	public static final int TENSION_ENTREE = 240;
	public static final int TENSION_PHASE = 120;

	// Construction d'une cha�ne avec les tensions permises. Sert � valider.
	public static final  String CHAINE_TENSION_PERMISE = 
			"120/240";
	
	
	
	/******************************
	 * * Les attributs d'un disjoncteur
	 ********************************/
	
	private double ampere;
    private double tension;

	// Une liste qui contient les demandes (charge) sur le circuit.
	private Liste demandeDuCircuit;
	
	// ALLUME ou ETEINT.	
    private int etat;
    
    
    // VOUS DEVEZ �CRIRE LES COMMENTAIRES JAVADOC AUSSI

	public Disjoncteur(double ampere, double tension) {
		this.ampere = ampere;
		this.tension = tension;
		
	}

	public double getAmpere() {
	
		// TODO Auto-generated method stub
		return 0;
	}

	public int getTension() {
	
		// TODO Auto-generated method stub
		return 0;
	}

	public double getPuissanceEnWatt() {
	
		// TODO Auto-generated method stub
		return 0;
	}

	public int getEtat() {
	
		// TODO Auto-generated method stub
		return 0;
	}

	public double getRatio() {
	
		// TODO Auto-generated method stub
		return 0;
	}
    
}
    
