package modele;
import java.io.Serializable;
import java.util.*;

import io.UtilitaireEntreeSortie;

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
	private int amperetotaledelaboite = 0;
	
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
	
	public Boite(int maxAmperes) {
		this.maxAmperes = maxAmperes;
		this.nbDisjoncteurs = 0;
        this.nbDisjoncteursPhase = 0;
        this.tabDisjoncteurs = new Disjoncteur[NB_LIGNES_MAX][NB_COLONNES];

		coord = new Coord();
	}

	/**
	 * @return La consommation totale en Watts de la bo�te.
	 */
	public double getConsommationTotalEnWatt(){
		int consommation = 0;
        for (int i = 0; i < NB_LIGNES_MAX; i++) {
            for (int j = 0; j < NB_COLONNES; j++) {
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
		 for (int i = 0; i < tabDisjoncteurs.length; i++) {
		    for (int j = 0; j < tabDisjoncteurs[i].length; j++) {
		        if (tabDisjoncteurs[i][j] != null) {
		        	return false;
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

	public Disjoncteur getDisjoncteur(int colonne, int ligne) {
		if(!getEmplacementEstVide(colonne, ligne)) {
			//for (int i = 0; i < ligne; i++) {
			    //for (int j = 0; j < tabDisjoncteurs[i].length; j++) {
			        //if (tabDisjoncteurs[i][j] != null) {
			try {
				return tabDisjoncteurs[ligne][colonne];

			}catch(Exception e) {
				
			}
			        //}
			        //else {
			       // }
			    //}
			   // if (ligne != -1 && colonne != -1) {
			        //break;
			   // }
			 //}
		}
		else {
			System.out.println("Il n'y a rien dans cet emplacement");
		}
		
		 return new Disjoncteur();
	}


	public int getMaxAmperes() {

// � �crire
		
		return maxAmperes;
	}

	//method qui remplit la boit de disjoncteur aleatoirement?
	public void remplirAlea() {
		 //UtilitaireEntreeSortie u = new UtilitaireEntreeSortie();

	    for(int i = 0; i < tabDisjoncteurs.length; i++) {
	    	for(int j = 0; j < tabDisjoncteurs[i].length; j++) {
	    		//remplit aleatoirement la premiere colonne de 240V
	    		if(getEmplacementEstVide(j, i) == true && j == 0) {
	    			tabDisjoncteurs[i][j] = new Disjoncteur(240);
	    		}
	    		else if(getEmplacementEstVide(j, i) == true && j == 1) {
	    			tabDisjoncteurs[i][j] = new Disjoncteur(120);
	    		}
	    		else 
	    			System.out.println("not empty");
	    	}
	    }

		
	}


	public Coord getEmplacementDisponible() {		
		Coord emplacementVide = new Coord();
		//srearch algorithm, search empty space
		 for (int i = 0; i < tabDisjoncteurs.length; i++) {
		    for (int j = 0; j < tabDisjoncteurs[i].length; j++) {
		        if (tabDisjoncteurs[i][j] != null) {
		        }
		        else {
					 emplacementVide.setLigne(i);
					 emplacementVide.setColonne(j);
					 //System.out.println("Space available " + emplacementVide.getLigne() + " " + 						emplacementVide.getColonne());
					 //coordoneeVide.add(emplacementVide);
					 return emplacementVide;
		        }
		    }
		 }
		 return emplacementVide;
		}

	public void ajouterDisjoncteur(int colonne, int ligne, Disjoncteur d) {	
		//utiliser classe coord pour les coordonnes de la boite
		Coord ajouterDisjoncteur = new Coord();
		ajouterDisjoncteur.setLigne(ligne);
		ajouterDisjoncteur.setColonne(colonne);
		
		if(coord.getColonne() > NB_COLONNES || coord.getLigne() > NB_LIGNES_MAX) {
			System.out.print("out of bounds\n");
		}
		// on aoute lobjet a la position voulu et on regarde si l'emplacement est vide avant d'ajouter.
		if(!getEmplacementEstVide(ajouterDisjoncteur.getColonne(), ajouterDisjoncteur.getLigne())) {
			System.out.println("L'emplacement n'est pas disponible");
		}
		else {
					
			tabDisjoncteurs[ajouterDisjoncteur.getColonne()][ajouterDisjoncteur.getLigne()] = d;
		}
	}
	public double getRatio(int colonne, int ligne) {
		Coord ajouterDemande = new Coord();
		ajouterDemande.setLigne(ligne);
		ajouterDemande.setColonne(colonne);
		return tabDisjoncteurs[ajouterDemande.getLigne()][ajouterDemande.getColonne()].getRatio();

	}

	public void ajouterDemande(int colonne, int ligne, double demande) {
		Coord ajouterDemande = new Coord();
		ajouterDemande.setLigne(ligne);
		ajouterDemande.setColonne(colonne);
		
		if(coord.getColonne() > NB_COLONNES || coord.getLigne() > NB_LIGNES_MAX) {
			System.out.print("out of bounds\n");
		}
		// on aoute lobjet a la position voulu et on regarde si l'emplacement est vide. si est vide on ajouter la demande. 
		if(!getEmplacementEstVide(ajouterDemande.getColonne(), ajouterDemande.getLigne())) {
			for (int i = 0; i < tabDisjoncteurs.length; i++) {
			    for (int j = 0; j < tabDisjoncteurs[i].length; j++) {
			        if (tabDisjoncteurs[i][j] != null) {
						tabDisjoncteurs[i][j].ajouterDemande(demande);
			        }
			        else if(tabDisjoncteurs[i][j].setAmpere((demande / tabDisjoncteurs[i][j].getTension()) * 0.80) == 0) {
						System.out.println("Il n'y a rien dans cet emplacement");
			        }
			        else {
						System.out.println("Il n'y a rien dans cet emplacement");
			        }
			    }
			 }		
		}
		
	}

	public void retirerPuissance(int colonne, int ligne, double demande) {
	
		Coord ajouterDemande = new Coord();
		ajouterDemande.setLigne(ligne);
		ajouterDemande.setColonne(colonne);
		
		if(coord.getColonne() > NB_COLONNES || coord.getLigne() > NB_LIGNES_MAX) {
			System.out.print("out of bounds\n");
		}
		
		// on aoute lobjet a la position voulu et on regarde si l'emplacement est vide. si est vide on ajouter la demande. 
		if(!getEmplacementEstVide(ajouterDemande.getColonne(),ajouterDemande.getLigne())) {
					
			tabDisjoncteurs[ajouterDemande.getLigne()][ajouterDemande.getColonne()].retirerDemande(demande);
		}
		else {
			System.out.println("Il n'y a pas de disjoncteurs");
		}
	}

	public int getNbDisjoncteurs() {
		for (int i = 0; i < tabDisjoncteurs.length; i++) {
		    for (int j = 0; j < tabDisjoncteurs[i].length; j++) {
		        if (tabDisjoncteurs[i][j] != null) {
		        	nbDisjoncteurs++;
		        }
		    }
		 }
		return nbDisjoncteurs;
	}

	public int getNbDisjoncteursPhase() {
	
		nbDisjoncteursPhase = 0;
		for (int i = 0; i < tabDisjoncteurs.length; i++) {
			for(int j = 0; j < tabDisjoncteurs[j].length; j++) {
				if (tabDisjoncteurs[i][j].getTension() == 120) {
					nbDisjoncteursPhase++;
				}
			}
		 }
		return nbDisjoncteursPhase;
		
	}

	public int getNbDisjoncteursEntree() {
	
		return getNbDisjoncteurs() - getNbDisjoncteursPhase();
	}

	public boolean getEmplacementEstVide(int colonne, int ligne) {
	
		coord = new Coord();
		coord.setLigne(ligne);
		coord.setColonne(colonne);
		
		try{
			if(coord.getColonne() > NB_COLONNES || coord.getLigne() > NB_LIGNES_MAX) {
				System.out.print("out of bounds\n");
				return false;

			}
			if(tabDisjoncteurs[coord.getLigne()][coord.getColonne()] == null)
				return true;
		}catch(Exception e) {
			
		}
		return false;
	}
	public boolean isAmpereSupMaxAmpere() {
		for(int i = 0; i < tabDisjoncteurs.length; i++) {
			for(int j = 0; j < tabDisjoncteurs[i].length; j++) {
				amperetotaledelaboite += tabDisjoncteurs[i][j].getAmpere();
				
			}
		}
		if(amperetotaledelaboite > maxAmperes) {
			return true;
		}
		return false;
	}
	@Override
	public String toString() {
		return coord.getLigne() + " : " + coord.getColonne();
	}
}
