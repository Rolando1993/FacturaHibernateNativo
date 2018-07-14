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
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author DUALPC
 */
public class UsuarioDao implements IUsuarioDao{

    @Override
    public Usuario obtenerDatosPorUsuario(Usuario usuario) {
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        String hql = "FROM Usuario WHERE nombre = :nombre";
        Query q = sesion.createQuery(hql);
        q.setParameter("nombre", usuario.getNombre());
        return (Usuario) q.uniqueResult();
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
    
}
