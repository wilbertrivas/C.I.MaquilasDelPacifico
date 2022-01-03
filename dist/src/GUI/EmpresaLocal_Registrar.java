package GUI;

import Controladores.ControlDB_EmpresaLocal;
import Controladores.ControlDB_Otros;
import Controladores.ControlDB_TipoEmpresaLocal;
import Modelos.EmpresaLocal;
import Modelos.TipoEmpresaLocal;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class EmpresaLocal_Registrar extends javax.swing.JPanel {
    Controladores.ControlDB_EmpresaLocal controladorEmpresaLocal = new ControlDB_EmpresaLocal();
    Controladores.ControlDB_TipoEmpresaLocal controladorTipoEmpresaLocal = new ControlDB_TipoEmpresaLocal();
 
    public EmpresaLocal_Registrar() {
        initComponents(); 
        PersonaNatural_apellidos.setEnabled(false);
        PersonaNatural_nombres.setEnabled(false); 
        //Cargamos en la interfaz los tipo de Cliente
        ArrayList<TipoEmpresaLocal> listadoTipoEmpresaLocal = new ArrayList();
        listadoTipoEmpresaLocal=controladorTipoEmpresaLocal.cargarTipoEmpresaLocal();
        for(int i=0; i< listadoTipoEmpresaLocal.size(); i++){
            tipoEmpresaLocal.addItem(listadoTipoEmpresaLocal.get(i).getDescripcion());
        }
    }
    public void Cliente_RegistrarZ() {
        initComponents();  
        //Cargamos en la interfaz los tipo de Cliente
        ArrayList<TipoEmpresaLocal> listadoTipoEmpresaLocal = new ArrayList();
        listadoTipoEmpresaLocal=controladorTipoEmpresaLocal.cargarTipoEmpresaLocal();
        for(int i=0; i< listadoTipoEmpresaLocal.size(); i++){
            tipoEmpresaLocal.addItem(listadoTipoEmpresaLocal.get(i).getDescripcion());
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        estado = new javax.swing.JComboBox<>();
        registrarEmpresaLocal = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        tipoEmpresaLocal = new javax.swing.JComboBox<>();
        alertaNit = new javax.swing.JLabel();
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
        jLabel4 = new javax.swing.JLabel();
        digitoVerificacion = new javax.swing.JLabel();
        nombreL = new javax.swing.JLabel();
        personaNatural = new javax.swing.JCheckBox();
        PersonaNatural_apellidosL = new javax.swing.JLabel();
        PersonaNatural_apellidos = new javax.swing.JTextField();
        PersonaNatural_nombres = new javax.swing.JTextField();
        PersonaNatural_nombresL = new javax.swing.JLabel();
        alertaPersonaNatural_Apellidos = new javax.swing.JLabel();
        alertaPersonaNatural_Nombres = new javax.swing.JLabel();
        nombreL1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("-");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 90, 10, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("CELULAR:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 120, 30));

        estado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo", "Inactivo" }));
        add(estado, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 370, 320, 40));

        registrarEmpresaLocal.setBackground(new java.awt.Color(255, 255, 255));
        registrarEmpresaLocal.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        registrarEmpresaLocal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/Bodega_Registrar_Bton_Registrar.PNG"))); // NOI18N
        registrarEmpresaLocal.setText("REGISTRAR");
        registrarEmpresaLocal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarEmpresaLocalActionPerformed(evt);
            }
        });
        add(registrarEmpresaLocal, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 420, 140, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("TIPO EMPRESA LOCAL:");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 190, 20));

        add(tipoEmpresaLocal, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, 330, 40));

        alertaNit.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        alertaNit.setForeground(new java.awt.Color(255, 51, 51));
        add(alertaNit, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, 440, 30));

        observacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                observacionMouseClicked(evt);
            }
        });
        add(observacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 330, 210, 30));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("NIT:");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 40, 30));

        nit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nitMouseClicked(evt);
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
        add(nit, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, 140, 30));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("CORREO:");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, 70, 30));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("TELEFONO:");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 250, 70, 30));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("ESTADO:");
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, 120, 30));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("DIRECCION:");
        add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 290, 80, 30));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("CIUDAD:");
        add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 330, 70, 30));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setText("OBSERVACION:");
        add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, 120, 30));

        alertaNombre.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        alertaNombre.setForeground(new java.awt.Color(255, 51, 51));
        add(alertaNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 120, 450, 30));

        nombre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nombreMouseClicked(evt);
            }
        });
        add(nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 90, 320, 30));

        telefono.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                telefonoMouseClicked(evt);
            }
        });
        add(telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 250, 310, 30));

        celular.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                celularMouseClicked(evt);
            }
        });
        add(celular, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 250, 210, 30));

        direccion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                direccionMouseClicked(evt);
            }
        });
        add(direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 290, 310, 30));

        correo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                correoMouseClicked(evt);
            }
        });
        add(correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 290, 210, 30));

        ciudad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ciudadMouseClicked(evt);
            }
        });
        add(ciudad, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 330, 310, 30));

        jLabel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "FORMULARIO REGISTRO DE EMPRESALOCAL", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 800, 20));

        digitoVerificacion.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        add(digitoVerificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 90, 50, 30));

        nombreL.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nombreL.setText("EMPRESA LOCAL:");
        add(nombreL, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 100, 160, 40));

        personaNatural.setBackground(new java.awt.Color(255, 255, 255));
        personaNatural.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        personaNatural.setText("Persona Natural");
        personaNatural.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                personaNaturalItemStateChanged(evt);
            }
        });
        add(personaNatural, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, -1, 30));

        PersonaNatural_apellidosL.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        PersonaNatural_apellidosL.setText("APELLIDOS:");
        add(PersonaNatural_apellidosL, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 90, 30));

        PersonaNatural_apellidos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PersonaNatural_apellidosMouseClicked(evt);
            }
        });
        add(PersonaNatural_apellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 190, 280, 30));

        PersonaNatural_nombres.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PersonaNatural_nombresMouseClicked(evt);
            }
        });
        add(PersonaNatural_nombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 190, 310, 30));

        PersonaNatural_nombresL.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        PersonaNatural_nombresL.setText("NOMBRES:");
        add(PersonaNatural_nombresL, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 190, 90, 30));

        alertaPersonaNatural_Apellidos.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        alertaPersonaNatural_Apellidos.setForeground(new java.awt.Color(255, 51, 51));
        add(alertaPersonaNatural_Apellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 220, 440, 30));

        alertaPersonaNatural_Nombres.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        alertaPersonaNatural_Nombres.setForeground(new java.awt.Color(255, 51, 51));
        add(alertaPersonaNatural_Nombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 220, 470, 30));

        nombreL1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nombreL1.setText("NOMBRE DE LA");
        add(nombreL1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 90, 160, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void registrarEmpresaLocalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarEmpresaLocalActionPerformed
        if(nit.getText().equals("")){
            alertaNit.setText("Error el Nit no Puede estar vacio");
        }else{
            if(!personaNatural.isSelected()){ //Persona Natural no fue seleccionado debe validar el Nombre del Cliente
                if(nombre.getText().equals("")){
                    alertaNombre.setText("Error el Nombre no Puede estar vacio");
                }else{
                    try{
                        new java.math.BigDecimal(nit.getText());
                        Integer.parseInt(digitoVerificacion.getText());
                        EmpresaLocal empresaLocal = new EmpresaLocal();
                        empresaLocal.setNit(nit.getText());
                        empresaLocal.setDigitoVerificacion(digitoVerificacion.getText());
                        empresaLocal.setNombre(nombre.getText());
                        empresaLocal.setTipoEmpresaLocal_id(controladorTipoEmpresaLocal.validarTipoEmpresaLocal_ID_por_Nombre(tipoEmpresaLocal.getSelectedItem().toString()));
                        empresaLocal.setTelefono(telefono.getText());
                        empresaLocal.setCelular(celular.getText());
                        empresaLocal.setDireccion(direccion.getText());
                        empresaLocal.setCorreo(correo.getText());
                        empresaLocal.setCiudad(ciudad.getText());
                        empresaLocal.setObservacion(observacion.getText());
                        ControlDB_Otros validador = new ControlDB_Otros();
                        empresaLocal.setEstado(validador.convertidorValorEstado(estado.getSelectedIndex()));
                         //buscamos por Nit si ya la empresa Existe y de ser así consultamos la ultima sucursal
                        empresaLocal.setSucursal(controladorEmpresaLocal.consultarConsecutivoSucursal(empresaLocal));
                        if(empresaLocal.getSucursal()!=1){//Ya existe una empresa Local creada con ese Nit por tal motivo procedemos a crear una sucursal
                            int confirmacion = JOptionPane.showConfirmDialog(null, "Ya existe una Empresa Local creada con ese Nit por tal motivo se procede a crear una sucursal No. "+empresaLocal.getSucursal());
                            //Si == 0,  No == 1, Cancelar == 2
                            if(confirmacion == 0){//Procedemos a registrar la nueva sucursal
                                int result=0;
                                result=controladorEmpresaLocal.registrarEmpresaLocal(empresaLocal);
                                if(result==1){// Registro Exitoso
                                    JOptionPane.showMessageDialog(null, "Registro Exitoso");
                                    nit.setText("");
                                    digitoVerificacion.setText("");
                                    nombre.setText("");
                                    PersonaNatural_apellidos.setText("");
                                    PersonaNatural_nombres.setText(""); 
                                    tipoEmpresaLocal.setSelectedIndex(0);
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
                                    JOptionPane.showMessageDialog(null, "No se pudo Registrar la empresa Local Verifique Información Suministrada","Error al registrar", JOptionPane.INFORMATION_MESSAGE);
                                }
                            }

                        }else{//El Nit no se encuentra en la base de datos 
                            int result=0;
                            result=controladorEmpresaLocal.registrarEmpresaLocal(empresaLocal);
                            if(result==1){// Registro Exitoso
                                JOptionPane.showMessageDialog(null, "Registro Exitoso");
                                nit.setText("");
                                digitoVerificacion.setText("");
                                nombre.setText("");
                                PersonaNatural_apellidos.setText("");
                                PersonaNatural_nombres.setText("");
                                tipoEmpresaLocal.setSelectedIndex(0);
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
                                JOptionPane.showMessageDialog(null, "No se pudo Registrar la empresa local Verifique Información Suministrada","Error al registrar", JOptionPane.INFORMATION_MESSAGE);
                            } 
                        }
                    }catch(Exception e){
                        JOptionPane.showMessageDialog(null, "Error verifique Nit, debe ser Númerico");
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
                            try{
                                new java.math.BigDecimal(nit.getText());
                                Integer.parseInt(digitoVerificacion.getText());
                                EmpresaLocal empresaLocal = new EmpresaLocal();
                                empresaLocal.setNit(nit.getText());
                                empresaLocal.setDigitoVerificacion(digitoVerificacion.getText());
                                empresaLocal.setNombre(""+PersonaNatural_apellidos.getText()+" "+PersonaNatural_nombres.getText());
                                empresaLocal.setTipoEmpresaLocal_id(controladorTipoEmpresaLocal.validarTipoEmpresaLocal_ID_por_Nombre(tipoEmpresaLocal.getSelectedItem().toString()));
                                empresaLocal.setTelefono(telefono.getText());
                                empresaLocal.setCelular(celular.getText());
                                empresaLocal.setDireccion(direccion.getText());
                                empresaLocal.setCorreo(correo.getText());
                                empresaLocal.setCiudad(ciudad.getText());
                                empresaLocal.setObservacion(observacion.getText());
                                ControlDB_Otros validador = new ControlDB_Otros();
                                empresaLocal.setEstado(validador.convertidorValorEstado(estado.getSelectedIndex()));
                                 //buscamos por Nit si ya la empresa Existe y de ser así consultamos la ultima sucursal
                                empresaLocal.setSucursal(controladorEmpresaLocal.consultarConsecutivoSucursal(empresaLocal));
                                JOptionPane.showMessageDialog(null, ""+empresaLocal.getSucursal());
                                if(empresaLocal.getSucursal()!=1){//Ya existe una empresa local con ese Nit por tal motivo procedemos a crear una sucursal
                                    int confirmacion = JOptionPane.showConfirmDialog(null, "Ya existe una empresa Local Creada con ese Nit por tal motivo se procede a crear la sucursal No. "+empresaLocal.getSucursal());
                                    //Si == 0,  No == 1, Cancelar == 2
                                    if(confirmacion == 0){//Procedemos a registrar la nueva sucursal
                                        int result=0;
                                        result=controladorEmpresaLocal.registrarEmpresaLocal(empresaLocal);
                                        if(result==1){// Registro Exitoso
                                            JOptionPane.showMessageDialog(null, "Registro Exitoso");
                                            nit.setText("");
                                            digitoVerificacion.setText("");
                                            nombre.setText("");
                                            PersonaNatural_apellidos.setText("");
                                            PersonaNatural_nombres.setText("");
                                            tipoEmpresaLocal.setSelectedIndex(0);
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
                                            JOptionPane.showMessageDialog(null, "No se pudo Registrar el Cliente Verifique Información Suministrada","Error al registrar", JOptionPane.INFORMATION_MESSAGE);
                                        }
                                    }
                                }else{//El Nit no se encuentra en la base de datos
                                    int result=0;
                                    result=controladorEmpresaLocal.registrarEmpresaLocal(empresaLocal);
                                    if(result==1){// Registro Exitoso
                                        JOptionPane.showMessageDialog(null, "Registro Exitoso");
                                        nit.setText("");
                                        digitoVerificacion.setText("");
                                        PersonaNatural_apellidos.setText("");
                                        PersonaNatural_nombres.setText("");                                       
                                        nombre.setText("");
                                        tipoEmpresaLocal.setSelectedIndex(0);
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
                                        JOptionPane.showMessageDialog(null, "No se pudo Registrar la Empresa Local Verifique Información Suministrada","Error al registrar", JOptionPane.INFORMATION_MESSAGE);
                                    } 
                                }
                            }catch(Exception e){
                                JOptionPane.showMessageDialog(null, "Error verifique Nit, debe ser Númerico");
                            }
                        }      
                    }   
                }
            }
        }   
    }//GEN-LAST:event_registrarEmpresaLocalActionPerformed

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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField PersonaNatural_apellidos;
    private javax.swing.JLabel PersonaNatural_apellidosL;
    private javax.swing.JTextField PersonaNatural_nombres;
    private javax.swing.JLabel PersonaNatural_nombresL;
    private javax.swing.JLabel alertaNit;
    private javax.swing.JLabel alertaNombre;
    private javax.swing.JLabel alertaPersonaNatural_Apellidos;
    private javax.swing.JLabel alertaPersonaNatural_Nombres;
    private javax.swing.JTextField celular;
    private javax.swing.JTextField ciudad;
    private javax.swing.JTextField correo;
    private javax.swing.JLabel digitoVerificacion;
    private javax.swing.JTextField direccion;
    private javax.swing.JComboBox<String> estado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField nit;
    private javax.swing.JTextField nombre;
    private javax.swing.JLabel nombreL;
    private javax.swing.JLabel nombreL1;
    private javax.swing.JTextField observacion;
    private javax.swing.JCheckBox personaNatural;
    private javax.swing.JButton registrarEmpresaLocal;
    private javax.swing.JTextField telefono;
    private javax.swing.JComboBox<String> tipoEmpresaLocal;
    // End of variables declaration//GEN-END:variables
}
