package parciales.grafos.simulacro_parcial_2024;

import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;
import tp5.ejercicio1.adjList.AdjListGraph;

import java.util.*;

public class Parcial {
    
    public List<String> resolver(Graph<Ciudad> grafo, String ciudad, int cantDiasVaca){
        List<String> camino = new LinkedList<String>();
        if (!grafo.isEmpty()){
            Vertex<Ciudad> origen = buscarCiudad(grafo, ciudad);
            if (origen != null && cantDiasVaca - origen.getData().getDias() > 0){
                dfs(grafo, origen, camino, new LinkedList<String>(), new boolean [grafo.getSize()], cantDiasVaca - origen.getData().getDias());
            }
        }
        return camino;
    }

    private void dfs(Graph<Ciudad> grafo, Vertex<Ciudad> origen, List<String> camino, List<String> caminoActual, boolean [] visitados, int cantDiasVaca){
        visitados[origen.getPosition()] = true;
        caminoActual.add(origen.getData().getNombre());

        List<Edge<Ciudad>> edges = grafo.getEdges(origen);
        for (Edge<Ciudad> arista : edges){
            Vertex<Ciudad> vertex = arista.getTarget();
            if (!visitados[vertex.getPosition()] && cantDiasVaca - vertex.getData().getDias() >= 0){
                dfs(grafo, vertex, camino, caminoActual, visitados, cantDiasVaca - vertex.getData().getDias());
            }
        }
        if (caminoActual.size() > camino.size()){
            camino.clear();
            camino.addAll(caminoActual);
        }
        visitados[origen.getPosition()] = false;
        caminoActual.remove(caminoActual.size()-1);
    }

    private Vertex<Ciudad> buscarCiudad(Graph<Ciudad> grafo, String ciudad){
        boolean ok = false;
        Vertex<Ciudad> vertice = null;
        List<Vertex<Ciudad>> vertices = grafo.getVertices();
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
        Graph<Ciudad> mapa = new AdjListGraph<Ciudad>();
        Vertex<Ciudad> MarDelPlata = mapa.createVertex(new Ciudad(7, "Mar Del Plata"));
        Vertex<Ciudad> Pila = mapa.createVertex(new Ciudad(1, "Pila"));
        Vertex<Ciudad> Dolores = mapa.createVertex(new Ciudad(1, "Dolores"));
        Vertex<Ciudad> Chascomus = mapa.createVertex(new Ciudad(1, "Chascomús"));
        Vertex<Ciudad> MarAzul = mapa.createVertex(new Ciudad(3, "Mar Azul"));
        Vertex<Ciudad> Pinamar = mapa.createVertex(new Ciudad(4, "Pinamar"));
        Vertex<Ciudad> Madariaga = mapa.createVertex(new Ciudad(1, "Madariaga"));
        Vertex<Ciudad> LaPlata = mapa.createVertex(new Ciudad(5, "La Plata"));
        Vertex<Ciudad> LasGaviotas = mapa.createVertex(new Ciudad(1, "Las Gaviotas"));
        Vertex<Ciudad> Querandi = mapa.createVertex(new Ciudad(1, "Querandi"));
        Vertex<Ciudad> Hudson = mapa.createVertex(new Ciudad(1, "Hudson"));
        
        mapa.connect(MarDelPlata, Pila);
        mapa.connect(Pila, MarDelPlata);
        mapa.connect(Pila, Dolores);
        mapa.connect(Dolores, Pila);
        mapa.connect(Dolores, Chascomus);
        mapa.connect(Chascomus, Dolores);
        
        mapa.connect(MarDelPlata, MarAzul);
        mapa.connect(MarAzul, MarDelPlata);
        mapa.connect(MarAzul, Pinamar);
        mapa.connect(Pinamar, MarAzul);
        mapa.connect(Pinamar, Madariaga);
        mapa.connect(Madariaga, Pinamar);
        mapa.connect(Dolores, Madariaga);
        mapa.connect(Madariaga, Dolores);
        mapa.connect(Madariaga, LaPlata);
        mapa.connect(LaPlata, Madariaga);
        mapa.connect(Chascomus, LaPlata);
        mapa.connect(LaPlata, Chascomus);
        
        mapa.connect(MarAzul, LasGaviotas);
        mapa.connect(LasGaviotas, MarAzul);
        mapa.connect(MarAzul, Querandi);
        mapa.connect(Querandi, MarAzul);
        mapa.connect(LaPlata, Hudson);
        mapa.connect(Hudson, LaPlata);
        
        Parcial p = new Parcial();
        System.out.println(p.resolver(mapa, "Mar Del Plata", 15));
    }
}