package pobj.motx.tme1;

import java.util.List;
import java.util.ArrayList;


public class GrillePlaces {
	private Grille grille;
	private List<Emplacement> places;
	private int nbHorizontaux;

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
	
	public List<Emplacement> getPlaces(){
		return places;
	}
	
	public int getNbHorizontal() {
		return nbHorizontaux;
	}
	
	public String toString() {
		String s ="";
		for (Emplacement e : places) {
			s+=e.toString()+"\n";
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
}