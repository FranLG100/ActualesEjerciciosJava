package ejercicio01;

import java.io.IOException;

import utilesFran.Amadeus;

public class CuentaVocales {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Amadeus amadeus=new Amadeus();
		
		int cont=0; //Entero para contar vocales
		char[] cadena; //En esta variable guardaremos el texto que introduzcamos, pasado a caracteres
		char[] origen= {'a','e','i','o','u'}; //Caracteres (vocales) con los cuales comparar los caracteres de 'cadena'
		
		//Le pedimos al usuario que introduzca el texto que desee
		System.out.println("Introduzca texto");
		String sujeto=amadeus.recibeTexto();
		
		//Lo pasamos a minúsculas, y lo convertimos en un array de caracteres
		sujeto=sujeto.toLowerCase();
		cadena=sujeto.toCharArray();
		
		//Con un For, comparamos cuantos caracteres coinciden con las vocales, 
		//añadiendo 1 al contador por cada coincidencia
		for (int i = 0; i < cadena.length; i++) {
			for (int j = 0; j < origen.length; j++) {
				if(cadena[i]==origen[j])
					cont++;
			}
		}
		
		//Imprimimos nuestra solución
		System.out.println("En ese texto hay "+cont+" vocales.");

	}

}
