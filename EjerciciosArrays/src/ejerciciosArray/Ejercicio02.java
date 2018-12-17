package ejerciciosArray;

import utilesFran.Amadeus;

public class Ejercicio02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Amadeus amadeus=new Amadeus();
		int[][] matrizA=amadeus.creaMatrizLlena(2, 3, 9);
		amadeus.imprimeMatriz(matrizA);
		
		System.out.println("");
		int[][] matrizB=amadeus.creaMatrizLlena(2, 3, 9);
		amadeus.imprimeMatriz(matrizB);
		
		System.out.println("");
		int[][] matrizSuma=amadeus.sumaMatriz(matrizA, matrizB);
		amadeus.imprimeMatriz(matrizSuma);
		
	}

}
