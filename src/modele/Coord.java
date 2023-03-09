package modele;

import java.io.Serializable;

/**
 * Cette classe repr�sente les coordonn�es 
 * possible dans diff�rents jeux de grille (ligne-colonne).
 * 
 * Les attributs sont utilisables � l'aide des m�thodes.
 * (m�me principe que  java.awt.Dimension).
 * 
 *@author pbelisle
 *@version Copyright H2009
 *@revisite H2023
 */
public class Coord implements Serializable{

	private static final long serialVersionUID = 1L;

	/*
	 * Les items choisis par l'utilisateur 
	 */
	private int ligne;
	private int colonne;

	/**
	* Constructeur par d�faut avec la coordonn�e  (0,0)
	*/
	public Coord() {
	
		ligne = 0;
		colonne = 0;
	}


	/**
	 * Accesseur de la ligne.
	 * 
	 * @return La ligne
	 */
	public int getLigne() {
	
		return ligne;
	}

	/**
	 * Mutateur de la ligne.
	 * 
	 * @param ligne La ligne de remplacement.
	 */
	public void setLigne(int ligne) {
	
		this.ligne = ligne;
	}

	/**
	 * Accesseur de la colonne.
	 * 
	 * @return La colonne.
	 */
	public int getColonne() {
	
		return colonne;
	}

	/**
	 * Mutateur de la colonne.
	 * 
	 * @param colonne La colonne de remplacement.
	 */
	public void setColonne(int colonne) {
	
		this.colonne = colonne;
	}

	/**
	 * Construit une cha�ne avec les attributs et la retourne.
	 * 
	 * @return Une cha�ne contenant les infos de la coordonn�e.
	 */
	public String toString(){
	
		return "(" + colonne + "-" + ligne + ")";
	}
}
