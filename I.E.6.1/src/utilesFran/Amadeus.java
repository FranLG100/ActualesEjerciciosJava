package utilesFran;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;

/**
 * Clase de utilidades (control de variables, aplicación de try catch, ...)
 * de uso personal
 * @author Francisco Antonio Lorente Girol
 * @version 1.0
 * */

public class Amadeus {

	BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
	boolean error = false;
	Random random=new Random();

	/**
	 * Método que aplica solicita la introducción de un dato tipo Integer
	 * y aplica los try catch necesarios durante el proceso.
	 * @return Número entero controlado
	 * */
	public int controlaInt() throws IOException {
		int entero = 0;
		do {
			try {
				entero = Integer.parseInt(entrada.readLine());
				error = false;
			} catch (NumberFormatException e) {
				// TODO: handle exception
				System.out.println("Valor no válido");
				error = true;
			}
		} while (error);
		return entero;
	}

	/**
	 * Método que aplica solicita la introducción de un dato tipo Integer
	 * y aplica los try catch necesarios durante el proceso.
	 * @return Número entero controlado positivo (incluyendo el 0)
	 * */
	public int controlaIntPositivo() throws IOException {
		int entero = 0;
		do {
			try {
				entero = Integer.parseInt(entrada.readLine());
				error = false;
				if (entero < 0)
					System.out.println("Introduzca un valor positivo");
			} catch (NumberFormatException e) {
				// TODO: handle exception
				System.out.println("Valor no válido");
				error = true;
			}
		} while (error || entero < 0);
		return entero;
	}
	
	
	/**
	 * Método que aplica solicita la introducción de un dato tipo Integer
	 * y aplica los try catch necesarios durante el proceso, entre un Mínimo
	 * y un Máximo
	 * @param min Rango mínimo del entero a introducir
	 * @param max Rango máximo del entero a introducir
	 * @return Número entero controlado
	 * */
	public int controlaIntMinMax(int min, int max) throws IOException {
		int aux=0;
		if(min>max) {
			aux=max;
			max=min;
			min=aux;
		}
		int entero = 0;
		do {
			try {
				entero = Integer.parseInt(entrada.readLine());
				error = false;
				if (entero<min || entero>max)
					System.out.println("Introduzca un valor entre "+min+" y "+max);
			} catch (NumberFormatException e) {
				// TODO: handle exception
				System.out.println("Valor no válido");
				error = true;
			}
		} while (error || entero<min || entero>max);
		return entero;
	}

	/**
	 * Método que aplica solicita la introducción de un dato tipo Integer
	 * y aplica los try catch necesarios durante el proceso.
	 * @return Número entero controlado entre 0 y 100
	 * */
	public int controlaIntPorcentaje() throws IOException {
		int entero = 0;
		do {
			try {
				entero = Integer.parseInt(entrada.readLine());
				error = false;
				if (entero < 0)
					System.out.println("Introduzca un valor mayor a 0");
				if (entero > 100)
					System.out.println("Introduzca un valor menor a 100");
			} catch (NumberFormatException e) {
				// TODO: handle exception
				System.out.println("Valor no válido");
				error = true;
			}
		} while (error || entero < 0 || entero > 100);
		return entero;
	}

	/**
	 * Método que aplica solicita la introducción de un dato tipo Double
	 * y aplica los try catch necesarios durante el proceso.
	 * @return Número del tipo double controlado
	 * */
	public double controlaDouble() throws IOException {
		double entero = 0;
		do {
			try {
				entero = Double.parseDouble(entrada.readLine());
				error = false;
			} catch (NumberFormatException e) {
				// TODO: handle exception
				System.out.println("Valor no válido, vuelva a introducirlo");
				error = true;
			}
		} while (error);
		return entero;
	}

	/**
	 * Método que aplica solicita la introducción de un dato tipo Double
	 * y aplica los try catch necesarios durante el proceso.
	 * @return Número del tipo double positivo (incluyendo 0)
	 * */
	public double controlaDoublePositivo() throws IOException {
		double entero = 0;
		do {
			try {
				entero = Double.parseDouble(entrada.readLine());
				error = false;
				if (entero < 0)
					System.out.println("Introduzca un valor positivo");
			} catch (NumberFormatException e) {
				// TODO: handle exception
				System.out.println("Valor no válido, vuelva a introducirlo");
				error = true;
			}
		} while (error || entero < 0);
		return entero;
	}

	/**
	 * Método que aplica solicita la introducción de un dato tipo Double
	 * y aplica los try catch necesarios durante el proceso.
	 * @return Número del tipo double controlado entre 0 y 100
	 * */
	public double controlaDoublePorcentaje() throws IOException {
		double entero = 0;
		do {
			try {
				entero = Double.parseDouble(entrada.readLine());
				error = false;
				if (entero < 0)
					System.out.println("Introduzca un valor mayor a 0");
				if (entero > 100)
					System.out.println("Introduzca un valor menor a 100");
			} catch (NumberFormatException e) {
				// TODO: handle exception
				System.out.println("Valor no válido");
				error = true;
			}
		} while (error || entero < 0 || entero > 100);
		return entero;
	}

	/**
	 * Método que aplica solicita la introducción de un dato tipo Float
	 * y aplica los try catch necesarios durante el proceso.
	 * @return Número del tipo float controlado
	 * */
	public float controlaFloat() throws IOException {
		float entero = 0;
		do {
			try {
				entero = Float.parseFloat(entrada.readLine());
				error = false;
			} catch (NumberFormatException e) {
				// TODO: handle exception
				System.out.println("Valor no válido, vuelva a introducirlo");
				error = true;
			}
		} while (error);
		return entero;
	}

	/**
	 * Método que aplica solicita la introducción de un dato tipo Float
	 * y aplica los try catch necesarios durante el proceso.
	 * @return Número del tipo float positivo (incluye el 0)
	 * */
	public float controlaFloatPositivo() throws IOException {
		float entero = 0;
		do {
			try {
				entero = Float.parseFloat(entrada.readLine());
				error = false;
				if (entero < 0)
					System.out.println("Introduzca un valor positivo");
			} catch (NumberFormatException e) {
				// TODO: handle exception
				System.out.println("Valor no válido, vuelva a introducirlo");
				error = true;
			}
		} while (error || entero < 0);
		return entero;
	}

	/**
	 * Método que aplica solicita la introducción de una cadena de caracteres por teclado.
	 * El método comprueba si se ha escrito 's', 'sí', 'si', 'yes','y', 'no','n'
	 * @return <ul>
	 * <li>true Si se ha escrito 's', 'sí', 'si', 'yes','y'
	 * <li>false Si se ha escrito 'n', 'no'
	 * </ul>
	 * */
	public boolean afirmaODesmiente() throws IOException {
		String respuesta;
		do {
			respuesta = entrada.readLine();
			error = false;
			if (respuesta.equalsIgnoreCase("si") || respuesta.equalsIgnoreCase("y") || respuesta.equalsIgnoreCase("sí")
					|| respuesta.equalsIgnoreCase("s") || respuesta.equalsIgnoreCase("yes"))
				return true;
			else if (respuesta.equalsIgnoreCase("no") || respuesta.equalsIgnoreCase("n"))
				return false;
			else {
				error = true;
				System.out.println("Valor no válido, introduzca si o no");
			}
		} while (error);
		return false;
	}

	/**
	 * Solicita por consola la entrada por teclado de una cadena de caracteres.
	 * Comprueba que dicha cadena no esté vacía o que no sean todos espacios en blanco.
	 * @return Cadena de caracteres válida
	 * */
	public String recibeTexto() throws IOException {
		String respuesta;
		boolean vacio = true;
		char c;
		do {
			respuesta = entrada.readLine();
			for (int i = 0; i < respuesta.length(); i++) {
				c = respuesta.charAt(i);
				if (!Character.isWhitespace(c)) {
					vacio = false;
					break;
				}
			}
			if (vacio)
				System.out.println("El texto no debe estar vacío, introduzca datos");
		} while (vacio);
		return respuesta;
	}
	
	/**
	 * Comprueba que una cadena no esté vacía o que no sean todos espacios en blanco.
	 * @param s Cadena de caracteres a comprobar
	 * @return Cadena de caracteres válida
	 * */
	public String compruebaTexto(String s) throws IOException {
		String respuesta=s;
		boolean vacio = true;
		char c;
		do {
			for (int i = 0; i < respuesta.length(); i++) {
				c = respuesta.charAt(i);
				if (!Character.isWhitespace(c)) {
					vacio = false;
					break;
				}
			}
			if (vacio) {
				System.out.println("El texto no debe estar vacío, introduzca datos");
				respuesta = entrada.readLine();
			}
		} while (vacio);
		return respuesta;
	}
	
	/**
	 * Método que comprueba que el DNI tenga el formato adecuado de 8 dígitos y una letra al final
	 * @param s DNI a comprobar
	 * @return DNI validado
	 * */
	public String compruebaNIF(String s) throws IOException {
		String respuesta=s;
		boolean error = false;
		char c;
		
		do {
			error=false;
			while(respuesta.length()!=9) {
				System.out.println("Longitud del DNI incorrecta, vuelva a introducirlo");
				respuesta=recibeTexto();
			}
			for (int i = 0; i < 8; i++) {
				c = respuesta.charAt(i);
				if (!Character.isDigit(c)) {
					error = true;
					break;
				}
			}
			if(!Character.isAlphabetic(respuesta.charAt(8)))
				error=true;
			if (error) {
				System.out.println("DNI no válido. Vuélvalo a introducir");
				respuesta = entrada.readLine();
			}
		} while (error);
		return respuesta;
	}
	
	/*/////////////////////////////////////////////////////////////////////*/
	/*/ARRAYS//////////////////////////////////////////////////////////////*/
	/*/////////////////////////////////////////////////////////////////////*/
	
	/**
	 * Método que llena un array ya existente con valores aleatorios
	 * @param array Array que deseamos rellenar
	 * @param maxVal Valor máximo de los números aleatorios generados que llenarán el array
	 * @return El método devolverá el array que metimos como parámetro de entrada ya relleno
	 * */
	public int[] rellenaArray(int[] array, int maxVal) {
		int val;
		for (int i = 0; i < array.length; i++) {
			val=random.nextInt(maxVal)+1;
			array[i]=val;
		}
		return array;
		
	}
	
	/**
	 * Método que crea un array ya lleno con valores aleatorios
	 * @param tamanho Tamaño del Array que deseamos crear
	 * @param maxVal Valor máximo de los números aleatorios generados que llenarán el array
	 * @return El método devolverá un array de tamaño 'tamanho' ya lleno
	 * */
	public int[] creaArrayLleno(int tamanho,int maxVal) {
		int[] array=new int[tamanho];
		return rellenaArray(array,maxVal);
		
	}
	
	/**
	 * Método que imprime los valores de un array
	 * @param array Array que deseamos imprimir
	 * */
	public void imprimeArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]+" ");
		}
	}
	
	/**
	 * Método que suma los valores de dos arrays
	 * @param a Primer array que deseamos sumar
	 * @param b Segundo array que deseamos sumar
	 * @return El método devolverá un array con la suma de los arrays anteriores
	 * */
	public int[] sumaArray(int[]a, int[]b) {
		int capacidad=a.length;
		int[] suma=new int[capacidad];
		for (int i = 0; i < suma.length; i++) {
			suma[i]=a[i]+b[i];
		}
		return suma;
	}
	
	/**
	 * Método que ordena de menor a mayor un Array
	 * @param array Array que deseamos ordenar
	 * @return Array ya ordenado
	 * */
	public int[] ordenaArrayMenorMayor(int[] array) {
		Arrays.sort(array);
		return array;
	}
	
	/**
	 * Método que ordena de mayor a menor un Array
	 * @param array Array que deseamos ordenar
	 * @return Array ya ordenado
	 * */
	public int[] ordenaArrayMayorMenor(int[] array) {
		Arrays.sort(array);
		array=invierteArray(array);
		return array;
	}
	
	/**
	 * Método que invierte el orden de un array
	 * @param array Array que deseamos invertir
	 * @return Array ya invertido
	 * */
	public int[] invierteArray(int[] array) {
		int[] inversion=new int[array.length];
		for (int i = 0; i < array.length; i++) {
			inversion[i]=array[array.length-1-i];
		}
		return inversion;
	}
	
	/**
	 * Método que ordena de menor a mayor un array mediante el método de la Burbuja.
	 * @param array Array que deseamos ordenar
	 * @return Array ya ordenado
	 * */
	public int[] ordenacionAscendenteBurbujaArray(int[] array) {
		int aux;
		int mayor = array[0];
		boolean comprueba = true;
		while (comprueba) {
			comprueba = false;
			for (int j = 0; j < array.length - 1; j++) {
				if (array[j] > array[j + 1]) {
					aux = array[j + 1];
					array[j + 1] = array[j];
					array[j] = aux;
					comprueba = true;
				}
			}
		}
		return array;
	}
	
	/**
	 * Método que ordena de mayor a menor un array mediante el método de la Burbuja.
	 * @param array Array que deseamos ordenar
	 * @return Array ya ordenado
	 * */
	public int[] ordenacionDescendenteBurbujaArray(int[] array) {
		int aux;
		int mayor = array[0];
		boolean comprueba = true;
		while (comprueba) {
			comprueba = false;
			for (int j = 0; j < array.length - 1; j++) {
				if (array[j] < array[j + 1]) {
					aux = array[j + 1];
					array[j + 1] = array[j];
					array[j] = aux;
					comprueba = true;
				}
			}
		}
		return array;
	}
	
	/**
	 * Método que ordena de menor a mayor un array mediante el método de Inserción Directa.
	 * @param array Array que deseamos ordenar
	 * @return Array ya ordenado
	 * */
	public int[] ordenacionDirectaAscendenteArray(int[] array) {
		int index=0;
		int aux=0;
		for (int i = 1; i < array.length; i++) {
			index=i;
			aux=array[i];
			while((index>0)&&(array[index-1]>aux)) {
				array[index]=array[index-1];
				index--;
			}
			array[index]=aux;
		}
		return array;
	}
	
	
	/**
	 * Método que ordena de mayor a menor un array mediante el método de Inserción Directa.
	 * @param array Array que deseamos ordenar
	 * @return Array ya ordenado
	 * */
	public int[] ordenacionDirectaDescendenteArray(int[] array) {
		int index=0;
		int aux=0;
		for (int i = 1; i < array.length; i++) {
			index=i;
			aux=array[i];
			while((index>0)&&(array[index-1]<aux)) {
				array[index]=array[index-1];
				index--;
			}
			array[index]=aux;
		}
		return array;
	}
	
	/*/////////////////////////////////////////////////////////////////////*/
	/*/MATRICES////////////////////////////////////////////////////////////*/
	/*/////////////////////////////////////////////////////////////////////*/
	
	
	/**
	 * Método que llena una matriz ya existente con valores aleatorios
	 * @param matriz Matriz que deseamos rellenar
	 * @param maxVal Valor máximo de los números aleatorios generados que llenarán la matriz
	 * @return El método devolverá la matriz que metimos como parámetro de entrada ya relleno
	 * */
	public int[][] rellenaMatriz(int[][] matriz, int maxVal) {
		int val;
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				val=random.nextInt(maxVal)+1;
				matriz[i][j]=val;
			}
		}
		return matriz;	
	}
	
	
	/**
	 * Método que crea una matriz ya llena con valores aleatorios
	 * @param tamanho Tamaño de la matriz que deseamos crear
	 * @param maxVal Valor máximo de los números aleatorios generados que llenarán la matriz
	 * @return El método devolverá una matriz de tamaño 'tamanho' ya lleno
	 * */
	public int[][] creaMatriz(int filas, int columnas, int maxVal) {
		int[][]matriz=new int[filas][columnas];
		return rellenaMatriz(matriz, maxVal);
	}
	
	
	/**
	 * Método que imprime los valores de una matriz
	 * @param matriz Matriz que deseamos imprimir
	 * */
	public void imprimeMatriz(int[][]matriz) {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				System.out.print(matriz[i][j]+" ");
			}
			System.out.println("");
		}
	}
	
	
	/**
	 * Método que suma los valores de dos matrices
	 * @param a Primera matriz que deseamos sumar
	 * @param b Segunda matriz que deseamos sumar
	 * @return El método devolverá una matriz con la suma de las dos matrices anteriores
	 * */
	public int[][] sumaMatriz(int[][]a, int[][]b) {
		int nFilas=a.length;
		int nColumnas=a[0].length;
		int[][] suma=new int[nFilas][nColumnas];
		for (int i = 0; i < suma.length; i++) {
			for (int j = 0; j < suma[i].length; j++) {
				suma[i][j]=a[i][j]+b[i][j];
			}
		}
		return suma;
	}
	
	/**
	 * Método que halla el mayor valor de una matriz
	 * @param matriz Matriz de la cual deseamos hallar el mayor valor
	 * @return Retorna el mayor valor de la matriz.
	 * */
	public int mayorEnLaMatriz(int[][] matriz) {
		int aux=matriz[0][0];
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				if(matriz[i][j]>aux)
					aux=matriz[i][j];
			}
		}
		return aux;
	}
	
	/**
	 * Método que halla las posiciones del mayor valor de una matriz
	 * @param matriz Matriz de la cual deseamos hallar las posiciones del mayor valor
	 * @return Retorna las posiciones del mayor valor de una matriz.
	 * */
	public void posicionesMayorEnLaMatriz(int[][] matriz) {
		int mayor=mayorEnLaMatriz(matriz);
		System.out.println("El mayor número se encuentra en la/s posición/es: ");
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				if(mayor==matriz[i][j])
					System.out.print("["+i+"]["+j+"]  ");
			}
		}
	}
	
	/**
	 * Método que halla el menor valor de una matriz
	 * @param matriz Matriz de la cual deseamos hallar el menor valor
	 * @return Retorna el menor valor de la matriz.
	 * */
	public int menorEnLaMatriz(int[][] matriz) {
		int aux=matriz[0][0];
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				if(matriz[i][j]<aux)
					aux=matriz[i][j];
			}
		}
		return aux;
	}
	
	
	/**
	 * Método que halla las posiciones del menor valor de una matriz
	 * @param matriz Matriz de la cual deseamos hallar las posiciones del menor valor
	 * @return Retorna las posiciones del menor valor de una matriz.
	 * */
	public void posicionesMenorEnLaMatriz(int[][] matriz) {
		int menor=menorEnLaMatriz(matriz);
		System.out.println("El menor número se encuentra en la/s posición/es: ");
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				if(menor==matriz[i][j])
					System.out.print("["+i+"]["+j+"]  ");
			}
		}
	}
	
	/**
	 * Método que halla el mayor valor de una fila.
	 * @param matriz Matriz de la cual deseamos sacar el valor
	 * @param fila Fila de la cual queremos sacar el mayor valor
	 * @return Mayor valor de la fila
	 * */
	public int mayorEnFila(int[][] matriz, int fila) {
		int aux=matriz[fila][0];
		for (int i = 0; i < matriz.length; i++) {
			if(matriz[fila][i]>aux)
				aux=matriz[fila][i];
		}
		return aux;
	}
	
	
	//DA EL NUMERO DE COLUMNA EN EL CUAL ESTÁ
	/**
	 * Método que halla las columnas del mayor valor de una fila.
	 * @param matriz Matriz de la cual deseamos sacar el valor
	 * @param fila Fila de la cual queremos sacar el mayor valor
	 * @return Columnas en las cuales se encuentra el mayor valor de la fila
	 * */
	public int[] posicionesMayorEnFila(int[][] matriz,int fila) {
		int aux=mayorEnFila(matriz,fila);
		int cont=0;
		int j=0;
		for (int i = 0; i < matriz.length; i++) {
			if(aux==matriz[fila][i])
				cont++;
		}
		int[] respuesta=new int[cont];
		
		for (int i = 0; i < matriz.length; i++) {
			if(aux==matriz[fila][i]) {
				respuesta[j]=i;
				j++;
			}
		}
		return respuesta;
	}
	
	/**
	 * Método que halla el mayor valor de una columna.
	 * @param matriz Matriz de la cual deseamos sacar el valor
	 * @param columna Columna de la cual queremos sacar el mayor valor
	 * @return Mayor valor de la columna
	 * */
	public int mayorEnColumna(int[][] matriz, int columna) {
		int aux=matriz[0][columna];
		for (int i = 0; i < matriz.length; i++) {
			if(matriz[i][columna]>aux)
				aux=matriz[i][columna];
		}
		return aux;
	}
	
	//DA EL NÚMERO DE FILA EN EL CUAL ESTÁ
	/**
	 * Método que halla las filas del mayor valor de una columna.
	 * @param matriz Matriz de la cual deseamos sacar el valor
	 * @param columna Columna de la cual queremos sacar el mayor valor
	 * @return Filas en las cuales se encuentra el mayor valor de la columna
	 * */
	public int[] posicionesMayorEnColumna(int[][] matriz,int columna) {
		int aux=mayorEnColumna(matriz,columna);
		int cont=0;
		int j=0;
		for (int i = 0; i < matriz.length; i++) {
			if(aux==matriz[i][columna])
				cont++;
		}
		int[] respuesta=new int[cont];
		
		for (int i = 0; i < matriz.length; i++) {
			if(aux==matriz[i][columna]) {
				respuesta[j]=i;
				j++;
			}
		}
		return respuesta;
	}
	
	/**
	 * Método que halla el menor valor de una fila.
	 * @param matriz Matriz de la cual deseamos sacar el valor
	 * @param fila Fila de la cual queremos sacar el menor valor
	 * @return Menor valor de la fila
	 * */
	public int menorEnFila(int[][] matriz, int fila) {
		int aux=matriz[fila][0];
		for (int i = 0; i < matriz.length; i++) {
			if(matriz[fila][i]<aux)
				aux=matriz[fila][i];
		}
		return aux;
	}
	
	/**
	 * Método que halla las columnas del menor valor de una fila.
	 * @param matriz Matriz de la cual deseamos sacar el valor
	 * @param fila Fila de la cual queremos sacar el menor valor
	 * @return Columnas en las cuales se encuentra el menor valor de la fila
	 * */
	public int[] posicionesMenorEnFila(int[][] matriz,int fila) {
		int aux=menorEnFila(matriz,fila);
		int cont=0;
		int j=0;
		for (int i = 0; i < matriz.length; i++) {
			if(aux==matriz[fila][i])
				cont++;
		}
		int[] respuesta=new int[cont];
		
		for (int i = 0; i < matriz.length; i++) {
			if(aux==matriz[fila][i]) {
				respuesta[j]=i;
				j++;
			}
		}
		return respuesta;
	}
	
	
	/**
	 * Método que halla el menor valor de una columna.
	 * @param matriz Matriz de la cual deseamos sacar el valor
	 * @param columna Columna de la cual queremos sacar el menor valor
	 * @return Menor valor de la columna
	 * */
	public int menorEnColumna(int[][] matriz, int columna) {
		int aux=matriz[0][columna];
		for (int i = 0; i < matriz.length; i++) {
			if(matriz[i][columna]<aux)
				aux=matriz[i][columna];
		}
		return aux;
	}
	
	
	/**
	 * Método que halla las filas del menor valor de una columna.
	 * @param matriz Matriz de la cual deseamos sacar el valor
	 * @param columna Columna de la cual queremos sacar el menor valor
	 * @return Filas en las cuales se encuentra el menor valor de la columna
	 * */
	public int[] posicionesMenorEnColumna(int[][] matriz,int columna) {
		int aux=menorEnColumna(matriz,columna);
		int cont=0;
		int j=0;
		for (int i = 0; i < matriz.length; i++) {
			if(aux==matriz[i][columna])
				cont++;
		}
		int[] respuesta=new int[cont];
		
		for (int i = 0; i < matriz.length; i++) {
			if(aux==matriz[i][columna]) {
				respuesta[j]=i;
				j++;
			}
		}
		return respuesta;
	}
	
	/**
	 * Método que ordena una fila específica de una matriz de menor a mayor
	 * @param matriz Matriz de la cual ordenaremos una fila
	 * @param fila Fila específica que deseamos ordenar
	 * @return Matriz con la fila ya ordenada
	 * */
	public int[][] ordenaFilaMatrizAscendente(int[][] matriz, int fila) throws IOException{
		if(fila>=matriz.length || fila<0) {
			System.out.println("Esa fila no existe, introduzca una nueva");
			fila=controlaIntMinMax(0,matriz.length-1);
		}
		int[] arrayAuxiliar=new int[matriz[0].length];
		for (int i = 0; i < arrayAuxiliar.length; i++) {
			arrayAuxiliar[i]=matriz[fila][i];
		}
		
		arrayAuxiliar=ordenacionDirectaAscendenteArray(arrayAuxiliar);
		
		for (int i = 0; i < arrayAuxiliar.length; i++) {
			matriz[fila][i]=arrayAuxiliar[i];
		}
		
		return matriz;
	}
	
	/**
	 * Método que ordena una fila específica de una matriz de mayor a menor
	 * @param matriz Matriz de la cual ordenaremos una fila
	 * @param fila Fila específica que deseamos ordenar
	 * @return Matriz con la fila ya ordenada
	 * */
	public int[][] ordenaFilaMatrizDescendente(int[][] matriz, int fila) throws IOException{
		if(fila>=matriz.length || fila<0) {
			System.out.println("Esa fila no existe, introduzca una nueva");
			fila=controlaIntMinMax(0,matriz.length-1);
		}
		int[] arrayAuxiliar=new int[matriz[0].length];
		for (int i = 0; i < arrayAuxiliar.length; i++) {
			arrayAuxiliar[i]=matriz[fila][i];
		}
		
		arrayAuxiliar=ordenacionDirectaDescendenteArray(arrayAuxiliar);
		
		for (int i = 0; i < arrayAuxiliar.length; i++) {
			matriz[fila][i]=arrayAuxiliar[i];
		}
		
		return matriz;
	}
	
	
	/**
	 * Método que ordena una columna específica de una matriz de menor a mayor
	 * @param matriz Matriz de la cual ordenaremos una columna
	 * @param columna Columna específica que deseamos ordenar
	 * @return Matriz con la columna ya ordenada
	 * */
	public int[][] ordenaColumnaMatrizAscendente(int[][] matriz, int columna) throws IOException{
		if(columna>=matriz[0].length || columna<0) {
			System.out.println("Esa fila no existe, introduzca una nueva");
			columna=controlaIntMinMax(0,matriz[0].length-1);
		}
		int[] arrayAuxiliar=new int[matriz.length];
		for (int i = 0; i < arrayAuxiliar.length; i++) {
			arrayAuxiliar[i]=matriz[i][columna];
		}
		
		arrayAuxiliar=ordenacionDirectaAscendenteArray(arrayAuxiliar);
		
		for (int i = 0; i < arrayAuxiliar.length; i++) {
			matriz[i][columna]=arrayAuxiliar[i];
		}
		
		return matriz;
	}
	
	
	/**
	 * Método que ordena una columna específica de una matriz de mayor a menor
	 * @param matriz Matriz de la cual ordenaremos una columna
	 * @param columna Columna específica que deseamos ordenar
	 * @return Matriz con la columna ya ordenada
	 * */
	public int[][] ordenaColumnaMatrizDescendente(int[][] matriz, int columna) throws IOException{
		if(columna>=matriz[0].length || columna<0) {
			System.out.println("Esa fila no existe, introduzca una nueva");
			columna=controlaIntMinMax(0,matriz[0].length-1);
		}
		int[] arrayAuxiliar=new int[matriz.length];
		for (int i = 0; i < arrayAuxiliar.length; i++) {
			arrayAuxiliar[i]=matriz[i][columna];
		}
		
		arrayAuxiliar=ordenacionDirectaDescendenteArray(arrayAuxiliar);
		
		for (int i = 0; i < arrayAuxiliar.length; i++) {
			matriz[i][columna]=arrayAuxiliar[i];
		}
		
		return matriz;
	}
	
	/**
	 * Método que ordena todas las filas de una matriz de menor a mayor
	 * @param matriz Matriz de la cual ordenaremos las filas
	 * @return Matriz con las filas ya ordenadas
	 * */
	public int[][] ordenaFilasMatrizAscendente (int[][] matriz) throws IOException{
		for (int i = 0; i < matriz.length; i++) {
			matriz=ordenaFilaMatrizAscendente(matriz,i);
		}
		
		return matriz;
	}
	
	
	/**
	 * Método que ordena todas las filas de una matriz de mayor a menor
	 * @param matriz Matriz de la cual ordenaremos las filas
	 * @return Matriz con las filas ya ordenadas
	 * */
	public int[][] ordenaFilasMatrizDescendente (int[][] matriz) throws IOException{
		for (int i = 0; i < matriz.length; i++) {
			matriz=ordenaFilaMatrizDescendente(matriz,i);
		}
		
		return matriz;
	}
	
	
	/**
	 * Método que ordena todas las columnas de una matriz de menor a mayor
	 * @param matriz Matriz de la cual ordenaremos las columnas
	 * @return Matriz con las columnas ya ordenadas
	 * */
	public int[][] ordenaColumnasMatrizAscendente (int[][] matriz) throws IOException{
		for (int i = 0; i < matriz[0].length; i++) {
			matriz=ordenaColumnaMatrizAscendente(matriz,i);
		}
		
		return matriz;
	}
	
	/**
	 * Método que ordena todas las columnas de una matriz de mayor a menor
	 * @param matriz Matriz de la cual ordenaremos las columnas
	 * @return Matriz con las columnas ya ordenadas
	 * */
	public int[][] ordenaColumnasMatrizDescendente (int[][] matriz) throws IOException{
		for (int i = 0; i < matriz[0].length; i++) {
			matriz=ordenaColumnaMatrizDescendente(matriz,i);
		}
		
		return matriz;
	}
	
	/**
	 * Método público que comprueba si un array está contenido en una columna de una 
	 * matriz.
	 * @param matriz Matriz en la cual queremos comprobar si el array está contenido
	 * @param array Array que queremos comprobar si está contenido
	 * @return  <ul>
	 * 			<li>La columna en la cual se encuentra el array, en caso de estar contenido.</li>
	 * 			<li>-1 en caso de no estar contenida en ninguna columna</li>
	 * 			</ul>
	 * */
	public int comprobarColumnaContenida(int[][] matriz, int[] array) {
		int index=0;
		int coincidencia=0;
		int aux=0;
		int columna=0;
		boolean parar=false;
		
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				index=0;
				aux=i;
				//Comprueba las coincidencias entre columna y array a partir de la primera.
				//Está calculado, con la última expresión, para que no se desborde el array.
				//Si se completan todas las coincidencias, está contenido.
				while((index<array.length)&&(array[index]==matriz[aux][j])&&((array.length-i)>(array.length-1))) {
					coincidencia++;
					index++;
					aux++;
				}
				if (coincidencia==array.length) {
					System.out.println("\nEl array se encuentra en la columna "+j);
					parar=true;
					columna=j;
					break;
				}else
					coincidencia=0;
			}
			if(parar) {
				break;
				}
			
		}
		if(parar)
			return columna;
		else
			return -1;

	}
	
	/**
	 * Método público que comprueba si un array está contenido en una fila de una 
	 * matriz.
	 * @param matriz Matriz en la cual queremos comprobar si el array está contenido
	 * @param array Array que queremos comprobar si está contenido
	 * @return  <ul>
	 * 			<li>La fila en la cual se encuentra el array, en caso de estar contenido.</li>
	 * 			<li>-1 en caso de no estar contenida en ninguna fila</li>
	 * 			</ul>
	 * */
	public int comprobarFilaContenida(int[][] matriz, int[] array) {
		int index=0;
		int coincidencia=0;
		int aux=0;
		int fila=0;
		boolean parar=false;
		
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				index=0;
				aux=j;
				while((index<array.length)&&(array[index]==matriz[i][aux])&&((array.length-j)>(array.length-1))) {
					coincidencia++;
					index++;
					aux++;
				}
				if (coincidencia==array.length) {
					System.out.println("\nEl array se encuentra en la fila "+i);
					parar=true;
					fila=i;
					break;
				}else
					coincidencia=0;
			}
			if(parar)
				break;
			
		}
		if(parar)
			return fila;
		else
			return -1;

	}
	
	/**
	 * Método público que extrae una fila concreta de una matriz
	 * @param matriz Matriz de la cual queremos extraer la Fila
	 * @param fila Fila en concreto que queremos extraer
	 * @return Fila ya extraída en un array
	 * */
	public int[] extraeFila (int[][] matriz, int fila) {
		int[] arrayAuxiliar=new int[matriz[0].length];
		for (int i = 0; i < matriz[0].length; i++) {
			arrayAuxiliar[i]=matriz[fila][i];
		}
		return arrayAuxiliar;
	}
	
	
	/**
	 * Método público que extrae una columna concreta de una matriz
	 * @param matriz Matriz de la cual queremos extraer la Columna
	 * @param columna Columna en concreto que queremos extraer
	 * @return Columna ya extraída en un array
	 * */
	public int[] extraeColumna (int[][] matriz, int columna) {
		int[] arrayAuxiliar=new int[matriz.length];
		for (int i = 0; i < matriz.length; i++) {
			arrayAuxiliar[i]=matriz[i][columna];
		}
		return arrayAuxiliar;
	}
}
