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

import modelo.Departamento;
import modelo.Empresa;
import utilesFran.Amadeus;
import vista.Vista;

public class Controlador implements ActionListener, MouseListener {

	private Vista vista;
	private Departamento dpto;
	private Empresa empresa=new Empresa();
	private Amadeus amadeus=new Amadeus();
	
	private boolean dptoValido;
	private boolean nombreValido;
	private boolean localidadValida;
	private boolean nDptoValido;
	
	private boolean error;
	
	public enum AccionMVC {
		__INSERTAR, __MODIFICAR, __ELIMINAR, __CONSULTAR}
	
	public Controlador(Vista vista) {
		this.vista = vista;
	}
	
	public void iniciar() throws ClassNotFoundException, IOException {
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

		// declara una acciÃ³n y aÃ±ade un escucha al evento producido por el componente
		//this.vista.btnLogin.setActionCommand("__LOGIN");
		//this.vista.btnLogin.addActionListener(this);
		
		this.vista.btnInsertar.setActionCommand("__INSERTAR");
		this.vista.btnInsertar.addActionListener(this);
		
		this.vista.btnModificar.setActionCommand("__MODIFICAR");
		this.vista.btnModificar.addActionListener(this);
		
		this.vista.btnConsultar.setActionCommand("__CONSULTAR");
		this.vista.btnConsultar.addActionListener(this);
		
		this.vista.btnEliminar.setActionCommand("__ELIMINAR");
		this.vista.btnEliminar.addActionListener(this);
		
		empresa.iniciarFichero();
		this.vista.dptosTotales.setText(empresa.contarEmpresas());
		this.vista.tablaDptos.setModel(empresa.llenarTabla());

	}

	/*@Override
	public void actionPerformed(ActionEvent e) {
		switch (AccionMVC.valueOf(e.getActionCommand())) {
		case __LOGIN:
			break;
		}
	}*/
	
	@Override
	public void actionPerformed(ActionEvent e) {
		switch (AccionMVC.valueOf(e.getActionCommand())) {
			case __INSERTAR:
				try {
					dptoValido=amadeus.compruebaTextoVacio(this.vista.campoDpto.getText().toString());
					nombreValido=amadeus.compruebaTextoVacio(this.vista.campoNombreDpto.getText().toString());;
					localidadValida=amadeus.compruebaTextoVacio(this.vista.campoLocalidadDpto.getText().toString());;
					
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				if(!dptoValido || !nombreValido || !localidadValida) {
					JOptionPane.showMessageDialog(null, "Hay campos vacíos");
					error=true;
				}
				try {
					nDptoValido=amadeus.controlaIntPositivoValido(Integer.parseInt(this.vista.campoDpto.getText()));
				} catch (NumberFormatException | IOException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Caracteres Inválidos");
					e1.printStackTrace();
					error=true;
				}
				if(!nDptoValido) {
					JOptionPane.showMessageDialog(null, "Introduzca un valor positivo de ID");
					error=true;
				}
				if(empresa.comprobarExistencia(Integer.parseInt(this.vista.campoDpto.getText()))){
					JOptionPane.showMessageDialog(null, "Ya existe ese id de departamento, no puede insertarse");
					error=true;
				}
				if(!error) {
					try {
						empresa.insertarDepartamento(Integer.parseInt(this.vista.campoDpto.getText()), this.vista.campoNombreDpto.getText().toString(), this.vista.campoLocalidadDpto.getText().toString());
						System.out.println("Departamento insertado");
						JOptionPane.showMessageDialog(null, "Registrado con exito");
						this.vista.dptosTotales.setText(empresa.contarEmpresas());
						this.vista.tablaDptos.setModel(empresa.llenarTabla());
					} catch (NumberFormatException | IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				error=false;
				break;
			case __CONSULTAR:
				try {
					dptoValido=amadeus.compruebaTextoVacio(this.vista.campoDpto.getText().toString());
					} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				if(!dptoValido) {
					JOptionPane.showMessageDialog(null, "Hay campos vacíos");
					error=true;
				}
				try {
					nDptoValido=amadeus.controlaIntPositivoValido(Integer.parseInt(this.vista.campoDpto.getText()));
				} catch (NumberFormatException | IOException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Caracteres Inválidos");
					e1.printStackTrace();
					error=true;
				}
				if(!empresa.comprobarExistencia(Integer.parseInt(this.vista.campoDpto.getText()))){
					JOptionPane.showMessageDialog(null, "No existe ese id de departamento");
					error=true;
				}
				if(!error) {
					String[] datos=empresa.consultarDepartamento(Integer.parseInt(this.vista.campoDpto.getText()));
					this.vista.nombreActual.setText(datos[0]);
					this.vista.localidadActual.setText(datos[1]);
				}
				error=false;
				break;
			case __MODIFICAR:
				try {
					dptoValido=amadeus.compruebaTextoVacio(this.vista.campoDpto.getText().toString());
					nombreValido=amadeus.compruebaTextoVacio(this.vista.campoNombreDpto.getText().toString());;
					localidadValida=amadeus.compruebaTextoVacio(this.vista.campoLocalidadDpto.getText().toString());;
					
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				if(!dptoValido || !nombreValido || !localidadValida) {
					JOptionPane.showMessageDialog(null, "Hay campos vacíos");
					error=true;
				}
				try {
					nDptoValido=amadeus.controlaIntPositivoValido(Integer.parseInt(this.vista.campoDpto.getText()));
				} catch (NumberFormatException | IOException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Caracteres Inválidos");
					e1.printStackTrace();
					error=true;
				}
				if(!empresa.comprobarExistencia(Integer.parseInt(this.vista.campoDpto.getText()))){
					JOptionPane.showMessageDialog(null, "No existe ese id de departamento");
					error=true;
				}
				if(!error) {
					try {
						empresa.insertarDepartamento(Integer.parseInt(this.vista.campoDpto.getText()), this.vista.campoNombreDpto.getText().toString(), this.vista.campoLocalidadDpto.getText().toString());
						System.out.println("Departamento modificado");
						JOptionPane.showMessageDialog(null, "Modificado con exito");
						this.vista.tablaDptos.setModel(empresa.llenarTabla());
						} catch (NumberFormatException | IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				error=false;
				break;
			case __ELIMINAR:
				try {
					dptoValido=amadeus.compruebaTextoVacio(this.vista.campoDpto.getText().toString());
					} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				if(!dptoValido) {
					JOptionPane.showMessageDialog(null, "Hay campos vacíos");
					error=true;
				}
				try {
					nDptoValido=amadeus.controlaIntPositivoValido(Integer.parseInt(this.vista.campoDpto.getText()));
				} catch (NumberFormatException | IOException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Caracteres Inválidos");
					e1.printStackTrace();
					error=true;
				}
				if(!empresa.comprobarExistencia(Integer.parseInt(this.vista.campoDpto.getText()))){
					JOptionPane.showMessageDialog(null, "No existe ese id de departamento");
					error=true;
				}
				if(!error) {
					try {
						empresa.borrarDepartamento(Integer.parseInt(this.vista.campoDpto.getText()));
						JOptionPane.showMessageDialog(null, "Eliminado con exito");
						this.vista.dptosTotales.setText(empresa.contarEmpresas());
						this.vista.tablaDptos.setModel(empresa.llenarTabla());
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
