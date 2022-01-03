
package Controladores;

import Modelos.Bodega;
import Modelos.IngresoProducto;
import Modelos.Proveedor;
import Modelos.Usuario;
import java.io.FileNotFoundException;
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

public class ControlDB_Compra {
    private Connection conexion=null;
    private  ControlDB_DB control=null;   
    int consecutivoFactura=0;
    int consecutivoAuditoria=0;
    public ControlDB_Compra() {
        control = new ControlDB_DB();
        conexion= control.ConectarBaseDatos();       
    }   
    public int retornarElMaximo(){
         Connection conexion= control.ConectarBaseDatos();
        int retorno=0;
        Statement statement = null;
        try{
            statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT MAX(id) FROM ingresoproducto;");
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
    public int registrarCompra(IngresoProducto ingresoProducto, Bodega bodega, Usuario user) throws FileNotFoundException, SQLException{
       Connection conexion= control.ConectarBaseDatos();
        int result=0;
        try{
            //Calculamos el costo Total
            BigDecimal costoTotal;
            costoTotal=new java.math.BigDecimal(ingresoProducto.getCantidadInicial().toString());
            costoTotal =costoTotal.multiply(new java.math.BigDecimal(ingresoProducto.getValorUnitario().toString()));   
            
            //#########################################################
               try{
                   consecutivoFactura=retornarElMaximo();
                   consecutivoFactura++;
               }catch(Exception e){
                   consecutivoFactura++;                   
               }            
               /*System.out.println("INSERT INTO [maquilas].[dbo].[ingresoproducto] ([id],[cp], [proveedor_nit], [proveedor_sucursal]," +
                    " [producto_id], [numeroFacturaProveedor], [resolucionFactura], [fechaResolucion]," +
                    " [fechaCompra], [fechaMaximaExportacion], [cantidadInicial], [valorUnitario], [observacion], [estado],[nombreQuienElabora],[bodega_ingresoProductoInicial_id],[costoTotal])" +
                    " VALUES ('"+consecutivoFactura+"','"+ingresoProducto.getCp()+"', '"+ingresoProducto.getProveedor_nit()+"', '"+ingresoProducto.getProveedor_sucursal()+"', "
                            + " '"+ingresoProducto.getProducto_id()+"', '"+ingresoProducto.getNumeroFacturaProveedor()+"', '"+ingresoProducto.getResolucionFactura()+"'," +
                    " '"+convertirFormatoFecha(ingresoProducto.getFechaResolucion())+"', '"+convertirFormatoFecha(ingresoProducto.getFechaCompra())+"', '"+convertirFormatoFecha(ingresoProducto.getFechaMaximaExportacion())+"', '"+ingresoProducto.getCantidadInicial().toString()+"', "
                            + "'"+ingresoProducto.getValorUnitario().toString()+"', "
                                    + "'"+ingresoProducto.getObservacion()+"',"
                                            + " '"+ingresoProducto.getEstado()+"',"
                                                    + " '"+ingresoProducto.getNombreQuienElabora()+"',"
                                                            + " '"+ingresoProducto.getBodega_ingresoProductoInicial()+"',"
                                                                    + " '"+costoTotal+"');");*/
           
              System.out.println(""+"INSERT INTO [maquilas].[dbo].[ingresoproducto] ([id],[cp], [proveedor_nit], [proveedor_sucursal]," +
                    " [producto_id], [numeroFacturaProveedor], [resolucionFactura], [fechaResolucion]," +
                    " [fechaCompra], [fechaMaximaExportacion], [cantidadInicial], [valorUnitario], [observacion], [estado],[nombreQuienElabora],[bodega_ingresoProductoInicial_id],[costoTotal])" +
                    " VALUES ('"+consecutivoFactura+"','"+ingresoProducto.getCp()+"', '"+ingresoProducto.getProveedor_nit()+"', '"+ingresoProducto.getProveedor_sucursal()+"', "
                            + " '"+ingresoProducto.getProducto_id()+"', '"+ingresoProducto.getNumeroFacturaProveedor()+"', '"+ingresoProducto.getResolucionFactura()+"'," +
                    " '"+convertirFormatoFecha(ingresoProducto.getFechaResolucion())+"', '"+convertirFormatoFecha(ingresoProducto.getFechaCompra())+"', '"+convertirFormatoFecha(ingresoProducto.getFechaMaximaExportacion())+"', '"+ingresoProducto.getCantidadInicial().toString()+"', "
                            + "'"+ingresoProducto.getValorUnitario().toString()+"', "
                                    + "'"+ingresoProducto.getObservacion()+"',"
                                            + " '"+ingresoProducto.getEstado()+"',"
                                                    + " '"+ingresoProducto.getNombreQuienElabora()+"',"
                                                            + " '"+ingresoProducto.getBodega_ingresoProductoInicial()+"',"
                                                                    + " '"+costoTotal+"'););");
               
               PreparedStatement r= conexion.prepareStatement("INSERT INTO [maquilas].[dbo].[ingresoproducto] ([id],[cp], [proveedor_nit], [proveedor_sucursal]," +
                    " [producto_id], [numeroFacturaProveedor], [resolucionFactura], [fechaResolucion]," +
                    " [fechaCompra], [fechaMaximaExportacion], [cantidadInicial], [valorUnitario], [observacion], [estado],[nombreQuienElabora],[bodega_ingresoProductoInicial_id],[costoTotal])" +
                    " VALUES ('"+consecutivoFactura+"','"+ingresoProducto.getCp()+"', '"+ingresoProducto.getProveedor_nit()+"', '"+ingresoProducto.getProveedor_sucursal()+"', "
                            + " '"+ingresoProducto.getProducto_id()+"', '"+ingresoProducto.getNumeroFacturaProveedor()+"', '"+ingresoProducto.getResolucionFactura()+"'," +
                    " '"+convertirFormatoFecha(ingresoProducto.getFechaResolucion())+"', '"+convertirFormatoFecha(ingresoProducto.getFechaCompra())+"', '"+convertirFormatoFecha(ingresoProducto.getFechaMaximaExportacion())+"', '"+ingresoProducto.getCantidadInicial().toString()+"', "
                            + "'"+ingresoProducto.getValorUnitario().toString()+"', "
                                    + "'"+ingresoProducto.getObservacion()+"',"
                                            + " '"+ingresoProducto.getEstado()+"',"
                                                    + " '"+ingresoProducto.getNombreQuienElabora()+"',"
                                                            + " '"+ingresoProducto.getBodega_ingresoProductoInicial()+"',"
                                                                    + " '"+costoTotal+"');");       
            r.execute();
            result=1;
            int ingresoProductoId=retornarElMaximo();
            try{
                //Registramos la entrada en las dos Bodegas /Nacional y Extrajera, una contiene la
                //totalidad de cantidad Producto y otra inicia con valor de Cero para cuando se 
                //hagan movimientos de producto
                PreparedStatement registrarBodegaingresoProcto= conexion.prepareStatement("INSERT INTO [maquilas].[dbo].[bodega_ingresoproducto] ([bodega_id], [ingresoProducto_id], [saldo]) VALUES ('"+bodega.getId()+"', '"+ingresoProductoId+"', '"+ingresoProducto.getCantidadInicial().toString()+"');;");       
                registrarBodegaingresoProcto.execute();
                
                if(bodega.getId()==1){
                    PreparedStatement registrarBodegaingresoProducto_SegundaBodega= conexion.prepareStatement("INSERT INTO [maquilas].[dbo].[bodega_ingresoproducto] ([bodega_id], [ingresoProducto_id], [saldo]) VALUES ('2', '"+ingresoProductoId+"', '0');");       
                    registrarBodegaingresoProducto_SegundaBodega.execute();
                }else{
                     if(bodega.getId()==2){
                        PreparedStatement registrarBodegaingresoProducto_SegundaBodega= conexion.prepareStatement("INSERT INTO [maquilas].[dbo].[bodega_ingresoproducto] ([bodega_id], [ingresoProducto_id], [saldo]) VALUES ('1', '"+ingresoProductoId+"', '0');");       
                        registrarBodegaingresoProducto_SegundaBodega.execute();
                    }
                }
                //Procedemos a hacer el registro en la Tabla Auditoria
                 String fechaRegistroSistemas="";
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
                 //#########################################################
                try{
                   consecutivoAuditoria=retornarElMaximoAuditoria();
                   consecutivoAuditoria++;
                }catch(Exception e){
                   consecutivoAuditoria++;                   
                }                 
                //___________________________________________________
                
                ControlDB_Bodega  controlDB_Bodega = new ControlDB_Bodega();
                PreparedStatement registrarAuditoria= conexion.prepareStatement("INSERT INTO [maquilas].[dbo].[auditoria] "
                        + "([id],[fechaMovimiento], [cp],[idTipoMovimiento], [descripcionTipoMovimiento]  "
                        + ", [bodegaOrigen],[bodegaDestino], [usuario_id], [cantidad], "
                        + "[fechaRegistroSistema]) VALUES ('"+consecutivoAuditoria+"','"+ingresoProducto.getFechaCompra()+"',"
                                + " '"+ingresoProducto.getCp()+"','"+ingresoProductoId+"', "
                        + " 'Compra', '"+controlDB_Bodega.RetornoNombreBodega(ingresoProducto.getBodega_ingresoProductoInicial())+"', '"+controlDB_Bodega.RetornoNombreBodega(ingresoProducto.getBodega_ingresoProductoInicial())+"','"+user.getId()+"', '"+ingresoProducto.getCantidadInicial()+"','"+fechaRegistroSistemas+"');;");       
                registrarAuditoria.execute();                
                result=1;
            }catch(Exception sqlException){
                result=0;
                JOptionPane.showMessageDialog(null, "ERROR al querer insertar los datos.");
                sqlException.printStackTrace();
            }
        }catch (SQLException sqlException ){   
            result=0;
            JOptionPane.showMessageDialog(null, "ERROR al querer insertar los datos.");
            sqlException.printStackTrace();
        }  
        control.cerrarConexionBaseDatos();
        return result;
    }        
    public ArrayList<IngresoProducto> consultarCompras(String script) throws SQLException{
        ArrayList<IngresoProducto> listadoIngresoProducto = new ArrayList(); 
        control.ConectarBaseDatos();
        try{
            Statement statement  = conexion.createStatement();
            ResultSet resultSet;
            if(script.equals("")){
                //resultSet = statement.executeQuery("SELECT  TOP 300 * FROM [maquilas].[dbo].[ingresoproducto] WHERE [estado]=1;");
                resultSet = statement.executeQuery("SELECT [id]\n" +
                                                "      ,[cp]\n" +
                                                "      ,[proveedor_nit]\n" +
                                                "      ,[proveedor_sucursal]\n" +
                                                "      ,[producto_id]\n" +
                                                "      ,[numeroFacturaProveedor]\n" +
                                                "      ,[resolucionFactura]\n" +
                                                "      ,[fechaResolucion]\n" +
                                                "      ,[fechaCompra]\n" +
                                                "      ,[fechaMaximaExportacion]\n" +
                                                "      ,[cantidadInicial]\n" +
                                                "      ,[valorUnitario]\n" +
                                                "      ,[observacion]\n" +
                                                "      ,[estado]\n" +
                                                "      ,[nombreQuienElabora]\n" +
                                                "      ,[bodega_ingresoProductoInicial_id]\n" +
                                                "      ,[costoTotal]\n" +
                                                "	  --Proveedor\n" +
                                                "	  ,prov.[nit]\n" +
                                                "      ,prov.[digitoVerificacion]\n" +
                                                "      ,prov.[sucursal]\n" +
                                                "      ,prov.[nombre]\n" +
                                                "  FROM [maquilas].[dbo].[ingresoProducto] \n" +
                                                "  INNER JOIN (SELECT [nit]\n" +
                                                "      ,[digitoVerificacion]\n" +
                                                "      ,[sucursal]\n" +
                                                "      ,[nombre]  FROM [maquilas].[dbo].[proveedor]) prov ON prov.[nit]= [proveedor_nit] AND prov.[sucursal]=[proveedor_sucursal] WHERE [estado]=1;");
            }else{
                resultSet = statement.executeQuery("SELECT [id]\n" +
                                                "      ,[cp]\n" +
                                                "      ,[proveedor_nit]\n" +
                                                "      ,[proveedor_sucursal]\n" +
                                                "      ,[producto_id]\n" +
                                                "      ,[numeroFacturaProveedor]\n" +
                                                "      ,[resolucionFactura]\n" +
                                                "      ,[fechaResolucion]\n" +
                                                "      ,[fechaCompra]\n" +
                                                "      ,[fechaMaximaExportacion]\n" +
                                                "      ,[cantidadInicial]\n" +
                                                "      ,[valorUnitario]\n" +
                                                "      ,[observacion]\n" +
                                                "      ,[estado]\n" +
                                                "      ,[nombreQuienElabora]\n" +
                                                "      ,[bodega_ingresoProductoInicial_id]\n" +
                                                "      ,[costoTotal]\n" +
                                                "	  --Proveedor\n" +
                                                "	  ,prov.[nit]\n" +
                                                "      ,prov.[digitoVerificacion]\n" +
                                                "      ,prov.[sucursal]\n" +
                                                "      ,prov.[nombre]\n" +
                                                "  FROM [maquilas].[dbo].[ingresoProducto] \n" +
                                                "  INNER JOIN (SELECT [nit]\n" +
                                                "      ,[digitoVerificacion]\n" +
                                                "      ,[sucursal]\n" +
                                                "      ,[nombre]  FROM [maquilas].[dbo].[proveedor]) prov ON prov.[nit]= [proveedor_nit] AND prov.[sucursal]=[proveedor_sucursal] "+script+" and [estado]=1;");
            }
            while(resultSet.next()){ 
                IngresoProducto ingresoProducto = new IngresoProducto(); 
                ingresoProducto.setId(resultSet.getString(1));
                ingresoProducto.setCp(resultSet.getString(2));
                ingresoProducto.setProveedor_nit(resultSet.getString(3));
                ingresoProducto.setProveedor_sucursal(Integer.parseInt(resultSet.getString(4)));
                ingresoProducto.setProducto_id(Integer.parseInt(resultSet.getString(5)));
                ingresoProducto.setNumeroFacturaProveedor(resultSet.getString(6));
                ingresoProducto.setResolucionFactura(resultSet.getString(7));
                ingresoProducto.setFechaResolucion(resultSet.getString(8));
                ingresoProducto.setFechaCompra(resultSet.getString(9));
                ingresoProducto.setFechaMaximaExportacion(resultSet.getString(10));
                ingresoProducto.setCantidadInicial(new java.math.BigDecimal(resultSet.getString(11)));
                ingresoProducto.setValorUnitario(new java.math.BigDecimal(resultSet.getString(12)));
                ingresoProducto.setObservacion(resultSet.getString(13));
                ingresoProducto.setEstado(Integer.parseInt(resultSet.getString(14)));
                ingresoProducto.setNombreQuienElabora(resultSet.getString(15));
                ingresoProducto.setBodega_ingresoProductoInicial(Integer.parseInt(resultSet.getString(16)));
                ingresoProducto.setCostoTotal(new java.math.BigDecimal(resultSet.getString(17)));
                listadoIngresoProducto.add(ingresoProducto); 
            }         
        }catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null, "Error al tratar al consultar");
            sqlException.printStackTrace();
        } 
        control.cerrarConexionBaseDatos();
        return listadoIngresoProducto;
    } 
    public ArrayList<IngresoProducto> consultarComprasActivasAnuladas(String script) throws SQLException{
        ArrayList<IngresoProducto> listadoIngresoProducto = new ArrayList(); 
        control.ConectarBaseDatos();
        try{
            Statement statement  = conexion.createStatement();
            ResultSet resultSet;
            if(script.equals("")){
                //resultSet = statement.executeQuery("SELECT  TOP 300 * FROM [maquilas].[dbo].[ingresoproducto] WHERE [estado]=1;");
                resultSet = statement.executeQuery("SELECT [id]\n" +
                                                "      ,[cp]\n" +
                                                "      ,[proveedor_nit]\n" +
                                                "      ,[proveedor_sucursal]\n" +
                                                "      ,[producto_id]\n" +
                                                "      ,[numeroFacturaProveedor]\n" +
                                                "      ,[resolucionFactura]\n" +
                                                "      ,[fechaResolucion]\n" +
                                                "      ,[fechaCompra]\n" +
                                                "      ,[fechaMaximaExportacion]\n" +
                                                "      ,[cantidadInicial]\n" +
                                                "      ,[valorUnitario]\n" +
                                                "      ,[observacion]\n" +
                                                "      ,[estado]\n" +
                                                "      ,[nombreQuienElabora]\n" +
                                                "      ,[bodega_ingresoProductoInicial_id]\n" +
                                                "      ,[costoTotal]\n" +
                                                "	  --Proveedor\n" +
                                                "	  ,prov.[nit]\n" +
                                                "      ,prov.[digitoVerificacion]\n" +
                                                "      ,prov.[sucursal]\n" +
                                                "      ,prov.[nombre]\n" +
                                                "  FROM [maquilas].[dbo].[ingresoProducto] \n" +
                                                "  INNER JOIN (SELECT [nit]\n" +
                                                "      ,[digitoVerificacion]\n" +
                                                "      ,[sucursal]\n" +
                                                "      ,[nombre]  FROM [maquilas].[dbo].[proveedor]) prov ON prov.[nit]= [proveedor_nit] AND prov.[sucursal]=[proveedor_sucursal] WHERE [estado]=1 OR [estado]=2;");
            }else{
                resultSet = statement.executeQuery("SELECT [id]\n" +
                                                "      ,[cp]\n" +
                                                "      ,[proveedor_nit]\n" +
                                                "      ,[proveedor_sucursal]\n" +
                                                "      ,[producto_id]\n" +
                                                "      ,[numeroFacturaProveedor]\n" +
                                                "      ,[resolucionFactura]\n" +
                                                "      ,[fechaResolucion]\n" +
                                                "      ,[fechaCompra]\n" +
                                                "      ,[fechaMaximaExportacion]\n" +
                                                "      ,[cantidadInicial]\n" +
                                                "      ,[valorUnitario]\n" +
                                                "      ,[observacion]\n" +
                                                "      ,[estado]\n" +
                                                "      ,[nombreQuienElabora]\n" +
                                                "      ,[bodega_ingresoProductoInicial_id]\n" +
                                                "      ,[costoTotal]\n" +
                                                "	  --Proveedor\n" +
                                                "	  ,prov.[nit]\n" +
                                                "      ,prov.[digitoVerificacion]\n" +
                                                "      ,prov.[sucursal]\n" +
                                                "      ,prov.[nombre]\n" +
                                                "  FROM [maquilas].[dbo].[ingresoProducto] \n" +
                                                "  INNER JOIN (SELECT [nit]\n" +
                                                "      ,[digitoVerificacion]\n" +
                                                "      ,[sucursal]\n" +
                                                "      ,[nombre]  FROM [maquilas].[dbo].[proveedor]) prov ON prov.[nit]= [proveedor_nit] AND prov.[sucursal]=[proveedor_sucursal] "+script+" and [estado]=1 OR [estado]=2;");
            }
            while(resultSet.next()){ 
                IngresoProducto ingresoProducto = new IngresoProducto(); 
                ingresoProducto.setId(resultSet.getString(1));
                ingresoProducto.setCp(resultSet.getString(2));
                ingresoProducto.setProveedor_nit(resultSet.getString(3));
                ingresoProducto.setProveedor_sucursal(Integer.parseInt(resultSet.getString(4)));
                ingresoProducto.setProducto_id(Integer.parseInt(resultSet.getString(5)));
                ingresoProducto.setNumeroFacturaProveedor(resultSet.getString(6));
                ingresoProducto.setResolucionFactura(resultSet.getString(7));
                ingresoProducto.setFechaResolucion(resultSet.getString(8));
                ingresoProducto.setFechaCompra(resultSet.getString(9));
                ingresoProducto.setFechaMaximaExportacion(resultSet.getString(10));
                ingresoProducto.setCantidadInicial(new java.math.BigDecimal(resultSet.getString(11)));
                ingresoProducto.setValorUnitario(new java.math.BigDecimal(resultSet.getString(12)));
                ingresoProducto.setObservacion(resultSet.getString(13));
                ingresoProducto.setEstado(Integer.parseInt(resultSet.getString(14)));
                ingresoProducto.setNombreQuienElabora(resultSet.getString(15));
                ingresoProducto.setBodega_ingresoProductoInicial(Integer.parseInt(resultSet.getString(16)));
                ingresoProducto.setCostoTotal(new java.math.BigDecimal(resultSet.getString(17)));
                listadoIngresoProducto.add(ingresoProducto); 
            }         
        }catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null, "Error al tratar al consultar");
            sqlException.printStackTrace();
        } 
        control.cerrarConexionBaseDatos();
        return listadoIngresoProducto;
    } 
    public ArrayList<IngresoProducto> consultarComprasActivasAnuladasInactivas(String script) throws SQLException{
        ArrayList<IngresoProducto> listadoIngresoProducto = new ArrayList(); 
        control.ConectarBaseDatos();
        try{
            Statement statement  = conexion.createStatement();
            ResultSet resultSet;
            if(script.equals("")){
                //resultSet = statement.executeQuery("SELECT  TOP 300 * FROM [maquilas].[dbo].[ingresoproducto] WHERE [estado]=1;");
                resultSet = statement.executeQuery("SELECT [id]\n" +
                                                "      ,[cp]\n" +
                                                "      ,[proveedor_nit]\n" +
                                                "      ,[proveedor_sucursal]\n" +
                                                "      ,[producto_id]\n" +
                                                "      ,[numeroFacturaProveedor]\n" +
                                                "      ,[resolucionFactura]\n" +
                                                "      ,[fechaResolucion]\n" +
                                                "      ,[fechaCompra]\n" +
                                                "      ,[fechaMaximaExportacion]\n" +
                                                "      ,[cantidadInicial]\n" +
                                                "      ,[valorUnitario]\n" +
                                                "      ,[observacion]\n" +
                                                "      ,[estado]\n" +
                                                "      ,[nombreQuienElabora]\n" +
                                                "      ,[bodega_ingresoProductoInicial_id]\n" +
                                                "      ,[costoTotal]\n" +
                                                "	  --Proveedor\n" +
                                                "	  ,prov.[nit]\n" +
                                                "      ,prov.[digitoVerificacion]\n" +
                                                "      ,prov.[sucursal]\n" +
                                                "      ,prov.[nombre]\n" +
                                                "  FROM [maquilas].[dbo].[ingresoProducto] \n" +
                                                "  INNER JOIN (SELECT [nit]\n" +
                                                "      ,[digitoVerificacion]\n" +
                                                "      ,[sucursal]\n" +
                                                "      ,[nombre]  FROM [maquilas].[dbo].[proveedor]) prov ON prov.[nit]= [proveedor_nit] AND prov.[sucursal]=[proveedor_sucursal];");
            }else{
                resultSet = statement.executeQuery("SELECT [id]\n" +
                                                    "      ,[cp]\n" +
                                                    "      ,[proveedor_nit]\n" +
                                                    "      ,[proveedor_sucursal]\n" +
                                                    "      ,[producto_id]\n" +
                                                    "      ,[numeroFacturaProveedor]\n" +
                                                    "      ,[resolucionFactura]\n" +
                                                    "      ,[fechaResolucion]\n" +
                                                    "      ,[fechaCompra]\n" +
                                                    "      ,[fechaMaximaExportacion]\n" +
                                                    "      ,[cantidadInicial]\n" +
                                                    "      ,[valorUnitario]\n" +
                                                    "      ,[observacion]\n" +
                                                    "      ,[estado]\n" +
                                                    "      ,[nombreQuienElabora]\n" +
                                                    "      ,[bodega_ingresoProductoInicial_id]\n" +
                                                    "      ,[costoTotal]\n" +
                                                    "	  --Proveedor\n" +
                                                    "	  ,prov.[nit]\n" +
                                                    "      ,prov.[digitoVerificacion]\n" +
                                                    "      ,prov.[sucursal]\n" +
                                                    "      ,prov.[nombre]\n" +
                                                    "  FROM [maquilas].[dbo].[ingresoProducto] \n" +
                                                    "  INNER JOIN (SELECT [nit]\n" +
                                                    "      ,[digitoVerificacion]\n" +
                                                    "      ,[sucursal]\n" +
                                                    "      ,[nombre] FROM [maquilas].[dbo].[proveedor]) prov ON prov.[nit]= [proveedor_nit] AND prov.[sucursal]=[proveedor_sucursal] "+script+";");
            }
            while(resultSet.next()){ 
                IngresoProducto ingresoProducto = new IngresoProducto(); 
                ingresoProducto.setId(resultSet.getString(1));
                ingresoProducto.setCp(resultSet.getString(2));
                ingresoProducto.setProveedor_nit(resultSet.getString(3));
                ingresoProducto.setProveedor_sucursal(Integer.parseInt(resultSet.getString(4)));
                ingresoProducto.setProducto_id(Integer.parseInt(resultSet.getString(5)));
                ingresoProducto.setNumeroFacturaProveedor(resultSet.getString(6));
                ingresoProducto.setResolucionFactura(resultSet.getString(7));
                ingresoProducto.setFechaResolucion(resultSet.getString(8));
                ingresoProducto.setFechaCompra(resultSet.getString(9));
                ingresoProducto.setFechaMaximaExportacion(resultSet.getString(10));
                ingresoProducto.setCantidadInicial(new java.math.BigDecimal(resultSet.getString(11)));
                ingresoProducto.setValorUnitario(new java.math.BigDecimal(resultSet.getString(12)));
                ingresoProducto.setObservacion(resultSet.getString(13));
                ingresoProducto.setEstado(Integer.parseInt(resultSet.getString(14)));
                ingresoProducto.setNombreQuienElabora(resultSet.getString(15));
                ingresoProducto.setBodega_ingresoProductoInicial(Integer.parseInt(resultSet.getString(16)));
                ingresoProducto.setCostoTotal(new java.math.BigDecimal(resultSet.getString(17)));
                listadoIngresoProducto.add(ingresoProducto); 
            }         
        }catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null, "Error al tratar al consultar");
            sqlException.printStackTrace();
        } 
        control.cerrarConexionBaseDatos();
        return listadoIngresoProducto;
    } 
    public int retornarIdIngresoProducto(String cp){
        Connection conexion= control.ConectarBaseDatos();
        int id =0;
        Statement statement = null;
        try{
            statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT [id] FROM [maquilas].[dbo].[ingresoproducto] WHERE [cp]='"+cp+"';");
            while(resultSet.next()){ 
                id=Integer.parseInt(resultSet.getString(1));
            }
        }catch (SQLException sqlException){
            JOptionPane.showMessageDialog(null, "Error al Tratar de buscar");
            sqlException.printStackTrace();
        } 
        control.cerrarConexionBaseDatos();
        return id;
    }
    public String retornarSaldoIngresoProducto(int idIngresoProducto){
        Connection conexion= control.ConectarBaseDatos();
        String saldo="";
        Statement statement = null;
        try{
            statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT SUM([saldo]) AS SALDO FROM [dbo].[bodega_ingresoProducto] WHERE [ingresoProducto_id]='"+idIngresoProducto+"';");
            while(resultSet.next()){ 
               saldo=resultSet.getString(1);
            }
        }catch (SQLException sqlException){
            JOptionPane.showMessageDialog(null, "Error al Tratar de buscar saldo");
            sqlException.printStackTrace();
        } 
        control.cerrarConexionBaseDatos();
        return saldo;
    }
    public int eliminarCompra (int idIngresoProducto, Usuario u) throws SQLException{
        int result=0;
        if(validarRegistroItemFactura(idIngresoProducto)){// podemos eliminar la Compra
            Connection conexion= control.ConectarBaseDatos();
            //Registramos en Auditoria la eliminacion de la compra
            IngresoProducto ingresoProduct=ConsultarUnicaCompraPorId(idIngresoProducto);
            if(ingresoProduct != null){
                ControlDB_Bodega  controlDB_Bodega = new ControlDB_Bodega();
                
                String fechaRegistroSistemas="";
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
                 //#########################################################
                try{
                   consecutivoAuditoria=retornarElMaximoAuditoria();
                   consecutivoAuditoria++;
                }catch(Exception e){
                   consecutivoAuditoria++;                   
                }                 
                //___________________________________________________
                PreparedStatement registrarAuditoria= conexion.prepareStatement("INSERT INTO [maquilas].[dbo].[auditoria] "
                           + "([id],[fechaMovimiento], [cp],[idTipoMovimiento], [descripcionTipoMovimiento]  "
                           + ", [bodegaOrigen],[bodegaDestino], [usuario_id], [cantidad], "
                           + "[fechaRegistroSistema]) VALUES ('"+consecutivoAuditoria+"','"+ingresoProduct.getFechaCompra()+"',"
                                   + " '"+ingresoProduct.getCp()+"','"+ingresoProduct.getId()+"', "
                           + " 'CompraEliminar', '"+controlDB_Bodega.RetornoNombreBodega(ingresoProduct.getBodega_ingresoProductoInicial())+"', '"+controlDB_Bodega.RetornoNombreBodega(ingresoProduct.getBodega_ingresoProductoInicial())+"','"+u.getId()+"', '"+ingresoProduct.getCantidadInicial()+"','"+fechaRegistroSistemas+"');");       
                   registrarAuditoria.execute();                
                   result=1;
                try{
                    PreparedStatement QueryDelete_bodegaIngresoProducto= conexion.prepareStatement("DELETE FROM [dbo].[bodega_ingresoProducto] WHERE [ingresoProducto_id]='"+idIngresoProducto+"';");
                    QueryDelete_bodegaIngresoProducto.execute();
                    PreparedStatement QueryDelete_IngresoProducto= conexion.prepareStatement("DELETE FROM [dbo].[ingresoProducto] WHERE [id]='"+idIngresoProducto+"';");
                    QueryDelete_IngresoProducto.execute();
                    result=1;
                }
                catch (SQLException sqlException ){   
                    result=0;
                    JOptionPane.showMessageDialog(null, "ERROR al querer insertar los datos.");
                    sqlException.printStackTrace();
                }
            }  
            control.cerrarConexionBaseDatos();
        }
        return result;  
    }  
    public int AnularCompra (int idIngresoProducto, Usuario u) throws SQLException{
        int result=0;
       
            Connection conexion= control.ConectarBaseDatos();
            //Registramos en Auditoria la eliminacion de la compra
            IngresoProducto ingresoProduct=ConsultarUnicaCompraPorId(idIngresoProducto);
            if(ingresoProduct != null){
                ControlDB_Bodega  controlDB_Bodega = new ControlDB_Bodega();
                
                String fechaRegistroSistemas="";
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
                 //#########################################################
                try{
                   consecutivoAuditoria=retornarElMaximoAuditoria();
                   consecutivoAuditoria++;
                }catch(Exception e){
                   consecutivoAuditoria++;                   
                }                 
                //___________________________________________________
                try{//Sacamos DateTime del sistemas
                    PreparedStatement registrarAuditoria= conexion.prepareStatement("INSERT INTO [maquilas].[dbo].[auditoria] "
                               + "([id],[fechaMovimiento], [cp],[idTipoMovimiento], [descripcionTipoMovimiento]  "
                               + ", [bodegaOrigen],[bodegaDestino], [usuario_id], [cantidad], "
                               + "[fechaRegistroSistema]) VALUES ('"+consecutivoAuditoria+"','"+ingresoProduct.getFechaCompra()+"',"
                                       + " '"+ingresoProduct.getCp()+"','"+ingresoProduct.getId()+"', "
                               + " 'CompraAnular', '"+controlDB_Bodega.RetornoNombreBodega(ingresoProduct.getBodega_ingresoProductoInicial())+"', '"+controlDB_Bodega.RetornoNombreBodega(ingresoProduct.getBodega_ingresoProductoInicial())+"','"+u.getId()+"', '"+ingresoProduct.getCantidadInicial()+"','"+fechaRegistroSistemas+"');");       
                       registrarAuditoria.execute();                
                       result=1;

                    PreparedStatement cambiarEstadoAnuladoCompra= conexion.prepareStatement("UPDATE [maquilas].[dbo].[ingresoProducto] SET [estado] = '2' "+
                        " WHERE [ingresoProducto].[id]= '"+ingresoProduct.getId()+"';");
                     cambiarEstadoAnuladoCompra.execute();  
                     result=1;   
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, "No se pudo anular la compra verifique Movimientos");
                }
            }  
            control.cerrarConexionBaseDatos();
        
        return result;  
    }  
    public boolean validarRegistroItemFactura(int idIngresoProducto){
        Connection conexion= control.ConectarBaseDatos();
        int contador=0;
        Statement statement = null;
        try{
            statement = conexion.createStatement();
            ResultSet resultSet_ItemFactura = statement.executeQuery("SELECT * FROM [dbo].[itemFactura] WHERE [ingresoProducto_id]='"+idIngresoProducto+"';");
            while(resultSet_ItemFactura.next()){ 
               contador++;
            }
            ResultSet resultSet_ItemConsumo = statement.executeQuery("SELECT * FROM [dbo].[itemConsumo] WHERE [ingresoProducto_id]='"+idIngresoProducto+"';");
            while(resultSet_ItemConsumo.next()){ 
               contador++;
            }
            ResultSet resultSet_itemMovimientoProducto = statement.executeQuery("SELECT * FROM [dbo].[itemMovimientoProducto] WHERE [ingresoProducto_id]='"+idIngresoProducto+"';");
            while(resultSet_itemMovimientoProducto.next()){ 
               contador++;
            }
            
        }catch (SQLException sqlException){
            JOptionPane.showMessageDialog(null, "Error al Tratar de buscar saldo");
            sqlException.printStackTrace();
        } 
        control.cerrarConexionBaseDatos();
        if(contador==0){
            return true;//No hay registro de Venta en el sistemas podemos eliminar
        }else{
            return false;//Si hay registro de Venta en el sistemas no podemos eliminar
        }
    }
    public IngresoProducto ConsultarUnicaCompraPorId(int idCompra) throws SQLException{
        IngresoProducto ingresoProducto =null;
        control.ConectarBaseDatos();
        try{
            Statement statement  = conexion.createStatement();
            ResultSet resultSet;
            resultSet = statement.executeQuery("SELECT * FROM [maquilas].[dbo].[ingresoproducto]  WHERE [id]='"+idCompra+"';");
            while(resultSet.next()){ 
                ingresoProducto = new IngresoProducto(); 
                ingresoProducto.setId(resultSet.getString(1));
                ingresoProducto.setCp(resultSet.getString(2));
                ingresoProducto.setProveedor_nit(resultSet.getString(3));
                ingresoProducto.setProveedor_sucursal(Integer.parseInt(resultSet.getString(4)));
                ingresoProducto.setProducto_id(Integer.parseInt(resultSet.getString(5)));
                ingresoProducto.setNumeroFacturaProveedor(resultSet.getString(6));
                ingresoProducto.setResolucionFactura(resultSet.getString(7));
                ingresoProducto.setFechaResolucion(resultSet.getString(8));
                ingresoProducto.setFechaCompra(resultSet.getString(9));
                ingresoProducto.setFechaMaximaExportacion(resultSet.getString(10));
                ingresoProducto.setCantidadInicial(new java.math.BigDecimal(resultSet.getString(11)));
                ingresoProducto.setValorUnitario(new java.math.BigDecimal(resultSet.getString(12)));
                ingresoProducto.setObservacion(resultSet.getString(13));
                ingresoProducto.setEstado(Integer.parseInt(resultSet.getString(14)));
                ingresoProducto.setNombreQuienElabora(resultSet.getString(15));
                ingresoProducto.setBodega_ingresoProductoInicial(Integer.parseInt(resultSet.getString(16)));
                ingresoProducto.setCostoTotal(new java.math.BigDecimal(resultSet.getString(17)));
            }         
        }catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null, "Error al tratar al consultar");
            sqlException.printStackTrace();
        } 
        control.cerrarConexionBaseDatos();
        return ingresoProducto;
    }    
    public Proveedor retornarProveedorIngresoProducto(String cp){
        Connection conexion= control.ConectarBaseDatos();
        Statement statement = null;
        Proveedor ProveedorRetorno = null;
        try{
            statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT TOP 1000 "+
                        "       [proveedor].[nit]\n " +
                        "      ,[proveedor].[digitoVerificacion]\n " +
                        "      ,[proveedor].[sucursal]\n " +
                        "      ,[proveedor].[nombre]\n " +
                        "      ,[proveedor].[resolucionFacturacion]\n " +
                        "      ,[proveedor].[fechaResolucion]\n " +
                        "      ,[proveedor].[tipoProveedor_id]\n " +
                        "      ,[proveedor].[telefono]\n " +
                        "      ,[proveedor].[celular]\n " +
                        "      ,[proveedor].[direccion]\n " +
                        "      ,[proveedor].[correo]\n " +
                        "      ,[proveedor].[ciudad]\n " +
                        "      ,[proveedor].[observacion]\n " +
                        "      ,[proveedor].[estado] "
                    + " FROM [maquilas].[dbo].[ingresoproducto] "+
                        " INNER JOIN [dbo].[proveedor]  \n" +
                        "  ON 	[proveedor].[nit] = [ingresoproducto].[proveedor_nit] " +
                        "    AND [proveedor].[sucursal] = [ingresoproducto].[proveedor_sucursal] WHERE [cp]='"+cp+"';");
            while(resultSet.next()){ 
                ProveedorRetorno = new Proveedor();                 
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
            }
        }catch (SQLException sqlException){
            JOptionPane.showMessageDialog(null, "Error al Tratar de buscar");
            sqlException.printStackTrace();
        } 
        control.cerrarConexionBaseDatos();
        return ProveedorRetorno;
    }
    public boolean validarExistenciaCP(String cp){
        Connection conexion= control.ConectarBaseDatos();
        boolean validador =true;
        Statement statement = null;
        try{
            statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT [id] FROM [maquilas].[dbo].[ingresoproducto] WHERE [cp]='"+cp+"';");
            while(resultSet.next()){ 
                validador=false;
            }
        }catch (SQLException sqlException){
            JOptionPane.showMessageDialog(null, "Error al Tratar de buscar");
            sqlException.printStackTrace();
        } 
        control.cerrarConexionBaseDatos();
        return validador;
    }
    public String retornarSaldoIngresoProductoExtranjera(int idIngresoProducto){
        Connection conexion= control.ConectarBaseDatos();
        String saldo="";
        Statement statement = null;
        try{
            statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT [saldo] AS SALDO FROM [dbo].[bodega_ingresoProducto] WHERE [ingresoProducto_id]='"+idIngresoProducto+"' AND [bodega_id]=1;");
            while(resultSet.next()){ 
               saldo=resultSet.getString(1);
            }
        }catch (SQLException sqlException){
            JOptionPane.showMessageDialog(null, "Error al Tratar de buscar saldo");
            sqlException.printStackTrace();
        } 
        control.cerrarConexionBaseDatos();
        return saldo;
    }
    public String retornarSaldoIngresoProductoNacional(int idIngresoProducto){
        Connection conexion= control.ConectarBaseDatos();
        String saldo="";
        Statement statement = null;
        try{
            statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT [saldo] AS SALDO FROM [dbo].[bodega_ingresoProducto] WHERE [ingresoProducto_id]='"+idIngresoProducto+"' AND [bodega_id]=2;");
            while(resultSet.next()){ 
               saldo=resultSet.getString(1);
            }
        }catch (SQLException sqlException){
            JOptionPane.showMessageDialog(null, "Error al Tratar de buscar saldo");
            sqlException.printStackTrace();
        } 
        control.cerrarConexionBaseDatos();
        return saldo;
    }
    public String convertirFormatoFecha(String fecha){  // convertimos 2016-07-15 a formato  '7-15-2018'
        String[] fechaConvert = fecha.split("-");
        String retorno= ""+fechaConvert[1]+"-"+fechaConvert[2]+"-"+fechaConvert[0];
        return retorno;
    }
}
