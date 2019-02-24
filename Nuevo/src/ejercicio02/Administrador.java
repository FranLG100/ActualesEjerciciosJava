package ejercicio02;

public class Administrador extends Usuario {

	private int deletedMsg=0;
	private int bans=0;
	
	public Administrador(String nick, String email) {
		super(nick, email);
	}
	
	public void incrementBin() {
		deletedMsg++;
	}
	
	public void incrementBans() {
		bans++;
	}
	
	public void changeNick(String nick) {
		this.setNick(nick);
	}
	
	@Override
	public String toString() {
		return super.toString()+"\nMensajes borrados: "+deletedMsg+"\nUsuarios baneados: "+bans;
	}
	
}
