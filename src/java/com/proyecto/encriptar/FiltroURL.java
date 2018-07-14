/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.encriptar;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.http.HttpSession;

/**
 *
 * @author DUALPC
 */
public class FiltroURL implements PhaseListener{

    //Metodos Utilizados Para RestringirEl Acceso A Las URLS, Si El Usuario No Esta Logueado
    @Override
    public void afterPhase(PhaseEvent pe) {
        FacesContext facesContext = pe.getFacesContext();
        //Capturamos El Nombre De La Pagina Actual
        String currentPage = facesContext.getViewRoot().getViewId();
        //Creamos Una Variable Booleana Para Ver Si Es la Pagina De Logueo Que Se capturo
        boolean isPageLogin = currentPage.lastIndexOf("login.xhtml") > -1 ? true:false;
        
        HttpSession httpSesion = (HttpSession) facesContext.getExternalContext().getSession(true);
        /*
        Recuperamos Un Objeto Del String Que Se Guardo Para Ello Se Toma La Sesion Al usuario Que Se Definio 
        En El LoginMB
        */
        Object usuario = httpSesion.getAttribute("usuario");
        if(!isPageLogin && usuario != null){//Si No Es La Pagina De Logueo & El Usuario Es Nulo Lo Redirigimos A La Pagina
            NavigationHandler nHandler = facesContext.getApplication().getNavigationHandler();
            nHandler.handleNavigation(facesContext, null, "/login.xhtml");
        }
    }

    @Override
    public void beforePhase(PhaseEvent pe) {
    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.RESTORE_VIEW;
    }
    
}
