package ejercicio06;

import java.util.Map;
import java.util.TreeMap;

public class Catalogo {

	private TreeMap<Integer,Obra> catalogo=new TreeMap<Integer,Obra>();
	private boolean error=false;
	
	public Catalogo() {}
	
	public void addObra(Obra obra) {
		error=false;
		if(catalogo.containsKey(obra.getNumInventario())) {
			System.out.println("Ese n�mero de cat�logo ya est� incluido en nuestro cat�logo");
			error=true;
		}
		else {
			if(obra instanceof Escultura) {
				for (Map.Entry<Integer, Obra> escultura : catalogo.entrySet()) {
					if(escultura instanceof Escultura) {
						if(((Escultura) escultura.getValue()).equalsEscultura((Escultura)obra)) {
							System.out.println("Ya tenemos una obra con esas caracter�sticas en nuestro museo.");
							System.out.println("�Est� intentando incluir una falsificaci�n?");
							error=true;
						}
					}
				}
			}
			
			if(obra instanceof Pintura) {
				for (Map.Entry<Integer, Obra> pintura : catalogo.entrySet()) {
					if(pintura instanceof Pintura) {
						if(((Pintura) pintura.getValue()).equalsPintura((Pintura)obra)) {
							System.out.println("Ya tenemos una obra con esas caracter�sticas en nuestro museo.");
							System.out.println("�Est� intentando incluir una falsificaci�n?");
							error=true;
						}
					}
				}
			}
		}
		if(!error) {
			System.out.println("La obra ha sido a�adida con �xito");
			catalogo.put(obra.getNumInventario(), obra);
		}
		
	}
	
	public void eliminarObra(int num) {
		if(!catalogo.containsKey(num))
			System.out.println("Esa obra no existe en nuestro cat�logo");
		else {
			catalogo.remove(num);
			System.out.println("Obra eliminada con �xito");
		}
			
	}
	
	public void buscarObra(int num) {
		if(!catalogo.containsKey(num))
			System.out.println("Esa obra no existe en nuestro cat�logo");
		else {
			System.out.println(catalogo.get(num));
		}
	}
	
	public void obtenerSuperficie() {
		int superficie=0;
		for (Map.Entry<Integer, Obra> pintura : catalogo.entrySet()) {
			if(pintura instanceof Pintura)
				superficie+=((((Pintura) pintura.getValue()).getAncho())*(((Pintura) pintura.getValue()).getAlto()));
		}
		
		System.out.println("La superficie total de las pinturas que alberga el museo es de "+((double)(superficie/10000))+"m2.");
	}
	
	public void masAlta() {
		int alt=0;
		int aux = 0;
		for (Map.Entry<Integer, Obra> escultura : catalogo.entrySet()) {
			if(escultura instanceof Escultura) {
				if(alt<((Escultura) escultura.getValue()).getAltura())
					aux=escultura.getKey();
			}
		}
		
		System.out.println("La escultura m�s alta del museo es la obra n�"+aux);
	}
	
}
