package com.proyecto.entidades;
// Generated 23/06/2018 11:28:12 by Hibernate Tools 4.3.1


import java.math.BigDecimal;

/**
 * Detallefactura generated by hbm2java
 */
public class Detallefactura  implements java.io.Serializable {


     private int codigodetalle;
     private Factura factura;
     private Producto producto;
     private String codigobarra;
     private String nombre;
     private Integer cantidad;
     private BigDecimal precioventa;
     private BigDecimal total;

    public Detallefactura() {
    }

	
    public Detallefactura(int codigodetalle, Factura factura, Producto producto) {
        this.codigodetalle = codigodetalle;
        this.factura = factura;
        this.producto = producto;
    }
    public Detallefactura(int codigodetalle, Factura factura, Producto producto, String codigobarra, String nombre, Integer cantidad, BigDecimal precioventa, BigDecimal total) {
       this.codigodetalle = codigodetalle;
       this.factura = factura;
       this.producto = producto;
       this.codigobarra = codigobarra;
       this.nombre = nombre;
       this.cantidad = cantidad;
       this.precioventa = precioventa;
       this.total = total;
    }
    
     public Detallefactura(Factura factura, Producto producto, String codigobarra, String nombre, Integer cantidad, BigDecimal precioventa, BigDecimal total) {
       this.factura = factura;
       this.producto = producto;
       this.codigobarra = codigobarra;
       this.nombre = nombre;
       this.cantidad = cantidad;
       this.precioventa = precioventa;
       this.total = total;
    }
   
    public int getCodigodetalle() {
        return this.codigodetalle;
    }
    
    public void setCodigodetalle(int codigodetalle) {
        this.codigodetalle = codigodetalle;
    }
    public Factura getFactura() {
        return this.factura;
    }
    
    public void setFactura(Factura factura) {
        this.factura = factura;
    }
    public Producto getProducto() {
        return this.producto;
    }
    
    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    public String getCodigobarra() {
        return this.codigobarra;
    }
    
    public void setCodigobarra(String codigobarra) {
        this.codigobarra = codigobarra;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Integer getCantidad() {
        return this.cantidad;
    }
    
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
    public BigDecimal getPrecioventa() {
        return this.precioventa;
    }
    
    public void setPrecioventa(BigDecimal precioventa) {
        this.precioventa = precioventa;
    }
    public BigDecimal getTotal() {
        return this.total;
    }
    
    public void setTotal(BigDecimal total) {
        this.total = total;
    }




}


