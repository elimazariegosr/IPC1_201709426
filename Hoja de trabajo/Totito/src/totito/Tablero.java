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
public class Tablero extends javax.swing.JFrame {
    
    JButton btnTotito, btnEnviarNombre;
    JLabel lblJugador1, lblJugador2,nombre1,nombre2;
    JTextField txtJugador1, txtJugador2;
    protected static String nombreJugador1,nombreJugador2;
    
    JButton [][] matrixBtn = new JButton [3][3];

    public Tablero() {
    }
    
    public  void crearTablero(String jugador1, String jugador2){
        setVisible(true);
        setSize(600,400);
        setLayout(null);
        
        nombreJugador1=jugador1;
        nombreJugador2=jugador2;
        
        lblJugador1.setVisible(false);
        lblJugador2.setVisible(false);
        txtJugador1.setVisible(false);
        txtJugador2.setVisible(false);
        btnEnviarNombre.setVisible(false);
        
        nombre1 = new JLabel();
        nombre2 = new JLabel();
        
        nombre1.setText(jugador1+" "+"O");
        nombre2.setText(jugador2+" "+"X");
        
        nombre1.setBounds(360, 10, 120, 40);
        nombre2.setBounds(360, 120, 120, 100);
        
        getContentPane().add(nombre1);
         getContentPane().add(nombre2);
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                btnTotito = new JButton();
                btnTotito.setBounds(i*(300/3),j*(300/3), 300/3, 300/3);
                getContentPane().add(btnTotito);
                
                matrixBtn[j][i]=btnTotito;
                
            }
        }
         btnTotito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               System.out.println("Presionado");
            }
        });
         recorrerMatriz();
    }
    boolean estado;
    public void recorrerMatriz(){
        for(int i=0;i<matrixBtn.length;i++){
                
                matrixBtn[0][0].addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                       estadoJuego(0,0);
                    }
                });
                 matrixBtn[0][1].addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                       estadoJuego(0,1);
                      }
                });
                  matrixBtn[0][2].addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                       estadoJuego(0,2);
                    }
                });
                  matrixBtn[1][0].addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                       estadoJuego(1,0);
                    }
                });
                 matrixBtn[1][1].addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                       estadoJuego(1,1); 
                    }  
                });
                  matrixBtn[1][2].addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        estadoJuego(1,2);
                    }    
                });
                  matrixBtn[2][0].addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        estadoJuego(2,0); 
                        System.out.println("PRESIONADO 2, 0");
                    }
                });
                 matrixBtn[2][1].addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        estadoJuego(2,1);    
                    }
                });
                  matrixBtn[2][2].addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                            estadoJuego(2,2);
                        }
                });
            }   
            
    }
    public void estadoJuego(int x, int y){
       
        if(estado==true ){
            matrixBtn[x][y].setText("O");
            estado=false;
            verificarGanador();
        }else if(estado==false){
            matrixBtn[x][y].setText("X");
            estado=true;
            verificarGanador();
        }
    }
    public void verificarGanador(){
        //vertical
        if(matrixBtn[0][0].getText()=="O" && matrixBtn[1][0].getText()=="O"
                && matrixBtn[2][0].getText()=="O"){
                JOptionPane.showMessageDialog(null, "HA GANDO "+nombreJugador1);
                resetJuego();
        }else if(matrixBtn[0][0].getText()=="X" && matrixBtn[1][0].getText()=="X"
                && matrixBtn[2][0].getText()=="X"){
                JOptionPane.showMessageDialog(null, "HA GANDO "+nombreJugador2);
                resetJuego();
                
                
        }else if(matrixBtn[0][1].getText()=="O" && matrixBtn[1][1].getText()=="O"
                && matrixBtn[2][1].getText()=="O"){
                JOptionPane.showMessageDialog(null, "HA GANDO "+nombreJugador1);
                resetJuego();
                
        }else if(matrixBtn[0][1].getText()=="X" && matrixBtn[1][1].getText()=="X"
                && matrixBtn[2][1].getText()=="X"){
                JOptionPane.showMessageDialog(null, "HA GANDO "+nombreJugador2);
                resetJuego();
                
        }else if(matrixBtn[0][2].getText()=="O" && matrixBtn[1][2].getText()=="O"
                && matrixBtn[2][2].getText()=="O"){
                JOptionPane.showMessageDialog(null, "HA GANDO "+nombreJugador1);
                resetJuego();
        }else if(matrixBtn[0][2].getText()=="X" && matrixBtn[1][2].getText()=="X"
                && matrixBtn[2][2].getText()=="X"){
                JOptionPane.showMessageDialog(null, "HA GANDO "+nombreJugador2);
                resetJuego();
                
        //horizontal        
        }else if(matrixBtn[0][0].getText()=="O" && matrixBtn[0][1].getText()=="O"
                && matrixBtn[0][2].getText()=="O"){
                JOptionPane.showMessageDialog(null, "HA GANDO "+nombreJugador1);
                resetJuego();
                
        }else if(matrixBtn[0][0].getText()=="X" && matrixBtn[0][1].getText()=="X"
                && matrixBtn[0][2].getText()=="X"){
                JOptionPane.showMessageDialog(null, "HA GANDO "+nombreJugador2);
                resetJuego();
        }
        
        else if(matrixBtn[1][0].getText()=="O" && matrixBtn[1][1].getText()=="O"
                && matrixBtn[1][2].getText()=="O"){
                JOptionPane.showMessageDialog(null, "HA GANDO "+nombreJugador1);
                resetJuego();
        }else if(matrixBtn[1][0].getText()=="X" && matrixBtn[1][1].getText()=="X"
                && matrixBtn[1][2].getText()=="X"){
                JOptionPane.showMessageDialog(null, "HA GANDO "+nombreJugador2);
                resetJuego();
        }
        else if(matrixBtn[2][0].getText()=="O" && matrixBtn[2][1].getText()=="O"
                && matrixBtn[2][2].getText()=="O"){
                JOptionPane.showMessageDialog(null, "HA GANDO "+nombreJugador1);
                resetJuego();
        }else if(matrixBtn[2][0].getText()=="X" && matrixBtn[2][1].getText()=="X"
                && matrixBtn[2][2].getText()=="X"){
                JOptionPane.showMessageDialog(null, "HA GANDO "+nombreJugador2);
                resetJuego();
                
        }
    }
    
    public void ingresarNombre(){
        setVisible(true);
        setSize(600,400);
        setLayout(null);
        
        lblJugador1 = new JLabel();
        lblJugador2 = new JLabel();
        txtJugador1 = new JTextField();
        txtJugador2 = new JTextField();
        btnEnviarNombre = new JButton();
        
        lblJugador1.setText("Jugador 1");
        lblJugador2.setText("Jugador 2");
        btnEnviarNombre.setText("Enviar Nombres");
        
        
        lblJugador1.setBounds(10, 10, 120, 40);
        lblJugador2.setBounds(110, 10, 120, 40);
        
        txtJugador1.setBounds(10, 100, 100, 30);
        txtJugador2.setBounds(110, 100, 100, 30);

        btnEnviarNombre.setBounds(200, 200, 170, 40);
        getContentPane().add(lblJugador1);
        getContentPane().add(lblJugador2);
        getContentPane().add(txtJugador1);
        getContentPane().add(txtJugador2);
        getContentPane().add(btnEnviarNombre);
        
        //Presionar Boton para enviar datos
         btnEnviarNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearTablero(txtJugador1.getText(),txtJugador2.getText());
            }
        });

       
 
 
 
    }
    public void resetJuego(){
        for(int i=0;i<matrixBtn.length;i++){
            for(int j=0;j<matrixBtn.length;j++){
                
                matrixBtn[j][i].setText("");
                
            }
        }
    }
}
