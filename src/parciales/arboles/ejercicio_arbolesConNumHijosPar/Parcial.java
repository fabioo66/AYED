package parciales.arboles.ejercicio_arbolesConNumHijosPar;

import tp3.ejercicio5.GeneralTree;
import java.util.*;

public class Parcial {
    
    public List<GeneralTree<Integer>> resolver(GeneralTree<Integer> arbol){
        List<GeneralTree<Integer>> lista = new LinkedList<GeneralTree<Integer>>();
        if (!arbol.isEmpty()){
            resolver(arbol, lista);
        }
        return lista;
    }  

    public void resolver(GeneralTree<Integer> arbol, List<GeneralTree<Integer>> lista){
        if (!arbol.isLeaf() && arbol.getChildren().size() % 2 == 0){
            lista.add(arbol);
        }else{
            List<GeneralTree<Integer>> children = arbol.getChildren();
            for (GeneralTree<Integer> child : children){
                resolver(child);
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
        List<GeneralTree<Integer>> lis = p.resolver(a);
        for(GeneralTree<Integer> h: lis) {
            System.out.print(h.getData() + " ~ ");
        }
    }
}
