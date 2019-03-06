package ejercicio03;

public class Profesor extends Persona {

	private int Despacho;

	public Profesor() {
	}

	/**
	 * Constructor de un Profesor
	 * @param Despacho Número de despacho del profesor
	 * */
	public Profesor(String nombre, String apellidos, String dni, int Despacho) {
		super(nombre, apellidos, dni);
		this.Despacho = Despacho;
	}

	@Override
	public String identificate() {
		return "\nTipo: Profesor";
	}

	public int getIdAlumno() {
		return Despacho;
	}

	public void setIdAlumno(int Despacho) {
		this.Despacho = Despacho;
	}

	public String toString() {
		return identificate() + "\nNombre: " + getNombre() + "\nApellidos: " + getApellidos() + "Despacho: "
				+ Despacho + "\nDirección:"+"\n   Calle: "+getDireccion().getCalle()+"\n   ZIP: "+getDireccion().getZip()
				+"\n   Ciudad: "+getDireccion().getCiudad()+"\n   País: "+getDireccion().getPais();
	}
}
