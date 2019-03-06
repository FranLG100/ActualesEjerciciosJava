package ejercicio02;

import java.io.IOException;
import java.util.ArrayList;

public class Test {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		
		/**
		 * Se ha creado una clase test para probar que funcionen los diferentes
		 * métodos de las clases, y hacer uso del polimorfismo.
		 * */
		
		ArrayList<Usuario> usuarios=new ArrayList<Usuario>();
		
		Usuario u=new Usuario("Fralg100", "fralg@gmail.com");
		Moderador m=new Moderador("Gharoom", "gharoom@gmail.com");
		Administrador a=new Administrador("Fran","falor@gmail.com");
		
		usuarios.add(u);
		usuarios.add(m);
		usuarios.add(a);
		
		for (Usuario usuario : usuarios) {
			//Para cada usuario, incrementamos el número de mensajes en dos
			//y borramos uno.
			usuario.incrementMsg();
			usuario.incrementMsg();
			usuario.decrementMsg();
			
			
			//A los administradores le incrementamos los baneos y le cambiamos el nick y el mail
			if(usuario instanceof Administrador) {
				((Administrador) usuario).incrementBans();
				((Administrador) usuario).incrementBans();
				usuario.modificaEmail("am@deus.com");
				usuario.setNick("Amadeus");
				System.out.println("\nTipo: Administrador"+usuario);
			}
			//A los moderadores le incrementamos un mensaje más y un mensaje borrado
			else if(usuario instanceof Moderador) {
				usuario.incrementMsg();
				((Moderador) usuario).incrementBin();
				System.out.println("\nTipo: Moderador"+usuario);
			} 
			//Los usuarios los dejamos tal y como están al principio del bucle
			else {
				System.out.println("\nTipo: Usuario"+usuario);
			}
		}
	}

}
