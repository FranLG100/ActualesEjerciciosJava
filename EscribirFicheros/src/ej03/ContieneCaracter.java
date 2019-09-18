package ej03;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import utilesFran.Amadeus;

public class ContieneCaracter {

	public static void main(String[] args) throws IOException {

		Amadeus amadeus=new Amadeus();
		File f=amadeus.abrirArchivo("Ejercicio 1.txt");
		ContieneCaracter.contieneCaracter('t', f);
	}
	
	public static void contieneCaracter(char c, File f) throws IOException {
		BufferedReader lector = new BufferedReader(new FileReader(f));
		String linea=lector.readLine();
		
		while (linea!=null) {
			char[] aux=linea.toCharArray();
			boolean contiene=false;
			for (int i = 0; i < aux.length; i++) {
				if(linea.charAt(i)==c) {
					contiene=true;
					break;
				}
			}
			if(contiene) {
				System.out.println(linea);
				linea=lector.readLine();
				}
			else
				linea=lector.readLine();
		}
		lector.close();
	}

}
