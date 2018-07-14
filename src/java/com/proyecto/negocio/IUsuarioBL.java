/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.negocio;

import com.proyecto.entidades.Usuario;

/**
 *
 * @author DUALPC
 */
public interface IUsuarioBL {
    
    public Usuario obtenerUsuario(Usuario usuario);
    public Usuario loginUsuario(Usuario usuario);
}
