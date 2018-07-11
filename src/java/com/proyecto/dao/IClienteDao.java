/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.dao;

import com.proyecto.entidades.Cliente;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;



/**
 *
 * @author DUALPC
 */
public interface IClienteDao {
    
    void insertar(Cliente c);
    void actualizar(Cliente c);
    void eliminar(Cliente c);
    List<Cliente> getListaClientes();
    //public Cliente obtenerClientePorCodigo(EntityManager emf, Integer codCliente)throws Exception;
    //public ArrayList<Cliente> getObtenerClientePorCodigo(Integer codCliente);
    public Cliente obtenerClientePorCodigo(Session sesion, Integer codCliente)throws Exception;
    
}
