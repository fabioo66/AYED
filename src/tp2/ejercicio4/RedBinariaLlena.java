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
		} else if (ab.isLeaf()) {
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
}
