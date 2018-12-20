package ejerciciosEnumMoldes;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Materia m1=new Materia(Asignaturas.MATEMATICAS,6);
		Materia m2=new Materia(Asignaturas.LENGUAJE,7);
		Materia m3=new Materia(Asignaturas.PLASTICA,7);
		Materia m4=new Materia(Asignaturas.MATEMATICAS,9);
		Materia m5=new Materia(Asignaturas.BIOLOGIA,4);
		Materia m6=new Materia(Asignaturas.SOCIALES,5);
		Materia[] temario= {m1,m2,m3};
		Materia[] temario2= {m4,m5,m6};
		int i=0;
		Alumno al1=new Alumno("Fran", temario);
		Alumno al2=new Alumno("Jose", temario2);
		
		System.out.println("Materias del Alumno 1");
		for (Materia materia : al1.getMaterias()) {
			materia.imprimirMateria();
		}
		
		System.out.println("\nMaterias del Alumno 2");
		for (Materia materia : al2.getMaterias()) {
			materia.imprimirMateria();
		}
	}

}
