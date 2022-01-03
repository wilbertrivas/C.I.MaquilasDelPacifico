
package GUI;

import Controladores.ControlDB_EmpresaLocal;
import Controladores.ControlDB_TipoEmpresaLocal;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Image;
import com.itextpdf.text.Element;
import java.io.FileOutputStream;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Modelos.EmpresaLocal;
import Reportes.Generar_Reportes;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class EmpresaLocal_Consultar extends javax.swing.JPanel {
    DefaultTableModel modelo;
    String datos;
    String [] titulo= {"Nit", "Digito_Verificación","Sucursal", "Nombre", "Tipo_Cliente","Teléfono", "Celular", "Dirección","Correo","Ciudad","Observacion","Estado"};
    String [] registro;   
    
    public EmpresaLocal_Consultar() {
        initComponents();      
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        nombre = new javax.swing.JTextField();
        consultar = new javax.swing.JButton();
        listar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        limpiar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 153, 153));
        jLabel8.setText("CONSULTAR EMPRESAS LOCALES");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 0, 430, 30));

        jLabel7.setFont(new java.awt.Font("Tekton Pro", 1, 12)); // NOI18N
        jLabel7.setText("INGRESE NIT O NOMBRE:");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 160, 30));

        nombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nombreKeyPressed(evt);
            }
        });
        add(nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 50, 260, 30));

        consultar.setBackground(new java.awt.Color(255, 255, 255));
        consultar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        consultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/Bodega_Actualizar_Bton_Buscar.PNG"))); // NOI18N
        consultar.setText("CONSULTAR");
        consultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultarActionPerformed(evt);
            }
        });
        add(consultar, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 40, 140, 40));

        listar.setBackground(new java.awt.Color(255, 255, 255));
        listar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        listar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/Interfaz_Icon_Listar.PNG"))); // NOI18N
        listar.setText("LISTAR");
        listar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listarActionPerformed(evt);
            }
        });
        add(listar, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 40, 130, 40));

        tabla = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tabla.setBackground(new java.awt.Color(153, 204, 255));
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
        tabla.setFocusable(false);
        tabla.setGridColor(new java.awt.Color(255, 255, 255));
        tabla.setSelectionBackground(new java.awt.Color(255, 102, 102));
        tabla.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tabla);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 1400, 530));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/generarDocumento.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 10, 60, 60));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Documento");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 80, -1, 20));

        limpiar.setBackground(new java.awt.Color(255, 255, 255));
        limpiar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        limpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/Interfaz_Icon_Borrar.PNG"))); // NOI18N
        limpiar.setText("LIMPIAR");
        limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarActionPerformed(evt);
            }
        });
        add(limpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 40, 140, 40));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Generar ");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 70, -1, 20));
    }// </editor-fold>//GEN-END:initComponents

    private void consultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarActionPerformed
        try {
            tabla(nombre.getText());
        } catch (SQLException ex) {
            Logger.getLogger(EmpresaLocal_Consultar.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_consultarActionPerformed

    private void listarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listarActionPerformed
        try {
            tabla("");
        } catch (SQLException ex) {
            Logger.getLogger(EmpresaLocal_Consultar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_listarActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        /*try{
            String nombrePDF=JOptionPane.showInputDialog(null,"Ingrese el nombre del PDF");
            guardarPDF(nombrePDF);
            Runtime.getRuntime().exec("rundll32 url.dll, FileProtocolHandler "+ "D:\\"+nombrePDF+".pdf");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al crear el PDF");
        }*/
        Generar_Reportes gr = new Generar_Reportes();
        gr.generarReporteEmpresaLocal();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarActionPerformed
            nombre.setText("");
    }//GEN-LAST:event_limpiarActionPerformed

    private void nombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombreKeyPressed
        String valor=nombre.getText();
        tabla.show();
        try {
            tabla(valor);
        } catch (SQLException ex) {
           
        }
    }//GEN-LAST:event_nombreKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton consultar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton limpiar;
    private javax.swing.JButton listar;
    private javax.swing.JTextField nombre;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
    public void tabla(String valorConsulta) throws SQLException{
        registro = new String[12]; 
        modelo = new DefaultTableModel(null, titulo);
        ControlDB_EmpresaLocal c = new ControlDB_EmpresaLocal();
        ControlDB_TipoEmpresaLocal tipoEmpresaLocal = new ControlDB_TipoEmpresaLocal();
        ArrayList<EmpresaLocal> listadoEmpresaLocal=c.buscarEmpresaLocal(valorConsulta);
        for(int i =0; i< listadoEmpresaLocal.size(); i++){
            registro[0]=""+listadoEmpresaLocal.get(i).getNit();
            registro[1]=""+listadoEmpresaLocal.get(i).getDigitoVerificacion();
            registro[2]=""+listadoEmpresaLocal.get(i).getSucursal();
            registro[3]=""+listadoEmpresaLocal.get(i).getNombre();
            registro[4]=""+tipoEmpresaLocal.validarTipoEmpresaLocal_Nombre_por_ID(listadoEmpresaLocal.get(i).getTipoEmpresaLocal_id());
            registro[5]=""+listadoEmpresaLocal.get(i).getTelefono();
            registro[6]=""+listadoEmpresaLocal.get(i).getCelular();
            registro[7]=""+listadoEmpresaLocal.get(i).getDireccion();
            registro[8]=""+listadoEmpresaLocal.get(i).getCorreo();
            registro[9]=""+listadoEmpresaLocal.get(i).getCiudad();
            registro[10]=""+listadoEmpresaLocal.get(i).getObservacion();
            String estado=""+listadoEmpresaLocal.get(i).getEstado();
            if(estado.equals("1")){
                estado="Activo";
            }else{
                estado="Inactivo";
            }      
            registro[11]=estado;
            modelo.addRow(registro);
            tabla.setModel(modelo);
        }
    }
    public void guardarPDF(String nombreArchivo){
        //Document documento = new Document();
        float left = 2;
        float right = 2;
        float top = 2;
        float bottom = 0;
        Document documento = new Document(PageSize.LETTER, left, right, top, bottom);
        Document document = new Document();
        FileOutputStream ficheroPdf;
        try{
            ficheroPdf = new FileOutputStream("D:\\"+nombreArchivo+".pdf");
            PdfWriter.getInstance(
                               documento, 
                               ficheroPdf
                               ).setInitialLeading(20);
        }catch (Exception ex){
            System.out.println(ex.toString());
        }
        try{
            documento.open();
             
        documento.setMargins(left, right, 0, bottom);
            
            //Image imagen = Image.getInstance("src/GUI/Img/Logo.png");
            Image imagen = Image.getInstance("D://Logo.png");
            imagen.setAlignment(Element.ALIGN_LEFT);
            documento.add(imagen);
            /*Image imagen = Image.getInstance("Logo.png");
            //Agregamos la imagen al documento.*/
            //documento.add(imagen);
            
            Font fuente = new Font();
            fuente.setSize(8);
            Paragraph parrafo2 = new Paragraph("RESULTADOS ENCONTRADOS", fuente);
            parrafo2.setAlignment(1);//el 1 es para centrar
            documento.add(parrafo2);
            documento.add(new Paragraph(" "));
            PdfPTable tablaG = new PdfPTable(11);  
            int CantRegistro= tabla.getRowCount();//el numero indica la cantidad de Columnas
            //parrafo2 = new Paragraph("NIT", fuente);
            //tablaG.addCell(parrafo2);
            tablaG.addCell("NIT");
            tablaG.addCell("DIGITO_VERIFICACIÓN");
            tablaG.addCell("NOMBRE");
            tablaG.addCell("TIPO CLIENTE");
            tablaG.addCell("TELEFONO");
            tablaG.addCell("CELULAR");
            tablaG.addCell("DIRECCION");
            tablaG.addCell("CORREO");
            tablaG.addCell("CIUDAD");
            tablaG.addCell("OBSERVACION");
            tablaG.addCell("ESTADO");

            for(int fila=0; fila<CantRegistro; fila++){  
                try{
                    tablaG.addCell((String.valueOf(tabla.getValueAt(fila,0))));
                    tablaG.addCell((String.valueOf(tabla.getValueAt(fila,1))));
                    tablaG.addCell((String.valueOf(tabla.getValueAt(fila,2))));
                    tablaG.addCell((String.valueOf(tabla.getValueAt(fila,3))));
                    tablaG.addCell((String.valueOf(tabla.getValueAt(fila,4))));
                    tablaG.addCell((String.valueOf(tabla.getValueAt(fila,5))));
                    tablaG.addCell((String.valueOf(tabla.getValueAt(fila,6))));
                    tablaG.addCell((String.valueOf(tabla.getValueAt(fila,7))));
                    tablaG.addCell((String.valueOf(tabla.getValueAt(fila,8))));
                    tablaG.addCell((String.valueOf(tabla.getValueAt(fila,9))));
                    tablaG.addCell((String.valueOf(tabla.getValueAt(fila,10))));
                }catch(Exception e){         
                }
            }
            documento.add(tablaG);
            documento.add(new Paragraph(" "));
            documento.close();
        }catch(Exception ex){
            System.out.println(ex.toString());
        }
    }
}
