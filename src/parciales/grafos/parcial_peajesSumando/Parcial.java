package parciales.grafos.parcial_peajesSumando;

import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;
import tp5.ejercicio1.adjList.AdjListGraph;

import java.util.*;

public class Parcial {
    
    public List<String> caminoConPresupuesto(Graph<String> ciudades, String origen, String destino, int montoMinimo){
        List<String> camino = new LinkedList<String>();
        if (!ciudades.isEmpty()){
            Vertex<String> ori = ciudades.search(origen);
            Vertex<String> desti = ciudades.search(destino);
            if (ori != null && desti != null){
                dfs(ciudades, ori, desti, camino, new boolean[ciudades.getSize()], 0, montoMinimo);
            }
        }
        return camino;
    }

    private boolean dfs(Graph<String> ciudades, Vertex<String> origen, Vertex<String> destino, List<String> camino, boolean [] visitados, int montoActual, int montoMinimo){
        boolean ok = false;
        visitados[origen.getPosition()] = true;
        camino.add(origen.getData());

        if (origen.getData().equals(destino.getData()) && montoActual > montoMinimo){
            ok = true;
        }else {
            List<Edge<String>> edges = ciudades.getEdges(origen);
            Iterator<Edge<String>> iter = edges.iterator();
            while (iter.hasNext() && !ok){
                Edge<String> arista = iter.next();
                Vertex<String> vertice = arista.getTarget();
                if (!visitados[vertice.getPosition()]){
                    ok = dfs(ciudades, vertice, destino, camino, visitados, montoActual + arista.getWeight(), montoMinimo);
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
        Vertex<String> v1 = grafo.createVertex("Lincoln");
        Vertex<String> v2 = grafo.createVertex("Chascomús");
        Vertex<String> v3 = grafo.createVertex("Cañuelas");
        Vertex<String> v4 = grafo.createVertex("Dolores");
        Vertex<String> v5 = grafo.createVertex("Verónica");
        Vertex<String> v6 = grafo.createVertex("Villa Urquiza");
        Vertex<String> v7 = grafo.createVertex("Ranchos");
        Vertex<String> v8 = grafo.createVertex("Berisso");
        
        grafo.connect(v1, v2, 70);
        grafo.connect(v2, v1, 70);
        grafo.connect(v1, v3, 50);
        grafo.connect(v3, v1, 50);
        grafo.connect(v1, v4, 90);
        grafo.connect(v4, v1, 90);
        grafo.connect(v2, v5, 80);
        grafo.connect(v5, v2, 80);
        grafo.connect(v2, v6, 60);
        grafo.connect(v6, v2, 60);
        grafo.connect(v3, v5, 85);
        grafo.connect(v5, v3, 85);
        grafo.connect(v3, v7, 90);
        grafo.connect(v7, v3, 90);
        grafo.connect(v4, v6, 70);
        grafo.connect(v6, v4, 70);
        grafo.connect(v4, v7, 70);
        grafo.connect(v7, v4, 70);
        grafo.connect(v5, v8, 60);
        grafo.connect(v8, v5, 60);
        grafo.connect(v6, v8, 90);
        grafo.connect(v8, v6, 90);
        grafo.connect(v7, v8, 75);
        grafo.connect(v8, v7, 75);
        
        Parcial p = new Parcial();
        
        System.out.println(p.caminoConPresupuesto(grafo, "Lincoln", "Berisso", 200));
    }
}
