/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Modelos.Cliente;
import Modelos.TipoCliente;
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
public class ControlDB_TipoCliente {
    private Connection conexion=null;
    private  ControlDB_DB control=null;
    private int consecutivoTipoCliente=0;
    
    public ControlDB_TipoCliente() {
        control = new ControlDB_DB();
        conexion= control.ConectarBaseDatos();
        
    }    
    public int retornarElMaximo(){
         Connection conexion= control.ConectarBaseDatos();
        int retorno=0;
        Statement statement = null;
        try{
            statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT MAX(id) FROM tipocliente;");
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
   
    public ArrayList<TipoCliente> cargarTipoClientes(){
        ArrayList<TipoCliente> listadoTipoCliente = new ArrayList();
        conexion=control.ConectarBaseDatos();
        Connection conexion= control.ConectarBaseDatos();
        try{
            Statement statement = conexion.createStatement();
            ResultSet resultSet;
            resultSet= statement.executeQuery("SELECT * FROM [maquilas].[dbo].[tipocliente] WHERE [estado]=1;");
            while(resultSet.next()){ 
                TipoCliente tipoCliente = new TipoCliente();
                tipoCliente.setId(resultSet.getInt(1));
                tipoCliente.setDescripcion(resultSet.getString(2));
                tipoCliente.setEstado(resultSet.getInt(3));
                listadoTipoCliente.add(tipoCliente);
            }
        }
        catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null, "Error al tratar al consultar");
            sqlException.printStackTrace();
        } 
        control.cerrarConexionBaseDatos();
        return listadoTipoCliente;
   }
    public int validarTipoCliente_ID_por_Nombre(String tipoCliente){
        control.ConectarBaseDatos();
        int retorno=0;
        Statement statement = null;
        try{
            statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM [maquilas].[dbo].[tipoCliente];");
            while(resultSet.next()){ 
                if(tipoCliente.equals(resultSet.getString(2))){
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
    public String validarTipoCliente_Nombre_por_ID(int idTipoCliente){
        control.ConectarBaseDatos();
        String retorno="";
        Statement statement = null;
        try{
            statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM [maquilas].[dbo].[tipoCliente];");
            while(resultSet.next()){ 
                if(idTipoCliente == resultSet.getInt(1)){
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
