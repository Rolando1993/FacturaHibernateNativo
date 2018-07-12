/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.dao;

import com.proyecto.entidades.Factura;
import org.hibernate.Session;

/**
 *
 * @author DUALPC
 */
public interface IFacturaDao {
    public Factura obtenerUltimoRegistro(Session sesion)throws Exception;
    public Long obtenerTotalRegistroFactura(Session sesion);
}
