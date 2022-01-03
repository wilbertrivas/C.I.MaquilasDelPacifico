package Modelos;

import java.math.BigDecimal;

public class IngresoProducto {
    private String id;
    private String cp;
    private String proveedor_nit;
    private int proveedor_sucursal;
    private int producto_id;
    private String numeroFacturaProveedor;
    private String resolucionFactura;
    private String fechaResolucion;
    private String fechaCompra;
    private String fechaMaximaExportacion;
    private BigDecimal cantidadInicial;
    private BigDecimal valorUnitario;
    private String observacion;
    private int estado;
    private String nombreQuienElabora;
    private int bodega_ingresoProductoInicial;
    private BigDecimal costoTotal;

    public IngresoProducto() {
    }

    public IngresoProducto(String id, String cp, String proveedor_nit, int proveedor_sucursal, int producto_id, String numeroFacturaProveedor, String resolucionFactura, String fechaResolucion, String fechaCompra, String fechaMaximaExportacion, BigDecimal cantidadInicial, BigDecimal valorUnitario, String observacion, int estado, String nombreQuienElabora, int bodega_ingresoProductoInicial, BigDecimal costoTotal) {
        this.id = id;
        this.cp = cp;
        this.proveedor_nit = proveedor_nit;
        this.proveedor_sucursal = proveedor_sucursal;
        this.producto_id = producto_id;
        this.numeroFacturaProveedor = numeroFacturaProveedor;
        this.resolucionFactura = resolucionFactura;
        this.fechaResolucion = fechaResolucion;
        this.fechaCompra = fechaCompra;
        this.fechaMaximaExportacion = fechaMaximaExportacion;
        this.cantidadInicial = cantidadInicial;
        this.valorUnitario = valorUnitario;
        this.observacion = observacion;
        this.estado = estado;
        this.nombreQuienElabora = nombreQuienElabora;
        this.bodega_ingresoProductoInicial = bodega_ingresoProductoInicial;
        this.costoTotal = costoTotal;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getProveedor_nit() {
        return proveedor_nit;
    }

    public void setProveedor_nit(String proveedor_nit) {
        this.proveedor_nit = proveedor_nit;
    }

    public int getProveedor_sucursal() {
        return proveedor_sucursal;
    }

    public void setProveedor_sucursal(int proveedor_sucursal) {
        this.proveedor_sucursal = proveedor_sucursal;
    }

    public int getProducto_id() {
        return producto_id;
    }

    public void setProducto_id(int producto_id) {
        this.producto_id = producto_id;
    }

    public String getNumeroFacturaProveedor() {
        return numeroFacturaProveedor;
    }

    public void setNumeroFacturaProveedor(String numeroFacturaProveedor) {
        this.numeroFacturaProveedor = numeroFacturaProveedor;
    }

    public String getResolucionFactura() {
        return resolucionFactura;
    }

    public void setResolucionFactura(String resolucionFactura) {
        this.resolucionFactura = resolucionFactura;
    }

    public String getFechaResolucion() {
        return fechaResolucion;
    }

    public void setFechaResolucion(String fechaResolucion) {
        this.fechaResolucion = fechaResolucion;
    }

    public String getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(String fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public String getFechaMaximaExportacion() {
        return fechaMaximaExportacion;
    }

    public void setFechaMaximaExportacion(String fechaMaximaExportacion) {
        this.fechaMaximaExportacion = fechaMaximaExportacion;
    }

    public BigDecimal getCantidadInicial() {
        return cantidadInicial;
    }

    public void setCantidadInicial(BigDecimal cantidadInicial) {
        this.cantidadInicial = cantidadInicial;
    }

    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
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

    public String getNombreQuienElabora() {
        return nombreQuienElabora;
    }

    public void setNombreQuienElabora(String nombreQuienElabora) {
        this.nombreQuienElabora = nombreQuienElabora;
    }

    public int getBodega_ingresoProductoInicial() {
        return bodega_ingresoProductoInicial;
    }

    public void setBodega_ingresoProductoInicial(int bodega_ingresoProductoInicial) {
        this.bodega_ingresoProductoInicial = bodega_ingresoProductoInicial;
    }

    public BigDecimal getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(BigDecimal costoTotal) {
        this.costoTotal = costoTotal;
    }

   
}
