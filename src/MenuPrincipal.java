import java.util.Scanner;
import java.util.Stack;

public class MenuPrincipal {

    public static void triParTitre(Livre[] t) {
		int swapindex;
		Livre temp;
		for(int k=0; k< t.length ; k++) {
			
			swapindex = -1;
			for(int i=k; i<t.length; i++) {
				
				if(t[i].getTitre().compareTo(t[k].getTitre()) >0) {
					
					swapindex = i;
				}
			}
			
			if(swapindex != -1) {
				temp = t[k];
				t[k] = t[swapindex];
				t[swapindex] = temp;
			}
			 
		}
		
		
		
		
	}
	
	
	
	public static int rechercheBinaire(Livre[] tableau, String elementRecherche) {
		int debut = 0;
		int fin = tableau.length - 1;
		while (debut <= fin) {
			int milieu = (debut + fin) / 2;
			if (tableau[milieu].getTitre().compareTo(elementRecherche) == 0) {
				return milieu; // Retourne l'index si l'élément est trouvé
			} else if (tableau[milieu].getTitre().compareTo(elementRecherche) > 0) {
					debut = milieu + 1;
			} else {
					fin = milieu - 1;
			}
		}
			return -1; // Retourne -1 si l'élément n'est pas trouvé
	} 
	
	
	
	
	public static void main(String[] args) {
		int choix = 0;
		String id;
		Scanner sc = new Scanner(System.in);
		Stock stock = new Stock(1000);    			//Création d'un stock de maximum 1000 livres
		GestionnaireEmprunt gestionnaireEmprunt = new GestionnaireEmprunt(1000);
		Listechainee listechaine = new Listechainee();			//Liste chainee pour la recherche linéaire
		ArbreBinaire arbre = new ArbreBinaire();
		
		
		do {
			
			System.out.println("\n\nMenu Principal\n |||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
			System.out.println(" 1-  Ajouter livres                                     |");
			System.out.println(" 2-  Afficher livres                                    |");
			System.out.println(" 3-  Recherche linéaire avec une liste chainee          |");
			System.out.println(" 4-  Recherche binaire par titre du livre               |");
			System.out.println(" 5-  Recherche dans un arbre binaire par genre du livre |");
			System.out.println(" 6-  Recherche avec une table de hachage                |");
			System.out.println(" 7-  Emprunter un livre                                 |");
			System.out.println(" 8-  Afficher les livres empruntes                      |");
			System.out.println(" 9-  Rendre un livre emprunte                           |");
			System.out.println("\n 0- Quitter\n");
			System.out.print("Que voulez faire? ");
			choix = sc.nextInt();
			
			try {
				
				switch(choix) {
				
					
				case 1:
					String ligne = "";
					System.out.println("\n.... Entrer les informations des livres comme suit: ");
					System.out.println("ISBN,Titre,Auteur,Genre,Nombre d exemplaire      puis valider");
					sc.nextLine();
					ligne = sc.nextLine();
					
					
					Stack<Livre> pile = new Stack<>();		//pile permettant de stocker les ajouts de livre
					
					do {
						

							String [] chaine ;
							chaine = ligne.split(",");				//découpage de la ligne en utilisant la virgule comme séparateur
							
							if(chaine.length == 5) {	
									Livre l  = new Livre(Integer.valueOf(chaine[0]), chaine[1], chaine[2], chaine[3], Integer.valueOf(chaine[4]));
									pile.add(l);			//ajout du livre  dans la pile de Produit
							}
								
								
							else 	break;	//arreter l'ajout si la ligne saisie par l'utilisateur n'est pas correcte
								
							
							
							
							ligne = sc.nextLine();					//Lecture de la ligne
							
		
						
					}while(ligne != "");
					
					//Enregistrement des livres dans le stock
					while(!pile.isEmpty()) {
						stock.ajouterLivre(pile.pop());
					}
					
					break;
					
				
				case 2: 
					System.out.println("\n.... Liste des livres de la bibliothèque: ");
					stock.afficherLivre();	//Affichage des livres
					
					break;
					
					
				case 3:
					//on commence par mettre tous les livres du stock dans une liste chainee
					for(int i=0; i<stock.getNbrLivre(); i++) {
						listechaine.ajouter(stock.getListeLivre()[i]);
						
					}
					System.out.print(" Entrer l isbn du livre que vous recherchez: ");
					int isb = sc.nextInt();
					System.out.print(listechaine.rechercher(isb));  // recherche lineaire
					
				
					
					break;
					
				case 4:
					
					
					int n = stock.getNbrLivre();
					Livre table[] = new Livre[n];
					for(int i= 0; i<n; i++) {
						table[i] = stock.getListeLivre()[i];
					}
					
					triParTitre(table);
					System.out.print(" Entrer le titre du livre que vous recherchez: ");
					sc.nextLine();
					String  title = sc.nextLine();
					
					int index = rechercheBinaire(table, title); //recherche binaire
					
					System.out.print(table[index].toString());
					
					
				
					break;
					
					
				case 5:
					
					for(int i=0; i<stock.getNbrLivre(); i++) {
						arbre.inserer(stock.getListeLivre()[i]);
						
					}
					
					System.out.print(" Entrer le genre du livre que vous recherchez: ");
					sc.nextLine();
					String genre = sc.nextLine();
					System.out.print(arbre.rechercher(genre));  // recherche lineaire
					
					
					
					
					break;
					
				
				case 6:	
					
					
					MaHashTable hashTable = new MaHashTable();
					// ajout des livres dans la table de hachage
					for(int i=0; i<stock.getNbrLivre(); i++) {
						hashTable.ajouter(stock.getListeLivre()[i].getIsbn(),stock.getListeLivre()[i]);
						
					}
					
					System.out.print(" Entrer l isbn du livre que vous recherchez: ");
					isb = sc.nextInt();
					System.out.print(hashTable.obtenir(isb));		// recherche par indexage
					
					
					
					break;
					
					
				case 7:
					int idUtilisateur;
					int isbnDuLivre;
					String dateEmprunt;
					String delais;
					System.out.println("\n.... Entrer les informations de l emprunt: ");
					System.out.print(" Entrer l id de l emprunteur: ");
					idUtilisateur = sc.nextInt();
					System.out.print(" Entrer l isbn du livre que vous emprunte: ");
					isbnDuLivre = sc.nextInt();
					sc.nextLine();
					System.out.print(" Entrer la date de l emprunt ");
					dateEmprunt = sc.nextLine();
					System.out.print(" Entrer le delais de retour ");
					delais = sc.nextLine();
					
					if(stock.rechercherLivre(isbnDuLivre) != null) {
						if(stock.rechercherLivre(isbnDuLivre).getnombreExemplaire() > 0) {
							Emprunt e = new Emprunt(idUtilisateur, isbnDuLivre,dateEmprunt,delais);
							gestionnaireEmprunt.ajouterEmprunt(e);
							stock.rechercherLivre(isbnDuLivre).retirerExamplaire(1);
						}
						else
							System.out.print(" il n'ya plus d'exemplaire dans le stock.");
					}
					else System.out.print(" ce livre n'est pas present dans le stock.");
					
					
					
					
					
				
					break;
					
					
				case 8:
					for(int i=0; i<gestionnaireEmprunt.getnbrEmprunt(); i++) {
						System.out.print(gestionnaireEmprunt.getListeLivre()[i].toString());
					}
					
					
					
					break;
				
				
				
				case 9:

					System.out.println("\n.... Entrer les informations de l emprunt: ");
					System.out.print(" Entrer l id de l emprunteur: ");
					idUtilisateur = sc.nextInt();
					System.out.print(" Entrer l isbn du livre que vous avez emprunte: ");
					isbnDuLivre = sc.nextInt();
					gestionnaireEmprunt.RendreLivre(idUtilisateur, isbnDuLivre);
					stock.rechercherLivre(isbnDuLivre).nouveauxExamplaire(1);
					
				
				
				break;
			
			
			}
				
				
			}catch(Exception e) {
				
			}
			
		}while(choix !=0);
		
		System.out.println("\nMerci d'avoir utilisé notre service client de gestion. Au revoir !");
		
		
		
	}
}
