package pruebatablas;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Date;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.table.DefaultTableModel;

import Persona.Persona;
import vista.*;
import pruebatablas.*;

public class Controlador implements ActionListener, MouseListener{
	
	public vista vista;
	public Persona p=new Persona();
	public ArrayList<Persona> personas=new ArrayList<Persona>();
	public FileInputStream fis;
	public FileOutputStream fos;
	public ObjectInputStream ois;
	public ObjectOutputStream oos;
	public String[] cabeceras = {"Nombre","Apellido"};
	
	
	public enum AccionMVC {
		__ADD,
		__REMOVE
		}
	
	public Controlador(vista vista) {
		this.vista=vista;
	}
	
	public void iniciar() throws IOException, ClassNotFoundException {
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

		this.vista.addBtn.setActionCommand("__ADD");
		this.vista.addBtn.addActionListener(this);
		
		//p=new Persona("Fran","Lorente");
		//personas.add(p);
		//fos=new FileOutputStream("personas.txt");
		//oos=new ObjectOutputStream(fos);
		//oos.writeObject(personas);
		//oos.close();
		//fos.close();
		
		fis=new FileInputStream("personas.txt");
		ois=new ObjectInputStream(fis);
		personas=(ArrayList<Persona>) ois.readObject();
		ois.close();
		fis.close();
		int filas=personas.size();
		String matriz[][]=new String[filas][2];
		int i=0;
		for (Persona persona : personas) {
			matriz[i][0]=persona.getNombre();
			matriz[i][1]=persona.getApellidos();
			i++;
		}
		DefaultTableModel plantilla = new DefaultTableModel();
		plantilla.setDataVector(matriz, cabeceras);
		this.vista.tablaPersona.setModel(plantilla);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		switch (AccionMVC.valueOf(e.getActionCommand())) {
		case __ADD:
				if(!this.vista.campoNombre.getText().isEmpty() && !this.vista.campoApellidos.getText().isEmpty()) {
					p=new Persona(this.vista.campoNombre.getText().toString(), this.vista.campoApellidos.getText().toString());
					personas.add(p);
					try {
						fos=new FileOutputStream("personas.txt");
						oos=new ObjectOutputStream(fos);
						oos.writeObject(personas);
						oos.close();
						fos.close();
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					int filas=personas.size();
					String matriz[][]=new String[filas][2];
					int i=0;
					for (Persona persona : personas) {
						matriz[i][0]=persona.getNombre();
						matriz[i][1]=persona.getApellidos();
						i++;
					}
					DefaultTableModel plantilla = new DefaultTableModel();
					plantilla.setDataVector(matriz, cabeceras);
					this.vista.tablaPersona.setModel(plantilla);
				}
				
			break;
		default:
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