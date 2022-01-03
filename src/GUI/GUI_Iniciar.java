package GUI;

import Controladores.ControlDB_Usuario;
import Modelos.Usuario;
import java.awt.Color;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GUI_Iniciar extends javax.swing.JFrame {
    int contador=1;
    public GUI_Iniciar() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.WHITE);
        //usuario.setText("sa");
        //password.setText("root");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        salir = new javax.swing.JButton();
        registrar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        usuario = new javax.swing.JTextField();
        alertaUsuario = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        password = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        salir.setBackground(new java.awt.Color(255, 255, 255));
        salir.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/exit.png"))); // NOI18N
        salir.setText("SALIR");
        salir.setBorder(null);
        salir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        salir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });
        getContentPane().add(salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 270, 90, 70));

        registrar.setBackground(new java.awt.Color(255, 255, 255));
        registrar.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        registrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/camaronIni.PNG"))); // NOI18N
        registrar.setText("INGRESAR");
        registrar.setBorder(null);
        registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarActionPerformed(evt);
            }
        });
        registrar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                registrarKeyPressed(evt);
            }
        });
        getContentPane().add(registrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 240, 150, 50));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/Logo.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 370, 70));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("USUARIO");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, 80, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/GUI_Iniciar_camarones.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, 410, 300));

        usuario.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        usuario.setForeground(new java.awt.Color(102, 102, 102));
        usuario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        usuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                usuarioMouseClicked(evt);
            }
        });
        getContentPane().add(usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, 200, 30));

        alertaUsuario.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        alertaUsuario.setForeground(new java.awt.Color(255, 0, 51));
        getContentPane().add(alertaUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 580, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("PASSWORD");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 170, 80, 30));

        password.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        password.setForeground(new java.awt.Color(102, 102, 102));
        password.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 200, 200, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/fondo.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 350));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void usuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usuarioMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_usuarioMouseClicked

    private void registrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarActionPerformed
        if(usuario.getText().equals("")){
            alertaUsuario.setText("Error!.. El usuario no puede estar vacio");
        }else{
            if(password.getText().equals("")){
                alertaUsuario.setText("Error!.. La contraseña no puede estar vacia");
            }else{
                //Buscamos en nuestra base de datos si el usuario y password con correcto
                ControlDB_Usuario controlDB_Usuario = new ControlDB_Usuario();
                Usuario u = new Usuario();
                
                u.setUser(usuario.getText());
                u.setPassword(password.getText());          
                //borrar               
                Usuario user = controlDB_Usuario.validarUsuario(u);
                
                if(user != null){
                    if(contador==1){
                        GUI_Principal1 guiPrincipal= new GUI_Principal1();
                        try {
                            guiPrincipal.cargarUsuario(user);
                            guiPrincipal.cargaMenu();
                            
                        } catch (ParseException ex) {
                            Logger.getLogger(GUI_Iniciar.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        guiPrincipal.setVisible(true);
                        this.setVisible(false); 
                    }contador++;
                }else{
                    alertaUsuario.setText("Error!.. Usuario o Contraseña Incorrecta verifique datos");
                }
            }
        }
    }//GEN-LAST:event_registrarActionPerformed

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_salirActionPerformed

    private void registrarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_registrarKeyPressed
        if(usuario.getText().equals("")){
            alertaUsuario.setText("Error!.. El usuario no puede estar vacio");
        }else{
            if(password.getText().equals("")){
                alertaUsuario.setText("Error!.. La contraseña no puede estar vacia");
            }else{
                //Buscamos en nuestra base de datos si el usuario y password con correcto
                ControlDB_Usuario controlDB_Usuario = new ControlDB_Usuario();
                Usuario u = new Usuario();
                u.setUser(usuario.getText());
                u.setPassword(password.getText());
                Usuario user = controlDB_Usuario.validarUsuario(u);                
                if(user != null){
                    if(contador==1){
                        GUI_Principal1 guiPrincipal= new GUI_Principal1();
                        try {
                            guiPrincipal.cargarUsuario(user);
                            guiPrincipal.cargaMenu();
                        } catch (ParseException ex) {
                            Logger.getLogger(GUI_Iniciar.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        guiPrincipal.setVisible(true);
                        this.setVisible(false); 
                    }contador++;
                }else{
                    alertaUsuario.setText("Error!.. Usuario o Contraseña Incorrecta verifique datos");
                }
            }
        }
    }//GEN-LAST:event_registrarKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI_Iniciar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_Iniciar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_Iniciar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_Iniciar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_Iniciar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel alertaUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPasswordField password;
    private javax.swing.JButton registrar;
    private javax.swing.JButton salir;
    private javax.swing.JTextField usuario;
    // End of variables declaration//GEN-END:variables
}
