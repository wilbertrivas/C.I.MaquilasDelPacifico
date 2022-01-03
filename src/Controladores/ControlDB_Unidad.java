/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Modelos.Bodega;
import Modelos.Producto;
import Modelos.Unidad;
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
public class ControlDB_Unidad {
    private Connection conexion=null;
    private  ControlDB_DB control=null;  
    private int consecutivoUnidad=0;

    public ControlDB_Unidad() {
        control = new ControlDB_DB();
        conexion= control.ConectarBaseDatos(); 
    }
     public int retornarElMaximo(){
         Connection conexion= control.ConectarBaseDatos();
        int retorno=0;
        Statement statement = null;
        try{
            statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT MAX(id) FROM unidad;");
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
    public int registrarUnidad(Unidad u) throws FileNotFoundException{
         Connection conexion= control.ConectarBaseDatos();
        int result=0;
        try{
              //#########################################################
            try{
                consecutivoUnidad=retornarElMaximo();
                consecutivoUnidad++;
            }catch(Exception e){
                consecutivoUnidad++;                   
            }    
           PreparedStatement r= conexion.prepareStatement("INSERT INTO [maquilas].[dbo].[unidad] ([id],[descripcion], [estado]) VALUES ('"+consecutivoUnidad+"','"+u.getDescripcion()+"', '"+u.getEstado()+"');");
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
     public int validarUnidad(String nombreUnidad){
        Connection conexion= control.ConectarBaseDatos();
        int retorno=0;
        Statement statement = null;
        try{
            statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM [maquilas].[dbo].[unidad];");
            while(resultSet.next()){ 
                if(nombreUnidad.equalsIgnoreCase(resultSet.getString(2))){
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
     public int actualizarUnidad( Unidad u) throws FileNotFoundException{
        control.ConectarBaseDatos();
        int result=0;
        try{
            PreparedStatement r= conexion.prepareStatement("UPDATE [maquilas].[dbo].[unidad] SET  [descripcion]='"+u.getDescripcion()+"', [estado] ='"+u.getEstado()+"' WHERE [id]='"+ u.getId()+"'");
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
    public ArrayList<Unidad> ListarUnidadActivas() throws SQLException{
        control.ConectarBaseDatos();
        ArrayList<Unidad> listadoUnidad= new ArrayList();
        Statement statement = null;
        try{
            statement = conexion.createStatement();
            ResultSet resultSet;
            resultSet= statement.executeQuery("SELECT * FROM [maquilas].[dbo].[unidad] WHERE [estado]=1;");
            while(resultSet.next()){ 
                Unidad u = new Unidad(); 
                u.setId(Integer.parseInt(resultSet.getString(1)));
                u.setDescripcion(resultSet.getString(2));
                u.setEstado(Integer.parseInt(resultSet.getString(3)));
                listadoUnidad.add(u);
            }
        }catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null, "Error al tratar al consultar");
            sqlException.printStackTrace();
        } 
        control.cerrarConexionBaseDatos();
        return listadoUnidad;
    } 
    public int validarTipoUnidad_ID_por_Nombre(String tipoUnidad){
        control.ConectarBaseDatos();
        int retorno=0;
        Statement statement = null;
        try{
            statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM [maquilas].[dbo].[unidad];");
            while(resultSet.next()){ 
                if(tipoUnidad.equals(resultSet.getString(2))){
                    retorno =Integer.parseInt(resultSet.getString(1));
                }
            }
        }catch (SQLException sqlException){
            JOptionPane.showMessageDialog(null, "Error al Tratar de buscar");
            sqlException.printStackTrace();
        } 
        control.cerrarConexionBaseDatos();
        return retorno;
    }
    public String validarTipoUnidad_Nombre_por_Id(String idUnidad){
        control.ConectarBaseDatos();
        String retorno="";
        Statement statement = null;
        try{
            statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM [maquilas].[dbo].[unidad];");
            while(resultSet.next()){ 
                if(idUnidad.equals(resultSet.getString(1))){
                    retorno =resultSet.getString(2);
                }
            }
        }catch (SQLException sqlException){
            JOptionPane.showMessageDialog(null, "Error al Tratar de buscar");
            sqlException.printStackTrace();
        } 
        control.cerrarConexionBaseDatos();
        return retorno;
    }
   public ArrayList<Unidad> buscarUnidad(String valorConsulta) throws SQLException{
        control.ConectarBaseDatos();
        ArrayList<Unidad> listadoUnidad= new ArrayList();
        Statement statement = null;
        try{
            statement = conexion.createStatement();
            ResultSet resultSet;
            if(valorConsulta.equals("")){
                resultSet= statement.executeQuery("SELECT * FROM [maquilas].[dbo].[unidad];");
            }else{
                resultSet = statement.executeQuery("SELECT * FROM [maquilas].[dbo].[unidad] WHERE [id] like '%"+valorConsulta+"%' or [descripcion] like '%"+valorConsulta+"%';");
            }
             String estado="";
            while(resultSet.next()){ 
                Unidad u = new Unidad(); 
                u.setId(Integer.parseInt(resultSet.getString(1)));
                u.setDescripcion(resultSet.getString(2));
                u.setEstado(Integer.parseInt(resultSet.getString(3)));
                listadoUnidad.add(u);
            }
        }catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null, "Error al tratar al consultar");
            sqlException.printStackTrace();
        } 
        control.cerrarConexionBaseDatos();
        return listadoUnidad;
    } 
   
   public ArrayList<Unidad> consultarUnicoUnidad(Unidad u) throws SQLException{
        ArrayList<Unidad> listadoUnidad = new ArrayList(); 
        control.ConectarBaseDatos();
        Statement statement = null;
        try{
            statement = conexion.createStatement();
            ResultSet resultSet = null;
            if(u != null){
                resultSet = statement.executeQuery("SELECT * FROM [maquilas].[dbo].[unidad] WHERE [id]='"+u.getId()+"'");
                while(resultSet.next()){ 
                Unidad unid = new Unidad();       
                unid.setId(resultSet.getInt(1));
                unid.setDescripcion(resultSet.getString(2));
                unid.setEstado(Integer.parseInt(resultSet.getString(3)));
                listadoUnidad.add(unid);
            }
            }else{
               JOptionPane.showMessageDialog(null, "Verifique datos");
            }    
        }catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null, "Error al tratar al consultar");
            sqlException.printStackTrace();
        } 
        control.cerrarConexionBaseDatos();
        return listadoUnidad;
    }
}
