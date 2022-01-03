package Controladores;

import Modelos.ItemConsumo;
import Modelos.ItemFactura;
import Modelos.Usuario;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

public class ControlDB_ConsumoAnulacion {
    private Connection conexion=null;
    private  ControlDB_DB control=null;   
    private int consecutivoAuditoria=0;
    
    public ControlDB_ConsumoAnulacion() {
        control = new ControlDB_DB();
        conexion= control.ConectarBaseDatos();       
    }     
     public int retornarElMaximoAuditoria(){
         Connection conexion= control.ConectarBaseDatos();
        int retorno=0;
        Statement statement = null;
        try{
            statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT MAX(id) FROM auditoria;");
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
    public int anularConsumo(int idConsumo, Usuario user) throws SQLException{
        ArrayList<ItemConsumo> listadoItemConsumo = null;
        listadoItemConsumo = consultarItemConsumos(idConsumo);
        if(listadoItemConsumo != null){//Procedemos a actualizar los nuevos saldos de las Bodegas
               for(int i=0; i< listadoItemConsumo.size(); i++){
                   actualizarSaldosEnBodega( listadoItemConsumo.get(i).getIdIngresoProducto(),listadoItemConsumo.get(i).getCantidad(),"Nacional");
               }
        }
        control.ConectarBaseDatos();
        try{
            PreparedStatement actualizarEstadoConsumo= conexion.prepareStatement("UPDATE [maquilas].[dbo].[consumo] SET [estado] = '0' "+
                    " WHERE [consumo].[id]= '"+idConsumo+"';");
            actualizarEstadoConsumo.execute();   
            JOptionPane.showMessageDialog(null, "El consumo No."+idConsumo+ " Se ha anulado con exito");
            
            //Procedemos a hacer el registro en la Tabla Auditoria
            Date fechaActual = new Date(); 
            String  fechaMovimiento =new SimpleDateFormat("yyyy-MM-dd").format(fechaActual);
            
                    String fechaRegistroSistemas="";//Sacamos la fecha del sistemas
                       try{//Sacamos DateTime del sistemas
                           Statement statement = null;
                           statement = conexion.createStatement();
                           ResultSet resultSet = statement.executeQuery("SELECT SYSDATETIME();");
                           while(resultSet.next()){ 
                               fechaRegistroSistemas=resultSet.getString(1);
                           }
                       }catch(Exception e){
                           JOptionPane.showMessageDialog(null, "No se pudo sacar DateTime del sistemas");
                       } 
                    //sacamos el maxímo de Auditoria______________________
                    try{
                       consecutivoAuditoria=retornarElMaximoAuditoria();
                       consecutivoAuditoria++;
                    }catch(Exception e){
                       consecutivoAuditoria++;                   
                    }                 
                    //___________________________________________________
                       
                    PreparedStatement registrarAuditoria= conexion.prepareStatement("INSERT INTO [maquilas].[dbo].[auditoria] "
                            + "([id],[fechaMovimiento], [cp],[idTipoMovimiento], [descripcionTipoMovimiento], [bodegaOrigen],[bodegaDestino], [usuario_id], [cantidad], "
                            + "[fechaRegistroSistema]) VALUES ('"+consecutivoAuditoria+"','"+fechaMovimiento+"',"
                                    + " '0', '"+idConsumo+"', "
                            + " 'ConsumoAnulacion', 'Nacional','Nacional', '"+user.getId()+"', '0', '"+fechaRegistroSistemas+"');;");       
                    registrarAuditoria.execute();
            
            
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error!!.. No se pudo actualizar el saldo en Bodega del consumo que desea Anular");
        }
        control.cerrarConexionBaseDatos();
        return 0;
    }      
    public ArrayList<ItemConsumo> consultarItemConsumos(int idConsumo) throws SQLException{
        ArrayList<ItemConsumo> listadoItemConsumo = new ArrayList(); 
        control.ConectarBaseDatos();
        try{
            Statement statement  = conexion.createStatement();
            ResultSet resultSet;
            //resultSet = statement.executeQuery("select * from ingresoproducto "+script+" and estado=1;");
            resultSet = statement.executeQuery("SELECT [ingresoProducto_id] " +
                                                "      ,[consumo_id] " +
                                                "      ,[cantidad] " +
                                                "      ,[valorUnitario] " +
                                                "      ,[total] " +
                                                "  FROM [maquilas].[dbo].[itemConsumo] WHERE [itemConsumo].[consumo_id]='"+idConsumo+"';");
                while(resultSet.next()){ 
                    ItemConsumo itemConsumo = new ItemConsumo(); 
                    itemConsumo.setIdIngresoProducto(Integer.parseInt(resultSet.getString(1)));
                    itemConsumo.setIdConsumo(Integer.parseInt(resultSet.getString(2)));
                    itemConsumo.setCantidad(new BigDecimal(resultSet.getString(3)));
                    itemConsumo.setValorUnitarioKilo(Double.parseDouble(resultSet.getString(4)));
                    itemConsumo.setTotal(new BigDecimal(resultSet.getString(5)));
                    listadoItemConsumo.add(itemConsumo); 
            }         
        }catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null, "Error al tratar al consultar");
            sqlException.printStackTrace();
        } 
        control.cerrarConexionBaseDatos();
        return listadoItemConsumo;
    }  
    public void actualizarSaldosEnBodega(int ingresoProducto_id, BigDecimal cantidad, String Bodega){
        BigDecimal saldo=new BigDecimal(""+retornarSaldoBodegaIngresoProducto(ingresoProducto_id, Bodega));
        BigDecimal saldoNuevo= saldo.add(cantidad);         
        control.ConectarBaseDatos();
        try{
            int resultado=0;
            if(Bodega.equals("Extranjera")){
                try{
                    PreparedStatement r= conexion.prepareStatement("UPDATE [maquilas].[dbo].[bodega_ingresoproducto] SET [saldo] = '"+saldoNuevo.toPlainString()+"' "+
                            "WHERE [bodega_ingresoproducto].[bodega_id] = 1 AND [bodega_ingresoproducto].[ingresoProducto_id] = '"+ingresoProducto_id+"';");
                    r.execute();
                    resultado=1;
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, "Error!!.. No se pudo actualizar el saldo en Bodega de la factura que desea Anular");
                }
            }else{
                try{
                    if(Bodega.equals("Nacional")){
                        PreparedStatement z= conexion.prepareStatement("UPDATE [maquilas].[dbo].[bodega_ingresoproducto] SET [saldo] = '"+saldoNuevo.toPlainString()+"' "+
                                "WHERE [bodega_ingresoproducto].[bodega_id] = 2 AND [bodega_ingresoproducto].[ingresoProducto_id] = '"+ingresoProducto_id+"';");
                        z.execute();
                        resultado=1;
                    }
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, "Error!!.. No se pudo actualizar el saldo en Bodega de la factura que desea Anular");
                }
            }
            if(resultado ==1){//Activamos nuevamente el CP, por si ya se le había terminado el Saldo
                validadorSaldosIngresoProducto(ingresoProducto_id);
            }
        }catch (Exception e){   
            JOptionPane.showMessageDialog(null, "ERROR al querer insertar los datos.");
        }  
        control.cerrarConexionBaseDatos();
    }                    
    public BigDecimal retornarSaldoBodegaIngresoProducto(int ingresoProducto_id, String Bodega){
        Connection conexion= control.ConectarBaseDatos();
        BigDecimal saldo=new java.math.BigDecimal("0");
        if(Bodega.equals("Extranjera")){
            Statement statement = null;
            try{
                statement = conexion.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT [saldo] FROM [maquilas].[dbo].[bodega_ingresoproducto] WHERE [bodega_id]=1 AND [ingresoProducto_id]='"+ingresoProducto_id+"';");
                while(resultSet.next()){ 
                    String valor=resultSet.getString(1);
                    saldo=new java.math.BigDecimal(valor);
                }
            }catch (SQLException sqlException){
                JOptionPane.showMessageDialog(null, "Error al Tratar de buscar");
                sqlException.printStackTrace();
            } 
        }else{
            if(Bodega.equals("Nacional")){
                Statement statement = null;
                try{
                    statement = conexion.createStatement();
                    ResultSet resultSet = statement.executeQuery("SELECT [saldo] FROM [maquilas].[dbo].[bodega_ingresoproducto] WHERE [bodega_id]=2 AND [ingresoProducto_id]='"+ingresoProducto_id+"';");
                    while(resultSet.next()){ 
                        String valor=resultSet.getString(1);
                        saldo=new java.math.BigDecimal(valor);
                    }
                }catch (SQLException sqlException){
                    JOptionPane.showMessageDialog(null, "Error al Tratar de buscar");
                    sqlException.printStackTrace();
                } 
            }
        }
        control.cerrarConexionBaseDatos();
        return saldo;
    }   
    public void validadorSaldosIngresoProducto(int ingresoProducto_id){
        Connection conexion= control.ConectarBaseDatos();
        int contador=0;
        Statement statement = null;
        int result=0;
        try{
            statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM [maquilas].[dbo].[bodega_ingresoproducto] WHERE [ingresoProducto_id]='"+ingresoProducto_id+"' AND [saldo]=0;");
            while(resultSet.next()){ 
                contador++;
            }
        }catch (SQLException sqlException){
            JOptionPane.showMessageDialog(null, "Error al Tratar de buscar");
            sqlException.printStackTrace();
        } 
        switch(contador){
            case 1:{//Una sola Bodega tiene el saldo en Cero por tal motivo Se actualiza Estado a 1
                try{
                    PreparedStatement r= conexion.prepareStatement("UPDATE [ingresoproducto] SET [estado] = '1' WHERE [id] = '"+ingresoProducto_id+"';");
                    r.execute();
                    result=1;
                }
                catch (SQLException sqlException ){   
                    result=0;
                    JOptionPane.showMessageDialog(null, "ERROR al querer insertar los datos.");
                    sqlException.printStackTrace();
                }  
                break;
            }
            case 2:{// Ambas Bodegas se encuentra con saldos de Cero, tanto Nacional como Extranjeras
                try{
                    PreparedStatement r= conexion.prepareStatement("UPDATE [ingresoproducto] SET [estado] = '0' WHERE [id] = '"+ingresoProducto_id+"';");
                    r.execute();
                    result=1;
                }
                catch (SQLException sqlException ){   
                    result=0;
                    JOptionPane.showMessageDialog(null, "ERROR al querer insertar los datos.");
                    sqlException.printStackTrace();
                }  
                break;
            }
            default:{//Ninguna Bodega tiene el saldo en Cero por tal motivo Se actualiza Estado a 1
                try{
                    PreparedStatement r= conexion.prepareStatement("UPDATE [ingresoproducto] SET [estado] = '1' WHERE [id] = '"+ingresoProducto_id+"';");
                    r.execute();
                    result=1;
                }
                catch (SQLException sqlException ){   
                    result=0;
                    JOptionPane.showMessageDialog(null, "ERROR al querer insertar los datos.");
                    sqlException.printStackTrace();
                } 
                break;
            }
        }
        control.cerrarConexionBaseDatos();
    }
}
