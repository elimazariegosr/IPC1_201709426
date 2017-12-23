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

/**
 *
 * @author Mazariegos
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
      
}
