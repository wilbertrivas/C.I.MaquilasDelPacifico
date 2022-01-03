package GUI;


import Controladores.ControlDB_Compra;
import Controladores.ControlDB_Movimientos_Consultar;
import Modelos.Movimiento;
import Modelos.MovimientoItemProducto;
import Modelos.MovimientoProducto;
import Modelos.Proveedor;
import Modelos.Usuario;
import Reportes.Generar_Reportes;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Movimientos_Consultar extends javax.swing.JPanel {
    String valor="";
    Usuario user;
    String []tituloCP= {"CP","PRODUCTO","BODEGA","NOMBRE_PROV.","FECHA_COMPRA","FECHA_MAX._EXPORT.","SALDO","CANTIDAD A VENDER"};
    String [] registroCP;
    DefaultTableModel modeloCP;
    int facturaVentaNumero=0;
    String numeroCp="";
   
    
    public Movimientos_Consultar(Usuario u) {
        user= u;
        initComponents();
        //Formato de la tabla en la que se cargan los CP
        registroCP= new String[8]; 
        modeloCP = new DefaultTableModel(null, tituloCP);          
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Seleccionar_movimiento = new javax.swing.JPopupMenu();
        Seleccionar_Movimiento = new javax.swing.JMenuItem();
        alertaFechaMovimiento = new javax.swing.JLabel();
        codigoDocumento = new javax.swing.JTextField();
        ventanaInterna_Nombre1 = new javax.swing.JLabel();
        botonLimpiarBusqueda = new javax.swing.JButton();
        botonBuscarDocumento = new javax.swing.JButton();
        alertaBuscarMovimiento = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        ListadoBusquedasDocumentos = new javax.swing.JTable();

        Seleccionar_Movimiento.setText("Seleccionar_Movimiento");
        Seleccionar_Movimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Seleccionar_MovimientoActionPerformed(evt);
            }
        });
        Seleccionar_movimiento.add(Seleccionar_Movimiento);

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        alertaFechaMovimiento.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        alertaFechaMovimiento.setForeground(new java.awt.Color(255, 51, 51));
        add(alertaFechaMovimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 1090, 30));

        codigoDocumento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                codigoDocumentoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                codigoDocumentoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                codigoDocumentoKeyTyped(evt);
            }
        });
        add(codigoDocumento, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 250, 30));

        ventanaInterna_Nombre1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ventanaInterna_Nombre1.setForeground(new java.awt.Color(0, 153, 153));
        ventanaInterna_Nombre1.setText("Ingrese número de movimiento");
        add(ventanaInterna_Nombre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 350, -1));

        botonLimpiarBusqueda.setBackground(new java.awt.Color(255, 255, 255));
        botonLimpiarBusqueda.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        botonLimpiarBusqueda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/Interfaz_Icon_Borrar.PNG"))); // NOI18N
        botonLimpiarBusqueda.setText("LIMPIAR");
        botonLimpiarBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonLimpiarBusquedaActionPerformed(evt);
            }
        });
        add(botonLimpiarBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, 140, 40));

        botonBuscarDocumento.setBackground(new java.awt.Color(255, 255, 255));
        botonBuscarDocumento.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        botonBuscarDocumento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/Bodega_Actualizar_Bton_Buscar.PNG"))); // NOI18N
        botonBuscarDocumento.setText("BUSCAR");
        botonBuscarDocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarDocumentoActionPerformed(evt);
            }
        });
        add(botonBuscarDocumento, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 140, -1));

        alertaBuscarMovimiento.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        alertaBuscarMovimiento.setForeground(new java.awt.Color(255, 0, 51));
        add(alertaBuscarMovimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 770, 30));

        ListadoBusquedasDocumentos = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        ListadoBusquedasDocumentos.setBackground(new java.awt.Color(153, 204, 255));
        ListadoBusquedasDocumentos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        ListadoBusquedasDocumentos.setComponentPopupMenu(Seleccionar_movimiento);
        ListadoBusquedasDocumentos.setFocusable(false);
        ListadoBusquedasDocumentos.setGridColor(new java.awt.Color(0, 204, 204));
        ListadoBusquedasDocumentos.setSelectionBackground(new java.awt.Color(255, 102, 102));
        ListadoBusquedasDocumentos.getTableHeader().setReorderingAllowed(false);
        ListadoBusquedasDocumentos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ListadoBusquedasDocumentosMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ListadoBusquedasDocumentosMousePressed(evt);
            }
        });
        ListadoBusquedasDocumentos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ListadoBusquedasDocumentosKeyPressed(evt);
            }
        });
        jScrollPane5.setViewportView(ListadoBusquedasDocumentos);

        add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 1430, 550));
    }// </editor-fold>//GEN-END:initComponents

    private void codigoDocumentoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codigoDocumentoKeyPressed
       
    }//GEN-LAST:event_codigoDocumentoKeyPressed

    private void botonLimpiarBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonLimpiarBusquedaActionPerformed
        codigoDocumento.setText("");
        //Eliminamos la Busqueda Actual#######################################################
        DefaultTableModel md =(DefaultTableModel)ListadoBusquedasDocumentos.getModel();
        int CantEliminar= ListadoBusquedasDocumentos.getRowCount() -1;
        for(int i =CantEliminar; i>=0; i--){
            md.removeRow(i);
        }

        try {
            BuscarEnVentanaInternaDocumentos("0");
        } catch (SQLException ex) {
            Logger.getLogger(VentaFacturacionComputador_Editar_BodExtranjera.class.getName()).log(Level.SEVERE, null, ex);
        }
        alertaBuscarMovimiento.setText("");
    }//GEN-LAST:event_botonLimpiarBusquedaActionPerformed

    private void ListadoBusquedasDocumentosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ListadoBusquedasDocumentosMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_ListadoBusquedasDocumentosMouseClicked

    private void ListadoBusquedasDocumentosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ListadoBusquedasDocumentosMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_ListadoBusquedasDocumentosMousePressed

    private void ListadoBusquedasDocumentosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ListadoBusquedasDocumentosKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_ListadoBusquedasDocumentosKeyPressed

    private void botonBuscarDocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarDocumentoActionPerformed
        //Eliminamos la Busqueda Actual#######################################################
        DefaultTableModel md =(DefaultTableModel)ListadoBusquedasDocumentos.getModel();
        int CantEliminar= ListadoBusquedasDocumentos.getRowCount() -1;
        for(int i =CantEliminar; i>=0; i--){
            md.removeRow(i);
        }

        try {
            BuscarEnVentanaInternaDocumentos(codigoDocumento.getText()); //VentanaBuscarDocumento.show(false);
        } catch (SQLException ex) {
            Logger.getLogger(Movimientos_Consultar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_botonBuscarDocumentoActionPerformed

    private void Seleccionar_MovimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Seleccionar_MovimientoActionPerformed
         // TODO lo del clik derechoo
        DefaultTableModel modelo;
        int fila1;
        try{
            fila1=ListadoBusquedasDocumentos.getSelectedRow();
            if(fila1==-1){
                JOptionPane.showMessageDialog(null,"no se ha seleccionando ninguna fila");
            }
            else{
                modelo=(DefaultTableModel)ListadoBusquedasDocumentos.getModel();
                String idMovimiento = (String)modelo.getValueAt(fila1, 0);
                Generar_Reportes generarReportes = new Generar_Reportes();
                generarReportes.generar_Movimientos(Integer.parseInt(idMovimiento));
            }
        }catch(Exception e){
            
        }
        
    }//GEN-LAST:event_Seleccionar_MovimientoActionPerformed

    private void codigoDocumentoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codigoDocumentoKeyReleased
       
    }//GEN-LAST:event_codigoDocumentoKeyReleased

    private void codigoDocumentoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codigoDocumentoKeyTyped
       
    }//GEN-LAST:event_codigoDocumentoKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable ListadoBusquedasDocumentos;
    private javax.swing.JMenuItem Seleccionar_Movimiento;
    private javax.swing.JPopupMenu Seleccionar_movimiento;
    private javax.swing.JLabel alertaBuscarMovimiento;
    private javax.swing.JLabel alertaFechaMovimiento;
    private javax.swing.JButton botonBuscarDocumento;
    private javax.swing.JButton botonLimpiarBusqueda;
    private javax.swing.JTextField codigoDocumento;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel ventanaInterna_Nombre1;
    // End of variables declaration//GEN-END:variables

    public void BuscarEnVentanaInternaDocumentos(String valor) throws SQLException{
            DefaultTableModel modelo;
            String [] titulo= {"Id","Fecha_Mov","CP","Producto","bodegaOrigen","bodegaDestino","saldoAnterior","cantidadTrasladada","saldoActual","nombreQuienElabora","Estado"};
            String [] registro = new String[11]; 
            modelo = new DefaultTableModel(null, titulo);
            ControlDB_Movimientos_Consultar controlDB_Movimientos= new ControlDB_Movimientos_Consultar();
            ArrayList<MovimientoProducto> listadoMovimientoProducto =controlDB_Movimientos.consultarListadoMovimientoProductoCamarones(valor);
            for(int i =0; i< listadoMovimientoProducto.size(); i++){
                MovimientoProducto movimientoProducto= new MovimientoProducto();
                movimientoProducto=listadoMovimientoProducto.get(i);
                
                ArrayList <MovimientoItemProducto> ListadoMovimientoItemProducto = new ArrayList();
                ListadoMovimientoItemProducto = movimientoProducto.getMovimientoItemProducto();
                
                MovimientoItemProducto movimientoItemProducto1 = new MovimientoItemProducto();
                movimientoItemProducto1 = ListadoMovimientoItemProducto.get(0);
                
                MovimientoItemProducto movimientoItemProducto2 = new MovimientoItemProducto();
                movimientoItemProducto2 = ListadoMovimientoItemProducto.get(1);
                
                registro[0]=""+movimientoProducto.getId();
                registro[1]=""+movimientoProducto.getFechaMovimiento();
                registro[2]=""+controlDB_Movimientos.retornarCP(movimientoItemProducto1.getIngresoProducto_id());
                registro[3]=""+controlDB_Movimientos.retornarDescripcionProducto(movimientoItemProducto1.getIngresoProducto_id());
                registro[4]=""+movimientoItemProducto1.getBodegaOrigen();
                registro[5]=""+movimientoItemProducto1.getBodegaDestino();
                registro[6]=""+movimientoItemProducto1.getSaldoAnterior();
                registro[7]=""+movimientoItemProducto1.getCantidadTrasladada();
                registro[8]=""+movimientoItemProducto1.getSaldoActual();
                registro[9]=""+movimientoProducto.getNombreQuienElabora();
                registro[10]=""+validarEstado(movimientoProducto.getEstado());
                
                modelo.addRow(registro);
                registro[0]=""+movimientoProducto.getId();
                registro[1]=""+movimientoProducto.getFechaMovimiento();
                registro[2]=""+controlDB_Movimientos.retornarCP(movimientoItemProducto1.getIngresoProducto_id());
                registro[3]=""+controlDB_Movimientos.retornarDescripcionProducto(movimientoItemProducto1.getIngresoProducto_id());
                registro[4]=""+movimientoItemProducto2.getBodegaOrigen();
                registro[5]=""+movimientoItemProducto2.getBodegaDestino();
                registro[6]=""+movimientoItemProducto2.getSaldoAnterior();
                registro[7]=""+movimientoItemProducto2.getCantidadTrasladada();
                registro[8]=""+movimientoItemProducto2.getSaldoActual();
                registro[9]=""+movimientoProducto.getNombreQuienElabora();
                registro[10]=""+validarEstado(movimientoProducto.getEstado());
                modelo.addRow(registro);
                ListadoBusquedasDocumentos.setModel(modelo);  
            }
    }  
    public String validarEstado(int valor){
        String retorno="";
        switch(valor){
            case 1:{
                retorno= "Activo";
                break;
            }
            case 2:{
                retorno= "Anulada";
                break;
            }
            default:{
                retorno= "";
                break;
            }
        }
        return retorno;
    }
}
