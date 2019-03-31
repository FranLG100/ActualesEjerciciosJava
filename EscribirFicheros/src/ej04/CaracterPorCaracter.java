package ej04;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FilterInputStream;
import java.io.IOException;

import utilesFran.Amadeus;


public class CaracterPorCaracter {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		Amadeus amadeus=new Amadeus();
		File f=amadeus.abrirArchivo("Creado con txt.txt");
		amadeus.leerArchivo(f);
		CaracterPorCaracter.leerCaracterPorCaracter(f);
	}
	
	public static void leerCaracterPorCaracter(File f) throws IOException {
		BufferedReader lector = new BufferedReader(new FileReader(f));
		char c=(char) lector.read();
		while(c!=(char)(-1)) {
			System.out.println(c);
			c=(char) lector.read();
		}
		lector.close();
	}

}
