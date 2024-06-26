package parciales.arboles.ejercicio_parcial_directorios;

public class Recurso {
    private String nombre;
    private String tipo; // archivo o carpeta

    public Recurso(String nombre, String tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
    }
    
    public String getNombre(){
        return this.nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getTipo(){
        return this.tipo;
    }

    public void setTipo(String tipo){
        this.tipo = tipo;
    }

    public boolean esImagen() {
        if (tipo.equals("archivo")) {
            String ext = nombre.substring(nombre.indexOf('.') + 1);
            if (ext.equals("jpg") || ext.equals("png") || ext.equals("jpeg"))
                return true;
        }
        return false;
    }
}
