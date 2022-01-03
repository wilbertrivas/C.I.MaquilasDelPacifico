package Controladores;
import Modelos.Cliente;
import Modelos.FacturaVenta;
import Modelos.IngresoProducto;
import Modelos.ItemFactura;
import Modelos.ItemFacturaEditar;
import Modelos.Producto;
import Modelos.Proveedor;
import Modelos.Usuario;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ControlDB_VentaFacturacionPapel_EditarFacturaExtranjera {
    private Connection conexion=null;
    private  ControlDB_DB control=null;    
    private int consecutivoVenta=0;
    private int consecutivoAuditoria=0;
    
    public ControlDB_VentaFacturacionPapel_EditarFacturaExtranjera() {
        control = new ControlDB_DB();
        conexion= control.ConectarBaseDatos();       
    }   
    public int retornarElMaximo(){
        Connection conexion= control.ConectarBaseDatos();
        int retorno=0;
        Statement statement = null;
        try{
            statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT MAX([id]) FROM [dbo].[facturaVentaPapel];");
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
    public ArrayList<IngresoProducto> consultarCpBodegaExtranjera(String valorConsulta) throws SQLException{
        ArrayList<IngresoProducto> listadoIngresoProducto = new ArrayList(); 
        control.ConectarBaseDatos();
        try{
            Statement statement  = conexion.createStatement();
            ResultSet resultSet;
            //resultSet = statement.executeQuery("select * from ingresoproducto "+script+" and estado=1;");
            resultSet = statement.executeQuery(" SELECT "
                       + " [ingreProduct].[id], "
                       + " [ingreProduct].[cp],"
                       + " [ingreProduct].[proveedor_nit],"
                       + " [ingreProduct].[proveedor_sucursal],"
                       + " [ingreProduct].[producto_id], "
                       + " [ingreProduct].[numeroFacturaProveedor], "
                       + " [ingreProduct].[resolucionFactura], "
                       + " [ingreProduct].[fechaResolucion], "
                       + " [ingreProduct].[fechaCompra], "
                       + " [ingreProduct].[fechaMaximaExportacion], "
                       + " [ingreProduct].[cantidadInicial], "
                       + " [ingreProduct].[valorUnitario], "
                       + " [ingreProduct].[observacion], "
                       + " [ingreProduct].[estado] , "
                       + " [ingreProduct].[nombreQuienElabora], "
                       //+ " ingreProduct.bodega_ingresoProductoInicial_id,"
                       + " [bog_ingreProduc].[bodega_id], "
                       + " [bog_ingreProduc].[saldo] "
                    + " FROM [dbo].[ingresoproducto] AS [ingreProduct] "
                           + " INNER JOIN [bodega_ingresoProducto]  AS bog_ingreProduc "
                               + " ON [ingreProduct].[id] = [bog_ingreProduc].[ingresoProducto_id] AND [ingreProduct].[estado]=1 AND [bog_ingreProduc].[saldo] >0 "
                            + " INNER JOIN [producto] "
                               + " ON [producto].[id] = [ingreProduct].[producto_id] AND [producto].[id]=1"
                           + " INNER JOIN [bodega] "
                               + " ON [bodega].[id] = [bog_ingreProduc].[bodega_id] AND [bodega].[id] =1 "
                           + " INNER JOIN [proveedor] "
                               + " ON [ingreProduct].[proveedor_nit] = [proveedor].[nit] AND [ingreProduct].[proveedor_sucursal] = [proveedor].[sucursal] "
                    + " WHERE ([ingreProduct].[cp] like '%"+valorConsulta+"%'"
                       + " OR [ingreProduct].[proveedor_nit] like '%"+valorConsulta+"%' OR [proveedor].[nombre] like '%"+valorConsulta+"%' OR "
                            + "[ingreProduct].[numeroFacturaProveedor] like '%"+valorConsulta+"%' OR [ingreProduct].[resolucionFactura] like '%"+valorConsulta+"%' "
                                    + ") ;");
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
    public int registrarVentaExtranjera(FacturaVenta facturaVenta, ArrayList<ItemFacturaEditar> itemFactura, Usuario user) throws FileNotFoundException, SQLException{
        Connection conexion= control.ConectarBaseDatos();
        int result=0;
        try{
            //BigDecimal valorTotalPesos = new BigDecimal(facturaVenta.getValorTotalEnPesosCalculados().toPlainString());
            
            PreparedStatement registroVentaEditar= conexion.prepareStatement("UPDATE [maquilas].[dbo].[facturaVentaPapel] SET [dex]='"+facturaVenta.getDex()+"', "
                    + " [fechaFactura] ='"+facturaVenta.getFechaFactura()+"',"
                    + " [bodegaFacturaVenta_id]= '"+facturaVenta.getBodegaFacturaVenta_id()+"'," 
                    + " [cliente_nit]= '"+facturaVenta.getCliente_nit()+"',"
                    + " [cliente_sucursal]='"+facturaVenta.getCliente_sucursal()+"',"
                    + " [empresaLocal_nit]='"+facturaVenta.getEmpresaLocal_nit()+"'," 
                    + " [empresaLocal_sucursal]='"+facturaVenta.getEmpresaLocal_sucursal()+"',"
                    + " [trm]= '"+facturaVenta.getTrm()+"',"
                    + " [valorTotalDolarIngresados]= '"+facturaVenta.getValorTotalEnDolarIngresados().toPlainString()+"'," 
                    + " [valorTotalDolarCalculados]= '"+facturaVenta.getValorTotalEnDolarCalculados().toPlainString()+"',"
                    + " [valorTotalPesosCalculados]= '"+facturaVenta.getValorTotalEnPesosCalculados().toPlainString()+"',"
                    + " [observaciones]= '"+facturaVenta.getObservaciones()+"', "
                    + " [estado]= '"+facturaVenta.getEstado()+"',"
                    + " [nombreQuienElabora]='"+facturaVenta.getNombreQuienElabora()+"' WHERE [maquilas].[dbo].[facturaVentaPapel].[id]='"+facturaVenta.getId()+"';");       
            registroVentaEditar.execute();
            result=1;
            try{           
                int idVenta=facturaVenta.getId();
                //Hacemos el llamado a metodo que elimina todos los ItemFacturas y regresando sus saldos de la factura anterior para registrar los nuevos Items.
                eliminarItemFacturas(idVenta);
                
                BigDecimal valorToltalPesos=new BigDecimal("0");
                for(int i=0; i< itemFactura.size(); i++){
                    PreparedStatement registrarItemFactura= conexion.prepareStatement("INSERT INTO [maquilas].[dbo].[itemFacturaPapel] ([facturaVentaPapel_id], [ingresoProducto_id], [cantidad], [valorUnitarioKilo], [total]) VALUES ('"+idVenta+"', '"+itemFactura.get(i).getIdIngresoProducto()+"', '"+itemFactura.get(i).getCantidad().toPlainString()+"','"+itemFactura.get(i).getValorUnitarioKilo()+"','"+itemFactura.get(i).getTotal().toPlainString()+"');;");       
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
                    PreparedStatement registrarAuditoria= conexion.prepareStatement("INSERT INTO [maquilas].[dbo].[auditoria] "
                            + "([id],[fechaMovimiento], [cp],[idTipoMovimiento], [descripcionTipoMovimiento], [bodegaOrigen],[bodegaDestino], [usuario_id], [cantidad], "
                            + "[fechaRegistroSistema]) VALUES ('"+consecutivoAuditoria+"','"+facturaVenta.getFechaFactura()+"',"
                                    + " '"+retornarCP(itemFactura.get(i).getIdIngresoProducto())+"', '"+idVenta+"', "
                            + " 'VentaPapelExtranjeraEditar', 'Extranjera','Extranjera', '"+user.getId()+"', '"+itemFactura.get(i).getCantidad().toPlainString()+"', '"+fechaRegistroSistemas+"');;");       
                    registrarAuditoria.execute();                
                    result=1; 
                }
                
                ///Procedemos a actualizar el valor Total en Dolar una vez registrados los itemProductos
                    BigDecimal totalFacturaVentaDolar = retornarSumaTotalesItemsFacturaVentaExtranjera(idVenta);                
                    PreparedStatement actualizarValorTotalDolar= conexion.prepareStatement("UPDATE [maquilas].[dbo].[facturaVentaPapel] SET [valorTotalDolarCalculados] = '"+totalFacturaVentaDolar.toPlainString()+"' WHERE [facturaVentaPapel].[id] = '"+idVenta+"';");       
                    actualizarValorTotalDolar.execute();                
                    result=1;  
                
                ///Procedemos a actualizar el valor Total en Pesos una vez registrados los itemProductos
                    BigDecimal totalFacturaVentaPesos =  retornarSumaTotalesItemsFacturaVentaExtranjera(idVenta); 
                    //JOptionPane.showMessageDialog(null,"TRM: "+facturaVenta.getTrm().toString() + "-- DOLAR_TOTAL:"+totalFacturaVentaPesos.toPlainString());
                    BigDecimal trmFacturaVenta= new BigDecimal(facturaVenta.getTrm().toString());
                    totalFacturaVentaPesos=totalFacturaVentaPesos.multiply(trmFacturaVenta);
                    //JOptionPane.showMessageDialog(null," ="+totalFacturaVentaPesos.toPlainString());
                    PreparedStatement actualizarValorTotalPesos= conexion.prepareStatement("UPDATE [maquilas].[dbo].[facturaVentaPapel] SET [valorTotalPesosCalculados] = '"+totalFacturaVentaPesos.toPlainString()+"' WHERE [facturaVentaPapel].[id] = '"+idVenta+"';");       
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
    public boolean validorCantidadesExistentesBodegaExtranjera(ArrayList<ItemFacturaEditar> itemFactura) {
        //Este metodo solo compara si en Bododega hay existencia del los productos que se van a Exportar
        //En caso que si halla existencia retorna true, de lo contrario retorna false
        boolean validador=true;
        for(int i=0; i< itemFactura.size(); i++){          
            if(itemFactura.get(i).isCargadoEnFactura()){//Este Item factura ya existía en la factura por tal motivo debemos de sumar el saldo del cp + la cantidad del item para poderlo validar
                BigDecimal saldoEnBodegaExtranjera = retornarSumatoria_SaldoCPBodegaExtranjera_y_CantidadItemVenta(itemFactura.get(i).getIdIngresoProducto(),itemFactura.get(i).getIdFacturaVenta());
                BigDecimal cantidadEnFacturaVenta= itemFactura.get(i).getCantidad();
                if(saldoEnBodegaExtranjera.compareTo(cantidadEnFacturaVenta)== -1){
                    validador=false;
                }
            }else{//Este Item factura no existe por tal motivo solo comparamos la cantidad del CP con la cantidad solicitada en la venta
                BigDecimal saldoEnBodegaExtranjera=retornarSaldoBodegaIngresoProductoExtranjera(itemFactura.get(i).getIdIngresoProducto());
                BigDecimal cantidadEnFacturaVenta= itemFactura.get(i).getCantidad();
                if(saldoEnBodegaExtranjera.compareTo(cantidadEnFacturaVenta)== -1){
                    validador=false;
                }
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
            ResultSet resultSet = statement.executeQuery("select SUM(CONVERT(FLOAT, [total])) AS TOTAL  FROM [maquilas].[dbo].[itemFacturaPapel]  WHERE [facturaVentaPapel_id] ='"+idVenta+"';");
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
//#########################################################################################################
    public ArrayList<FacturaVenta> consultarFacturasVentasExtranjera(String valorConsulta) throws SQLException{
        ArrayList<FacturaVenta> listadoFacturaVentas = new ArrayList(); 
        control.ConectarBaseDatos();
        try{
            Statement statement  = conexion.createStatement();
            ResultSet resultSet;
            //resultSet = statement.executeQuery("select * from ingresoproducto "+script+" and estado=1;");
            resultSet = statement.executeQuery("SELECT TOP 1000 [id] \n" +
                                        "      ,[dex] \n" +
                                        "      ,[fechaFactura] \n" +
                                        "      ,[bodegaFacturaVenta_id] \n" +
                                        "      ,[cliente_nit] \n" +
                                        "      ,[cliente_sucursal] \n" +
                                        "      ,[empresaLocal_nit] \n" +
                                        "      ,[empresaLocal_sucursal] \n" +
                                        "      ,[trm] \n" +
                                        "      ,[valorTotalDolarIngresados] \n" +
                                        "      ,[valorTotalDolarCalculados] \n" +
                                        "      ,[valorTotalPesosCalculados] \n" +
                                        "      ,[observaciones] \n" +
                                        "      ,[estado] \n" +
                                        "      ,[nombreQuienElabora] \n" +
                                        "   FROM [maquilas].[dbo].[facturaVentaPapel] WHERE [facturaVentaPapel].[estado]=1 AND [facturaVentaPapel].[bodegaFacturaVenta_id]=1 "+valorConsulta+";");
                while(resultSet.next()){ 
                    FacturaVenta facturaVenta = new FacturaVenta(); 
                    facturaVenta.setId(Integer.parseInt(resultSet.getString(1)));
                    facturaVenta.setDex(resultSet.getString(2));
                    facturaVenta.setFechaFactura(resultSet.getString(3));
                    facturaVenta.setBodegaFacturaVenta_id(Integer.parseInt(resultSet.getString(4)));
                    facturaVenta.setCliente_nit(resultSet.getString(5));
                    facturaVenta.setCliente_sucursal(Integer.parseInt(resultSet.getString(6)));
                    facturaVenta.setEmpresaLocal_nit(resultSet.getString(7));
                    facturaVenta.setEmpresaLocal_sucursal(Integer.parseInt(resultSet.getString(8)));
                    facturaVenta.setTrm(Double.parseDouble(resultSet.getString(9)));
                    facturaVenta.setValorTotalEnDolarIngresados(new BigDecimal(resultSet.getString(10)));
                    facturaVenta.setValorTotalEnDolarCalculados(new BigDecimal(resultSet.getString(11)));
                    facturaVenta.setValorTotalEnPesosCalculados(new BigDecimal(resultSet.getString(12)));
                    facturaVenta.setObservaciones(resultSet.getString(13));
                    facturaVenta.setEstado(Integer.parseInt(resultSet.getString(14)));
                    facturaVenta.setNombreQuienElabora(resultSet.getString(15));
                    listadoFacturaVentas.add(facturaVenta); 
            }         
        }catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null, "Error al tratar al consultar");
            sqlException.printStackTrace();
        } 
        control.cerrarConexionBaseDatos();
        return listadoFacturaVentas;
    }
    public String consultarNombreCliente(Cliente c) throws SQLException{
        Cliente clienteRetorno=null;
        try{
            control.ConectarBaseDatos();
            Statement statement = null;
            statement = conexion.createStatement();
            ResultSet resultSet = null;
            if(c != null){
                resultSet = statement.executeQuery("SELECT * FROM [maquilas].[dbo].[cliente]  WHERE [nit] ='"+c.getNit()+"' AND [sucursal] = '"+c.getSucursal()+"';");
                while(resultSet.next()){ 
                clienteRetorno = new Cliente();       
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
            }
            }else{
               JOptionPane.showMessageDialog(null, "Verifique datos");
            }    
        }catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null, "Error al tratar al consultar");
            sqlException.printStackTrace();
        } 
        control.cerrarConexionBaseDatos();
        return clienteRetorno.getNombre();
    } 
    public String retornarCantidadTotalFacturaVenta(int facturaVentaId){
        Connection conexion= control.ConectarBaseDatos();
        String valor="";
            try{
                 Statement statement = conexion.createStatement();
                ResultSet resultSet = statement.executeQuery(""
                        + "SELECT TOP 1	\n" +
                        "		[CantidadSumada].[cantidadGeneral] AS facturaVenta_Cantidad	\n" +
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
                        "		INNER JOIN (SELECT facturaVentaPapel_id AS tablaX ,SUM(cantidad) AS cantidadGeneral FROM [dbo].[itemFacturaPapel] WHERE facturaVentaPapel_id='"+facturaVentaId+"' GROUP BY facturaVentaPapel_id) AS CantidadSumada\n" +
                        "		ON [CantidadSumada].[tablaX]=[facturaVentaPapel].id\n" +
                        "	WHERE [facturaVentaPapel].[id]='"+facturaVentaId+"';");
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
    public FacturaVenta consultarUnicaFacturasVentasExtranjera(String idFacturaVenta) throws SQLException{
        FacturaVenta facturaVenta =null; 
        control.ConectarBaseDatos();
        try{
            Statement statement  = conexion.createStatement();
            ResultSet resultSet;
            //resultSet = statement.executeQuery("select * from ingresoproducto "+script+" and estado=1;");
            resultSet = statement.executeQuery("SELECT TOP 1000 [id] \n" +
                                        "      ,[dex] \n" +
                                        "      ,[fechaFactura] \n" +
                                        "      ,[bodegaFacturaVenta_id] \n" +
                                        "      ,[cliente_nit] \n" +
                                        "      ,[cliente_sucursal] \n" +
                                        "      ,[empresaLocal_nit] \n" +
                                        "      ,[empresaLocal_sucursal] \n" +
                                        "      ,[trm] \n" +
                                        "      ,[valorTotalDolarIngresados] \n" +
                                        "      ,[valorTotalDolarCalculados] \n" +
                                        "      ,[valorTotalPesosCalculados] \n" +
                                        "      ,[observaciones] \n" +
                                        "      ,[estado] \n" +
                                        "      ,[nombreQuienElabora] \n" +
                                        "   FROM [maquilas].[dbo].[facturaVentaPapel] WHERE [facturaVentaPapel].[bodegaFacturaVenta_id]=1 AND [facturaVentaPapel].[id]="+idFacturaVenta+";");
                while(resultSet.next()){ 
                    facturaVenta = new FacturaVenta(); 
                    facturaVenta.setId(Integer.parseInt(resultSet.getString(1)));
                    facturaVenta.setDex(resultSet.getString(2));
                    facturaVenta.setFechaFactura(resultSet.getString(3));
                    facturaVenta.setBodegaFacturaVenta_id(Integer.parseInt(resultSet.getString(4)));
                    facturaVenta.setCliente_nit(resultSet.getString(5));
                    facturaVenta.setCliente_sucursal(Integer.parseInt(resultSet.getString(6)));
                    facturaVenta.setEmpresaLocal_nit(resultSet.getString(7));
                    facturaVenta.setEmpresaLocal_sucursal(Integer.parseInt(resultSet.getString(8)));
                    facturaVenta.setTrm(Double.parseDouble(resultSet.getString(9)));
                    facturaVenta.setValorTotalEnDolarIngresados(new BigDecimal(resultSet.getString(10)));
                    facturaVenta.setValorTotalEnDolarCalculados(new BigDecimal(resultSet.getString(11)));
                    facturaVenta.setValorTotalEnPesosCalculados(new BigDecimal(resultSet.getString(12)));
                    facturaVenta.setObservaciones(resultSet.getString(13));
                    facturaVenta.setEstado(Integer.parseInt(resultSet.getString(14)));
                    facturaVenta.setNombreQuienElabora(resultSet.getString(15));
                    
            }         
        }catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null, "Error al tratar al consultar");
            sqlException.printStackTrace();
        } 
        control.cerrarConexionBaseDatos();
        return facturaVenta;
    }
    public ArrayList<ItemFactura> consultarItemFacturasVentasExtranjera(String idFacturaVenta) throws SQLException{
        ArrayList<ItemFactura> listadoItemFacturas = new ArrayList(); 
        control.ConectarBaseDatos();
        try{
            Statement statement  = conexion.createStatement();
            ResultSet resultSet;
            //resultSet = statement.executeQuery("select * from ingresoproducto "+script+" and estado=1;");
            resultSet = statement.executeQuery(" SELECT  [facturaVentaPapel_id] " +
                                                " ,[ingresoProducto_id] " +
                                                " ,[cantidad]  " +
                                                " ,[valorUnitarioKilo] " +
                                                " ,[total] " +
                                                " FROM [maquilas].[dbo].[itemFacturaPapel] WHERE [itemFacturaPapel].[facturaVentaPapel_id] = '"+idFacturaVenta+"';");
            while(resultSet.next()){ 
                ItemFactura  itemFactura = new ItemFactura(); 
                itemFactura.setIdFacturaVenta(Integer.parseInt(resultSet.getString(1)));
                itemFactura.setIdIngresoProducto(Integer.parseInt(resultSet.getString(2)));
                itemFactura.setCantidad(new BigDecimal(resultSet.getString(3)));
                itemFactura.setValorUnitarioKilo(Double.parseDouble(resultSet.getString(4)));
                itemFactura.setTotal(new BigDecimal(resultSet.getString(5)));
                listadoItemFacturas.add(itemFactura);           
            }         
        }catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null, "Error al tratar al consultar");
            sqlException.printStackTrace();
        } 
        control.cerrarConexionBaseDatos();
        return listadoItemFacturas;
    }
    public Cliente retornarCliente(Cliente c) throws SQLException{
        Cliente clienteRetorno=null;
        try{
            control.ConectarBaseDatos();
            Statement statement = null;
            statement = conexion.createStatement();
            ResultSet resultSet = null;
            if(c != null){
                resultSet = statement.executeQuery("SELECT * FROM [maquilas].[dbo].[cliente]  WHERE [nit] ='"+c.getNit()+"' AND [sucursal] = '"+c.getSucursal()+"';");
                while(resultSet.next()){ 
                clienteRetorno = new Cliente();       
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
            }
            }else{
               JOptionPane.showMessageDialog(null, "Verifique datos");
            }    
        }catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null, "Error al tratar al consultar");
            sqlException.printStackTrace();
        } 
        control.cerrarConexionBaseDatos();
        return clienteRetorno;
    } 
    public IngresoProducto retornarCompra(int idCompra) throws SQLException{
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
    public String retornoNombreProducto(int idProducto){
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
    public Proveedor retornarProveedor(Proveedor p) throws SQLException{
        Proveedor ProveedorRetorno = null;    
        control.ConectarBaseDatos();
        Statement statement = null;
        try{
            statement = conexion.createStatement();
            ResultSet resultSet = null;
            if(p != null){
                resultSet = statement.executeQuery("SELECT * FROM [maquilas].[dbo].[proveedor] where [nit] ='"+p.getNit()+"' AND [sucursal] = '"+p.getSucursal()+"';");
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
            }else{
               JOptionPane.showMessageDialog(null, "Verifique datos");
            }

            
        }catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null, "Error al tratar al consultar");
            sqlException.printStackTrace();
        } 
        control.cerrarConexionBaseDatos();
        return ProveedorRetorno;
    } 
    public void eliminarItemFacturas(int idFacturaVenta) throws SQLException{
        ArrayList<ItemFactura> listadoItemFacturas = consultarItemFacturasVentasExtranjera(""+idFacturaVenta);
        for(int i=0; i< listadoItemFacturas.size(); i++){
            actualizarNuevoSaldoBodegaIngresoProductoBodegaExtranjeraAntesdeEliminarItemVentas(listadoItemFacturas.get(i).getIdIngresoProducto(),listadoItemFacturas.get(i).getCantidad());
            PreparedStatement r= conexion.prepareStatement("DELETE FROM [maquilas].[dbo].[itemFacturaPapel] WHERE [itemFacturaPapel].[facturaVentaPapel_id]='"+idFacturaVenta+"' AND [ingresoProducto_id]='"+listadoItemFacturas.get(i).getIdIngresoProducto()+"';");
            r.execute();
        }
    }
    public int actualizarNuevoSaldoBodegaIngresoProductoBodegaExtranjeraAntesdeEliminarItemVentas(int ingresoProducto_id, BigDecimal cantidad){
        BigDecimal saldo=new BigDecimal(""+retornarSaldoBodegaIngresoProductoExtranjera(ingresoProducto_id));
        BigDecimal saldoNuevo= saldo.add(cantidad);         
        control.ConectarBaseDatos();
        int result=0;
        try{
            PreparedStatement r= conexion.prepareStatement("UPDATE [maquilas].[dbo].[bodega_ingresoproducto] SET [saldo] = '"+saldoNuevo.toPlainString()+"' "+
                    "WHERE [bodega_ingresoproducto].[bodega_id] = 1 AND [bodega_ingresoproducto].[ingresoProducto_id] = '"+ingresoProducto_id+"';");
            r.execute();
            result++;  
            try{
                PreparedStatement h= conexion.prepareStatement("UPDATE [ingresoproducto] SET [estado] = '1' WHERE [id] = '"+ingresoProducto_id+"';");
                h.execute();
                result++;
            }
            catch (SQLException sqlException ){   
                result=0;
                JOptionPane.showMessageDialog(null, "ERROR al querer insertar los datos.");
                sqlException.printStackTrace();
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
    public BigDecimal retornarSumatoria_SaldoCPBodegaExtranjera_y_CantidadItemVenta(int ingresoProducto_id, int idFacturaVenta){
        Connection conexion= control.ConectarBaseDatos();
        BigDecimal saldo=new java.math.BigDecimal("0");
        try{
            Statement statement_SaldoCPBodegaExtranjera  = conexion.createStatement();
            ResultSet resultSet_SaldoCPBodegaExtranjera = statement_SaldoCPBodegaExtranjera.executeQuery("SELECT [saldo] FROM [maquilas].[dbo].[bodega_ingresoproducto] WHERE [bodega_id]=1 AND [ingresoProducto_id]='"+ingresoProducto_id+"';");
            while(resultSet_SaldoCPBodegaExtranjera.next()){ 
                String valor=resultSet_SaldoCPBodegaExtranjera.getString(1);
                //JOptionPane.showMessageDialog(null, ""+valor);
                saldo=saldo.add(new java.math.BigDecimal(valor));
            }
            Statement statement_CantidadItemVenta  = conexion.createStatement();
            ResultSet resultSet_CantidadItemVenta = statement_CantidadItemVenta.executeQuery("SELECT [cantidad] FROM [maquilas].[dbo].[itemFacturaPapel] WHERE [facturaVentaPapel_id]='"+idFacturaVenta+"' AND [ingresoProducto_id]='"+ingresoProducto_id+"';");
            while(resultSet_CantidadItemVenta.next()){ 
                String valor=resultSet_CantidadItemVenta.getString(1);
                //JOptionPane.showMessageDialog(null, ""+valor);
                saldo=saldo.add(new java.math.BigDecimal(valor));
            }
        }catch (SQLException sqlException){
            JOptionPane.showMessageDialog(null, "Error al Tratar de buscar");
            sqlException.printStackTrace();
        } 
        control.cerrarConexionBaseDatos();
        return saldo;
    }
    
}
