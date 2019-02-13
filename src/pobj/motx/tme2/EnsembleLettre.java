package pobj.motx.tme2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class EnsembleLettre extends ArrayList<Character> {
		private static final long serialVersionUID = 1L;
		private List<Character> ensemble;
		
		public EnsembleLettre() {
			ensemble = new ArrayList<Character>();
		}

		EnsembleLettre(Collection<? extends Character> c) {
			super(c);
		}
		
		@Override
		public boolean add(Character e) {
			if (!this.contains(e)) {
				return super.add(e);
			} else
				return false;
		}
		
	    public boolean contains(char c) {
	        return ensemble.contains(c);
	    }
	    
	    public List<Character> getEnsembleLettre() {
	        return ensemble;
	    }

	    
		public EnsembleLettre intersection(EnsembleLettre e2){
			List<Character> inter = new ArrayList<Character>();
			for(Character c: this.getEnsembleLettre()){
				if(e2.contains(c)){
					inter.add(c);
				}
			}
			return new EnsembleLettre(inter);
		}


}
