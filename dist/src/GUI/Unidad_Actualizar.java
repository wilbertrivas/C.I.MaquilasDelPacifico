package GUI;

import Controladores.ControlDB_DB;
import Controladores.ControlDB_Otros;
import Controladores.ControlDB_Unidad;
import Modelos.Unidad;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Unidad_Actualizar extends javax.swing.JPanel {
    DefaultTableModel modelo;
    String datos; 
    String [] titulo= {"CODIGO","NOMBRE", "ESTADO"};
    String [] registro;
    Controladores.ControlDB_DB ControlDB = new ControlDB_DB();
    private Connection conexion=null;
    String accion="";
    public Unidad_Actualizar() {
        initComponents();
        conexion=ControlDB.ConectarBaseDatos();
        codigoA.setEnabled(false);
        descripcionA.setEnabled(false);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Seleccionar = new javax.swing.JPopupMenu();
        Editar = new javax.swing.JMenuItem();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        codigoB = new javax.swing.JTextField();
        Btn_buscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table1 = new javax.swing.JTable();
        codigoA = new javax.swing.JTextField();
        descripcionA = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        estadoA = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        actualizar = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();
        limpiar = new javax.swing.JButton();

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
        jLabel7.setText("ACTUALIZAR UNIDAD");
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

        Btn_buscar.setBackground(new java.awt.Color(255, 255, 255));
        Btn_buscar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Btn_buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/Bodega_Actualizar_Bton_Buscar.PNG"))); // NOI18N
        Btn_buscar.setText("BUSCAR");
        Btn_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Btn_buscarActionPerformed(evt);
            }
        });
        add(Btn_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 30, 140, -1));

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

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 100, 620, 260));
        add(codigoA, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, 220, 30));
        add(descripcionA, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, 220, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("ESTADO:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 230, 90, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("NOMBRE:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, 120, 30));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("CODIGO:");
        add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, 60, 30));
        add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 1050, 10));

        estadoA.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));
        add(estadoA, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 230, 220, 30));

        jLabel15.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DATOS", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Adobe Arabic", 1, 14))); // NOI18N
        add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 370, 180));

        actualizar.setBackground(new java.awt.Color(255, 255, 255));
        actualizar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        actualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/Bodega_Actualizar_Bton_Actualizar.PNG"))); // NOI18N
        actualizar.setText("ACTUALIZAR ");
        actualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                actualizarMouseClicked(evt);
            }
        });
        add(actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 170, 50));

        cancelar.setBackground(new java.awt.Color(255, 255, 255));
        cancelar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/Bodega_Actualizar_Bton_Cancelar.PNG"))); // NOI18N
        cancelar.setText("CANCELAR");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });
        add(cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 290, 170, 50));

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
    }// </editor-fold>//GEN-END:initComponents

    private void Btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Btn_buscarActionPerformed
        String valor=codigoB.getText();
        Table1.show();
        try {
            tabla(valor);
        } catch (SQLException ex) {
            Logger.getLogger(Unidad_Actualizar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_Btn_buscarActionPerformed

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
                Unidad uni = new Unidad();
                uni.setId(Integer.parseInt((String)modelo.getValueAt(fila1, 0)));
                consultarParaActualizar(uni);
                codigoA.setEnabled(false);
                descripcionA.setEnabled(true);
                estadoA.setEnabled(true);
           }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al buscar la Unidad, verifique Datos");
        }
    }//GEN-LAST:event_EditarActionPerformed

    private void actualizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_actualizarMouseClicked
        if(codigoA.getText().equalsIgnoreCase("")){
            JOptionPane.showMessageDialog(null, "El Campo Cogido no puede estar vacio");
        }
        else{
            if(descripcionA.getText().equalsIgnoreCase("")){
                JOptionPane.showMessageDialog(null, "El Campo Nombre no puede estar vacio");
            }
            else{
                try{
                    Integer.parseInt(codigoA.getText());
                    Unidad u = new Unidad();
                    u.setId(Integer.parseInt(codigoA.getText()));
                    u.setDescripcion(descripcionA.getText());
                    String estadoD="";
                    if(estadoA.getSelectedIndex()==0){
                        estadoD="1";
                    }else{
                        estadoD="0";
                    }
                    u.setEstado(Integer.parseInt(estadoD));
                    if(codigoA.equals("")){
                        JOptionPane.showMessageDialog(null, "Datos vacio");
                    }
                    else{
                        ControlDB_Unidad controlUnidad = new ControlDB_Unidad();
                        int retorno = controlUnidad.actualizarUnidad(u);
                        if(retorno ==1){
                            JOptionPane.showMessageDialog(null, "Actualización Exitosa");
                            tabla("");
                            codigoA.setText("");
                            descripcionA.setText("");
                            estadoA.setSelectedIndex(0);
                        }else{
                            JOptionPane.showMessageDialog(null, "Error al Actualizar Verifique Datos");
                        }                      
                    }
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, "El Campo codigo solo debe de tener Valores Numericos");
                }
            }
        }
    }//GEN-LAST:event_actualizarMouseClicked

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        codigoA.setText("");
        descripcionA.setText("");
        estadoA.setSelectedIndex(0);
    }//GEN-LAST:event_cancelarActionPerformed

    private void limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarActionPerformed
        codigoB.setText("");
    }//GEN-LAST:event_limpiarActionPerformed

    private void codigoBKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codigoBKeyPressed
         String valor=codigoB.getText();
        Table1.show();
        try {
            tabla(valor);
        } catch (SQLException ex) {
            Logger.getLogger(Unidad_Actualizar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_codigoBKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Btn_buscar;
    private javax.swing.JMenuItem Editar;
    private javax.swing.JPopupMenu Seleccionar;
    private javax.swing.JTable Table1;
    private javax.swing.JButton actualizar;
    private javax.swing.JButton cancelar;
    private javax.swing.JTextField codigoA;
    private javax.swing.JTextField codigoB;
    private javax.swing.JTextField descripcionA;
    private javax.swing.JComboBox<String> estadoA;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton limpiar;
    // End of variables declaration//GEN-END:variables
 public void tabla(String valorConsulta) throws SQLException{
        registro = new String[3]; 
        modelo = new DefaultTableModel(null, titulo);
        ControlDB_Unidad controlDB_Unidad = new ControlDB_Unidad();
        ControlDB_Otros controlOtros = new ControlDB_Otros();
        ArrayList<Unidad> listadoUnidad=controlDB_Unidad.buscarUnidad(valorConsulta);
        for(int i =0; i< listadoUnidad.size(); i++){
            registro[0]=""+listadoUnidad.get(i).getId();
            registro[1]=""+listadoUnidad.get(i).getDescripcion();
            registro[2]=""+controlOtros.convertidorEstadoID_x_Nombre(listadoUnidad.get(i).getEstado());
            modelo.addRow(registro);
            Table1.setModel(modelo);
        } 
    }
    public void consultarParaActualizar (Unidad uni) throws SQLException{
        ControlDB_Unidad controlUnidad = new ControlDB_Unidad();
        ControlDB_Otros  controlOtros = new ControlDB_Otros();
        ArrayList<Unidad> listadoUnidad = controlUnidad.consultarUnicoUnidad(uni);
        for(int i =0; i< listadoUnidad.size(); i++){      
            codigoA.setText(""+listadoUnidad.get(i).getId());
            descripcionA.setText(""+listadoUnidad.get(i).getDescripcion());
            estadoA.setSelectedItem(controlOtros.convertidorEstadoID_x_Nombre(listadoUnidad.get(i).getEstado()));    
        } 
    }
}
