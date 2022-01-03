/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Controladores.ControlDB_Cliente;
import Controladores.ControlDB_Otros;
import Controladores.ControlDB_TipoCliente;
import Modelos.Cliente;
import Modelos.TipoCliente;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class Cliente_Actualizar extends javax.swing.JPanel {
    Controladores.ControlDB_Cliente controladorCliente = new ControlDB_Cliente();
    Controladores.ControlDB_TipoCliente controladorTipoCliente = new ControlDB_TipoCliente();
    DefaultTableModel modelo;
    String datos; 
    String [] titulo= {"NIT","SUCURSAL", "NOMBRE"};
    String [] registro;
    String accion="";
    String nombreOriginal="";
    public Cliente_Actualizar(){
        initComponents();  
         //Cargamos en la interfaz los tipo de Cliente
        ArrayList<TipoCliente> listadoTipoCliente = new ArrayList();
        listadoTipoCliente=controladorTipoCliente.cargarTipoClientes();
        for(int i=0; i< listadoTipoCliente.size(); i++){
            tipoCliente.addItem(listadoTipoCliente.get(i).getDescripcion());
        }
        nit.setEnabled(false);
        digitoVerificacion.setEnabled(false);
        sucursal.setEnabled(false);
        nombre.setEnabled(false);
        tipoCliente.setEnabled(false);
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
        tipoCliente = new javax.swing.JComboBox<>();
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
        sucursal = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();

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
        jLabel7.setText("ACTUALIZAR CLIENTES");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, 440, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("BUSQUEDA POR CODIGO O NOMBRE:");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 270, 30));

        codigoB.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                codigoBKeyPressed(evt);
            }
        });
        add(codigoB, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 40, 250, 30));

        buscar.setBackground(new java.awt.Color(255, 255, 255));
        buscar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/Bodega_Actualizar_Bton_Buscar.PNG"))); // NOI18N
        buscar.setText("BUSCAR");
        buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarActionPerformed(evt);
            }
        });
        add(buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 30, 140, -1));

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

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 90, 450, 330));
        add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 1120, 10));

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
        add(actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 390, 170, 50));

        cancelar.setBackground(new java.awt.Color(255, 255, 255));
        cancelar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/Bodega_Actualizar_Bton_Cancelar.PNG"))); // NOI18N
        cancelar.setText("CANCELAR");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });
        add(cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 390, 170, 50));

        limpiar.setBackground(new java.awt.Color(255, 255, 255));
        limpiar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        limpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/Interfaz_Icon_Borrar.PNG"))); // NOI18N
        limpiar.setText("LIMPIAR");
        limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarActionPerformed(evt);
            }
        });
        add(limpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 30, 140, 40));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("NIT:");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 40, 30));

        nit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nitMouseClicked(evt);
            }
        });
        add(nit, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 160, 200, 30));

        digitoVerificacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                digitoVerificacionMouseClicked(evt);
            }
        });
        add(digitoVerificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 160, 40, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("-");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 160, 20, 30));

        alertaNit.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        alertaNit.setForeground(new java.awt.Color(255, 51, 51));
        add(alertaNit, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 190, 440, 30));

        alertaNombre.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        alertaNombre.setForeground(new java.awt.Color(255, 51, 51));
        add(alertaNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 190, 420, 30));

        nombre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nombreMouseClicked(evt);
            }
        });
        add(nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 160, 320, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("TIPO CLIENTE:");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 100, 20));

        add(tipoCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, 250, 30));

        telefono.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                telefonoMouseClicked(evt);
            }
        });
        add(telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 220, 320, 30));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("TELEFONO:");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 220, 70, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("CELULAR:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 120, 30));

        celular.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                celularMouseClicked(evt);
            }
        });
        add(celular, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 220, 250, 30));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("DIRECCION:");
        add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 260, 80, 30));

        direccion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                direccionMouseClicked(evt);
            }
        });
        add(direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 260, 320, 30));

        ciudad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ciudadMouseClicked(evt);
            }
        });
        add(ciudad, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 300, 320, 30));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("CIUDAD:");
        add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 300, 70, 30));

        estado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));
        add(estado, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 340, 250, 30));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("ESTADO:");
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 120, 30));

        observacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                observacionMouseClicked(evt);
            }
        });
        add(observacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 300, 250, 30));

        correo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                correoMouseClicked(evt);
            }
        });
        add(correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 260, 250, 30));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("CORREO:");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 70, 30));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setText("OBSERVACION:");
        add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 120, 30));

        sucursal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        sucursal.setText("...");
        add(sucursal, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 120, 200, 30));

        jLabel15.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DATOS", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Adobe Arabic", 1, 14))); // NOI18N
        add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 800, 390));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setText("NOMBRE:");
        add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 160, 60, 30));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel18.setText("SUCURSAL No.");
        add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 120, 100, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed
        try {
            String valor=codigoB.getText();
            Table1.show();
            tabla(valor);
        } catch (SQLException ex) {
            Logger.getLogger(Cliente_Actualizar.class.getName()).log(Level.SEVERE, null, ex);
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
                //buscar=nitT+":"+sucursalT+":"+nombreT;
                buscar=nitT+":"+sucursalT;
                Cliente c = new Cliente();
                c.setNit(nitT);
                c.setSucursal(Integer.parseInt(sucursalT));
                consultarParaActualizar(c);
                nit.setEnabled(false);
                digitoVerificacion.setEnabled(false);
                sucursal.setEnabled(false);
                nombre.setEnabled(true);
                tipoCliente.setEnabled(true);
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
        tipoCliente.setSelectedIndex(0);
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
        tipoCliente.setEnabled(false);
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
            if(nombre.getText().equals("")){
                alertaNombre.setText("Error el Nombre no Puede estar vacio");
            }else{
                try{
                    new java.math.BigDecimal(nit.getText());
                    Controladores.ControlDB_Cliente ControlDB_Clientes = new ControlDB_Cliente();
                    Controladores.ControlDB_TipoCliente ControlTipoCliente = new ControlDB_TipoCliente();
                    Controladores.ControlDB_Otros controlDB_Otros = new ControlDB_Otros();
                    int tipoClienteC= ControlTipoCliente.validarTipoCliente_ID_por_Nombre(tipoCliente.getSelectedItem().toString());
                    Cliente c = new Cliente();
                    c.setNit(nit.getText());
                    c.setDigitoVerificacion(digitoVerificacion.getText());
                    c.setSucursal(Integer.parseInt(sucursal.getText()));
                    c.setNombre(nombre.getText());
                    c.setTipoCliente_id(tipoClienteC);
                    c.setTelefono(telefono.getText());
                    c.setCelular(celular.getText());
                    c.setDireccion(direccion.getText());
                    c.setCorreo(correo.getText());
                    c.setCiudad(ciudad.getText());
                    c.setObservacion(observacion.getText());
                    c.setEstado(controlDB_Otros.convertidorValorEstado(estado.getSelectedIndex()));
                    int result=0;
                    result=ControlDB_Clientes.actualizarCliente(c);
                    if(result==1){
                        JOptionPane.showMessageDialog(null, "Actualización Exitosa");
                        nit.setText("");
                        digitoVerificacion.setText("");
                        sucursal.setText("");
                        nombre.setText("");
                        tipoCliente.setSelectedIndex(0);
                        telefono.setText("");
                        celular.setText("");
                        direccion.setText("");
                        correo.setText("");
                        ciudad.setText("");
                        observacion.setText("");
                        estado.setSelectedIndex(0);
                        alertaNit.setText("");
                        alertaNombre.setText(""); 
                        //Cargamos esa actualizacion en la tabla
                        String valor="";
                        Table1.show();
                        tabla(valor);//#########################
                    }else{
                        JOptionPane.showMessageDialog(null, "Error al querer actualizar los datos", "Error al actualizar", JOptionPane.INFORMATION_MESSAGE);
                    }
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, "Error verifique Nit, debe ser Númerico");
                }
            }   
        }    
    }//GEN-LAST:event_actualizarActionPerformed

    private void codigoBKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codigoBKeyPressed
        String valor=codigoB.getText();
        Table1.show();
        try {
            tabla(valor);
        } catch (SQLException ex) {
            Logger.getLogger(Compra_Registrar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_codigoBKeyPressed

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
                    //buscar=nitT+":"+sucursalT+":"+nombreT;
                    buscar=nitT+":"+sucursalT;
                    Cliente c = new Cliente();
                    c.setNit(nitT);
                    c.setSucursal(Integer.parseInt(sucursalT));
                    consultarParaActualizar(c);
                    nit.setEnabled(false);
                    digitoVerificacion.setEnabled(false);
                    sucursal.setEnabled(false);
                    nombre.setEnabled(true);
                    tipoCliente.setEnabled(true);
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
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
    private javax.swing.JLabel sucursal;
    private javax.swing.JTextField telefono;
    private javax.swing.JComboBox<String> tipoCliente;
    // End of variables declaration//GEN-END:variables
    public void tabla(String valorConsulta) throws SQLException{
        registro = new String[3]; 
        modelo = new DefaultTableModel(null, titulo);
        ControlDB_Cliente c = new ControlDB_Cliente();
        ArrayList<Cliente> listadoCliente=c.buscarCliente(valorConsulta);
        for(int i =0; i< listadoCliente.size(); i++){
            registro[0]=""+listadoCliente.get(i).getNit();
            registro[1]=""+listadoCliente.get(i).getSucursal();
            registro[2]=""+listadoCliente.get(i).getNombre();
            modelo.addRow(registro);
            Table1.setModel(modelo);
        }
    }
    
    public void consultarParaActualizar (Cliente client) throws SQLException{
        ControlDB_Cliente c = new ControlDB_Cliente();
        ArrayList<Cliente> listadoCliente=c.consultarUnicoCliente(client);
        for(int i =0; i< listadoCliente.size(); i++){      
            nit.setText(""+listadoCliente.get(i).getNit());
            digitoVerificacion.setText(""+listadoCliente.get(i).getDigitoVerificacion());
            sucursal.setText(""+listadoCliente.get(i).getSucursal());
            nombre.setText(""+listadoCliente.get(i).getNombre());
            tipoCliente.setSelectedIndex(listadoCliente.get(i).getTipoCliente_id()-1);;
            telefono.setText(""+listadoCliente.get(i).getTelefono());
            celular.setText(""+listadoCliente.get(i).getCelular());
            direccion.setText(""+listadoCliente.get(i).getDireccion());
            correo.setText(""+listadoCliente.get(i).getCorreo());
            ciudad.setText(""+listadoCliente.get(i).getCiudad());
            observacion.setText(""+listadoCliente.get(i).getObservacion());
            
            ControlDB_Otros controlOtros = new ControlDB_Otros();
            estado.setSelectedItem(controlOtros.convertidorEstadoID_x_Nombre(listadoCliente.get(i).getEstado()));
        }
    }
}
