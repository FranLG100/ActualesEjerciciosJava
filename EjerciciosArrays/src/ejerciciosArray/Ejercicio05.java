package ejerciciosArray;

import utilesFran.Amadeus;

public class Ejercicio05 {
	public static void main(String[] args) {

		Amadeus amadeus = new Amadeus();
		int cont=0;
		int[] array = amadeus.creaArrayLleno(10, 50);
		System.out.println("Nuestro array es: ");
		amadeus.imprimeArray(array);
		System.out.println("\n");
		
		for (int i = 0; i < array.length; i++) {
			for (int j = 2; j <= array[i]/2; j++) {
				if(array[i]%j==0)
					cont++;
			}
			if (cont==0)
				System.out.println(array[i]+" es primo");
			cont=0;
		}
	}
}
