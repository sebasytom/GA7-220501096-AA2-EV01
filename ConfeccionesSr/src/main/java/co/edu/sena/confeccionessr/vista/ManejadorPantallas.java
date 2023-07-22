
package co.edu.sena.confeccionessr.vista;

/**
 *
 * @author SEBAS
 */
public class ManejadorPantallas {
    
    private static VCliente pantallaEstudiante;
    
       
    
       public static void abrirPantallaCliente() {
        
       pantallaEstudiante = new VCliente();
       pantallaEstudiante.setVisible(true);
       pantallaEstudiante.setLocationRelativeTo(null);
       }
      
    
       public static void cerrarPantallaCliente() {
       pantallaEstudiante.setVisible(false);
       pantallaEstudiante = null; 
       }
}
