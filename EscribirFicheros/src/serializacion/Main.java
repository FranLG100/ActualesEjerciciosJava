package serializacion;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub

		Biblioteca b=new Biblioteca();
		
		HashMap<Integer, Libro> libros=new HashMap<Integer, Libro>();
		
		libros=b.importarLibros(libros);
		for (Map.Entry<Integer, Libro> libro : libros.entrySet()) {
			System.out.println(libro.toString());
		}
		b.crearLibro();
		for (Map.Entry<Integer, Libro> libro : b.getLibros().entrySet()) {
			System.out.println(libro.toString());
		}
		b.exportarEnFichero();
		
	}

}
