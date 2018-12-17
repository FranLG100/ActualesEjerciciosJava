package ejerciciosArray;

import utilesFran.Amadeus;

public class Ejercicio04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Amadeus amadeus=new Amadeus();
		int suma=0;
		int[] array=amadeus.creaArrayLleno(20, 100);
		int mayor=array[0];
		System.out.println("Nuestro array:");
		amadeus.imprimeArray(array);
		
		//Cuento con que el elemento array[1] es una posición par, porque es la segunda
		//posición
		for (int i = 0; i < array.length; i++) {
			if(i%2==0)
				suma+=array[i];
			else {
				if(array[i]>mayor)
					mayor=array[i];
			}
		}
		
		System.out.println();
		System.out.println("La suma de los elementos pares es: "+suma);
		System.out.println("El mayor elemento impar es : "+mayor);

	}

}
