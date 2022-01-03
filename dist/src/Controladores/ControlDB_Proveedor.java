
package Controladores;

import GUI.CalcularDigitoVerificacion;
import Modelos.Cliente;
import Modelos.Proveedor;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ControlDB_Proveedor {
    private Connection conexion=null;
    private ControlDB_DB control=null;    
    
    public ControlDB_Proveedor() {
        control = new ControlDB_DB();
        conexion= control.ConectarBaseDatos();       
    }
    public int registrarProveedores(Proveedor p) throws FileNotFoundException{
        Connection conexion= control.ConectarBaseDatos();
        int result=0;
         try{
            if(p.getTipoProveedor_id()==4){
               PreparedStatement r= conexion.prepareStatement("INSERT INTO [maquilas].[dbo].[proveedor] ([nit], [sucursal], [nombre], [resolucionFacturacion],"
                                                        + " [fechaResolucion], [tipoProveedor_id], [telefono], [celular], [direccion], [correo],"
                                                        + " [ciudad], [observacion], [estado]) VALUES ('"+p.getNit()+"', '"+p.getSucursal()+"', '"+p.getNombre()+"',"
                                                        + " '"+p.getResolucionFacturacion()+"', '"+p.getFechaResolucion()+"', '"+p.getTipoProveedor_id()+"',"
                                                        + " '"+p.getTelefono()+"', '"+p.getCelular()+"', '"+p.getDireccion()+"', '"+p.getCorreo()+"', '"+p.getCiudad()+"', '"+p.getObservacion()+"', '"+p.getEstado()+"');");
                r.execute();
                result=1;
            }else{
                PreparedStatement r= conexion.prepareStatement("INSERT INTO [maquilas].[dbo].[proveedor] ([nit],[digitoVerificacion],[sucursal], [nombre], [resolucionFacturacion],"
                                                        + " [fechaResolucion], [tipoProveedor_id], [telefono], [celular], [direccion], [correo],"
                                                        + " [ciudad], [observacion], [estado]) VALUES ('"+p.getNit()+"', '"+p.getDigitoVerificacion()+"','"+p.getSucursal()+"','"+p.getNombre()+"',"
                                                        + " '"+p.getResolucionFacturacion()+"', '"+p.getFechaResolucion()+"', '"+p.getTipoProveedor_id()+"',"
                                                        + " '"+p.getTelefono()+"', '"+p.getCelular()+"', '"+p.getDireccion()+"', '"+p.getCorreo()+"', '"+p.getCiudad()+"', '"+p.getObservacion()+"', '"+p.getEstado()+"');");
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
    public int actualizarProveedor( Proveedor p) throws FileNotFoundException{
        control.ConectarBaseDatos();
        int result=0;
        try{
             if(p.getTipoProveedor_id()==4){
                //c.setDigitoVerificacion("");
                PreparedStatement r= conexion.prepareStatement("UPDATE [maquilas].[dbo].[proveedor] SET [digitoVerificacion] = NULL, [nombre] = '"+p.getNombre()+"',[resolucionFacturacion] = '"+p.getResolucionFacturacion()+"',[fechaResolucion] = '"+p.getFechaResolucion()+"', [tipoProveedor_id] = '"+p.getTipoProveedor_id()+"',"
                                                         + " [telefono] = '"+p.getTelefono()+"', [celular] = '"+p.getCelular()+"', [direccion] = '"+p.getDireccion()+"',"
                                                         + " [correo] = '"+p.getCorreo()+"', [ciudad] = '"+p.getCiudad()+"', [observacion] = '"+p.getObservacion()+"',"
                                                         + " [estado] = '"+p.getEstado()+"'"    
                                                         + " WHERE [nit] = '"+p.getNit()+"' AND [sucursal] = '"+p.getSucursal()+"';");               
                r.execute();
                result=1;
             }else{
                //Procedemos a calcular el Digito de Verificación
                String nitS = p.getNit();
                long nitL = Long.parseLong(nitS);
                CalcularDigitoVerificacion calDV = new CalcularDigitoVerificacion();
                p.setDigitoVerificacion(""+calDV.generarDv(nitL));
                PreparedStatement r= conexion.prepareStatement("UPDATE [maquilas].[dbo].[proveedor] SET [digitoVerificacion] = '"+p.getDigitoVerificacion()+"',[nombre] = '"+p.getNombre()+"',[resolucionFacturacion] = '"+p.getResolucionFacturacion()+"',[fechaResolucion] = '"+p.getFechaResolucion()+"', [tipoProveedor_id] = '"+p.getTipoProveedor_id()+"',"
                                                         + " [telefono] = '"+p.getTelefono()+"', [celular] = '"+p.getCelular()+"', [direccion] = '"+p.getDireccion()+"',"
                                                         + " [correo] = '"+p.getCorreo()+"', [ciudad] = '"+p.getCiudad()+"', [observacion] = '"+p.getObservacion()+"',"
                                                         + " [estado] = '"+p.getEstado()+"'"    
                                                         + " WHERE [nit] = '"+p.getNit()+"' AND [sucursal] = '"+p.getSucursal()+"';");               
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
    public int validarExistenciaProveedor(Proveedor p){
        control.ConectarBaseDatos();
        int retorno=0;
        Statement statement = null;
        try{
            statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM [maquilas].[dbo].[proveedor];");
            while(resultSet.next()){ 
                String nit= ""+p.getNit();
                String sucursal= ""+p.getSucursal();
                if(nit.equals(resultSet.getString(1)) && sucursal.equals(resultSet.getString(3))){
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
    public ArrayList<Proveedor> buscarProveedor(String valorConsulta) throws SQLException{
        ArrayList<Proveedor> listadoProveedor = new ArrayList();
        
        control.ConectarBaseDatos();
        Statement statement = null;
        try{
            statement = conexion.createStatement();
            ResultSet resultSet;
            if(valorConsulta.equals("")){
                resultSet= statement.executeQuery("SELECT * FROM [maquilas].[dbo].[proveedor];");
            }else{
                resultSet = statement.executeQuery("SELECT * FROM [maquilas].[dbo].[proveedor] WHERE ([nit] like'%"+valorConsulta+"%' or [nombre] like '%"+valorConsulta+"%');");
            }
            while(resultSet.next()){ 
                Proveedor p = new Proveedor();       
                p.setNit(resultSet.getString(1));
                p.setDigitoVerificacion(resultSet.getString(2));
                p.setSucursal(Integer.parseInt(resultSet.getString(3)));
                p.setNombre(resultSet.getString(4));
                p.setResolucionFacturacion(resultSet.getString(5));
                p.setFechaResolucion(resultSet.getString(6));
                p.setTipoProveedor_id(resultSet.getInt(7));
                p.setTelefono(resultSet.getString(8));
                p.setCelular(resultSet.getString(9));
                p.setDireccion(resultSet.getString(10));
                p.setCorreo(resultSet.getString(11));
                p.setCiudad(resultSet.getString(12));
                p.setObservacion(resultSet.getString(13));
                p.setEstado(resultSet.getInt(14));
                listadoProveedor.add(p);
            }
        }catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null, "Error al tratar al consultar");
            sqlException.printStackTrace();
        } 
        control.cerrarConexionBaseDatos();
        return listadoProveedor;
    } 
    public ArrayList<Proveedor> consultarUnicoProveedor(Proveedor p) throws SQLException{
        ArrayList<Proveedor> listadoProveedor = new ArrayList(); 
        control.ConectarBaseDatos();
        Statement statement = null;
        try{
            statement = conexion.createStatement();
            ResultSet resultSet = null;
            if(p != null){
                resultSet = statement.executeQuery("SELECT * FROM [maquilas].[dbo].[proveedor] where [nit] ='"+p.getNit()+"' AND [sucursal] = '"+p.getSucursal()+"';");
                while(resultSet.next()){ 
                Proveedor ProveedorRetorno = new Proveedor();       
                ProveedorRetorno.setNit(resultSet.getString(1));
                ProveedorRetorno.setDigitoVerificacion(resultSet.getString(2));
                ProveedorRetorno.setSucursal(Integer.parseInt(resultSet.getString(3)));
                ProveedorRetorno.setNombre(resultSet.getString(4));
                ProveedorRetorno.setResolucionFacturacion(resultSet.getString(5));
                ProveedorRetorno.setFechaResolucion(resultSet.getString(6));
                ProveedorRetorno.setTipoProveedor_id(Integer.parseInt(resultSet.getString(7)));
                ProveedorRetorno.setTelefono(resultSet.getString(8));
                ProveedorRetorno.setCelular(resultSet.getString(9));
                ProveedorRetorno.setDireccion(resultSet.getString(10));
                ProveedorRetorno.setCorreo(resultSet.getString(11));
                ProveedorRetorno.setCiudad(resultSet.getString(12));
                ProveedorRetorno.setObservacion(resultSet.getString(13));
                ProveedorRetorno.setEstado(Integer.parseInt(resultSet.getString(14)));
                listadoProveedor.add(ProveedorRetorno);
            }
            }else{
               JOptionPane.showMessageDialog(null, "Verifique datos");
            }

            
        }catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null, "Error al tratar al consultar");
            sqlException.printStackTrace();
        } 
        control.cerrarConexionBaseDatos();
        return listadoProveedor;
    } 
    public int consultarConsecutivoSucursal(Proveedor p){
        control.ConectarBaseDatos();
        int sucursal=0;
        Statement statement = null;
        try{
            statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT MAX([sucursal]) as sucursal FROM [maquilas].[dbo].[proveedor] WHERE [nit]='"+p.getNit()+"';");
            while(resultSet.next()){ 
                try{
                    sucursal= Integer.parseInt(resultSet.getString(1)); //Cuando salga Null toma el valor de 0
                }catch(Exception e){
                    sucursal= 0;
                }
            }
        }catch (SQLException sqlException){
            JOptionPane.showMessageDialog(null, "Error al Tratar de buscar");
            sqlException.printStackTrace();
            System.exit(1);
        } 
        control.cerrarConexionBaseDatos();
        sucursal++;
        return sucursal;
    }
}
