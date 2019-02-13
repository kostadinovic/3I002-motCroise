package pobj.motx.tme2;

import java.util.List;

public class CroixContrainte implements IContrainte {
	private int m1;
	private int c1;
	private int m2;
	private int c2;
	
	public CroixContrainte(int m1, int c1, int m2, int c2) {
		super();
		this.m1 = m1;
		this.c1 = c1;
		this.m2 = m2;
		this.c2 = c2;
	}
	
	@Override
	public int reduce(GrillePotentiel grille) {
		EnsembleLettre ens1 = grille.getMotsPot().get(m1).charAt(c1);
		EnsembleLettre ens2 = grille.getMotsPot().get(m2).charAt(c2);
		EnsembleLettre s = ens1.intersection(ens2);
		int nb = 0;

		if (ens1.size() > s.size()) {
			nb += grille.getMotsPot().get(m1).filterParEnsembleDeLettrePo(c1, s);
		}

		if (ens2.size() > s.size()) {
			nb += grille.getMotsPot().get(m2).filterParEnsembleDeLettrePo(c2, s);
		}
		
		return nb;
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
	
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null)
			return false;
		if (!(o instanceof CroixContrainte))
			return false;
		CroixContrainte other = (CroixContrainte) o;
		if (c1 != other.c1 || c2 != other.c2 ||m1 != other.m1 || m2 != other.m2) {
			return false;
		}
		return true;
	}
}