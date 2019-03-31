package ej01;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import utilesFran.Amadeus;

public class ContarPalabras {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		Amadeus amadeus=new Amadeus();
		File archivo=amadeus.abrirArchivo("Ejercicio 1.txt");
		/*File archivo=amadeus.crearArchivo("Ejercicio 1.txt");
		amadeus.anexarArchivo(archivo, "Primera línea de prueba");
		amadeus.anexarArchivo(archivo, "Hola mundo");
		amadeus.anexarArchivo(archivo, "Tres tristes tigre tragan trigo en un trigal");*/
		ContarPalabras.cuentaPalabras(archivo);
		
	}
	
	public static void cuentaPalabras(File file) throws IOException {
		Amadeus amadeus=new Amadeus();
		ArrayList<String> lineas=new ArrayList<String>();
		ArrayList<String> palabras=new ArrayList<String>();
		int contador=0;
		BufferedReader lector = new BufferedReader(new FileReader(file));
		String linea=lector.readLine();
		
		while (linea!=null) {
			lineas.add(linea);
			linea=lector.readLine();
		}
		lector.close();
		for (String s : lineas) {
			palabras.addAll(Arrays.asList(s.split("\\s")));
		}
		
		System.out.println(palabras.size());
	}

}
