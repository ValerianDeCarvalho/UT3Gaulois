package personnages;

public class Romain {
	private String nom;
	private String texte;
	private int force;
	private int nbEquipement = 0;
	private boolean vainqueur;
	private Equipement[] equipements = new Equipement[2];
	
	public Romain(String nom, int force) {
		this.nom = nom;
		assert force > 0;
		this.force = force;
	}
	
	public String getNom() {
		return nom;
	}
	
	public int getForce() {
		return force;
	}

	public boolean isVainqueur() {
		return vainqueur;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "<< " + texte + " >>");
	}

	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}
	
//	public void recevoirCoup(int forceCoup) {
//		assert (force > 0);
//		int x = force;
//		force -= forceCoup;
//		if (force > 0) {
//			parler("Aïe");
//		}else{
//			parler("J'abandonne");
//		}
//		assert (x > force);
//	}
	
	public void sEquiper(Equipement equipement) {
		switch(nbEquipement) {
		case 2:
			System.out.println("Le soldat " + nom + " est déjà bien protégé!");
			break;
			
		case 1:
			if (equipements[0] == equipement){
				System.out.println("Le soldat " + nom + " possède déjà " + equipement.toString());
				break;
			}else{
				equipements[1]=equipement;
				nbEquipement=nbEquipement+1;
				System.out.println("Le soldat " + getNom() + " s'équipe avec un " + equipement.toString());
				break;
			}
			
		case 0:
			equipements[0]=equipement;
			nbEquipement=nbEquipement+1;
			System.out.println("Le soldat " + getNom() + " s'équipe avec un " + equipement.toString());
			break;
		}
	}
	
	public Equipement[] recevoirCoup(int forceCoup) {
		 Equipement[] equipementEjecte = null;
//		 précondition
		 assert force > 0;
		 int oldForce = force;
		 forceCoup = calculResistanceEquipement(forceCoup);
		 force -= forceCoup;
//		 if (force > 0) {
//			 parler("Aïe");
//		 } else {
//			 equipementEjecte = ejecterEquipement();
//			 parler("J'abandonne...");
//		 }
		 if (force==0) {
			 parler("Aïe");
		 } else {
			 equipementEjecte = ejecterEquipement();
			 parler("J'abandonne...");
		}
		// post condition la force a diminuée
		if (force == oldForce) {
			parler("Ahah je suis invincible!");
			vainqueur = true;
		}
		assert force < oldForce;
		return equipementEjecte;
	}
	
	private int calculResistanceEquipement(int forceCoup) {
		 texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
		 int resistanceEquipement = 0;
		 if (nbEquipement!=0) {
			 texte += "\nMais heureusement, grace à mon équipement sa force est diminué de ";
			 for (int i = 0; i < nbEquipement; i++) {
				 if (equipements[i] != null && equipements[i].equals(Equipement.BOUCLIER)) {
					 resistanceEquipement += 8;
				 } else {
					 System.out.println("Equipement casque");
					 resistanceEquipement += 5;
				 }
			 }
			 texte += resistanceEquipement + "!";
		 }
		 parler(texte);
		 forceCoup-= resistanceEquipement;
		 if (forceCoup < 0) {
			 forceCoup = 0;
		 }
		 return forceCoup;
	}
	
	private Equipement[] ejecterEquipement() {
		 Equipement[] equipementEjecte = new Equipement[nbEquipement];
		 System.out.println("L'équipement de " + nom + " s'envole sous la force du coup.");
		 //TODO
		 int nbEquipementEjecte = 0;
		 for (int i = 0; i < nbEquipement; i++) {
			 if (equipements[i] != null) {
				 equipementEjecte[nbEquipementEjecte]=equipements[i];
				 nbEquipementEjecte++;
				 equipements[i] = null;
			 }
		 }
		 return equipementEjecte;
	}
	
	public static void main(String[] args) {
		Romain minus = new Romain("Minus",6);
		minus.parler("Je suis Minus fils de Bardus");
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
		minus.recevoirCoup(6);
	}
	
}