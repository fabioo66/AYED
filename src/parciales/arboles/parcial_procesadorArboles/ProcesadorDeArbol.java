package parciales.arboles.parcial_procesadorArboles;

import tp2.ejercicio2.BinaryTree;
import java.util.*;

public class ProcesadorDeArbol {
    private BinaryTree<Integer> arbol;

    public ProcesadorDeArbol(BinaryTree<Integer> arbol){
        this.arbol = arbol;
    }

    public Objeto procesar(){
        int cant = 0;
        List<BinaryTree<Integer>> lista = new LinkedList<BinaryTree<Integer>>();
        if (!this.arbol.isEmpty()){
            cant = procesar(this.arbol, lista);
        }
        Objeto objeto = new Objeto(lista, cant); 
        return objeto;
    }

    private int procesar(BinaryTree<Integer> arbol, List<BinaryTree<Integer>> lista){
        int cant = 0;
        if (arbol.getData() % 2 == 0){
            cant++;
            if (arbol.hasLeftChild() && arbol.hasRightChild()){
                lista.add(arbol);
            }
        }
        if (arbol.hasLeftChild()){
            cant += procesar(arbol.getLeftChild(), lista);
        }
        if (arbol.hasRightChild()){
            cant += procesar(arbol.getRightChild(), lista);
        }
        return cant;
    }

    public static void main(String[] args) {
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
        
        ProcesadorDeArbol p = new ProcesadorDeArbol(ab);
        Objeto parc = p.procesar();
        
        System.out.println("");
        
        System.out.println(parc.getList());

        System.out.println("-----------------");

        System.out.println(parc.getCantPares());
    }

}
