
package co.edu.sena.confeccionessr.modelo.controlador;

import co.edu.sena.confeccionessr.modelo.Cliente;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class CCliente {
    
    public void registrarCliente(Cliente c){
        
        try {
            Statement st = Conexion.getConect().createStatement();
            st.execute("insert into cliente values ('"+c.getId()+"', '"+c.getNombre()+"', '"+c.getApellido()+"', '"+c.getDireccion()+"', '"+c.getTelefono()+"', '"+c.getTalla()+"')");
            JOptionPane.showMessageDialog(null, "Cliente Registrado");
            
        } catch (SQLException ex) {
            Logger.getLogger(CCliente.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Cliente No Registrado");
        }
    }
    
    
    public ResultSet consultarCliente(){
    
        ResultSet rs=null;

    try {
            Statement st = Conexion.getConect().createStatement();
            
          rs= st.executeQuery("select * from cliente");
        } catch (SQLException ex) {
            Logger.getLogger(CCliente.class.getName()).log(Level.SEVERE, null, ex);        
        }        
    
    return rs;
    }
    
    
    public ResultSet consultarClientePoiId(int Id){
    
        ResultSet rs=null;

    try {
            Statement st = Conexion.getConect().createStatement();
            
          rs= st.executeQuery("select * from cliente where id_cliente= '"+Id+"'");
        } catch (SQLException ex) {
            Logger.getLogger(CCliente.class.getName()).log(Level.SEVERE, null, ex);        
        }        
    
    return rs;
    }
    
    
    public void modificarCliente(Cliente c){
    
        try {
            Statement st = Conexion.getConect().createStatement();
            st.execute("update cliente set nombre= '"+c.getNombre()+"', apellido= '"+c.getApellido()+"', direccion= '"+c.getDireccion()+"', telefono='"+c.getTelefono()+"', talla='"+c.getTalla()+"' where id_cliente='"+c.getId()+"' ");
            JOptionPane.showMessageDialog(null, "Cliente Actualizado");
        } catch (SQLException ex) {
            Logger.getLogger(CCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public void eliminarCliente(int Id){
    
     try {
            Statement st = Conexion.getConect().createStatement();
            st.execute("delete from cliente where id_cliente= '"+Id+"'");
            JOptionPane.showMessageDialog(null, "Cliente Eliminado");
            
        } catch (SQLException ex) {
            Logger.getLogger(CCliente.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Cliente No Eliminado");
        }
    
    }   

    public void  pintarTabla(JTable tabla, ResultSet rs){

      
           DefaultTableModel modelo = new DefaultTableModel();
            
            modelo.addColumn("Id");
            modelo.addColumn("Nombre");
            modelo.addColumn("Apellido");
            modelo.addColumn("Direccion");
            modelo.addColumn("Telefono");
            modelo.addColumn("Talla");
            
            
        try {
            while (rs.next()){
                String[]fila={rs.getString("id_cliente"),rs.getString("nombre"),rs.getString("apellido"), rs.getString("direccion"), rs.getString("telefono"), rs.getString("talla")};
                modelo.addRow(fila);
                
            } 
            tabla.setModel(modelo);
            
        } catch (SQLException ex) {
            Logger.getLogger(CCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
            
           
}

}
