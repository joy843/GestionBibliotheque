public class GestionnaireEmprunt {

    //Déclaration des variables d'instances
		private int nbrMaxEmprunt;				//Nombre maximum d'emprunt possible
		private Emprunt listeEmprunt[];			//Tableau de tous les emprunts effectués
		private int nbrEmprunt;					//Nombre de d'emprunt effectué
		
		//Constructeur
		public GestionnaireEmprunt(int nb) {
			this.nbrMaxEmprunt = nb;
			this.listeEmprunt = new Emprunt[nb];
			this.nbrEmprunt = 0;
		}
		
		//Accesseur
		public Emprunt[] getListeLivre() {
			return this.listeEmprunt;
		}
		public int getnbrEmprunt() {
			return this.nbrEmprunt;
		}
		
		
		public void ajouterEmprunt(Emprunt p) {
			this.listeEmprunt[this.nbrEmprunt++] = p;		//ajout dans le tableau des Emprunts
			System.out.println("... emprunt effectué ");
		}
		
		public void RendreLivre(int id, int isbn) {
			int index = -1;
			for (int i=0; i< this.nbrEmprunt; i++) {
				if(this.listeEmprunt[i].getIsbnDuLivre() == isbn && this.listeEmprunt[i].getIdUtilisateur() == id) {
					index = i;
				}
			}
			if(index < 0 ) {
				System.out.println("... Le livre n existe pas dans les emprunts ");
			}
			else {
				this.nbrEmprunt--;
				//Décaler les éléments du tableau vers la gauche à partir de l'indice du produit à supprimer
				for (int i=index; i< this.nbrEmprunt; i++) {
					this.listeEmprunt[i] = this.listeEmprunt[i+1];
				}
				
				System.out.println("... Livre rendu ");
				
			}
			
		}

}
