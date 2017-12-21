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
    public Tablero tab = null;

    public Movimiento(int cantidad,Tablero tab) {
        this.cantidad=cantidad;
        this.tab=tab;
    }
    public void moverArriba(int cantidad){
        for(int i=0;i<cantidad;i++){
            try{  
                
                tab.matrizlabel[tab.posjugy-=1][tab.posjugx].setIcon(tab.mago);
                tab.matriz[tab.posjugy+1][tab.posjugx]=0;
                tab.matrizlabel[tab.posjugy+1][tab.posjugx].setIcon(null);
                
                Thread.sleep(500);
            }catch(InterruptedException e){
            }
        }
        tab.matriz[tab.posjugy][tab.posjugx]=1;
    }
    public void run(){
        moverArriba(cantidad);
    }
    
}
