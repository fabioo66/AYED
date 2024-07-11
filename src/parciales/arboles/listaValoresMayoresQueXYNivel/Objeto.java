package parciales.arboles.listaValoresMayoresQueXYNivel;

public class Objeto {
    private int valor;
    private int nivel;

    public Objeto(int valor, int nivel) {
        this.valor = valor;
        this.nivel = nivel;
    }

    public int getValor() {
        return valor;
    }

    public int getNivel() {
        return nivel;
    }

    @Override
    public String toString() {
        return "Objeto [nivel=" + nivel + ", valor=" + valor + "]";
    }
}
