package tp1.ejercicio7;

import java.util.ArrayList;
import java.util.List;

public class EjercicioSucesion {
	
    public List<Integer> calcularSucesion(int n) {
        List<Integer> sucesion = new ArrayList<>();
        sucesion.add(n);
        if (n == 1) {
            return sucesion;
        } else {
            if (n % 2 == 0) {
                sucesion.addAll(calcularSucesion(n / 2));
            } else {
                sucesion.addAll(calcularSucesion(3 * n + 1));
            }
            return sucesion;
        }
    }
	
	public static void main (String[] args) {
		EjercicioSucesion ejercicio = new EjercicioSucesion();
		List<Integer> sucesion;
		sucesion = ejercicio.calcularSucesion(6);
		
		System.out.println("Lista de sucesion: ");
		for(int i : sucesion) {
			System.out.println(i);
		}
	}
}
