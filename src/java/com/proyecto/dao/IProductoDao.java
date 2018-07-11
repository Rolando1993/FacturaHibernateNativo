/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.dao;


import com.proyecto.entidades.Producto;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author DUALPC
 */
public interface IProductoDao {
    
    void insertar(Producto p);
    void actualizar(Producto p);
    void eliminar(Producto p);
    List<Producto> getListaProductos();
    public Producto obtenerProductoPorCodigoDeBarra(Session sesion, String codBarra)throws Exception;
}
