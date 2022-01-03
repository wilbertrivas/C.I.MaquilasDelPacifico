package GUI;

import Controladores.ControlDB_Movimientos_Camarones;
import Controladores.ControlDB_Producto;
import Controladores.ControlDB_Compra;
import Controladores.ControlDB_Movimientos_Cajas;
import Modelos.IngresoProducto;
import Modelos.Movimiento;
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

public class Movimientos_Registrar_Camarones extends javax.swing.JPanel {
    String valor="";
    String accion="";
    Usuario user;
    String []tituloCP= {"CP","PRODUCTO","BODEGA","NOMBRE_PROV.","FECHA_COMPRA","FECHA_MAX._EXPORT.","SALDO","CANTIDAD A VENDER"};
    String [] registroCP;
    DefaultTableModel modeloCP;
    int facturaVentaNumero=0;
    int MovimientoNumero=0;
    
    
    public Movimientos_Registrar_Camarones(Usuario u) {
        user= u;
        initComponents();
        VentanaInternaVentas.show(false);
        //Formato de la tabla en la que se cargan los CP
        registroCP= new String[8]; 
        modeloCP = new DefaultTableModel(null, tituloCP);
        Table_Movimiento_Bodega.setModel(modeloCP);     
        
          //#########################################################
        ControlDB_Movimientos_Camarones controlDB_Movimientos_Camarones = new ControlDB_Movimientos_Camarones();
        try{
            MovimientoNumero=controlDB_Movimientos_Camarones.retornarElMaximo();
            MovimientoNumero++;
            MovimientoNo.setText("Movimiento No.  "+MovimientoNumero);
        }catch(Exception e){
            MovimientoNumero++;
            MovimientoNo.setText("Movimiento No.  "+MovimientoNumero);
        }   
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Seleccionar = new javax.swing.JPopupMenu();
        Editar = new javax.swing.JMenuItem();
        Eliminar = new javax.swing.JPopupMenu();
        EliminarCP = new javax.swing.JMenuItem();
        VentanaInternaVentas = new javax.swing.JInternalFrame();
        valorConsulta = new javax.swing.JTextField();
        ventanaInterna_Nombre = new javax.swing.JLabel();
        limpiar1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        ListadoBusquedasCP = new javax.swing.JTable();
        buscar = new javax.swing.JButton();
        cancelar1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        Label_CargarCP = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        Table_Movimiento_Bodega = new javax.swing.JTable();
        RegistrarMovimiento = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        fechaMovimiento = new com.toedter.calendar.JDateChooser();
        alertaFechaMovimiento = new javax.swing.JLabel();
        MovimientoNo = new javax.swing.JLabel();

        Editar.setText("Seleccionar");
        Editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarActionPerformed(evt);
            }
        });
        Seleccionar.add(Editar);

        EliminarCP.setText("EliminarCP");
        EliminarCP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarCPActionPerformed(evt);
            }
        });
        Eliminar.add(EliminarCP);

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        VentanaInternaVentas.setBackground(new java.awt.Color(255, 255, 255));
        VentanaInternaVentas.setTitle("LISTADO DE CP ACTIVOS");
        VentanaInternaVentas.setVisible(true);
        VentanaInternaVentas.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        valorConsulta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                valorConsultaKeyPressed(evt);
            }
        });
        VentanaInternaVentas.getContentPane().add(valorConsulta, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 250, 30));

        ventanaInterna_Nombre.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        ventanaInterna_Nombre.setForeground(new java.awt.Color(0, 153, 153));
        ventanaInterna_Nombre.setText("Buscar CP");
        VentanaInternaVentas.getContentPane().add(ventanaInterna_Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 210, -1));

        limpiar1.setBackground(new java.awt.Color(255, 255, 255));
        limpiar1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        limpiar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/Interfaz_Icon_Borrar.PNG"))); // NOI18N
        limpiar1.setText("LIMPIAR");
        limpiar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiar1ActionPerformed(evt);
            }
        });
        VentanaInternaVentas.getContentPane().add(limpiar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, 140, 40));

        ListadoBusquedasCP = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        ListadoBusquedasCP.setBackground(new java.awt.Color(153, 204, 255));
        ListadoBusquedasCP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        ListadoBusquedasCP.setComponentPopupMenu(Seleccionar);
        ListadoBusquedasCP.setFocusable(false);
        ListadoBusquedasCP.setGridColor(new java.awt.Color(0, 204, 204));
        ListadoBusquedasCP.setSelectionBackground(new java.awt.Color(255, 102, 102));
        ListadoBusquedasCP.getTableHeader().setReorderingAllowed(false);
        ListadoBusquedasCP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ListadoBusquedasCPKeyPressed(evt);
            }
        });
        jScrollPane3.setViewportView(ListadoBusquedasCP);

        VentanaInternaVentas.getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 1060, 220));

        buscar.setBackground(new java.awt.Color(255, 255, 255));
        buscar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/Bodega_Actualizar_Bton_Buscar.PNG"))); // NOI18N
        buscar.setText("BUSCAR");
        buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarActionPerformed(evt);
            }
        });
        VentanaInternaVentas.getContentPane().add(buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 140, -1));

        cancelar1.setBackground(new java.awt.Color(255, 255, 255));
        cancelar1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cancelar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/Bodega_Actualizar_Bton_Cancelar.PNG"))); // NOI18N
        cancelar1.setText("CANCELAR");
        cancelar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelar1ActionPerformed(evt);
            }
        });
        VentanaInternaVentas.getContentPane().add(cancelar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 90, 160, 40));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/fondo.png"))); // NOI18N
        VentanaInternaVentas.getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1110, 380));

        add(VentanaInternaVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 30, 1110, 370));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 102, 102));
        jLabel9.setText("MOVIMIENTO DE CAMARONES EN BODEGA");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 0, 430, 30));

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel20.setText("CARGAR CP");
        jLabel20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel20MouseClicked(evt);
            }
        });
        add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 80, 30));

        Label_CargarCP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/Compra_Agregar_Proveedor.png"))); // NOI18N
        Label_CargarCP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Label_CargarCPMouseClicked(evt);
            }
        });
        add(Label_CargarCP, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 70, 70));

        Table_Movimiento_Bodega = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                if (colIndex == 8){
                    return true;
                }else{
                    return false;
                }
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
        Table_Movimiento_Bodega.setComponentPopupMenu(Eliminar);
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

        add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 1090, 100));

        RegistrarMovimiento.setBackground(new java.awt.Color(255, 255, 255));
        RegistrarMovimiento.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        RegistrarMovimiento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/Bodega_Registrar_Bton_Registrar.PNG"))); // NOI18N
        RegistrarMovimiento.setText("REGISTRAR MOVIMIENTO");
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
        add(RegistrarMovimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 240, 60));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("FECHA DE MOVIMIENTO");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, 160, 20));

        fechaMovimiento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fechaMovimientoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                fechaMovimientoMouseEntered(evt);
            }
        });
        add(fechaMovimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 150, 160, 30));

        alertaFechaMovimiento.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        alertaFechaMovimiento.setForeground(new java.awt.Color(255, 51, 51));
        add(alertaFechaMovimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 1090, 30));

        MovimientoNo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        MovimientoNo.setText("Movimiento No.");
        add(MovimientoNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 260, 20));
    }// </editor-fold>//GEN-END:initComponents

    private void Label_CargarCPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Label_CargarCPMouseClicked
        //Eliminamos la Busqueda Actual#######################################################
        DefaultTableModel md =(DefaultTableModel)ListadoBusquedasCP.getModel();
        int CantEliminar= ListadoBusquedasCP.getRowCount() -1;
        for(int i =CantEliminar; i>=0; i--){
           md.removeRow(i);
        }
        DefaultTableModel modelo;
        String [] titulo= {"CP","PRODUCTO","BODEGA","CANT. INICIAL","SALDO", "FECHA_COMPRA", "FECHA. MAX. EXPORTACIÓN", "NOMBRE_PROVEEDOR"};
        String [] registro = new String[8]; 
        modelo = new DefaultTableModel(null, titulo);
        ListadoBusquedasCP.setModel(modelo); 
        //###################################################################################
        VentanaInternaVentas.show(true);
        CargarVentanaInterna(2);
        
         //#########################################################
        ControlDB_Movimientos_Cajas controlDB_Movimientos_Cajas = new ControlDB_Movimientos_Cajas();
        try{
            MovimientoNumero=controlDB_Movimientos_Cajas.retornarElMaximo();
            MovimientoNumero++;
            MovimientoNo.setText("Movimiento No.  "+MovimientoNumero);
        }catch(Exception e){
            MovimientoNumero++;
            MovimientoNo.setText("Factura de Venta No.  "+MovimientoNumero);
        }       
    }//GEN-LAST:event_Label_CargarCPMouseClicked

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
                ControlDB_Movimientos_Camarones  controlDB_Movimientos_Camarones = new ControlDB_Movimientos_Camarones();
                if(controlDB_Movimientos_Camarones.validarSaldosBodegasMovimientos(CP,saldoBodegaExtranjeraActual,saldoBodegaNacionalActual)){    
                    int result= controlDB_Movimientos_Camarones.registrarMovimiento( fechaMovimiento, CP, saldoBodegaExtranjeraModificado, saldoBodegaNacionalModificado,user, saldoExtranjeraTraslado, saldoNacionalTrasladado,saldoBodegaExtranjeraActual, saldoBodegaNacionalActual);
                    if(result ==6){
                        JOptionPane.showMessageDialog(null, "Movimiento para CP "+CP+ " Registrado con Exito");//Registro Exitoso

                        //Actualizamos el nuevo valor en la tabla
                        DefaultTableModel modelo;
                        ArrayList<Movimiento> listadoMovimientos=null;     
                        try {
                            listadoMovimientos = controlDB_Movimientos_Camarones.consultarBodegas_Por_CP(controlDB_Movimientos_Camarones.retornarId_IngresoProducto(CP));
                        } catch (SQLException ex) {
                            Logger.getLogger(Movimientos_Registrar_Cajas.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        String [] titulo= {"CP","PRODUCTO","BODEGA","NIT_PROV.","NOMBRE_PROV.","FECHA_COMPRA","FECHA_MAX._EXPORT.","SALDO","CANTIDAD A MOVER"};
                        String [] registro = new String[9]; 
                        modelo = new DefaultTableModel(null, titulo);
                        for(int i =0; i< listadoMovimientos.size(); i++){
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
                            registro[7]=""+listadoMovimientos.get(i).getBodega_saldo();
                            registro[8]="0";
                            modelo.addRow(registro);
                            Table_Movimiento_Bodega.setModel(modelo);  
                        }
                         //Autoincrementamos valor de Movimiento
                            try{
                                MovimientoNumero=controlDB_Movimientos_Camarones.retornarElMaximo();
                                MovimientoNumero++;
                                MovimientoNo.setText("Movimiento No.  "+MovimientoNumero);
                            }catch(Exception e){
                                MovimientoNumero++;
                                MovimientoNo.setText("Movimiento No.  "+MovimientoNumero);
                            }  

                        ControlDB_Movimientos_Camarones controlDB_MovimientosT = new ControlDB_Movimientos_Camarones();
                        Generar_Reportes generarReportes = new Generar_Reportes();
                        generarReportes.generar_Movimientos(controlDB_MovimientosT.retornarElMaximo());
                        //Table_Movimiento_Bodega.setDefaultRenderer(Object.class, new Myrender_VentasRegistrarExtranjera(6));
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Los saldos han cambiado ya no se puede registrar el Movimiento, cargue el CP y realice el proceso de nuevo");
                }
            }
        }catch(Exception e){
            alertaFechaMovimiento.setText("ERROR verifique la fecha");
        }
    }//GEN-LAST:event_RegistrarMovimientoActionPerformed

    private void valorConsultaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_valorConsultaKeyPressed
       try {
            BuscarEnVentanaInterna();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al Buscar");
        }
    }//GEN-LAST:event_valorConsultaKeyPressed

    private void limpiar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiar1ActionPerformed
        valorConsulta.setText("");
    }//GEN-LAST:event_limpiar1ActionPerformed

    private void ListadoBusquedasCPKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ListadoBusquedasCPKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_ListadoBusquedasCPKeyPressed

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed
        try {
            BuscarEnVentanaInterna();
        } catch (SQLException ex) {
            Logger.getLogger(Movimientos_Registrar_Camarones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_buscarActionPerformed

    private void cancelar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelar1ActionPerformed
        VentanaInternaVentas.show(false);
    }//GEN-LAST:event_cancelar1ActionPerformed

    private void EditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarActionPerformed
        // TODO lo del clik derechoo
        DefaultTableModel modelo;
        int fila1;
        try{
            fila1=ListadoBusquedasCP.getSelectedRow();
            if(fila1==-1){
                JOptionPane.showMessageDialog(null,"no se ha seleccionando ninguna fila");
            }
            else{
                accion="modificar";
                modelo=(DefaultTableModel)ListadoBusquedasCP.getModel();
                String idIngresoProducto = (String)modelo.getValueAt(fila1, 0);
                ControlDB_Movimientos_Camarones controlDB_Movimientos= new ControlDB_Movimientos_Camarones();
                ArrayList<Movimiento> listadoMovimientos =controlDB_Movimientos.consultarBodegas_Por_CP(idIngresoProducto);     
                String [] titulo= {"CP","PRODUCTO","BODEGA","NIT_PROV.","NOMBRE_PROV.","FECHA_COMPRA","FECHA_MAX._EXPORT.","SALDO","CANTIDAD A MOVER"};
                String [] registro = new String[9]; 
                ControlDB_Producto controlDB_Producto = new ControlDB_Producto();
                modelo = new DefaultTableModel(null, titulo);
                for(int i =0; i< listadoMovimientos.size(); i++){
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
                    registro[7]=""+listadoMovimientos.get(i).getBodega_saldo();
                    registro[8]="0";
                    modelo.addRow(registro);
                    Table_Movimiento_Bodega.setModel(modelo);  
                }
                Table_Movimiento_Bodega.setDefaultRenderer(Object.class, new Myrender(6));
                VentanaInternaVentas.show(false);
            }
        }catch(Exception e){
        }   
    }//GEN-LAST:event_EditarActionPerformed

    private void jLabel20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseClicked
     
    }//GEN-LAST:event_jLabel20MouseClicked

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

    private void EliminarCPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarCPActionPerformed
           
    }//GEN-LAST:event_EliminarCPActionPerformed

    private void fechaMovimientoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fechaMovimientoMouseClicked
        alertaFechaMovimiento.setText("");
    }//GEN-LAST:event_fechaMovimientoMouseClicked

    private void fechaMovimientoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fechaMovimientoMouseEntered
        alertaFechaMovimiento.setText("");
    }//GEN-LAST:event_fechaMovimientoMouseEntered

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Editar;
    private javax.swing.JPopupMenu Eliminar;
    private javax.swing.JMenuItem EliminarCP;
    private javax.swing.JLabel Label_CargarCP;
    private javax.swing.JTable ListadoBusquedasCP;
    private javax.swing.JLabel MovimientoNo;
    private javax.swing.JButton RegistrarMovimiento;
    private javax.swing.JPopupMenu Seleccionar;
    private javax.swing.JTable Table_Movimiento_Bodega;
    private javax.swing.JInternalFrame VentanaInternaVentas;
    private javax.swing.JLabel alertaFechaMovimiento;
    private javax.swing.JButton buscar;
    private javax.swing.JButton cancelar1;
    private com.toedter.calendar.JDateChooser fechaMovimiento;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JButton limpiar1;
    private javax.swing.JTextField valorConsulta;
    private javax.swing.JLabel ventanaInterna_Nombre;
    // End of variables declaration//GEN-END:variables
 
    public void BuscarEnVentanaInterna() throws SQLException{
            DefaultTableModel modelo;
            String [] titulo= {"ID","CP","NIT_PROVEEDOR","NOMBRE_PROVEEDOR","FECHA_COMPRA","FECHA. MAX. EXPORTACIÓN","CANT. INICIAL"};
            String [] registro = new String[7]; 
            modelo = new DefaultTableModel(null, titulo);
            ControlDB_Movimientos_Camarones controlDB_Movimientos= new ControlDB_Movimientos_Camarones();
            ArrayList<IngresoProducto> listadoCp =controlDB_Movimientos.ingresoProducto_ConsultarCP(valorConsulta.getText());
            for(int i =0; i< listadoCp.size(); i++){
                registro[0]=""+listadoCp.get(i).getId();
                registro[1]=""+listadoCp.get(i).getCp();
                registro[2]=""+listadoCp.get(i).getProveedor_nit();
                ControlDB_Compra  controlDB_Compra = new ControlDB_Compra();
                try{
                    Proveedor prov = controlDB_Compra.retornarProveedorIngresoProducto(listadoCp.get(i).getCp());
                    if(prov != null){
                        registro[3]=""+prov.getNombre(); 
                    }else{
                        registro[3]="";//No aparecio Un proveedor 
                    }
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, "No se pudo Cargar el proveedor x CP");
                }
                registro[4]=""+listadoCp.get(i).getFechaCompra();
                registro[5]=""+listadoCp.get(i).getFechaMaximaExportacion();
                registro[6]=""+listadoCp.get(i).getCantidadInicial();
                modelo.addRow(registro);
                ListadoBusquedasCP.setModel(modelo);  
            }
            ListadoBusquedasCP.setDefaultRenderer(Object.class, new Myrender(5));
    }  
    public void CargarVentanaInterna(int n){
        switch(n){
            case 1:{//Cargamos la ventana Interna para Buscar Clientes
                VentanaInternaVentas.show(true);
                VentanaInternaVentas.setTitle("Listado De Clientes");
                ventanaInterna_Nombre.setText("Buscar Cliente");
                TextPrompt placeholder = new TextPrompt("Buscar por Nit o Nombre:", valorConsulta);
                valor="Clientes";
                break;
            }
            case 2:{//Cargamos la ventana Interna para Buscar CP
                VentanaInternaVentas.show(true);
                VentanaInternaVentas.setTitle("Listado De CP");
                ventanaInterna_Nombre.setText("Buscar CP");
                TextPrompt placeholder = new TextPrompt("Buscar por Nit o Nombre:", valorConsulta);
                valor="CP";            
                break;
            }
        }     
    }
    public boolean validarCPcargadoEncarrito(String cp){
        boolean retorno =false;
        int filas = Table_Movimiento_Bodega.getRowCount();
        DefaultTableModel modeloX=(DefaultTableModel)Table_Movimiento_Bodega.getModel();
        for(int i=0; i< filas; i++){
            String data=(String)modeloX.getValueAt(i, 0);
            if(data.equals(cp)){
                retorno=true;
            }
        }
        return retorno;
    }
    public boolean validarQueCargueAlmenosUnCP(){
        boolean retorno =true;
        int filas = Table_Movimiento_Bodega.getRowCount();
        DefaultTableModel modeloX=(DefaultTableModel)Table_Movimiento_Bodega.getModel();
        for(int i=0; i< filas; i++){
            retorno=false;
        }
        return retorno;
    }
    public boolean validarEnCPCargadosCantidadAVenderSeaMayorACero(){
        boolean retorno =false;
        int filas = Table_Movimiento_Bodega.getRowCount();
        DefaultTableModel modeloX=(DefaultTableModel)Table_Movimiento_Bodega.getModel();
        for(int i=0; i< filas; i++){
            String data=(String)modeloX.getValueAt(i, 8);
            if(data.compareTo("0")<= 0){
                retorno=true;
            }
        }
        return retorno;
    }
    public boolean Validar_Si_CP_EstaVencido(String fechaMaximaExportacion) throws ParseException{
        Date fechaActual = new Date(); 
        String  Fecha =new SimpleDateFormat("yyyy-MM-dd").format(fechaActual);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaHoy=dateFormat.parse(Fecha);
        Date fechaDevo=dateFormat.parse(fechaMaximaExportacion);
        int diasAtraso=(int) ((fechaDevo.getTime() -fechaHoy.getTime())/86400000);
        if(diasAtraso >= 61){
            return false;
        }else{
            if(diasAtraso >= 31 && diasAtraso <= 60){
                return false;
            }else{
                return true;
            }
        }        
    }
}
