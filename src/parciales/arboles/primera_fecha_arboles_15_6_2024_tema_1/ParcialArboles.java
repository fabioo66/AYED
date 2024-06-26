package parciales.arboles.primera_fecha_arboles_15_6_2024_tema_1;

import tp3.ejercicio1.GeneralTree;
import java.util.*;

public class ParcialArboles {
    GeneralTree<Integer> arbol = new GeneralTree<>();

    public ParcialArboles(GeneralTree<Integer> arbol) {
        this.arbol = arbol;
    }

    public List<Integer> camino (int num){
        List<Integer> caminito = new LinkedList<>();
        if (!this.arbol.isEmpty()){
            procesar(this.arbol, caminito, num);
        }
        return caminito;
    }

    private boolean procesar(GeneralTree<Integer> arbol, List<Integer> caminoActual, int num){
        boolean ok = false;
        if (!arbol.isLeaf() && arbol.getChildren().size() >= num){
            caminoActual.add(arbol.getData());
            List<GeneralTree<Integer>> children = arbol.getChildren();
            Iterator<GeneralTree<Integer>> iter = children.iterator();
            while (iter.hasNext() && !ok){
                GeneralTree<Integer> child = iter.next();
                ok = procesar(child, caminoActual, num);
            }
        }else if (!caminoActual.isEmpty()){
            ok = true;
            caminoActual.add(arbol.getData());
        }
        if (!ok){
            caminoActual.remove(caminoActual.size()-1);
        }
        return ok;
    }

    public static void main (String [] args){

        List<GeneralTree<Integer>> children1 = new LinkedList<GeneralTree<Integer>>();
        children1.add(new GeneralTree<Integer>(6));
        GeneralTree<Integer> subAb1 = new GeneralTree<Integer>(5, children1);
        
        List<GeneralTree<Integer>> children2 = new LinkedList<GeneralTree<Integer>>();
        children2.add(new GeneralTree<Integer>(28));
        children2.add(new GeneralTree<Integer>(55));
        children2.add(new GeneralTree<Integer>(18));
        GeneralTree<Integer> subAb2 = new GeneralTree<Integer>(22, children2);
        
        List<GeneralTree<Integer>> children3 = new LinkedList<GeneralTree<Integer>>();
        children3.add(new GeneralTree<Integer>(4));
        GeneralTree<Integer> subAb3 = new GeneralTree<Integer>(19, children3);
        
        List<GeneralTree<Integer>> children4 = new LinkedList<GeneralTree<Integer>>();
        children4.add(subAb1);
        children4.add(subAb2);
        GeneralTree<Integer> a1 = new GeneralTree<Integer>(8, children4);

        GeneralTree<Integer> a5 = new GeneralTree<Integer>(42);
        
        List<GeneralTree<Integer>> children6 = new LinkedList<GeneralTree<Integer>>();
        children6.add(subAb3);
        children6.add(new GeneralTree<Integer>(-9));
        GeneralTree<Integer> a2 = new GeneralTree<Integer>(-5, children6);
        
        List<GeneralTree<Integer>> ab = new LinkedList<GeneralTree<Integer>>();
        ab.add(a1);
        ab.add(a5);
        ab.add(a2);
        GeneralTree<Integer> a = new GeneralTree<Integer>(10, ab);

        ParcialArboles p = new ParcialArboles(a);

        System.out.println(p.camino(2)); //[10, 8, 22, 28]
        System.out.println(p.camino(3)); //[10, 42]
    }
}
