package parciales.arboles.segunda_fecha_parcial_29_06_2024_tema_2;

import tp2.ejercicio2.BinaryTree;

public class ParcialArboles {
    private BinaryTree<Integer> arbol;

    public ParcialArboles(BinaryTree<Integer> arbol){
        this.arbol = arbol;
    }

    public BinaryTree<Integer> nuevoTree(){
        BinaryTree<Integer> nuevoArbol = new BinaryTree<>();
        if (!this.arbol.isEmpty()){
            procesar(this.arbol, nuevoArbol, 0);
        }
        return nuevoArbol;
    }

    private void procesar(BinaryTree<Integer> arbol, BinaryTree<Integer> arbolNuevo, int izq){
        arbolNuevo.setData(izq + arbol.getData());

        if (arbol.hasLeftChild()){
            arbolNuevo.addLeftChild(new BinaryTree<>());
            procesar(arbol.getLeftChild(), arbolNuevo.getLeftChild(), 0);
        }
        if (arbol.hasRightChild()){
            int hijoIzq = 0;
            if (arbol.hasLeftChild()){
                hijoIzq = arbol.getLeftChild().getData();
            }
            arbolNuevo.addRightChild(new BinaryTree<>());
            procesar(arbol.getRightChild(), arbolNuevo.getRightChild(), hijoIzq);
        }
    }
    
    /* Solucion de valen
    public BinaryTree<Integer> nuevoTree(){
        BinaryTree<Integer> nuevo = new BinaryTree<Integer> ();
        if (!this.arbol.isEmpty())
            nuevo = crear (this.arbol, 0);
        return nuevo;
    }
    
    private BinaryTree<Integer> crear (BinaryTree<Integer> arbol, int izq){
        BinaryTree<Integer> nuevo = new BinaryTree<Integer> (arbol.getData() + izq);
        int izquierdo = 0;
        if (arbol.hasLeftChild()){
            izquierdo = arbol.getLeftChild().getData();
            nuevo.addLeftChild(crear (arbol.getLeftChild(), 0));
        }
        if (arbol.hasRightChild())
            nuevo.addRightChild(crear (arbol.getRightChild(), izquierdo));
        return nuevo;
    }
    */

    public static void main(String[] args) {
        BinaryTree<Integer> ab = new BinaryTree<>(1);
        ab.addLeftChild(new BinaryTree<>(2));
        ab.addRightChild(new BinaryTree<>(3));
        ab.getLeftChild().addLeftChild(new BinaryTree<>(4));

        BinaryTree<Integer> ab1 = new BinaryTree<>(7);
        ab.getRightChild().addRightChild(ab1);
        ab1.addLeftChild(new BinaryTree<>(8));
        ab1.getLeftChild().addLeftChild(new BinaryTree<>(9));
        ab1.getLeftChild().addRightChild(new BinaryTree<>(10));

        //ParcialArboles parcial = new ParcialArboles(ab);

        System.out.println("Arbol dado");
        //ab.imprimirArbol();

        System.out.println(" ");
        System.out.println("Nuevo arbol");

        //BinaryTree<Integer> arbolNuevo = parcial.nuevoTree();

        //arbolNuevo.imprimirArbol();
    }
}
