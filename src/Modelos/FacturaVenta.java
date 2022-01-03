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
public class FacturaVenta {
    private int id;
    private String dex;
    private String fechaFactura;
    private int bodegaFacturaVenta_id;
    private String cliente_nit;
    private int cliente_sucursal;
    private String empresaLocal_nit;
    private int empresaLocal_sucursal;
    private Double trm;
    private BigDecimal valorTotalEnDolarIngresados;
    private BigDecimal valorTotalEnDolarCalculados;
    private BigDecimal valorTotalEnPesosCalculados;
    private String observaciones;
    private int estado;
    private String nombreQuienElabora;

    public FacturaVenta() {
    }

    public FacturaVenta(int id, String dex, String fechaFactura, int bodegaFacturaVenta_id, String cliente_nit, int cliente_sucursal, String empresaLocal_nit, int empresaLocal_sucursal, Double trm, BigDecimal valorTotalEnDolarIngresados, BigDecimal valorTotalEnDolarCalculados, BigDecimal valorTotalEnPesosCalculados, String observaciones, int estado, String nombreQuienElabora) {
        this.id = id;
        this.dex = dex;
        this.fechaFactura = fechaFactura;
        this.bodegaFacturaVenta_id = bodegaFacturaVenta_id;
        this.cliente_nit = cliente_nit;
        this.cliente_sucursal = cliente_sucursal;
        this.empresaLocal_nit = empresaLocal_nit;
        this.empresaLocal_sucursal = empresaLocal_sucursal;
        this.trm = trm;
        this.valorTotalEnDolarIngresados = valorTotalEnDolarIngresados;
        this.valorTotalEnDolarCalculados = valorTotalEnDolarCalculados;
        this.valorTotalEnPesosCalculados = valorTotalEnPesosCalculados;
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

    public String getDex() {
        return dex;
    }

    public void setDex(String dex) {
        this.dex = dex;
    }

    public String getFechaFactura() {
        return fechaFactura;
    }

    public void setFechaFactura(String fechaFactura) {
        this.fechaFactura = fechaFactura;
    }

    public int getBodegaFacturaVenta_id() {
        return bodegaFacturaVenta_id;
    }

    public void setBodegaFacturaVenta_id(int bodegaFacturaVenta_id) {
        this.bodegaFacturaVenta_id = bodegaFacturaVenta_id;
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

    public Double getTrm() {
        return trm;
    }

    public void setTrm(Double trm) {
        this.trm = trm;
    }

    public BigDecimal getValorTotalEnDolarIngresados() {
        return valorTotalEnDolarIngresados;
    }

    public void setValorTotalEnDolarIngresados(BigDecimal valorTotalEnDolarIngresados) {
        this.valorTotalEnDolarIngresados = valorTotalEnDolarIngresados;
    }

    public BigDecimal getValorTotalEnDolarCalculados() {
        return valorTotalEnDolarCalculados;
    }

    public void setValorTotalEnDolarCalculados(BigDecimal valorTotalEnDolarCalculados) {
        this.valorTotalEnDolarCalculados = valorTotalEnDolarCalculados;
    }

    public BigDecimal getValorTotalEnPesosCalculados() {
        return valorTotalEnPesosCalculados;
    }

    public void setValorTotalEnPesosCalculados(BigDecimal valorTotalEnPesosCalculados) {
        this.valorTotalEnPesosCalculados = valorTotalEnPesosCalculados;
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