
package Controladores;

import Modelos.Consumo;
import Modelos.FacturaVenta;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ControlDB_ConsumoGeneral {
    private Connection conexion=null;
    private  ControlDB_DB control=null;    
    
    public ControlDB_ConsumoGeneral() {
        control = new ControlDB_DB();
        conexion= control.ConectarBaseDatos();       
    }     
    public ArrayList<Consumo> consultarConsumoGeneral(String valorConsulta) throws SQLException{
        ArrayList<Consumo> listadoConsumos = new ArrayList(); 
        control.ConectarBaseDatos();
        try{
            Statement statement  = conexion.createStatement();
            ResultSet resultSet;
            //resultSet = statement.executeQuery("select * from ingresoproducto "+script+" and estado=1;");
            resultSet = statement.executeQuery("SELECT TOP 1000 \n" +
                                                "       [consumo].[id]\n" +
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
                                                " FROM [maquilas].[dbo].[consumo]  "+valorConsulta+";");
                while(resultSet.next()){ 
                    Consumo consumo = new Consumo(); 
                    consumo.setId(Integer.parseInt(resultSet.getString(1)));
                    consumo.setFechaConsumo(resultSet.getString(2));
                    consumo.setBodegaConsumo_id(Integer.parseInt(resultSet.getString(3)));
                    consumo.setCliente_nit(resultSet.getString(4));
                    consumo.setCliente_sucursal(Integer.parseInt(resultSet.getString(5)));
                    consumo.setEmpresaLocal_nit(resultSet.getString(6));
                    consumo.setEmpresaLocal_sucursal(Integer.parseInt(resultSet.getString(7)));
                    consumo.setValorTotalEnPesos(new BigDecimal(resultSet.getString(8)));
                    consumo.setObservaciones(resultSet.getString(9));
                    consumo.setEstado(Integer.parseInt(resultSet.getString(10)));
                    consumo.setNombreQuienElabora(resultSet.getString(11));                  
                    listadoConsumos.add(consumo); 
            }         
        }catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null, "Error al tratar al consultar");
            sqlException.printStackTrace();
        } 
        control.cerrarConexionBaseDatos();
        return listadoConsumos;
    } 
    
}
