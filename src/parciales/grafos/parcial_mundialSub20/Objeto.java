package parciales.grafos.parcial_mundialSub20;

import java.util.*;

public class Objeto {
    private List<String> lista;
    private int cuadras;

    public Objeto(List<String> lista, int cuadras) {
        this.lista = lista;
        this.cuadras = cuadras;
    }

    public List<String> getListaDeListas() {
        return lista;
    }

    public void setListaDeListas(List<String> lista) {
        this.lista = lista;
    }

    public int getCuadras() {
        return cuadras;
    }

    public void setCuadras(int cuadras) {
        this.cuadras = cuadras;
    }

    public String toString() {
        return "Objeto [lista=" + lista + ", cuadras=" + cuadras + "]";
    }
}
