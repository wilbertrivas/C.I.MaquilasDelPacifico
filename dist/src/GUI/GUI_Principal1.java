
package GUI;

import Controladores.ControlDB_PermisoUsuario;
import Modelos.Usuario;
import java.awt.Color;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
public class GUI_Principal1 extends javax.swing.JFrame {

    Usuario user;
    public GUI_Principal1() {
        initComponents();
        this.setLocationRelativeTo(null);
        ObtenerFecha c = new ObtenerFecha();
        fecha.setText("Fecha-Hora Ingreso al Sistema: "+c.getNTPDate()); 
        user= new Usuario(); 
        user.setUser("");
        this.getContentPane().setBackground(Color.WHITE);
    }
    public void cargarUsuario(Usuario userT) throws ParseException{
        user = userT;  
        userOnline.setText("Usuario: "+ user.getUser());
        nombreUsuarioEnLinea.setText(("Nombre: "+ user.getNombre()+" "+ user.getApellido()));              
    }
    public void cargaMenu(){
        ControlDB_PermisoUsuario  controlDB_PermisoUsuario = new ControlDB_PermisoUsuario();
        try{
            //validamos Permiso cliente_registrar
            int retornoPermiso_cliente_registrar=controlDB_PermisoUsuario.retornarEstadoPermisoUsuario(user,"cliente_registrar");
            if(retornoPermiso_cliente_registrar != 1){
                cliente_registrar.show(false);
            }           
            //validamos Permiso cliente_consultar
            int retornoPermiso_cliente_consultar=controlDB_PermisoUsuario.retornarEstadoPermisoUsuario(user,"cliente_consultar");
            if(retornoPermiso_cliente_consultar != 1){
                cliente_consultar.show(false);
            }
            
            //validamos Permiso cliente_actualizar
            int retornoPermiso_cliente_actualizar=controlDB_PermisoUsuario.retornarEstadoPermisoUsuario(user,"cliente_actualizar");
            if(retornoPermiso_cliente_actualizar != 1){
                cliente_actualizar.show(false);
            }
            
            //validamos Permiso proveedor_registrar
            int retornoPermiso_proveedor_registrar=controlDB_PermisoUsuario.retornarEstadoPermisoUsuario(user,"proveedor_registrar");
            if(retornoPermiso_proveedor_registrar != 1){
                proveedor_registrar.show(false);
            }
            
            //validamos Permiso proveedor_consultar
            int retornoPermiso_proveedor_consultar=controlDB_PermisoUsuario.retornarEstadoPermisoUsuario(user,"proveedor_consultar");
            if(retornoPermiso_proveedor_consultar != 1){
                proveedor_consultar.show(false);
            }
            
            //validamos Permiso proveedor_actualizar
            int retornoPermiso_proveedor_actualizar=controlDB_PermisoUsuario.retornarEstadoPermisoUsuario(user,"proveedor_actualizar");
            if(retornoPermiso_proveedor_actualizar != 1){
                proveedor_actualizar.show(false);
            }
            
            //validamos Permiso compra_registrar
            int retornoPermiso_compra_registrar=controlDB_PermisoUsuario.retornarEstadoPermisoUsuario(user,"compra_registrar");
            if(retornoPermiso_compra_registrar != 1){
                compra_registrar.show(false);
            }
            
            //validamos Permiso compra_consultar
            int retornoPermiso_compra_consultar=controlDB_PermisoUsuario.retornarEstadoPermisoUsuario(user,"compra_consultar");
            if(retornoPermiso_compra_consultar != 1){
                compra_consultar.show(false);
            }
            
            //validamos Permiso compra_anular
            int retornoPermiso_compra_anular=controlDB_PermisoUsuario.retornarEstadoPermisoUsuario(user,"compra_anular");
            if(retornoPermiso_compra_anular != 1){
                compra_anular.show(false);
            }
            //validamos Permiso compra_eliminar
            int retornoPermiso_compra_eliminar=controlDB_PermisoUsuario.retornarEstadoPermisoUsuario(user,"compra_eliminar");
            if(retornoPermiso_compra_eliminar != 1){
                compra_eliminar.show(false);
            }
            //validamos Permiso compra_editar
            int retornoPermiso_compra_editar=controlDB_PermisoUsuario.retornarEstadoPermisoUsuario(user,"compra_editar");
            if(retornoPermiso_compra_editar != 1){
                compra_editar.show(false);
            }
            
            //validamos Permiso venta_extranjera_registrar
            int retornoPermiso_venta_extranjera_registrar=controlDB_PermisoUsuario.retornarEstadoPermisoUsuario(user,"venta_extranjera_registrar");
            if(retornoPermiso_venta_extranjera_registrar != 1){
                venta_extranjera_registrar.show(false);
            }
            
            //validamos Permiso venta_extranjera_editar
            int retornoPermiso_venta_extranjera_editar=controlDB_PermisoUsuario.retornarEstadoPermisoUsuario(user,"venta_extranjera_editar");
            if(retornoPermiso_venta_extranjera_editar != 1){
                venta_extranjera_editar.show(false);
            }
            
            //validamos Permiso venta_nacional_registrar
            int retornoPermiso_venta_nacional_registrar=controlDB_PermisoUsuario.retornarEstadoPermisoUsuario(user,"venta_nacional_registrar");
            if(retornoPermiso_venta_nacional_registrar != 1){
                venta_nacional_registrar.show(false);
            }
            
            //validamos Permiso venta_nacional_editar
            int retornoPermiso_venta_nacional_editar=controlDB_PermisoUsuario.retornarEstadoPermisoUsuario(user,"venta_nacional_editar");
            if(retornoPermiso_venta_nacional_editar != 1){
                venta_nacional_editar.show(false);
            }
            
            //validamos Permiso venta_consultar
            int retornoPermiso_venta_consultar=controlDB_PermisoUsuario.retornarEstadoPermisoUsuario(user,"venta_consultar");
            if(retornoPermiso_venta_consultar != 1){
                venta_consultar.show(false);
            }
            
            //validamos Permiso venta_anular
            int retornoPermiso_venta_anular=controlDB_PermisoUsuario.retornarEstadoPermisoUsuario(user,"venta_anular");
            if(retornoPermiso_venta_anular != 1){
                venta_anular.show(false);
            }
            
            //validamos Permiso venta_modificar_dex
            int retornoPermiso_venta_modificar_dex=controlDB_PermisoUsuario.retornarEstadoPermisoUsuario(user,"venta_modificar_dex");
            if(retornoPermiso_venta_modificar_dex != 1){
                venta_modificar_dex.show(false);
            }
            
            //··················································································
                 //validamos Permiso ventaElectronica_extranjera_registrar
            int retornoPermiso_ventaElectronica_extranjera_registrar=controlDB_PermisoUsuario.retornarEstadoPermisoUsuario(user,"ventaElectronica_extranjera_registrar");
            if(retornoPermiso_ventaElectronica_extranjera_registrar != 1){
                ventaElectronica_extranjera_registrar.show(false);
            }
            
            //validamos Permiso ventaElectronica_extranjera_editar
            int retornoPermiso_ventaElectronica_extranjera_editar=controlDB_PermisoUsuario.retornarEstadoPermisoUsuario(user,"ventaElectronica_extranjera_editar");
            if(retornoPermiso_ventaElectronica_extranjera_editar != 1){
                ventaElectronica_extranjera_editar.show(false);
            }
            
            //validamos Permiso ventaElectronica_nacional_registrar
            int retornoPermiso_ventaElectronica_nacional_registrar=controlDB_PermisoUsuario.retornarEstadoPermisoUsuario(user,"ventaElectronica_nacional_registrar");
            if(retornoPermiso_ventaElectronica_nacional_registrar != 1){
                ventaElectronica_nacional_registrar.show(false);
            }
            
            //validamos Permiso ventaElectronica_nacional_editar
            int retornoPermiso_ventaElectronica_nacional_editar=controlDB_PermisoUsuario.retornarEstadoPermisoUsuario(user,"ventaElectronica_nacional_editar");
            if(retornoPermiso_ventaElectronica_nacional_editar != 1){
                ventaElectronica_nacional_editar.show(false);
            }
            
            //validamos Permiso ventaElectronica_consultar
            int retornoPermiso_ventaElectronica_consultar=controlDB_PermisoUsuario.retornarEstadoPermisoUsuario(user,"ventaElectronica_consultar");
            if(retornoPermiso_ventaElectronica_consultar != 1){
                ventaElectronica_consultar.show(false);
            }
            
            //validamos Permiso ventaElectronica_anular
            int retornoPermiso_ventaElectronica_anular=controlDB_PermisoUsuario.retornarEstadoPermisoUsuario(user,"ventaElectronica_anular");
            if(retornoPermiso_ventaElectronica_anular != 1){
                ventaElectronica_anular.show(false);
            }
            
            //validamos Permiso ventaElectronica_modificar_dex
            int retornoPermiso_ventaElectronica_modificar_dex=controlDB_PermisoUsuario.retornarEstadoPermisoUsuario(user,"ventaElectronica_modificar_dex");
            if(retornoPermiso_ventaElectronica_modificar_dex != 1){
                ventaElectronica_modificar_dex.show(false);
            }
            
            //··················································································
             //··················································································
                 //validamos Permiso ventaPapel_extranjera_registrar
            int retornoPermiso_ventaPapel_extranjera_registrar=controlDB_PermisoUsuario.retornarEstadoPermisoUsuario(user,"ventaPapel_extranjera_registrar");
            if(retornoPermiso_ventaPapel_extranjera_registrar != 1){
                ventaPapel_extranjera_registrar.show(false);
            }
            
            //validamos Permiso ventaPapel_extranjera_editar
            int retornoPermiso_ventaPapel_extranjera_editar=controlDB_PermisoUsuario.retornarEstadoPermisoUsuario(user,"ventaPapel_extranjera_editar");
            if(retornoPermiso_ventaPapel_extranjera_editar != 1){
                ventaPapel_extranjera_editar.show(false);
            }
            
            //validamos Permiso ventaPapel_nacional_registrar
            int retornoPermiso_ventaPapel_nacional_registrar=controlDB_PermisoUsuario.retornarEstadoPermisoUsuario(user,"ventaPapel_nacional_registrar");
            if(retornoPermiso_ventaPapel_nacional_registrar != 1){
                ventaPapel_nacional_registrar.show(false);
            }
            
            //validamos Permiso ventaPapel_nacional_editar
            int retornoPermiso_ventaPapel_nacional_editar=controlDB_PermisoUsuario.retornarEstadoPermisoUsuario(user,"ventaPapel_nacional_editar");
            if(retornoPermiso_ventaPapel_nacional_editar != 1){
                ventaPapel_nacional_editar.show(false);
            }
            
            //validamos Permiso ventaPapel_consultar
            int retornoPermiso_ventaPapel_consultar=controlDB_PermisoUsuario.retornarEstadoPermisoUsuario(user,"ventaPapel_consultar");
            if(retornoPermiso_ventaPapel_consultar != 1){
                ventaPapel_consultar.show(false);
            }
            
            //validamos Permiso ventaPapel_anular
            int retornoPermiso_ventaPapel_anular=controlDB_PermisoUsuario.retornarEstadoPermisoUsuario(user,"ventaPapel_anular");
            if(retornoPermiso_ventaPapel_anular != 1){
                ventaPapel_anular.show(false);
            }
            
            //validamos Permiso ventaPapel_modificar_dex
            int retornoPermiso_ventaPapel_modificar_dex=controlDB_PermisoUsuario.retornarEstadoPermisoUsuario(user,"ventaPapel_modificar_dex");
            if(retornoPermiso_ventaPapel_modificar_dex != 1){
                ventaPapel_modificar_dex.show(false);
            }
            
            //··················································································
            
            
            //validamos Permiso movimiento_camarones_registrar
            int retornoPermiso_movimiento_camarones_registrar=controlDB_PermisoUsuario.retornarEstadoPermisoUsuario(user,"movimiento_camarones_registrar");
            if(retornoPermiso_movimiento_camarones_registrar != 1){
                movimiento_camarones_registrar.show(false);
            }
            
            //validamos Permiso movimiento_camarones_editar
            int retornoPermiso_movimiento_camarones_editar=controlDB_PermisoUsuario.retornarEstadoPermisoUsuario(user,"movimiento_camarones_editar");
            if(retornoPermiso_movimiento_camarones_editar != 1){
                movimiento_camarones_editar.show(false);
            }
            
            //validamos Permiso movimiento_carton_registrar
            int retornoPermiso_movimiento_carton_registrar=controlDB_PermisoUsuario.retornarEstadoPermisoUsuario(user,"movimiento_carton_registrar");
            if(retornoPermiso_movimiento_carton_registrar != 1){
                movimiento_carton_registrar.show(false);
            }
           
            //validamos Permiso movimiento_carton_editar
            int retornoPermiso_movimiento_carton_editar=controlDB_PermisoUsuario.retornarEstadoPermisoUsuario(user,"movimiento_carton_editar");
            if(retornoPermiso_movimiento_carton_editar != 1){
                movimiento_carton_editar.show(false);
            }
            
            //validamos Permiso movimiento_consultar
            int retornoPermiso_movimiento_consultar=controlDB_PermisoUsuario.retornarEstadoPermisoUsuario(user,"movimiento_consultar");
            if(retornoPermiso_movimiento_consultar != 1){
                movimiento_consultar.show(false);
            }
            
            //validamos Permiso movimiento_anular
            int retornoPermiso_movimiento_anular=controlDB_PermisoUsuario.retornarEstadoPermisoUsuario(user,"movimiento_anular");
            if(retornoPermiso_movimiento_anular != 1){
                movimiento_anular.show(false);
            }
            
            //validamos Permiso consumo_camarones_registrar
            int retornoPermiso_consumo_camarones_registrar=controlDB_PermisoUsuario.retornarEstadoPermisoUsuario(user,"consumo_camarones_registrar");
            if(retornoPermiso_consumo_camarones_registrar != 1){
                consumo_camarones_registrar.show(false);
            }
            
            //validamos Permiso consumo_camarones_editar
            int retornoPermiso_consumo_camarones_editar=controlDB_PermisoUsuario.retornarEstadoPermisoUsuario(user,"consumo_camarones_editar");
            if(retornoPermiso_consumo_camarones_editar != 1){
                consumo_camarones_editar.show(false);
            }
            
            //validamos Permiso consumo_carton_registrar
            int retornoPermiso_consumo_carton_registrar=controlDB_PermisoUsuario.retornarEstadoPermisoUsuario(user,"consumo_carton_registrar");
            if(retornoPermiso_consumo_carton_registrar != 1){
                consumo_carton_registrar.show(false);
            }
            
            //validamos Permiso consumo_carton_editar
            int retornoPermiso_consumo_carton_editar=controlDB_PermisoUsuario.retornarEstadoPermisoUsuario(user,"consumo_carton_editar");
            if(retornoPermiso_consumo_carton_editar != 1){
                consumo_carton_editar.show(false);
            }
            
            //validamos Permiso consumo_consultar
            int retornoPermiso_consumo_consultar=controlDB_PermisoUsuario.retornarEstadoPermisoUsuario(user,"consumo_consultar");
            if(retornoPermiso_consumo_consultar != 1){
                consumo_consultar.show(false);
            }
            
            //validamos Permiso consumo_anular
            int retornoPermiso_consumo_anular=controlDB_PermisoUsuario.retornarEstadoPermisoUsuario(user,"consumo_anular");
            if(retornoPermiso_consumo_anular != 1){
                consumo_anular.show(false);
            }
            
            //validamos Permiso informe_anual_crear
            int retornoPermiso_informe_anual_crear=controlDB_PermisoUsuario.retornarEstadoPermisoUsuario(user,"informe_anual_crear");
            if(retornoPermiso_informe_anual_crear != 1){
                informe_anual_crear.show(false);
            }
            
            //validamos Permiso auditoria_consultar
            int retornoPermiso_auditoria_consultar=controlDB_PermisoUsuario.retornarEstadoPermisoUsuario(user,"auditoria_consultar");
            if(retornoPermiso_auditoria_consultar != 1){
                auditoria_consultar.show(false);
            }
            
            //validamos Permiso usuario_registrar
            int retornoPermiso_usuario_registrar=controlDB_PermisoUsuario.retornarEstadoPermisoUsuario(user,"usuario_registrar");
            if(retornoPermiso_usuario_registrar != 1){
                usuario_registrar.show(false);
            }
            
            //validamos Permiso usuario_consultar
            int retornoPermiso_usuario_consultar=controlDB_PermisoUsuario.retornarEstadoPermisoUsuario(user,"usuario_consultar");
            if(retornoPermiso_usuario_consultar != 1){
                usuario_consultar.show(false);
            }
            
            //validamos Permiso usuario_actualizar
            int retornoPermiso_usuario_actualizar=controlDB_PermisoUsuario.retornarEstadoPermisoUsuario(user,"usuario_actualizar");
            if(retornoPermiso_usuario_actualizar != 1){
                usuario_actualizar.show(false);
            }
            
            //validamos Permiso empresa_local_registrar
            int retornoPermiso_empresa_local_registrar=controlDB_PermisoUsuario.retornarEstadoPermisoUsuario(user,"empresa_local_registrar");
            if(retornoPermiso_empresa_local_registrar != 1){
                empresa_local_registrar.show(false);
            }
            
            //validamos Permiso empresa_local_consultar
            int retornoPermiso_empresa_local_consultar=controlDB_PermisoUsuario.retornarEstadoPermisoUsuario(user,"empresa_local_consultar");
            if(retornoPermiso_empresa_local_consultar != 1){
                empresa_local_consultar.show(false);
            }
            
            //validamos Permiso empresa_local_actualizar
            int retornoPermiso_empresa_local_actualizar=controlDB_PermisoUsuario.retornarEstadoPermisoUsuario(user,"empresa_local_actualizar");
            if(retornoPermiso_empresa_local_actualizar != 1){
                empresa_local_actualizar.show(false);
            }
            
            //validamos Permiso producto_registrar
            int retornoPermiso_producto_registrar=controlDB_PermisoUsuario.retornarEstadoPermisoUsuario(user,"producto_registrar");
            if(retornoPermiso_producto_registrar != 1){
                producto_registrar.show(false);
            }
            
            //validamos Permiso producto_consultar
            int retornoPermiso_producto_consultar=controlDB_PermisoUsuario.retornarEstadoPermisoUsuario(user,"producto_consultar");
            if(retornoPermiso_producto_consultar != 1){
                producto_consultar.show(false);
            }
            
            //validamos Permiso producto_actualizar
            int retornoPermiso_producto_actualizar=controlDB_PermisoUsuario.retornarEstadoPermisoUsuario(user,"producto_actualizar");
            if(retornoPermiso_producto_actualizar != 1){
                producto_actualizar.show(false);
            }
            
            //validamos Permiso unidad_registrar
            int retornoPermiso_unidad_registrar=controlDB_PermisoUsuario.retornarEstadoPermisoUsuario(user,"unidad_registrar");
            if(retornoPermiso_unidad_registrar != 1){
                unidad_registrar.show(false);
            }
            
            //validamos Permiso unidad_consultar
            int retornoPermiso_unidad_consultar=controlDB_PermisoUsuario.retornarEstadoPermisoUsuario(user,"unidad_consultar");
            if(retornoPermiso_unidad_consultar != 1){
                unidad_consultar.show(false);
            }
            
            //validamos Permiso unidad_actualizar
            int retornoPermiso_unidad_actualizar=controlDB_PermisoUsuario.retornarEstadoPermisoUsuario(user,"unidad_actualizar");
            if(retornoPermiso_unidad_actualizar != 1){
                unidad_actualizar.show(false);
            }
            
            //validamos Permiso bodega_registrar
            int retornoPermiso_bodega_registrar=controlDB_PermisoUsuario.retornarEstadoPermisoUsuario(user,"bodega_registrar");
            if(retornoPermiso_bodega_registrar != 1){
                bodega_registrar.show(false);
            }
            
            //validamos Permiso bodega_consultar
            int retornoPermiso_bodega_consultar=controlDB_PermisoUsuario.retornarEstadoPermisoUsuario(user,"bodega_consultar");
            if(retornoPermiso_bodega_consultar != 1){
                bodega_consultar.show(false);
            }
            
            //validamos Permiso bodega_actualizar
            int retornoPermiso_bodega_actualizar=controlDB_PermisoUsuario.retornarEstadoPermisoUsuario(user,"bodega_actualizar");
            if(retornoPermiso_bodega_actualizar != 1){
                bodega_actualizar.show(false);
            }
            
            //validamos Permiso parametros_permisos_usuarios
            int retornoPermiso_parametros_permisos_usuarios=controlDB_PermisoUsuario.retornarEstadoPermisoUsuario(user,"parametros_permisos_usuarios");
            if(retornoPermiso_parametros_permisos_usuarios != 1){
                parametros_permisos_usuarios.show(false);
            }
            
            //validamos Permiso parametros_permisos_menu
            int retornoPermiso_parametros_permisos_menu=controlDB_PermisoUsuario.retornarEstadoPermisoUsuario(user,"parametros_permisos_menu");
            if(retornoPermiso_parametros_permisos_menu != 1){
                parametros_permisos_menu.show(false);
            }        
            //###############################MENU#################################
            //validamos Permiso cliente
            int retornoPermiso_cliente=controlDB_PermisoUsuario.retornarEstadoMenu("cliente");
            if(retornoPermiso_cliente != 1){
                cliente.show(false);
            } 
            //validamos Permiso proveedor
            int retornoPermiso_proveedor=controlDB_PermisoUsuario.retornarEstadoMenu("proveedor");
            if(retornoPermiso_proveedor != 1){
                proveedor.show(false);
            } 
            //validamos Permiso compra
            int retornoPermiso_compra=controlDB_PermisoUsuario.retornarEstadoMenu("compra");
            if(retornoPermiso_compra != 1){
                compra.show(false);
            } 
            //validamos Permiso venta
            int retornoPermiso_venta=controlDB_PermisoUsuario.retornarEstadoMenu("venta");
            if(retornoPermiso_venta != 1){
                venta.show(false);
            } 
            //validamos Permiso movimiento
            int retornoPermiso_movimiento=controlDB_PermisoUsuario.retornarEstadoMenu("movimiento");
            if(retornoPermiso_movimiento != 1){
                movimiento.show(false);
            } 
            //validamos Permiso consumo
            int retornoPermiso_consumo=controlDB_PermisoUsuario.retornarEstadoMenu("consumo");
            if(retornoPermiso_consumo != 1){
                consumo.show(false);
            } 
            //validamos Permiso informe_anual
            int retornoPermiso_informe_anual=controlDB_PermisoUsuario.retornarEstadoMenu("informe_anual");
            if(retornoPermiso_informe_anual != 1){
                informe_anual.show(false);
            } 
            //validamos Permiso auditoria
            int retornoPermiso_auditoria=controlDB_PermisoUsuario.retornarEstadoMenu("auditoria");
            if(retornoPermiso_auditoria != 1){
                auditoria.show(false);
            } 
            //validamos Permiso usuario
            int retornoPermiso_usuario=controlDB_PermisoUsuario.retornarEstadoMenu("usuario");
            if(retornoPermiso_usuario != 1){
                usuario.show(false);
            } 
            //validamos Permiso empresa_local
            int retornoPermiso_empresa_local=controlDB_PermisoUsuario.retornarEstadoMenu("empresa_local");
            if(retornoPermiso_empresa_local != 1){
                empresa_local.show(false);
            } 
            //validamos Permiso producto
            int retornoPermiso_producto=controlDB_PermisoUsuario.retornarEstadoMenu("producto");
            if(retornoPermiso_producto != 1){
                producto.show(false);
            } 
            //validamos Permiso unidad
            int retornoPermiso_unidad=controlDB_PermisoUsuario.retornarEstadoMenu("unidad");
            if(retornoPermiso_unidad != 1){
                unidad.show(false);
            } 
            //validamos Permiso bodega
            int retornoPermiso_bodega=controlDB_PermisoUsuario.retornarEstadoMenu("bodega");
            if(retornoPermiso_bodega != 1){
                bodega.show(false);
            } 
            //validamos Permiso parametros
            int retornoPermiso_parametros=controlDB_PermisoUsuario.retornarEstadoMenu("parametros");
            if(retornoPermiso_parametros != 1){
                parametros.show(false);
            } 
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al validar permiso del usuario");
        }   
    }
    

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JScrollPane();
        jLabel1 = new javax.swing.JLabel();
        nombreUsuarioEnLinea = new javax.swing.JLabel();
        fecha = new javax.swing.JLabel();
        userOnline = new javax.swing.JLabel();
        entradaAlmacenNo1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        cliente = new javax.swing.JMenu();
        cliente_registrar = new javax.swing.JMenuItem();
        cliente_consultar = new javax.swing.JMenuItem();
        cliente_actualizar = new javax.swing.JMenuItem();
        proveedor = new javax.swing.JMenu();
        proveedor_registrar = new javax.swing.JMenuItem();
        proveedor_consultar = new javax.swing.JMenuItem();
        proveedor_actualizar = new javax.swing.JMenuItem();
        compra = new javax.swing.JMenu();
        compra_registrar = new javax.swing.JMenuItem();
        compra_consultar = new javax.swing.JMenuItem();
        compra_anular = new javax.swing.JMenuItem();
        compra_eliminar = new javax.swing.JMenuItem();
        compra_editar = new javax.swing.JMenuItem();
        venta = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        ventaElectronica_extranjera_registrar = new javax.swing.JMenuItem();
        ventaElectronica_extranjera_editar = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        ventaElectronica_nacional_registrar = new javax.swing.JMenuItem();
        ventaElectronica_nacional_editar = new javax.swing.JMenuItem();
        ventaElectronica_consultar = new javax.swing.JMenuItem();
        ventaElectronica_anular = new javax.swing.JMenuItem();
        ventaElectronica_modificar_dex = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        ventaPapel_extranjera_registrar = new javax.swing.JMenuItem();
        ventaPapel_extranjera_editar = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        ventaPapel_nacional_registrar = new javax.swing.JMenuItem();
        ventaPapel_nacional_editar = new javax.swing.JMenuItem();
        ventaPapel_consultar = new javax.swing.JMenuItem();
        ventaPapel_anular = new javax.swing.JMenuItem();
        ventaPapel_modificar_dex = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        Venta_Extranjera = new javax.swing.JMenu();
        venta_extranjera_registrar = new javax.swing.JMenuItem();
        venta_extranjera_editar = new javax.swing.JMenuItem();
        Venta_Nacional = new javax.swing.JMenu();
        venta_nacional_registrar = new javax.swing.JMenuItem();
        venta_nacional_editar = new javax.swing.JMenuItem();
        venta_consultar = new javax.swing.JMenuItem();
        venta_anular = new javax.swing.JMenuItem();
        venta_modificar_dex = new javax.swing.JMenuItem();
        movimiento = new javax.swing.JMenu();
        jMenu15 = new javax.swing.JMenu();
        movimiento_camarones_registrar = new javax.swing.JMenuItem();
        movimiento_camarones_editar = new javax.swing.JMenuItem();
        Movimiento_Carton = new javax.swing.JMenu();
        movimiento_carton_registrar = new javax.swing.JMenuItem();
        movimiento_carton_editar = new javax.swing.JMenuItem();
        movimiento_consultar = new javax.swing.JMenuItem();
        movimiento_anular = new javax.swing.JMenuItem();
        consumo = new javax.swing.JMenu();
        Consumo_Camarones = new javax.swing.JMenu();
        consumo_camarones_registrar = new javax.swing.JMenuItem();
        consumo_camarones_editar = new javax.swing.JMenuItem();
        Consumo_Carton = new javax.swing.JMenu();
        consumo_carton_registrar = new javax.swing.JMenuItem();
        consumo_carton_editar = new javax.swing.JMenuItem();
        consumo_consultar = new javax.swing.JMenuItem();
        consumo_anular = new javax.swing.JMenuItem();
        informe_anual = new javax.swing.JMenu();
        informe_anual_crear = new javax.swing.JMenuItem();
        auditoria = new javax.swing.JMenu();
        auditoria_consultar = new javax.swing.JMenuItem();
        usuario = new javax.swing.JMenu();
        usuario_registrar = new javax.swing.JMenuItem();
        usuario_consultar = new javax.swing.JMenuItem();
        usuario_actualizar = new javax.swing.JMenuItem();
        empresa_local = new javax.swing.JMenu();
        empresa_local_registrar = new javax.swing.JMenuItem();
        empresa_local_consultar = new javax.swing.JMenuItem();
        empresa_local_actualizar = new javax.swing.JMenuItem();
        producto = new javax.swing.JMenu();
        producto_registrar = new javax.swing.JMenuItem();
        producto_consultar = new javax.swing.JMenuItem();
        producto_actualizar = new javax.swing.JMenuItem();
        unidad = new javax.swing.JMenu();
        unidad_registrar = new javax.swing.JMenuItem();
        unidad_consultar = new javax.swing.JMenuItem();
        unidad_actualizar = new javax.swing.JMenuItem();
        bodega = new javax.swing.JMenu();
        bodega_registrar = new javax.swing.JMenuItem();
        bodega_consultar = new javax.swing.JMenuItem();
        bodega_actualizar = new javax.swing.JMenuItem();
        parametros = new javax.swing.JMenu();
        parametros_permisos_usuarios = new javax.swing.JMenuItem();
        parametros_permisos_menu = new javax.swing.JMenuItem();
        Salir = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("C.I. MAQUILAS DEL PACIFICO S.A.S");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 1520, 660));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/Logo_presentacion.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, -10, 360, 70));

        nombreUsuarioEnLinea.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nombreUsuarioEnLinea.setForeground(new java.awt.Color(0, 153, 153));
        nombreUsuarioEnLinea.setText("Nombre:");
        getContentPane().add(nombreUsuarioEnLinea, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, 450, 20));

        fecha.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        fecha.setForeground(new java.awt.Color(0, 153, 153));
        getContentPane().add(fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 20, 500, 20));

        userOnline.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        userOnline.setForeground(new java.awt.Color(0, 153, 153));
        userOnline.setText("Usuario");
        getContentPane().add(userOnline, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 0, 430, 20));

        entradaAlmacenNo1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        entradaAlmacenNo1.setForeground(new java.awt.Color(0, 153, 51));
        entradaAlmacenNo1.setText("Usuario Conectado: ");
        getContentPane().add(entradaAlmacenNo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 170, 20));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/fondo.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1520, 70));

        jMenuBar1.setBackground(new java.awt.Color(255, 255, 255));
        jMenuBar1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jMenuBar1.setForeground(new java.awt.Color(255, 255, 255));
        jMenuBar1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jMenuBar1.setOpaque(false);
        jMenuBar1.setPreferredSize(new java.awt.Dimension(327, 35));

        cliente.setBackground(new java.awt.Color(255, 255, 255));
        cliente.setBorder(null);
        cliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/menu/menu_cliente.png"))); // NOI18N
        cliente.setText("Cliente  ");
        cliente.setFont(new java.awt.Font("Malgun Gothic", 0, 14)); // NOI18N
        cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clienteActionPerformed(evt);
            }
        });

        cliente_registrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/menu/sub_menu.png"))); // NOI18N
        cliente_registrar.setText("Registrar");
        cliente_registrar.setPreferredSize(new java.awt.Dimension(150, 30));
        cliente_registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cliente_registrarActionPerformed(evt);
            }
        });
        cliente.add(cliente_registrar);

        cliente_consultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/menu/sub_menu.png"))); // NOI18N
        cliente_consultar.setText("Consultar");
        cliente_consultar.setPreferredSize(new java.awt.Dimension(150, 30));
        cliente_consultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cliente_consultarActionPerformed(evt);
            }
        });
        cliente.add(cliente_consultar);

        cliente_actualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/menu/sub_menu.png"))); // NOI18N
        cliente_actualizar.setText("Actualizar");
        cliente_actualizar.setPreferredSize(new java.awt.Dimension(150, 30));
        cliente_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cliente_actualizarActionPerformed(evt);
            }
        });
        cliente.add(cliente_actualizar);

        jMenuBar1.add(cliente);

        proveedor.setBackground(new java.awt.Color(255, 255, 255));
        proveedor.setBorder(null);
        proveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/menu/menu_proveedor.png"))); // NOI18N
        proveedor.setText("Proveedor  ");
        proveedor.setFont(new java.awt.Font("Malgun Gothic", 0, 14)); // NOI18N
        proveedor.setPreferredSize(new java.awt.Dimension(100, 20));

        proveedor_registrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/menu/sub_menu.png"))); // NOI18N
        proveedor_registrar.setText("Registrar");
        proveedor_registrar.setPreferredSize(new java.awt.Dimension(150, 30));
        proveedor_registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                proveedor_registrarActionPerformed(evt);
            }
        });
        proveedor.add(proveedor_registrar);

        proveedor_consultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/menu/sub_menu.png"))); // NOI18N
        proveedor_consultar.setText("Consultar");
        proveedor_consultar.setPreferredSize(new java.awt.Dimension(150, 30));
        proveedor_consultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                proveedor_consultarActionPerformed(evt);
            }
        });
        proveedor.add(proveedor_consultar);

        proveedor_actualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/menu/sub_menu.png"))); // NOI18N
        proveedor_actualizar.setText("Actualizar");
        proveedor_actualizar.setPreferredSize(new java.awt.Dimension(150, 30));
        proveedor_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                proveedor_actualizarActionPerformed(evt);
            }
        });
        proveedor.add(proveedor_actualizar);

        jMenuBar1.add(proveedor);

        compra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/menu/menu_comprar.png"))); // NOI18N
        compra.setText("Compra  ");
        compra.setFont(new java.awt.Font("Malgun Gothic", 0, 14)); // NOI18N

        compra_registrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/menu/sub_menu.png"))); // NOI18N
        compra_registrar.setText("Registrar");
        compra_registrar.setPreferredSize(new java.awt.Dimension(150, 30));
        compra_registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                compra_registrarActionPerformed(evt);
            }
        });
        compra.add(compra_registrar);

        compra_consultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/menu/sub_menu.png"))); // NOI18N
        compra_consultar.setText("Consultar");
        compra_consultar.setPreferredSize(new java.awt.Dimension(150, 30));
        compra_consultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                compra_consultarActionPerformed(evt);
            }
        });
        compra.add(compra_consultar);

        compra_anular.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/menu/sub_menu.png"))); // NOI18N
        compra_anular.setText("Anular");
        compra_anular.setPreferredSize(new java.awt.Dimension(150, 30));
        compra_anular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                compra_anularActionPerformed(evt);
            }
        });
        compra.add(compra_anular);

        compra_eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/menu/sub_menu.png"))); // NOI18N
        compra_eliminar.setText("Eliminar");
        compra_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                compra_eliminarActionPerformed(evt);
            }
        });
        compra.add(compra_eliminar);

        compra_editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/menu/sub_menu.png"))); // NOI18N
        compra_editar.setText("Editar");
        compra_editar.setPreferredSize(new java.awt.Dimension(150, 30));
        compra_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                compra_editarActionPerformed(evt);
            }
        });
        compra.add(compra_editar);

        jMenuBar1.add(compra);

        venta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/menu/menu_venta.png"))); // NOI18N
        venta.setText("Venta  ");
        venta.setFont(new java.awt.Font("Malgun Gothic", 0, 14)); // NOI18N

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/menu/sub_menu.png"))); // NOI18N
        jMenu1.setText("Facturación Eléctronica");
        jMenu1.setPreferredSize(new java.awt.Dimension(150, 30));

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/menu/sub_menu.png"))); // NOI18N
        jMenu2.setText("Extranjera");
        jMenu2.setPreferredSize(new java.awt.Dimension(150, 30));

        ventaElectronica_extranjera_registrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/menu/sub_menu.png"))); // NOI18N
        ventaElectronica_extranjera_registrar.setText("Registrar");
        ventaElectronica_extranjera_registrar.setPreferredSize(new java.awt.Dimension(150, 30));
        ventaElectronica_extranjera_registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ventaElectronica_extranjera_registrarActionPerformed(evt);
            }
        });
        jMenu2.add(ventaElectronica_extranjera_registrar);

        ventaElectronica_extranjera_editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/menu/sub_menu.png"))); // NOI18N
        ventaElectronica_extranjera_editar.setText("Editar");
        ventaElectronica_extranjera_editar.setPreferredSize(new java.awt.Dimension(150, 30));
        ventaElectronica_extranjera_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ventaElectronica_extranjera_editarActionPerformed(evt);
            }
        });
        jMenu2.add(ventaElectronica_extranjera_editar);

        jMenu1.add(jMenu2);

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/menu/sub_menu.png"))); // NOI18N
        jMenu3.setText("Nacional");
        jMenu3.setPreferredSize(new java.awt.Dimension(150, 30));

        ventaElectronica_nacional_registrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/menu/sub_menu.png"))); // NOI18N
        ventaElectronica_nacional_registrar.setText("Registrar");
        ventaElectronica_nacional_registrar.setPreferredSize(new java.awt.Dimension(150, 30));
        ventaElectronica_nacional_registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ventaElectronica_nacional_registrarActionPerformed(evt);
            }
        });
        jMenu3.add(ventaElectronica_nacional_registrar);

        ventaElectronica_nacional_editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/menu/sub_menu.png"))); // NOI18N
        ventaElectronica_nacional_editar.setText("Editar");
        ventaElectronica_nacional_editar.setPreferredSize(new java.awt.Dimension(150, 30));
        ventaElectronica_nacional_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ventaElectronica_nacional_editarActionPerformed(evt);
            }
        });
        jMenu3.add(ventaElectronica_nacional_editar);

        jMenu1.add(jMenu3);

        ventaElectronica_consultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/menu/sub_menu.png"))); // NOI18N
        ventaElectronica_consultar.setText("Consultar");
        ventaElectronica_consultar.setPreferredSize(new java.awt.Dimension(150, 30));
        ventaElectronica_consultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ventaElectronica_consultarActionPerformed(evt);
            }
        });
        jMenu1.add(ventaElectronica_consultar);

        ventaElectronica_anular.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/menu/sub_menu.png"))); // NOI18N
        ventaElectronica_anular.setText("Anular");
        ventaElectronica_anular.setPreferredSize(new java.awt.Dimension(150, 30));
        ventaElectronica_anular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ventaElectronica_anularActionPerformed(evt);
            }
        });
        jMenu1.add(ventaElectronica_anular);

        ventaElectronica_modificar_dex.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/menu/sub_menu.png"))); // NOI18N
        ventaElectronica_modificar_dex.setText("Modificar");
        ventaElectronica_modificar_dex.setPreferredSize(new java.awt.Dimension(150, 30));
        ventaElectronica_modificar_dex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ventaElectronica_modificar_dexActionPerformed(evt);
            }
        });
        jMenu1.add(ventaElectronica_modificar_dex);

        venta.add(jMenu1);

        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/menu/sub_menu.png"))); // NOI18N
        jMenu4.setText("Facturación Papel");
        jMenu4.setPreferredSize(new java.awt.Dimension(150, 30));

        jMenu5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/menu/sub_menu.png"))); // NOI18N
        jMenu5.setText("Extranjera");
        jMenu5.setPreferredSize(new java.awt.Dimension(150, 30));

        ventaPapel_extranjera_registrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/menu/sub_menu.png"))); // NOI18N
        ventaPapel_extranjera_registrar.setText("Registrar");
        ventaPapel_extranjera_registrar.setPreferredSize(new java.awt.Dimension(150, 30));
        ventaPapel_extranjera_registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ventaPapel_extranjera_registrarActionPerformed(evt);
            }
        });
        jMenu5.add(ventaPapel_extranjera_registrar);

        ventaPapel_extranjera_editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/menu/sub_menu.png"))); // NOI18N
        ventaPapel_extranjera_editar.setText("Editar");
        ventaPapel_extranjera_editar.setPreferredSize(new java.awt.Dimension(150, 30));
        ventaPapel_extranjera_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ventaPapel_extranjera_editarActionPerformed(evt);
            }
        });
        jMenu5.add(ventaPapel_extranjera_editar);

        jMenu4.add(jMenu5);

        jMenu6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/menu/sub_menu.png"))); // NOI18N
        jMenu6.setText("Nacional");
        jMenu6.setPreferredSize(new java.awt.Dimension(150, 30));

        ventaPapel_nacional_registrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/menu/sub_menu.png"))); // NOI18N
        ventaPapel_nacional_registrar.setText("Registrar");
        ventaPapel_nacional_registrar.setPreferredSize(new java.awt.Dimension(150, 30));
        ventaPapel_nacional_registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ventaPapel_nacional_registrarActionPerformed(evt);
            }
        });
        jMenu6.add(ventaPapel_nacional_registrar);

        ventaPapel_nacional_editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/menu/sub_menu.png"))); // NOI18N
        ventaPapel_nacional_editar.setText("Editar");
        ventaPapel_nacional_editar.setPreferredSize(new java.awt.Dimension(150, 30));
        ventaPapel_nacional_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ventaPapel_nacional_editarActionPerformed(evt);
            }
        });
        jMenu6.add(ventaPapel_nacional_editar);

        jMenu4.add(jMenu6);

        ventaPapel_consultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/menu/sub_menu.png"))); // NOI18N
        ventaPapel_consultar.setText("Consultar");
        ventaPapel_consultar.setPreferredSize(new java.awt.Dimension(150, 30));
        ventaPapel_consultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ventaPapel_consultarActionPerformed(evt);
            }
        });
        jMenu4.add(ventaPapel_consultar);

        ventaPapel_anular.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/menu/sub_menu.png"))); // NOI18N
        ventaPapel_anular.setText("Anular");
        ventaPapel_anular.setPreferredSize(new java.awt.Dimension(150, 30));
        ventaPapel_anular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ventaPapel_anularActionPerformed(evt);
            }
        });
        jMenu4.add(ventaPapel_anular);

        ventaPapel_modificar_dex.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/menu/sub_menu.png"))); // NOI18N
        ventaPapel_modificar_dex.setText("Modificar");
        ventaPapel_modificar_dex.setPreferredSize(new java.awt.Dimension(150, 30));
        ventaPapel_modificar_dex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ventaPapel_modificar_dexActionPerformed(evt);
            }
        });
        jMenu4.add(ventaPapel_modificar_dex);

        venta.add(jMenu4);

        jMenu7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/menu/sub_menu.png"))); // NOI18N
        jMenu7.setText("Facturación Computador");
        jMenu7.setPreferredSize(new java.awt.Dimension(150, 30));

        Venta_Extranjera.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/menu/sub_menu.png"))); // NOI18N
        Venta_Extranjera.setText("Extranjera");
        Venta_Extranjera.setPreferredSize(new java.awt.Dimension(150, 30));

        venta_extranjera_registrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/menu/sub_menu.png"))); // NOI18N
        venta_extranjera_registrar.setText("Registrar");
        venta_extranjera_registrar.setPreferredSize(new java.awt.Dimension(150, 30));
        venta_extranjera_registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                venta_extranjera_registrarActionPerformed(evt);
            }
        });
        Venta_Extranjera.add(venta_extranjera_registrar);

        venta_extranjera_editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/menu/sub_menu.png"))); // NOI18N
        venta_extranjera_editar.setText("Editar");
        venta_extranjera_editar.setPreferredSize(new java.awt.Dimension(150, 30));
        venta_extranjera_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                venta_extranjera_editarActionPerformed(evt);
            }
        });
        Venta_Extranjera.add(venta_extranjera_editar);

        jMenu7.add(Venta_Extranjera);

        Venta_Nacional.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/menu/sub_menu.png"))); // NOI18N
        Venta_Nacional.setText("Nacional");
        Venta_Nacional.setPreferredSize(new java.awt.Dimension(150, 30));

        venta_nacional_registrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/menu/sub_menu.png"))); // NOI18N
        venta_nacional_registrar.setText("Registrar");
        venta_nacional_registrar.setPreferredSize(new java.awt.Dimension(150, 30));
        venta_nacional_registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                venta_nacional_registrarActionPerformed(evt);
            }
        });
        Venta_Nacional.add(venta_nacional_registrar);

        venta_nacional_editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/menu/sub_menu.png"))); // NOI18N
        venta_nacional_editar.setText("Editar");
        venta_nacional_editar.setPreferredSize(new java.awt.Dimension(150, 30));
        venta_nacional_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                venta_nacional_editarActionPerformed(evt);
            }
        });
        Venta_Nacional.add(venta_nacional_editar);

        jMenu7.add(Venta_Nacional);

        venta_consultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/menu/sub_menu.png"))); // NOI18N
        venta_consultar.setText("Consultar");
        venta_consultar.setPreferredSize(new java.awt.Dimension(150, 30));
        venta_consultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                venta_consultarActionPerformed(evt);
            }
        });
        jMenu7.add(venta_consultar);

        venta_anular.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/menu/sub_menu.png"))); // NOI18N
        venta_anular.setText("Anular");
        venta_anular.setPreferredSize(new java.awt.Dimension(150, 30));
        venta_anular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                venta_anularActionPerformed(evt);
            }
        });
        jMenu7.add(venta_anular);

        venta_modificar_dex.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/menu/sub_menu.png"))); // NOI18N
        venta_modificar_dex.setText("Modificar Dex");
        venta_modificar_dex.setPreferredSize(new java.awt.Dimension(150, 30));
        venta_modificar_dex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                venta_modificar_dexActionPerformed(evt);
            }
        });
        jMenu7.add(venta_modificar_dex);

        venta.add(jMenu7);

        jMenuBar1.add(venta);

        movimiento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/menu/menu_movimiento.png"))); // NOI18N
        movimiento.setText("Movimiento  ");
        movimiento.setFont(new java.awt.Font("Malgun Gothic", 0, 14)); // NOI18N

        jMenu15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/menu/sub_menu.png"))); // NOI18N
        jMenu15.setText("Camarones");
        jMenu15.setPreferredSize(new java.awt.Dimension(150, 30));

        movimiento_camarones_registrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/menu/sub_menu.png"))); // NOI18N
        movimiento_camarones_registrar.setText("Registrar");
        movimiento_camarones_registrar.setPreferredSize(new java.awt.Dimension(150, 30));
        movimiento_camarones_registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                movimiento_camarones_registrarActionPerformed(evt);
            }
        });
        jMenu15.add(movimiento_camarones_registrar);

        movimiento_camarones_editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/menu/sub_menu.png"))); // NOI18N
        movimiento_camarones_editar.setText("Editar");
        movimiento_camarones_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                movimiento_camarones_editarActionPerformed(evt);
            }
        });
        jMenu15.add(movimiento_camarones_editar);

        movimiento.add(jMenu15);

        Movimiento_Carton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/menu/sub_menu.png"))); // NOI18N
        Movimiento_Carton.setText("Cartón");
        Movimiento_Carton.setPreferredSize(new java.awt.Dimension(150, 30));

        movimiento_carton_registrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/menu/sub_menu.png"))); // NOI18N
        movimiento_carton_registrar.setText("Registrar");
        movimiento_carton_registrar.setPreferredSize(new java.awt.Dimension(150, 30));
        movimiento_carton_registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                movimiento_carton_registrarActionPerformed(evt);
            }
        });
        Movimiento_Carton.add(movimiento_carton_registrar);

        movimiento_carton_editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/menu/sub_menu.png"))); // NOI18N
        movimiento_carton_editar.setText("Editar");
        movimiento_carton_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                movimiento_carton_editarActionPerformed(evt);
            }
        });
        Movimiento_Carton.add(movimiento_carton_editar);

        movimiento.add(Movimiento_Carton);

        movimiento_consultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/menu/sub_menu.png"))); // NOI18N
        movimiento_consultar.setText("Consultar");
        movimiento_consultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                movimiento_consultarActionPerformed(evt);
            }
        });
        movimiento.add(movimiento_consultar);

        movimiento_anular.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/menu/sub_menu.png"))); // NOI18N
        movimiento_anular.setText("Anular");
        movimiento_anular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                movimiento_anularActionPerformed(evt);
            }
        });
        movimiento.add(movimiento_anular);

        jMenuBar1.add(movimiento);

        consumo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/menu/menu_consumo.png"))); // NOI18N
        consumo.setText("Consumo  ");
        consumo.setFont(new java.awt.Font("Malgun Gothic", 0, 14)); // NOI18N

        Consumo_Camarones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/menu/sub_menu.png"))); // NOI18N
        Consumo_Camarones.setText("Camarones");
        Consumo_Camarones.setPreferredSize(new java.awt.Dimension(150, 30));

        consumo_camarones_registrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/menu/sub_menu.png"))); // NOI18N
        consumo_camarones_registrar.setText("Registrar");
        consumo_camarones_registrar.setPreferredSize(new java.awt.Dimension(150, 30));
        consumo_camarones_registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consumo_camarones_registrarActionPerformed(evt);
            }
        });
        Consumo_Camarones.add(consumo_camarones_registrar);

        consumo_camarones_editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/menu/sub_menu.png"))); // NOI18N
        consumo_camarones_editar.setText("Editar");
        consumo_camarones_editar.setPreferredSize(new java.awt.Dimension(150, 30));
        consumo_camarones_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consumo_camarones_editarActionPerformed(evt);
            }
        });
        Consumo_Camarones.add(consumo_camarones_editar);

        consumo.add(Consumo_Camarones);

        Consumo_Carton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/menu/sub_menu.png"))); // NOI18N
        Consumo_Carton.setText("Cartón");
        Consumo_Carton.setPreferredSize(new java.awt.Dimension(150, 30));

        consumo_carton_registrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/menu/sub_menu.png"))); // NOI18N
        consumo_carton_registrar.setText("Registrar");
        consumo_carton_registrar.setPreferredSize(new java.awt.Dimension(150, 30));
        consumo_carton_registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consumo_carton_registrarActionPerformed(evt);
            }
        });
        Consumo_Carton.add(consumo_carton_registrar);

        consumo_carton_editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/menu/sub_menu.png"))); // NOI18N
        consumo_carton_editar.setText("Editar");
        consumo_carton_editar.setPreferredSize(new java.awt.Dimension(150, 30));
        consumo_carton_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consumo_carton_editarActionPerformed(evt);
            }
        });
        Consumo_Carton.add(consumo_carton_editar);

        consumo.add(Consumo_Carton);

        consumo_consultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/menu/sub_menu.png"))); // NOI18N
        consumo_consultar.setText("Consultar");
        consumo_consultar.setPreferredSize(new java.awt.Dimension(150, 30));
        consumo_consultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consumo_consultarActionPerformed(evt);
            }
        });
        consumo.add(consumo_consultar);

        consumo_anular.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/menu/sub_menu.png"))); // NOI18N
        consumo_anular.setText("Anular");
        consumo_anular.setPreferredSize(new java.awt.Dimension(150, 30));
        consumo_anular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consumo_anularActionPerformed(evt);
            }
        });
        consumo.add(consumo_anular);

        jMenuBar1.add(consumo);

        informe_anual.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/menu/menu_informeAnual.png"))); // NOI18N
        informe_anual.setText("Informe_Anual ");
        informe_anual.setFont(new java.awt.Font("Malgun Gothic", 0, 14)); // NOI18N

        informe_anual_crear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/menu/sub_menu.png"))); // NOI18N
        informe_anual_crear.setText("Crear");
        informe_anual_crear.setPreferredSize(new java.awt.Dimension(150, 30));
        informe_anual_crear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                informe_anual_crearActionPerformed(evt);
            }
        });
        informe_anual.add(informe_anual_crear);

        jMenuBar1.add(informe_anual);

        auditoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/menu/menu_auditoria.png"))); // NOI18N
        auditoria.setText("Auditoria ");
        auditoria.setFont(new java.awt.Font("Malgun Gothic", 0, 14)); // NOI18N

        auditoria_consultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/menu/sub_menu.png"))); // NOI18N
        auditoria_consultar.setText("Consultar");
        auditoria_consultar.setPreferredSize(new java.awt.Dimension(150, 30));
        auditoria_consultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                auditoria_consultarActionPerformed(evt);
            }
        });
        auditoria.add(auditoria_consultar);

        jMenuBar1.add(auditoria);

        usuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/menu/menu_usuario.png"))); // NOI18N
        usuario.setText("Usuario ");
        usuario.setFont(new java.awt.Font("Malgun Gothic", 0, 14)); // NOI18N

        usuario_registrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/menu/sub_menu.png"))); // NOI18N
        usuario_registrar.setText("Registrar");
        usuario_registrar.setPreferredSize(new java.awt.Dimension(150, 30));
        usuario_registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuario_registrarActionPerformed(evt);
            }
        });
        usuario.add(usuario_registrar);

        usuario_consultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/menu/sub_menu.png"))); // NOI18N
        usuario_consultar.setText("Consultar");
        usuario_consultar.setPreferredSize(new java.awt.Dimension(150, 30));
        usuario_consultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuario_consultarActionPerformed(evt);
            }
        });
        usuario.add(usuario_consultar);

        usuario_actualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/menu/sub_menu.png"))); // NOI18N
        usuario_actualizar.setText("Actualizar");
        usuario_actualizar.setPreferredSize(new java.awt.Dimension(150, 30));
        usuario_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuario_actualizarActionPerformed(evt);
            }
        });
        usuario.add(usuario_actualizar);

        jMenuBar1.add(usuario);

        empresa_local.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/menu/menu_empresaLocal.png"))); // NOI18N
        empresa_local.setText("Empresa_Local ");
        empresa_local.setFont(new java.awt.Font("Malgun Gothic", 0, 14)); // NOI18N

        empresa_local_registrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/menu/sub_menu.png"))); // NOI18N
        empresa_local_registrar.setText("Registrar");
        empresa_local_registrar.setPreferredSize(new java.awt.Dimension(150, 30));
        empresa_local_registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                empresa_local_registrarActionPerformed(evt);
            }
        });
        empresa_local.add(empresa_local_registrar);

        empresa_local_consultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/menu/sub_menu.png"))); // NOI18N
        empresa_local_consultar.setText("Consultar");
        empresa_local_consultar.setPreferredSize(new java.awt.Dimension(150, 30));
        empresa_local_consultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                empresa_local_consultarActionPerformed(evt);
            }
        });
        empresa_local.add(empresa_local_consultar);

        empresa_local_actualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/menu/sub_menu.png"))); // NOI18N
        empresa_local_actualizar.setText("Actualizar");
        empresa_local_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                empresa_local_actualizarActionPerformed(evt);
            }
        });
        empresa_local.add(empresa_local_actualizar);

        jMenuBar1.add(empresa_local);

        producto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/menu/menu_producto.png"))); // NOI18N
        producto.setText("Producto ");
        producto.setFont(new java.awt.Font("Malgun Gothic", 0, 14)); // NOI18N

        producto_registrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/menu/sub_menu.png"))); // NOI18N
        producto_registrar.setText("Registrar");
        producto_registrar.setPreferredSize(new java.awt.Dimension(150, 30));
        producto_registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                producto_registrarActionPerformed(evt);
            }
        });
        producto.add(producto_registrar);

        producto_consultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/menu/sub_menu.png"))); // NOI18N
        producto_consultar.setText("Consultar");
        producto_consultar.setPreferredSize(new java.awt.Dimension(150, 30));
        producto_consultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                producto_consultarActionPerformed(evt);
            }
        });
        producto.add(producto_consultar);

        producto_actualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/menu/sub_menu.png"))); // NOI18N
        producto_actualizar.setText("Actualizar");
        producto_actualizar.setPreferredSize(new java.awt.Dimension(150, 30));
        producto_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                producto_actualizarActionPerformed(evt);
            }
        });
        producto.add(producto_actualizar);

        jMenuBar1.add(producto);

        unidad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/menu/menu_unidad.png"))); // NOI18N
        unidad.setText("Unidad ");
        unidad.setFont(new java.awt.Font("Malgun Gothic", 0, 14)); // NOI18N

        unidad_registrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/menu/sub_menu.png"))); // NOI18N
        unidad_registrar.setText("Registrar");
        unidad_registrar.setPreferredSize(new java.awt.Dimension(150, 30));
        unidad_registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unidad_registrarActionPerformed(evt);
            }
        });
        unidad.add(unidad_registrar);

        unidad_consultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/menu/sub_menu.png"))); // NOI18N
        unidad_consultar.setText("Consultar");
        unidad_consultar.setPreferredSize(new java.awt.Dimension(150, 30));
        unidad_consultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unidad_consultarActionPerformed(evt);
            }
        });
        unidad.add(unidad_consultar);

        unidad_actualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/menu/sub_menu.png"))); // NOI18N
        unidad_actualizar.setText("Actualizar");
        unidad_actualizar.setPreferredSize(new java.awt.Dimension(150, 30));
        unidad_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unidad_actualizarActionPerformed(evt);
            }
        });
        unidad.add(unidad_actualizar);

        jMenuBar1.add(unidad);

        bodega.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/menu/menu_bodega.png"))); // NOI18N
        bodega.setText("Bodega ");
        bodega.setFont(new java.awt.Font("Malgun Gothic", 0, 14)); // NOI18N

        bodega_registrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/menu/sub_menu.png"))); // NOI18N
        bodega_registrar.setText("Registrar");
        bodega_registrar.setPreferredSize(new java.awt.Dimension(150, 30));
        bodega_registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bodega_registrarActionPerformed(evt);
            }
        });
        bodega.add(bodega_registrar);

        bodega_consultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/menu/sub_menu.png"))); // NOI18N
        bodega_consultar.setText("Consultar");
        bodega_consultar.setPreferredSize(new java.awt.Dimension(150, 30));
        bodega_consultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bodega_consultarActionPerformed(evt);
            }
        });
        bodega.add(bodega_consultar);

        bodega_actualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/menu/sub_menu.png"))); // NOI18N
        bodega_actualizar.setText("Actualizar");
        bodega_actualizar.setPreferredSize(new java.awt.Dimension(150, 30));
        bodega_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bodega_actualizarActionPerformed(evt);
            }
        });
        bodega.add(bodega_actualizar);

        jMenuBar1.add(bodega);

        parametros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/menu/menu_parametros.png"))); // NOI18N
        parametros.setText("Parámetros");
        parametros.setFont(new java.awt.Font("Malgun Gothic", 0, 14)); // NOI18N

        parametros_permisos_usuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/menu/sub_menu.png"))); // NOI18N
        parametros_permisos_usuarios.setText("Permisos Usuario");
        parametros_permisos_usuarios.setPreferredSize(new java.awt.Dimension(150, 30));
        parametros_permisos_usuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                parametros_permisos_usuariosActionPerformed(evt);
            }
        });
        parametros.add(parametros_permisos_usuarios);

        parametros_permisos_menu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/menu/sub_menu.png"))); // NOI18N
        parametros_permisos_menu.setText("Permisos Menú");
        parametros_permisos_menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                parametros_permisos_menuActionPerformed(evt);
            }
        });
        parametros.add(parametros_permisos_menu);

        jMenuBar1.add(parametros);

        Salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/menu/menu_salir.png"))); // NOI18N
        Salir.setText("Salir");

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Img/menu/sub_menu.png"))); // NOI18N
        jMenuItem1.setText("Salir");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        Salir.add(jMenuItem1);

        jMenuBar1.add(Salir);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cliente_registrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cliente_registrarActionPerformed
        panel.setViewportView(new Cliente_Registrar());
    }//GEN-LAST:event_cliente_registrarActionPerformed

    private void cliente_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cliente_actualizarActionPerformed
         panel.setViewportView(new Cliente_Actualizar());
    }//GEN-LAST:event_cliente_actualizarActionPerformed

    private void proveedor_consultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_proveedor_consultarActionPerformed
        panel.setViewportView(new Proveedor_Consultar());
    }//GEN-LAST:event_proveedor_consultarActionPerformed

    private void producto_consultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_producto_consultarActionPerformed
       panel.setViewportView(new Producto_Consultar());
    }//GEN-LAST:event_producto_consultarActionPerformed

    private void movimiento_carton_registrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_movimiento_carton_registrarActionPerformed
        panel.setViewportView(new Movimientos_Registrar_Cajas(user));
    }//GEN-LAST:event_movimiento_carton_registrarActionPerformed

    private void parametros_permisos_usuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_parametros_permisos_usuariosActionPerformed
        try {
            panel.setViewportView(new Permiso_Usuario());
        } catch (SQLException ex) {
            Logger.getLogger(GUI_Principal1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_parametros_permisos_usuariosActionPerformed

    private void cliente_consultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cliente_consultarActionPerformed
          panel.setViewportView(new Cliente_Consultar());
    }//GEN-LAST:event_cliente_consultarActionPerformed

    private void proveedor_registrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_proveedor_registrarActionPerformed
         panel.setViewportView(new Proveedores_Registrar());
    }//GEN-LAST:event_proveedor_registrarActionPerformed

    private void proveedor_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_proveedor_actualizarActionPerformed
         panel.setViewportView(new Proveedor_Actualizar());
    }//GEN-LAST:event_proveedor_actualizarActionPerformed

    private void compra_registrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_compra_registrarActionPerformed
        try {
            panel.setViewportView(new Compra_Registrar(user));
        } catch (SQLException ex) {
            Logger.getLogger(Menu_Compra.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_compra_registrarActionPerformed

    private void compra_consultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_compra_consultarActionPerformed
         try { 
            panel.setViewportView(new Compra_Consultar());
        } catch (SQLException ex) {
            Logger.getLogger(Menu_Compra.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_compra_consultarActionPerformed

    private void compra_anularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_compra_anularActionPerformed
        try { 
            panel.setViewportView(new Compra_Anular(user));
        } catch (SQLException ex) {
            Logger.getLogger(Menu_Compra.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_compra_anularActionPerformed

    private void compra_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_compra_editarActionPerformed
        try { 
            panel.setViewportView(new Compra_Editar(user));
        } catch (SQLException ex) {
            Logger.getLogger(Menu_Compra.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }//GEN-LAST:event_compra_editarActionPerformed

    private void venta_extranjera_registrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_venta_extranjera_registrarActionPerformed
         panel.setViewportView(new VentaFacturacionComputador_Registrar_BodExtranjera(user));  
    }//GEN-LAST:event_venta_extranjera_registrarActionPerformed

    private void venta_extranjera_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_venta_extranjera_editarActionPerformed
        try{
            panel.setViewportView(new VentaFacturacionComputador_Editar_BodExtranjera(user));
        }catch(Exception e){} 
    }//GEN-LAST:event_venta_extranjera_editarActionPerformed

    private void venta_nacional_registrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_venta_nacional_registrarActionPerformed
        panel.setViewportView(new VentaFacturacionComputador_Registrar_BodNacional(user));  
    }//GEN-LAST:event_venta_nacional_registrarActionPerformed

    private void venta_nacional_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_venta_nacional_editarActionPerformed
        try{
            panel.setViewportView(new VentaFacturacionComputador_Editar_BodNacional(user));
        }catch(Exception e){} 
    }//GEN-LAST:event_venta_nacional_editarActionPerformed

    private void venta_consultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_venta_consultarActionPerformed
         try {
            panel.setViewportView(new VentaFacturacionComputador_Consultar());
        } catch (SQLException ex) {
            Logger.getLogger(Menu_Venta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_venta_consultarActionPerformed

    private void venta_anularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_venta_anularActionPerformed
        try { 
            panel.setViewportView(new VentaFacturacionComputador_Anular(user));
        } catch (SQLException ex) {
            Logger.getLogger(Menu_Venta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_venta_anularActionPerformed

    private void venta_modificar_dexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_venta_modificar_dexActionPerformed
        try {
            panel.setViewportView(new VentaFacturacionComputador_ModificarDEX());
        } catch (SQLException ex) {
            Logger.getLogger(Menu_Venta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_venta_modificar_dexActionPerformed

    private void movimiento_camarones_registrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_movimiento_camarones_registrarActionPerformed
         panel.setViewportView(new Movimientos_Registrar_Camarones(user));  
    }//GEN-LAST:event_movimiento_camarones_registrarActionPerformed

    private void consumo_camarones_registrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consumo_camarones_registrarActionPerformed
         panel.setViewportView(new ConsumoCamarones_Registrar_BodNacional(user));
    }//GEN-LAST:event_consumo_camarones_registrarActionPerformed

    private void consumo_carton_registrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consumo_carton_registrarActionPerformed
        panel.setViewportView(new ConsumoCajas_Registrar_BodNacional(user));
    }//GEN-LAST:event_consumo_carton_registrarActionPerformed

    private void consumo_camarones_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consumo_camarones_editarActionPerformed
       panel.setViewportView(new ConsumoCamarones_Editar_BodNacional(user));
    }//GEN-LAST:event_consumo_camarones_editarActionPerformed

    private void consumo_carton_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consumo_carton_editarActionPerformed
        panel.setViewportView(new ConsumoCajas_Editar_BodNacional(user));
    }//GEN-LAST:event_consumo_carton_editarActionPerformed

    private void consumo_consultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consumo_consultarActionPerformed
        try {
            panel.setViewportView(new Consumo_Consultar());
        } catch (SQLException ex) {
            Logger.getLogger(Menu_Consumo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_consumo_consultarActionPerformed

    private void consumo_anularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consumo_anularActionPerformed
        try {
            panel.setViewportView(new Consumo_Anular(user));
        } catch (SQLException ex) {
            Logger.getLogger(Menu_Consumo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_consumo_anularActionPerformed

    private void informe_anual_crearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_informe_anual_crearActionPerformed
        panel.setViewportView(new InformeAnual());
    }//GEN-LAST:event_informe_anual_crearActionPerformed

    private void auditoria_consultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_auditoria_consultarActionPerformed
        panel.setViewportView(new Auditoria_Control());
    }//GEN-LAST:event_auditoria_consultarActionPerformed

    private void usuario_registrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuario_registrarActionPerformed
         panel.setViewportView(new Usuario_Registrar());
    }//GEN-LAST:event_usuario_registrarActionPerformed

    private void usuario_consultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuario_consultarActionPerformed
        panel.setViewportView(new Usuario_Consultar());
    }//GEN-LAST:event_usuario_consultarActionPerformed

    private void usuario_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuario_actualizarActionPerformed
        try {
            panel.setViewportView(new Usuario_Actualizar());
        } catch (SQLException ex) {
            Logger.getLogger(Menu_Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_usuario_actualizarActionPerformed

    private void empresa_local_registrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_empresa_local_registrarActionPerformed
        panel.setViewportView(new EmpresaLocal_Registrar());
    }//GEN-LAST:event_empresa_local_registrarActionPerformed

    private void empresa_local_consultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_empresa_local_consultarActionPerformed
        panel.setViewportView(new EmpresaLocal_Consultar());
    }//GEN-LAST:event_empresa_local_consultarActionPerformed

    private void empresa_local_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_empresa_local_actualizarActionPerformed
          panel.setViewportView(new EmpresaLocal_Actualizar());
    }//GEN-LAST:event_empresa_local_actualizarActionPerformed

    private void producto_registrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_producto_registrarActionPerformed
        try {
            panel.setViewportView(new Producto_Registrar());
        } catch (SQLException ex) {
            Logger.getLogger(Menu_Producto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_producto_registrarActionPerformed

    private void producto_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_producto_actualizarActionPerformed
        try {
            panel.setViewportView(new Producto_Actualizar());
        } catch (SQLException ex) {
            Logger.getLogger(Menu_Producto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_producto_actualizarActionPerformed

    private void unidad_registrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unidad_registrarActionPerformed
         panel.setViewportView(new Unidad_Registrar());
    }//GEN-LAST:event_unidad_registrarActionPerformed

    private void unidad_consultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unidad_consultarActionPerformed
        panel.setViewportView(new Unidad_Consultar());
    }//GEN-LAST:event_unidad_consultarActionPerformed

    private void unidad_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unidad_actualizarActionPerformed
        panel.setViewportView(new Unidad_Actualizar());
    }//GEN-LAST:event_unidad_actualizarActionPerformed

    private void bodega_registrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bodega_registrarActionPerformed
       panel.setViewportView(new Bodega_Registrar());
    }//GEN-LAST:event_bodega_registrarActionPerformed

    private void bodega_consultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bodega_consultarActionPerformed
       panel.setViewportView(new Bodega_Consultar());
    }//GEN-LAST:event_bodega_consultarActionPerformed

    private void bodega_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bodega_actualizarActionPerformed
        panel.setViewportView(new Bodega_Actualizar());
    }//GEN-LAST:event_bodega_actualizarActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        GUI_Iniciar gui_Iniciar = new GUI_Iniciar();
        gui_Iniciar.setVisible(true);
        this.removeAll();
        this.setVisible(false);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void parametros_permisos_menuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_parametros_permisos_menuActionPerformed
       panel.setViewportView(new Permiso_Menu());
    }//GEN-LAST:event_parametros_permisos_menuActionPerformed

    private void clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_clienteActionPerformed

    private void movimiento_consultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_movimiento_consultarActionPerformed
        panel.setViewportView(new Movimientos_Consultar(user));
    }//GEN-LAST:event_movimiento_consultarActionPerformed

    private void compra_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_compra_eliminarActionPerformed
        try { 
            panel.setViewportView(new Compra_Eliminar(user));
        } catch (SQLException ex) {
            Logger.getLogger(Menu_Compra.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }//GEN-LAST:event_compra_eliminarActionPerformed

    private void movimiento_camarones_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_movimiento_camarones_editarActionPerformed
        panel.setViewportView(new Movimientos_Editar_Camarones(user));
    }//GEN-LAST:event_movimiento_camarones_editarActionPerformed

    private void movimiento_carton_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_movimiento_carton_editarActionPerformed
        panel.setViewportView(new Movimientos_Editar_Cajas(user));
    }//GEN-LAST:event_movimiento_carton_editarActionPerformed

    private void movimiento_anularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_movimiento_anularActionPerformed
         panel.setViewportView(new Movimientos_Anular(user));
    }//GEN-LAST:event_movimiento_anularActionPerformed

    private void ventaElectronica_extranjera_registrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ventaElectronica_extranjera_registrarActionPerformed
         panel.setViewportView(new VentaFacturacionElectronica_Registrar_BodExtranjera(user));  
    }//GEN-LAST:event_ventaElectronica_extranjera_registrarActionPerformed

    private void ventaPapel_extranjera_registrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ventaPapel_extranjera_registrarActionPerformed
        panel.setViewportView(new VentaFacturacionPapel_Registrar_BodExtranjera(user)); 
    }//GEN-LAST:event_ventaPapel_extranjera_registrarActionPerformed

    private void ventaElectronica_extranjera_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ventaElectronica_extranjera_editarActionPerformed
        panel.setViewportView(new VentaFacturacionElectronica_Editar_BodExtranjera(user)); 
    }//GEN-LAST:event_ventaElectronica_extranjera_editarActionPerformed

    private void ventaElectronica_nacional_registrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ventaElectronica_nacional_registrarActionPerformed
        panel.setViewportView(new VentaFacturacionElectronica_Registrar_BodNacional(user)); 
    }//GEN-LAST:event_ventaElectronica_nacional_registrarActionPerformed

    private void ventaElectronica_nacional_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ventaElectronica_nacional_editarActionPerformed
       panel.setViewportView(new VentaFacturacionElectronica_Editar_BodNacional(user)); 
    }//GEN-LAST:event_ventaElectronica_nacional_editarActionPerformed

    private void ventaElectronica_consultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ventaElectronica_consultarActionPerformed
        try { 
            panel.setViewportView(new VentaFacturacionElectronica_Consultar());
        } catch (SQLException ex) {
            Logger.getLogger(GUI_Principal1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ventaElectronica_consultarActionPerformed

    private void ventaElectronica_anularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ventaElectronica_anularActionPerformed
        try { 
            panel.setViewportView(new VentaFacturacionElectronica_Anular(user));
        } catch (SQLException ex) {
            Logger.getLogger(GUI_Principal1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ventaElectronica_anularActionPerformed

    private void ventaElectronica_modificar_dexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ventaElectronica_modificar_dexActionPerformed
        try {
            panel.setViewportView(new VentaFacturacionElectronica_ModificarDEX());
        } catch (SQLException ex) {
            Logger.getLogger(GUI_Principal1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ventaElectronica_modificar_dexActionPerformed

    private void ventaPapel_extranjera_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ventaPapel_extranjera_editarActionPerformed
       panel.setViewportView(new VentaFacturacionPapel_Editar_BodExtranjera(user));
    }//GEN-LAST:event_ventaPapel_extranjera_editarActionPerformed

    private void ventaPapel_nacional_registrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ventaPapel_nacional_registrarActionPerformed
        panel.setViewportView(new VentaFacturacionPapel_Registrar_BodNacional(user));
    }//GEN-LAST:event_ventaPapel_nacional_registrarActionPerformed

    private void ventaPapel_nacional_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ventaPapel_nacional_editarActionPerformed
        panel.setViewportView(new VentaFacturacionPapel_Editar_BodNacional(user));
    }//GEN-LAST:event_ventaPapel_nacional_editarActionPerformed

    private void ventaPapel_consultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ventaPapel_consultarActionPerformed
        try {
            panel.setViewportView(new VentaFacturacionPapel_Consultar());
        } catch (SQLException ex) {
            Logger.getLogger(GUI_Principal1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ventaPapel_consultarActionPerformed

    private void ventaPapel_anularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ventaPapel_anularActionPerformed
        try {
            panel.setViewportView(new VentaFacturacionPapel_Anular(user));
        } catch (SQLException ex) {
            Logger.getLogger(GUI_Principal1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ventaPapel_anularActionPerformed

    private void ventaPapel_modificar_dexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ventaPapel_modificar_dexActionPerformed
        try {
            panel.setViewportView(new VentaFacturacionPapel_ModificarDEX());
        } catch (SQLException ex) {
            Logger.getLogger(GUI_Principal1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ventaPapel_modificar_dexActionPerformed

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
            java.util.logging.Logger.getLogger(GUI_Principal1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_Principal1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_Principal1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_Principal1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_Principal1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu Consumo_Camarones;
    private javax.swing.JMenu Consumo_Carton;
    private javax.swing.JMenu Movimiento_Carton;
    private javax.swing.JMenu Salir;
    private javax.swing.JMenu Venta_Extranjera;
    private javax.swing.JMenu Venta_Nacional;
    private javax.swing.JMenu auditoria;
    private javax.swing.JMenuItem auditoria_consultar;
    private javax.swing.JMenu bodega;
    private javax.swing.JMenuItem bodega_actualizar;
    private javax.swing.JMenuItem bodega_consultar;
    private javax.swing.JMenuItem bodega_registrar;
    private javax.swing.JMenu cliente;
    private javax.swing.JMenuItem cliente_actualizar;
    private javax.swing.JMenuItem cliente_consultar;
    private javax.swing.JMenuItem cliente_registrar;
    private javax.swing.JMenu compra;
    private javax.swing.JMenuItem compra_anular;
    private javax.swing.JMenuItem compra_consultar;
    private javax.swing.JMenuItem compra_editar;
    private javax.swing.JMenuItem compra_eliminar;
    private javax.swing.JMenuItem compra_registrar;
    private javax.swing.JMenu consumo;
    private javax.swing.JMenuItem consumo_anular;
    private javax.swing.JMenuItem consumo_camarones_editar;
    private javax.swing.JMenuItem consumo_camarones_registrar;
    private javax.swing.JMenuItem consumo_carton_editar;
    private javax.swing.JMenuItem consumo_carton_registrar;
    private javax.swing.JMenuItem consumo_consultar;
    private javax.swing.JMenu empresa_local;
    private javax.swing.JMenuItem empresa_local_actualizar;
    private javax.swing.JMenuItem empresa_local_consultar;
    private javax.swing.JMenuItem empresa_local_registrar;
    private javax.swing.JLabel entradaAlmacenNo1;
    private javax.swing.JLabel fecha;
    private javax.swing.JMenu informe_anual;
    private javax.swing.JMenuItem informe_anual_crear;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu15;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenu movimiento;
    private javax.swing.JMenuItem movimiento_anular;
    private javax.swing.JMenuItem movimiento_camarones_editar;
    private javax.swing.JMenuItem movimiento_camarones_registrar;
    private javax.swing.JMenuItem movimiento_carton_editar;
    private javax.swing.JMenuItem movimiento_carton_registrar;
    private javax.swing.JMenuItem movimiento_consultar;
    private javax.swing.JLabel nombreUsuarioEnLinea;
    private javax.swing.JScrollPane panel;
    private javax.swing.JMenu parametros;
    private javax.swing.JMenuItem parametros_permisos_menu;
    private javax.swing.JMenuItem parametros_permisos_usuarios;
    private javax.swing.JMenu producto;
    private javax.swing.JMenuItem producto_actualizar;
    private javax.swing.JMenuItem producto_consultar;
    private javax.swing.JMenuItem producto_registrar;
    private javax.swing.JMenu proveedor;
    private javax.swing.JMenuItem proveedor_actualizar;
    private javax.swing.JMenuItem proveedor_consultar;
    private javax.swing.JMenuItem proveedor_registrar;
    private javax.swing.JMenu unidad;
    private javax.swing.JMenuItem unidad_actualizar;
    private javax.swing.JMenuItem unidad_consultar;
    private javax.swing.JMenuItem unidad_registrar;
    private javax.swing.JLabel userOnline;
    private javax.swing.JMenu usuario;
    private javax.swing.JMenuItem usuario_actualizar;
    private javax.swing.JMenuItem usuario_consultar;
    private javax.swing.JMenuItem usuario_registrar;
    private javax.swing.JMenu venta;
    private javax.swing.JMenuItem ventaElectronica_anular;
    private javax.swing.JMenuItem ventaElectronica_consultar;
    private javax.swing.JMenuItem ventaElectronica_extranjera_editar;
    private javax.swing.JMenuItem ventaElectronica_extranjera_registrar;
    private javax.swing.JMenuItem ventaElectronica_modificar_dex;
    private javax.swing.JMenuItem ventaElectronica_nacional_editar;
    private javax.swing.JMenuItem ventaElectronica_nacional_registrar;
    private javax.swing.JMenuItem ventaPapel_anular;
    private javax.swing.JMenuItem ventaPapel_consultar;
    private javax.swing.JMenuItem ventaPapel_extranjera_editar;
    private javax.swing.JMenuItem ventaPapel_extranjera_registrar;
    private javax.swing.JMenuItem ventaPapel_modificar_dex;
    private javax.swing.JMenuItem ventaPapel_nacional_editar;
    private javax.swing.JMenuItem ventaPapel_nacional_registrar;
    private javax.swing.JMenuItem venta_anular;
    private javax.swing.JMenuItem venta_consultar;
    private javax.swing.JMenuItem venta_extranjera_editar;
    private javax.swing.JMenuItem venta_extranjera_registrar;
    private javax.swing.JMenuItem venta_modificar_dex;
    private javax.swing.JMenuItem venta_nacional_editar;
    private javax.swing.JMenuItem venta_nacional_registrar;
    // End of variables declaration//GEN-END:variables
    
    
}
