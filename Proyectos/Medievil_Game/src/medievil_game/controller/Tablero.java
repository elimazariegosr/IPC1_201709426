/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medievil_game.controller;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.*;
import medievil_game.model.*;
/**
 *
 * @author Mazariegos
 */
public class Tablero {
    public int tam =0;
    public JPanel fondo;
    public ImageIcon mago,guerrero,princesa,bomba,vida;
    public int tamcuadrox=0, tamcuadroy=0, posjugxj1,posjugyj1,posjugxj2,posjugyj2;
    
    public int [][] matriz;
    public JLabel [][] matrizlabel;
    
    Personaje personaje = new Personaje();
    public Tablero(int tam, JPanel fondo){
        this.tam=tam;
        this.fondo=fondo;
        llenar(tam);
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
        
        personaje.agregarImagenes(tamcuadrox, tamcuadroy);
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
                JLabel tablero;
                if(matriz[j][i]==0){
                    tablero = new JLabel();
                    tablero.setOpaque(true);
                    tablero.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
                    tablero.setBounds(i*tamcuadrox,j*tamcuadroy,tamcuadrox,tamcuadroy);
                    matrizlabel[j][i]=tablero;
                    fondo.add(matrizlabel[j][i],BorderLayout.CENTER);
                    fondo.repaint();
    
                }else if(matriz[j][i]==1){
                    tablero = new JLabel(mago);
                    tablero.setOpaque(true);
                    tablero.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
                    tablero.setBounds(i*tamcuadrox,j*tamcuadroy,tamcuadrox,tamcuadroy);
                    matrizlabel[j][i]=tablero;
                    fondo.add(matrizlabel[j][i],BorderLayout.CENTER);
                    fondo.repaint();
                }else if(matriz[j][i]==2){
                    tablero = new JLabel(princesa);
                    tablero.setOpaque(true);
                    tablero.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
                    tablero.setBounds(i*tamcuadrox,j*tamcuadroy,tamcuadrox,tamcuadroy);
                    matrizlabel[j][i]=tablero;
                    fondo.add(matrizlabel[j][i],BorderLayout.CENTER);
                    fondo.repaint();
                }else if(matriz[j][i]==3){
                    tablero = new JLabel(bomba);
                    tablero.setOpaque(true);
                    tablero.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
                    tablero.setBounds(i*tamcuadrox,j*tamcuadroy,tamcuadrox,tamcuadroy);
                    matrizlabel[j][i]=tablero;
                    fondo.add(matrizlabel[j][i],BorderLayout.CENTER);
                    fondo.repaint(); 
                }else if(matriz[j][i]==4){
                    tablero = new JLabel(vida);
                    tablero.setOpaque(true);
                    tablero.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
                    tablero.setBounds(i*tamcuadrox,j*tamcuadroy,tamcuadrox,tamcuadroy);
                    matrizlabel[j][i]=tablero;
                    fondo.add(matrizlabel[j][i],BorderLayout.CENTER);
                    fondo.repaint(); 
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
            matriz[y][x]=3;
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
            matriz[y][x]=4;
        }
    }
}