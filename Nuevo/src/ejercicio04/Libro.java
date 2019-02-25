package ejercicio04;

public class Libro extends Publicacion implements Prestable {

	private boolean prestado=false;
	
	public Libro(int codigo, String titulo, int anho) {
		super(codigo, titulo, anho);
	}
	
	@Override
	public String toString() {
		return "\nTipo de publicación: Libro"+super.toString()+"\nDisponible: "+(prestado?"No":"Sí");
	}

	@Override
	public void prestar() {
		this.prestado=true;
		
	}

	@Override
	public void devolver() {
		this.prestado=false;
		
	}

	@Override
	public Boolean prestado() {
		return prestado;
	}

	
	
	

}
