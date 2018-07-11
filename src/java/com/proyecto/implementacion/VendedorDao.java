/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.implementacion;

import com.proyecto.dao.IVendedorDao;
import com.proyecto.entidades.Vendedor;
import com.proyecto.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author DUALPC
 */
public class VendedorDao implements IVendedorDao{

    @Override
    public void insertar(Vendedor v) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(v);
        session.getTransaction().commit();
        session.close(); 
    }

    @Override
    public void actualizar(Vendedor v) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(v);
        session.getTransaction().commit();
        session.close();  
    }

    @Override
    public void eliminar(Vendedor v) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(v);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Vendedor> getListaVendedores() {
        List<Vendedor> lista = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query  = session.createQuery("From Vendedor");
        lista = (List<Vendedor>)query.list();
        session.close();
        return lista; 
    }
    
}
