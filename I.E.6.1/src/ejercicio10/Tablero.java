package ejercicio10;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import utilesFran.Amadeus;

public class Tablero {

	Amadeus amadeus = new Amadeus();
	String[][] matriz = new String[8][8]; 
	ArrayList<String> celdas = new ArrayList<String>();
	ArrayList<String> barcos = new ArrayList<String>();
	int fila = 0;
	int columna = 0;
	int nBarcos = 8;
	int nBarcosActuales = 0;
	Random random = new Random();

	public void iniciarTablero() {

		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				matriz[i][j] = Integer.toString(i) + Integer.toString(j);
				//System.out.print(matriz[i][j] + " ");
			}
			//System.out.println();
		}
	}

	public void mostrarTablero() {

		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				String aux = Integer.toString(i) + Integer.toString(j);
				if (barcos.contains(aux) && celdas.contains(aux)) {
					System.out.print("*" + " ");
					//nBarcosActuales--;
					}
				else if(celdas.contains(aux)) {
					System.out.print("X" + " ");
				}
				else
					System.out.print("O" + " ");
			}
			System.out.println();
		}
	}

	/*
	 * public void mostrarTableroActualizado(int x, int y) {
	 * 
	 * for (int i = 0; i < matriz.length; i++) { for (int j = 0; j <
	 * matriz[i].length; j++) { if (j==x && i==y) System.out.print('X' + " "); else
	 * System.out.print('O' + " "); } System.out.println(); } }
	 */

	public void introducirCelda() throws IOException {
		boolean repetido=false;
		System.out.println("Introduzca fila [0-7]");
		do {
			fila = amadeus.controlaIntPositivo();
		} while (fila > 7);

		System.out.println("Introduzca columna [0-7]");
		do {
			columna = amadeus.controlaIntPositivo();
		} while (columna > 7);

		String celda = Integer.toString(fila) + Integer.toString(columna);
		if(!celdas.contains(celda)) {
			celdas.add(celda);
		}else
			repetido=true;
		//CONTROLAR AHORA LA REPETICIÓN
		if (barcos.contains(celda) && !repetido) {
			nBarcosActuales--;
			System.out.println("¡Tocado!");
		}
		mostrarTablero();
	}

	public void iniciarBarcos() {
		do {
			int aux1 = random.nextInt(8);
			int aux2= random.nextInt(8);
			String auxString = Integer.toString(aux1)+Integer.toString(aux2);
			if (!barcos.contains(auxString)) {
				barcos.add(auxString);
				nBarcosActuales++;
			}
		} while (nBarcosActuales < 8);
	}
	
	public void Jugar() throws IOException {
		iniciarBarcos();
		iniciarTablero();
		do {
			introducirCelda();
			System.out.println("Quedan "+nBarcosActuales+" barcos");
		}while(nBarcosActuales>0);
		System.out.println("¡Has ganado!");
	}

}
