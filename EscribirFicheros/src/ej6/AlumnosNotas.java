package ej6;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import utilesFran.Amadeus;

public class AlumnosNotas {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		Amadeus amadeus=new Amadeus();
		File f=amadeus.abrirArchivo("Notas.txt");
		AlumnosNotas.alumnosNotas(f);
	}
	
	public static void alumnosNotas(File f) throws IOException {
		BufferedReader lector=new BufferedReader(new FileReader(f));
		ArrayList<String> lineas=new ArrayList<String>();
		String linea=lector.readLine();
		while (linea!=null) {
			StringTokenizer token;
			token=new StringTokenizer(linea,",");
			String apellidos = null, nombre = null, media = null;
			while (token.hasMoreTokens()) {
				apellidos=token.nextToken().trim();
				nombre=token.nextToken().trim();
				media=token.nextToken().trim();
			}
			int aux=Integer.parseInt(media);
			if(aux>5) {
				System.out.println("Alumno: "+nombre+" "+apellidos+"  Media: "+aux);
				linea=lector.readLine();
			}else
				linea=lector.readLine();
		}
	}

}
