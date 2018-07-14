/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.beans;

import com.proyecto.entidades.Usuario;
import com.proyecto.negocio.IUsuarioBL;
import com.proyecto.negocio.UsuarioBL;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.http.HttpSession;
import org.primefaces.context.RequestContext;

/**
 *
 * @author DUALPC
 */
@ManagedBean
@SessionScoped
public class LoginMB {

    private Usuario usuario = new Usuario();
    private String nombre;
    private String password;
    IUsuarioBL usuarioBl = new UsuarioBL();
    
    public LoginMB() {
        this.usuario = new Usuario();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
    
    public void login(ActionEvent event) {
        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage message = null;
        boolean loggedIn = false;
        String ruta="";
        this.usuario = usuarioBl.loginUsuario(this.usuario);
        if(this.usuario != null) {
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", this.usuario.getNombre());
            loggedIn = true;
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenido", this.usuario.getNombre());
            ruta="/FacturaWebNativo/faces/views/bienvenido.xhtml";
        } else {
            loggedIn = false;
            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Error", "Usuario O Contraseñas Incorrectas");
            this.usuario = new Usuario();
        }
         
        FacesContext.getCurrentInstance().addMessage(null, message);
        context.addCallbackParam("loggedIn", loggedIn);
        context.addCallbackParam("ruta", ruta);
    }   
    
    
    //Metodo Para Cerrar La Sesion
    public String cerrarSesion(){
        this.nombre = null;
        this.password = null;
        HttpSession httpSesion = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        httpSesion.invalidate();
        return "/login";
    }
}
