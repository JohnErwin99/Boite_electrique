package modele;
import java.util.*;
public class boite_et_disjonteur_tester {

	public static void main(String[] args) {

		LinkedList<Disjoncteur> listedisjoncteur = new LinkedList<>();
		//test disjoncteur:
		Disjoncteur d = new Disjoncteur(240); 
		System.out.println("Ajoute " );
		d.ajouterDemande(14400);
		System.out.println("ampere du disjoncteur: " + d.getAmpere());
		System.out.println("tension du disjoncteur: " + d.getTension());
		System.out.println("puissance disjoncteur: " + d.getPuissanceEnWatt());
		System.out.println("etat : " + d.getEtat());
		System.out.print("Longueur d'un circuit: " + d.demandeDuCircuit.size() + "\n");
		{

			/**
			 * 
			 */
			final long serialVersionUID = 1L;
			
		};
		
		/*Boite boitedisjoncteur = new Boite(400);
		System.out.println("ampere Max de la boite electrique: " + boitedisjoncteur.getMaxAmperes());
		System.out.println("nombre de disjonteur : " + boitedisjoncteur.getNbDisjoncteurs());
 		boitedisjoncteur.getEmplacementDisponible();

		//boitedisjoncteur.ajouterDemande(0, 5, demande);
 		
		boitedisjoncteur.ajouterDisjoncteur(1, 5, d);
		System.out.println("Emplacement diponible apres l'ajout d'un disjoncteur");
 		boitedisjoncteur.getEmplacementDisponible();

		System.out.println("Ajout dune puissance aux disjoncteur ");
		boitedisjoncteur.ajouterDemande(1, 5, 3300);*/



		//Disjoncteur r = new Disjoncteur(-15, 240);

		
		/*listedisjoncteur.addFirst(d);
		//listedisjoncteur.addFirst(r);
		
		System.out.println("Ajoute " );
		d.ajouterDemande(d.setPuissanceEnWatt(15, 200));
		System.out.println("ampere du disjoncteur: " + d.getAmpere());
		System.out.println("tension du disjoncteur: " + d.getTension());
		System.out.println("puissance disjoncteur: " + d.getPuissanceEnWatt());
		System.out.println("etat : " + d.getEtat());
		System.out.print("Longueur d'un circuit: " + d.demandeDuCircuit.size() + "\n");

		
		//ajouter une puissance au disjoncteur:
		
		System.out.println("Ajoute ");
		d.ajouterDemande(d.setPuissanceEnWatt(15, 280));
		System.out.println("ampere du disjoncteur: " + d.getAmpere());
		System.out.println("tension du disjoncteur: " + d.getTension());
		System.out.println("etat : " + d.getEtat());
		System.out.println("Puissance disjoncteur : " + d.getPuissanceEnWatt());
		System.out.print("Longueur d'un circuit: " + d.demandeDuCircuit.size() + "\n");
		
		//ajouter une puissance au disjoncteur:
		System.out.println("Ajoute ");
		d.ajouterDemande(d.setPuissanceEnWatt(50, 100));
		System.out.println("ampere du disjoncteur: " + d.getAmpere());
		System.out.println("tension du disjoncteur: " + d.getTension());
		System.out.println("etat : " + d.getEtat());
		System.out.println("Puissance disjoncteur : " + d.getPuissanceEnWatt());
		System.out.print("Longueur d'un circuit: " + d.demandeDuCircuit.size() + "\n");

		
		//ajouter une puissance negative au disjoncteur:
		System.out.println("Ajoute");
		d.ajouterDemande(d.setPuissanceEnWatt(5, 240));
		System.out.println("ampere du disjoncteur: " + d.getAmpere());
		System.out.println("tension du disjoncteur: " + d.getTension());
		System.out.println("etat : " + d.getEtat());
		System.out.println("Puissance disjoncteur : " + d.getPuissanceEnWatt());
		System.out.print("Longueur d'un circuit: " + d.demandeDuCircuit.size() + "\n");

		//ajouter une puissance au disjoncteur:
		System.out.println("Ajoute");
		d.ajouterDemande(d.setPuissanceEnWatt(80, 120));
		System.out.println("ampere du disjoncteur: " + d.getAmpere());
		System.out.println("tension du disjoncteur: " + d.getTension());
		System.out.println("etat : " + d.getEtat());
		System.out.println("Puissance disjoncteur : " + d.getPuissanceEnWatt());
		System.out.print("Longueur d'un circuit: " + d.demandeDuCircuit.size());


	
		
	
		
		
		
		
		/*System.out.println("\n");
		//On ajoute un deuxiem disjoncteur
		System.out.println("ampere du disjoncteur: " + r.getAmpere());
		System.out.println("tension du disjoncteur: " + r.getTension());
		System.out.println("max puissance: " + r.getMaxPuissanceEnWatt());
		r.ajouterDemande();
		System.out.println("etat : " + r.getEtat());
		System.out.println("Puissance disjoncteur : " + r.getPuissanceEnWatt());
		System.out.println("Ratio : " + r.getRatio());
		System.out.print(listedisjoncteur.peek().getPuissanceEnWatt());
		System.out.print(r.demandeDuCircuit.peekLast());
		System.out.print(r.retirerDemande());*/


	}

}
