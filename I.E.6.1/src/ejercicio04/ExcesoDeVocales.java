package ejercicio04;

import java.io.IOException;

import utilesFran.Amadeus;

public class ExcesoDeVocales {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		Amadeus amadeus=new Amadeus();
		int contA=0; //Cuenta las veces que aparece la vocal 'a'
		int contE = 0; //Cuenta las veces que aparece la vocal 'e'
		int contO = 0; //Cuenta las veces que aparece la vocal 'o'
		char[] cadena; //Aquí guardaremos el String pasado a caracteres
		char[] origen= {'a','e','o'}; //Caracteres que queremos comprobar
		String comprobante; //En este String guardaremos la palabra que deseamos comprobar si se encuentra en nuestra frase
		int contComprobante=0; //Y la de veces que se repite dicha palabra/substring.
		
		//Le pedimos al usuario que introduzca un texto
		System.out.println("Introduzca texto");
		String sujeto=amadeus.recibeTexto().toLowerCase(); //Y lo pasamos a minúsculas
		cadena=sujeto.toCharArray();//Y a caracteres
		String[] palabras=sujeto.split("[\\s,]"); //Y guardamos cada palabra por separado,
												//separándolas por espacios en blanco o comas.
		
		//Comprobamos cuantas veces se repiten la a, la o y la e
		for (int i = 0; i < cadena.length; i++) {
				if(cadena[i]==origen[0])
					contA++;
				if(cadena[i]==origen[1])
					contE++;
				if(cadena[i]==origen[2])
					contO++;
		}
		
		if(contA>10)
			System.out.println("Exceso de a");
		if(contE>3)
			System.out.println("Exceso de e");
		if(contO>5)
			System.out.println("Exceso de o");
		
		
		//Ahora, el usuario comprobará una palabra que desee en el texto
		System.out.println("¿Qué palabra desea comprobar?");
		comprobante=amadeus.recibeTexto().toLowerCase();
		
		//Se contará las veces que se repite...
		for (int i = 0; i < palabras.length; i++) {
			if(comprobante.equals(palabras[i]))
				contComprobante++;
		}
		
		System.out.println("Esa palabra se repite "+contComprobante+" veces");
		//...y en qué posición (contando la frase en caracteres) se encuentra.
		if(sujeto.indexOf(comprobante)>=0)
			System.out.println("Se encuentra, por primera vez, en la posición "+sujeto.indexOf(comprobante));
	}

}
