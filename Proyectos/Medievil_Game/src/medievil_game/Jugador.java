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
public class Jugador {
    private int idJugador;
    private String nombre;
    private boolean turno;
    private int vida;
    private int ordenPersonaje;
    private Dado movimientoCasilla;
    private String Direccion;

    public Jugador() {
    }

    public Jugador(int idJugador, String nombre, boolean turno, int vida,
            int ordenPersonaje, Dado movimientoCasilla, String Direccion) {
        this.idJugador = idJugador;
        this.nombre = nombre;
        this.turno = turno;
        this.vida = vida;
        this.ordenPersonaje = ordenPersonaje;
        this.movimientoCasilla = movimientoCasilla;
        this.Direccion = Direccion;
    }

    public int getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(int idJugador) {
        this.idJugador = idJugador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isTurno() {
        return turno;
    }

    public void setTurno(boolean turno) {
        this.turno = turno;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getOrdenPersonaje() {
        return ordenPersonaje;
    }

    public void setOrdenPersonaje(int ordenPersonaje) {
        this.ordenPersonaje = ordenPersonaje;
    }

    public Dado getMovimientoCasilla() {
        return movimientoCasilla;
    }

    public void setMovimientoCasilla(Dado movimientoCasilla) {
        this.movimientoCasilla = movimientoCasilla;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }
    
    
}
