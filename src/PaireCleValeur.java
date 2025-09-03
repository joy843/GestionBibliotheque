import java.util.LinkedList;
import java.util.Hashtable;
// Classe représentant une paire clé-valeur
public class PaireCleValeur {

    private int cle;
	private Livre valeur;
	
	// Constructeur de la paire clé-valeur
	public PaireCleValeur(int cle, Livre valeur) {
		this.cle = cle;
		this.valeur = valeur;
	}
	
	public int getCle() {
		return cle;
	}
		
	public Livre getValeur() {
		return valeur;
	}

}
