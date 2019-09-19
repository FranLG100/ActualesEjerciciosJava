package serializable;

import java.io.IOException;
import java.io.Serializable;

public class Main implements Serializable{

	public static void main(String[] args) throws ClassNotFoundException, IOException {
		// TODO Auto-generated method stub

		Empresa empresa=new Empresa();
		empresa.iniciarFichero();
		empresa.insertarDepartamento();
		empresa.contarEmpresas();
		empresa.escribirFichero();
	}

}
