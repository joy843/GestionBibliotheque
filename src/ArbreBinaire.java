public class ArbreBinaire {

    NoeudArbre racine;
	
	// Constructeur
	public ArbreBinaire() {
		this.racine = null;
	}
	
	// Méthode pour insérer une valeur dans l'arbre
	public void inserer(Livre valeur) {
		this.racine = insererRec(this.racine, valeur);
	}
	
	//Méthode d'insertion
	public NoeudArbre insererRec(NoeudArbre noeud, Livre valeur) {
		// Si l'arbre ou le sous-arbre est vide, on crée un nouveau nœud
		if (noeud == null) {
			return new NoeudArbre(valeur);
		}
		// Sinon, on descend dans le sous-arbre gauche ou droit selon la valeur
		if (valeur.getGenre().compareTo(noeud.valeur.getGenre()) < 0 ) {
			noeud.gauche = insererRec(noeud.gauche, valeur);
		} else  {
			noeud.droit = insererRec(noeud.droit, valeur);
		}
		// On retourne le nœud courant
		return noeud;
	}
	
	// Méthode récursive pour rechercher une valeur dans l'arbre
	
	public String rechercher(String genre) {
		return rechercherRec(this.racine, genre);
	}
	
	private String rechercherRec(NoeudArbre noeud, String genre) {
	// Si l'arbre ou le sous-arbre est vide, la valeur n'est pas présente
		if (noeud == null) {
			return null;
		}
	// Si la valeur recherchée est égale à la valeur du nœud courant, on a trouvé
		if (genre.compareTo(noeud.valeur.getGenre()) == 0) {
			return noeud.valeur.toString();
		}
	// Sinon, on descend dans le sous-arbre gauche ou droit selon la valeur
		else if (genre.compareTo(noeud.valeur.getGenre()) < 0) {
			return rechercherRec(noeud.gauche, genre);
		} else {
			return rechercherRec(noeud.droit, genre);
		}	
	}

}
