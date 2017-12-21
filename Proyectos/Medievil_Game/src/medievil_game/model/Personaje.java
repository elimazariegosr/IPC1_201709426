/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medievil_game.controller;
import java.awt.*;
import javax.swing.*;
/**
 *
 * @author Mazariegos
 */
public class Personaje {
    private String [] nombre = new String[3];
    private int [] alcance = new int [3];
    private int [] poder = new int [3];
    public ImageIcon [] imagen;

    public Personaje() {
    }

    public Personaje(String[] nombre, int[] alcance, int[] poder, ImageIcon[] imagen) {
        this.nombre = nombre;
        this.alcance = alcance;
        this.poder = poder;
        this.imagen = imagen;
    }

    public String[] getNombre() {
        return nombre;
    }

    public void setNombre(String[] nombre) {
        this.nombre = nombre;
    }

    public int[] getAlcance() {
        return alcance;
    }

    public void setAlcance(int[] alcance) {
        this.alcance = alcance;
    }

    public int[] getPoder() {
        return poder;
    }

    public void setPoder(int[] poder) {
        this.poder = poder;
    }

    public ImageIcon[] getImagen(int numero) {
        return imagen;
    }

    public void setImagen(ImageIcon[] imagen) {
        this.imagen = imagen;
    }
    public void agregarImagenes(int x, int y)
    {
     imagen= new ImageIcon[3];    
     System.out.println("estamos aki");
    ImageIcon matemp = new ImageIcon(getClass().getResource("/Pictures/mago.png"));
        Image ma = matemp.getImage();
        Image iconomag = ma.getScaledInstance(x, y, Image.SCALE_SMOOTH);
        imagen[0] = new ImageIcon(iconomag);
        
    ImageIcon guetemp = new ImageIcon(getClass().getResource("/Pictures/guerrero.png"));
        Image gue = guetemp.getImage();
        Image iconogue = gue.getScaledInstance(x, y, Image.SCALE_SMOOTH);
        imagen[1] = new ImageIcon(iconogue);
        
    ImageIcon pritemp = new ImageIcon(getClass().getResource("/Pictures/princesa.png"));
        Image pri = pritemp.getImage();
        Image iconopri = ma.getScaledInstance(x, y, Image.SCALE_SMOOTH);
        imagen[2] = new ImageIcon(iconopri);
    }
}
