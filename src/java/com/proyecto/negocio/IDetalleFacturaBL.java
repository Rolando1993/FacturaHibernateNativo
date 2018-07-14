/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.negocio;

import com.proyecto.entidades.Detallefactura;
import org.hibernate.Session;

/**
 *
 * @author DUALPC
 */
public interface IDetalleFacturaBL {
    
     public boolean guardarDetalleFactura(Session sesion, Detallefactura detalleFactura)throws Exception;
    
}
