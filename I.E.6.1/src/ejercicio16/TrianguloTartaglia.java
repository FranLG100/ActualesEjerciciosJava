package ejercicio16;

public class TrianguloTartaglia {
	  public static void main(String[] args) {
	    
	    int tamanho = 5;
		    for (int i = 0; i < tamanho; i++) {
		      for (int k = 0; k < tamanho - i; k++) {
		        System.out.print(" ");
		      }
		      for (int j = 0; j <= i; j++) {
		        System.out.print(Tartaglia(i, j) + " ");
		      }
		      System.out.println();
		    }
		  }


	  

	  /**
		 * Método público que realiza el triángulo de Tartaglia
		 *@param i Fila en la cual nos encontramos
		 *@param j Columna en la cual nos encontramos
		 * */
	  public static int Tartaglia(int i, int j) {
	    if (j == 0 || j == i) {
	      return 1;
	    } else {
	      return Tartaglia(i-1, j-1) + Tartaglia(i-1,j);
	    }
	  }
	}