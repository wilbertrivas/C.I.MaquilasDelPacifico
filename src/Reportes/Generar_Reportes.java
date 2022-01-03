package Reportes;
import Controladores.ControlDB_DB;
import java.awt.Frame;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class Generar_Reportes {
    
    public void generarReporteBodegaActivas(){
        try{
            JasperReport reporte = (JasperReport) JRLoader.loadObject("src//Reportes//Bodega//Reporte_Bodega_ListadoBodegaActivas.jasper");
            ControlDB_DB control = new ControlDB_DB();
            JasperPrint j = JasperFillManager.fillReport(reporte, null, control.ConectarBaseDatos());
            JasperViewer jv = new  JasperViewer(j,false);   
            jv.setTitle("Reporte Bodegas Activas");
            jv.setExtendedState(Frame.MAXIMIZED_BOTH);
            jv.setVisible(true);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al Mostrar Reporte"+e);
        }
    }
    public void generarReporteClientes(){
        try{
            JasperReport reporte = (JasperReport) JRLoader.loadObject("src//Reportes//Clientes//Reporte_Clientes_ListadoClientesActivos.jasper");
            ControlDB_DB control = new ControlDB_DB();
            JasperPrint j = JasperFillManager.fillReport(reporte, null, control.ConectarBaseDatos());
            JasperViewer jv = new  JasperViewer(j,false);  
            jv.setTitle("Reporte Clientes");
            jv.setExtendedState(Frame.MAXIMIZED_BOTH);
            jv.setVisible(true);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al Mostrar Reporte"+e);
        }
    }
    public void generarReporteEmpresaLocal(){
        try{
            JasperReport reporte = (JasperReport) JRLoader.loadObject("src//Reportes//EmpresaLocal//Reporte_EmpresaLocal_ListadoEmpresaLocalActivos.jasper");
            ControlDB_DB control = new ControlDB_DB();
            JasperPrint j = JasperFillManager.fillReport(reporte, null, control.ConectarBaseDatos());
            JasperViewer jv = new  JasperViewer(j,false);  
            jv.setTitle("Reporte Empresas Locales");
            jv.setExtendedState(Frame.MAXIMIZED_BOTH);
            jv.setVisible(true);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al Mostrar Reporte"+e);
        }
    }
    public void generarReporteProveedoresActivos(){
        try{
            JasperReport reporte = (JasperReport) JRLoader.loadObject("src//Reportes//Proveedor//Reporte_Proveedor_ListadoProveedoresActivos.jasper");
            ControlDB_DB control = new ControlDB_DB();
            JasperPrint j = JasperFillManager.fillReport(reporte, null, control.ConectarBaseDatos());
            JasperViewer jv = new  JasperViewer(j,false);  
            jv.setTitle("Reporte Proveedores");
            jv.setExtendedState(Frame.MAXIMIZED_BOTH);
            jv.setVisible(true);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al Mostrar Reporte"+e);
        }
    }
    public void generarReporteProductosActivos(){
        try{
            JasperReport reporte = (JasperReport) JRLoader.loadObject("src//Reportes//Producto//Reporte_Producto_ListadoProductoActivas.jasper");
            ControlDB_DB control = new ControlDB_DB();
            JasperPrint j = JasperFillManager.fillReport(reporte, null, control.ConectarBaseDatos());
            JasperViewer jv = new  JasperViewer(j,false);  
            jv.setTitle("Reporte Productos");
            jv.setExtendedState(Frame.MAXIMIZED_BOTH);
            jv.setVisible(true);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al Mostrar Reporte"+e);
        }
    }
    public void generarReporteUnidadesActivas(){
        try{
            JasperReport reporte = (JasperReport) JRLoader.loadObject("src//Reportes//Unidad//Reporte_Unidad_ListadoUnidadActivas.jasper");
            ControlDB_DB control = new ControlDB_DB();
            JasperPrint j = JasperFillManager.fillReport(reporte, null, control.ConectarBaseDatos());
            JasperViewer jv = new  JasperViewer(j,false);  
            jv.setTitle("Reporte Unidades");
            jv.setExtendedState(Frame.MAXIMIZED_BOTH);
            jv.setVisible(true);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al Mostrar Reporte"+e);
        }
    }
    public void generarReporteUsuarioActivos(){
        try{
            JasperReport reporte = (JasperReport) JRLoader.loadObject("src//Reportes//Usuario//Reporte_Usuarios_ListadoUsuariosActivos.jasper");
            ControlDB_DB control = new ControlDB_DB();
            JasperPrint j = JasperFillManager.fillReport(reporte, null, control.ConectarBaseDatos());
            JasperViewer jv = new  JasperViewer(j,false);  
            jv.setTitle("Reporte Usuarios");
            jv.setExtendedState(Frame.MAXIMIZED_BOTH);
            jv.setVisible(true);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al Mostrar Reporte"+e);
        }
    }
    public void generarReporteUnicoUsuarioPorId(int id) {
        
        try {
            ControlDB_DB control = new ControlDB_DB();
            String rutaInforme="src//Reportes//Usuario//Reporte_Usuarios_BuscarPorId.jasper";
            Map parametros = new HashMap();
            parametros.put("idUsuario", id);
            JasperPrint informe = JasperFillManager.fillReport(rutaInforme, parametros,control.ConectarBaseDatos());
            JasperViewer ventanaVisor = new JasperViewer(informe, false);
            ventanaVisor.setTitle("USUARIO");
            ventanaVisor.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(Generar_Reportes.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al Generar Reporte");
        }
    }
    public void generar_FacturaCompra(int id) {
        
        try {
            ControlDB_DB control = new ControlDB_DB();
            String rutaInforme="src//Reportes//Compras//Reporte_Compra_Registrar.jasper";
            Map parametros = new HashMap();
            parametros.put("id_ingresoProducto", id);
            JasperPrint informe = JasperFillManager.fillReport(rutaInforme, parametros,control.ConectarBaseDatos());
            JasperViewer ventanaVisor = new JasperViewer(informe, false);
            ventanaVisor.setTitle("FACTURA DE COMPRA");
            ventanaVisor.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(Generar_Reportes.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al Generar Reporte");
        }
    }   
    public void generar_InformeAnual_Por_RangoFecha_VentasTodas(String fechaVentaID, String fechaVentaFD) { 
        try {
            ControlDB_DB control = new ControlDB_DB();
            String rutaInforme="src//Reportes//InformeAnual//InformeAnualFechas.jasper";
            Map parametros = new HashMap<String, String>();
            parametros.put("fechaVentaI", fechaVentaID);
            parametros.put("fechaVentaF", fechaVentaFD);            
            JasperPrint informe = JasperFillManager.fillReport(rutaInforme, parametros,control.ConectarBaseDatos());
            JasperViewer ventanaVisor = new JasperViewer(informe, false);
            ventanaVisor.setTitle("INFORME ANUAL");
            ventanaVisor.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(Generar_Reportes.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al Generar Reporte");
        }
    }   
    public void generar_InformeAnual_Por_RangoFecha_CompraTodas(String fechaCompraID, String fechaCompraFD) { 
        try {
            ControlDB_DB control = new ControlDB_DB();
            String rutaInforme="src//Reportes//InformeAnualCompras//InformeAnualFechas.jasper";
            Map parametros = new HashMap<String, String>();
            parametros.put("fechaVentaI", fechaCompraID);
            parametros.put("fechaVentaF", fechaCompraFD);            
            JasperPrint informe = JasperFillManager.fillReport(rutaInforme, parametros,control.ConectarBaseDatos());
            JasperViewer ventanaVisor = new JasperViewer(informe, false);
            ventanaVisor.setTitle("INFORME ANUAL COMPRAS");
            ventanaVisor.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(Generar_Reportes.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al Generar Reporte");
        }
    }   
    public void generar_ConsumoCamarones(int idConsumo) {       
        try {
            ControlDB_DB control = new ControlDB_DB();
            String rutaInforme="src//Reportes//ConsumoCamarones//Reporte_ConsumoCamarones.jasper";
            Map parametros = new HashMap();
            parametros.put("idConsumo", idConsumo);
            JasperPrint informe = JasperFillManager.fillReport(rutaInforme, parametros,control.ConectarBaseDatos());
            JasperViewer ventanaVisor = new JasperViewer(informe, false);
            ventanaVisor.setTitle("CONSUMO. NACIONAL");
            ventanaVisor.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(Generar_Reportes.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al Generar Reporte");
        }
    }
    public void generar_ConsumoAnulado(int idConsumo) {       
        try {
            ControlDB_DB control = new ControlDB_DB();
            String rutaInforme="src//Reportes//ConsumoCamarones//Reporte_ConsumoAnulado.jasper";
            Map parametros = new HashMap();
            parametros.put("idConsumo", idConsumo);
            JasperPrint informe = JasperFillManager.fillReport(rutaInforme, parametros,control.ConectarBaseDatos());
            JasperViewer ventanaVisor = new JasperViewer(informe, false);
            ventanaVisor.setTitle("CONSUMO. ANULADOS");
            ventanaVisor.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(Generar_Reportes.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al Generar Reporte");
        }
    }
    public void generar_Movimientos(int idMovimiento) {       
        try {
            ControlDB_DB control = new ControlDB_DB();
            String rutaInforme="src//Reportes//Movimientos//Reporte_Movimientos.jasper";
            Map parametros = new HashMap();
            parametros.put("idMovimiento", idMovimiento);
            JasperPrint informe = JasperFillManager.fillReport(rutaInforme, parametros,control.ConectarBaseDatos());
            JasperViewer ventanaVisor = new JasperViewer(informe, false);
            ventanaVisor.setTitle("Movimientos");
            ventanaVisor.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(Generar_Reportes.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al Generar Reporte");
        }
    }
    public void generar_MovimientosAnulados(int idMovimiento) {       
        try {
            ControlDB_DB control = new ControlDB_DB();
            String rutaInforme="src//Reportes//Movimientos//Reporte_Movimientos_Anulados.jasper";
            Map parametros = new HashMap();
            parametros.put("idMovimiento", idMovimiento);
            JasperPrint informe = JasperFillManager.fillReport(rutaInforme, parametros,control.ConectarBaseDatos());
            JasperViewer ventanaVisor = new JasperViewer(informe, false);
            ventanaVisor.setTitle("Movimientos");
            ventanaVisor.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(Generar_Reportes.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al Generar Reporte");
        }
    }
    public void generar_FacturaCompraAnulada(int id) {
        
        try {
            ControlDB_DB control = new ControlDB_DB();
            String rutaInforme="src//Reportes//Compras//Reporte_Compra_Anulada.jasper";
            Map parametros = new HashMap();
            parametros.put("id_ingresoProducto", id);
            JasperPrint informe = JasperFillManager.fillReport(rutaInforme, parametros,control.ConectarBaseDatos());
            JasperViewer ventanaVisor = new JasperViewer(informe, false);
            ventanaVisor.setTitle("FACTURA DE COMPRA");
            ventanaVisor.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(Generar_Reportes.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al Generar Reporte");
        }
    }
    
    
    //Ventas a Computador
    public void generar_FacturaVentaComputadorExtranjera(int idVentaExtranjera) {       
        try {
            ControlDB_DB control = new ControlDB_DB();
            String rutaInforme="src//Reportes//VentasComputador//Reporte_Ventas_RegistrarExtranjeraDolares.jasper";
            Map parametros = new HashMap();
            parametros.put("idFacturaVenta", idVentaExtranjera);
            JasperPrint informe = JasperFillManager.fillReport(rutaInforme, parametros,control.ConectarBaseDatos());
            JasperViewer ventanaVisor = new JasperViewer(informe, false);
            ventanaVisor.setTitle("FACTURA DE VENTA BOD. EXTRANJERA");
            ventanaVisor.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(Generar_Reportes.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al Generar Reporte");
        }
    }
    public void generar_FacturaVentaComputadorNacional(int idVentaExtranjera) {       
        try {
            ControlDB_DB control = new ControlDB_DB();
            String rutaInforme="src//Reportes//VentasComputador//Reporte_Ventas_RegistrarNacional.jasper";
            Map parametros = new HashMap();
            parametros.put("idFacturaVenta", idVentaExtranjera);
            JasperPrint informe = JasperFillManager.fillReport(rutaInforme, parametros,control.ConectarBaseDatos());
            JasperViewer ventanaVisor = new JasperViewer(informe, false);
            ventanaVisor.setTitle("FACTURA DE VENTA BOD. NACIONAL");
            ventanaVisor.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(Generar_Reportes.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al Generar Reporte");
        }
    }
    public void generar_FacturaVentaComputadorExtranjeraAnulada(int idVentaExtranjera) {       
        try {
            ControlDB_DB control = new ControlDB_DB();
            String rutaInforme="src//Reportes//VentasComputador//Reporte_Ventas_RegistrarExtranjeraAnuladaDolares.jasper";
            Map parametros = new HashMap();
            parametros.put("idFacturaVenta", idVentaExtranjera);
            JasperPrint informe = JasperFillManager.fillReport(rutaInforme, parametros,control.ConectarBaseDatos());
            JasperViewer ventanaVisor = new JasperViewer(informe, false);
            ventanaVisor.setTitle("FACTURA DE VENTA BOD. EXTRANJERA ANULADA");
            ventanaVisor.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(Generar_Reportes.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al Generar Reporte");
        }
    }
    public void generar_FacturaVentaComputadorNacionalAnulada(int idVentaExtranjera) {       
        try {
            ControlDB_DB control = new ControlDB_DB();
            String rutaInforme="src//Reportes//VentasComputador//Reporte_Ventas_RegistrarNacionalAnulada.jasper";
            Map parametros = new HashMap();
            parametros.put("idFacturaVenta", idVentaExtranjera);
            JasperPrint informe = JasperFillManager.fillReport(rutaInforme, parametros,control.ConectarBaseDatos());
            JasperViewer ventanaVisor = new JasperViewer(informe, false);
            ventanaVisor.setTitle("FACTURA DE VENTA BOD. NACIONAL ANULADA");
            ventanaVisor.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(Generar_Reportes.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al Generar Reporte");
        }
    }
    public void generar_FacturaVentaComputadorExtranjera_Pesos(int idVentaExtranjera) {       
        try {
            ControlDB_DB control = new ControlDB_DB();
            String rutaInforme="src//Reportes//VentasComputador//Reporte_Ventas_RegistrarExtranjera_Pesos.jasper";
            Map parametros = new HashMap();
            parametros.put("idFacturaVenta", idVentaExtranjera);
            JasperPrint informe = JasperFillManager.fillReport(rutaInforme, parametros,control.ConectarBaseDatos());
            JasperViewer ventanaVisor = new JasperViewer(informe, false);
            ventanaVisor.setTitle("FACTURA DE VENTA BOD. EXTRANJERA");
            ventanaVisor.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(Generar_Reportes.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al Generar Reporte");
        }
    }
    public void generar_FacturaVentaComputadorExtranjeraAnulada_Pesos(int idVentaExtranjera) {       
        try {
            ControlDB_DB control = new ControlDB_DB();
            String rutaInforme="src//Reportes//VentasComputador//Reporte_Ventas_RegistrarExtranjeraAnulada_Pesos.jasper";
            Map parametros = new HashMap();
            parametros.put("idFacturaVenta", idVentaExtranjera);
            JasperPrint informe = JasperFillManager.fillReport(rutaInforme, parametros,control.ConectarBaseDatos());
            JasperViewer ventanaVisor = new JasperViewer(informe, false);
            ventanaVisor.setTitle("FACTURA DE VENTA BOD. EXTRANJERA ANULADA");
            ventanaVisor.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(Generar_Reportes.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al Generar Reporte");
        }
    }
   
    //Ventas a Electronica
    public void generar_FacturaVentaElectronicaExtranjera(int idVentaExtranjera) {       
        try {
            ControlDB_DB control = new ControlDB_DB();
            String rutaInforme="src//Reportes//VentasElectronica//Reporte_Ventas_RegistrarExtranjeraDolares.jasper";
            Map parametros = new HashMap();
            parametros.put("idFacturaVenta", idVentaExtranjera);
            JasperPrint informe = JasperFillManager.fillReport(rutaInforme, parametros,control.ConectarBaseDatos());
            JasperViewer ventanaVisor = new JasperViewer(informe, false);
            ventanaVisor.setTitle("FACTURA DE VENTA BOD. EXTRANJERA");
            ventanaVisor.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(Generar_Reportes.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al Generar Reporte");
        }
    }
    public void generar_FacturaVentaElectronicaNacional(int idVentaExtranjera) {       
        try {
            ControlDB_DB control = new ControlDB_DB();
            String rutaInforme="src//Reportes//VentasElectronica//Reporte_Ventas_RegistrarNacional.jasper";
            Map parametros = new HashMap();
            parametros.put("idFacturaVenta", idVentaExtranjera);
            JasperPrint informe = JasperFillManager.fillReport(rutaInforme, parametros,control.ConectarBaseDatos());
            JasperViewer ventanaVisor = new JasperViewer(informe, false);
            ventanaVisor.setTitle("FACTURA DE VENTA BOD. NACIONAL");
            ventanaVisor.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(Generar_Reportes.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al Generar Reporte");
        }
    }
    public void generar_FacturaVentaElectronicaExtranjeraAnulada(int idVentaExtranjera) {       
        try {
            ControlDB_DB control = new ControlDB_DB();
            String rutaInforme="src//Reportes//VentasElectronica//Reporte_Ventas_RegistrarExtranjeraAnuladaDolares.jasper";
            Map parametros = new HashMap();
            parametros.put("idFacturaVenta", idVentaExtranjera);
            JasperPrint informe = JasperFillManager.fillReport(rutaInforme, parametros,control.ConectarBaseDatos());
            JasperViewer ventanaVisor = new JasperViewer(informe, false);
            ventanaVisor.setTitle("FACTURA DE VENTA BOD. EXTRANJERA ANULADA");
            ventanaVisor.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(Generar_Reportes.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al Generar Reporte");
        }
    }
    public void generar_FacturaVentaElectronicaNacionalAnulada(int idVentaExtranjera) {       
        try {
            ControlDB_DB control = new ControlDB_DB();
            String rutaInforme="src//Reportes//VentasElectronica//Reporte_Ventas_RegistrarNacionalAnulada.jasper";
            Map parametros = new HashMap();
            parametros.put("idFacturaVenta", idVentaExtranjera);
            JasperPrint informe = JasperFillManager.fillReport(rutaInforme, parametros,control.ConectarBaseDatos());
            JasperViewer ventanaVisor = new JasperViewer(informe, false);
            ventanaVisor.setTitle("FACTURA DE VENTA BOD. NACIONAL ANULADA");
            ventanaVisor.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(Generar_Reportes.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al Generar Reporte");
        }
    }
    public void generar_FacturaVentaElectronicaExtranjera_Pesos(int idVentaExtranjera) {       
        try {
            ControlDB_DB control = new ControlDB_DB();
            String rutaInforme="src//Reportes//VentasElectronica//Reporte_Ventas_RegistrarExtranjera_Pesos.jasper";
            Map parametros = new HashMap();
            parametros.put("idFacturaVenta", idVentaExtranjera);
            JasperPrint informe = JasperFillManager.fillReport(rutaInforme, parametros,control.ConectarBaseDatos());
            JasperViewer ventanaVisor = new JasperViewer(informe, false);
            ventanaVisor.setTitle("FACTURA DE VENTA BOD. EXTRANJERA");
            ventanaVisor.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(Generar_Reportes.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al Generar Reporte");
        }
    }
    public void generar_FacturaVentaElectronicaExtranjeraAnulada_Pesos(int idVentaExtranjera) {       
        try {
            ControlDB_DB control = new ControlDB_DB();
            String rutaInforme="src//Reportes//VentasElectronica//Reporte_Ventas_RegistrarExtranjeraAnulada_Pesos.jasper";
            Map parametros = new HashMap();
            parametros.put("idFacturaVenta", idVentaExtranjera);
            JasperPrint informe = JasperFillManager.fillReport(rutaInforme, parametros,control.ConectarBaseDatos());
            JasperViewer ventanaVisor = new JasperViewer(informe, false);
            ventanaVisor.setTitle("FACTURA DE VENTA BOD. EXTRANJERA ANULADA");
            ventanaVisor.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(Generar_Reportes.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al Generar Reporte");
        }
    }
    
    
    //Ventas a Papel
    public void generar_FacturaVentaPapelExtranjera(int idVentaExtranjera) {       
        try {
            ControlDB_DB control = new ControlDB_DB();
            String rutaInforme="src//Reportes//VentasPapel//Reporte_Ventas_RegistrarExtranjeraDolares.jasper";
            Map parametros = new HashMap();
            parametros.put("idFacturaVenta", idVentaExtranjera);
            JasperPrint informe = JasperFillManager.fillReport(rutaInforme, parametros,control.ConectarBaseDatos());
            JasperViewer ventanaVisor = new JasperViewer(informe, false);
            ventanaVisor.setTitle("FACTURA DE VENTA BOD. EXTRANJERA");
            ventanaVisor.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(Generar_Reportes.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al Generar Reporte");
        }
    }
    public void generar_FacturaVentaPapelNacional(int idVentaExtranjera) {       
        try {
            ControlDB_DB control = new ControlDB_DB();
            String rutaInforme="src//Reportes//VentasPapel//Reporte_Ventas_RegistrarNacional.jasper";
            Map parametros = new HashMap();
            parametros.put("idFacturaVenta", idVentaExtranjera);
            JasperPrint informe = JasperFillManager.fillReport(rutaInforme, parametros,control.ConectarBaseDatos());
            JasperViewer ventanaVisor = new JasperViewer(informe, false);
            ventanaVisor.setTitle("FACTURA DE VENTA BOD. NACIONAL");
            ventanaVisor.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(Generar_Reportes.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al Generar Reporte");
        }
    }
    public void generar_FacturaVentaPapelExtranjeraAnulada(int idVentaExtranjera) {       
        try {
            ControlDB_DB control = new ControlDB_DB();
            String rutaInforme="src//Reportes//VentasPapel//Reporte_Ventas_RegistrarExtranjeraAnuladaDolares.jasper";
            Map parametros = new HashMap();
            parametros.put("idFacturaVenta", idVentaExtranjera);
            JasperPrint informe = JasperFillManager.fillReport(rutaInforme, parametros,control.ConectarBaseDatos());
            JasperViewer ventanaVisor = new JasperViewer(informe, false);
            ventanaVisor.setTitle("FACTURA DE VENTA BOD. EXTRANJERA ANULADA");
            ventanaVisor.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(Generar_Reportes.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al Generar Reporte");
        }
    }
    public void generar_FacturaVentaPapelNacionalAnulada(int idVentaExtranjera) {       
        try {
            ControlDB_DB control = new ControlDB_DB();
            String rutaInforme="src//Reportes//VentasPapel//Reporte_Ventas_RegistrarNacionalAnulada.jasper";
            Map parametros = new HashMap();
            parametros.put("idFacturaVenta", idVentaExtranjera);
            JasperPrint informe = JasperFillManager.fillReport(rutaInforme, parametros,control.ConectarBaseDatos());
            JasperViewer ventanaVisor = new JasperViewer(informe, false);
            ventanaVisor.setTitle("FACTURA DE VENTA BOD. NACIONAL ANULADA");
            ventanaVisor.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(Generar_Reportes.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al Generar Reporte");
        }
    }
    public void generar_FacturaVentaPapelExtranjera_Pesos(int idVentaExtranjera) {       
        try {
            ControlDB_DB control = new ControlDB_DB();
            String rutaInforme="src//Reportes//VentasPapel//Reporte_Ventas_RegistrarExtranjera_Pesos.jasper";
            Map parametros = new HashMap();
            parametros.put("idFacturaVenta", idVentaExtranjera);
            JasperPrint informe = JasperFillManager.fillReport(rutaInforme, parametros,control.ConectarBaseDatos());
            JasperViewer ventanaVisor = new JasperViewer(informe, false);
            ventanaVisor.setTitle("FACTURA DE VENTA BOD. EXTRANJERA");
            ventanaVisor.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(Generar_Reportes.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al Generar Reporte");
        }
    }
    public void generar_FacturaVentaPapelExtranjeraAnulada_Pesos(int idVentaExtranjera) {       
        try {
            ControlDB_DB control = new ControlDB_DB();
            String rutaInforme="src//Reportes//VentasPapel//Reporte_Ventas_RegistrarExtranjeraAnulada_Pesos.jasper";
            Map parametros = new HashMap();
            parametros.put("idFacturaVenta", idVentaExtranjera);
            JasperPrint informe = JasperFillManager.fillReport(rutaInforme, parametros,control.ConectarBaseDatos());
            JasperViewer ventanaVisor = new JasperViewer(informe, false);
            ventanaVisor.setTitle("FACTURA DE VENTA BOD. EXTRANJERA ANULADA");
            ventanaVisor.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(Generar_Reportes.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al Generar Reporte");
        }
    }
}
