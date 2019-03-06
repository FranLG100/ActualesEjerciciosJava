package ejercicio04;

public class Revista extends Publicacion {

	private int numero;
	
	/**
	 * Constructor de la clase Revista
	 * @param numero Número de entrega de la revista
	 * */
	public Revista(int codigo, String titulo, int anho, int numero) {
		super(codigo, titulo, anho);
		this.numero=numero;
	}
	
	public String toString() {
		return "\nTipo de publicación: Revista"+super.toString()+"\nNº de Lanzamiento: "+numero;
	}

	

	
	
	
}
