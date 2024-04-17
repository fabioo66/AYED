package tp3.ejercicio2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import tp1.ejercicio8.Queue;
import tp3.ejercicio1.GeneralTree;

public class RecorridosAG {
	public List<Integer> numerosImparesMayoresQuePreOrden (GeneralTree <Integer> a, Integer n){
		ArrayList<Integer> lista = new ArrayList<Integer>();
		if(!a.isEmpty() && a.getData() != null) {
			preOrder(a, n, lista);
			return lista;
		}else {
			return null;
		}
	}
	
	private void preOrder(GeneralTree <Integer> ab, Integer n, ArrayList <Integer> lista) {
		if(ab.getData() % 2 != 0 && ab.getData() > n);
			lista.add(ab.getData());
		List<GeneralTree<Integer>> children = ab.getChildren();
		for (GeneralTree<Integer> child: children) {
			preOrder(child, n, lista);
		}
	}
	
	public List<Integer> numerosImparesMayoresQueInOrden (GeneralTree <Integer> a, Integer n){
		ArrayList<Integer> lista = new ArrayList<Integer>();
		if(!a.isEmpty() && a.getData() != null) {
			inOrder(a, n, lista);
			return lista;
		}else {
			return null;
		}
	}
	
	private void inOrder(GeneralTree <Integer> ab, Integer n, ArrayList <Integer> lista) {
		List<GeneralTree<Integer>> children = ab.getChildren();
		if(ab.getData() % 2 != 0 && ab.getData() > n);
			lista.add(ab.getData());
		for (GeneralTree<Integer> child: children) {
			inOrder(child, n, lista);
		}
	}
	
	public List<Integer> numerosImparesMayoresQuePostOrden (GeneralTree <Integer> a, Integer n){
		ArrayList<Integer> lista = new ArrayList<Integer>();
		if(!a.isEmpty() && a.getData() != null) {
			postOrder(a, n, lista);
			return lista;
		}else {
			return null;
		}
	}
	
	private void postOrder(GeneralTree <Integer> ab, Integer n, ArrayList <Integer> lista) {
		List<GeneralTree<Integer>> children = ab.getChildren();
		for (GeneralTree<Integer> child: children) {
			inOrder(child, n, lista);
		}
		if(ab.getData() % 2 != 0 && ab.getData() > n);{
			lista.add(ab.getData());
		}
	}
	
	public List<Integer> numerosImparesMayoresQuePorNiveles(GeneralTree <Integer> a, Integer n){
		ArrayList<Integer> lista = new ArrayList<Integer>();
		if(!a.isEmpty() && a.getData() != null) {
			porNiveles(a, n, lista);
			return lista;
		}else {
			return null;
		}
	}
	
	private void porNiveles(GeneralTree <Integer> ab, Integer n, ArrayList <Integer> lista) {
		GeneralTree<Integer> tree_aux;
		
		Queue<GeneralTree<Integer>> queue = new Queue<GeneralTree<Integer>>();
		queue.enqueue(ab);
		
		while(!queue.isEmpty()) {
			tree_aux = queue.dequeue();
			if(tree_aux.getData() % 2 != 0 && tree_aux.getData() > n) {
				lista.add(tree_aux.getData());
			}
			List<GeneralTree<Integer>> children = tree_aux.getChildren();
			for (GeneralTree<Integer> child: children) {
				queue.enqueue(child);
			}	
		}
	}
	
    public static void main(String[] args) {
        GeneralTree<Integer> a1 = new GeneralTree<Integer>(1);
        List<GeneralTree<Integer>> children2 = new LinkedList<GeneralTree<Integer>>();
        children2.add(new GeneralTree<Integer>(21));
        children2.add(new GeneralTree<Integer>(22));
        children2.add(new GeneralTree<Integer>(23));
        GeneralTree<Integer> a2 = new GeneralTree<Integer>(2, children2);
        List<GeneralTree<Integer>> children3 = new LinkedList<GeneralTree<Integer>>();
        children3.add(new GeneralTree<Integer>(31));
        children3.add(new GeneralTree<Integer>(32));
        GeneralTree<Integer> a3 = new GeneralTree<Integer>(3, children3);
        List<GeneralTree<Integer>> childen = new LinkedList<GeneralTree<Integer>>();
        childen.add(a1);childen.add(a2);childen.add(a3);
        GeneralTree<Integer> a = new GeneralTree<Integer>(11, childen);
        
        System.out.println("AlturaMax=" + a.altura());
        System.out.println("Ancho=" + a.ancho());
        
        RecorridosAG rec = new RecorridosAG();
        
        System.out.println("PREORDEN:" + rec.numerosImparesMayoresQuePreOrden(a, 0));
        System.out.println("INORDEN:" + rec.numerosImparesMayoresQueInOrden(a, 0));
        System.out.println("POSTORDEN:" + rec.numerosImparesMayoresQuePostOrden(a, 0));
        System.out.println("POR NIVELES:" + rec.numerosImparesMayoresQuePorNiveles(a, 0));
    }
}
