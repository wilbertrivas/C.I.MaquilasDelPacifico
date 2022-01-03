/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

/**
 *
 * @author JQuery
 */
public class PermisoUsuario {
    private int usuario_id;
    private int permisos_id;
    private int estado;

    public PermisoUsuario() {
    }

    public PermisoUsuario(int usuario_id, int permisos_id, int estado) {
        this.usuario_id = usuario_id;
        this.permisos_id = permisos_id;
        this.estado = estado;
    }

    public int getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
    }

    public int getPermisos_id() {
        return permisos_id;
    }

    public void setPermisos_id(int permisos_id) {
        this.permisos_id = permisos_id;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
    
}
