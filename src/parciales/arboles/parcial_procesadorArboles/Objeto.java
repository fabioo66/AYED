package parciales.arboles.parcial_procesadorArboles;

import java.util.*;

import tp2.ejercicio2.BinaryTree;

public class Objeto {
    private List<BinaryTree<Integer>> list;
    private int cantPares;
    

    public Objeto(List<BinaryTree<Integer>> list, int cantPares){
        this.list = list;
        this.cantPares = cantPares;
    }

    public List<BinaryTree<Integer>> getList(){
        return this.list;
    }

    public void setList(List<BinaryTree<Integer>> list){
        this.list = list;
    }

    public void add(BinaryTree<Integer> arbol){
        this.list.add(arbol);
    }

    public int getCantPares(){
        return this.cantPares;
    }

    public void setCantPares(int cantPares){
        this.cantPares = cantPares;
    }

    public void incrementarCantPares(){
        this.cantPares++;
    }

    public String toString(){
        return "Cantidad de pares: " + this.cantPares + "\n" + this.list.toString();
    }
}
