package pobj.motx.tme2;

public class CroixContrainte implements IContrainte {
	private int m1;
	private int c1;
	private int m2;private int c2;
	
	public CroixContrainte(int m1, int c1, int m2, int c2) {
		super();
		this.m1 = m1;
		this.c1 = c1;
		this.m2 = m2;
		this.c2 = c2;
	}

	public int reduce(GrillePotentiel grille) {
		EnsembleLettre liste1 = grille.getMotsPot().get(m1).ensembleLettrePos(c1);
		EnsembleLettre liste2 = grille.getMotsPot().get(m2).ensembleLettrePos(c2);
		EnsembleLettre s = new EnsembleLettre(liste1);
		s.retainAll(liste2);
		int nombreDeMotFiltrees = 0;
		if (liste1.size() > s.size()) {
			nombreDeMotFiltrees += grille.getMotsPot().get(m1).filterParEnsembleDeLettrePo(c1, s);
		}
		if (liste2.size() > s.size()) {
			nombreDeMotFiltrees += grille.getMotsPot().get(m2).filterParEnsembleDeLettrePo(c2, s);
		}
		return nombreDeMotFiltrees;
	}
	
	public int getM1() {
		return m1;
	}
	
	public void setM1(int m1) {
		this.m1 = m1;
	}
	
	public int getC1() {
		return c1;
	}
	
	public void setC1(int c1) {
		this.c1 = c1;
	}

	public int getM2() {
		return m2;
	}

	public void setM2(int m2) {
		this.m2 = m2;
	}

	public int getC2() {
		return c2;
	}

	public void setC2(int c2) {
		this.c2 = c2;
	}
}