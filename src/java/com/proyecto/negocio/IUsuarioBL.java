/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.negocio;

import com.proyecto.entidades.Usuario;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author DUALPC
 */
public interface IUsuarioBL {
    
    public Usuario obtenerUsuario(Usuario usuario);
    public Usuario loginUsuario(Usuario usuario);
    public List<Usuario> listaDeUsuarios();
    public boolean guardarUsuario(Session sesion, Usuario usuario)throws Exception;
    void save(Usuario u);
    void update(Usuario u);
    void delete(Usuario u);
}
