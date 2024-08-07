package parciales.arboles.ejercicio_parcial_princesa;

public class Personaje {
    private String nombre;
    private String tipo; //Dragon, Princesa, Animal, etc.
    
    public Personaje(String nombre, String tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
        }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo(){
        return this.tipo;
    }

    public void setTipo(String tipo){
        this.tipo = tipo;
    }
     
    public boolean esDragon(){
        return this.getTipo().equals("Dragon");
    }

    public boolean esPrincesa(){
        return this.getTipo().equals("Princesa");
    }

	@Override
	public String toString() {
		return "Personaje [nombre=" + nombre + ", tipo=" + tipo + "]";
	}
}
