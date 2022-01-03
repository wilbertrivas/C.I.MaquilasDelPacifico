
package GUI;

import Controladores.ControlDB_Otros;
import Controladores.ControlDB_Proveedor;
import Controladores.ControlDB_TipoProveedor;
import Modelos.Proveedor;
import Modelos.TipoProveedor;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JOptionPane;

public class Proveedores_Registrar extends javax.swing.JPanel {
    Controladores.ControlDB_Proveedor ControlDB_Proveedor = new ControlDB_Proveedor();
    Controladores.ControlDB_TipoProveedor controladorTipoProveedor = new ControlDB_TipoProveedor();
    Controladores.ControlDB_Otros controladorOtros = new ControlDB_Otros();
    
    public Proveedores_Registrar() {
        initComponents();
        PersonaNatural_apellidos.setEnabled(false);
        PersonaNatural_nombres.setEnabled(false); 
        //Cargamos en la interfaz los tipo de Proveedor
        ArrayList<TipoProveedor> listadoTipoProveedor = new ArrayList();
        listadoTipoProveedor=controladorTipoProveedor.cargarTipoProveedor();
        for(int i=0; i< listadoTipoProveedor.size(); i++){
            tipoProveedor.addItem(listadoTipoProveedor.get(i).getDescripcion());
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        estado = new javax.swing.JComboBox<>();
        registrarProveedores = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        tipoProveedor = new javax.swing.JComboBox<>();
        alertaNit = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        observacion = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        nit = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        alertaNombre = new javax.swing.JLabel();
        nombre = new javax.swing.JTextField();
        telefono = new javax.swing.JTextField();
        celular = new javax.swing.JTextField();
        direccion = new javax.swing.JTextField();
        correo = new javax.swing.JTextField();
        ciudad = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        resolucionFactura = new javax.swing.JTextField();
        fechaResolucion = new com.toedter.calendar.JDateChooser();
        alertaResolucionFacturacion = new javax.swing.JLabel();
        alertaFechaResolucion = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        digitoVerificacion = new javax.swing.JLabel();
        personaNatural = new javax.swing.JCheckBox();
        PersonaNatural_apellidosL = new javax.swing.JLabel();
        PersonaNatural_apellidos = new javax.swing.JTextField();
        PersonaNatural_nombres = new javax.swing.JTextField();
        PersonaNatural_nombresL = new javax.swing.JLabel();
        alertaPersonaNatural_Apellidos = new javax.swing.JLabel();
        alertaPersonaNatural_Nombres = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("-");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 100, 40, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("CELULAR:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 140, 30));

        estado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));
        add(estado, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 420, 310, 40));

        registrarProveedores.setBackground(new java.awt.Color(255, 255, 255));
        registrarProveedores.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        registrarProveedores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/Bodega_Registrar_Bton_Registrar.PNG"))); // NOI18N
        registrarProveedores.setText("REGISTRAR");
        registrarProveedores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                registrarProveedoresMouseExited(evt);
            }
        });
        registrarProveedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarProveedoresActionPerformed(evt);
            }
        });
        add(registrarProveedores, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 480, 150, 50));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("RESOLUCIÓN:");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 250, 160, 20));

        add(tipoProveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, 330, 40));

        alertaNit.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        alertaNit.setForeground(new java.awt.Color(255, 51, 51));
        add(alertaNit, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 320, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("NOMBRE:");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 100, 60, 30));

        observacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                observacionMouseClicked(evt);
            }
        });
        add(observacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 380, 310, 30));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("NIT:");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 90, 30));

        nit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nitMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                nitMouseEntered(evt);
            }
        });
        nit.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nitKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nitKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nitKeyTyped(evt);
            }
        });
        add(nit, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, 140, 30));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("CORREO:");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 90, 30));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("TELEFONO:");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 300, 70, 30));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("ESTADO:");
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, 150, 30));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("DIRECCION:");
        add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 340, 80, 30));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("CIUDAD:");
        add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 380, 70, 30));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setText("OBSERVACION:");
        add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, 140, 30));

        alertaNombre.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        alertaNombre.setForeground(new java.awt.Color(255, 51, 51));
        add(alertaNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 130, 410, 30));

        nombre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nombreMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                nombreMouseEntered(evt);
            }
        });
        add(nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 100, 310, 30));

        telefono.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                telefonoMouseClicked(evt);
            }
        });
        add(telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 300, 310, 30));

        celular.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                celularMouseClicked(evt);
            }
        });
        add(celular, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 300, 310, 30));

        direccion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                direccionMouseClicked(evt);
            }
        });
        add(direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 340, 310, 30));

        correo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                correoMouseClicked(evt);
            }
        });
        add(correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 340, 310, 30));

        ciudad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ciudadMouseClicked(evt);
            }
        });
        add(ciudad, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 380, 310, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("PROVEEDOR:");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 110, 20));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setText("RESOLUCIÓN ");
        add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 180, 30));

        resolucionFactura.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                resolucionFacturaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                resolucionFacturaMouseEntered(evt);
            }
        });
        add(resolucionFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 240, 310, 30));

        fechaResolucion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fechaResolucionMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                fechaResolucionMouseEntered(evt);
            }
        });
        add(fechaResolucion, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 240, 310, 30));

        alertaResolucionFacturacion.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        alertaResolucionFacturacion.setForeground(new java.awt.Color(255, 51, 51));
        add(alertaResolucionFacturacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, 610, 30));

        alertaFechaResolucion.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        alertaFechaResolucion.setForeground(new java.awt.Color(255, 51, 51));
        add(alertaFechaResolucion, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 260, 680, 30));

        jLabel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "FORMULARIO REGISTRO DE PROVEEDORES", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 800, 30));

        digitoVerificacion.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        add(digitoVerificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 100, 50, 30));

        personaNatural.setBackground(new java.awt.Color(255, 255, 255));
        personaNatural.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        personaNatural.setText("Persona Natural");
        personaNatural.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                personaNaturalItemStateChanged(evt);
            }
        });
        add(personaNatural, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 150, 150, 30));

        PersonaNatural_apellidosL.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        PersonaNatural_apellidosL.setText("APELLIDOS:");
        add(PersonaNatural_apellidosL, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 100, 30));

        PersonaNatural_apellidos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PersonaNatural_apellidosMouseClicked(evt);
            }
        });
        add(PersonaNatural_apellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 310, 30));

        PersonaNatural_nombres.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PersonaNatural_nombresMouseClicked(evt);
            }
        });
        add(PersonaNatural_nombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 180, 310, 30));

        PersonaNatural_nombresL.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        PersonaNatural_nombresL.setText("NOMBRES:");
        add(PersonaNatural_nombresL, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 180, 90, 30));

        alertaPersonaNatural_Apellidos.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        alertaPersonaNatural_Apellidos.setForeground(new java.awt.Color(255, 51, 51));
        add(alertaPersonaNatural_Apellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 210, 440, 30));

        alertaPersonaNatural_Nombres.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        alertaPersonaNatural_Nombres.setForeground(new java.awt.Color(255, 51, 51));
        add(alertaPersonaNatural_Nombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 210, 470, 30));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setText("DE FACTURA:");
        add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 180, 20));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setText("TIPO ");
        add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 110, 30));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel18.setText("FECHA DE ");
        add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 230, 160, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void registrarProveedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarProveedoresActionPerformed
        if(nit.getText().equals("")){
            alertaNit.setText("Error el Nit no Puede estar vacio");
        }else{
            if(!personaNatural.isSelected()){ //Persona Natural no fue seleccionado debe validar el Nombre del Cliente
                if(nombre.getText().equals("")){
                    alertaNombre.setText("Error el Nombre no Puede estar vacio");
                }else{
                    if(resolucionFactura.getText().equals("")){
                        alertaResolucionFacturacion.setText("Resolucion de factura no puede estar vacia");
                    }else{
                        try{
                            Calendar fecha = fechaResolucion.getCalendar();
                            String ano = ""+fecha.get(Calendar.YEAR);
                            String mes = "";
                            if((fecha.get(Calendar.MONTH) +1) <=9){
                                mes = "0"+(fecha.get(Calendar.MONTH) + 1);
                            }else{
                                mes = ""+(fecha.get(Calendar.MONTH) + 1);
                            }
                            String dia = "";
                            if(fecha.get(Calendar.DAY_OF_MONTH) <=9){
                                dia = "0"+fecha.get(Calendar.DAY_OF_MONTH);
                            }else{
                                dia = ""+fecha.get(Calendar.DAY_OF_MONTH);
                            }
                            String fechaResolucionP=ano+"-"+mes+"-"+dia;
                            try{
                                new java.math.BigDecimal(nit.getText());
                                Integer.parseInt(digitoVerificacion.getText());    
                                Proveedor p = new Proveedor();
                                p.setNit(nit.getText());
                                p.setDigitoVerificacion(digitoVerificacion.getText());                                  
                                p.setNombre(nombre.getText());
                                try{
                                    BigDecimal resoFacturac = new BigDecimal(resolucionFactura.getText());
                                    p.setResolucionFacturacion(resoFacturac.toPlainString());
                                    p.setFechaResolucion(fechaResolucionP);
                                    p.setTipoProveedor_id(controladorTipoProveedor.validarTipoProveedor_ID_por_Nombre(tipoProveedor.getSelectedItem().toString()));
                                    p.setTelefono(telefono.getText());
                                    p.setCelular(celular.getText());
                                    p.setDireccion(direccion.getText());
                                    p.setCorreo(correo.getText());
                                    p.setCiudad(ciudad.getText());
                                    p.setObservacion(observacion.getText());
                                    p.setEstado(controladorOtros.convertidorValorEstado(estado.getSelectedIndex()));
                                    
                                    //buscamos por Nit si ya el proveedor Existe y de ser así consultamos la ultima sucursal
                                    p.setSucursal(ControlDB_Proveedor.consultarConsecutivoSucursal(p));
                                    if(p.getSucursal()!=1){//Ya existe un Proveedor creado con ese Nit por tal motivo procedemos a crear una sucursal
                                        int confirmacion = JOptionPane.showConfirmDialog(null, "Ya existe Un Proveedor creado con ese Nit por tal motivo se procede a crear la sucursal No. "+p.getSucursal());
                                        //Si == 0,  No == 1, Cancelar == 2
                                        if(confirmacion == 0){//Procedemos a registrar la nueva sucursal
                                            int result=0;
                                            result=ControlDB_Proveedor.registrarProveedores(p);
                                            if(result==1){// Registro Exitoso
                                                JOptionPane.showMessageDialog(null, "Registro Exitoso");
                                                nit.setText("");
                                                digitoVerificacion.setText("");
                                                nombre.setText("");
                                                PersonaNatural_apellidos.setText("");
                                                PersonaNatural_nombres.setText("");
                                                resolucionFactura.setText("");
                                                //fechaResolucion.
                                                tipoProveedor.setSelectedIndex(0);
                                                telefono.setText("");
                                                celular.setText("");
                                                direccion.setText("");
                                                correo.setText("");
                                                ciudad.setText("");
                                                observacion.setText("");
                                                estado.setSelectedIndex(0);                                    
                                                alertaNit.setText("");
                                                alertaNombre.setText("");
                                            }else{
                                                JOptionPane.showMessageDialog(null, "No se pudo Registrar el Proveedor Verifique Información Suministrada","Error al registrar", JOptionPane.INFORMATION_MESSAGE);
                                            }
                                        }
                                    }else{//El Nit no se encuentra en la base de datos 
                                        int result=0;
                                        result=ControlDB_Proveedor.registrarProveedores(p);
                                        if(result==1){// Registro Exitoso
                                            JOptionPane.showMessageDialog(null, "Registro Exitoso");
                                            nit.setText("");
                                            digitoVerificacion.setText("");
                                            nombre.setText("");
                                            PersonaNatural_apellidos.setText("");
                                            PersonaNatural_nombres.setText("");
                                            resolucionFactura.setText("");
                                            //fechaResolucion.
                                            tipoProveedor.setSelectedIndex(0);
                                            telefono.setText("");
                                            celular.setText("");
                                            direccion.setText("");
                                            correo.setText("");
                                            ciudad.setText("");
                                            observacion.setText("");
                                            estado.setSelectedIndex(0);                                    
                                            alertaNit.setText("");
                                            alertaNombre.setText("");
                                        }else{
                                            JOptionPane.showMessageDialog(null, "No se pudo Registrar el Proveedor Verifique Información Suministrada","Error al registrar", JOptionPane.INFORMATION_MESSAGE);
                                        } 
                                    }
                                }catch(Exception ex){
                                    alertaResolucionFacturacion.setText("Error La Resolución de Factura debe ser númerica");
                                }
                            }catch(Exception ex){
                                JOptionPane.showMessageDialog(null, "Error verifique Nit, debe ser Númerico");
                            }
                        }catch(Exception e){
                            alertaFechaResolucion.setText("ERROR verifique la fecha");
                        }
                    }
                }
            }else{
                if(personaNatural.isSelected()){ //Persona Natural  fue seleccionado debe validar el Nombre y a pellido de persona Natural
                    if(PersonaNatural_apellidos.getText().equals("")){
                        alertaPersonaNatural_Apellidos.setText("Error los Apellidos no Pueden estar vacio");
                    }else{
                        if(PersonaNatural_nombres.getText().equals("")){
                            alertaPersonaNatural_Nombres.setText("Error el Nombre no Puede estar vacio");
                        }else{
                            if(resolucionFactura.getText().equals("")){
                                alertaResolucionFacturacion.setText("Resolucion de factura no puede estar vacia");
                            }else{
                                try{
                                    Calendar fecha = fechaResolucion.getCalendar();
                                    String ano = ""+fecha.get(Calendar.YEAR);
                                    String mes = "";
                                    if((fecha.get(Calendar.MONTH) +1) <=9){
                                        mes = "0"+(fecha.get(Calendar.MONTH) + 1);
                                    }else{
                                        mes = ""+(fecha.get(Calendar.MONTH) + 1);
                                    }
                                    String dia = "";
                                    if(fecha.get(Calendar.DAY_OF_MONTH) <=9){
                                        dia = "0"+fecha.get(Calendar.DAY_OF_MONTH);
                                    }else{
                                        dia = ""+fecha.get(Calendar.DAY_OF_MONTH);
                                    }
                                    String fechaResolucionP=ano+"-"+mes+"-"+dia;
                                    try{
                                        new java.math.BigDecimal(nit.getText());
                                        Integer.parseInt(digitoVerificacion.getText());    
                                        Proveedor p = new Proveedor();
                                        p.setNit(nit.getText());
                                        p.setDigitoVerificacion(digitoVerificacion.getText());                                  
                                        p.setNombre(""+PersonaNatural_apellidos.getText()+" "+PersonaNatural_nombres.getText());
                                        try{
                                            BigDecimal resoFacturac = new BigDecimal(resolucionFactura.getText());
                                            p.setResolucionFacturacion(resoFacturac.toPlainString());
                                            p.setFechaResolucion(fechaResolucionP);
                                            p.setTipoProveedor_id(controladorTipoProveedor.validarTipoProveedor_ID_por_Nombre(tipoProveedor.getSelectedItem().toString()));
                                            p.setTelefono(telefono.getText());
                                            p.setCelular(celular.getText());
                                            p.setDireccion(direccion.getText());
                                            p.setCorreo(correo.getText());
                                            p.setCiudad(ciudad.getText());
                                            p.setObservacion(observacion.getText());
                                            p.setEstado(controladorOtros.convertidorValorEstado(estado.getSelectedIndex()));

                                            //buscamos por Nit si ya el Proveedor Existe y de ser así consultamos la ultima sucursal
                                            p.setSucursal(ControlDB_Proveedor.consultarConsecutivoSucursal(p));
                                            JOptionPane.showMessageDialog(null, ""+p.getSucursal());
                                            if(p.getSucursal()!=1){//Ya existe un Proveedor creado con ese Nit por tal motivo procedemos a crear una sucursal
                                                int confirmacion = JOptionPane.showConfirmDialog(null, "Ya existe un Proveedor creado con ese Nit por tal motivo se procede a crear la sucursal No. "+p.getSucursal());
                                                //Si == 0,  No == 1, Cancelar == 2
                                                if(confirmacion == 0){//Procedemos a registrar la nueva sucursal
                                                    int result=0;
                                                    result=ControlDB_Proveedor.registrarProveedores(p);
                                                    if(result==1){// Registro Exitoso
                                                        JOptionPane.showMessageDialog(null, "Registro Exitoso");
                                                        nit.setText("");
                                                        digitoVerificacion.setText("");
                                                        nombre.setText("");
                                                        PersonaNatural_apellidos.setText("");
                                                        PersonaNatural_nombres.setText("");
                                                        resolucionFactura.setText("");
                                                        //fechaResolucion.
                                                        tipoProveedor.setSelectedIndex(0);
                                                        telefono.setText("");
                                                        celular.setText("");
                                                        direccion.setText("");
                                                        correo.setText("");
                                                        ciudad.setText("");
                                                        observacion.setText("");
                                                        estado.setSelectedIndex(0);                                    
                                                        alertaNit.setText("");
                                                        alertaNombre.setText("");
                                                    }else{
                                                        JOptionPane.showMessageDialog(null, "No se pudo Registrar el Proveedor Verifique Información Suministrada","Error al registrar", JOptionPane.INFORMATION_MESSAGE);
                                                    }
                                                }
                                            }else{//El Nit no se encuentra en la base de datos
                                                int result=0;
                                                result=ControlDB_Proveedor.registrarProveedores(p);
                                                if(result==1){// Registro Exitoso
                                                    JOptionPane.showMessageDialog(null, "Registro Exitoso");
                                                    nit.setText("");
                                                    digitoVerificacion.setText("");
                                                    nombre.setText("");
                                                    PersonaNatural_apellidos.setText("");
                                                    PersonaNatural_nombres.setText("");
                                                    resolucionFactura.setText("");
                                                    //fechaResolucion.
                                                    tipoProveedor.setSelectedIndex(0);
                                                    telefono.setText("");
                                                    celular.setText("");
                                                    direccion.setText("");
                                                    correo.setText("");
                                                    ciudad.setText("");
                                                    observacion.setText("");
                                                    estado.setSelectedIndex(0);                                    
                                                    alertaNit.setText("");
                                                    alertaNombre.setText("");
                                                }else{
                                                    JOptionPane.showMessageDialog(null, "No se pudo Registrar el Proveedor Verifique Información Suministrada","Error al registrar", JOptionPane.INFORMATION_MESSAGE);
                                                } 
                                            }
                                        }catch(Exception e){
                                            alertaResolucionFacturacion.setText("Error La Resolución de Factura debe ser númerica");
                                        }
                                    }catch(Exception e){
                                        JOptionPane.showMessageDialog(null, "Error verifique Nit, debe ser Númerico");
                                    }
                                }catch(Exception e){
                                    alertaFechaResolucion.setText("ERROR verifique la fecha");
                                }
                            }
                        }
                    }
                }
            }
        }                                          
    }//GEN-LAST:event_registrarProveedoresActionPerformed

    private void observacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_observacionMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_observacionMouseClicked

    private void nitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nitMouseClicked
       alertaNit.setText("");
    }//GEN-LAST:event_nitMouseClicked

    private void nombreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nombreMouseClicked
        alertaNombre.setText("");
    }//GEN-LAST:event_nombreMouseClicked

    private void telefonoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_telefonoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_telefonoMouseClicked

    private void celularMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_celularMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_celularMouseClicked

    private void direccionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_direccionMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_direccionMouseClicked

    private void correoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_correoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_correoMouseClicked

    private void ciudadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ciudadMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_ciudadMouseClicked

    private void resolucionFacturaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resolucionFacturaMouseClicked
       alertaResolucionFacturacion.setText("");
    }//GEN-LAST:event_resolucionFacturaMouseClicked

    private void nitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nitMouseEntered
        alertaNit.setText("");
    }//GEN-LAST:event_nitMouseEntered

    private void nombreMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nombreMouseEntered
        alertaNombre.setText("");
    }//GEN-LAST:event_nombreMouseEntered

    private void resolucionFacturaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resolucionFacturaMouseEntered
       alertaResolucionFacturacion.setText("");
    }//GEN-LAST:event_resolucionFacturaMouseEntered

    private void fechaResolucionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fechaResolucionMouseClicked
        alertaFechaResolucion.setText("");
    }//GEN-LAST:event_fechaResolucionMouseClicked

    private void fechaResolucionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fechaResolucionMouseEntered
         alertaFechaResolucion.setText("");
    }//GEN-LAST:event_fechaResolucionMouseEntered

    private void registrarProveedoresMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registrarProveedoresMouseExited
        alertaFechaResolucion.setText("");
    }//GEN-LAST:event_registrarProveedoresMouseExited

    private void personaNaturalItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_personaNaturalItemStateChanged
        if(personaNatural.isSelected()){
            nombre.setEnabled(false);
            PersonaNatural_apellidos.setEnabled(true);
            PersonaNatural_nombres.setEnabled(true);
        }else{
            nombre.setEnabled(true);
            PersonaNatural_apellidos.setEnabled(false);
            PersonaNatural_nombres.setEnabled(false);
        }
    }//GEN-LAST:event_personaNaturalItemStateChanged

    private void PersonaNatural_apellidosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PersonaNatural_apellidosMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_PersonaNatural_apellidosMouseClicked

    private void PersonaNatural_nombresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PersonaNatural_nombresMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_PersonaNatural_nombresMouseClicked

    private void nitKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nitKeyPressed
        alertaNit.setText("");
        try{
            if(nit.getText().equals("")){//El nit está vacio
            }else{
                //Procedemos a validar si es un número entero
                try{
                    new java.math.BigDecimal(nit.getText());
                    String nitS = nit.getText();
                    long nitL = Long.parseLong(nitS);
                    CalcularDigitoVerificacion calDV = new CalcularDigitoVerificacion();
                    digitoVerificacion.setText(""+calDV.generarDv(nitL));
                }catch(Exception e){
                    alertaNit.setText("El Nit debe ser númerico");
                }
            }
        }catch(Exception e){

        }
    }//GEN-LAST:event_nitKeyPressed

    private void nitKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nitKeyReleased
        alertaNit.setText("");
        try{
            if(nit.getText().equals("")){//El nit está vacio

            }else{
                //Procedemos a validar si es un número entero
                try{
                    new java.math.BigDecimal(nit.getText());
                    String nitS = nit.getText();
                    long nitL = Long.parseLong(nitS);
                    CalcularDigitoVerificacion calDV = new CalcularDigitoVerificacion();
                    digitoVerificacion.setText(""+calDV.generarDv(nitL));
                }catch(Exception e){
                    alertaNit.setText("El Nit debe ser númerico");
                }
            }
        }catch(Exception e){

        }
    }//GEN-LAST:event_nitKeyReleased

    private void nitKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nitKeyTyped
        alertaNit.setText("");
        try{
            if(nit.getText().equals("")){//El nit está vacio

            }else{
                //Procedemos a validar si es un número entero
                try{
                    new java.math.BigDecimal(nit.getText());
                    String nitS = nit.getText();
                    long nitL = Long.parseLong(nitS);
                    CalcularDigitoVerificacion calDV = new CalcularDigitoVerificacion();
                    digitoVerificacion.setText(""+calDV.generarDv(nitL));
                }catch(Exception e){
                    alertaNit.setText("El Nit debe ser númerico");
                }
            }
        }catch(Exception e){

        }
    }//GEN-LAST:event_nitKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField PersonaNatural_apellidos;
    private javax.swing.JLabel PersonaNatural_apellidosL;
    private javax.swing.JTextField PersonaNatural_nombres;
    private javax.swing.JLabel PersonaNatural_nombresL;
    private javax.swing.JLabel alertaFechaResolucion;
    private javax.swing.JLabel alertaNit;
    private javax.swing.JLabel alertaNombre;
    private javax.swing.JLabel alertaPersonaNatural_Apellidos;
    private javax.swing.JLabel alertaPersonaNatural_Nombres;
    private javax.swing.JLabel alertaResolucionFacturacion;
    private javax.swing.JTextField celular;
    private javax.swing.JTextField ciudad;
    private javax.swing.JTextField correo;
    private javax.swing.JLabel digitoVerificacion;
    private javax.swing.JTextField direccion;
    private javax.swing.JComboBox<String> estado;
    private com.toedter.calendar.JDateChooser fechaResolucion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField nit;
    private javax.swing.JTextField nombre;
    private javax.swing.JTextField observacion;
    private javax.swing.JCheckBox personaNatural;
    private javax.swing.JButton registrarProveedores;
    private javax.swing.JTextField resolucionFactura;
    private javax.swing.JTextField telefono;
    private javax.swing.JComboBox<String> tipoProveedor;
    // End of variables declaration//GEN-END:variables
}
