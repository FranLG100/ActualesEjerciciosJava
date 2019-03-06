package ejercicio06;

public class Pintura extends Obra{
	
	private int ancho, alto;
	private String soporte;
	
	public Pintura() {
		super();
	}
	
	/**
	 * Constructor de la clase Pintura
	 * @param ancho Ancho de la pintura
	 * @param alto Alto de la pintura
	 * @param soporte Soporte de la obra
	 * */
	public Pintura(String titulo, int numInventario, Artista autor,int anyo, int ancho, int alto, String soporte) {
		super(titulo, numInventario, autor, anyo);
		this.ancho=ancho;
		this.alto=alto;
		this.soporte=soporte;
	}
	
	@Override
	public String toString() {
		return "\nTipo: Pintura"+super.toString()+"\nAncho: "+ancho+"\nAlto: "+alto+"\nSoporte: "+soporte;
	}
	
	
	public boolean equalsPintura(Pintura p) {
		if(super.equalsObra(p) && this.alto==p.alto && this.ancho==p.ancho && this.soporte.equalsIgnoreCase(p.getSoporte()))
			return true;
		else
			return false;
	}
	
	public int getAncho() {
		return ancho;
	}
	public void setAncho(int ancho) {
		this.ancho = ancho;
	}
	public int getAlto() {
		return alto;
	}
	public void setAlto(int alto) {
		this.alto = alto;
	}
	public String getSoporte() {
		return soporte;
	}
	public void setSoporte(String soporte) {
		this.soporte = soporte;
	}
	
	
	
	

}
