package ejercicio12;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import utilesFran.Amadeus;

public class SopaDeLetras {

	Amadeus amadeus=new Amadeus();
	ArrayList<String> palabras=new ArrayList<String>(); //Lista de palabras que aparecerán en la sopa de letras
	//Abecedario. No contiene la Ñ (Una pequeña trampa que me ayuda a encontrar palabras).
	char[] abecedario= {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
	char[][] matriz=new char[15][15]; //Tablero de juego
	Random random=new Random(); //Generador de números aleatorios
	boolean valido=false; //Variable que permite que algunos métodos continuen con sus procedimientos. O no.
	
	
	/**
	 * Método público que inicia el juego de la Sopa de Letras
	 * */
	public void jugarSopaDeLetras() throws IOException {
		inicializadorPalabras();
		inicializadorMatriz();
		imprimeSopaDeLetras();
	}
	
	
	/**
	 * Método público que pide al usuario que introduzca diez palabras a esconder
	 * en la sopa de letras. Palabras de al menos 3 letras, y menos de 15.
	 * Las pasará a mayúsculas.
	 * */
	public void inicializadorPalabras() throws IOException {
		String aux;
		for (int i = 0; i < 10; i++) {	
			do {
			System.out.println("Introduzca la palabra "+(i+1)+" de 10 [3-15 caracteres]");
			aux=amadeus.recibeTexto();
			}while(aux.length()>15||aux.length()<3);
			aux=aux.toUpperCase();
			palabras.add(aux);
		}
	}
	
	/**
	 * Método público que inicia la matriz de juego, con caracteres en blanco.
	 * */
	public void inicializadorMatriz() {
		
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				matriz[i][j]=' ';
			}
		}
	}
	
	/**
	 * Método público que imprime la Sopa de Letras. Si la matriz tiene un espacio en blanco,
	 * coloca un caracter aleatorio en mayúsculas de la lista Abecedario. Si no, coloca
	 * la letra de la palabra correspondiente.
	 * */
	public void imprimeSopaDeLetras() {
		escondePalabras();
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				if(Character.isWhitespace(matriz[i][j]))
					System.out.print(abecedario[random.nextInt(abecedario.length)]+" ");
				else
					System.out.print(matriz[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	
	/**
	 * Método público que esconde las palabras en la sopa de letras.
	 * Las esconderá con orientaciones aleatorias (horizontal, vertical o diagonal)
	 * */
	public void escondePalabras() {
		int opcion;
		int posX;
		int posY;
		for (int i = 0; i < palabras.size(); i++) {
			valido = false;
			while (!valido) {
				opcion = random.nextInt(3);
				posX = random.nextInt(15);
				posY = random.nextInt(15);
				switch (opcion) {
				case 0:
					enVertical(posX, posY, i);
					break;
				case 1:
					enHorizontal(posX, posY, i);
					break;
				default:
					enDiagonal(posX, posY, i);
					break;
				}
			}
		}
	}
	
	/**
	 * Coloca la palabra en vertical, si hay espacio suficiente para colocarla.
	 * @param i Fila del caracter.
	 * @param j Columna del caracter.
	 * @param k Índice de la lista de palabras. Para saber qué palabra toca colocar.
	 * */
	public void enVertical(int i, int j, int k) {
		char[] auxChar = palabras.get(k).toCharArray();
		int aux = 14 - i;
		if (aux >= palabras.get(k).length()) {
			for (int l = 0; l < auxChar.length; l++) {
				if (!Character.isWhitespace(matriz[i + l][j])) {
					valido = false;
					break;
				} else {
					valido = true;
				}
			}
		}else
			valido=false;
		if (valido) {
			for (int l = 0; l < auxChar.length; l++) {
				matriz[i + l][j] = auxChar[l];
			}
		}
	}
	
	public void enHorizontal(int i, int j, int k) {
		char[] auxChar = palabras.get(k).toCharArray();
		int aux = 14 - j;
		if (aux >= palabras.get(k).length()) {
			for (int l = 0; l < auxChar.length; l++) {
				if (!Character.isWhitespace(matriz[i][j+l])) {
					valido = false;
					break;
				} else {
					valido = true;
				}
			}
		}else
			valido=false;
		if (valido) {
			for (int l = 0; l < auxChar.length; l++) {
				matriz[i][j+l] = auxChar[l];
			}
		}
	}
	
	public void enDiagonal(int i, int j, int k) {
		char[] auxChar = palabras.get(k).toCharArray();
		int auxX = 14 - i;
		int auxY = 14-j;
		if ((auxX >= palabras.get(k).length())&&(auxY>=palabras.get(k).length())) {
			for (int l = 0; l < auxChar.length; l++) {
				if (!Character.isWhitespace(matriz[i+l][j+l])) {
					valido = false;
					break;
				} else {
					valido = true;
				}
			}
			
		}else
			valido=false;
		if (valido) {
			for (int l = 0; l < auxChar.length; l++) {
				matriz[i+l][j+l] = auxChar[l];
			}
		}
	}
}
