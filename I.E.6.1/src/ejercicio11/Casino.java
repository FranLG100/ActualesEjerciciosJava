package ejercicio11;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import utilesFran.Amadeus;

public class Casino {

	Amadeus amadeus=new Amadeus();
	//Random. Para generar los números del bingo.
	Random random=new Random();
	//Lista de números. Nuestros números. Servirán para generar el cartón.
	ArrayList<Integer> misNumeros=new ArrayList<Integer>();
	//Números de la primera línea del cartón
	ArrayList<Integer> primeraLinea=new ArrayList<Integer>();
	//Números de la segunda línea del cartón
	ArrayList<Integer> segundaLinea=new ArrayList<Integer>();
	//Números de la tercera línea del cartón
	ArrayList<Integer> terceraLinea=new ArrayList<Integer>();
	//Números que han salido del bombo
	ArrayList<Integer> numerosQueHanSalido=new ArrayList<Integer>();
	//Variable con múltiples usos auxiliares
	int aux=0;
	//Variable útil para utilizar en el menú
	int opcion=0;
	//Cartón del bingo. El tamaño será luego especificado.
	int[][] carton;
	//Sabremos si ha salido línea o no
	boolean linea=false;
	//Para definir si la partida ha terminado o no.
	boolean victoria=false;
	
	/**
	 * Método que inicia el juego del Bingo.
	 * */
	public void jugarBingo() throws IOException {
		System.out.println("¡Bienvenido! En breve comenzará la partida del Bingo.");
		System.out.println("Este será su cartón\n");
		this.carton=comprarCarton(); //Al principio, generamos un cartón para el jugador.
		System.out.println("\nAhora, ¡Procedamos a jugar!");
		do {
			//Le damos la opción a sacar una bola, comprobar qué números han salido, y comprobar el cartón propio
			System.out.println("Seleccione una opción");
			System.out.println("1.-Sacar bola del bombo");
			System.out.println("2.-Comprobar números que han salido");
			System.out.println("3.-Comprobar mi cartón");
			opcion=amadeus.controlaIntMinMax(1, 3);
			switch (opcion) {
			case 1:
				sacarBola();
				comprobarLineas();
				break;
			case 2:
				imprimirNumerosQueHanSalido();
				break;

			default:
				imprimeCarton(carton);
				break;
			}
		}while(!victoria);
		System.out.println("¡ENHORABUENA! ¡Has Ganado!");
	}
	
	
	/**
	 * Método público que permite generar un cartón de bingo. 15 Números 
	 * en total. Genera 15 números aleatorios sin repetir que formarán parte de nuestro
	 * cartón. Los números se ordenarán de menor a mayor por columnas.
	 * @return carton Array de números que jugamos en esa ronda de Bingo.
	 * */
	public int[][] comprarCarton() {
		int[][] carton = new int[3][5];
		//Hasta que tengamos 15 números sin repetir, se irán generando números aleatorios
			do {
				aux = random.nextInt(100);
				if (!misNumeros.contains(aux))
					misNumeros.add(aux);
			} while (misNumeros.size() < 15);
		Collections.sort(misNumeros);
		//Quiero ordenar el cartón como se ordena en el bingo.
		//Por columnas.
		aux=0;
		int j=0;
		while (j < carton[0].length) {
			for (int i = 0; i < carton.length; i++) {
				carton[i][j] = misNumeros.get(aux);
				aux++;
			}
			j++;
		}

		//Tras ordenarlo, imprimimos el cartón con el método imprimeCartón
		imprimeCarton(carton);
		
		//Por último, llenamos la primera segunda y tercera línea con sus números correspondientes.
		//Para saber si en algún momento hemos cantado línea.
		for (int i = 0; i < carton.length; i++) {
			for (int k = 0; k < carton[i].length; k++) {
				if(i==0)
					primeraLinea.add(carton[i][k]);
				else if(i==1)
					segundaLinea.add(carton[i][k]);
				else
					terceraLinea.add(carton[i][k]);
			}
		}
		return carton;

	}
	
	/**
	 * Método público para sacar una bola del bombo del Bingo.
	 * No puede sacar una bola que ya haya salido.
	 * */
	public void sacarBola() {
		boolean valido = false;
		//Evita la repetición de números
		do {
			aux = random.nextInt(100);
			if (!numerosQueHanSalido.contains(aux)) {
				numerosQueHanSalido.add(aux); //Lo añadimos a los números que han salido.
				valido = true;
			}
		} while (!valido);
		valido = false; //Vuelve a poner la variable en falso para otros métodos.
		Collections.sort(numerosQueHanSalido);
		System.out.println("EL " + aux);
	}
	
	
	/**
	 * Imprimimos los números que han salido del bombo.
	 * */
	public void imprimirNumerosQueHanSalido() {
		System.out.println(numerosQueHanSalido.toString());
	}
	
	/**
	 * Comprobamos las líneas. En el momento en el que se canta una, no se vuelve a cantar.
	 * 
	 * */
	public void comprobarLineas() {
		if (!linea) {
			if ((numerosQueHanSalido.containsAll(primeraLinea) || numerosQueHanSalido.containsAll(segundaLinea)
					|| numerosQueHanSalido.containsAll(terceraLinea))) {
				System.out.println("¡HAN CANTADO LÍNEA");
				linea = true;
			}
		}
		if (numerosQueHanSalido.containsAll(misNumeros)) {
			victoria=true;
		}

	}
	
	/**
	 * Método público que imprime nuestro cartón de números, tachando los que ya tenemos.
	 * @param carton Nuestro cartón de números.
	 * */
	public void imprimeCarton(int[][] carton) {
		for (int i = 0; i < carton.length; i++) {
			for (int j = 0; j < carton[i].length; j++) {
				if(numerosQueHanSalido.contains(carton[i][j]))
					System.out.print("** ");
				else
					System.out.print(carton[i][j]+" ");
			}
			System.out.println();
		}
	}
}
