package ejerciciosArray;

import java.util.Random;

import utilesFran.Amadeus;

public class Ejercicio01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Amadeus amadeus=new Amadeus();
		
		int[] factoriales;
		
		factoriales=amadeus.creaArrayLleno(20, 10);
		System.out.println("Array creado:");
		amadeus.imprimeArray(factoriales);
		System.out.println("\n\nFactoriales del array creado");
		for (int i = 0; i < factoriales.length; i++) {
			int aux=factoriales[i]-1;
			while(aux>1) {
				factoriales[i]*=aux;
				aux--;
			}
		}
		amadeus.imprimeArray(factoriales);
		
		
		
	}

}
