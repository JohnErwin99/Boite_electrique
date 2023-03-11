package programme;

import gui.Constantes;
import gui.UtilitaireAffichageBoite;
import gui.UtilitaireGestionMenu;
import io.UtilitaireEntreeSortie;
import modele.Boite;

/**
* Dans le cadre du tp1 inf111, il s'agit de simuler la gestion d'une 
* bo�te �lectrique avec des disjoncteurs.
*   
* Il est possible d'ajouter des disjoncteurs, des appareils sur un circuit, de
* sauvegarder et de r�cup�rer des bo�tes d�crites dans la classe du m�me 
* nom. 
*
* Le projet ne contient qu'une seule bo�te � la fois.
*
* (voir �nonc� du travail pour les d�tails).
* 
* @author Pierre B�lisle
* @version Copyright H2023
*
*/

public class DemarrerBoiteDisjoncteur {

	/*
	 * Strat�gie globale : On utilise les SP des diff�rents modules pour obtenir  
	 * une boite electrique. 
	 * 
	 * C'est ici qu'on g�re la boucle principale qui se termine si l'utilisateur 
	 * quitte ou s'il r�ussit.
	 * 
	 * De plus, on obtient s'il y a eu un clique sur une option de menu, alors
	 *  on d�l�gue au module UtilitaireGestionMenu pour la distribution des 
	 *  t�ches.
	 */
	public static void main(String[] args) {
						
		// Obtenir un amp�rage pour la bo�te.
		int max_amperes = 
			UtilitaireEntreeSortie.entierValide("Entrez l'amp�rage de la bo�te",
						Boite.AMPERAGE_MIN + 1,
						Boite.AMPERAGE_MAX + 1);

		// Si l'utilisateur n'a pas annul�.
		if(max_amperes != Boite.AMPERAGE_MIN - 1){
			
			// R�cup�rer une bo�te neuve.
			Boite boite = new Boite(max_amperes);

			// is � vrai si l'utilisateur quitte.
			boolean quitter = false;


			// Sert � obtenir une option s�lectionn�e.
			String option;				

			/*Remplit la bo�te avec des disjoncteurs au hasard.
			 *  
			 * NOTE : Peut �tre demand� � l'utilisateur �ventuellement sert
			 *        pour simplifier le travail.
			 */
			boite.remplirAlea();

			// Le programme se termine si l'utilisateur appuie sur le bouton
			// QUITTER ou sur le X. 
			do
			{
				UtilitaireAffichageBoite.afficherBoite(boite);

				// Boucle qui attend que l'utilisateur appuie sur un des boutons.
				while(!UtilitaireAffichageBoite.optionMenuEstCliquee()){
					
					//Laisse le temps d'intercepter le clic.
					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				};

				// R�cup�ration de l'option s�lectionn�e pour �viter pls appels 
				// � l'accesseur.
				option = UtilitaireAffichageBoite.getOptionMenuClique();

				// Gestion des options du menu.

				// D�marrer le bon SP selon l'option
				// Selon la version de Java, il est possible 
				// d'utiliser switch-case.
				if(option.equals(Constantes.OPTIONS_MENU
						[Constantes.AJOUTER_DISJONCTEUR])){

					UtilitaireGestionMenu.ajouterDisjoncteur(boite);
				}

				else if(option.equals(Constantes.OPTIONS_MENU
						[Constantes.AJOUTER_APPAREIL])){
					UtilitaireGestionMenu.ajouterDemande(boite);
				}

				else if(option.equals(Constantes.OPTIONS_MENU
						[Constantes.RECUPERER])){

					// On essaie dans une autre boite car si null, on veut garder la
					// la boite qui est ouverte.
					Boite boiteTmp = UtilitaireGestionMenu.recupererBoite();

					if(boiteTmp != null){
						boite = boiteTmp;
					}
				}

				else if(option.equals(Constantes.OPTIONS_MENU
						[Constantes.SAUVEGARDER])){

					UtilitaireGestionMenu.sauvegarderBoite(boite);

				}

				if(option.equals(Constantes.OPT_QUITTER)){
					quitter = UtilitaireGestionMenu.veutSortir(boite);
				}

			}while(!quitter );
		}
		System.exit(0);


	}
}