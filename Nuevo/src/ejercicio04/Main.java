package ejercicio04;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Publicacion> publicaciones=new ArrayList<Publicacion>();
		
		
		/**
		 * A continuación se procede a un test. Se crean varias publicaciones (libros
		 * y revistas) y se prueban sus métodos. Todo almacenado en una lista de publicaciones.
		 * */
		
		Libro l1=new Libro(1, "Fray Perico y su Borrico", 1991);
		Libro l2=new Libro(2, "El Pirata Garrapata", 1989);
		Libro l3=new Libro(3, "El Fantasma de la Ópera", 1925);
		Libro l4=new Libro(4, "De Ratones y Hombres", 1937);
		Revista r1=new Revista(5, "Computer Hoy", 2001, 6);
		Revista r2=new Revista(6, "Jara y Sedal", 1993, 2);
		Revista r3=new Revista(7, "Super Mortadelo", 1972, 126);
		Revista r4=new Revista(8, "Cinemanía", 2008, 72);
		
		l2.prestar();
		l3.prestar();
		l4.prestar();
		l3.devolver();
		
		publicaciones.add(l1);
		publicaciones.add(l2);
		publicaciones.add(l3);
		publicaciones.add(l4);
		publicaciones.add(r1);
		publicaciones.add(r2);
		publicaciones.add(r3);
		publicaciones.add(r4);
		
		System.out.println("\n-------------------------------------");
		System.out.println("Listemos todas nuestras publicaciones");
		System.out.println("-------------------------------------");
		for (Publicacion publicacion : publicaciones) {
			System.out.println(publicacion);
		}
		
		System.out.println("\n-------------------------------------");
		System.out.println("Listemos nuestas publicaciones prestadas");
		System.out.println("-------------------------------------");
		System.out.println();
		cuentaPrestado(publicaciones);
		
		System.out.println("\n\n-------------------------------------");
		System.out.println("Publicaciones anteriores a 1990");
		System.out.println("-------------------------------------");
		publicacionesAnterioresA(publicaciones,1990);
		
		
	}
	
	/**
	 * Método que cuenta y muestra cuántas publicaciones se encuentran prestadas
	 * @param publicaciones Colección de publicaciones a comprobar
	 * */
	public static void cuentaPrestado(ArrayList<Publicacion> publicaciones) {
		int cuenta=0;
		for (Publicacion publicacion : publicaciones) {
			if(publicacion instanceof Libro) {
				if(((Libro) publicacion).prestado()) {
					System.out.println(publicacion);
					cuenta++;
				}
			}
		}
		System.out.println("\n\nHay prestadas "+cuenta+" publicaciones.");
	}
	
	/**
	 * Método que muestra publicaciones anteriores a un determinado año
	 * @param publicaciones Colección de publicaciones a comprobar
	 * @param anho Año a comprobar
	 * */
	public static void publicacionesAnterioresA(ArrayList<Publicacion> publicaciones, int anho) {
		ArrayList<Publicacion> tmp = new ArrayList<Publicacion>();
		for (Publicacion publicacion : publicaciones) {
			if(publicacion.getAnho()<anho)
				tmp.add(publicacion);
		}
		System.out.println("Las publicaciones anteriores a "+anho+" son: ");
		for (Publicacion publicacion : tmp) {
			System.out.println(publicacion);
		}
		
		tmp.clear();
	}
	
	

}
