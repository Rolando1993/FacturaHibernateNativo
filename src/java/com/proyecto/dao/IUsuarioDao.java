/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.dao;

import com.proyecto.entidades.Usuario;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author DUALPC
 */
public interface IUsuarioDao {
    
    public Usuario obtenerDatosPorUsuario(Usuario usuario);
    public Usuario login(Usuario usuario);
    public List<Usuario> getListasUsuarios();
    public boolean insertarVendedor(Session sesion, Usuario usuario)throws Exception;
    void insertar(Usuario u);
    void actualizar(Usuario u);
    void eliminar(Usuario u);
}
