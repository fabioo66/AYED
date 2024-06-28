package parciales.arboles.parcial_productoHojasProfundas;

import tp1.ejercicio8.Queue;
import tp3.ejercicio5.GeneralTree;
import java.util.*;

public class Parcial {
    
    public int resolver(GeneralTree<Integer> arbol){
        if (arbol.isEmpty()){
            return 0;
        }else{
            Queue<GeneralTree<Integer>> cola = new Queue<GeneralTree<Integer>>();

            cola.enqueue(arbol);
            cola.enqueue(null);

            int nivelActual = 0;
            int nivelMax = Integer.MIN_VALUE;
            int producto = 1;

            while (!cola.isEmpty()){
                GeneralTree<Integer> ab = cola.dequeue();
                if (ab != null){
                    if (ab.isLeaf()){
                        if (nivelActual > nivelMax){
                            nivelMax = nivelActual;
                            producto = ab.getData();  // Reiniciar el producto al encontrar un nuevo nivel máximo.
                        } else if (nivelActual == nivelMax){
                            producto *= ab.getData();
                        }
                    }
                    if (ab.isLeaf() && nivelActual > nivelMax){
                        nivelMax = nivelActual;
                        producto *= ab.getData();
                    }
                    List<GeneralTree<Integer>> children = arbol.getChildren();
                    for (GeneralTree<Integer> child : children){
                        cola.enqueue(child);
                    }
                }else{
                    if (!cola.isEmpty()){
                        nivelActual++;
                        cola.enqueue(null);
                    }
                }
            }
        if (producto != 1){
            return producto;
        }else{
            return 0;
        }
        }
    }

    public static void main(String[] args) {
        //List<GeneralTree<Integer>> subChildren1 = new LinkedList<GeneralTree<Integer>>();
        //subChildren1.add(new GeneralTree<Integer>(2));
        GeneralTree<Integer> subAb1 = new GeneralTree<Integer>(7);
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
