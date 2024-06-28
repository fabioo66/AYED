package parciales.grafos.parcial_mundialSub20;

import java.util.*;

import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;
import tp5.ejercicio1.adjList.AdjListGraph;

public class Parcial {
    
    public List<Objeto> resolver(Graph<String> sitios, String origen, String destino, List<String> evitarPasarPor){
        List<Objeto> lista = new LinkedList<Objeto>();
        if (!sitios.isEmpty()){
            Vertex<String> ori = sitios.search(origen);
            Vertex<String> desti = sitios.search(destino);
            if (ori != null && desti != null){
                dfs(sitios, ori, desti, lista, new LinkedList<String>(), new boolean [sitios.getSize()], evitarPasarPor, 0);
            }
        }
        return lista;
    }

    private void dfs(Graph<String> sitios, Vertex<String> origen, Vertex<String> destino, List<Objeto> lista, List<String> caminoActual, boolean [] visitados, List<String> evitarPasarPor, int cuadras){
        visitados[origen.getPosition()] = true;
        caminoActual.add(origen.getData());

        if (origen.equals(destino)){
            lista.add(new Objeto(new LinkedList<String>(caminoActual), cuadras));
        }else {
            List<Edge<String>> edges = sitios.getEdges(origen);
            for (Edge<String> arista : edges){
                if (!visitados[arista.getTarget().getPosition()] && !evitarPasarPor.contains(arista.getTarget().getData())){
                    dfs(sitios, arista.getTarget(), destino, lista, caminoActual, visitados, evitarPasarPor, cuadras + arista.getWeight());
                }
            }
        }
        caminoActual.remove(caminoActual.size()-1);
        visitados[origen.getPosition()] = false;
    }

    public static void main(String args[]) {
        Graph<String> grafo = new AdjListGraph<String>();
        Vertex<String> v1 = grafo.createVertex("Estadio Diego Armando Maradona");
        Vertex<String> v2 = grafo.createVertex("Legislatura");
        Vertex<String> v3 = grafo.createVertex("Coliseo Podestá");
        Vertex<String> v4 = grafo.createVertex("MACLA");
        Vertex<String> v5 = grafo.createVertex("Catedral La Plata");
        Vertex<String> v6 = grafo.createVertex("Palacio Campodónico");
        Vertex<String> v7 = grafo.createVertex("Rectorado UNLP");
        Vertex<String> v8 = grafo.createVertex("Museo UNLP");
        
        grafo.connect(v1, v2, 25);
        grafo.connect(v2, v1, 25);
        grafo.connect(v1, v3, 20);
        grafo.connect(v3, v1, 20);
        grafo.connect(v1, v4, 35);
        grafo.connect(v4, v1, 35);
        grafo.connect(v1, v5, 40);
        grafo.connect(v5, v1, 40);
        grafo.connect(v2, v3, 25);
        grafo.connect(v3, v2, 25);
        grafo.connect(v4, v5, 8);
        grafo.connect(v5, v4, 8);
        grafo.connect(v5, v7, 5);
        grafo.connect(v7, v5, 5);
        grafo.connect(v3, v6, 10);
        grafo.connect(v6, v3, 10);
        grafo.connect(v6, v7, 30);
        grafo.connect(v7, v6, 30);
        grafo.connect(v7, v8, 15);
        grafo.connect(v8, v7, 15);
        
        List<String> evitarPasarPor = new LinkedList<String>();
        evitarPasarPor.add("Legislatura");
        evitarPasarPor.add("MACLA");
        
        Parcial p = new Parcial();
        List<Objeto> lis = p.resolver(grafo, "Estadio Diego Armando Maradona", "Palacio Campodónico", evitarPasarPor);
        
        for(Objeto aux: lis) {
            System.out.println(aux);
        }
    }
}
