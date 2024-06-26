package parciales.arboles.parcial_descendientes;

import java.util.LinkedList;
import java.util.List;

import tp2.ejercicio2.BinaryTree;

public class Parcial {
    
    public List<Integer> resolver(BinaryTree<Integer> arbol){
        List<Integer> lista = new LinkedList<Integer>();
        if (!arbol.isEmpty()){
            procesar(arbol, lista);
        }
        return lista;
    }

    private void procesar(BinaryTree<Integer> arbol, List<Integer> lista){
        int cantIzq = 0;
        int cantDer = 0;

        if (arbol.hasLeftChild()){
            cantIzq = contarDescendientes(arbol.getLeftChild());
            procesar(arbol.getLeftChild(), lista);
        }
        if (arbol.hasRightChild()){
            cantDer = contarDescendientes(arbol.getRightChild());
            procesar(arbol.getRightChild(), lista);
        }
        if (cantIzq == cantDer){
            lista.add(arbol.getData());
        }
    }

    private int contarDescendientes(BinaryTree<Integer> arbol){
        int cant = 1;

        if (arbol.hasLeftChild()){
            cant += contarDescendientes(arbol.getLeftChild());
        }
        if (arbol.hasRightChild()){
            cant += contarDescendientes(arbol.getRightChild());
        }
        return cant;
    }

    public static void main(String[] args) {
        BinaryTree<Integer> ab = new BinaryTree<Integer>(2);
        ab.addLeftChild(new BinaryTree<Integer>(1));
        ab.getLeftChild().addLeftChild(new BinaryTree<Integer>(16));
        ab.getLeftChild().addRightChild(new BinaryTree<Integer>(6));
        ab.addRightChild(new BinaryTree<Integer>(5));
        ab.getRightChild().addRightChild(new BinaryTree<Integer>(8));
        ab.getRightChild().getRightChild().addLeftChild(new BinaryTree<Integer>(22));
        Parcial p = new Parcial();
        
        System.out.println(p.resolver(ab));
    }
}
