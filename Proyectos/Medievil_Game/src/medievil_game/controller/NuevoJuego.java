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
public class NuevoJuego {
    public int primero=0,segundo=0,tercero=0;

    public NuevoJuego() {
    }
    public NuevoJuego(int primero,int segundo, int tercero) {
        this.primero=primero;
        this.segundo=segundo;
        this.tercero=tercero;
        obtenerOrden(primero,segundo,tercero);
    }
    public void obtenerOrden(int primero,int segundo, int tercero){
        //System.out.println("Orden "+pri+", "+sec+", "+ter);
        System.out.println("Ornden "+primero+", "+segundo+", "+tercero);
    }
}
