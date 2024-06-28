package parciales.grafos.simulacro_parcial_2024;

public class Ciudad {
    private String nombre;
    private int dias;

    public Ciudad(int dias, String nombre){
        this.dias = dias;
        this.nombre = nombre;
    }

    public String getNombre(){
        return this.nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public int getDias(){
        return this.dias;
    }

    public void setDias(int dias){
        this.dias = dias;
    }

    public String toString(){
        return this.nombre + " " + this.dias;
    }
}