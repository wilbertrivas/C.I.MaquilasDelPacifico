package GUI;

import Controladores.ControlDB_Cliente;
import Controladores.ControlDB_Compra;
import Controladores.ControlDB_ConsumoCajasNacional;
import Controladores.ControlDB_EmpresaLocal;
import Controladores.ControlDB_Proveedor;
import Modelos.Cliente;
import Modelos.Consumo;
import Modelos.EmpresaLocal;
import Modelos.IngresoProducto;
import Modelos.ItemConsumo;
import Modelos.Proveedor;
import Modelos.Usuario;
import Reportes.Generar_Reportes;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ConsumoCajas_Registrar_BodNacional extends javax.swing.JPanel {
    String valor="";
    String accion="";
    Usuario user;
    String []tituloCP= {"CP","PRODUCTO","BODEGA","NOMBRE_PROV.","FECHA_COMPRA","FECHA_MAX._EXPORT.","SALDO","CANTIDAD A VENDER"};
    String [] registroCP;
    DefaultTableModel modeloCP;
    int consumoNumero=0;
    
    public ConsumoCajas_Registrar_BodNacional(Usuario u) {
        user= u;
        initComponents();
        VentanaInternaVentas.show(false);
        //Formato de la tabla en la que se cargan los CP
        registroCP= new String[8]; 
        modeloCP = new DefaultTableModel(null, tituloCP);
        CarritoVentaCP.setModel(modeloCP);
        
        //#########################################################
        ControlDB_ConsumoCajasNacional controlDB_ConsumoCajasNacional = new ControlDB_ConsumoCajasNacional();
        try{
            consumoNumero=controlDB_ConsumoCajasNacional.retornarElMaximo();
            consumoNumero++;
            ConsumoNo.setText("Consumo No.  "+consumoNumero);
        }catch(Exception e){
            consumoNumero++;
            ConsumoNo.setText("Consumo No.  "+consumoNumero);
        }       
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Seleccionar = new javax.swing.JPopupMenu();
        Editar = new javax.swing.JMenuItem();
        Eliminar = new javax.swing.JPopupMenu();
        EliminarCP = new javax.swing.JMenuItem();
        VentanaInternaVentas = new javax.swing.JInternalFrame();
        codigo = new javax.swing.JTextField();
        ventanaInterna_Nombre = new javax.swing.JLabel();
        limpiar1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        ListadoBusquedas = new javax.swing.JTable();
        buscar1 = new javax.swing.JButton();
        cancelar1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        cli_celular = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        alertaDatosFactura = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        cli_nit = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        fechaFactura = new com.toedter.calendar.JDateChooser();
        ConsumoNo = new javax.swing.JLabel();
        CargarCliente = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        observacion = new javax.swing.JTextArea();
        jLabel27 = new javax.swing.JLabel();
        cli_direccion = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        cli_correo = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        cli_ciudad = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        cli_nombre = new javax.swing.JLabel();
        cli_telefono = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        CarritoVentaCP = new javax.swing.JTable();
        RegistrarConsumo = new javax.swing.JButton();
        precioVentaKilo = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        alertaEmpresaLocal = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        cli_sucursal = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();

        Editar.setText("Seleccionar");
        Editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarActionPerformed(evt);
            }
        });
        Seleccionar.add(Editar);

        EliminarCP.setText("EliminarCP");
        EliminarCP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarCPActionPerformed(evt);
            }
        });
        Eliminar.add(EliminarCP);

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        VentanaInternaVentas.setBackground(new java.awt.Color(255, 255, 255));
        VentanaInternaVentas.setTitle("Titulo");
        VentanaInternaVentas.setVisible(true);
        VentanaInternaVentas.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        codigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                codigoKeyPressed(evt);
            }
        });
        VentanaInternaVentas.getContentPane().add(codigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 250, 30));

        ventanaInterna_Nombre.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        ventanaInterna_Nombre.setForeground(new java.awt.Color(0, 153, 153));
        ventanaInterna_Nombre.setText("Buscar CP");
        VentanaInternaVentas.getContentPane().add(ventanaInterna_Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 210, -1));

        limpiar1.setBackground(new java.awt.Color(255, 255, 255));
        limpiar1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        limpiar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/Interfaz_Icon_Borrar.PNG"))); // NOI18N
        limpiar1.setText("LIMPIAR");
        limpiar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiar1ActionPerformed(evt);
            }
        });
        VentanaInternaVentas.getContentPane().add(limpiar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, 140, 40));

        ListadoBusquedas = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        ListadoBusquedas.setBackground(new java.awt.Color(153, 204, 255));
        ListadoBusquedas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        ListadoBusquedas.setComponentPopupMenu(Seleccionar);
        ListadoBusquedas.setFocusable(false);
        ListadoBusquedas.setGridColor(new java.awt.Color(0, 204, 204));
        ListadoBusquedas.setSelectionBackground(new java.awt.Color(255, 102, 102));
        ListadoBusquedas.getTableHeader().setReorderingAllowed(false);
        ListadoBusquedas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ListadoBusquedasKeyPressed(evt);
            }
        });
        jScrollPane3.setViewportView(ListadoBusquedas);

        VentanaInternaVentas.getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 1060, 220));

        buscar1.setBackground(new java.awt.Color(255, 255, 255));
        buscar1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        buscar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/Bodega_Actualizar_Bton_Buscar.PNG"))); // NOI18N
        buscar1.setText("BUSCAR");
        buscar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscar1ActionPerformed(evt);
            }
        });
        VentanaInternaVentas.getContentPane().add(buscar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 140, -1));

        cancelar1.setBackground(new java.awt.Color(255, 255, 255));
        cancelar1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cancelar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/Bodega_Actualizar_Bton_Cancelar.PNG"))); // NOI18N
        cancelar1.setText("CANCELAR");
        cancelar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelar1ActionPerformed(evt);
            }
        });
        VentanaInternaVentas.getContentPane().add(cancelar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 90, 160, 40));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/fondo.png"))); // NOI18N
        VentanaInternaVentas.getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1110, 380));

        add(VentanaInternaVentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 1120, 410));

        cli_celular.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cli_celular.setForeground(new java.awt.Color(102, 102, 102));
        add(cli_celular, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 110, 330, 20));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 102, 102));
        jLabel9.setText("REGISTRAR CONSUMO DE CAJAS");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 0, 370, 30));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel18.setText("Nit:");
        add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 70, 20));

        alertaDatosFactura.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        alertaDatosFactura.setForeground(new java.awt.Color(255, 0, 51));
        add(alertaDatosFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 280, 1010, 30));

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel21.setText("CONSUMIDOR");
        jLabel21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel21MouseClicked(evt);
            }
        });
        add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 90, 30));

        cli_nit.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cli_nit.setForeground(new java.awt.Color(102, 102, 102));
        add(cli_nit, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 30, 350, 20));

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel20.setText("CARGAR CP");
        jLabel20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel20MouseClicked(evt);
            }
        });
        add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 80, 30));

        fechaFactura.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fechaFacturaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                fechaFacturaMouseEntered(evt);
            }
        });
        add(fechaFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 150, 230, 30));

        ConsumoNo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ConsumoNo.setText("Consumo No.");
        add(ConsumoNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 0, 260, 30));

        CargarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/Compra_Agregar_Proveedor.png"))); // NOI18N
        CargarCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CargarClienteMouseClicked(evt);
            }
        });
        add(CargarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 80, 100));

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel25.setText("Celular:");
        add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, 70, 20));

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel26.setText("CARGAR ");
        add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 60, 20));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel19.setText("Observación:");
        add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 190, 120, 30));

        observacion.setColumns(20);
        observacion.setRows(5);
        observacion.setBorder(null);
        jScrollPane2.setViewportView(observacion);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 190, 570, 90));

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel27.setText("Dirección:");
        add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 30, 70, 20));

        cli_direccion.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cli_direccion.setForeground(new java.awt.Color(102, 102, 102));
        add(cli_direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 30, 280, 20));

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel31.setText("Correo:");
        add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 50, 70, 20));

        cli_correo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cli_correo.setForeground(new java.awt.Color(102, 102, 102));
        add(cli_correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 50, 280, 20));

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel32.setText("Ciudad:");
        add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 70, 50, 20));

        cli_ciudad.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cli_ciudad.setForeground(new java.awt.Color(102, 102, 102));
        add(cli_ciudad, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 70, 280, 20));

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel33.setText("Nombre:");
        add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 70, 20));

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel34.setText("Telefono:");
        add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 70, 20));

        cli_nombre.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cli_nombre.setForeground(new java.awt.Color(102, 102, 102));
        add(cli_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 70, 350, 20));

        cli_telefono.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cli_telefono.setForeground(new java.awt.Color(102, 102, 102));
        add(cli_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, 340, 20));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("Factura:");
        add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 150, 130, 30));

        jLabel36.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(102, 102, 102));
        jLabel36.setText("NACIONAL");
        add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 150, 170, 30));

        jLabel38.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel38.setText("Bodega:");
        add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 100, 30));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/Compra_Agregar_Proveedor.png"))); // NOI18N
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 70, 70));

        CarritoVentaCP = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                if (colIndex == 7){
                    return true;
                }else{
                    return false;
                }
            }

        };
        CarritoVentaCP.setBackground(new java.awt.Color(153, 204, 255));
        CarritoVentaCP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        CarritoVentaCP.setComponentPopupMenu(Eliminar);
        CarritoVentaCP.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        CarritoVentaCP.setSelectionBackground(new java.awt.Color(255, 102, 102));
        CarritoVentaCP.getTableHeader().setReorderingAllowed(false);
        CarritoVentaCP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CarritoVentaCPMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CarritoVentaCPMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                CarritoVentaCPMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                CarritoVentaCPMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                CarritoVentaCPMouseReleased(evt);
            }
        });
        CarritoVentaCP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                CarritoVentaCPKeyPressed(evt);
            }
        });
        jScrollPane4.setViewportView(CarritoVentaCP);

        add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 310, 1010, 150));

        RegistrarConsumo.setBackground(new java.awt.Color(255, 255, 255));
        RegistrarConsumo.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        RegistrarConsumo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/Bodega_Registrar_Bton_Registrar.PNG"))); // NOI18N
        RegistrarConsumo.setText("REGISTRAR VENTAS");
        RegistrarConsumo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                RegistrarConsumoMouseExited(evt);
            }
        });
        RegistrarConsumo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistrarConsumoActionPerformed(evt);
            }
        });
        add(RegistrarConsumo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 470, 240, 60));

        precioVentaKilo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                precioVentaKiloMouseClicked(evt);
            }
        });
        add(precioVentaKilo, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 190, 170, 30));

        jLabel40.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel40.setText("Por Kilo:");
        add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 140, 20));

        jLabel41.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel41.setText("Precio de Venta");
        add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 140, 30));

        alertaEmpresaLocal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        alertaEmpresaLocal.setForeground(new java.awt.Color(255, 0, 51));
        add(alertaEmpresaLocal, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 90, 770, 30));

        jLabel15.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "INFORMACIÓN EMPRESA CONSUMIDORA", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Adobe Arabic", 1, 14))); // NOI18N
        add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 1120, 130));

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel22.setText("Sucursal:");
        add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 70, 20));

        cli_sucursal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cli_sucursal.setForeground(new java.awt.Color(102, 102, 102));
        add(cli_sucursal, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 50, 320, 20));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("Fecha de ");
        add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 140, 140, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void fechaFacturaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fechaFacturaMouseClicked

    }//GEN-LAST:event_fechaFacturaMouseClicked

    private void fechaFacturaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fechaFacturaMouseEntered

    }//GEN-LAST:event_fechaFacturaMouseEntered

    private void CargarClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CargarClienteMouseClicked
        valor="Clientes";
        codigo.setText("");
        //Eliminamos la Busqueda Actual#######################################################
        DefaultTableModel md =(DefaultTableModel)ListadoBusquedas.getModel();
        int CantEliminar= ListadoBusquedas.getRowCount() -1;
        for(int i =CantEliminar; i>=0; i--){
           md.removeRow(i);
        }
        DefaultTableModel modelo;
        String [] titulo= {"NIT","SUCURSAL", "NOMBRE"};
        String [] registro = new String[3]; 
        modelo = new DefaultTableModel(null, titulo);
        ListadoBusquedas.setModel(modelo);
        VentanaInternaVentas.show(true);
        CargarVentanaInterna(1);                
    }//GEN-LAST:event_CargarClienteMouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        String fechaFacturaV=retornarFechaVentaEnString();
        if(fechaFacturaV.equals("")){
            JOptionPane.showMessageDialog(null, "Verifique Formato de fecha el ingresado no es valido");
        }else{ 
            fechaFactura.setEnabled(false);
            valor="CP";    
            codigo.setText("");
            //Eliminamos la Busqueda Actual#######################################################
            DefaultTableModel md =(DefaultTableModel)ListadoBusquedas.getModel();
            int CantEliminar= ListadoBusquedas.getRowCount() -1;
            for(int i =CantEliminar; i>=0; i--){
               md.removeRow(i);
            }
            DefaultTableModel modelo;
            String [] titulo= {"CP","PRODUCTO","BODEGA","CANT. INICIAL","SALDO", "FECHA_COMPRA", "FECHA. MAX. EXPORTACIÓN", "NOMBRE_PROVEEDOR"};
            String [] registro = new String[8]; 
            modelo = new DefaultTableModel(null, titulo);
            ListadoBusquedas.setModel(modelo);    
            VentanaInternaVentas.show(true);
            CargarVentanaInterna(2);
        }   
    }//GEN-LAST:event_jLabel4MouseClicked

    private void RegistrarConsumoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RegistrarConsumoMouseExited
        alertaEmpresaLocal.setText("");
        alertaDatosFactura.setText("");
    }//GEN-LAST:event_RegistrarConsumoMouseExited

    private void RegistrarConsumoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistrarConsumoActionPerformed
        if(cli_nit.getText().equals("")){
            alertaEmpresaLocal.setText("ERROR!!.. Se debe Cargar los datos de la Empresa Local, Antes de Registrar el consumo");
        }else{
            if(precioVentaKilo.getText().equals("")){
                alertaDatosFactura.setText("ERROR!!.. Se debe Ingresar el precio de Consumo por Kilo, Antes de Registrar el consumo");
            }else{
                try{
                    Float.parseFloat(precioVentaKilo.getText()); //validamos que valorTotalDolar de la interfaz sea númerico
                    if(Float.parseFloat(precioVentaKilo.getText()) <= 1000000){
                        try{
                            //try{
                            Calendar fecha = fechaFactura.getCalendar();
                            String ano = ""+fecha.get(Calendar.YEAR);
                            String mes = "";
                            String dia = "";
                            if((fecha.get(Calendar.MONTH) +1) <=9){
                                mes = "0"+(fecha.get(Calendar.MONTH) + 1);
                            }else{
                                mes = ""+(fecha.get(Calendar.MONTH) + 1);
                            }
                            if(fecha.get(Calendar.DAY_OF_MONTH) <=9){
                                dia = "0"+fecha.get(Calendar.DAY_OF_MONTH);
                            }else{
                                dia = ""+fecha.get(Calendar.DAY_OF_MONTH);
                            }
                            String fechaFacturaV=ano+"-"+mes+"-"+dia;
                            if(validarQueCargueAlmenosUnCP()){//Validamos que se cargue al menos un CP, para poder Registrar el Consumo.
                                alertaDatosFactura.setText("ERROR!!..  Se debe Cargar al menos un CP, Antes de Registrar el consumo");
                            }else{
                                if(validarEnCPCargadosCantidadAVenderSeaMayorACero()){
                                    alertaDatosFactura.setText("ERROR!!..  En los CP cargados la cantidad a consumir debe ser mayor a Cero, de lo contrario elimine CP con valor de Cero");
                                }else{ 
                                    Consumo consumo = new Consumo();
                                    consumo.setFechaConsumo(fechaFacturaV);
                                    consumo.setBodegaConsumo_id(2);
                                        String[] arregloNit= cli_nit.getText().split("-");
                                        String nitC = arregloNit[0];
                                        String digitoVerificacionC = arregloNit[1];                                        
                                    consumo.setCliente_nit(nitC);
                                    consumo.setCliente_sucursal(Integer.parseInt(digitoVerificacionC));
                                    //consumo.setCliente_nombre(cli_nombre.getText());
                                        ControlDB_EmpresaLocal controlEmpresaLocal = new ControlDB_EmpresaLocal();
                                        EmpresaLocal emp = new EmpresaLocal();
                                        EmpresaLocal empresL = null;
                                    try {
                                        emp.setNit("900088695");
                                        emp.setSucursal(1);
                                        empresL = controlEmpresaLocal.retornarEmpresaLocal(emp);
                                    } catch (SQLException ex) {
                                        Logger.getLogger(ConsumoCajas_Registrar_BodNacional.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                    consumo.setEmpresaLocal_nit(empresL.getNit());
                                    consumo.setEmpresaLocal_sucursal(empresL.getSucursal());
                                    //consumo.setEmpresaLocal_nombre(empresL.getNombre());
                                    consumo.setObservaciones(observacion.getText());
                                    consumo.setEstado(1);
                                    consumo.setNombreQuienElabora(user.getNombre()+" "+user.getApellido());
                                    BigDecimal sumatoriaValorTotalPesos= new java.math.BigDecimal("0");
                                    ArrayList<ItemConsumo> ArrayItemConsumo= new ArrayList();

                                    int filasCarritoConsumoCP = CarritoVentaCP.getRowCount();
                                    DefaultTableModel modeloX=(DefaultTableModel)CarritoVentaCP.getModel();
                                    for(int i=0; i< filasCarritoConsumoCP; i++){
                                        BigDecimal CantidadKiloIngresoProducto=new java.math.BigDecimal((String)modeloX.getValueAt(i, 7));
                                        BigDecimal precioVentaKiloT=new java.math.BigDecimal(precioVentaKilo.getText());                                           
                                        ItemConsumo item = new ItemConsumo();
                                        item.setIdConsumo(consumoNumero);                 
                                        ControlDB_Compra controlDB_Compra = new ControlDB_Compra();
                                        item.setIdIngresoProducto(controlDB_Compra.retornarIdIngresoProducto((String)modeloX.getValueAt(i, 0)));
                                        item.setValorUnitarioKilo(Double.parseDouble(precioVentaKilo.getText()));
                                        item.setCantidad(CantidadKiloIngresoProducto);          
                                        item.setTotal(CantidadKiloIngresoProducto.multiply(precioVentaKiloT));
                                        if(i==0){
                                            sumatoriaValorTotalPesos = new java.math.BigDecimal(item.getTotal().toPlainString());
                                            //JOptionPane.showMessageDialog(null, "Sumatoria_Inicial="+sumatoriaValorTotalPesos.toPlainString());
                                        }else{
                                            BigDecimal c = new BigDecimal(item.getTotal().toPlainString());
                                            //JOptionPane.showMessageDialog(null, "Sumatoria="+sumatoriaValorTotalPesos.toString()+" valor sacado="+c.toString());
                                            sumatoriaValorTotalPesos.add(c);
                                         }
                                        ArrayItemConsumo.add(item);
                                    }
                                    consumo.setValorTotalEnPesos(new BigDecimal(sumatoriaValorTotalPesos.toPlainString()));
                                    //JOptionPane.showMessageDialog(null, facturaVenta.getValorTotalEnPesos());
                                    ControlDB_ConsumoCajasNacional controlDB_ConsumoNacional = new ControlDB_ConsumoCajasNacional();
                                    try {
                                        if(controlDB_ConsumoNacional.validorCantidadesExistentesBodegaNacional(ArrayItemConsumo)){
                                            int valorW=controlDB_ConsumoNacional.registrarConsumoNacional(consumo, ArrayItemConsumo,user);
                                            if(valorW==1){
                                                JOptionPane.showMessageDialog(null, "Registro De Consumo Exitoso");
                                                cli_nit.setText("");
                                                cli_sucursal.setText("");
                                                cli_nombre.setText("");
                                                cli_telefono.setText("");
                                                cli_celular.setText("");
                                                cli_direccion.setText("");
                                                cli_correo.setText("");
                                                cli_ciudad.setText("");
                                                fechaFactura.setEnabled(true);
                                                precioVentaKilo.setText("");
                                                observacion.setText("");
                                                consumoNumero++;
                                                ConsumoNo.setText("Consumo No.  "+consumoNumero);                                                                   
                                                ControlDB_ConsumoCajasNacional controlDB_ConsumoCajasNacional = new ControlDB_ConsumoCajasNacional();
                                                Generar_Reportes generarReportes = new Generar_Reportes();
                                                generarReportes.generar_ConsumoCamarones(controlDB_ConsumoCajasNacional.retornarElMaximo());
                                                //Generar_Reportes generarReportes = new Generar_Reportes();
                                                //generarReportes.generar_FacturaVentaNacional(controlDB_Ventas.retornarElMaximo());

                                                //Eliminamos los CP actuales#######################################################
                                                DefaultTableModel md =(DefaultTableModel)CarritoVentaCP.getModel();
                                                int CantEliminar= CarritoVentaCP.getRowCount() -1;
                                                for(int i =CantEliminar; i>=0; i--){
                                                   md.removeRow(i);
                                                }
                                                //############################################
                                            }else{
                                                JOptionPane.showMessageDialog(null, "Error al registrar el consumo");    
                                            }
                                        }else{
                                            JOptionPane.showMessageDialog(null, "Error!!. No se puede Registrar el consumo Verifique nuevamente todos los saldos en bodega debido a que han cambiado. Sugerencia Elimine los CP y vuelva a cargarlos");
                                        }
                                    } catch (FileNotFoundException ex) {
                                        Logger.getLogger(ConsumoCajas_Registrar_BodNacional.class.getName()).log(Level.SEVERE, null, ex);
                                    } catch (SQLException ex) {
                                        Logger.getLogger(ConsumoCajas_Registrar_BodNacional.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                }
                            }
                        }catch(Exception e){
                            alertaDatosFactura.setText("ERROR!!.. La fecha de consumo debe tener un formato de fecha valido, verifique datos ingresados");     
                        }
                    }else{
                        alertaDatosFactura.setText("ERROR!!.. El precio de consumo por  Kilo debe ser menor a un millon (1.000.000)");
                    }
                }catch(Exception e){
                    alertaDatosFactura.setText("ERROR!!.. El valor de consumo por Kilo debe ser númerico, verifique datos ingresados");
                }                             
            }           
        }
    }//GEN-LAST:event_RegistrarConsumoActionPerformed

    private void codigoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codigoKeyPressed
        try {
            BuscarEnVentanaInterna();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al Actualizar");
        }
    }//GEN-LAST:event_codigoKeyPressed

    private void limpiar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiar1ActionPerformed
        codigo.setText("");
    }//GEN-LAST:event_limpiar1ActionPerformed

    private void ListadoBusquedasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ListadoBusquedasKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_ListadoBusquedasKeyPressed

    private void buscar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscar1ActionPerformed
        try {
            BuscarEnVentanaInterna();
        } catch (SQLException ex) {
            Logger.getLogger(ConsumoCajas_Registrar_BodNacional.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_buscar1ActionPerformed

    private void cancelar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelar1ActionPerformed
        VentanaInternaVentas.show(false);
    }//GEN-LAST:event_cancelar1ActionPerformed

    private void EditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditarActionPerformed
       // TODO lo del clik derechoo
        DefaultTableModel modelo;
        if(valor.equals("Clientes")){
            int fila1;
            try{
                fila1=ListadoBusquedas.getSelectedRow();
                if(fila1==-1){
                    JOptionPane.showMessageDialog(null,"no se ha seleccionando ninguna fila");
                }
                else{
                    try{
                        accion="modificar";
                        modelo=(DefaultTableModel)ListadoBusquedas.getModel();
                        String nitT=(String)modelo.getValueAt(fila1, 0);
                        String sucursalT=(String)modelo.getValueAt(fila1, 1);
                        String nombreT=(String)modelo.getValueAt(fila1, 2);
                        
                        Cliente c=new Cliente();
                        c.setNit(nitT);
                        c.setSucursal(Integer.parseInt(sucursalT));
                        c.setNombre(nombreT);
                        ControlDB_Cliente controlDB_Cliente = new ControlDB_Cliente();
                        ArrayList<Cliente> listadoCliente=controlDB_Cliente.consultarUnicoCliente(c);
                        for(int i =0; i< listadoCliente.size(); i++){ 
                            cli_nit.setText(listadoCliente.get(i).getNit()+"-"+listadoCliente.get(i).getDigitoVerificacion());
                            cli_sucursal.setText(""+listadoCliente.get(i).getSucursal());
                            cli_nombre.setText(listadoCliente.get(i).getNombre());
                            cli_telefono.setText(listadoCliente.get(i).getTelefono());
                            cli_celular.setText(listadoCliente.get(i).getCelular());
                            cli_direccion.setText(listadoCliente.get(i).getDireccion());
                            cli_correo.setText(listadoCliente.get(i).getCorreo());
                            cli_ciudad.setText(listadoCliente.get(i).getCiudad());          
                        }
                        //Eliminamos la Busqueda Actual#######################################################
                         DefaultTableModel md =(DefaultTableModel)ListadoBusquedas.getModel();
                        int CantEliminar= ListadoBusquedas.getRowCount() -1;
                        for(int i =CantEliminar; i>=0; i--){
                            md.removeRow(i);
                        }
                        //######################################################################################
                        VentanaInternaVentas.show(false);
                    }catch(Exception e){
                        JOptionPane.showMessageDialog(null, "No se pudo cargar el Cliente");
                    }
                }
            }catch(Exception e){
            }
        }
        if(valor.equals("CP")){
            int fila1;
            try{
                fila1=ListadoBusquedas.getSelectedRow();
                if(fila1==-1){
                    JOptionPane.showMessageDialog(null,"no se ha seleccionando ninguna fila");
                }
                else{
                    /*0cp  1producto   2.Bodega   3. cant inicia
                    4.saldo.   5. fechaCompra   6. fechaMaxExpo  7.Nombre.PROVE*/
                    accion="modificar";
                    modelo=(DefaultTableModel)ListadoBusquedas.getModel();
                    registroCP[0]=(String)modelo.getValueAt(fila1, 0);
                    registroCP[1]=(String)modelo.getValueAt(fila1, 1);
                    registroCP[2]=(String)modelo.getValueAt(fila1, 2);
                    registroCP[3]=(String)modelo.getValueAt(fila1, 7);
                    registroCP[4]=(String)modelo.getValueAt(fila1, 5);
                    registroCP[5]=(String)modelo.getValueAt(fila1, 6);
                    registroCP[6]=(String)modelo.getValueAt(fila1, 4);
                    registroCP[7]="0";
                    if(validarCPcargadoEncarrito(registroCP[0])){
                        JOptionPane.showMessageDialog(null, "El cp ya fue cargado");
                        //Eliminamos la Busqueda Actual#######################################################
                         DefaultTableModel md =(DefaultTableModel)ListadoBusquedas.getModel();
                        int CantEliminar= ListadoBusquedas.getRowCount() -1;
                        for(int i =CantEliminar; i>=0; i--){
                            md.removeRow(i);
                        }
                        VentanaInternaVentas.show(false);
                    }else{
                        modeloCP.addRow(registroCP);
                        CarritoVentaCP.setModel(modeloCP);
                        //Eliminamos la Busqueda Actual#######################################################
                         DefaultTableModel md =(DefaultTableModel)ListadoBusquedas.getModel();
                        int CantEliminar= ListadoBusquedas.getRowCount() -1;
                        for(int i =CantEliminar; i>=0; i--){
                            md.removeRow(i);
                        }
                        VentanaInternaVentas.show(false);
                    }
                }
            }catch(Exception e){
            }
        }
    }//GEN-LAST:event_EditarActionPerformed

    private void jLabel21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseClicked
        VentanaInternaVentas.show(true);
        CargarVentanaInterna(1);
        valor="Clientes";
    }//GEN-LAST:event_jLabel21MouseClicked

    private void jLabel20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseClicked
        VentanaInternaVentas.show(true);
        CargarVentanaInterna(2);
        valor="CP"; 
    }//GEN-LAST:event_jLabel20MouseClicked

    private void CarritoVentaCPKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CarritoVentaCPKeyPressed
        int filas = CarritoVentaCP.getRowCount();
        DefaultTableModel modeloX=(DefaultTableModel)CarritoVentaCP.getModel();
        for(int i=0; i< filas; i++){
            try{
               //JOptionPane.showMessageDialog(null, (String)modeloX.getValueAt(i, 7));
               int cantidadDisponibleEnBodega = Integer.parseInt((String)modeloX.getValueAt(i, 6));
               int cantidadSolicitadaEnVenta = Integer.parseInt((String)modeloX.getValueAt(i, 7));
               if(cantidadSolicitadaEnVenta > cantidadDisponibleEnBodega){
                  JOptionPane.showMessageDialog(null, "La cantidad no puede superar el saldo");
                   modeloX.setValueAt("0", i, 7);
               }
               if(cantidadSolicitadaEnVenta < 0){
                  JOptionPane.showMessageDialog(null, "La cantidad solicitada no puede ser negativa");
                   modeloX.setValueAt("0", i, 7);
               }
            }catch(Exception e){
               JOptionPane.showMessageDialog(null,"EL valor ingresado en la fila No. "+(i +1)+" debe ser Numerico");
               modeloX.setValueAt("0", i, 7);
            }
        }
    }//GEN-LAST:event_CarritoVentaCPKeyPressed

    private void CarritoVentaCPMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CarritoVentaCPMouseEntered
      int filas = CarritoVentaCP.getRowCount();
        DefaultTableModel modeloX=(DefaultTableModel)CarritoVentaCP.getModel();
        for(int i=0; i< filas; i++){
            try{
               //JOptionPane.showMessageDialog(null, (String)modeloX.getValueAt(i, 7));
               int cantidadDisponibleEnBodega = Integer.parseInt((String)modeloX.getValueAt(i, 6));
               int cantidadSolicitadaEnVenta = Integer.parseInt((String)modeloX.getValueAt(i, 7));
               if(cantidadSolicitadaEnVenta > cantidadDisponibleEnBodega){
                  JOptionPane.showMessageDialog(null, "La cantidad no puede superar el saldo");
                   modeloX.setValueAt("0", i, 7);
               }
               if(cantidadSolicitadaEnVenta < 0){
                  JOptionPane.showMessageDialog(null, "La cantidad solicitada no puede ser negativa");
                   modeloX.setValueAt("0", i, 7);
               }
            }catch(Exception e){
               JOptionPane.showMessageDialog(null,"EL valor ingresado en la fila No. "+(i +1)+" debe ser Numerico");
               modeloX.setValueAt("0", i, 7);
            }
        }
    }//GEN-LAST:event_CarritoVentaCPMouseEntered

    private void CarritoVentaCPMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CarritoVentaCPMouseExited
        int filas = CarritoVentaCP.getRowCount();
        DefaultTableModel modeloX=(DefaultTableModel)CarritoVentaCP.getModel();
        for(int i=0; i< filas; i++){
            try{
               //JOptionPane.showMessageDialog(null, (String)modeloX.getValueAt(i, 7));
               int cantidadDisponibleEnBodega = Integer.parseInt((String)modeloX.getValueAt(i, 6));
               int cantidadSolicitadaEnVenta = Integer.parseInt((String)modeloX.getValueAt(i, 7));
               if(cantidadSolicitadaEnVenta > cantidadDisponibleEnBodega){
                  JOptionPane.showMessageDialog(null, "La cantidad no puede superar el saldo");
                   modeloX.setValueAt("0", i, 7);
               }
               if(cantidadSolicitadaEnVenta < 0){
                  JOptionPane.showMessageDialog(null, "La cantidad solicitada no puede ser negativa");
                   modeloX.setValueAt("0", i, 7);
               }
            }catch(Exception e){
               JOptionPane.showMessageDialog(null,"EL valor ingresado en la fila No. "+(i +1)+" debe ser Numerico");
               modeloX.setValueAt("0", i, 7);
            }
        }
    }//GEN-LAST:event_CarritoVentaCPMouseExited

    private void CarritoVentaCPMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CarritoVentaCPMousePressed
        int filas = CarritoVentaCP.getRowCount();
        DefaultTableModel modeloX=(DefaultTableModel)CarritoVentaCP.getModel();
        for(int i=0; i< filas; i++){
            try{
               //JOptionPane.showMessageDialog(null, (String)modeloX.getValueAt(i, 7));
               int cantidadDisponibleEnBodega = Integer.parseInt((String)modeloX.getValueAt(i, 6));
               int cantidadSolicitadaEnVenta = Integer.parseInt((String)modeloX.getValueAt(i, 7));
               if(cantidadSolicitadaEnVenta > cantidadDisponibleEnBodega){
                  JOptionPane.showMessageDialog(null, "La cantidad no puede superar el saldo");
                   modeloX.setValueAt("0", i, 7);
               }
               if(cantidadSolicitadaEnVenta < 0){
                  JOptionPane.showMessageDialog(null, "La cantidad solicitada no puede ser negativa");
                   modeloX.setValueAt("0", i, 7);
               }
            }catch(Exception e){
               JOptionPane.showMessageDialog(null,"EL valor ingresado en la fila No. "+(i +1)+" debe ser Numerico");
               modeloX.setValueAt("0", i, 7);
            }
        }
    }//GEN-LAST:event_CarritoVentaCPMousePressed

    private void CarritoVentaCPMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CarritoVentaCPMouseReleased
        int filas = CarritoVentaCP.getRowCount();
        DefaultTableModel modeloX=(DefaultTableModel)CarritoVentaCP.getModel();
        for(int i=0; i< filas; i++){
            try{
               //JOptionPane.showMessageDialog(null, (String)modeloX.getValueAt(i, 7));
               int cantidadDisponibleEnBodega = Integer.parseInt((String)modeloX.getValueAt(i, 6));
               int cantidadSolicitadaEnVenta = Integer.parseInt((String)modeloX.getValueAt(i, 7));
               if(cantidadSolicitadaEnVenta > cantidadDisponibleEnBodega){
                  JOptionPane.showMessageDialog(null, "La cantidad no puede superar el saldo");
                   modeloX.setValueAt("0", i, 7);
               }
               if(cantidadSolicitadaEnVenta < 0){
                  JOptionPane.showMessageDialog(null, "La cantidad solicitada no puede ser negativa");
                   modeloX.setValueAt("0", i, 7);
               }
            }catch(Exception e){
               JOptionPane.showMessageDialog(null,"EL valor ingresado en la fila No. "+(i +1)+" debe ser Numerico");
               modeloX.setValueAt("0", i, 7);
            }
        }
    }//GEN-LAST:event_CarritoVentaCPMouseReleased

    private void CarritoVentaCPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CarritoVentaCPMouseClicked
        int filas = CarritoVentaCP.getRowCount();
        DefaultTableModel modeloX=(DefaultTableModel)CarritoVentaCP.getModel();
        for(int i=0; i< filas; i++){
            try{
               //JOptionPane.showMessageDialog(null, (String)modeloX.getValueAt(i, 7));
               int cantidadDisponibleEnBodega = Integer.parseInt((String)modeloX.getValueAt(i, 6));
               int cantidadSolicitadaEnVenta = Integer.parseInt((String)modeloX.getValueAt(i, 7));
               if(cantidadSolicitadaEnVenta > cantidadDisponibleEnBodega){
                  JOptionPane.showMessageDialog(null, "La cantidad no puede superar el saldo");
                   modeloX.setValueAt("0", i, 7);
               }
               if(cantidadSolicitadaEnVenta < 0){
                  JOptionPane.showMessageDialog(null, "La cantidad solicitada no puede ser negativa");
                   modeloX.setValueAt("0", i, 7);
               }
            }catch(Exception e){
               JOptionPane.showMessageDialog(null,"EL valor ingresado en la fila No. "+(i +1)+" debe ser Numerico");
               modeloX.setValueAt("0", i, 7);
            }
        }
    }//GEN-LAST:event_CarritoVentaCPMouseClicked

    private void EliminarCPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarCPActionPerformed
        // TODO lo del clik derechoo
        DefaultTableModel modeloY;
        int fila1=CarritoVentaCP.getSelectedRow();
        if(fila1==-1){
            JOptionPane.showMessageDialog(null,"no se ha seleccionando ninguna fila");
        }
        else{  
            modeloY=(DefaultTableModel)CarritoVentaCP.getModel();
            modeloY.removeRow(fila1);
        }                       
    }//GEN-LAST:event_EliminarCPActionPerformed

    private void precioVentaKiloMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_precioVentaKiloMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_precioVentaKiloMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CargarCliente;
    private javax.swing.JTable CarritoVentaCP;
    private javax.swing.JLabel ConsumoNo;
    private javax.swing.JMenuItem Editar;
    private javax.swing.JPopupMenu Eliminar;
    private javax.swing.JMenuItem EliminarCP;
    private javax.swing.JTable ListadoBusquedas;
    private javax.swing.JButton RegistrarConsumo;
    private javax.swing.JPopupMenu Seleccionar;
    private javax.swing.JInternalFrame VentanaInternaVentas;
    private javax.swing.JLabel alertaDatosFactura;
    private javax.swing.JLabel alertaEmpresaLocal;
    private javax.swing.JButton buscar1;
    private javax.swing.JButton cancelar1;
    private javax.swing.JLabel cli_celular;
    private javax.swing.JLabel cli_ciudad;
    private javax.swing.JLabel cli_correo;
    private javax.swing.JLabel cli_direccion;
    private javax.swing.JLabel cli_nit;
    private javax.swing.JLabel cli_nombre;
    private javax.swing.JLabel cli_sucursal;
    private javax.swing.JLabel cli_telefono;
    private javax.swing.JTextField codigo;
    private com.toedter.calendar.JDateChooser fechaFactura;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JButton limpiar1;
    private javax.swing.JTextArea observacion;
    private javax.swing.JTextField precioVentaKilo;
    private javax.swing.JLabel ventanaInterna_Nombre;
    // End of variables declaration//GEN-END:variables
 
    public void CargarVentanaInterna(int n){
        switch(n){
            case 1:{//Cargamos la ventana Interna para Buscar Clientes
                VentanaInternaVentas.show(true);
                VentanaInternaVentas.setTitle("Listado De Clientes");
                ventanaInterna_Nombre.setText("Buscar Cliente");
                TextPrompt placeholder = new TextPrompt("Buscar por Nit o Nombre:", codigo);
                valor="Clientes";
                break;
            }
            case 2:{//Cargamos la ventana Interna para Buscar CP
                VentanaInternaVentas.show(true);
                VentanaInternaVentas.setTitle("Listado De CP");
                ventanaInterna_Nombre.setText("Buscar CP");
                TextPrompt placeholder = new TextPrompt("Buscar por Nit o Nombre:", codigo);
                valor="CP";            
                break;
            }
        }     
    }
    public void BuscarEnVentanaInterna() throws SQLException{
        switch(valor){
            case "Clientes":{
                try{
                    ListadoBusquedas.setDefaultRenderer(Object.class, new Myrender_ConsumoDefaultEmpresaLocal());
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, "No se pudo cargar los colores");
                }
                DefaultTableModel modelo;
                String [] titulo= {"NIT","SUCURSAL", "NOMBRE"};
                String [] registro = new String[3]; 
                modelo = new DefaultTableModel(null, titulo);
                ControlDB_Cliente controlDB_Cliente = new ControlDB_Cliente();
                ArrayList<Cliente> listadoClientes=controlDB_Cliente.buscarClienteLocalConsumo(codigo.getText());
                for(int i =0; i< listadoClientes.size(); i++){ 
                    registro[0]=""+listadoClientes.get(i).getNit();
                    registro[1]=""+listadoClientes.get(i).getSucursal();
                    registro[2]=""+listadoClientes.get(i).getNombre();
                    modelo.addRow(registro);
                    ListadoBusquedas.setModel(modelo);
                    //JOptionPane.showMessageDialog(null, "Hola si hay info"+listadoClientes.get(i).getNit()+listadoClientes.get(i).getDigitoVerificacion()+listadoClientes.get(i).getNombre());
                }
                break;
            }
            case "CP":{
                DefaultTableModel modelo;
                String [] titulo= {"CP","PRODUCTO","BODEGA","CANT. INICIAL","SALDO", "FECHA_COMPRA", "FECHA. MAX. EXPORTACIÓN", "NOMBRE_PROVEEDOR"};
                String [] registro = new String[8]; 
                modelo = new DefaultTableModel(null, titulo);
                ControlDB_ConsumoCajasNacional controlDB_ConsumoCajasNacional= new ControlDB_ConsumoCajasNacional();
                ArrayList<IngresoProducto> listadoCp=controlDB_ConsumoCajasNacional.consultarCpBodegaNacional(codigo.getText());
                for(int i =0; i< listadoCp.size(); i++){
                    registro[0]=""+listadoCp.get(i).getCp();
                    registro[1]=""+controlDB_ConsumoCajasNacional.validarNombreProducto(listadoCp.get(i).getProducto_id()).getDescripcion();
                    registro[2]=""+controlDB_ConsumoCajasNacional.validarNombreBodegaNacional(""+listadoCp.get(i).getBodega_ingresoProductoInicial());
                    registro[3]=""+listadoCp.get(i).getCantidadInicial();
                    registro[4]=""+controlDB_ConsumoCajasNacional.validarSaldoBodegaNacional(listadoCp.get(i).getId());
                    registro[5]=""+listadoCp.get(i).getFechaCompra();
                    registro[6]=""+listadoCp.get(i).getFechaMaximaExportacion();
                    //Consultamos el Nombre del proveedor atravez del Nit y sucursal
                    ControlDB_Proveedor controlDB_Proveedor = new ControlDB_Proveedor();
                    Proveedor prov = new Proveedor();
                    prov.setNit(listadoCp.get(i).getProveedor_nit());
                    prov.setSucursal(listadoCp.get(i).getProveedor_sucursal());

                    ArrayList<Proveedor> listadoProveedor=controlDB_Proveedor.consultarUnicoProveedor(prov);
                    for(int a =0; a< listadoProveedor.size(); a++){ 
                        registro[7]=""+listadoProveedor.get(a).getNombre(); 
                    }
                    modelo.addRow(registro);
                    ListadoBusquedas.setModel(modelo);  
                }
                try{
                    String fechaFactVent=retornarFechaVentaEnString();
                    //ListadoBusquedas.setDefaultRenderer(Object.class, new Myrender(6));
                    ListadoBusquedas.setDefaultRenderer(Object.class, new Myrender_VentasRegistrarNacional(6,fechaFactVent));
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, "No se pudo cargar los colores");
                }
            }   
        }
    }    

    public boolean validarCPcargadoEncarrito(String cp){
        boolean retorno =false;
        int filas = CarritoVentaCP.getRowCount();
        DefaultTableModel modeloX=(DefaultTableModel)CarritoVentaCP.getModel();
        for(int i=0; i< filas; i++){
            String data=(String)modeloX.getValueAt(i, 0);
            if(data.equals(cp)){
                retorno=true;
            }
        }
        return retorno;
    }
    public boolean validarQueCargueAlmenosUnCP(){
        boolean retorno =true;
        int filas = CarritoVentaCP.getRowCount();
        DefaultTableModel modeloX=(DefaultTableModel)CarritoVentaCP.getModel();
        for(int i=0; i< filas; i++){
            retorno=false;
        }
        return retorno;
    }
    public boolean validarEnCPCargadosCantidadAVenderSeaMayorACero(){
        boolean retorno =false;
        int filas = CarritoVentaCP.getRowCount();
        DefaultTableModel modeloX=(DefaultTableModel)CarritoVentaCP.getModel();
        for(int i=0; i< filas; i++){
            String data=(String)modeloX.getValueAt(i, 7);
            if(data.compareTo("0")<= 0){
                retorno=true;
            }
        }
        return retorno;
    }

     public boolean Validar_Si_CP_EstaVencido(String fechaMaximaExportacion) throws ParseException{
        Date fechaActual = new Date(); 
        String  Fecha =new SimpleDateFormat("yyyy-MM-dd").format(fechaActual);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaHoy=dateFormat.parse(Fecha);
        Date fechaDevo=dateFormat.parse(fechaMaximaExportacion);
        int diasAtraso=(int) ((fechaDevo.getTime() -fechaHoy.getTime())/86400000);
        if(diasAtraso >= 61){
            return false;
        }else{
            if(diasAtraso >= 31 && diasAtraso <= 60){
                return false;
            }else{
                return true;
            }
        }        
    }
     public String retornarFechaVentaEnString(){// Retorna la fecha de Venta en formato "yyyy-MM-dd"
         String fechaFacturaV="";
        try{
            //try{
            Calendar fecha = fechaFactura.getCalendar();
            String ano = ""+fecha.get(Calendar.YEAR);
            String mes = "";
            String dia = "";
            if((fecha.get(Calendar.MONTH) +1) <=9){
                mes = "0"+(fecha.get(Calendar.MONTH) + 1);
            }else{
                mes = ""+(fecha.get(Calendar.MONTH) + 1);
            }
            if(fecha.get(Calendar.DAY_OF_MONTH) <=9){
                dia = "0"+fecha.get(Calendar.DAY_OF_MONTH);
            }else{
                dia = ""+fecha.get(Calendar.DAY_OF_MONTH);
            }
            fechaFacturaV=ano+"-"+mes+"-"+dia;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Verifique la fecha de la Factura de Venta");
        }
        return fechaFacturaV;
    }
}
