/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.implementacion;

import com.proyecto.dao.IDetalleFacturaDao;
import com.proyecto.entidades.Detallefactura;
import org.hibernate.Session;

/**
 *
 * @author DUALPC
 */
public class DetalleFacturaDao implements IDetalleFacturaDao{

    @Override
    public boolean guardarVentaDetalleFactura(Session sesion, Detallefactura detalleFactura) throws Exception {
        sesion.save(detalleFactura);
        return true;
    }
    
}
