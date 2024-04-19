package tp2.ejercicio8;

import tp2.ejercicio2.BinaryTree;

public class ParcialArboles {
	public boolean esPrefijo(BinaryTree<Integer> arbol1, BinaryTree<Integer> arbol2){
		if(arbol1.getData() != arbol2.getData()) {
			return false;
		}
		boolean result = true;
		if (arbol1.hasLeftChild()) {
			if(arbol2.hasLeftChild()) {
				result = result && esPrefijo(arbol1.getLeftChild(), arbol2.getLeftChild());
			}else
				return false;
			
		}
		if (arbol1.hasRightChild()) {
			if(arbol2.hasRightChild()) {
				result = result && esPrefijo(arbol1.getRightChild(), arbol2.getRightChild());
			}else
				return false;
			
		}
		return result;
	}
	
	public static void main(String[] args) {
		
		// arbol prefijo 2(dos)
		
		BinaryTree<Integer> ab = new BinaryTree<Integer>(1);
		BinaryTree<Integer> hijoIzquierdo = new BinaryTree<Integer>(4);
		BinaryTree<Integer> hijoDerecho = new BinaryTree<Integer>(7);
		BinaryTree<Integer> TreintaDos = new BinaryTree<Integer>(10);
		
		hijoIzquierdo.addLeftChild(new BinaryTree<Integer>(2));
		hijoIzquierdo.addRightChild(TreintaDos);
		TreintaDos.addRightChild(new BinaryTree <Integer>(9));
		
		hijoDerecho.addLeftChild(new BinaryTree<Integer>(8));
		hijoDerecho.addRightChild(new BinaryTree<Integer>(12));
		
		ab.addLeftChild(hijoIzquierdo);
		ab.addRightChild(hijoDerecho);
		
		///////////////////////////////////////////////////////
		
		// arbol prefijo 1(uno)
		
		BinaryTree<Integer> ab1 = new BinaryTree<Integer>(1);
		BinaryTree<Integer> hijoIzquierdo1 = new BinaryTree<Integer>(4);
		BinaryTree<Integer> hijoDerecho1 = new BinaryTree<Integer>(7);
		BinaryTree<Integer> TreintaDos1 = new BinaryTree<Integer>(10);
		
		hijoIzquierdo1.addLeftChild(new BinaryTree<Integer>(66));
		hijoIzquierdo1.addRightChild(TreintaDos1);
		TreintaDos1.addRightChild(new BinaryTree <Integer>(9));
		
		hijoDerecho1.addLeftChild(new BinaryTree<Integer>(8));
		hijoDerecho1.addRightChild(new BinaryTree<Integer>(12));
		
		ab1.addLeftChild(hijoIzquierdo1);
		ab1.addRightChild(hijoDerecho1);
		
		ParcialArboles test = new ParcialArboles();
		
		System.out.println(test.esPrefijo(ab1, ab));
	}
}
