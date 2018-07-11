/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.beans;

import com.proyecto.entidades.Cliente;
import com.proyecto.entidades.Producto;
import com.proyecto.negocio.IProductoBL;
import com.proyecto.negocio.ProductoBL;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author DUALPC
 */
@ManagedBean
@ViewScoped
public class ProductoMB implements Serializable {

    private Producto producto = new Producto();
    private List<Producto> listaProductos;
    IProductoBL productoBL = new ProductoBL();

    public ProductoMB() {
        producto = new Producto();
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public List<Producto> getListaProductos() {
        listaProductos = productoBL.consultarProducto();
        return listaProductos;
    }

    public void setListaProductos(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public void prepararNuevoProducto() {
        this.producto = new Producto();
    }

    public void save() {
        productoBL.save(getProducto());
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Datos Insertados Exitosamente"));
    }

    public void update() {
        productoBL.update(getProducto());
    }

    public void delete() {
        productoBL.delete(getProducto());
    }

}
