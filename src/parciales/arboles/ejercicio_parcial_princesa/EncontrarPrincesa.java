package parciales.arboles.ejercicio_parcial_princesa;

import tp3.ejercicio5.GeneralTree;
import java.util.*;

/*Dado un árbol general compuesto por personajes, donde 
puede haber dragones, princesas y otros, se denominan 
nodos accesibles a aquellos nodos tales que a lo largo 
del camino del nodo raíz del árbol hasta el nodo (ambos 
inclusive) no se encuentra ningún dragón. 
Implementar un método que devuelva una lista con un camino desde la raíz a una Princesa sin 
pasar por un Dragón –sin necesidad de ser el más cercano a la raíz-. Asuma que existe al menos 
un camino accesible */

public class EncontrarPrincesa {

    public EncontrarPrincesa (){

    }

    public List<Personaje> devolverCamino(GeneralTree<Personaje> arbol){
        List<Personaje> camino = new LinkedList<>();
        if (!arbol.isEmpty() && !arbol.getData().getTipo().equals("Dragon")){
            resolver( arbol, camino);
        }
        return camino;
    }

    private boolean resolver(GeneralTree<Personaje> arbol, List<Personaje> camino){
        boolean ok = false;
        camino.add(arbol.getData());
        if (arbol.getData().getTipo().equals("Princesa")){
            ok = true;
        }else{
            List<GeneralTree<Personaje>> children = arbol.getChildren();
            Iterator<GeneralTree<Personaje>> iter = children.iterator();
            
            while (iter.hasNext() && !ok){
                GeneralTree<Personaje> child = iter.next();
                if (!child.getData().getTipo().equals("Dragon")){
                    ok = resolver(child, camino);
                }
            }
        }
        if (!ok){
            camino.remove(camino.size()-1);
        }
        return ok;
    }
}
