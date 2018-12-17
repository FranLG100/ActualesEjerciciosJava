package ejerciciosArray;

import utilesFran.Amadeus;

public class Ejercicio08 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Amadeus amadeus=new Amadeus();
		int[][] matriz = amadeus.creaMatrizLlena(5, 5, 9);
		int[] diagonal=new int[matriz.length];
		
		System.out.println("MATRIZ ORIGINAL");
		amadeus.imprimeMatriz(matriz);
		
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				if(i==j) {
					diagonal[i]=matriz[i][j];
				}
			}
		}
		
		diagonal=amadeus.invierteArray(diagonal);
		
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				if(i==j) {
					matriz[i][j]=diagonal[i];
				}
			}
		}
		
		System.out.println("\n\nMATRIZ CON DIAGONAL INVERSA");
		amadeus.imprimeMatriz(matriz);
	}

}
