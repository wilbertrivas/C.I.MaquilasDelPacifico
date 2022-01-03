package GUI;

import Controladores.ControlDB_Bodega;
import Controladores.ControlDB_Compra;
import Controladores.ControlDB_Producto;
import Controladores.ControlDB_Proveedor;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Modelos.Bodega;
import Modelos.IngresoProducto;
import Modelos.Producto;
import Modelos.Proveedor;
import Reportes.Generar_Reportes;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Compra_Consultar extends javax.swing.JPanel {
    DefaultTableModel modelo;
    String datos;
    String [] titulo= {"Entrada Alm. No","CP","Nit_Proveedor", "Nombre_Proveedor", "No_Factura","Bodega","Producto","Fecha_Compra","FechaMaxima_Exportación","Cant_Inicial","SaldoTotalBodega","SaldoBodegaExtranjera","SaldoBodegaNacional","Estado"};
    String [] registro;  
    public Compra_Consultar() throws SQLException {
        initComponents();  
        //Cargamos las Bodegas en la interfaz###############
        ControlDB_Bodega  controlDB_Bodega = new ControlDB_Bodega();
        ArrayList<Bodega> listadoBodega = new ArrayList();
        listadoBodega=controlDB_Bodega.ListarBodegaActivas();
        for(int i=0; i< listadoBodega.size(); i++){
            editBodega.addItem(listadoBodega.get(i).getDescripcion());
        }
        
        
         //Cargamos los productos en la interfaz###############
        ControlDB_Producto  controlDB_Producto = new ControlDB_Producto();
        ArrayList<Producto> listadoProducto = new ArrayList();
        listadoProducto=controlDB_Producto.ListarProductosActivos();
        for(int i=0; i< listadoProducto.size(); i++){
            editProducto.addItem(listadoProducto.get(i).getDescripcion());
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        VerFactura = new javax.swing.JPopupMenu();
        Editar = new javax.swing.JMenuItem();
        jLabel8 = new javax.swing.JLabel();
        editNumeroFactura = new javax.swing.JTextField();
        consultar = new javax.swing.JButton();
        listar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        limpiar = new javax.swing.JButton();
        nombre = new javax.swing.JRadioButton();
        bodega = new javax.swing.JRadioButton();
        nit = new javax.swing.JRadioButton();
        editCp = new javax.swing.JTextField();
        editNit = new javax.swing.JTextField();
        factura = new javax.swing.JRadioButton();
        editNombre = new javax.swing.JTextField();
        fechaCompraInicio = new com.toedter.calendar.JDateChooser();
        cp = new javax.swing.JRadioButton();
        editBodega = new javax.swing.JComboBox<>();
        editProducto = new javax.swing.JComboBox<>();
        compra = new javax.swing.JRadioButton();
        producto = new javax.swing.JRadioButton();
        alertaGeneral = new javax.swing.JLabel();
        fechaCompraFinal = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        editColorSelect = new javax.swing.JComboBox<>();
        alertaColor = new javax.swing.JRadioButton();
        estado = new javax.swing.JRadioButton();
        estadoSelect = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();

        Editar.setText("VerFactura");
        Editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarActionPerformed(evt);
            }
        });
        VerFactura.add(Editar);

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1480, 560));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 153, 153));
        jLabel8.setText("CONSULTAR COMPRAS");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 430, 20));
        add(editNumeroFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 130, 180, 30));

        consultar.setBackground(new java.awt.Color(255, 255, 255));
        consultar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        consultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/Bodega_Actualizar_Bton_Buscar.PNG"))); // NOI18N
        consultar.setText("CONSULTAR");
        consultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultarActionPerformed(evt);
            }
        });
        add(consultar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 30, 140, 40));

        listar.setBackground(new java.awt.Color(255, 255, 255));
        listar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        listar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/Interfaz_Icon_Listar.PNG"))); // NOI18N
        listar.setText("LISTAR");
        listar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listarActionPerformed(evt);
            }
        });
        add(listar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 130, 140, 40));

        tabla = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tabla.setBackground(new java.awt.Color(153, 204, 255));
        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tabla.setComponentPopupMenu(VerFactura);
        tabla.setFocusable(false);
        tabla.setSelectionBackground(new java.awt.Color(255, 102, 102));
        tabla.getTableHeader().setReorderingAllowed(false);
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 1500, 530));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Inicio");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 120, -1, -1));

        limpiar.setBackground(new java.awt.Color(255, 255, 255));
        limpiar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        limpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/Interfaz_Icon_Borrar.PNG"))); // NOI18N
        limpiar.setText("LIMPIAR");
        limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarActionPerformed(evt);
            }
        });
        add(limpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 80, 140, 40));

        nombre.setBackground(new java.awt.Color(255, 255, 255));
        nombre.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nombre.setText("Nombre Proveedor");
        add(nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        bodega.setBackground(new java.awt.Color(255, 255, 255));
        bodega.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        bodega.setText("Bodega");
        add(bodega, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 90, -1, -1));

        nit.setBackground(new java.awt.Color(255, 255, 255));
        nit.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nit.setText("Nit Proveedor");
        add(nit, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        editCp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editCpActionPerformed(evt);
            }
        });
        add(editCp, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 50, 210, 30));
        add(editNit, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 50, 180, 30));

        factura.setBackground(new java.awt.Color(255, 255, 255));
        factura.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        factura.setText("Número Factura Proveedor");
        add(factura, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));
        add(editNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 90, 180, 30));

        fechaCompraInicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fechaCompraInicioMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                fechaCompraInicioMouseEntered(evt);
            }
        });
        add(fechaCompraInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 140, 120, 30));

        cp.setBackground(new java.awt.Color(255, 255, 255));
        cp.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cp.setText("CP");
        add(cp, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 50, -1, -1));

        add(editBodega, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 90, 210, 30));

        add(editProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 170, 180, 30));

        compra.setBackground(new java.awt.Color(255, 255, 255));
        compra.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        compra.setText("Fecha Compra");
        add(compra, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 130, -1, 40));

        producto.setBackground(new java.awt.Color(255, 255, 255));
        producto.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        producto.setText("Producto");
        add(producto, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, -1));

        alertaGeneral.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        alertaGeneral.setForeground(new java.awt.Color(255, 51, 51));
        add(alertaGeneral, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 180, 320, 20));

        fechaCompraFinal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fechaCompraFinalMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                fechaCompraFinalMouseEntered(evt);
            }
        });
        add(fechaCompraFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 140, 100, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Fin");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 120, -1, -1));

        editColorSelect.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "VERDE", "AMARILLO", "ROJO" }));
        add(editColorSelect, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 180, 210, 30));

        alertaColor.setBackground(new java.awt.Color(255, 255, 255));
        alertaColor.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        alertaColor.setText("Alerta");
        add(alertaColor, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 170, -1, 40));

        estado.setBackground(new java.awt.Color(255, 255, 255));
        estado.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        estado.setText("Estado");
        add(estado, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 30, 70, 40));

        estadoSelect.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todas", "Activas", "Inactivas", "Anuladas" }));
        estadoSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                estadoSelectActionPerformed(evt);
            }
        });
        add(estadoSelect, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 40, 210, 30));

        jLabel15.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Filtros", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Adobe Arabic", 1, 14))); // NOI18N
        add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 1090, 190));
    }// </editor-fold>//GEN-END:initComponents

    private void consultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarActionPerformed
        //Eliminamos la Busqueda Actual#######################################################
        DefaultTableModel md =(DefaultTableModel)tabla.getModel();
        int CantEliminar= tabla.getRowCount() -1;
        for(int i =CantEliminar; i>=0; i--){
            md.removeRow(i);
        }         
        String Script="";
        boolean validarConsulta = true;
        if(nit.isSelected()){
            if(editNit.getText().equals("")){
                alertaGeneral.setText("Mensaje: El Nit no puede estar Vacio");
                validarConsulta=false;
            }else{
                Script += " [proveedor_nit] like '%"+editNit.getText()+"%'";
            }
        }
        if(nombre.isSelected()){
            if(editNombre.getText().equals("")){
                alertaGeneral.setText("Mensaje: El Nombre no puede estar Vacio");
                validarConsulta=false;
            }else{
                if(Script.equals("")){
                    Script += " [proveedor_nombre] like '%"+editNombre.getText()+"%' ";
                }else{
                    Script += " and [proveedor_nombre] like '%"+editNombre.getText()+"%' ";
                }
            }
        }
         if(factura.isSelected()){
            if(editNumeroFactura.getText().equals("")){
                alertaGeneral.setText("Mensaje: El Número de Factura no puede estar Vacio");
                validarConsulta=false;
            }else{
                if(Script.equals("")){
                    Script += " [numeroFacturaProveedor] like '%"+editNumeroFactura.getText()+"%' ";
                }else{
                    Script += " and [numeroFacturaProveedor] like '%"+editNumeroFactura.getText()+"%' ";
                }
            }
        }
         if(compra.isSelected()){
              try{
                Calendar fechaI = fechaCompraInicio.getCalendar();
                String anoI = ""+fechaI.get(Calendar.YEAR);
                String mesI = "";
                if((fechaI.get(Calendar.MONTH) +1) <=9){
                                mesI = "0"+(fechaI.get(Calendar.MONTH) + 1);
                }else{
                    mesI = ""+(fechaI.get(Calendar.MONTH) + 1);
                }
                String diaI = "";
                if(fechaI.get(Calendar.DAY_OF_MONTH) <=9){
                    diaI = "0"+fechaI.get(Calendar.DAY_OF_MONTH);
                }else{
                    diaI = ""+fechaI.get(Calendar.DAY_OF_MONTH);
                }
                String fechaCompraI=anoI+"-"+mesI+"-"+diaI;
                
                
                Calendar fechaF = fechaCompraInicio.getCalendar();
                String anoF = ""+fechaF.get(Calendar.YEAR);
                String mesF = "";
                if((fechaF.get(Calendar.MONTH) +1) <=9){
                                mesF = "0"+(fechaF.get(Calendar.MONTH) + 1);
                }else{
                    mesF = ""+(fechaF.get(Calendar.MONTH) + 1);
                }
                String diaF = "";
                if(fechaF.get(Calendar.DAY_OF_MONTH) <=9){
                    diaF = "0"+fechaF.get(Calendar.DAY_OF_MONTH);
                }else{
                    diaF = ""+fechaF.get(Calendar.DAY_OF_MONTH);
                }
                String fechaCompraF=anoF+"-"+mesF+"-"+diaF;
                            if(Script.equals("")){
                                //Script += " fechaCompra BETWEEN '"+fechaCompraI+"' and '"+fechaCompraF+"' ";
                                Script += " [fechaCompra]  BETWEEN CAST('"+fechaCompraI+"' AS DATE) AND CAST('"+fechaCompraF+"' AS DATE) ";
                            }else{
                                 //Script += " and fechaCompra BETWEEN '"+fechaCompraI+"' and '"+fechaCompraF+"' ";
                                 Script += " AND [fechaCompra]  BETWEEN CAST('"+fechaCompraI+"' AS DATE) AND CAST('"+fechaCompraF+"' AS DATE) ";
                            }
              }catch(Exception e){
                  alertaGeneral.setText("Mensaje: Verifique Fecha:");
                  validarConsulta=false;
              }            
        }
         if(cp.isSelected()){
            if(editCp.getText().equals("")){
                alertaGeneral.setText("Mensaje: El Cp no puede estar Vacio");
                validarConsulta=false;
            }else{
                if(Script.equals("")){
                    Script += " [cp] like '%"+editCp.getText()+"%' ";
                }else{
                    Script += " and [cp] like '%"+editCp.getText()+"%' ";
                }
            }
        }    
        if(bodega.isSelected()){
            ControlDB_Bodega controlDB_Bodega = new ControlDB_Bodega();
            int idBodega=controlDB_Bodega.RetornoIdBodega(editBodega.getSelectedItem().toString());   
            if(Script.equals("")){ 
                Script += " [bodega_ingresoProductoInicial_id] = '"+idBodega+"'  ";
            }else{
                Script += "  and [bodega_ingresoProductoInicial_id] = '"+idBodega+"'  "; 
            }
        }     
        if(producto.isSelected()){
            ControlDB_Producto controlDB_Producto = new ControlDB_Producto();
            int idProducto=controlDB_Producto.RetornoIdProducto(editProducto.getSelectedItem().toString());   
            if(Script.equals("")){ 
                Script += " [producto_id] = '"+idProducto+"' ";
            }else{
                Script += " and [producto_id] = '"+idProducto+"' ";
            }
        }
        if(estado.isSelected()){
            if(estadoSelect.getSelectedIndex()==0){//seleccionamos Todas
                if(Script.equals("")){ 
                    Script += " ([estado]=1 OR [estado]=2 OR [estado]=0) ";
                }else{
                    Script += " AND ([estado]=1 OR [estado]=2 OR [estado]=0) ";
                }
            }
            if(estadoSelect.getSelectedIndex()==1){//seleccionamos Activas
                if(Script.equals("")){ 
                    Script += " ([estado]=1) ";
                }else{
                    Script += " AND ([estado]=1) ";
                }
            }
            if(estadoSelect.getSelectedIndex()==2){//seleccionamos Inactivas
                if(Script.equals("")){ 
                    Script += " ([estado]=0) ";
                }else{
                    Script += " AND ([estado]=0) ";
                }
            }
            if(estadoSelect.getSelectedIndex()==3){//seleccionamos Anuladas
                if(Script.equals("")){ 
                    Script += " ([estado]=2) ";
                }else{
                    Script += " AND ([estado]=2) ";
                }
            }       
        }
        if(validarConsulta){
            try {
                if(nit.isSelected() || nombre.isSelected() || factura.isSelected() || compra.isSelected() || cp.isSelected() || bodega.isSelected() || producto.isSelected()|| estado.isSelected() ){
                     tabla( " Where "+Script);
                }else{
                     tabla( "");
                }
                tabla.setDefaultRenderer(Object.class, new Myrender(8));
            } catch (SQLException ex) {
                Logger.getLogger(Compra_Consultar.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(Compra_Consultar.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
    }//GEN-LAST:event_consultarActionPerformed

    private void listarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listarActionPerformed
        try {
            tabla("");
        } catch (SQLException ex) {
            Logger.getLogger(Compra_Consultar.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Compra_Consultar.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }//GEN-LAST:event_listarActionPerformed

    private void limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarActionPerformed
            editNit.setText("");
            editNombre.setText("");
            editNumeroFactura.setText("");
            editCp.setText("");
            nit.setSelected(false);
            nombre.setSelected(false);
            factura.setSelected(false);
            producto.setSelected(false);
            cp.setSelected(false);
            bodega.setSelected(false);
            compra.setSelected(false);
            alertaColor.setSelected(false);
    }//GEN-LAST:event_limpiarActionPerformed

    private void editCpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editCpActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editCpActionPerformed

    private void fechaCompraInicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fechaCompraInicioMouseClicked
        alertaGeneral.setText("");
    }//GEN-LAST:event_fechaCompraInicioMouseClicked

    private void fechaCompraInicioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fechaCompraInicioMouseEntered
        alertaGeneral.setText("");
    }//GEN-LAST:event_fechaCompraInicioMouseEntered

    private void fechaCompraFinalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fechaCompraFinalMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_fechaCompraFinalMouseClicked

    private void fechaCompraFinalMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fechaCompraFinalMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_fechaCompraFinalMouseEntered

    private void EditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarActionPerformed
        // TODO lo del clik derechoo
        int fila1;
        String buscar="";
        try{
            fila1=tabla.getSelectedRow();
            if(fila1==-1){
                JOptionPane.showMessageDialog(null,"no se ha seleccionando ninguna fila");
            }
            else{
                try{

                    modelo=(DefaultTableModel)tabla.getModel();
                    String id=(String)modelo.getValueAt(fila1, 0);
                    String estado=(String)modelo.getValueAt(fila1, 13);
                    if(estado.equals("Anulada")){
                        Generar_Reportes generarReportes = new Generar_Reportes();
                        generarReportes.generar_FacturaCompraAnulada(Integer.parseInt(id));
                    }else{
                        Generar_Reportes generarReportes = new Generar_Reportes();
                        generarReportes.generar_FacturaCompra(Integer.parseInt(id));
                    }
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, "No se pudo cargar el proveedor");
                }
            }
        }catch(Exception e){
        }
    }//GEN-LAST:event_EditarActionPerformed

    private void estadoSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_estadoSelectActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_estadoSelectActionPerformed

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked
        if (evt.getClickCount() == 2) {
             // TODO lo del clik derechoo
            int fila1;
            String buscar="";
            try{
                fila1=tabla.getSelectedRow();
                if(fila1==-1){
                    JOptionPane.showMessageDialog(null,"no se ha seleccionando ninguna fila");
                }
                else{
                    try{

                        modelo=(DefaultTableModel)tabla.getModel();
                        String id=(String)modelo.getValueAt(fila1, 0);
                        String estado=(String)modelo.getValueAt(fila1, 13);
                        if(estado.equals("Anulada")){
                            Generar_Reportes generarReportes = new Generar_Reportes();
                            generarReportes.generar_FacturaCompraAnulada(Integer.parseInt(id));
                        }else{
                            Generar_Reportes generarReportes = new Generar_Reportes();
                            generarReportes.generar_FacturaCompra(Integer.parseInt(id));
                        }
                    }catch(Exception e){
                        JOptionPane.showMessageDialog(null, "No se pudo cargar el proveedor");
                    }
                }
            }catch(Exception e){
            }
        }
    }//GEN-LAST:event_tablaMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Editar;
    private javax.swing.JPopupMenu VerFactura;
    private javax.swing.JRadioButton alertaColor;
    private javax.swing.JLabel alertaGeneral;
    private javax.swing.JRadioButton bodega;
    private javax.swing.JRadioButton compra;
    private javax.swing.JButton consultar;
    private javax.swing.JRadioButton cp;
    private javax.swing.JComboBox<String> editBodega;
    private javax.swing.JComboBox<String> editColorSelect;
    private javax.swing.JTextField editCp;
    private javax.swing.JTextField editNit;
    private javax.swing.JTextField editNombre;
    private javax.swing.JTextField editNumeroFactura;
    private javax.swing.JComboBox<String> editProducto;
    private javax.swing.JRadioButton estado;
    private javax.swing.JComboBox<String> estadoSelect;
    private javax.swing.JRadioButton factura;
    private com.toedter.calendar.JDateChooser fechaCompraFinal;
    private com.toedter.calendar.JDateChooser fechaCompraInicio;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton limpiar;
    private javax.swing.JButton listar;
    private javax.swing.JRadioButton nit;
    private javax.swing.JRadioButton nombre;
    private javax.swing.JRadioButton producto;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
    public void tabla(String script) throws SQLException, ParseException{
        registro = new String[14]; 
        modelo = new DefaultTableModel(null, titulo);
        ControlDB_Compra com = new ControlDB_Compra();
        ArrayList<IngresoProducto> listadoIngresoProducto=com.consultarComprasActivasAnuladasInactivas(script);
        ControlDB_Producto controlDB_Producto = new ControlDB_Producto();
        ControlDB_Bodega controlDB_Bodega = new ControlDB_Bodega();
        if(alertaColor.isSelected()){
            for(int i =0; i< listadoIngresoProducto.size(); i++){
                if(diferenciaFecha(listadoIngresoProducto.get(i).getFechaMaximaExportacion()).equals(editColorSelect.getSelectedItem().toString())){
                    registro[0]=""+listadoIngresoProducto.get(i).getId();
                    registro[1]=""+listadoIngresoProducto.get(i).getCp();
                    registro[2]=""+listadoIngresoProducto.get(i).getProveedor_nit();
                    
                    Proveedor prov = new Proveedor();
                    prov.setNit(listadoIngresoProducto.get(i).getProveedor_nit());
                    prov.setSucursal(listadoIngresoProducto.get(i).getProveedor_sucursal());
                    ControlDB_Proveedor controlDB_Proveedor = new ControlDB_Proveedor();
                    ArrayList<Proveedor> listadoProv=controlDB_Proveedor.consultarUnicoProveedor(prov);
                    for(int a =0; a< listadoProv.size(); a++){ 
                       registro[3]=""+listadoProv.get(a).getNombre();
                       //Colocamos el Digito de Verificación al Nit
                       registro[2]=""+listadoIngresoProducto.get(i).getProveedor_nit()+"-"+listadoProv.get(a).getDigitoVerificacion();;
                    }
                    
                    registro[4]=""+listadoIngresoProducto.get(i).getNumeroFacturaProveedor();
                    registro[5]=""+controlDB_Bodega.RetornoNombreBodega(listadoIngresoProducto.get(i).getBodega_ingresoProductoInicial());
                    registro[6]=""+controlDB_Producto.RetornoNombreProducto(listadoIngresoProducto.get(i).getProducto_id());
                    registro[7]=""+listadoIngresoProducto.get(i).getFechaCompra();
                    registro[8]=""+listadoIngresoProducto.get(i).getFechaMaximaExportacion();
                    registro[9]=""+listadoIngresoProducto.get(i).getCantidadInicial();
                    //BigDecimal saldo = new java.math.BigDecimal(""+com.retornarSaldoIngresoProducto(Integer.parseInt(listadoIngresoProducto.get(i).getId())));
                    //registro[10]=""+ saldo.toString();
                    registro[10]=""+ com.retornarSaldoIngresoProducto(Integer.parseInt(listadoIngresoProducto.get(i).getId()));
                    registro[11]=""+ com.retornarSaldoIngresoProductoExtranjera(Integer.parseInt(listadoIngresoProducto.get(i).getId()));
                    registro[12]=""+ com.retornarSaldoIngresoProductoNacional(Integer.parseInt(listadoIngresoProducto.get(i).getId()));
                    registro[13]=""+validarEstado(listadoIngresoProducto.get(i).getEstado());
                    modelo.addRow(registro);
                    tabla.setModel(modelo);
                }
            }
        }else{
            for(int i =0; i< listadoIngresoProducto.size(); i++){
                registro[0]=""+listadoIngresoProducto.get(i).getId();
                registro[1]=""+listadoIngresoProducto.get(i).getCp();
                registro[2]=""+listadoIngresoProducto.get(i).getProveedor_nit();
                
                Proveedor prov = new Proveedor();
                prov.setNit(listadoIngresoProducto.get(i).getProveedor_nit());
                prov.setSucursal(listadoIngresoProducto.get(i).getProveedor_sucursal());
                ControlDB_Proveedor controlDB_Proveedor = new ControlDB_Proveedor();
                ArrayList<Proveedor> listadoProv=controlDB_Proveedor.consultarUnicoProveedor(prov);
                for(int a =0; a< listadoProv.size(); a++){ 
                   registro[3]=""+listadoProv.get(a).getNombre();
                   //Colocamos el Digito de Verificación al Nit
                   registro[2]=""+listadoIngresoProducto.get(i).getProveedor_nit()+"-"+listadoProv.get(a).getDigitoVerificacion();;
                }
                
                registro[4]=""+listadoIngresoProducto.get(i).getNumeroFacturaProveedor();
                registro[5]=""+controlDB_Bodega.RetornoNombreBodega(listadoIngresoProducto.get(i).getBodega_ingresoProductoInicial());
                registro[6]=""+controlDB_Producto.RetornoNombreProducto(listadoIngresoProducto.get(i).getProducto_id());
                registro[7]=""+listadoIngresoProducto.get(i).getFechaCompra();
                registro[8]=""+listadoIngresoProducto.get(i).getFechaMaximaExportacion();
                registro[9]=""+listadoIngresoProducto.get(i).getCantidadInicial();
                //BigDecimal saldo = new java.math.BigDecimal(""+com.retornarSaldoIngresoProducto(Integer.parseInt(listadoIngresoProducto.get(i).getId())));
                //registro[10]=""+ saldo.toString();
                
                registro[10]=""+ com.retornarSaldoIngresoProducto(Integer.parseInt(listadoIngresoProducto.get(i).getId()));
                registro[11]=""+ com.retornarSaldoIngresoProductoExtranjera(Integer.parseInt(listadoIngresoProducto.get(i).getId()));
                registro[12]=""+ com.retornarSaldoIngresoProductoNacional(Integer.parseInt(listadoIngresoProducto.get(i).getId()));
                registro[13]=""+validarEstado(listadoIngresoProducto.get(i).getEstado());
                modelo.addRow(registro);
                tabla.setModel(modelo);
            }
        }
    }
    public String validarEstado(int valor){
        String retorno="";
        switch(valor){
            case 0:{
                retorno= "Inactiva";
                break;
            }
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
    public String diferenciaFecha(String fechaMaximaExportacion) throws ParseException{
        Date fechaActual = new Date(); 
        String  Fecha =new SimpleDateFormat("yyyy-MM-dd").format(fechaActual);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaHoy=dateFormat.parse(Fecha);
        Date fechaDevo=dateFormat.parse(fechaMaximaExportacion);
        int diasAtraso=(int) ((fechaDevo.getTime() -fechaHoy.getTime())/86400000);
        if(diasAtraso >= 61){
            return "VERDE";
        }else{
            if(diasAtraso >= 31 && diasAtraso <= 60){
                return "AMARILLO";
            }else{
                return "ROJO";
            }
        }        
    }
}
