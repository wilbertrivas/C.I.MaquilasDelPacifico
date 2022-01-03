
package Modelos;

import java.math.BigDecimal;


public class Movimiento {
    //Ingreso_Productos___________________________________________________
    private String IngresoProducto_id;
    private String IngresoProducto_cp;
    private String IngresoProducto_proveedor_nit;
    private int IngresoProducto_proveedor_sucursal;
    private int IngresoProducto_producto_id;
    private String IngresoProducto_numeroFacturaProveedor;
    private String IngresoProducto_resolucionFactura;
    private String IngresoProducto_fechaResolucion;
    private String IngresoProducto_fechaCompra;
    private String IngresoProducto_fechaMaximaExportacion;
    private BigDecimal IngresoProducto_cantidadInicial;
    private BigDecimal IngresoProducto_valorUnitario;
    private String IngresoProducto_observacion;
    private int IngresoProducto_estado;
    private String IngresoProducto_nombreQuienElabora;
    private int IngresoProducto_bodega_ingresoProductoInicial;
    private BigDecimal IngresoProducto_costoTotal;
    //_________________________________________________________________
    private int Bodega_id;
    private String Bodega_Descripcion;
    private int Bodega_saldo;
    private int Bodega_estado;
    private int Producto_id;
    private String Producto_descripcion;

    public Movimiento() {
    }

    public Movimiento(String IngresoProducto_id, String IngresoProducto_cp, String IngresoProducto_proveedor_nit, int IngresoProducto_proveedor_sucursal, int IngresoProducto_producto_id, String IngresoProducto_numeroFacturaProveedor, String IngresoProducto_resolucionFactura, String IngresoProducto_fechaResolucion, String IngresoProducto_fechaCompra, String IngresoProducto_fechaMaximaExportacion, BigDecimal IngresoProducto_cantidadInicial, BigDecimal IngresoProducto_valorUnitario, String IngresoProducto_observacion, int IngresoProducto_estado, String IngresoProducto_nombreQuienElabora, int IngresoProducto_bodega_ingresoProductoInicial, BigDecimal IngresoProducto_costoTotal, int Bodega_id, String Bodega_Descripcion, int Bodega_saldo, int Bodega_estado, int Producto_id, String Producto_descripcion) {
        this.IngresoProducto_id = IngresoProducto_id;
        this.IngresoProducto_cp = IngresoProducto_cp;
        this.IngresoProducto_proveedor_nit = IngresoProducto_proveedor_nit;
        this.IngresoProducto_proveedor_sucursal = IngresoProducto_proveedor_sucursal;
        this.IngresoProducto_producto_id = IngresoProducto_producto_id;
        this.IngresoProducto_numeroFacturaProveedor = IngresoProducto_numeroFacturaProveedor;
        this.IngresoProducto_resolucionFactura = IngresoProducto_resolucionFactura;
        this.IngresoProducto_fechaResolucion = IngresoProducto_fechaResolucion;
        this.IngresoProducto_fechaCompra = IngresoProducto_fechaCompra;
        this.IngresoProducto_fechaMaximaExportacion = IngresoProducto_fechaMaximaExportacion;
        this.IngresoProducto_cantidadInicial = IngresoProducto_cantidadInicial;
        this.IngresoProducto_valorUnitario = IngresoProducto_valorUnitario;
        this.IngresoProducto_observacion = IngresoProducto_observacion;
        this.IngresoProducto_estado = IngresoProducto_estado;
        this.IngresoProducto_nombreQuienElabora = IngresoProducto_nombreQuienElabora;
        this.IngresoProducto_bodega_ingresoProductoInicial = IngresoProducto_bodega_ingresoProductoInicial;
        this.IngresoProducto_costoTotal = IngresoProducto_costoTotal;
        this.Bodega_id = Bodega_id;
        this.Bodega_Descripcion = Bodega_Descripcion;
        this.Bodega_saldo = Bodega_saldo;
        this.Bodega_estado = Bodega_estado;
        this.Producto_id = Producto_id;
        this.Producto_descripcion = Producto_descripcion;
    }

    public String getIngresoProducto_id() {
        return IngresoProducto_id;
    }

    public void setIngresoProducto_id(String IngresoProducto_id) {
        this.IngresoProducto_id = IngresoProducto_id;
    }

    public String getIngresoProducto_cp() {
        return IngresoProducto_cp;
    }

    public void setIngresoProducto_cp(String IngresoProducto_cp) {
        this.IngresoProducto_cp = IngresoProducto_cp;
    }

    public String getIngresoProducto_proveedor_nit() {
        return IngresoProducto_proveedor_nit;
    }

    public void setIngresoProducto_proveedor_nit(String IngresoProducto_proveedor_nit) {
        this.IngresoProducto_proveedor_nit = IngresoProducto_proveedor_nit;
    }

    public int getIngresoProducto_proveedor_sucursal() {
        return IngresoProducto_proveedor_sucursal;
    }

    public void setIngresoProducto_proveedor_sucursal(int IngresoProducto_proveedor_sucursal) {
        this.IngresoProducto_proveedor_sucursal = IngresoProducto_proveedor_sucursal;
    }

    public int getIngresoProducto_producto_id() {
        return IngresoProducto_producto_id;
    }

    public void setIngresoProducto_producto_id(int IngresoProducto_producto_id) {
        this.IngresoProducto_producto_id = IngresoProducto_producto_id;
    }

    public String getIngresoProducto_numeroFacturaProveedor() {
        return IngresoProducto_numeroFacturaProveedor;
    }

    public void setIngresoProducto_numeroFacturaProveedor(String IngresoProducto_numeroFacturaProveedor) {
        this.IngresoProducto_numeroFacturaProveedor = IngresoProducto_numeroFacturaProveedor;
    }

    public String getIngresoProducto_resolucionFactura() {
        return IngresoProducto_resolucionFactura;
    }

    public void setIngresoProducto_resolucionFactura(String IngresoProducto_resolucionFactura) {
        this.IngresoProducto_resolucionFactura = IngresoProducto_resolucionFactura;
    }

    public String getIngresoProducto_fechaResolucion() {
        return IngresoProducto_fechaResolucion;
    }

    public void setIngresoProducto_fechaResolucion(String IngresoProducto_fechaResolucion) {
        this.IngresoProducto_fechaResolucion = IngresoProducto_fechaResolucion;
    }

    public String getIngresoProducto_fechaCompra() {
        return IngresoProducto_fechaCompra;
    }

    public void setIngresoProducto_fechaCompra(String IngresoProducto_fechaCompra) {
        this.IngresoProducto_fechaCompra = IngresoProducto_fechaCompra;
    }

    public String getIngresoProducto_fechaMaximaExportacion() {
        return IngresoProducto_fechaMaximaExportacion;
    }

    public void setIngresoProducto_fechaMaximaExportacion(String IngresoProducto_fechaMaximaExportacion) {
        this.IngresoProducto_fechaMaximaExportacion = IngresoProducto_fechaMaximaExportacion;
    }

    public BigDecimal getIngresoProducto_cantidadInicial() {
        return IngresoProducto_cantidadInicial;
    }

    public void setIngresoProducto_cantidadInicial(BigDecimal IngresoProducto_cantidadInicial) {
        this.IngresoProducto_cantidadInicial = IngresoProducto_cantidadInicial;
    }

    public BigDecimal getIngresoProducto_valorUnitario() {
        return IngresoProducto_valorUnitario;
    }

    public void setIngresoProducto_valorUnitario(BigDecimal IngresoProducto_valorUnitario) {
        this.IngresoProducto_valorUnitario = IngresoProducto_valorUnitario;
    }

    public String getIngresoProducto_observacion() {
        return IngresoProducto_observacion;
    }

    public void setIngresoProducto_observacion(String IngresoProducto_observacion) {
        this.IngresoProducto_observacion = IngresoProducto_observacion;
    }

    public int getIngresoProducto_estado() {
        return IngresoProducto_estado;
    }

    public void setIngresoProducto_estado(int IngresoProducto_estado) {
        this.IngresoProducto_estado = IngresoProducto_estado;
    }

    public String getIngresoProducto_nombreQuienElabora() {
        return IngresoProducto_nombreQuienElabora;
    }

    public void setIngresoProducto_nombreQuienElabora(String IngresoProducto_nombreQuienElabora) {
        this.IngresoProducto_nombreQuienElabora = IngresoProducto_nombreQuienElabora;
    }

    public int getIngresoProducto_bodega_ingresoProductoInicial() {
        return IngresoProducto_bodega_ingresoProductoInicial;
    }

    public void setIngresoProducto_bodega_ingresoProductoInicial(int IngresoProducto_bodega_ingresoProductoInicial) {
        this.IngresoProducto_bodega_ingresoProductoInicial = IngresoProducto_bodega_ingresoProductoInicial;
    }

    public BigDecimal getIngresoProducto_costoTotal() {
        return IngresoProducto_costoTotal;
    }

    public void setIngresoProducto_costoTotal(BigDecimal IngresoProducto_costoTotal) {
        this.IngresoProducto_costoTotal = IngresoProducto_costoTotal;
    }

    public int getBodega_id() {
        return Bodega_id;
    }

    public void setBodega_id(int Bodega_id) {
        this.Bodega_id = Bodega_id;
    }

    public String getBodega_Descripcion() {
        return Bodega_Descripcion;
    }

    public void setBodega_Descripcion(String Bodega_Descripcion) {
        this.Bodega_Descripcion = Bodega_Descripcion;
    }

    public int getBodega_saldo() {
        return Bodega_saldo;
    }

    public void setBodega_saldo(int Bodega_saldo) {
        this.Bodega_saldo = Bodega_saldo;
    }

    public int getBodega_estado() {
        return Bodega_estado;
    }

    public void setBodega_estado(int Bodega_estado) {
        this.Bodega_estado = Bodega_estado;
    }

    public int getProducto_id() {
        return Producto_id;
    }

    public void setProducto_id(int Producto_id) {
        this.Producto_id = Producto_id;
    }

    public String getProducto_descripcion() {
        return Producto_descripcion;
    }

    public void setProducto_descripcion(String Producto_descripcion) {
        this.Producto_descripcion = Producto_descripcion;
    }

    
}
