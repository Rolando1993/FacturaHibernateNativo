/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.pruebas;

import com.proyecto.entidades.Cliente;
import com.proyecto.negocio.ClienteBL;
import com.proyecto.negocio.ICLienteBL;
import com.proyecto.util.HibernateUtil;
import java.util.List;
import java.util.Scanner;
import org.hibernate.Session;

/**
 *
 * @author DUALPC
 */
public class AppCliente {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Scanner sc = new Scanner(System.in);

        int codigo;
        String nombre = "";
        String apellido = "";
        String direccion = "";
        int op = 0;
        ICLienteBL clienteBL = new ClienteBL();
        Cliente c = new Cliente();
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
            if (op == 1) {
                System.out.println("Datos Personales Del Cliente.....");

                System.out.println("Ingrese El Nombre Del Cliente");
                nombre = sc.nextLine();
                nombre = sc.nextLine();

                System.out.println("Ingrese El Apellido Del Cliente");
                apellido = sc.nextLine();

                System.out.println("Ingrese La Direccion Del Cliente");
                direccion = sc.nextLine();

                c.setNombres(nombre);
                c.setApellidos(apellido);
                c.setDireccion(direccion);
                clienteBL.save(c);
                System.out.println("Registro Insertado Con Exito....");

            } else if (op == 2) {
                System.out.println("Datos Personales Del Cliente.....");
                System.out.println("Ingrese El Codigo Del Cliente");
                codigo = sc.nextInt();

                System.out.println("Ingrese El Nombre Del Cliente");
                nombre = sc.nextLine();
                nombre = sc.nextLine();

                System.out.println("Ingrese El Apellido Del Cliente");
                apellido = sc.nextLine();

                System.out.println("Ingrese La Direccion Del Cliente");
                direccion = sc.nextLine();

                //em.getTransaction().begin();
                c.setCodigocliente(codigo);
                c.setNombres(nombre);
                c.setApellidos(apellido);
                c.setDireccion(direccion);
                clienteBL.update(c);
                //em.getTransaction().commit();
                System.out.println("Registro Actualizado Con Exito....");

            } else if (op == 3) {
                System.out.println("Datos Personales Del Cliente.....");
                System.out.println("Ingrese El Codigo Del Cliente");
                codigo = sc.nextInt();

                c.setCodigocliente(codigo);
                clienteBL.delete(c);
                System.out.println("Registro Eliminado Con Exito....");

            } else if (op == 4) {
                List<Cliente> listaClientes = (List<Cliente>) session.createQuery("FROM Cliente").list();
                System.out.println("En Esta Base De Datos Hay " + listaClientes.size() + " Clientes.. ");

            } else if (op == 5) {
                List<Cliente> listaClientes = (List<Cliente>) session.createQuery("FROM Cliente").list();
                System.out.println("Hay " + listaClientes.size() + " Clientes En El Sistema");
                for (Cliente cli : listaClientes) {
                    System.out.println(cli.toString());

                }
            }
        } while (op != 6);
        System.out.println("Saliendo........");
        System.exit(op);
        

    }

}
