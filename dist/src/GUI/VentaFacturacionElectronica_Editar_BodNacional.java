package GUI;

import Controladores.ControlDB_Cliente;
import Controladores.ControlDB_Compra;
import Controladores.ControlDB_EmpresaLocal;
import Controladores.ControlDB_Proveedor;
import Controladores.ControlDB_VentaFacturacionElectronica_EditarFacturaNacional;
import Modelos.Cliente;
import Modelos.EmpresaLocal;
import Modelos.FacturaVenta;  
import Modelos.IngresoProducto;
import Modelos.ItemFactura;
import Modelos.ItemFacturaEditar;
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

public class VentaFacturacionElectronica_Editar_BodNacional extends javax.swing.JPanel {
    String accion="";
    Usuario user;
    String []tituloCP=         {"CP","PRODUCTO","BODEGA","NOMBRE_PROV.","FECHA_COMPRA","FECHA_MAX._EXPORT.","SALDO","CANTIDAD A VENDER"};
    //String []tituloCPElimados= {"CP","PRODUCTO","BODEGA","NOMBRE_PROV.","FECHA_COMPRA","FECHA_MAX._EXPORT.","SALDO","CANTIDAD A VENDER"};
    String [] registroCP= new String[9];
    
    DefaultTableModel modeloCP;
    DefaultTableModel modeloCP_Eliminados;
    int facturaVentaNumero=0;
    int idFacturaVentaEdit=0;
     String [] registroCP_Eliminados= new String[9]; ;
     String []tituloCP_Eliminados= {"CP","PRODUCTO","BODEGA","NOMBRE_PROV.","FECHA_COMPRA","FECHA_MAX._EXPORT.","SALDO","CANTIDAD A VENDER","CARGADAEN FACT."};
    public VentaFacturacionElectronica_Editar_BodNacional(Usuario u) {
        user= u;
        initComponents();
        VentanaInternaCp.show(false);
        VentanaBuscarDocumento.show(false);
        VentanaCPEliminados.show(false);
        VentanaInternaCp.show(false);
        VentanaInternaClientes.show(false);
        //Formato de la tabla en la que se cargan los CP
        modeloCP = new DefaultTableModel(null, tituloCP);
        CarritoVentaCP.setModel(modeloCP);
        fechaFactura.setEnabled(true);
        
       
        
        //Inicializamos variables de CP Elimninados;***************
        modeloCP_Eliminados = new DefaultTableModel(null, tituloCP_Eliminados);
        CP_Eliminados.setModel(modeloCP_Eliminados);
        //**********************************************************
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Seleccionar_CP = new javax.swing.JPopupMenu();
        Seleccionar_Cp = new javax.swing.JMenuItem();
        Eliminar = new javax.swing.JPopupMenu();
        EliminarCP = new javax.swing.JMenuItem();
        SeleccionarDocumento = new javax.swing.JPopupMenu();
        SeleccionarDocumentos = new javax.swing.JMenuItem();
        Seleccionar_Cliente = new javax.swing.JPopupMenu();
        Seleccionar_Clientes = new javax.swing.JMenuItem();
        Restaurar_CP = new javax.swing.JPopupMenu();
        Restaurar_Cp = new javax.swing.JMenuItem();
        VentanaInternaCp = new javax.swing.JInternalFrame();
        ventanaInterna_Nombre3 = new javax.swing.JLabel();
        codigoCP = new javax.swing.JTextField();
        buscarCP = new javax.swing.JButton();
        limpiarCP = new javax.swing.JButton();
        cancelarCP = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        tabla_ListadoBusquedaCP = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        VentanaCPEliminados = new javax.swing.JInternalFrame();
        jScrollPane1 = new javax.swing.JScrollPane();
        CP_Eliminados = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        botonCancelarBusqueda1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        VentanaInternaClientes = new javax.swing.JInternalFrame();
        ventanaInterna_Nombre2 = new javax.swing.JLabel();
        codigoClientes = new javax.swing.JTextField();
        buscarClientes = new javax.swing.JButton();
        limpiarClientes = new javax.swing.JButton();
        cancelarClientes = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        tabla_ListadoBusquedaClientes = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        VentanaBuscarDocumento = new javax.swing.JInternalFrame();
        alertaBuscarFacturaVenta = new javax.swing.JLabel();
        codigoDocumento = new javax.swing.JTextField();
        ventanaInterna_Nombre1 = new javax.swing.JLabel();
        botonLimpiarBusqueda = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        ListadoBusquedasDocumentos = new javax.swing.JTable();
        botonBuscarDocumento = new javax.swing.JButton();
        botonCancelarBusqueda = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        cli_celular = new javax.swing.JLabel();
        cli_nit = new javax.swing.JLabel();
        cli_nombre = new javax.swing.JLabel();
        cli_telefono = new javax.swing.JLabel();
        cli_sucursal = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        label_CargarCliente = new javax.swing.JLabel();
        label_CargarCP = new javax.swing.JLabel();
        FacturaVentaNo = new javax.swing.JLabel();
        CargarCliente = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        cli_direccion = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        cli_correo = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        cli_ciudad = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        label_CargarCP2 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        CarritoVentaCP = new javax.swing.JTable();
        RegistrarVentaExtranjera = new javax.swing.JButton();
        alertaCliente = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        RegistrarVentaExtranjera1 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        fechaFactura = new com.toedter.calendar.JDateChooser();
        jLabel19 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        observacion = new javax.swing.JTextArea();
        jLabel14 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        precioVentaKilo = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        alertaDatosFactura = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();

        Seleccionar_Cp.setText("Seleccionar_CP");
        Seleccionar_Cp.setAutoscrolls(true);
        Seleccionar_Cp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Seleccionar_CpActionPerformed(evt);
            }
        });
        Seleccionar_CP.add(Seleccionar_Cp);

        EliminarCP.setText("EliminarCP");
        EliminarCP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarCPActionPerformed(evt);
            }
        });
        Eliminar.add(EliminarCP);

        SeleccionarDocumentos.setActionCommand("SeleccionarDocumento");
        SeleccionarDocumentos.setLabel("SeleccionarDocumento");
        SeleccionarDocumentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SeleccionarDocumentosActionPerformed(evt);
            }
        });
        SeleccionarDocumento.add(SeleccionarDocumentos);

        Seleccionar_Clientes.setText("Seleccionar_Clientes");
        Seleccionar_Clientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Seleccionar_ClientesActionPerformed(evt);
            }
        });
        Seleccionar_Cliente.add(Seleccionar_Clientes);

        Restaurar_Cp.setText("Restaurar_CP");
        Restaurar_Cp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Restaurar_CpActionPerformed(evt);
            }
        });
        Restaurar_CP.add(Restaurar_Cp);

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        VentanaInternaCp.setBackground(new java.awt.Color(255, 255, 255));
        VentanaInternaCp.setVisible(true);
        VentanaInternaCp.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ventanaInterna_Nombre3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        ventanaInterna_Nombre3.setForeground(new java.awt.Color(0, 153, 153));
        ventanaInterna_Nombre3.setText("Listado de CP");
        VentanaInternaCp.getContentPane().add(ventanaInterna_Nombre3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 210, -1));

        codigoCP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                codigoCPKeyPressed(evt);
            }
        });
        VentanaInternaCp.getContentPane().add(codigoCP, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 250, 30));

        buscarCP.setBackground(new java.awt.Color(255, 255, 255));
        buscarCP.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        buscarCP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/Bodega_Actualizar_Bton_Buscar.PNG"))); // NOI18N
        buscarCP.setText("BUSCAR");
        buscarCP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarCPActionPerformed(evt);
            }
        });
        VentanaInternaCp.getContentPane().add(buscarCP, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 140, -1));

        limpiarCP.setBackground(new java.awt.Color(255, 255, 255));
        limpiarCP.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        limpiarCP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/Interfaz_Icon_Borrar.PNG"))); // NOI18N
        limpiarCP.setText("LIMPIAR");
        limpiarCP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarCPActionPerformed(evt);
            }
        });
        VentanaInternaCp.getContentPane().add(limpiarCP, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, 140, 40));

        cancelarCP.setBackground(new java.awt.Color(255, 255, 255));
        cancelarCP.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cancelarCP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/Bodega_Actualizar_Bton_Cancelar.PNG"))); // NOI18N
        cancelarCP.setText("CANCELAR");
        cancelarCP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarCPActionPerformed(evt);
            }
        });
        VentanaInternaCp.getContentPane().add(cancelarCP, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 90, 160, 40));

        tabla_ListadoBusquedaCP = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tabla_ListadoBusquedaCP.setBackground(new java.awt.Color(153, 204, 255));
        tabla_ListadoBusquedaCP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tabla_ListadoBusquedaCP.setComponentPopupMenu(Seleccionar_CP);
        tabla_ListadoBusquedaCP.getTableHeader().setReorderingAllowed(false);
        jScrollPane7.setViewportView(tabla_ListadoBusquedaCP);

        VentanaInternaCp.getContentPane().add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 137, 1020, 260));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/fondo.png"))); // NOI18N
        VentanaInternaCp.getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 410));

        add(VentanaInternaCp, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 1220, 450));

        VentanaCPEliminados.setBackground(new java.awt.Color(255, 255, 255));
        VentanaCPEliminados.setVisible(true);
        VentanaCPEliminados.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        CP_Eliminados = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }

        };
        CP_Eliminados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        CP_Eliminados.setComponentPopupMenu(Restaurar_CP);
        CP_Eliminados.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(CP_Eliminados);

        VentanaCPEliminados.getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 1170, 180));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("LISTADO DE CP ELIMANDOS");
        VentanaCPEliminados.getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 30));

        botonCancelarBusqueda1.setBackground(new java.awt.Color(255, 255, 255));
        botonCancelarBusqueda1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        botonCancelarBusqueda1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/Bodega_Actualizar_Bton_Cancelar.PNG"))); // NOI18N
        botonCancelarBusqueda1.setText("CERRAR");
        botonCancelarBusqueda1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarBusqueda1ActionPerformed(evt);
            }
        });
        VentanaCPEliminados.getContentPane().add(botonCancelarBusqueda1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 230, 160, 50));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/fondo.png"))); // NOI18N
        VentanaCPEliminados.getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 410));

        add(VentanaCPEliminados, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 1220, 450));

        VentanaInternaClientes.setBackground(new java.awt.Color(255, 255, 255));
        VentanaInternaClientes.setTitle("Busqueda Clientes");
        VentanaInternaClientes.setVisible(true);
        VentanaInternaClientes.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ventanaInterna_Nombre2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        ventanaInterna_Nombre2.setForeground(new java.awt.Color(0, 153, 153));
        ventanaInterna_Nombre2.setText("Listados Clientes:");
        VentanaInternaClientes.getContentPane().add(ventanaInterna_Nombre2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 210, -1));

        codigoClientes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                codigoClientesKeyPressed(evt);
            }
        });
        VentanaInternaClientes.getContentPane().add(codigoClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 250, 30));

        buscarClientes.setBackground(new java.awt.Color(255, 255, 255));
        buscarClientes.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        buscarClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/Bodega_Actualizar_Bton_Buscar.PNG"))); // NOI18N
        buscarClientes.setText("BUSCAR");
        buscarClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarClientesActionPerformed(evt);
            }
        });
        VentanaInternaClientes.getContentPane().add(buscarClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 140, -1));

        limpiarClientes.setBackground(new java.awt.Color(255, 255, 255));
        limpiarClientes.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        limpiarClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/Interfaz_Icon_Borrar.PNG"))); // NOI18N
        limpiarClientes.setText("LIMPIAR");
        limpiarClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarClientesActionPerformed(evt);
            }
        });
        VentanaInternaClientes.getContentPane().add(limpiarClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, 140, 40));

        cancelarClientes.setBackground(new java.awt.Color(255, 255, 255));
        cancelarClientes.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cancelarClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/Bodega_Actualizar_Bton_Cancelar.PNG"))); // NOI18N
        cancelarClientes.setText("CANCELAR");
        cancelarClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarClientesActionPerformed(evt);
            }
        });
        VentanaInternaClientes.getContentPane().add(cancelarClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 90, 160, 40));

        tabla_ListadoBusquedaClientes = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        tabla_ListadoBusquedaClientes.setBackground(new java.awt.Color(153, 204, 255));
        tabla_ListadoBusquedaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tabla_ListadoBusquedaClientes.setComponentPopupMenu(Seleccionar_Cliente);
        tabla_ListadoBusquedaClientes.getTableHeader().setReorderingAllowed(false);
        jScrollPane6.setViewportView(tabla_ListadoBusquedaClientes);

        VentanaInternaClientes.getContentPane().add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 960, 200));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/fondo.png"))); // NOI18N
        VentanaInternaClientes.getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 410));

        add(VentanaInternaClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 1220, 450));

        VentanaBuscarDocumento.setBackground(new java.awt.Color(255, 255, 255));
        VentanaBuscarDocumento.setTitle("Buscar Factura Ventas Extranjeras");
        VentanaBuscarDocumento.setVisible(true);
        VentanaBuscarDocumento.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        alertaBuscarFacturaVenta.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        alertaBuscarFacturaVenta.setForeground(new java.awt.Color(255, 0, 51));
        VentanaBuscarDocumento.getContentPane().add(alertaBuscarFacturaVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 770, 30));

        codigoDocumento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                codigoDocumentoKeyPressed(evt);
            }
        });
        VentanaBuscarDocumento.getContentPane().add(codigoDocumento, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 250, 30));

        ventanaInterna_Nombre1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ventanaInterna_Nombre1.setForeground(new java.awt.Color(0, 153, 153));
        ventanaInterna_Nombre1.setText("Ingrese Número de Factura");
        VentanaBuscarDocumento.getContentPane().add(ventanaInterna_Nombre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 350, -1));

        botonLimpiarBusqueda.setBackground(new java.awt.Color(255, 255, 255));
        botonLimpiarBusqueda.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        botonLimpiarBusqueda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/Interfaz_Icon_Borrar.PNG"))); // NOI18N
        botonLimpiarBusqueda.setText("LIMPIAR");
        botonLimpiarBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonLimpiarBusquedaActionPerformed(evt);
            }
        });
        VentanaBuscarDocumento.getContentPane().add(botonLimpiarBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, 140, 40));

        ListadoBusquedasDocumentos = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }

        };
        ListadoBusquedasDocumentos.setBackground(new java.awt.Color(153, 204, 255));
        ListadoBusquedasDocumentos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        ListadoBusquedasDocumentos.setComponentPopupMenu(SeleccionarDocumento);
        ListadoBusquedasDocumentos.setFocusable(false);
        ListadoBusquedasDocumentos.setGridColor(new java.awt.Color(0, 204, 204));
        ListadoBusquedasDocumentos.setSelectionBackground(new java.awt.Color(255, 102, 102));
        ListadoBusquedasDocumentos.getTableHeader().setReorderingAllowed(false);
        ListadoBusquedasDocumentos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ListadoBusquedasDocumentosMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ListadoBusquedasDocumentosMousePressed(evt);
            }
        });
        ListadoBusquedasDocumentos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ListadoBusquedasDocumentosKeyPressed(evt);
            }
        });
        jScrollPane5.setViewportView(ListadoBusquedasDocumentos);

        VentanaBuscarDocumento.getContentPane().add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 1200, 230));

        botonBuscarDocumento.setBackground(new java.awt.Color(255, 255, 255));
        botonBuscarDocumento.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        botonBuscarDocumento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/Bodega_Actualizar_Bton_Buscar.PNG"))); // NOI18N
        botonBuscarDocumento.setText("BUSCAR");
        botonBuscarDocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarDocumentoActionPerformed(evt);
            }
        });
        VentanaBuscarDocumento.getContentPane().add(botonBuscarDocumento, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 140, -1));

        botonCancelarBusqueda.setBackground(new java.awt.Color(255, 255, 255));
        botonCancelarBusqueda.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        botonCancelarBusqueda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/Bodega_Actualizar_Bton_Cancelar.PNG"))); // NOI18N
        botonCancelarBusqueda.setText("CANCELAR");
        botonCancelarBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarBusquedaActionPerformed(evt);
            }
        });
        VentanaBuscarDocumento.getContentPane().add(botonCancelarBusqueda, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 90, 160, 40));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/fondo.png"))); // NOI18N
        VentanaBuscarDocumento.getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 410));

        add(VentanaBuscarDocumento, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 1220, 450));

        cli_celular.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cli_celular.setForeground(new java.awt.Color(102, 102, 102));
        add(cli_celular, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 180, 360, 20));

        cli_nit.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cli_nit.setForeground(new java.awt.Color(102, 102, 102));
        add(cli_nit, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 100, 360, 20));

        cli_nombre.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cli_nombre.setForeground(new java.awt.Color(102, 102, 102));
        add(cli_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 140, 360, 20));

        cli_telefono.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cli_telefono.setForeground(new java.awt.Color(102, 102, 102));
        add(cli_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 160, 360, 20));

        cli_sucursal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cli_sucursal.setForeground(new java.awt.Color(102, 102, 102));
        add(cli_sucursal, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 120, 360, 20));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 102, 102));
        jLabel9.setText("BUSCAR FACTURA");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 200, -1));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel18.setText("Sucursal:");
        add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, 70, 20));

        label_CargarCliente.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        label_CargarCliente.setText("CLIENTE");
        label_CargarCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_CargarClienteMouseClicked(evt);
            }
        });
        add(label_CargarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 90, 30));

        label_CargarCP.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        label_CargarCP.setText("CARGAR CP");
        label_CargarCP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_CargarCPMouseClicked(evt);
            }
        });
        add(label_CargarCP, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 400, 80, 30));

        FacturaVentaNo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        FacturaVentaNo.setText("Factura de Venta No.");
        add(FacturaVentaNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 70, 260, 20));

        CargarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/Compra_Agregar_Proveedor.png"))); // NOI18N
        CargarCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CargarClienteMouseClicked(evt);
            }
        });
        add(CargarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 80, 100));

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel25.setText("Celular:");
        add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 180, 70, 20));

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel26.setText("CARGAR ");
        add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 60, 20));

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel27.setText("Dirección:");
        add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 100, 70, 20));

        cli_direccion.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cli_direccion.setForeground(new java.awt.Color(102, 102, 102));
        add(cli_direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 100, 460, 20));

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel31.setText("Correo:");
        add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 120, 70, 20));

        cli_correo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cli_correo.setForeground(new java.awt.Color(102, 102, 102));
        add(cli_correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 120, 470, 20));

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel32.setText("Ciudad:");
        add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 140, 50, 20));

        cli_ciudad.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cli_ciudad.setForeground(new java.awt.Color(102, 102, 102));
        add(cli_ciudad, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 140, 470, 20));

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel33.setText("Nombre:");
        add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 140, 70, 20));

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel34.setText("Telefono:");
        add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 160, 70, 20));

        label_CargarCP2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/Compra_Agregar_Proveedor.png"))); // NOI18N
        label_CargarCP2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                label_CargarCP2MouseClicked(evt);
            }
        });
        add(label_CargarCP2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 70, 70));

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

        add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 360, 1010, 150));

        RegistrarVentaExtranjera.setBackground(new java.awt.Color(255, 255, 255));
        RegistrarVentaExtranjera.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        RegistrarVentaExtranjera.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/Bodega_Registrar_Bton_Registrar.PNG"))); // NOI18N
        RegistrarVentaExtranjera.setText("REGISTRAR VENTAS");
        RegistrarVentaExtranjera.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                RegistrarVentaExtranjeraMouseExited(evt);
            }
        });
        RegistrarVentaExtranjera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistrarVentaExtranjeraActionPerformed(evt);
            }
        });
        add(RegistrarVentaExtranjera, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 540, 240, 60));

        alertaCliente.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        alertaCliente.setForeground(new java.awt.Color(255, 0, 51));
        add(alertaCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 160, 770, 30));

        jLabel15.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "INFORMACIÓN DEL CLIENTE", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Adobe Arabic", 1, 14))); // NOI18N
        add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 1080, 140));

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel23.setText("Nit:");
        add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, 70, 20));

        RegistrarVentaExtranjera1.setBackground(new java.awt.Color(255, 255, 255));
        RegistrarVentaExtranjera1.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        RegistrarVentaExtranjera1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/Bodega_Registrar_Bton_Registrar.PNG"))); // NOI18N
        RegistrarVentaExtranjera1.setText("BUSCAR FACTURAS ELECTRONICAS NACIONALES");
        RegistrarVentaExtranjera1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                RegistrarVentaExtranjera1MouseExited(evt);
            }
        });
        RegistrarVentaExtranjera1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistrarVentaExtranjera1ActionPerformed(evt);
            }
        });
        add(RegistrarVentaExtranjera1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, 420, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 102, 102));
        jLabel10.setText("REGISTRO DE VENTA NACIONAL");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 70, 430, -1));
        add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 1070, 20));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setText("MOSTRAR CP ELIMINADOS");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 540, 190, 60));

        fechaFactura.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fechaFacturaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                fechaFacturaMouseEntered(evt);
            }
        });
        add(fechaFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 220, 220, 30));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel19.setText("Observación:");
        add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 260, 120, 30));

        observacion.setColumns(20);
        observacion.setRows(5);
        observacion.setBorder(null);
        jScrollPane2.setViewportView(observacion);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 260, 400, 70));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setText("Factura:");
        add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 230, 80, 30));

        jLabel36.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(102, 102, 102));
        jLabel36.setText("NACIONAL");
        add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 220, 200, 30));

        jLabel38.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel38.setText("Bodega:");
        add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 100, 30));

        precioVentaKilo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                precioVentaKiloMouseClicked(evt);
            }
        });
        add(precioVentaKilo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 260, 200, 30));

        jLabel40.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel40.setText("Por Kilo:");
        add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 140, 20));

        jLabel41.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel41.setText("Precio de Venta");
        add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 140, 30));

        alertaDatosFactura.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        alertaDatosFactura.setForeground(new java.awt.Color(255, 0, 51));
        add(alertaDatosFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 330, 1010, 30));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setText("Fecha de ");
        add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 220, 140, 20));
    }// </editor-fold>//GEN-END:initComponents

    private void CargarClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CargarClienteMouseClicked
        if(FacturaVentaNo.getText().equals("Factura de Venta No.")){
            JOptionPane.showMessageDialog(null, "No se ha cargado factura de venta Electrónica Nacional para editar");
        }else{
            VentanaInternaClientes.show(true);
            TextPrompt placeholder = new TextPrompt("Buscar por Nit o Nombre:", codigoClientes);

            VentanaInternaCp.show(false);
            VentanaBuscarDocumento.show(false);
            VentanaCPEliminados.show(false);

            codigoClientes.setText("");
            //Eliminamos la Busqueda Actual#######################################################
            DefaultTableModel md =(DefaultTableModel)tabla_ListadoBusquedaClientes.getModel();
            int CantEliminar= tabla_ListadoBusquedaClientes.getRowCount() -1;
            for(int i =CantEliminar; i>=0; i--){
               md.removeRow(i);
            }
            DefaultTableModel modelo;
            String [] titulo= {"NIT","SUCURSAL", "NOMBRE"};
            String [] registro = new String[3]; 
            modelo = new DefaultTableModel(null, titulo);
            tabla_ListadoBusquedaClientes.setModel(modelo);
            VentanaInternaClientes.show(true);  
        }
    }//GEN-LAST:event_CargarClienteMouseClicked

    private void label_CargarCP2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_CargarCP2MouseClicked
        if(FacturaVentaNo.getText().equals("Factura de Venta No.")){
            JOptionPane.showMessageDialog(null, "No se ha cargado factura de venta Electronica Nacional para editar");
        }else{
            VentanaInternaCp.show(true);
            TextPrompt placeholder = new TextPrompt("Buscar por Nit o Nombre:", codigoCP);
            VentanaBuscarDocumento.show(false);
            VentanaCPEliminados.show(false);
            VentanaInternaClientes.show(false);

            String fechaFacturaV=retornarFechaVentaEnString();
            if(fechaFacturaV.equals("")){
                JOptionPane.showMessageDialog(null, "Verifique Formato de fecha el ingresado no es valido");
            }else{
                fechaFactura.setEnabled(true);    
                codigoCP.setText("");
                //Eliminamos la Busqueda Actual#######################################################
                DefaultTableModel md =(DefaultTableModel)tabla_ListadoBusquedaCP.getModel();
                int CantEliminar= tabla_ListadoBusquedaCP.getRowCount() -1;
                for(int i =CantEliminar; i>=0; i--){
                   md.removeRow(i);
                }
                DefaultTableModel modelo;
                String [] titulo= {"CP","PRODUCTO","BODEGA","CANT. INICIAL","SALDO", "FECHA_COMPRA", "FECHA. MAX. EXPORTACIÓN", "NOMBRE_PROVEEDOR"};
                modelo = new DefaultTableModel(null, titulo);
                tabla_ListadoBusquedaCP.setModel(modelo);    
                VentanaInternaCp.show(true);
            }
        }        
    }//GEN-LAST:event_label_CargarCP2MouseClicked

    private void RegistrarVentaExtranjeraMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RegistrarVentaExtranjeraMouseExited
        alertaCliente.setText("");
        alertaDatosFactura.setText("");
    }//GEN-LAST:event_RegistrarVentaExtranjeraMouseExited

    private void RegistrarVentaExtranjeraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistrarVentaExtranjeraActionPerformed
        if(cli_nit.getText().equals("")){
            alertaCliente.setText("ERROR!!.. Se debe Cargar los datos del Cliente Nacional, Antes de Registrar la Venta");
        }else{
            if(precioVentaKilo.getText().equals("")){
                alertaDatosFactura.setText("ERROR!!.. Se debe Ingresar el precio de Venta por Kilo, Antes de Registrar la Venta");
            }else{
                try{
                    Float.parseFloat(precioVentaKilo.getText()); //validamos que valorTotalDolar de la interfaz sea númerico
                    if(Float.parseFloat(precioVentaKilo.getText()) <= 1000000){
                        try{
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
                            if(validarQueCargueAlmenosUnCP()){//Validamos que se cargue al menos un CP, para poder Registrar la Venta.
                                alertaDatosFactura.setText("ERROR!!..  Se debe Cargar al menos un CP, Antes de Registrar la Venta");
                            }else{
                                if(validarEnCPCargadosCantidadAVenderSeaMayorACero()){//Validamos que las cantidades de los CP sea mayor a cero
                                    alertaDatosFactura.setText("ERROR!!..  En los CP cargados la cantidad a vender debe ser mayor a Cero, de lo contrario elimine CP con valor de Cero");
                                }else{ 
                                    FacturaVenta facturaVenta = new FacturaVenta();
                                    facturaVenta.setId(idFacturaVentaEdit);
                                    facturaVenta.setDex("0");
                                    facturaVenta.setFechaFactura(fechaFacturaV);
                                    facturaVenta.setBodegaFacturaVenta_id(2);
                                        String[] arregloNit= cli_nit.getText().split("-");
                                        String nitC = arregloNit[0];
                                        String DigitoVerfiC = arregloNit[1];                                        
                                    facturaVenta.setCliente_nit(nitC);
                                    facturaVenta.setCliente_sucursal(Integer.parseInt(cli_sucursal.getText()));
                                        ControlDB_EmpresaLocal controlEmpresaLocal = new ControlDB_EmpresaLocal();
                                        EmpresaLocal emp = new EmpresaLocal();
                                        EmpresaLocal empresL = null;
                                    try {
                                        emp.setNit("900088695");
                                        emp.setSucursal(1);
                                        empresL = controlEmpresaLocal.retornarEmpresaLocal(emp);
                                    } catch (SQLException ex) {
                                        Logger.getLogger(VentaFacturacionElectronica_Editar_BodNacional.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                    facturaVenta.setEmpresaLocal_nit(empresL.getNit());
                                    facturaVenta.setEmpresaLocal_sucursal(empresL.getSucursal());
                                    facturaVenta.setTrm(Double.parseDouble("0"));
                                    facturaVenta.setValorTotalEnDolarIngresados(new BigDecimal("0"));
                                    facturaVenta.setValorTotalEnDolarCalculados(new BigDecimal("0"));
                                    facturaVenta.setObservaciones(observacion.getText());
                                    facturaVenta.setEstado(1);
                                    facturaVenta.setNombreQuienElabora(user.getNombre()+" "+user.getApellido());
                                    BigDecimal sumatoriaValorTotalDolar= new java.math.BigDecimal("0");
                                    ArrayList<ItemFacturaEditar> ArrayItemFacturaEditar= new ArrayList();

                                    int filasCarritoVentaCP = CarritoVentaCP.getRowCount();
                                    DefaultTableModel modeloX=(DefaultTableModel)CarritoVentaCP.getModel();
                                    for(int i=0; i< filasCarritoVentaCP; i++){
                                        BigDecimal CantidadKiloIngresoProducto=new java.math.BigDecimal((String)modeloX.getValueAt(i, 7));
                                        BigDecimal precioVentaKiloT=new java.math.BigDecimal(precioVentaKilo.getText());                                           
                                        ItemFacturaEditar item = new ItemFacturaEditar();
                                        item.setIdFacturaVenta(idFacturaVentaEdit);                 
                                        ControlDB_Compra controlDB_Compra = new ControlDB_Compra();
                                        item.setIdIngresoProducto(controlDB_Compra.retornarIdIngresoProducto((String)modeloX.getValueAt(i, 0)));
                                        item.setValorUnitarioKilo(Double.parseDouble(precioVentaKilo.getText()));
                                        item.setCantidad(CantidadKiloIngresoProducto);          
                                        item.setTotal(CantidadKiloIngresoProducto.multiply(precioVentaKiloT));
                                        if(i==0){
                                            sumatoriaValorTotalDolar = new java.math.BigDecimal(item.getTotal().toPlainString());
                                        }else{
                                            BigDecimal c = new BigDecimal(item.getTotal().toPlainString());
                                            sumatoriaValorTotalDolar.add(c);
                                         }
                                        String cargadoEnFactura="";
                                        cargadoEnFactura=(String)modeloX.getValueAt(i, 8);
                                        if(cargadoEnFactura.equals("SI")){
                                            item.setCargadoEnFactura(true);
                                        }else{
                                            item.setCargadoEnFactura(false);
                                        }
                                        ArrayItemFacturaEditar.add(item);
                                    }
                                    facturaVenta.setValorTotalEnPesosCalculados(new BigDecimal(sumatoriaValorTotalDolar.toPlainString()));
                                    facturaVenta.setValorTotalEnDolarCalculados(new BigDecimal("0"));
                                    ControlDB_VentaFacturacionElectronica_EditarFacturaNacional controlDB_VentasEditar = new ControlDB_VentaFacturacionElectronica_EditarFacturaNacional();
                                    try {
                                        if(controlDB_VentasEditar.validorCantidadesExistentesBodegaNacional(ArrayItemFacturaEditar)){
                                            int valorW=controlDB_VentasEditar.registrarVentaNacional(facturaVenta, ArrayItemFacturaEditar,user);
                                            if(valorW==1){
                                                JOptionPane.showMessageDialog(null, "Registro De Venta Exitosa");
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
                                                FacturaVentaNo.setText("Factura de Venta No.");                                                                   
                                                Generar_Reportes generarReportes = new Generar_Reportes();
                                                generarReportes.generar_FacturaVentaElectronicaNacional(facturaVenta.getId());

                                                //Eliminamos los CP actuales#######################################################
                                                DefaultTableModel md =(DefaultTableModel)CarritoVentaCP.getModel();
                                                int CantEliminar= CarritoVentaCP.getRowCount() -1;
                                                for(int i =CantEliminar; i>=0; i--){
                                                   md.removeRow(i);
                                                }
                                                //############################################
                                            }else{
                                                JOptionPane.showMessageDialog(null, "Error al registrar la Venta");    
                                            }
                                        }else{
                                            JOptionPane.showMessageDialog(null, "Error!!. No se puede Registrar la Venta Verifique nuevamente todos los saldos en bodega debido a que han cambiado. Sugerencia Elimine los CP y vuelva a cargarlos");
                                        }
                                    } catch (FileNotFoundException ex) {
                                        Logger.getLogger(VentaFacturacionElectronica_Editar_BodNacional.class.getName()).log(Level.SEVERE, null, ex);
                                    } catch (SQLException ex) {
                                        Logger.getLogger(VentaFacturacionElectronica_Editar_BodNacional.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                }
                            }
                        }catch(Exception e){
                          alertaDatosFactura.setText("ERROR!!.. La fecha de factura debe tener un formato de fecha valido, verifique datos ingresados");     
                        }
                    }else{
                        alertaDatosFactura.setText("ERROR!!.. El precio de venta por  Kilo debe ser menor a un millon (1.000.000)");
                    }
                }catch(Exception e){
                    alertaDatosFactura.setText("ERROR!!.. El valor de precio por Kilo debe ser númericoa, verifique datos ingresados");
                }
            }           
        }
    }//GEN-LAST:event_RegistrarVentaExtranjeraActionPerformed

    private void Seleccionar_CpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Seleccionar_CpActionPerformed
       // TODO lo del clik derechoo
        DefaultTableModel modelo;       
            int fila1;
            try{
                fila1=tabla_ListadoBusquedaCP.getSelectedRow();
                if(fila1==-1){
                    JOptionPane.showMessageDialog(null,"no se ha seleccionando ninguna fila");
                }
                else{
                        /*0cp  1producto   2.Bodega   3. cant inicia
                        4.saldo.   5. fechaCompra   6. fechaMaxExpo  7.Nombre.PROVE*/
                        accion="modificar";
                        modelo=(DefaultTableModel)tabla_ListadoBusquedaCP.getModel();
                        registroCP[0]=(String)modelo.getValueAt(fila1, 0);
                        registroCP[1]=(String)modelo.getValueAt(fila1, 1);
                        registroCP[2]=(String)modelo.getValueAt(fila1, 2);
                        registroCP[3]=(String)modelo.getValueAt(fila1, 7);
                        registroCP[4]=(String)modelo.getValueAt(fila1, 5);
                        registroCP[5]=(String)modelo.getValueAt(fila1, 6);
                        registroCP[6]=(String)modelo.getValueAt(fila1, 4);
                        registroCP[7]="0";
                        registroCP[8]="";
                        if(validarCPcargadoEncarrito(registroCP[0])){
                            JOptionPane.showMessageDialog(null, "El cp ya fue cargado");
                            //Eliminamos la Busqueda Actual#######################################################
                             DefaultTableModel md =(DefaultTableModel)tabla_ListadoBusquedaCP.getModel();
                            int CantEliminar= tabla_ListadoBusquedaCP.getRowCount() -1;
                            for(int i =CantEliminar; i>=0; i--){
                                md.removeRow(i);
                            }
                              VentanaInternaCp.show(false);
                        }else{
                            //if(Validar_Si_CP_EstaVencido((String)modelo.getValueAt(fila1, 6))){
                                //JOptionPane.showMessageDialog(null, "El CP no se puede cargar para Exportacion porque fechaMáxima de Exportación está vencida");
                            //}else{
                                modeloCP.addRow(registroCP);
                                CarritoVentaCP.setModel(modeloCP);
                                //Eliminamos la Busqueda Actual#######################################################
                                 DefaultTableModel md =(DefaultTableModel)tabla_ListadoBusquedaCP.getModel();
                                int CantEliminar= tabla_ListadoBusquedaCP.getRowCount() -1;
                                for(int i =CantEliminar; i>=0; i--){
                                    md.removeRow(i);
                                }
                                VentanaInternaCp.show(false);
                            //}
                        }
                    
                }
            }catch(Exception e){
            
        }
    }//GEN-LAST:event_Seleccionar_CpActionPerformed

    private void label_CargarClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_CargarClienteMouseClicked
        if(FacturaVentaNo.getText().equals("Factura de Venta No.")){
            JOptionPane.showMessageDialog(null, "No se ha cargado factura de venta Extranjera para editar");
        }else{
            VentanaInternaClientes.show(true);
            TextPrompt placeholder = new TextPrompt("Buscar por Nit o Nombre:", codigoClientes);

            VentanaInternaCp.show(false);
            VentanaBuscarDocumento.show(false);
            VentanaCPEliminados.show(false);

            codigoClientes.setText("");
            //Eliminamos la Busqueda Actual#######################################################
            DefaultTableModel md =(DefaultTableModel)tabla_ListadoBusquedaClientes.getModel();
            int CantEliminar= tabla_ListadoBusquedaClientes.getRowCount() -1;
            for(int i =CantEliminar; i>=0; i--){
               md.removeRow(i);
            }
            DefaultTableModel modelo;
            String [] titulo= {"NIT","SUCURSAL", "NOMBRE"};
            String [] registro = new String[3]; 
            modelo = new DefaultTableModel(null, titulo);
            tabla_ListadoBusquedaClientes.setModel(modelo);
            VentanaInternaClientes.show(true);  
        }
    }//GEN-LAST:event_label_CargarClienteMouseClicked

    private void label_CargarCPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_label_CargarCPMouseClicked
        if(FacturaVentaNo.getText().equals("Factura de Venta No.")){
            JOptionPane.showMessageDialog(null, "No se ha cargado factura de venta Nacional para editar");
        }else{
            VentanaInternaCp.show(true);
            TextPrompt placeholder = new TextPrompt("Buscar por Nit o Nombre:", codigoCP);
            VentanaBuscarDocumento.show(false);
            VentanaCPEliminados.show(false);
            VentanaInternaClientes.show(false);
            String fechaFacturaV=retornarFechaVentaEnString();
            if(fechaFacturaV.equals("")){
                JOptionPane.showMessageDialog(null, "Verifique Formato de fecha el ingresado no es valido");
            }else{
                fechaFactura.setEnabled(false);    
                codigoCP.setText("");
                //Eliminamos la Busqueda Actual#######################################################
                DefaultTableModel md =(DefaultTableModel)tabla_ListadoBusquedaCP.getModel();
                int CantEliminar= tabla_ListadoBusquedaCP.getRowCount() -1;
                for(int i =CantEliminar; i>=0; i--){
                   md.removeRow(i);
                }
                DefaultTableModel modelo;
                String [] titulo= {"CP","PRODUCTO","BODEGA","CANT. INICIAL","SALDO", "FECHA_COMPRA", "FECHA. MAX. EXPORTACIÓN", "NOMBRE_PROVEEDOR"};
                modelo = new DefaultTableModel(null, titulo);
                tabla_ListadoBusquedaCP.setModel(modelo);    
                VentanaInternaCp.show(true);
            }
        }  
    }//GEN-LAST:event_label_CargarCPMouseClicked

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
            String valor=(String)modeloY.getValueAt(fila1, 8);
            if(valor.equalsIgnoreCase("SI")){               
                registroCP_Eliminados[0]=(String)modeloY.getValueAt(fila1, 0);
                registroCP_Eliminados[1]=(String)modeloY.getValueAt(fila1, 1);
                registroCP_Eliminados[2]=(String)modeloY.getValueAt(fila1, 2);
                registroCP_Eliminados[3]=(String)modeloY.getValueAt(fila1, 3);
                registroCP_Eliminados[4]=(String)modeloY.getValueAt(fila1, 4);
                registroCP_Eliminados[5]=(String)modeloY.getValueAt(fila1, 5);
                registroCP_Eliminados[6]=(String)modeloY.getValueAt(fila1, 6);
                registroCP_Eliminados[7]=(String)modeloY.getValueAt(fila1, 7);;
                registroCP_Eliminados[8]=(String)modeloY.getValueAt(fila1, 8);;
                modeloCP_Eliminados.addRow(registroCP_Eliminados);
                CP_Eliminados.setModel(modeloCP_Eliminados);
                modeloY.removeRow(fila1);
            }else{
                modeloY.removeRow(fila1);
            }
            //Validamos si se han elimandos todos los CP para habilitar el campo fecha de Factura,**************** 
            if(CarritoVentaCP.getRowCount() == 0){
                fechaFactura.setEnabled(true);
            }
            //**************************************************************************************************
            
        }                       
    }//GEN-LAST:event_EliminarCPActionPerformed

    private void RegistrarVentaExtranjera1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RegistrarVentaExtranjera1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_RegistrarVentaExtranjera1MouseExited

    private void RegistrarVentaExtranjera1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistrarVentaExtranjera1ActionPerformed
        //Limpiamos los CP eliminados de una consulta anterior
        DefaultTableModel md =(DefaultTableModel)CP_Eliminados.getModel();
        int CantEliminar= CP_Eliminados.getRowCount() -1;
        for(int i =CantEliminar; i>=0; i--){
            md.removeRow(i);
        }
        VentanaBuscarDocumento.show(true);
    }//GEN-LAST:event_RegistrarVentaExtranjera1ActionPerformed

    private void codigoDocumentoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codigoDocumentoKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_codigoDocumentoKeyPressed

    private void botonLimpiarBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonLimpiarBusquedaActionPerformed
        codigoDocumento.setText("");
        //Eliminamos la Busqueda Actual#######################################################
        DefaultTableModel md =(DefaultTableModel)ListadoBusquedasDocumentos.getModel();
        int CantEliminar= ListadoBusquedasDocumentos.getRowCount() -1;
        for(int i =CantEliminar; i>=0; i--){
           md.removeRow(i);
        }
        
        try {
            BuscarEnVentanaInternaDocumentos("0");
        } catch (SQLException ex) {
            Logger.getLogger(VentaFacturacionElectronica_Editar_BodNacional.class.getName()).log(Level.SEVERE, null, ex);
        }
        alertaBuscarFacturaVenta.setText("");
    }//GEN-LAST:event_botonLimpiarBusquedaActionPerformed

    private void ListadoBusquedasDocumentosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ListadoBusquedasDocumentosMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_ListadoBusquedasDocumentosMouseClicked

    private void ListadoBusquedasDocumentosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ListadoBusquedasDocumentosMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_ListadoBusquedasDocumentosMousePressed

    private void ListadoBusquedasDocumentosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ListadoBusquedasDocumentosKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_ListadoBusquedasDocumentosKeyPressed

    private void botonBuscarDocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarDocumentoActionPerformed
        //Eliminamos la Busqueda Actual#######################################################
        DefaultTableModel md =(DefaultTableModel)ListadoBusquedasDocumentos.getModel();
        int CantEliminar= ListadoBusquedasDocumentos.getRowCount() -1;
        for(int i =CantEliminar; i>=0; i--){
           md.removeRow(i);
        }
        
        try {
            BuscarEnVentanaInternaDocumentos(codigoDocumento.getText());
        } catch (SQLException ex) {
            Logger.getLogger(VentaFacturacionElectronica_Editar_BodNacional.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_botonBuscarDocumentoActionPerformed

    private void botonCancelarBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarBusquedaActionPerformed
        VentanaBuscarDocumento.show(false);
    }//GEN-LAST:event_botonCancelarBusquedaActionPerformed

    private void SeleccionarDocumentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SeleccionarDocumentosActionPerformed
        DefaultTableModel modelo;
        int fila1;
        try{
            fila1=ListadoBusquedasDocumentos.getSelectedRow();
            if(fila1==-1){
                JOptionPane.showMessageDialog(null,"no se ha seleccionando ninguna fila");
            }
            else{
                try{
                    modelo=(DefaultTableModel)ListadoBusquedasDocumentos.getModel();
                    String idFacturaVenta=(String)modelo.getValueAt(fila1, 0);                    
                    ControlDB_VentaFacturacionElectronica_EditarFacturaNacional controlDB_Ventas_Editar_Factura_BodNacional = new ControlDB_VentaFacturacionElectronica_EditarFacturaNacional();
                    FacturaVenta facturaVenta =null;
                    ArrayList<ItemFactura> listadoItemFacturas = null;    
                    Cliente cliente =null;
                    try{
                        facturaVenta=controlDB_Ventas_Editar_Factura_BodNacional.consultarUnicaFacturasVentasNacional(idFacturaVenta);
                        listadoItemFacturas=controlDB_Ventas_Editar_Factura_BodNacional.consultarItemFacturasVentasNacional(idFacturaVenta);
                        
                        
                        
                        Cliente c = new Cliente();
                        c.setNit(facturaVenta.getCliente_nit());
                        c.setSucursal(facturaVenta.getCliente_sucursal());
                        cliente= controlDB_Ventas_Editar_Factura_BodNacional.retornarCliente(c);
                        
                        idFacturaVentaEdit=facturaVenta.getId();
                        FacturaVentaNo.setText("Factura de Venta No.  "+idFacturaVentaEdit);
                        
                        cli_nit.setText(cliente.getNit()+"-"+cliente.getDigitoVerificacion());
                        cli_sucursal.setText(""+cliente.getSucursal());
                        cli_nombre.setText(cliente.getNombre());
                        cli_telefono.setText(cliente.getTelefono());
                        cli_celular.setText(cliente.getCelular());
                        cli_direccion.setText(cliente.getDireccion());
                        cli_correo.setText(cliente.getCorreo());
                        cli_ciudad.setText(cliente.getCiudad());
                        
                                             
                        
                        String fechaFacturaV=facturaVenta.getFechaFactura();
                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                        Date fechaFacturaX=dateFormat.parse(fechaFacturaV);
                                            
                        fechaFactura.setDate(fechaFacturaX);
                        precioVentaKilo.setText(""+listadoItemFacturas.get(0).getValorUnitarioKilo());
                        observacion.setText(facturaVenta.getObservaciones());
                        
                        String [] registroCPX= new String[9]; 
                        String []tituloCP= {"CP","PRODUCTO","BODEGA","NOMBRE_PROV.","FECHA_COMPRA","FECHA_MAX._EXPORT.","SALDO","CANTIDAD A VENDER","CARGADAEN FACT."};
                        modeloCP = new DefaultTableModel(null, tituloCP);
                        CarritoVentaCP.setModel(modeloCP);
                        
                        for(int i =0; i< listadoItemFacturas.size(); i++){ 
                            
                           IngresoProducto ingresoProducto= controlDB_Ventas_Editar_Factura_BodNacional.retornarCompra(listadoItemFacturas.get(i).getIdIngresoProducto());
                            //registroCPX[0]=listadoItemFacturas.get(i).getIdIngresoProducto());
                            registroCPX[0]=ingresoProducto.getCp();
                            
                            registroCPX[1]=controlDB_Ventas_Editar_Factura_BodNacional.retornoNombreProducto(ingresoProducto.getProducto_id());
                            registroCPX[2]="Nacional";
                            
                            Proveedor p = new Proveedor();
                            p.setNit(ingresoProducto.getProveedor_nit());
                            p.setSucursal(ingresoProducto.getProveedor_sucursal());                        
                            Proveedor proveedor = new Proveedor();
                            proveedor= controlDB_Ventas_Editar_Factura_BodNacional.retornarProveedor(p);
                            
                            
                            registroCPX[3]=proveedor.getNombre();
                            registroCPX[4]=ingresoProducto.getFechaCompra();
                            registroCPX[5]=ingresoProducto.getFechaMaximaExportacion();         
                            int cantidadEnBodega = 0;
                            //JOptionPane.showMessageDialog(null, ""+controlDB_Ventas_Editar_Factura_BodExtranjera.validarSaldoBodegaExtranejera(""+listadoItemFacturas.get(i).getIdIngresoProducto()));
                            cantidadEnBodega = cantidadEnBodega+ Integer.parseInt(controlDB_Ventas_Editar_Factura_BodNacional.validarSaldoBodegaNacional(""+listadoItemFacturas.get(i).getIdIngresoProducto()));
                            cantidadEnBodega = cantidadEnBodega + Integer.parseInt(listadoItemFacturas.get(i).getCantidad().toPlainString()); //Le sumamos la cantidad dela ItemVenta
                            registroCPX[6]=""+cantidadEnBodega;
                            registroCPX[7]=listadoItemFacturas.get(i).getCantidad().toPlainString();
                            registroCPX[8]="SI";
                            
                            modeloCP.addRow(registroCPX);
                            
                        }                   
                        CarritoVentaCP.setModel(modeloCP);
                    }catch(Exception e){
                        JOptionPane.showMessageDialog(null, "No se pudo cargar la factura de Venta");
                    }
                   
                    //Eliminamos la Busqueda Actual#######################################################
                     DefaultTableModel md =(DefaultTableModel)ListadoBusquedasDocumentos.getModel();
                    int CantEliminar= ListadoBusquedasDocumentos.getRowCount() -1;
                    for(int i =CantEliminar; i>=0; i--){
                        md.removeRow(i);
                    }
                    //######################################################################################
                    VentanaBuscarDocumento.show(false);
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, "No se pudo cargar el Cliente");
                }
            }
        }catch(Exception e){
        }
        
    }//GEN-LAST:event_SeleccionarDocumentosActionPerformed

    private void botonCancelarBusqueda1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarBusqueda1ActionPerformed
        VentanaCPEliminados.show(false);
    }//GEN-LAST:event_botonCancelarBusqueda1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        VentanaInternaCp.show(false);
        VentanaBuscarDocumento.show(false);
        VentanaCPEliminados.show(false); 
        VentanaCPEliminados.show(true);
        VentanaCPEliminados.show(false); 
        VentanaCPEliminados.show(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void codigoClientesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codigoClientesKeyPressed
        buscarClientes();  
    }//GEN-LAST:event_codigoClientesKeyPressed

    private void buscarClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarClientesActionPerformed
        buscarClientes();              
    }//GEN-LAST:event_buscarClientesActionPerformed

    private void limpiarClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarClientesActionPerformed
        codigoClientes.setText("");
    }//GEN-LAST:event_limpiarClientesActionPerformed

    private void cancelarClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarClientesActionPerformed
         VentanaInternaClientes.show(false);
    }//GEN-LAST:event_cancelarClientesActionPerformed

    private void Seleccionar_ClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Seleccionar_ClientesActionPerformed
        DefaultTableModel modelo;
        int fila1;
        try{
            fila1=tabla_ListadoBusquedaClientes.getSelectedRow();
            if(fila1==-1){
                JOptionPane.showMessageDialog(null,"no se ha seleccionando ninguna fila");
            }
            else{
                try{
                    accion="modificar";
                    modelo=(DefaultTableModel)tabla_ListadoBusquedaClientes.getModel();
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
                     DefaultTableModel md =(DefaultTableModel)tabla_ListadoBusquedaClientes.getModel();
                    int CantEliminar= tabla_ListadoBusquedaClientes.getRowCount() -1;
                    for(int i =CantEliminar; i>=0; i--){
                        md.removeRow(i);
                    }
                    //######################################################################################
                    VentanaInternaClientes.show(false);
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, "No se pudo cargar el Cliente");
                }
            }
        }catch(Exception e){
        }     
    }//GEN-LAST:event_Seleccionar_ClientesActionPerformed

    private void codigoCPKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codigoCPKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_codigoCPKeyPressed

    private void buscarCPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarCPActionPerformed
        buscarCP();
    }//GEN-LAST:event_buscarCPActionPerformed

    private void limpiarCPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarCPActionPerformed
         codigoCP.setText("");
    }//GEN-LAST:event_limpiarCPActionPerformed

    private void cancelarCPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarCPActionPerformed
        VentanaInternaCp.show(false);
    }//GEN-LAST:event_cancelarCPActionPerformed

    private void Restaurar_CpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Restaurar_CpActionPerformed
         // TODO lo del clik derechoo
        DefaultTableModel modeloY;
        int fila1=CP_Eliminados.getSelectedRow();
        if(fila1==-1){
            JOptionPane.showMessageDialog(null,"no se ha seleccionando ninguna fila");
        }
        else{  
            modeloY=(DefaultTableModel)CP_Eliminados.getModel();
            String valor=(String)modeloY.getValueAt(fila1, 8);
            if(valor.equalsIgnoreCase("SI")){               
                registroCP[0]=(String)modeloY.getValueAt(fila1, 0);
                registroCP[1]=(String)modeloY.getValueAt(fila1, 1);
                registroCP[2]=(String)modeloY.getValueAt(fila1, 2);
                registroCP[3]=(String)modeloY.getValueAt(fila1, 3);
                registroCP[4]=(String)modeloY.getValueAt(fila1, 4);
                registroCP[5]=(String)modeloY.getValueAt(fila1, 5);
                registroCP[6]=(String)modeloY.getValueAt(fila1, 6);
                registroCP[7]=(String)modeloY.getValueAt(fila1, 7);
                registroCP[8]=(String)modeloY.getValueAt(fila1, 8);
               // modeloCP_Eliminados.addRow(registroCP);
                //CP_Eliminados.setModel(modeloCP_Eliminados);
                if(validarCPcargadoEncarrito(registroCP[0])){
                            JOptionPane.showMessageDialog(null, "El cp ya fue cargado");
                }else{
                    //if(Validar_Si_CP_EstaVencido((String)modeloY.getValueAt(fila1, 5))){
                    //  JOptionPane.showMessageDialog(null, "El CP no se puede cargar para Exportacion porque fechaMáxima de Exportación está vencida");
                    //}else{
                    modeloCP.addRow(registroCP);
                    CarritoVentaCP.setModel(modeloCP);
                    modeloY.removeRow(fila1); //Eliminamos el CP de la listado de CP Eliminados
                    VentanaCPEliminados.show(false);
                    VentanaCPEliminados.show(true);
                    VentanaCPEliminados.show(false);
                    
                    //}
                }               
            }
        }   
    }//GEN-LAST:event_Restaurar_CpActionPerformed

    private void fechaFacturaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fechaFacturaMouseClicked

    }//GEN-LAST:event_fechaFacturaMouseClicked

    private void fechaFacturaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fechaFacturaMouseEntered

    }//GEN-LAST:event_fechaFacturaMouseEntered

    private void precioVentaKiloMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_precioVentaKiloMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_precioVentaKiloMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable CP_Eliminados;
    private javax.swing.JLabel CargarCliente;
    private javax.swing.JTable CarritoVentaCP;
    private javax.swing.JPopupMenu Eliminar;
    private javax.swing.JMenuItem EliminarCP;
    private javax.swing.JLabel FacturaVentaNo;
    private javax.swing.JTable ListadoBusquedasDocumentos;
    private javax.swing.JButton RegistrarVentaExtranjera;
    private javax.swing.JButton RegistrarVentaExtranjera1;
    private javax.swing.JPopupMenu Restaurar_CP;
    private javax.swing.JMenuItem Restaurar_Cp;
    private javax.swing.JPopupMenu SeleccionarDocumento;
    private javax.swing.JMenuItem SeleccionarDocumentos;
    private javax.swing.JPopupMenu Seleccionar_CP;
    private javax.swing.JPopupMenu Seleccionar_Cliente;
    private javax.swing.JMenuItem Seleccionar_Clientes;
    private javax.swing.JMenuItem Seleccionar_Cp;
    private javax.swing.JInternalFrame VentanaBuscarDocumento;
    private javax.swing.JInternalFrame VentanaCPEliminados;
    private javax.swing.JInternalFrame VentanaInternaClientes;
    private javax.swing.JInternalFrame VentanaInternaCp;
    private javax.swing.JLabel alertaBuscarFacturaVenta;
    private javax.swing.JLabel alertaCliente;
    private javax.swing.JLabel alertaDatosFactura;
    private javax.swing.JButton botonBuscarDocumento;
    private javax.swing.JButton botonCancelarBusqueda;
    private javax.swing.JButton botonCancelarBusqueda1;
    private javax.swing.JButton botonLimpiarBusqueda;
    private javax.swing.JButton buscarCP;
    private javax.swing.JButton buscarClientes;
    private javax.swing.JButton cancelarCP;
    private javax.swing.JButton cancelarClientes;
    private javax.swing.JLabel cli_celular;
    private javax.swing.JLabel cli_ciudad;
    private javax.swing.JLabel cli_correo;
    private javax.swing.JLabel cli_direccion;
    private javax.swing.JLabel cli_nit;
    private javax.swing.JLabel cli_nombre;
    private javax.swing.JLabel cli_sucursal;
    private javax.swing.JLabel cli_telefono;
    private javax.swing.JTextField codigoCP;
    private javax.swing.JTextField codigoClientes;
    private javax.swing.JTextField codigoDocumento;
    private com.toedter.calendar.JDateChooser fechaFactura;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel label_CargarCP;
    private javax.swing.JLabel label_CargarCP2;
    private javax.swing.JLabel label_CargarCliente;
    private javax.swing.JButton limpiarCP;
    private javax.swing.JButton limpiarClientes;
    private javax.swing.JTextArea observacion;
    private javax.swing.JTextField precioVentaKilo;
    private javax.swing.JTable tabla_ListadoBusquedaCP;
    private javax.swing.JTable tabla_ListadoBusquedaClientes;
    private javax.swing.JLabel ventanaInterna_Nombre1;
    private javax.swing.JLabel ventanaInterna_Nombre2;
    private javax.swing.JLabel ventanaInterna_Nombre3;
    // End of variables declaration//GEN-END:variables
 
  
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

    /*public boolean Validar_Si_CP_EstaVencido(String fechaMaximaExportacion) throws ParseException{
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
    }*/
    public boolean Validar_Si_CP_EstaVencido(String fechaMaximaExportacion) throws ParseException{
        String fechaFacturaV=retornarFechaVentaEnString();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaHoy=dateFormat.parse(fechaFacturaV);
        Date fechaDevo=dateFormat.parse(fechaMaximaExportacion);
        int diasAtraso=(int) ((fechaDevo.getTime() -fechaHoy.getTime())/86400000);
        if(diasAtraso < 0){
            return true;
        }else{
            return false;
        }
        /*if(diasAtraso >= 61){
            return false;
        }else{
            if(diasAtraso >= 31 && diasAtraso <= 60){
                return false;
            }else{
                return true;
            }
        }    */
        
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
    
    
    
    public void BuscarEnVentanaInternaDocumentos(String valorConsulta) throws SQLException{               
        DefaultTableModel modelo;
        String [] titulo= {"No Factura","Dex", "Fecha_Factura", "Bodega", "Nit_Cliente", "Nombre", "Cant_Vendida","ValorTotalDolar","valorTotalPesos","Estado"};
        String [] registro = new String[10]; 
        modelo = new DefaultTableModel(null, titulo);     
        ArrayList<FacturaVenta> listadoVentas=null;
        ControlDB_VentaFacturacionElectronica_EditarFacturaNacional controlDB_Ventas_Editar_Factura_BodNacional = null;
        if(valorConsulta.equals("")){
             controlDB_Ventas_Editar_Factura_BodNacional = new ControlDB_VentaFacturacionElectronica_EditarFacturaNacional();
            listadoVentas=controlDB_Ventas_Editar_Factura_BodNacional.consultarFacturasVentasNacional(codigoDocumento.getText());
        }else{
            try{
                Integer.parseInt(codigoDocumento.getText());
                controlDB_Ventas_Editar_Factura_BodNacional = new ControlDB_VentaFacturacionElectronica_EditarFacturaNacional();
                listadoVentas=controlDB_Ventas_Editar_Factura_BodNacional.consultarFacturasVentasNacional(" AND [facturaVenta].[id]='"+codigoDocumento.getText()+"'");
            }catch(Exception e){
                alertaBuscarFacturaVenta.setText("Verifique valor Ingresado!! Debe ser Númerico");
                
            }
        }
        if(listadoVentas !=null){
            for(int i =0; i< listadoVentas.size(); i++){ 
                registro[0]=""+listadoVentas.get(i).getId();
                registro[1]=""+listadoVentas.get(i).getDex();
                registro[2]=""+listadoVentas.get(i).getFechaFactura();
                registro[3]="Nacional"; //+listadoVentas.get(i).getBodegaFacturaVenta_id();
                registro[4]=""+listadoVentas.get(i).getCliente_nit();       
                Cliente c = new Cliente();
                c.setNit(listadoVentas.get(i).getCliente_nit());
                c.setSucursal(listadoVentas.get(i).getCliente_sucursal());
                registro[5]=""+controlDB_Ventas_Editar_Factura_BodNacional.consultarNombreCliente(c);
                registro[6]=""+controlDB_Ventas_Editar_Factura_BodNacional.retornarCantidadTotalFacturaVenta(listadoVentas.get(i).getId());
                registro[7]=""+listadoVentas.get(i).getValorTotalEnDolarCalculados();
                registro[8]=""+listadoVentas.get(i).getValorTotalEnPesosCalculados();
                registro[9]=""+validarEstado(listadoVentas.get(i).getEstado());
                modelo.addRow(registro);
                ListadoBusquedasDocumentos.setModel(modelo);
                //JOptionPane.showMessageDialog(null, "Hola si hay info"+listadoClientes.get(i).getNit()+listadoClientes.get(i).getDigitoVerificacion()+listadoClientes.get(i).getNombre());
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
    public void buscarClientes(){
        DefaultTableModel modeloClientes;
        String [] tituloClientes= {"NIT","SUCURSAL", "NOMBRE"};
        String [] registroClientes = new String[3]; 
        modeloClientes = new DefaultTableModel(null, tituloClientes);
        ControlDB_Cliente controlDB_Cliente = new ControlDB_Cliente();
        ArrayList<Cliente> listadoClientes = null;
        try {
            listadoClientes = controlDB_Cliente.buscarCliente(codigoClientes.getText());
        } catch (SQLException ex) {
            Logger.getLogger(VentaFacturacionElectronica_Editar_BodNacional.class.getName()).log(Level.SEVERE, null, ex);
        }
        for(int i =0; i< listadoClientes.size(); i++){ 
            registroClientes[0]=""+listadoClientes.get(i).getNit();
            registroClientes[1]=""+listadoClientes.get(i).getSucursal();
            registroClientes[2]=""+listadoClientes.get(i).getNombre();
            //JOptionPane.showMessageDialog(null, ""+registroClientes[2]);   
            modeloClientes.addRow(registroClientes);

            //JOptionPane.showMessageDialog(null, "Hola si hay info"+listadoClientes.get(i).getNit()+listadoClientes.get(i).getDigitoVerificacion()+listadoClientes.get(i).getNombre());
        }  
        tabla_ListadoBusquedaClientes.setModel(modeloClientes);
    }
    public void buscarCP(){
        try{                                         
            DefaultTableModel modeloCP;
            String [] titulo= {"CP","PRODUCTO","BODEGA","CANT. INICIAL","SALDO", "FECHA_COMPRA", "FECHA. MAX. EXPORTACIÓN", "NOMBRE_PROVEEDOR"};
            String [] registroCP = new String[8];
            modeloCP = new DefaultTableModel(null, titulo);
            ControlDB_VentaFacturacionElectronica_EditarFacturaNacional controlDB_Ventas= new ControlDB_VentaFacturacionElectronica_EditarFacturaNacional();
            ArrayList<IngresoProducto> listadoCp=controlDB_Ventas.consultarCpBodegaNacional(codigoCP.getText());
            for(int i =0; i< listadoCp.size(); i++){
                registroCP[0]=""+listadoCp.get(i).getCp();
                registroCP[1]=""+controlDB_Ventas.validarNombreProducto(listadoCp.get(i).getProducto_id()).getDescripcion();
                registroCP[2]=""+controlDB_Ventas.validarNombreBodegaNacional(""+listadoCp.get(i).getBodega_ingresoProductoInicial());
                registroCP[3]=""+listadoCp.get(i).getCantidadInicial();
                registroCP[4]=""+controlDB_Ventas.validarSaldoBodegaNacional(listadoCp.get(i).getId());
                registroCP[5]=""+listadoCp.get(i).getFechaCompra();
                registroCP[6]=""+listadoCp.get(i).getFechaMaximaExportacion();
                //JOptionPane.showMessageDialog(null, ""+registroCP[6]);
                //Consultamos el Nombre del proveedor atravez del Nit y sucursal
                ControlDB_Proveedor controlDB_Proveedor = new ControlDB_Proveedor();
                Proveedor prov = new Proveedor();
                prov.setNit(listadoCp.get(i).getProveedor_nit());
                prov.setSucursal(listadoCp.get(i).getProveedor_sucursal());

                ArrayList<Proveedor> listadoProveedor=controlDB_Proveedor.consultarUnicoProveedor(prov);
                for(int a =0; a< listadoProveedor.size(); a++){
                    registroCP[7]=""+listadoProveedor.get(a).getNombre();
                }
                modeloCP.addRow(registroCP);

            }
            tabla_ListadoBusquedaCP.setModel(modeloCP);
            try{
                String fechaFactVent=retornarFechaVentaEnString();
                tabla_ListadoBusquedaCP.setDefaultRenderer(Object.class, new Myrender_VentasRegistrarExtranjera(6,fechaFactVent));
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "No se pudo cargar los colores");
            }
        }catch(SQLException ex){
            Logger.getLogger(VentaFacturacionElectronica_Editar_BodNacional.class.getName()).log(Level.SEVERE,null, ex);
        }
    }
}
