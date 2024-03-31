package tp1.ejercicio5;

public class Datos {
	private int min;
	private int max;
	private double promedio;
	
	public Datos(int unMin, int unMax, double unPromedio) {
		setMin(unMin);
		setMax(unMax);
		setPromedio(unPromedio);
	}
	
	public int getMin() {
		return min;
	}
	public void setMin(int min) {
		this.min = min;
	}
	public int getMax() {
		return max;
	}
	public void setMax(int max) {
		this.max = max;
	}
	public double getPromedio() {
		return promedio;
	}
	public void setPromedio(double promedio) {
		this.promedio = promedio;
	}
}