/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

/**
 *
 * @author JQuery
 */
public class Menu_EmpresaLocal extends javax.swing.JPanel {

    /**
     * Creates new form MenuRegistrarUnidad
     */
    public Menu_EmpresaLocal() {
        initComponents();
        panel.setViewportView(new GUIPresentacion());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JScrollPane();
        consultar = new javax.swing.JButton();
        actualizar = new javax.swing.JButton();
        registrar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 1130, 510));

        consultar.setBackground(new java.awt.Color(255, 255, 255));
        consultar.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        consultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/cliente_Consultar.png"))); // NOI18N
        consultar.setText("CONSULTAR");
        consultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultarActionPerformed(evt);
            }
        });
        add(consultar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 160, 50));

        actualizar.setBackground(new java.awt.Color(255, 255, 255));
        actualizar.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        actualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/cliente_actualizar.png"))); // NOI18N
        actualizar.setText("ACTUALIZAR");
        actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizarActionPerformed(evt);
            }
        });
        add(actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 160, 50));

        registrar.setBackground(new java.awt.Color(255, 255, 255));
        registrar.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        registrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/cliente_registrar.png"))); // NOI18N
        registrar.setText("REGISTRAR");
        registrar.setBorder(null);
        registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarActionPerformed(evt);
            }
        });
        add(registrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 160, 50));

        jLabel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "MENU EMPRESA LOCAL", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 180, 30));

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/Bodega_Menu_Actualizar.PNG"))); // NOI18N
        jButton4.setText("ACTUALIZAR");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 150, 50));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 102, 102));
        jLabel3.setText("INTERFAZ");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 140, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 102));
        jLabel4.setText("EMPRESA lOCAL");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 130, 30));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/Interfaz_Icon.PNG"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 70));
    }// </editor-fold>//GEN-END:initComponents

    private void registrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarActionPerformed
        panel.setViewportView(new EmpresaLocal_Registrar());
    }//GEN-LAST:event_registrarActionPerformed

    private void consultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarActionPerformed
        panel.setViewportView(new EmpresaLocal_Consultar());
    }//GEN-LAST:event_consultarActionPerformed

    private void actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizarActionPerformed
        panel.setViewportView(new EmpresaLocal_Actualizar());
    }//GEN-LAST:event_actualizarActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton actualizar;
    private javax.swing.JButton consultar;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane panel;
    private javax.swing.JButton registrar;
    // End of variables declaration//GEN-END:variables
}