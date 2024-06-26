package parciales.arboles.parcial_monodistante;

import tp2.ejercicio2.BinaryTree;

public class Parcial {
    private BinaryTree<Integer> arbol;

    public Parcial(BinaryTree<Integer> arbol){
        this.arbol = arbol;
    }

    public boolean resolver(int k){
        boolean ok = false;
        if (!this.arbol.isEmpty()){
            ok = procesar(this.arbol, k, arbol.getData());
        }
        return ok;
    }

    private boolean procesar(BinaryTree<Integer> arbol, int k, int suma){
        boolean ok = false;
        if (arbol.isLeaf() && suma == k){
            ok = true;
        }
        if (arbol.hasLeftChild()){
            ok = procesar(arbol.getLeftChild(), k, suma + arbol.getLeftChild().getData());
        }
        if (arbol.hasRightChild() && !ok){
            ok = procesar(arbol.getRightChild(), k, suma + arbol.getLeftChild().getData());
        }
        return ok;
    }

    public static void main(String args[]) {
        BinaryTree<Integer> ab = new BinaryTree<Integer>(1);
        ab.addLeftChild(new BinaryTree<Integer>(3));
        ab.getLeftChild().addLeftChild(new BinaryTree<Integer>(3));
        //ab.getLeftChild().getLeftChild().addLeftChild(new BinaryTree<Integer>(1));
        ab.addRightChild(new BinaryTree<Integer>(4));
        ab.getRightChild().addLeftChild(new BinaryTree<Integer>(1));
        ab.getRightChild().getLeftChild().addLeftChild(new BinaryTree<Integer>(1));
        ab.getRightChild().addRightChild(new BinaryTree<Integer>(2));
        
        Parcial a = new Parcial(ab);
        System.out.println(a.resolver(7));
    
    }
}
