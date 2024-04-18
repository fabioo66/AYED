package tp3.ejercicio3;

import java.util.LinkedList;
import java.util.List;


public class Ejercicio3 {
	public static void main(String[] args) {
		GeneralTree<String> a1 = new GeneralTree<String>("1");
		List<GeneralTree<String>> children2 = new LinkedList<GeneralTree<String>>();
		children2.add(new GeneralTree<String>("21"));
		children2.add(new GeneralTree<String>("22"));
		children2.add(new GeneralTree<String>("23"));
		GeneralTree<String> a2 = new GeneralTree<String>("2", children2);
		List<GeneralTree<String>> children3 = new LinkedList<GeneralTree<String>>();
		children3.add(new GeneralTree<String>("31"));
		children3.add(new GeneralTree<String>("32"));
		GeneralTree<String> a3 = new GeneralTree<String>("3", children3);
		List<GeneralTree<String>> childen = new LinkedList<GeneralTree<String>>();
		childen.add(a1);childen.add(a2);childen.add(a3);
		GeneralTree<String> a = new GeneralTree<String>("0", childen);
		System.out.println("La altura del arbol es " +  a.altura());
		System.out.println("---------------------------------------------------------------------");
		System.out.println("La altura del nodo ingresado por parametro es " + a.nivel("23"));
		System.out.println("---------------------------------------------------------------------");
		System.out.println("El ancho del arbol es " + a.ancho());
	}
}
