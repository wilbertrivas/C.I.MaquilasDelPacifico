/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Controladores.*;
import Modelos.Usuario;
import java.text.ParseException;
import javax.swing.JOptionPane;
public class GUI_Principal extends javax.swing.JFrame {

    Usuario user;
    public GUI_Principal() {
        initComponents();
        this.setLocationRelativeTo(null);
        ObtenerFecha c = new ObtenerFecha();
        fecha.setText("Fecha-Hora Ingreso al Sistema: "+c.getNTPDate()); 
        user= new Usuario(); 
        user.setUser("");
    }
    public void cargarUsuario(Usuario userT) throws ParseException{
        user = userT;  
        userOnline.setText("Usuario: "+ user.getUser());
        nombreUsuarioEnLinea.setText(("Nombre: "+ user.getNombre()+" "+ user.getApellido()));
        
        
    }
    

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JScrollPane();
        Boton_Proveedor = new javax.swing.JButton();
        nombreUsuarioEnLinea = new javax.swing.JLabel();
        fecha = new javax.swing.JLabel();
        userOnline = new javax.swing.JLabel();
        entradaAlmacenNo1 = new javax.swing.JLabel();
        Boton_Compra = new javax.swing.JButton();
        Boton_Ventas = new javax.swing.JButton();
        Boton_Movimientos = new javax.swing.JButton();
        Boton_Consumo = new javax.swing.JButton();
        Boton_InformeAnual = new javax.swing.JButton();
        Boton_Producto = new javax.swing.JButton();
        Boton_Unidad = new javax.swing.JButton();
        Boton_Bodega = new javax.swing.JButton();
        Boton_Usuario = new javax.swing.JButton();
        Boton_Auditoria = new javax.swing.JButton();
        Boton_Maquilas = new javax.swing.JButton();
        Boton_Salir = new javax.swing.JButton();
        Boton_Cliente = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 1340, 500));

        Boton_Proveedor.setBackground(new java.awt.Color(255, 255, 255));
        Boton_Proveedor.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Boton_Proveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/proveedor.png"))); // NOI18N
        Boton_Proveedor.setText("PROVEEDOR");
        Boton_Proveedor.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Boton_Proveedor.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        Boton_Proveedor.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Boton_Proveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton_ProveedorActionPerformed(evt);
            }
        });
        getContentPane().add(Boton_Proveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, 100, 70));

        nombreUsuarioEnLinea.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nombreUsuarioEnLinea.setForeground(new java.awt.Color(0, 153, 153));
        nombreUsuarioEnLinea.setText("Nombre:");
        getContentPane().add(nombreUsuarioEnLinea, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 10, 380, 20));

        fecha.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fecha.setForeground(new java.awt.Color(0, 153, 153));
        getContentPane().add(fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 0, 420, 20));

        userOnline.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        userOnline.setForeground(new java.awt.Color(0, 153, 153));
        userOnline.setText("Usuario");
        getContentPane().add(userOnline, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 0, 180, -1));

        entradaAlmacenNo1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        entradaAlmacenNo1.setForeground(new java.awt.Color(0, 153, 51));
        entradaAlmacenNo1.setText("Usuario en Linea: ");
        getContentPane().add(entradaAlmacenNo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 0, 110, 20));

        Boton_Compra.setBackground(new java.awt.Color(255, 255, 255));
        Boton_Compra.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Boton_Compra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/comprar.png"))); // NOI18N
        Boton_Compra.setText("COMPRA");
        Boton_Compra.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Boton_Compra.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        Boton_Compra.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Boton_Compra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton_CompraActionPerformed(evt);
            }
        });
        getContentPane().add(Boton_Compra, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 50, 80, 70));

        Boton_Ventas.setBackground(new java.awt.Color(255, 255, 255));
        Boton_Ventas.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Boton_Ventas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/vender.png"))); // NOI18N
        Boton_Ventas.setText("VENTAS");
        Boton_Ventas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Boton_Ventas.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        Boton_Ventas.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Boton_Ventas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton_VentasActionPerformed(evt);
            }
        });
        getContentPane().add(Boton_Ventas, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 50, 80, 70));

        Boton_Movimientos.setBackground(new java.awt.Color(255, 255, 255));
        Boton_Movimientos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Boton_Movimientos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/movimientos.PNG"))); // NOI18N
        Boton_Movimientos.setText("MOVIMIENTO");
        Boton_Movimientos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Boton_Movimientos.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        Boton_Movimientos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Boton_Movimientos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton_MovimientosActionPerformed(evt);
            }
        });
        getContentPane().add(Boton_Movimientos, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 50, 110, 70));

        Boton_Consumo.setBackground(new java.awt.Color(255, 255, 255));
        Boton_Consumo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Boton_Consumo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/consumo_P.png"))); // NOI18N
        Boton_Consumo.setText("CONSUMO");
        Boton_Consumo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Boton_Consumo.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        Boton_Consumo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Boton_Consumo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton_ConsumoActionPerformed(evt);
            }
        });
        getContentPane().add(Boton_Consumo, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 50, 100, 70));

        Boton_InformeAnual.setBackground(new java.awt.Color(255, 255, 255));
        Boton_InformeAnual.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Boton_InformeAnual.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/informe_Final.png"))); // NOI18N
        Boton_InformeAnual.setText("INFORME ANUAL");
        Boton_InformeAnual.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Boton_InformeAnual.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        Boton_InformeAnual.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Boton_InformeAnual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton_InformeAnualActionPerformed(evt);
            }
        });
        getContentPane().add(Boton_InformeAnual, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 50, 130, 70));

        Boton_Producto.setBackground(new java.awt.Color(255, 255, 255));
        Boton_Producto.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Boton_Producto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/camaron.png"))); // NOI18N
        Boton_Producto.setText("PRODUCTO");
        Boton_Producto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Boton_Producto.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        Boton_Producto.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Boton_Producto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton_ProductoActionPerformed(evt);
            }
        });
        getContentPane().add(Boton_Producto, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 50, 100, 70));

        Boton_Unidad.setBackground(new java.awt.Color(255, 255, 255));
        Boton_Unidad.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Boton_Unidad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/balanza.png"))); // NOI18N
        Boton_Unidad.setText("UNIDAD");
        Boton_Unidad.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Boton_Unidad.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        Boton_Unidad.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Boton_Unidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton_UnidadActionPerformed(evt);
            }
        });
        getContentPane().add(Boton_Unidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 50, 80, 70));

        Boton_Bodega.setBackground(new java.awt.Color(255, 255, 255));
        Boton_Bodega.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Boton_Bodega.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/bodega.PNG"))); // NOI18N
        Boton_Bodega.setText("BODEGA");
        Boton_Bodega.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Boton_Bodega.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        Boton_Bodega.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Boton_Bodega.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton_BodegaActionPerformed(evt);
            }
        });
        getContentPane().add(Boton_Bodega, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 50, 80, 70));

        Boton_Usuario.setBackground(new java.awt.Color(255, 255, 255));
        Boton_Usuario.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Boton_Usuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/user.PNG"))); // NOI18N
        Boton_Usuario.setText("USUARIO");
        Boton_Usuario.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Boton_Usuario.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        Boton_Usuario.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Boton_Usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton_UsuarioActionPerformed(evt);
            }
        });
        getContentPane().add(Boton_Usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 50, 90, 70));

        Boton_Auditoria.setBackground(new java.awt.Color(255, 255, 255));
        Boton_Auditoria.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Boton_Auditoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/auditoria.PNG"))); // NOI18N
        Boton_Auditoria.setText("AUDITORIA");
        Boton_Auditoria.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Boton_Auditoria.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        Boton_Auditoria.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Boton_Auditoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton_AuditoriaActionPerformed(evt);
            }
        });
        getContentPane().add(Boton_Auditoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 50, 100, 70));

        Boton_Maquilas.setBackground(new java.awt.Color(255, 255, 255));
        Boton_Maquilas.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Boton_Maquilas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/maquilas.PNG"))); // NOI18N
        Boton_Maquilas.setText("EMP. LOCAL");
        Boton_Maquilas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Boton_Maquilas.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        Boton_Maquilas.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Boton_Maquilas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton_MaquilasActionPerformed(evt);
            }
        });
        getContentPane().add(Boton_Maquilas, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 50, 100, 70));

        Boton_Salir.setBackground(new java.awt.Color(255, 255, 255));
        Boton_Salir.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Boton_Salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/cerrar_sesion.png"))); // NOI18N
        Boton_Salir.setText("SALIR");
        Boton_Salir.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Boton_Salir.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        Boton_Salir.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Boton_Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton_SalirActionPerformed(evt);
            }
        });
        getContentPane().add(Boton_Salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 50, 90, 70));

        Boton_Cliente.setBackground(new java.awt.Color(255, 255, 255));
        Boton_Cliente.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Boton_Cliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/cliente.png"))); // NOI18N
        Boton_Cliente.setText("CLIENTE");
        Boton_Cliente.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Boton_Cliente.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        Boton_Cliente.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Boton_Cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton_ClienteActionPerformed(evt);
            }
        });
        getContentPane().add(Boton_Cliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 80, 70));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/barra2.jpg"))); // NOI18N
        jLabel4.setText("jLabel4");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 1340, 50));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 51));
        jLabel2.setText("C.I. MAQUILAS DEL PACIFICO S.A.S");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 2, -1, 20));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/barra.jpg"))); // NOI18N
        jLabel5.setText("jLabel4");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1340, 50));

        jLabel22.setBackground(new java.awt.Color(255, 255, 255));
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/fondo.png"))); // NOI18N
        getContentPane().add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1340, 160));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Boton_ProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton_ProveedorActionPerformed
        //Validamos que el usuario sea valido
        if(user.getUser().equals("")){
            JOptionPane.showMessageDialog(null, "Usted está ingresando de manera Ilegal, favor comunicarse con el Administrador");
            GUI_Iniciar gui_Iniciar = new GUI_Iniciar();
            gui_Iniciar.setVisible(true);
            this.removeAll();
            this.setVisible(false);
        }else{
            panel.setViewportView(new Menu_Proveedores());
        } 
    }//GEN-LAST:event_Boton_ProveedorActionPerformed

    private void Boton_CompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton_CompraActionPerformed
        //Validamos que el usuario sea valido
        if(user.getUser().equals("")){
            JOptionPane.showMessageDialog(null, "Usted está ingresando de manera Ilegal, favor comunicarse con el Administrador");
            GUI_Iniciar gui_Iniciar = new GUI_Iniciar();
            gui_Iniciar.setVisible(true);
            this.removeAll();
            this.setVisible(false);
        }else{
            panel.setViewportView(new Menu_Compra(user));
        } 
    }//GEN-LAST:event_Boton_CompraActionPerformed

    private void Boton_VentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton_VentasActionPerformed
         //Validamos que el usuario sea valido
        if(user.getUser().equals("")){
            JOptionPane.showMessageDialog(null, "Usted está ingresando de manera Ilegal, favor comunicarse con el Administrador");
            GUI_Iniciar gui_Iniciar = new GUI_Iniciar();
            gui_Iniciar.setVisible(true);
            this.removeAll();
            this.setVisible(false);
        }else{
            panel.setViewportView(new Menu_Venta(user));
        } 
    }//GEN-LAST:event_Boton_VentasActionPerformed

    private void Boton_MovimientosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton_MovimientosActionPerformed
         //Validamos que el usuario sea valido
        if(user.getUser().equals("")){
            JOptionPane.showMessageDialog(null, "Usted está ingresando de manera Ilegal, favor comunicarse con el Administrador");
            GUI_Iniciar gui_Iniciar = new GUI_Iniciar();
            gui_Iniciar.setVisible(true);
            this.removeAll();
            this.setVisible(false);
        }else{
            panel.setViewportView(new Menu_Movimientos(user));
        } 
    }//GEN-LAST:event_Boton_MovimientosActionPerformed

    private void Boton_ConsumoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton_ConsumoActionPerformed
         //Validamos que el usuario sea valido
        if(user.getUser().equals("")){
            JOptionPane.showMessageDialog(null, "Usted está ingresando de manera Ilegal, favor comunicarse con el Administrador");
            GUI_Iniciar gui_Iniciar = new GUI_Iniciar();
            gui_Iniciar.setVisible(true);
            this.removeAll();
            this.setVisible(false);
        }else{
            panel.setViewportView(new Menu_Consumo(user));
        } 
    }//GEN-LAST:event_Boton_ConsumoActionPerformed

    private void Boton_InformeAnualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton_InformeAnualActionPerformed
         //Validamos que el usuario sea valido
        if(user.getUser().equals("")){
            JOptionPane.showMessageDialog(null, "Usted está ingresando de manera Ilegal, favor comunicarse con el Administrador");
            GUI_Iniciar gui_Iniciar = new GUI_Iniciar();
            gui_Iniciar.setVisible(true);
            this.removeAll();
            this.setVisible(false);
        }else{
            panel.setViewportView(new InformeAnual());
        } 
    }//GEN-LAST:event_Boton_InformeAnualActionPerformed

    private void Boton_ProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton_ProductoActionPerformed
         //Validamos que el usuario sea valido
        if(user.getUser().equals("")){
            JOptionPane.showMessageDialog(null, "Usted está ingresando de manera Ilegal, favor comunicarse con el Administrador");
            GUI_Iniciar gui_Iniciar = new GUI_Iniciar();
            gui_Iniciar.setVisible(true);
            this.removeAll();
            this.setVisible(false);
        }else{
            panel.setViewportView(new Menu_Producto());
        } 
    }//GEN-LAST:event_Boton_ProductoActionPerformed

    private void Boton_UnidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton_UnidadActionPerformed
         //Validamos que el usuario sea valido
        if(user.getUser().equals("")){
            JOptionPane.showMessageDialog(null, "Usted está ingresando de manera Ilegal, favor comunicarse con el Administrador");
            GUI_Iniciar gui_Iniciar = new GUI_Iniciar();
            gui_Iniciar.setVisible(true);
            this.removeAll();
            this.setVisible(false);
        }else{
            panel.setViewportView(new Menu_Unidad());
        } 
    }//GEN-LAST:event_Boton_UnidadActionPerformed

    private void Boton_BodegaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton_BodegaActionPerformed
         //Validamos que el usuario sea valido
        if(user.getUser().equals("")){
            JOptionPane.showMessageDialog(null, "Usted está ingresando de manera Ilegal, favor comunicarse con el Administrador");
            GUI_Iniciar gui_Iniciar = new GUI_Iniciar();
            gui_Iniciar.setVisible(true);
            this.removeAll();
            this.setVisible(false);
        }else{
            panel.setViewportView(new Menu_Bodega());
        } 
    }//GEN-LAST:event_Boton_BodegaActionPerformed

    private void Boton_UsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton_UsuarioActionPerformed
         //Validamos que el usuario sea valido
        if(user.getUser().equals("")){
            JOptionPane.showMessageDialog(null, "Usted está ingresando de manera Ilegal, favor comunicarse con el Administrador");
            GUI_Iniciar gui_Iniciar = new GUI_Iniciar();
            gui_Iniciar.setVisible(true);
            this.removeAll();
            this.setVisible(false);
        }else{
            panel.setViewportView(new Menu_Usuario());
        }  
    }//GEN-LAST:event_Boton_UsuarioActionPerformed

    private void Boton_AuditoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton_AuditoriaActionPerformed
         //Validamos que el usuario sea valido
        if(user.getUser().equals("")){
            JOptionPane.showMessageDialog(null, "Usted está ingresando de manera Ilegal, favor comunicarse con el Administrador");
            GUI_Iniciar gui_Iniciar = new GUI_Iniciar();
            gui_Iniciar.setVisible(true);
            this.removeAll();
            this.setVisible(false);
        }else{
            //panel.setViewportView(new Auditoria_Control());
        } 
    }//GEN-LAST:event_Boton_AuditoriaActionPerformed

    private void Boton_MaquilasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton_MaquilasActionPerformed
         //Validamos que el usuario sea valido
        if(user.getUser().equals("")){
            JOptionPane.showMessageDialog(null, "Usted está ingresando de manera Ilegal, favor comunicarse con el Administrador");
            GUI_Iniciar gui_Iniciar = new GUI_Iniciar();
            gui_Iniciar.setVisible(true);
            this.removeAll();
            this.setVisible(false);
        }else{
            panel.setViewportView(new Menu_EmpresaLocal());
        } 
    }//GEN-LAST:event_Boton_MaquilasActionPerformed

    private void Boton_SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton_SalirActionPerformed
       GUI_Iniciar gui_Iniciar = new GUI_Iniciar();
        gui_Iniciar.setVisible(true);
        this.removeAll();
        this.setVisible(false);
    }//GEN-LAST:event_Boton_SalirActionPerformed

    private void Boton_ClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton_ClienteActionPerformed
         //Validamos que el usuario sea valido
        if(user.getUser().equals("")){
            JOptionPane.showMessageDialog(null, "Usted está ingresando de manera Ilegal, favor comunicarse con el Administrador");
            GUI_Iniciar gui_Iniciar = new GUI_Iniciar();
            gui_Iniciar.setVisible(true);
            this.removeAll();
            this.setVisible(false);
        }else{
            panel.setViewportView(new Menu_Cliente());
        } 
    }//GEN-LAST:event_Boton_ClienteActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Boton_Auditoria;
    private javax.swing.JButton Boton_Bodega;
    private javax.swing.JButton Boton_Cliente;
    private javax.swing.JButton Boton_Compra;
    private javax.swing.JButton Boton_Consumo;
    private javax.swing.JButton Boton_InformeAnual;
    private javax.swing.JButton Boton_Maquilas;
    private javax.swing.JButton Boton_Movimientos;
    private javax.swing.JButton Boton_Producto;
    private javax.swing.JButton Boton_Proveedor;
    private javax.swing.JButton Boton_Salir;
    private javax.swing.JButton Boton_Unidad;
    private javax.swing.JButton Boton_Usuario;
    private javax.swing.JButton Boton_Ventas;
    private javax.swing.JLabel entradaAlmacenNo1;
    private javax.swing.JLabel fecha;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel nombreUsuarioEnLinea;
    private javax.swing.JScrollPane panel;
    private javax.swing.JLabel userOnline;
    // End of variables declaration//GEN-END:variables
    public void CargarIconosAplicacion(){
        Controladores.ControlDB_Usuario controlDB_usuario= new ControlDB_Usuario();
        if(controlDB_usuario.validarTipoUsuario(user.getUser()).equals("Administrador")){
            Boton_Cliente.show(true);         
            Boton_Proveedor.show(true);       
            Boton_Compra.show(true);          
            Boton_Ventas.show(true);          
            Boton_Movimientos.show(true);     
            Boton_Consumo.show(true);       
            Boton_InformeAnual.show(true);          
            Boton_Auditoria.show(true); 
            Boton_Usuario.show(true);   
            Boton_Maquilas.show(true);    
            Boton_Salir.show(true); 
            Boton_Producto.show(false);          
            Boton_Unidad.show(false);         
            Boton_Bodega.show(false);                 
        }else{
            if(controlDB_usuario.validarTipoUsuario(user.getUser()).equals("Estandar")){
                Boton_Cliente.show(true);         
                Boton_Proveedor.show(true);       
                Boton_Compra.show(true);          
                Boton_Ventas.show(true);          
                Boton_Movimientos.show(true);     
                Boton_Consumo.show(true);       
                Boton_InformeAnual.show(false);          
                Boton_Auditoria.show(false); 
                Boton_Usuario.show(false);   
                Boton_Maquilas.show(false);    
                Boton_Salir.show(true); 
                Boton_Producto.show(false);          
                Boton_Unidad.show(false);         
                Boton_Bodega.show(false); 
            }else{
                if(controlDB_usuario.validarTipoUsuario(user.getUser()).equals("Root")){
                    Boton_Cliente.show(true);         
                    Boton_Proveedor.show(true);       
                    Boton_Compra.show(true);          
                    Boton_Ventas.show(true);          
                    Boton_Movimientos.show(true);     
                    Boton_Consumo.show(true);       
                    Boton_InformeAnual.show(true);          
                    Boton_Auditoria.show(true); 
                    Boton_Usuario.show(true);   
                    Boton_Maquilas.show(true);    
                    Boton_Salir.show(true); 
                    Boton_Producto.show(true);          
                    Boton_Unidad.show(true);         
                    Boton_Bodega.show(true); 
                }
            }
        }
    }
}
