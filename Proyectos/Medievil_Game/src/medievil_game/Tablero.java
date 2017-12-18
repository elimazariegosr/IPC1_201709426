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
    JLabel lblDimX,lblDimY,lblPosicion;
    JTextField txtDimX,txtDimY;
    JButton  btnIngresarDatos;
    Scanner opcion = new Scanner(System.in);
    JLabel [][]tabMatrix;
    public Tablero() {
    }
    public void mostrarTablero(int x, int y){
        
        setVisible(true);
        setSize(900,700);
        setLayout(null);
        System.out.println("Estoy aqui");
        
        tabMatrix= new JLabel[y][x];
        for(int i=0;i<x;i++){
            for(int j=0;j<y;j++){
               System.out.println("Estoy aqui"+i*(600/x));

                lblPosicion=new JLabel();
                lblPosicion.setText("P:"+j+","+i);
                lblPosicion.setBorder(javax.swing.BorderFactory.
                        createLineBorder(new java.awt.Color(0, 0, 0)));

                lblPosicion.setBounds((i*(600/x))+25,(j*(600/y))+25, 600/x, 600/y);
                getContentPane().add(lblPosicion);
                tabMatrix[j][i]=lblPosicion;
                
            }
        }
        ingresarVidasRandom(x);
        ingresarMinasRandom(x);
        
    }
    public void ingresarDatos(){
        setVisible(true);
        setSize(600,400);
        setLayout(null);
        
        lblDimX = new JLabel();
        lblDimX.setText("Ingrese Base");
        lblDimX.setBounds(10, 10, 120, 40);
       
        lblDimY = new JLabel();
        lblDimY.setText("Ingrese Altura");
        lblDimY.setBounds(110, 10, 120, 40);
        
        txtDimX = new JTextField();
        txtDimX.setBounds(10, 100, 100, 30);
        
        txtDimY = new JTextField();
        txtDimY.setBounds(110, 100, 100, 30);
        
        btnIngresarDatos = new JButton();
        btnIngresarDatos.setText("Ingresar datos");
        btnIngresarDatos.setBounds(200, 200, 170, 40);
        getContentPane().add(btnIngresarDatos);
        getContentPane().add(txtDimY);
        getContentPane().add(txtDimX);
        getContentPane().add(lblDimY);
        getContentPane().add(lblDimX);
        
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
    
    public void ingresarVidasRandom(int valor){
        
        valor *=valor;
        valor*=0.05;
        int randomX;
        int randomY;
        for(int i=0; i<valor;i++){
            randomX=(int)(Math.random()*valor+1);
            randomY=(int)(Math.random()*valor+2);
      
            System.out.println("Numero"+randomX);
          if(randomX>18 && randomY>18 && randomX<7 && randomY<7){
                
            }else{
                tabMatrix[randomX][randomY].setText("<3");
            } 
           }
    }
    public void ingresarMinasRandom(int valor){
        
        
        int numero =valor * valor;
        numero*=0.10;
        int randomX;
        int randomY;
        for(int i=0; i<valor;i++){
            randomX=(int)(Math.random()*valor+1);
            randomY=(int)(Math.random()*valor+2);
      
            if(randomX<valor && randomY <valor){
                System.out.println("Numero Minas"+randomX);
                tabMatrix[randomX][randomY].setText("Q");
            }else{
                    
            } 
        }
    }
    
}
