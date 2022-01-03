package Controladores;

import Modelos.FacturaVenta;
import Modelos.IngresoProducto;
import Modelos.ItemFactura;
import Modelos.Movimiento;
import Modelos.Producto;
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

public class ControlDB_Movimientos_Cajas {
    private Connection conexion=null;
    private  ControlDB_DB control=null;    
    private int consecutivoMovimiento=0;
    private int consecutivoAuditoria=0;
    private int consecutivoFactura=253;
    
    public ControlDB_Movimientos_Cajas() {
        control = new ControlDB_DB();
        conexion= control.ConectarBaseDatos();       
    }   
    public int retornarElMaximo(){
        Connection conexion= control.ConectarBaseDatos();
        int retorno=0;
        Statement statement = null;
        try{
            statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT MAX([id]) FROM [dbo].[movimientoProducto];");
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
    public int retornarElMaximoFacturaVenta(){
        Connection conexion= control.ConectarBaseDatos();
        int retorno=0;
        Statement statement = null;
        try{
            statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT MAX([id]) FROM [dbo].[facturaVenta];");
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
    public ArrayList<IngresoProducto> ingresoProducto_ConsultarCP(String valorConsulta) throws SQLException{
        ArrayList<IngresoProducto> listadoIngresoProducto = new ArrayList(); 
        control.ConectarBaseDatos();
        try{
            Statement statement  = conexion.createStatement();
            ResultSet resultSet;
            //resultSet = statement.executeQuery("select * from ingresoproducto "+script+" and estado=1;");
            resultSet = statement.executeQuery("SELECT TOP 1000 "+
                    "       [ingresoProducto].[id]\n " +
                    "      ,[ingresoProducto].[cp]\n " +
                    "      ,[ingresoProducto].[proveedor_nit]\n" +
                    "      ,[ingresoProducto].[proveedor_sucursal]\n" +
                    "      ,[ingresoProducto].[producto_id]\n" +
                    "      ,[ingresoProducto].[numeroFacturaProveedor]\n" +
                    "      ,[ingresoProducto].[resolucionFactura]\n" +
                    "      ,[ingresoProducto].[fechaResolucion]\n" +
                    "      ,[ingresoProducto].[fechaCompra]\n" +
                    "      ,[ingresoProducto].[fechaMaximaExportacion]\n" +
                    "      ,[ingresoProducto].[cantidadInicial]\n" +
                    "      ,[ingresoProducto].[valorUnitario]\n" +
                    "      ,[ingresoProducto].[observacion]\n" +
                    "      ,[ingresoProducto].[estado]\n" +
                    "      ,[ingresoProducto].[nombreQuienElabora]\n" +
                    "      ,[ingresoProducto].[bodega_ingresoProductoInicial_id]\n" +
                    "      ,[ingresoProducto].[costoTotal]\n" +
                    "  FROM [maquilas].[dbo].[ingresoProducto] "+
                    "  INNER JOIN [dbo].[proveedor]  \n" +
                    "   ON  [proveedor].[nit] = [ingresoProducto].[proveedor_nit] AND [proveedor].[sucursal] = [ingresoProducto].[proveedor_sucursal] "+
                    " WHERE ([ingresoProducto].[id] like '%"+valorConsulta+"%' OR [ingresoProducto].[cp] like '%"+valorConsulta+"%' OR"
                            + "[ingresoProducto].[proveedor_nit] like '%"+valorConsulta+"%' OR [proveedor].[nombre] like '%"+valorConsulta+"%') AND [ingresoProducto].[estado]=1 AND [ingresoProducto].[producto_id]=2;");
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
                    ingresoProducto.setCantidadInicial(new BigDecimal(resultSet.getString(11)));
                    ingresoProducto.setValorUnitario(new BigDecimal(resultSet.getString(12)));
                    ingresoProducto.setObservacion(resultSet.getString(13));
                    ingresoProducto.setEstado(Integer.parseInt(resultSet.getString(14)));
                    ingresoProducto.setNombreQuienElabora(resultSet.getString(15));
                    ingresoProducto.setBodega_ingresoProductoInicial(Integer.parseInt(resultSet.getString(16)));
                    listadoIngresoProducto.add(ingresoProducto); 
            }         
        }catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null, "Error al tratar al consultar");
            sqlException.printStackTrace();
        } 
        control.cerrarConexionBaseDatos();
        return listadoIngresoProducto;
    } 
    public ArrayList<Movimiento> consultarBodegas_Por_CP(String idIngresoProducto) throws SQLException{
        ArrayList<Movimiento> listadoMovimientos = new ArrayList(); 
        control.ConectarBaseDatos();
        try{
            Statement statement  = conexion.createStatement();
            ResultSet resultSet;
            //resultSet = statement.executeQuery("select * from ingresoproducto "+script+" and estado=1;");
            resultSet = statement.executeQuery("SELECT TOP 50 "
                    +   "                           [ingresoProducto].[id]\n" +
                        "                          ,[ingresoProducto].[cp]\n" +
                        "                          ,[ingresoProducto].[proveedor_nit]\n" +
                        "                          ,[ingresoProducto].[proveedor_sucursal]\n" +
                        "                          ,[ingresoProducto].[producto_id]\n" +
                        "                          ,[ingresoProducto].[numeroFacturaProveedor]\n" +
                        "                          ,[ingresoProducto].[resolucionFactura]\n" +
                        "                          ,[ingresoProducto].[fechaResolucion]\n" +
                        "                          ,[ingresoProducto].[fechaCompra]\n" +
                        "                          ,[ingresoProducto].[fechaMaximaExportacion]\n" +
                        "                          ,[ingresoProducto].[cantidadInicial]\n" +
                        "                          ,[ingresoProducto].[valorUnitario]\n" +
                        "                          ,[ingresoProducto].[observacion]\n" +
                        "                          ,[ingresoProducto].[estado]\n" +
                        "                          ,[ingresoProducto].[nombreQuienElabora]\n" +
                        "                          ,[ingresoProducto].[bodega_ingresoProductoInicial_id]\n" +
                        "                          ,[ingresoProducto].[costoTotal]\n" +
                        "			   ,[bodega_ingresoProducto].[bodega_id]\n" +
                        "			   ,[bodega].[descripcion]\n" +
                        "			   ,[bodega_ingresoProducto].[saldo]\n" +
                        "			   ,[bodega].[estado]\n" +
                        "                          ,[producto].[id]\n"+ 
                        "                          ,[producto].[descripcion]\n"+
                        "                      FROM [maquilas].[dbo].[ingresoProducto] \n" +
                        "                     INNER JOIN [dbo].[bodega_ingresoProducto] ON [ingresoProducto].[id]=[bodega_ingresoProducto].[ingresoProducto_id] \n" +
                        "                     INNER JOIN [dbo].[bodega] ON [bodega_ingresoProducto].[bodega_id] =[bodega].[id] "
                    + "                       INNER JOIN [dbo].[producto] ON [ingresoProducto].[producto_id] =[producto].[id]"
                    + "WHERE [ingresoProducto].[id]='"+idIngresoProducto+"';");
                while(resultSet.next()){ 
                    Movimiento movimiento = new Movimiento(); 
                    movimiento.setIngresoProducto_id(resultSet.getString(1));
                    movimiento.setIngresoProducto_cp(resultSet.getString(2));
                    movimiento.setIngresoProducto_proveedor_nit(resultSet.getString(3));
                    movimiento.setIngresoProducto_proveedor_sucursal(Integer.parseInt(resultSet.getString(4)));
                    movimiento.setProducto_id(Integer.parseInt(resultSet.getString(5)));
                    movimiento.setIngresoProducto_numeroFacturaProveedor(resultSet.getString(6));
                    movimiento.setIngresoProducto_resolucionFactura(resultSet.getString(7));
                    movimiento.setIngresoProducto_fechaResolucion(resultSet.getString(8));
                    movimiento.setIngresoProducto_fechaCompra(resultSet.getString(9));
                    movimiento.setIngresoProducto_fechaMaximaExportacion(resultSet.getString(10));
                    movimiento.setIngresoProducto_cantidadInicial(new BigDecimal(resultSet.getString(11)));
                    movimiento.setIngresoProducto_valorUnitario(new BigDecimal(resultSet.getString(12)));
                    movimiento.setIngresoProducto_observacion(resultSet.getString(13));
                    movimiento.setIngresoProducto_estado(Integer.parseInt(resultSet.getString(14)));
                    movimiento.setIngresoProducto_nombreQuienElabora(resultSet.getString(15));
                    movimiento.setIngresoProducto_bodega_ingresoProductoInicial(Integer.parseInt(resultSet.getString(16)));
                    movimiento.setIngresoProducto_costoTotal(new BigDecimal(resultSet.getString(17)));
                    movimiento.setBodega_id(Integer.parseInt(resultSet.getString(18)));
                    movimiento.setBodega_Descripcion(resultSet.getString(19));
                    movimiento.setBodega_saldo(Integer.parseInt(resultSet.getString(20)));
                    movimiento.setBodega_estado(Integer.parseInt(resultSet.getString(21)));                 
                    movimiento.setProducto_id(Integer.parseInt(resultSet.getString(22)));                 
                    movimiento.setProducto_descripcion(resultSet.getString(23));                 
                    listadoMovimientos.add(movimiento); 
            }         
        }catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null, "Error al tratar al consultar");
            sqlException.printStackTrace();
        } 
        control.cerrarConexionBaseDatos();
        return listadoMovimientos;
    }   
    public String validarSaldoBodegaExtranejera(String idIngresoProducto) throws SQLException{
        control.ConectarBaseDatos();
        String saldo="0";
        try{
            Statement statement  = conexion.createStatement();
            ResultSet resultSet;
            //resultSet = statement.executeQuery("select * from ingresoproducto "+script+" and estado=1;");
            resultSet = statement.executeQuery(" SELECT [saldo] FROM [dbo].[bodega_ingresoProducto] WHERE [ingresoProducto_id] ='"+idIngresoProducto+"' AND [bodega_id] =1;");
            while(resultSet.next()){ 
                saldo=resultSet.getString(1);
            }           
        }catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null, "Error al tratar al consultar el saldo");
            sqlException.printStackTrace();
        } 
        control.cerrarConexionBaseDatos();
        return saldo;
    } 
    public String validarNombreBodegaExtranejera(String id ) throws SQLException{
        control.ConectarBaseDatos();
        String Nombre="";
        try{
            Statement statement  = conexion.createStatement();
            ResultSet resultSet;
            //resultSet = statement.executeQuery("select * from ingresoproducto "+script+" and estado=1;");
            resultSet = statement.executeQuery(" SELECT [descripcion] FROM [dbo].[bodega_ingresoproductoinicial] WHERE [id] ='"+id+"';");
            while(resultSet.next()){ 
                Nombre=resultSet.getString(1);
            }           
        }catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null, "Error al tratar al consultar el Nombre de la Bodega Extranjera");
            sqlException.printStackTrace();
        } 
        control.cerrarConexionBaseDatos();
        return Nombre;
    } 
    public Producto validarNombreProducto(int id ) throws SQLException{
        control.ConectarBaseDatos();
        Producto product = new Producto();
        try{
            Statement statement  = conexion.createStatement();
            ResultSet resultSet;
            //resultSet = statement.executeQuery("select * from ingresoproducto "+script+" and estado=1;");
            resultSet = statement.executeQuery(" SELECT * FROM [dbo].[producto] WHERE [id] ='"+id+"';");
            while(resultSet.next()){ 
                product.setId(Integer.parseInt(resultSet.getString(1)));
                product.setDescripcion(resultSet.getString(2));
                product.setTipo(resultSet.getString(3));
                product.setSubpartidaArancelaria(resultSet.getString(4));
                product.setUnidad_id(Integer.parseInt(resultSet.getString(5)));
                product.setEstado(Integer.parseInt(resultSet.getString(6)));
            }           
        }catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null, "Error al tratar al consultar el Nombre de la Bodega Extranjera");
            sqlException.printStackTrace();
        } 
        control.cerrarConexionBaseDatos();
        return product;
    }  
    public int registrarVentaExtranjera(FacturaVenta facturaVenta, ArrayList<ItemFactura> itemFactura, Usuario user) throws FileNotFoundException, SQLException{
        
        Connection conexion= control.ConectarBaseDatos();
        int result=0;
        try{
            //BigDecimal valorTotalPesos = new BigDecimal(facturaVenta.getValorTotalEnPesosCalculados().toPlainString());
            //#########################################################
            try{
                consecutivoFactura=retornarElMaximoFacturaVenta();
                consecutivoFactura++;
            }catch(Exception e){
                consecutivoFactura=253;                   
            }  
            
            PreparedStatement registroVenta= conexion.prepareStatement("INSERT INTO [maquilas].[dbo].[facturaVenta] ([id],[dex], [fechaFactura], [bodegaFacturaVenta_id]," +
                        " [cliente_nit], [cliente_sucursal], [empresaLocal_nit]," +
                        " [empresaLocal_sucursal], [trm], [valorTotalDolarIngresados], [valorTotalDolarCalculados], " +
                        " [valorTotalPesosCalculados], [observaciones], [estado], [nombreQuienElabora]) VALUES ('"+consecutivoFactura+"','"+facturaVenta.getDex()+"'," +
                        " '"+facturaVenta.getFechaFactura()+"', '"+facturaVenta.getBodegaFacturaVenta_id()+"', '"+facturaVenta.getCliente_nit()+"',"+
                        " '"+facturaVenta.getCliente_sucursal()+"', '"+facturaVenta.getEmpresaLocal_nit()+"', "+
                        " '"+facturaVenta.getEmpresaLocal_sucursal()+"', '"+facturaVenta.getTrm()+"',"+
                        " '"+facturaVenta.getValorTotalEnDolarIngresados().toPlainString()+"', '"+facturaVenta.getValorTotalEnDolarCalculados().toPlainString()+"',"+
                        " '"+facturaVenta.getValorTotalEnPesosCalculados().toPlainString()+"', '"+facturaVenta.getObservaciones()+"', "+
                        " '"+facturaVenta.getEstado()+"', '"+facturaVenta.getNombreQuienElabora()+"');");       
            registroVenta.execute();
            result=1;
            try{           
                int idVenta=retornarElMaximoFacturaVenta();
                BigDecimal valorToltalPesos=new BigDecimal("0");
                for(int i=0; i< itemFactura.size(); i++){
                    PreparedStatement registrarItemFactura= conexion.prepareStatement("INSERT INTO [maquilas].[dbo].[itemfactura] ([facturaVenta_id], [ingresoProducto_id], [cantidad], [valorUnitarioKilo], [total]) VALUES ('"+idVenta+"', '"+itemFactura.get(i).getIdIngresoProducto()+"', '"+itemFactura.get(i).getCantidad().toPlainString()+"','"+itemFactura.get(i).getValorUnitarioKilo()+"','"+itemFactura.get(i).getTotal().toPlainString()+"');;");       
                    registrarItemFactura.execute();
                    valorToltalPesos.add(new BigDecimal(""+itemFactura.get(i).getTotal()));
                    actualizarSaldoBodegaIngresoProductoBodegaExtranjera(itemFactura.get(i).getIdIngresoProducto(), itemFactura.get(i).getCantidad());
                    int contador=validadorSaldosIngresoProducto(itemFactura.get(i).getIdIngresoProducto());
                    if(contador==2){
                        JOptionPane.showMessageDialog(null, "El CP: "+retornarCP(itemFactura.get(i).getIdIngresoProducto())+" tiene Cero saldo por tal motivo queda Inactivo");
                    }
                    //Procedemos a hacer el registro en la Tabla Auditoria
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
                            + "[fechaRegistroSistema]) VALUES ('"+consecutivoAuditoria+"','"+facturaVenta.getFechaFactura()+"',"
                                    + " '"+retornarCP(itemFactura.get(i).getIdIngresoProducto())+"', '"+idVenta+"', "
                            + " 'Venta', 'Extranjera','Extranjera', '"+user.getId()+"', '"+itemFactura.get(i).getCantidad().toPlainString()+"', '"+fechaRegistroSistemas+"');;");       
                    registrarAuditoria.execute();                
                    result=1; 
                }
                ///Procedemos a actualizar el valor Total en Pesos una vez registrados los itemProductos
                    BigDecimal totalFacturaVenta = retornarSumaTotalesItemsFacturaVentaExtranjera(idVenta);                
                    PreparedStatement actualizarValorTotalPesos= conexion.prepareStatement("UPDATE [maquilas].[dbo].[facturaventa] SET [valorTotalDolarCalculados] = '"+totalFacturaVenta.toPlainString()+"' WHERE [facturaventa].[id] = '"+idVenta+"';");       
                    actualizarValorTotalPesos.execute();                
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
    public int actualizarSaldoBodegaIngresoProductoBodegaExtranjera(int ingresoProducto_id, BigDecimal cantidad){
        BigDecimal saldo=new BigDecimal(""+retornarSaldoBodegaIngresoProductoExtranjera(ingresoProducto_id));
        BigDecimal saldoNuevo= saldo.subtract(cantidad);         
        control.ConectarBaseDatos();
        int result=0;
        try{
            PreparedStatement r= conexion.prepareStatement("UPDATE [maquilas].[dbo].[bodega_ingresoproducto] SET [saldo] = '"+saldoNuevo.toPlainString()+"' "+
                    "WHERE [bodega_ingresoproducto].[bodega_id] = 1 AND [bodega_ingresoproducto].[ingresoProducto_id] = '"+ingresoProducto_id+"';");
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
    public BigDecimal retornarSaldoBodegaIngresoProductoExtranjera(int ingresoProducto_id){
        Connection conexion= control.ConectarBaseDatos();
        BigDecimal saldo=new java.math.BigDecimal("0");
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
        control.cerrarConexionBaseDatos();
        return saldo;
    }
    public int validadorSaldosIngresoProducto(int ingresoProducto_id){
        Connection conexion= control.ConectarBaseDatos();
        int contador=0;
        Statement statement = null;
        try{
            statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM [maquilas].[dbo].[bodega_ingresoproducto] WHERE [ingresoProducto_id]='"+ingresoProducto_id+"' AND [saldo]=0;");
            while(resultSet.next()){ 
                contador++;
            }
        }catch (SQLException sqlException){
            JOptionPane.showMessageDialog(null, "Error al Tratar de buscar");
            sqlException.printStackTrace();
            //System.exit(1);
        } 
        //control.cerrarConexionBaseDatos();
        if(contador==2){
            //control.ConectarBaseDatos();
            int result=0;
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
            //control.cerrarConexionBaseDatos();
            return result;
        }      
        control.cerrarConexionBaseDatos();
        return contador;
    }
    public String retornarCP(int ingresoProducto_id){
        Connection conexion= control.ConectarBaseDatos();
        String cp="";
        Statement statement = null;
        try{
            statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT [cp] FROM [maquilas].[dbo].[ingresoproducto] WHERE [id]='"+ingresoProducto_id+"';");
            while(resultSet.next()){ 
                cp=resultSet.getString(1);
            }
        }catch (SQLException sqlException){
            JOptionPane.showMessageDialog(null, "Error al Tratar de buscar");
            sqlException.printStackTrace();
        } 
        control.cerrarConexionBaseDatos();
        return cp;
    }
    public boolean validorCantidadesExistentesBodegaExtranjera(ArrayList<ItemFactura> itemFactura) {
        //Este metodo solo compara si en Bododega hay existencia del los productos que se van a Exportar
        //En caso que si halla existencia retorna true, de lo contrario retorna false
        boolean validador=true;
        for(int i=0; i< itemFactura.size(); i++){
            BigDecimal saldoEnBodegaExtranjera=retornarSaldoBodegaIngresoProductoExtranjera(itemFactura.get(i).getIdIngresoProducto());
            BigDecimal cantidadEnFacturaVenta= itemFactura.get(i).getCantidad();
            if(saldoEnBodegaExtranjera.compareTo(cantidadEnFacturaVenta)== -1){
                validador=false;
            }
        }
        return validador;       
    }
    public BigDecimal retornarSumaTotalesItemsFacturaVentaExtranjera(int idVenta){
        Connection conexion= control.ConectarBaseDatos();
        BigDecimal total=new java.math.BigDecimal("0");
        Statement statement = null;
        try{
            statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery("select SUM(CONVERT(FLOAT, [total])) AS TOTAL  FROM [maquilas].[dbo].[itemFactura]  WHERE [facturaVenta_id] ='"+idVenta+"';");
            while(resultSet.next()){ 
                String valor=resultSet.getString(1);
                total=new java.math.BigDecimal(valor);
            }
        }catch (SQLException sqlException){
            JOptionPane.showMessageDialog(null, "Error al Tratar de buscar");
            sqlException.printStackTrace();
        } 
        control.cerrarConexionBaseDatos();
        return total;
    }   
    public String retornarId_IngresoProducto(String CP){
        Connection conexion= control.ConectarBaseDatos();
        String id="";
        Statement statement = null;
        try{
            statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT [id] FROM [maquilas].[dbo].[ingresoproducto] WHERE [cp]='"+CP+"';");
            while(resultSet.next()){ 
                id=resultSet.getString(1);
            }
        }catch (SQLException sqlException){
            JOptionPane.showMessageDialog(null, "Error al Tratar de buscar");
            sqlException.printStackTrace();
        } 
        control.cerrarConexionBaseDatos();
        return id;
    }
    public int registrarMovimiento(String fechaMovimiento, String CP, int nuevoSalgoBodegaExtranjera, int nuevoSaldoBodegaNacional, Usuario u, int saldoExtranjeraTraslado, int saldoNacionalTrasladado, int saldoBodegaExtranjeraActual, int saldoBodegaNacionalActual){
        int result=0;
        control.ConectarBaseDatos();
        try{
            int idIngresoProducto= Integer.parseInt(retornarId_IngresoProducto(CP));
            String saldoAnteriorExtranjera="";
            String saldoAnteriorNacional="";
            
            boolean validar = validadorSaldoEnBodega_por_CP(idIngresoProducto, saldoBodegaExtranjeraActual,saldoBodegaNacionalActual);
            if(validar){
                try{
                    //Sacamos los saldo anteriores de las bodegas antes de cambiarlos
                    saldoAnteriorExtranjera=retornarSaldoBodegaBodega(idIngresoProducto,1);
                    saldoAnteriorNacional=retornarSaldoBodegaBodega(idIngresoProducto,2);
                    
                    PreparedStatement scriptExtranjera= conexion.prepareStatement("UPDATE [maquilas].[dbo].[bodega_ingresoproducto] SET [saldo] = '"+nuevoSalgoBodegaExtranjera+"' "+
                            "WHERE [bodega_ingresoproducto].[bodega_id] = 1 AND [bodega_ingresoproducto].[ingresoProducto_id] = '"+idIngresoProducto+"';");
                    scriptExtranjera.execute();
                    PreparedStatement scriptNacional= conexion.prepareStatement("UPDATE [maquilas].[dbo].[bodega_ingresoproducto] SET [saldo] = '"+nuevoSaldoBodegaNacional+"' "+
                            "WHERE [bodega_ingresoproducto].[bodega_id] = 2 AND [bodega_ingresoproducto].[ingresoProducto_id] = '"+idIngresoProducto+"';");
                    scriptNacional.execute();
                    result++;
                    try{
                        //Procedemos a hacer Registro en tabla Movimiento e ItemMovimiento
                        
                        //sacamos el maxímo de Movimiento
                        try{
                           consecutivoMovimiento=retornarElMaximo();
                           consecutivoMovimiento++;
                        }catch(Exception e){
                           consecutivoMovimiento++;                   
                        }                 
                            
                        PreparedStatement movimientoProducto= conexion.prepareStatement("INSERT INTO [maquilas].[dbo].[movimientoProducto] "
                                        + "([id],[fechaMovimiento], [nombreQuienElabora],[estado]) VALUES ('"+consecutivoMovimiento+"','"+fechaMovimiento+"','"+u.getNombre()+" "+u.getApellido()+"',1);");       
                        movimientoProducto.execute();                
                        result++; 
                        
                        int idMovimientoProducto=0;
                        try{
                           idMovimientoProducto= retornarElMaximo();
                        }catch(Exception e){
                            idMovimientoProducto=1;
                        }
                        try{
                            PreparedStatement registrarMovimientoEnExtranjera= conexion.prepareStatement("INSERT INTO [maquilas].[dbo].[itemMovimientoProducto] "
                                        + "([ingresoProducto_id], [movimientoProducto_id],[bodegaMovimiento_id], [bodegaOrigen], [bodegaDestino],[saldoAnterior],[cantidadTrasladada],[saldoActual])"
                                    + " VALUES ('"+idIngresoProducto+"', '"+idMovimientoProducto+"', '1', "
                                            + "'Nacional','Extranjera','"+saldoAnteriorExtranjera+"','"+saldoNacionalTrasladado+"', '"+nuevoSalgoBodegaExtranjera+"');");       
                            registrarMovimientoEnExtranjera.execute(); 
                            result++;
                            try{
                                PreparedStatement registrarMovimientoEnNacional= conexion.prepareStatement("INSERT INTO [maquilas].[dbo].[itemMovimientoProducto] "
                                        + "([ingresoProducto_id], [movimientoProducto_id],[bodegaMovimiento_id], [bodegaOrigen], [bodegaDestino],[saldoAnterior],[cantidadTrasladada],[saldoActual])"
                                    + " VALUES ('"+idIngresoProducto+"', '"+idMovimientoProducto+"', '2', "
                                            + "'Extranjera','Nacional','"+saldoAnteriorNacional+"','"+saldoExtranjeraTraslado+"', '"+nuevoSaldoBodegaNacional+"');");       
                                registrarMovimientoEnNacional.execute(); 
                                result++;
                                //Procedemos a Registrar en Auditoria Traslado de Extranjera a Nacional
                                try{
                                    //Procedemos a hacer el registro en la Tabla Auditoria
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
                                    Date fechaAct = new Date(); 
                                    String  FechaActual =new SimpleDateFormat("yyyy-MM-dd").format(fechaAct);    
                                    
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
                                            + "[fechaRegistroSistema]) VALUES ('"+consecutivoAuditoria+"','"+FechaActual+"',"
                                                    + " '"+CP+"', '"+idMovimientoProducto+"', "
                                                + " 'Movimiento', 'Extranjera','Nacional', '"+u.getId()+"', '"+saldoExtranjeraTraslado+"', '"+fechaRegistroSistemas+"');");       
                                    registrarAuditoria.execute();                
                                    result++; 
                                }catch(Exception e){
                                    JOptionPane.showMessageDialog(null,"Error al registrar Movimiento de Extranjera a Nacional en Tabla Auditoria");
                                }
                                try{
                                    //Procedemos a hacer el registro en la Tabla Auditoria
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
                                    Date fechaAct = new Date(); 
                                    String  FechaActual =new SimpleDateFormat("yyyy-MM-dd").format(fechaAct);     
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
                                            + "[fechaRegistroSistema]) VALUES ('"+consecutivoAuditoria+"','"+FechaActual+"',"
                                                    + " '"+CP+"', '"+idMovimientoProducto+"', "
                                                + " 'Movimiento', 'Nacional','Extranjera', '"+u.getId()+"', '"+saldoNacionalTrasladado+"', '"+fechaRegistroSistemas+"');");       
                                    registrarAuditoria.execute();                
                                    result++; 
                                }catch(SQLException sqlException){
                                     JOptionPane.showMessageDialog(null,"Error al registrar Movimiento de Nacional a Extranjera en Tabla Auditoria");
                                     sqlException.printStackTrace();
                                }
                            }catch(SQLException sqlException){
                                JOptionPane.showMessageDialog(null,"Error al registrar Movimiento en Tabla Auditoria");
                                sqlException.printStackTrace();
                            }
                        }catch(SQLException sqlException){
                            JOptionPane.showMessageDialog(null, "ERROR al querer insertar los datos.");
                    sqlException.printStackTrace();
                        }
                    }catch(SQLException sqlException){
                        JOptionPane.showMessageDialog(null, "ERROR al querer insertar los datos.");
                        sqlException.printStackTrace();
                    }       
                    }catch(SQLException sqlException){
                        JOptionPane.showMessageDialog(null, "ERROR al querer insertar los datos.");
                     sqlException.printStackTrace();
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Los Saldos en las bodegas han cambiado verifique saldos y registre movimiento nuevamente");
                }  
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error al Tratar de buscar Id Producto");
        } 
        control.cerrarConexionBaseDatos();
        return result;
    }
    public boolean validadorSaldoEnBodega_por_CP(int idIngresoProducto, int  saldoBodegaExtranjeraActual, int saldoBodegaNacionalActual){// validamos que los saldos sigan vigente ennuestra base de datos
        control.ConectarBaseDatos();
        int contadorValidad=0; //Si nuestro contador es == 2 podemos realizar el movimiento
        try{
            Statement statement  = conexion.createStatement();
            ResultSet resultSet;
            //resultSet = statement.executeQuery("select * from ingresoproducto "+script+" and estado=1;");
            resultSet = statement.executeQuery(" SELECT * FROM [dbo].[bodega_ingresoProducto] WHERE [ingresoProducto_id] ='"+idIngresoProducto+"' AND [bodega_id] =1 AND [saldo]='"+saldoBodegaExtranjeraActual+"';");
            while(resultSet.next()){ 
                contadorValidad++;
            }           
        }catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null, "Error al tratar al consultar el saldo");
            sqlException.printStackTrace();
        } 
        try{
            Statement statement  = conexion.createStatement();
            ResultSet resultSet;
            //resultSet = statement.executeQuery("select * from ingresoproducto "+script+" and estado=1;");
            resultSet = statement.executeQuery(" SELECT * FROM [dbo].[bodega_ingresoProducto] WHERE [ingresoProducto_id] ='"+idIngresoProducto+"' AND [bodega_id] =2 AND [saldo]='"+saldoBodegaNacionalActual+"';");
            while(resultSet.next()){ 
                contadorValidad++;
            }           
        }catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null, "Error al tratar al consultar el saldo");
            sqlException.printStackTrace();
        } 
        control.cerrarConexionBaseDatos();
        if(contadorValidad==2){
            return true;
        }else{
            return false;
        }
    }
    public String retornarSaldoBodegaBodega(int idIngresoProducto, int Bodega){// validamos que los saldos sigan vigente ennuestra base de datos
        control.ConectarBaseDatos();
        String saldo="";
        try{
            Statement statement  = conexion.createStatement();
            ResultSet resultSet;
            //resultSet = statement.executeQuery("select * from ingresoproducto "+script+" and estado=1;");
            resultSet = statement.executeQuery(" SELECT [saldo] FROM [dbo].[bodega_ingresoProducto] WHERE [ingresoProducto_id] ='"+idIngresoProducto+"' AND [bodega_id] ='"+Bodega+"';");
            while(resultSet.next()){ 
                saldo=resultSet.getString(1);
            }           
        }catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null, "Error al tratar al consultar el saldo");
            sqlException.printStackTrace();
        } 
       return saldo;
    }

    public boolean validarSaldosBodegasMovimientos(String cp, int saldoBodegaExtrajera, int saldoBodegaNacional) throws SQLException{
        control.ConectarBaseDatos();
        int contador=0;
        try{
            Statement statementExtranjera  = conexion.createStatement();
            ResultSet resultSetExtranjera;
            //resultSet = statement.executeQuery("select * from ingresoproducto "+script+" and estado=1;");
            resultSetExtranjera = statementExtranjera.executeQuery("SELECT " +
                                                " [ingresoProducto].[id] " +
                                                " ,[ingresoProducto].[cp] " +
                                                " ,[bodega_ingresoProducto].[saldo] " +
                                                " FROM [maquilas].[dbo].[ingresoProducto] " +
                                                " INNER JOIN [dbo].[bodega_ingresoProducto] " +
                                                " ON [ingresoProducto].[id]=[bodega_ingresoProducto].[ingresoProducto_id] " +
                                                " WHERE [ingresoProducto].[cp]='"+cp+"' AND [bodega_ingresoProducto].[saldo]='"+saldoBodegaExtrajera+"' AND " +
                                                " [bodega_ingresoProducto].[bodega_id]='1';");
            while(resultSetExtranjera.next()){ 
                contador++;
            }       
            Statement statementNacional  = conexion.createStatement();
            ResultSet resultSetNacional;
            //resultSet = statement.executeQuery("select * from ingresoproducto "+script+" and estado=1;");
            resultSetNacional = statementNacional.executeQuery("SELECT " +
                                                " [ingresoProducto].[id] " +
                                                " ,[ingresoProducto].[cp] " +
                                                " ,[bodega_ingresoProducto].[saldo] " +
                                                " FROM [maquilas].[dbo].[ingresoProducto] " +
                                                " INNER JOIN [dbo].[bodega_ingresoProducto] " +
                                                " ON [ingresoProducto].[id]=[bodega_ingresoProducto].[ingresoProducto_id] " +
                                                " WHERE [ingresoProducto].[cp]='"+cp+"' AND [bodega_ingresoProducto].[saldo]='"+saldoBodegaNacional+"' AND " +
                                                " [bodega_ingresoProducto].[bodega_id]='2';");
            while(resultSetNacional.next()){ 
                contador++;
            }  
        }catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null, "Error al tratar al consultar el saldo");
            sqlException.printStackTrace();
        } 
        control.cerrarConexionBaseDatos();
        
        if(contador==2){
            return true; //Los saldos siguen iguales.
        }else{
            return false; //Los saldos se alteraron.
        }
    } 


}
