package ejercicio09;

public class Capicua {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int origen=21312;
		int numeroFinal=0;
		char[] aux=Integer.toString(origen).toCharArray();
		char[] comprobante=Integer.toString(origen).toCharArray();
		boolean capicua=false;
		
		for (int i = 0; i < comprobante.length; i++) {
			comprobante[i]=aux[aux.length-i-1];
		}
		
		numeroFinal=Integer.parseInt(String.valueOf(comprobante));
		
		if(numeroFinal==origen)
			System.out.println("El número es capicúa");
		else
			System.out.println("No lo es");
		
	}

}
