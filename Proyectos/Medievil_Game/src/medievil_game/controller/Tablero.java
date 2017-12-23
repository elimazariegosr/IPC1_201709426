/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medievil_game.controller;
import java.awt.BorderLayout;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.*;
import medievil_game.model.*;
import medievil_game.view.TableroView;
/**
 *
 * @author Mazariegos
 */
public class Tablero {

    /**
     *
     */
    public int tam=10;
    public JPanel fondo;
    public ImageIcon mago,guerrero,princesa,bomba,vida,inipersj1,inipersj2;
    public int tamcuadrox=0, tamcuadroy=0, posjugxj1,posjugyj1,posjugxj2,posjugyj2;
    public int [][] matriz;
    public JLabel [][] matrizlabel;
    
    public String nombre1,inipersonaje;
    Personaje personaje = new Personaje();
    
    
    public Tablero() {
    }
    
    public Tablero(JPanel fondo){
        this.fondo=fondo;
        System.out.println("en el tablero");
        leerFile();
        llenar(tam);
    }
    public void leerFile(){
       System.out.println("leyendo");
         BufferedReader br1=null,br2=null;
      
       try{
           String stri;
        br1 = new BufferedReader(new FileReader("ordenJ.txt"));
        //br2 = new BufferedReader(new FileReader(""));  
        while((stri = br1.readLine()) !=null){
                inipersonaje=stri;
            }
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            try{
                if (br1!= null )br1.close();
            }catch(IOException e){
                e.printStackTrace();
            }
        }
      
    }
    public void llenar(int tam){
        tamcuadrox = 600/tam;
        tamcuadroy = 600/tam;
        
        matriz = new int[tam][tam];
        matrizlabel = new JLabel[tam][tam];
        
        for(int i=0;i<tam;i++){
            for(int j=1;j<tam;j++){
                matriz[j][i]=0;
            }   
        }
        //1 sirve para indicar donde esta jugador 1
        posjugxj1=(int)(Math.random()*tam-1);
        posjugyj1=(int)(Math.random()*tam-1);
        
        matriz[posjugyj1][posjugxj1]=1;
        //2 sirve para indicar donde esta jugador 2
        posjugxj2=(int)(Math.random()*tam-1);
        posjugyj2=(int)(Math.random()*tam-1);
        
        matriz[posjugyj2][posjugxj2]=2;
        
        //3 sirve para indicar donde estan las vidas
        
        //4 sirve para indicar donde estan las minas
        char pers1,pers2;
        pers1=inipersonaje.charAt(0);
        pers2=inipersonaje.charAt(3);
        personaje.agregarImagenes(tamcuadrox, tamcuadroy);
       
        System.out.println("hola mi"+pers1);
        System.out.println("hola mi"+pers2);
        switch (pers1) {
            case '0':
                inipersj1=personaje.imagen[0];
                break;
            case '1':
                inipersj1=personaje.imagen[1];
                break;
            case '2':
                inipersj1=personaje.imagen[2];
                break;
            default:
                break;
        }
        switch (pers2) {
            case '0':
                inipersj2=personaje.imagen[0];
                break;
            case '1':
                inipersj2=personaje.imagen[1];
                break;
            case '2':
                inipersj2=personaje.imagen[2];
                break;
            default:
                break;
        }
        mago=personaje.imagen[0];
        guerrero=personaje.imagen[1];
        princesa=personaje.imagen[2];
        bomba=personaje.imagen[3];
        vida=personaje.imagen[4];
        agregarBombaLogica();
        agregarVidaLogica();
        repintar();
    }
    public void repintar(){
        for(int i=0;i<tam;i++){
            for(int j=0;j<tam;j++){
                JLabel tablero,vid;
                switch (matriz[j][i]) {
                    case 0:
                        tablero = new JLabel();
                        tablero.setOpaque(false);
                        tablero.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
                        tablero.setBounds(i*tamcuadrox,j*tamcuadroy,tamcuadrox,tamcuadroy);
                        matrizlabel[j][i]=tablero;
                        fondo.add(matrizlabel[j][i],BorderLayout.CENTER);
                        fondo.repaint();
                    break;
                    case 1:
                        tablero = new JLabel(inipersj1);
                        tablero.setOpaque(true);
                        tablero.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
                        tablero.setBounds(i*tamcuadrox,j*tamcuadroy,tamcuadrox,tamcuadroy);
                        tablero.setBackground(Color.blue);
                        matrizlabel[j][i]=tablero;
                        fondo.add(matrizlabel[j][i],BorderLayout.CENTER);
                        fondo.repaint();
                    break;
                    case 2:
                        tablero = new JLabel(inipersj2);
                        tablero.setOpaque(true);
                        tablero.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
                        tablero.setBounds(i*tamcuadrox,j*tamcuadroy,tamcuadrox,tamcuadroy);
                        tablero.setBackground(Color.red);

                        matrizlabel[j][i]=tablero;
                        fondo.add(matrizlabel[j][i],BorderLayout.CENTER);
                        fondo.repaint();
                    break;
                    case 3:
                        tablero = new JLabel(bomba);
                        tablero.setOpaque(false);
                        tablero.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
                        tablero.setBounds(i*tamcuadrox,j*tamcuadroy,tamcuadrox,tamcuadroy);
                        matrizlabel[j][i]=tablero;
                        fondo.add(matrizlabel[j][i],BorderLayout.CENTER);
                        fondo.repaint();
                    break;
                    case 4:
                        tablero = new JLabel(vida);
                        tablero.setOpaque(false);
                        tablero.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0))); 
                        tablero.setBounds(i*tamcuadrox,j*tamcuadroy,tamcuadrox,tamcuadroy);
                        matrizlabel[j][i]=tablero;
                        fondo.add(matrizlabel[j][i],BorderLayout.CENTER);
                        fondo.repaint();
                    break;
                }
            }   
        }
    }
    //agregar bombas aleatoriamente a la matriz logica
     public void agregarBombaLogica(){
       int numbomba = tam * tam;
       numbomba*=0.10;
       System.out.println(numbomba);
        for(int i=0;i<numbomba;i++){
            int x= (int)(Math.random()*tam);
            int y= (int)(Math.random()*tam);
            if(matriz[y][x]!=2 && matriz[y][x]!=1){
                matriz[y][x]=3;
            }
            
        }
    }
     //agregar vidas aleatoriamente  a la matriz logica
     public void agregarVidaLogica(){
       int numvida = tam * tam;
       numvida*=0.05;
       System.out.println(numvida);
        for(int i=0;i<numvida;i++){
            int x= (int)(Math.random()*tam);
            int y= (int)(Math.random()*tam);
             if(matriz[y][x]!=2 && matriz[y][x]!=1){
                matriz[y][x]=4;
            }
        }
    }
}