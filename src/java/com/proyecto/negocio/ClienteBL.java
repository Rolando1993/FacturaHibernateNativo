/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.negocio;

import com.proyecto.implementacion.ClienteDao;
import com.proyecto.dao.IClienteDao;
import com.proyecto.entidades.Cliente;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author DUALPC
 */
public class ClienteBL implements ICLienteBL{
    
    IClienteDao clienteDao = new ClienteDao();

    @Override
    public void save(Cliente c) {
        this.clienteDao.insertar(c);
    }

    @Override
    public void update(Cliente c) {
        this.clienteDao.actualizar(c);
    }

    @Override
    public void delete(Cliente c) {
        this.clienteDao.eliminar(c);
    }

    @Override
    public List<Cliente> consultarCliente() {
       return this.clienteDao.getListaClientes();
    }

    
    @Override
    public Cliente obtenerCliente(Session sesion, Integer codCliente) throws Exception {
        return this.clienteDao.obtenerClientePorCodigo(sesion, codCliente);
    }
    
}
