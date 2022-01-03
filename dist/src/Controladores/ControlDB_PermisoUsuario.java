
package Controladores;

import Modelos.PermisoUsuario;
import Modelos.Unidad;
import Modelos.Usuario;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ControlDB_PermisoUsuario {
    private Connection conexion=null;
    private  ControlDB_DB control=null;  

    public ControlDB_PermisoUsuario() {
        control = new ControlDB_DB();
        conexion= control.ConectarBaseDatos(); 
    }
   
   public ArrayList<PermisoUsuario> buscarPermisoUsuario(int idUsuario) throws SQLException{
        control.ConectarBaseDatos();
        ArrayList<PermisoUsuario> listadoPermisoUsuario= new ArrayList();
        Statement statement = null;
        try{
            statement = conexion.createStatement();
            ResultSet resultSet;
            resultSet= statement.executeQuery("SELECT * FROM [maquilas].[dbo].[permisos_usuario] WHERE [usuario_id]='"+idUsuario+"';");
     
            while(resultSet.next()){ 
                PermisoUsuario u = new PermisoUsuario(); 
                u.setUsuario_id(Integer.parseInt(resultSet.getString(1)));
                u.setPermisos_id(Integer.parseInt(resultSet.getString(2)));
                u.setEstado(Integer.parseInt(resultSet.getString(3)));
                listadoPermisoUsuario.add(u);
            }
        }catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null, "Error al tratar al consultar");
            sqlException.printStackTrace();
        } 
        control.cerrarConexionBaseDatos();
        return listadoPermisoUsuario;
    } 
    public String retornarDescripcionPermiso(int idPermiso){
        Connection conexion= control.ConectarBaseDatos();
        String retorno="";
        Statement statement = null;
        try{
            statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT [descripcion] FROM [maquilas].[dbo].[permisos] WHERE [id]='"+idPermiso+"';");
            while(resultSet.next()){ 
                retorno =resultSet.getString(1);   
            }
        }catch (SQLException sqlException){
            JOptionPane.showMessageDialog(null, "Error al Tratar de buscar");
            sqlException.printStackTrace();
            System.exit(1);
        } 
        control.cerrarConexionBaseDatos();
        return retorno;
    }
    public int retornarIdPermiso(String descripcionPermiso){
        Connection conexion= control.ConectarBaseDatos();
        int retorno=0;
        Statement statement = null;
        try{
            statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT [id] FROM [maquilas].[dbo].[permisos] WHERE [descripcion]='"+descripcionPermiso+"';");
            while(resultSet.next()){ 
                retorno =Integer.parseInt(resultSet.getString(1));   
            }
        }catch (SQLException sqlException){
            JOptionPane.showMessageDialog(null, "Error al Tratar de buscar");
            sqlException.printStackTrace();
            System.exit(1);
        } 
        control.cerrarConexionBaseDatos();
        return retorno;
    }
    public int actualizarPermisoUsuario(ArrayList<PermisoUsuario> listadoPermisoUsario) throws FileNotFoundException, SQLException{
        control.ConectarBaseDatos();
        int result=0;
        try{
            for(int i =0; i< listadoPermisoUsario.size(); i++){     
                PreparedStatement r= conexion.prepareStatement("UPDATE [maquilas].[dbo].[permisos_usuario] SET  [estado]='"+listadoPermisoUsario.get(i).getEstado()+"' WHERE [usuario_id]='"+listadoPermisoUsario.get(i).getUsuario_id()+"' AND [permisos_id]='"+listadoPermisoUsario.get(i).getPermisos_id()+"'");
                r.execute();
                result=1;
            }
        }
        catch (SQLException sqlException ){   
            result=0;
            JOptionPane.showMessageDialog(null, "ERROR al querer insertar los datos.");
            sqlException.printStackTrace();
        }  
        control.cerrarConexionBaseDatos();
        return result;
    } 
    public int retornarEstadoPermisoUsuario(Usuario u, String descripcionPermiso){
        Connection conexion= control.ConectarBaseDatos();
        int retorno=0;
        Statement statement = null;
        int idPermiso = retornarIdPermiso(descripcionPermiso);
        try{
            statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery("  SELECT [permisos_usuario].[estado] FROM [maquilas].[dbo].[permisos_usuario] " +
                        " INNER JOIN [dbo].[permisos] ON [permisos_usuario].[permisos_id]=[permisos].[id] AND [permisos_usuario].[permisos_id]='"+idPermiso+"' " +
                        " INNER JOIN [dbo].[usuario] ON [permisos_usuario].[usuario_id]=[usuario].[id] AND [usuario].[id]='"+u.getId()+"';");
            while(resultSet.next()){ 
                retorno =Integer.parseInt(resultSet.getString(1));   
            }
        }catch (SQLException sqlException){
            JOptionPane.showMessageDialog(null, "Error al Tratar de buscar");
            sqlException.printStackTrace();
            System.exit(1);
        } 
        control.cerrarConexionBaseDatos();
        return retorno;
    }
     public int retornarEstadoMenu(String descripcionPermiso){
        Connection conexion= control.ConectarBaseDatos();
        int retorno=0;
        Statement statement = null;
        try{
            statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT [estado] FROM [maquilas].[dbo].[permisos] WHERE [descripcion]='"+descripcionPermiso+"';");
            while(resultSet.next()){ 
                retorno =Integer.parseInt(resultSet.getString(1));   
            }
        }catch (SQLException sqlException){
            JOptionPane.showMessageDialog(null, "Error al Tratar de buscar");
            sqlException.printStackTrace();
            System.exit(1);
        } 
        control.cerrarConexionBaseDatos();
        return retorno;
    }
   
}
