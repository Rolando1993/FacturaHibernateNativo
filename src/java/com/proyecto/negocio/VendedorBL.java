/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.negocio;

import com.proyecto.dao.IVendedorDao;
import com.proyecto.implementacion.VendedorDao;
import com.proyecto.entidades.Vendedor;
import java.util.List;

/**
 *
 * @author DUALPC
 */
public class VendedorBL implements IVendedorBL{
    
    IVendedorDao vendedorDao = new VendedorDao();

    @Override
    public void save(Vendedor v) {
       this.vendedorDao.insertar(v);
    }

    @Override
    public void update(Vendedor v) {
        this.vendedorDao.actualizar(v);
    }

    @Override
    public void delete(Vendedor v) {
        this.vendedorDao.eliminar(v);
    }

    @Override
    public List<Vendedor> consultarVendedor() {
        return this.vendedorDao.getListaVendedores();
    }
    
}
