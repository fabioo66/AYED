package parciales.grafos.parcial_caminoPandemia_2;

import java.util.*;

import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;
import tp5.ejercicio1.adjList.AdjListGraph;

public class Parcial {
    
    public List<String> resolver(Graph<Ciudad> ciudades, String origen, String destino){
        List<String> camino = new LinkedList<String>();
        if (!ciudades.isEmpty()){
            Vertex<Ciudad> ori = buscarCiudad(ciudades, origen);
            Vertex<Ciudad> desti = buscarCiudad(ciudades, destino);
            if (ori != null && desti != null && !ori.getData().getFase().equals("Fase 1") && !desti.getData().getFase().equals("Fase 1")){
                dfs(ciudades, ori, desti, camino, new boolean [ciudades.getSize()]);
            }
        }
        return camino;
    }

    private boolean dfs(Graph<Ciudad> ciudades, Vertex<Ciudad> origen, Vertex<Ciudad> destino, List<String> camino, boolean [] visitados){
        boolean ok = false;
        visitados[origen.getPosition()] = true;
        camino.add(origen.getData().getNombre());

        if (origen.getData().getNombre().equals(destino.getData().getNombre())){
            ok = true;
        }else {
            List<Edge<Ciudad>> edges = ciudades.getEdges(origen);
            Iterator<Edge<Ciudad>> iter = edges.iterator();
            while(iter.hasNext() && !ok){
                Edge<Ciudad> arista = iter.next();
                Vertex<Ciudad> vertice = arista.getTarget();
                if (!visitados[vertice.getPosition()] && !vertice.getData().getFase().equals("Fase 1")){
                    ok = dfs(ciudades, vertice, destino, camino, visitados);
                }
            }
        }
        if (!ok){
            camino.remove(camino.size()-1);
        }
        visitados[origen.getPosition()] = false;
        return ok;
    }

    private Vertex<Ciudad> buscarCiudad(Graph<Ciudad> ciudades, String ciudad){
        boolean ok = false;
        Vertex<Ciudad> vertice = null;
        
        List<Vertex<Ciudad>> vertices = ciudades.getVertices();
        Iterator<Vertex<Ciudad>> iter = vertices.iterator();
        while (iter.hasNext() && !ok){
            Vertex<Ciudad> v = iter.next();
            if (v.getData().getNombre().equals(ciudad)){
                ok = true;
                vertice = v;
            }
        }
        return vertice;
    }
     public static void main(String args[]) {
        Graph<Ciudad> grafo = new AdjListGraph<Ciudad>();
        //Descarte Saladillo, Lobos y Pinamar
        Vertex<Ciudad> v1 = grafo.createVertex(new Ciudad("Suipacha", "Fase 5"));
        Vertex<Ciudad> v2 = grafo.createVertex(new Ciudad("Carlos Keen", "Fase 3"));
        Vertex<Ciudad> v3 = grafo.createVertex(new Ciudad("Moreno", "Fase 1"));
        Vertex<Ciudad> v4 = grafo.createVertex(new Ciudad("Quilmes", "Fase 1"));
        Vertex<Ciudad> v5 = grafo.createVertex(new Ciudad("Navarro", "Fase 4"));
        Vertex<Ciudad> v6 = grafo.createVertex(new Ciudad("Cañuelas", "Fase 3"));
        Vertex<Ciudad> v7 = grafo.createVertex(new Ciudad("Abasto", "Fase 2"));
        Vertex<Ciudad> v8 = grafo.createVertex(new Ciudad("La Plata", "Fase 2"));
        
        grafo.connect(v1, v2);
        grafo.connect(v2, v1);
        grafo.connect(v2, v3);
        grafo.connect(v3, v2);
        grafo.connect(v3, v4);
        grafo.connect(v4, v3);
        grafo.connect(v1, v5);
        grafo.connect(v5, v1);
        grafo.connect(v5, v6);
        grafo.connect(v6, v5);
        grafo.connect(v6, v7);
        grafo.connect(v7, v6);
        grafo.connect(v7, v3);
        grafo.connect(v3, v7);
        grafo.connect(v7, v8);
        grafo.connect(v8, v7);
        grafo.connect(v8, v4);
        grafo.connect(v4, v8);
        
        Parcial p = new Parcial();
        
        System.out.println(p.resolver(grafo, "La Plata", "Carlos Keen"));
    }
}
