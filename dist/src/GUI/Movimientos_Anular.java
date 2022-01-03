package GUI;

import Controladores.ControlDB_Compra;
import Controladores.ControlDB_Movimientos_Anular;
import Modelos.Movimiento;
import Modelos.MovimientoItemProducto;
import Modelos.MovimientoProducto;
import Modelos.Proveedor;
import Modelos.Usuario;
import Reportes.Generar_Reportes;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Movimientos_Anular extends javax.swing.JPanel {
    String valor="";
    Usuario user;
    String []tituloCP= {"CP","PRODUCTO","BODEGA","NOMBRE_PROV.","FECHA_COMPRA","FECHA_MAX._EXPORT.","SALDO","CANTIDAD A VENDER"};
    String [] registroCP;
    DefaultTableModel modeloCP;
    int facturaVentaNumero=0;
    String numeroCp="";
    int MovimientoNumero=0;
    int saldoOriginalesBodegaExtranjera=0;
    int saldoOriginalesBodegaNacional=0;
    
    public Movimientos_Anular(Usuario u) {
        user= u;
        initComponents();
        VentanaBuscarDocumento.show(false);
        //Formato de la tabla en la que se cargan los CP
        registroCP= new String[8]; 
        modeloCP = new DefaultTableModel(null, tituloCP);
        Table_Movimiento_Bodega.setModel(modeloCP);            
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Seleccionar_movimiento = new javax.swing.JPopupMenu();
        Seleccionar_Movimiento = new javax.swing.JMenuItem();
        VentanaBuscarDocumento = new javax.swing.JInternalFrame();
        alertaBuscarMovimiento = new javax.swing.JLabel();
        codigoDocumento = new javax.swing.JTextField();
        ventanaInterna_Nombre1 = new javax.swing.JLabel();
        botonLimpiarBusqueda = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        ListadoBusquedasDocumentos = new javax.swing.JTable();
        botonBuscarDocumento = new javax.swing.JButton();
        botonCancelarBusqueda = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        Table_Movimiento_Bodega = new javax.swing.JTable();
        RegistrarMovimiento = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        fechaMovimiento = new com.toedter.calendar.JDateChooser();
        alertaFechaMovimiento = new javax.swing.JLabel();
        MovimientoNo = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        BuscarCompra = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();

        Seleccionar_Movimiento.setText("Seleccionar_Movimiento");
        Seleccionar_Movimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Seleccionar_MovimientoActionPerformed(evt);
            }
        });
        Seleccionar_movimiento.add(Seleccionar_Movimiento);

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        VentanaBuscarDocumento.setBackground(new java.awt.Color(255, 255, 255));
        VentanaBuscarDocumento.setTitle("Buscar Movimientos en Bodega");
        VentanaBuscarDocumento.setToolTipText("");
        VentanaBuscarDocumento.setVisible(true);
        VentanaBuscarDocumento.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        alertaBuscarMovimiento.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        alertaBuscarMovimiento.setForeground(new java.awt.Color(255, 0, 51));
        VentanaBuscarDocumento.getContentPane().add(alertaBuscarMovimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 770, 30));

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
        VentanaBuscarDocumento.getContentPane().add(codigoDocumento, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 250, 30));

        ventanaInterna_Nombre1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ventanaInterna_Nombre1.setForeground(new java.awt.Color(0, 153, 153));
        ventanaInterna_Nombre1.setText("Ingrese número de movimiento camarones");
        VentanaBuscarDocumento.getContentPane().add(ventanaInterna_Nombre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 350, -1));

        botonLimpiarBusqueda.setBackground(new java.awt.Color(255, 255, 255));
        botonLimpiarBusqueda.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        botonLimpiarBusqueda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/Interfaz_Icon_Borrar.PNG"))); // NOI18N
        botonLimpiarBusqueda.setText("LIMPIAR");
        botonLimpiarBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonLimpiarBusquedaActionPerformed(evt);
            }
        });
        VentanaBuscarDocumento.getContentPane().add(botonLimpiarBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, 140, 40));

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

        VentanaBuscarDocumento.getContentPane().add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 1390, 370));

        botonBuscarDocumento.setBackground(new java.awt.Color(255, 255, 255));
        botonBuscarDocumento.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        botonBuscarDocumento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/Bodega_Actualizar_Bton_Buscar.PNG"))); // NOI18N
        botonBuscarDocumento.setText("BUSCAR");
        botonBuscarDocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarDocumentoActionPerformed(evt);
            }
        });
        VentanaBuscarDocumento.getContentPane().add(botonBuscarDocumento, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 140, -1));

        botonCancelarBusqueda.setBackground(new java.awt.Color(255, 255, 255));
        botonCancelarBusqueda.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        botonCancelarBusqueda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/Bodega_Actualizar_Bton_Cancelar.PNG"))); // NOI18N
        botonCancelarBusqueda.setText("CANCELAR");
        botonCancelarBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarBusquedaActionPerformed(evt);
            }
        });
        VentanaBuscarDocumento.getContentPane().add(botonCancelarBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 90, 160, 40));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/fondo.png"))); // NOI18N
        VentanaBuscarDocumento.getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1440, 520));

        add(VentanaBuscarDocumento, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 1450, 540));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 102, 102));
        jLabel9.setText("ANULACIÓN DE MOVIMIENTOS");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 490, 30));

        Table_Movimiento_Bodega = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;

            }

        };
        Table_Movimiento_Bodega.setBackground(new java.awt.Color(153, 204, 255));
        Table_Movimiento_Bodega.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        Table_Movimiento_Bodega.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Table_Movimiento_Bodega.setSelectionBackground(new java.awt.Color(255, 102, 102));
        Table_Movimiento_Bodega.getTableHeader().setReorderingAllowed(false);
        Table_Movimiento_Bodega.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Table_Movimiento_BodegaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Table_Movimiento_BodegaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Table_Movimiento_BodegaMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Table_Movimiento_BodegaMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                Table_Movimiento_BodegaMouseReleased(evt);
            }
        });
        Table_Movimiento_Bodega.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Table_Movimiento_BodegaKeyPressed(evt);
            }
        });
        jScrollPane4.setViewportView(Table_Movimiento_Bodega);

        add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 1400, 130));

        RegistrarMovimiento.setBackground(new java.awt.Color(255, 255, 255));
        RegistrarMovimiento.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        RegistrarMovimiento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/Bodega_Registrar_Bton_Registrar.PNG"))); // NOI18N
        RegistrarMovimiento.setText("ANULAR MOVIMIENTO");
        RegistrarMovimiento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                RegistrarMovimientoMouseExited(evt);
            }
        });
        RegistrarMovimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistrarMovimientoActionPerformed(evt);
            }
        });
        add(RegistrarMovimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, 240, 60));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("FECHA DE MOVIMIENTO");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 160, 20));

        fechaMovimiento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fechaMovimientoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                fechaMovimientoMouseEntered(evt);
            }
        });
        add(fechaMovimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 200, 160, 30));

        alertaFechaMovimiento.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        alertaFechaMovimiento.setForeground(new java.awt.Color(255, 51, 51));
        add(alertaFechaMovimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 1090, 30));

        MovimientoNo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        MovimientoNo.setText("Movimiento No.");
        add(MovimientoNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 260, 20));
        add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 1070, 20));

        BuscarCompra.setBackground(new java.awt.Color(255, 255, 255));
        BuscarCompra.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        BuscarCompra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/Bodega_Registrar_Bton_Registrar.PNG"))); // NOI18N
        BuscarCompra.setText("BUSCAR MOVIMIENTO");
        BuscarCompra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                BuscarCompraMouseExited(evt);
            }
        });
        BuscarCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarCompraActionPerformed(evt);
            }
        });
        add(BuscarCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, 320, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 102, 102));
        jLabel10.setText("BUSCAR MOVIMIENTO");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 200, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void RegistrarMovimientoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RegistrarMovimientoMouseExited

    }//GEN-LAST:event_RegistrarMovimientoMouseExited

    private void RegistrarMovimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistrarMovimientoActionPerformed
         try{
            Calendar fecha = fechaMovimiento.getCalendar();
            String ano = ""+fecha.get(Calendar.YEAR);
            String mes = "";
            if((fecha.get(Calendar.MONTH) +1) <=9){
                mes = "0"+(fecha.get(Calendar.MONTH) + 1);
            }else{
                mes = ""+(fecha.get(Calendar.MONTH) + 1);
            }
            String dia = "";
            if(fecha.get(Calendar.DAY_OF_MONTH) <=9){
                dia = "0"+fecha.get(Calendar.DAY_OF_MONTH);
            }else{
                dia = ""+fecha.get(Calendar.DAY_OF_MONTH);
            }
            String fechaMovimiento=ano+"-"+mes+"-"+dia;
           
            int filas = Table_Movimiento_Bodega.getRowCount();
            int saldoBodegaExtranjeraActual= 0;
            int saldoBodegaExtranjeraModificado=0;
            int saldoExtranjeraTraslado=0;

            int saldoBodegaNacionalActual=0;
            int saldoBodegaNacionalModificado=0;
            int saldoNacionalTrasladado=0;
            String CP="";
            if(filas <= 0){
                JOptionPane.showMessageDialog(null, "No se ha cargado un CP");
            }else{
                DefaultTableModel modeloX=(DefaultTableModel)Table_Movimiento_Bodega.getModel();
                for(int i=0; i< filas; i++){
                    try{
                        CP=(String)modeloX.getValueAt(i, 0);
                        String tipoBodega=(String)modeloX.getValueAt(i, 2);
                        if(tipoBodega.equals("Extranjera")){
                            saldoBodegaExtranjeraActual= Integer.parseInt((String)modeloX.getValueAt(i, 7));
                            saldoExtranjeraTraslado=Integer.parseInt((String)modeloX.getValueAt(i, 8));
                            saldoBodegaExtranjeraModificado=  saldoBodegaExtranjeraActual -Integer.parseInt((String)modeloX.getValueAt(i, 8));    
                        }else{
                            if(tipoBodega.equals("Nacional")){
                                saldoBodegaNacionalActual= Integer.parseInt((String)modeloX.getValueAt(i, 7));
                                saldoNacionalTrasladado= Integer.parseInt((String)modeloX.getValueAt(i, 8));
                                saldoBodegaNacionalModificado=  saldoBodegaNacionalActual -Integer.parseInt((String)modeloX.getValueAt(i, 8));   
                            }
                        }
                    }catch(Exception e){
                       JOptionPane.showMessageDialog(null,"Error al realizar Movimiento Verifique Datos");
                    } 
                }
                //Actualizamos los nuevos saldos para cargarlos en la DB
                saldoBodegaExtranjeraModificado = saldoBodegaExtranjeraModificado + saldoNacionalTrasladado;
                saldoBodegaNacionalModificado =  saldoBodegaNacionalModificado + saldoExtranjeraTraslado;

                /*JOptionPane.showMessageDialog(null, "Actual_Extranjera:"+saldoBodegaExtranjeraActual+"\nNuevo_Extranjera:"+saldoBodegaExtranjeraModificado+"\n"
                                                    + "Actual_Nacional:"+saldoBodegaNacionalActual+"\nNuevo_Nacional:"+saldoBodegaNacionalModificado);*/ 
                //ControlDB_Movimientos_Editar_Camarones  controlDB_Movimientos_Camarones = new ControlDB_Movimientos_Editar_Camarones();
                
                //validamos que los saldo en la bodega sigan Igual al orignal################################
                
                ControlDB_Movimientos_Anular controlDB_Movimientos= new ControlDB_Movimientos_Anular();
                DefaultTableModel modelo=(DefaultTableModel)Table_Movimiento_Bodega.getModel();
                int idMovimiento = MovimientoNumero;
                String CP_Temp=(String)modelo.getValueAt(0, 0);
                //System.out.println("cpTemportal: "+ CP_Temp);
                int idIngresoProducto = controlDB_Movimientos.retornarIdIngresoProducto(CP_Temp);
                //System.out.println("Extranjera: "+saldoOriginalesBodegaExtranjera);
                //System.out.println("Nacional: "+ saldoOriginalesBodegaNacional);
                //System.out.println("idMovimiento: "+ idMovimiento);
                //System.out.println("idIngresoProducto: "+ idIngresoProducto);
                
                if(controlDB_Movimientos.validarEstadoSaldoIngresoProducto(saldoOriginalesBodegaExtranjera, saldoOriginalesBodegaNacional, idIngresoProducto)){
                    //JOptionPane.showMessageDialog(null, "No han cambiado los saldos se puede modificiar Movimiento");
                    if(controlDB_Movimientos.actualizarSaldosIngresoProducto(saldoBodegaExtranjeraActual, saldoBodegaNacionalActual, idIngresoProducto)){
                        //Actualizamos estado a Anulado
                        if(controlDB_Movimientos.AnularMovimiento(idMovimiento,CP_Temp, user)){
                            JOptionPane.showMessageDialog(null, "Movimiento para CP "+CP+ " Fue Anulado con Exito");//Anulación Exitosa
                            Generar_Reportes generarReportes = new Generar_Reportes();
                            generarReportes.generar_MovimientosAnulados(MovimientoNumero);
                            //Table_Movimiento_Bodega.setDefaultRenderer(Object.class, new Myrender_VentasRegistrarExtranjera(6));
                        }else{
                            JOptionPane.showMessageDialog(null, "Error al Anular CP "+CP+ ", no fue posible Anularlo");//Error de Anulacióna
                        }
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Los saldo han cambiado no se puede Anular Movimiento");
                }
                //###########################################################################################            
            }
        }catch(Exception e){
            alertaFechaMovimiento.setText("ERROR verifique la fecha");
        }
    }//GEN-LAST:event_RegistrarMovimientoActionPerformed

    private void Table_Movimiento_BodegaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Table_Movimiento_BodegaKeyPressed
        int filas = Table_Movimiento_Bodega.getRowCount();
        DefaultTableModel modeloX=(DefaultTableModel)Table_Movimiento_Bodega.getModel();
        for(int i=0; i< filas; i++){
            try{
                //JOptionPane.showMessageDialog(null, (String)modeloX.getValueAt(i, 7));
                int cantidadDisponibleEnBodega = Integer.parseInt((String)modeloX.getValueAt(i, 7));
                int cantidadSolicitadaMovimiento= Integer.parseInt((String)modeloX.getValueAt(i, 8));
                if(cantidadSolicitadaMovimiento > cantidadDisponibleEnBodega){
                   JOptionPane.showMessageDialog(null, "La cantidad no puede superar el saldo");
                    modeloX.setValueAt("0", i, 8);
                }
                if(cantidadSolicitadaMovimiento < 0){
                   JOptionPane.showMessageDialog(null, "La cantidad solicitada no puede ser negativa");
                    modeloX.setValueAt("0", i, 8);
                }
            }catch(Exception e){
               JOptionPane.showMessageDialog(null,"EL valor ingresado en la fila No. "+(i +1)+" debe ser Numerico");
               modeloX.setValueAt("0", i, 8);
            }
        }
    }//GEN-LAST:event_Table_Movimiento_BodegaKeyPressed

    private void Table_Movimiento_BodegaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Table_Movimiento_BodegaMouseEntered
        int filas = Table_Movimiento_Bodega.getRowCount();
        DefaultTableModel modeloX=(DefaultTableModel)Table_Movimiento_Bodega.getModel();
        for(int i=0; i< filas; i++){
            try{
                int cantidadDisponibleEnBodega = Integer.parseInt((String)modeloX.getValueAt(i, 7));
                int cantidadSolicitadaMovimiento= Integer.parseInt((String)modeloX.getValueAt(i, 8));
                if(cantidadSolicitadaMovimiento > cantidadDisponibleEnBodega){
                   JOptionPane.showMessageDialog(null, "La cantidad no puede superar el saldo");
                    modeloX.setValueAt("0", i, 8);
                }
                if(cantidadSolicitadaMovimiento < 0){
                   JOptionPane.showMessageDialog(null, "La cantidad solicitada no puede ser negativa");
                    modeloX.setValueAt("0", i, 8);
                }
            }catch(Exception e){
               JOptionPane.showMessageDialog(null,"EL valor ingresado en la fila No. "+(i +1)+" debe ser Numerico");
               modeloX.setValueAt("0", i, 8);
            }
        }
    }//GEN-LAST:event_Table_Movimiento_BodegaMouseEntered

    private void Table_Movimiento_BodegaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Table_Movimiento_BodegaMouseExited
       int filas = Table_Movimiento_Bodega.getRowCount();
        DefaultTableModel modeloX=(DefaultTableModel)Table_Movimiento_Bodega.getModel();
        for(int i=0; i< filas; i++){
            try{
               int cantidadDisponibleEnBodega = Integer.parseInt((String)modeloX.getValueAt(i, 7));
               int cantidadSolicitadaMovimiento= Integer.parseInt((String)modeloX.getValueAt(i, 8));
               if(cantidadSolicitadaMovimiento > cantidadDisponibleEnBodega){
                    JOptionPane.showMessageDialog(null, "La cantidad no puede superar el saldo");
                    modeloX.setValueAt("0", i, 8);
               }
               if(cantidadSolicitadaMovimiento < 0){
                    JOptionPane.showMessageDialog(null, "La cantidad solicitada no puede ser negativa");
                    modeloX.setValueAt("0", i, 8);
               }
            }catch(Exception e){
               JOptionPane.showMessageDialog(null,"EL valor ingresado en la fila No. "+(i +1)+" debe ser Numerico");
               modeloX.setValueAt("0", i, 8);
            }
        }
    }//GEN-LAST:event_Table_Movimiento_BodegaMouseExited

    private void Table_Movimiento_BodegaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Table_Movimiento_BodegaMousePressed
        int filas = Table_Movimiento_Bodega.getRowCount();
        DefaultTableModel modeloX=(DefaultTableModel)Table_Movimiento_Bodega.getModel();
        for(int i=0; i< filas; i++){
            try{
               int cantidadDisponibleEnBodega = Integer.parseInt((String)modeloX.getValueAt(i, 7));
               int cantidadSolicitadaMovimiento= Integer.parseInt((String)modeloX.getValueAt(i, 8));
               if(cantidadSolicitadaMovimiento > cantidadDisponibleEnBodega){
                    JOptionPane.showMessageDialog(null, "La cantidad no puede superar el saldo");
                    modeloX.setValueAt("0", i, 8);
               }
               if(cantidadSolicitadaMovimiento < 0){
                  JOptionPane.showMessageDialog(null, "La cantidad solicitada no puede ser negativa");
                   modeloX.setValueAt("0", i, 8);
               }
            }catch(Exception e){
               JOptionPane.showMessageDialog(null,"EL valor ingresado en la fila No. "+(i +1)+" debe ser Numerico");
               modeloX.setValueAt("0", i, 8);
            }
        }
    }//GEN-LAST:event_Table_Movimiento_BodegaMousePressed

    private void Table_Movimiento_BodegaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Table_Movimiento_BodegaMouseReleased
       int filas = Table_Movimiento_Bodega.getRowCount();
        DefaultTableModel modeloX=(DefaultTableModel)Table_Movimiento_Bodega.getModel();
        for(int i=0; i< filas; i++){
            try{
                int cantidadDisponibleEnBodega = Integer.parseInt((String)modeloX.getValueAt(i, 7));
                int cantidadSolicitadaMovimiento= Integer.parseInt((String)modeloX.getValueAt(i, 8));
                if(cantidadSolicitadaMovimiento > cantidadDisponibleEnBodega){
                    JOptionPane.showMessageDialog(null, "La cantidad no puede superar el saldo");
                    modeloX.setValueAt("0", i, 8);
                }
                if(cantidadSolicitadaMovimiento < 0){
                    JOptionPane.showMessageDialog(null, "La cantidad solicitada no puede ser negativa");
                    modeloX.setValueAt("0", i, 8);
               }
            }catch(Exception e){
               JOptionPane.showMessageDialog(null,"EL valor ingresado en la fila No. "+(i +1)+" debe ser Numerico");
               modeloX.setValueAt("0", i, 8);
            }
        }
    }//GEN-LAST:event_Table_Movimiento_BodegaMouseReleased

    private void Table_Movimiento_BodegaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Table_Movimiento_BodegaMouseClicked
        int filas = Table_Movimiento_Bodega.getRowCount();
        DefaultTableModel modeloX=(DefaultTableModel)Table_Movimiento_Bodega.getModel();
        for(int i=0; i< filas; i++){
            try{
                int cantidadDisponibleEnBodega = Integer.parseInt((String)modeloX.getValueAt(i, 7));
                int cantidadSolicitadaMovimiento= Integer.parseInt((String)modeloX.getValueAt(i, 8));
                if(cantidadSolicitadaMovimiento > cantidadDisponibleEnBodega){
                    JOptionPane.showMessageDialog(null, "La cantidad no puede superar el saldo");
                    modeloX.setValueAt("0", i, 8);
                }
                if(cantidadSolicitadaMovimiento < 0){
                    JOptionPane.showMessageDialog(null, "La cantidad solicitada no puede ser negativa");
                    modeloX.setValueAt("0", i, 8);
               }
            }catch(Exception e){
                JOptionPane.showMessageDialog(null,"EL valor ingresado en la fila No. "+(i +1)+" debe ser Numerico");
                modeloX.setValueAt("0", i, 8);
            }
        }
    }//GEN-LAST:event_Table_Movimiento_BodegaMouseClicked

    private void fechaMovimientoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fechaMovimientoMouseClicked
        alertaFechaMovimiento.setText("");
    }//GEN-LAST:event_fechaMovimientoMouseClicked

    private void fechaMovimientoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fechaMovimientoMouseEntered
        alertaFechaMovimiento.setText("");
    }//GEN-LAST:event_fechaMovimientoMouseEntered

    private void BuscarCompraMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BuscarCompraMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_BuscarCompraMouseExited

    private void BuscarCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarCompraActionPerformed
        VentanaBuscarDocumento.show(true);
    }//GEN-LAST:event_BuscarCompraActionPerformed

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
            Logger.getLogger(Movimientos_Anular.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_botonBuscarDocumentoActionPerformed

    private void botonCancelarBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarBusquedaActionPerformed
        VentanaBuscarDocumento.show(false);
    }//GEN-LAST:event_botonCancelarBusquedaActionPerformed

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
                ControlDB_Movimientos_Anular controlDB_Movimientos= new ControlDB_Movimientos_Anular();
                MovimientoProducto movimientoProducto =controlDB_Movimientos.consultarUnicoMovimientoProducto(Integer.parseInt(idMovimiento));
                
                String fechaMov=movimientoProducto.getFechaMovimiento();
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date fechaM=dateFormat.parse(fechaMov);
                fechaMovimiento.setDate(fechaM);
                
                ArrayList <MovimientoItemProducto> ListadoMovimientoItemProducto = new ArrayList();
                ListadoMovimientoItemProducto = movimientoProducto.getMovimientoItemProducto();
                
                MovimientoItemProducto movimientoItemProducto1 = ListadoMovimientoItemProducto.get(0); //Nacional
                
                MovimientoItemProducto movimientoItemProducto2 = ListadoMovimientoItemProducto.get(1); //Extranjera
                
                MovimientoNumero=movimientoProducto.getId();
                MovimientoNo.setText("Movimiento No.  "+MovimientoNumero);
                
                ArrayList<Movimiento> listadoMovimientos =controlDB_Movimientos.consultarBodegas_Por_CP(""+movimientoItemProducto1.getIngresoProducto_id());     
                String [] titulo= {"CP","PRODUCTO","BODEGA","NIT_PROV.","NOMBRE_PROV.","FECHA_COMPRA","FECHA_MAX._EXPORT.","SALDO","CANTIDAD A MOVER"};
                String [] registro = new String[9]; 
                
                //ControlDB_Producto controlDB_Producto = new ControlDB_Producto();
                if(listadoMovimientos.get(0).getBodega_saldo()== movimientoItemProducto1.getSaldoActual()  && 
                        listadoMovimientos.get(1).getBodega_saldo()== movimientoItemProducto2.getSaldoActual()){
                    //JOptionPane.showMessageDialog(null, "Los saldos no han cambiado "+listadoMovimientos.get(0).getBodega_saldo()+"="+movimientoItemProducto1.getSaldoActual()+"\n"
                           // +  listadoMovimientos.get(1).getBodega_saldo()+"="+movimientoItemProducto2.getSaldoActual());
                    
                    saldoOriginalesBodegaExtranjera=listadoMovimientos.get(0).getBodega_saldo();
                    saldoOriginalesBodegaNacional=listadoMovimientos.get(1).getBodega_saldo();
                    
                    int saldoSumadoenExtranjera=(movimientoItemProducto1.getSaldoActual() +movimientoItemProducto2.getCantidadTrasladada()- movimientoItemProducto1.getCantidadTrasladada());
                    int saldoSumadoenNacional=(movimientoItemProducto2.getSaldoActual() +movimientoItemProducto1.getCantidadTrasladada()- movimientoItemProducto2.getCantidadTrasladada());
                    //Procedemos a cargar los Datos                   
                    modelo = new DefaultTableModel(null, titulo);
                    for(int i =0; i< listadoMovimientos.size(); i++){
                        numeroCp=""+listadoMovimientos.get(i).getIngresoProducto_cp();
                        registro[0]=""+listadoMovimientos.get(i).getIngresoProducto_cp();
                        registro[1]=""+listadoMovimientos.get(i).getProducto_descripcion();
                        registro[2]=""+listadoMovimientos.get(i).getBodega_Descripcion();
                        registro[3]=""+listadoMovimientos.get(i).getIngresoProducto_proveedor_nit();
                        ControlDB_Compra  controlDB_Compra = new ControlDB_Compra();
                        try{
                            Proveedor prov = controlDB_Compra.retornarProveedorIngresoProducto(listadoMovimientos.get(i).getIngresoProducto_cp());
                            if(prov != null){
                                registro[4]=""+prov.getNombre(); 
                            }else{
                                registro[4]="";//No aparecio Un proveedor 
                            }
                        }catch(Exception e){
                            JOptionPane.showMessageDialog(null, "No se pudo Cargar el proveedor x CP");
                        }
                        registro[5]=""+listadoMovimientos.get(i).getIngresoProducto_fechaCompra();
                        registro[6]=""+listadoMovimientos.get(i).getIngresoProducto_fechaMaximaExportacion();
                        if(i==0){
                            //registro[7]=""+listadoMovimientos.get(i).getBodega_saldo();
                            registro[7]=""+saldoSumadoenExtranjera;   
                        }else{
                            if(i==1){
                               registro[7]=""+saldoSumadoenNacional;    
                            }
                        }
                        if(i==0){
                            registro[8]=""+movimientoItemProducto2.getCantidadTrasladada();
                        }else{
                            if(i==1)
                            registro[8]=""+movimientoItemProducto1.getCantidadTrasladada();
                        }
                        modelo.addRow(registro);
                        Table_Movimiento_Bodega.setModel(modelo);  
                    }
                    Table_Movimiento_Bodega.setDefaultRenderer(Object.class, new Myrender(6));
                    VentanaBuscarDocumento.show(false);     
                }else{
                    /*JOptionPane.showMessageDialog(null, "Los saldos si han cambiado "+listadoMovimientos.get(0).getBodega_saldo()+"="+movimientoItemProducto1.getSaldoActual()+"\n"
                            +  listadoMovimientos.get(1).getBodega_saldo()+"="+movimientoItemProducto2.getSaldoActual());*/
                    JOptionPane.showMessageDialog(null, "Los saldos en las Bodegas han cambiado ya no se puede editar el movimiento ");
                }
                
                
            }
        }catch(Exception e){
        }   
        
    }//GEN-LAST:event_Seleccionar_MovimientoActionPerformed

    private void codigoDocumentoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codigoDocumentoKeyReleased
       
    }//GEN-LAST:event_codigoDocumentoKeyReleased

    private void codigoDocumentoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codigoDocumentoKeyTyped
       
    }//GEN-LAST:event_codigoDocumentoKeyTyped

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BuscarCompra;
    private javax.swing.JTable ListadoBusquedasDocumentos;
    private javax.swing.JLabel MovimientoNo;
    private javax.swing.JButton RegistrarMovimiento;
    private javax.swing.JMenuItem Seleccionar_Movimiento;
    private javax.swing.JPopupMenu Seleccionar_movimiento;
    private javax.swing.JTable Table_Movimiento_Bodega;
    private javax.swing.JInternalFrame VentanaBuscarDocumento;
    private javax.swing.JLabel alertaBuscarMovimiento;
    private javax.swing.JLabel alertaFechaMovimiento;
    private javax.swing.JButton botonBuscarDocumento;
    private javax.swing.JButton botonCancelarBusqueda;
    private javax.swing.JButton botonLimpiarBusqueda;
    private javax.swing.JTextField codigoDocumento;
    private com.toedter.calendar.JDateChooser fechaMovimiento;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel ventanaInterna_Nombre1;
    // End of variables declaration//GEN-END:variables

    public void BuscarEnVentanaInternaDocumentos(String valor) throws SQLException{
            DefaultTableModel modelo;
            String [] titulo= {"Id","Fecha_Mov","CP","Producto","bodegaOrigen","bodegaDestino","saldoAnterior","cantidadTrasladada","saldoActual","nombreQuienElabora"};
            String [] registro = new String[10]; 
            modelo = new DefaultTableModel(null, titulo);
            ControlDB_Movimientos_Anular controlDB_Movimientos= new ControlDB_Movimientos_Anular();
            ArrayList<MovimientoProducto> listadoMovimientoProducto =controlDB_Movimientos.consultarListadoMovimientoProducto(valor);
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
                modelo.addRow(registro);
                ListadoBusquedasDocumentos.setModel(modelo);  
            }
    }  
}
