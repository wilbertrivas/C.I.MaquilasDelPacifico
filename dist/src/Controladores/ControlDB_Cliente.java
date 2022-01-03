package Controladores;

import GUI.CalcularDigitoVerificacion;
import Modelos.Cliente;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
public class ControlDB_Cliente {
    private Connection conexion=null;
    private  ControlDB_DB control=null;    
    
    public ControlDB_Cliente() {
        control = new ControlDB_DB();
        conexion= control.ConectarBaseDatos();       
    }
    public int registrarCliente(Cliente c) throws FileNotFoundException{
        Connection conexion= control.ConectarBaseDatos();
        int result=0;
        try{
            if(c.getTipoCliente_id()==4){
                PreparedStatement r= conexion.prepareStatement("INSERT INTO [maquilas].[dbo].[cliente] ([nit],[sucursal],[nombre], "
                                                            + "[tipoCliente_id], [telefono], [celular], [direccion], [correo], "
                                                            + "[ciudad], [observacion], [estado]) VALUES "
                                                            + "('"+c.getNit()+"', '"+c.getSucursal()+"', '"+c.getNombre()+"', '"+c.getTipoCliente_id()+"', '"+c.getTelefono()+"', '"+c.getCelular()+"',"
                                                            + " '"+c.getDireccion()+"', '"+c.getCorreo()+"', '"+c.getCiudad()+"', '"+c.getObservacion()+"', '"+c.getEstado()+"');");
                r.execute();
                result=1;
            }else{
                PreparedStatement r= conexion.prepareStatement("INSERT INTO [maquilas].[dbo].[cliente] ([nit], [digitoVerificacion],[sucursal],[nombre], "
                                                            + "[tipoCliente_id], [telefono], [celular], [direccion], [correo], "
                                                            + "[ciudad], [observacion], [estado]) VALUES "
                                                            + "('"+c.getNit()+"', '"+c.getDigitoVerificacion()+"', '"+c.getSucursal()+"', '"+c.getNombre()+"', '"+c.getTipoCliente_id()+"', '"+c.getTelefono()+"', '"+c.getCelular()+"',"
                                                            + " '"+c.getDireccion()+"', '"+c.getCorreo()+"', '"+c.getCiudad()+"', '"+c.getObservacion()+"', '"+c.getEstado()+"');");
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
    public int actualizarCliente( Cliente c) throws FileNotFoundException{
        control.ConectarBaseDatos();
        int result=0;
        try{
             if(c.getTipoCliente_id()==4){
                //c.setDigitoVerificacion("");
                PreparedStatement r= conexion.prepareStatement("UPDATE [maquilas].[dbo].[cliente] SET [digitoVerificacion] = NULL, [nombre] = '"+c.getNombre()+"', [tipoCliente_id] = '"+c.getTipoCliente_id()+"',"
                                                             + " [telefono] = '"+c.getTelefono()+"', [celular] = '"+c.getCelular()+"', [direccion] = '"+c.getDireccion()+"',"
                                                             + " [correo] = '"+c.getCorreo()+"', [ciudad] = '"+c.getCiudad()+"', [observacion] = '"+c.getObservacion()+"',"
                                                             + "[estado] = '"+c.getEstado()+"'"    
                                                             + " WHERE [nit] = '"+c.getNit()+"' AND [sucursal]='"+c.getSucursal()+"';");
                r.execute();
                result=1;
             }else{
                //Procedemos a calcular el Digito de Verificación
                String nitS = c.getNit();
                long nitL = Long.parseLong(nitS);
                CalcularDigitoVerificacion calDV = new CalcularDigitoVerificacion();
                c.setDigitoVerificacion(""+calDV.generarDv(nitL));
                
                PreparedStatement r= conexion.prepareStatement("UPDATE [maquilas].[dbo].[cliente] SET [digitoVerificacion] = '"+c.getDigitoVerificacion()+"', [nombre] = '"+c.getNombre()+"', [tipoCliente_id] = '"+c.getTipoCliente_id()+"',"
                                                         + " [telefono] = '"+c.getTelefono()+"', [celular] = '"+c.getCelular()+"', [direccion] = '"+c.getDireccion()+"',"
                                                         + " [correo] = '"+c.getCorreo()+"', [ciudad] = '"+c.getCiudad()+"', [observacion] = '"+c.getObservacion()+"',"
                                                         + "[estado] = '"+c.getEstado()+"'"    
                                                         + " WHERE [nit] = '"+c.getNit()+"' AND [sucursal]='"+c.getSucursal()+"';");
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
    public int validarExistenciaCliente(Cliente c){
        control.ConectarBaseDatos();
        int retorno=0;
        Statement statement = null;
        try{
            statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM [maquilas].[dbo].[cliente];");
            while(resultSet.next()){ 
                String nit= ""+c.getNit();
                String sucursal= ""+c.getSucursal();
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
    public ArrayList<Cliente> buscarCliente(String valorConsulta) throws SQLException{
        ArrayList<Cliente> listadoCliente = new ArrayList();
        control.ConectarBaseDatos();
        Statement statement = null;
        try{
            statement = conexion.createStatement();
            ResultSet resultSet;
            if(valorConsulta.equals("")){
                resultSet= statement.executeQuery("SELECT * FROM [maquilas].[dbo].[cliente];");
            }else{
                resultSet = statement.executeQuery("SELECT * FROM [maquilas].[dbo].[cliente] WHERE ([nit] like '%"+valorConsulta+"%' or [nombre] like '%"+valorConsulta+"%');");
            }
            while(resultSet.next()){ 
                Cliente c = new Cliente();       
                c.setNit(resultSet.getString(1));
                c.setDigitoVerificacion(resultSet.getString(2));
                c.setSucursal(Integer.parseInt(resultSet.getString(3)));
                c.setNombre(resultSet.getString(4));
                c.setTipoCliente_id(Integer.parseInt(resultSet.getString(5)));
                c.setTelefono(resultSet.getString(6));
                c.setCelular(resultSet.getString(7));
                c.setDireccion(resultSet.getString(8));
                c.setCorreo(resultSet.getString(9));
                c.setCiudad(resultSet.getString(10));
                c.setObservacion(resultSet.getString(11));
                c.setEstado(Integer.parseInt(resultSet.getString(12)));
                listadoCliente.add(c);
            }
        }catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null, "Error al tratar al consultar");
            sqlException.printStackTrace();
        } 
        control.cerrarConexionBaseDatos();
        return listadoCliente;
    } 
    public ArrayList<Cliente> buscarClienteLocalConsumo(String valorConsulta) throws SQLException{
        ArrayList<Cliente> listadoCliente = new ArrayList();
        control.ConectarBaseDatos();
        Statement statement = null;
        try{
            statement = conexion.createStatement();
            ResultSet resultSet;
            if(valorConsulta.equals("")){
                resultSet= statement.executeQuery("SELECT * FROM [maquilas].[dbo].[cliente] WHERE [nit]='900088695';");
            }else{
                resultSet = statement.executeQuery("SELECT * FROM [maquilas].[dbo].[cliente] WHERE ([nit] like '%"+valorConsulta+"%' or [nombre] like '%"+valorConsulta+"%')AND [nit]='900088695';");
            }
            while(resultSet.next()){ 
                Cliente c = new Cliente();       
                c.setNit(resultSet.getString(1));
                c.setDigitoVerificacion(resultSet.getString(2));
                c.setSucursal(Integer.parseInt(resultSet.getString(3)));
                c.setNombre(resultSet.getString(4));
                c.setTipoCliente_id(Integer.parseInt(resultSet.getString(5)));
                c.setTelefono(resultSet.getString(6));
                c.setCelular(resultSet.getString(7));
                c.setDireccion(resultSet.getString(8));
                c.setCorreo(resultSet.getString(9));
                c.setCiudad(resultSet.getString(10));
                c.setObservacion(resultSet.getString(11));
                c.setEstado(Integer.parseInt(resultSet.getString(12)));
                listadoCliente.add(c);
            }
        }catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null, "Error al tratar al consultar");
            sqlException.printStackTrace();
        } 
        control.cerrarConexionBaseDatos();
        return listadoCliente;
    }
    public ArrayList<Cliente> consultarUnicoCliente(Cliente c) throws SQLException{
        ArrayList<Cliente> listadoCliente = new ArrayList(); 
        control.ConectarBaseDatos();
        Statement statement = null;
        try{
            statement = conexion.createStatement();
            ResultSet resultSet = null;
            if(c != null){
                resultSet = statement.executeQuery("SELECT * FROM [maquilas].[dbo].[cliente]  WHERE [nit] ='"+c.getNit()+"' AND [sucursal] = '"+c.getSucursal()+"';");
                while(resultSet.next()){ 
                Cliente clienteRetorno = new Cliente();       
                clienteRetorno.setNit(resultSet.getString(1));
                clienteRetorno.setDigitoVerificacion(resultSet.getString(2));
                clienteRetorno.setSucursal(Integer.parseInt(resultSet.getString(3)));
                clienteRetorno.setNombre(resultSet.getString(4));
                clienteRetorno.setTipoCliente_id(Integer.parseInt(resultSet.getString(5)));
                clienteRetorno.setTelefono(resultSet.getString(6));
                clienteRetorno.setCelular(resultSet.getString(7));
                clienteRetorno.setDireccion(resultSet.getString(8));
                clienteRetorno.setCorreo(resultSet.getString(9));
                clienteRetorno.setCiudad(resultSet.getString(10));
                clienteRetorno.setObservacion(resultSet.getString(11));
                clienteRetorno.setEstado(Integer.parseInt(resultSet.getString(12)));
                listadoCliente.add(clienteRetorno);
            }
            }else{
               JOptionPane.showMessageDialog(null, "Verifique datos");
            }    
        }catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null, "Error al tratar al consultar");
            sqlException.printStackTrace();
        } 
        control.cerrarConexionBaseDatos();
        return listadoCliente;
    } 
    public int consultarConsecutivoSucursal(Cliente c){
        control.ConectarBaseDatos();
        int sucursal=0;
        Statement statement = null;
        try{
            statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT MAX([sucursal]) as sucursal FROM [maquilas].[dbo].[cliente] WHERE [nit]='"+c.getNit()+"';");
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
