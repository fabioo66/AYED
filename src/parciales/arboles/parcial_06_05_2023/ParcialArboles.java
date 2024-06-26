package parciales.arboles.parcial_06_05_2023;

import tp2.ejercicio1.BinaryTree;

public class ParcialArboles {
    private BinaryTree<Integer> arbol;
    
    public ParcialArboles(BinaryTree<Integer> arbol){
        this.arbol = arbol;
    }

    public boolean isTwoTree(int num){
        boolean ok = false;
        if (!this.arbol.isEmpty()){
            BinaryTree<Integer> subArbol = buscarArbol(this.arbol, num);
            if (subArbol != null){
                ok = procesar(subArbol);
            }
        }
        return ok;
    }

    private BinaryTree<Integer> buscarArbol(BinaryTree<Integer> arbol, int num){
        if (arbol.getData() == num)
            return arbol;
        BinaryTree<Integer> newArbol = new BinaryTree<Integer>();
        if (arbol.hasLeftChild()){
            newArbol = buscarArbol(arbol.getLeftChild(), num);
        }
        if (arbol.hasRightChild() && newArbol.isEmpty()){
            newArbol = buscarArbol(arbol.getRightChild(), num);
        }
        return newArbol;
    }

    private boolean procesar(BinaryTree<Integer> subArbol){
        int ramaIzq = -1;
        int ramaDer = -1;
        if (subArbol.hasLeftChild()){
            ramaIzq = contarDosHijos(subArbol.getLeftChild());
        }
        if (subArbol.hasRightChild()){
            ramaDer = contarDosHijos(subArbol.getRightChild());
        }
        return ramaIzq == ramaDer;
    }

    private int contarDosHijos(BinaryTree<Integer> arb) {
        int cant = 0;
        if (arb.hasLeftChild()){ 
            cant += this.contarDosHijos(arb.getLeftChild());
        }
        if(arb.hasRightChild()){ 
            cant += this.contarDosHijos(arb.getRightChild());
        }
        if (arb.hasLeftChild() && arb.hasRightChild()){ 
            cant++;
        }
        return cant;
    }

    public static void main (String[] args) { 
        
        BinaryTree<Integer> ab = new BinaryTree<Integer>(2);
        ab.addLeftChild(new BinaryTree<Integer>(7));
        ab.addRightChild(new BinaryTree<Integer>(-5));
        ab.getLeftChild().addLeftChild(new BinaryTree<Integer>(23));
        ab.getLeftChild().addRightChild(new BinaryTree<Integer>(6));
        ab.getLeftChild().getLeftChild().addLeftChild(new BinaryTree<Integer>(-3));
        ab.getLeftChild().getRightChild().addLeftChild(new BinaryTree<Integer>(55));
        ab.getLeftChild().getRightChild().getLeftChild().addLeftChild(new BinaryTree<Integer>(9));
        ab.getLeftChild().getRightChild().getLeftChild().addRightChild(new BinaryTree<Integer>(16));
        ab.getRightChild().addLeftChild(new BinaryTree<Integer>(19));
        ab.getRightChild().addRightChild(new BinaryTree<Integer>(4));
        ab.getRightChild().getRightChild().addRightChild(new BinaryTree<Integer>(18));
        ab.getRightChild().getRightChild().getRightChild().addLeftChild(new BinaryTree<Integer>(8));
        ab.getRightChild().getRightChild().getRightChild().addRightChild(new BinaryTree<Integer>(24));
        ab.entreNiveles(0, 4);
        
        ParcialArboles parcialArb = new ParcialArboles(ab);
        System.out.println("Resultado=" + parcialArb.isTwoTree(2));
        System.out.println("Resultado=" + parcialArb.isTwoTree(7));
        System.out.println("Resultado=" + parcialArb.isTwoTree(-3));
        System.out.println("Resultado=" + parcialArb.isTwoTree(4));
        System.out.println("Resultado=" + parcialArb.isTwoTree(55));
    }
    
}
