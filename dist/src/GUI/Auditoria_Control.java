package GUI;

import Controladores.ControlDB_Auditoria;
import Controladores.ControlDB_EmpresaLocal;
import Modelos.Auditoria;
import Reportes.Generar_Reportes;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Auditoria_Control extends javax.swing.JPanel {
    Controladores.ControlDB_EmpresaLocal controladorEmpresaLocal = new ControlDB_EmpresaLocal();
    DefaultTableModel modelo;
    String datos; 
    String [] titulo= {"Id","Fecha_Movimiento", "Cp", "idTipoMovimiento", "DescripcionTipoMovimiento", "BodegaOrigen", "BodegaDestino", "Usuario", "Cantidad", "FechaRegistro"};
    String [] registro;
    String accion="";
    public Auditoria_Control(){
        initComponents();  
       
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        codigoB = new javax.swing.JTextField();
        buscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table1 = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        limpiar = new javax.swing.JButton();
        CargarFactura = new javax.swing.JLabel();
        CargarUsuario = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 153, 153));
        jLabel7.setText("AUDITORIA:   (CONTROL DE MOVIMIENTOS EN EL SISTEMA)");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, 610, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("BUSQUEDA POR CP:");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 170, 30));

        codigoB.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                codigoBKeyPressed(evt);
            }
        });
        add(codigoB, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, 350, 30));

        buscar.setBackground(new java.awt.Color(255, 255, 255));
        buscar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/Bodega_Actualizar_Bton_Buscar.PNG"))); // NOI18N
        buscar.setText("BUSCAR");
        buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarActionPerformed(evt);
            }
        });
        add(buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 30, 140, -1));

        Table1 = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        Table1.setBackground(new java.awt.Color(153, 204, 255));
        Table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        Table1.setDoubleBuffered(true);
        Table1.setFocusable(false);
        Table1.setGridColor(new java.awt.Color(0, 204, 204));
        Table1.setSelectionBackground(new java.awt.Color(255, 102, 102));
        Table1.getTableHeader().setReorderingAllowed(false);
        Table1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Table1KeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(Table1);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 1470, 520));
        add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 1270, 10));

        limpiar.setBackground(new java.awt.Color(255, 255, 255));
        limpiar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        limpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/Interfaz_Icon_Borrar.PNG"))); // NOI18N
        limpiar.setText("LIMPIAR");
        limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarActionPerformed(evt);
            }
        });
        add(limpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 30, 140, 40));

        CargarFactura.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        CargarFactura.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CargarFactura.setText("CARGAR FACTURA");
        CargarFactura.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        CargarFactura.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CargarFacturaMouseClicked(evt);
            }
        });
        add(CargarFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 130, 40));

        CargarUsuario.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        CargarUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CargarUsuario.setText("CARGAR USUARIO");
        CargarUsuario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        CargarUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CargarUsuarioMouseClicked(evt);
            }
        });
        add(CargarUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, 130, 40));
    }// </editor-fold>//GEN-END:initComponents

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed
        try {
            String valor=codigoB.getText();
            Table1.show();
            tabla(valor);
        } catch (SQLException ex) {
            Logger.getLogger(Auditoria_Control.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_buscarActionPerformed

    private void Table1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Table1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_Table1KeyPressed

    private void limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarActionPerformed
        codigoB.setText("");
    }//GEN-LAST:event_limpiarActionPerformed

    private void CargarUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CargarUsuarioMouseClicked
        int fila1;
        String buscar="";
        try{
            fila1=Table1.getSelectedRow();
            if(fila1==-1){
                JOptionPane.showMessageDialog(null,"no se ha seleccionando ninguna fila");
            }
            else{
                accion="modificar";
                modelo=(DefaultTableModel)Table1.getModel();
                String id=(String)modelo.getValueAt(fila1, 0);
                String fechaMovimiento=(String)modelo.getValueAt(fila1, 1);
                String Cp=(String)modelo.getValueAt(fila1, 2);
                String idTipoMovimiento=(String)modelo.getValueAt(fila1, 3);
                String descripcionTipoMovimiento=(String)modelo.getValueAt(fila1, 4);
                String bodegaOrigen=(String)modelo.getValueAt(fila1, 5);
                String bodegaDestino=(String)modelo.getValueAt(fila1, 6);
                String Usuario=(String)modelo.getValueAt(fila1, 7);
                Generar_Reportes generarReportes = new Generar_Reportes();
                generarReportes.generarReporteUnicoUsuarioPorId(Integer.parseInt(Usuario));
                    
            }
        }catch(Exception e){
        }
    }//GEN-LAST:event_CargarUsuarioMouseClicked

    private void CargarFacturaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CargarFacturaMouseClicked
        int fila1;
        String buscar="";
        try{
            fila1=Table1.getSelectedRow();
            if(fila1==-1){
                JOptionPane.showMessageDialog(null,"no se ha seleccionando ninguna fila");
            }
            else{
                accion="modificar";
                modelo=(DefaultTableModel)Table1.getModel();
                String id=(String)modelo.getValueAt(fila1, 0);
                String fechaMovimiento=(String)modelo.getValueAt(fila1, 1);
                String Cp=(String)modelo.getValueAt(fila1, 2);
                String idTipoMovimiento=(String)modelo.getValueAt(fila1, 3);
                String descripcionTipoMovimiento=(String)modelo.getValueAt(fila1, 4);
                String bodegaOrigen=(String)modelo.getValueAt(fila1, 5);
                String bodegaDestino=(String)modelo.getValueAt(fila1, 6);
                String Usuario=(String)modelo.getValueAt(fila1, 7);
                
                //VENTAS A COMPUTADOR
                if(descripcionTipoMovimiento.equals("VentaComputadorExtranjeraRegistrar")){
                    Generar_Reportes generarReportes = new Generar_Reportes();
                        generarReportes.generar_FacturaVentaComputadorExtranjera(Integer.parseInt(idTipoMovimiento));
                }
                if(descripcionTipoMovimiento.equals("VentaComputadorNacionalRegistrar")){
                     Generar_Reportes generarReportes = new Generar_Reportes();
                            generarReportes.generar_FacturaVentaComputadorNacional(Integer.parseInt(idTipoMovimiento)); 
                }
                if(descripcionTipoMovimiento.equals("VentaComputadorExtranjeraEditar")){
                    Generar_Reportes generarReportes = new Generar_Reportes();
                        generarReportes.generar_FacturaVentaComputadorExtranjera(Integer.parseInt(idTipoMovimiento));
                }
                if(descripcionTipoMovimiento.equals("VentaComputadorNacionalEditar")){
                     Generar_Reportes generarReportes = new Generar_Reportes();
                            generarReportes.generar_FacturaVentaComputadorNacional(Integer.parseInt(idTipoMovimiento)); 
                }
                if(descripcionTipoMovimiento.equals("VentaComputadorExtranjeraAnulacion")){
                    Generar_Reportes generarReportes = new Generar_Reportes();
                    generarReportes.generar_FacturaVentaComputadorExtranjeraAnulada(Integer.parseInt(idTipoMovimiento));
                }
                if(descripcionTipoMovimiento.equals("VentaComputadorNacionalAnulacion")){
                    Generar_Reportes generarReportes = new Generar_Reportes();
                    generarReportes.generar_FacturaVentaComputadorNacionalAnulada(Integer.parseInt(idTipoMovimiento));
                }
                
                //VENTAS A ELECTRONICA
                if(descripcionTipoMovimiento.equals("VentaElectronicaExtranjeraRegistrar")){
                    Generar_Reportes generarReportes = new Generar_Reportes();
                        generarReportes.generar_FacturaVentaElectronicaExtranjera(Integer.parseInt(idTipoMovimiento));
                }
                if(descripcionTipoMovimiento.equals("VentaElectronicaNacionalRegistrar")){
                     Generar_Reportes generarReportes = new Generar_Reportes();
                            generarReportes.generar_FacturaVentaElectronicaNacional(Integer.parseInt(idTipoMovimiento)); 
                }
                if(descripcionTipoMovimiento.equals("VentaElectronicaExtranjeraEditar")){
                    Generar_Reportes generarReportes = new Generar_Reportes();
                        generarReportes.generar_FacturaVentaElectronicaExtranjera(Integer.parseInt(idTipoMovimiento));
                }
                if(descripcionTipoMovimiento.equals("VentaElectronicaNacionalEditar")){
                     Generar_Reportes generarReportes = new Generar_Reportes();
                            generarReportes.generar_FacturaVentaElectronicaNacional(Integer.parseInt(idTipoMovimiento)); 
                }
                if(descripcionTipoMovimiento.equals("VentaElectronicaExtranjeraAnulacion")){
                    Generar_Reportes generarReportes = new Generar_Reportes();
                    generarReportes.generar_FacturaVentaElectronicaExtranjeraAnulada(Integer.parseInt(idTipoMovimiento));
                }
                if(descripcionTipoMovimiento.equals("VentaElectronicaNacionalAnulacion")){
                    Generar_Reportes generarReportes = new Generar_Reportes();
                    generarReportes.generar_FacturaVentaElectronicaNacionalAnulada(Integer.parseInt(idTipoMovimiento));
                }
                 //VENTAS A PAPEL
                if(descripcionTipoMovimiento.equals("VentaPapelExtranjeraRegistrar")){
                    Generar_Reportes generarReportes = new Generar_Reportes();
                        generarReportes.generar_FacturaVentaPapelExtranjera(Integer.parseInt(idTipoMovimiento));
                }
                if(descripcionTipoMovimiento.equals("VentaPapelNacionalRegistrar")){
                     Generar_Reportes generarReportes = new Generar_Reportes();
                            generarReportes.generar_FacturaVentaPapelNacional(Integer.parseInt(idTipoMovimiento)); 
                }
                if(descripcionTipoMovimiento.equals("VentaPapelExtranjeraEditar")){
                    Generar_Reportes generarReportes = new Generar_Reportes();
                        generarReportes.generar_FacturaVentaPapelExtranjera(Integer.parseInt(idTipoMovimiento));
                }
                if(descripcionTipoMovimiento.equals("VentaPapelNacionalEditar")){
                     Generar_Reportes generarReportes = new Generar_Reportes();
                            generarReportes.generar_FacturaVentaPapelNacional(Integer.parseInt(idTipoMovimiento)); 
                }
                if(descripcionTipoMovimiento.equals("VentaPapelExtranjeraAnulacion")){
                    Generar_Reportes generarReportes = new Generar_Reportes();
                    generarReportes.generar_FacturaVentaPapelExtranjeraAnulada(Integer.parseInt(idTipoMovimiento));
                }
                if(descripcionTipoMovimiento.equals("VentaPapelNacionalAnulacion")){
                    Generar_Reportes generarReportes = new Generar_Reportes();
                    generarReportes.generar_FacturaVentaPapelNacionalAnulada(Integer.parseInt(idTipoMovimiento));
                }
                
                //COMPRAS
                if(descripcionTipoMovimiento.equals("Compra")){
                    if(bodegaOrigen.equals(bodegaDestino) && bodegaOrigen.equals("Extranjera")){  //ok
                        Generar_Reportes generarReportes = new Generar_Reportes();
                        generarReportes.generar_FacturaCompra(Integer.parseInt(idTipoMovimiento));
                    }else{
                        if(bodegaOrigen.equals(bodegaDestino) && bodegaOrigen.equals("Nacional")){  //ok
                            Generar_Reportes generarReportes = new Generar_Reportes();
                            generarReportes.generar_FacturaCompra(Integer.parseInt(idTipoMovimiento));          
                        }
                    }
                }
                if(descripcionTipoMovimiento.equals("CompraAnular")){
                    Generar_Reportes generarReportes = new Generar_Reportes();
                    generarReportes.generar_FacturaCompraAnulada(Integer.parseInt(idTipoMovimiento));
                }
                
                //MOVIMIENTOS
                if(descripcionTipoMovimiento.equals("Movimiento")){
                    Generar_Reportes generarReportes = new Generar_Reportes();
                    generarReportes.generar_Movimientos(Integer.parseInt(idTipoMovimiento));        
                }
                //MOVIMIENTOS
                if(descripcionTipoMovimiento.equals("MovimientoEditado")){
                    Generar_Reportes generarReportes = new Generar_Reportes();
                    generarReportes.generar_Movimientos(Integer.parseInt(idTipoMovimiento));        
                }
                //MOVIMIENTOS
                if(descripcionTipoMovimiento.equals("MovimientoAnulado")){
                    Generar_Reportes generarReportes = new Generar_Reportes();
                    generarReportes.generar_MovimientosAnulados(Integer.parseInt(idTipoMovimiento));        
                }
                
                //CONSUMO
                if(descripcionTipoMovimiento.equals("Consumo")){
                    Generar_Reportes generarReportes = new Generar_Reportes();
                    generarReportes.generar_ConsumoCamarones(Integer.parseInt(idTipoMovimiento));        
                }
            
                if(descripcionTipoMovimiento.equals("ConsumoAnulacion")){
                    Generar_Reportes generarReportes = new Generar_Reportes();
                    generarReportes.generar_ConsumoAnulado(Integer.parseInt(idTipoMovimiento));
                }   
                if(descripcionTipoMovimiento.equals("ConsumoNacionalEditar")){
                    Generar_Reportes generarReportes = new Generar_Reportes();
                    generarReportes.generar_ConsumoCamarones(Integer.parseInt(idTipoMovimiento));
                } 
                 
            }    
        }catch(Exception e){
        }
    }//GEN-LAST:event_CargarFacturaMouseClicked

    private void codigoBKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codigoBKeyPressed
        try {
            String valor=codigoB.getText();
            Table1.show();
            tabla(valor);
        } catch (SQLException ex) {
            Logger.getLogger(Auditoria_Control.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_codigoBKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CargarFactura;
    private javax.swing.JLabel CargarUsuario;
    private javax.swing.JTable Table1;
    private javax.swing.JButton buscar;
    private javax.swing.JTextField codigoB;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton limpiar;
    // End of variables declaration//GEN-END:variables
    public void tabla(String valorConsulta) throws SQLException{
        registro = new String[10]; 
        modelo = new DefaultTableModel(null, titulo);
        ControlDB_Auditoria controlDB_Auditoria= new ControlDB_Auditoria();
        ArrayList<Auditoria> listadoAuditoria=controlDB_Auditoria.buscarAuditoria(valorConsulta);
        for(int i =0; i< listadoAuditoria.size(); i++){
            registro[0]=""+listadoAuditoria.get(i).getId();
            registro[1]=""+listadoAuditoria.get(i).getFechaMovimiento();
            registro[2]=""+listadoAuditoria.get(i).getCp();
            registro[3]=""+listadoAuditoria.get(i).getIdTipoMovimiento();
            registro[4]=""+listadoAuditoria.get(i).getDescripcionTipoMovimiento();
            registro[5]=""+listadoAuditoria.get(i).getBodegaOrigen();
            registro[6]=""+listadoAuditoria.get(i).getBodegaDestino();
            registro[7]=""+listadoAuditoria.get(i).getUsuario_id();
            registro[8]=""+listadoAuditoria.get(i).getCantidad();
            registro[9]=""+listadoAuditoria.get(i).getFechaRegistroSistema();
            modelo.addRow(registro);
            Table1.setModel(modelo);
        }
    } 
}
