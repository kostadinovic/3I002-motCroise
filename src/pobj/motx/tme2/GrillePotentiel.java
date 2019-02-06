package pobj.motx.tme2;

import java.util.List;
import pobj.motx.tme1.*;

public class GrillePotentiel {
	private GrillePlaces grille;
	private Dictionnaire dico;
	private List<Dictionnaire> motsPot;
	
	public GrillePotentiel(GrillePlaces grille, Dictionnaire dicoComplet) {
		this.grille=grille;
		this.dico= dicoComplet;
		int nbEmp=grille.getPlaces().size();
		Dictionnaire dicoCopy = dico.copy();
		
		for(int i=0;i<nbEmp;i++) {
			dicoCopy.filtreLongueur(grille.getPlaces().get(i).size());
			for (int j = 0; j < grille.getPlaces().get(i).size(); j++) {
				if(!grille.getPlaces().get(i).getCase(i,j).isPleine() && !grille.getPlaces().get(i).getCase(j).isVide()) {
					d.filtreParLettre(grille.getPlaces().get(i).getCase(j).getChar(), j);
				}		
}
		}
		
	}
	
	public boolean isDead() {
		
	}
	
	

}
