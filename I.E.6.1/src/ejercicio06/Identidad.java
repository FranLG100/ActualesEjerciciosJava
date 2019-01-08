package ejercicio06;

import java.io.IOException;

import utilesFran.Amadeus;

public class Identidad {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//En este caso, ya tenía un método en mi clase de utilidades que controlaba
		//que el DNI fuese válido. En caso contrario, volvía a pedirlo.
		
		Amadeus amadeus=new Amadeus();
		System.out.println("Introduzca su DNI");
		String dni=amadeus.recibeTexto();
		amadeus.compruebaNIF(dni);
		
		//Cambia el dígito noveno por un espacio.
		System.out.println(dni.replace(dni.charAt(8),' '));
	}

}
