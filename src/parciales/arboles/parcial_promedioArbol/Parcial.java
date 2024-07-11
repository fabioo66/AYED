package parciales.arboles.parcial_promedioArbol;

import tp3.ejercicio5.GeneralTree;
import java.util.*;

public class Parcial {
    
    public int resolver(GeneralTree<Integer> arbol, int min, int max){
        Objeto objeto = new Objeto();
        if (!arbol.isEmpty()){
            inOrden(arbol, min, max, objeto);
        }
        return objeto.getPromedio();
    }

    private void inOrden(GeneralTree<Integer> arbol, int min, int max, Objeto objeto){
        List<GeneralTree<Integer>> children = arbol.getChildren();
        if (arbol.hasChildren()){
            inOrden(children.getFirst(), min, max, objeto);
        }
        if (arbol.getData() >= min && arbol.getData() <= max){
            objeto.sumar(arbol.getData());
        }
        for (int i=1; i < children.size(); i++){
            inOrden(children.get(i), min, max, objeto);
        }
    }
}

