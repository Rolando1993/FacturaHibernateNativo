/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.negocio;

import com.proyecto.entidades.Cliente;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author DUALPC
 */
public interface ICLienteBL {
    
    void save(Cliente c);
    void update(Cliente c);
    void delete(Cliente c);
    List<Cliente> consultarCliente();
    //public Cliente obtenerCliente(EntityManager emf, Integer codCliente)throws Exception;
    //public ArrayList<Cliente> obtenerCliente(Integer codCliente);
    public Cliente obtenerCliente(Session sesion, Integer codCliente)throws Exception;
}
