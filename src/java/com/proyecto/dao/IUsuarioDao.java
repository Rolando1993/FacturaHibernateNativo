/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.dao;

import com.proyecto.entidades.Usuario;

/**
 *
 * @author DUALPC
 */
public interface IUsuarioDao {
    
    public Usuario obtenerDatosPorUsuario(Usuario usuario);
    public Usuario login(Usuario usuario);
}
