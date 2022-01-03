/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Controladores.ControlDB_Bodega;
import Controladores.ControlDB_Otros;
import Modelos.Bodega;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author wrivas
 */
public class Bodega_Registrar extends javax.swing.JPanel {

    /**
     * Creates new form RegistrarBodega
     */
    public Bodega_Registrar() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        estado = new javax.swing.JComboBox<>();
        registrarUnidad = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        descripcion = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        alertaNombre = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(620, 260));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        estado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));
        add(estado, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, 270, 40));

        registrarUnidad.setBackground(new java.awt.Color(255, 255, 255));
        registrarUnidad.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        registrarUnidad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/Bodega_Registrar_Bton_Registrar.PNG"))); // NOI18N
        registrarUnidad.setText("REGISTRAR");
        registrarUnidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarUnidadActionPerformed(evt);
            }
        });
        add(registrarUnidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, 200, 50));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("ESTADO:");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, -1, 20));

        descripcion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                descripcionMouseClicked(evt);
            }
        });
        add(descripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 270, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("BODEGA:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, -1, 20));

        alertaNombre.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        alertaNombre.setForeground(new java.awt.Color(255, 51, 51));
        add(alertaNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 310, 20));

        jLabel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "FORMULARIO REGISTRO DE BODEGA", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 490, 260));
    }// </editor-fold>//GEN-END:initComponents

    private void registrarUnidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarUnidadActionPerformed
        if(descripcion.getText().equals("")){
            alertaNombre.setText("Error!!. Nombre de la Bodega no puede estar vacio");
        }else{
            ControlDB_Bodega controlDB_Bodega = new ControlDB_Bodega();
            ControlDB_Otros  controlOtros = new ControlDB_Otros();
            int valorEstado = controlOtros.convertidorValorEstado(estado.getSelectedIndex());
           
            if(controlDB_Bodega.validarBodega(descripcion.getText())==0){
                Bodega b = new Bodega();
                b.setDescripcion(descripcion.getText());
                b.setEstado(valorEstado);
                try {
                    if(controlDB_Bodega.registrarBodega(b)==1){
                        JOptionPane.showMessageDialog(null, "Registro Exitoso");
                        descripcion.setText("");
                        estado.setSelectedIndex(0);
                    }else{
                        JOptionPane.showMessageDialog(null, "Error al registrar Bodega");    
                    }
                } catch (FileNotFoundException ex) {
                    JOptionPane.showMessageDialog(null, "Error al registrar Bodega");   
                }
            }else{
                JOptionPane.showMessageDialog(null, "Ya existe una bodega registrada con el mismo nombre", "Error al registrar", JOptionPane.INFORMATION_MESSAGE);
            }        
        }
    }//GEN-LAST:event_registrarUnidadActionPerformed

    private void descripcionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_descripcionMouseClicked
        alertaNombre.setText("");
    }//GEN-LAST:event_descripcionMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel alertaNombre;
    private javax.swing.JTextField descripcion;
    private javax.swing.JComboBox<String> estado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton registrarUnidad;
    // End of variables declaration//GEN-END:variables
}