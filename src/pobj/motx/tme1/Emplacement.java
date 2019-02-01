package pobj.motx.tme1;

import java.util.ArrayList;
import java.util.List;

public class Emplacement {
	private List<Case> lettres;
	
	public Emplacement() {
		lettres = new ArrayList<Case>();
	}
	
	@Override
	public String toString() {
		String s="";
		for(Case c: lettres) {
			s= s+c.getChar();
		}
		return s;	
	}
	
	public int size() {
		return lettres.size();
	}
	
	
}
