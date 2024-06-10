package tp5.ejercicio5;

public class Jubilado extends Persona{
	private boolean jubilacionRecibida;
	private int distancia;
	
	public Jubilado(String nombre, String domicilio, boolean jubilacionRecibida, int distancia) {
		super(nombre, domicilio);
		this.jubilacionRecibida = jubilacionRecibida;
		this.distancia = distancia;
	}

	public boolean isJubilacionRecibida() {
		return jubilacionRecibida;
	}

	public void setJubilacionRecibida(boolean jubilacionRecibida) {
		this.jubilacionRecibida = jubilacionRecibida;
	}

	public float getDistancia() {
		return distancia;
	}

	public void setDistancia(int distancia) {
		this.distancia = distancia;
	}	
}
