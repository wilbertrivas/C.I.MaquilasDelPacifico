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
public class ItemConsumoEditar {
    private int idConsumo;
    private int idIngresoProducto;
    private BigDecimal cantidad;
    private Double valorUnitarioKilo;
    private BigDecimal total;
    private boolean cargadoEnFactura;

    public ItemConsumoEditar() {
    }

    public ItemConsumoEditar(int idConsumo, int idIngresoProducto, BigDecimal cantidad, Double valorUnitarioKilo, BigDecimal total, boolean cargadoEnFactura) {
        this.idConsumo = idConsumo;
        this.idIngresoProducto = idIngresoProducto;
        this.cantidad = cantidad;
        this.valorUnitarioKilo = valorUnitarioKilo;
        this.total = total;
        this.cargadoEnFactura = cargadoEnFactura;
    }

    public int getIdConsumo() {
        return idConsumo;
    }

    public void setIdConsumo(int idConsumo) {
        this.idConsumo = idConsumo;
    }

    public int getIdIngresoProducto() {
        return idIngresoProducto;
    }

    public void setIdIngresoProducto(int idIngresoProducto) {
        this.idIngresoProducto = idIngresoProducto;
    }

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }

    public Double getValorUnitarioKilo() {
        return valorUnitarioKilo;
    }

    public void setValorUnitarioKilo(Double valorUnitarioKilo) {
        this.valorUnitarioKilo = valorUnitarioKilo;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public boolean isCargadoEnFactura() {
        return cargadoEnFactura;
    }

    public void setCargadoEnFactura(boolean cargadoEnFactura) {
        this.cargadoEnFactura = cargadoEnFactura;
    }

   
}
