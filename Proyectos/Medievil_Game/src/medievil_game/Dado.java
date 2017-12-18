/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medievil_game;

/**
 *
 * @author Mazariegos
 */
public class Dado {
    private int numero;

    public Dado(int numero) {
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        numero =(int) Math.random();
        this.numero=numero;
    }
    
    
}
