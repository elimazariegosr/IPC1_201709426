/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medievil_game.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import medievil_game.model.Personaje;

/**
 *
 */
public class Archivo {

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
    public void guardarTodo(String jug1, String jug2, int vidasj1,int vidasj2, int tiempo){
        File archivo = new File("Registros.txt");
        
        try{
                
             if(archivo.exists()){
                FileWriter fw = new FileWriter(archivo);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter pw = new PrintWriter(bw);
                pw.append(vidasj1 + ", " + jug1 + ", "+tiempo);
                pw.append(vidasj2 + ", " + jug2 + ", "+tiempo);
                pw.append("");
 
                pw.close();
                bw.close();
 
             }else{
                FileWriter fw = new FileWriter(archivo);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter pw = new PrintWriter(bw);
                pw.write(vidasj1 + ", " + jug1 + ", "+tiempo);
                pw.append(vidasj2 + ", " + jug2 + ", "+tiempo);
                pw.append("");
 
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
