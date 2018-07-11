/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.pruebas;


import com.proyecto.entidades.Vendedor;
import com.proyecto.negocio.IVendedorBL;
import com.proyecto.negocio.VendedorBL;
import com.proyecto.util.HibernateUtil;
import java.util.List;
import java.util.Scanner;
import org.hibernate.Session;


/**
 *
 * @author DUALPC
 */
public class AppVendedor {
    
     
    public static void main(String[] args) {
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        Scanner sc = new Scanner(System.in);
        
        int codigo;
        String nombre = "";
        String apellido = "";
        String direccion = "";
        String dni = "";
        String celular = "";
        
        int op = 0;
        IVendedorBL vendedorBL = new VendedorBL();
        Vendedor v = new Vendedor();
        do {            
            System.out.println("Menu De Opciones - JPA - Hibernate ");
            System.out.println("1. Grabar");
            System.out.println("2. Actualizar");
            System.out.println("3. Eliminar");
            System.out.println("4. Consultar");
            System.out.println("5. Imprimir Todo");
            System.out.println("6. Salir");
            System.out.println("Ingrese La Opcion");
            op = sc.nextInt();
                if(op == 1){
                    System.out.println("Datos Personales Del Vendedor.....");
                    
                    System.out.println("Ingrese El Nombre Del Vendedor");
                    nombre = sc.nextLine();
                    nombre = sc.nextLine();
                    
                    System.out.println("Ingrese El Apellido Del Vendedor");
                    apellido = sc.nextLine();
                    
                    System.out.println("Ingrese El DNI Del Vendedor");
                    dni = sc.nextLine();
                    
                    System.out.println("Ingrese El Celular Del Vendedor");
                    celular = sc.nextLine();
                    
                    System.out.println("Ingrese La Direccion Del Vendedor");
                    direccion = sc.nextLine();
                  
                    v.setNombres(nombre);
                    v.setApellidos(apellido);
                    v.setDni(dni);
                    v.setCeluldar(celular);
                    v.setDireccion(direccion);
                    vendedorBL.save(v);
                    System.out.println("Registro Insertado Con Exito....");
                    
                }else if(op == 2){
                    System.out.println("Datos Personales Del Vendedor.....");
                    System.out.println("Ingrese El Codigo Del Vendedor");
                    codigo = sc.nextInt();
                    
                    System.out.println("Ingrese El Nombre Del Vendedor");
                    nombre = sc.nextLine();
                    nombre = sc.nextLine();
                    
                    System.out.println("Ingrese El Apellido Del Vendedor");
                    apellido = sc.nextLine();
                    
                    System.out.println("Ingrese El DNI Del Vendedor");
                    dni = sc.nextLine();
                    
                    System.out.println("Ingrese El Celular Del Vendedor");
                    celular = sc.nextLine();
                    
                    System.out.println("Ingrese La Direccion Del Vendedor");
                    direccion = sc.nextLine();
                    
                    //em.getTransaction().begin();
                    v.setCodigovendedor(codigo);
                    v.setNombres(nombre);
                    v.setApellidos(apellido);
                    v.setDni(dni);
                    v.setCeluldar(celular);
                    v.setDireccion(direccion);
                    vendedorBL.update(v);
                    //em.getTransaction().commit();
                    System.out.println("Registro Actualizado Con Exito....");
                    
                }else if(op == 3){
                    System.out.println("Datos Personales Del Vendedor.....");
                    System.out.println("Ingrese El Codigo Del Vendedor");
                    codigo = sc.nextInt();
                    
                    v.setCodigovendedor(codigo);
                    vendedorBL.delete(v);
                    System.out.println("Registro Eliminado Con Exito....");
                    
                }else if(op == 4){
                    for (Vendedor v1 : vendedorBL.consultarVendedor()) {
                        System.out.println(v1);
                        
                    }
                    
                }else if(op == 5){
                    List<Vendedor> listaVendedores = (List<Vendedor>) session.createQuery("FROM Vendedor").list();
                    System.out.println("Hay " + listaVendedores.size() + " Vendedores En El Sistema");
                    for (Vendedor ven : listaVendedores) {
                        System.out.println(ven.toString());
            
                    }
                }
        } while (op != 6);
        System.exit(op);
        System.out.println("Saliendo........");
        
    }
}
