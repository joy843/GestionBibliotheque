public class Livre {

    private int isbn;
	private String titre;
	private String auteur;
	private String genre;
	private int nombreExemplaire;
	
	//Constructeur
	
	public Livre(int id, String titre, String auteur, String genre, int nombreExemplaire) {
		this.isbn = id;
		this.titre = titre;
		this.auteur = auteur;
		this.genre = genre;
		this.nombreExemplaire = nombreExemplaire;
	}
	
	//Accesseurs
	public int getIsbn() {
		return this.isbn;
	}
	public String getTitre() {
		return this.titre;
	}
	public String getAuteur() {
		return this.auteur;
	}
	public String getGenre() {
		return this.genre;
	}
	public int getnombreExemplaire() {
		return this.isbn;
	}
	
	//Mutateurs
	public void setIsbn(int id) {
		this.isbn = id;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public void setnombreExemplaire(int n) {
		this.nombreExemplaire = n;
	}
	
	
	//ajouter exemplaire
	public void nouveauxExamplaire(int n) {
		this.nombreExemplaire += n;
	}
	
	
	//retirer exemplaire
	public void retirerExamplaire(int n) {
		this.nombreExemplaire -= n;
	}
	
	
	//toString
	public String toString() {
		return " - ISBN: " + Integer.toString(isbn) + ", titre: " + this.titre + ", genre: " + this.genre + ", auteur: " + this.auteur + ", nombre d'exemplaire: " + Integer.toString(this.nombreExemplaire);
	}

}
