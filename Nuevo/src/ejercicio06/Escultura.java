package ejercicio06;

public class Escultura extends Obra {
	
	private String material;
	private int altura;
	
	public Escultura() {
	}
	
	/**
	 * Constructor de una Escultura
	 * @param material Material de la estatua
	 * @param altura Altura de la estatua
	 * */
	public Escultura(String titulo, int numInventario, Artista autor, int anyo, String material, int altura) {
		super(titulo, numInventario, autor, anyo);
		this.material=material;
		this.altura=altura;
	}
	
	@Override
	public String toString() {
		return "\nTipo: Escultura"+super.toString()+"\nMaterial: "+material+"\nAltura: "+altura;
	}


	public boolean equalsEscultura(Escultura es) {
		if(super.equalsObra(es) && this.material.equalsIgnoreCase(es.getMaterial()) && this.altura==es.altura)
			return true;
		else
			return false;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}
	
	
	
	

}
