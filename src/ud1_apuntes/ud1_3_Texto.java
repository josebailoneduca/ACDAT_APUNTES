/*
LICENCIA JOSE JAVIER BO
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
Lista de paquetes:
 */

package ud1_apuntes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jose Javier Bailon Ortiz
 */
public class ud1_3_Texto {
    
    //LEER DIRECTO
    private void LEER_CARACTER_A_CARACTER(){
                File fichero = new File("");
        FileReader fr = null;
        try {
            fr = new FileReader(fichero);
            //4-LEER texto caracter a caracter finaliza al devolver -1
            int i;
            while ((i = fr.read()) > -1) {
                System.out.print("" + ((char) i));
            }

        } catch (FileNotFoundException fnf) {
            System.out.println("Archivo de texto no encontrado");
            return;
        } catch (IOException io) {
            System.out.println("Error accediendo al archivo: " + io.getMessage());
            return;
        } finally {
            //CERRAR STREAMS
            try {
                if (fr != null) {
                    fr.close();
                }
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
    
    //LEER BUFFERED READER
    
    private void LEER_BUFFERED_READER(){
        //- GESTIÓN DEL FICHERO
        File fichero = new File("");
         
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader(fichero);
            br = new BufferedReader(fr);
            String linea;
            
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
            
        } catch (FileNotFoundException fnf) {
            System.out.println("Archivo de texto no encontrado");
            return;
        } catch (IOException io) {
            System.out.println("Error accediendo al archivo: " + io.getMessage());
            return;
        } finally {
            //5-CERRAR STREAMS
            try {
                if (br != null) {
                    br.close();
                }
                if (fr != null) {
                    fr.close();
                }
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
    
    private void ESCRIBIR_BUFFERED_WRITTER(){

        File archivoEscritura = new File("test.txt");

 

        //1- preparacion de readers y writters
   
        FileWriter fw = null;
        BufferedWriter bw = null;
        PrintWriter pw = null;//alternativa 
        try {
            //2- lectura del archivo
             
            ArrayList<String> lineas = new ArrayList<String>();
            lineas.add("1");
            lineas.add("2");
            lineas.add("3");
            //4- Escritura del archivo
            fw = new FileWriter(archivoEscritura);
            bw = new BufferedWriter(fw);
            
            for (String linea : lineas) {
                bw.write(linea);
                bw.newLine();
            }
         } catch (FileNotFoundException fnf) {
            System.out.println("Archivo no encontrado: "+fnf.getMessage());
        } catch (IOException ioe) {
            System.out.println("Error de E/S:"+ioe.getMessage());
        } finally {
            //6- Cierre de streams
            try {
                if (bw != null) 
                    bw.close();
                if (fw != null) 
                    fw.close();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }

        }
    }
    
    private void HERRAMIENTAS(){
    StringTokenizer st = new StringTokenizer("MI TEXTO", "\t\n\r\f,;:. ");
              int  totalPalabras = st.countTokens();
              st.nextToken();
    }
}//end ud1_3_Texto
