/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Modelos.PermisoMenu;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author JQuery
 */
public class ControlDB_PermisoMenu {
    private Connection conexion=null;
    private  ControlDB_DB control=null;  
    private int consecutivoPermisoMenu=0;

    public ControlDB_PermisoMenu() {
        control = new ControlDB_DB();
        conexion= control.ConectarBaseDatos(); 
    }
     public int retornarElMaximo(){
         Connection conexion= control.ConectarBaseDatos();
        int retorno=0;
        Statement statement = null;
        try{
            statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT MAX(id) FROM permisos;");
            while(resultSet.next()){ 
                if(resultSet.getString(1) != null){
                    retorno =Integer.parseInt(resultSet.getString(1));
                }
            }
        }catch (SQLException sqlException){
            JOptionPane.showMessageDialog(null, "Error al Tratar de buscar");
            sqlException.printStackTrace();
            System.exit(1);
        } 
        control.cerrarConexionBaseDatos();
        return retorno;
    }
    public int registrarPermisoMenu(PermisoMenu u) throws FileNotFoundException{
         Connection conexion= control.ConectarBaseDatos();
        int result=0;
        try{
              //#########################################################
            try{
                consecutivoPermisoMenu=retornarElMaximo();
                consecutivoPermisoMenu++;
            }catch(Exception e){
                consecutivoPermisoMenu++;                   
            }    
           PreparedStatement r= conexion.prepareStatement("INSERT INTO [maquilas].[dbo].[permisos] ([id],[descripcion], [estado]) VALUES ('"+consecutivoPermisoMenu+"','"+u.getDescripcion()+"', '"+u.getEstado()+"');");
           r.execute();
            result=1;
        }
        catch (SQLException sqlException ){   
            result=0;
            JOptionPane.showMessageDialog(null, "ERROR al querer insertar los datos.");
            sqlException.printStackTrace();
        }  
        control.cerrarConexionBaseDatos();
        return result;
    }
     public int validarPermisoMenu(String nombrePermisoMenu){
        Connection conexion= control.ConectarBaseDatos();
        int retorno=0;
        Statement statement = null;
        try{
            statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM [maquilas].[dbo].[permisos];");
            while(resultSet.next()){ 
                if(nombrePermisoMenu.equalsIgnoreCase(resultSet.getString(2))){
                    retorno =1;
                }
            }
        }catch (SQLException sqlException){
            JOptionPane.showMessageDialog(null, "Error al Tratar de buscar");
            sqlException.printStackTrace();
            System.exit(1);
        } 
        control.cerrarConexionBaseDatos();
        return retorno;
    }
    public int actualizarPermisoMenu( PermisoMenu u) throws FileNotFoundException{
        control.ConectarBaseDatos();
        int result=0;
        try{
            PreparedStatement r= conexion.prepareStatement("UPDATE [maquilas].[dbo].[permisos] SET  [descripcion]='"+u.getDescripcion()+"', [estado] ='"+u.getEstado()+"' WHERE [id]='"+ u.getId()+"'");
            r.execute();
            result=1;
        }
        catch (SQLException sqlException ){   
            result=0;
            JOptionPane.showMessageDialog(null, "ERROR al querer insertar los datos.");
            sqlException.printStackTrace();
        }  
        control.cerrarConexionBaseDatos();
        return result;
    } 
    public ArrayList<PermisoMenu> ListarPermisosMenuActivos() throws SQLException{
        control.ConectarBaseDatos();
        ArrayList<PermisoMenu> listadoPermisoMenu= new ArrayList();
        Statement statement = null;
        try{
            statement = conexion.createStatement();
            ResultSet resultSet;
            resultSet= statement.executeQuery("SELECT * FROM [maquilas].[dbo].[permisos] WHERE [estado]=1;");
            while(resultSet.next()){ 
                PermisoMenu u = new PermisoMenu(); 
                u.setId(Integer.parseInt(resultSet.getString(1)));
                u.setDescripcion(resultSet.getString(2));
                u.setEstado(Integer.parseInt(resultSet.getString(3)));
                listadoPermisoMenu.add(u);
            }
        }catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null, "Error al tratar al consultar");
            sqlException.printStackTrace();
        } 
        control.cerrarConexionBaseDatos();
        return listadoPermisoMenu;
    } 
    public ArrayList<PermisoMenu> buscarPermisoMenu(String valorConsulta) throws SQLException{
        control.ConectarBaseDatos();
        ArrayList<PermisoMenu> listadoPermisoMenu= new ArrayList();
        Statement statement = null;
        try{
            statement = conexion.createStatement();
            ResultSet resultSet;
            if(valorConsulta.equals("")){
                resultSet= statement.executeQuery("SELECT * FROM [maquilas].[dbo].[permisos] WHERE ([descripcion]='cliente' OR " +
"												[descripcion]='proveedor' OR " +
"												[descripcion]='compra' OR " +
"												[descripcion]='venta' OR " +
"												[descripcion]='movimiento' OR " +
"												[descripcion]='consumo' OR " +
"												[descripcion]='informe_anual' OR " +
"												[descripcion]='auditoria' OR " +
"												[descripcion]='usuario' OR " +
"												[descripcion]='empresa_local' OR " +
"												[descripcion]='producto' OR " +
"												[descripcion]='unidad' OR " +
"												[descripcion]='bodega' OR " +
"												[descripcion]='parametros');");
            }else{
                resultSet = statement.executeQuery("SELECT * FROM [maquilas].[dbo].[permisos] WHERE ([descripcion]='cliente' OR " +
"												[descripcion]='proveedor' OR " +
"												[descripcion]='compra' OR " +
"												[descripcion]='venta' OR " +
"												[descripcion]='movimiento' OR " +
"												[descripcion]='consumo' OR " +
"												[descripcion]='informe_anual' OR " +
"												[descripcion]='auditoria' OR " +
"												[descripcion]='usuario' OR " +
"												[descripcion]='empresa_local' OR " +
"												[descripcion]='producto' OR " +
"												[descripcion]='unidad' OR " +
"												[descripcion]='bodega' OR " +
"												[descripcion]='parametros') AND [id] like '%"+valorConsulta+"%' OR [descripcion] like '%"+valorConsulta+"%';");
            }
             String estado="";
            while(resultSet.next()){ 
                PermisoMenu u = new PermisoMenu(); 
                u.setId(Integer.parseInt(resultSet.getString(1)));
                u.setDescripcion(resultSet.getString(2));
                u.setEstado(Integer.parseInt(resultSet.getString(3)));
                listadoPermisoMenu.add(u);
            }
        }catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null, "Error al tratar al consultar");
            sqlException.printStackTrace();
        } 
        control.cerrarConexionBaseDatos();
        return listadoPermisoMenu;
    } 
   
   public ArrayList<PermisoMenu> consultarUnicoPermisoMenu(PermisoMenu u) throws SQLException{
        ArrayList<PermisoMenu> listadoPermisoMenu= new ArrayList(); 
        control.ConectarBaseDatos();
        Statement statement = null;
        try{
            statement = conexion.createStatement();
            ResultSet resultSet = null;
            if(u != null){
                resultSet = statement.executeQuery("SELECT * FROM [maquilas].[dbo].[permisos] WHERE [id]='"+u.getId()+"'");
                while(resultSet.next()){ 
                PermisoMenu permisoMenu = new PermisoMenu();       
                permisoMenu.setId(resultSet.getInt(1));
                permisoMenu.setDescripcion(resultSet.getString(2));
                permisoMenu.setEstado(Integer.parseInt(resultSet.getString(3)));
                listadoPermisoMenu.add(permisoMenu);
            }
            }else{
               JOptionPane.showMessageDialog(null, "Verifique datos");
            }    
        }catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null, "Error al tratar al consultar");
            sqlException.printStackTrace();
        } 
        control.cerrarConexionBaseDatos();
        return listadoPermisoMenu;
    }
}
