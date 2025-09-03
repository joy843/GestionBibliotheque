public class Stock {

    //Déclaration des variables d'instances
	private int nbrMaxLivre;				//Nombre maximum de livre dans le stock
	private Livre listeLivre[];			//Tableau de tous les livres
	private int nbrLivre;					//Nombre de livre dans le stock
	
	//Constructeur
	public Stock(int nb) {
		this.nbrMaxLivre = nb;
		this.listeLivre = new Livre[nb];
		this.nbrLivre = 0;
	}
	
	//Accesseur
	public Livre[] getListeLivre() {
		return this.listeLivre;
	}
	public int getNbrLivre() {
		return this.nbrLivre;
	}
	
	//Méthode d'ajout d'un livre
	public void ajouterLivre(Livre p) {
		this.listeLivre[this.nbrLivre++] = p;		//ajout dans le tableau de produits
		System.out.println("... Ajout effectué ");
	}
	
	//Méthode de recherche d'un livre
	public Livre rechercherLivre(int isbn) {
		for (int i=0; i< this.nbrLivre; i++) {
			if(this.listeLivre[i].getIsbn() == isbn) {
				return this.listeLivre[i];
			}
		}
		return null;
	}
	
	//Méthode d'affichage d'un livre
	public void afficherLivre() {
		for (int i=0; i< this.nbrLivre; i++) {
			System.out.println(this.listeLivre[i].toString());
			
		}
			
			
	}
	
	
	//Supprimer un produit
	public void supprimerProduit(int isbn) {
		int index = -1;
		for (int i=0; i< this.nbrLivre; i++) {
			if(this.listeLivre[i].getIsbn() == isbn) {
				index = i;
			}
		}
		if(index < 0 ) {
			System.out.println("... Le livre n existe pas dans le stock ");
		}
		else {
			this.nbrLivre--;
			//Décaler les éléments du tableau vers la gauche à partir de l'indice du produit à supprimer
			for (int i=index; i< this.nbrLivre; i++) {
				this.listeLivre[i] = this.listeLivre[i+1];
			}
			System.out.println("... Suppression effectuée ");
			
		}
		
	}
	
	
	//Méthode d'affichage des livres en rupture de stock
		public void produitEnRupture() {
			for (int i=0; i< this.nbrLivre; i++) {
				if(this.listeLivre[i].getnombreExemplaire() == 0) {
					 System.out.println(this.listeLivre[i].toString());
				}
				
				
			}
				
				
		}
}
