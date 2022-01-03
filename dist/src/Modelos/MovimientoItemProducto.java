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
public class MovimientoItemProducto {
    private int ingresoProducto_id;
    private int movimientoProducto_id;
    private int bodegaMovimiento_id;
    private String bodegaOrigen;
    private String bodegaDestino;
    private int saldoAnterior;
    private int cantidadTrasladada;
    private int saldoActual;

    public MovimientoItemProducto() {
    }

    public MovimientoItemProducto(int ingresoProducto_id, int movimientoProducto_id, int bodegaMovimiento_id, String bodegaOrigen, String bodegaDestino, int saldoAnterior, int cantidadTrasladada, int saldoActual) {
        this.ingresoProducto_id = ingresoProducto_id;
        this.movimientoProducto_id = movimientoProducto_id;
        this.bodegaMovimiento_id = bodegaMovimiento_id;
        this.bodegaOrigen = bodegaOrigen;
        this.bodegaDestino = bodegaDestino;
        this.saldoAnterior = saldoAnterior;
        this.cantidadTrasladada = cantidadTrasladada;
        this.saldoActual = saldoActual;
    }

    public int getIngresoProducto_id() {
        return ingresoProducto_id;
    }

    public void setIngresoProducto_id(int ingresoProducto_id) {
        this.ingresoProducto_id = ingresoProducto_id;
    }

    public int getMovimientoProducto_id() {
        return movimientoProducto_id;
    }

    public void setMovimientoProducto_id(int movimientoProducto_id) {
        this.movimientoProducto_id = movimientoProducto_id;
    }

    public int getBodegaMovimiento_id() {
        return bodegaMovimiento_id;
    }

    public void setBodegaMovimiento_id(int bodegaMovimiento_id) {
        this.bodegaMovimiento_id = bodegaMovimiento_id;
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

    public int getSaldoAnterior() {
        return saldoAnterior;
    }

    public void setSaldoAnterior(int saldoAnterior) {
        this.saldoAnterior = saldoAnterior;
    }

    public int getCantidadTrasladada() {
        return cantidadTrasladada;
    }

    public void setCantidadTrasladada(int cantidadTrasladada) {
        this.cantidadTrasladada = cantidadTrasladada;
    }

    public int getSaldoActual() {
        return saldoActual;
    }

    public void setSaldoActual(int saldoActual) {
        this.saldoActual = saldoActual;
    }
    
}
