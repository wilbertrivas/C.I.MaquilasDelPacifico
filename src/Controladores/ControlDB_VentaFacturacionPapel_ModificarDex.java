package Controladores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ControlDB_VentaFacturacionPapel_ModificarDex {
    private Connection conexion=null;
    private  ControlDB_DB control=null;    
    
    public ControlDB_VentaFacturacionPapel_ModificarDex() {
        control = new ControlDB_DB();
        conexion= control.ConectarBaseDatos();       
    }     
    
    public int modificarDex(String idVenta, String Dex) throws SQLException{
        int result=0;
        control.ConectarBaseDatos();
        try{
            PreparedStatement modificarDex= conexion.prepareStatement("UPDATE [maquilas].[dbo].[facturaVentaPapel] SET [dex] = '"+Dex+"' "+
                    " WHERE [facturaVentaPapel].[id]= '"+idVenta+"';");
            modificarDex.execute();   
            result =1;
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error!!.. No se pudo actualizar el DEX de la factura de Venta a Papel");
        }
        control.cerrarConexionBaseDatos();
        return result;
    } 
}
