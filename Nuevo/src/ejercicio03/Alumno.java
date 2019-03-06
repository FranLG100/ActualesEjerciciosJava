package ejercicio03;

public class Alumno extends Persona {

	private int idAlumno;

	public Alumno() {
	}

	/**
	 * Constructor de alumno.
	 * @param idAlumno Identificador del alumno
	 * */
	public Alumno(String nombre, String apellidos, String dni, int idAlumno) {
		super(nombre, apellidos, dni);
		this.idAlumno = idAlumno;
	}

	@Override
	public String identificate() {
		return "\nTipo: Estudiante";
	}

	public int getIdAlumno() {
		return idAlumno;
	}

	public void setIdAlumno(int idAlumno) {
		this.idAlumno = idAlumno;
	}

	public String toString() {
		return identificate() + "\nNombre: " + getNombre() + "\nApellidos: " + getApellidos() + "ID Estudiante: "
				+ idAlumno + "\nDirección:"+"\n   Calle: "+getDireccion().getCalle()+"\n   ZIP: "+getDireccion().getZip()
				+"\n   Ciudad: "+getDireccion().getCiudad()+"\n   País: "+getDireccion().getPais();
	}

}
