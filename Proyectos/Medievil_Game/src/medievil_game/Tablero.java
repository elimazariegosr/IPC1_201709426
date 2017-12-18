/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medievil_game;
import java.util.Scanner;
import javax.swing.*;
/**
 *
 * @author Mazariegos
 */
public class Tablero extends javax.swing.JFrame {
    JLabel lblDimX,lblDimY;
    JTextField txtDimX,txtDimY;
    JButton btnPosicion, btnIngresarDatos;
    Scanner opcion = new Scanner(System.in);
    
    public Tablero() {
    }
    public void mostrarTablero(int x, int y){
        
        setVisible(true);
        setSize(900,700);
        setLayout(null);
        System.out.println("Estoy aqui");
        
        JButton [][]tabMatrix= new JButton[y][x];
        for(int i=0;i<x;i++){
            for(int j=0;j<y;j++){
               System.out.println("Estoy aqui"+i*(600/x));

                btnPosicion=new JButton();
                btnPosicion.setText("P:"+j+","+i);
                btnPosicion.setBounds(i*(600/x),j*(600/y), 600/x, 600/y);
                getContentPane().add(btnPosicion);
                tabMatrix[j][i]=btnPosicion;
            }
        }
    }
    public void ingresarDatos(){
        setVisible(true);
        setSize(600,400);
        setLayout(null);
        
        lblDimX = new JLabel();
        lblDimX.setText("Ingrese Base");
        lblDimX.setBounds(10, 10, 120, 40);
        getContentPane().add(lblDimX);
       
        lblDimY = new JLabel();
        lblDimY.setText("Ingrese Altura");
        lblDimY.setBounds(100, 10, 120, 40);
        getContentPane().add(lblDimY);
        
        txtDimX = new JTextField();
        txtDimX.setBounds(10, 100, 100, 30);
        getContentPane().add(txtDimX);
        
        txtDimY = new JTextField();
        txtDimY.setBounds(150, 100, 100, 30);
        getContentPane().add(txtDimY);
        
        btnIngresarDatos = new JButton();
        btnIngresarDatos.setText("Ingresar datos");
        btnIngresarDatos.setBounds(200, 200, 170, 40);
        getContentPane().add(btnIngresarDatos);
        
        //Presionar Boton para enviar datos
         btnIngresarDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrarTablero(Integer.valueOf(txtDimX.getText()),
                        Integer.valueOf(txtDimY.getText()));
                lblDimX.setVisible(false);
                lblDimY.setVisible(false);
                txtDimX.setVisible(false);
                txtDimY.setVisible(false);
                btnIngresarDatos.setVisible(false);

            }
        });

       
    }
}
