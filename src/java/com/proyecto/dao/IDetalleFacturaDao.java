/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.dao;

import com.proyecto.entidades.Detallefactura;
import org.hibernate.Session;

/**
 *
 * @author DUALPC
 */
public interface IDetalleFacturaDao {
    
    //Metodo Para Guardar Los Registros En El Detalle Factura En la Base De Datos
    public boolean guardarVentaDetalleFactura(Session sesion, Detallefactura detalleFactura)throws Exception;
}
