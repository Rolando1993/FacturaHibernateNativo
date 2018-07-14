/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.negocio;

import com.proyecto.dao.IDetalleFacturaDao;
import com.proyecto.entidades.Detallefactura;
import com.proyecto.implementacion.DetalleFacturaDao;
import org.hibernate.Session;

/**
 *
 * @author DUALPC
 */
public class DetalleFacturaBL implements IDetalleFacturaBL{
    
    IDetalleFacturaDao detalleFacturaDao = new DetalleFacturaDao();

    @Override
    public boolean guardarDetalleFactura(Session sesion, Detallefactura detalleFactura) throws Exception {
        return this.detalleFacturaDao.guardarVentaDetalleFactura(sesion, detalleFactura);
    }
    
}
