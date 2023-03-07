package modele;
import java.util.*;
public class boite_et_disjonteur_tester {

	public static void main(String[] args) {

		LinkedList<Disjoncteur> listedisjoncteur = new LinkedList<>();
		//test disjoncteur:
		
		Disjoncteur d = new Disjoncteur(120); 
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
		
		Boite boitedisjoncteur = new Boite(d);
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

		

	}

}
