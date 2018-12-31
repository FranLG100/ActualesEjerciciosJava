package ejercicio18;

import java.io.IOException;

import utilesFran.Amadeus;

public class OrdenarMatriz {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		Amadeus amadeus=new Amadeus();
		int [][] matriz=amadeus.creaMatriz(5, 5, 9);
		int[] arrayAuxiliar=new int[5];
		amadeus.imprimeMatriz(matriz);
		int fila=0;
		
		System.out.println("\nIntroduzca fila a ordenar");
		fila=amadeus.controlaIntMinMax(0, 4);
		
		for (int i = 0; i < arrayAuxiliar.length; i++) {
			arrayAuxiliar[i]=matriz[fila][i];
		}
		
		arrayAuxiliar=amadeus.ordenacionAscendenteBurbujaArray(arrayAuxiliar);
		
		for (int i = 0; i < arrayAuxiliar.length; i++) {
			matriz[fila][i]=arrayAuxiliar[i];
		}
		
		System.out.println();
		amadeus.imprimeMatriz(matriz);
		
		System.out.println("\nAhora ordenaremos la diagonal");
		
		for (int i = 0; i < arrayAuxiliar.length; i++) {
			arrayAuxiliar[i]=matriz[i][i];
		}
		arrayAuxiliar=amadeus.ordenacionDirectaAscendenteArray(arrayAuxiliar);
		for (int i = 0; i < arrayAuxiliar.length; i++) {
			matriz[i][i]=arrayAuxiliar[i];
		}
		
		System.out.println();
		amadeus.imprimeMatriz(matriz);
	}

}
