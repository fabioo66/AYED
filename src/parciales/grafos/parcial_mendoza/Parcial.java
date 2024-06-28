package parciales.grafos.parcial_mendoza;

import java.util.*;

import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;
import tp5.ejercicio1.adjList.AdjListGraph;

public class Parcial {
    
    public List<String> recorrido(Graph<String> grafo, int cantLocalidades, int cantNafta, List<String> localidadesExceptuadas){
        List<String> camino = new LinkedList<String>();
        if(!grafo.isEmpty()){
            Vertex<String> origen = grafo.search("Mendoza");
            if (origen != null){
                dfs(grafo, origen, camino, new boolean [grafo.getSize()], cantLocalidades, cantNafta, localidadesExceptuadas);
            }
        }
        return camino;
    }

    private boolean dfs(Graph<String> grafo, Vertex<String> origen, List<String> camino, boolean [] visitados, int cantLocalidades, int cantNafta, List<String> localidadesExceptuadas){
        boolean ok = false;
        camino.add(origen.getData());
        visitados[origen.getPosition()] = true;

        if (camino.size() == cantLocalidades){
            ok = true;
        }else {
            List<Edge<String>> edges = grafo.getEdges(origen);
            Iterator<Edge<String>> iter = edges.iterator();
            while (iter.hasNext() && !ok){
                Edge<String> arista = iter.next();
                Vertex<String> vertice = arista.getTarget();
                if (!visitados[vertice.getPosition()] && cantNafta - arista.getWeight() >= 0 && !localidadesExceptuadas.contains(vertice.getData())){
                    ok = dfs(grafo, vertice, camino, visitados, cantLocalidades, cantNafta - arista.getWeight(), localidadesExceptuadas);
                }
            }
        }
        if (!ok){
            camino.remove(camino.size()-1);
        }
        visitados[origen.getPosition()] = false;
        return ok;
    }

    public static void main(String args[]) {
        Graph<String> grafo = new AdjListGraph<String>();
        Vertex<String> v1 = grafo.createVertex("Mendoza");
        Vertex<String> v2 = grafo.createVertex("Tunuyán");
        Vertex<String> v3 = grafo.createVertex("San Martin");
        Vertex<String> v4 = grafo.createVertex("La Paz");
        Vertex<String> v5 = grafo.createVertex("Santa Rosa");
        Vertex<String> v6 = grafo.createVertex("San Rafael");
        Vertex<String> v7 = grafo.createVertex("Malargue");
        Vertex<String> v8 = grafo.createVertex("General Alvear");
        
        grafo.connect(v1, v2, 10);
        grafo.connect(v1, v3, 6);
        grafo.connect(v2, v3, 10);
        grafo.connect(v3, v4, 8);
        grafo.connect(v4, v5, 2);
        grafo.connect(v3, v6, 13);
        grafo.connect(v6, v2, 11);
        grafo.connect(v6, v8, 7);
        grafo.connect(v2, v7, 12);
        grafo.connect(v8, v7, 6);
        
        List<String> localidadesExceptuadas = new LinkedList<String>();
        localidadesExceptuadas.add("General Alvear");
        localidadesExceptuadas.add("La Paz");
        
        Parcial p = new Parcial();
        
        System.out.println(p.recorrido(grafo, 5, 80, localidadesExceptuadas));
    }
}
