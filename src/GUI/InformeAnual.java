package GUI;

import Reportes.Generar_Reportes;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class InformeAnual extends javax.swing.JPanel {
    DefaultTableModel modelo;
    String datos;
    String [] titulo= {"Entrada Alm. No","CP","Nit_Proveedor", "Nombre_Proveedor", "No_Factura","Bodega","Producto","Fecha_Compra","FechaMaxima_Exportación","Cant_Inicial","SaldoEnBodega"};
    String [] registro;  
    public InformeAnual(){
        initComponents();  
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        VerFactura = new javax.swing.JPopupMenu();
        Editar = new javax.swing.JMenuItem();
        jLabel8 = new javax.swing.JLabel();
        consultar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        fechaVentaI = new com.toedter.calendar.JDateChooser();
        select_FechaVenta = new javax.swing.JRadioButton();
        alertaGeneral = new javax.swing.JLabel();
        fechaVentaF = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        consultar1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        fechaCompraI = new com.toedter.calendar.JDateChooser();
        select_FechaCompra = new javax.swing.JRadioButton();
        fechaCompraF = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        Editar.setText("VerFactura");
        Editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarActionPerformed(evt);
            }
        });
        VerFactura.add(Editar);

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 153, 153));
        jLabel8.setText("INFORME ANUAL VENTAS");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 430, 20));

        consultar.setBackground(new java.awt.Color(255, 255, 255));
        consultar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        consultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/Bodega_Actualizar_Bton_Buscar.PNG"))); // NOI18N
        consultar.setText("CONSULTAR");
        consultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultarActionPerformed(evt);
            }
        });
        add(consultar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 130, 150, 50));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Inicio");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 60, -1, -1));

        fechaVentaI.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fechaVentaIMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                fechaVentaIMouseEntered(evt);
            }
        });
        add(fechaVentaI, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, 190, 30));

        select_FechaVenta.setBackground(new java.awt.Color(255, 255, 255));
        select_FechaVenta.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        select_FechaVenta.setText("Fecha de Ventas");
        add(select_FechaVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, 40));

        alertaGeneral.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        alertaGeneral.setForeground(new java.awt.Color(255, 51, 51));
        add(alertaGeneral, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 400, 320, 20));

        fechaVentaF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fechaVentaFMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                fechaVentaFMouseEntered(evt);
            }
        });
        add(fechaVentaF, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 80, 190, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Fin");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 60, -1, -1));

        jLabel15.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Filtros", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Adobe Arabic", 1, 14))); // NOI18N
        add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 590, 170));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 153, 153));
        jLabel9.setText("INFORME ANUAL COMPRA");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 430, 20));

        consultar1.setBackground(new java.awt.Color(255, 255, 255));
        consultar1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        consultar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/Bodega_Actualizar_Bton_Buscar.PNG"))); // NOI18N
        consultar1.setText("CONSULTAR");
        consultar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultar1ActionPerformed(evt);
            }
        });
        add(consultar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 340, 150, 50));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Inicio");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 270, -1, -1));

        fechaCompraI.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fechaCompraIMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                fechaCompraIMouseEntered(evt);
            }
        });
        add(fechaCompraI, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 290, 190, 30));

        select_FechaCompra.setBackground(new java.awt.Color(255, 255, 255));
        select_FechaCompra.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        select_FechaCompra.setText("Fecha de Compras");
        add(select_FechaCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, -1, 40));

        fechaCompraF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fechaCompraFMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                fechaCompraFMouseEntered(evt);
            }
        });
        add(fechaCompraF, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 290, 190, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Fin");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 270, -1, -1));

        jLabel16.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Filtros", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Adobe Arabic", 1, 14))); // NOI18N
        add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 590, 160));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/GUI_Iniciar_camarones.png"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 30, 460, 310));
    }// </editor-fold>//GEN-END:initComponents

    private void consultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarActionPerformed
        if(select_FechaVenta.isSelected() ){
            try{
                Calendar fechaI = fechaVentaI.getCalendar();
                String anoI = ""+fechaI.get(Calendar.YEAR);
                String mesI = "";
                if((fechaI.get(Calendar.MONTH) +1) <=9){
                                mesI = "0"+(fechaI.get(Calendar.MONTH) + 1);
                }else{
                    mesI = ""+(fechaI.get(Calendar.MONTH) + 1);
                }
                String diaI = "";
                if(fechaI.get(Calendar.DAY_OF_MONTH) <=9){
                    diaI = "0"+fechaI.get(Calendar.DAY_OF_MONTH);
                }else{
                    diaI = ""+fechaI.get(Calendar.DAY_OF_MONTH);
                }
                String fechaVentaInicio=anoI+"-"+mesI+"-"+diaI;


                Calendar fechaF = fechaVentaF.getCalendar();
                String anoF = ""+fechaF.get(Calendar.YEAR);
                String mesF = "";
                if((fechaF.get(Calendar.MONTH) +1) <=9){
                                mesF = "0"+(fechaF.get(Calendar.MONTH) + 1);
                }else{
                    mesF = ""+(fechaF.get(Calendar.MONTH) + 1);
                }
                String diaF = "";
                if(fechaF.get(Calendar.DAY_OF_MONTH) <=9){
                    diaF = "0"+fechaF.get(Calendar.DAY_OF_MONTH);
                }else{
                    diaF = ""+fechaF.get(Calendar.DAY_OF_MONTH);
                }
                String fechaVentaFinal=anoF+"-"+mesF+"-"+diaF;
                Generar_Reportes generar_Reportes = new Generar_Reportes();
                generar_Reportes.generar_InformeAnual_Por_RangoFecha_VentasTodas(fechaVentaInicio, fechaVentaFinal);

            }catch(Exception e){
               JOptionPane.showMessageDialog(null, "Verifique formatos de fechas");
           }  
        }              
    }//GEN-LAST:event_consultarActionPerformed

    private void fechaVentaIMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fechaVentaIMouseClicked
        alertaGeneral.setText("");
    }//GEN-LAST:event_fechaVentaIMouseClicked

    private void fechaVentaIMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fechaVentaIMouseEntered
        alertaGeneral.setText("");
    }//GEN-LAST:event_fechaVentaIMouseEntered

    private void fechaVentaFMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fechaVentaFMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_fechaVentaFMouseClicked

    private void fechaVentaFMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fechaVentaFMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_fechaVentaFMouseEntered

    private void EditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarActionPerformed
     
    }//GEN-LAST:event_EditarActionPerformed

    private void consultar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultar1ActionPerformed
        if(select_FechaCompra.isSelected() ){
            try{
                Calendar fechaI = fechaCompraI.getCalendar();
                String anoI = ""+fechaI.get(Calendar.YEAR);
                String mesI = "";
                if((fechaI.get(Calendar.MONTH) +1) <=9){
                                mesI = "0"+(fechaI.get(Calendar.MONTH) + 1);
                }else{
                    mesI = ""+(fechaI.get(Calendar.MONTH) + 1);
                }
                String diaI = "";
                if(fechaI.get(Calendar.DAY_OF_MONTH) <=9){
                    diaI = "0"+fechaI.get(Calendar.DAY_OF_MONTH);
                }else{
                    diaI = ""+fechaI.get(Calendar.DAY_OF_MONTH);
                }
                String fechaVentaInicio=anoI+"-"+mesI+"-"+diaI;


                Calendar fechaF = fechaCompraF.getCalendar();
                String anoF = ""+fechaF.get(Calendar.YEAR);
                String mesF = "";
                if((fechaF.get(Calendar.MONTH) +1) <=9){
                                mesF = "0"+(fechaF.get(Calendar.MONTH) + 1);
                }else{
                    mesF = ""+(fechaF.get(Calendar.MONTH) + 1);
                }
                String diaF = "";
                if(fechaF.get(Calendar.DAY_OF_MONTH) <=9){
                    diaF = "0"+fechaF.get(Calendar.DAY_OF_MONTH);
                }else{
                    diaF = ""+fechaF.get(Calendar.DAY_OF_MONTH);
                }
                String fechaVentaFinal=anoF+"-"+mesF+"-"+diaF;
                Generar_Reportes generar_Reportes = new Generar_Reportes();
                generar_Reportes.generar_InformeAnual_Por_RangoFecha_CompraTodas(fechaVentaInicio, fechaVentaFinal);

            }catch(Exception e){
               JOptionPane.showMessageDialog(null, "Verifique formatos de fechas");
           }  
        }     
    }//GEN-LAST:event_consultar1ActionPerformed

    private void fechaCompraIMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fechaCompraIMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_fechaCompraIMouseClicked

    private void fechaCompraIMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fechaCompraIMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_fechaCompraIMouseEntered

    private void fechaCompraFMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fechaCompraFMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_fechaCompraFMouseClicked

    private void fechaCompraFMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fechaCompraFMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_fechaCompraFMouseEntered


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Editar;
    private javax.swing.JPopupMenu VerFactura;
    private javax.swing.JLabel alertaGeneral;
    private javax.swing.JButton consultar;
    private javax.swing.JButton consultar1;
    private com.toedter.calendar.JDateChooser fechaCompraF;
    private com.toedter.calendar.JDateChooser fechaCompraI;
    private com.toedter.calendar.JDateChooser fechaVentaF;
    private com.toedter.calendar.JDateChooser fechaVentaI;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JRadioButton select_FechaCompra;
    private javax.swing.JRadioButton select_FechaVenta;
    // End of variables declaration//GEN-END:variables
   }
