package ejercicio15;

public class Fibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int limite=10;
		for (int i = 0; i < limite; i++) {
		System.out.print(serieFibonacci(i)+" ");
		}
		
	}
	
	/**
	 * Método público que realiza la serie de Fibonacci
	 * */
	public static int serieFibonacci(int n){

		if (n==0||n==1)
			return n;
		else {
		return serieFibonacci(n-1)+serieFibonacci(n-2);
		
		}

		} 

}
