package parciales.arboles.parcial_promedioArbol;

import tp3.ejercicio5.GeneralTree;
import java.util.*;

public class Parcial {
    
    public int resolver(GeneralTree<Integer> arbol, int min, int max){
        if (!arbol.isEmpty()){
            Objeto objeto = new Objeto();
            procesar(arbol, min, max, objeto);
            return objeto.promedio();
        }else{
            return 0;
        }
    }

    private void procesar(GeneralTree<Integer> arbol, int min, int max, Objeto objeto){
        if (arbol.getData() >= min && arbol.getData() <= max){
            objeto.agregar(arbol.getData());
        }else {
            List<GeneralTree<Integer>> children = arbol.getChildren();
            for (GeneralTree<Integer> child : children){
                procesar(child, min, max, objeto);
            }
        }
    }

    public static void main(String[] args) {
        List<GeneralTree<Integer>> subChildren1 = new LinkedList<GeneralTree<Integer>>();
        subChildren1.add(new GeneralTree<Integer>(2));
        GeneralTree<Integer> subAb1 = new GeneralTree<Integer>(7, subChildren1);
        List<GeneralTree<Integer>> subChildren2 = new LinkedList<GeneralTree<Integer>>();
        subChildren2.add(new GeneralTree<Integer>(-4));
        subChildren2.add(subAb1);
        subChildren2.add(new GeneralTree<Integer>(-6));
        GeneralTree<Integer> a1 = new GeneralTree<Integer>(3, subChildren2);
        
        List<GeneralTree<Integer>> subChildren3 = new LinkedList<GeneralTree<Integer>>();
        subChildren3.add(new GeneralTree<Integer>(1));
        subChildren3.add(new GeneralTree<Integer>(-9));
        subChildren3.add(new GeneralTree<Integer>(10));
        GeneralTree<Integer> a2 = new GeneralTree<Integer>(5, subChildren3);
        
        List<GeneralTree<Integer>> arbol = new LinkedList<GeneralTree<Integer>>();
        arbol.add(a1);
        arbol.add(a2);
        GeneralTree<Integer> a = new GeneralTree<Integer>(-7, arbol);
        
        Parcial p = new Parcial();
        System.out.println(p.resolver(a, 2, 8));
    }
}
