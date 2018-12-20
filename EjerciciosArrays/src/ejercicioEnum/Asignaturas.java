package ejercicioEnum;

public enum Asignaturas {
	MATEMATICAS(6),
	LENGUAJE(8),
	SOCIALES(9), 
	PLASTICA(6),
	BIOLOGIA(5);
	
	private int nota;
	
	Asignaturas(int nota){
		this.nota=nota;
	}
	
	public void setNota(int nota) {
		this.nota=nota;
	}
	
	public int getNota() {
		return nota;
	}

}
