package GUI;

import Controladores.ControlDB_Bodega;
import Controladores.ControlDB_Cliente;
import Controladores.ControlDB_ConsumoAnulacion;
import Controladores.ControlDB_ConsumoGeneral;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Modelos.Cliente;
import Modelos.Consumo;
import Modelos.Usuario;
import Reportes.Generar_Reportes;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Consumo_Anular extends javax.swing.JPanel {
    DefaultTableModel modelo;
    String datos;
    String [] titulo= {"Id_Consumo No.","FechaConsumo", "Bodega", "Nit_Cliente","Nombre_Cliente","ValorTotalPesos","Estado","NombreQuienElabora"};
    String [] registro; 
    Usuario user;
    public Consumo_Anular(Usuario u) throws SQLException {
        user= u;
        initComponents();  
       
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        AnularConsumo = new javax.swing.JPopupMenu();
        Editar = new javax.swing.JMenuItem();
        jLabel8 = new javax.swing.JLabel();
        consultarVentas = new javax.swing.JButton();
        listar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        limpiar = new javax.swing.JButton();
        nit = new javax.swing.JRadioButton();
        editIdConsumo = new javax.swing.JTextField();
        editNit = new javax.swing.JTextField();
        fechaConsumoInicio = new com.toedter.calendar.JDateChooser();
        idConsumo = new javax.swing.JRadioButton();
        fechaConsumo = new javax.swing.JRadioButton();
        alertaGeneral = new javax.swing.JLabel();
        fechaConsumoFinal = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();

        Editar.setText("AnularConsumo");
        Editar.setToolTipText("");
        Editar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarActionPerformed(evt);
            }
        });
        AnularConsumo.add(Editar);

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 153, 153));
        jLabel8.setText("ANULAR CONSUMOS");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 430, 20));

        consultarVentas.setBackground(new java.awt.Color(255, 255, 255));
        consultarVentas.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        consultarVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/Bodega_Actualizar_Bton_Buscar.PNG"))); // NOI18N
        consultarVentas.setText("CONSULTAR");
        consultarVentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                consultarVentasMouseExited(evt);
            }
        });
        consultarVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultarVentasActionPerformed(evt);
            }
        });
        add(consultarVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 140, 40));

        listar.setBackground(new java.awt.Color(255, 255, 255));
        listar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        listar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/Interfaz_Icon_Listar.PNG"))); // NOI18N
        listar.setText("LISTAR");
        listar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listarActionPerformed(evt);
            }
        });
        add(listar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 170, 140, 40));

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
        tabla.setComponentPopupMenu(AnularConsumo);
        tabla.setFocusable(false);
        tabla.setSelectionBackground(new java.awt.Color(255, 102, 102));
        tabla.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tabla);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 1390, 390));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Inicio");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 30, -1, -1));

        limpiar.setBackground(new java.awt.Color(255, 255, 255));
        limpiar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        limpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/Interfaz_Icon_Borrar.PNG"))); // NOI18N
        limpiar.setText("LIMPIAR");
        limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarActionPerformed(evt);
            }
        });
        add(limpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 170, 140, 40));

        nit.setBackground(new java.awt.Color(255, 255, 255));
        nit.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nit.setText("Nit Empresa Consumidora:");
        add(nit, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        editIdConsumo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editIdConsumoActionPerformed(evt);
            }
        });
        add(editIdConsumo, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 40, 250, 30));
        add(editNit, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, 250, 30));

        fechaConsumoInicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fechaConsumoInicioMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                fechaConsumoInicioMouseEntered(evt);
            }
        });
        add(fechaConsumoInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 50, 120, 30));

        idConsumo.setBackground(new java.awt.Color(255, 255, 255));
        idConsumo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        idConsumo.setText("Id Consumo");
        add(idConsumo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        fechaConsumo.setBackground(new java.awt.Color(255, 255, 255));
        fechaConsumo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fechaConsumo.setText("Fecha Consumo");
        fechaConsumo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fechaConsumoActionPerformed(evt);
            }
        });
        add(fechaConsumo, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 40, -1, 40));

        alertaGeneral.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        alertaGeneral.setForeground(new java.awt.Color(255, 51, 51));
        add(alertaGeneral, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 1140, 30));

        fechaConsumoFinal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fechaConsumoFinalMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                fechaConsumoFinalMouseEntered(evt);
            }
        });
        add(fechaConsumoFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 50, 120, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Fin");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 30, -1, -1));

        jLabel15.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Filtros", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Adobe Arabic", 1, 14))); // NOI18N
        add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 970, 120));
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
        if(idConsumo.isSelected()){
            if(editIdConsumo.getText().equals("")){
                alertaGeneral.setText("Mensaje: El Código del consumo no puede estar Vacio");
                validarConsulta=false;
            }else{
                if(Script.equals("")){
                    Script += " [consumo].[id] like '%"+editIdConsumo.getText()+"%' ";
                }else{
                    Script += " and [consumo].[id] like '%"+editIdConsumo.getText()+"%' ";
                }
            }
        }
        if(nit.isSelected()){
            if(editNit.getText().equals("")){
                alertaGeneral.setText("Mensaje: El Nit no puede estar Vacio");
                validarConsulta=false;
            }else{
                 if(Script.equals("")){
                    Script += " [consumo].[cliente_nit] like '%"+editNit.getText()+"%'";
                }else{
                    Script += " and [consumo].[cliente_nit] like '%"+editNit.getText()+"%' ";
                }
                
            }
        }
        if(fechaConsumo.isSelected()){
            try{
                Calendar fechaI = fechaConsumoInicio.getCalendar();
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
                String fechaConsumoI=anoI+"-"+mesI+"-"+diaI;
                
                
                Calendar fechaF = fechaConsumoFinal.getCalendar();
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
                String fechaConsumoF=anoF+"-"+mesF+"-"+diaF;
                            if(Script.equals("")){
                                //Script += " fechaCompra BETWEEN '"+fechaCompraI+"' and '"+fechaCompraF+"' ";
                                Script += " [consumo].[fechaConsumo]  BETWEEN CAST('"+fechaConsumoI+"' AS DATE) AND CAST('"+fechaConsumoF+"' AS DATE) ";
                            }else{
                                 //Script += " and fechaCompra BETWEEN '"+fechaCompraI+"' and '"+fechaCompraF+"' ";
                                 Script += " AND [consumo].[fechaConsumo]  BETWEEN CAST('"+fechaConsumoI+"' AS DATE) AND CAST('"+fechaConsumoF+"' AS DATE) ";
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
                
                if(nit.isSelected() ||  idConsumo.isSelected() || fechaConsumo.isSelected()){
                     tabla(" Where "+Script);
                }else{
                     tabla("");
                }      
            } catch (SQLException ex) {
                Logger.getLogger(Consumo_Anular.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(Consumo_Anular.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    
    }//GEN-LAST:event_consultarVentasActionPerformed

    private void listarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listarActionPerformed
        try {
            tabla("");
        } catch (SQLException ex) {
            Logger.getLogger(Consumo_Anular.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Consumo_Anular.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }//GEN-LAST:event_listarActionPerformed

    private void limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarActionPerformed
            //Limpiamos los Campos de Texto
            editNit.setText("");
            editIdConsumo.setText("");

            //Deshabilitamos los Select
            nit.setSelected(false);
            idConsumo.setSelected(false);
            fechaConsumo.setSelected(false);

    }//GEN-LAST:event_limpiarActionPerformed

    private void editIdConsumoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editIdConsumoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editIdConsumoActionPerformed

    private void fechaConsumoInicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fechaConsumoInicioMouseClicked
        alertaGeneral.setText("");
    }//GEN-LAST:event_fechaConsumoInicioMouseClicked

    private void fechaConsumoInicioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fechaConsumoInicioMouseEntered
        alertaGeneral.setText("");
    }//GEN-LAST:event_fechaConsumoInicioMouseEntered

    private void fechaConsumoFinalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fechaConsumoFinalMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_fechaConsumoFinalMouseClicked

    private void fechaConsumoFinalMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fechaConsumoFinalMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_fechaConsumoFinalMouseEntered

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
                    String idConsumo=(String)modelo.getValueAt(fila1, 0);
                    String estado = (String)modelo.getValueAt(fila1, 6);
                    if(!estado.equals("Activo")){
                        JOptionPane.showMessageDialog(null, "El consumo ya se encuentra anulado, no se puede Anular");
                    }else{
                        ControlDB_ConsumoAnulacion controlDB_ConsumoAnulacion = new ControlDB_ConsumoAnulacion();
                        controlDB_ConsumoAnulacion.anularConsumo(Integer.parseInt(idConsumo), user);
                        tabla("");
                           
                    }
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, "No se pudo cargar el proveedor");
                }
            }
        }catch(Exception e){
        }
    }//GEN-LAST:event_EditarActionPerformed

    private void fechaConsumoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fechaConsumoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fechaConsumoActionPerformed

    private void consultarVentasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_consultarVentasMouseExited
       alertaGeneral.setText("");
    }//GEN-LAST:event_consultarVentasMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPopupMenu AnularConsumo;
    private javax.swing.JMenuItem Editar;
    private javax.swing.JLabel alertaGeneral;
    private javax.swing.JButton consultarVentas;
    private javax.swing.JTextField editIdConsumo;
    private javax.swing.JTextField editNit;
    private javax.swing.JRadioButton fechaConsumo;
    private com.toedter.calendar.JDateChooser fechaConsumoFinal;
    private com.toedter.calendar.JDateChooser fechaConsumoInicio;
    private javax.swing.JRadioButton idConsumo;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton limpiar;
    private javax.swing.JButton listar;
    private javax.swing.JRadioButton nit;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
    public void tabla(String script) throws SQLException, ParseException{
        registro = new String[8]; 
        modelo = new DefaultTableModel(null, titulo);
        ControlDB_ConsumoGeneral com = new ControlDB_ConsumoGeneral();
        ArrayList<Consumo> listadoConsumo=com.consultarConsumoGeneral(script);
        ControlDB_Bodega controlDB_Bodega = new ControlDB_Bodega();
        for(int i =0; i< listadoConsumo.size(); i++){
            registro[0]=""+listadoConsumo.get(i).getId();
            registro[1]=""+listadoConsumo.get(i).getFechaConsumo();
            registro[2]=""+controlDB_Bodega.RetornoNombreBodega(listadoConsumo.get(i).getBodegaConsumo_id());
            registro[3]=""+listadoConsumo.get(i).getCliente_nit();
            
            //Consultamos el Nombre del proveedor atravez del Nit y sucursal
            ControlDB_Cliente controlDB_Cliente = new ControlDB_Cliente();
            Cliente cli = new Cliente();
            cli.setNit(listadoConsumo.get(i).getCliente_nit());
            cli.setSucursal(listadoConsumo.get(i).getCliente_sucursal());
            ArrayList<Cliente> listadoCliente=controlDB_Cliente.consultarUnicoCliente(cli);
            for(int a =0; a< listadoCliente.size(); a++){ 
                registro[4]=""+listadoCliente.get(a).getNombre(); 
            }
            
            registro[5]=""+listadoConsumo.get(i).getValorTotalEnPesos();
            registro[6]=""+validarEstado(listadoConsumo.get(i).getEstado());
            registro[7]=""+listadoConsumo.get(i).getNombreQuienElabora();  
            modelo.addRow(registro);
            tabla.setModel(modelo);  
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
