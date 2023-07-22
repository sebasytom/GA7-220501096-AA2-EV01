
package co.edu.sena.confeccionessr;

import co.edu.sena.confeccionessr.modelo.controlador.Conexion;
import co.edu.sena.confeccionessr.vista.ManejadorPantallas;



/**
 *
 * @author SEBAS
 */

public class ConfeccionesSr {

    public static void main(String[] args) {
        
        
    Conexion.conectar();
    ManejadorPantallas.abrirPantallaCliente();
}

}