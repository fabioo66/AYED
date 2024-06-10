package tp5.ejercicio2;

import java.util.LinkedList;
import java.util.List;

import tp1.ejercicio8.Queue;
import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;
import tp5.ejercicio1.adjList.AdjListGraph;

public class Recorridos<T> {

	public List<T> dfs (Graph<T> g){
		List<T> lista = new LinkedList<T>();
		// Java ya pone todas las posiciones en falso
		boolean [] visitados = new boolean [g.getSize()];
		for(Vertex<T> v : g.getVertices()) {
			if(!visitados[v.getPosition()]){
				dfs2(g, v, visitados, lista);
			}
		}
		return lista;
	 }
	 
	private void dfs2(Graph<T> g, Vertex<T> v, boolean[] visitados, List<T> lista){
		// Operaciones basicas siempre que usamos dfs
	 	lista.add(v.getData());
	 	visitados[v.getPosition()] = true;
	 	
	 	// Pido adyacentes
	 	List<Edge<T>> ady = g.getEdges(v);
	 	for(Edge<T> edge : ady){
	 		// Vertice destino de la arista
	 		Vertex<T> destino = edge.getTarget();
	 		if(!visitados[destino.getPosition()]){
	 			dfs2(g, destino, visitados, lista);
	 		}
	 	}
	 }
	 
	public List<T> bfs (Graph<T> g){
		List<T> lista = new LinkedList<T>();
		boolean[] marca = new boolean[g.getSize()];
		for (int i = 0; i < g.getSize(); i++) {
			if (!marca[i]){
				bfs2(i, g, marca, lista); //las listas empiezan en la pos 1
			 }
		}
		return lista;
	}
	
	private void bfs2(int i, Graph<T> g, boolean [] marca, List<T> lista) {
		Queue<Vertex<T>> q = new Queue<Vertex<T>>();
		q.enqueue(g.getVertex(i));
		marca[i] = true;
		while (!q.isEmpty()) {
			Vertex<T> w = q.dequeue();
			lista.add(w.getData());
			// para todos los vecinos de w:
			List<Edge<T>> adyacentes = g.getEdges(w);
			for (Edge<T> e: adyacentes) {
				int j = e.getTarget().getPosition();
				if (!marca[j]) {
					marca[j] = true;
					//Vertex<T> v = e.getTarget();
					q.enqueue(e.getTarget());
				}
			}
		}

	}
		
	public static void main(String[] args) {
		Graph<String> ciudades = new AdjListGraph<String>();
	    Recorridos<String> rec = new Recorridos<String>();
	    Vertex<String> v1 = ciudades.createVertex("Buenos Aires");
	    Vertex<String> v2 = ciudades.createVertex("Santiago");
	    Vertex<String> v3 = ciudades.createVertex("Asunción");
	    Vertex<String> v4 = ciudades.createVertex("Tokio");
	    Vertex<String> v5 = ciudades.createVertex("Roma");
	    Vertex<String> v6 = ciudades.createVertex("Paris");
	    Vertex<String> v7 = ciudades.createVertex("Madrid");
	    Vertex<String> v8 = ciudades.createVertex("Caracas");
	    ciudades.connect(v1, v2);
	    ciudades.connect(v1, v3);
	    ciudades.connect(v2, v5);
	    ciudades.connect(v3, v7);
	    ciudades.connect(v3, v8);
	    ciudades.connect(v8, v7);
	    ciudades.connect(v8, v4);
	    ciudades.connect(v5, v4);
	    ciudades.connect(v7, v4);
	    ciudades.connect(v6, v5);
	    ciudades.connect(v6, v7);
	    ciudades.connect(v6, v4);
	    ciudades.connect(v4, v1);
	        
	    List<String> lisDFS = rec.dfs(ciudades);
	    List<String> lisBFS = rec.bfs(ciudades);
	        
	    System.out.print("Lista DFS: ");
	    	for (String e: lisDFS){
	            System.out.print(e + " ~ ");
	        }
	    	
	    System.out.println("");
	    	
	    System.out.print("Lista BFS: ");
	    	for (String e: lisBFS){
	            System.out.print(e + " ~ ");
	        }
	}
}