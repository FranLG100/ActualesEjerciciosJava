package ejercicio04;

import java.io.IOException;

import utilesFran.Amadeus;

public class ExcesoDeVocales {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		Amadeus amadeus=new Amadeus();
		int contA=0;
		int contE = 0;
		int contO = 0;
		char[] cadena;
		char[] origen= {'a','e','o'};
		String comprobante;
		int contComprobante=0;
		
		System.out.println("Introduzca texto");
		String sujeto=amadeus.recibeTexto().toLowerCase();
		cadena=sujeto.toCharArray();
		String[] palabras=sujeto.split("[\\s,]");
		
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
		
		System.out.println("¿Qué palabra desea comprobar?");
		comprobante=amadeus.recibeTexto().toLowerCase();
		
		for (int i = 0; i < palabras.length; i++) {
			if(comprobante.equals(palabras[i]))
				contComprobante++;
		}
		
		System.out.println("Esa palabra se repite "+contComprobante+" veces");
		if(sujeto.indexOf(comprobante)>=0)
			System.out.println("Se encuentra, por primera vez, en la posición "+sujeto.indexOf(comprobante));
	}

}
