package Controladores;

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

public class ControlDB_VentaFacturacionPapel_AnulacionFactura {
    private Connection conexion=null;
    private  ControlDB_DB control=null;    
    private int consecutivoVenta=0;
    private int consecutivoAuditoria=0;
    public ControlDB_VentaFacturacionPapel_AnulacionFactura() {
        control = new ControlDB_DB();
        conexion= control.ConectarBaseDatos();       
    }     
    public int retornarElMaximo(){
         Connection conexion= control.ConectarBaseDatos();
        int retorno=0;
        Statement statement = null;
        try{
            statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT MAX(id) FROM facturaVentaPapel;");
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
    public int anularFacturaVenta(int idVenta, String Bodega, Usuario user) throws SQLException{
        ArrayList<ItemFactura> listadoItemFactura = null;
        listadoItemFactura = consultarItemFacturas(idVenta);
        if(listadoItemFactura != null){//Procedemos a actualizar los nuevos saldos de las Bodegas
               for(int i=0; i< listadoItemFactura.size(); i++){
                   actualizarSaldosEnBodega( listadoItemFactura.get(i).getIdIngresoProducto(),listadoItemFactura.get(i).getCantidad(),Bodega);
               }
        }
        control.ConectarBaseDatos();
        try{
            PreparedStatement actualizarEstadoFacturaVenta= conexion.prepareStatement("UPDATE [maquilas].[dbo].[facturaVentaPapel] SET [estado] = '0' "+
                    " WHERE [facturaVentaPapel].[id]= '"+idVenta+"';");
            actualizarEstadoFacturaVenta.execute();   
            JOptionPane.showMessageDialog(null, "La factura No."+idVenta+ " Se ha anulado con exito");
            
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
                                    + " '0', '"+idVenta+"', "
                            + " 'VentaPapel"+Bodega+"Anulacion', '"+Bodega+"','"+Bodega+"', '"+user.getId()+"', '0', '"+fechaRegistroSistemas+"');;");       
                    registrarAuditoria.execute();                
            
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error!!.. No se pudo actualizar el saldo en Bodega de la factura que desea Anular");
        }
        control.cerrarConexionBaseDatos();
        
        
        
        
        return 0;
    }      
    public ArrayList<ItemFactura> consultarItemFacturas(int idVenta) throws SQLException{
        ArrayList<ItemFactura> listadoItemFactura = new ArrayList(); 
        control.ConectarBaseDatos();
        try{
            Statement statement  = conexion.createStatement();
            ResultSet resultSet;
            //resultSet = statement.executeQuery("select * from ingresoproducto "+script+" and estado=1;");
            resultSet = statement.executeQuery("SELECT  [facturaVentaPapel_id]\n" +
                                    "      ,[ingresoProducto_id]\n" +
                                    "      ,[cantidad]\n" +
                                    "      ,[valorUnitarioKilo]\n" +
                                    "      ,[total]\n" +
                                    "  FROM [maquilas].[dbo].[itemFacturaPapel] WHERE [itemFacturaPapel].[facturaVentaPapel_id]='"+idVenta+"';");
                while(resultSet.next()){ 
                    ItemFactura itemfaturaVenta = new ItemFactura(); 
                    itemfaturaVenta.setIdFacturaVenta(Integer.parseInt(resultSet.getString(1)));
                    itemfaturaVenta.setIdIngresoProducto(Integer.parseInt(resultSet.getString(2)));
                    itemfaturaVenta.setCantidad(new BigDecimal(resultSet.getString(3)));
                    itemfaturaVenta.setValorUnitarioKilo(Double.parseDouble(resultSet.getString(4)));
                    itemfaturaVenta.setTotal(new BigDecimal(resultSet.getString(5)));
                    listadoItemFactura.add(itemfaturaVenta); 
            }         
        }catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null, "Error al tratar al consultar");
            sqlException.printStackTrace();
        } 
        control.cerrarConexionBaseDatos();
        return listadoItemFactura;
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
    public String retornarCantidadTotalFacturaVenta(int facturaVentaPapelId){
        Connection conexion= control.ConectarBaseDatos();
        String valor="";
            try{
                 Statement statement = conexion.createStatement();
                ResultSet resultSet = statement.executeQuery(""
                        + "SELECT TOP 1	\n" +
                        "		[CantidadSumada].[cantidadGeneral] AS facturaVentaPapel_Cantidad	\n" +
                        " FROM [maquilas].[dbo].[facturaVentaPapel] \n" +
                        "	INNER JOIN [dbo].[empresaLocal] \n" +
                        "		ON [facturaVentaPapel].[empresaLocal_nit]=[empresaLocal].[nit] \n" +
                        "			AND [facturaVentaPapel].[empresaLocal_sucursal]=[empresaLocal].[sucursal] \n" +
                        "	INNER JOIN [dbo].[usuario] \n" +
                        "		ON  [empresaLocal].[nit] = [usuario].[empresaLocal_nit]\n" +
                        "			AND [empresaLocal].[sucursal] = [usuario].[empresaLocal_sucursal] \n" +
                        "	INNER JOIN [dbo].[cliente]  \n" +
                        "		ON 	[cliente].[nit] = [facturaVentaPapel].[cliente_nit]\n" +
                        "			AND [cliente].[sucursal] = [facturaVentaPapel].[cliente_sucursal]\n" +
                        "	INNER JOIN [dbo].[itemFacturaPapel]  \n" +
                        "		ON [facturaVentaPapel].[id] = [itemFacturaPapel].[facturaVentaPapel_id]\n" +
                        "	INNER JOIN [dbo].[ingresoProducto]  \n" +
                        "		ON [itemFacturaPapel].[ingresoProducto_id] = [ingresoProducto].[id]\n" +
                        "	INNER JOIN [dbo].[producto] \n" +
                        "		ON	[ingresoProducto].[producto_id] = [producto].[id]\n" +
                        "	INNER JOIN [dbo].[unidad] \n" +
                        "		ON [unidad].[id] =[producto].[unidad_id]\n" +
                        "	INNER JOIN [dbo].[bodegaFacturaVenta] \n" +
                        "		ON [bodegaFacturaVenta].[id] =[facturaVentaPapel].[bodegaFacturaVenta_id]\n" +
                        "		INNER JOIN (SELECT facturaVentaPapel_id AS tablaX ,SUM(cantidad) AS cantidadGeneral FROM [dbo].[itemFacturaPapel] WHERE facturaVentaPapel_id='"+facturaVentaPapelId+"' GROUP BY facturaVentaPapel_id) AS CantidadSumada\n" +
                        "		ON [CantidadSumada].[tablaX]=[facturaVentaPapel].id\n" +
                        "	WHERE [facturaVentaPapel].[id]='"+facturaVentaPapelId+"';");
                while(resultSet.next()){ 
                     valor=resultSet.getString(1); 
                }
            }catch (SQLException sqlException){
                JOptionPane.showMessageDialog(null, "Error al Tratar de buscar");
                sqlException.printStackTrace();
            } 
        control.cerrarConexionBaseDatos();
        return valor;
    }
}




