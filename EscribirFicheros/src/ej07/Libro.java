package ej07;

import java.io.IOException;
import java.io.Serializable;

import utilesFran.Amadeus;

public class Libro implements Serializable{

	private Amadeus amadeus=new Amadeus();
	private int codigoLibro;
	private String isbn;
	private String titulo;
	private String autor;
	private String editorial;
	private int anho;
	
	public Libro() {}

	public Libro(int codigoLibro, String isbn, String titulo, String autor, String editorial, int anho) throws IOException {
		super();
		this.setCodigoLibro(codigoLibro);
		this.codigoLibro = codigoLibro;
		this.isbn = isbn;
		this.titulo = titulo;
		this.autor = autor;
		this.editorial = editorial;
		this.anho = anho;
	}

	/**
	 * @return the codigoLibro
	 */
	public int getCodigoLibro() {
		return codigoLibro;
	}

	/**
	 * @param codigoLibro the codigoLibro to set
	 * @throws IOException 
	 */
	public void setCodigoLibro(int codigoLibro) throws IOException {
		if(codigoLibro<1000 || codigoLibro>9999) {
			System.out.println("El código de Libro debe ser un número de cuatro cifras (entre 1000 y 9999)");
			System.out.println("Introduzca otro");
			codigoLibro=amadeus.controlaIntMinMax(1000, 9999);
		}
		this.codigoLibro=codigoLibro;
	}

	/**
	 * @return the isbn
	 */
	public String getIsbn() {
		return isbn;
	}

	/**
	 * @param isbn the isbn to set
	 */
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	/**
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * @param titulo the titulo to set
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * @return the autor
	 */
	public String getAutor() {
		return autor;
	}

	/**
	 * @param autor the autor to set
	 */
	public void setAutor(String autor) {
		this.autor = autor;
	}

	/**
	 * @return the editorial
	 */
	public String getEditorial() {
		return editorial;
	}

	/**
	 * @param editorial the editorial to set
	 */
	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	/**
	 * @return the anho
	 */
	public int getAnho() {
		return anho;
	}

	/**
	 * @param anho the anho to set
	 */
	public void setAnho(int anho) {
		this.anho = anho;
	}
	
	
	
}
