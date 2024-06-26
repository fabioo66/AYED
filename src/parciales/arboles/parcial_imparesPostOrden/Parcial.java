package parciales.arboles.parcial_imparesPostOrden;

import tp2.ejercicio2.BinaryTree;

public class Parcial {
    
    public int sumaImparesPosOrdenMayorA(BinaryTree<Integer> arbol, int limite){
        int suma = 0;
        if (!arbol.isEmpty()){
            suma = procesar(arbol, limite);
        }
        return suma;
    }

    private int procesar(BinaryTree<Integer> arbol, int limite){
        int suma = 0;
        if (arbol.hasLeftChild()){
            suma += procesar(arbol.getLeftChild(), limite);
        }
        if (arbol.hasRightChild()){
            suma += procesar(arbol.getRightChild(), limite);
        }
        if (arbol.getData() % 2 != 0 && arbol.getData() > limite){
            suma += arbol.getData();
        }
        return suma;
    }

    public static void main(String args[]) {
        BinaryTree<Integer> ab = new BinaryTree<Integer>(7);
        ab.addLeftChild(new BinaryTree<Integer>(56));
        ab.getLeftChild().addLeftChild(new BinaryTree<Integer>(38));
        ab.getLeftChild().addRightChild(new BinaryTree<Integer>(31));
        ab.getLeftChild().getRightChild().addRightChild(new BinaryTree<Integer>(94));
        ab.getLeftChild().getRightChild().getRightChild().addRightChild(new BinaryTree<Integer>(2));
        ab.getLeftChild().getRightChild().getRightChild().getRightChild().addLeftChild(new BinaryTree<Integer>(1));
        ab.getLeftChild().getLeftChild().addLeftChild(new BinaryTree<Integer>(87));
        ab.getLeftChild().getLeftChild().addRightChild(new BinaryTree<Integer>(77));
        ab.getLeftChild().getLeftChild().getRightChild().addLeftChild(new BinaryTree<Integer>(16));
        ab.getLeftChild().getLeftChild().getRightChild().getLeftChild().addRightChild(new BinaryTree<Integer>(43));
        ab.getLeftChild().getLeftChild().getRightChild().getLeftChild().getRightChild().addLeftChild(new BinaryTree<Integer>(9));
        ab.getLeftChild().getLeftChild().getRightChild().getLeftChild().getRightChild().addRightChild(new BinaryTree<Integer>(10));
        ab.addRightChild(new BinaryTree<Integer>(25));
        ab.getRightChild().addLeftChild(new BinaryTree<Integer>(5));
        ab.getRightChild().addRightChild(new BinaryTree<Integer>(6));
        
        Parcial p = new Parcial();
        
        System.out.println(p.sumaImparesPosOrdenMayorA(ab, 30));
    
    }
}
