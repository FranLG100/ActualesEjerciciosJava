package ejercicio04;

public class Revista extends Publicacion {

	private int numero;
	
	public Revista(int codigo, String titulo, int anho, int numero) {
		super(codigo, titulo, anho);
		this.numero=numero;
	}
	
	public String toString() {
		return "\nTipo de publicaci�n: Revista"+super.toString()+"\nN� de Lanzamiento: "+numero;
	}

	

	
	
	
}
