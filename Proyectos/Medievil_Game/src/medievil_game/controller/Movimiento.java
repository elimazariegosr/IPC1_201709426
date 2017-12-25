/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medievil_game.controller;

import java.awt.BorderLayout;
import java.awt.Color;
import static java.awt.Color.red;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import medievil_game.model.Personaje;
import medievil_game.view.EmpezarJuego;
import medievil_game.view.TableroView;

/**
 *
 * @author Mazariegos
 */
public class Movimiento extends Thread {
    public int cantidad,dir,posicionx,posiciony,
            turnpersj1,turnpersj2,valormatriz,enturnoj1, enturnoj2;
    public String xoy,orden1,orden2,guardj1,guardj2;
    public Color color;
    public int turno,numero,estado,turnovalidacion,vidasj1,vidasj2,validarganar;
    public Tablero tab = null;
    public ImageIcon nuevaimagen;
    public JPanel panelatacar,paneltimer;
    public JButton [] vecbtn;
    
    Personaje personaje = new Personaje();
    Archivo arch = new Archivo();
    public Movimiento(){
    }
    public Movimiento(JPanel paneltimer){
        this.paneltimer=paneltimer;   
    }
    public Movimiento(int cantidad,Tablero tab,int dir,String xoy,int turno,
            int turnpersj1,int turnpersj2) {
        this.cantidad=cantidad;
        this.tab=tab;
        this.dir=dir;
        this.xoy=xoy;
        this.turno=turno;
        this.turnpersj1=turnpersj1;
        this.turnpersj2=turnpersj2;
        leerFile();
        leerJugadores();
        
    
    }
    
    //vaidacion de turno de persnaje del jugador 2
    public void validarTurnoP2(){
         switch (turnpersj2) {
            case 0:
                System.out.println("personaje en el orden "+turnpersj2);
                if(orden1.charAt(3)=='0'){nuevaimagen=tab.mago; enturnoj2=0;}
                if(orden1.charAt(3)=='1'){nuevaimagen=tab.guerrero;enturnoj2=1;}
                if(orden1.charAt(3)=='2'){nuevaimagen=tab.princesa;enturnoj2=2;}

                break;
            case 1:
                System.out.println("personaje en el orden "+turnpersj2);
                if(orden1.charAt(4)=='0'){nuevaimagen=tab.mago;enturnoj2=0;}
                if(orden1.charAt(4)=='1'){nuevaimagen=tab.guerrero;enturnoj2=1;}
                if(orden1.charAt(4)=='2'){nuevaimagen=tab.princesa;enturnoj2=2;}
                break;
            case 2:
                System.out.println("personaje en el orden "+turnpersj2);
                if(orden1.charAt(5)=='0'){nuevaimagen=tab.mago;enturnoj2=0;}
                if(orden1.charAt(5)=='1'){nuevaimagen=tab.guerrero;enturnoj2=1;}
                if(orden1.charAt(5)=='2'){nuevaimagen=tab.princesa;enturnoj2=2;}

                break;

            }
             
    }
    // validar turno de persnaje del jugador 1
    public void validarTurnoP1(){
        switch (turnpersj1) {
            case 0:
                System.out.println("personaje en el orden "+turnpersj1);
                if(orden1.charAt(0)=='0'){nuevaimagen=tab.mago; enturnoj1=0;}
                if(orden1.charAt(0)=='1'){nuevaimagen=tab.guerrero; enturnoj1=1;}
                if(orden1.charAt(0)=='2'){nuevaimagen=tab.princesa; enturnoj1=2;}
                
                break;
            case 1:
                System.out.println("personaje en el orden "+turnpersj1);
                if(orden1.charAt(1)=='0'){nuevaimagen=tab.mago; enturnoj1=0;}
                if(orden1.charAt(1)=='1'){nuevaimagen=tab.guerrero; enturnoj1=1;}
                if(orden1.charAt(1)=='2'){nuevaimagen=tab.princesa; enturnoj1=2;}
                break;
            case 2:
                System.out.println("personaje en el orden "+turnpersj1);
                if(orden1.charAt(2)=='0'){nuevaimagen=tab.mago; enturnoj1=0;}
                if(orden1.charAt(2)=='1'){nuevaimagen=tab.guerrero;enturnoj1=1;}
                if(orden1.charAt(2)=='2'){nuevaimagen=tab.princesa; enturnoj1=2;}

                break;

       }
    }
    //mover en y, x  y validaciondes de ataque
    public void mover(int cantidad,int dir,String xoy,int turno){
        //verificar turno de jugador
        if(turno==1){
            validarTurnoP1();
            valormatriz=1;
            color=Color.YELLOW;
            turnovalidacion=2;
            posicionx=tab.posjugxj1;
            posiciony=tab.posjugyj1;
            System.out.println(numero);
        }else if(turno==2){
            valormatriz=2;
                validarTurnoP2();
            turnovalidacion=1;
                 color=Color.GREEN;   
                
            posicionx=tab.posjugxj2;
            posiciony=tab.posjugyj2;
        }
// si se mueve en x, si se mueve en y o atacar         
        switch(xoy){
            case "a":
                if(turno==1){
                    atacarJ1();   
    ///ataque del jugador 2                   
                }else if(turno==2){
                    atacarJ2();
                }
            break;
           //mover en y
            case "y":
               for(int i=0;i<cantidad;i++){
                    try{ 
                        tab.matrizlabel[posiciony][posicionx].setIcon(null);
                        if(posiciony-1==-1 && dir==-1 ||posiciony+1==tab.tam && dir==1){
                            quitarVidaSalir(turno);
                             System.out.println("tva"+turnovalidacion);
                            
                            System.out.println("tva"+tab.matriz[posiciony/2][posicionx/2]);
                           
                            if(tab.matriz[tab.tam/2][tab.tam/2]==turnovalidacion){
                                tab.matriz[posiciony][posicionx]=0;
                                tab.matrizlabel[posiciony][posicionx].setOpaque(false);
                                tab.matrizlabel[posiciony][posicionx].setIcon(null);
                                tab.matrizlabel[posiciony][posicionx].setBackground(null);
                                validarVidas((tab.tam/2)+(1),tab.tam/2,turno);
                                tab.matrizlabel[posiciony=(tab.tam/2)+1][posicionx=tab.tam/2]
                                    .setIcon(nuevaimagen);
                                tab.matrizlabel[posiciony][posicionx].setOpaque(true);

                                tab.matrizlabel[posiciony][posicionx]
                                    .setBackground(color);
                                tab.matriz[posiciony][posicionx]=valormatriz;
   
                            }else{
                                tab.matriz[posiciony][posicionx]=0;
                                tab.matrizlabel[posiciony][posicionx].setOpaque(false);
                                tab.matrizlabel[posiciony][posicionx].setIcon(null);
                                tab.matrizlabel[posiciony][posicionx].setBackground(null);
                                validarVidas(tab.tam/2,tab.tam/2,turno);
                                tab.matrizlabel[posiciony=tab.tam/2][posicionx=tab.tam/2]
                                    .setIcon(nuevaimagen);
                                tab.matrizlabel[posiciony][posicionx].setOpaque(true);

                                tab.matrizlabel[posiciony][posicionx]
                                    .setBackground(color);

                            }    
                            guardarPosicion(posicionx,posiciony,turno);
                            tab.matriz[posiciony][posicionx]=valormatriz;

                            return;
                        }else{
                            System.out.println("tva"+turnovalidacion);
                            
                            System.out.println("tva"+tab.matriz[posiciony-(dir*(-1))][posicionx]);
                            
                            if(tab.matriz[posiciony-(dir*(-1))][posicionx]==turnovalidacion){
                                if(posicionx-(dir*(-1))<0 || (posicionx-(dir*(-1))>=tab.tam)){
                                    
                                    validarVidas(posicionx+(dir*(-1)),posiciony,turno);
                                
                                    tab.matrizlabel[posiciony][posicionx+=dir*(-1)].setIcon(nuevaimagen);
                                    tab.matrizlabel[posiciony][posicionx].setOpaque(true);
                                    tab.matrizlabel[posiciony][posicionx].setBackground(color);


                                    tab.matrizlabel[posiciony][posicionx-dir*(-1)].setOpaque(false);
                                    tab.matriz[posiciony][posicionx-dir*(-1)]=0;
                                    tab.matrizlabel[posiciony][posicionx-dir*(-1)].setIcon(null);
                                    tab.matrizlabel[posiciony][posicionx-dir*(-1)].setBackground(null);
                                    tab.matriz[posiciony][posicionx]=valormatriz;
                                
                                }else{
                                    validarVidas(posicionx-(dir*(-1)),posiciony,turno);

                                    tab.matrizlabel[posiciony][posicionx-=dir*(-1)].setIcon(nuevaimagen);
                                    tab.matrizlabel[posiciony][posicionx].setOpaque(true);
                                    tab.matrizlabel[posiciony][posicionx].setBackground(color);


                                    tab.matrizlabel[posiciony][posicionx+dir*(-1)].setOpaque(false);
                                    tab.matriz[posiciony][posicionx+dir*(-1)]=0;
                                    tab.matrizlabel[posiciony][posicionx+dir*(-1)].setIcon(null);
                                    tab.matrizlabel[posiciony][posicionx+dir*(-1)].setBackground(null);
                                    tab.matriz[posiciony][posicionx]=valormatriz;                                
                                }
                                
                                
                                
                                    
                            }else{
                                validarVidas(posicionx,posiciony-(dir*(-1)),turno);

                                tab.matrizlabel[posiciony-=dir*(-1)][posicionx].setIcon(nuevaimagen);
                                tab.matrizlabel[posiciony][posicionx].setOpaque(true);
                                tab.matrizlabel[posiciony][posicionx].setBackground(color);


                                tab.matrizlabel[posiciony+dir*(-1)][posicionx].setOpaque(false);
                                tab.matriz[posiciony+dir*(-1)][posicionx]=0;
                                tab.matrizlabel[posiciony+dir*(-1)][posicionx].setIcon(null);
                                tab.matrizlabel[posiciony+dir*(-1)][posicionx].setBackground(null);
                                tab.matriz[posiciony][posicionx]=valormatriz;

                            }        
                            guardarPosicion(posicionx,posiciony,turno);
                        }
                        Thread.sleep(500);
                    }catch(InterruptedException e){}
                }
                tab.matriz[posiciony][posicionx]=valormatriz;
            break;
            case "x":
                for(int i=0;i<cantidad;i++){
                    try{
                        tab.matrizlabel[posiciony][posicionx].setIcon(null);
                       
                        if(posicionx-1==-1  && dir==-1 || posicionx+1==tab.tam  && dir==1){
                            tab.matriz[posiciony][posicionx]=0;
                             System.out.println("tva"+turnovalidacion);
                            
                            System.out.println("tva"+tab.matriz[posiciony/2][posicionx/2]);
                           
                            quitarVidaSalir(turno);
                            tab.matrizlabel[posiciony][posicionx].setOpaque(false);
                            tab.matrizlabel[posiciony][posicionx].setIcon(null);
                            tab.matrizlabel[posiciony][posicionx].setBackground(null);
                            if(tab.matriz[tab.tam/2][tab.tam/2]==turnovalidacion){
                                validarVidas((tab.tam/2)-(-1),tab.tam/2,turno);
                                tab.matrizlabel[posiciony=(tab.tam/2)-(-1)][posicionx=tab.tam/2]
                                    .setIcon(nuevaimagen);

                                tab.matrizlabel[posiciony][posicionx].setOpaque(true);
                                tab.matrizlabel[posiciony][posicionx]
                                    .setBackground(color);
                                tab.matriz[posiciony][posicionx]=valormatriz;

                            }else{
                                validarVidas(tab.tam/2,tab.tam/2,turno);
                                tab.matrizlabel[posiciony=tab.tam/2][posicionx=tab.tam/2]
                                .setIcon(nuevaimagen);
                            
                                tab.matrizlabel[posiciony][posicionx].setOpaque(true);
                                tab.matrizlabel[posiciony][posicionx]
                                .setBackground(color);
                                tab.matriz[posiciony][posicionx]=valormatriz;

                            }
                             guardarPosicion(posicionx,posiciony,turno);
                            return;
                        }else{ 
                             System.out.println("tva"+turnovalidacion);
                            
                            System.out.println("tva"+tab.matriz[posiciony][posicionx-(dir*(-1))]);
                           
                            if(tab.matriz[posiciony][posicionx-(dir*(-1))]==turnovalidacion){
                                if(posiciony-(dir*(-1))<0 || posiciony-(dir*(-1))>=tab.tam){
                                
                                    validarVidas(posicionx,posiciony+(dir*(-1)),turno);
                                    tab.matrizlabel[posiciony+=dir*(-1)][posicionx].setIcon(nuevaimagen);
                                    tab.matrizlabel[posiciony][posicionx].setOpaque(true);
                                    tab.matrizlabel[posiciony][posicionx].setBackground(color);
                                    tab.matriz[posiciony-dir*(-1)][posicionx]=0;
                                    tab.matrizlabel[posiciony-dir*(-1)][posicionx].setOpaque(false);
                                    tab.matrizlabel[posiciony-dir*(-1)][posicionx].setIcon(null);
                                    tab.matrizlabel[posiciony-dir*(-1)][posicionx].setBackground(null);
                                    tab.matriz[posiciony][posicionx]=valormatriz;
                                    
                                }else{
                                    validarVidas(posicionx,posiciony-(dir*(-1)),turno);

                                    tab.matrizlabel[posiciony-=dir*(-1)][posicionx].setIcon(nuevaimagen);
                                    tab.matrizlabel[posiciony][posicionx].setOpaque(true);
                                    tab.matrizlabel[posiciony][posicionx].setBackground(color);
                                    tab.matriz[posiciony+dir*(-1)][posicionx]=0;
                                    tab.matrizlabel[posiciony+dir*(-1)][posicionx].setOpaque(false);
                                    tab.matrizlabel[posiciony+dir*(-1)][posicionx].setIcon(null);
                                    tab.matrizlabel[posiciony+dir*(-1)][posicionx].setBackground(null);
                                    tab.matriz[posiciony][posicionx]=valormatriz;
                                                    
                                }
                                
                            }else{
                                validarVidas(posicionx-(dir*(-1)),posiciony,turno);

                                tab.matrizlabel[posiciony][posicionx-=dir*(-1)].setIcon(nuevaimagen);
                                tab.matrizlabel[posiciony][posicionx].setOpaque(true);
                                tab.matrizlabel[posiciony][posicionx].setBackground(color);
                                tab.matriz[posiciony][posicionx+dir*(-1)]=0;
                                tab.matrizlabel[posiciony][posicionx+dir*(-1)].setOpaque(false);
                                tab.matrizlabel[posiciony][posicionx+dir*(-1)].setIcon(null);
                                tab.matrizlabel[posiciony][posicionx+dir*(-1)].setBackground(null);
                                tab.matriz[posiciony][posicionx]=valormatriz;
                        
                            }
                            
                           guardarPosicion(posicionx,posiciony,turno);
                        }
                    Thread.sleep(500);
                    }catch(InterruptedException e){}
                }
                 tab.matriz[posiciony][posicionx]=valormatriz;
            
            break;
       } 
    }
    public void guardarPosicion(int x,int y, int turno){
        if(turno==1){
            tab.posjugyj1=y;
            tab.posjugxj1=x;
        }else if(turno==2){
            tab.posjugyj2=y;
            tab.posjugxj2=x;
        }
    }
    public void run(){
        mover(cantidad,dir,xoy,turno);
    }
    
    public void validarVidas(int x, int y,int jug){
        
        if(jug==1){
        
        switch (tab.matriz[y][x]) {
            //quitar vidas
            case 3:
                for(int i =9;i>=0;i--){
                    if(i==0){
                        arch.guardarTodo(guardj1, guardj2, vidasj1, vidasj2, 10);
                        JOptionPane.showMessageDialog(null, "HA GANDO EL JUGADOR "+2);
                        new TableroView().setEnabled(false);
                        new EmpezarJuego().setVisible(true);
                        
                    }
                    if(tab.vecj1[i]==1){
                        tab.vecvidasj1[i].setBounds(i*20, 0, 15, 15);
                        tab.vecvidasj1[i].setBackground(null);
                        tab.vecvidasj1[i].setText("");
                        tab.vecj1[i]=0;
                        vidasj1=i;
                       return;
                    }
                }
                break;
                //agregar vidas
            case 4:
                   for(int i =0;i<10;i++){
                    if(tab.vecj1[i]==0){
                        tab.vecvidasj1[i].setBounds(i*20, 0, 15, 15);
                        tab.vecvidasj1[i].setBackground(Color.RED);
                        tab.vecvidasj1[i].setText("+");
                        tab.vecj1[i]=1;
                        vidasj1=i;
                       return;
                    }
                }
            break;
        }        
        }else if(jug==2){

        switch (tab.matriz[y][x]) {
            //quitar vidas
            case 3:
                for(int i =9;i>=0;i--){
                    if(i==0){
                        arch.guardarTodo(guardj1, guardj2, vidasj1, vidasj2, 10);
                        JOptionPane.showMessageDialog(null, "HA GANDO EL JUGADOR "+1);
                        new TableroView().dispose();
                        new EmpezarJuego().setVisible(true);

                    }
                    if(tab.vecj2[i]==1){
                        tab.vecvidasj2[i].setBounds(i*20, 0, 15, 15);
                        tab.vecvidasj2[i].setBackground(null);
                        tab.vecvidasj2[i].setText("");
                        tab.vecj2[i]=0;
                        vidasj2=i;
                       return;
                    }
                }
                break;
                //agregar vidas
            case 4:
                   for(int i =0;i<10;i++){
                    if(tab.vecj2[i]==0){
                        tab.vecvidasj2[i].setBounds(i*20, 0, 15, 15);
                        tab.vecvidasj2[i].setBackground(Color.RED);
                        tab.vecvidasj2[i].setText("+");
                        tab.vecj2[i]=1;
                        vidasj2=i;
                       return;
                    }
                }
            break;
        }        
        }
        
    }
    public void quitarVidaSalir(int jug){
        if(jug==1){
            validarganar=2;
        }else if(jug==2){
            validarganar=1;
        }
        for(int i =9;i>=0;i--){
           if(i==0){
               
               arch.guardarTodo(guardj1, guardj2, vidasj1, vidasj2, 10);
               JOptionPane.showMessageDialog(null, "HA GANDO EL JUGADOR "+validarganar);
               
                new TableroView().dispose();
                new EmpezarJuego().setVisible(true);

           }
            switch(jug){
                case 1:
                    if(tab.vecj1[i]==1){
                        tab.vecvidasj1[i].setBounds(i*20, 0, 15, 15);
                        tab.vecvidasj1[i].setBackground(null);
                        tab.vecvidasj1[i].setText("");
                        tab.vecj1[i]=0;
                       return;
                    }
                break;
                case 2:
                    if(tab.vecj2[i]==1){
                        tab.vecvidasj2[i].setBounds(i*20, 0, 15, 15);
                        tab.vecvidasj2[i].setBackground(null);
                        tab.vecvidasj2[i].setText("");
                        tab.vecj2[i]=0;
                        return;
                    }
                break;
            }
           
        }
             
    }
    public void leerJugadores(){
        BufferedReader br1=null,br2=null;
        try{
            String j1,j2;
            br1= new BufferedReader(new FileReader("Nombre1.txt"));
            br2 = new BufferedReader(new FileReader("Nombre2.txt"));
            while(( j1= br1.readLine()) !=null && ( j2= br1.readLine()) !=null){
                guardj1=j1;
                guardj2=j2;
            }
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            try{
                if (br1!= null )br1.close();
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }
    public void leerFile(){
       
        BufferedReader br1=null;
        try{
        String linea;
        br1 = new BufferedReader(new FileReader("ordenJ.txt"));
        while((linea = br1.readLine()) !=null){
                orden1=linea;
            }
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            try{
                if (br1!= null )br1.close();
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }
//atacar jugador 1   
    public void atacarJ1(){
        if(turnpersj1==0 || turnpersj1==1 || turnpersj1==2){
            switch (enturnoj1) {
            //ataque para mago j1
                case 0:
                    System.out.println("ataca mago");
                    for(int i =1; i<=4; i++){
                        if(posicionx +i <tab.tam){
                            if(tab.matriz[posiciony][posicionx +i]==2){
                                System.out.println("derecha");
                                quitarVidaSalir(2);
                                return;
                            }
                        }
                        if(posicionx -i >=0){
                            if(tab.matriz[posiciony][posicionx -i]==2){
                                System.out.println("izquierda");
                                quitarVidaSalir(2);
                                return;
                            }
                        }
                        if(posiciony +i < tab.tam){
                           if(tab.matriz[posiciony +i][posicionx]==2){
                                System.out.println("abajo");
                                quitarVidaSalir(2);
                                return;
                           }
                        }
                        if(posiciony -i >=0){
                           if(tab.matriz[posiciony -i][posicionx]==2){
                                System.out.println("arriba");
                                quitarVidaSalir(2);
                                return;
                            }
                        }
                    }   
                break;
                //ataque para guerrero j1    
                case 1:
                    System.out.println("ataca guerrero");
                    for(int i =1; i<=2; i++){
                      if(posicionx +i <tab.tam){
                            if(tab.matriz[posiciony][posicionx +i]==2){
                                System.out.println("derecha");
                                quitarVidaSalir(2);
                                quitarVidaSalir(2);
                                return;
                            }
                        }
                        if(posicionx -i >=0){
                            if(tab.matriz[posiciony][posicionx -i]==2){
                                System.out.println("izquierda");
                                quitarVidaSalir(2);
                                quitarVidaSalir(2);
                                return;
                            }
                        }
                        if(posiciony +i < tab.tam){
                           if(tab.matriz[posiciony +i][posicionx]==2){
                                System.out.println("abajo");
                                quitarVidaSalir(2);
                                quitarVidaSalir(2);
                                return;
                           }
                        }
                        if(posiciony -i >=0){
                           if(tab.matriz[posiciony -i][posicionx]==2){
                                System.out.println("arriba");
                                quitarVidaSalir(2);
                                quitarVidaSalir(2);
                                return;
                            }
                        }
                    }  
                break;
                //ataque para princesa j1    
                case 2:
                    System.out.println("ataca princesa");
                    if(posicionx - 1 >=0){
                        if(tab.matriz[posiciony][posicionx-1]==2){
                            quitarVidaSalir(2);
                            turno=1;
                        }
                    }
                    if(posicionx + 1 < tab.tam){
                        if(tab.matriz[posiciony][posicionx+1]==2){
                            quitarVidaSalir(2);
                            turno=1;
                        }
                    }
                    if(posiciony - 1>=0){
                        if(tab.matriz[posiciony-1][posicionx]==2){
                            quitarVidaSalir(2);
                            turno=1;
                        }
                    }
                    if(posiciony +1 < tab.tam){
                        if(tab.matriz[posiciony+1][posicionx]==2){
                            quitarVidaSalir(2);
                            turno=1;
                        }
                    }
                break;
            }
        }
    } 
//atacar jugador 2    
    public void atacarJ2(){
        if(turnpersj2==0 || turnpersj2==1 || turnpersj2==2){
            switch (enturnoj2) {
                case 0:
                    System.out.println("ataca mago");
                    for(int i =1; i<=4; i++){
                        if(posicionx +i <tab.tam){
                            if(tab.matriz[posiciony][posicionx +i]==1){
                                System.out.println("derecha");
                                quitarVidaSalir(1);
                                return;
                            }
                        }
                        if(posicionx -i >=0){
                            if(tab.matriz[posiciony][posicionx -i]==1){
                                System.out.println("izquierda");
                                quitarVidaSalir(1);
                                return;
                            }
                        }
                        if(posiciony +i < tab.tam){
                           if(tab.matriz[posiciony +i][posicionx]==1){
                                System.out.println("abajo");
                                quitarVidaSalir(1);
                                return;
                           }
                        }
                        if(posiciony -i >=0){
                           if(tab.matriz[posiciony -i][posicionx]==1){
                                System.out.println("arriba");
                                quitarVidaSalir(1);
                                return;
                            }
                        }                     
                    }  
                break;
                case 1:
                    System.out.println("ataca guerrero");
                    for(int i =1; i<=2; i++){
                        if(posicionx +i <tab.tam){
                            if(tab.matriz[posiciony][posicionx +i]==1){
                                System.out.println("derecha");
                                quitarVidaSalir(1);
                                quitarVidaSalir(1);
                                return;
                            }
                        }
                        if(posicionx -i >=0){
                            if(tab.matriz[posiciony][posicionx -i]==1){
                                System.out.println("izquierda");
                                quitarVidaSalir(1);
                                quitarVidaSalir(1);
                                return;  
                            }
                        }
                        if(posiciony +i < tab.tam){
                           if(tab.matriz[posiciony +i][posicionx]==1){
                                System.out.println("abajo");
                                 quitarVidaSalir(1);
                                quitarVidaSalir(1);
                                return;                 
                           }
                        }
                        if(posiciony -i >=0){
                           if(tab.matriz[posiciony -i][posicionx]==1){
                                System.out.println("arriba");
                                quitarVidaSalir(1);
                                quitarVidaSalir(1);
                                return;                            
                           }
                        }
                    }  
                break;
                case 2:
                    System.out.println("ataca princesa");
                    if(posicionx - 1 >=0){
                        if(tab.matriz[posiciony][posicionx-1]==1){
                            quitarVidaSalir(1);
                            turno=2;
                        }
                    }
                    if(posicionx + 1 < tab.tam){
                        if(tab.matriz[posiciony][posicionx+1]==1){
                            quitarVidaSalir(1);
                            turno=2;
                        }
                    }
                    if(posiciony - 1>=0){
                        if(tab.matriz[posiciony-1][posicionx]==1){
                            quitarVidaSalir(1);
                            turno=2;
                        }
                    }
                    if(posiciony +1 < tab.tam){
                        if(tab.matriz[posiciony+1][posicionx]==1){
                            quitarVidaSalir(1);
                            turno=2;
                        }
                    }                    
                break;
            }
        }
    }
    
}
