package modele;
import java.util.*;
public class boite_et_disjonteur_tester {

	public static void main(String[] args) {

		LinkedList<Disjoncteur> listedisjoncteur = new LinkedList<>();
		//test disjoncteur:
		Disjoncteur d = new Disjoncteur() 
		{

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			
		};
		//Disjoncteur r = new Disjoncteur(-15, 240);

		
		listedisjoncteur.addFirst(d);
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
		System.out.println("etat : " + d.getEtat());
		System.out.println("Puissance disjoncteur : " + d.getPuissanceEnWatt());
		System.out.print("Longueur d'un circuit: " + d.demandeDuCircuit.size() + "\n");
		
		//ajouter une puissance au disjoncteur:
		System.out.println("Ajoute ");
		d.ajouterDemande(d.setPuissanceEnWatt(50, 100));
		System.out.println("etat : " + d.getEtat());
		System.out.println("Puissance disjoncteur : " + d.getPuissanceEnWatt());
		System.out.print("Longueur d'un circuit: " + d.demandeDuCircuit.size() + "\n");

		
		//ajouter une puissance negative au disjoncteur:
		System.out.println("Ajoute");
		d.ajouterDemande(d.setPuissanceEnWatt(5, 240));
		System.out.println("etat : " + d.getEtat());
		System.out.println("Puissance disjoncteur : " + d.getPuissanceEnWatt());
		System.out.print("Longueur d'un circuit: " + d.demandeDuCircuit.size() + "\n");

		//ajouter une puissance au disjoncteur:
		System.out.println("Ajoute");
		d.ajouterDemande(d.setPuissanceEnWatt(80, 120));
		System.out.println("etat : " + d.getEtat());
		System.out.println("Puissance disjoncteur : " + d.getPuissanceEnWatt());
		System.out.print("Longueur d'un circuit: " + d.demandeDuCircuit.size());


	
		
	
		
		
		
		
		/*System.out.println("\n");
		//On ajoute une deuxieme puissance au meme Disjoncteur
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
