package pobj.motx.tme2;

import java.util.ArrayList;
import java.util.List;
import pobj.motx.tme1.*;

public class GrillePotentiel {
	private GrillePlaces grille;
	private Dictionnaire dico;
	private List<Dictionnaire> motsPot;
	private GrillePlaces places;
	private List<IContrainte> contraintes;
	
	
	public GrillePotentiel(GrillePlaces grille, Dictionnaire dicoComplet, List<Dictionnaire> motsPot) {
		this.grille = grille;
		this.dico = dicoComplet;
		this.contraintes = new ArrayList<>();
		this.motsPot = motsPot;
		int i=0;
			for (Emplacement emp : grille.getPlaces()) {
				this.motsPot.get(i).filtreLongueur(emp.size());
				int j=0;
				for (Case c : emp.getCases()) {
					if (!(c.isPleine() || c.isVide())) 
					   this.motsPot.get(i).filtreParLettre(c.getChar(),j);
					j++;	
				}
				System.out.println(this.motsPot.get(i).size());
				i++;	
			}
			contrainte(grille);
			propage();
	}
	
	public GrillePotentiel(GrillePlaces grille, Dictionnaire dicoComplet) {
		this.grille = grille;
		this.dico = dicoComplet;
		this.contraintes = new ArrayList<>();
		motsPot =new ArrayList<Dictionnaire>();
		filtre(grille,dicoComplet);
		contrainte(grille);
		propage();
	}
	
	public boolean isDead() {
		boolean dead = false;
		for (Dictionnaire dico : motsPot) {
			dead = (dico.size() == 0);
		}
		return dead;
	}
	
	public GrillePotentiel fixer(int m, String soluce) {
		GrillePotentiel gp = new GrillePotentiel(this.getPlaces().fixer(m, soluce), this.dico,this.copy(motsPot));
		return gp;
	}
	
	public List<Dictionnaire> copy(List<Dictionnaire> motsPot){
		List<Dictionnaire> dicoCopy = new ArrayList<Dictionnaire>();
		for (Dictionnaire dico : motsPot) {
			dicoCopy.add(dico.copy());
		}
		return dicoCopy;
	}
	
	/**
	 * renvoie la liste des emplacement dans la grille
	 * 
	 * @return places (une liste d'emplacements)
	 */
	public GrillePlaces getPlaces() {
		return places;
	}
	
	public List<Dictionnaire> getMotsPot() {
		return motsPot;
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
	
	public void filtre(GrillePlaces grille , Dictionnaire dicoComplet) {
		int j = 0;
		for (Emplacement emplacement : grille.getPlaces()) {
			Dictionnaire dico = dicoComplet.copy();
			dico.filtreLongueur(emplacement.size());
			int i = 0;
			for (Case c : emplacement.getCases()) {
				if (!(c.isPleine() || c.isVide())) {
					dico.filtreParLettre(c.getChar(), i);
				}
				i++;
			}
			motsPot.add(dico);
			j++;
		}
		
	}
	
	public void contrainte(GrillePlaces grille) {
		for (int i = 0; i < grille.getNbHorizontal(); i++) {
			
			Emplacement m1 = grille.getPlaces().get(i);
			
			for (int j = grille.getNbHorizontal(); j < grille.getPlaces().size(); j++) {
				 //pb retour j a effacer
				Emplacement m2 = grille.getPlaces().get(j);
				
				for (int c1 = 0; c1 < m1.getCases().size(); c1++) {
					
					for (int c2 = 0; c2 < m2.getCases().size(); c2++) {
						
						if (m1.getCases().get(c1).equals(m2.getCases().get(c2)) && m1.getCases().get(c1).isVide()) {
							
							IContrainte contrainte = new CroixContrainte(i, c1, j, c2);
							
							if (!contraintes.contains(contrainte)) {
								
								contraintes.add(contrainte);
							}
						}
					}
				}
			}
		}	
	}
	

}
