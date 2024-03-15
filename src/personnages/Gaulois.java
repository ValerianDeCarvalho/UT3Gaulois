package personnages;

public class Gaulois {
	private String nom;
	private int force;
	private int nbTrophees;
	private Equipement[] trophees = new Equipement[100];
	private int effetPotion = 1;
	
	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}
	
	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "<< " + texte + " >>");
	}
	
//	private String prendreParole() {
//		return "Le gaulois " + nom + " : ";
//	}
	
	 private String prendreParole() {
		 return "Le gaulois " + nom + " : ";
	}
	
//	public void frapper(Romain romain) {
//		System.out.println(nom + " envoie un grand coup dans la machoire de " + romain.getNom());
//		romain.recevoirCoup((force/3)*effetPotion);
//	}
	 
	 public void frapper(Romain romain) {
		 System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		 Equipement troph[] = romain.recevoirCoup((force / 3) * effetPotion);
		 for (int i = 0; troph != null && i < troph.length; i++, nbTrophees++) {
			 this.trophees[nbTrophees] = troph[i];
		 }
	}
	
	public void boirePotion(int forcePotion) {
		effetPotion = forcePotion;
		parler("Merci Druide, je sens que ma force est " + effetPotion + " fois décuplée");
	}

	@Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";
	}

	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Asterix", 8);
		Romain minus = new Romain("Minus", 12);
		System.out.println(asterix);
		asterix.parler("Obelix je suis là!");
		asterix.frapper(minus);
		//asterix.boirePotion(8);
		asterix.frapper(minus);
	}
	
}
