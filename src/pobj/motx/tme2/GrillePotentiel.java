package pobj.motx.tme2;

import java.util.ArrayList;
import java.util.List;
import pobj.motx.tme1.*;

public class GrillePotentiel {
	private GrillePlaces grille;
	private Dictionnaire dico;
	private List<Dictionnaire> motsPot;
	//private GrillePlaces places;
	private List<IContrainte> contraintes;
	
	
	public GrillePotentiel(GrillePlaces grille, Dictionnaire dicoComplet) {
		this.grille = grille;
		this.dico = dicoComplet;
		this.contraintes = new ArrayList<>();
		motsPot =new ArrayList<Dictionnaire>();
		
		filtre(grille,dicoComplet);
		checkContrainte();
		//propage();
	}
	
	public boolean isDead() {
		for(Dictionnaire d:motsPot){
			if(d.size()==0) {
				return true;
			}
		}
		return false;
	}
	
	public List<Dictionnaire> getMotsPot() {
		return motsPot;
	}
	
	public void filtre(GrillePlaces grille , Dictionnaire dicoComplet) {
		int j = 0;
		for (Emplacement emplacement : grille.getPlaces()) {
			Dictionnaire dico = dicoComplet.copy();
			dico.filtreLongueur(emplacement.size());
			int i = 0;
			for (Case c : emplacement.getCase()) {
				if (!(c.isPleine() || c.isVide())) {
					dico.filtreParLettre(c.getChar(), i);
				}
				i++;
			}
			motsPot.add(dico);
			j++;
		}
		
	}
	
	public GrillePotentiel fixer(int m, String soluce) {
		GrillePotentiel gp = new GrillePotentiel(grille.fixer(m, soluce),dico);;
		return gp;
	}
	
	public List<IContrainte> getContraintes(){
		return contraintes;
	}
	
	public List<Dictionnaire> copy(List<Dictionnaire> motsPot){
		List<Dictionnaire> dicoCopy = new ArrayList<Dictionnaire>();
		for (Dictionnaire dico : motsPot) {
			dicoCopy.add(dico.copy());
		}
		return dicoCopy;
	}
	
	/*
	

	
	public List<Dictionnaire> copy(List<Dictionnaire> motsPot){
		List<Dictionnaire> dicoCopy = new ArrayList<Dictionnaire>();
		for (Dictionnaire dico : motsPot) {
			dicoCopy.add(dico.copy());
		}
		return dicoCopy;
	}
	
	
	
	private boolean propage() {
		
		while (true) {

			int nbreDeMotsEliminees = 0;
			for (IContrainte iContrainte : contraintes) {
				nbreDeMotsEliminees += iContrainte.reduce(this);
			}
			if (nbreDeMotsEliminees == 0) {
				return true;
			}
			if (this.isDead()) {
				return false;
			}
		}
	}
	 */
	
	public void checkContrainte(){ 
		int m1=0;
		for(Emplacement e1:grille.getPlaces()){
			int m2=0;
			for(Emplacement e2:grille.getPlaces()){
				if(e1.estHorizontal()&& e2.estVertical()){
					for(int c1=0;c1<e1.size();c1++) {
						for(int c2=0;c2<e2.size();c2++){
							if((e1.getCase(c1)==e2.getCase(c2))&&(e1.getCase(c1).isVide())){
								contraintes.add(new CroixContrainte(m1,c1,m2,c2));
							}
						}
					}
				}
				m2++;
			}
			m1++;}
		}
	

}
