package Controladores;

import GUI.CalcularDigitoVerificacion;
import Modelos.Cliente;
import Modelos.EmpresaLocal;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ControlDB_EmpresaLocal {
    
    private Connection conexion=null;
    private  ControlDB_DB control=null;    
    
    public ControlDB_EmpresaLocal() {
        control = new ControlDB_DB();
        conexion= control.ConectarBaseDatos();       
    } 
   
    public EmpresaLocal retornarEmpresaLocal(EmpresaLocal emp) throws SQLException{
        EmpresaLocal empresaL = new EmpresaLocal();
        control.ConectarBaseDatos();
        Statement statement = null;
        try{
            statement = conexion.createStatement();
            ResultSet resultSet= statement.executeQuery("SELECT * FROM [maquilas].[dbo].[empresalocal] WHERE [nit] ='"+emp.getNit()+"' and [sucursal] = '"+emp.getSucursal()+"';");
            while(resultSet.next()){ 
                empresaL.setNit(resultSet.getString(1));
                empresaL.setDigitoVerificacion(resultSet.getString(2));
                empresaL.setSucursal(Integer.parseInt(resultSet.getString(3)));
                empresaL.setNombre(resultSet.getString(4));
                empresaL.setTipoEmpresaLocal_id(Integer.parseInt(resultSet.getString(5)));
                empresaL.setTelefono(resultSet.getString(6));               
                empresaL.setCelular(resultSet.getString(7));
                empresaL.setDireccion(resultSet.getString(8));
                empresaL.setCorreo(resultSet.getString(9));
                empresaL.setCiudad(resultSet.getString(10));
                empresaL.setObservacion(resultSet.getString(11));
                empresaL.setEstado(Integer.parseInt(resultSet.getString(12)));
            }
        }catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null, "Error al tratar al consultar");
            sqlException.printStackTrace();
        } 
        control.cerrarConexionBaseDatos();
        return empresaL;
    } 
    public ArrayList<EmpresaLocal> consultarUnicaEmpresaLocal(EmpresaLocal emp) throws SQLException{
        ArrayList<EmpresaLocal> listadoEmpresaLocal = new ArrayList(); 
        control.ConectarBaseDatos();
        Statement statement = null;
        try{
            statement = conexion.createStatement();
            ResultSet resultSet = null;
            if(emp != null){
                resultSet = statement.executeQuery("SELECT * FROM [maquilas].[dbo].[empresalocal]  WHERE [nit] ='"+emp.getNit()+"' and [sucursal] = '"+emp.getSucursal()+"';");
                while(resultSet.next()){ 
                EmpresaLocal empresaL = new EmpresaLocal();       
                empresaL.setNit(resultSet.getString(1));
                empresaL.setDigitoVerificacion(resultSet.getString(2));
                empresaL.setSucursal(Integer.parseInt(resultSet.getString(3)));
                empresaL.setNombre(resultSet.getString(4));
                empresaL.setTipoEmpresaLocal_id(Integer.parseInt(resultSet.getString(5)));
                empresaL.setTelefono(resultSet.getString(6));               
                empresaL.setCelular(resultSet.getString(7));
                empresaL.setDireccion(resultSet.getString(8));
                empresaL.setCorreo(resultSet.getString(9));
                empresaL.setCiudad(resultSet.getString(10));
                empresaL.setObservacion(resultSet.getString(11));
                empresaL.setEstado(Integer.parseInt(resultSet.getString(12)));
                listadoEmpresaLocal.add(empresaL);
            }
            }else{
               JOptionPane.showMessageDialog(null, "Verifique datos");
            }    
        }catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null, "Error al tratar al consultar");
            sqlException.printStackTrace();
        } 
        control.cerrarConexionBaseDatos();
        return listadoEmpresaLocal;
    } 
    public int registrarEmpresaLocal(EmpresaLocal c) throws FileNotFoundException{
        Connection conexion= control.ConectarBaseDatos();
        int result=0;
        try{
            if(c.getTipoEmpresaLocal_id()==4){
                PreparedStatement r= conexion.prepareStatement("INSERT INTO [maquilas].[dbo].[empresaLocal] ([nit],[sucursal],[nombre], "
                                                            + "[tipoEmpresaLocal_id], [telefono], [celular], [direccion], [correo], "
                                                            + "[ciudad], [observacion], [estado]) VALUES "
                                                            + "('"+c.getNit()+"', '"+c.getSucursal()+"', '"+c.getNombre()+"', '"+c.getTipoEmpresaLocal_id()+"', '"+c.getTelefono()+"', '"+c.getCelular()+"',"
                                                            + " '"+c.getDireccion()+"', '"+c.getCorreo()+"', '"+c.getCiudad()+"', '"+c.getObservacion()+"', '"+c.getEstado()+"');");
                r.execute();
                result=1;
            }else{
                PreparedStatement r= conexion.prepareStatement("INSERT INTO [maquilas].[dbo].[empresaLocal] ([nit], [digitoVerificacion],[sucursal],[nombre], "
                                                            + "[tipoEmpresaLocal_id], [telefono], [celular], [direccion], [correo], "
                                                            + "[ciudad], [observacion], [estado]) VALUES "
                                                            + "('"+c.getNit()+"', '"+c.getDigitoVerificacion()+"', '"+c.getSucursal()+"', '"+c.getNombre()+"', '"+c.getTipoEmpresaLocal_id()+"', '"+c.getTelefono()+"', '"+c.getCelular()+"',"
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
    public int actualizarEmpresaLocal(EmpresaLocal c) throws FileNotFoundException{
        control.ConectarBaseDatos();
        int result=0;
        try{
             if(c.getTipoEmpresaLocal_id()==4){
                //c.setDigitoVerificacion("");
                PreparedStatement r= conexion.prepareStatement("UPDATE [maquilas].[dbo].[empresaLocal] SET [digitoVerificacion] = NULL, [nombre] = '"+c.getNombre()+"', [tipoEmpresaLocal_id] = '"+c.getTipoEmpresaLocal_id()+"',"
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
                
                PreparedStatement r= conexion.prepareStatement("UPDATE [maquilas].[dbo].[empresaLocal] SET [digitoVerificacion] = '"+c.getDigitoVerificacion()+"', [nombre] = '"+c.getNombre()+"', [tipoEmpresaLocal_id] = '"+c.getTipoEmpresaLocal_id()+"',"
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
    public int validarExistenciaEmpresaLocal(EmpresaLocal c){
        control.ConectarBaseDatos();
        int retorno=0;
        Statement statement = null;
        try{
            statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM [maquilas].[dbo].[empresaLocal];");
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
    public ArrayList<EmpresaLocal> buscarEmpresaLocal(String valorConsulta) throws SQLException{
        ArrayList<EmpresaLocal> listadoEmpresaLocal = new ArrayList();
        control.ConectarBaseDatos();
        Statement statement = null;
        try{
            statement = conexion.createStatement();
            ResultSet resultSet;
            if(valorConsulta.equals("")){
                resultSet= statement.executeQuery("SELECT * FROM [maquilas].[dbo].[empresaLocal];");
            }else{
                resultSet = statement.executeQuery("SELECT * FROM [maquilas].[dbo].[empresaLocal] WHERE ([nit] like '%"+valorConsulta+"%' or [nombre] like '%"+valorConsulta+"%');");
            }
            while(resultSet.next()){ 
                EmpresaLocal c = new EmpresaLocal();       
                c.setNit(resultSet.getString(1));
                c.setDigitoVerificacion(resultSet.getString(2));
                c.setSucursal(Integer.parseInt(resultSet.getString(3)));
                c.setNombre(resultSet.getString(4));
                c.setTipoEmpresaLocal_id(Integer.parseInt(resultSet.getString(5)));
                c.setTelefono(resultSet.getString(6));
                c.setCelular(resultSet.getString(7));
                c.setDireccion(resultSet.getString(8));
                c.setCorreo(resultSet.getString(9));
                c.setCiudad(resultSet.getString(10));
                c.setObservacion(resultSet.getString(11));
                c.setEstado(Integer.parseInt(resultSet.getString(12)));
                listadoEmpresaLocal.add(c);
            }
        }catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null, "Error al tratar al consultar");
            sqlException.printStackTrace();
        } 
        control.cerrarConexionBaseDatos();
        return listadoEmpresaLocal;
    } 
    public ArrayList<EmpresaLocal> consultarUnicoEmpresaLocal(EmpresaLocal c) throws SQLException{
        ArrayList<EmpresaLocal> listadoEmpresaLocal = new ArrayList(); 
        control.ConectarBaseDatos();
        Statement statement = null;
        try{
            statement = conexion.createStatement();
            ResultSet resultSet = null;
            if(c != null){
                resultSet = statement.executeQuery("SELECT * FROM [maquilas].[dbo].[empresaLocal]  WHERE [nit] ='"+c.getNit()+"' AND [sucursal] = '"+c.getSucursal()+"';");
                while(resultSet.next()){ 
                EmpresaLocal empresaLocalRetorno = new EmpresaLocal();       
                empresaLocalRetorno.setNit(resultSet.getString(1));
                empresaLocalRetorno.setDigitoVerificacion(resultSet.getString(2));
                empresaLocalRetorno.setSucursal(Integer.parseInt(resultSet.getString(3)));
                empresaLocalRetorno.setNombre(resultSet.getString(4));
                empresaLocalRetorno.setTipoEmpresaLocal_id(Integer.parseInt(resultSet.getString(5)));
                empresaLocalRetorno.setTelefono(resultSet.getString(6));
                empresaLocalRetorno.setCelular(resultSet.getString(7));
                empresaLocalRetorno.setDireccion(resultSet.getString(8));
                empresaLocalRetorno.setCorreo(resultSet.getString(9));
                empresaLocalRetorno.setCiudad(resultSet.getString(10));
                empresaLocalRetorno.setObservacion(resultSet.getString(11));
                empresaLocalRetorno.setEstado(Integer.parseInt(resultSet.getString(12)));
                listadoEmpresaLocal.add(empresaLocalRetorno);
            }
            }else{
               JOptionPane.showMessageDialog(null, "Verifique datos");
            }    
        }catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null, "Error al tratar al consultar");
            sqlException.printStackTrace();
        } 
        control.cerrarConexionBaseDatos();
        return listadoEmpresaLocal;
    } 
    public int consultarConsecutivoSucursal(EmpresaLocal c){
        control.ConectarBaseDatos();
        int sucursal=0;
        Statement statement = null;
        try{
            statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT MAX([sucursal]) as sucursal FROM [maquilas].[dbo].[empresaLocal] WHERE [nit]='"+c.getNit()+"';");
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
    
     /*public ArrayList<EmpresaLocal> buscarEmpresaLocal(String valorConsulta) throws SQLException{
        ArrayList<EmpresaLocal> listadoEmpresaLocal = new ArrayList();
        control.ConectarBaseDatos();
        Statement statement = null;
        ResultSet resultSet=null;
        try{
            statement = conexion.createStatement();
            if(valorConsulta.equals("")){
                resultSet= statement.executeQuery("SELECT * FROM [maquilas].[dbo].[empresalocal];");
            }else{
                resultSet = statement.executeQuery("SELECT * FROM [maquilas].[dbo].[empresalocal] WHERE ([nit] like '%"+valorConsulta+"%' or [nombre] like '%"+valorConsulta+"%');");
            }
            
            while(resultSet.next()){ 
                EmpresaLocal c = new EmpresaLocal();       
                c.setNit(resultSet.getString(1));
                c.setDigitoVerificacion(resultSet.getString(2));
                c.setSucursal(Integer.parseInt(resultSet.getString(3)));
                c.setNombre(resultSet.getString(4));
                c.setTipoEmpresaLocal_id(Integer.parseInt(resultSet.getString(5)));
                c.setTelefono(resultSet.getString(6));               
                c.setCelular(resultSet.getString(7));
                c.setDireccion(resultSet.getString(8));
                c.setCorreo(resultSet.getString(9));
                c.setCiudad(resultSet.getString(10));
                c.setObservacion(resultSet.getString(11));
                c.setEstado(Integer.parseInt(resultSet.getString(12)));
                listadoEmpresaLocal.add(c);
            }
        }catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null, "Error al tratar al consultar");
            sqlException.printStackTrace();
        } 
        control.cerrarConexionBaseDatos();
        return listadoEmpresaLocal;
    } */
}
