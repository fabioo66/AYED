package parciales.grafos.primera_fecha_grafos_15_06_2024_tema_2;

public class Recinto {
    String nombre;
    int minutos;

    public Recinto(String nombre, int minutos){
        this.nombre = nombre;
        this.minutos = minutos;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public int getMinutos(){
        return minutos;
    }

    public void setMinutos(int minutos){
        this.minutos = minutos;
    }
}
