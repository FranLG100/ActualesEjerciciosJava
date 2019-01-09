package ejercicio10B;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import utilesFran.Amadeus;

public class Tablero {

	Amadeus amadeus = new Amadeus();
	String[][] matriz = new String[8][8]; //Este será nuestro tablero
	ArrayList<String> celdas = new ArrayList<String>(); //Celdas que hemos introducido
	ArrayList<String> barcos = new ArrayList<String>(); //Celdas en las que se encuentra un barco
	int fila = 0; //Fila
	int columna = 0; //Columna
	int nBarcos = 8; //Número de barcos que queremos colocar
	int nBarcosActuales = 0; //Número de barcos colocados
	boolean valido=false; //Auxiliar que nos indicará si el programa continua realizando una tarea o no
	Random random = new Random(); //Generador de números aleatorios

	/**
	 * Método público que sirve para generar el tablero inicial. Cada casilla es un String
	 * que muestra la fila y la columna ("00", "01", "02", etc.)
	 * */
	public void iniciarTablero() {

		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				matriz[i][j] = Integer.toString(i) + Integer.toString(j);
				//System.out.print(matriz[i][j] + " ");
			}
			//System.out.println();
		}
	}

	/**
	 * Método público que sirve para mostrar el tablero. Si hemos fallado, se mostrará 
	 * una 'X'. Si hemos acertado, un '*'. Si no hemos tocado esa casilla, se mostrará
	 * una 'O'.
	 * */
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

	/**
	 * Método público para que el jugador introduzca una celda del tablero.
	 * Introduce una fila y una columna, que se pasará a String y se comparará con la 
	 * lista de barcos. Se controlará que no se introduzcan celdas repetidas.
	 * Se muestra el tablero tras introducir una celda.
	 * */
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
			//nBarcosActuales--;
			System.out.println("¡Tocado!");
		}
		mostrarTablero();
	}

	/**
	 * Método público para inicializar los barcos de una casilla.
	 * Se controla para que no se puedan introducir dos barcos en la misma casilla.
	 * */
	public void iniciarBarcosPequenhos() {
		do {
			int aux1 = random.nextInt(8);
			int aux2= random.nextInt(8);
			String auxString = Integer.toString(aux1)+Integer.toString(aux2);
			if (!barcos.contains(auxString)) {
				barcos.add(auxString);
				nBarcosActuales++;
			}
		} while (nBarcosActuales < 4);
	}
	
	/**
	 * Método público para inicializar los barcos de dos casillas.
	 * Se controla para que no se puedan introducir dos barcos en la misma casilla.
	 * */
	public void iniciarBarcosMedianos() {
		do {
			while(!valido) {
			int aux1 = random.nextInt(8);
			int aux2= random.nextInt(8);
			int opcion=random.nextInt(2);
			String auxString = Integer.toString(aux1)+Integer.toString(aux2);
			if(opcion==1)
				colocarEnVertical(aux1, aux2, auxString,2);
			else
				colocarEnVertical(aux1, aux2, auxString,2);
			}
			//String auxString = Integer.toString(aux1)+Integer.toString(aux2);

				nBarcosActuales++;
				valido=false;
		} while (nBarcosActuales < 7);
	}
	
	/**
	 * Método público para inicializar el barco de tres casillas.
	 * */
	public void iniciarBarcosGrandes() {
		do {
			while(!valido) {
			int aux1 = random.nextInt(8);
			int aux2= random.nextInt(8);
			int opcion=random.nextInt(2);
			String auxString = Integer.toString(aux1)+Integer.toString(aux2);
			if(opcion==1)
				colocarEnVertical(aux1, aux2, auxString,3);
			else
				colocarEnVertical(aux1, aux2, auxString,3);
			}
			//String auxString = Integer.toString(aux1)+Integer.toString(aux2);

				nBarcosActuales++;
				valido=false;
		} while (nBarcosActuales < 8);
	}
	
	/**
	 * Método público para colocar los barcos de más de una casilla
	 * en posición vertical.
	 * @param posA Fila de la primera casilla del barco
	 * @param posB Columna de la primera casilla del barco
	 * @param casilla Casilla del primer fragmento del barco
	 * @param longitud Longitud del barco a colocar.
	 * */
	public void colocarEnVertical(int posA, int posB, String casilla, int longitud) {
		int cont = 0;
		ArrayList<String> memoria=new ArrayList<String>(); //Aquí guardaremos las casillas del barco.
		memoria.add(casilla); //Añadimos la casilla inicial
		String auxString = null; //Un String que funcionará como auxiliar
		if (((7 - posA) >= longitud) && !barcos.contains(casilla)) { //Si el barco no sobrepasa la matriz, continuamos
			while (cont < longitud-1) { //Hasta que lleguemos a la longitud, realizamos el paso (restamos uno porque descontamos la primera casilla)
				posA++; //Bajamos una columna
				auxString = Integer.toString(posA) + Integer.toString(posB); //Convertimos a casilla
				if (!barcos.contains(auxString)) { //Si la casilla no está ocupada, la metemos en la memoria
					memoria.add(auxString);
					valido=true;
				}else { //Si está ocupada y no podemos continuar, invalidamos el proceso y limpiamos la memoria
					valido=false;
					memoria.clear();
					break;
				}
				cont++; //Sumamos uno al fragmento del barco
			}
			if(valido) {//Si todo está en orden
				barcos.addAll(memoria); //Añadimos todas las casillas de la memoria a la lista de barcos
				memoria.clear(); //Y la limpiamos para posteriores procesos
			}
			
		}
		
	}
	
	/**
	 * Método público para colocar los barcos de más de una casilla
	 * en posición horizontal.
	 * @param posA Fila de la primera casilla del barco
	 * @param posB Columna de la primera casilla del barco
	 * @param casilla Casilla del primer fragmento del barco
	 * @param longitud Longitud del barco a colocar.
	 * */
	public void colocarEnHorizontal(int posA, int posB, String casilla, int longitud) {
		int cont = 0;
		ArrayList<String> memoria=new ArrayList<String>();
		memoria.add(casilla);
		String auxString = null;
		if (((7 - posB) >= longitud) && !barcos.contains(casilla)) {
			while (cont < longitud-1) {
				posB++; //Todo igual al proceso anterior, pero recorremos uno a la derecha
				auxString = Integer.toString(posA) + Integer.toString(posB);
				if (!barcos.contains(auxString)) {
					memoria.add(auxString);
					valido=true;
				}else {
					valido=false;
					memoria.clear();
					break;
				}
				cont++;
			}
			if(valido) {
				barcos.addAll(memoria);
				memoria.clear();
			}
			
		}
		
	}
	
	/**
	 * Método público para iniciar el juego de los barquitos
	 * */
	public void Jugar() throws IOException {
		iniciarBarcosPequenhos(); //Inicializa los barcos pequenhos
		iniciarBarcosMedianos(); //Inicializa los barcos medianos
		iniciarBarcosGrandes(); //Inicializa los barcos graneds
		iniciarTablero(); //Inicializa el tablero
		do {
			introducirCelda();
			//System.out.println("Quedan "+nBarcosActuales+" barcos");
		}while(!celdas.containsAll(barcos)); //Comprueba si las celdas que hemos introducido contienen las casillas de los barcos.
		System.out.println("¡Has ganado!");
	}

}
