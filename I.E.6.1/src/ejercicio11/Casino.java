package ejercicio11;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import utilesFran.Amadeus;

public class Casino {

	Amadeus amadeus=new Amadeus();
	Random random=new Random();
	ArrayList<Integer> misNumeros=new ArrayList<Integer>();
	ArrayList<Integer> primeraLinea=new ArrayList<Integer>();
	ArrayList<Integer> segundaLinea=new ArrayList<Integer>();
	ArrayList<Integer> terceraLinea=new ArrayList<Integer>();
	ArrayList<Integer> numerosQueHanSalido=new ArrayList<Integer>();
	int aux=0;
	int opcion=0;
	int[][] carton;
	boolean linea=false;
	boolean victoria=false;
	
	public void jugarBingo() throws IOException {
		System.out.println("¡Bienvenido! En breve comenzará la partida del Bingo.");
		System.out.println("Este será su cartón\n");
		this.carton=comprarCarton();
		System.out.println("\nAhora, ¡Procedamos a jugar!");
		do {
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
	
	public int[][] comprarCarton() {
		int[][] carton = new int[3][5];
		//for (int i = 0; i < 15; i++) {
			do {
				aux = random.nextInt(100);
				if (!misNumeros.contains(aux))
					misNumeros.add(aux);
			} while (misNumeros.size() < 15);
		//}
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
		/*for (int i = 0; i < carton.length; i++) {
			for (int j = 0; j < carton[i].length; j++) {
				carton[i][j]=misNumeros.get(aux);
				aux++;
			}
		}*/
		imprimeCarton(carton);
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
	
	public void sacarBola() {
		boolean valido = false;
		do {
			aux = random.nextInt(100);
			if (!numerosQueHanSalido.contains(aux)) {
				numerosQueHanSalido.add(aux);
				valido = true;
			}
		} while (!valido);
		valido = false;
		Collections.sort(numerosQueHanSalido);
		System.out.println("EL " + aux);
	}
	
	public void imprimirNumerosQueHanSalido() {
		System.out.println(numerosQueHanSalido.toString());
	}
	
	public void comprobarLineas() {
		if (!linea) {
			if ((numerosQueHanSalido.containsAll(primeraLinea) || numerosQueHanSalido.containsAll(segundaLinea)
					|| numerosQueHanSalido.containsAll(terceraLinea))) {
				System.out.println("¡HAN CANTADO LÍNEA");
				linea = true;
			}
		}
		if ((numerosQueHanSalido.containsAll(primeraLinea) && numerosQueHanSalido.containsAll(segundaLinea)
				&& numerosQueHanSalido.containsAll(terceraLinea))) {
			victoria=true;
		}

	}
	
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
