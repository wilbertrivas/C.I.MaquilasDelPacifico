
package Controladores;
import Modelos.Bodega;
import Modelos.Cliente;
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

public class ControlDB_Producto {
    private Connection conexion=null;
    private  ControlDB_DB control=null;  
    private int consecutivoProducto=0;

    public ControlDB_Producto() {
        control = new ControlDB_DB();
        conexion= control.ConectarBaseDatos(); 
    }
    public int retornarElMaximo(){
         Connection conexion= control.ConectarBaseDatos();
        int retorno=0;
        Statement statement = null;
        try{
            statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT MAX(id) FROM producto;");
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
    
    public int registrarProducto(Producto p){
        Connection conexion= control.ConectarBaseDatos();
        int result=0;
        try{
            //#########################################################
            try{
                consecutivoProducto=retornarElMaximo();
                consecutivoProducto++;
            }catch(Exception e){
                consecutivoProducto++;                   
            }    
            PreparedStatement r= conexion.prepareStatement("INSERT INTO [maquilas].[dbo].[producto] ([id],[descripcion], [tipo],[SubpartidaArancelaria], [unidad_id], [estado])"
                                                         + " VALUES ('"+consecutivoProducto+"','"+p.getDescripcion()+"','"+p.getTipo()+"','"+p.getSubpartidaArancelaria()+"','"+p.getUnidad_id()+"','"+p.getEstado()+"');");
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
    public int validarExistenciaProducto(String nombreProducto){
        Connection conexion= control.ConectarBaseDatos();
        int retorno=0;
        Statement statement = null;
        try{
            statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM [maquilas].[dbo].[producto];");
            while(resultSet.next()){ 
                if(nombreProducto.equals(resultSet.getString(2))){
                    retorno =1;
                }
            }
        }catch (SQLException sqlException){
            JOptionPane.showMessageDialog(null, "Error al Tratar de buscar");
        } 
        control.cerrarConexionBaseDatos();
        return retorno;
    }
    public ArrayList<Producto> buscarProductos(String valorConsulta) throws SQLException{
        control.ConectarBaseDatos();
        ArrayList<Producto> listadoProducto= new ArrayList();
        Statement statement = null;
        try{
            statement = conexion.createStatement();
            ResultSet resultSet;
            if(valorConsulta.equals("")){
                resultSet= statement.executeQuery("SELECT * FROM [maquilas].[dbo].[producto];");
            }else{
                resultSet = statement.executeQuery("SELECT * FROM [maquilas].[dbo].[producto] WHERE [id] like'%"+valorConsulta+"%' or [descripcion] like '%"+valorConsulta+"%';");
            }
            while(resultSet.next()){ 
                Producto b = new Producto(); 
                b.setId(Integer.parseInt(resultSet.getString(1)));
                b.setDescripcion(resultSet.getString(2));
                b.setTipo(resultSet.getString(3));
                b.setSubpartidaArancelaria(resultSet.getString(4));
                b.setUnidad_id(Integer.parseInt(resultSet.getString(5)));
                b.setEstado(Integer.parseInt(resultSet.getString(6)));
                listadoProducto.add(b);
            }
        }catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null, "Error al tratar al consultar");
            sqlException.printStackTrace();
        } 
        control.cerrarConexionBaseDatos();
        return listadoProducto;
    } 
    public int actualizarProductos(Producto p) throws FileNotFoundException{
        control.ConectarBaseDatos();
        int result=0;
        try{
            PreparedStatement r= conexion.prepareStatement("UPDATE [maquilas].[dbo].[producto] set [descripcion]='"+p.getDescripcion()+"',[tipo]='"+p.getTipo()+"', [SubpartidaArancelaria] ='"+p.getSubpartidaArancelaria()+"' , [unidad_id] ='"+p.getUnidad_id()+"' , [estado] ='"+p.getEstado()+"' where [id]='"+ p.getId()+"'");
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
    public ArrayList<Producto> consultarUnicoProducto(Producto p) throws SQLException{
        ArrayList<Producto> listadoProducto = new ArrayList(); 
        control.ConectarBaseDatos();
        Statement statement = null;
        try{
            statement = conexion.createStatement();
            ResultSet resultSet = null;
            if(p != null){
                resultSet = statement.executeQuery("SELECT * FROM [maquilas].[dbo].[producto] where [id]='"+p.getId()+"'");
                while(resultSet.next()){ 
                Producto product = new Producto();       
                product.setId(resultSet.getInt(1));
                product.setDescripcion(resultSet.getString(2));
                product.setTipo(resultSet.getString(3));
                product.setSubpartidaArancelaria(resultSet.getString(4));
                product.setUnidad_id(resultSet.getInt(5));
                product.setEstado(Integer.parseInt(resultSet.getString(6)));
                listadoProducto.add(product);
            }
            }else{
               JOptionPane.showMessageDialog(null, "Verifique datos");
            }    
        }catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null, "Error al tratar al consultar");
            sqlException.printStackTrace();
        } 
        control.cerrarConexionBaseDatos();
        return listadoProducto;
    }
    
     public ArrayList<Producto> ListarProductosActivos() throws SQLException{
        control.ConectarBaseDatos();
        ArrayList<Producto> listadoProducto= new ArrayList();
        Statement statement = null;
        try{
            statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM [maquilas].[dbo].[producto] WHERE [estado]=1");
                while(resultSet.next()){ 
                Producto product = new Producto();       
                product.setId(resultSet.getInt(1));
                product.setDescripcion(resultSet.getString(2));
                product.setTipo(resultSet.getString(3));
                product.setSubpartidaArancelaria(resultSet.getString(4));
                product.setUnidad_id(resultSet.getInt(5));
                product.setEstado(Integer.parseInt(resultSet.getString(6)));
                listadoProducto.add(product);
            }
        }catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null, "Error al tratar al consultar");
            sqlException.printStackTrace();
        } 
        control.cerrarConexionBaseDatos();
        return listadoProducto;
     }
     public int RetornoIdProducto(String nombreProducto){
        Connection conexion= control.ConectarBaseDatos();
        int retorno=0;
        Statement statement = null;
        try{
            statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM [maquilas].[dbo].[producto];");
            while(resultSet.next()){ 
                if(nombreProducto.equalsIgnoreCase(resultSet.getString(2))){
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
     public String RetornoNombreProducto(int idProducto){
        Connection conexion= control.ConectarBaseDatos();
        String retorno="";
        Statement statement = null;
        try{
            statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM [maquilas].[dbo].[producto];");
            while(resultSet.next()){ 
                if(idProducto ==Integer.parseInt(resultSet.getString(1))){
                    retorno = resultSet.getString(2);
                }
            }
        }catch (SQLException sqlException){
            JOptionPane.showMessageDialog(null, "Error al Tratar de buscar");
            sqlException.printStackTrace();
            
        } 
        control.cerrarConexionBaseDatos();
        return retorno;
    }
    public ArrayList<Producto> ListarProductosPorMateriaPrima() throws SQLException{
        control.ConectarBaseDatos();
        ArrayList<Producto> listadoProducto= new ArrayList();
        Statement statement = null;
        try{
            statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM [maquilas].[dbo].[producto] WHERE [estado]=1 AND [tipo]='Materia Prima';");
                while(resultSet.next()){ 
                Producto product = new Producto();       
                product.setId(resultSet.getInt(1));
                product.setDescripcion(resultSet.getString(2));
                product.setTipo(resultSet.getString(3));
                product.setSubpartidaArancelaria(resultSet.getString(4));
                product.setUnidad_id(resultSet.getInt(5));
                product.setEstado(Integer.parseInt(resultSet.getString(6)));
                listadoProducto.add(product);
            }
        }catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null, "Error al tratar al consultar");
            sqlException.printStackTrace();
        } 
        control.cerrarConexionBaseDatos();
        return listadoProducto;
     }
}
