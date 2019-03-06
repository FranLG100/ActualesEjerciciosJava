package ejercicio01;

public class CuentaCorriente extends Cuenta{

	//El interés será fijo durante todo el proceso.
	final private double interes=1.5;

	public CuentaCorriente(Cliente cliente, long numerocuenta) {
		super(cliente, numerocuenta);
		// TODO Auto-generated constructor stub
	}


	public void retirarSaldo(double cantidad) {
		saldo-=cantidad;
		
	}
	
	@Override
	public String toString() {
		return "\nNúmero de cuenta: "+numerocuenta+"\nCliente: "+cliente.getNombre()+" "+cliente.getApellidos()+"\nSaldo: "+saldo;
	}
	
	/**
	 * Método para actualizar el saldo de la cuenta
	 * */
	@Override
	public void actualizarSaldo() {
		saldo=saldo+(saldo*(interes/100));
	}

	
	
	
	
}
