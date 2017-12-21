/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medievil_game.controller;

/**
 *
 * @author Mazariegos
 */
public class Movimiento extends Thread {
    public int cantidad;
    public int dir;
    public String xoy;
    public Tablero tab = null;

    public Movimiento(int cantidad,Tablero tab,int dir,String xoy) {
        this.cantidad=cantidad;
        this.tab=tab;
        this.dir=dir;
        this.xoy=xoy;
    }
    //mover hacia arriba o abajo
    public void mover(int cantidad,int dir,String xoy){
       switch(xoy){
           case "y":
               for(int i=0;i<cantidad;i++){
                    try{  
                        if(tab.posjugy-1==-1 || tab.posjugy+1==tab.tam){
                            tab.matrizlabel[tab.posjugy][tab.posjugx].setIcon(null);
                            tab.matrizlabel[tab.posjugy=tab.tam/2][tab.posjugx=tab.tam/2]
                                    .setIcon(tab.mago);
                            tab.matriz[tab.posjugy][tab.posjugx]=0;
                            return;
                        }else{
                        tab.matrizlabel[tab.posjugy-=dir*(-1)][tab.posjugx].setIcon(tab.mago);

                        tab.matriz[tab.posjugy+dir*(-1)][tab.posjugx]=0;
                        tab.matrizlabel[tab.posjugy+dir*(-1)][tab.posjugx].setIcon(null);
                        }
                        Thread.sleep(500);
                    }catch(InterruptedException e){}
                }
                tab.matriz[tab.posjugy][tab.posjugx]=1;
            break;
            case "x":
                for(int i=0;i<cantidad;i++){
                    try{
                        if(tab.posjugx-1==-1 || tab.posjugx+1==tab.tam){
                            tab.matrizlabel[tab.posjugy][tab.posjugx].setIcon(null);
                            tab.matrizlabel[tab.posjugy=tab.tam/2][tab.posjugx=tab.tam/2]
                                    .setIcon(tab.mago);
                            tab.matriz[tab.posjugy][tab.posjugx]=0;
                            return;
                        }else{
                        tab.matrizlabel[tab.posjugy][tab.posjugx-=dir*(-1)].setIcon(tab.mago);

                        tab.matriz[tab.posjugy][tab.posjugx+dir*(-1)]=0;
                        tab.matrizlabel[tab.posjugy][tab.posjugx+dir*(-1)].setIcon(null);
                        }
                    Thread.sleep(500);
                    }catch(InterruptedException e){}
                }
                 tab.matriz[tab.posjugy][tab.posjugx]=1;
            break;
               
       } 
    }
    public void moverEnX(int cantidad,int dir){
        
    }
    //
    public void run(){
        mover(cantidad,dir,xoy);
    }
    
}
