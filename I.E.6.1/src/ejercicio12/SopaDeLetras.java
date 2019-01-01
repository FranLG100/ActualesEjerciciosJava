package ejercicio12;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import utilesFran.Amadeus;

public class SopaDeLetras {

	Amadeus amadeus=new Amadeus();
	ArrayList<String> palabras=new ArrayList<String>();
	char[] abecedario= {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
	char[][] matriz=new char[15][15];
	Random random=new Random();
	boolean valido=false;
	
	public void jugarSopaDeLetras() throws IOException {
		inicializadorPalabras();
		inicializadorMatriz();
		imprimeSopaDeLetras();
	}
	
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
	public void inicializadorMatriz() {
		
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				matriz[i][j]=' ';
			}
		}
	}
	
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
