package ejercicio06;

import java.io.IOException;

import utilesFran.Amadeus;

public class Identidad {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		Amadeus amadeus=new Amadeus();
		System.out.println("Introduzca su DNI");
		String dni=amadeus.recibeTexto();
		amadeus.compruebaNIF(dni);
		System.out.println(dni.replace(dni.charAt(8),' '));
	}

}
