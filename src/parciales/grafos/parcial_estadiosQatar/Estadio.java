package parciales.grafos.parcial_estadiosQatar;

public class Estadio {
    private String ciudad;
    private String estadio;

    public Estadio(String ciudad, String estadio) {
        this.ciudad = ciudad;
        this.estadio = estadio;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getEstadio() {
        return estadio;
    }

    public void setEstadio(String estadio) {
        this.estadio = estadio;
    }

    @Override
    public String toString() {
        return "Estadio [ciudad=" + ciudad + ", estadio=" + estadio + "]";
    }
}
