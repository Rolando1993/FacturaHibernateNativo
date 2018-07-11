/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.implementacion;

import com.proyecto.dao.IClienteDao;
import com.proyecto.entidades.Cliente;
import com.proyecto.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author DUALPC
 */
public class ClienteDao implements IClienteDao{

    @Override
    public void insertar(Cliente c) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(c);
        session.getTransaction().commit();
        session.close(); 
    }

    @Override
    public void actualizar(Cliente c) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(c);
        session.getTransaction().commit();
        session.close();  
    }

    @Override
    public void eliminar(Cliente c) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(c);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Cliente> getListaClientes() {
        List<Cliente> lista = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query  = session.createQuery("From Cliente");
        lista = (List<Cliente>)query.list();
        session.close();
        return lista; 
    }

    @Override
    public Cliente obtenerClientePorCodigo(Session sesion, Integer codCliente) throws Exception {
        String hql = "FROM Cliente WHERE codigocliente = :codigocliente";
        Query q = sesion.createQuery(hql);
        q.setParameter("codigocliente", codCliente);
        return (Cliente) q.uniqueResult();
        
    }
    
}
