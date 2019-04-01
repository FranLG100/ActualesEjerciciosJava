package serializacion;

import java.io.IOException;
import java.util.HashMap;

public class Main {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub

		Biblioteca b=new Biblioteca();
		
		HashMap<Integer, Libro> libros=new HashMap<Integer, Libro>();
		libros=b.importarLibros(libros);
		
		b.crearLibro();
		b.exportarEnFichero();
		
	}

}
