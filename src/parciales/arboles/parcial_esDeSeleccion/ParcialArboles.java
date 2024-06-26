package parciales.arboles.parcial_esDeSeleccion;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import tp3.ejercicio5.GeneralTree;

public class ParcialArboles {
    
    public static boolean esDeSeleccion(GeneralTree<Integer> arbol){
        boolean ok = false;
        if (!arbol.isEmpty()){
            ok = procesar(arbol);
        }
        return ok;
    }

    private static boolean procesar(GeneralTree<Integer> arbol){
        if (arbol.isLeaf()){
            return true;
        }else{
            boolean ok = true;
            int padre = arbol.getData();
            int min = Integer.MAX_VALUE;

            List<GeneralTree<Integer>> children = arbol.getChildren();
            Iterator<GeneralTree<Integer>> iter = children.iterator();
            while(iter.hasNext() && !ok) {
                GeneralTree<Integer> child = iter.next();
                if (child.getData() < min){
                    min = child.getData();
                }
                ok = procesar(child);
            }
            return ok && min == padre;
        }
    }

    public static void main(String[] args) {
		GeneralTree<Integer> a1 = new GeneralTree<Integer>(1);
		List<GeneralTree<Integer>> children2 = new LinkedList<GeneralTree<Integer>>();
		children2.add(new GeneralTree<Integer>(22));
		children2.add(new GeneralTree<Integer>(21));
		children2.add(new GeneralTree<Integer>(23));
		GeneralTree<Integer> a2 = new GeneralTree<Integer>(21, children2);
		List<GeneralTree<Integer>> children3 = new LinkedList<GeneralTree<Integer>>();
		children3.add(new GeneralTree<Integer>(31));
		children3.add(new GeneralTree<Integer>(32));
		GeneralTree<Integer> a3 = new GeneralTree<Integer>(31, children3);
		List<GeneralTree<Integer>> children = new LinkedList<GeneralTree<Integer>>();
		children.add(a1);
		children.add(a2);
		children.add(a3);
		GeneralTree<Integer> a = new GeneralTree<Integer>(1, children);
        
        System.out.println("Es de seleccion el primer arbol: " + esDeSeleccion(a));
	}
}
