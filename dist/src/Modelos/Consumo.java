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
public class Consumo {
    private int id;
    private String fechaConsumo;
    private int bodegaConsumo_id;
    private String cliente_nit;
    private int cliente_sucursal;
    private String empresaLocal_nit;
    private int empresaLocal_sucursal;
    private BigDecimal valorTotalEnPesos;
    private String observaciones;
    private int estado;
    private String nombreQuienElabora;

    public Consumo() {
    }

    public Consumo(int id, String fechaConsumo, int bodegaConsumo_id, String cliente_nit, int cliente_sucursal, String empresaLocal_nit, int empresaLocal_sucursal, BigDecimal valorTotalEnPesos, String observaciones, int estado, String nombreQuienElabora) {
        this.id = id;
        this.fechaConsumo = fechaConsumo;
        this.bodegaConsumo_id = bodegaConsumo_id;
        this.cliente_nit = cliente_nit;
        this.cliente_sucursal = cliente_sucursal;
        this.empresaLocal_nit = empresaLocal_nit;
        this.empresaLocal_sucursal = empresaLocal_sucursal;
        this.valorTotalEnPesos = valorTotalEnPesos;
        this.observaciones = observaciones;
        this.estado = estado;
        this.nombreQuienElabora = nombreQuienElabora;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFechaConsumo() {
        return fechaConsumo;
    }

    public void setFechaConsumo(String fechaConsumo) {
        this.fechaConsumo = fechaConsumo;
    }

    public int getBodegaConsumo_id() {
        return bodegaConsumo_id;
    }

    public void setBodegaConsumo_id(int bodegaConsumo_id) {
        this.bodegaConsumo_id = bodegaConsumo_id;
    }

    public String getCliente_nit() {
        return cliente_nit;
    }

    public void setCliente_nit(String cliente_nit) {
        this.cliente_nit = cliente_nit;
    }

    public int getCliente_sucursal() {
        return cliente_sucursal;
    }

    public void setCliente_sucursal(int cliente_sucursal) {
        this.cliente_sucursal = cliente_sucursal;
    }

    public String getEmpresaLocal_nit() {
        return empresaLocal_nit;
    }

    public void setEmpresaLocal_nit(String empresaLocal_nit) {
        this.empresaLocal_nit = empresaLocal_nit;
    }

    public int getEmpresaLocal_sucursal() {
        return empresaLocal_sucursal;
    }

    public void setEmpresaLocal_sucursal(int empresaLocal_sucursal) {
        this.empresaLocal_sucursal = empresaLocal_sucursal;
    }

    public BigDecimal getValorTotalEnPesos() {
        return valorTotalEnPesos;
    }

    public void setValorTotalEnPesos(BigDecimal valorTotalEnPesos) {
        this.valorTotalEnPesos = valorTotalEnPesos;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getNombreQuienElabora() {
        return nombreQuienElabora;
    }

    public void setNombreQuienElabora(String nombreQuienElabora) {
        this.nombreQuienElabora = nombreQuienElabora;
    }

}
