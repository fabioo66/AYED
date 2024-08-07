package parciales.arboles.parcial_hojaMasLejana;

import java.util.LinkedList;
import java.util.List;

import tp3.ejercicio1.GeneralTree;

public class Parcial {
    
    public List<Integer> caminoMasLargo(GeneralTree<Integer> ab) {
        List<Integer> camino = new LinkedList<Integer>();
        if (!ab.isEmpty()){
            procesar(ab, camino, new LinkedList<Integer>());
        }
        return camino;
    }

    private void procesar(GeneralTree<Integer> ab, List<Integer> camino, List<Integer> caminoActual){
        caminoActual.add(ab.getData());
        if (ab.isLeaf() && caminoActual.size() > camino.size()){
            camino.removeAll(camino);
            camino.addAll(caminoActual);
        }else{
            List<GeneralTree<Integer>> children = ab.getChildren();
            for (GeneralTree<Integer> child : children){
                procesar(child, camino, caminoActual);
            }
        }
        caminoActual.remove(caminoActual.size()-1);
    }

    public static void main(String main[]) {
        List<GeneralTree<Integer>> subChildren1 = new LinkedList<GeneralTree<Integer>>();
        subChildren1.add(new GeneralTree<Integer>(2));
        GeneralTree<Integer> subAb1 = new GeneralTree<Integer>(7, subChildren1);
        List<GeneralTree<Integer>> subChildren2 = new LinkedList<GeneralTree<Integer>>();
        subChildren2.add(new GeneralTree<Integer>(4));
        subChildren2.add(subAb1);
        subChildren2.add(new GeneralTree<Integer>(6));
        GeneralTree<Integer> a1 = new GeneralTree<Integer>(3, subChildren2);
        
        List<GeneralTree<Integer>> subChildren3 = new LinkedList<GeneralTree<Integer>>();
        subChildren3.add(new GeneralTree<Integer>(1));
        subChildren3.add(new GeneralTree<Integer>(9));
        subChildren3.add(new GeneralTree<Integer>(10));
        GeneralTree<Integer> a2 = new GeneralTree<Integer>(5, subChildren3);
        
        List<GeneralTree<Integer>> arbol = new LinkedList<GeneralTree<Integer>>();
        arbol.add(a1);
        arbol.add(a2);
        GeneralTree<Integer> a = new GeneralTree<Integer>(8, arbol);
        
        Parcial cam = new Parcial();
        System.out.println(cam.caminoMasLargo(a));
    }
}
