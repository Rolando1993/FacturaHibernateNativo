package com.proyecto.entidades;
// Generated 23/06/2018 11:28:12 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Cliente generated by hbm2java
 */
public class Cliente  implements java.io.Serializable {


     private int codigocliente;
     private String nombres;
     private String apellidos;
     private String direccion;
     private Set<Factura> facturas = new HashSet<Factura>(0);

    public Cliente() {
    }

	
    public Cliente(int codigocliente) {
        this.codigocliente = codigocliente;
    }
    public Cliente(int codigocliente, String nombres, String apellidos, String direccion, Set<Factura> facturas) {
       this.codigocliente = codigocliente;
       this.nombres = nombres;
       this.apellidos = apellidos;
       this.direccion = direccion;
       this.facturas = facturas;
    }
   
    public int getCodigocliente() {
        return this.codigocliente;
    }
    
    public void setCodigocliente(int codigocliente) {
        this.codigocliente = codigocliente;
    }
    public String getNombres() {
        return this.nombres;
    }
    
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
    public String getApellidos() {
        return this.apellidos;
    }
    
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public String getDireccion() {
        return this.direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public Set<Factura> getFacturas() {
        return this.facturas;
    }
    
    public void setFacturas(Set<Factura> facturas) {
        this.facturas = facturas;
    }

    @Override
    public String toString() {
        return "Cliente{" + "codigocliente=" + codigocliente + ", nombres=" + nombres + ", apellidos=" + apellidos + ", direccion=" + direccion + '}';
    }




}


