/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medievil_game.controller;

import java.awt.BorderLayout;
import java.awt.Color;
import static java.awt.Color.red;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import medievil_game.model.Personaje;

/**
 *
 * @author Mazariegos
 */
public class Movimiento extends Thread {
    public int cantidad,dir,posicionx,posiciony,turnpersj1,turnpersj2,valormatriz;
    public String xoy,orden1,orden2;
    public Color color;
    public int turno,numero,estado;
    public Tablero tab = null;
    public ImageIcon nuevaimagen;
    public JPanel panelatacar;
    public JButton [] vecbtn;
    
    Personaje personaje = new Personaje();
    public Movimiento(){
    }
    public Movimiento(JPanel panelatacar){
        this.panelatacar=panelatacar;
        
    }
    public Movimiento(int cantidad,Tablero tab,int dir,String xoy,int turno,
            int turnpersj1,int turnpersj2) {
        this.cantidad=cantidad;
        this.tab=tab;
        this.dir=dir;
        this.xoy=xoy;
        this.turno=turno;
        this.turnpersj1=turnpersj1;
        this.turnpersj2=turnpersj2;
        leerFile();
        
    
    }
    public void guardarOrden(int ord1,int ord2,int ord3,int ord4,int ord5,int ord6){
        System.out.println(ord1+" "+ord2);
    }
    
    public void validarTurnoP2(){
         switch (turnpersj2) {
            case 0:
                System.out.println("personaje en el orden "+turnpersj2);
                if(orden1.charAt(3)=='0'){nuevaimagen=tab.mago;}
                if(orden1.charAt(3)=='1'){nuevaimagen=tab.guerrero;}
                if(orden1.charAt(3)=='2'){nuevaimagen=tab.princesa;}

                break;
            case 1:
                System.out.println("personaje en el orden "+turnpersj2);
                if(orden1.charAt(4)=='0'){nuevaimagen=tab.mago;}
                if(orden1.charAt(4)=='1'){nuevaimagen=tab.guerrero;}
                if(orden1.charAt(4)=='2'){nuevaimagen=tab.princesa;}
                break;
            case 2:
                System.out.println("personaje en el orden "+turnpersj2);
                if(orden1.charAt(5)=='0'){nuevaimagen=tab.mago;}
                if(orden1.charAt(5)=='1'){nuevaimagen=tab.guerrero;}
                if(orden1.charAt(5)=='2'){nuevaimagen=tab.princesa;}

                break;

            }
             
    }
    public void validarTurnoP1(){
        switch (turnpersj1) {
            case 0:
                System.out.println("personaje en el orden "+turnpersj1);
                if(orden1.charAt(0)=='0'){nuevaimagen=tab.mago;}
                if(orden1.charAt(0)=='1'){nuevaimagen=tab.guerrero;}
                if(orden1.charAt(0)=='2'){nuevaimagen=tab.princesa;}
                
                break;
            case 1:
                System.out.println("personaje en el orden "+turnpersj1);
                if(orden1.charAt(1)=='0'){nuevaimagen=tab.mago;}
                if(orden1.charAt(1)=='1'){nuevaimagen=tab.guerrero;}
                if(orden1.charAt(1)=='2'){nuevaimagen=tab.princesa;}
                break;
            case 2:
                System.out.println("personaje en el orden "+turnpersj1);
                if(orden1.charAt(2)=='0'){nuevaimagen=tab.mago;}
                if(orden1.charAt(2)=='1'){nuevaimagen=tab.guerrero;}
                if(orden1.charAt(2)=='2'){nuevaimagen=tab.princesa;}

                break;

       }
    }
    //mover hacia arriba o abajo
    public void mover(int cantidad,int dir,String xoy,int turno){
        //atacar();
        if(turno==1){
            validarTurnoP1();
            valormatriz=1;
            color=Color.YELLOW;
             
            posicionx=tab.posjugxj1;
            posiciony=tab.posjugyj1;
            System.out.println(numero);
        }else if(turno==2){
            valormatriz=2;
                validarTurnoP2();
            
                 color=Color.GREEN;   
                
            posicionx=tab.posjugxj2;
            posiciony=tab.posjugyj2;
        }
        switch(xoy){
            case "a":
                if(turno==1){
                   if(turnpersj2==0){
                       System.out.println("Ataca mago");
                   }else if(turnpersj1==2){
                       System.out.println("Ataca mago");
                   }else if(turnpersj1==2){
                       System.out.println("Ataca mago");
                   } 
                }else if(turno==2){
                    if(turnpersj2==0){
                       System.out.println("Ataca mago j2");
                   }else if(turnpersj2==1){
                       System.out.println("Ataca mago j2");
                   }else if(turnpersj2==2){
                       System.out.println("Ataca mago j2");
                   } 

                }
                break;
           //mover en y
           case "y":
               
               for(int i=0;i<cantidad;i++){
                    try{ 
                        tab.matrizlabel[posiciony][posicionx].setIcon(null);
                        if(posiciony-1==-1 && dir==-1 ||posiciony+1==tab.tam && dir==1){
                            quitarVidaSalir(turno);
                            tab.matrizlabel[posiciony][posicionx].setOpaque(false);
                            tab.matrizlabel[posiciony][posicionx].setIcon(null);
                            tab.matrizlabel[posiciony][posicionx].setBackground(null);
                            validarVidas(tab.tam/2,tab.tam/2,turno);
                            tab.matrizlabel[posiciony=tab.tam/2][posicionx=tab.tam/2]
                                .setIcon(nuevaimagen);
                            tab.matrizlabel[posiciony][posicionx].setOpaque(true);

                            tab.matrizlabel[posiciony][posicionx]
                                .setBackground(color);

                            tab.matriz[posiciony][posicionx]=0;
                            guardarPosicion(posicionx,posiciony,turno);
                            return;
                        }else{
                            validarVidas(posicionx,posiciony-(dir*(-1)),turno);
                            tab.matrizlabel[posiciony-=dir*(-1)][posicionx].setIcon(nuevaimagen);
                            tab.matrizlabel[posiciony][posicionx].setOpaque(true);
                            tab.matrizlabel[posiciony][posicionx].setBackground(color);


                            tab.matrizlabel[posiciony+dir*(-1)][posicionx].setOpaque(false);
                            tab.matriz[posiciony+dir*(-1)][posicionx]=0;
                            tab.matrizlabel[posiciony+dir*(-1)][posicionx].setIcon(null);
                            tab.matrizlabel[posiciony+dir*(-1)][posicionx].setBackground(null);

                            guardarPosicion(posicionx,posiciony,turno);
                        }
                        Thread.sleep(500);
                    }catch(InterruptedException e){}
                }
                tab.matriz[posiciony][posicionx]=valormatriz;
            break;
            case "x":
                for(int i=0;i<cantidad;i++){
                    try{
                        tab.matrizlabel[posiciony][posicionx].setIcon(null);
                       
                        if(posicionx-1==-1  && dir==-1 || posicionx+1==tab.tam  && dir==1){
                            quitarVidaSalir(turno);
                            tab.matrizlabel[posiciony][posicionx].setOpaque(false);
                            tab.matrizlabel[posiciony][posicionx].setIcon(null);
                            tab.matrizlabel[posiciony][posicionx].setBackground(null);
                            
                            validarVidas(tab.tam/2,tab.tam/2,turno);
                            tab.matrizlabel[posiciony=tab.tam/2][posicionx=tab.tam/2]
                                .setIcon(nuevaimagen);
                            
                            tab.matrizlabel[posiciony][posicionx].setOpaque(true);
                            tab.matrizlabel[posiciony][posicionx]
                                .setBackground(color);
                            
                           
                            tab.matriz[posiciony][posicionx]=0;
                             guardarPosicion(posicionx,posiciony,turno);
                            return;
                        }else{ 
                            validarVidas(posicionx-(dir*(-1)),posiciony,turno);
                            tab.matrizlabel[posiciony][posicionx-=dir*(-1)].setIcon(nuevaimagen);
                            tab.matrizlabel[posiciony][posicionx].setOpaque(true);
                            tab.matrizlabel[posiciony][posicionx].setBackground(color);
                            tab.matriz[posiciony][posicionx+dir*(-1)]=0;
                            tab.matrizlabel[posiciony][posicionx+dir*(-1)].setOpaque(false);
                            tab.matrizlabel[posiciony][posicionx+dir*(-1)].setIcon(null);
                            tab.matrizlabel[posiciony][posicionx+dir*(-1)].setBackground(null);
                            
                           guardarPosicion(posicionx,posiciony,turno);
                        }
                    Thread.sleep(500);
                    }catch(InterruptedException e){}
                }
                 tab.matriz[posiciony][posicionx]=valormatriz;
            
            break;
       } 
    }
    public void guardarPosicion(int x,int y, int turno){
        if(turno==1){
            tab.posjugyj1=y;
            tab.posjugxj1=x;
        }else if(turno==2){
            tab.posjugyj2=y;
            tab.posjugxj2=x;
        }
    }
    public void run(){
        mover(cantidad,dir,xoy,turno);
    }
    
    public void validarVidas(int x, int y,int jug){
        if(jug==1){

        switch (tab.matriz[y][x]) {
            //quitar vidas
            case 3:
                for(int i =9;i>0;i--){
                    System.out.println("i: " + i);
                    if(tab.vecj1[i]==1){
                        tab.vecvidasj1[i].setBounds(i*20, 0, 15, 15);
                        tab.vecvidasj1[i].setBackground(null);
                        tab.vecvidasj1[i].setText("");
                        tab.vecj1[i]=0;
                       return;
                    }
                }
                break;
                //agregar vidas
            case 4:
                   for(int i =0;i<10;i++){
                    if(tab.vecj1[i]==0){
                        tab.vecvidasj1[i].setBounds(i*20, 0, 15, 15);
                        tab.vecvidasj1[i].setBackground(Color.RED);
                        tab.vecvidasj1[i].setText("+");
                        tab.vecj1[i]=1;
                       return;
                    }
                }
            break;
        }        
        }else if(jug==2){

        switch (tab.matriz[y][x]) {
            //quitar vidas
            case 3:
                for(int i =9;i>0;i--){
                    System.out.println("i: " + i);
                    if(tab.vecj2[i]==1){
                        tab.vecvidasj2[i].setBounds(i*20, 0, 15, 15);
                        tab.vecvidasj2[i].setBackground(null);
                        tab.vecvidasj2[i].setText("");
                        tab.vecj2[i]=0;
                       return;
                    }
                }
                break;
                //agregar vidas
            case 4:
                   for(int i =0;i<10;i++){
                    if(tab.vecj2[i]==0){
                        tab.vecvidasj2[i].setBounds(i*20, 0, 15, 15);
                        tab.vecvidasj2[i].setBackground(Color.RED);
                        tab.vecvidasj2[i].setText("+");
                        tab.vecj2[i]=1;
                       return;
                    }
                }
            break;
        }        
        }
        
    }
    public void quitarVidaSalir(int jug){
       
        for(int i =9;i>0;i--){
            System.out.println("i: " + i);
            switch(jug){
                case 1:
                    if(tab.vecj1[i]==1){
                        tab.vecvidasj1[i].setBounds(i*20, 0, 15, 15);
                        tab.vecvidasj1[i].setBackground(null);
                        tab.vecvidasj1[i].setText("");
                        tab.vecj1[i]=0;
                       return;
                    }
                break;
                case 2:
                    if(tab.vecj2[i]==1){
                        tab.vecvidasj2[i].setBounds(i*20, 0, 15, 15);
                        tab.vecvidasj2[i].setBackground(null);
                        tab.vecvidasj2[i].setText("");
                        tab.vecj2[i]=0;
                        return;
                    }
                break;
            }
           
        }
             
    }
    public void leerFile(){
       
        BufferedReader br1=null,br2=null;
        try{
        String linea;
        br1 = new BufferedReader(new FileReader("ordenJ.txt"));
        //br2 = new BufferedReader(new FileReader(""));  
        while((linea = br1.readLine()) !=null){
                orden1=linea;
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
    
}
