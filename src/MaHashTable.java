import java.util.Hashtable;
import java.util.LinkedList;

public class MaHashTable {

    private static final int CAPACITE_PAR_DEFAUT = 50;
	private Hashtable [] table; 
	private int taille; 

	public MaHashTable() {
		table = new Hashtable[CAPACITE_PAR_DEFAUT]; 
		taille = 0;
	}
	
	
	private int fonctionHachage(int cle) {
		return Math.abs(cle % table.length);
	}
	
	
	// Méthode pour ajouter une paire clé-valeur dans la table de hachage
	public void ajouter(int cle, Livre valeur) {
		int index = fonctionHachage(cle);
		if (table[index] == null) {
			table[index] = new Hashtable<>();
		}
		if (table[index].containsKey(cle)) {
			table[index].put(cle, valeur);
			
		} else {
			table[index].put(cle, valeur);
			taille++;
		}
	
		
	}
	
	
	// Méthode de recherche
	public String obtenir(int cle) {
		int index = fonctionHachage(cle);
		if (table[index] != null) {
			return table[index].get(cle).toString();
		}
			return null; // Clé non trouvée
	}

}
