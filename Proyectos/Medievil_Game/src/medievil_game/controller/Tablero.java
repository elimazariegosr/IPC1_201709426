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
    public ImageIcon mago,guerrero,princesa;
    public int tamcuadrox=0, tamcuadroy=0, posjugx,posjugy;
    
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
        posjugx=(int)(Math.random()*tam-1);
        posjugy=(int)(Math.random()*tam-1);;
        
        matriz[posjugx][posjugy]=1;
        //2 sirve para indicar donde esta jugador 2
        
        //3 sirve para indicar donde estan las vidas
        
        //4 sirve para indicar donde estan las minas
        
        personaje.agregarImagenes(tamcuadrox, tamcuadroy);
        mago=personaje.imagen[0];
        repintar();
    //        System.out.println(matriz[0][3]);
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
                }
            }   
        }
    }
}