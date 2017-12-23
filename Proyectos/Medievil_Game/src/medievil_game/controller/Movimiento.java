/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medievil_game.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.ImageIcon;
import medievil_game.model.Personaje;

/**
 *
 * @author Mazariegos
 */
public class Movimiento extends Thread {
    public int cantidad,dir,posicionx,posiciony,turnpersj1,turnpersj2;
    public String xoy,orden1,orden2;
    public int turno,numero;
    public Tablero tab = null;
    public ImageIcon nuevaimagen;
    Personaje personaje = new Personaje();
    public Movimiento(){
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
         
    }
    public void validarTurnoP1(){
         
    }
    //mover hacia arriba o abajo
    public void mover(int cantidad,int dir,String xoy,int turno){
        if(turno==1){
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
            posicionx=tab.posjugxj1;
            posiciony=tab.posjugyj1;
            System.out.println(numero);
        }else if(turno==2){
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
             
            posicionx=tab.posjugxj2;
            posiciony=tab.posjugyj2;
        }
        switch(xoy){
            //mover en y
           case "y":
               for(int i=0;i<cantidad;i++){
                    try{ 
                        tab.matrizlabel[posiciony][posicionx].setIcon(null);
                        if(posiciony-1==-1 && dir==-1 ||posiciony+1==tab.tam && dir==1){
                            tab.matrizlabel[posiciony][posicionx].setIcon(null);
                            validarVidas(tab.tam/2,tab.tam/2,turno);
                            tab.matrizlabel[posiciony=tab.tam/2][posicionx=tab.tam/2]
                                .setIcon(nuevaimagen);
                            tab.matriz[posiciony][posicionx]=0;
                            guardarPosicion(posicionx,posiciony,turno);
                            return;
                        }else{
                            validarVidas(posicionx,posiciony-(dir*(-1)),turno);
                           tab.matrizlabel[posiciony-=dir*(-1)][posicionx].setIcon(nuevaimagen);
                            tab.matriz[posiciony+dir*(-1)][posicionx]=0;
                            tab.matrizlabel[posiciony+dir*(-1)][posicionx].setIcon(null);
                            guardarPosicion(posicionx,posiciony,turno);
                        }
                        Thread.sleep(500);
                    }catch(InterruptedException e){}
                }
                tab.matriz[posiciony][posicionx]=1;
            break;
            case "x":
                for(int i=0;i<cantidad;i++){
                    try{
                        tab.matrizlabel[posiciony][posicionx].setIcon(null);
                        if(posicionx-1==-1  && dir==-1 || posicionx+1==tab.tam  && dir==1){
                            tab.matrizlabel[posiciony][posicionx].setIcon(null);
                            validarVidas(tab.tam/2,tab.tam/2,turno);
                            tab.matrizlabel[posiciony=tab.tam/2][posicionx=tab.tam/2]
                                .setIcon(nuevaimagen);
                            tab.matriz[posiciony][posicionx]=0;
                             guardarPosicion(posicionx,posiciony,turno);
                            return;
                        }else{ 
                            validarVidas(posicionx-(dir*(-1)),posiciony,turno);
                            tab.matrizlabel[posiciony][posicionx-=dir*(-1)].setIcon(nuevaimagen);
                            tab.matriz[posiciony][posicionx+dir*(-1)]=0;
                            tab.matrizlabel[posiciony][posicionx+dir*(-1)].setIcon(null);
                           guardarPosicion(posicionx,posiciony,turno);
                        }
                    Thread.sleep(500);
                    }catch(InterruptedException e){}
                }
                 tab.matriz[posiciony][posicionx]=1;
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
        switch (tab.matriz[y][x]) {
            case 3:
                System.out.println("ha pasado por una bomba jugador "+jug);
                break;
            case 4:
                System.out.println("ha pasado por una vida jugador "+jug);
            break;
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
