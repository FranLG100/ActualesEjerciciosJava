package ejercicio02;

public class Moderador extends Usuario {

	private int deletedMsg=0; //mensajes eliminados
	
	public Moderador(String nick, String email) {
		super(nick, email);
	}
	
	/**
	 * Método que incrementa el número de mensajes borrados
	 * */
	public void incrementBin() {
		deletedMsg++;
	}
	
	@Override
	public String toString() {
		return super.toString()+"\nMensajes borrados: "+deletedMsg;
	}
	
}
