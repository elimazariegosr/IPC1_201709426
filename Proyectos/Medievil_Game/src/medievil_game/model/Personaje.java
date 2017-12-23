/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medievil_game.model;
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
    private int [] orden;
    public ImageIcon [] imagen;

    public Personaje() {
    }

    public Personaje(String[] nombre, int[] alcance, int[] poder, ImageIcon[] imagen) {
        this.nombre = nombre;
        this.alcance = alcance;
        this.poder = poder;
        this.imagen = imagen;
    }
    public void agregarPersonajes(){
        nombre[0]="mago";
        nombre[1]="guerrero";
        nombre[2]="princesa";
        
        alcance[0]=4;
        alcance[1]=2;
        alcance[2]=1;
        
        poder[0]=1;
        poder[1]=2;
        poder[2]=1;
        
    }
    
    public void agregarOrden(int primero, int segundo, int tercero,
            int cuarto,int quinto ,int sexto){
        agregarPersonajes();
    
        orden = new int[6];
        orden[0]=primero;
        orden[1]=segundo;
        orden[2]=tercero;
        orden[3]=cuarto;
        orden[4]=quinto;
        orden[5]=sexto;
        
    }
    public void agregarImagenes(int x, int y)
    {
        
     agregarPersonajes();
     imagen= new ImageIcon[5];    
     System.out.println("agregando imagenes");
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
        Image iconopri = pri.getScaledInstance(x, y, Image.SCALE_SMOOTH);
        imagen[2] = new ImageIcon(iconopri);
    
        ImageIcon bomtemp = new ImageIcon(getClass().getResource("/Pictures/bomba.png"));
        Image bom = bomtemp.getImage();
        Image iconobom = bom.getScaledInstance(x, y, Image.SCALE_SMOOTH);
        imagen[3] = new ImageIcon(iconobom);
    
    ImageIcon vidatemp = new ImageIcon(getClass().getResource("/Pictures/vida.png"));
        Image vida = vidatemp.getImage();
        Image iconovida = vida.getScaledInstance(x, y, Image.SCALE_SMOOTH);
        imagen[4] = new ImageIcon(iconovida);
    
    }
}
