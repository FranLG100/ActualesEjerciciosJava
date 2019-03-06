package ejercicio01;

public abstract class Cuenta {
	
	protected long numerocuenta;
	protected double saldo=0;
	protected Cliente cliente=new Cliente();
	
	/**
	 * Constructor público de cliente
	 * @param cliente Cliente al cual le pertenece la cuenta
	 * @param numerocuenta Número de la cuenta
	 * */
	public 	Cuenta(Cliente cliente, long numerocuenta) {
		this.cliente=cliente;
		this.numerocuenta=numerocuenta;
	}

	/**
	 * Método para ingresar saldo en la cuenta
	 * @param cantidad Cantidad de dinero a ingresar en la cuenta
	 * */
	public void ingresarSaldo(double cantidad) {
		saldo+=cantidad;
	}
	
	/**
	 * Método para retirar saldo de la cuenta
	 * @param cantidad Cantidad de dinero a ingresar en la cuenta
	 * */
	public abstract void retirarSaldo(double cantidad); 
	
	
	public void actualizarSaldo() {
		
	}
	
	public long getNumerocuenta() {
		return numerocuenta;
	}


	public double getSaldo() {
		return saldo;
	}


	public Cliente getCliente() {
		return cliente;
	}

	

}
