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

	/**
	 * Método que presta el libro
	 * */
	@Override
	public void prestar() {
		this.prestado=true;
		
	}

	/**
	 * Método que devuelve el libro (el cual estaba prestado)
	 * */
	@Override
	public void devolver() {
		this.prestado=false;
		
	}

	/**
	 * Método que informa sobre el estado del libro
	 * @return <ul><li>true - El libro está prestado</li><li>false - El libro está disponible</li></ul>
	 * */
	@Override
	public Boolean prestado() {
		return prestado;
	}

	
	
	

}
