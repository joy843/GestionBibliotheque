public class Emprunt {

    private int idUtilisateur;
	private int isbnDuLivre;
	private String dateEmprunt;
	private String delais;
	
	//Constructeur
	public Emprunt(int id, int isbn, String emp, String delais) {
		this.idUtilisateur = id;
		this.isbnDuLivre = isbn;
		this.dateEmprunt = emp;
		this.delais = delais;
	}
	
	//Accesseurs
	public int getIdUtilisateur() {
		return this.idUtilisateur;
	}
	public int getIsbnDuLivre() {
		return this.isbnDuLivre;
	}
	public String getDateEmprunt() {
		return this.dateEmprunt;
	}
	public String getDelais() {
		return this.delais;
	}
	
	
	
	
	//toString
	public String toString() {
		return " - id Emprunteur" + Integer.toString(this.idUtilisateur) + ", titre: " + Integer.toString(this.isbnDuLivre) + ", dateEmprunt: " + this.dateEmprunt + ", délais: " + this.delais;
	}

}
