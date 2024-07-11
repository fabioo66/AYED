package parciales.arboles.listaFrontera;

import java.util.*;
import tp3.ejercicio5.GeneralTree;

public class Parcial {
    private GeneralTree<Integer> arbol;

    public List<Integer> resolver(){
        List<Integer> lista = new LinkedList<>();
        if (!this.arbol.isEmpty()){
            procesar(this.arbol, lista);
        }
        return lista;
    }

    private void procesar(GeneralTree<Integer> arbol, List<Integer> lista){
        if (arbol.isLeaf() && arbol.getData() % 2 == 0){
            lista.add(arbol.getData());
        }
        for (GeneralTree<Integer> child : arbol.getChildren()){
            procesar(child, lista);
        }
    }
}
