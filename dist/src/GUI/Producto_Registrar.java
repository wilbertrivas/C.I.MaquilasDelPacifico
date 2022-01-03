package GUI;

import Controladores.ControlDB_Otros;
import Controladores.ControlDB_Producto;
import Controladores.ControlDB_Unidad;
import Modelos.Producto;
import Modelos.Unidad;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class Producto_Registrar extends javax.swing.JPanel {
    ControlDB_Unidad ControlDB_Unidad = new ControlDB_Unidad();
    public Producto_Registrar() throws SQLException {
        initComponents();
        
        //Cargamos en la interfaz las unidades
        ArrayList<Unidad> listadoUnidades = new ArrayList();
        listadoUnidades=ControlDB_Unidad.ListarUnidadActivas();
        for(int i=0; i< listadoUnidades.size(); i++){
            unidad.addItem(listadoUnidades.get(i).getDescripcion());
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        descripcion = new javax.swing.JTextField();
        estado = new javax.swing.JComboBox<>();
        alertaSubpartida = new javax.swing.JLabel();
        registrarUnidad1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        subPartida = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        unidad = new javax.swing.JComboBox<>();
        alertaNombre = new javax.swing.JLabel();
        tipo = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("TIPO:");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("ESTADO:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 70, 20));

        descripcion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                descripcionMouseClicked(evt);
            }
        });
        add(descripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 50, 310, 30));

        estado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));
        add(estado, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 240, 310, 30));

        alertaSubpartida.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        alertaSubpartida.setForeground(new java.awt.Color(255, 51, 51));
        add(alertaSubpartida, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 170, 310, 20));

        registrarUnidad1.setBackground(new java.awt.Color(255, 255, 255));
        registrarUnidad1.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        registrarUnidad1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/Bodega_Registrar_Bton_Registrar.PNG"))); // NOI18N
        registrarUnidad1.setText("REGISTRAR");
        registrarUnidad1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarUnidad1ActionPerformed(evt);
            }
        });
        add(registrarUnidad1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 290, 180, 40));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 30, 240, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("UNIDAD:");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 60, 20));

        subPartida.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                subPartidaMouseClicked(evt);
            }
        });
        add(subPartida, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 140, 310, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("SUBPARTIDA ARANCELARIA:");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, -1, 20));

        add(unidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 190, 310, 30));

        alertaNombre.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        alertaNombre.setForeground(new java.awt.Color(255, 51, 51));
        add(alertaNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, 310, 20));

        tipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Insumo", "Materia Prima" }));
        tipo.setToolTipText("");
        add(tipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 100, 310, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("NOMBRE:");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, 20));

        jLabel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "FORMULARIO REGISTRO PRODUCTO", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 590, 360));
    }// </editor-fold>//GEN-END:initComponents

    private void descripcionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_descripcionMouseClicked
        alertaNombre.setText("");
    }//GEN-LAST:event_descripcionMouseClicked

    private void registrarUnidad1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarUnidad1ActionPerformed
        if(descripcion.getText().equals("")){
            alertaNombre.setText("Error nombre de producto no puede estar vacio");
        }else{
            if(subPartida.getText().equals("")){
                alertaSubpartida.setText("Error la subPartida no puede estar vacia");
            }
            else{
                ControlDB_Producto controlDB_Producto = new ControlDB_Producto();
                ControlDB_Unidad controlDB_Unidad = new ControlDB_Unidad();
                ControlDB_Otros controlDBOtros = new ControlDB_Otros();
                Producto p = new Producto();
                p.setDescripcion(descripcion.getText());
                p.setTipo(tipo.getSelectedItem().toString());
                p.setSubpartidaArancelaria(subPartida.getText());
                p.setUnidad_id(controlDB_Unidad.validarTipoUnidad_ID_por_Nombre(unidad.getSelectedItem().toString()));
                p.setEstado(controlDBOtros.convertidorValorEstado(estado.getSelectedIndex()));
                
                if(controlDB_Producto.validarExistenciaProducto(descripcion.getText())==0){
                    int result=controlDB_Producto.registrarProducto(p);
                    if(result==1){
                        JOptionPane.showMessageDialog(null, "Registro Exitoso");
                        descripcion.setText("");
                        subPartida.setText("");
                        unidad.setSelectedIndex(0);
                        estado.setSelectedIndex(0);
                        alertaNombre.setText("");
                        alertaSubpartida.setText("");
                    }else{
                        JOptionPane.showMessageDialog(null, "No se pudo Registrar el Producto");
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Ya existe un producto registrado con el mismo nombre", "Error al registrar", JOptionPane.INFORMATION_MESSAGE);
                }            
            }
        }
    }//GEN-LAST:event_registrarUnidad1ActionPerformed

    private void subPartidaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_subPartidaMouseClicked
       alertaSubpartida.setText("");
    }//GEN-LAST:event_subPartidaMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel alertaNombre;
    private javax.swing.JLabel alertaSubpartida;
    private javax.swing.JTextField descripcion;
    private javax.swing.JComboBox<String> estado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JButton registrarUnidad1;
    private javax.swing.JTextField subPartida;
    private javax.swing.JComboBox<String> tipo;
    private javax.swing.JComboBox<String> unidad;
    // End of variables declaration//GEN-END:variables
}
