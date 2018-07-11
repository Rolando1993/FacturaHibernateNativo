/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.negocio;

import com.proyecto.entidades.Producto;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author DUALPC
 */
public interface IProductoBL {
    
    void save(Producto p);
    void update(Producto p);
    void delete(Producto p);
    List<Producto> consultarProducto();
    public Producto obtenerProducto(Session sesion, String codBarra)throws Exception;
    
}
