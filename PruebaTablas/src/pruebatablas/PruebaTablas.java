/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebatablas;

import java.io.IOException;

import vista.vista;

/**
 *
 * @author Fran
 */
public class PruebaTablas {

    /**
     * @param args the command line arguments
     * @throws IOException 
     * @throws ClassNotFoundException 
     */
    public static void main(String[] args) throws ClassNotFoundException, IOException {
        // TODO code application logic here
    	new Controlador(new vista()).iniciar();
    }
    
}
