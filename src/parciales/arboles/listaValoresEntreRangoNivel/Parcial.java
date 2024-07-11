package parciales.arboles.listaValoresEntreRangoNivel;

import java.util.LinkedList;
import tp3.ejercicio5.GeneralTree;

import java.util.*;

public class Parcial {
    
    public List<Objeto> resolver(int menor, int mayor, GeneralTree<Integer> arbol){
        List<Objeto> lista = new LinkedList<>();
        if (!arbol.isEmpty()){
            postOrden(arbol, lista, menor, mayor, 0);
        }
        return lista;
    }

    private void postOrden(GeneralTree<Integer> arbol, List<Objeto> lista, int menor, int mayor, int nivel){
        for (GeneralTree<Integer> child : arbol.getChildren()){
            postOrden(child, lista, menor, mayor, nivel+1);
        }
        if (arbol.getData() >= menor && arbol.getData() <= mayor){
            lista.add(new Objeto(arbol.getData(), nivel));
        }
    }
}
