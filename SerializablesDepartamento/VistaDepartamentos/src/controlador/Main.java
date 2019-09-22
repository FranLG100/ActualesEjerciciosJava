package controlador;

import java.io.IOException;

import vista.Vista;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		 new Controlador(new Vista()).iniciar();
	}

}
