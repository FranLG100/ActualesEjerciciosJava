package ejercicio02;

public class Administrador extends Usuario {

	private int deletedMsg=0; //Mensajes eliminados
	private int bans=0; //Usuarios baneados
	
	public Administrador(String nick, String email) {
		super(nick, email);
	}
	
	/**
	 * Método que incrementa el número de mensajes borrados
	 * */
	public void incrementBin() {
		deletedMsg++;
	}
	
	/**
	 * Método que incrementa el número de baneos de usuarios
	 * */
	public void incrementBans() {
		bans++;
	}
	
	/**
	 * Método que permite cambiar el propio nick
	 * */
	public void changeNick(String nick) {
		this.setNick(nick);
	}
	
	@Override
	public String toString() {
		return super.toString()+"\nMensajes borrados: "+deletedMsg+"\nUsuarios baneados: "+bans;
	}
	
}
