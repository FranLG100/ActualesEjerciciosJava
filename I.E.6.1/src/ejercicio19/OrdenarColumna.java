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
		int[][] matriz={{1,2,3,5,4},{1,2,4,8,5},{0,5,2,2,3},{5,8,2,4,0},{1,5,7,0,3}};
		int[] array={5,8,2,4,0};
		int[] arrayAuxiliar=new int[tamanho];
		int index=0;
		int coincidencia=0;
		
		System.out.println("Array generado:");
		amadeus.imprimeArray(array);
		System.out.println("\n\nMatriz generada:");
		amadeus.imprimeMatriz(matriz);
		
		for (int i = 0; i < matriz.length; i++) {
			index=0;
			while((index<matriz.length)&&(array[index]==matriz[i][index])) {
				coincidencia++;
				index++;	
			}
			if (coincidencia==matriz.length) {
				System.out.println("\nEl array se encuentra en la columna "+i);
				columna=i;
				break;
			}else
				coincidencia=0;
		}
		
		System.out.println("�C�mo desea ordenarla?");
		System.out.println("1.-M�todo de la burbuja");
		System.out.println("2.-M�todo de inserci�n directa");
		
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
