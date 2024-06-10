package tp5.ejercicio3;

import java.util.LinkedList;
import java.util.List;

public class CaminoMinimo {
	private List<String> camino;
    private int minimo;
    
    public CaminoMinimo() {
        camino = new LinkedList<String>();
        minimo = 9999;
    }
    
	public List<String> getCamino() {
		return camino;
	}
	public void setCamino(List<String> camino) {
		this.camino = camino;
	}
	public int getMinimo() {
		return minimo;
	}
	public void setMinimo(int minimo) {
		this.minimo = minimo;
	} 
}
