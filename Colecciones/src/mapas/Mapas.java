package mapas;

import java.util.HashMap;
import java.util.Map;

import utilesFran.Amadeus;

public class Mapas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Amadeus amadeus=new Amadeus();
		HashMap<String,Persona> map=new HashMap<String,Persona>();
		Persona p=null;
		
		p = new Persona("28823344Q", "Francisco", "Lorente", 210);

		map.put(p.getDni(), p);

		p = new Persona("312421321r", "Juan", "Rodríguez", 110);

		map.put(p.getDni(), p);

		p = new Persona("426482431Q", "Pacheca", "Domínguez", 158);

		map.put(p.getDni(), p);
		
		for (Map.Entry<String, Persona> m: map.entrySet()) {
			
			String dni=m.getKey();
			Persona pe=m.getValue();
			
			System.out.println("DNI:"+dni+pe.toString()+"\n");
			
		}
		
		//Esta clave no existe, saldrá un resultado nulo
		System.out.println(map.get("28826344Q"));
	}

}
