package ejercicio14;

public class Factorial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(CalculaFactorial(4));

	}
	
	public static int CalculaFactorial(int num) {

		if(num==0)
			return 1;
		else
		return num*CalculaFactorial(num-1);
	}

}
