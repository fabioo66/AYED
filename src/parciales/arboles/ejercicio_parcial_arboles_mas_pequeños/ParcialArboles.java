package parciales.arboles.ejercicio_parcial_arboles_mas_pequeños;

import java.util.*;
import tp3.ejercicio1.GeneralTree;

public class ParcialArboles {
    
    public List<GeneralTree<Integer>> devolverArboles(GeneralTree<Integer> arbol){
        List<GeneralTree<Integer>> lista = new LinkedList<GeneralTree<Integer>>();
        if (!arbol.isEmpty()){
            procesar(arbol, lista);
        }
        return lista;
    } 

    public void procesar(GeneralTree<Integer> arbol, List<GeneralTree<Integer>> lista){
        GeneralTree<Integer> padre = arbol;
        int suma = 0;
        List<GeneralTree<Integer>> children = arbol.getChildren();
        for (GeneralTree<Integer> child : children){
            suma += child.getData();
            procesar(child, lista);
        }
        if (suma > padre.getData()){
            lista.add(padre);
        }
    } 

    public static void main(String[] args) {
		
		List<GeneralTree<Integer>> children1 = new LinkedList<GeneralTree<Integer>>();
		children1.add(new GeneralTree<Integer>(5));
        GeneralTree<Integer> a1 = new GeneralTree<Integer>(2, children1);

        List<GeneralTree<Integer>> children2 = new LinkedList<GeneralTree<Integer>>();
        children2.add(new GeneralTree<Integer>(6));
        children2.add(new GeneralTree<Integer>(2));
		children2.add(new GeneralTree<Integer>(8));
        GeneralTree<Integer> a2 = new GeneralTree<Integer>(33, children2);

        List<GeneralTree<Integer>> children3 = new LinkedList<GeneralTree<Integer>>();
        children3.add(new GeneralTree<Integer>(6));
        children3.add(new GeneralTree<Integer>(100));
        GeneralTree<Integer> a3 = new GeneralTree<Integer>(4, children3);

        List<GeneralTree<Integer>> children = new LinkedList<GeneralTree<Integer>>();
        children.add(a1);
        children.add(a2);
		children.add(a3);
        GeneralTree<Integer> a = new GeneralTree<Integer>(100, children);

	    ParcialArboles devolverArboles = new ParcialArboles();
		List<GeneralTree<Integer>> lista = devolverArboles.devolverArboles(a);
        System.out.println("hola");
        for (GeneralTree<Integer> arbol : lista) {
            System.out.println(arbol.getData());
        }
	}
}
