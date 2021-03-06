
package GUI;
import Controladores.ControlDB_Otros;
import Controladores.ControlDB_Usuario;
import Modelos.Usuario;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class Usuario_Actualizar extends javax.swing.JPanel {
    ControlDB_Usuario controlDB_Usuario= new ControlDB_Usuario();
    DefaultTableModel modelo;
    String datos; 
    String [] titulo= {"CODIGO","USER", "NOMBRE", "APELLIDO"};
    String [] registro;
    String accion="";
    Statement statement = null;
    
    public Usuario_Actualizar() throws SQLException {
        initComponents();
        //Deshabilitamos los campos al iniciar###########################
        codigoP.setEnabled(false);
        usuario.setEnabled(false);
        password.setEnabled(false);
        nombre.setEnabled(false);
        apellido.setEnabled(false);
        telefono.setEnabled(false);
        celular.setEnabled(false);
        correo.setEnabled(false);
        estado.setEnabled(false);
        //##############################################################
        

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
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
        codigoP = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        actualizar = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();
        limpiar = new javax.swing.JButton();
        usuario = new javax.swing.JTextField();
        alertaUsuario = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        password = new javax.swing.JPasswordField();
        alertaPassword = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        nombre = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        apellido = new javax.swing.JTextField();
        alertaApellido = new javax.swing.JLabel();
        celular = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        alertaNombre = new javax.swing.JLabel();
        telefono = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        correo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        estado = new javax.swing.JComboBox<>();
        alertaCodigo = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();

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
        jLabel7.setText("ACTUALIZAR USUARIOS");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, 440, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("BUSQUEDA POR CODIGO O NOMBRE:");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 270, 30));

        codigoB.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                codigoBKeyPressed(evt);
            }
        });
        add(codigoB, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 40, 250, 30));

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

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 100, 460, 280));
        add(codigoP, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, 280, 30));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("CODIGO:");
        add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 60, 30));
        add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 1290, 10));

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
        add(actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 440, 170, 50));

        cancelar.setBackground(new java.awt.Color(255, 255, 255));
        cancelar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/Bodega_Actualizar_Bton_Cancelar.PNG"))); // NOI18N
        cancelar.setText("CANCELAR");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });
        add(cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 440, 170, 50));

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

        usuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                usuarioMouseClicked(evt);
            }
        });
        add(usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 170, 280, 30));

        alertaUsuario.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        alertaUsuario.setForeground(new java.awt.Color(255, 0, 51));
        add(alertaUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 200, 320, 20));

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel20.setText("Usuario:");
        add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 70, 40));

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel28.setText("Contrase??a:");
        add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 170, 80, 30));
        add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 170, 280, 30));

        alertaPassword.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        alertaPassword.setForeground(new java.awt.Color(255, 0, 51));
        add(alertaPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 200, 320, 20));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Nombre:");
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 70, 30));

        nombre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nombreMouseClicked(evt);
            }
        });
        add(nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 220, 280, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Apellido:");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 220, 80, 30));

        apellido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                apellidoMouseClicked(evt);
            }
        });
        add(apellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 220, 280, 30));

        alertaApellido.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        alertaApellido.setForeground(new java.awt.Color(255, 0, 51));
        add(alertaApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 250, 320, 20));

        celular.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                celularMouseClicked(evt);
            }
        });
        add(celular, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 270, 280, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Celular:");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 270, 70, 30));

        alertaNombre.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        alertaNombre.setForeground(new java.awt.Color(255, 0, 51));
        add(alertaNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 250, 320, 20));

        telefono.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                telefonoMouseClicked(evt);
            }
        });
        add(telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 270, 280, 30));

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel29.setText("Telefono:");
        add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 70, 30));

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel27.setText("Correo:");
        add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 70, 30));

        correo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                correoMouseClicked(evt);
            }
        });
        correo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                correoActionPerformed(evt);
            }
        });
        add(correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 320, 280, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Estado:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 320, 70, 20));

        estado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));
        add(estado, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 320, 280, 30));

        alertaCodigo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        alertaCodigo.setForeground(new java.awt.Color(255, 0, 51));
        add(alertaCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, 320, 20));

        jLabel15.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "INFORMACION DEL USUARIO", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Adobe Arabic", 1, 14))); // NOI18N
        add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 790, 400));
    }// </editor-fold>//GEN-END:initComponents

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed
        String valor=codigoB.getText();
        Table1.show();
        try {
            tabla(valor);
        } catch (SQLException ex) {
            Logger.getLogger(Usuario_Actualizar.class.getName()).log(Level.SEVERE, null, ex);
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
                buscar=(String)modelo.getValueAt(fila1, 0);
                Usuario us = new Usuario();
                us.setId(Integer.parseInt(buscar));
                consultarParaActualizar(us);
                codigoP.setEnabled(false);
                usuario.setEnabled(true);
                password.setEnabled(true);
                nombre.setEnabled(true);
                apellido.setEnabled(true);
                telefono.setEnabled(true);
                celular.setEnabled(true);
                correo.setEnabled(true);
                estado.setEnabled(true);
           }
        }catch(Exception e){
        }
    }//GEN-LAST:event_EditarActionPerformed

    private void actualizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_actualizarMouseClicked
        if(codigoP.getText().equals("")){
            alertaCodigo.setText("Error!!.. Debe Cargar el Usuario");
        }
        else{
        if(usuario.getText().equals("")){
            alertaUsuario.setText("Error!!.. El nombre de Usuario no puede estar vacio");
        }else{
            if(password.getText().equals("")){
                    alertaPassword.setText("Error!!.. La contrase??a no puede estar vacia");
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
                                ControlDB_Otros controlDBO_Otros = new ControlDB_Otros();
                                ControlDB_Usuario controlDB_Usuario = new ControlDB_Usuario();
                                u.setId(Integer.parseInt(codigoP.getText()));
                                u.setUser(usuario.getText());   
                                u.setPassword(password.getText());   
                                u.setNombre(nombre.getText());   
                                u.setApellido(apellido.getText());   
                                u.setCelular(celular.getText());   
                                u.setTelefono(telefono.getText());    
                                u.setCorreo(correo.getText());  
                                u.setEstado(""+controlDBO_Otros.convertidorValorEstado(estado.getSelectedIndex()));   
                                int result=0;
                                result=controlDB_Usuario.actualizarUsuario(u);
                                if(result==1){
                                    JOptionPane.showMessageDialog(null, "Actualizaci??n de Usuario Exitosa");
                                    codigoP.setEditable(true);
                                    codigoP.setText("");
                                    codigoP.setEnabled(false);
                                    usuario.setText("");
                                    password.setText("");
                                    nombre.setText("");
                                    apellido.setText("");
                                    celular.setText("");
                                    telefono.setText("");
                                    correo.setText("");
                                    estado.setSelectedIndex(0);
                                    alertaApellido.setText("");
                                    alertaNombre.setText("");
                                    alertaPassword.setText("");
                                    alertaUsuario.setText("");
                                    try { //Actualizamos la tabla de Busqueda.
                                        tabla(codigoB.getText());
                                    } catch (SQLException ex) {
                                        try {
                                            tabla("");
                                        } catch (SQLException ex1) {
                                           
                                        }
                                    }
                                }else{
                                    JOptionPane.showMessageDialog(null, "Error Al Registrar el Usuario");
                                }                               
                            } catch (FileNotFoundException ex) {
                                Logger.getLogger(Usuario_Registrar.class.getName()).log(Level.SEVERE, null, ex);
                        }  
                    }
                }
            }
        }}    
    }//GEN-LAST:event_actualizarMouseClicked

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        codigoP.setText("");
        usuario.setText("");
        password.setText("");
        nombre.setText("");
        apellido.setText("");
        telefono.setText("");
        celular.setText("");
        correo.setText("");
        estado.setSelectedIndex(0);
        alertaCodigo.setText("");     
        alertaNombre.setText("");
        alertaApellido.setText("");
        alertaPassword.setText("");
        alertaUsuario.setText("");
    }//GEN-LAST:event_cancelarActionPerformed

    private void limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarActionPerformed
        codigoB.setText("");
    }//GEN-LAST:event_limpiarActionPerformed

    private void actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_actualizarActionPerformed

    private void usuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usuarioMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_usuarioMouseClicked

    private void nombreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nombreMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreMouseClicked

    private void apellidoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_apellidoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_apellidoMouseClicked

    private void celularMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_celularMouseClicked

    }//GEN-LAST:event_celularMouseClicked

    private void telefonoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_telefonoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_telefonoMouseClicked

    private void correoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_correoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_correoMouseClicked

    private void correoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_correoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_correoActionPerformed

    private void codigoBKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codigoBKeyPressed
         String valor=codigoB.getText();
        Table1.show();
        try {
            tabla(valor);
        } catch (SQLException ex) {
            Logger.getLogger(Usuario_Actualizar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_codigoBKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Editar;
    private javax.swing.JPopupMenu Seleccionar;
    private javax.swing.JTable Table1;
    private javax.swing.JButton actualizar;
    private javax.swing.JLabel alertaApellido;
    private javax.swing.JLabel alertaCodigo;
    private javax.swing.JLabel alertaNombre;
    private javax.swing.JLabel alertaPassword;
    private javax.swing.JLabel alertaUsuario;
    private javax.swing.JTextField apellido;
    private javax.swing.JButton buscar;
    private javax.swing.JButton cancelar;
    private javax.swing.JTextField celular;
    private javax.swing.JTextField codigoB;
    private javax.swing.JTextField codigoP;
    private javax.swing.JTextField correo;
    private javax.swing.JComboBox<String> estado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton limpiar;
    private javax.swing.JTextField nombre;
    private javax.swing.JPasswordField password;
    private javax.swing.JTextField telefono;
    private javax.swing.JTextField usuario;
    // End of variables declaration//GEN-END:variables
    public void tabla(String valorConsulta) throws SQLException{
        //{"CODIGO","USER", "NOMBRE", "APELLIDO"};
        registro = new String[4]; 
        modelo = new DefaultTableModel(null, titulo);
        ControlDB_Usuario controlDB_UsuarioT = new ControlDB_Usuario();
        ArrayList<Usuario> listadoUsuario=controlDB_UsuarioT.buscarUsuarios(valorConsulta);
        for(int i =0; i< listadoUsuario.size(); i++){
            registro[0]=""+listadoUsuario.get(i).getId();
            registro[1]=""+listadoUsuario.get(i).getUser();
            registro[2]=""+listadoUsuario.get(i).getNombre();
            registro[3]=""+listadoUsuario.get(i).getApellido(); 
            modelo.addRow(registro);
            Table1.setModel(modelo);
        }
    }
    public void consultarParaActualizar (Usuario usu ) throws SQLException{
        ControlDB_Usuario controlDB_UsuarioT = new ControlDB_Usuario();
        ControlDB_Otros  controlOtros = new ControlDB_Otros();
        ArrayList<Usuario> listadoUsuario = controlDB_UsuarioT.consultarUnicoUsuario(usu);
        for(int i =0; i< listadoUsuario.size(); i++){     
            codigoP.setText(""+listadoUsuario.get(i).getId());
            usuario.setText(""+listadoUsuario.get(i).getUser());
            password.setText("");
            nombre.setText(""+listadoUsuario.get(i).getNombre());
            apellido.setText(""+listadoUsuario.get(i).getApellido());
            telefono.setText(""+listadoUsuario.get(i).getTelefono());
            celular.setText(""+listadoUsuario.get(i).getCelular());
            correo.setText(""+listadoUsuario.get(i).getCorreo());
            estado.setSelectedItem(""+controlOtros.convertidorEstadoID_x_Nombre(Integer.parseInt(listadoUsuario.get(i).getEstado())));
        }
    }    
}
