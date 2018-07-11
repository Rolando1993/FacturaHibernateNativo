/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.implementacion;

import com.proyecto.dao.IProductoDao;
import com.proyecto.entidades.Producto;
import com.proyecto.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author DUALPC
 */
public class ProductoDao implements IProductoDao{

    @Override
    public void insertar(Producto p) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(p);
        session.getTransaction().commit();
        session.close(); 
    }

    @Override
    public void actualizar(Producto p) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(p);
        session.getTransaction().commit();
        session.close(); 
    }

    @Override
    public void eliminar(Producto p) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(p);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Producto> getListaProductos() {
         List<Producto> lista = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query  = session.createQuery("From Producto");
        lista = (List<Producto>)query.list();
        session.close();
        return lista; 
    }

    @Override
    public Producto obtenerProductoPorCodigoDeBarra(Session sesion, String codBarra) throws Exception {
        String hql = "FROM Producto WHERE codigobarra = :codigobarra";
        Query q = sesion.createQuery(hql);
        q.setParameter("codigobarra", codBarra);
        return (Producto) q.uniqueResult();
    }
    
}
