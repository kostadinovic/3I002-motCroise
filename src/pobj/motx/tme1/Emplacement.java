package pobj.motx.tme1;

import java.util.ArrayList;
import java.util.List;

/**
 *  classe permetttant l'introduiction de mots dans la grille
 * @author nemanja
 *
 */
public class Emplacement {
	/**
	 * liste de case
	 */
	private List<Case> lettres;
	
	/**
	 *  initialisation de la liste de case
	 */
	public Emplacement() {
		lettres = new ArrayList<Case>();
	}
	
	/**
	 * affiche le mots dans l'emplacement
	 * @return les mots
	 */
	@Override
	public String toString() {
		String s="";
		for(Case c: lettres) {
			s= s+c.getChar();
		}
		return s;	
	}
	/**
	 * retourne la taille de l'emplacement du mot
	 * @return la taille
	 */
	public int size() {
		return lettres.size();
	}
	
	/**
	 * ajoute la case c dans la liste lettres
	 * @param c retourner
	 */
	public void add(Case c) {
		if(c !=null) {
			lettres.add(c);
		}
	}
	
	/**
	 * accede à la liste des cases de l'emplacement
	 * 
	 * @return la liste des lettres de l'emplacement
	 */
	public List<Case> getCase(){
		return this.lettres;
	}
	
	public Case getCase(int i) {
		return lettres.get(i);
	}
	
	public boolean estVertical(){
		return (this.getCase(0).getLig())<(this.getCase(1).getLig());
	}
	
	public boolean estHorizontal(){
		return (this.getCase(0).getCol())<(this.getCase(1).getCol());
}
}
