/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medievil_game.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.table.DefaultTableModel;
import medievil_game.model.Personaje;

/**
 *
 */
public class Archivo {
    String cadenaNueva[]= new String[100];
    int numCadena;
    public Archivo() {
    }
 
    public void ordenJ(String pri,String sec,String ter,String cua,String qui, String sex){
          File archivo = new File("ordenJ.txt");
        if(archivo.exists()){
            System.out.println("Existe");
        }
        try {
            FileWriter fw = new FileWriter(archivo);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
            pw.write(pri+sec+ter+cua+qui+sex);

            pw.close();
            bw.close();
        } catch (IOException e) {
        }
    }
    public void leerTodo(){
         File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        
        try{
        archivo = new File("Registros.txt");    
        
        fr= new FileReader(archivo);
        br= new BufferedReader(fr);
        String linea;
        while((linea=br.readLine())!=null){
            cadenaNueva[numCadena]=linea;
            numCadena++;
         } 
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            try{
                if (fr!= null )fr.close();
            }catch(IOException e){
                e.printStackTrace();
            }
        }

    }
    public void guardarTodo(String jug1, String jug2){
        System.out.println(cadenaNueva);
        File archivo = new File("Registros.txt");
        try{
              String datos;  
             if(archivo.exists()){
                leerTodo();
                FileWriter fw = new FileWriter(archivo);
                
                BufferedWriter bw = new BufferedWriter(fw);
                
                PrintWriter pw = new PrintWriter(bw);
                for(int i =0; i<numCadena;i++){
                    pw.append(cadenaNueva[i] + "\n");
                }
                
                pw.append(jug1 + "\n");
                pw.append(jug2);
              
                pw.close();
                bw.close();
                bw.close();
                
 
             }else{
                FileWriter fw = new FileWriter(archivo);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter pw = new PrintWriter(bw);
                pw.write(jug1 + "\n");
                pw.append(jug2 + "\n");
                pw.close();
                bw.close();
 
            }
            }catch(IOException e){
            }
    }
    public void guardarNombreJ(String nombre1,int num0,int num1, int num2,int idJug){
        File archivo = new File("Nombre"+idJug+".txt");
        
        Personaje personaje = new Personaje();
        personaje.agregarPersonajes();
            if(archivo.exists()){
            }
            try{
                System.out.println("numero1:"+num0);
                FileWriter fw = new FileWriter(archivo);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter pw = new PrintWriter(bw);
                pw.write("Nombre: "+ nombre1 + "\n");
                pw.append("1. " + personaje.nombre[num0] + "\n");
                pw.append("2. " + personaje.nombre[num1] + "\n");
                pw.append("3. " + personaje.nombre[num2] + "\n");
 
                pw.close();
                bw.close();
            }catch(IOException e){
            }
    }
     public void guardarTam(String tamx){
        File archivo = new File("Tamaño.txt");
            if(archivo.exists()){
            }
            try{
                FileWriter fw = new FileWriter(archivo);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter pw = new PrintWriter(bw);
                pw.write(tamx);
                pw.close();
                bw.close();
            }catch(IOException e){
            }
    } 
}
