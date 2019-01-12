package ejercicio14;

public class Factorial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(CalculaFactorial(4));

	}
	
	/**
	 * Método estático que calcula el factorial de un número
	 * @param num Número entero del cual queremos conocer el factorial
	 * @return Factorial del número, calculado con este método recursivo
	 * */
	public static int CalculaFactorial(int num) {

		if(num==0) 
			return 1;
		else
		return num*CalculaFactorial(num-1); //Devuelve el número y el propio método llamándose con la misma  variable -1.
	}

}
