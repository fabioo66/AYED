package tp2.ejercicio2;

public class Ejercicio2 {
	
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
	
		
		System.out.println("Arbol in orden: ");
		ab.printInOrden();
		
		System.out.println("----------------------------");
		
		System.out.println("Cantidad de hojas del arbol");
		int hojas = ab.contarHojas();
		System.out.println(hojas);
		
		System.out.println("-------------------------------");
		System.out.println("Arbol Espejo in orden: ");
		BinaryTree<Integer> arbolEspejo = ab.espejo();
		arbolEspejo.printInOrden();
		
		System.out.println("--------------------------------");
		
		System.out.println("Arbol por niveles");
		ab.printLevelTraversal();
		
		System.out.println("---------------------------------");
		
		System.out.println("Arbol entre niveles");
		
		ab.entreNiveles(0, 3);
	}
}
