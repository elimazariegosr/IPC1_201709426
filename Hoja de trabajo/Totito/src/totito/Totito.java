/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package totito;
import javax.swing.*;
/**
 *
 * @author Mazariegos
 */
public class Totito extends javax.swing.JFrame{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Tablero tablero = new Tablero();
        tablero.ingresarNombre();
    }
    
}
