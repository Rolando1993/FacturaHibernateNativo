/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.implementacion;

import com.proyecto.dao.IFacturaDao;
import com.proyecto.entidades.Factura;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author DUALPC
 */
public class FacturaDao implements IFacturaDao{

    @Override
    public Factura obtenerUltimoRegistro(Session sesion) throws Exception {
        String hql = "FROM Factura ORDER BY codigofactura DESC";
        Query q = sesion.createQuery(hql).setMaxResults(1);
        
        return (Factura) q.uniqueResult();
    }

    @Override
    public Long obtenerTotalRegistroFactura(Session sesion) {
        String hql = "SELECT COUNT(*) FROM Factura";
        Query q = sesion.createQuery(hql);
        
        return (Long) q.uniqueResult();
    }
    
}
