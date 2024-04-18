package tp3.ejercicio4;

import tp1.ejercicio8.Queue;
import tp3.ejercicio3.GeneralTree;

public class AnalizadorArbol {
	public double devolverMaximoPromedio (GeneralTree<AreaEmpresa>arbol) {
		Queue<GeneralTree<AreaEmpresa>> cola = new Queue<GeneralTree<AreaEmpresa>>();
		cola.enqueue(arbol);
		cola.enqueue(null);
		double cantSuma = 0, max = 0, cantNodos = 0, prom;
		while(!cola.isEmpty()) {
			GeneralTree<AreaEmpresa> actual = cola.dequeue();
			if(actual != null) {
				for(GeneralTree<AreaEmpresa> e : actual.getChildren()) {
					cola.enqueue(e);
					cantNodos++;
					cantSuma += actual.getData().getTardanza();
				}
			}else {
				if(!cola.isEmpty()) {
					prom = cantSuma / cantNodos;
					if(prom > max) max = prom;
					cantNodos = 0;
					cantSuma = 0;
					cola.enqueue(null);
				}
			}
		}
		return max;
	}
}
