package ejercicio02;

public class Moderador extends Usuario {

	private int deletedMsg=0;
	
	public Moderador(String nick, String email) {
		super(nick, email);
	}
	
	public void incrementBin() {
		deletedMsg++;
	}
	
	@Override
	public String toString() {
		return super.toString()+"\nMensajes borrados: "+deletedMsg;
	}
	
}
