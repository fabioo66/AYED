package parciales.arboles.parcial_promedioArbol;

public class Objeto {
    private int suma;
    private int cantidad;

    public Objeto() {
        this.suma = 0;
        this.cantidad = 0;
    }

    public void agregar(int valor) {
        this.suma += valor;
        this.cantidad++;
    }

    public int promedio() {
        return this.suma / this.cantidad;
    }

    public int getSuma() {
        return suma;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setSuma(int suma) {
        this.suma = suma;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
