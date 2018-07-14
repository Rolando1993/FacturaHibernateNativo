/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.beans;

import com.proyecto.entidades.Usuario;
import com.proyecto.entidades.Vendedor;
import com.proyecto.negocio.IUsuarioBL;
import com.proyecto.negocio.UsuarioBL;
import com.proyecto.util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author DUALPC
 */
@ManagedBean
@RequestScoped
public class UsuarioMB {

    Session sesion = null;
    Transaction tx = null;
    private List<Usuario> listaUsuarios;
    private Usuario usuario = new Usuario();
    IUsuarioBL usuarioBL = new UsuarioBL();
    private Vendedor vendedor = new Vendedor();
    
    public UsuarioMB() {
        this.listaUsuarios = new ArrayList<>();
    }

    public List<Usuario> getListaUsuarios() {
        this.listaUsuarios = usuarioBL.listaDeUsuarios();
        return listaUsuarios;
    }

    public void setListaUsuarios(List<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public void prepararNuevoUsuario(){
        this.usuario = new Usuario();
    }
    
     //Metodo Para Guardar Venta
    public void guardarUsuario() {
        this.sesion = null;
        this.tx = null;
        this.vendedor.setCodigovendedor(2);
        try {
            this.sesion = HibernateUtil.getSessionFactory().openSession();
            this.tx = this.sesion.beginTransaction();
            //Datos Para Guardar La Factura En La Base De Datos
            this.usuario.setVendedor(this.vendedor);
            //Hacemos El Insert En La Tabla Factura De La Base De Datos
            usuarioBL.guardarUsuario(this.sesion, this.usuario);
            this.tx.commit();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Usuario Registrado"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            if (this.tx != null) {
                tx.rollback();
            }
        } finally {
            if (this.sesion != null) {
                this.sesion.close();
            }
        }
    }
    
    public void save(){
        usuarioBL.save(getUsuario());
    }
    
    
    public void update(){
        usuarioBL.update(getUsuario());
    }
    
    public void delete(){
         usuarioBL.delete(getUsuario());
    }
}
