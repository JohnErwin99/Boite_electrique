package modele;
import java.io.Serializable;
import java.util.*;

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
	LinkedList<Double> demandeDuCircuit;

	
	// ALLUME ou ETEINT.	
    private int etat;
    
    public Disjoncteur() {
		demandeDuCircuit = new LinkedList<Double>();
	}
    public Disjoncteur(double tension) {
    	this.tension = setTension(tension);
		demandeDuCircuit = new LinkedList<Double>();
	}
    
    // VOUS DEVEZ �CRIRE LES COMMENTAIRES JAVADOC AUSSI

	public Disjoncteur(double ampere, double tension) {
		this.ampere = setAmpere(ampere);
		this.tension = setTension(tension);
		
		etat = ETEINT;
		demandeDuCircuit = new LinkedList<Double>();
		
	}

	public double getAmpere() {
	
		return ampere;
	}
	//valide si lampere est permise. return lampere ou return 0.
	public double setAmpere(double ampere) {
		boolean trouve = false;
		int index = -1;
		for (int i = 0; i < AMPERAGES_PERMIS.length; i++) {
            if (Double.compare(ampere, AMPERAGES_PERMIS[i]) == 0) {	
                trouve = true;
                index = i;
                break;
            }
        }

        // print the result of the search
        if (trouve) {
            System.out.println(ampere + " est permis ");
            return ampere;
        } else {
            System.out.println(ampere + " non permis ");
            return 0;
        }
	}

	public int getTension() {
	
		
		return (int)tension;
	}
	//valide si la tension est permise. return la tension ou return 0.
	public int setTension(double tension) {
		boolean trouve = false;
		String [] arraysplit = CHAINE_TENSION_PERMISE.split("/");
		int index = -1;
		for (int i = 0; i < arraysplit.length; i++) {
            if (Double.compare(tension, Double.parseDouble(arraysplit[i])) == 0) {
                trouve = true;
                index = i;
                break;
            }
        }

        // print the result of the search
        if (trouve) {
            System.out.println(tension + " est permis ");
            return (int)tension;
        } else {
            System.out.println(tension + " non permis ");
            return 0;
        }
	}

	public double getPuissanceEnWatt() {
		
		return ((ampere * tension) * 0.80);
	}
	
	public double setPuissanceEnWatt(double ampere, double tension) {
		this.ampere = setAmpere(ampere);
		this.tension = setTension(tension);
		if((ampere * tension) * 0.80 >= getMaxPuissanceEnWatt()){
			return 0;
		}
		return (this.ampere * this.tension) * 0.80;
	}
	//Calcule la puissance en watts maximale
	public double getMaxPuissanceEnWatt() {
		return ((MAX_AMPERAGE * TENSION_ENTREE) * 0.80);
	}

	public int getEtat() {
	
		return etat;
	}

	
	public double getRatio() {
	
		//puissance consomme / puissance total possible
		return getPuissanceEnWatt() / getMaxPuissanceEnWatt();
	}
	
	//ajouter une puissance au disjoncteur. Calcule l'ampere avec la puissance donne.
	public void ajouterDemande(double puissance) {
		
		demandeDuCircuit.addFirst(puissance);		
		ampere = setAmpere((demandeDuCircuit.getFirst() / tension) / 0.80);

		
		if(ampere > MAX_AMPERAGE) {
			etat = ETEINT;
		}
		else if(Double.compare(puissance, 0) == 0 || Double.compare(tension, 0) == 0 || Double.compare(ampere, 0) == 0) {
			
			System.out.println("ampere ou tension egal 0");
			retirerDemande(puissance);
			etat = ETEINT;
		}
		else if(ampere < 0) {
			System.out.println("ampere negatif");
			retirerDemande(puissance);
			
		}
		else if(ampere < MAX_AMPERAGE && demandeDuCircuit.getFirst() != 0) {
			etat = ALLUME;
		}
	}
	public void retirerDemande(double puissance) {
		// Verifier si la demande peut etre retirer. -15, on retire 15. -60 on retire 60.
		Iterator<Double> iterator = demandeDuCircuit.iterator();
		{
			while (iterator.hasNext()) {
			    Double num = iterator.next();
			    if(Double.compare(Math.abs(puissance), num) == 0) {
			    	iterator.remove();
			    }
			}
		}
	}
	@Override
	public String toString() {
		return "ampere du disjoncteur: " + getAmpere()+ "\ntension du disjoncteur: " + getTension()+ "\npuissance disjoncteur: " + getPuissanceEnWatt() + "\npuissance max: " + getMaxPuissanceEnWatt() + "\netat : " + 			getEtat() + "\nLongueur d'un circuit: " + demandeDuCircuit.size();
	}
   
}
    
