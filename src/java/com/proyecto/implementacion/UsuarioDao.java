/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.implementacion;

import com.proyecto.dao.IUsuarioDao;
import com.proyecto.encriptar.EncriptarContraseña;
import com.proyecto.entidades.Usuario;
import com.proyecto.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author DUALPC
 */
public class UsuarioDao implements IUsuarioDao{

    @Override
    public Usuario obtenerDatosPorUsuario(Usuario usuario) {
        Usuario model = null;
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        String hql = "FROM Usuario WHERE nombre = '"+usuario.getNombre()+"'";
        try {
            sesion.beginTransaction();
            model = (Usuario) sesion.createQuery(hql).uniqueResult();
            sesion.beginTransaction().commit();
        } catch (Exception e) {
            sesion.beginTransaction().rollback();
        }
        return model;
        /*String hql = "FROM Usuario WHERE nombre = :nombre";
        Query q = sesion.createQuery(hql);
        q.setParameter("nombre", usuario.getNombre());
        return (Usuario) q.uniqueResult();*/
    }

    @Override
    public Usuario login(Usuario usuario) {
        Usuario user = this.obtenerDatosPorUsuario(usuario);
        if(user != null){
            if(!user.getPassword().equals(EncriptarContraseña.sha512(usuario.getPassword()))){
                user = null;
            }
        }
        return user;
    }

    @Override
    public List<Usuario> getListasUsuarios() {
        List<Usuario> lista = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query  = session.createQuery("From Usuario");
        lista = (List<Usuario>)query.list();
        session.close();
        return lista; 
    }

    @Override
    public boolean insertarVendedor(Session sesion, Usuario usuario) throws Exception {
        sesion.save(usuario);
        return true;
    }

    @Override
    public void actualizar(Usuario u) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(u);
        session.getTransaction().commit();
        session.close();  
    }

    @Override
    public void eliminar(Usuario u) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(u);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void insertar(Usuario u) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(u);
        session.getTransaction().commit();
        session.close();
    }
    
}
