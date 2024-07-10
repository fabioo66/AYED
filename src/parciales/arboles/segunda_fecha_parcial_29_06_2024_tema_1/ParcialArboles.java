package parciales.arboles.segunda_fecha_parcial_29_06_2024_tema_1;

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

    private void procesar(BinaryTree<Integer> arbol, BinaryTree<Integer> arbolNuevo, int padre){
        arbolNuevo.setData(arbol.getData() + padre);

        if (arbol.hasLeftChild()){
            arbolNuevo.addLeftChild(new BinaryTree<>());
            procesar(arbol.getLeftChild(), arbolNuevo.getLeftChild(), arbol.getData());
        }
        if (arbol.hasRightChild()){
            arbolNuevo.addRightChild(new BinaryTree<>());
            procesar(arbol.getRightChild(), arbolNuevo.getRightChild(), 0);
        }
    }

    /* Solucion de valen
    public BinaryTree<Integer> nuevoTree(){
        BinaryTree<Integer> nuevo = new BinaryTree<Integer> ();
        if (!this.arbol.isEmpty())
            nuevo = crearTema1 (this.arbol, 0);
        return nuevo;
    }
    
    private BinaryTree<Integer> crearTema1 (BinaryTree<Integer> arbol, int padre){
        BinaryTree<Integer> nuevo = new BinaryTree<Integer> (arbol.getData() + padre);
        if (arbol.hasLeftChild())
            nuevo.addLeftChild(crearTema1 (arbol.getLeftChild(), arbol.getData()));
        if (arbol.hasRightChild())
            nuevo.addRightChild(crearTema1 (arbol.getRightChild(), 0));
        return nuevo;
    }
    */

    public static void main(String[] args) {
        BinaryTree<Integer> ab = new BinaryTree<>(1);
        ab.addLeftChild(new BinaryTree<>(2));
        ab.addRightChild(new BinaryTree<>(3));
        ab.getLeftChild().addLeftChild(new BinaryTree<>(4));

        BinaryTree<Integer> ab1 = new BinaryTree<>(5);
        ab.getRightChild().addLeftChild(ab1);
        ab.getRightChild().addRightChild(new BinaryTree<>(6));
        ab1.addLeftChild(new BinaryTree<>(7));

        //ParcialArboles parcial = new ParcialArboles(ab);

        System.out.println("Arbol dado");
        //ab.imprimirArbol();

        System.out.println(" ");
        System.out.println("Nuevo arbol");

        //BinaryTree<Integer> arbolNuevo = parcial.nuevoTree();

        //arbolNuevo.imprimirArbol();
    }
}
