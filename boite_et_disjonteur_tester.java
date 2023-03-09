package modele;
import java.util.*;
import modele.Disjoncteur;
import io.UtilitaireFichier;

public class boite_et_disjonteur_tester {
	
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		//Les puissance valide selon les ampere valides sont si dessous:
		//(15*120*0.80, 20*120*0.80, 40*120*0.80, 50*120*0.80, MAX_AMPERAGE*120*0.80
		//(15*240*0.80, 20*240*0.80, 40*240*0.80, 50*240*0.80, MAX_AMPERAGE*240*0.80
		
		//demande valide Tension a 120v: 1440, 1920, 3840, 4800, 5760 
		//demande valide Tension a 240v: 2880, 3840, 7680, 9600, 11520 
		
		LinkedList<Disjoncteur> listedisjoncteur = new LinkedList<>();
		Boite boitedisjoncteur = new Boite(60*60);
		Coord coord = new Coord();

		//test disjoncteur:
		
        int choice = -1;
        
        while (choice != 0) {
            System.out.println("Please enter the number to select an option, or 0 to exit:");
            System.out.println("1. Verifier emplacement disponible");
            System.out.println("2. Verifier emplacement disponible a une coordonne fixe");
            System.out.println("3. Ajouter un disjoncteur a la boite a une coorddonne fixe");
            System.out.println("4. Ajoute une demande a un disjoncteurs");
            System.out.println("5. Retirer une demande a un disjoncteurs");
            System.out.println("6. Exporter la boite dans un fichier texte");
            System.out.println("7. Voir les donnees d'un disjoncteur");
            System.out.println("8. Voir les donnees d8u fichier");


            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            
            switch (choice) { 
            
            	case 1:
        		System.out.println("Le prochain emplacement disponible se trouve a " + "ligne: " + 						boitedisjoncteur.getEmplacementDisponible().getLigne() + ": colonne:  " 
            					+ boitedisjoncteur.getEmplacementDisponible().getColonne() + "\n\n"); 
                    break;
            	case 2:
            		coord = new Coord();
            		
            		System.out.println("Entrer la ligne ou verifier la dispo");
            		int insererligne = scanner.nextInt();
            		coord.setLigne(insererligne);
            		
            		System.out.println("Entrer la colonne ou ou verifier la dispo");
            		int inserercolonne = scanner.nextInt();
            		coord.setColonne(inserercolonne);  
            		
            		System.out.println("Emplacement diponible? " + 					boitedisjoncteur.getEmplacementEstVide(coord.getLigne(), coord.getColonne() )+ "\n\n");
            		break;
                case 3:
            		coord = new Coord();
            		System.out.println("Entrer la ligne ou inserer un disjoncteur");
            		int insererl = scanner.nextInt();
            		coord.setLigne(insererl);
            		
            		System.out.println("Entrer la colonne ou inserer un disjoncteur");
            		int insererc = scanner.nextInt();
            		coord.setColonne(insererc);  
            		
            		System.out.println("Entrer le nombre de volts(120V ou 2400V");
            		int volt = scanner.nextInt();

            		boitedisjoncteur.ajouterDisjoncteur(coord.getLigne(), coord.getColonne(), new 					Disjoncteur(volt));
            		break;
               
                case 4:
                	coord = new Coord();
            		System.out.println("Entrer la ligne ou inserer la demande du disjoncteur");
            		int insert = scanner.nextInt();
            		coord.setLigne(insert);
            		
            		System.out.println("Entrer la colonne ou inserer la demande du disjoncteur");
            		int insertc = scanner.nextInt();
            		coord.setColonne(insertc); 
            		
            		System.out.println("Entrer la demande du disjoncteur, les demandes en watts valides sont 					representer comme suit:\n"
            				+ "		//demande valide Tension a 120v: 1440W, 1920W, 3840W, 4800W, 5760W \r\n"
            				+ "		//demande valide Tension a 240v: 2880W, 3840W, 7680W, 9600W, 11520W ");
            		int demande = scanner.nextInt();
            		coord.setColonne(insertc);  
            		
            		boitedisjoncteur.getDisjoncteur(coord.getLigne(), coord.getColonne()).ajouterDemande(demande);
            		System.out.println("Disjoncteur data " + boitedisjoncteur.getDisjoncteur(coord.getLigne(), coord.getColonne()).toString() + "\n\n");
            		
                    break;
                case 5:
                	coord = new Coord();
            		System.out.println("Entrer la ligne ou inserer la demande du disjoncteur");
            		int insert1 = scanner.nextInt();
            		coord.setLigne(insert1);
            		
            		System.out.println("Entrer la colonne ou inserer la demande du disjoncteur");
            		int insertc1 = scanner.nextInt();
            		coord.setColonne(insertc1); 
            		System.out.println("Entrer la demande du disjoncteur, les demandes en watts valides sont 					representer comme suit:\n"
            				+ "		//demande valide Tension a 120v: 1440W, 1920W, 3840W, 4800W, 5760W \r\n"
            				+ "		//demande valide Tension a 240v: 2880W, 3840W, 7680W, 9600W, 11520W ");
            		int demande1 = scanner.nextInt();
            		
                	boitedisjoncteur.retirerPuissance(coord.getLigne(), coord.getColonne(), demande1);
                	break;
                case 6:
                	UtilitaireFichier exporterdansfichier = new UtilitaireFichier();
                	
                	coord = new Coord();
            		System.out.println("Entrer la ligne ou inserer la demande du disjoncteur");
            		int insert2 = scanner.nextInt();
            		coord.setLigne(insert2);
            		
            		System.out.println("Entrer la colonne ou inserer la demande du disjoncteur");
            		int insertc2 = scanner.nextInt();
            		coord.setColonne(insertc2); 
            		
                	exporterdansfichier.sauvegarderDsFichierTexte(boitedisjoncteur, "boite.txt", coord.getLigne(), coord.getColonne());
                	break;
                case 7: 
                	coord = new Coord();
                	System.out.println("Voir les donnes de la boite et la puissance");
                	System.out.println("Entrer la ligne du disjoncteur a voir une puissance");
            		int voirligne = scanner.nextInt();
            		coord.setLigne(voirligne);
            		
            		System.out.println("Entrer la colonne du disjoncteur a voir une puissance");
            		int voircol = scanner.nextInt();
            		coord.setColonne(voircol); 
            		
            		System.out.println(boitedisjoncteur.getDisjoncteur(coord.getLigne(), coord.getColonne()).toString());
            		break;
                case 8: 
                	System.out.println("Ouvrir fichier texte de la boite");
            		
                	UtilitaireFichier ouvrirdansfichier = new UtilitaireFichier();
                	ouvrirdansfichier.recupererBoite("boite.txt");
                	System.out.println("\n\n");

            		break;
                default:
                    System.out.println("Invalid choice, please try again");
                    break;
            }
        }
        
        scanner.close();
	
		//System.out.println("Ajoute " );
		//lorsquune demande est ajouter en watts(puissance), il faut calculer lampere et verifier si lampere est valide. 
		//Les puissance valide selon les ampere valides sont si dessous:
		//(15*120*0.80, 20*120*0.80, 40*120*0.80, 50*120*0.80, MAX_AMPERAGE*120*0.80
		//(15*240*0.80, 20*240*0.80, 40*240*0.80, 50*240*0.80, MAX_AMPERAGE*240*0.80
		
		//demande valide Tension a 120v: 1440, 1920, 3840, 4800, 5760 
		//demande valide Tension a 240v: 2880, 3840, 7680, 9600, 11520 

		/*d.ajouterDemande(15000);
		System.out.println("ampere du disjoncteur: " + d.getAmpere());
		System.out.println("tension du disjoncteur: " + d.getTension());
		System.out.println("puissance disjoncteur: " + d.getPuissanceEnWatt());
		System.out.println("puissance max: " + d.getMaxPuissanceEnWatt());
		System.out.println("etat : " + d.getEtat());
		System.out.print("Longueur d'un circuit: " + d.demandeDuCircuit.size() + "\n");
		
		d.ajouterDemande(1440);
		System.out.println("ampere du disjoncteur: " + d.getAmpere());
		System.out.println("tension du disjoncteur: " + d.getTension());
		System.out.println("puissance disjoncteur: " + d.getPuissanceEnWatt());
		System.out.println("puissance max: " + d.getMaxPuissanceEnWatt());

		System.out.println("etat : " + d.getEtat());
		System.out.print("Longueur d'un circuit: " + d.demandeDuCircuit.size() + "\n");*/

		{

			/**
			 * 
			 */
			final long serialVersionUID = 1L;
			
		};
		
		/*Boite boitedisjoncteur = new Boite(d, 400);
		Coord coord = new Coord();
		coord.setLigne(5);
		coord.setColonne(1);

		System.out.println("ampere Max de la boite electrique: " + boitedisjoncteur.getMaxAmperes());
		System.out.println("nombre de disjonteur : " + boitedisjoncteur.getNbDisjoncteurs());
		System.out.println("consommaiton totale : " + boitedisjoncteur.getConsommationTotalEnWatt());
 		boitedisjoncteur.getEmplacementDisponible(); 		
 		
		boitedisjoncteur.ajouterDisjoncteur(coord.getColonne(), coord.getLigne(), d);
		System.out.println("Emplacement disponible " + coord.getLigne() + " : " + coord.getColonne());
		
 		//boitedisjoncteur.getEmplacementDisponible();

		System.out.println("Ajout dune puissance aux disjoncteur ");
		boitedisjoncteur.ajouterDemande(1, 5, 1920);
		System.out.println("consommation totale : " + boitedisjoncteur.getConsommationTotalEnWatt());
		System.out.println("emplacement encore disponible? : " + boitedisjoncteur.getEmplacementEncoreDisponible());
		
		
		*/
		
		
		//utilitaireFichier
		/*UtilitaireFichier ecrireboite = new UtilitaireFichier();
		ecrireboite.sauvegarderDsFichierTexte(boitedisjoncteur, "test.txt");
		ecrireboite.recupererBoite("test.txt");*/

		

	}

}
