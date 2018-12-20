package ejercicioEnum;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Alumno al1=new Alumno("Fran");
		Alumno al2=new Alumno("Jose");
		al2.getAsignaturas().MATEMATICAS.setNota(8);
		
		//System.out.println(al1.getAsignaturas().MATEMATICAS.getNota());
		//System.out.println(al2.getAsignaturas().MATEMATICAS.getNota());
		
		for (Asignaturas a: al1.getAsignaturas().values()) {
			System.out.println(a+" "+a.getNota());
		}

	}

}
