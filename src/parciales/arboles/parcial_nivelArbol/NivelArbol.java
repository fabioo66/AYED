package parciales.arboles.parcial_nivelArbol;

import tp1.ejercicio8.Queue;
import tp2.ejercicio2.BinaryTree;

public class NivelArbol {
    private BinaryTree<Integer> arbol;

    public NivelArbol(BinaryTree<Integer> arbol){
        this.arbol = arbol;
    }

    public BinaryTree<Integer> minEnNivelAB(int n){
        BinaryTree<Integer> hoja = null;
        if (!this.arbol.isEmpty()){
            Queue<BinaryTree<Integer>> cola = new Queue<BinaryTree<Integer>>();
            cola.enqueue(this.arbol);
            cola.enqueue(null);

            int nivel = 0;
            int min = Integer.MAX_VALUE;

            while (!cola.isEmpty() && nivel <= n){
                BinaryTree<Integer> ab = cola.dequeue();
                if (ab != null){
                    if (ab.isLeaf() && nivel == n){
                        if (ab.getData() < min){
                            min = ab.getData();
                            hoja = ab;
                        }
                    }
                    if (ab.hasLeftChild()){
                        cola.enqueue(ab.getLeftChild());
                    }
                    if (ab.hasRightChild()){
                        cola.enqueue(ab.getRightChild());
                    }
                }else{
                    if (!cola.isEmpty()){
                        cola.enqueue(null);
                        nivel++;
                    }
                }
            }
        }
        return hoja;
    }

    public static void main(String[] args) {
        BinaryTree<Integer> ab = new BinaryTree<Integer>(2);
        ab.addLeftChild(new BinaryTree<Integer>(7));
        ab.getLeftChild().addLeftChild(new BinaryTree<Integer>(2));
        ab.getLeftChild().addRightChild(new BinaryTree<Integer>(6));
        ab.getLeftChild().getRightChild().addLeftChild(new BinaryTree<Integer>(5));
        ab.getLeftChild().getRightChild().addRightChild(new BinaryTree<Integer>(11));
        ab.addRightChild(new BinaryTree<Integer>(5));
        ab.getRightChild().addRightChild(new BinaryTree<Integer>(9));
        ab.getRightChild().getRightChild().addLeftChild(new BinaryTree<Integer>(4));
        
        NivelArbol a = new NivelArbol(ab);
        
        BinaryTree<Integer> result = a.minEnNivelAB(1);
    if (result != null) {
        System.out.println(result.getData());
    } else {
        System.out.println("No se encontró una hoja en el nivel 1");
    }
    
    result = a.minEnNivelAB(2);
    if (result != null) {
        System.out.println(result.getData());
    } else {
        System.out.println("No se encontró una hoja en el nivel 2");
    }

    result = a.minEnNivelAB(3);
    if (result != null) {
        System.out.println(result.getData());
    } else {
        System.out.println("No se encontró una hoja en el nivel 3");
    }
    
    System.out.println("");
    }

}
