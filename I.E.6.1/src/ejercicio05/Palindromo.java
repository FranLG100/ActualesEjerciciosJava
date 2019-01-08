package ejercicio05;

import java.io.IOException;

import utilesFran.Amadeus;

public class Palindromo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		Amadeus amadeus=new Amadeus();
		
		//Le pedimos al usuario que escriba una frase.
		System.out.println("Introduzca palabra a comprobar");
		String frase=amadeus.recibeTexto().toLowerCase(); //La pasamos a minúsculas.
		frase=frase.trim(); //Quitamos espacios iniciales o finales si los hubiese. 
		char[] original=new char[frase.length()];
		char[] comprobante=new char[frase.length()];
		original=frase.toCharArray(); //Y a caracteres
		
		//Ahora, simplemente pasamos todos esos caracteres a otra variable,
		//pero en orden inverso al original.
		for (int i = 0; i < comprobante.length; i++) {
			comprobante[i]=original[frase.length()-i-1];
		}
		
		//Formamos un String con ese array de caracteres invertido
		String palindromo=new String(comprobante);
		
		//Y comprobamos. Si el string original es igual a este nuevo string de caracteres
		//invertidos, entonces, es un palíndromo.
		if(palindromo.equals(frase))
			System.out.println("Sí es un palíndromo");
		else
			System.out.println("No es un palíndromo");
	}

}
