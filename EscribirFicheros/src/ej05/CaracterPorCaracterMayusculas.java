package ej05;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import utilesFran.Amadeus;

public class CaracterPorCaracterMayusculas {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		Amadeus amadeus=new Amadeus();
		File f=amadeus.abrirArchivo("Creado con txt.txt");
		CaracterPorCaracterMayusculas.leerCaracterPorCaracterMayusculas(f);
		
	}

	public static void leerCaracterPorCaracterMayusculas(File f) throws IOException {
		BufferedReader lector = new BufferedReader(new FileReader(f));
		char c=(char) lector.read();
		while(c!=(char)(-1)) {
			if (Character.isDigit(c))
				c=(char) lector.read();
			else {
				if(Character.isLowerCase(c))
					c=Character.toUpperCase(c);
			System.out.println(c);
			c=(char) lector.read();
			}
		}
		lector.close();
	}
}
