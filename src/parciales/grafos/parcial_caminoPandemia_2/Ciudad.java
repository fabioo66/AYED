package parciales.grafos.parcial_caminoPandemia_2;

public class Ciudad {
    private String nombre;
    private String fase;

    public Ciudad(String nombre, String fase) {
        this.nombre = nombre;
        this.fase = fase;
    }

    public String getNombre() {
        return nombre;
    }

    public void setFase(String fase) {
        this.fase = fase;
    }

    public String getFase() {
        return fase;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre + " - " + fase;
    }
}
