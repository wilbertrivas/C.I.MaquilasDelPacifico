/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;
import Modelos.Bodega;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class ControlDB_Bodega {
    private Connection conexion=null;
    private  ControlDB_DB control=null;  
    int consecutivoBodega=0;

    public ControlDB_Bodega() {
        control = new ControlDB_DB();
        conexion= control.ConectarBaseDatos(); 
    }
    public int retornarElMaximo(){
         Connection conexion= control.ConectarBaseDatos();
        int retorno=0;
        Statement statement = null;
        try{
            statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT MAX(id) FROM bodega;");
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
    public int registrarBodega(Bodega b) throws FileNotFoundException{
         Connection conexion= control.ConectarBaseDatos();
        int result=0;
        
        //#########################################################
        try{
            consecutivoBodega=retornarElMaximo();
            consecutivoBodega++;
        }catch(Exception e){
            consecutivoBodega++;                   
        }    
        try{
           PreparedStatement r= conexion.prepareStatement("INSERT INTO [maquilas].[dbo].[bodega] ([id],[descripcion], [estado]) VALUES ('"+consecutivoBodega+"','"+b.getDescripcion()+"', '"+b.getEstado()+"');");
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
    public int validarBodega(String nombreBogeda){
        Connection conexion= control.ConectarBaseDatos();
        int retorno=0;
        Statement statement = null;
        try{
            statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM [maquilas].[dbo].[bodega];");
            while(resultSet.next()){ 
                if(nombreBogeda.equalsIgnoreCase(resultSet.getString(2))){
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
    public int RetornoIdBodega(String nombreBogeda){
        Connection conexion= control.ConectarBaseDatos();
        int retorno=0;
        Statement statement = null;
        try{
            statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM [maquilas].[dbo].[bodega];");
            while(resultSet.next()){ 
                if(nombreBogeda.equalsIgnoreCase(resultSet.getString(2))){
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
     public String RetornoNombreBodega(int idBodega){
        Connection conexion= control.ConectarBaseDatos();
        String retorno="";
        Statement statement = null;
        try{
            statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM [maquilas].[dbo].[bodega];");
            while(resultSet.next()){ 
                if(idBodega == Integer.parseInt((resultSet.getString(1)))){
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
    public ArrayList<Bodega> buscarBodegas(String valorConsulta) throws SQLException{
        control.ConectarBaseDatos();
        ArrayList<Bodega> listadoBodega= new ArrayList();
        Statement statement = null;
        try{
            statement = conexion.createStatement();
            ResultSet resultSet;
            if(valorConsulta.equals("")){
                resultSet= statement.executeQuery("SELECT * FROM [maquilas].[dbo].[bodega];");
            }else{
                resultSet = statement.executeQuery("SELECT * FROM [maquilas].[dbo].[bodega] where [id] like '%"+valorConsulta+"%' or [descripcion] like '%"+valorConsulta+"%';");
            }
            while(resultSet.next()){ 
                Bodega b = new Bodega(); 
                b.setId(Integer.parseInt(resultSet.getString(1)));
                b.setDescripcion(resultSet.getString(2));
                b.setEstado(Integer.parseInt(resultSet.getString(3)));
                listadoBodega.add(b);
            }
        }catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null, "Error al tratar al consultar");
            sqlException.printStackTrace();
        } 
        control.cerrarConexionBaseDatos();
        return listadoBodega;
    } 
    public int actualizarBodega( Bodega d) throws FileNotFoundException{
        control.ConectarBaseDatos();
        int result=0;
        try{
            PreparedStatement r= conexion.prepareStatement("UPDATE [maquilas].[dbo].[bodega] SET  [descripcion]='"+d.getDescripcion()+"', [estado] ='"+d.getEstado()+"' where [id]='"+ d.getId()+"'");
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
    
    public ArrayList<Bodega> consultarUnicaBodega(Bodega b) throws SQLException{
        ArrayList<Bodega> listadoBodega = new ArrayList(); 
        control.ConectarBaseDatos();
        Statement statement = null;
        try{
            statement = conexion.createStatement();
            ResultSet resultSet = null;
            if(b != null){
                resultSet = statement.executeQuery("SELECT * FROM [maquilas].[dbo].[bodega] WHERE [id]='"+b.getId()+"'");
                while(resultSet.next()){ 
                Bodega bodega = new Bodega();       
                bodega.setId(resultSet.getInt(1));
                bodega.setDescripcion(resultSet.getString(2));
                bodega.setEstado(Integer.parseInt(resultSet.getString(3)));
                listadoBodega.add(bodega);
            }
            }else{
               JOptionPane.showMessageDialog(null, "Verifique datos");
            }    
        }catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null, "Error al tratar al consultar");
            sqlException.printStackTrace();
        } 
        control.cerrarConexionBaseDatos();
        return listadoBodega;
    }
      public ArrayList<Bodega> ListarBodegaActivas() throws SQLException{
        control.ConectarBaseDatos();
        ArrayList<Bodega> listadoBodega= new ArrayList();
        Statement statement = null;
        try{
            statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM [maquilas].[dbo].[bodega] where [estado] = 1");
                while(resultSet.next()){ 
                    Bodega bodega = new Bodega();       
                    bodega.setId(resultSet.getInt(1));
                    bodega.setDescripcion(resultSet.getString(2));
                    bodega.setEstado(Integer.parseInt(resultSet.getString(3)));
                    listadoBodega.add(bodega);
                }
        }catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null, "Error al tratar al consultar");
            sqlException.printStackTrace();
        } 
        control.cerrarConexionBaseDatos();
        return listadoBodega;
     }
}
