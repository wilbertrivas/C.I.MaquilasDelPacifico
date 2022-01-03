/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Modelos.Cliente;
import Modelos.TipoCliente;
import Modelos.TipoProveedor;
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
 * @author wrivas
 */
public class ControlDB_TipoProveedor {
    private Connection conexion=null;
    private  ControlDB_DB control=null;
    
    public ControlDB_TipoProveedor() {
        control = new ControlDB_DB();
        conexion= control.ConectarBaseDatos();
        
    }    
   
    public ArrayList<TipoProveedor> cargarTipoProveedor(){       
        ArrayList<TipoProveedor> listadoTipoProveedor = new ArrayList();        
        conexion=control.ConectarBaseDatos();
        Connection conexion= control.ConectarBaseDatos();
        try{
            Statement statement = conexion.createStatement();
            ResultSet resultSet;
            resultSet= statement.executeQuery("SELECT * FROM [maquilas].[dbo].[tipoproveedor] WHERE [estado]=1;");
            while(resultSet.next()){ 
                TipoProveedor tipoProveedor = new TipoProveedor();
                tipoProveedor.setId(resultSet.getInt(1));
                tipoProveedor.setDescripcion(resultSet.getString(2));
                tipoProveedor.setEstado(resultSet.getInt(3));
                listadoTipoProveedor.add(tipoProveedor);
            }
        }
        catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null, "Error al tratar al consultar");
        } 
        control.cerrarConexionBaseDatos();
        return listadoTipoProveedor;
   }
    public int validarTipoProveedor_ID_por_Nombre(String tipoProveedor){
        control.ConectarBaseDatos();
        int retorno=0;
        Statement statement = null;
        try{
            statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM [maquilas].[dbo].[tipoproveedor];");
            while(resultSet.next()){ 
                if(tipoProveedor.equals(resultSet.getString(2))){
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
    public String validarTipoProveedor_Nombre_por_ID(int idTipoProveedor){
        control.ConectarBaseDatos();
        String retorno="";
        Statement statement = null;
        try{
            statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM [maquilas].[dbo].[tipoProveedor];");
            while(resultSet.next()){ 
                if(idTipoProveedor == resultSet.getInt(1)){
                    retorno =resultSet.getString(2);
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
}
