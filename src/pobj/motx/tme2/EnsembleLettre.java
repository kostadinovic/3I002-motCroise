package pobj.motx.tme2;

import java.util.ArrayList;
import java.util.Collection;

public class EnsembleLettre extends ArrayList<Character> {
		private static final long serialVersionUID = 1L;
		
		public EnsembleLettre() {	
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
}
