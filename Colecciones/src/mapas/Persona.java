package mapas;

import utilesFran.Amadeus;

public class Persona {
	
	private Amadeus amadeus=new Amadeus();
	private static int id=1;
	private int idPersona=0;
	private String nombre;
	private String apellido;
	private int altura;
	private String dni;
	
	public String getDni() {
		return dni;
	}


	public void setDni(String dni) {
		this.dni = dni;
	}


	public Persona(String dni, String nombre, String apellido, int altura) {
		this.dni=dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.altura = altura;
	}


	public int getIdPersona() {
		return idPersona;
	}


	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
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
	
	@Override
	public String toString() {
		return "\nID: "+idPersona+"\nNombre: "+nombre+"\nApellido: "+apellido+"\nAltura: "+altura+"cm";
	}
	

}
