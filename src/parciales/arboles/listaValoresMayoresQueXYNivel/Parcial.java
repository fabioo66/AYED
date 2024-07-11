package parciales.arboles.listaValoresMayoresQueXYNivel;

import java.util.*;

import tp3.ejercicio3.GeneralTree;


public class Parcial {
    
    public List<Objeto> resolver(GeneralTree<Integer> arbol, int valor){
        List<Objeto> lista = new LinkedList<>();
        if (!arbol.isEmpty()){
            inOrden(arbol, lista, valor, 0);
        }
        return lista;
    }

    private void inOrden(GeneralTree<Integer> arbol, List<Objeto> lista, int valor, int nivel){
        List<GeneralTree<Integer>> children = arbol.getChildren();
        if (arbol.hasChildren()){
            inOrden(children.getFirst(), lista, valor, nivel+1);
        }
        if (arbol.getData() > valor){
            lista.add(new Objeto(arbol.getData(), nivel));
        }
        for (int i=1; i < children.size(); i++){
            inOrden(children.get(i), lista, valor, nivel+1);
        }
    }


}
