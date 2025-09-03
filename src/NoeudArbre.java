public class NoeudArbre {

    Livre valeur;
	NoeudArbre gauche;
	NoeudArbre droit;
	
	// Constructeur
	public NoeudArbre(Livre valeur) {
		this.valeur = valeur;
		this.gauche = null;
		this.droit = null;
	}

}
