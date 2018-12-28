package ejercicio01;

import java.io.IOException;

import utilesFran.Amadeus;

public class CuentaVocales {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Amadeus amadeus=new Amadeus();
		
		int cont=0;
		char[] cadena;
		char[] origen= {'a','e','i','o','u'};
		System.out.println("Introduzca texto");
		String sujeto=amadeus.recibeTexto();
		sujeto=sujeto.toLowerCase();
		cadena=sujeto.toCharArray();
		
		for (int i = 0; i < cadena.length; i++) {
			for (int j = 0; j < origen.length; j++) {
				if(cadena[i]==origen[j])
					cont++;
			}
		}
		
		System.out.println("En ese texto hay "+cont+" vocales.");

	}

}
