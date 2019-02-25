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
		return "\nC�digo: "+codigo+"\nT�tulo: "+titulo+"\nA�o de publicaci�n: "+anho; 
	}


	public int getCodigo() {
		return codigo;
	}


	public int getAnho() {
		return anho;
	}


	
	

}
