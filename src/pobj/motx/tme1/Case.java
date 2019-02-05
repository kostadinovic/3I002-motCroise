package pobj.motx.tme1;
/**
 * 
 * @author nemanja
 * 
 * Classe de création d'une Case 
 *
 */
public class Case {
	/**
	 *  les attributs de la Case (ligne, colonne) et valeur
	 */
	private final int colonne, ligne;
	private char valeur;
	
	/** Initialise les attributs de la Case au valeurs passée aux arguments
	 * 
	 * @param lig
	 * @param col
	 * @param c
	 */
	public Case(int lig,int col,char c) {

		this.ligne=lig;
		this.colonne=col;
		this.valeur=c;
	}
	
	
	public int getLig() { return ligne; } /** retourne la ligne */
	public int getCol() { return colonne; } /** retourne la colonne */
	public char getChar() { return valeur; } /** retourne la valeur contenue dans la case */
	
	/**
	 * Modifie la valeur de la case par la valeur c
	 * @param c
	 */
	public void setChar(char c) { 
		this.valeur=c;
	}
	
	/** 
	 * vérifie si la case est vide 
	 * @return vrai ou faux
	 */
	public boolean isVide() {
		if(valeur== ' ') {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * vérifie si la Case est pleine
	 * @return
	 */
	public boolean isPleine() {
		if(valeur =='*') {
			return true;
		}else {
			return false;
		}
	}
	

}
