/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.negocio;

import com.proyecto.dao.IFacturaDao;
import com.proyecto.entidades.Factura;
import com.proyecto.implementacion.FacturaDao;
import org.hibernate.Session;

/**
 *
 * @author DUALPC
 */
public class FacturaBL implements IFacturaBL{
    
    IFacturaDao facturaDao = new FacturaDao();

    @Override
    public Factura obtenerRegistro(Session sesion) throws Exception {
        return this.facturaDao.obtenerUltimoRegistro(sesion);
    }

    @Override
    public Long obtenerTotalRegistro(Session sesion) {
        return this.facturaDao.obtenerTotalRegistroFactura(sesion);
    }
    
}
