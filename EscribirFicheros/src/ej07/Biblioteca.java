package ej07;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;

import utilesFran.Amadeus;

public class Biblioteca {
	
	private Amadeus amadeus=new Amadeus();
	private HashMap<Integer,Libro> libros=new HashMap<Integer,Libro>();
	private Libro libro;
	
	public Biblioteca() {}
	
	public void addLibro(Libro ejemplar) {
		if(libros.containsKey(ejemplar.getCodigoLibro())) 
			System.out.println("Ese libro ya se encuentra en nuestra biblioteca");
		else {
			libros.put(ejemplar.getCodigoLibro(), ejemplar);
		}
	}
	
	public void crearLibro() throws IOException {
		int codLibro=0;
		String isbn;
		String titulo;
		String autor;
		String editorial;
		int anho;
		
		do{
			System.out.println("Introduzca código de libro");
			codLibro=amadeus.controlaIntMinMax(1000, 9999);
			if(libros.containsKey(codLibro))
				System.out.println("Ese número ya se encuentra en nuestra biblioteca, introduzca otro");
		}while(libros.containsKey(codLibro));
		
		System.out.println("Introduzca ISBN");
		isbn=amadeus.recibeTexto();
		
		System.out.println("Introduzca título");
		titulo=amadeus.recibeTexto();
		
		System.out.println("Introduzca autor");
		autor=amadeus.recibeTexto();
		
		System.out.println("Introduzca editorial");
		editorial=amadeus.recibeTexto();
		
		System.out.println("Introduzca año de edición");
		anho=amadeus.controlaIntMinMax(0, Calendar.getInstance().get(Calendar.YEAR));
		
		libro=new Libro(codLibro, isbn, titulo, autor, editorial, anho);
		libros.put(libro.getCodigoLibro(), libro);
	}

	/**
	 * @return the libros
	 */
	public HashMap<Integer, Libro> getLibros() {
		return libros;
	}

	/**
	 * @param libros the libros to set
	 */
	public void setLibros(HashMap<Integer, Libro> libros) {
		this.libros = libros;
	}

	/**
	 * @return the libro
	 */
	public Libro getLibro() {
		return libro;
	}

	/**
	 * @param libro the libro to set
	 */
	public void setLibro(Libro libro) {
		this.libro = libro;
	}
	
	public void escribirEnFichero(int codLibro) {
		if(!libros.containsKey(codLibro))
			System.out.println("Ese libro no existe");
		else {
		Libro ejemplar=libros.get(codLibro);
		File f=amadeus.abrirArchivo("Libros.txt");
		amadeus.anexarArchivo(f, ejemplar.getCodigoLibro()+";");
		amadeus.anexarArchivo(f, ejemplar.getIsbn()+";");
		amadeus.anexarArchivo(f, ejemplar.getTitulo()+";");
		amadeus.anexarArchivo(f, ejemplar.getAutor()+";");
		amadeus.anexarArchivo(f, ejemplar.getEditorial()+";");
		amadeus.anexarArchivo(f, ejemplar.getAnho()+";");
		amadeus.anexarArchivo(f, "");
		}
		
	}
	
	
	

}
