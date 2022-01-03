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
public class Producto {
    private int id;
    private String descripcion;
    private String tipo;
    private String SubpartidaArancelaria;
    private int Unidad_id;
    private int estado;

    public Producto() {
    }

    public Producto(int id, String descripcion, String tipo, String SubpartidaArancelaria, int Unidad_id, int estado) {
        this.id = id;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.SubpartidaArancelaria = SubpartidaArancelaria;
        this.Unidad_id = Unidad_id;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getSubpartidaArancelaria() {
        return SubpartidaArancelaria;
    }

    public void setSubpartidaArancelaria(String SubpartidaArancelaria) {
        this.SubpartidaArancelaria = SubpartidaArancelaria;
    }

    public int getUnidad_id() {
        return Unidad_id;
    }

    public void setUnidad_id(int Unidad_id) {
        this.Unidad_id = Unidad_id;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

   
}
