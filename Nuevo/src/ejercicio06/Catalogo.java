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
			System.out.println("Ese número de catálogo ya está incluido en nuestro catálogo");
			error=true;
		}
		else {
			if(obra instanceof Escultura) {
				for (Map.Entry<Integer, Obra> escultura : catalogo.entrySet()) {
					if(escultura instanceof Escultura) {
						if(((Escultura) escultura.getValue()).equalsEscultura((Escultura)obra)) {
							System.out.println("Ya tenemos una obra con esas características en nuestro museo.");
							System.out.println("¿Está intentando incluir una falsificación?");
							error=true;
						}
					}
				}
			}
			
			if(obra instanceof Pintura) {
				for (Map.Entry<Integer, Obra> pintura : catalogo.entrySet()) {
					if(pintura instanceof Pintura) {
						if(((Pintura) pintura.getValue()).equalsPintura((Pintura)obra)) {
							System.out.println("Ya tenemos una obra con esas características en nuestro museo.");
							System.out.println("¿Está intentando incluir una falsificación?");
							error=true;
						}
					}
				}
			}
		}
		if(!error) {
			System.out.println("La obra ha sido añadida con éxito");
			catalogo.put(obra.getNumInventario(), obra);
		}
		
	}
	
	public void eliminarObra(int num) {
		if(!catalogo.containsKey(num))
			System.out.println("Esa obra no existe en nuestro catálogo");
		else {
			catalogo.remove(num);
			System.out.println("Obra eliminada con éxito");
		}
			
	}
	
	public void buscarObra(int num) {
		if(!catalogo.containsKey(num))
			System.out.println("Esa obra no existe en nuestro catálogo");
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
		
		System.out.println("La escultura más alta del museo es la obra nº"+aux);
	}
	
}
