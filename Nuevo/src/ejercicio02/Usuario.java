package ejercicio02;

import java.io.IOException;

import utilesFran.Amadeus;

public class Usuario {
	
	private int mensajes;
	private String email;
	private String nick;
	protected Amadeus amadeus=new Amadeus();
	
	public Usuario() {
		
	}
	
	public Usuario(String nick, String email) {
		this.nick=nick;
		this.email=email;
	}
	
	/**
	 * Método que incrementa el número de mensajes
	 * */
	public void incrementMsg() {
		mensajes++;
	}
	
	/**
	 * Método que decrementa el número de mensajes
	 * */
	public void decrementMsg() {
		if(mensajes==0)
			System.out.println("Se ha llegado al mínimo de mensajes");
		else
			mensajes--;
	}
	
	public void modificaEmail(String email) throws IOException {
		this.email=email;
	}
	
	@Override
	public String toString() {
		return "\nNick: "+nick+"\nEmail: "+email+"\nMensajes publicados: "+mensajes;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}
	
	
	
	

}
