/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medievil_game.controller;

import javax.swing.ImageIcon;

/**
 *
 * @author Mazariegos
 */
public class Movimiento extends Thread {
    public int cantidad,dir,posicionx,posiciony;
    public String xoy;
    public int turno;
    public Tablero tab = null;
    public ImageIcon nuevaimagen;
    public Movimiento(int cantidad,Tablero tab,int dir,String xoy,int turno) {
        this.cantidad=cantidad;
        this.tab=tab;
        this.dir=dir;
        this.xoy=xoy;
        this.turno=turno;
    }
    //mover hacia arriba o abajo
    public void mover(int cantidad,int dir,String xoy,int turno){
        //
        if(turno==1){
            nuevaimagen=tab.mago;
            posicionx=tab.posjugxj1;
            posiciony=tab.posjugyj1;
            System.out.println();
        }else if(turno==2){
            nuevaimagen=tab.princesa;
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
        if(tab.matriz[y][x]==3){
            System.out.println("ha pasado por una bomba jugador "+jug);
        }else if(tab.matriz[y][x]==4){
            System.out.println("ha pasado por una vida jugador "+jug);
        }
    }
}
