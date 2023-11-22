/*
LICENCIA JOSE JAVIER BO
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
Lista de paquetes:
 */

package ud1_apuntes;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jose Javier Bailon Ortiz
 */
public class ud1_4_BinarioPuro {

public void REF_DATA_OUTPUT_INPUT_STREAM(){

    try {
        
        
        DataOutputStream dos = new DataOutputStream(new FileOutputStream("datao.dat",true));
        DataInputStream dis = new DataInputStream(new FileInputStream(new File("datao.dat")));
        
        
        dos.writeInt(1);
        dis.readInt();
        
        dos.writeUTF("micadena");
        dis.readUTF();
        
        
        dos.writeChar(8);
        dis.readChar();
        
        
    } catch (FileNotFoundException ex) {
        Logger.getLogger(ud1_4_BinarioPuro.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
        Logger.getLogger(ud1_4_BinarioPuro.class.getName()).log(Level.SEVERE, null, ex);
    }
}

public void DATAINPUTSTREAM_LEER_ARCHIVO(){
File archivo = new File("DATOS.DAT");

        //3-PREPARACIÓN LECTURA: streams y datos        
        FileInputStream fis = null;
        DataInputStream dis = null;

        //4-LECTURA DATOS por pares nombre-edad:
        try {
            fis = new FileInputStream(archivo);
            dis = new DataInputStream(fis);

            // Bucle de lectura:          
            // Se intenta leer de 2 en 2 bytes y 
            // mientras la cantidad de bytes leidos no sea 0 se continua leyendo
            //
            byte[] b;
            while (true) {
                dis.readInt();
            }
        } catch (FileNotFoundException fnfe) {//Excepción del FileInputStream
            System.out.println(" ---> ERROR EN ACCESO al fichero: " + archivo.getAbsolutePath() + "\n");
        } 
        catch(EOFException eofex){
            //FIN DE ARCHIVO
        }
        catch (IOException ieo) {////Excepción de métodos readUTF y readInt
            System.out.println(" ---> ERROR métodos de lectura: " + archivo.getAbsolutePath() + "\n");
        } finally {
            try {
                //5-CERRAR STREAMS
                if (dis != null) {
                    dis.close();
                }
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException ioe) {
                System.out.println(" ---> ERROR en el cierre: " + archivo.getAbsolutePath() + "\n");
                ioe.printStackTrace();
            }
        }//end finally

}


public void DATAINPUTSTREAM_LEER_CARACTER_2BYTE(){
 File archivo = new File("DATOS.DAT");

        //3-PREPARACIÓN LECTURA: streams y datos        
        FileInputStream fis = null;
        DataInputStream dis = null;

        //4-LECTURA DATOS por pares nombre-edad:
        try {
            fis = new FileInputStream(archivo);
            dis = new DataInputStream(fis);

            // Bucle de lectura:          
            // Se intenta leer de 2 en 2 bytes y 
            // mientras la cantidad de bytes leidos no sea 0 se continua leyendo
            //
            byte[] b;
            while ((b = dis.readNBytes(2)).length != 0) {
                //convertir los dos bytes leidos a string segun el charset adecuado
                System.out.print(new String(b, StandardCharsets.ISO_8859_1));
            }
        } catch (FileNotFoundException fnfe) {//Excepción del FileInputStream
            System.out.println(" ---> ERROR EN ACCESO al fichero: " + archivo.getAbsolutePath() + "\n");
        } catch (IOException ieo) {////Excepción de métodos readUTF y readInt
            System.out.println(" ---> ERROR métodos de lectura: " + archivo.getAbsolutePath() + "\n");
        } finally {
            try {
                //5-CERRAR STREAMS
                if (dis != null) {
                    dis.close();
                }
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException ioe) {
                System.out.println(" ---> ERROR en el cierre: " + archivo.getAbsolutePath() + "\n");
                ioe.printStackTrace();
            }
        }//end finally

}
    
public void DATAOUPUTSTREAM_ESCRIBIR_CARACTER_BYTE(){


 FileOutputStream fileOS = null;
        String texto="era se una vez";
         File archivo = new File("file.dat");
        DataOutputStream dataOS = null;
        try {
            fileOS = new FileOutputStream(archivo);
            dataOS = new DataOutputStream(fileOS);
            //4-INSERTAR DATOS RECORRIENDO EL TEXTO Y GUARDANDO CADA CARACTER COMO BYTE
            for (int i = 0; i < texto.length(); i++) {
                //guardar caracter como byte
                dataOS.writeByte((byte) texto.charAt(i));
                
            }
        } catch (IOException ioe) {
            System.out.println(" ---> ERROR EN ACCESO al fichero o en métodos escritura: " + archivo.getAbsolutePath());
            ioe.printStackTrace();
        } finally {
            try {
                //5-CERRAR STREAMS
                if (dataOS != null) {
                    dataOS.close();
                }
                if (fileOS != null) {
                    fileOS.close();
                }
            } catch (IOException ioe) {
                //System.out.println(" ---> ERROR en el cierre: "+archivo.getAbsolutePath()+"\n");
                ioe.printStackTrace();
            }
        }//end finally

}
}//end ud1_4_BinarioPuro
