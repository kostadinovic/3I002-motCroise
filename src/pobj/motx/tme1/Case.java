package pobj.motx.tme1;

public class Case {
	private final int colonne, ligne;
	private char valeur;
	
	public Case(int lig,int col,char c) {
		this.ligne=lig;
		this.colonne=col;
		this.valeur=c;
	}
	
	
	public int getLig() { return ligne; }
	public int getCol() { return colonne; }
	public char getChar() { return valeur; }
	
	public void setChar(char c) {
		this.valeur=c;
	}
	
	public boolean isVide() {
		if(valeur== ' ') {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean isPleine() {
		if(valeur =='*') {
			return true;
		}else {
			return false;
		}
	}
	
	
	
	
	
	

}
