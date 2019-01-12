package ejercicio13;

import java.util.ArrayList;

import utilesFran.Amadeus;

public class PuntoDeSilla {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Amadeus amadeus = new Amadeus();

		//Descomentar para probar con matrices aleatorias
		//int[][] matriz = amadeus.creaMatriz(4, 4, 99);
		//Y comentar esta línea
		int[][] matriz = {{2,8,4,8},{0,0,0,0},{0,0,0,0},{2,3,3,3}};
		
		int aux; //Variable auxiliar
		int col; //Variable para guardar la columna
		ArrayList<Integer> respuestas=new ArrayList<Integer>(); //Para uno de los ejercicios comentados
		System.out.println("Esta es nuestra matriz");
		amadeus.imprimeMatriz(matriz);
		System.out.println();

		// System.out.println(amadeus.menorEnFila(matriz, 0));

		//EL MAYOR VALOR DE UNA FILA Y UNA COLUMNA 
		/*for (int i = 0; i < matriz.length; i++) {
			aux = amadeus.mayorEnFila(matriz, i);
			respuestas = amadeus.posicionesMayorEnFila(matriz, i);
			for (int j = 0; j < respuestas.length; j++) {
				if(aux==amadeus.mayorEnColumna(matriz, respuestas[j]))
					System.out.println(aux+", fila "+i+" y columna "+respuestas[j]+", es el mayor común");
			}
		}*/

		//OTRA VERSIÓN BUENA, PERO MENOS EFICIENTE
		/*for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				if (amadeus.menorEnFila(matriz, i) == amadeus.mayorEnColumna(matriz, j)) {
					System.out.println(matriz[i][j] + "(Posición:[" + i + "," + j + "]" + " es un punto de silla");
				}
			}
		}*/
		
		//Para cada fila, buscamos el menor valor existente y guardamos ese valor en un auxiliar.
		for (int i = 0; i < matriz.length; i++) {
			aux=amadeus.menorEnFila(matriz, i);
			for (int j = 0; j < matriz[i].length; j++) {
				if(aux==matriz[i][j]) { //Ahora, si el valor coincide en la fila, bloqueamos la columna y comprobamos
					if(aux==amadeus.mayorEnColumna(matriz, j))
						System.out.println(matriz[i][j] + "(Posición:[" + i + "," + j + "]" + " es un punto de silla");
				}
			}
		}
		
		
		 

	}

}
