package tp1.ejercicio5;

public class Ejercicio5 {
	private static int maxValue;
	private static int minValue;
	private static double average;
	
	public static Datos conRet(int[] array) {
		int max = -99999, min = 99999, suma = 0;
		double prom = 0;
		for(int i = 0; i < array.length; i++) {
			if(array[i] > max) {
				max = array[i];
			}
			if(array[i] < min) {
				min = array[i];
		    }
			suma += array[i];
		}	
		prom = (double) suma / array.length;
			
		Datos obj = new Datos(max, min, prom);
		return obj;
	}
	
	public static void sinRet(int [] array, Datos obj) {
		int max = -99999, min = 99999, suma = 0;
		double prom = 0;
		for(int i = 0; i < array.length; i++) {
			if(array[i] > max) {
				max = array[i];
			}
			if(array[i] < min) {
				min = array[i];
		    }
			suma += array[i];
		}	
		prom = (double) suma / array.length;
		
		obj.setMax(max);
	    obj.setMin(min);
	    obj.setPromedio(prom);
	}
	
	public static void sinNada(int [] array) {
		maxValue = -9999;
		minValue = 99999;
		int suma = 0;
		for(int i = 0; i < array.length; i++) {
			if(array[i] > maxValue) {
				maxValue = array[i];
			}
			if(array[i] < minValue) {
				minValue = array[i];
		    }
			suma += array[i];
		}	
		average = (double) suma / array.length;
	}

	public static void main(String[] args) {
		
		System.out.println("Con ret : ");
		int [] arrayConRet = {1,8,10,3,2};
		Datos resultConRet = conRet(arrayConRet);
		System.out.println("Máximo: " + resultConRet.getMax() + "\n" +
	    				   "Mínimo: " + resultConRet.getMin() + "\n" +
	                       "Promedio: " + resultConRet.getPromedio());
		
		System.out.println("-------------------------------------------");

		System.out.println("Sin ret : ");
	    int [] arraySinRet = {7,9,10,6};
	    Datos resultSinRet = new Datos(7,7,7);
	    Ejercicio5.sinRet(arraySinRet, resultSinRet);
	    System.out.println("Máximo: " + resultSinRet.getMax() + "\n" +
				           "Mínimo: " + resultSinRet.getMin() + "\n" +
                           "Promedio: " + resultSinRet.getPromedio());
	    
	    System.out.println("-------------------------------------------");
	    
	    System.out.println("Sin ret y sin parametros: ");
	    int [] v = {7,7,7,6,8,4};
	    Ejercicio5.sinNada(v);
	    System.out.println("Máximo: " + maxValue + "\n" +
		                   "Mínimo: " + minValue + "\n" +
                           "Promedio: " + average);
	}
}