/*
LICENCIA JOSE JAVIER BO
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
Lista de paquetes:
 */

package ud1_apuntes;

/**
 *
 * @author Jose Javier Bailon Ortiz
 */
public class ud1_2_infoSistemaOperativo {
    public static void main(String[] args) {
        //informacion del sistema
            String sistemaOperativo=System.getProperty("os.name");
            boolean esWindows=sistemaOperativo.contains("Windows");
    }
}//end ud1_2_info
