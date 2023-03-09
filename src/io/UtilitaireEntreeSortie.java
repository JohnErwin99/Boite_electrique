package io;
/*
 * Module utilitaire permettant la saisie au clavier � l'aide de bo�te de
 * dialogue.
 *
 * @Author Pierre B�lisle
 * @version H2023
*/

import javax.swing.JOptionPane;

import modele.Disjoncteur;

public class UtilitaireEntreeSortie {


	/*
	 * Fonction locale pour saisir et valider l'amp�rage d'un disjoncteur. 
	 */
	public static int ampereValide(Double ampere) {

		//J'ai setampere qui valide les ampere deja dans la classe disjoncteur. 
		Disjoncteur d = new Disjoncteur();		
		//return (int)d.setAmpere(ampere);
		
		boolean trouve = false;
		int index = -1;
		for (int i = 0; i < d.AMPERAGES_PERMIS.length; i++) {
            if (Double.compare(ampere, d.AMPERAGES_PERMIS[i]) == 0) {	
                trouve = true;
                index = i;
                break;
            }
        }

        // print the result of the search
        if (trouve) {
            System.out.println(ampere + " est permis ");
            return (int)ampere;
        } else {
            System.out.println(ampere + " non permis ");
            return 0;
        }
	}

	/*
	 * Fonction  pour saisir et valider la tension d'un disjoncteur. 
	 */
	public static int tensionValide() {
		
		/*
		 * Strat�gie : On utilise JOptionPane pour la saisie et les constantes 
		 * pr�vues.
		 */
		
		// JOptionPane retourne un String.
		String tension;

		// Utilis� pour la validation avec les String.
		String tensionEntree =  String.valueOf(Disjoncteur.TENSION_ENTREE) ;
		String tensionPhase =  String.valueOf(Disjoncteur.TENSION_PHASE) ;

		do{
			tension = 
					JOptionPane.showInputDialog("Entrez une tension valide " + 
							Disjoncteur.CHAINE_TENSION_PERMISE);

		}while(tension != null && 
				!tension.equals(tensionEntree) &&
				!tension.equals(tensionPhase));

		return (tension== null)?0:Integer.parseInt(tension) ;
	}


	/**
	 * Saisit et valide un entier entre min et max.  La fonction retourne min - 1
	 * si l'utilisateur annule.
	 * 
	 * 
	 * @param msgSollic Le message affich�.
	 * @param min La plus petite valeur permise.
	 * @param max La plus grande valeur permise.
	 * 
	 * @return L'entier saisit ou min-1 si l'utilisateur annule.
	 */
	public static int entierValide(String msgSollic, int min, int max) {

		String entier = null;

		// Version String des valeurs re�ues.
		String minString =  String.valueOf(min) ;
		String maxString =  String.valueOf(max) ;

		do{
			entier = 
					JOptionPane.showInputDialog(msgSollic + 
							" entre " + minString + " et " + maxString);

			// V�rifier si c'est convertissable en entier.
			try{
				
				if(entier != null){
					int x = Integer.parseInt(entier);
				}
			}
			catch(Exception e){

				// Dans le cas d'une exception, on remet un entier invalide. 
				entier =  String.valueOf(min-1) ;
			}

		}while(entier != null && 
				(Integer.parseInt(entier) < min ||
						Integer.parseInt(entier) > max));

		return (entier== null)?min-1:Integer.parseInt(entier) ;
	}

	/**
	 * Saisit et valide un r�el entre min et max.  
	 * La fonction retourne Double.NaN si l'utilisateur annule.
	 * 
	 * 
	 * @param msgSollic Le message affich�.
	 * @param min La plus petite valeur permise.
	 * @param max La plus grande valeur permise.
	 * 
	 * @return L'entier saisit ou min-1 si l'utilisateur annule.
	 */
	public static double reelValide(String msgSollic) {

		String reel = null;

		reel = JOptionPane.showInputDialog(msgSollic);

		// V�rifier si c'est convertissable en r�el.
		try{

			if(reel != null){
			
				// Tentative de conversion.
				double x = Double.parseDouble(reel);
			}
		}
		catch(Exception e){

			// Dans le cas d'une exception, reel == null. 
			reel =  null;
		}
		return (reel== null)?Double.NaN:Double.parseDouble(reel) ;
	}

}