package GUI;

import Controladores.ControlDB_Otros;
import Controladores.ControlDB_Producto;
import Controladores.ControlDB_Unidad;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Image;
import com.itextpdf.text.Element;
import java.io.FileOutputStream;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import Modelos.Producto;
import Reportes.Generar_Reportes;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Producto_Consultar extends javax.swing.JPanel {
    DefaultTableModel modelo;
    String datos;
    String [] titulo= {"Código Producto","Nombre Producto","Tipo", "Subpartida Arancelaria", "Unidad", "Estado"};
    String [] registro;  
    public Producto_Consultar() {
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
        limpiar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 153, 153));
        jLabel8.setText("CONSULTAR PRODUCTOS");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 0, 430, 30));

        jLabel7.setFont(new java.awt.Font("Tekton Pro", 1, 12)); // NOI18N
        jLabel7.setText("INGRESE SUBPARTIDA O NOMBRE:");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 260, 30));

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
        tabla.setSelectionBackground(new java.awt.Color(255, 102, 102));
        tabla.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tabla);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 870, 370));

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

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/generarDocumento.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 20, 60, 60));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Documento");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 90, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Generar ");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 80, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void consultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarActionPerformed
        try {
            tabla(nombre.getText());
        } catch (SQLException ex) {
            Logger.getLogger(Producto_Consultar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_consultarActionPerformed

    private void listarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listarActionPerformed
        try {
            tabla("");
        } catch (SQLException ex) {
            Logger.getLogger(Producto_Consultar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_listarActionPerformed

    private void limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarActionPerformed
            nombre.setText("");
    }//GEN-LAST:event_limpiarActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        Generar_Reportes gr = new Generar_Reportes();
        gr.generarReporteProductosActivos();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void nombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombreKeyPressed
        try {
            tabla(nombre.getText());
        } catch (SQLException ex) {
            Logger.getLogger(Producto_Consultar.class.getName()).log(Level.SEVERE, null, ex);
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
        registro = new String[6]; 
        modelo = new DefaultTableModel(null, titulo);
        ControlDB_Producto p = new ControlDB_Producto();
        ControlDB_Unidad unidad = new ControlDB_Unidad();
        ArrayList<Producto> listadoProducto=p.buscarProductos(valorConsulta);
        for(int i =0; i< listadoProducto.size(); i++){
            registro[0]=""+listadoProducto.get(i).getId();
            registro[1]=""+listadoProducto.get(i).getDescripcion();
            registro[2]=""+listadoProducto.get(i).getTipo();
            registro[3]=""+listadoProducto.get(i).getSubpartidaArancelaria();
            registro[4]=""+unidad.validarTipoUnidad_Nombre_por_Id(""+listadoProducto.get(i).getUnidad_id());
            ControlDB_Otros controlDB_Otros = new ControlDB_Otros();
            registro[5]=controlDB_Otros.convertidorEstadoID_x_Nombre(listadoProducto.get(i).getEstado());
            modelo.addRow(registro);
            tabla.setModel(modelo);
        }
    }
    public void guardarPDF(String nombreArchivo){
        //Document documento = new Document();
        Document documento = new Document();
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
            //Image imagen = Image.getInstance("src/GUI/Img/Logo.png");
            Image imagen = Image.getInstance("D://Logo.png");
            imagen.setAlignment(Element.ALIGN_LEFT);
            documento.add(imagen);
            /*Image imagen = Image.getInstance("Logo.png");
            //Agregamos la imagen al documento.*/
            //documento.add(imagen);
            Paragraph parrafo2 = new Paragraph("RESULTADOS ENCONTRADOS");
            parrafo2.setAlignment(1);//el 1 es para centrar
            documento.add(parrafo2);
            documento.add(new Paragraph(" "));
            PdfPTable tablaG = new PdfPTable(6);  
            int CantRegistro= tabla.getRowCount();//el numero indica la cantidad de Columnas
            tablaG.addCell("CÓDIGO PRODUCTO");
            tablaG.addCell("NOMBRE PRODUCTO");
            tablaG.addCell("TIPO");
            tablaG.addCell("SUBPARTIDA ARANCELARIA");
            tablaG.addCell("UNIDAD");
            tablaG.addCell("ESTADO");
            for(int fila=0; fila<CantRegistro; fila++){  
                try{
                    tablaG.addCell((String.valueOf(tabla.getValueAt(fila,0))));
                    tablaG.addCell((String.valueOf(tabla.getValueAt(fila,1))));
                    tablaG.addCell((String.valueOf(tabla.getValueAt(fila,2))));
                    tablaG.addCell((String.valueOf(tabla.getValueAt(fila,3))));
                    tablaG.addCell((String.valueOf(tabla.getValueAt(fila,4))));
                    tablaG.addCell((String.valueOf(tabla.getValueAt(fila,5))));
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