package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import modelo.Empresa;
import utilesFran.Amadeus;
import vista.Vista;

public class Controlador implements ActionListener, MouseListener {

	private Vista vista;
	private Amadeus amadeus=new Amadeus();
	private Empresa empresa=new Empresa();
	
	boolean dptoValido;
	boolean apellidoValido;
	boolean salarioValido;
	boolean idValido;
	
	boolean error;
	
	public enum AccionMVC {
		__INSERTAR,__MODIFICAR,__CONSULTAR,__ELIMINAR,__CALCULAR
		}
	
	public Controlador(Vista vista) {
		this.vista = vista;
	}
	
	public void iniciar() throws IOException {
		// Skin tipo WINDOWS
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			SwingUtilities.updateComponentTreeUI(vista);
			vista.setVisible(true);
		} catch (UnsupportedLookAndFeelException ex) {
		} catch (ClassNotFoundException ex) {
		} catch (InstantiationException ex) {
		} catch (IllegalAccessException ex) {
		}

		// declara una acci√≥n y a√±ade un escucha al evento producido por el componente
		this.vista.btnInsertar.setActionCommand("__INSERTAR");
		this.vista.btnInsertar.addActionListener(this);
		
		this.vista.btnConsultar.setActionCommand("__CONSULTAR");
		this.vista.btnConsultar.addActionListener(this);
		
		this.vista.btnModificar.setActionCommand("__MODIFICAR");
		this.vista.btnModificar.addActionListener(this);
		
		this.vista.btnEliminar.setActionCommand("__ELIMINAR");
		this.vista.btnEliminar.addActionListener(this);
		
		this.vista.btnCalcular.setActionCommand("__CALCULAR");
		this.vista.btnCalcular.addActionListener(this);
		
		empresa.iniciarArchivo();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (AccionMVC.valueOf(e.getActionCommand())) {
		case __INSERTAR:
			try {
				dptoValido=amadeus.compruebaTextoVacio(this.vista.campoDepartamento.getText().toString());
				apellidoValido=amadeus.compruebaTextoVacio(this.vista.campoApellido.getText().toString());;
				salarioValido=amadeus.compruebaTextoVacio(this.vista.campoSalario.getText().toString());;
				idValido=amadeus.compruebaTextoVacio(this.vista.campoID.getText().toString());;
				
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			if(!dptoValido || !apellidoValido || !idValido || !salarioValido) {
				JOptionPane.showMessageDialog(null, "Hay campos vacÌos");
				error=true;
			}
			try {
				idValido=amadeus.controlaIntPositivoValido(Integer.parseInt(this.vista.campoID.getText()));
			} catch (NumberFormatException | IOException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, "Caracteres Inv·lidos en ID");
				error=true;
			}
			if(!idValido) {
				JOptionPane.showMessageDialog(null, "Introduzca un valor positivo de ID");
				error=true;
			}
			try {
				dptoValido=amadeus.controlaIntPositivoValido(Integer.parseInt(this.vista.campoDepartamento.getText()));
			} catch (NumberFormatException | IOException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, "Caracteres Inv·lidos en Departamento");
				error=true;
			}
			if(!dptoValido) {
				JOptionPane.showMessageDialog(null, "Introduzca un valor positivo de Departamento");
				error=true;
			}
			try {
				salarioValido=amadeus.controlaDoublePositivoValido(Double.parseDouble(this.vista.campoSalario.getText()));
			} catch (NumberFormatException | IOException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, "Caracteres Inv·lidos en el salario");
				e1.printStackTrace();
				error=true;
			}
			if(!salarioValido) {
				JOptionPane.showMessageDialog(null, "Introduzca un valor positivo de Salario");
				error=true;
			}
			if(empresa.comprobarExistencia(Integer.parseInt(this.vista.campoID.getText()))){
				JOptionPane.showMessageDialog(null, "Ya existe ese id, no puede insertarse");
				error=true;
			}
			if(!error) {
				try {
					empresa.insertarEmpleado(Integer.parseInt(this.vista.campoID.getText()), this.vista.campoApellido.getText().toString(), Integer.parseInt(this.vista.campoDepartamento.getText()), Double.parseDouble(this.vista.campoSalario.getText()));
					System.out.println("Empleado insertado");
					JOptionPane.showMessageDialog(null, "Registrado con exito");
					} catch (NumberFormatException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			error=false;
			break;
		case __ELIMINAR:
			try {
				idValido=amadeus.compruebaTextoVacio(this.vista.campoID.getText().toString());;
				
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			if(!idValido) {
				JOptionPane.showMessageDialog(null, "Introduzca un ID");
				error=true;
			}
			try {
				idValido=amadeus.controlaIntPositivoValido(Integer.parseInt(this.vista.campoID.getText()));
			} catch (NumberFormatException | IOException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, "Caracteres Inv·lidos en ID");
				error=true;
			}
			if(!idValido) {
				JOptionPane.showMessageDialog(null, "Introduzca un valor positivo de ID");
				error=true;
			}
			if(!empresa.comprobarExistencia(Integer.parseInt(this.vista.campoID.getText()))){
				JOptionPane.showMessageDialog(null, "ID inexistente");
				error=true;
			}
			if(!error) {
				try {
					empresa.eliminarEmpleado(Integer.parseInt(this.vista.campoID.getText()));
					System.out.println("Empleado insertado");
					JOptionPane.showMessageDialog(null, "Eliminacion exitosa");
					} catch (NumberFormatException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			error=false;
			break;
		case __CONSULTAR:
			try {
				idValido=amadeus.compruebaTextoVacio(this.vista.campoID.getText().toString());;
				
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			if(!idValido) {
				JOptionPane.showMessageDialog(null, "Introduzca un ID");
				error=true;
			}
			try {
				idValido=amadeus.controlaIntPositivoValido(Integer.parseInt(this.vista.campoID.getText()));
			} catch (NumberFormatException | IOException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, "Caracteres Inv·lidos en ID");
				error=true;
			}
			if(!idValido) {
				JOptionPane.showMessageDialog(null, "Introduzca un valor positivo de ID");
				error=true;
			}
			if(!empresa.comprobarExistencia(Integer.parseInt(this.vista.campoID.getText()))){
				JOptionPane.showMessageDialog(null, "ID inexistente");
				error=true;
			}
			if(!error) {
				try {
					String[] datos=empresa.consultarEmpleado(Integer.parseInt(this.vista.campoID.getText()));
					System.out.println("Empleado insertado");
					this.vista.consultaApellido.setText(datos[1]);
					this.vista.consultaDepartamento.setText(datos[2]);
					this.vista.consultaSalario.setText(datos[3]);
					} catch (NumberFormatException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			error=false;
			break;
		case __CALCULAR:
			try {
				idValido=amadeus.compruebaTextoVacio(this.vista.campoID.getText().toString());;
				salarioValido=amadeus.compruebaTextoVacio(this.vista.campoIncrementoSalario.getText().toString());;
				
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			if(!idValido || !salarioValido) {
				JOptionPane.showMessageDialog(null, "ID o Salario vacio");
				error=true;
			}
			try {
				idValido=amadeus.controlaIntPositivoValido(Integer.parseInt(this.vista.campoID.getText()));
			} catch (NumberFormatException | IOException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, "Caracteres Inv·lidos en ID");
				error=true;
			}
			if(!idValido) {
				JOptionPane.showMessageDialog(null, "Introduzca un valor positivo de ID");
				error=true;
			}
			if(!empresa.comprobarExistencia(Integer.parseInt(this.vista.campoID.getText()))){
				JOptionPane.showMessageDialog(null, "ID inexistente");
				error=true;
			}
			try {
				salarioValido=amadeus.controlaDoublePositivoValido(Double.parseDouble(this.vista.campoIncrementoSalario.getText()));
			} catch (NumberFormatException | IOException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, "Caracteres Inv·lidos en el salario");
				e1.printStackTrace();
				error=true;
			}
			if(!salarioValido) {
				JOptionPane.showMessageDialog(null, "Introduzca un valor positivo de Salario");
				error=true;
			}
			if(!error) {
				try {
					String[] datos=empresa.consultarEmpleado(Integer.parseInt(this.vista.campoID.getText()));
					this.vista.consultaApellido.setText(datos[1]);
					this.vista.consultaDepartamento.setText(datos[2]);
					this.vista.consultaSalario.setText(datos[3]);
					double nuevoSalario=Double.parseDouble(datos[3])+Double.parseDouble(this.vista.campoIncrementoSalario.getText());
					this.vista.consultaCalculoSalario.setText(Double.toString(nuevoSalario));
					} catch (NumberFormatException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			error=false;
			break;
		case __MODIFICAR:
			try {
				idValido=amadeus.compruebaTextoVacio(this.vista.campoID.getText().toString());;
				salarioValido=amadeus.compruebaTextoVacio(this.vista.campoIncrementoSalario.getText().toString());;
				
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			if(!idValido || !salarioValido) {
				JOptionPane.showMessageDialog(null, "ID o Salario vacio");
				error=true;
			}
			try {
				idValido=amadeus.controlaIntPositivoValido(Integer.parseInt(this.vista.campoID.getText()));
			} catch (NumberFormatException | IOException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, "Caracteres Inv·lidos en ID");
				error=true;
			}
			if(!idValido) {
				JOptionPane.showMessageDialog(null, "Introduzca un valor positivo de ID");
				error=true;
			}
			if(!empresa.comprobarExistencia(Integer.parseInt(this.vista.campoID.getText()))){
				JOptionPane.showMessageDialog(null, "ID inexistente");
				error=true;
			}
			try {
				salarioValido=amadeus.controlaDoublePositivoValido(Double.parseDouble(this.vista.campoIncrementoSalario.getText()));
			} catch (NumberFormatException | IOException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, "Caracteres Inv·lidos en el salario");
				e1.printStackTrace();
				error=true;
			}
			if(!salarioValido) {
				JOptionPane.showMessageDialog(null, "Introduzca un valor positivo de Salario");
				error=true;
			}
			if(!error) {
				try {
					String[] datos=empresa.consultarEmpleado(Integer.parseInt(this.vista.campoID.getText()));
					this.vista.consultaApellido.setText(datos[1]);
					this.vista.consultaDepartamento.setText(datos[2]);
					this.vista.consultaSalario.setText(datos[3]);
					double nuevoSalario=Double.parseDouble(datos[3])+Double.parseDouble(this.vista.campoIncrementoSalario.getText());
					this.vista.consultaCalculoSalario.setText(Double.toString(nuevoSalario));
					empresa.modificaSalario(Integer.parseInt(this.vista.campoID.getText()), nuevoSalario);
					JOptionPane.showMessageDialog(null, "Salario Actualizado");
					} catch (NumberFormatException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			error=false;
			break;
		}
	}
	
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
