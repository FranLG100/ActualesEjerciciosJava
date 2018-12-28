package ejercicio05;

import java.io.IOException;

import utilesFran.Amadeus;

public class Palindromo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		Amadeus amadeus=new Amadeus();
		
		System.out.println("Introduzca palabra a comprobar");
		String frase=amadeus.recibeTexto().toLowerCase();
		char[] original=new char[frase.length()];
		char[] comprobante=new char[frase.length()];
		original=frase.toCharArray();
		
		for (int i = 0; i < comprobante.length; i++) {
			comprobante[i]=original[frase.length()-i-1];
		}
		
		String palindromo=new String(comprobante);
		
		if(palindromo.equals(frase))
			System.out.println("Sí es un palíndromo");
		else
			System.out.println("No es un palíndromo");
	}

}
