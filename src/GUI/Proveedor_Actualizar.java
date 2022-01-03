/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Controladores.ControlDB_Otros;
import Controladores.ControlDB_Proveedor;
import Controladores.ControlDB_TipoProveedor;
import Modelos.Proveedor;
import Modelos.TipoProveedor;
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
public class Proveedor_Actualizar extends javax.swing.JPanel {
    ControlDB_Proveedor controladorProveedor = new ControlDB_Proveedor();
    Controladores.ControlDB_TipoProveedor controladorTipoProveedor = new ControlDB_TipoProveedor();
    DefaultTableModel modelo;
    String datos; 
    String [] titulo= {"NIT","SUCURSAL", "NOMBRE"};
    String [] registro;
    String accion="";
    //String nombreOriginal="";
    public Proveedor_Actualizar() {
        initComponents();
         //Cargamos en la interfaz los tipo de Proveedor
        ArrayList<TipoProveedor> listadoTipoProveedor = new ArrayList();
        listadoTipoProveedor=controladorTipoProveedor.cargarTipoProveedor();
        for(int i=0; i< listadoTipoProveedor.size(); i++){
            tipoProveedor.addItem(listadoTipoProveedor.get(i).getDescripcion());
        }        
        nit.setEnabled(false);
        digitoVerificacion.setEnabled(false);
        sucursal.setEnabled(false);
        nombre.setEnabled(false);
        resolucionFacturacion.setEnabled(false);
        fechaResolucion.setVisible(false);
        tipoProveedor.setEnabled(false);
        telefono.setEnabled(false);
        celular.setEnabled(false);
        direccion.setEnabled(false);
        correo.setEnabled(false);
        ciudad.setEnabled(false);
        observacion.setEnabled(false);
        estado.setEnabled(false);    
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Seleccionar = new javax.swing.JPopupMenu();
        Editar = new javax.swing.JMenuItem();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        codigoB = new javax.swing.JTextField();
        buscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table1 = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        actualizar = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();
        limpiar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        nit = new javax.swing.JTextField();
        digitoVerificacion = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        alertaNit = new javax.swing.JLabel();
        alertaNombre = new javax.swing.JLabel();
        nombre = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tipoProveedor = new javax.swing.JComboBox<>();
        telefono = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        celular = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        direccion = new javax.swing.JTextField();
        ciudad = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        estado = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        observacion = new javax.swing.JTextField();
        correo = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        AlertaResolucionFacturacion = new javax.swing.JLabel();
        AlertaFechaResolucion = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        resolucionFacturacion = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        fechaResolucion = new com.toedter.calendar.JDateChooser();
        jLabel19 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        sucursal = new javax.swing.JLabel();

        Editar.setText("Seleccionar");
        Editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarActionPerformed(evt);
            }
        });
        Seleccionar.add(Editar);

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 153, 153));
        jLabel7.setText("ACTUALIZAR PROVEEDORES");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 0, 440, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("BUSQUEDA POR CODIGO O NOMBRE:");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 270, 30));

        codigoB.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                codigoBKeyPressed(evt);
            }
        });
        add(codigoB, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 30, 250, 30));

        buscar.setBackground(new java.awt.Color(255, 255, 255));
        buscar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/Bodega_Actualizar_Bton_Buscar.PNG"))); // NOI18N
        buscar.setText("BUSCAR");
        buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarActionPerformed(evt);
            }
        });
        add(buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 20, 140, -1));

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
        Table1.setComponentPopupMenu(Seleccionar);
        Table1.setFocusable(false);
        Table1.setGridColor(new java.awt.Color(0, 204, 204));
        Table1.setSelectionBackground(new java.awt.Color(255, 102, 102));
        Table1.getTableHeader().setReorderingAllowed(false);
        Table1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Table1MouseClicked(evt);
            }
        });
        Table1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Table1KeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(Table1);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 110, 470, 340));
        add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 1210, -1));

        actualizar.setBackground(new java.awt.Color(255, 255, 255));
        actualizar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        actualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/Bodega_Actualizar_Bton_Actualizar.PNG"))); // NOI18N
        actualizar.setText("ACTUALIZAR ");
        actualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                actualizarMouseClicked(evt);
            }
        });
        actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizarActionPerformed(evt);
            }
        });
        add(actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 450, 170, 50));

        cancelar.setBackground(new java.awt.Color(255, 255, 255));
        cancelar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/Bodega_Actualizar_Bton_Cancelar.PNG"))); // NOI18N
        cancelar.setText("CANCELAR");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });
        add(cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 450, 170, 50));

        limpiar.setBackground(new java.awt.Color(255, 255, 255));
        limpiar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        limpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/Interfaz_Icon_Borrar.PNG"))); // NOI18N
        limpiar.setText("LIMPIAR");
        limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarActionPerformed(evt);
            }
        });
        add(limpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 20, 140, 40));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("NIT:");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 60, 30));

        nit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nitMouseClicked(evt);
            }
        });
        add(nit, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 150, 160, 30));

        digitoVerificacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                digitoVerificacionMouseClicked(evt);
            }
        });
        add(digitoVerificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 150, 50, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("-");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 150, 20, 30));

        alertaNit.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        alertaNit.setForeground(new java.awt.Color(255, 51, 51));
        add(alertaNit, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 180, 480, 30));

        alertaNombre.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        alertaNombre.setForeground(new java.awt.Color(255, 51, 51));
        add(alertaNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 180, 420, 30));

        nombre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nombreMouseClicked(evt);
            }
        });
        nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreActionPerformed(evt);
            }
        });
        add(nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 150, 220, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("TIPO PROVEEDOR:");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 130, 20));

        tipoProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tipoProveedorActionPerformed(evt);
            }
        });
        add(tipoProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, 230, 30));

        telefono.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                telefonoMouseClicked(evt);
            }
        });
        add(telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 270, 230, 30));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("TELEFONO:");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, 70, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("CELULAR:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 270, 90, 30));

        celular.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                celularMouseClicked(evt);
            }
        });
        add(celular, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 270, 220, 30));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("DIRECCION:");
        add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, 110, 30));

        direccion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                direccionMouseClicked(evt);
            }
        });
        add(direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 310, 230, 30));

        ciudad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ciudadMouseClicked(evt);
            }
        });
        add(ciudad, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 350, 230, 30));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("CIUDAD:");
        add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, 100, 30));

        estado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));
        add(estado, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 390, 200, 30));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("ESTADO:");
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 390, 120, 30));

        observacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                observacionMouseClicked(evt);
            }
        });
        add(observacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 350, 220, 30));

        correo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                correoMouseClicked(evt);
            }
        });
        add(correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 310, 220, 30));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("CORREO:");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 310, 70, 30));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setText("OBSERVACION:");
        add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 350, 120, 30));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setText("NOMBRE:");
        add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 150, 80, 30));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setText("RESOLUCIÓN:");
        add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 220, 90, 30));

        AlertaResolucionFacturacion.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        AlertaResolucionFacturacion.setForeground(new java.awt.Color(255, 51, 51));
        add(AlertaResolucionFacturacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 440, 30));

        AlertaFechaResolucion.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        AlertaFechaResolucion.setForeground(new java.awt.Color(255, 51, 51));
        add(AlertaFechaResolucion, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 240, 460, 30));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel18.setText("FACTURACIÓN:");
        add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 100, 60));

        resolucionFacturacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                resolucionFacturacionMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                resolucionFacturacionMouseEntered(evt);
            }
        });
        add(resolucionFacturacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 210, 230, 30));

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel20.setText("RESOLUCIÓN DE ");
        add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 120, 30));

        fechaResolucion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fechaResolucionMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                fechaResolucionMouseEntered(evt);
            }
        });
        add(fechaResolucion, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 210, 220, 30));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel19.setText("FECHA");
        add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 210, 90, 20));

        jLabel15.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DATOS", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Adobe Arabic", 1, 14))); // NOI18N
        add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 730, 420));

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel21.setText("SUCURSAL No.");
        add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 110, 100, 30));

        sucursal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        sucursal.setText("...");
        add(sucursal, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 110, 200, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed
        String valor=codigoB.getText();
        Table1.show();
        try {
            tabla(valor);
        } catch (SQLException ex) {
            Logger.getLogger(Proveedor_Actualizar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_buscarActionPerformed

    private void Table1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Table1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_Table1KeyPressed

    private void EditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarActionPerformed
        // TODO lo del clik derechoo
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
                String nitT=(String)modelo.getValueAt(fila1, 0);
                String sucursalT=(String)modelo.getValueAt(fila1, 1);
                //String nombreT=(String)modelo.getValueAt(fila1, 2);
                //nombreOriginal=(String)modelo.getValueAt(fila1, 2);
                Proveedor pro = new Proveedor();
                pro.setNit(nitT);
                pro.setSucursal(Integer.parseInt(sucursalT));
                //pro.setNombre(nombreT);
                consultarParaActualizar(pro);
                nit.setEnabled(false);
                digitoVerificacion.setEnabled(false);
                sucursal.setEnabled(false);
                nombre.setEnabled(true);
                resolucionFacturacion.setEnabled(true);
                fechaResolucion.setVisible(true);
                tipoProveedor.setEnabled(true);
                telefono.setEnabled(true);
                celular.setEnabled(true);
                direccion.setEnabled(true);
                correo.setEnabled(true);
                ciudad.setEnabled(true);
                observacion.setEnabled(true);
                estado.setEnabled(true);  
           }
        }catch(Exception e){
        }
    }//GEN-LAST:event_EditarActionPerformed

    private void actualizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_actualizarMouseClicked
         
    }//GEN-LAST:event_actualizarMouseClicked

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        //Limpiamos los campos
        nit.setText("");
        digitoVerificacion.setText("");
        sucursal.setText("");
        nombre.setText("");
        resolucionFacturacion.setText("");
        tipoProveedor.setSelectedIndex(0);
        telefono.setText("");
        celular.setText("");
        direccion.setText("");
        correo.setText("");
        ciudad.setText("");
        observacion.setText("");
        estado.setSelectedIndex(0);
        alertaNit.setText("");
        alertaNombre.setText("");
        
        //Deshabilitamos los JTextFiel
        nit.setEnabled(false);
        digitoVerificacion.setEnabled(false);
        sucursal.setEnabled(false);
        nombre.setEnabled(false);
        resolucionFacturacion.setEnabled(false);
        fechaResolucion.setVisible(false);
        tipoProveedor.setEnabled(false);
        telefono.setEnabled(false);
        celular.setEnabled(false);
        direccion.setEnabled(false);
        correo.setEnabled(false);
        ciudad.setEnabled(false);
        observacion.setEnabled(false);
        estado.setEnabled(false);    
    }//GEN-LAST:event_cancelarActionPerformed

    private void limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarActionPerformed
        codigoB.setText("");
    }//GEN-LAST:event_limpiarActionPerformed

    private void nitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nitMouseClicked
        alertaNit.setText("");
    }//GEN-LAST:event_nitMouseClicked

    private void digitoVerificacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_digitoVerificacionMouseClicked
        alertaNit.setText("");
    }//GEN-LAST:event_digitoVerificacionMouseClicked

    private void nombreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nombreMouseClicked
        alertaNombre.setText("");
    }//GEN-LAST:event_nombreMouseClicked

    private void telefonoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_telefonoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_telefonoMouseClicked

    private void celularMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_celularMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_celularMouseClicked

    private void direccionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_direccionMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_direccionMouseClicked

    private void ciudadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ciudadMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_ciudadMouseClicked

    private void observacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_observacionMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_observacionMouseClicked

    private void correoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_correoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_correoMouseClicked

    private void actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizarActionPerformed
       if(nit.getText().equals("")){
            alertaNit.setText("Error el Nit no Puede estar vacio");
        }else{
            if(digitoVerificacion.getText().equals("")){
                alertaNit.setText("Error el Digito de Verificacion no Puede estar vacio");
            }else{
                if(nombre.getText().equals("")){
                    alertaNombre.setText("Error el Nombre no Puede estar vacio");
                }else{
                    if(resolucionFacturacion.getText().equals("")){
                        alertaNombre.setText("Error la fecha de resolución No Puede estar vacia");
                    }else{
                         try{
                            Calendar fecha = fechaResolucion.getCalendar();
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
                            String fechaResolucionP=ano+"-"+mes+"-"+dia;
                            //JOptionPane.showMessageDialog(null,fechaResolucionP);
                                try{
                                    new java.math.BigDecimal(nit.getText());
                                    //Integer.parseInt(digitoVerificacion.getText());
                                    Controladores.ControlDB_Proveedor ControlDB_Proveedor = new ControlDB_Proveedor();
                                    Controladores.ControlDB_TipoProveedor ControlTipoProveedor = new ControlDB_TipoProveedor();
                                    Controladores.ControlDB_Otros controlDB_Otros = new ControlDB_Otros();
                                    Proveedor p = new Proveedor();
                                    p.setNit(nit.getText());
                                    p.setDigitoVerificacion(digitoVerificacion.getText());
                                    p.setSucursal(Integer.parseInt(sucursal.getText()));
                                    p.setNombre(nombre.getText());
                                    p.setResolucionFacturacion(resolucionFacturacion.getText());
                                    p.setFechaResolucion(fechaResolucionP);
                                    p.setTipoProveedor_id(ControlTipoProveedor.validarTipoProveedor_ID_por_Nombre(tipoProveedor.getSelectedItem().toString()));
                                    p.setTelefono(telefono.getText());
                                    p.setCelular(celular.getText());
                                    p.setDireccion(direccion.getText());
                                    p.setCorreo(correo.getText());
                                    p.setCiudad(ciudad.getText());
                                    p.setObservacion(observacion.getText());
                                    p.setEstado(controlDB_Otros.convertidorValorEstado(estado.getSelectedIndex()));
                                    int result=0;
                                    result=ControlDB_Proveedor.actualizarProveedor(p);
                                    if(result==1){
                                        JOptionPane.showMessageDialog(null, "Actualización Exitosa");
                                        nit.setText("");
                                        digitoVerificacion.setText("");
                                        sucursal.setText("");
                                        nombre.setText("");
                                        resolucionFacturacion.setText("");
                                        tipoProveedor.setSelectedIndex(0);
                                        telefono.setText("");
                                        celular.setText("");
                                        direccion.setText("");
                                        correo.setText("");
                                        ciudad.setText("");
                                        observacion.setText("");
                                        estado.setSelectedIndex(0);
                                        alertaNit.setText("");
                                        alertaNombre.setText(""); 
                                        AlertaResolucionFacturacion.setText("");
                                        AlertaFechaResolucion.setText("");
                                        //Cargamos esa actualizacion en la tabla
                                        String valor="";
                                        Table1.show();
                                        tabla(valor);//#########################
                                    }else{
                                        JOptionPane.showMessageDialog(null, "Error al querer actualizar los datos", "Error al actualizar", JOptionPane.INFORMATION_MESSAGE);
                                    }
                                }catch(Exception e){
                                   alertaNit.setText("Error verifique Nit, debe ser Númerico");
                                }
                            }catch(Exception e){
                            AlertaFechaResolucion.setText("ERROR verifique la fecha");
                        }
                    }
                }
            }
        } 
    }//GEN-LAST:event_actualizarActionPerformed

    private void resolucionFacturacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resolucionFacturacionMouseClicked
        AlertaResolucionFacturacion.setText("");
        AlertaFechaResolucion.setText("");
    }//GEN-LAST:event_resolucionFacturacionMouseClicked

    private void fechaResolucionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fechaResolucionMouseClicked
        AlertaResolucionFacturacion.setText("");
        AlertaFechaResolucion.setText("");
    }//GEN-LAST:event_fechaResolucionMouseClicked

    private void fechaResolucionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fechaResolucionMouseEntered
        AlertaResolucionFacturacion.setText("");
        AlertaFechaResolucion.setText("");
    }//GEN-LAST:event_fechaResolucionMouseEntered

    private void resolucionFacturacionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resolucionFacturacionMouseEntered
        AlertaResolucionFacturacion.setText("");
        AlertaFechaResolucion.setText("");
    }//GEN-LAST:event_resolucionFacturacionMouseEntered

    private void tipoProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipoProveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tipoProveedorActionPerformed

    private void codigoBKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codigoBKeyPressed
        String valor=codigoB.getText();
        Table1.show();
        try {
            tabla(valor);
        } catch (SQLException ex) {
            Logger.getLogger(Compra_Registrar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_codigoBKeyPressed

    private void nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreActionPerformed

    private void Table1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Table1MouseClicked
        if (evt.getClickCount() == 2) {
            // TODO lo del clik derechoo
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
                    String nitT=(String)modelo.getValueAt(fila1, 0);
                    String sucursalT=(String)modelo.getValueAt(fila1, 1);
                    //String nombreT=(String)modelo.getValueAt(fila1, 2);
                    //nombreOriginal=(String)modelo.getValueAt(fila1, 2);
                    Proveedor pro = new Proveedor();
                    pro.setNit(nitT);
                    pro.setSucursal(Integer.parseInt(sucursalT));
                    //pro.setNombre(nombreT);
                    consultarParaActualizar(pro);
                    nit.setEnabled(false);
                    digitoVerificacion.setEnabled(false);
                    sucursal.setEnabled(false);
                    nombre.setEnabled(true);
                    resolucionFacturacion.setEnabled(true);
                    fechaResolucion.setVisible(true);
                    tipoProveedor.setEnabled(true);
                    telefono.setEnabled(true);
                    celular.setEnabled(true);
                    direccion.setEnabled(true);
                    correo.setEnabled(true);
                    ciudad.setEnabled(true);
                    observacion.setEnabled(true);
                    estado.setEnabled(true);  
               }
            }catch(Exception e){
            }
        }
    }//GEN-LAST:event_Table1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AlertaFechaResolucion;
    private javax.swing.JLabel AlertaResolucionFacturacion;
    private javax.swing.JMenuItem Editar;
    private javax.swing.JPopupMenu Seleccionar;
    private javax.swing.JTable Table1;
    private javax.swing.JButton actualizar;
    private javax.swing.JLabel alertaNit;
    private javax.swing.JLabel alertaNombre;
    private javax.swing.JButton buscar;
    private javax.swing.JButton cancelar;
    private javax.swing.JTextField celular;
    private javax.swing.JTextField ciudad;
    private javax.swing.JTextField codigoB;
    private javax.swing.JTextField correo;
    private javax.swing.JTextField digitoVerificacion;
    private javax.swing.JTextField direccion;
    private javax.swing.JComboBox<String> estado;
    private com.toedter.calendar.JDateChooser fechaResolucion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton limpiar;
    private javax.swing.JTextField nit;
    private javax.swing.JTextField nombre;
    private javax.swing.JTextField observacion;
    private javax.swing.JTextField resolucionFacturacion;
    private javax.swing.JLabel sucursal;
    private javax.swing.JTextField telefono;
    private javax.swing.JComboBox<String> tipoProveedor;
    // End of variables declaration//GEN-END:variables
    public void tabla(String valorConsulta) throws SQLException{
        registro = new String[3]; 
        modelo = new DefaultTableModel(null, titulo);
        ControlDB_Proveedor p = new ControlDB_Proveedor();
        ArrayList<Proveedor> listadoProveedor=p.buscarProveedor(valorConsulta);
        for(int i =0; i< listadoProveedor.size(); i++){
            registro[0]=""+listadoProveedor.get(i).getNit();
            registro[1]=""+listadoProveedor.get(i).getSucursal();
            registro[2]=""+listadoProveedor.get(i).getNombre();
            modelo.addRow(registro);
            Table1.setModel(modelo);
        }
    }
    public void consultarParaActualizar (Proveedor p) throws SQLException{
        ControlDB_Proveedor c = new ControlDB_Proveedor();
        ArrayList<Proveedor> listadoProveedor=c.consultarUnicoProveedor(p);
        for(int i =0; i< listadoProveedor.size(); i++){ 
            nit.setText(listadoProveedor.get(i).getNit());
            digitoVerificacion.setText(""+listadoProveedor.get(i).getDigitoVerificacion());
            sucursal.setText(""+listadoProveedor.get(i).getSucursal());
            nombre.setText(listadoProveedor.get(i).getNombre());
            resolucionFacturacion.setText(""+listadoProveedor.get(i).getResolucionFacturacion());                    
            SimpleDateFormat formatoDeltexto = new SimpleDateFormat("yyyy-MM-dd");
            String strFecha= (listadoProveedor.get(i).getFechaResolucion());
            Date fecha = null;
            try{
                fecha = formatoDeltexto.parse(strFecha);
                fechaResolucion.setDate(fecha);
                tipoProveedor.setSelectedIndex(listadoProveedor.get(i).getTipoProveedor_id()-1);
                telefono.setText(listadoProveedor.get(i).getTelefono());
                celular.setText(listadoProveedor.get(i).getCelular());
                direccion.setText(listadoProveedor.get(i).getDireccion());
                correo.setText(listadoProveedor.get(i).getCorreo());
                ciudad.setText(listadoProveedor.get(i).getCiudad());
                observacion.setText(listadoProveedor.get(i).getObservacion());

                ControlDB_Otros controlOtros = new ControlDB_Otros();
                estado.setSelectedItem(controlOtros.convertidorEstadoID_x_Nombre(listadoProveedor.get(i).getEstado()));   
            }catch(ParseException ex){
                JOptionPane.showMessageDialog(null, "Error al cargar la fecha");
            }
        }                  
    }
}
