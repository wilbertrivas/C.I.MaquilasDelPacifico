/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Modelos.EmpresaLocal;
import Modelos.TipoCliente;
import Modelos.TipoEmpresaLocal;
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
public class ControlDB_TipoEmpresaLocal {
    private Connection conexion=null;
    private  ControlDB_DB control=null;
    
    public ControlDB_TipoEmpresaLocal() {
        control = new ControlDB_DB();
        conexion= control.ConectarBaseDatos();
        
    }    
   
    public ArrayList<TipoEmpresaLocal> cargarTipoEmpresaLocal(){
        ArrayList<TipoEmpresaLocal> listadoTipoEmpresaLocal = new ArrayList();
        conexion=control.ConectarBaseDatos();
        Connection conexion= control.ConectarBaseDatos();
        try{
            Statement statement = conexion.createStatement();
            ResultSet resultSet;
            resultSet= statement.executeQuery("SELECT * FROM [maquilas].[dbo].[tipoEmpresaLocal] WHERE [estado]=1;");
            while(resultSet.next()){ 
                TipoEmpresaLocal tipoEmpresaLocal = new TipoEmpresaLocal();
                tipoEmpresaLocal.setId(resultSet.getInt(1));
                tipoEmpresaLocal.setDescripcion(resultSet.getString(2));
                tipoEmpresaLocal.setEstado(resultSet.getInt(3));
                listadoTipoEmpresaLocal.add(tipoEmpresaLocal);
            }
        }
        catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null, "Error al tratar al consultar");
            sqlException.printStackTrace();
        } 
        control.cerrarConexionBaseDatos();
        return listadoTipoEmpresaLocal;
   }
    public int validarTipoEmpresaLocal_ID_por_Nombre(String tipoEmpresaLocal){
        control.ConectarBaseDatos();
        int retorno=0;
        Statement statement = null;
        try{
            statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM [maquilas].[dbo].[tipoEmpresaLocal];");
            while(resultSet.next()){ 
                if(tipoEmpresaLocal.equals(resultSet.getString(2))){
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
    public String validarTipoEmpresaLocal_Nombre_por_ID(int idTipoEmpresaLocal){
        control.ConectarBaseDatos();
        String retorno="";
        Statement statement = null;
        try{
            statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM [maquilas].[dbo].[tipoEmpresaLocal];");
            while(resultSet.next()){ 
                if(idTipoEmpresaLocal == resultSet.getInt(1)){
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
