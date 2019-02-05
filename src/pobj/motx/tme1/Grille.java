package pobj.motx.tme1;

/**
 * Classe permetant de crée des grille de case
 * @author nemanja
 *
 */

public class Grille {
	/**
	 * une matrice de case 
	 */
	private Case[][] matrice;
	
	
	/**
	 * construit et initialise la grille avec 
	 * @param hauteur
	 * @param largeur
	 */
	public Grille(int hauteur, int largeur) {
		matrice= new Case[hauteur][largeur];
		for(int i=0;i<hauteur;i++) {
			for(int j=0;j<largeur;j++) {
				this.matrice[i][j] = new Case(i,j,' ');		
			}
		}
	}
	
	
	/**
	 * retourne la valeur de la case 
	 * @param lig
	 * @param col
	 * @return
	 */
	public Case getCase(int lig,int col){
		return matrice[lig][col];	
	}
	
	/**
	 * affiche la grille
	 */
	@Override
	public String toString() {
		return GrilleLoader.serialize(this, false);
	}
	
	/** 
	 * retourne le nombre de ligne de la grille
	 * @return
	 */
	public int nbLig() {
		return matrice.length;
	}
	
	/**
	 * retorune le nombre de colonne de la grille
	 * @return
	 */
	public int nbCol() {
		return matrice[0].length;
	}
	
	/**
	 * permet de faire une copie la grille 
	 * @return
	 */
	public Grille copy() {
		Grille copy = new Grille(this.nbLig(),this.nbCol());
		for (int i=0; i<this.nbLig();i++) {
			for (int j=0; j<nbCol();j++) {
					copy.getCase(i, j).setChar(getCase(i, j).getChar());		
			}
		}
		return copy;
	}
}
