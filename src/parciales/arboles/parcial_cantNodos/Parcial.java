package parciales.arboles.parcial_cantNodos;

import java.util.LinkedList;
import java.util.List;

import tp3.ejercicio5.GeneralTree;

public class Parcial {

    public int resolver(GeneralTree<Integer> arbol){
        int cantNodos = 0;
        int cantNodosTotales = 0;
        List<Integer> lista = new LinkedList<Integer>();
        if (!arbol.isEmpty()){
            cantNodosTotales = procesar(arbol, lista);
            System.out.println("Cantidad de nodos totales =" + cantNodosTotales);
            if (cantNodosTotales % 2 == 0){
                for (Integer num : lista){
                    if (num >= 0){
                        cantNodos += 1;
                    }
                }
            }else{
                for (Integer num : lista){
                    if (num < 0){
                        cantNodos += 1;
                    }
                }
            }
        }
        return cantNodos;
    }

    private int procesar (GeneralTree<Integer> arbol, List<Integer> lista){
        int cant = 1;
        lista.add(arbol.getData());
        List<GeneralTree<Integer>> children = arbol.getChildren();
        for (GeneralTree<Integer> child : children){
            cant += procesar(child, lista);
        }
        return cant;
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
        System.out.println(p.resolver(a));
    }
}
