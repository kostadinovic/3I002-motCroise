package pobj.motx.tme1;

import java.util.List;
import java.util.ArrayList;


public class GrillePlaces {
	private List<Emplacement> places;
	private Grille grille;
	private int nbHorizontaux;

	public GrillePlaces(Grille grille) {
		places = new ArrayList<Emplacement>();
		this.grille = grille;
		for (int i = 0; i < grille.nbLig(); i++) {
			cherchePlaces(getLig(i));
		}
		nbHorizontaux = places.size();
		for (int i = 0; i < grille.nbCol(); i++) {
			cherchePlaces(getCol(i));
		}
	}
	
	public List<Emplacement> getPlaces(){
		return places;
	}
	
	public int getNbHorizontal() {
		return nbHorizontaux;
	}
	
	public String toString() {
		String s ="";
		for (Emplacement emplacement : places) {
			s+=emplacement.toString()+"\n";
		}
		return s;
	}
	
	private List<Case> getLig(int lig){
		List<Case> tmp = new ArrayList<Case>();
		for (int i = 0; i < grille.nbCol(); i++) 
			tmp.add(grille.getCase(lig, i));
		return tmp;
	}
	private List<Case> getCol(int col){
		List<Case> tmp = new ArrayList<Case>();
		for (int i = 0; i < grille.nbLig(); i++) 
			tmp.add(grille.getCase(i, col));
		return tmp;
	}
	
	
	

}