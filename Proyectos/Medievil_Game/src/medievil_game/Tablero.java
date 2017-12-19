/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medievil_game;
import java.awt.*;
import java.util.Scanner;
import javax.swing.*;
/**
 *
 * @author Mazariegos
 */
public class Tablero extends javax.swing.JFrame {
    JLabel lblDimX,lblDimY,lblPosicion,lblImagen,lblOrden,
            lblNombre1,lblNombre2,lblImagenMago1,
            lblImagenPrincesa1,lblImagenGuerrero1,lblImagenMago2,
            lblImagenPrincesa2,lblImagenGuerrero2;
    
    JTextField txtDimX,txtDimY,txtNombre1,txtNombre2;
    JButton  btnIngresarDatos,btnOrden;
    Scanner opcion = new Scanner(System.in);
    JLabel [][]tabMatrix;
    JLabel [] arregloLblOrden;
    JButton [] arregloBtnOrden;
    
    //obtener las imagenes respectivas
    ImageIcon imagenMago1 = new ImageIcon(getClass().
            getResource("/medievil_game/Imagenes/mago.png"));
            ImageIcon imagenGuerrero1 = new ImageIcon(getClass().
            getResource("/medievil_game/Imagenes/guerrero.png"));
            ImageIcon imagenPrincesa1 = new ImageIcon(getClass().
            getResource("/medievil_game/Imagenes/princesa.png"));
         
            ImageIcon iconoMago1 = new ImageIcon(imagenMago1.getImage().
                        getScaledInstance(75,75,Image.SCALE_DEFAULT));
            ImageIcon iconoGuerrero1 = new ImageIcon(imagenGuerrero1.getImage().
                        getScaledInstance(75,75,Image.SCALE_DEFAULT));
            ImageIcon iconoPrincesa1 = new ImageIcon(imagenPrincesa1.getImage().
                        getScaledInstance(75,75,Image.SCALE_DEFAULT));
            
    public Tablero() {
    }
    public void mostrarTablero(int x, int y){
         
        setVisible(true);
        setSize(900,700);
        setLayout(null);
        
        System.out.println("Estoy aqui");
        lblImagen = new JLabel();
        lblImagen.setBounds(20, 20, 610, 610);
        ImageIcon imagen = new ImageIcon(getClass().
                getResource("/medievil_game/Imagenes/mapa.jpg"));
        ImageIcon icono = new ImageIcon(imagen.getImage().
                getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(),
                        Image.SCALE_DEFAULT));
        lblImagen.setIcon(icono);
        lblImagen.setOpaque(true);
        tabMatrix= new JLabel[y][x];
        for(int i=0;i<x;i++){
            for(int j=0;j<y;j++){
               System.out.println("Estoy aqui"+i*(600/x));

                lblPosicion=new JLabel();
                //lblPosicion.setText("P:"+j+","+i);
                lblPosicion.setBorder(javax.swing.BorderFactory.
                createLineBorder(new java.awt.Color(0, 0, 0)));

                lblPosicion.setBounds((i*(600/x))+25,(j*(600/y))+25, 600/x, 600/y);
                getContentPane().add(lblPosicion);
                tabMatrix[j][i]=lblPosicion;
            }
        }
        ingresarVidasRandom(x);
        ingresarMinasRandom(x);
        getContentPane().add(lblImagen);

    }
   //mandar los datos al tablero
    public void ingresarDatos(){
        setVisible(true);
        setSize(800,400);
        setLayout(null);
        formulario();
        
        //Presionar Boton para enviar datos
         btnIngresarDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrarTablero(Integer.valueOf(txtDimX.getText()),
                        Integer.valueOf(txtDimY.getText()));
                invisible();
            }
        });

       
    }
    // cambiar de vista
    public void invisible(){
                lblDimX.setVisible(false);
                lblDimY.setVisible(false);
                txtDimX.setVisible(false);
                txtDimY.setVisible(false);
                btnIngresarDatos.setVisible(false);
                for(int i=0;i<6;i++){
                    arregloBtnOrden[i].setVisible(false);
                    arregloLblOrden[i].setVisible(false);
                }

    }
    //ingresar vidas random
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
                ImageIcon imagen = new ImageIcon(getClass().
                getResource("/medievil_game/Imagenes/vida.png"));
                ImageIcon icono = new ImageIcon(imagen.getImage().
                getScaledInstance(tabMatrix[randomX][randomY].getWidth()-25
                        , tabMatrix[randomX][randomY].getHeight()-25,
                    Image.SCALE_DEFAULT));
                
                tabMatrix[randomX][randomY].setIcon(icono);
            } 
           }
    }
    //ingresar minas random
    public void ingresarMinasRandom(int valor){
        
        
        int numero =valor * valor;
        numero*=0.10;
        int randomX;
        int randomY;
        for(int i=0; i<valor;i++){
            randomX=(int)(Math.random()*valor);
            randomY=(int)(Math.random()*valor);
      
            if(randomX<valor && randomY <valor){
                System.out.println("Numero Minas"+randomX);
                ImageIcon imagen = new ImageIcon(getClass().
                getResource("/medievil_game/Imagenes/bomba.png"));
                ImageIcon icono = new ImageIcon(imagen.getImage().
                getScaledInstance(tabMatrix[randomX][randomY].getWidth()-25
                        , tabMatrix[randomX][randomY].getHeight()-25,
                    Image.SCALE_DEFAULT));
                
                tabMatrix[randomX][randomY].setIcon(icono);
            }else{
                    
            } 
        }
    }
    //formulario principal
    public void formulario(){
     
        lblDimX = new JLabel();
        lblDimX.setText("Ingrese Base");
        lblDimX.setBounds(550, 100, 120, 40);
       
        lblDimY = new JLabel();
        lblDimY.setText("Ingrese Altura");
        lblDimY.setBounds(650, 100, 120, 40);
        
       
        txtDimX = new JTextField();
        txtDimX.setBounds(550, 150, 100, 30);
        
        txtDimY = new JTextField();
        txtDimY.setBounds(650, 150, 100, 30);
        
        btnIngresarDatos = new JButton();
        btnIngresarDatos.setText("Ingresar datos");
        btnIngresarDatos.setBounds(600, 300, 170, 40);
       
        arregloLblOrden = new JLabel[6];
        arregloBtnOrden = new JButton[6];
        for(int i=0;i<3;i++){
            lblOrden = new JLabel();
            //lblOrden.setText("J1- P"+String.valueOf(i));
            lblOrden.setBounds(i*(600/8)+25, 10, 75, 75);
             getContentPane().add(lblOrden);
            lblOrden.setBorder(javax.swing.BorderFactory.
                        createLineBorder(new java.awt.Color(0, 0, 0)));
            System.out.println("numero"+i);            
            arregloLblOrden[i]=lblOrden;
            
        }for(int i=3;i<6;i++){
            lblOrden = new JLabel();
          //  lblOrden.setText("J2- P"+String.valueOf(i));
            lblOrden.setBounds(20+(i*(600/8)+25), 10, 75, 75);
             getContentPane().add(lblOrden);
            lblOrden.setBorder(javax.swing.BorderFactory.
                        createLineBorder(new java.awt.Color(0, 0, 0)));
            System.out.println("numero"+i);            
            arregloLblOrden[i]=lblOrden;
            
        }
        
        for(int i=0;i<3;i++){
            btnOrden = new JButton();
            btnOrden.setText("J1- P"+String.valueOf(i));
            btnOrden.setBounds(i*(600/8)+25, 90, 75, 75);
             getContentPane().add(btnOrden);
            btnOrden.setBorder(javax.swing.BorderFactory.
                        createLineBorder(new java.awt.Color(0, 0, 0)));
            System.out.println("numero"+i);            
            arregloBtnOrden[i]=btnOrden;
            
        }for(int i=3;i<6;i++){
            btnOrden = new JButton();
            btnOrden.setText("J2- P"+String.valueOf(i));
            btnOrden.setBounds(20+(i*(600/8)+25), 90, 75, 75);
             getContentPane().add(btnOrden);
            btnOrden.setBorder(javax.swing.BorderFactory.
                        createLineBorder(new java.awt.Color(0, 0, 0)));
            System.out.println("numero"+i);            
            arregloBtnOrden[i]=btnOrden;
            
        }
        getContentPane().add(btnIngresarDatos);
        getContentPane().add(txtDimY);
        getContentPane().add(txtDimX);
        getContentPane().add(lblDimY);
        getContentPane().add(lblDimX);
        mandarOrden();
    }
    //Elegir orden de personajes
    public void mandarOrden(){
          arregloBtnOrden[0].addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                   validacionPosicionJ1("M1");
                }
            });
            arregloBtnOrden[1].addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                  validacionPosicionJ1("G1");
                }
            });
            arregloBtnOrden[2].addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    validacionPosicionJ1("P1");
                }
            });
            
            arregloBtnOrden[3].addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    validacionPosicionJ2("M2");
                }
            });
            
            arregloBtnOrden[4].addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    validacionPosicionJ2("G2");
                }
            });
            
            arregloBtnOrden[5].addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    validacionPosicionJ2("P2");
                }
            });
    }
    //validacion de orde personaje jugador 1        
    public void validacionPosicionJ1(String nombre){
          //obtener imagen mago
            
            ImageIcon iconoPrincipal = new ImageIcon(); 
            switch(nombre){
                case "M1":
                    iconoPrincipal=iconoMago1;
                break;
                case "G1":
                    iconoPrincipal=iconoGuerrero1;
                break;
                case "P1":
                    iconoPrincipal=iconoPrincesa1;
                break;
            }
            
        if(arregloLblOrden[0].getText()==""){
            arregloLblOrden[0].setText(nombre);
            arregloLblOrden[0].setIcon(iconoPrincipal);
        }else if(arregloLblOrden[1].getText()==""){
            arregloLblOrden[1].setText(nombre);
            arregloLblOrden[1].setIcon(iconoPrincipal);
        }else if(arregloLblOrden[2].getText()==""){
            arregloLblOrden[2].setText(nombre);
            arregloLblOrden[2].setIcon(iconoPrincipal);

        }
    }
    //validacion de orde personaje jugador 2
    public void validacionPosicionJ2(String nombre){
        ImageIcon iconoPrincipal = new ImageIcon(); 
            switch(nombre){
                case "M2":
                    iconoPrincipal=iconoMago1;
                break;
                case "G2":
                    iconoPrincipal=iconoGuerrero1;
                break;
                case "P2":
                    iconoPrincipal=iconoPrincesa1;
                break;
            }
            
        
        if(arregloLblOrden[3].getText()==""){
            arregloLblOrden[3].setText(nombre);
            arregloLblOrden[3].setIcon(iconoPrincipal);
        }else if(arregloLblOrden[4].getText()==""){
            arregloLblOrden[4].setText(nombre);
            arregloLblOrden[4].setIcon(iconoPrincipal);
        }else if(arregloLblOrden[5].getText()==""){
            arregloLblOrden[5].setText(nombre);
            arregloLblOrden[5].setIcon(iconoPrincipal);
        }
    }
}
