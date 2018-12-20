package ejerciciosEnumMoldes;

public class Alumno {

	String nombre;
	Materia[] materias;
	Asignaturas a;
	
	public Alumno(String nombre, Materia[] materias) {
		this.nombre=nombre;
		this.materias=materias;
	}
	
	public Materia[] getMaterias() {
		return materias;
	}
	
}
