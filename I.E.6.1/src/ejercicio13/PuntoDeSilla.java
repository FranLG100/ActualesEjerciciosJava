package ejercicio13;

import utilesFran.Amadeus;

public class PuntoDeSilla {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Amadeus amadeus = new Amadeus();

		int[][] matriz = amadeus.creaMatriz(4, 4, 99);
		
		int aux;
		int col;
		int[] respuestas;
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

		
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				if (amadeus.menorEnFila(matriz, i) == amadeus.mayorEnColumna(matriz, j)) {
					System.out.println(matriz[i][j] + "(Posición:[" + i + "," + j + "]" + " es un punto de silla");
				}
			}
		}
		
		/*for (int i = 0; i < matriz.length; i++) {
			aux = amadeus.menorEnFila(matriz, i);
			respuestas = amadeus.posicionesMenorEnFila(matriz, i);
			for (int j = 0; j < respuestas.length; j++) {
				if(aux==amadeus.mayorEnColumna(matriz, respuestas[j]))
					System.out.println(aux+", fila "+i+" y columna "+respuestas[j]+", es un punto de Silla");
			}
		}*/
		
		
		 

	}

}
