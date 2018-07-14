/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.negocio;

import com.proyecto.dao.IUsuarioDao;
import com.proyecto.entidades.Usuario;
import com.proyecto.implementacion.UsuarioDao;

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
    
}
