package tp5.ejercicio3;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;

public class Mapa {
	Graph<String> mapaCiudades;
	
	/**
     * Retorna la lista de ciudades que se deben atravesar para ir de ciudad1 a ciudad2 en caso de que se
     * pueda llegar, si no retorna la lista vacía. (Sin tener en cuenta el combustible).
     * @param ciudad1
     * @param ciudad2
     * @return
     */
	
	public List<String> devolverCamino(String ciudad1, String ciudad2){
		List<String> camino = new LinkedList<String>();
		Vertex <String> origen = this.mapaCiudades.search(ciudad1);
		Vertex <String> destino = this.mapaCiudades.search(ciudad2);
		
		if (origen != null && destino != null) {
			dfs(origen, destino, new boolean[this.mapaCiudades.getSize()], camino);
		}
		return camino;
	}
	
	private boolean dfs(Vertex <String> origen, Vertex <String> destino, boolean [] visitados, List<String> camino) {
		boolean ok = false;
		visitados[origen.getPosition()] = true;
		camino.add(origen.getData());
		
		if (origen == destino) {
			return true;
		}
		
		List<Edge<String>> adyacentes = mapaCiudades.getEdges(origen);
		Iterator<Edge<String>> iter = adyacentes.iterator();
		
		while (iter.hasNext() && !ok) {
			Vertex <String> vertex = iter.next().getTarget();
			
			if(!visitados[vertex.getPosition()]) {
				ok = dfs (vertex, destino, visitados, camino);
			}
		}
		
		if(!ok) {
			// Si el adyacente no tiene aristas de salida, elimino el ultimo vertice
			camino.remove(camino.size()-1); 
		}
		return ok;
	}
	
	/**
     * Retorna la lista de ciudades que forman un camino desde ciudad1 a ciudad2, sin pasar por las ciudades
     * que están contenidas en la lista ciudades pasada por parámetro, si no existe camino retorna la lista
     * vacía. (Sin tener en cuenta el combustible).
     * @param ciudad1
     * @param ciudad2
     * @param ciudades
     * @return
     */
	
	public List<String> devolverCaminoExceptuando(String ciudad1, String ciudad2, List<String> ciudades){
		List<String> camino = new LinkedList<String>();
		Vertex <String> origen = this.mapaCiudades.search(ciudad1);
		Vertex <String> destino = this.mapaCiudades.search(ciudad2);
		
		if (origen != null && destino != null) {
			dfsExcept(origen, destino, new boolean[this.mapaCiudades.getSize()], camino, ciudades);
		}
		return camino;
	}
	
	private boolean dfsExcept(Vertex <String> origen, Vertex <String> destino, boolean [] visitados, List<String> camino, List<String> ciudades) {
		boolean ok = false;
		visitados[origen.getPosition()] = true;
		camino.add(origen.getData());
		
		if (origen == destino) {
			return true;
		}
		
		List<Edge<String>> adyacentes = mapaCiudades.getEdges(origen);
		Iterator<Edge<String>> iter = adyacentes.iterator();
		
		while (iter.hasNext() && !ok) {
			Vertex <String> vertex = iter.next().getTarget();
			
			if(!visitados[vertex.getPosition()] && !ciudades.contains(vertex.getData())) {
				ok = dfs (vertex, destino, visitados, camino);
			}
		}
		
		if(!ok) {
			// Si el adyacente no tiene aristas de salida, elimino el ultimo vertice
			camino.remove(camino.size()-1); 
		}
		return ok;
	}
	
	/**
     * Retorna la lista de ciudades que forman el camino más corto para llegar de ciudad1 a ciudad2, si no
     * existe camino retorna la lista vacía. (Las rutas poseen la distancia)
     * @param ciudad1
     * @param ciudad2
     * @return
     */
	
	public List<String> caminoMasCorto(String ciudad1, String ciudad2) {
		Vertex <String> origen = this.mapaCiudades.search(ciudad1);
		Vertex <String> destino = this.mapaCiudades.search(ciudad2);
		CaminoMinimo caminoMinimo = new CaminoMinimo();
		
		if (origen != null && destino != null) {
            dfsMasCorto(origen, destino, new boolean[mapaCiudades.getSize()], new LinkedList<String>(), 0, caminoMinimo);
		}
		
		return caminoMinimo.getCamino();
	}
	
	private void dfsMasCorto(Vertex <String> origen, Vertex <String> destino, boolean [] visitados, List<String> caminoActual, int pesoActual, CaminoMinimo caminoMinimo) {
		visitados[origen.getPosition()] = true;
		caminoActual.add(origen.getData());
		
		if (origen == destino) {
			if (pesoActual < caminoMinimo.getMinimo()) {
				caminoMinimo.setCamino(caminoActual);
				caminoMinimo.setMinimo(pesoActual);
			}
		}else {
			List<Edge<String>> edges = mapaCiudades.getEdges(origen);
			for (Edge<String> edge : edges) {
				Vertex <String> vertex = edge.getTarget();
				if (!visitados[vertex.getPosition()]) {
					dfsMasCorto(vertex, destino, visitados, caminoActual, pesoActual + edge.getWeight(), caminoMinimo);
				}
			}
		}
		visitados[origen.getPosition()] = false;
        caminoActual.remove(caminoActual.size() - 1);
	}
	
	 /**
     * Retorna la lista de ciudades que forman un camino para llegar de ciudad1 a ciudad2. El auto no debe
     * quedarse sin combustible y no puede cargar. Si no existe camino retorna la lista vacía.
     */
	
	public List<String> caminoSinCargarCombustible(String ciudad1, String ciudad2, int tanqueAuto){
		List<String> camino = new LinkedList<String>();
		Vertex <String> origen = this.mapaCiudades.search(ciudad1);
		Vertex <String> destino = this.mapaCiudades.search(ciudad2);
		
		if (origen != null && destino != null) {
			dfsSinCargarCombustible(origen, destino, new boolean [this.mapaCiudades.getSize()], camino, tanqueAuto);
		}
		return camino;
	}
	
	private boolean dfsSinCargarCombustible(Vertex <String> origen, Vertex <String> destino, boolean [] visitados, List<String> camino, int tanque) {
		boolean ok = false;
		visitados[origen.getPosition()] = true;
		camino.add(origen.getData());
		
		if (origen == destino) {
			return true;
		}
		
		List<Edge<String>> adyacentes = this.mapaCiudades.getEdges(origen);
		Iterator<Edge<String>> iter = adyacentes.iterator();
		
		while (iter.hasNext() && !ok) {
			Edge<String> vertex = iter.next();
			int j = vertex.getTarget().getPosition();
			if (!visitados[j] && tanque - vertex.getWeight() > 0) {
				dfsSinCargarCombustible(vertex.getTarget(), destino, visitados, camino, tanque - vertex.getWeight());
			}
		}
		
		if (!ok) {
			camino.remove(camino.size()-1);
		}
		
		return ok;
	}
	
	/*
	 Retorna la lista de ciudades que forman un camino para llegar de ciudad1 a ciudad2 teniendo en cuenta
	 que el auto debe cargar la menor cantidad de veces. El auto no se debe quedar sin combustible en
	 medio de una ruta, además puede completar su tanque al llegar a cualquier ciudad. Si no existe camino
     retorna la lista vacía
	 */
	
	public List<String> caminoConMenorCargaDeCombustible (String ciudad1, String ciudad2, int tanqueAuto){
		Vertex <String> origen = this.mapaCiudades.search(ciudad1);
		Vertex <String> destino = this.mapaCiudades.search(ciudad2);
		CaminoMinimo caminoMinimo = new CaminoMinimo();
		
		if (origen != null && destino != null) {
			dfsConMenorCargaDeCombustible(
                    origen,
                    destino,
                    new boolean[mapaCiudades.getSize()],
                    new LinkedList<String>(),
                    0,
                    caminoMinimo,
                    tanqueAuto,
                    tanqueAuto
            );
		}
		return caminoMinimo.getCamino();
	}
	
	private void dfsConMenorCargaDeCombustible(Vertex <String> origen, Vertex <String> destino, boolean [] visitados, LinkedList<String> caminoActual, int cargaTanquesActual, CaminoMinimo caminoMinimo, int tanqueActual, int tanqueLleno) {
		visitados[origen.getPosition()] = true;
		caminoActual.add(origen.getData());
		
		if (origen == destino) {
			if (cargaTanquesActual < caminoMinimo.getMinimo()) {
				caminoMinimo.setCamino(caminoActual);
				caminoMinimo.setMinimo(cargaTanquesActual);
			}
		}else {
			List<Edge<String>> edges = mapaCiudades.getEdges(origen);
			for (Edge<String> edge : edges) {
				Edge<String> vertex = edge;
				int j = vertex.getTarget().getPosition();
				if (!visitados[j]) {
					if (tanqueActual - vertex.getWeight() > 0)
						dfsConMenorCargaDeCombustible(vertex.getTarget(), destino, visitados, caminoActual, cargaTanquesActual, caminoMinimo, tanqueActual - vertex.getWeight(), tanqueLleno);
					else
						dfsConMenorCargaDeCombustible(vertex.getTarget(), destino, visitados, caminoActual, cargaTanquesActual + 1, caminoMinimo, tanqueLleno, tanqueLleno);
				}
			}
		}
		visitados[origen.getPosition()] = false;
        caminoActual.remove(caminoActual.size() - 1);
	}
}
