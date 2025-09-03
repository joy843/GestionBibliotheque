public class Listechainee {

    Noeud  tete;
	
	//constructeur
	public Listechainee() {
		this.tete = null;
	}
	
	//Méthode d'ajout
	public void ajouter(Livre l) {
		Noeud nouveauNoeud = new Noeud(l);
		if(tete == null) {
			tete = nouveauNoeud;
			return;
		}
		
		Noeud  actuel = tete;
		while(actuel.suivant != null) {
			actuel = actuel.suivant;
		}
		actuel.suivant = nouveauNoeud;
		
	}
	
	//Méthode de suppression
	public void supprimer(Livre l) {
		if(tete == null) {
			return;
		}
		if(tete.valeur.equals(l)){
			tete = tete.suivant;
			return;
		}
		Noeud actuel = tete;
		while(actuel.suivant != null) {
			if(actuel.suivant.valeur.equals(l)) {
				actuel.suivant = actuel.suivant.suivant;
				return;
			}
			actuel = actuel.suivant;
		}
	}
	
	
	//Méthode pour rechecher un élément dans la liste
	public String rechercher(int isbn) {
		Noeud actuel = tete;
		while(actuel != null) {
			if(actuel.valeur.getIsbn() == isbn ) {
				return actuel.valeur.toString() ;
			}
			
			actuel = actuel.suivant;
		}
		
		return null;
	}
	
	//Méthode pour afficher les éléments de la liste
	public void afficher() {
		Noeud actuel = tete;
		while(actuel != null) {
			System.out.println(actuel.valeur.toString());
			actuel = actuel.suivant;
		}
	}
}
