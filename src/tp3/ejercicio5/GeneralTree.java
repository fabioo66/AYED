package tp3.ejercicio5;

import java.util.LinkedList;
import java.util.List;
import tp1.ejercicio8.Queue;

public class GeneralTree<T>{

	private T data;
	private List<GeneralTree<T>> children = new LinkedList<GeneralTree<T>>(); 

	public GeneralTree() {
		
	}
	public GeneralTree(T data) {
		this.data = data;
	}

	public GeneralTree(T data, List<GeneralTree<T>> children) {
		this(data);
		this.children = children;
	}	
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public List<GeneralTree<T>> getChildren() {
		return this.children;
	}
	
	public void setChildren(List<GeneralTree<T>> children) {
		if (children != null)
			this.children = children;
	}
	
	public void addChild(GeneralTree<T> child) {
		this.getChildren().add(child);
	}

	public boolean isLeaf() {
		return !this.hasChildren();
	}
	
	public boolean hasChildren() {
		return !this.children.isEmpty();
	}
	
	public boolean isEmpty() {
		return this.data == null && !this.hasChildren();
	}

	public void removeChild(GeneralTree<T> child) {
		if (this.hasChildren())
			children.remove(child);
	}
	
	public int altura() {
		if(this.isLeaf()) {
			return 0;
		}
		int suma, max = 0;
		List<GeneralTree<T>> children = this.getChildren();
		for (GeneralTree<T> child: children) {
			suma = child.altura() + 1;
			max = Math.max(max, suma);
		}
		return max;
	}
	
	public int nivel(T dato){
		Queue<GeneralTree<T>> cola = new Queue<GeneralTree<T>>();
		cola.enqueue(this);
		cola.enqueue(null);
		int nivel = 0;
		boolean encontre = false;
		while(!cola.isEmpty() && !encontre) {
			GeneralTree<T> actual = cola.dequeue();
			if(actual != null && !encontre) {
				if(actual.getData() == dato) {
					encontre = true;
				}
				for(GeneralTree<T> e : actual.getChildren()) {
					cola.enqueue(e);
				}
			}else {
				if(!cola.isEmpty()) {
					cola.enqueue(null);
					nivel ++;
				}
			}
		}
		if(!encontre) {
			return -1;
		}else {
			return nivel;
		}
	  }

	public int ancho(){
		Queue<GeneralTree<T>> cola = new Queue<GeneralTree<T>>();
		cola.enqueue(this);
		cola.enqueue(null);
		int cant = 0, max = 0;
		while(!cola.isEmpty()) {
			GeneralTree<T> actual = cola.dequeue();
			if(actual != null) {
				for(GeneralTree<T> e : actual.getChildren()) {
					cola.enqueue(e);
					cant++;
				}
			}else {
				if(!cola.isEmpty()) {
					if(cant > max) max = cant;
					cant = 0;
					cola.enqueue(null);
				}
			}
		}
		return max;
	}
	
	public boolean esAncestro(T a, T b) {
    	GeneralTree<T> subArbol = buscarNodo(this,a);
    	boolean result = false;
    	if (subArbol != null) 
    		result = (buscarNodo(subArbol,b) != null);
    	return result;
    }
    
    private GeneralTree<T> buscarNodo(GeneralTree<T> arbol , T dato) { 
    	GeneralTree<T> subArbol = null;
    	if (arbol.getData().equals(dato)) {
    		subArbol = arbol;
    	}else {
    		if (!arbol.isLeaf()) {
    			List<GeneralTree<T>> children = arbol.getChildren();
    			for (GeneralTree<T> child: children) {
    				subArbol = buscarNodo(child,dato);
    				if (subArbol != null) return arbol;
    			}
    		}
    	}
    	return subArbol;    		
    }
}