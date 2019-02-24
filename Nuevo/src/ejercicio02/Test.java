package ejercicio02;

import java.io.IOException;
import java.util.ArrayList;

public class Test {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		ArrayList<Usuario> usuarios=new ArrayList<Usuario>();
		
		Usuario u=new Usuario("Fralg100", "fralg@gmail.com");
		Moderador m=new Moderador("Gharoom", "gharoom@gmail.com");
		Administrador a=new Administrador("Fran","falor@gmail.com");
		
		usuarios.add(u);
		usuarios.add(m);
		usuarios.add(a);
		
		for (Usuario usuario : usuarios) {
			usuario.incrementMsg();
			usuario.incrementMsg();
			usuario.decrementMsg();
			
			
			if(usuario instanceof Administrador) {
				((Administrador) usuario).incrementBans();
				((Administrador) usuario).incrementBans();
				usuario.modificaEmail("am@adeus.com");
				usuario.setNick("Amadeus");
				System.out.println("\nTipo: Administrador"+usuario);
			}else if(usuario instanceof Moderador) {
				usuario.incrementMsg();
				((Moderador) usuario).incrementBin();
				System.out.println("\nTipo: Moderador"+usuario);
			} else {
				System.out.println("\nTipo: Usuario"+usuario);
			}
		}
	}

}
