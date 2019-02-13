package pobj.motx.tme2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Un ensemble de mots.
 *
 */
public class Dictionnaire {

	// stockage des mots
	private List<String> mots = new ArrayList<>();

	/**
	 * Ajoute un mot au Dictionnaire, en dernière position.
	 * @param mot à ajouter, il sera stocké en minuscules (lowerCase)
	 */
	public void add(String mot) {
		mots.add(mot.toLowerCase());
	}

	/**
	 * Taille du dictionnaire, c'est à dire nombre de mots qu'il contient.
	 * @return la taille
	 */
	public int size() {
		return mots.size();
	}
	
	/**
	 * Accès au i-eme mot du dictionnaire.
	 * @param i l'index du mot recherché, compris entre 0 et size-1.
	 * @return le mot à cet index
	 */
	public String get(int i) {
		return mots.get(i);
	}

	/**
	 * Rend une copie de ce Dictionnaire.
	 * @return une copie identique de ce Dictionnaire
	 */
	public Dictionnaire copy () {
		Dictionnaire copy = new Dictionnaire();
		copy.mots.addAll(mots);
		return copy;
	}

	/**
	 * Retire les mots qui ne font pas exactement "len" caractères de long.
	 * Attention cette opération modifie le Dictionnaire, utiliser copy() avant de filtrer pour ne pas perdre d'information.
	 * @param len la longueur voulue 
	 * @return le nombre de mots supprimés
	 */
	public int filtreLongueur(int len) {
		List<String> cible = new ArrayList<>();
		int cpt=0;
		for (String mot : mots) {
			if (mot.length() == len)
				cible.add(mot);
			else
				cpt++;
		}
		mots = cible;
		return cpt;
	}

	
	@Override
	public String toString() {
		if (size() == 1) {
			return mots.get(0);
		} else {
			return "Dico size =" + size();
		}
	}
	
	/**
	 * Création d'un dictionnaire à partir d'un fichier
	 * @param path le chemin du fichier ou se trouve le dictionnaire
	 * @return une instance de la classe Dictionnaire
	 */
	public static Dictionnaire loadDictionnaire(String path) {
		Dictionnaire dico = new Dictionnaire();
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			for(String line = br.readLine(); line != null ; line = br.readLine()) {
				dico.add(line);
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
		return dico;
	}
	
	/**
	 * modifiera le dictionnaire pour ne garder que les mots dont la ième lettre est c
	 * 
	 * @param c une lettre utilisé pour le filtrage
	 * @param i l'index de la lettre c dans les mot
	 * @return Dictionnaire qui contient les mots qui ont comme lettre c a la i-éme position
	 * 
	 */
	
	public int filtreParLettre(char c, int i) {
		List<String> listeDeMots = new ArrayList<>();
		int cpt = 0;
		for (String mot : mots) {
			if (mot.charAt(i) == c)
				listeDeMots.add(mot);
			else
				cpt++;
		}
		mots = listeDeMots;
		return cpt;
	}
	
	public int filterParEnsembleDeLettrePo(int i, EnsembleLettre ensembleLettre) {
		int cpt = 0;
		List<String> cible = new ArrayList<>();
		for (String mot : this.mots) {
			if (ensembleLettre.contains(mot.charAt(i))) {
				cible.add(mot);
			} else
				cpt++;
		}
		mots = cible;
		return cpt;
	}
	
	public EnsembleLettre ensembleLettrePos(int i) {
		EnsembleLettre ensLettre = new EnsembleLettre();
		for (String m : mots) {
			ensLettre.add(m.charAt(i));
		}
		return ensLettre;
	}
	
	public EnsembleLettre charAt(int index) {
		if (mots.isEmpty()) {
			return new EnsembleLettre();
		}
		EnsembleLettre l = new EnsembleLettre();
		for (String mot : mots) {
			l.add(mot.charAt(index));
		}
	    return l;
	}
	


	
}
