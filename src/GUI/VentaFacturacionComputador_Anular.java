package GUI;
import Controladores.ControlDB_Bodega;
import Controladores.ControlDB_Cliente;
import Controladores.ControlDB_VentaFacturacionComputador_AnulacionFactura;
import Controladores.ControlDB_VentaFacturacionComputador_ParametrosGenerales;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Modelos.Bodega;
import Modelos.Cliente;
import Modelos.FacturaVenta;
import Modelos.Usuario;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VentaFacturacionComputador_Anular extends javax.swing.JPanel {
    DefaultTableModel modelo;
    String datos;
    String [] titulo= {"Id_Venta No.","Dex","fechaVenta", "Bodega_Venta", "Nit_Cliente","Nombre_Cliente","Cant.Vendida","Valor_Total_Dolar_Ingresados","Valor_Total_Dolar_Calculados","Estado","NombreQuienElaboro"};
    String [] registro;  
    Usuario user;
    ControlDB_VentaFacturacionComputador_AnulacionFactura  ObjetoAnulacionFactura ;
    ControlDB_Bodega  controlDB_Bodega ;
    ControlDB_VentaFacturacionComputador_ParametrosGenerales ObjetoParametrosGenerales;

    public VentaFacturacionComputador_Anular(Usuario u) throws SQLException {
        user= u;
        initComponents();  
        ObjetoAnulacionFactura = new ControlDB_VentaFacturacionComputador_AnulacionFactura();
        controlDB_Bodega = new ControlDB_Bodega();
        ObjetoParametrosGenerales = new ControlDB_VentaFacturacionComputador_ParametrosGenerales();
        //Cargamos las Bodegas en la interfaz###############
       
        ArrayList<Bodega> listadoBodega = new ArrayList();
        listadoBodega=new ControlDB_Bodega().ListarBodegaActivas();
        for(int i=0; i< listadoBodega.size(); i++){
            editBodega.addItem(listadoBodega.get(i).getDescripcion());
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        VerFactura = new javax.swing.JPopupMenu();
        Editar = new javax.swing.JMenuItem();
        InformacionDEX = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        editDex = new javax.swing.JTextField();
        consultarVentas = new javax.swing.JButton();
        listar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        limpiar = new javax.swing.JButton();
        nombre = new javax.swing.JRadioButton();
        bodega = new javax.swing.JRadioButton();
        nit = new javax.swing.JRadioButton();
        editIdVenta = new javax.swing.JTextField();
        editNit = new javax.swing.JTextField();
        Dex = new javax.swing.JRadioButton();
        editNombre = new javax.swing.JTextField();
        fechaCompraInicio = new com.toedter.calendar.JDateChooser();
        idVenta = new javax.swing.JRadioButton();
        editBodega = new javax.swing.JComboBox<>();
        compra = new javax.swing.JRadioButton();
        alertaGeneral = new javax.swing.JLabel();
        fechaCompraFinal = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        editColorSelect = new javax.swing.JComboBox<>();
        alertaColor = new javax.swing.JRadioButton();
        cargarColor = new javax.swing.JRadioButton();
        jLabel15 = new javax.swing.JLabel();

        Editar.setText("AnularFactura");
        Editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarActionPerformed(evt);
            }
        });
        VerFactura.add(Editar);

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        InformacionDEX.setBackground(new java.awt.Color(255, 255, 255));
        InformacionDEX.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        InformacionDEX.setText("?");
        InformacionDEX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InformacionDEXActionPerformed(evt);
            }
        });
        add(InformacionDEX, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 130, 50, 30));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 153, 153));
        jLabel8.setText("ANULAR FACTURAS DE VENTA A COMPUTADOR");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 430, 20));
        add(editDex, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 160, 210, 30));

        consultarVentas.setBackground(new java.awt.Color(255, 255, 255));
        consultarVentas.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        consultarVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/Bodega_Actualizar_Bton_Buscar.PNG"))); // NOI18N
        consultarVentas.setText("CONSULTAR");
        consultarVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultarVentasActionPerformed(evt);
            }
        });
        add(consultarVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 20, 140, 40));

        listar.setBackground(new java.awt.Color(255, 255, 255));
        listar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        listar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/Interfaz_Icon_Listar.PNG"))); // NOI18N
        listar.setText("LISTAR");
        listar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listarActionPerformed(evt);
            }
        });
        add(listar, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 120, 140, 40));

        tabla = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tabla.setBackground(new java.awt.Color(204, 204, 204));
        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tabla.setComponentPopupMenu(VerFactura);
        tabla.setFocusable(false);
        tabla.setSelectionBackground(new java.awt.Color(255, 102, 102));
        tabla.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tabla);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 1060, 280));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Inicio");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 70, -1, -1));

        limpiar.setBackground(new java.awt.Color(255, 255, 255));
        limpiar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        limpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/Interfaz_Icon_Borrar.PNG"))); // NOI18N
        limpiar.setText("LIMPIAR");
        limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarActionPerformed(evt);
            }
        });
        add(limpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 70, 140, 40));

        nombre.setBackground(new java.awt.Color(255, 255, 255));
        nombre.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nombre.setText("Nombre Cliente");
        add(nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        bodega.setBackground(new java.awt.Color(255, 255, 255));
        bodega.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        bodega.setText("Bodega");
        add(bodega, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 40, -1, -1));

        nit.setBackground(new java.awt.Color(255, 255, 255));
        nit.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nit.setText("Nit Cliente");
        add(nit, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        editIdVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editIdVentaActionPerformed(evt);
            }
        });
        add(editIdVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 40, 210, 30));
        add(editNit, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 80, 210, 30));

        Dex.setBackground(new java.awt.Color(255, 255, 255));
        Dex.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Dex.setText("Dex");
        add(Dex, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, -1));
        add(editNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, 210, 30));

        fechaCompraInicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fechaCompraInicioMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                fechaCompraInicioMouseEntered(evt);
            }
        });
        add(fechaCompraInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 90, 130, 30));

        idVenta.setBackground(new java.awt.Color(255, 255, 255));
        idVenta.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        idVenta.setText("Código_Factura Venta");
        add(idVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        add(editBodega, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 40, 260, 30));

        compra.setBackground(new java.awt.Color(255, 255, 255));
        compra.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        compra.setText("Fecha Venta");
        add(compra, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 80, -1, 40));

        alertaGeneral.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        alertaGeneral.setForeground(new java.awt.Color(255, 51, 51));
        add(alertaGeneral, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 1060, 30));

        fechaCompraFinal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fechaCompraFinalMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                fechaCompraFinalMouseEntered(evt);
            }
        });
        add(fechaCompraFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 90, 120, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Fin");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 70, -1, -1));

        editColorSelect.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "VERDE", "AMARILLO", "ROJO" }));
        add(editColorSelect, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 130, 210, 30));

        alertaColor.setBackground(new java.awt.Color(255, 255, 255));
        alertaColor.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        alertaColor.setText("Alerta Cambiar Dex");
        add(alertaColor, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 120, -1, 40));

        cargarColor.setBackground(new java.awt.Color(255, 255, 255));
        cargarColor.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cargarColor.setText("Color Modificar Dex");
        add(cargarColor, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 160, -1, 40));

        jLabel15.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Filtros", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Adobe Arabic", 1, 14))); // NOI18N
        add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 830, 180));
    }// </editor-fold>//GEN-END:initComponents

    private void consultarVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarVentasActionPerformed
        //Eliminamos la Busqueda Actual#######################################################
        DefaultTableModel md =(DefaultTableModel)tabla.getModel();
        int CantEliminar= tabla.getRowCount() -1;
        for(int i =CantEliminar; i>=0; i--){
            md.removeRow(i);
        }
        String Script="";
        boolean validarConsulta = true;
        if(idVenta.isSelected()){
            if(editIdVenta.getText().equals("")){
                alertaGeneral.setText("Mensaje: El Código de Factura de Venta a Computador no puede estar Vacio");
                validarConsulta=false;
            }else{
                if(Script.equals("")){
                    Script += " [facturaVenta].[id] like '%"+editIdVenta.getText()+"%' ";
                }else{
                    Script += " and [facturaVenta].[id] like '%"+editIdVenta.getText()+"%' ";
                }
            }
        }
        if(nit.isSelected()){
            if(editNit.getText().equals("")){
                alertaGeneral.setText("Mensaje: El Nit no puede estar Vacio");
                validarConsulta=false;
            }else{
                Script += " [facturaVenta].[cliente_nit] like '%"+editNit.getText()+"%'";
            }
        }
        if(nombre.isSelected()){
            if(editNombre.getText().equals("")){
                alertaGeneral.setText("Mensaje: El Nombre no puede estar Vacio");
                validarConsulta=false;
            }else{
                if(Script.equals("")){
                    Script += " [cliente].[nombre] like '%"+editNombre.getText()+"%' ";
                }else{
                    Script += " and [cliente].[nombre] like '%"+editNombre.getText()+"%' ";
                }
            }
        }
         if(Dex.isSelected()){
            if(editDex.getText().equals("")){
                alertaGeneral.setText("Mensaje: El Número de Dex no puede estar Vacio");
                validarConsulta=false;
            }else{
                if(Script.equals("")){
                    Script += " [facturaVenta].[dex] like '%"+editDex.getText()+"%' ";
                }else{
                    Script += " and [facturaVenta].[dex] like '%"+editDex.getText()+"%' ";
                }
            }
        }

         if(bodega.isSelected()){
            ControlDB_Bodega controlDB_Bodega = new ControlDB_Bodega();
            int idBodega=controlDB_Bodega.RetornoIdBodega(editBodega.getSelectedItem().toString());   
            if(Script.equals("")){ 
                Script += " [facturaVenta].[bodegaFacturaVenta_id] = '"+idBodega+"'  ";
            }else{
                Script += "  and [facturaVenta].[bodegaFacturaVenta_id] = '"+idBodega+"'  "; 
            }
        } 
         if(compra.isSelected()){
              try{
                Calendar fechaI = fechaCompraInicio.getCalendar();
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
                String fechaVentaI=anoI+"-"+mesI+"-"+diaI;
                
                
                Calendar fechaF = fechaCompraFinal.getCalendar();
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
                String fechaVentaF=anoF+"-"+mesF+"-"+diaF;
                            if(Script.equals("")){
                                //Script += " fechaCompra BETWEEN '"+fechaCompraI+"' and '"+fechaCompraF+"' ";
                                Script += " [facturaVenta].[fechaFactura]  BETWEEN CAST('"+fechaVentaI+"' AS DATE) AND CAST('"+fechaVentaF+"' AS DATE) ";
                            }else{
                                 //Script += " and fechaCompra BETWEEN '"+fechaCompraI+"' and '"+fechaCompraF+"' ";
                                 Script += " AND [facturaVenta].[fechaFactura]  BETWEEN CAST('"+fechaVentaI+"' AS DATE) AND CAST('"+fechaVentaF+"' AS DATE) ";
                            }
              }catch(Exception e){
                  alertaGeneral.setText("Mensaje: Verifique Fecha:");
                  validarConsulta=false;
              }            
        }      
        if(validarConsulta){
            try {
                //Eliminamos la Busqueda Actual#######################################################
                DefaultTableModel model =(DefaultTableModel)tabla.getModel();
                int CantiEliminar= tabla.getRowCount() -1;
                for(int i =CantiEliminar; i>=0; i--){
                    model.removeRow(i);
                }
                
                if(nit.isSelected() || nombre.isSelected() || Dex.isSelected() || idVenta.isSelected() || bodega.isSelected()|| compra.isSelected()){
                     tabla(" Where "+Script);
                }else{
                     tabla("");
                }
                if(cargarColor.isSelected()){
                    tabla.setDefaultRenderer(Object.class, new Myrender_Ventas(2));
                }else{
                    if(!cargarColor.isSelected()){
                        tabla.setDefaultRenderer(Object.class, new Myrender_VentasTablaPorDefecto(2));
                    }
                }
                if(alertaColor.isSelected()){
                    tabla.setDefaultRenderer(Object.class, new Myrender_Ventas(2));
                }
            } catch (SQLException ex) {
                Logger.getLogger(VentaFacturacionComputador_Anular.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(VentaFacturacionComputador_Anular.class.getName()).log(Level.SEVERE, null, ex);
            }
        }  
    }//GEN-LAST:event_consultarVentasActionPerformed

    private void listarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listarActionPerformed
        try {
            tabla("");
        } catch (SQLException ex) {
            Logger.getLogger(VentaFacturacionComputador_Anular.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(VentaFacturacionComputador_Anular.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }//GEN-LAST:event_listarActionPerformed

    private void limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarActionPerformed
            //Limpiamos los Campos de Texto
            editNit.setText("");
            editNombre.setText("");
            editDex.setText("");
            editIdVenta.setText("");
            //Deshabilitamos los Select
            nit.setSelected(false);
            nombre.setSelected(false);
            Dex.setSelected(false);
            idVenta.setSelected(false);
            bodega.setSelected(false);
            compra.setSelected(false);
            alertaColor.setSelected(false);
    }//GEN-LAST:event_limpiarActionPerformed

    private void editIdVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editIdVentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editIdVentaActionPerformed

    private void fechaCompraInicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fechaCompraInicioMouseClicked
        alertaGeneral.setText("");
    }//GEN-LAST:event_fechaCompraInicioMouseClicked

    private void fechaCompraInicioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fechaCompraInicioMouseEntered
        alertaGeneral.setText("");
    }//GEN-LAST:event_fechaCompraInicioMouseEntered

    private void fechaCompraFinalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fechaCompraFinalMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_fechaCompraFinalMouseClicked

    private void fechaCompraFinalMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fechaCompraFinalMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_fechaCompraFinalMouseEntered

    private void EditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarActionPerformed
        // TODO lo del clik derechoo
        int fila1;
        String buscar="";
        try{
            fila1=tabla.getSelectedRow();
            if(fila1==-1){
                JOptionPane.showMessageDialog(null,"no se ha seleccionando ninguna fila");
            }
            else{
                try{
                    modelo=(DefaultTableModel)tabla.getModel();
                    String idFacturaVenta=(String)modelo.getValueAt(fila1, 0);
                    String Bodega=(String)modelo.getValueAt(fila1, 3);
                    String estado = (String)modelo.getValueAt(fila1, 9);
                    if(!estado.equals("Activo")){
                        JOptionPane.showMessageDialog(null, "La factura ya se encuentra anulada, no se puede Anular");
                    }else{
                        //Procedemos a Anular la factura
                        if(Bodega.equals("Extranjera")){//Anulamos Factura Extranjera
                            ObjetoAnulacionFactura.anularFacturaVenta(Integer.parseInt(idFacturaVenta), Bodega, user);
                            tabla("");
                        }else{
                            if(Bodega.equals("Nacional")){//Anulamos Factura Nacional
                                ObjetoAnulacionFactura.anularFacturaVenta(Integer.parseInt(idFacturaVenta), Bodega, user);
                                tabla("");
                            }
                        }
                    }  
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, "No se pudo cargar el proveedor");
                }
            }
        }catch(Exception e){
        }
    }//GEN-LAST:event_EditarActionPerformed

    private void InformacionDEXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InformacionDEXActionPerformed
        JOptionPane.showMessageDialog(null, "INFORMACIÓN SOBRE COLORES:"
                                        + "\nVerde: Al Dex le falta de 15 a 30 días para que ya no se pueda modificar"
                                        + "\nAmarillo: Al Dex le falta de 5 a 15 días para que ya no se pueda modificar"
                                        + "\nRojo: Al Dex le falta menos de 4 días para que ya no se pueda modificar"
                                        + "\n\nRecuerde que el Dex tiene solo un mes para Dejarse Modificar");      
    }//GEN-LAST:event_InformacionDEXActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton Dex;
    private javax.swing.JMenuItem Editar;
    private javax.swing.JButton InformacionDEX;
    private javax.swing.JPopupMenu VerFactura;
    private javax.swing.JRadioButton alertaColor;
    private javax.swing.JLabel alertaGeneral;
    private javax.swing.JRadioButton bodega;
    private javax.swing.JRadioButton cargarColor;
    private javax.swing.JRadioButton compra;
    private javax.swing.JButton consultarVentas;
    private javax.swing.JComboBox<String> editBodega;
    private javax.swing.JComboBox<String> editColorSelect;
    private javax.swing.JTextField editDex;
    private javax.swing.JTextField editIdVenta;
    private javax.swing.JTextField editNit;
    private javax.swing.JTextField editNombre;
    private com.toedter.calendar.JDateChooser fechaCompraFinal;
    private com.toedter.calendar.JDateChooser fechaCompraInicio;
    private javax.swing.JRadioButton idVenta;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton limpiar;
    private javax.swing.JButton listar;
    private javax.swing.JRadioButton nit;
    private javax.swing.JRadioButton nombre;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
    public void tabla(String script) throws SQLException, ParseException{
        registro = new String[11]; 
        modelo = new DefaultTableModel(null, titulo);
        ArrayList<FacturaVenta> listadoVentas=ObjetoParametrosGenerales.consultarVentasGeneral(script);
       
        if(alertaColor.isSelected()){
            for(int i =0; i< listadoVentas.size(); i++){
                if(diferenciaFecha(listadoVentas.get(i).getFechaFactura()).equals(editColorSelect.getSelectedItem().toString())){
                    registro[0]=""+listadoVentas.get(i).getId();
                    registro[1]=""+listadoVentas.get(i).getDex();
                    registro[2]=""+listadoVentas.get(i).getFechaFactura();
                    registro[3]=""+new ControlDB_Bodega().RetornoNombreBodega(listadoVentas.get(i).getBodegaFacturaVenta_id());
                    registro[4]=""+listadoVentas.get(i).getCliente_nit();
                     //Consultamos el Nombre del proveedor atravez del Nit y sucursal
                    ControlDB_Cliente controlDB_Cliente = new ControlDB_Cliente();
                    Cliente cli = new Cliente();
                    cli.setNit(listadoVentas.get(i).getCliente_nit());
                    cli.setSucursal(listadoVentas.get(i).getCliente_sucursal());

                    ArrayList<Cliente> listadoCliente=controlDB_Cliente.consultarUnicoCliente(cli);
                    for(int a =0; a< listadoCliente.size(); a++){ 
                        registro[5]=""+listadoCliente.get(a).getNombre(); 
                    }     
                    ControlDB_VentaFacturacionComputador_AnulacionFactura controlDB_VentasAnulacion = new ControlDB_VentaFacturacionComputador_AnulacionFactura();
                    registro[6]=""+controlDB_VentasAnulacion.retornarCantidadTotalFacturaVenta(listadoVentas.get(i).getId());
                    registro[7]=""+listadoVentas.get(i).getValorTotalEnDolarIngresados();
                    registro[8]=""+listadoVentas.get(i).getValorTotalEnDolarCalculados();
                    registro[9]=""+validarEstado(listadoVentas.get(i).getEstado());
                    registro[10]=""+listadoVentas.get(i).getNombreQuienElabora();              
                    modelo.addRow(registro);
                    tabla.setModel(modelo);
                }
            }
        }else{
            for(int i =0; i< listadoVentas.size(); i++){
                registro[0]=""+listadoVentas.get(i).getId();
                registro[1]=""+listadoVentas.get(i).getDex();
                registro[2]=""+listadoVentas.get(i).getFechaFactura();
                registro[3]=""+new ControlDB_Bodega().RetornoNombreBodega(listadoVentas.get(i).getBodegaFacturaVenta_id());
                registro[4]=""+listadoVentas.get(i).getCliente_nit();
                 //Consultamos el Nombre del proveedor atravez del Nit y sucursal
                    ControlDB_Cliente controlDB_Cliente = new ControlDB_Cliente();
                    Cliente cli = new Cliente();
                    cli.setNit(listadoVentas.get(i).getCliente_nit());
                    cli.setSucursal(listadoVentas.get(i).getCliente_sucursal());

                    ArrayList<Cliente> listadoCliente=controlDB_Cliente.consultarUnicoCliente(cli);
                    for(int a =0; a< listadoCliente.size(); a++){ 
                        registro[5]=""+listadoCliente.get(a).getNombre(); 
                    } 
                registro[6]=""+new ControlDB_VentaFacturacionComputador_AnulacionFactura().retornarCantidadTotalFacturaVenta(listadoVentas.get(i).getId());
                registro[7]=""+listadoVentas.get(i).getValorTotalEnDolarIngresados();
                registro[8]=""+listadoVentas.get(i).getValorTotalEnDolarCalculados();
                registro[9]=""+validarEstado(listadoVentas.get(i).getEstado());
                registro[10]=""+listadoVentas.get(i).getNombreQuienElabora();              
                modelo.addRow(registro);
                tabla.setModel(modelo);
            }
        }
    }
    public String diferenciaFecha(String fechaMaximaExportacion) throws ParseException{
        Date fechaActual = new Date(); 
        String  Fecha =new SimpleDateFormat("yyyy-MM-dd").format(fechaActual);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaHoy=dateFormat.parse(Fecha);
        Date fechaDevo=dateFormat.parse(fechaMaximaExportacion);
        int diasAtraso=(int) ((fechaHoy.getTime()-fechaDevo.getTime())/86400000);
        if(diasAtraso >= 15 && diasAtraso <= 30){
           return "ROJO";
        }else{
            if(diasAtraso >= 5 && diasAtraso < 15){
                return "AMARILLO";
            }else{
                if(diasAtraso >= 1 && diasAtraso < 4){
                    
                     return "VERDE";
                }else{
                    return "";//No colocar ningun color
                }
            }
        }         
    }
    public String validarEstado(int valor){
        String retorno="";
        switch(valor){
            case 1:{
                retorno= "Activo";
                break;
            }
            case 0:{
                retorno= "Anulada";
                break;
            }
            default:{
                retorno= "Anulada";
                break;
            }
        }
        return retorno;
    }
}
