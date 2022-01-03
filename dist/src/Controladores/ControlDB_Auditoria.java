package Controladores;

import Modelos.Auditoria;
import Modelos.EmpresaLocal;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ControlDB_Auditoria { 
    private Connection conexion=null;
    private  ControlDB_DB control=null;    
    
    public ControlDB_Auditoria() {
        control = new ControlDB_DB();
        conexion= control.ConectarBaseDatos();       
    }
    public ArrayList<Auditoria> buscarAuditoria(String valorConsulta) throws SQLException{
        ArrayList<Auditoria> listadoAuditoria = new ArrayList();
        control.ConectarBaseDatos();
        Statement statement = null;
        ResultSet resultSet=null;
        try{
            statement = conexion.createStatement();
            if(valorConsulta.equals("")){
                resultSet= statement.executeQuery("SELECT TOP 1000 * FROM [maquilas].[dbo].[auditoria];");
            }else{
                resultSet = statement.executeQuery("SELECT TOP 1000 * FROM [maquilas].[dbo].[auditoria] WHERE ([cp] like '%"+valorConsulta+"%');");
            }
            while(resultSet.next()){ 
                Auditoria auditoria = new Auditoria();       
                auditoria.setId(resultSet.getString(1));
                auditoria.setFechaMovimiento((resultSet.getString(2)));
                auditoria.setCp(resultSet.getString(3));
                auditoria.setIdTipoMovimiento(resultSet.getString(4));
                auditoria.setDescripcionTipoMovimiento(resultSet.getString(5));
                auditoria.setBodegaOrigen(resultSet.getString(6));
                auditoria.setBodegaDestino(resultSet.getString(7));
                auditoria.setUsuario_id(Integer.parseInt(resultSet.getString(8)));
                auditoria.setCantidad(new BigDecimal(resultSet.getString(9)));
                auditoria.setFechaRegistroSistema((resultSet.getString(10)));
                listadoAuditoria.add(auditoria);
            }
        }catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null, "Error al tratar al consultar");
            sqlException.printStackTrace();
        } 
        control.cerrarConexionBaseDatos();
        return listadoAuditoria;
    } 
    public int actualizarEmpresaLocal( EmpresaLocal c) throws FileNotFoundException{
        control.ConectarBaseDatos();
        int result=0;
        try{
             PreparedStatement r= conexion.prepareStatement("UPDATE [maquilas].[dbo].[empresalocal] SET [nombre] = '"+c.getNombre()+"', "
                    + " [direccion] = '"+c.getDireccion()+"', [telefono] = '"+c.getTelefono()+"', [celular] = '"+c.getCelular()+"', "
                    + " [correo] = '"+c.getCorreo()+"', [ciudad] = '"+c.getCiudad()+"', [estado] = '"+c.getEstado()+"' "
                    + " WHERE [nit] = "+c.getNit()+" AND [sucursal] = '"+c.getSucursal()+"';"); 
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
    public EmpresaLocal retornarEmpresaLocal() throws SQLException{
        EmpresaLocal empresaL = new EmpresaLocal();
        control.ConectarBaseDatos();
        Statement statement = null;
        try{
            statement = conexion.createStatement();
            ResultSet resultSet= statement.executeQuery("SELECT * FROM [maquilas].[dbo].[empresalocal]");
            while(resultSet.next()){ 
                empresaL.setNit(resultSet.getString(1));
                empresaL.setDigitoVerificacion(resultSet.getString(2));
                empresaL.setSucursal(Integer.parseInt(resultSet.getString(3)));
                empresaL.setNombre(resultSet.getString(4));
                empresaL.setDireccion(resultSet.getString(5));
                empresaL.setTelefono(resultSet.getString(6));
                empresaL.setCelular(resultSet.getString(7));
                empresaL.setCorreo(resultSet.getString(8));
                empresaL.setCiudad(resultSet.getString(9));
                empresaL.setEstado(Integer.parseInt(resultSet.getString(10)));
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
                empresaL.setDireccion(resultSet.getString(5));
                empresaL.setTelefono(resultSet.getString(6));
                empresaL.setCelular(resultSet.getString(7));
                empresaL.setCorreo(resultSet.getString(8));
                empresaL.setCiudad(resultSet.getString(9));
                empresaL.setEstado(Integer.parseInt(resultSet.getString(10)));
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
}
