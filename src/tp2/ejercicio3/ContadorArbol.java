package tp2.ejercicio3;

import java.util.ArrayList;
import tp2.ejercicio2.BinaryTree;

public class ContadorArbol {
	BinaryTree<Integer> ab;
	
	public ContadorArbol(BinaryTree<Integer> ab) {
		this.ab = ab;
	}
	
	public ArrayList<Integer> numerosParesA(){
		ArrayList<Integer> result = new ArrayList<Integer>();
		this.inOrden(ab, result);
		return result;
	}
	
	public ArrayList<Integer> numerosParesB(){
		ArrayList<Integer> result = new ArrayList<Integer>();
		this.postOrden(ab, result);
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
	
	public static void main(String[] args) {
		BinaryTree<Integer> ab = new BinaryTree<Integer>(40);
		BinaryTree<Integer> hijoIzquierdo = new BinaryTree<Integer>(25);
		BinaryTree<Integer> hijoDerecho = new BinaryTree<Integer>(78);
		hijoIzquierdo.addLeftChild(new BinaryTree<Integer>(10));
		hijoIzquierdo.addRightChild(new BinaryTree<Integer>(32));
		ab.addLeftChild(hijoIzquierdo);
		ab.addRightChild(hijoDerecho);
		
		ContadorArbol contador = new ContadorArbol(ab);
		
		ArrayList<Integer> lista = contador.numerosParesA();
		
		System.out.println("Imprimo lista de numeros pares");
		for(int i : lista) {
			System.out.println(i);
		}
		
	}
}