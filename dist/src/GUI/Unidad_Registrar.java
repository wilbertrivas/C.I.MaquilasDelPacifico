
package GUI;

import Controladores.ControlDB_Otros;
import Controladores.ControlDB_Unidad;
import Modelos.Unidad;
import java.io.FileNotFoundException;
import javax.swing.JOptionPane;

public class Unidad_Registrar extends javax.swing.JPanel {
        
    public Unidad_Registrar() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        descripcion = new javax.swing.JTextField();
        estado = new javax.swing.JComboBox<>();
        alertaNombre = new javax.swing.JLabel();
        registrarUnidad1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("UNIDAD:");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, -1, 20));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("ESTADO:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 70, 20));

        descripcion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                descripcionMouseClicked(evt);
            }
        });
        add(descripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 310, 30));

        estado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));
        add(estado, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, 310, 30));

        alertaNombre.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        alertaNombre.setForeground(new java.awt.Color(255, 51, 51));
        add(alertaNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 310, 20));

        registrarUnidad1.setBackground(new java.awt.Color(255, 255, 255));
        registrarUnidad1.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        registrarUnidad1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/Bodega_Registrar_Bton_Registrar.PNG"))); // NOI18N
        registrarUnidad1.setText("REGISTRAR");
        registrarUnidad1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarUnidad1ActionPerformed(evt);
            }
        });
        add(registrarUnidad1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 150, 140, 40));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 30, 240, -1));

        jLabel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "FORMULARIO REGISTRO UNIDADES", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 430, 220));
    }// </editor-fold>//GEN-END:initComponents

    private void descripcionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_descripcionMouseClicked
        alertaNombre.setText("");
    }//GEN-LAST:event_descripcionMouseClicked

    private void registrarUnidad1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarUnidad1ActionPerformed
       if(descripcion.getText().equals("")){
            alertaNombre.setText("Error la unidad no puede estar vacio");
        }else{
            ControlDB_Unidad controlDB_Unidad = new ControlDB_Unidad();
            ControlDB_Otros  controlOtros = new ControlDB_Otros();
            
            if(controlDB_Unidad.validarUnidad(descripcion.getText())==0){
                Unidad unid = new Unidad();
                unid.setDescripcion(descripcion.getText());
                unid.setEstado(controlOtros.convertidorValorEstado(estado.getSelectedIndex()));
                    
                try {
                    if(controlDB_Unidad.registrarUnidad(unid)==1){
                        JOptionPane.showMessageDialog(null, "Registro de Unidad Exitoso");
                        descripcion.setText("");
                        estado.setSelectedIndex(0);
                    }else{
                        JOptionPane.showMessageDialog(null, "Error al registrar La unidad");    
                    }
                } catch (FileNotFoundException ex) {
                    JOptionPane.showMessageDialog(null, "Error al registrar Unidad");   
                }
            }else{
                JOptionPane.showMessageDialog(null, "Ya existe una unidad registrada con el mismo nombre", "Error al registrar", JOptionPane.INFORMATION_MESSAGE);
            }      
       }
    }//GEN-LAST:event_registrarUnidad1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel alertaNombre;
    private javax.swing.JTextField descripcion;
    private javax.swing.JComboBox<String> estado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton registrarUnidad1;
    // End of variables declaration//GEN-END:variables
}
