package parciales.grafos.primera_fecha_grafos_15_6_2024_tema_1;

import java.util.*;

import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;
import tp5.ejercicio1.adjList.AdjListGraph;

public class Parcial {

    public int resolver(Graph<Recinto> sitios, int tiempo){
        int cant = 0;
        if (!sitios.isEmpty()){
            Vertex<Recinto> origen = buscarOrigen(sitios);
            if (origen != null && tiempo - origen.getData().getMinutos() >= 0){
                cant = resolver(sitios, origen, new boolean [sitios.getSize()], tiempo - origen.getData().getMinutos(), 1);
            }
        }
        return cant;
    }

    private Vertex<Recinto> buscarOrigen(Graph<Recinto> sitios){
        boolean ok = false;
        List<Vertex<Recinto>> vertices = sitios.getVertices();
        Iterator<Vertex<Recinto>> iter = vertices.iterator();
        Vertex<Recinto> vertice = null;
        while (iter.hasNext() && !ok){
            vertice = iter.next();
            if (vertice.getData().getNombre().equals("Entrada")){
                ok = true;
            }
        }
        return vertice;
    }

    private int resolver(Graph<Recinto> sitios, Vertex<Recinto> origen, boolean [] visitados, int tiempo, int cantVisitados){
        visitados[origen.getPosition()] = true;
        int max = cantVisitados;
        List<Edge<Recinto>> edges = sitios.getEdges(origen);
        for (Edge<Recinto> edge : edges){
            if (!visitados[edge.getTarget().getPosition()] && tiempo - (edge.getTarget().getData().getMinutos() + edge.getWeight()) >= 0){
                int resultado = resolver(sitios, edge.getTarget(), visitados, tiempo - (edge.getTarget().getData().getMinutos() + edge.getWeight()), cantVisitados+1);
                if (resultado > max){
                    max = resultado;
                }
            }
        }
        visitados[origen.getPosition()] = false;
        return max;
    }

    public static void main(String args[]) {
        Graph<Recinto> grafo = new AdjListGraph<Recinto>();
        Vertex<Recinto> Entrada = grafo.createVertex(new Recinto("Entrada", 15));
        Vertex<Recinto> Cebras = grafo.createVertex(new Recinto("Cebras", 10));
        Vertex<Recinto> Tigres = grafo.createVertex(new Recinto("Tigres", 10));
        Vertex<Recinto> Flamencos = grafo.createVertex(new Recinto("Flamencos", 10));
        Vertex<Recinto> Murcielagos = grafo.createVertex(new Recinto("Murciélagos", 20));
        Vertex<Recinto> Wallabies = grafo.createVertex(new Recinto("Wallabies", 30));
        Vertex<Recinto> Tortugas = grafo.createVertex(new Recinto("Tortugas", 10));
        Vertex<Recinto> Pumas = grafo.createVertex(new Recinto("Pumas", 10));
        
        grafo.connect(Entrada, Cebras, 10);
        grafo.connect(Cebras, Entrada, 10);
        grafo.connect(Entrada, Tigres, 10);
        grafo.connect(Tigres, Entrada, 10);
        grafo.connect(Entrada, Murcielagos, 20);
        grafo.connect(Murcielagos, Entrada, 20);
        grafo.connect(Entrada, Flamencos, 25);
        grafo.connect(Flamencos, Entrada, 25);
        
        grafo.connect(Tigres, Cebras, 8);
        grafo.connect(Cebras, Tigres, 8);
        grafo.connect(Cebras, Tortugas, 10);
        grafo.connect(Tortugas, Cebras, 10);
        grafo.connect(Flamencos, Murcielagos, 25);
        grafo.connect(Murcielagos, Flamencos, 25);
        grafo.connect(Murcielagos, Wallabies, 10);
        grafo.connect(Wallabies, Murcielagos, 10);
        grafo.connect(Wallabies, Tortugas, 10);
        grafo.connect(Tortugas, Wallabies, 10);
        grafo.connect(Tortugas, Pumas, 15);
        grafo.connect(Pumas, Tortugas, 15);
        
        Parcial p = new Parcial();
        
        System.out.println(p.resolver(grafo, 100));
        System.out.println(p.resolver(grafo, 30));
    }
}