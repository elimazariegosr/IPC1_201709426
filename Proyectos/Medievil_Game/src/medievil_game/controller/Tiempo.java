/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medievil_game.controller;

import medievil_game.view.TableroView;

/**
 *
 * @author Mazariegos
 */
public class Tiempo extends Thread {
    private TableroView tabview;
    private int segundos;
    private int minutos;

    public Tiempo(TableroView tabview) {
        this.tabview = tabview;
        segundos=tabview.getSegundos();
        minutos=tabview.getMinutos();
    }

    @Override
    public void run() {
         //To change body of generated methods, choose Tools | Templates.
         for(int i=0;i<300;i++){
             if(segundos!=59){
                 segundos=tabview.aumentarS();
             }else{
                 segundos=0;
                 tabview.borrarS();
                 if(minutos!=5){
                     minutos=tabview.aumentarM();
                 }else{
                     
                 }
             }
             try{
                 sleep(999);
             }catch(InterruptedException ex){
             
             }
         }
    }
    
    
    
}
