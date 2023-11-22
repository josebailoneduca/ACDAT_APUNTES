/*
LICENCIA JOSE JAVIER BO
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
Lista de paquetes:
 */

package ud1_apuntes;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author Jose Javier Bailon Ortiz
 */
public class ud1_1_archivos_filtros_directorios {

    public static void main(String[] args) {
        File file = new File("./asdfa/dasfsd.txt");
        
        //DIRECTORIO
        //es directorio
        file.isDirectory();
        //listado normal
        String[] lista = file.list();
        
        
        //ARCHIVO
        file.getName();
        file.length();//kb
        file.getPath();
        file.delete();
        file.renameTo(OtroFile);
        file.canRead();
        file.canExecute();
        file.canWrite();
        
        //crear
        try {
            file.createNewFile();
        } catch (IOException ex) {
            System.out.println("No se puede crear el archivo " + file.getAbsolutePath());
            System.exit(0);
        }
        
        
        
        //FILTRO
        FiltroXML filtroXml=new FiltroXML();//clasequeimplementa
        String[] listaArchivos = file.list(filtroXml);
    }
}//end ud1_1_archivos
