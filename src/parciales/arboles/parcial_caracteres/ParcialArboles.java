package parciales.arboles.parcial_caracteres;

import tp3.ejercicio1.GeneralTree;

import java.util.*;

public class ParcialArboles {
    
    public List<List<Character>> caminosPares(GeneralTree<Character> arbol){
        List<List<Character>> lista = new LinkedList<List<Character>>(); 
        if (!arbol.isEmpty()){
            procesar(arbol, lista, new LinkedList<Character>(), 1);
        }
        return lista;
    }   

    private void procesar(GeneralTree<Character> arbol, List<List<Character>> lista, List<Character> listaActual, int cant){
        listaActual.add(arbol.getData());
        if (arbol.isLeaf() && cant % 2 == 0){
            lista.add(new LinkedList<>(listaActual));
        }else{
            List<GeneralTree<Character>> children = arbol.getChildren();
            for (GeneralTree<Character> child : children){
                procesar(child, lista, listaActual, cant+1);
            }
        }
        listaActual.remove(listaActual.size()-1);
    }

    public static void main(String args[]) {
        ParcialArboles p = new ParcialArboles();
        
        List<GeneralTree<Character>> subChildren1 = new LinkedList<GeneralTree<Character>>();
        subChildren1.add(new GeneralTree<Character>('E'));
        GeneralTree<Character> a1 = new GeneralTree<Character>('B', subChildren1);
        
        List<GeneralTree<Character>> subChildren2 = new LinkedList<GeneralTree<Character>>();
        subChildren2.add(new GeneralTree<Character>('H'));
        subChildren2.add(new GeneralTree<Character>('I'));
        GeneralTree<Character> subAb1 = new GeneralTree<Character>('F', subChildren2);
        List<GeneralTree<Character>> subChildren3 = new LinkedList<GeneralTree<Character>>();
        subChildren3.add(subAb1);
        subChildren3.add(new GeneralTree<Character>('G'));
        GeneralTree<Character> a2 = new GeneralTree<Character>('C', subChildren3);
        
        List<GeneralTree<Character>> arbol = new LinkedList<GeneralTree<Character>>();
        arbol.add(a1);
        arbol.add(a2);
        arbol.add(new GeneralTree<Character>('D'));
        GeneralTree<Character> a = new GeneralTree<Character>('A', arbol);
        
        List<List<Character>> lis = p.caminosPares(a);
        for(List<Character>l: lis) {
            System.out.println(l);
        }
    }
}
