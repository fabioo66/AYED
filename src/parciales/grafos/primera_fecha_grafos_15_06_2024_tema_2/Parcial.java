package parciales.grafos.primera_fecha_grafos_15_06_2024_tema_2;

import java.util.*;

import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;
import tp5.ejercicio1.adjList.AdjListGraph;

public class Parcial {
    public String resolver (Graph<Recinto> sitios, int tiempo){
        boolean ok = false;
        if (!sitios.isEmpty()){
            Vertex<Recinto> origen = buscarOrigen(sitios);
            
            if (origen != null){
                int tiempoRestante = tiempo - origen.getData().getMinutos();
                if (tiempoRestante >= 0) {
                    ok = esAlcanzable(sitios, origen, new LinkedList<Recinto>(), new boolean[sitios.getSize()], tiempoRestante);
                }
            }
        }
        if (ok){
            return "Alcanzable";
        }else {
            return "No alcanzable";
        }
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

    /*private boolean esAlcanzable(Graph<Recinto> sitios, Vertex<Recinto> origen, List<Recinto> camino, boolean [] visitados, int tiempo){
        boolean ok = false;
        int tiempoRestante = tiempo - origen.getData().getMinutos();
        if (tiempoRestante >= 0){
            visitados[origen.getPosition()] = true;
            camino.add(origen.getData());
        }
        if (camino.size() == sitios.getSize()){
            ok = true;
        }else {
            List<Edge<Recinto>> edges = sitios.getEdges(origen);
            Iterator<Edge<Recinto>> iter = edges.iterator();
            while (iter.hasNext() && !ok){
                Edge<Recinto> arista = iter.next();
                if (!visitados[arista.getTarget().getPosition()] && tiempoRestante - arista.getWeight()>= 0){
                    ok = esAlcanzable(sitios, arista.getTarget(), camino, visitados, tiempo - arista.getWeight());
                }
            }
        }
        if (!ok){
            visitados[origen.getPosition()] = false;
            camino.remove(camino.size()-1);
        }
        return ok;
    }*/


    private boolean esAlcanzable(Graph<Recinto> sitios, Vertex<Recinto> origen, List<Recinto> camino, boolean [] visitados, int tiempo){
        boolean ok = false;
        visitados[origen.getPosition()] = true;
        camino.add(origen.getData());
        if (camino.size() == sitios.getSize()){
            ok = true;
        }else {
            List<Edge<Recinto>> edges = sitios.getEdges(origen);
            Iterator<Edge<Recinto>> iter = edges.iterator();
            while (iter.hasNext() && !ok){
                Edge<Recinto> arista = iter.next();
                if (!visitados[arista.getTarget().getPosition()] && tiempo - (arista.getWeight() + arista.getTarget().getData().getMinutos()) >= 0){
                    ok = esAlcanzable(sitios, arista.getTarget(), camino, visitados, tiempo - (arista.getWeight() + arista.getTarget().getData().getMinutos()));
                }
            }
        }
        if (!ok){
            visitados[origen.getPosition()] = false;
            camino.remove(camino.size()-1);
        }
        return ok;
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
        
        System.out.println(p.resolver(grafo, 220));
        System.out.println(p.resolver(grafo, 100));
    }
}
