package Controladores;
import Modelos.FacturaVenta;
import Modelos.IngresoProducto;
import Modelos.ItemFactura;
import Modelos.Producto;
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

public class ControlDB_VentaFacturacionElectronica_RegistrarFacturaNacional {
    private Connection conexion=null;
    private  ControlDB_DB control=null; 
    private int consecutivoVenta=0;
    private int consecutivoAuditoria=0;
    
    public ControlDB_VentaFacturacionElectronica_RegistrarFacturaNacional() {
        control = new ControlDB_DB();
        conexion= control.ConectarBaseDatos();       
    }   
    public int retornarElMaximo(){
        Connection conexion= control.ConectarBaseDatos();
        int retorno=0;
        Statement statement = null;
        try{
            statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT MAX([id]) FROM [dbo].[facturaVentaElectronica];");
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
        if(retorno == 0){
            return 0; //Para que al sumarle la factura quede en 1 que es el parametro establecido por el cliente
        }else{
            return retorno;
        }
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
    public ArrayList<IngresoProducto> consultarCpBodegaNacional(String valorConsulta) throws SQLException{
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
                               + " ON [bodega].[id] = [bog_ingreProduc].[bodega_id] AND [bodega].[id] =2 "
                     + " INNER JOIN [proveedor] "
                               + " ON [ingreProduct].[proveedor_nit] = [proveedor].[nit] AND [ingreProduct].[proveedor_sucursal] = [proveedor].[sucursal] "
                    + "WHERE ([ingreProduct].[cp] like '%"+valorConsulta+"%'"
                       + " OR [ingreProduct].[proveedor_nit] like '%"+valorConsulta+"%' OR [proveedor].[nombre] like '%"+valorConsulta+"%' OR "
                            + " [ingreProduct].[numeroFacturaProveedor] like '%"+valorConsulta+"%' OR [ingreProduct].[resolucionFactura] like '%"+valorConsulta+"%' "
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
    public String validarSaldoBodegaNacional(String idIngresoProducto) throws SQLException{
        control.ConectarBaseDatos();
        String saldo="0";
        try{
            Statement statement  = conexion.createStatement();
            ResultSet resultSet;
            //resultSet = statement.executeQuery("select * from ingresoproducto "+script+" and estado=1;");
            resultSet = statement.executeQuery(" SELECT [saldo] FROM [dbo].[bodega_ingresoProducto] WHERE [ingresoProducto_id] ='"+idIngresoProducto+"' AND [bodega_id] =2;");
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
    public String validarNombreBodegaNacional(String id ) throws SQLException{
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
            JOptionPane.showMessageDialog(null, "Error al tratar al consultar el Nombre de la Bodega Nacional");
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
            JOptionPane.showMessageDialog(null, "Error al tratar al consultar el Nombre de la Bodega Nacional");
            sqlException.printStackTrace();
        } 
        control.cerrarConexionBaseDatos();
        return product;
    }  
    public int registrarVentaNacional(FacturaVenta facturaVentaElectronica, ArrayList<ItemFactura> itemFacturaElectronica, Usuario user) throws FileNotFoundException, SQLException{
        Connection conexion= control.ConectarBaseDatos();
        int result=0;
        try{
            //BigDecimal valorTotalPesos = new BigDecimal(facturaVentaElectronica.getValorTotalEnPesosCalculados().toPlainString());
             //#########################################################
               try{
                    consecutivoVenta=retornarElMaximo();
                    consecutivoVenta++;
               }catch(Exception e){
                   consecutivoVenta=253;                   
               }   
            PreparedStatement registroVenta= conexion.prepareStatement("INSERT INTO [maquilas].[dbo].[facturaVentaElectronica] ([id],[dex], [fechaFactura], [bodegaFacturaVenta_id]," +
                        " [cliente_nit], [cliente_sucursal], [empresaLocal_nit], [empresaLocal_sucursal]," +
                        "  [trm], [valorTotalDolarIngresados], [valorTotalDolarCalculados], " +
                        " [valorTotalPesosCalculados], [observaciones], [estado], [nombreQuienElabora]) VALUES ('"+consecutivoVenta+"','"+facturaVentaElectronica.getDex()+"'," +
                        " '"+facturaVentaElectronica.getFechaFactura()+"', '"+facturaVentaElectronica.getBodegaFacturaVenta_id()+"', '"+facturaVentaElectronica.getCliente_nit()+"',"+
                        " '"+facturaVentaElectronica.getCliente_sucursal()+"', '"+facturaVentaElectronica.getEmpresaLocal_nit()+"', "+
                        " '"+facturaVentaElectronica.getEmpresaLocal_sucursal()+"', '"+facturaVentaElectronica.getTrm()+"',"+
                        " '"+facturaVentaElectronica.getValorTotalEnDolarIngresados().toPlainString()+"', '"+facturaVentaElectronica.getValorTotalEnDolarCalculados().toPlainString()+"',"+
                        " '"+facturaVentaElectronica.getValorTotalEnPesosCalculados().toPlainString()+"', '"+facturaVentaElectronica.getObservaciones()+"', "+
                        " '"+facturaVentaElectronica.getEstado()+"', '"+facturaVentaElectronica.getNombreQuienElabora()+"');");           
            registroVenta.execute();
            result=1;
            try{           
                int idVenta=retornarElMaximo();
                BigDecimal valorToltalPesos=new BigDecimal("0");
                for(int i=0; i< itemFacturaElectronica.size(); i++){
                    PreparedStatement registrarItemFactura= conexion.prepareStatement("INSERT INTO [maquilas].[dbo].[itemFacturaElectronica] ([facturaVentaElectronica_id], [ingresoProducto_id], [cantidad], [valorUnitarioKilo], [total]) VALUES ('"+idVenta+"', '"+itemFacturaElectronica.get(i).getIdIngresoProducto()+"', '"+itemFacturaElectronica.get(i).getCantidad().toPlainString()+"','"+itemFacturaElectronica.get(i).getValorUnitarioKilo()+"','"+itemFacturaElectronica.get(i).getTotal().toPlainString()+"');;");       
                    registrarItemFactura.execute();
                    valorToltalPesos.add(new BigDecimal(""+itemFacturaElectronica.get(i).getTotal()));
                    actualizarSaldoBodegaIngresoProductoBodegaNacional(itemFacturaElectronica.get(i).getIdIngresoProducto(), itemFacturaElectronica.get(i).getCantidad());
                    int contador=validadorSaldosIngresoProducto(itemFacturaElectronica.get(i).getIdIngresoProducto());
                    if(contador==2){
                        JOptionPane.showMessageDialog(null, "El CP: "+retornarCP(itemFacturaElectronica.get(i).getIdIngresoProducto())+" tiene Cero saldo por tal motivo queda Inactivo");
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
                            + "[fechaRegistroSistema]) VALUES ('"+consecutivoAuditoria+"','"+facturaVentaElectronica.getFechaFactura()+"',"
                                    + " '"+retornarCP(itemFacturaElectronica.get(i).getIdIngresoProducto())+"', '"+idVenta+"', "
                                + " 'VentaElectronicaNacionalRegistrar', 'Nacional','Nacional', '"+user.getId()+"', '"+itemFacturaElectronica.get(i).getCantidad().toPlainString()+"', '"+fechaRegistroSistemas+"');;");       
                    registrarAuditoria.execute();                
                    result=1; 
                }
                
                ///Procedemos a actualizar el valor Total en Pesos una vez registrados los itemProductos
                    BigDecimal totalFacturaVenta = retornarSumaTotalesItemsFacturaVentaNacional(idVenta);                
                    PreparedStatement actualizarValorTotalPesos= conexion.prepareStatement("UPDATE [maquilas].[dbo].[facturaVentaElectronica] SET [valorTotalPesosCalculados] = '"+totalFacturaVenta.toPlainString()+"' WHERE [facturaVentaElectronica].[id] = '"+idVenta+"';");       
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
    public int actualizarSaldoBodegaIngresoProductoBodegaNacional(int ingresoProducto_id, BigDecimal cantidad){
        BigDecimal saldo=new BigDecimal(""+retornarSaldoBodegaIngresoProductoNacional(ingresoProducto_id));
        BigDecimal saldoNuevo= saldo.subtract(cantidad);         
        control.ConectarBaseDatos();
        int result=0;
        try{
            PreparedStatement r= conexion.prepareStatement("UPDATE [maquilas].[dbo].[bodega_ingresoproducto] SET [saldo] = '"+saldoNuevo.toPlainString()+"' "+
                    "WHERE [bodega_ingresoproducto].[bodega_id] = 2 AND [bodega_ingresoproducto].[ingresoProducto_id] = '"+ingresoProducto_id+"';");
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
    public BigDecimal retornarSaldoBodegaIngresoProductoNacional(int ingresoProducto_id){
        Connection conexion= control.ConectarBaseDatos();
        BigDecimal saldo=new java.math.BigDecimal("0");
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
    public boolean validorCantidadesExistentesBodegaNacional(ArrayList<ItemFactura> itemFacturaElectronica) {
        //Este metodo solo compara si en Bododega hay existencia del los productos que se van a Exportar
        //En caso que si halla existencia retorna true, de lo contrario retorna false
        boolean validador=true;
        for(int i=0; i< itemFacturaElectronica.size(); i++){
            BigDecimal saldoEnBodegaNaciona=retornarSaldoBodegaIngresoProductoNacional(itemFacturaElectronica.get(i).getIdIngresoProducto());
            BigDecimal cantidadEnFacturaVenta= itemFacturaElectronica.get(i).getCantidad();
            if(saldoEnBodegaNaciona.compareTo(cantidadEnFacturaVenta)== -1){
                validador=false;
            }
        }
        return validador;       
    }
    public BigDecimal retornarSumaTotalesItemsFacturaVentaNacional(int idVenta){
        Connection conexion= control.ConectarBaseDatos();
        BigDecimal total=new java.math.BigDecimal("0");
        Statement statement = null;
        try{
            statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery("select SUM(CONVERT(FLOAT, [total])) AS TOTAL  FROM [maquilas].[dbo].[itemFacturaElectronica]  WHERE [facturaVentaElectronica_id] ='"+idVenta+"';");
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
}
