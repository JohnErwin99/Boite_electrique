package modele;
import java.io.Serializable;

/*
* Module qui permet la gestion d'une bo�te �lectrique
* avec disjoncteurs.
*
* La boite doit d'abord �tre initialis�e au nombre d'amp�res voulus 
* ainsi que son nombre de disjoncteurs maximum possibles.
*
* Impl�mente l'interface Serializable pour la sauvegarde
* dans un fichier binaire. 
*/
public class Boite implements Serializable {
	
	/**
	 * Enl�ve un "warning". On ne g�re pas les versions.
	 */
	private static final long serialVersionUID = 1L;
	
	/*********************************
	 *  LES CONSTANTES DE LA BOITE
	 *********************************/
	// La modification a un effet direct sur l'affichage.
	public static final int MAX_DISJONCTEURS  = 60;
	public static final int NB_COLONNES  = 2;
	
	public static final int NB_LIGNES_MAX  = 
			MAX_DISJONCTEURS/NB_COLONNES;
	
	// Pour le remplissage de d�part.
    public static final double POURC_REMPLI = 0.6;
	public static final double POURC_TENSION_ENTREE = .3;
	
	public static final int AMPERAGE_MIN= 100;
	public static final int AMPERAGE_MAX = 400;
	
	/*********************************
	 *  LES ATTRIBUTS DE LA BOITE
	 *********************************/
	private int maxAmperes;
	
	// Le tableau est 2D mais il est � l'envers de la r�alit� (ligne-colonne).
	// Toutes les m�thodes qui n�cessitent la position, re�oivent 
	// une coordonn�e (colonne-ligne).  
	private Disjoncteur[][] tabDisjoncteurs;	
	private int nbDisjoncteurs;
	
	// On d�duit les disjoncteurs TENSION_ENTREE par
	// nbDisjoncteurs - nbDisjoncteursPhase  
	private int nbDisjoncteursPhase;
    Disjoncteur d;
	Coord coord;


	
	// Vous devez �crire les m�thodes manquantes.
	
	public Boite(int max_amperes) {
	
	    d = new Disjoncteur(15, 120);
		coord = new Coord();
		this.maxAmperes = max_amperes;
		this.nbDisjoncteurs = 0;
        this.nbDisjoncteursPhase = 0;
        this.tabDisjoncteurs = new Disjoncteur[2][NB_LIGNES_MAX];

	}

	/**
	 * @return La consommation totale en Watts de la bo�te.
	 */
	public double getConsommationTotalEnWatt(){
		int consommation = 0;
        for (int i = 0; i < tabDisjoncteurs.length; i++) {
            for (int j = 0; j < tabDisjoncteurs[i].length; j++) {
                if (tabDisjoncteurs[i][j] != null) {
                	consommation += tabDisjoncteurs[i][j].getAmpere() * 0.80;
                }
            }
        }
        return consommation;
	  }

	/**
	 * @return la puissance totale consomm�e sur les disjoncteurs. 
	 */
	public double puissance_total_boite(){
		int puissanceConsommee = 0;
        for (int i = 0; i < tabDisjoncteurs.length; i++) {
            for (int j = 0; j < tabDisjoncteurs[i].length; j++) {
                if (tabDisjoncteurs[i][j] != null) {
                	puissanceConsommee += tabDisjoncteurs[i][j].getPuissanceEnWatt();
                }
            }
        }
        return puissanceConsommee;
	}
	/*
	 * 
	 * @return  Le temps de support de la charge.
	 */
	public double temps_ups(){

	    // � �crire

	    return 0;
	}

	public boolean getEmplacementEncoreDisponible() {
	
	    // � �crire

		return false;
	}

	public Disjoncteur getDisjoncteur(int j, int i) {
	
	    // � �crire

		return new Disjoncteur();
	}


	public int getMaxAmperes() {
	
	    // � �crire

		return maxAmperes;
	}

	public void remplirAlea() {
	
	    // � �crire

		
	}


	public Coord getEmplacementDisponible() {	 
	//srearch algorithm, search empty space
	 int row = -1;
	 int col = -1;
	 for (int i = 0; i < coord.getLigne(); i++) {
	    for (int j = 0; j < coord.getColonne(); j++) {
	        if (tabDisjoncteurs[i][j] == null) {
	            row = i;
	            col = j;
	            break;
	        }
	    }
	    if (row != -1 && col != -1) {
	        break;
	    }
	 }
	 return coord;
	}

	public void ajouterDisjoncteur(int colonne, int ligne, Disjoncteur d) {
	
		coord.setColonne(colonne);
		coord.setLigne(ligne);
		
		// add the object to the first empty space
        if (!getEmplacementDisponible().equals(coord)) {
        	 tabDisjoncteurs[ligne][colonne] = d;
            System.out.println("Added object to row " + colonne + ", column " + ligne);
            nbDisjoncteurs++;
        } else {
            System.out.println("Array is full, could not add object");
        }
		
		

		
	}

	public void ajouterDemande(int i, int j, double demande) {
	
	    // � �crire

		
	}

	public void retirerPuissance(int i, int j, double demande) {
	
	    // � �crire

		
	}

	public int getNbDisjoncteurs() {
	
		return nbDisjoncteurs;
	}

	public int getNbDisjoncteursPhase() {
	
	    // � �crire

		return 0;
	}

	public int getNbDisjoncteursEntree() {
	
	    // � �crire3

		return 0;
	}

	public boolean getEmplacementEstVide(int colonne, int ligne) {
	
	    // � �crire

		return false;
	}
}
