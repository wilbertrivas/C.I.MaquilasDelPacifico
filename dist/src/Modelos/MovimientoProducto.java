/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

import java.util.ArrayList;

/**
 *
 * @author JQuery
 */
public class MovimientoProducto {
    private int id;
    private String fechaMovimiento;
    private String nombreQuienElabora;
    private ArrayList<MovimientoItemProducto> movimientoItemProducto;
    private int estado; 

    public MovimientoProducto() {
    }

    public MovimientoProducto(int id, String fechaMovimiento, String nombreQuienElabora, ArrayList<MovimientoItemProducto> movimientoItemProducto, int estado) {
        this.id = id;
        this.fechaMovimiento = fechaMovimiento;
        this.nombreQuienElabora = nombreQuienElabora;
        this.movimientoItemProducto = movimientoItemProducto;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFechaMovimiento() {
        return fechaMovimiento;
    }

    public void setFechaMovimiento(String fechaMovimiento) {
        this.fechaMovimiento = fechaMovimiento;
    }

    public String getNombreQuienElabora() {
        return nombreQuienElabora;
    }

    public void setNombreQuienElabora(String nombreQuienElabora) {
        this.nombreQuienElabora = nombreQuienElabora;
    }

    public ArrayList<MovimientoItemProducto> getMovimientoItemProducto() {
        return movimientoItemProducto;
    }

    public void setMovimientoItemProducto(ArrayList<MovimientoItemProducto> movimientoItemProducto) {
        this.movimientoItemProducto = movimientoItemProducto;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
 
}
