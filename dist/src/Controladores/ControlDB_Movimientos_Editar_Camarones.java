package Controladores;

import Modelos.Movimiento;
import Modelos.MovimientoItemProducto;
import Modelos.MovimientoProducto;
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

public class ControlDB_Movimientos_Editar_Camarones {
    private Connection conexion=null;
    private  ControlDB_DB control=null;  
    private int consecutivoAuditoria=0;
    
    public ControlDB_Movimientos_Editar_Camarones() {
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
    public MovimientoProducto consultarUnicoMovimientoProductoCamarones(int idMovimiento) throws SQLException{
        ArrayList<MovimientoItemProducto> listadoMovimientoItemProducto = new ArrayList(); 
        MovimientoProducto movimientoProducto = new MovimientoProducto(); 
        control.ConectarBaseDatos();
        try{
            Statement statement  = conexion.createStatement();
            ResultSet resultSetMovimientoProducto;
            resultSetMovimientoProducto = statement.executeQuery(" "
                    + "     SELECT \n" +
                    "	   [movimientoProducto].[id]\n" +
                    "      ,[movimientoProducto].[fechaMovimiento]\n" +
                    "      ,[movimientoProducto].[nombreQuienElabora]\n" +
                    "      ,[movimientoProducto].[estado]\n" +
                    "      ,[itemMovimientoProducto].[ingresoProducto_id]\n" +
                    "      ,[itemMovimientoProducto].[movimientoProducto_id]\n" +
                    "      ,[itemMovimientoProducto].[bodegaMovimiento_id]\n" +
                    "      ,[itemMovimientoProducto].[bodegaOrigen]\n" +
                    "      ,[itemMovimientoProducto].[bodegaDestino]\n" +
                    "      ,[itemMovimientoProducto].[saldoAnterior]\n" +
                    "      ,[itemMovimientoProducto].[cantidadTrasladada]\n" +
                    "      ,[itemMovimientoProducto].[saldoActual]\n" +
                    "  FROM [maquilas].[dbo].[itemMovimientoProducto]\n" +
                    "		INNER JOIN [dbo].[movimientoProducto]\n" +
                    "               ON [movimientoProducto].[id] = [itemMovimientoProducto].[movimientoProducto_id] AND [movimientoProducto].[estado]=1 AND [movimientoProducto].[id]='"+idMovimiento+"' \n" +
                    "           INNER JOIN [dbo].[ingresoProducto]\n" +
                    "		    ON [ingresoProducto].[id] = [itemMovimientoProducto].[ingresoProducto_id] \n" +
                    "		INNER JOIN [dbo].[producto]\n" +
                    "		    ON [ingresoProducto].[producto_id] = [producto].[id] AND [producto].[id]=1 ORDER BY [movimientoProducto].[id];");   
            while(resultSetMovimientoProducto.next()){    
                movimientoProducto.setId(Integer.parseInt(resultSetMovimientoProducto.getString(1)));
                movimientoProducto.setFechaMovimiento(resultSetMovimientoProducto.getString(2));
                movimientoProducto.setNombreQuienElabora(resultSetMovimientoProducto.getString(3));  
                movimientoProducto.setEstado(Integer.parseInt(resultSetMovimientoProducto.getString(4)));  
                MovimientoItemProducto movimientoItemProducto = new MovimientoItemProducto();
                movimientoItemProducto.setIngresoProducto_id(Integer.parseInt(resultSetMovimientoProducto.getString(5)));
                movimientoItemProducto.setMovimientoProducto_id(Integer.parseInt(resultSetMovimientoProducto.getString(6)));
                movimientoItemProducto.setBodegaMovimiento_id(Integer.parseInt(resultSetMovimientoProducto.getString(7)));
                movimientoItemProducto.setBodegaOrigen(resultSetMovimientoProducto.getString(8));
                movimientoItemProducto.setBodegaDestino(resultSetMovimientoProducto.getString(9));
                movimientoItemProducto.setSaldoAnterior(Integer.parseInt(resultSetMovimientoProducto.getString(10)));
                movimientoItemProducto.setCantidadTrasladada(Integer.parseInt(resultSetMovimientoProducto.getString(11)));
                movimientoItemProducto.setSaldoActual(Integer.parseInt(resultSetMovimientoProducto.getString(12)));  
                listadoMovimientoItemProducto.add(movimientoItemProducto);
            }       
            movimientoProducto.setMovimientoItemProducto(listadoMovimientoItemProducto);
        }catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null, "Error al tratar al consultar");
            sqlException.printStackTrace();
        } 
        control.cerrarConexionBaseDatos();
        return movimientoProducto;
    } 
    public ArrayList<MovimientoProducto> consultarListadoMovimientoProductoCamarones(String valorConsulta) throws SQLException{
        ArrayList<MovimientoProducto> listadoMovimientoProducto = new ArrayList();      
        control.ConectarBaseDatos();
        try{
            Statement statement  = conexion.createStatement();
            ResultSet resultSetMovimientoProducto;
            resultSetMovimientoProducto = statement.executeQuery(" "
                    + "     SELECT \n" +
                    "	   [movimientoProducto].[id]\n" +
                    "      ,[movimientoProducto].[fechaMovimiento]\n" +
                    "      ,[movimientoProducto].[nombreQuienElabora]\n" +
                    "      ,[movimientoProducto].[estado]\n" +
                    "      ,[itemMovimientoProducto].[ingresoProducto_id]\n" +
                    "      ,[itemMovimientoProducto].[movimientoProducto_id]\n" +
                    "      ,[itemMovimientoProducto].[bodegaMovimiento_id]\n" +
                    "      ,[itemMovimientoProducto].[bodegaOrigen]\n" +
                    "      ,[itemMovimientoProducto].[bodegaDestino]\n" +
                    "      ,[itemMovimientoProducto].[saldoAnterior]\n" +
                    "      ,[itemMovimientoProducto].[cantidadTrasladada]\n" +
                    "      ,[itemMovimientoProducto].[saldoActual]\n" +
                    "  FROM [maquilas].[dbo].[itemMovimientoProducto]\n" +
                    "		INNER JOIN [dbo].[movimientoProducto]\n" +
                    "               ON [movimientoProducto].[id] = [itemMovimientoProducto].[movimientoProducto_id] AND [movimientoProducto].[estado]=1  "
                    + "         INNER JOIN [dbo].[ingresoProducto]\n" +
                    "               ON [ingresoProducto].[id] = [itemMovimientoProducto].[ingresoProducto_id] \n" +
                    "           INNER JOIN [dbo].[producto]\n" +
                    "               ON [ingresoProducto].[producto_id] = [producto].[id] AND [producto].[id]=1 \n" +
                    "  WHERE ([movimientoProducto].[id] like '%"+valorConsulta+"%' OR [movimientoProducto].[nombreQuienElabora] like '%"+valorConsulta+"%' )"
                + "  ORDER BY [movimientoProducto].[id];");   
            while(resultSetMovimientoProducto.next()){   
                MovimientoProducto movimientoProducto = new MovimientoProducto();
                movimientoProducto.setId(Integer.parseInt(resultSetMovimientoProducto.getString(1)));
                movimientoProducto.setFechaMovimiento(resultSetMovimientoProducto.getString(2));
                movimientoProducto.setNombreQuienElabora(resultSetMovimientoProducto.getString(3));  
                movimientoProducto.setEstado(Integer.parseInt(resultSetMovimientoProducto.getString(4)));  
                
                MovimientoItemProducto movimientoItemProducto1 = new MovimientoItemProducto();
                movimientoItemProducto1.setIngresoProducto_id(Integer.parseInt(resultSetMovimientoProducto.getString(5)));
                movimientoItemProducto1.setMovimientoProducto_id(Integer.parseInt(resultSetMovimientoProducto.getString(6)));
                movimientoItemProducto1.setBodegaMovimiento_id(Integer.parseInt(resultSetMovimientoProducto.getString(7)));
                movimientoItemProducto1.setBodegaOrigen(resultSetMovimientoProducto.getString(8));
                movimientoItemProducto1.setBodegaDestino(resultSetMovimientoProducto.getString(9));
                movimientoItemProducto1.setSaldoAnterior(Integer.parseInt(resultSetMovimientoProducto.getString(10)));
                movimientoItemProducto1.setCantidadTrasladada(Integer.parseInt(resultSetMovimientoProducto.getString(11)));
                movimientoItemProducto1.setSaldoActual(Integer.parseInt(resultSetMovimientoProducto.getString(12))); 
                
                resultSetMovimientoProducto.next();//Generamos la siguiente lectura de ItemMovimientos
                MovimientoItemProducto movimientoItemProducto2 = new MovimientoItemProducto();
                movimientoItemProducto2.setIngresoProducto_id(Integer.parseInt(resultSetMovimientoProducto.getString(5)));
                movimientoItemProducto2.setMovimientoProducto_id(Integer.parseInt(resultSetMovimientoProducto.getString(6)));
                movimientoItemProducto2.setBodegaMovimiento_id(Integer.parseInt(resultSetMovimientoProducto.getString(7)));
                movimientoItemProducto2.setBodegaOrigen(resultSetMovimientoProducto.getString(8));
                movimientoItemProducto2.setBodegaDestino(resultSetMovimientoProducto.getString(9));
                movimientoItemProducto2.setSaldoAnterior(Integer.parseInt(resultSetMovimientoProducto.getString(10)));
                movimientoItemProducto2.setCantidadTrasladada(Integer.parseInt(resultSetMovimientoProducto.getString(11)));
                movimientoItemProducto2.setSaldoActual(Integer.parseInt(resultSetMovimientoProducto.getString(12))); 
                
                ArrayList<MovimientoItemProducto> listadoMovimientoItemProducto= new ArrayList();     
                listadoMovimientoItemProducto.add(movimientoItemProducto1);
                listadoMovimientoItemProducto.add(movimientoItemProducto2);                
                movimientoProducto.setMovimientoItemProducto(listadoMovimientoItemProducto); //Añadimos el listado de movimientoItemProducto a MovimientoProducto
                
                listadoMovimientoProducto.add(movimientoProducto);
            }       
         
        }catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null, "Error al tratar al consultar");
            sqlException.printStackTrace();
        } 
        control.cerrarConexionBaseDatos();
        return listadoMovimientoProducto;
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
    public boolean validarEstadoSaldoIngresoProducto(int saldoOriginalesBodegaExtranjera, int saldoOriginalesBodegaNacional, int idingresoProducto){
        Connection conexion= control.ConectarBaseDatos();
        int contador=0;
        Statement statement = null;
        try{
            statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT \n" +
                    "	[bodega_ingresoProducto].[bodega_id],\n" +
                    "	[bodega_ingresoProducto].[saldo]\n" +
                    "FROM [maquilas].[dbo].[ingresoproducto]\n" +
                    "		INNER JOIN [dbo].[bodega_ingresoProducto]\n" +
                    "			ON [ingresoproducto].[id]=[bodega_ingresoProducto].[ingresoProducto_id] AND [ingresoproducto].[id]='"+idingresoProducto+"';");
            while(resultSet.next()){ 
                if(resultSet.getInt(1)==1){
                    if(resultSet.getInt(2)==saldoOriginalesBodegaExtranjera){//validamos que la Bodega Extranjera sea igual a la original para Movificar Movimiento
                        contador++;
                    }
                };
                if(resultSet.getInt(1)==2){
                    if(resultSet.getInt(2)==saldoOriginalesBodegaNacional){//validamos que la Bodega Nacional sea igual a la original para Movificar Movimiento
                        contador++;
                    }
                };
            }
        }catch (SQLException sqlException){
            JOptionPane.showMessageDialog(null, "Error al Tratar de buscar");
            sqlException.printStackTrace();
        } 
        control.cerrarConexionBaseDatos();
        if(contador==2){
            return true;
        }else{
            return false;
        }
    }
    public boolean actualizarSaldosIngresoProducto(int saldoNuevoExtranjera, int saldoNuevoNacional, int idIngresoProducto){
        control.ConectarBaseDatos();
        boolean retorno=false;
        int contador=0;
        int result=0;
        try{
            PreparedStatement actualizarSaldoBodegaExtranjera= conexion.prepareStatement("UPDATE [maquilas].[dbo].[bodega_ingresoproducto] SET [saldo] = '"+saldoNuevoExtranjera+"' "+
                    "WHERE [bodega_ingresoproducto].[bodega_id] = 1 AND [bodega_ingresoproducto].[ingresoProducto_id] = '"+idIngresoProducto+"';");
            actualizarSaldoBodegaExtranjera.execute();
            contador++;
        }
        catch (SQLException sqlException ){   
            JOptionPane.showMessageDialog(null, "ERROR al querer insertar los datos.");
            sqlException.printStackTrace();
        }  
        try{
            PreparedStatement actualizarSaldoBodegaNacional= conexion.prepareStatement("UPDATE [maquilas].[dbo].[bodega_ingresoproducto] SET [saldo] = '"+saldoNuevoNacional+"' "+
                    "WHERE [bodega_ingresoproducto].[bodega_id] = 2 AND [bodega_ingresoproducto].[ingresoProducto_id] = '"+idIngresoProducto+"';");
            actualizarSaldoBodegaNacional.execute();
            contador++;
        }
        catch (SQLException sqlException ){   
            JOptionPane.showMessageDialog(null, "ERROR al querer insertar los datos.");
            sqlException.printStackTrace();
        } 
        control.cerrarConexionBaseDatos();
        if(contador==2){
            return true;
        }else{
            return false;
        }  
    }
    public boolean eliminarMovimiento (int idMovimiento) throws SQLException{
        boolean resultado=false;
        Connection conexion= control.ConectarBaseDatos();
        try{
            PreparedStatement Delete_itemMovimientoProducto= conexion.prepareStatement("DELETE FROM [dbo].[itemMovimientoProducto] WHERE [movimientoProducto_id]='"+idMovimiento+"';");
            Delete_itemMovimientoProducto.execute();
            PreparedStatement Delete_movimientoProducto= conexion.prepareStatement("DELETE FROM [dbo].[movimientoProducto] WHERE [id]='"+idMovimiento+"';");
            Delete_movimientoProducto.execute();
            resultado=true;
        }catch (SQLException sqlException ){   
            resultado= false;
            JOptionPane.showMessageDialog(null, "ERROR No se pudo eliminar Movimiento");
            sqlException.printStackTrace();
        }
        control.cerrarConexionBaseDatos();
        return resultado;  
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
    public int registrarMovimiento(int consecutivo,String fechaMovimiento, String CP, int nuevoSalgoBodegaExtranjera, int nuevoSaldoBodegaNacional, Usuario u, int saldoExtranjeraTraslado, int saldoNacionalTrasladado, int saldoBodegaExtranjeraActual, int saldoBodegaNacionalActual){
        int result=0;
        int consecutivoMovimiento=consecutivo;
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
                        PreparedStatement movimientoProducto= conexion.prepareStatement("INSERT INTO [maquilas].[dbo].[movimientoProducto] "
                                        + "([id],[fechaMovimiento], [nombreQuienElabora],[estado]) VALUES ('"+consecutivoMovimiento+"','"+fechaMovimiento+"','"+u.getNombre()+" "+u.getApellido()+"',1);");       
                        movimientoProducto.execute();                
                        result++; 
                        
                        int idMovimientoProducto=consecutivoMovimiento;
                        
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
                                                + " 'MovimientoEditado', 'Extranjera','Nacional', '"+u.getId()+"', '"+saldoExtranjeraTraslado+"', '"+fechaRegistroSistemas+"');");       
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
                                    PreparedStatement registrarAuditoria= conexion.prepareStatement("INSERT INTO [maquilas].[dbo].[auditoria] "
                                            + "([id],[fechaMovimiento], [cp],[idTipoMovimiento], [descripcionTipoMovimiento], [bodegaOrigen],[bodegaDestino], [usuario_id], [cantidad], "
                                            + "[fechaRegistroSistema]) VALUES ('"+consecutivoAuditoria+"','"+FechaActual+"',"
                                                    + " '"+CP+"', '"+idMovimientoProducto+"', "
                                                + " 'MovimientoEditado', 'Nacional','Extranjera', '"+u.getId()+"', '"+saldoNacionalTrasladado+"', '"+fechaRegistroSistemas+"');");       
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
    public String retornarDescripcionProducto(int idIngresoProducto){
        Connection conexion= control.ConectarBaseDatos();
        String descripcionProducto="";
        Statement statement = null;
        try{
            statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT [producto].[descripcion]\n" +
                                            "  FROM [maquilas].[dbo].[ingresoProducto]\n" +
                                            "	INNER JOIN [dbo].[producto] ON [ingresoProducto].[producto_id] = [producto].[id]\n" +
                                            "	WHERE [ingresoProducto].[id]='"+idIngresoProducto+"';");
            while(resultSet.next()){ 
                descripcionProducto=resultSet.getString(1);
            }
        }catch (SQLException sqlException){
            JOptionPane.showMessageDialog(null, "Error al Tratar de buscar");
            sqlException.printStackTrace();
        } 
        control.cerrarConexionBaseDatos();
        return descripcionProducto;
    }
}
