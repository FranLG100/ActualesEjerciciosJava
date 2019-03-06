package ejercicio06;

import java.time.LocalDate;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Catalogo catalogo=new Catalogo();
		
		/**
		 * Realizamos un test
		 * */
		Artista a1=new Artista("Goya", "Fuendetodos - España", LocalDate.of(1746,03,30), LocalDate.of(1828,04,16));
		Artista a2=new Artista("Picasso", "Málaga - España", LocalDate.of(1881,10,25), LocalDate.of(1973,04,8));
		
		Artista a3=new Artista("Bernini", "Roma - Italia", LocalDate.of(1598,12,07), LocalDate.of(1680,11,28));
		Artista a4=new Artista("Rodin", "París - Francia", LocalDate.of(1840,11,12), LocalDate.of(1917,11,17));
		
		Pintura p1=new Pintura("El sueño de la razón produce monstruos", 4444, a1, 1799, 20, 30, "Papel");
		Pintura p2=new Pintura("Saturno devorando a su hijo", 1111, a1, 1823, 83, 146, "Lienzo");
		Pintura p3=new Pintura("El sueño de la razón produce monstruos", 4444, a1, 1799, 20, 30, "Papel");
		Pintura p4=new Pintura("El sueño de la razón produce monstruos", 2222, a1, 1799, 20, 30, "Papel");
		Pintura p5=new Pintura("Guernica", 3333, a2, 1937, 777, 349, "Lienzo");
		
		Escultura e1=new Escultura("El Pensador", 5555, a4, 1904, "Bronce", 184);
		Escultura e2=new Escultura("El Rapto de Proserpina", 6666, a3, 1622, "Mármol", 295);
		
		
		/**
		 * Añadimos las obras anteriores
		 * */
		catalogo.addObra(p1);
		//System.out.println(catalogo.getCatalogo().get(p1.getNumInventario()).getAutor());
		catalogo.addObra(p2);
		catalogo.addObra(p5);
		catalogo.addObra(e1);
		catalogo.addObra(e2);
		
		//buscamos una obra en específico
		catalogo.buscarObra(6666);
		System.out.println();
		System.out.println();
		//Obtenemos la superficie de los cuadros del museo
		catalogo.obtenerSuperficie();
		System.out.println();
		System.out.println();
		//Hallamos la estatua más alta en nuestro museo
		catalogo.masAlta();
		
		System.out.println();
		System.out.println();
		//Eliminamos una obra...
		catalogo.eliminarObra(5555);
		System.out.println();
		//...y probamos a eliminarla de nuevo
		catalogo.eliminarObra(5555);
		
		System.out.println();
		//Añadimos una obra con un número de inventario repetido
		catalogo.addObra(p3);
		System.out.println();
		//Intentamos añadir una falsificación
		catalogo.addObra(p4);
		
		
	}

}
