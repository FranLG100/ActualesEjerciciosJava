package ejercicio01;

public class CuentaAhorro extends Cuenta {

	private double interes;
	private double saldoMinimo;
	
	
	public CuentaAhorro(Cliente cliente, long numerocuenta, double interes, double saldoMinimo) {
		super(cliente, numerocuenta);
		this.interes=interes;
		this.saldoMinimo=saldoMinimo;
	}


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
