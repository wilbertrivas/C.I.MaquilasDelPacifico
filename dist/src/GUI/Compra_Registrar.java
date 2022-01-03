package GUI;
import Controladores.ControlDB_Bodega;
import Controladores.ControlDB_Compra;
import Controladores.ControlDB_Producto;
import Controladores.ControlDB_Proveedor;
import Modelos.Bodega;
import Modelos.IngresoProducto;
import Modelos.Producto;
import Modelos.Proveedor;
import Modelos.Usuario;
import Reportes.Generar_Reportes; 
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Compra_Registrar extends javax.swing.JPanel {
    DefaultTableModel modelo;
    String datos; 
    String [] titulo= {"NIT","SUCURSAL", "NOMBRE"};
    String [] registro;
   // Controladores.ControladorDB_old ControlDB = new ControladorDB_old();
    String accion="";
    String nombreOriginal="";
    int maximoEntradasAlmacen=0;
    Usuario user;
    
    public Compra_Registrar(Usuario u) throws SQLException {
        user= u;
        initComponents();
        VentanaInternaProveedor.show(false);
        TextPrompt placeholder = new TextPrompt("Buscar por Nit o Nombre:", codigoB);
        
        //Cargamos los productos en la interfaz###############
        ControlDB_Producto  controlDB_Producto = new ControlDB_Producto();
        ArrayList<Producto> listadoProducto = new ArrayList();
        listadoProducto=controlDB_Producto.ListarProductosActivos();
        for(int i=0; i< listadoProducto.size(); i++){
            producto.addItem(listadoProducto.get(i).getDescripcion());
        }
        //Cargamos las Bodegas en la interfaz###############
        ControlDB_Bodega  controlDB_Bodega = new ControlDB_Bodega();
        ArrayList<Bodega> listadoBodega = new ArrayList();
        listadoBodega=controlDB_Bodega.ListarBodegaActivas();
        for(int i=0; i< listadoBodega.size(); i++){
            bodega.addItem(listadoBodega.get(i).getDescripcion());
        }

        //#########################################################
        ControlDB_Compra controlDB_Compra = new ControlDB_Compra();
        try{
            maximoEntradasAlmacen=controlDB_Compra.retornarElMaximo();
            maximoEntradasAlmacen++;
            entradaAlmacenNo.setText("Entrada En Almacen No.  "+maximoEntradasAlmacen);
        }catch(Exception e){
            maximoEntradasAlmacen++;
            entradaAlmacenNo.setText("Entrada En Almacen No.  "+maximoEntradasAlmacen);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Seleccionar = new javax.swing.JPopupMenu();
        Editar = new javax.swing.JMenuItem();
        VentanaInternaProveedor = new javax.swing.JInternalFrame();
        codigoB = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        limpiar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table1 = new javax.swing.JTable();
        buscar = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        nombre = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cp = new javax.swing.JTextField();
        alertaValorUnitario = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        alertaProveedor = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        nit = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        resolucionFacturacion = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        cambiarResolucionFacturacion = new javax.swing.JButton();
        fechaResolución = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        bodega = new javax.swing.JComboBox<>();
        jLabel24 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        producto = new javax.swing.JComboBox<>();
        fechaCompra = new com.toedter.calendar.JDateChooser();
        entradaAlmacenNo = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        registrarUnidad1 = new javax.swing.JButton();
        numeroFacturaProveedor = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        cantidad = new javax.swing.JTextField();
        valorUnitario = new javax.swing.JTextField();
        ValorUnidad = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        alertaCP = new javax.swing.JLabel();
        alertaCantidad = new javax.swing.JLabel();
        alertaNumeroFacturaProveedor = new javax.swing.JLabel();
        alertaFecha = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        observacion = new javax.swing.JTextArea();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        sucursal = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        fechaMaximaExportacion = new com.toedter.calendar.JDateChooser();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        alertaFechaMaximaExportacion = new javax.swing.JLabel();

        Editar.setText("Seleccionar");
        Editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditarActionPerformed(evt);
            }
        });
        Seleccionar.add(Editar);

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        VentanaInternaProveedor.setBackground(new java.awt.Color(255, 255, 255));
        VentanaInternaProveedor.setMaximizable(true);
        VentanaInternaProveedor.setTitle("LISTADO DE PROVEEDORES");
        VentanaInternaProveedor.setVisible(true);
        VentanaInternaProveedor.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        codigoB.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                codigoBKeyPressed(evt);
            }
        });
        VentanaInternaProveedor.getContentPane().add(codigoB, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 250, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 153, 153));
        jLabel7.setText("BUSCAR PROVEEDOR");
        VentanaInternaProveedor.getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 210, -1));

        limpiar.setBackground(new java.awt.Color(255, 255, 255));
        limpiar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        limpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/Interfaz_Icon_Borrar.PNG"))); // NOI18N
        limpiar.setText("LIMPIAR");
        limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarActionPerformed(evt);
            }
        });
        VentanaInternaProveedor.getContentPane().add(limpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, 140, 40));

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
        Table1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Table1MouseClicked(evt);
            }
        });
        Table1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Table1KeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(Table1);

        VentanaInternaProveedor.getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 940, 400));

        buscar.setBackground(new java.awt.Color(255, 255, 255));
        buscar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/Bodega_Actualizar_Bton_Buscar.PNG"))); // NOI18N
        buscar.setText("BUSCAR");
        buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarActionPerformed(evt);
            }
        });
        VentanaInternaProveedor.getContentPane().add(buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 140, -1));

        cancelar.setBackground(new java.awt.Color(255, 255, 255));
        cancelar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/Bodega_Actualizar_Bton_Cancelar.PNG"))); // NOI18N
        cancelar.setText("CANCELAR");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });
        VentanaInternaProveedor.getContentPane().add(cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 90, 160, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/fondo.png"))); // NOI18N
        VentanaInternaProveedor.getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 990, 560));

        add(VentanaInternaProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 1000, 580));

        nombre.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nombre.setForeground(new java.awt.Color(102, 102, 102));
        add(nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 70, 340, 20));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 102, 102));
        jLabel9.setText("REGISTRO DE COMPRA");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 430, 30));

        cp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cpMouseClicked(evt);
            }
        });
        add(cp, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 240, 280, 30));

        alertaValorUnitario.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        alertaValorUnitario.setForeground(new java.awt.Color(255, 0, 51));
        add(alertaValorUnitario, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 420, 740, 20));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel18.setText("Nit:");
        add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 80, 20));

        alertaProveedor.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        alertaProveedor.setForeground(new java.awt.Color(255, 0, 51));
        add(alertaProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 790, 30));

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel21.setText("PROVEEDOR");
        add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 90, 30));

        nit.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nit.setForeground(new java.awt.Color(102, 102, 102));
        add(nit, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 50, 430, 20));

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel20.setText("No. Factura:");
        add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 80, 30));

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel27.setText("Resolución Facturación:");
        add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 170, 20));

        resolucionFacturacion.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        resolucionFacturacion.setForeground(new java.awt.Color(102, 102, 102));
        add(resolucionFacturacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 90, 260, 20));

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel23.setText("Resolución:");
        add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 100, 130, 30));

        cambiarResolucionFacturacion.setBackground(new java.awt.Color(255, 255, 255));
        cambiarResolucionFacturacion.setText("Cambiar_Resolución_Facturación");
        cambiarResolucionFacturacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cambiarResolucionFacturacionActionPerformed(evt);
            }
        });
        add(cambiarResolucionFacturacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, -1, -1));

        fechaResolución.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fechaResolución.setForeground(new java.awt.Color(102, 102, 102));
        add(fechaResolución, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 100, 280, 20));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Bodega:");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 70, 30));

        add(bodega, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 340, 280, 30));

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel24.setText("Fecha de");
        add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 90, 130, 20));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Producto:");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 290, 80, 20));

        producto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                productoMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                productoMouseExited(evt);
            }
        });
        add(producto, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 290, 280, 30));

        fechaCompra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fechaCompraMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                fechaCompraMouseEntered(evt);
            }
        });
        add(fechaCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 240, 280, 30));

        entradaAlmacenNo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        entradaAlmacenNo.setText("Entrada de almacen No.");
        add(entradaAlmacenNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 0, 210, 20));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/Compra_Agregar_Proveedor.png"))); // NOI18N
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 80, 90));

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel25.setText("Nombre:");
        add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 70, 70, 20));

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel26.setText("CARGAR ");
        add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 70, 20));

        registrarUnidad1.setBackground(new java.awt.Color(255, 255, 255));
        registrarUnidad1.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        registrarUnidad1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/Bodega_Registrar_Bton_Registrar.PNG"))); // NOI18N
        registrarUnidad1.setText("REGISTRAR COMPRA");
        registrarUnidad1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                registrarUnidad1MouseExited(evt);
            }
        });
        registrarUnidad1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarUnidad1ActionPerformed(evt);
            }
        });
        add(registrarUnidad1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 550, 210, 40));

        numeroFacturaProveedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                numeroFacturaProveedorMouseClicked(evt);
            }
        });
        add(numeroFacturaProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, 280, 30));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel19.setText("Observación:");
        add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 450, 120, 30));

        cantidad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cantidadMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cantidadMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cantidadMouseExited(evt);
            }
        });
        add(cantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 340, 280, 30));

        valorUnitario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                valorUnitarioMouseClicked(evt);
            }
        });
        add(valorUnitario, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 390, 280, 30));

        ValorUnidad.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        add(ValorUnidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 340, 130, 30));

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel28.setText("CP:");
        add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 70, 30));

        alertaCP.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        alertaCP.setForeground(new java.awt.Color(255, 0, 51));
        add(alertaCP, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 270, 340, 20));

        alertaCantidad.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        alertaCantidad.setForeground(new java.awt.Color(255, 0, 51));
        add(alertaCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 370, 480, 20));

        alertaNumeroFacturaProveedor.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        alertaNumeroFacturaProveedor.setForeground(new java.awt.Color(255, 0, 51));
        add(alertaNumeroFacturaProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 220, 430, 20));

        alertaFecha.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        alertaFecha.setForeground(new java.awt.Color(255, 0, 51));
        add(alertaFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 270, 520, 20));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Fecha de Compra:");
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 240, 160, 20));

        observacion.setColumns(20);
        observacion.setRows(5);
        jScrollPane2.setViewportView(observacion);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 440, 710, 100));

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel29.setText("Cantidad:");
        add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 340, 120, 30));

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel30.setText("Valor Unitario:");
        add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 130, 30));

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel22.setText("Sucursal No. ");
        add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 110, 20));

        sucursal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        sucursal.setForeground(new java.awt.Color(102, 102, 102));
        add(sucursal, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 70, 310, 20));

        jLabel15.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "INFORMACIÓN DEL PROVEEDOR", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Adobe Arabic", 1, 14))); // NOI18N
        add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 980, 160));

        fechaMaximaExportacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fechaMaximaExportacionMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                fechaMaximaExportacionMouseEntered(evt);
            }
        });
        add(fechaMaximaExportacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 290, 280, 30));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("Exportación:");
        add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 150, 30));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("Fecha Máxima");
        add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 150, 20));

        alertaFechaMaximaExportacion.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        alertaFechaMaximaExportacion.setForeground(new java.awt.Color(255, 0, 51));
        add(alertaFechaMaximaExportacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 320, 360, 20));
    }// </editor-fold>//GEN-END:initComponents

    private void limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarActionPerformed
          codigoB.setText("");
    }//GEN-LAST:event_limpiarActionPerformed

    private void buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarActionPerformed
        String valor=codigoB.getText();
        Table1.show();
        try {
            tabla(valor);
        } catch (SQLException ex) {
            Logger.getLogger(Compra_Registrar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_buscarActionPerformed

    private void Table1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Table1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_Table1KeyPressed

    private void cpMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cpMouseClicked
        
    }//GEN-LAST:event_cpMouseClicked

    private void fechaCompraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fechaCompraMouseClicked
       
    }//GEN-LAST:event_fechaCompraMouseClicked

    private void fechaCompraMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fechaCompraMouseEntered
        
    }//GEN-LAST:event_fechaCompraMouseEntered

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
                try{
                    accion="modificar";
                    modelo=(DefaultTableModel)Table1.getModel();
                    String nitT=(String)modelo.getValueAt(fila1, 0);
                    String sucursalT=(String)modelo.getValueAt(fila1, 1);
                    String nombreT=(String)modelo.getValueAt(fila1, 2);
                    nombreOriginal=(String)modelo.getValueAt(fila1, 2);
                    //buscar=nitT+":"+digitoVerificacionT+":"+nombreT;
                    Proveedor p=new Proveedor();
                    p.setNit(nitT);
                    p.setSucursal(Integer.parseInt(sucursalT));
                    p.setNombre(nombreT);
                    consultarParaActualizar(p);
                    VentanaInternaProveedor.show(false);
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, "No se pudo cargar el proveedor");
                }
            }
        }catch(Exception e){
        }
    }//GEN-LAST:event_EditarActionPerformed

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        VentanaInternaProveedor.show(true);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void registrarUnidad1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarUnidad1ActionPerformed
        if(nit.getText().equals("")){
            alertaProveedor.setText("Error!!.. Se debe Cargar el Proveedor");
        }else{
            if(numeroFacturaProveedor.getText().equals("")){
                alertaNumeroFacturaProveedor.setText("Error!!.. Número de factura del Proveedor no puede estar vacio");
            }else{
                if(cp.getText().equals("")){
                    alertaCP.setText("Error!!.. El CP no puede estar vacio");
                }
                else{
                    try{
                        Calendar fecha = fechaCompra.getCalendar();
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
                        String fechaCompra=ano+"-"+mes+"-"+dia;
                        String fechaMaximaExport="";
                        try{
                            Calendar fechaMaxExport = fechaMaximaExportacion.getCalendar();
                            String anoMaxExport = ""+fechaMaxExport.get(Calendar.YEAR);
                            String mesMaxExport = "";
                            String diaMaxExport = "";
                            if((fechaMaxExport.get(Calendar.MONTH) +1) <=9){
                                mesMaxExport = "0"+(fechaMaxExport.get(Calendar.MONTH) + 1);
                            }else{
                                mesMaxExport = ""+(fechaMaxExport.get(Calendar.MONTH) + 1);
                            }
                            if(fechaMaxExport.get(Calendar.DAY_OF_MONTH) <=9){
                                diaMaxExport = "0"+fechaMaxExport.get(Calendar.DAY_OF_MONTH);
                            }else{
                                diaMaxExport = ""+fechaMaxExport.get(Calendar.DAY_OF_MONTH);
                            }
                            fechaMaximaExport=anoMaxExport+"-"+mesMaxExport+"-"+diaMaxExport;
                        
                            if(cantidad.getText().equals("")){
                                alertaCantidad.setText("Error!!.. La cantidad no puede estar vacia");
                            }else{
                                if(valorUnitario.getText().equals("")){
                                    alertaValorUnitario.setText("Error!!.. El valor unitario no puede estar vacio");
                                }else{
                                    try{
                                        Integer.parseInt(cantidad.getText());
                                        BigDecimal cantidadI =new BigDecimal(cantidad.getText());
                                        if(Integer.parseInt(cantidad.getText()) <= 2000000){
                                            try{
                                                Float.parseFloat(valorUnitario.getText());
                                                BigDecimal valorUnitarioI =new BigDecimal(valorUnitario.getText());
                                                if(Float.parseFloat(valorUnitario.getText()) <= 1000000){
                                                    if(cantidadI.toPlainString().compareTo("0") > 0){
                                                        if(cantidadI.toPlainString().compareTo("0") == 0){
                                                            alertaCantidad.setText("Error!!.. La cantidad no puede ser 0 inicialmente");
                                                        }else{
                                                            if(valorUnitarioI.toPlainString().compareTo("0") > 0){
                                                                if(valorUnitarioI.toPlainString().compareTo("0") == 0){
                                                                    alertaValorUnitario.setText("Error!!.. El valor Unitario no puede ser 0 inicialmente");
                                                                }else{
                                                                    //###################################
                                                                    //Procedemos a registrar la compra
                                                                   //ano mes dia
                                                                  /* String fechaMaximaExportacion=""; //Fecha Máxima de Exportación
                                                                    if(Integer.parseInt(mes)<= 6){
                                                                        String mesMaximoExportacion = ""+(Integer.parseInt(mes) +6); 
                                                                        if(Integer.parseInt(mesMaximoExportacion) <= 9){
                                                                            mesMaximoExportacion = "0"+mesMaximoExportacion;
                                                                        }
                                                                        fechaMaximaExportacion=ano+"-"+mesMaximoExportacion+"-"+dia;
                                                                    }else{
                                                                        String mesMaximoExportacion = ""+((Integer.parseInt(mes) +6)-12); 
                                                                        if(Integer.parseInt(mesMaximoExportacion) <= 9){
                                                                            mesMaximoExportacion = "0"+mesMaximoExportacion;
                                                                        }
                                                                        fechaMaximaExportacion=(Integer.parseInt(ano)+1)+"-"+mesMaximoExportacion+"-"+dia;
                                                                    }*/
                                                                    //JOptionPane.showMessageDialog(null, fechaMaximaExportacion);
                                                                    try {
                                                                        //String[] arregloNit= nit.getText().split("-");
                                                                        String nitC = nit.getText();
                                                                        String sucursalC = sucursal.getText();
                                                                        String nombreC= nombre.getText();
                                                                        String resolucionFacturacionC= resolucionFacturacion.getText();
                                                                        String fechaResoluciónC= fechaResolución.getText();
                                                                        String numeroFacturaProveedorC= numeroFacturaProveedor.getText();
                                                                        String cpC= cp.getText();

                                                                        ControlDB_Bodega controlDB_Bodega =  new ControlDB_Bodega();
                                                                        int tipoBodegaC= controlDB_Bodega.RetornoIdBodega(bodega.getSelectedItem().toString());

                                                                         ControlDB_Producto controlDB_Producto =  new ControlDB_Producto();
                                                                        int tipoProductoC= controlDB_Producto.RetornoIdProducto(producto.getSelectedItem().toString());

                                                                        BigDecimal cantidadC=new java.math.BigDecimal(cantidad.getText());
                                                                        BigDecimal valorUnitarioC=new java.math.BigDecimal(valorUnitario.getText());
                                                                        Bodega bodegaX = new Bodega();
                                                                        int idBodega=controlDB_Bodega.RetornoIdBodega(bodega.getSelectedItem().toString());
                                                                        bodegaX.setId(idBodega);
                                                                        try{
                                                                            int result=0;
                                                                            IngresoProducto ingresoProducto = new IngresoProducto ();
                                                                            ingresoProducto.setCp(cpC);
                                                                            ingresoProducto.setProveedor_nit(nitC);
                                                                            ingresoProducto.setProveedor_sucursal(Integer.parseInt(sucursalC));
                                                                            ingresoProducto.setProducto_id(tipoProductoC);
                                                                            ingresoProducto.setNumeroFacturaProveedor(numeroFacturaProveedorC);
                                                                            ingresoProducto.setResolucionFactura(resolucionFacturacionC);
                                                                            ingresoProducto.setFechaResolucion(fechaResoluciónC);
                                                                            ingresoProducto.setFechaCompra(fechaCompra);
                                                                            ingresoProducto.setFechaMaximaExportacion(fechaMaximaExport);
                                                                            ingresoProducto.setCantidadInicial(cantidadC);
                                                                            ingresoProducto.setValorUnitario(valorUnitarioC);
                                                                            ingresoProducto.setObservacion(observacion.getText());
                                                                            ingresoProducto.setEstado(1);
                                                                            ingresoProducto.setNombreQuienElabora(user.getNombre()+" "+user.getApellido());
                                                                            ingresoProducto.setBodega_ingresoProductoInicial(bodegaX.getId());

                                                                            ControlDB_Compra controlDB_Compra = new ControlDB_Compra(); 
                                                                            if(controlDB_Compra.validarExistenciaCP(ingresoProducto.getCp())){
                                                                                result=controlDB_Compra.registrarCompra(ingresoProducto, bodegaX, user);
                                                                                //JOptionPane.showMessageDialog(null, ""+result);
                                                                                if(result==1){
                                                                                    JOptionPane.showMessageDialog(null, "Registro de compra Exitoso");
                                                                                    Generar_Reportes generarReportes = new Generar_Reportes();
                                                                                    generarReportes.generar_FacturaCompra(controlDB_Compra.retornarElMaximo());
                                                                                    nit.setText("");
                                                                                    sucursal.setText("");
                                                                                    nombre.setText("");
                                                                                    resolucionFacturacion.setText("");
                                                                                    fechaResolución.setText("");
                                                                                    numeroFacturaProveedor.setText("");
                                                                                    cp.setText("");
                                                                                    //fechaCompra
                                                                                    producto.setSelectedIndex(0);
                                                                                    bodega.setSelectedIndex(0);
                                                                                    cantidad.setText("");
                                                                                    valorUnitario.setText("");
                                                                                    observacion.setText("");
                                                                                    maximoEntradasAlmacen++;
                                                                                    entradaAlmacenNo.setText("Entrada de almacen No.  "+maximoEntradasAlmacen);
                                                                                }else{
                                                                                    JOptionPane.showMessageDialog(null, "Error Al Registrar la compra");
                                                                                }
                                                                            }else{
                                                                                JOptionPane.showMessageDialog(null, "Error!!. El CP ya fue registrado anteriormente");
                                                                            }
                                                                        }catch(Exception e){
                                                                            JOptionPane.showMessageDialog(null, "Error.. Al tratar de registrar la compra");
                                                                        }                                                               
                                                                    }catch(Exception e){
                                                                        JOptionPane.showMessageDialog(null, "Error.. Al Conectarse con la base de datos");        
                                                                    }
                                                                }
                                                            }else{
                                                                alertaValorUnitario.setText("Error!!.. El valor Unitario no puede ser negativo");
                                                            }
                                                        }
                                                    }else{
                                                        alertaCantidad.setText("Error!!.. La cantidad no puede ser negativa");
                                                    }
                                                }else{
                                                    alertaValorUnitario.setText("Error!!.. El valor unitario debe ser menor a un millon (1.000.000)");
                                                }
                                            }catch(Exception e){
                                                alertaValorUnitario.setText("Error!!.. El valor unitario debe ser numerico y no tener valor Exagerados");
                                            }
                                        }else{
                                            alertaCantidad.setText("Error!!.. La cantidad no puede ser mayor a Dos Millones(2.000.000)");
                                        }
                                    }catch(Exception e){
                                        alertaCantidad.setText("Error!!.. La cantidad debe ser numerica y no tener Valores Exagerados");
                                    }
                                }
                            }
                        }catch(Exception e){
                            alertaFechaMaximaExportacion.setText("Error!!.. Verifique la fecha máxima de exportación");
                        }
                    }catch(Exception e){
                        alertaFecha.setText("Error!!.. Verifique la fecha de Compra");
                    }
                }
            }
        }
    }//GEN-LAST:event_registrarUnidad1ActionPerformed

    private void numeroFacturaProveedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_numeroFacturaProveedorMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_numeroFacturaProveedorMouseClicked

    private void cantidadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cantidadMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cantidadMouseClicked

    private void valorUnitarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_valorUnitarioMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_valorUnitarioMouseClicked

    private void registrarUnidad1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registrarUnidad1MouseExited
        alertaCP.setText("");
        alertaCantidad.setText("");
        alertaFecha.setText("");
        alertaNumeroFacturaProveedor.setText("");
        alertaProveedor.setText("");
        alertaValorUnitario.setText("");
                
    }//GEN-LAST:event_registrarUnidad1MouseExited

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
         VentanaInternaProveedor.show(false);
    }//GEN-LAST:event_cancelarActionPerformed

    private void codigoBKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codigoBKeyPressed
        Table1.removeAll();
        String valor=codigoB.getText();
        Table1.show();
        try {
            tabla(valor);
        } catch (SQLException ex) {
            Logger.getLogger(Compra_Registrar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_codigoBKeyPressed

    private void productoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_productoMouseExited
        if(producto.getSelectedItem().toString().equals("Camarones")){
            ValorUnidad.setText("Kilos");
        }else{
            if(producto.getSelectedItem().toString().equals("Cajas")){
                ValorUnidad.setText("Unidades");
            }
        } 
    }//GEN-LAST:event_productoMouseExited

    private void productoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_productoMouseClicked
        if(producto.getSelectedItem().toString().equals("Camarones")){
            ValorUnidad.setText("Kilos");
        }else{
            if(producto.getSelectedItem().toString().equals("Cajas")){
                ValorUnidad.setText("Unidades");
            }
        } 
    }//GEN-LAST:event_productoMouseClicked

    private void cantidadMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cantidadMouseEntered
        if(producto.getSelectedItem().toString().equals("Camarones")){
            ValorUnidad.setText("Kilos");
        }else{
            if(producto.getSelectedItem().toString().equals("Cajas")){
                ValorUnidad.setText("Unidades");
            }
        } 
    }//GEN-LAST:event_cantidadMouseEntered

    private void cantidadMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cantidadMouseExited
        if(producto.getSelectedItem().toString().equals("Camarones")){
            ValorUnidad.setText("Kilos");
        }else{
            if(producto.getSelectedItem().toString().equals("Cajas")){
                ValorUnidad.setText("Unidades");
            }
        } 
    }//GEN-LAST:event_cantidadMouseExited

    private void cambiarResolucionFacturacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cambiarResolucionFacturacionActionPerformed
        try{
            BigDecimal resoFacturacion = new BigDecimal(JOptionPane.showInputDialog(null, "Ingrese la resolución Facturación"));
            resolucionFacturacion.setText(""+resoFacturacion.toPlainString());
        }catch(Exception e){
             JOptionPane.showMessageDialog(null, "Error!!.. La resolución de Facturación debe ser Númerica");       
        }
    }//GEN-LAST:event_cambiarResolucionFacturacionActionPerformed

    private void fechaMaximaExportacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fechaMaximaExportacionMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_fechaMaximaExportacionMouseClicked

    private void fechaMaximaExportacionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fechaMaximaExportacionMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_fechaMaximaExportacionMouseEntered

    private void Table1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Table1MouseClicked
       if (evt.getClickCount() == 2) {
           // TODO lo del clik derechoo
            int fila1;
            String buscar="";
            try{
                fila1=Table1.getSelectedRow();
                if(fila1==-1){
                    JOptionPane.showMessageDialog(null,"no se ha seleccionando ninguna fila");
                }
                else{
                    try{
                        accion="modificar";
                        modelo=(DefaultTableModel)Table1.getModel();
                        String nitT=(String)modelo.getValueAt(fila1, 0);
                        String sucursalT=(String)modelo.getValueAt(fila1, 1);
                        String nombreT=(String)modelo.getValueAt(fila1, 2);
                        nombreOriginal=(String)modelo.getValueAt(fila1, 2);
                        //buscar=nitT+":"+digitoVerificacionT+":"+nombreT;
                        Proveedor p=new Proveedor();
                        p.setNit(nitT);
                        p.setSucursal(Integer.parseInt(sucursalT));
                        p.setNombre(nombreT);
                        consultarParaActualizar(p);
                        VentanaInternaProveedor.show(false);
                    }catch(Exception e){
                        JOptionPane.showMessageDialog(null, "No se pudo cargar el proveedor");
                    }
                }
            }catch(Exception e){
            }
        }
    }//GEN-LAST:event_Table1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Editar;
    private javax.swing.JPopupMenu Seleccionar;
    private javax.swing.JTable Table1;
    private javax.swing.JLabel ValorUnidad;
    private javax.swing.JInternalFrame VentanaInternaProveedor;
    private javax.swing.JLabel alertaCP;
    private javax.swing.JLabel alertaCantidad;
    private javax.swing.JLabel alertaFecha;
    private javax.swing.JLabel alertaFechaMaximaExportacion;
    private javax.swing.JLabel alertaNumeroFacturaProveedor;
    private javax.swing.JLabel alertaProveedor;
    private javax.swing.JLabel alertaValorUnitario;
    private javax.swing.JComboBox<String> bodega;
    private javax.swing.JButton buscar;
    private javax.swing.JButton cambiarResolucionFacturacion;
    private javax.swing.JButton cancelar;
    private javax.swing.JTextField cantidad;
    private javax.swing.JTextField codigoB;
    private javax.swing.JTextField cp;
    private javax.swing.JLabel entradaAlmacenNo;
    private com.toedter.calendar.JDateChooser fechaCompra;
    private com.toedter.calendar.JDateChooser fechaMaximaExportacion;
    private javax.swing.JLabel fechaResolución;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton limpiar;
    private javax.swing.JLabel nit;
    private javax.swing.JLabel nombre;
    private javax.swing.JTextField numeroFacturaProveedor;
    private javax.swing.JTextArea observacion;
    private javax.swing.JComboBox<String> producto;
    private javax.swing.JButton registrarUnidad1;
    private javax.swing.JLabel resolucionFacturacion;
    private javax.swing.JLabel sucursal;
    private javax.swing.JTextField valorUnitario;
    // End of variables declaration//GEN-END:variables
public void tabla(String valorConsulta) throws SQLException{
        registro = new String[3]; 
        modelo = new DefaultTableModel(null, titulo);
        ControlDB_Proveedor p = new ControlDB_Proveedor();
        ArrayList<Proveedor> listadoProveedor=p.buscarProveedor(valorConsulta);
        for(int i =0; i< listadoProveedor.size(); i++){
            registro[0]=""+listadoProveedor.get(i).getNit();
            registro[1]=""+listadoProveedor.get(i).getSucursal();
            registro[2]=""+listadoProveedor.get(i).getNombre();
            modelo.addRow(registro);
            Table1.setModel(modelo);
        }  
    }
    public void consultarParaActualizar (Proveedor p) throws SQLException{
        ControlDB_Proveedor c = new ControlDB_Proveedor();
        ArrayList<Proveedor> listadoProveedor=c.consultarUnicoProveedor(p);
        for(int i =0; i< listadoProveedor.size(); i++){ 
            nit.setText(listadoProveedor.get(i).getNit());
            sucursal.setText(""+listadoProveedor.get(i).getSucursal());
            nombre.setText(listadoProveedor.get(i).getNombre());
            resolucionFacturacion.setText(""+listadoProveedor.get(i).getResolucionFacturacion());                       
            fechaResolución.setText(listadoProveedor.get(i).getFechaResolucion());
            
        }
    }
}
