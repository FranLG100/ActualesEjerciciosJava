package ejercicio03;

import java.io.IOException;
import java.util.ArrayList;

import utilesFran.Amadeus;

public class Menu {
	
	private Amadeus amadeus=new Amadeus();
	private ArrayList<Persona> personas=new ArrayList<Persona>();
	
	/**
	 * Método que arranca un menú y deja que el usuario interactúe con el programa
	 * */
	public void arrancaMenu() throws IOException {
		int option = 0;
		do {
		System.out.println("Escoja una opción");
		System.out.println("1.-Crear un alumno");
		System.out.println("2.-Crear un profesor");
		System.out.println("3.-Mostrar todos los alumnos");
		System.out.println("4.-Mostrar todos los profesores");
		System.out.println("5.-Mostrar todas las personas");
		System.out.println("6.-Salir");
		
		option=amadeus.controlaIntMinMax(1, 6);
		
		switch (option) {
		case 1:
			crearAlumno();
			break;
		case 2:
			crearProfesor();
			break;
		case 3:
			listAlumnos();
			break;
		case 4:
			listProfesores();
			break;
		case 5:
			listTodos();
			break;
		default:
			break;
		}
		
		}while(option!=6);
		
	}
	
	/**
	 * Crea un objeto alumno con todos sus datos necesarios
	 * */
	public void crearAlumno() throws IOException {
		String c1;
		String c2;
		String c3;
		String c4;
		int idAlumno;
		
		System.out.println("Introduzca nombre del Alumno");
		c1=amadeus.recibeTexto();
		System.out.println("Introduzca apellidos del Alumno");
		c2=amadeus.recibeTexto();
		System.out.println("Introduzca dni del Alumno");
		c3=amadeus.recibeTexto();
		c3=amadeus.compruebaNIF(c3);
		System.out.println("Introduzca ID del Alumno");
		idAlumno=amadeus.controlaIntPositivo();
		
		Alumno alum=new Alumno(c1,c2,c3,idAlumno);
		
		System.out.println("Introduzca calle del Alumno");
		c1=amadeus.recibeTexto();
		System.out.println("Introduzca zip del Alumno");
		c2=amadeus.recibeTexto();
		System.out.println("Introduzca ciudad del Alumno");
		c3=amadeus.recibeTexto();
		System.out.println("Introduzca pais del Alumno");
		c4=amadeus.recibeTexto();
		
		Direccion dir=new Direccion(c1,c2,c3,c4);
		
		alum.setDireccion(dir);
		
		personas.add(alum);
		
		
	}
	
	/**
	 * Crea un objeto profesor con todos sus datos necesarios
	 * */
	public void crearProfesor() throws IOException {
		String c1;
		String c2;
		String c3;
		String c4;
		int despacho;
		
		System.out.println("Introduzca nombre del Profesor");
		c1=amadeus.recibeTexto();
		System.out.println("Introduzca apellidos del Profesor");
		c2=amadeus.recibeTexto();
		System.out.println("Introduzca dni del Profesor");
		c3=amadeus.recibeTexto();
		c3=amadeus.compruebaNIF(c3);
		System.out.println("Introduzca despacho del Profesor");
		despacho=amadeus.controlaIntPositivo();
		
		Profesor prof=new Profesor(c1,c2,c3,despacho);
		
		System.out.println("Introduzca calle del Profesor");
		c1=amadeus.recibeTexto();
		System.out.println("Introduzca zip del Profesor");
		c2=amadeus.recibeTexto();
		System.out.println("Introduzca ciudad del Profesor");
		c3=amadeus.recibeTexto();
		System.out.println("Introduzca pais del Profesor");
		c4=amadeus.recibeTexto();
		
		Direccion dir=new Direccion(c1,c2,c3,c4);
		
		prof.setDireccion(dir);
		
		personas.add(prof);
		
		
	}
	
	/**
	 * Lista todos los alumnos almacenados
	 * */
	public void listAlumnos() {
		for (Persona persona : personas) {
			if(persona instanceof Alumno)
				System.out.println(persona);
		}
	}
	
	/**
	 * Lista todos los profesores almacenados
	 * */
	public void listProfesores() {
		for (Persona persona : personas) {
			if(persona instanceof Profesor)
				System.out.println(persona);
		}
	}
	
	/**
	 * Lista todos los alumnos y profesores almacenados
	 * */
	public void listTodos() {
		for (Persona persona : personas) {
				System.out.println(persona);
		}
	}

}
