package ejercicio06;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class Artista {

	private String nombre;
	private String lugarNac;
	private LocalDate fechaNac;
	private LocalDate fechaFall;
	
	public Artista() {
		
	}

	public Artista(String nombre, String lugarNac, LocalDate fechaNac, LocalDate fechaFall) {
		this.nombre = nombre;
		this.lugarNac = lugarNac;
		this.fechaNac = fechaNac;
		this.fechaFall = fechaFall;
	}
	
	public String toString() {
		return "\nNombre: "+nombre+"\nLugar de Nacimiento: "+lugarNac+"\nFecha de Nacimiento: "+
				fechaNac.toString()+"\nFecha de Fallecimiento: "+fechaFall.toString();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getLugarNac() {
		return lugarNac;
	}

	public void setLugarNac(String lugarNac) {
		this.lugarNac = lugarNac;
	}

	public LocalDate getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(LocalDate fechaNac) {
		this.fechaNac = fechaNac;
	}

	public LocalDate getFechaFall() {
		return fechaFall;
	}

	public void setFechaFall(LocalDate fechaFall) {
		this.fechaFall = fechaFall;
	}
	
	
	
	
	
}
