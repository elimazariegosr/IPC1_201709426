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
public class Personaje {
    private int idPersonaje;
    private String nombre;
    private int quitarVidas;
    private int casillaAtaque;

    int [] arregloIdPersonaje =new int[3];
    String []arregloNombre = new String[3];
    int [] arregloQuitarVidas =new int[3];
    int [] arregloCasillaAtaque =new int[3];

    public Personaje() {
    }

    public Personaje(int idPersonaje, String nombre, int quitarVidas, int casillaAtaque) {
        this.idPersonaje = idPersonaje;
        this.nombre = nombre;
        this.quitarVidas = quitarVidas;
        this.casillaAtaque = casillaAtaque;
    }

    public int getIdPersonaje() {
        return idPersonaje;
    }

    public void setIdPersonaje(int idPersonaje) {
        this.idPersonaje = idPersonaje;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getQuitarVidas() {
        return quitarVidas;
    }

    public void setQuitarVidas(int quitarVidas) {
        this.quitarVidas = quitarVidas;
    }

    public int getCasillaAtaque() {
        return casillaAtaque;
    }

    public void setCasillaAtaque(int casillaAtaque) {
        this.casillaAtaque = casillaAtaque;
    }
    
    
    public void orden(int primero, int segundo, int tecero){
        
    }
    public void agregarPersonajes(){
         
         for(int i =0;i<3;i++){
            arregloIdPersonaje[i]=i+1;    
         }
         arregloNombre[0]="Mago"; 
         arregloNombre[1]="Guerrero";
         arregloNombre[2]="Princesa";
         
         arregloQuitarVidas[0]=1;
         arregloQuitarVidas[1]=2;
         arregloQuitarVidas[2]=1;
         
         
         arregloCasillaAtaque[0]=4;
         arregloCasillaAtaque[1]=2;
         arregloCasillaAtaque[2]=1; 
    }
    public void mostrarPersonajes(){
        for(int i=0;i<3;i++){
            System.out.println("id Personaje:"+arregloIdPersonaje[i]+
                    " Nombre:"+arregloNombre[i]+" quita "+arregloQuitarVidas[i]+
                    " vidas  ataca a"+arregloCasillaAtaque[i]+" casilla(s)");
        }
    }
}
