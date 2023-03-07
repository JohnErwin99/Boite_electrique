package modele;
import java.io.Serializable;
import java.util.*;

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
	
	public static final int AMPERAGE_MIN = 100;
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
	ArrayList<Coord> coordoneeVide  = new ArrayList<>();


	
	// Vous devez �crire les m�thodes manquantes.
	
	public Boite(Disjoncteur d) {
		this.nbDisjoncteurs = 0;
        this.nbDisjoncteursPhase = 0;
        this.tabDisjoncteurs = new Disjoncteur[NB_LIGNES_MAX][NB_LIGNES_MAX];
        
        this.d = d;
		coord = new Coord();
	}

	/**
	 * @return La consommation totale en Watts de la bo�te.
	 */
	public double getConsommationTotalEnWatt(){
		int consommation = 0;
        for (int i = 0; i < tabDisjoncteurs.length; i++) {
            for (int j = 0; j < tabDisjoncteurs[i].length; j++) {
                if (tabDisjoncteurs[i][j] != null) {
                	consommation += tabDisjoncteurs[i][j].getPuissanceEnWatt();
                }
            }
        }
        return consommation;
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
	
		//srearch algorithm, search empty space
		 int ligne = -1;
		 int colonne = -1;
		 for (int i = 0; i < NB_LIGNES_MAX; i++) {
		    for (int j = 0; j < NB_COLONNES; j++) {
		        if (tabDisjoncteurs[i][j] != null) {
		        }
		        else {
		        	return true;
		        }
		    }
		    if (ligne != -1 && colonne != -1) {
		        break;
		    }
		 }
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

	//method qui remplit la boit de disjoncteur aleatoirement?
	public void remplirAlea() {
	
	    // � �crire

		
	}


	public Coord getEmplacementDisponible() {		
		
		//srearch algorithm, search empty space
		 int ligne = -1;
		 int colonne = -1;
		 for (int i = 0; i < NB_LIGNES_MAX; i++) {
		    for (int j = 0; j < NB_COLONNES; j++) {
		        if (tabDisjoncteurs[i][j] != null) {
		        }
		        else {
		        	Coord emplacementVide = new Coord();
					 emplacementVide.setLigne(i);
					 emplacementVide.setColonne(j);
					 System.out.println("Space available " + emplacementVide.getLigne() + " " + 						emplacementVide.getColonne());
					 coordoneeVide.add(emplacementVide);
		        }
		    }
		    if (ligne != -1 && colonne != -1) {
		        break;
		    }
		 }
		 return coordoneeVide.get(0);
		}

	public void ajouterDisjoncteur(int colonne, int ligne, Disjoncteur d) {	
		//utiliser classe coord pour les coordonnes de la boite
		Coord ajouterDisjoncteur = new Coord();
		ajouterDisjoncteur.setLigne(ligne);
		ajouterDisjoncteur.setColonne(colonne);
		
		// on aoute lobjet a la position voulu et on regarde si l'emplacement est vide avant d'ajouter.
		if(coordoneeVide.isEmpty()) {
			System.out.println("La boit est vide");
		}
		else {
			for(int i = 0; i < coordoneeVide.size(); i++) {
				if(coordoneeVide.get(i).getLigne() == ajouterDisjoncteur.getLigne() 
						&& coordoneeVide.get(i).getColonne() == ajouterDisjoncteur.getColonne()) 
				{
					//a enlever
					//System.out.println("Position: " + coordoneeVide.get(i).getLigne() + " : " + 					//coordoneeVide.get(i).getColonne() );
					
					//ajouter le disjoncteur a la boite apres vlidation
					tabDisjoncteurs[ajouterDisjoncteur.getLigne()][ajouterDisjoncteur.getColonne()] = d;
				}
			}
		}
	
	}

	public void ajouterDemande(int colonne, int ligne, double demande) {
		Coord ajouterDemande = new Coord();
		ajouterDemande.setLigne(ligne);
		ajouterDemande.setColonne(colonne);
		
		if(coordoneeVide.isEmpty()) {
			System.out.println("La boite est vide");
		}
		else {
			for(int i = 0; i < coordoneeVide.size(); i++) {
				//verifie si la position a ajouter la demande est vide ou pas
				if(coordoneeVide.get(i).getLigne() == ajouterDemande.getLigne() 
						&& coordoneeVide.get(i).getColonne() == ajouterDemande.getColonne()) 
				{
					System.out.println("Position: " + coordoneeVide.get(i).getLigne() + " : " + 					coordoneeVide.get(i).getColonne() );
					
					//ajouter le disjoncteur a la boite apres vlidation
					//information du disjoncteur, A ENLEVER
					d.ajouterDemande(demande);
					System.out.println(d.toString());

				}
				else {
					System.out.println("Position: " + coordoneeVide.get(i).getLigne() + " : " + 					coordoneeVide.get(i).getColonne()+ " EST NULLE, rien ne se passe..." );
				}
			}
		}
		
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
