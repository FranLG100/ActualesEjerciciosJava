package ejercicio04;

public class Libro extends Publicacion implements Prestable {

	private boolean prestado=false;
	
	public Libro(int codigo, String titulo, int anho) {
		super(codigo, titulo, anho);
	}
	
	@Override
	public String toString() {
		return "\nTipo de publicaci�n: Libro"+super.toString()+"\nDisponible: "+(prestado?"No":"S�");
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
