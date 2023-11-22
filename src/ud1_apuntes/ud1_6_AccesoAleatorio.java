/*
LICENCIA JOSE JAVIER BO
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
Lista de paquetes:
 */

package ud1_apuntes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.text.SimpleDateFormat;

/**
 *
 * @author Jose Javier Bailon Ortiz
 */
public class ud1_6_AccesoAleatorio {
    
    
    
public void AGREGAR_RANDOMACCESSFILE(){

RandomAccessFile raf = null;
        File fichero = new File("arvhico.dat");
        try {
            //acceso a archivo
            raf = new RandomAccessFile(fichero, "rw");//Lectura y Escritura
            //actualizar numero de empleados
            raf.seek(0);
            raf.writeInt(Control.getEmpleados().size());
            //ir al final
            raf.seek(raf.length());

            raf.writeInt(e.getId());//id empleado
            //Usamos clase StringBuffer para controlar tamaño de los String
            StringBuffer sbn = new StringBuffer(e.getNombre());
            sbn.setLength(Empleado.limiteNombre);//limite de longitud nombre
            String nombre = sbn.toString();
            raf.writeChars(nombre);//nombre
            //Limitamos el tamaño de apellidos:
            StringBuffer sba = new StringBuffer(e.getApellidos());
            sba.setLength(Empleado.limiteApellidos);//limite de longitud apellidos
            String apellidos = sba.toString();
            raf.writeChars(apellidos);//apellidos
            raf.writeInt(e.getSueldo());
            for (int trabajo : e.getTrabajos()) {
                raf.writeInt(trabajo);
            }
        } catch (FileNotFoundException ex) {
            msgError("Archivo no encontrado " + fichero.getAbsolutePath());
        } catch (IOException ex) {
            msgError("Error accediendo a " + fichero.getAbsolutePath());
        } finally {
            try {
                if (raf != null) {
                    raf.close();
                }
            } catch (IOException ex) {
                msgError("Error accediendo a " + fichero.getAbsolutePath());
            }
        }

}
    
    
    
public void CAMBIAR_RANDOMACCESSFILE(){

    //CALCULAR INICIO
 long inicioEscritura = 4 + ((idTrabajo - 1) * Trabajo.longitudBytes);
        RandomAccessFile raf = null;
        File fichero = new File("archivoi.dat");
        try {
            //acceso a archivo
            raf = new RandomAccessFile(fichero, "rw");//Lectura y Escritura
            //actualizar id del trabajo a negativo
            raf.seek(inicioEscritura);
            
            raf.writeInt(8);
            
        } catch (FileNotFoundException ex) {
            System.out.println("Archivo no encontrado " + fichero.getAbsolutePath());
        } catch (IOException ex) {
            System.out.println("Error accediendo a " + fichero.getAbsolutePath());
        } finally {
            try {
                if (raf != null) {
                    raf.close();
                }
            } catch (IOException ex) {
                System.out.println("Error accediendo a " + fichero.getAbsolutePath());
            }
        }


}    
    
    
    
    
    
    
    
    
    
    
public Object LEER_RANDOMaCCESSFILE(){
        Object trabajo = null;
        //calculo de la posicion del trabajo en el archivo
        long inicioLectura = 4 + ((idTrabajo - 1) * Trabajo.longitudBytes);
        RandomAccessFile raf = null;
        File fichero = new File("datos.dat");
        try {
            //acceso a archivo
            raf = new RandomAccessFile(fichero, "r");//Lectura solo

            //comprobar que el trabajo existe 
            if (inicioLectura >= raf.length()) {
                return null;
            }
            //moverse hasta la posicion inicial del trabajo
            raf.seek(inicioLectura);
            
            //leer campos
            int id = raf.readInt();
            
            
            
            //LECTURA DE DETERMINADOS CARACTERES CON TAMANIO FIJO
            char[] nombreCh = new char[Trabajo.limiteNombre];
            for (int j = 0; j < Trabajo.limiteNombre; j++) {
                nombreCh[j] = raf.readChar();
            }
            String nombre = new String(nombreCh);
            
            
            
            
            long fecha = raf.readLong();
            
            //LE
            int[] empleados = new int[Trabajo.limiteEmpleados];
            for (int j = 0; j < Trabajo.limiteEmpleados; j++) {
                empleados[j] = raf.readInt();
            }
            
            //crear trabajo
            trabajo = new Trabajo(id, nombre, fecha, empleados);
            
            
        } catch (FileNotFoundException ex) {
            System.out.println("Archivo no encontrado " + fichero.getAbsolutePath());
        } catch (IOException ex) {
            System.out.println("Error accediendo a " + fichero.getAbsolutePath());
        } finally {
            try {
                if (raf != null) {
                    raf.close();
                }
            } catch (IOException ex) {
                System.out.println("Error accediendo a " + fichero.getAbsolutePath());
            }
        }
        //devolver trabajo
        return trabajo;

}
}//end ud1_6_AccesoAleatorio
