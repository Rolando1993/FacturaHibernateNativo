/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.negocio;

import com.proyecto.entidades.Vendedor;
import java.util.List;

/**
 *
 * @author DUALPC
 */
public interface IVendedorBL {
    
    void save(Vendedor v);
    void update(Vendedor v);
    void delete(Vendedor v);
    List<Vendedor> consultarVendedor();
    
    
}
