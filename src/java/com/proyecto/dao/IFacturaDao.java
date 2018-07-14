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
    //Obtiene El Ultimo Registro De La Tabla Factura De La Base De Datos
    public Factura obtenerUltimoRegistro(Session sesion)throws Exception;
    //Verifica Si la Tabla Factura Posee Registros
    public Long obtenerTotalRegistroFactura(Session sesion);
    //Metodo Para Guardar Los Registros De La Factura En la Base De Datos
    public boolean guardarVentaFactura(Session sesion, Factura factura)throws Exception;
}
