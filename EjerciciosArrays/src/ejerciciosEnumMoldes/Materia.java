package ejerciciosEnumMoldes;

public class Materia {

	String nombre;
	int nota;
	Asignaturas a;
	
	public Materia() {};
	
	public Materia(String nombre, int nota) {
		this.nombre=nombre; 
		this.nota=nota;
		};
	
	public void imprimirMateria() {
		System.out.println(nombre+": "+nota);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}
	
	
	
}
