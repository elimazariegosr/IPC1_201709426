/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medievil_game.model;

/**
 *
 * @author Mazariegos
 */
public class Jugador {
    public String [] nombre = new String[2];
    public int [] turno;
    public int[] tam =new int[2];;
      
        
    public void agregarJugador(String nombre1,String nombre2,int x, int y){
      
        nombre[0]=nombre1;
        nombre[1]=nombre2;
        tam[0]=x;
        tam[1]=y;
        
    }
}
