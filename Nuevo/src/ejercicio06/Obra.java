package ejercicio06;

public class Obra {

	private String titulo;
	private int numInventario;
	private Artista autor;
	private int anyo;
	
	public Obra() {}
	
	
	
	public Obra(String titulo, int numInventario, Artista autor, int anyo) {
		super();
		this.titulo = titulo;
		this.numInventario = numInventario;
		this.autor = autor;
		this.anyo = anyo;
	}


	@Override
	public String toString() {
		return "\nTítulo: "+titulo+"\nCódigo de Inventario: "+numInventario+"\nAutor: "+autor.getNombre()+"\nAño: "+anyo;
	}


	public boolean equalsObra(Obra obra) {
		if(this.titulo.equalsIgnoreCase(obra.getTitulo()) && this.autor.getNombre().equalsIgnoreCase(obra.getAutor().getNombre()) && this.anyo==obra.anyo)
			return true;
		else
			return false;
	}

	public String getTitulo() {
		return titulo;
	}



	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}



	public int getNumInventario() {
		return numInventario;
	}



	public void setNumInventario(int numInventario) {
		this.numInventario = numInventario;
	}



	public Artista getAutor() {
		return autor;
	}



	public void setAutor(Artista autor) {
		this.autor = autor;
	}



	public int getAnyo() {
		return anyo;
	}



	public void setAnyo(int anyo) {
		this.anyo = anyo;
	}

	
}
