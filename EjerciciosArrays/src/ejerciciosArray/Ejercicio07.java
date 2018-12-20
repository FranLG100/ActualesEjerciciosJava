package ejerciciosArray;

import utilesFran.Amadeus;

public class Ejercicio07 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Amadeus amadeus = new Amadeus();
		int[][] matrizA=amadeus.creaMatrizLlena(4, 6, 9);
		int[][] matrizB=amadeus.creaMatrizLlena(4, 6, 9);
		int min=amadeus.menorEnLaMatriz(matrizA);
		int max=amadeus.mayorEnLaMatriz(matrizB);
		
		System.out.println("MATRIZ ORIGINAL A");
		amadeus.imprimeMatriz(matrizA);
		System.out.println("\nMATRIZ ORIGINAL B");
		amadeus.imprimeMatriz(matrizB);
		
		for (int i = 0; i < matrizA.length; i++) {
			for (int j = 0; j < matrizA[i].length; j++) {
				if(matrizA[i][j]==min)
					matrizA[i][j]=max;
			}
		}
		
		for (int i = 0; i < matrizB.length; i++) {
			for (int j = 0; j < matrizB[i].length; j++) {
				if(matrizB[i][j]==max)
					matrizB[i][j]=min;
			}
		}
		
		System.out.println("\nMATRIZ A INTERCAMBIADA");
		amadeus.imprimeMatriz(matrizA);
		System.out.println("\nMATRIZ B INTERCAMBIADA");
		amadeus.imprimeMatriz(matrizB);
	}

}
