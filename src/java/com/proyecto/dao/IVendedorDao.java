/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.dao;

import com.proyecto.entidades.Vendedor;
import java.util.List;

/**
 *
 * @author DUALPC
 */
public interface IVendedorDao {
    
    void insertar(Vendedor v);
    void actualizar(Vendedor v);
    void eliminar(Vendedor v);
    List<Vendedor> getListaVendedores();
    
}
