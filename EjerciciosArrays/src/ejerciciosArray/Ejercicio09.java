package ejerciciosArray;

public class Ejercicio09 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arrayA= {0,1,2,3,4,5,6,7,8};
		int[] arrayB= {6,7,8};
		//Comentar el anterior y descomentar este para probar el caso en el que no.
		//int[] arrayB= {6,7,8,9};
		int k=0;
		boolean contenido=false;
		
		for (int i = 0; i < arrayA.length; i++) {
			while(arrayB[k]==arrayA[i]) {
				k++;
				i++;
				if(arrayB[k]==arrayB[arrayB.length-1] && arrayB[arrayB.length-1]==arrayA[i]) {
					System.out.println("B está contenido en A");
					contenido=true;
					break;
				}
				if(i==arrayA.length-1)
					break;
			}
			k=0;
		}
		
		if(!contenido)
			System.out.println("B NO está contenido en A");

	}

}
