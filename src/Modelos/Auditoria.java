/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.math.BigDecimal;

/**
 *
 * @author JQuery
 */
public class Auditoria {
    private String id;  //En la base de datos es BIGINT (18.446.744.073.709.551.615)
    private String fechaMovimiento;
    private String cp;
    private String idTipoMovimiento;
    private String descripcionTipoMovimiento;
    private String bodegaOrigen;
    private String bodegaDestino;
    private int usuario_id;
    private BigDecimal cantidad;
    private String fechaRegistroSistema;

    public Auditoria() {
    }

    public Auditoria(String id, String fechaMovimiento, String cp, String idTipoMovimiento, String descripcionTipoMovimiento, String bodegaOrigen, String bodegaDestino, int usuario_id, BigDecimal cantidad, String fechaRegistroSistema) {
        this.id = id;
        this.fechaMovimiento = fechaMovimiento;
        this.cp = cp;
        this.idTipoMovimiento = idTipoMovimiento;
        this.descripcionTipoMovimiento = descripcionTipoMovimiento;
        this.bodegaOrigen = bodegaOrigen;
        this.bodegaDestino = bodegaDestino;
        this.usuario_id = usuario_id;
        this.cantidad = cantidad;
        this.fechaRegistroSistema = fechaRegistroSistema;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFechaMovimiento() {
        return fechaMovimiento;
    }

    public void setFechaMovimiento(String fechaMovimiento) {
        this.fechaMovimiento = fechaMovimiento;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getIdTipoMovimiento() {
        return idTipoMovimiento;
    }

    public void setIdTipoMovimiento(String idTipoMovimiento) {
        this.idTipoMovimiento = idTipoMovimiento;
    }

    public String getDescripcionTipoMovimiento() {
        return descripcionTipoMovimiento;
    }

    public void setDescripcionTipoMovimiento(String descripcionTipoMovimiento) {
        this.descripcionTipoMovimiento = descripcionTipoMovimiento;
    }

    public String getBodegaOrigen() {
        return bodegaOrigen;
    }

    public void setBodegaOrigen(String bodegaOrigen) {
        this.bodegaOrigen = bodegaOrigen;
    }

    public String getBodegaDestino() {
        return bodegaDestino;
    }

    public void setBodegaDestino(String bodegaDestino) {
        this.bodegaDestino = bodegaDestino;
    }

    public int getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(int usuario_id) {
        this.usuario_id = usuario_id;
    }

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }

    public String getFechaRegistroSistema() {
        return fechaRegistroSistema;
    }

    public void setFechaRegistroSistema(String fechaRegistroSistema) {
        this.fechaRegistroSistema = fechaRegistroSistema;
    }

}
