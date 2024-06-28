package parciales.grafos.parcial_estadiosQatar;

import java.util.*;

import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;
import tp5.ejercicio1.adjList.AdjListGraph;


public class Parcial {
    
    public List<String> estadios(Graph<Estadio> mapaEstadios, String estadioOrigen, int cantKm){
        List<String> camino = new LinkedList<String>();
        if (!mapaEstadios.isEmpty()){
            Vertex<Estadio> origen = buscarOrigen(mapaEstadios, estadioOrigen);
            if (origen != null){
                dfs(mapaEstadios, origen, camino, new LinkedList<String>(), new boolean [mapaEstadios.getSize()], cantKm);
            }
        }
        return camino;
    }

    public void dfs(Graph<Estadio> mapaEstadios, Vertex<Estadio> origen, List<String> camino, List<String> caminoActual, boolean [] visitados, int cantKm){
        
        visitados[origen.getPosition()] = true;
        caminoActual.add(origen.getData().getEstadio());
        
        List<Edge<Estadio>> edges = mapaEstadios.getEdges(origen);
        for (Edge<Estadio> arista : edges){
            if (!visitados[arista.getTarget().getPosition()] && cantKm - arista.getWeight() >= 0){
                dfs(mapaEstadios, arista.getTarget(), camino, caminoActual, visitados, cantKm - arista.getWeight());  
            }
        }
        if (caminoActual.size() > camino.size()){
            camino.clear();
            camino.addAll(caminoActual);
        }
        visitados[origen.getPosition()] = false;
        caminoActual.remove(caminoActual.size()-1);
    }

    private Vertex<Estadio> buscarOrigen(Graph<Estadio> mapaEstadios, String estadioOrigen){
        boolean ok = false;
        Vertex<Estadio> vertice = null;
        
        List<Vertex<Estadio>> vertices = mapaEstadios.getVertices();
        Iterator<Vertex<Estadio>> iter = vertices.iterator();
        while (iter.hasNext() && !ok){
            Vertex<Estadio> v = iter.next();
            if (v.getData().getEstadio().equals(estadioOrigen)){
                ok = true;
                vertice = v;
            }
        }
        return vertice;
    }

    public static void main(String args[]) {
        Graph<Estadio> grafo = new AdjListGraph<Estadio>();
        Vertex<Estadio> v1 = grafo.createVertex(new Estadio("Jor", "AI BAYT STADIUM"));
        Vertex<Estadio> v2 = grafo.createVertex(new Estadio("Lusail", "LUSAIL STADIUM"));
        Vertex<Estadio> v3 = grafo.createVertex(new Estadio("Rayán", "EDUCATION CITY STADIUM"));
        Vertex<Estadio> v4 = grafo.createVertex(new Estadio("Rayán", "AL RAYYAN STADIUM"));
        Vertex<Estadio> v5 = grafo.createVertex(new Estadio("Doha", "STADIUM 947"));
        Vertex<Estadio> v6 = grafo.createVertex(new Estadio("Doha", "KHALIFA INTERNATIONAL STADIUM"));
        Vertex<Estadio> v7 = grafo.createVertex(new Estadio("Doha", "AL THUMAMA STADIUM"));
        Vertex<Estadio> v8 = grafo.createVertex(new Estadio("Wakrah", "AL JANOUB STADIUM"));
        
        grafo.connect(v1, v2, 42);
        grafo.connect(v2, v1, 42);
        grafo.connect(v2, v3, 24);
        grafo.connect(v3, v2, 24);
        grafo.connect(v2, v5, 52);
        grafo.connect(v5, v2, 52);
        grafo.connect(v3, v4, 11);
        grafo.connect(v4, v3, 11);
        grafo.connect(v4, v6, 8);
        grafo.connect(v6, v4, 8);
        grafo.connect(v6, v7, 12);
        grafo.connect(v7, v6, 12);
        grafo.connect(v7, v8, 12);
        grafo.connect(v8, v7, 12);
        grafo.connect(v8, v5, 19);
        grafo.connect(v5, v8, 19);
        
        Parcial p = new Parcial();
        
        System.out.println(p.estadios(grafo, "AI BAYT STADIUM", 100));
    }
}
