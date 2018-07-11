/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.negocio;

import com.proyecto.dao.IProductoDao;
import com.proyecto.implementacion.ProductoDao;
import com.proyecto.entidades.Producto;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author DUALPC
 */
public class ProductoBL implements IProductoBL{
    
    IProductoDao productoDao = new ProductoDao();

    @Override
    public void save(Producto p) {
        this.productoDao.insertar(p);
    }

    @Override
    public void update(Producto p) {
        this.productoDao.actualizar(p);
    }

    @Override
    public void delete(Producto p) {
        this.productoDao.eliminar(p);
    }

    @Override
    public List<Producto> consultarProducto() {
        return this.productoDao.getListaProductos();
    }

    @Override
    public Producto obtenerProducto(Session sesion, String codBarra) throws Exception {
        return this.productoDao.obtenerProductoPorCodigoDeBarra(sesion, codBarra);
    }
    
}
