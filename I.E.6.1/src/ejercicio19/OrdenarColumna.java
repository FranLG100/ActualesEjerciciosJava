package ejercicio19;

import java.io.IOException;

import utilesFran.Amadeus;

public class OrdenarColumna {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		Amadeus amadeus=new Amadeus();
		int columna = 0;
		int tamanho=5;
		//int[][] matriz=new int[tamanho][tamanho];
		//int[] array=new int[tamanho];
		
		//Hemos hecho una matriz ya predefinida para comprobar que el siguiente array
		//se encuentra contenida en ella. En otro caso, sería complicado que aleatoriamente
		//saliese
		int[][] matriz={{1,2,3,5,4},{1,2,4,8,5},{0,5,2,2,3},{5,8,2,4,0},{1,5,7,0,3}};
		int[] array={5,8,2,4,0};
		int[] arrayAuxiliar=new int[tamanho];


		System.out.println("Array generado:");
		amadeus.imprimeArray(array);
		System.out.println("\n\nMatriz generada:");
		amadeus.imprimeMatriz(matriz);
		
		columna=amadeus.comprobarColumnaContenida(matriz, array);
		
		if(columna>=0) {
		System.out.println("¿Cómo desea ordenarla?");
		System.out.println("1.-Método de la burbuja");
		System.out.println("2.-Método de inserción directa");
		
		int opcion=amadeus.controlaIntMinMax(1, 2);
		switch (opcion) {
		case 1:
			arrayAuxiliar=amadeus.ordenacionAscendenteBurbujaArray(array);
			break;
		default:
			arrayAuxiliar=amadeus.ordenacionDirectaAscendenteArray(array);
			break;
		}
		
		for (int i = 0; i < matriz.length; i++) {
			matriz[i][columna]=arrayAuxiliar[i];
		}
		
		amadeus.imprimeMatriz(matriz);
		}
		
		
	}

}
