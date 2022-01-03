package Controladores;
import Modelos.FacturaVenta;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ControlDB_VentaFacturacionPapel_ParametrosGenerales {
    private Connection conexion=null;
    private  ControlDB_DB control=null;    
    
    public ControlDB_VentaFacturacionPapel_ParametrosGenerales() {
        control = new ControlDB_DB();
        conexion= control.ConectarBaseDatos();       
    }     
    public ArrayList<FacturaVenta> consultarVentasGeneral(String valorConsulta) throws SQLException{
        ArrayList<FacturaVenta> listadoFacturaVentasElectronica = new ArrayList(); 
        control.ConectarBaseDatos();
        try{
            Statement statement  = conexion.createStatement();
            ResultSet resultSet;
            //resultSet = statement.executeQuery("select * from ingresoproducto "+script+" and estado=1;");
            resultSet = statement.executeQuery("SELECT TOP 1000 [facturaVentaPapel].[id]\n" +
                        "      ,[facturaVentaPapel].[dex]\n" +
                        "      ,[facturaVentaPapel].[fechaFactura]\n" +
                        "      ,[facturaVentaPapel].[bodegaFacturaVenta_id]\n" +
                        "      ,[facturaVentaPapel].[cliente_nit]\n" +
                        "      ,[facturaVentaPapel].[cliente_sucursal]\n" +
                        "      ,[facturaVentaPapel].[empresaLocal_nit]\n" +
                        "      ,[facturaVentaPapel].[empresaLocal_sucursal]\n" +
                        "      ,[facturaVentaPapel].[trm]\n" +
                        "      ,[facturaVentaPapel].[valorTotalDolarIngresados]\n" +
                        "      ,[facturaVentaPapel].[valorTotalDolarCalculados]\n" +
                        "      ,[facturaVentaPapel].[valorTotalPesosCalculados]\n" +
                        "      ,[facturaVentaPapel].[observaciones]\n" +
                        "      ,[facturaVentaPapel].[estado]\n" +
                        "      ,[facturaVentaPapel].[nombreQuienElabora]\n" +
                        "  FROM [maquilas].[dbo].[facturaVentaPapel] \n"+
                        "   INNER JOIN [dbo].[cliente]  \n" +
                        "           ON 	[cliente].[nit] = [facturaVentaPapel].[cliente_nit]\n" +
                        "  AND [cliente].[sucursal] = [facturaVentaPapel].[cliente_sucursal]  "+valorConsulta+";");
            while(resultSet.next()){ 
                FacturaVenta faturaVenta = new FacturaVenta(); 
                faturaVenta.setId(Integer.parseInt(resultSet.getString(1)));
                faturaVenta.setDex(resultSet.getString(2));
                faturaVenta.setFechaFactura(resultSet.getString(3));
                faturaVenta.setBodegaFacturaVenta_id(Integer.parseInt(resultSet.getString(4)));
                faturaVenta.setCliente_nit(resultSet.getString(5));
                faturaVenta.setCliente_sucursal(Integer.parseInt(resultSet.getString(6)));
                faturaVenta.setEmpresaLocal_nit(resultSet.getString(7));
                faturaVenta.setEmpresaLocal_sucursal(Integer.parseInt(resultSet.getString(8)));
                faturaVenta.setTrm(Double.parseDouble(resultSet.getString(9)));
                faturaVenta.setValorTotalEnDolarIngresados(new BigDecimal(resultSet.getString(10)));
                faturaVenta.setValorTotalEnDolarCalculados(new BigDecimal(resultSet.getString(11)));
                faturaVenta.setValorTotalEnPesosCalculados(new BigDecimal(resultSet.getString(12)));
                faturaVenta.setObservaciones(resultSet.getString(13));
                faturaVenta.setEstado(Integer.parseInt(resultSet.getString(14)));
                faturaVenta.setNombreQuienElabora(resultSet.getString(15));
                listadoFacturaVentasElectronica.add(faturaVenta); 
            }         
        }catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null, "Error al tratar al consultar");
            sqlException.printStackTrace();
        } 
        control.cerrarConexionBaseDatos();
        return listadoFacturaVentasElectronica;
    } 
    
}
