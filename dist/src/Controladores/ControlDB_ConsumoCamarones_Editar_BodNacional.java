
package Controladores;

import Modelos.Cliente;
import Modelos.Consumo;
import Modelos.FacturaVenta;
import Modelos.IngresoProducto;
import Modelos.ItemConsumo;
import Modelos.ItemConsumoEditar;
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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

public class ControlDB_ConsumoCamarones_Editar_BodNacional {
    private Connection conexion=null;
    private  ControlDB_DB control=null;    
    private int consecutivoConsumo=0;
    private int consecutivoAuditoria=0;
    
    public ControlDB_ConsumoCamarones_Editar_BodNacional() {
        control = new ControlDB_DB();
        conexion= control.ConectarBaseDatos();       
    }   
   public int retornarElMaximo(){
        Connection conexion= control.ConectarBaseDatos();
        int retorno=0;
        Statement statement = null;
        try{
            statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT MAX([id]) FROM [dbo].[consumo];");
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
                            + " INNER JOIN [dbo].[proveedor]  " 
                                       +" ON [proveedor].[nit] = [ingreProduct].[proveedor_nit] AND [proveedor].[sucursal] = [ingreProduct].[proveedor_sucursal] "
                    + "WHERE ([ingreProduct].[cp] like '%"+valorConsulta+"%'"
                       + " OR [ingreProduct].[proveedor_nit] like '%"+valorConsulta+"%' OR [proveedor].[nombre] like '%"+valorConsulta+"%' OR "
                            + "[ingreProduct].[numeroFacturaProveedor] like '%"+valorConsulta+"%' OR [ingreProduct].[resolucionFactura] like '%"+valorConsulta+"%' "
                                    + ") AND [ingreProduct].[estado]=1 AND [ingreProduct].[producto_id]=1  ;");
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
            JOptionPane.showMessageDialog(null, "Error al tratar al consultar el Nombre de la Bodega");
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
    public int registrarConsumoNacional(Consumo consumo, ArrayList<ItemConsumoEditar> itemConsumo, Usuario user) throws FileNotFoundException, SQLException{
       Connection conexion= control.ConectarBaseDatos();
        int result=0;
        try{
            //BigDecimal valorTotalPesos = new BigDecimal(consumo.getValorTotalEnPesos().toPlainString());
            PreparedStatement registroVentaEditar= conexion.prepareStatement("UPDATE [maquilas].[dbo].[consumo] SET "
                    + " [fechaConsumo]='"+consumo.getFechaConsumo()+"', "
                    + " [bodegaConsumo_id]='"+consumo.getBodegaConsumo_id()+"', "
                    + " [cliente_nit]='"+consumo.getCliente_nit()+"', "
                    + " [cliente_sucursal]='"+consumo.getCliente_sucursal()+"', "
                    + " [empresaLocal_nit]='"+consumo.getEmpresaLocal_nit()+"', "
                    + " [empresaLocal_sucursal]='"+consumo.getEmpresaLocal_sucursal()+"', "
                    + " [valorTotalPesos]='"+consumo.getValorTotalEnPesos().toPlainString()+"', "
                    + " [observaciones]='"+consumo.getObservaciones()+"', "
                    + " [estado]='"+consumo.getEstado()+"', "
                    + " [nombreQuienElabora]='"+consumo.getNombreQuienElabora()+"' WHERE [maquilas].[dbo].[consumo].[id]='"+consumo.getId()+"';");                 
            registroVentaEditar.execute();
            result=1;
            try{           
                int idConsumo=consumo.getId();
                //Hacemos el llamado a metodo que elimina todos los ItemConsumos y regresando sus saldos del consumo anterior para registrar los nuevos Items.
                eliminarItemConsumo(idConsumo);
                
                BigDecimal valorToltalPesos=new BigDecimal("0");
                for(int i=0; i< itemConsumo.size(); i++){
                    PreparedStatement registrarItemConsumo= conexion.prepareStatement("INSERT INTO [maquilas].[dbo].[itemConsumo] ([ingresoProducto_id],[consumo_id],[cantidad], [valorUnitario], [total]) VALUES ('"+itemConsumo.get(i).getIdIngresoProducto()+"', '"+idConsumo+"', '"+itemConsumo.get(i).getCantidad().toPlainString()+"','"+itemConsumo.get(i).getValorUnitarioKilo()+"','"+itemConsumo.get(i).getTotal().toPlainString()+"');;");       
                    registrarItemConsumo.execute();
                    valorToltalPesos.add(new BigDecimal(""+itemConsumo.get(i).getTotal()));
                    actualizarSaldoBodegaIngresoProductoBodegaNacional(itemConsumo.get(i).getIdIngresoProducto(), itemConsumo.get(i).getCantidad());
                    int contador=validadorSaldosIngresoProducto(itemConsumo.get(i).getIdIngresoProducto());
                    if(contador==2){
                        JOptionPane.showMessageDialog(null, "El CP: "+retornarCP(itemConsumo.get(i).getIdIngresoProducto())+" tiene Cero saldo por tal motivo queda Inactivo");
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
                            + "[fechaRegistroSistema]) VALUES ('"+consecutivoAuditoria+"','"+consumo.getFechaConsumo()+"',"
                                    + " '"+retornarCP(itemConsumo.get(i).getIdIngresoProducto())+"', '"+idConsumo+"', "
                                + " 'ConsumoNacionalEditar', 'Nacional','Nacional', '"+user.getId()+"', '"+itemConsumo.get(i).getCantidad().toPlainString()+"', '"+fechaRegistroSistemas+"');;");       
                    registrarAuditoria.execute();                
                    result=1; 
                }
                
                ///Procedemos a actualizar el valor Total en Pesos una vez registrados los itemProductos
                    BigDecimal totalValorConsumo = retornarSumaTotalesItemsConsumoNacional(idConsumo);                
                    PreparedStatement actualizarValorTotalPesos= conexion.prepareStatement("UPDATE [maquilas].[dbo].[consumo] SET [valorTotalPesos] = '"+totalValorConsumo.toPlainString()+"' WHERE [consumo].[id] = '"+idConsumo+"';");       
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
    public boolean validorCantidadesExistentesBodegaNacional(ArrayList<ItemConsumoEditar> itemConsumo) {
        //Este metodo solo compara si en Bododega hay existencia del los productos que se van a Exportar
        //En caso que si halla existencia retorna true, de lo contrario retorna false
        boolean validador=true;
        for(int i=0; i< itemConsumo.size(); i++){
            if(itemConsumo.get(i).isCargadoEnFactura()){//Este Item factura ya existía en la factura por tal motivo debemos de sumar el saldo del cp + la cantidad del item para poderlo validar
                BigDecimal saldoEnBodegaNacional = retornarSumatoria_SaldoCPBodegaNacional_y_CantidadItemConsumo(itemConsumo.get(i).getIdIngresoProducto(),itemConsumo.get(i).getIdConsumo());
                BigDecimal cantidadEnFacturaVenta= itemConsumo.get(i).getCantidad();
                if(saldoEnBodegaNacional.compareTo(cantidadEnFacturaVenta)== -1){
                    validador=false;
                }
            }else{//Este Item factura no existe por tal motivo solo comparamos la cantidad del CP con la cantidad solicitada en la venta
                BigDecimal saldoEnBodegaNacional=retornarSaldoBodegaIngresoProductoNacional(itemConsumo.get(i).getIdIngresoProducto());
                BigDecimal cantidadEnFacturaVenta= itemConsumo.get(i).getCantidad();
                if(saldoEnBodegaNacional.compareTo(cantidadEnFacturaVenta)== -1){
                    validador=false;
                }
            }
        }
        return validador;       
    }
    public BigDecimal retornarSumaTotalesItemsConsumoNacional(int idConsumo){
        Connection conexion= control.ConectarBaseDatos();
        BigDecimal total=new java.math.BigDecimal("0");
        Statement statement = null;
        try{
            statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery("select SUM(CONVERT(FLOAT, [total])) AS TOTAL  FROM [maquilas].[dbo].[itemConsumo]  WHERE [consumo_id] ='"+idConsumo+"';");
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
    public ArrayList<Consumo> consultarConsumosCamaronesNacional(String valorConsulta) throws SQLException{
        ArrayList<Consumo> listadoConsumo = new ArrayList(); 
        control.ConectarBaseDatos();
        try{
            Statement statement  = conexion.createStatement();
            ResultSet resultSet;
            //resultSet = statement.executeQuery("select * from ingresoproducto "+script+" and estado=1;");
            resultSet = statement.executeQuery("SELECT TOP 1000 [consumo].[id] " +
                                                "      ,[consumo].[fechaConsumo] " +
                                                "      ,[consumo].[bodegaConsumo_id] " +
                                                "      ,[consumo].[cliente_nit] " +
                                                "      ,[consumo].[cliente_sucursal] " +
                                                "      ,[consumo].[empresaLocal_nit] " +
                                                "      ,[consumo].[empresaLocal_sucursal] " +
                                                "      ,[consumo].[valorTotalPesos] " +
                                                "      ,[consumo].[observaciones] " +
                                                "      ,[consumo].[estado] " +
                                                "      ,[consumo].[nombreQuienElabora] " +
                                                "  FROM [maquilas].[dbo].[consumo] "
                    + " INNER JOIN [itemConsumo] ON [itemConsumo].[consumo_id]=[consumo].[id] "
                    + " INNER JOIN [ingresoProducto] ON [ingresoProducto].[id]=[itemConsumo].[ingresoProducto_id] AND [ingresoProducto].[producto_id]=1 "
                    + " WHERE [consumo].[estado]=1 AND [consumo].[bodegaConsumo_id]=2 "+valorConsulta+";");
                while(resultSet.next()){ 
                    Consumo consumo = new Consumo(); 
                    consumo.setId(Integer.parseInt(resultSet.getString(1)));
                    consumo.setFechaConsumo(resultSet.getString(2));
                    consumo.setBodegaConsumo_id(Integer.parseInt(resultSet.getString(3)));
                    consumo.setCliente_nit(resultSet.getString(4));
                    consumo.setCliente_sucursal(Integer.parseInt(resultSet.getString(5)));
                    consumo.setEmpresaLocal_nit(resultSet.getString(6));
                    consumo.setEmpresaLocal_sucursal(Integer.parseInt(resultSet.getString(7)));
                    consumo.setValorTotalEnPesos(new java.math.BigDecimal(resultSet.getString(8)));
                    consumo.setObservaciones(resultSet.getString(9));
                    consumo.setEstado(Integer.parseInt(resultSet.getString(10)));
                    consumo.setNombreQuienElabora(resultSet.getString(11));
                    listadoConsumo.add(consumo); 
            }         
        }catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null, "Error al tratar al consultar");
            sqlException.printStackTrace();
        } 
        control.cerrarConexionBaseDatos();
        return listadoConsumo;
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
    public String retornarCantidadTotalConsumo(int idConsumo){
        Connection conexion= control.ConectarBaseDatos();
        String valor="";
            try{
                 Statement statement = conexion.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT  " +
                                            "  SUM([cantidad]) AS itemConsumo_cantidad " +
                                            "  FROM [maquilas].[dbo].[itemConsumo] " +
                                            "  WHERE consumo_id='"+idConsumo+"';");
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
    public Consumo consultarUnicoConsumoNacional(String idConsumo) throws SQLException{
        System.out.println(""+idConsumo);
        Consumo consumo =new Consumo(); 
        control.ConectarBaseDatos();
        try{
            Statement statement  = conexion.createStatement();
            ResultSet resultSet;
            //resultSet = statement.executeQuery("select * from ingresoproducto "+script+" and estado=1;");
            resultSet = statement.executeQuery("SELECT TOP 1000 [id] " +
                                                "      ,[fechaConsumo] " +
                                                "      ,[bodegaConsumo_id] " +
                                                "      ,[cliente_nit] " +
                                                "      ,[cliente_sucursal] " +
                                                "      ,[empresaLocal_nit] " +
                                                "      ,[empresaLocal_sucursal] " +
                                                "      ,[valorTotalPesos] " +
                                                "      ,[observaciones] " +
                                                "      ,[estado] " +
                                                "      ,[nombreQuienElabora] " +
                                                "  FROM [maquilas].[dbo].[consumo] WHERE [consumo].[estado]=1 AND [consumo].[bodegaConsumo_id]=2  AND [consumo].[id]="+idConsumo+";");
                while(resultSet.next()){ 
                    
                    consumo.setId(Integer.parseInt(resultSet.getString(1)));
                    consumo.setFechaConsumo(resultSet.getString(2));
                    consumo.setBodegaConsumo_id(Integer.parseInt(resultSet.getString(3)));
                    consumo.setCliente_nit(resultSet.getString(4));
                    consumo.setCliente_sucursal(Integer.parseInt(resultSet.getString(5)));
                    consumo.setEmpresaLocal_nit(resultSet.getString(6));
                    consumo.setEmpresaLocal_sucursal(Integer.parseInt(resultSet.getString(7)));
                    consumo.setValorTotalEnPesos(new java.math.BigDecimal(resultSet.getString(8)));
                    consumo.setObservaciones(resultSet.getString(9));
                    consumo.setEstado(Integer.parseInt(resultSet.getString(10)));
                    consumo.setNombreQuienElabora(resultSet.getString(11));
                    System.out.println(""+consumo.getId()+":"+consumo.getNombreQuienElabora());
            }         
        }catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null, "Error al tratar al consultar");
            sqlException.printStackTrace();
        } 
        control.cerrarConexionBaseDatos();
        return consumo;
    }
    public ArrayList<ItemConsumo> consultarItemConsumoNacional(String idConsumo) throws SQLException{
        ArrayList<ItemConsumo> listadoItemconsumo = new ArrayList(); 
        control.ConectarBaseDatos();
        try{
            Statement statement  = conexion.createStatement();
            ResultSet resultSet;
            //resultSet = statement.executeQuery("select * from ingresoproducto "+script+" and estado=1;");
            resultSet = statement.executeQuery("SELECT  [consumo_id] " +
                                                " ,[ingresoProducto_id] " +
                                                " ,[cantidad]  " +
                                                " ,[valorUnitario] " +
                                                " ,[total] " +
                                                " FROM [maquilas].[dbo].[itemConsumo] WHERE [itemConsumo].[consumo_id] = '"+idConsumo+"';");
            while(resultSet.next()){ 
                ItemConsumo  itemConsumo = new ItemConsumo(); 
                itemConsumo.setIdConsumo(Integer.parseInt(resultSet.getString(1)));
                itemConsumo.setIdIngresoProducto(Integer.parseInt(resultSet.getString(2)));
                itemConsumo.setCantidad(new BigDecimal(resultSet.getString(3)));
                itemConsumo.setValorUnitarioKilo(Double.parseDouble(resultSet.getString(4)));
                itemConsumo.setTotal(new BigDecimal(resultSet.getString(5)));
                listadoItemconsumo.add(itemConsumo);           
            }         
        }catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null, "Error al tratar al consultar");
            sqlException.printStackTrace();
        } 
        control.cerrarConexionBaseDatos();
        return listadoItemconsumo;
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
    public void eliminarItemConsumo(int idConsumo) throws SQLException{
        ArrayList<ItemConsumo> listadoItemConsumo = consultarItemConsumoNacional(""+idConsumo);
        for(int i=0; i< listadoItemConsumo.size(); i++){
            actualizarNuevoSaldoBodegaIngresoProductoBodegaNacionalAntesdeEliminartemConsumo(listadoItemConsumo.get(i).getIdIngresoProducto(),listadoItemConsumo.get(i).getCantidad());
            PreparedStatement r= conexion.prepareStatement("DELETE FROM [maquilas].[dbo].[itemConsumo] WHERE [itemConsumo].[consumo_id]='"+idConsumo+"' AND [ingresoProducto_id]='"+listadoItemConsumo.get(i).getIdIngresoProducto()+"';");
            r.execute();
        }
    }
    public int actualizarNuevoSaldoBodegaIngresoProductoBodegaNacionalAntesdeEliminartemConsumo(int ingresoProducto_id, BigDecimal cantidad){
        BigDecimal saldo=new BigDecimal(""+retornarSaldoBodegaIngresoProductoNacional(ingresoProducto_id));
        BigDecimal saldoNuevo= saldo.add(cantidad);         
        control.ConectarBaseDatos();
        int result=0;
        try{
            PreparedStatement r= conexion.prepareStatement("UPDATE [maquilas].[dbo].[bodega_ingresoproducto] SET [saldo] = '"+saldoNuevo.toPlainString()+"' "+
                    "WHERE [bodega_ingresoproducto].[bodega_id] = 2 AND [bodega_ingresoproducto].[ingresoProducto_id] = '"+ingresoProducto_id+"';");
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
    public BigDecimal retornarSumatoria_SaldoCPBodegaNacional_y_CantidadItemConsumo(int ingresoProducto_id, int idConsumo){
        Connection conexion= control.ConectarBaseDatos();
        BigDecimal saldo=new java.math.BigDecimal("0");
        try{
            Statement statement_SaldoCPBodegaNacional  = conexion.createStatement();
            ResultSet resultSet_SaldoCPBodegaNacional = statement_SaldoCPBodegaNacional.executeQuery("SELECT [saldo] FROM [maquilas].[dbo].[bodega_ingresoproducto] WHERE [bodega_id]=2 AND [ingresoProducto_id]='"+ingresoProducto_id+"';");
            while(resultSet_SaldoCPBodegaNacional.next()){ 
                String valor=resultSet_SaldoCPBodegaNacional.getString(1);
                saldo=saldo.add(new java.math.BigDecimal(valor));
            }
        }catch (SQLException sqlException){
            JOptionPane.showMessageDialog(null, "Error al Tratar de buscar");
            sqlException.printStackTrace();
        } 
        try{            
            Statement statement_CantidadItemVenta  = conexion.createStatement();
            ResultSet resultSet_CantidadItemVenta = statement_CantidadItemVenta.executeQuery("SELECT [cantidad] FROM [maquilas].[dbo].[itemConsumo] WHERE [consumo_id]='"+idConsumo+"' AND [ingresoProducto_id]='"+ingresoProducto_id+"';");
            while(resultSet_CantidadItemVenta.next()){ 
                String valor=resultSet_CantidadItemVenta.getString(1);             
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
