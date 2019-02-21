package ejercicio01;

public abstract class Cuenta {
	
	protected long numerocuenta;
	protected double saldo=0;
	protected Cliente cliente=new Cliente();
	
	public 	Cuenta(Cliente cliente, long numerocuenta) {
		this.cliente=cliente;
		this.numerocuenta=numerocuenta;
	}

	public void ingresarSaldo(double cantidad) {
		saldo+=cantidad;
	}
	
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
