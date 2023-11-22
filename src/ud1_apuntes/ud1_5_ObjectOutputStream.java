/*
LICENCIA JOSE JAVIER BO
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
Lista de paquetes:
 */

package ud1_apuntes;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jose Javier Bailon Ortiz
 */
public class ud1_5_ObjectOutputStream {
    
    
public void LEER_OBJECT_INPUT_STREAM(){
 File f = new File(ruta);


        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            //preparacion de streams
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);

            //recoger trabajos hasta EOF exception
            while (true) {

                //recoger objeto CASTEAR AL TIPO
                ObjetoSerializable obj = (ObjetoSerializable) ois.readObject();
  
            }//fin while

            //tratamiento de excepciones y cierre de streams
        } catch (EOFException eofe) {
            //FIN DE ARCHIVO
        } catch (IOException ex) {
            System.out.println("Error accediendo a archivo");
        } catch (ClassNotFoundException ex) {

        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException ex) {
                System.out.println("Error accediendo a archivo");
            }
        }


}
    
    
public void ESCRIBIR_OBJECT_OUTPUT_STREAM(){
File f = new File("ARCHIVO.DAT");
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        //ESCRIBIR objetos
        try {
            //preparar streams
            fos = new FileOutputStream(f, true);
            //Comprobar si ya hay trabajos para decidir que tipo de objectOutputStream crear
            if (COMPROBAR_PRIMER_GRABADO) {
                //SI NO HAY TRABAJOS CREA UN OBJECTOUTPUTSTREAM NORMAL
                oos = new ObjectOutputStream(fos);
            } else {
                //SI YA HAY TRABAJOS CREA UN AGREGAROBJECTOUTPUTSTREAM QUE EVITA LA ESCRITURA DE CABECERA
                oos = new AgregarObjectOutputStream(fos);
            }

            //escribir el objeto en disco
            oos.writeObject(new ObjetoSerializable("dsf", "sdf", 0));

            //tratamiento de excepciones y cierre de streams
        } catch (FileNotFoundException ex) {
            System.out.println("Archivo no encontrado " + f.getAbsolutePath());
        } catch (IOException ex) {
            System.out.println("Error escribiendo a archivo " + f.getAbsolutePath());
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }}
}//end ud1_5_ObjectOutputStream
