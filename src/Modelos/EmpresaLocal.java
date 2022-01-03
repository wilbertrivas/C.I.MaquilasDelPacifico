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
public class EmpresaLocal {
    private String nit;
    private String digitoVerificacion;
    private int sucursal;
    private String nombre;
    private int tipoEmpresaLocal_id;
    private String telefono;
    private String celular;
    private String direccion;
    private String correo;
    private String ciudad;
    private String observacion;
    private int estado;

    public EmpresaLocal() {
    }

    public EmpresaLocal(String nit, String digitoVerificacion, int sucursal, String nombre, int tipoEmpresaLocal_id, String telefono, String celular, String direccion, String correo, String ciudad, String observacion, int estado) {
        this.nit = nit;
        this.digitoVerificacion = digitoVerificacion;
        this.sucursal = sucursal;
        this.nombre = nombre;
        this.tipoEmpresaLocal_id = tipoEmpresaLocal_id;
        this.telefono = telefono;
        this.celular = celular;
        this.direccion = direccion;
        this.correo = correo;
        this.ciudad = ciudad;
        this.observacion = observacion;
        this.estado = estado;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getDigitoVerificacion() {
        return digitoVerificacion;
    }

    public void setDigitoVerificacion(String digitoVerificacion) {
        this.digitoVerificacion = digitoVerificacion;
    }

    public int getSucursal() {
        return sucursal;
    }

    public void setSucursal(int sucursal) {
        this.sucursal = sucursal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTipoEmpresaLocal_id() {
        return tipoEmpresaLocal_id;
    }

    public void setTipoEmpresaLocal_id(int tipoEmpresaLocal_id) {
        this.tipoEmpresaLocal_id = tipoEmpresaLocal_id;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }


}
