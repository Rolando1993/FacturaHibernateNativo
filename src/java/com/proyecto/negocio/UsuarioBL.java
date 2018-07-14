/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.negocio;

import com.proyecto.dao.IUsuarioDao;
import com.proyecto.entidades.Usuario;
import com.proyecto.implementacion.UsuarioDao;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author DUALPC
 */
public class UsuarioBL implements IUsuarioBL{

    IUsuarioDao usuarioDao = new UsuarioDao();
    
    @Override
    public Usuario obtenerUsuario(Usuario usuario) {
        return this.usuarioDao.obtenerDatosPorUsuario(usuario);
    }

    @Override
    public Usuario loginUsuario(Usuario usuario) {
        return this.usuarioDao.login(usuario);
    }

    @Override
    public List<Usuario> listaDeUsuarios() {
        return this.usuarioDao.getListasUsuarios();
    }

    @Override
    public boolean guardarUsuario(Session sesion, Usuario usuario) throws Exception {
        return this.usuarioDao.insertarVendedor(sesion, usuario);
    }

    @Override
    public void update(Usuario u) {
        this.usuarioDao.actualizar(u);
    }

    @Override
    public void delete(Usuario u) {
        this.usuarioDao.eliminar(u);
    }

    @Override
    public void save(Usuario u) {
        this.usuarioDao.insertar(u);
    }
    
}
