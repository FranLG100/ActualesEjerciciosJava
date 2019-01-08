package ejercicio09;

public class Capicua {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Número a comprobar
		int origen=21312;
		//Número que usaremos para comprobar
		int numeroFinal=0;
		//Convertimos el número a String, y a array de caracteres.
		char[] aux=Integer.toString(origen).toCharArray();
		//El comprobante, igual.
		char[] comprobante=Integer.toString(origen).toCharArray();
		boolean capicua=false;
		
		//Pasamos al comprobante el número al revés
		for (int i = 0; i < comprobante.length; i++) {
			comprobante[i]=aux[aux.length-i-1];
		}
		
		//Juntamos el número y lo pasamos a integer
		numeroFinal=Integer.parseInt(String.valueOf(comprobante));
		
		//Comprobamos si es o no capicúa
		if(numeroFinal==origen)
			System.out.println("El número es capicúa");
		else
			System.out.println("No lo es");
		
	}

}
