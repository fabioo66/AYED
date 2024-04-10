package tp2.ejercicio6;

import tp2.ejercicio2.BinaryTree;
import tp2.ejercicio5.ProfundidadDeArbolBinario;

public class Transformacion {
	BinaryTree<Integer> ab;
	
	public Transformacion(BinaryTree<Integer> ab) {
		this.ab = ab;
	}
	
	public BinaryTree<Integer> suma(){
		if(!ab.isEmpty() && ab.getData() != null){
			return suma(ab);
		}else
			return null;
	}
	
	private BinaryTree<Integer> suma(BinaryTree<Integer> arbol){
		if(arbol.isEmpty()) {
			return new BinaryTree<Integer>();
		}
		if(arbol.isLeaf()) {
			return new BinaryTree<Integer>(0);
		}else {
			BinaryTree<Integer> izq = null;
			BinaryTree<Integer> der = null;
			int suma = 0;
			if(arbol.hasLeftChild()) {
				izq = suma(arbol.getLeftChild()); 
				suma += izq.getData();
				suma += arbol.getLeftChild().getData();
			}
			if(arbol.hasRightChild()) {
				der = suma(arbol.getRightChild()); 
				suma += der.getData();
				suma += arbol.getRightChild().getData();
			}
			BinaryTree<Integer> arbolSuma = new BinaryTree<Integer>(suma);
			arbolSuma.addLeftChild(izq);
			arbolSuma.addRightChild(der);
			return arbolSuma;
		}
	}
	
	public static void main(String[] args) {
		BinaryTree<Integer> ab = new BinaryTree<Integer>(40);
		BinaryTree<Integer> hijoIzquierdo = new BinaryTree<Integer>(25);
		BinaryTree<Integer> hijoDerecho = new BinaryTree<Integer>(78);
		BinaryTree<Integer> TreintaDos = new BinaryTree<Integer>(32);
		
		hijoIzquierdo.addLeftChild(new BinaryTree<Integer>(10));
		hijoIzquierdo.addRightChild(TreintaDos);
		TreintaDos.addRightChild(new BinaryTree <Integer>(66));
		
		hijoDerecho.addLeftChild(new BinaryTree<Integer>(20));
		hijoDerecho.addRightChild(new BinaryTree<Integer>(50));
		
		ab.addLeftChild(hijoIzquierdo);
		ab.addRightChild(hijoDerecho);
		
		System.out.println("Por niveles");
		ab.printLevelTraversal();
		
		System.out.println("------------------------");
		
		Transformacion tran = new Transformacion(ab);
		
		BinaryTree<Integer> abNuevo = tran.suma();
		
		System.out.println("Arbol nuevo por niveles");
		abNuevo.printLevelTraversal();
	}
	
}	