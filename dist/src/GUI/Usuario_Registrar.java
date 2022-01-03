/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Controladores.ControlDB_EmpresaLocal;
import Controladores.ControlDB_Otros;
import Controladores.ControlDB_Usuario;
import Modelos.EmpresaLocal;
import Modelos.Usuario;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Usuario_Registrar extends javax.swing.JPanel {

    DefaultTableModel modelo;
    String datos; 
    String [] titulo= {"NIT","SUCURSAL", "NOMBRE"};
    String [] registro;
    String accion="";
    String nombreOriginal="";
    int maximoEntradasAlmacen=0;
    public Usuario_Registrar() {
        initComponents();
        VentanaInternaEmpresaLocal.show(false);
        TextPrompt placeholder = new TextPrompt("Buscar por Nit o Nombre:", codigoB);   
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Seleccionar = new javax.swing.JPopupMenu();
        Editar = new javax.swing.JMenuItem();
        VentanaInternaEmpresaLocal = new javax.swing.JInternalFrame();
        codigoB = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        limpiarEmpresaLocal = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table1 = new javax.swing.JTable();
        buscarEmpresaLocal = new javax.swing.JButton();
        cancelarEmpresaLocal = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        nombreEmpresaLocal = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        celular = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        alertaEmpresaLocal = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        nitEmpresaLocal = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        RegistrarUsuario = new javax.swing.JButton();
        usuario = new javax.swing.JTextField();
        telefono = new javax.swing.JTextField();
        correo = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        nombre = new javax.swing.JTextField();
        apellido = new javax.swing.JTextField();
        alertaNombre = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        password = new javax.swing.JPasswordField();
        alertaPassword = new javax.swing.JLabel();
        estado = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        alertaUsuario = new javax.swing.JLabel();
        alertaApellido = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
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

        VentanaInternaEmpresaLocal.setBackground(new java.awt.Color(255, 255, 255));
        VentanaInternaEmpresaLocal.setTitle("EMPRESA LOCAL");
        VentanaInternaEmpresaLocal.setVisible(true);
        VentanaInternaEmpresaLocal.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        codigoB.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                codigoBKeyPressed(evt);
            }
        });
        VentanaInternaEmpresaLocal.getContentPane().add(codigoB, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 250, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 153, 153));
        jLabel7.setText("BUSCAR EMPRESA LOCAL");
        VentanaInternaEmpresaLocal.getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 310, -1));

        limpiarEmpresaLocal.setBackground(new java.awt.Color(255, 255, 255));
        limpiarEmpresaLocal.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        limpiarEmpresaLocal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/Interfaz_Icon_Borrar.PNG"))); // NOI18N
        limpiarEmpresaLocal.setText("LIMPIAR");
        limpiarEmpresaLocal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarEmpresaLocalActionPerformed(evt);
            }
        });
        VentanaInternaEmpresaLocal.getContentPane().add(limpiarEmpresaLocal, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, 140, 40));

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
        Table1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Table1KeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(Table1);

        VentanaInternaEmpresaLocal.getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 490, 230));

        buscarEmpresaLocal.setBackground(new java.awt.Color(255, 255, 255));
        buscarEmpresaLocal.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        buscarEmpresaLocal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/Bodega_Actualizar_Bton_Buscar.PNG"))); // NOI18N
        buscarEmpresaLocal.setText("BUSCAR");
        buscarEmpresaLocal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarEmpresaLocalActionPerformed(evt);
            }
        });
        VentanaInternaEmpresaLocal.getContentPane().add(buscarEmpresaLocal, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 140, -1));

        cancelarEmpresaLocal.setBackground(new java.awt.Color(255, 255, 255));
        cancelarEmpresaLocal.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cancelarEmpresaLocal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/Bodega_Actualizar_Bton_Cancelar.PNG"))); // NOI18N
        cancelarEmpresaLocal.setText("CANCELAR");
        cancelarEmpresaLocal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarEmpresaLocalActionPerformed(evt);
            }
        });
        VentanaInternaEmpresaLocal.getContentPane().add(cancelarEmpresaLocal, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 90, 160, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/fondo.png"))); // NOI18N
        VentanaInternaEmpresaLocal.getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 540, 390));

        add(VentanaInternaEmpresaLocal, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 70, -1, -1));

        nombreEmpresaLocal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nombreEmpresaLocal.setForeground(new java.awt.Color(102, 102, 102));
        add(nombreEmpresaLocal, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 100, 600, 30));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 102, 102));
        jLabel9.setText("REGISTRO DE USUARIO");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 450, 30));

        celular.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                celularMouseClicked(evt);
            }
        });
        add(celular, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 270, 280, 30));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel18.setText("Sucursal:");
        add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 70, 30));

        alertaEmpresaLocal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        alertaEmpresaLocal.setForeground(new java.awt.Color(255, 0, 51));
        add(alertaEmpresaLocal, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 130, 600, 30));

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel21.setText("EMPRESA LOCAL");
        add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 120, 30));

        nitEmpresaLocal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nitEmpresaLocal.setForeground(new java.awt.Color(102, 102, 102));
        add(nitEmpresaLocal, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 40, 600, 30));

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel20.setText("Usuario:");
        add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 70, 60));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Celular:");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 270, 70, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Apellido:");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 220, 80, 30));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/Compra_Agregar_Proveedor.png"))); // NOI18N
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 80, 90));

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel25.setText("Nombre:");
        add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 70, 30));

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel26.setText("CARGAR ");
        add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, 70, 20));

        RegistrarUsuario.setBackground(new java.awt.Color(255, 255, 255));
        RegistrarUsuario.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        RegistrarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/Bodega_Registrar_Bton_Registrar.PNG"))); // NOI18N
        RegistrarUsuario.setText("REGISTRAR USUARIO");
        RegistrarUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                RegistrarUsuarioMouseExited(evt);
            }
        });
        RegistrarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistrarUsuarioActionPerformed(evt);
            }
        });
        add(RegistrarUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 440, 210, 50));

        usuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                usuarioMouseClicked(evt);
            }
        });
        add(usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 170, 280, 30));

        telefono.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                telefonoMouseClicked(evt);
            }
        });
        add(telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 270, 280, 30));

        correo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                correoMouseClicked(evt);
            }
        });
        add(correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 320, 280, 30));

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel27.setText("Correo:");
        add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 70, 30));

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel28.setText("Contraseña:");
        add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 170, 80, 30));

        jLabel15.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "INFORMACIÓN DE LA EMPRESA LOCAL ", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Adobe Arabic", 1, 14))); // NOI18N
        add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 880, 150));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Nombre:");
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 70, 30));

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel29.setText("Telefono:");
        add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 70, 30));

        nombre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nombreMouseClicked(evt);
            }
        });
        add(nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 220, 280, 30));

        apellido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                apellidoMouseClicked(evt);
            }
        });
        add(apellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 220, 280, 30));

        alertaNombre.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        alertaNombre.setForeground(new java.awt.Color(255, 0, 51));
        add(alertaNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 250, 320, 20));

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel22.setText("Nombre de");
        add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 140, 30));
        add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 170, 280, 30));

        alertaPassword.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        alertaPassword.setForeground(new java.awt.Color(255, 0, 51));
        add(alertaPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 200, 320, 20));

        estado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));
        add(estado, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 320, 280, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Estado:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 320, 70, 20));

        alertaUsuario.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        alertaUsuario.setForeground(new java.awt.Color(255, 0, 51));
        add(alertaUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 200, 320, 20));

        alertaApellido.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        alertaApellido.setForeground(new java.awt.Color(255, 0, 51));
        add(alertaApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 250, 320, 20));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel19.setText("Nit:");
        add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, 70, 30));

        sucursal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        sucursal.setForeground(new java.awt.Color(102, 102, 102));
        add(sucursal, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 70, 600, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void limpiarEmpresaLocalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarEmpresaLocalActionPerformed
          codigoB.setText("");
    }//GEN-LAST:event_limpiarEmpresaLocalActionPerformed

    private void buscarEmpresaLocalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarEmpresaLocalActionPerformed
        String valor=codigoB.getText();
        Table1.show();
        try {
            tabla(valor);
        } catch (SQLException ex) {
            Logger.getLogger(Usuario_Registrar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_buscarEmpresaLocalActionPerformed

    private void Table1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Table1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_Table1KeyPressed

    private void celularMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_celularMouseClicked
        
    }//GEN-LAST:event_celularMouseClicked

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
                String nombreT=(String)modelo.getValueAt(fila1, 2);
                //nombreOriginal=(String)modelo.getValueAt(fila1, 2);
                buscar=nitT+":"+sucursalT+":"+nombreT;
                consultarParaActualizar(buscar);
                VentanaInternaEmpresaLocal.show(false);
              
            }
        }catch(Exception e){
        }
    }//GEN-LAST:event_EditarActionPerformed

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        VentanaInternaEmpresaLocal.show(true);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void RegistrarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistrarUsuarioActionPerformed
        if(nitEmpresaLocal.getText().equals("")){
            alertaEmpresaLocal.setText("Error!!.. Se debe Cargar la Empresa Local");
        }else{
            if(usuario.getText().equals("")){
                alertaUsuario.setText("Error!!.. El nombre de Usuario no puede estar vacio");
            }else{
                if(password.getText().equals("")){
                    alertaPassword.setText("Error!!.. La contraseña no puede estar vacia");
                }
                else{
                    if(nombre.getText().equals("")){
                        alertaNombre.setText("Error!!.. El nombre no puede estar vacio");
                    }else{
                        if(apellido.getText().equals("")){
                            alertaApellido.setText("Error!!.. El apellido no puede estar vacio");
                        }else{
                            try {
                                Usuario u = new Usuario();
                                EmpresaLocal emp = new EmpresaLocal();
                                ControlDB_Otros controlDBO_Otros = new ControlDB_Otros();
                                ControlDB_Usuario controlDB_Usuario = new ControlDB_Usuario();
                                String[] arregloNit= nitEmpresaLocal.getText().split("-");
                                emp.setNit(arregloNit[0]);
                                emp.setSucursal(Integer.parseInt(sucursal.getText()));
                                emp.setNombre(nombreEmpresaLocal.getText());
                                
                                u.setUser(usuario.getText());   
                                u.setPassword(password.getText());   
                                u.setNombre(nombre.getText());   
                                u.setApellido(apellido.getText());   
                                u.setCelular(celular.getText());   
                                u.setTelefono(telefono.getText());    
                                u.setCorreo(correo.getText());  
                                u.setEstado(""+controlDBO_Otros.convertidorValorEstado(estado.getSelectedIndex()));   
                                int result=0;
                                result=controlDB_Usuario.registrarUsuario(u, emp);
                                if(result==1){
                                 JOptionPane.showMessageDialog(null, "Registro de Usuario Exitoso");
                                        nitEmpresaLocal.setText("");
                                        sucursal.setText("");                                        
                                        nombreEmpresaLocal.setText("");
                                        usuario.setText("");
                                        password.setText("");
                                        nombre.setText("");
                                        apellido.setText("");
                                        celular.setText("");
                                        telefono.setText("");
                                        correo.setText("");
                                        estado.setSelectedIndex(0);
                                        alertaApellido.setText("");
                                        alertaEmpresaLocal.setText("");
                                        alertaNombre.setText("");
                                        alertaPassword.setText("");
                                        alertaUsuario.setText("");
                                }else{
                                    JOptionPane.showMessageDialog(null, "Error Al Registrar el Usuario");
                                }                               
                            } catch (FileNotFoundException ex) {
                                Logger.getLogger(Usuario_Registrar.class.getName()).log(Level.SEVERE, null, ex);
                            }  
                        }
                    }
                }
            }
        }               
    }//GEN-LAST:event_RegistrarUsuarioActionPerformed

    private void usuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usuarioMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_usuarioMouseClicked

    private void telefonoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_telefonoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_telefonoMouseClicked

    private void correoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_correoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_correoMouseClicked

    private void RegistrarUsuarioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RegistrarUsuarioMouseExited
        alertaUsuario.setText("");
        alertaPassword.setText("");
        alertaNombre.setText("");
        alertaApellido.setText("");
    }//GEN-LAST:event_RegistrarUsuarioMouseExited

    private void cancelarEmpresaLocalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarEmpresaLocalActionPerformed
         VentanaInternaEmpresaLocal.show(false);
    }//GEN-LAST:event_cancelarEmpresaLocalActionPerformed

    private void nombreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nombreMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreMouseClicked

    private void apellidoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_apellidoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_apellidoMouseClicked

    private void codigoBKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codigoBKeyPressed
        Table1.removeAll();
        String valor=codigoB.getText();
        Table1.show();
        try {
            tabla(valor);
        } catch (SQLException ex) {
            Logger.getLogger(Usuario_Registrar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_codigoBKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Editar;
    private javax.swing.JButton RegistrarUsuario;
    private javax.swing.JPopupMenu Seleccionar;
    private javax.swing.JTable Table1;
    private javax.swing.JInternalFrame VentanaInternaEmpresaLocal;
    private javax.swing.JLabel alertaApellido;
    private javax.swing.JLabel alertaEmpresaLocal;
    private javax.swing.JLabel alertaNombre;
    private javax.swing.JLabel alertaPassword;
    private javax.swing.JLabel alertaUsuario;
    private javax.swing.JTextField apellido;
    private javax.swing.JButton buscarEmpresaLocal;
    private javax.swing.JButton cancelarEmpresaLocal;
    private javax.swing.JTextField celular;
    private javax.swing.JTextField codigoB;
    private javax.swing.JTextField correo;
    private javax.swing.JComboBox<String> estado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton limpiarEmpresaLocal;
    private javax.swing.JLabel nitEmpresaLocal;
    private javax.swing.JTextField nombre;
    private javax.swing.JLabel nombreEmpresaLocal;
    private javax.swing.JPasswordField password;
    private javax.swing.JLabel sucursal;
    private javax.swing.JTextField telefono;
    private javax.swing.JTextField usuario;
    // End of variables declaration//GEN-END:variables
public void tabla(String valorConsulta) throws SQLException{
    registro = new String[3]; 
        modelo = new DefaultTableModel(null, titulo);
        ControlDB_EmpresaLocal empLocal = new ControlDB_EmpresaLocal();
        ArrayList<EmpresaLocal> listadoEmpresaLocal=empLocal.buscarEmpresaLocal("");
        for(int i =0; i< listadoEmpresaLocal.size(); i++){
            registro[0]=""+listadoEmpresaLocal.get(i).getNit();
            registro[1]=""+listadoEmpresaLocal.get(i).getSucursal();
            registro[2]=""+listadoEmpresaLocal.get(i).getNombre();
            modelo.addRow(registro);
            Table1.setModel(modelo);
        }    
    }
    public void consultarParaActualizar (String codigoc) throws SQLException{
        ControlDB_EmpresaLocal c = new ControlDB_EmpresaLocal();
        ArrayList<EmpresaLocal> listadoEmpresaLocal=c.buscarEmpresaLocal("");
        for(int i =0; i< listadoEmpresaLocal.size(); i++){      
            nitEmpresaLocal.setText(listadoEmpresaLocal.get(i).getNit()+"-"+listadoEmpresaLocal.get(i).getDigitoVerificacion());
            sucursal.setText(""+listadoEmpresaLocal.get(i).getSucursal());
            nombreEmpresaLocal.setText(""+listadoEmpresaLocal.get(i).getNombre());
        }
    }
}
