package ejercicio01;

public class CuentaCorriente extends Cuenta{

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
		return "\nN�mero de cuenta: "+numerocuenta+"\nCliente: "+cliente.getNombre()+" "+cliente.getApellidos()+"\nSaldo: "+saldo;
	}
	
	@Override
	public void actualizarSaldo() {
		saldo=saldo+(saldo*(interes/100));
	}

	
	
	
	
}
