package ejercicio01;

public class CuentaAhorro extends Cuenta {

	private double interes;
	private double saldoMinimo;
	
	/**
	 * Constructor de la clase CuentaAhorro
	 * @param interes Interés variable de la cuenta
	 * @param saldoMinimo Saldo mínimo de la cuenta ahorro. El saldo no podrá bajar de esa cantidad una vez se alcance
	 * */
	public CuentaAhorro(Cliente cliente, long numerocuenta, double interes, double saldoMinimo) {
		super(cliente, numerocuenta);
		this.interes=interes;
		this.saldoMinimo=saldoMinimo;
	}


	/**
	 * Método para retirar saldo de la cuenta. No puede retirarse dinero si la cantidad
	 * no llega al mínimo, o si sacando la cantidad, se bajase del mismo.
	 * @param cantidad Saldo a retirar
	 * */
	public void retirarSaldo(double cantidad) {
		if(saldo<saldoMinimo)
			System.out.println("No se puede retirar dicha cantidad, aún no hemos llegado a los "+saldoMinimo+"€");
		else if((saldo-cantidad)<saldoMinimo) 
			System.out.println("No se puede retirar dicha cantidad, bajaríamos de los "+saldoMinimo+"€");
		else
			saldo-=cantidad;
		
	}
	
	@Override
	public String toString() {
		return "\nNúmero de cuenta: "+numerocuenta+"\nCliente: "+cliente.getNombre()+" "+cliente.getApellidos()+"\nSaldo: "+saldo;
	}

	/**
	 * Método para actualizar la cantidad de dinero en la cuenta.
	 * */
	@Override
	public void actualizarSaldo() {
		saldo=saldo+(saldo*(interes/100));
	}

	public double getInteres() {
		return interes;
	}


	public void setInteres(double interes) {
		this.interes = interes;
	}
	
	
	
	
	
}
