package parciales.arboles.ejercicio_parcial_directorios;

import java.util.*;

import tp3.ejercicio5.GeneralTree;
import tp1.ejercicio8.Queue;

/* Dado un árbol que representa una estructura de directorios, implementar un 
método que reciba un nivel y retorne una lista con las imágenes encontradas en ese nivel. 
Modelar el recurso para representar las carpetas y los archivos. */

public class DevolverImagenes {
    
    public DevolverImagenes(){

    }

    public List<Recurso> imagenes(GeneralTree<Recurso> arbol, int nivel){
        List<Recurso> lista = new LinkedList<>();

        if (!arbol.isEmpty()){

            Queue<GeneralTree<Recurso>> cola = new Queue<>();
            cola.enqueue(arbol);
            cola.enqueue(null);

            int level = 0;
            while (!cola.isEmpty() && level <= nivel){
                GeneralTree<Recurso> ab = cola.dequeue();
                if (ab != null){
                    if (nivel == level && ab.getData().esImagen()){
                        lista.add(ab.getData());
                    }
                    List<GeneralTree<Recurso>> children = arbol.getChildren();
                    for (GeneralTree<Recurso> child : children){
                        cola.enqueue(child);
                    }
                }else if (!cola.isEmpty()){
                    level++;
                    cola.enqueue(null);
                }
            }
        }
        return lista;
    }
}
