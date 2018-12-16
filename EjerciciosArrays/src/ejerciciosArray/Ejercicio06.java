package ejerciciosArray;

import utilesFran.Amadeus;

public class Ejercicio06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Amadeus amadeus=new Amadeus();
		int[] array=amadeus.creaArrayLleno(100, 1000);
		int pares=0;
		
		for (int i = 0; i < array.length; i++) {
			if(array[i]%2==0)
				pares++;
		}
		System.out.println("ARREGLO INICIAL:");
		amadeus.imprimeArray(array);
		int[]par=new int[pares];
		int[]impar=new int[100-pares];
		int j=0;
		int k=0;
		
		for (int i = 0; i < array.length; i++) {
			if(array[i]%2==0){
				par[j]=array[i];
				j++;
			}else {
				impar[k]=array[i];
				k++;
			}
		}
		System.out.println("\nPARES:");
		amadeus.imprimeArray(par);
		System.out.println("\nIMPARES:");
		amadeus.imprimeArray(impar);
	}

}
