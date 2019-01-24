package pruebas;

import utilesFran.Amadeus;

public class Persona {
	
	private Amadeus amadeus=new Amadeus();
	private static int id=0;
	private String nombre;
	private String apellido;
	private int altura;
	
	
	public Persona(String nombre, String apellido, int altura) {
		this.id = id++;
		this.nombre = nombre;
		this.apellido = apellido;
		this.altura = altura;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public int getAltura() {
		return altura;
	}


	public void setAltura(int altura) {
		this.altura = altura;
	}
	
	
	
	
	
	
	
	

}
