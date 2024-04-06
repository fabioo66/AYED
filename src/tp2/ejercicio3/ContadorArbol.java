package tp2.ejercicio3;

import java.util.ArrayList;

import tp2.ejercicio2.BinaryTree;

public class ContadorArbol {
	BinaryTree<Integer> ab;
	
	public ContadorArbol(BinaryTree<Integer> ab) {
		this.ab = ab;
	}
	
	public ArrayList<Integer> numerosPares(){
		ArrayList<Integer> result = new ArrayList<Integer>();
		this.inOrden(ab, result);
		return result;
	}
	
	private void inOrden(BinaryTree<Integer> ab, ArrayList<Integer> lista) {
		if (ab.hasLeftChild()) {
			this.inOrden(ab.getLeftChild(), lista);
		}
		if (ab.getData() % 2 == 0) {
			lista.add(ab.getData());
		}
		if (ab.hasRightChild()) {
			this.inOrden(ab.getRightChild(), lista);
		}
	}
	
	private void postOrden(BinaryTree<Integer> ab, ArrayList<Integer> lista) {
		if (ab.hasLeftChild()) {
			this.postOrden(ab.getLeftChild(), lista);
		}
		if (ab.getData() % 2 == 0) {
			lista.add(ab.getData());
		}
		if (ab.hasRightChild()) {
			this.postOrden(ab.getRightChild(), lista);
		}
	}
}
