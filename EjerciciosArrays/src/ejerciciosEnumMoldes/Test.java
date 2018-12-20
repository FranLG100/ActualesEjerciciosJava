package ejerciciosEnumMoldes;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Materia m1=null;
		m1.setNombre(Asignaturas.BIOLOGIA.name());
		Materia[] temario= new Materia[3];
		int i=0;
		Alumno al1=new Alumno("Fran", temario);
		Alumno al2=new Alumno("Jose", temario);
		
		for (Materia materia : temario) {
			materia.imprimirMateria();
		}
	}

}
