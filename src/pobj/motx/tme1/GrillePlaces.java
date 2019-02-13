package pobj.motx.tme1;

import java.util.List;
import java.util.ArrayList;

/** 
 * classe qui nous permet de trouver tout les emplacements des mots sur la grille
 * @author nemanja
 *
 */


public class GrillePlaces {
	private Grille grille; /** la grille */
	private List<Emplacement> places; /** la liste qui contient les places des mots */
	private int nbHorizontaux; /** nombre de mots */
	
	/**
	 * calcul les emplacements de mots que cotnient la grille grille
	 * @param grille
	 */
	public GrillePlaces(Grille grille) {
		this.grille = grille;
		places = new ArrayList<Emplacement>();
		for (int i = 0; i < grille.nbLig(); i++) {
			cherchePlaces(getLig(i));
		}
		nbHorizontaux =places.size();
		for (int i = 0; i < grille.nbCol(); i++) {
			cherchePlaces(getCol(i));
		}
	}
	
	/**
	 * 
	 * @return le nombre de places
	 */
	public List<Emplacement> getPlaces(){
		return places;
	}
	
	/**
	 * 
	 * @return nombre de mots horizontaux
	 */
	public int getNbHorizontal() {
		return nbHorizontaux;
	}
	
	/** 
	 * fonction d'affichage
	 */
	public String toString() {
		String s ="";
		for (Emplacement e : places) {
			s+=e.toString()+"\n";
		}
		return s;
	}
	
	/**
	 * retourne la liste des mots sur la ligne
	 * @param lig
	 * @return
	 */
	private List<Case> getLig(int lig){
		List<Case> tmp = new ArrayList<Case>();
		for (int i = 0; i < grille.nbCol(); i++) 
			tmp.add(grille.getCase(lig, i));
		return tmp;
	}
	
	/**
	 * retourne la liste des mots sur la colonnes col
	 * @param col
	 * @return
	 */
	private List<Case> getCol(int col){
		List<Case> tmp = new ArrayList<Case>();
		for (int i = 0; i < grille.nbLig(); i++) 
			tmp.add(grille.getCase(i, col));
		return tmp;
	}
	
	private void cherchePlaces(List<Case> cases) {
		Emplacement e = new Emplacement();
		for (Case c: cases) {
			if(!c.isPleine()){
				e.add(c);
			}else {
				if(e.size()>1) {
					places.add(e);
				}
		        e = new Emplacement();
			}
		}
		if(e.size()> 1)
			places.add(e);
	}
	
	/**
	 * ajoute dans le m-iéme emplacment de la grille le mot qui est soluce 
	 * 
	 * @param m est index de l'emplacment à remplir avec les lettre du mot soluce
	 * @param soluce est le mot à ajouter dans le m-iéme emplacement de la grille
	 * @return une nouvelle grille avec le m-iéme emplacement contenant soluce
	 */
	public GrillePlaces fixer(int m, String soluce) {
		Grille gCopie=grille.copy();
		List<Case> cases = this.getPlaces().get(m).getCase();
		int i=0;
		for (Case c : cases){
			char lettre=soluce.charAt(i);
			gCopie.getCase(c.getLig(), c.getCol()).setChar(lettre);
			i++;
		}
		GrillePlaces gp=new GrillePlaces (gCopie);
		return gp;
	}
	
	
}