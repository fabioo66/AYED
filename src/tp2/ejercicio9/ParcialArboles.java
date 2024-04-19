package tp2.ejercicio9;

import tp2.ejercicio2.BinaryTree;

public class ParcialArboles {
	
	public BinaryTree<Data> sumAndDif(BinaryTree<Integer> arbol){
		BinaryTree<Data> abNuevo = new BinaryTree<Data>();
		if(!arbol.isEmpty() && arbol != null) {
			abNuevo = sumAndDif(arbol, 0, 0);
			return abNuevo;
		}else {
			
			return abNuevo;
		}
	}
	
	private BinaryTree<Data> sumAndDif(BinaryTree<Integer> arbol, int suma, int padre){
		
		BinaryTree<Data> izq = null;
		BinaryTree<Data> der = null;
		
		if (arbol.hasLeftChild()) {
			izq = sumAndDif(arbol.getLeftChild(), suma + arbol.getData(), arbol.getData());
		}
		if (arbol.hasRightChild()) {
			der = sumAndDif(arbol.getRightChild(), suma + arbol.getData(), arbol.getData());
		}
        BinaryTree<Data> arbolData = new BinaryTree<Data>(new Data(suma + arbol.getData(), arbol.getData() - padre));
		arbolData.addLeftChild(izq);
		arbolData.addRightChild(der);
		return arbolData;
	}
	
	public static void main(String[] args) {
		System.out.println("Test Ejercicio9");
		ParcialArboles test = new ParcialArboles();
	        
		BinaryTree<Integer> ab = new BinaryTree<Integer>(20);
		ab.addLeftChild(new BinaryTree<Integer>(5));
		ab.getLeftChild().addLeftChild(new BinaryTree<Integer>(-5));
		ab.getLeftChild().addRightChild(new BinaryTree<Integer>(10));
		ab.getLeftChild().getRightChild().addLeftChild(new BinaryTree<Integer>(1));
		ab.addRightChild(new BinaryTree<Integer>(30));
		ab.getRightChild().addLeftChild(new BinaryTree<Integer>(50));
		ab.getRightChild().addRightChild(new BinaryTree<Integer>(-9));
		ab.getRightChild().getLeftChild().addRightChild(new BinaryTree<Integer>(4));
		ab.getRightChild().getLeftChild().getRightChild().addRightChild(new BinaryTree<Integer>(6));   
	     
		ab.printLevelTraversal();
		System.out.println("Nuevo arbol:");
	    
		BinaryTree<Data> arbolNuevo = test.sumAndDif(ab);
	     
		arbolNuevo.printLevelTraversal();
	}
}
