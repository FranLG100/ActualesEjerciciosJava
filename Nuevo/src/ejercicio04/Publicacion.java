package ejercicio04;

public abstract class Publicacion {
	
	private int codigo;
	private String titulo;
	private int anho;
	
	
	public Publicacion(int codigo, String titulo, int anho) {
		this.codigo = codigo;
		this.titulo = titulo;
		this.anho = anho;
	}
	
	@Override
	public String toString() {
		return "\nCódigo: "+codigo+"\nTítulo: "+titulo+"\nAño de publicación: "+anho; 
	}


	public int getCodigo() {
		return codigo;
	}


	public int getAnho() {
		return anho;
	}


	
	

}
