package ej07;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		Biblioteca b=new Biblioteca();
		
		b.crearLibro();
		b.escribirEnFichero(4444);
		
	}

}
