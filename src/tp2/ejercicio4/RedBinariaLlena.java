package tp2.ejercicio4;

import tp2.ejercicio2.BinaryTree;

public class RedBinariaLlena {
	BinaryTree<Integer> ab;
	
	public RedBinariaLlena(BinaryTree<Integer> ab) {
		this.ab = ab;
	}
	
	public int retardoReenvio() {
		return retardin(ab);
	}
	
	private int retardin(BinaryTree<Integer> ab) {
		int left = 0;
		int right = 0;
		if(ab.isEmpty()) {
			return 0;
		}else if (ab.isLeaf()) {
	        return ab.getData();
		}else {
			if(ab.hasLeftChild()) {
				left = retardin(ab.getLeftChild());
			}
			if(ab.hasRightChild()) {
				right = retardin(ab.getRightChild());
			}
			if(left > right) {
				return ab.getData() + left;
			}else {
				return ab.getData() + right;
			}
		}
		
	}
	
	public static void main(String[] args) {
		BinaryTree<Integer> ab = new BinaryTree<Integer>(40);
		BinaryTree<Integer> hijoIzquierdo = new BinaryTree<Integer>(25);
		BinaryTree<Integer> hijoDerecho = new BinaryTree<Integer>(78);
		
		hijoIzquierdo.addLeftChild(new BinaryTree<Integer>(10));
		hijoIzquierdo.addRightChild(new BinaryTree<Integer>(332));
		
		hijoDerecho.addLeftChild(new BinaryTree<Integer>(20));
		hijoDerecho.addRightChild(new BinaryTree<Integer>(50));
		
		ab.addLeftChild(hijoIzquierdo);
		ab.addRightChild(hijoDerecho);
		
		RedBinariaLlena red = new RedBinariaLlena(ab);
		System.out.print(red.retardoReenvio());
	}
}
