package personnages;

import java.util.Iterator;

public class Village {
	private Gaulois[] villageois;
	private Chef chef;
	private int nbVillageois = 0;
	private int nbVillageoisMaximun;
	private String nom;

	public Village(String nom, int nbVillageoisMaximun) {
		this.nom = nom;
		this.nbVillageoisMaximun = nbVillageoisMaximun;
		this.villageois = new Gaulois[nbVillageoisMaximun];
	}

	public String getNom() {
		return nom;
	}
	
	public void setChef(Chef chef) {
		this.chef = chef;
	}

	public void afficherVillageois() {
		System.out.println("Dans le village du " + chef.getNom() + " vivent les légendaires gaulois :");
		for (int i = 0; i < nbVillageois; i++) {
			System.out.println(villageois[i].getNom());
		}
		
	}
	
	public void ajouterHabitant(Gaulois gaulois){
		if (nbVillageois < nbVillageoisMaximun) {
			villageois[nbVillageois] = gaulois;
			nbVillageois = nbVillageois + 1;
		} else {
			System.out.println("Le village est plein!");
		}
	}
	
	public Gaulois trouverHabitant (int numeroVillageois) {
		return villageois[numeroVillageois];
	}
	
	public static void main(String[] args) {
		Village village = new Village("Village des irréductibles", 30);
		
		//Gaulois gaulois = village.trouverHabitant(30);
		//On sort en dehors du nombre maximun de villageois possible dans le village
		
		Chef abraracourcix = new Chef("Abraracourcix", 6, village);
		village.setChef(abraracourcix);
		Gaulois asterix = new Gaulois("Asterix", 8);
		village.ajouterHabitant(asterix);
		Gaulois obelix = new Gaulois("Obelix", 25);
		village.ajouterHabitant(obelix);
		
		village.afficherVillageois();
		//Gaulois gaulois = village.trouverHabitant(0);
		//System.out.println(gaulois);
		//On obtient null étant donné que le gaulois n'existe pas
	}
}
