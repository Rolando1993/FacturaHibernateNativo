/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.beans;

import com.proyecto.encriptar.ReporteFactura;
import com.proyecto.entidades.Cliente;
import com.proyecto.entidades.Detallefactura;
import com.proyecto.entidades.Factura;
import com.proyecto.entidades.Producto;
import com.proyecto.entidades.Vendedor;
import com.proyecto.negocio.ClienteBL;
import com.proyecto.negocio.DetalleFacturaBL;
import com.proyecto.negocio.FacturaBL;
import com.proyecto.negocio.ICLienteBL;
import com.proyecto.negocio.IDetalleFacturaBL;
import com.proyecto.negocio.IFacturaBL;
import com.proyecto.negocio.IProductoBL;
import com.proyecto.negocio.ProductoBL;
import com.proyecto.util.HibernateUtil;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.primefaces.context.RequestContext;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author DUALPC
 */
@ManagedBean
@ViewScoped
public class FacturaMB implements Serializable {

    Session sesion = null;
    Transaction tx = null;
    
    @ManagedProperty("#{loginMB}")
    private LoginMB loginMB = new LoginMB();

    private Cliente cliente = new Cliente();
    private Integer codigoCliente;
    ICLienteBL clienteBL = new ClienteBL();

    private Producto producto = new Producto();
    private String codigoBarra;
    IProductoBL productoBL = new ProductoBL();

    private List<Detallefactura> listDetalleFactura;

    private String cantidadProducto;
    private String productoSeleccionado;
    private Factura factura = new Factura();

    private String cantidadProducto2;

    private Long numeroFactura;
    IFacturaBL facturaBL = new FacturaBL();

    private BigDecimal totalVentaFactura;

    private Vendedor vendedor = new Vendedor();

    IDetalleFacturaBL detalleFacturaBL = new DetalleFacturaBL();

    public FacturaMB() {
        this.factura = new Factura();
        this.listDetalleFactura = new ArrayList<>();
        this.vendedor = new Vendedor();
        this.cliente = new Cliente();
        this.producto = new Producto();
    }

    public LoginMB getLoginMB() {
        return loginMB;
    }

    public void setLoginMB(LoginMB loginMB) {
        this.loginMB = loginMB;
    }

    
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Integer getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(Integer codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public String getCodigoBarra() {
        return codigoBarra;
    }

    public void setCodigoBarra(String codigoBarra) {
        this.codigoBarra = codigoBarra;
    }

    public List<Detallefactura> getListDetalleFactura() {
        return listDetalleFactura;
    }

    public void setListDetalleFactura(List<Detallefactura> listDetalleFactura) {
        this.listDetalleFactura = listDetalleFactura;
    }

    public String getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(String cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public String getProductoSeleccionado() {
        return productoSeleccionado;
    }

    public void setProductoSeleccionado(String productoSeleccionado) {
        this.productoSeleccionado = productoSeleccionado;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    public String getCantidadProducto2() {
        return cantidadProducto2;
    }

    public void setCantidadProducto2(String cantidadProducto2) {
        this.cantidadProducto2 = cantidadProducto2;
    }

    public Long getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(Long numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public BigDecimal getTotalVentaFactura() {
        return totalVentaFactura;
    }

    public void setTotalVentaFactura(BigDecimal totalVentaFactura) {
        this.totalVentaFactura = totalVentaFactura;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    //Metodo Para Agregar Los Clientes Por Medio Del Dialog
    public void datosDelCliente(Integer codCliente) {
        this.sesion = null;
        this.tx = null;
        try {
            this.sesion = HibernateUtil.getSessionFactory().openSession();
            this.tx = this.sesion.beginTransaction();

            this.cliente = clienteBL.obtenerCliente(this.sesion, codCliente);
            this.tx.commit();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Datos Del Cliente Agregado"));

        } catch (Exception e) {
            if (this.tx != null) {
                System.out.println(e.getMessage());
                tx.rollback();
            }
        } finally {
            if (this.sesion != null) {
                this.sesion.close();
            }
        }
    }

    //Metodo Para Agregar Los Clientes Por Medio Del Codigo
    public void agregarDatosDelCliente2() {
        this.sesion = null;
        this.tx = null;
        try {
            if (this.codigoCliente == null) {
                return;
            }
            this.sesion = HibernateUtil.getSessionFactory().openSession();
            this.tx = this.sesion.beginTransaction();
            this.cliente = clienteBL.obtenerCliente(this.sesion, this.codigoCliente);
            if (this.cliente != null) {
                this.codigoCliente = null;
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Datos Del Cliente Agregado"));
            } else {
                this.codigoCliente = null;
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Incorrecto", "Cliente No Encontrado"));
            }
            this.tx.commit();

        } catch (Exception e) {
            if (this.tx != null) {
                System.out.println(e.getMessage());
                tx.rollback();
            }
        } finally {
            if (this.sesion != null) {
                this.sesion.close();
            }
        }
    }

    //Metodo Para Solicitar La Cantidad De Producto A Vender
    public void pedirCantidadProducto(String codBarra) {
        this.productoSeleccionado = codBarra;
    }

    //Metodo Para Agregar Los Productos Por Medio Del Dialog
    public void datosDelProducto() {
        this.sesion = null;
        this.tx = null;
        try {
            if (!(this.cantidadProducto.matches("[0-9]*")) || this.cantidadProducto.equals("0") || this.cantidadProducto.equals("")) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Error La Cantidad Es Incorrecta"));
                this.cantidadProducto = "";
            } else {
                this.sesion = HibernateUtil.getSessionFactory().openSession();
                this.tx = this.sesion.beginTransaction();

                //Obtiene Los Datos Del Producto Por El Codigo De Barra
                this.producto = productoBL.obtenerProducto(this.sesion, this.productoSeleccionado);
                this.listDetalleFactura.add(new Detallefactura(null, null, this.producto.getCodigobarra(),
                        this.producto.getNombre(), Integer.parseInt(this.cantidadProducto), this.producto.getPrecioventa(),
                        BigDecimal.valueOf(Integer.parseInt(this.cantidadProducto) * this.producto.getPrecioventa().floatValue())));

                this.tx.commit();
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Producto Agregado"));
                this.cantidadProducto = "";
                //Llamada Al metodo Total Factura Venta
                this.totalFacturaVenta();
            }

        } catch (Exception e) {
            if (this.tx != null) {
                System.out.println(e.getMessage());
                tx.rollback();
            }
        } finally {
            if (this.sesion != null) {
                this.sesion.close();
            }
        }
    }

    //Metodo Para Mostrar Los Productos Por Medio Del Dialog
    public void mostrarCantidadDelProducto2() {
        this.sesion = null;
        this.tx = null;
        try {
            if (this.codigoBarra.equals("")) {
                return;
            }
            this.sesion = HibernateUtil.getSessionFactory().openSession();
            this.tx = this.sesion.beginTransaction();

            this.producto = productoBL.obtenerProducto(this.sesion, codigoBarra);
            if (this.producto != null) {
                //Solicitar Mostrar El Dialog Cantidad Producto 2
                RequestContext context = RequestContext.getCurrentInstance();
                context.execute("PF('dialogCantidadProducto2').show();");
                this.codigoBarra = null;

            } else {
                this.codigoBarra = null;
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Producto No Encontrado"));
            }
            this.tx.commit();
        } catch (Exception e) {
            if (this.tx != null) {
                System.out.println(e.getMessage());
                tx.rollback();
            }
        } finally {
            if (this.sesion != null) {
                this.sesion.close();
            }
        }
    }

    //Merodo Para Buscar Los Productos Por Codigo De Barra
    public void agregarDatosDelProducto2() {
        if (!(this.cantidadProducto2.matches("[0-9]*")) || this.cantidadProducto2.equals("0") || this.cantidadProducto2.equals("")) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Error La Cantidad Es Incorrecta"));
            this.cantidadProducto2 = "";
        } else {
            this.listDetalleFactura.add(new Detallefactura(null, null, this.producto.getCodigobarra(),
                    this.producto.getNombre(), Integer.parseInt(this.cantidadProducto2), this.producto.getPrecioventa(),
                    BigDecimal.valueOf(Integer.parseInt(this.cantidadProducto2) * this.producto.getPrecioventa().floatValue())));

            this.cantidadProducto2 = "";
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Producto Agregado Al Detalle"));

            //Llamada Al Metodo Total Factura Venta
            this.totalFacturaVenta();

        }

    }

    //Metodo Para Cacular El Total A Vender En La Factura
    public void totalFacturaVenta() {
        this.totalVentaFactura = new BigDecimal("0");

        try {
            /*
            Calculamos El Total De La Venta Por Medio De Un Bucle Que Recorra & Multiplique El precio De Venta
            & La Cantidad Ademas Se Sumara El Valor & Se Ira Acumulando En La Variable Total Factura Venta
             */
            for (Detallefactura item : listDetalleFactura) {
                BigDecimal totalVentaPorProducto = item.getPrecioventa().multiply(new BigDecimal(item.getCantidad()));
                item.setTotal(totalVentaPorProducto);
                totalVentaFactura = totalVentaFactura.add(totalVentaPorProducto);
            }
            //Asignamos El Total De La Venta Al Objeto Factura Que Sera Llamado En El Metodo Realizar Venta
            this.factura.setTotalventa(totalVentaFactura);
            System.out.println("Total A Vender: " + this.factura.getTotalventa());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", e.getMessage()));

        }
    }

    //Metodo Para Quitar Un Producto De la Factura
    public void quitarProducto(String codBarra, Integer filaSeleccionada) {
        try {
            int i = 0;
            for (Detallefactura item : this.listDetalleFactura) {
                if (item.getCodigobarra().equals(codBarra) && filaSeleccionada.equals(i)) {
                    this.listDetalleFactura.remove(i);
                    break;
                }
                i++;
            }
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Informacion", "Se Retiro El Producto De La Factura"));
            //Invocamos Al Metodo Calcular Factura Venta Para Actualizar El Total A Vender
            this.totalFacturaVenta();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", e.getMessage()));
        }
    }

    //Metodos Para Editar La Cantidad De producto En La Tabla 
    public void onRowEdit(RowEditEvent event) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Informacion", "Se Modifico La Cantidad"));
        //Invocamos Al Metodo Calcular Factura Venta Para Actualizar El Total A Vender
        this.totalFacturaVenta();
    }

    public void onRowCancel(RowEditEvent event) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "No Se Hizo Ningun Cambio"));
    }

    //Metodo Para Generar El Numero De Factura
    public void numeroFactura() {
        this.sesion = null;
        this.tx = null;
        try {
            this.sesion = HibernateUtil.getSessionFactory().openSession();
            this.tx = this.sesion.beginTransaction();
            //Verificamops Si Hay Registro En La Tabla Factura De La Base De Dtos
            this.numeroFactura = facturaBL.obtenerTotalRegistro(this.sesion);

            if (this.numeroFactura <= 0 || this.numeroFactura == null) {
                this.numeroFactura = Long.valueOf("1");
            } else {
                //Recuperamos El Ultimo Registro Que Exista En La Tabla Factura De la Base De Datos
                this.factura = facturaBL.obtenerRegistro(this.sesion);
                this.numeroFactura = Long.valueOf(this.factura.getNumerofactura() + 1);

                //Limpiar La Variable Total Venta Factura
                this.totalVentaFactura = new BigDecimal("0");
            }
            this.tx.commit();

        } catch (Exception e) {
            if (this.tx != null) {
                tx.rollback();
            }
            System.out.println(e.getMessage());
        } finally {
            if (this.sesion != null) {
                this.sesion.close();
            }
        }
    }

    //Metodo Para Limpiar La Factura
    public void limpiarFactura() {
        this.cliente = new Cliente();
        this.factura = new Factura();
        this.listDetalleFactura = new ArrayList<>();
        this.numeroFactura = null;
        this.totalVentaFactura = null;
        //Invocar El Metodo Para Desactivar El Button
        this.disableButton();
    }

    //Metodo Para Guardar Venta
    public void guardarVenta() {
        this.sesion = null;
        this.tx = null;
        this.vendedor.setCodigovendedor(loginMB.getUsuario().getVendedor().getCodigovendedor());
        try {
            this.sesion = HibernateUtil.getSessionFactory().openSession();
            this.tx = this.sesion.beginTransaction();
            //Datos Para Guardar La Factura En La Base De Datos
            this.factura.setNumerofactura(this.numeroFactura.intValue());
            this.factura.setCliente(this.cliente);
            this.factura.setVendedor(this.vendedor);
            //Hacemos El Insert En La Tabla Factura De La Base De Datos
            facturaBL.guardarFactura(this.sesion, this.factura);
            //Recuperamos El Ultimo Registro De La Tabla Factura
            this.factura = facturaBL.obtenerRegistro(this.sesion);
            //Recorremos El ArrayList Para Guardar Cada Registro En La Base De Datos
            for (Detallefactura item : listDetalleFactura) {
                this.producto = productoBL.obtenerProducto(this.sesion, item.getCodigobarra());
                item.setFactura(this.factura);
                item.setProducto(this.producto);

                //Hacemos El Insert En La Tabla Detalle Factura De La Base De Datos
                detalleFacturaBL.guardarDetalleFactura(this.sesion, item);
            }
            this.tx.commit();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Venta Registrada"));
            this.limpiarFactura();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            if (this.tx != null) {
                tx.rollback();
            }
        } finally {
            if (this.sesion != null) {
                this.sesion.close();
            }
        }
    }
    
    //Metodos Para Activar & Desactivar Los Controles En la Factura
    private boolean enable;

    public boolean isEnable() {
        return enable;
    }
    
    public void enableButton(){
        enable = true;
    }
    
    public void disableButton(){
        enable = false;
    }
    
    //Recuperar Fecha Del Sistema
    private String fechaSistema;

    public String getFechaSistema() {
        Calendar fecha = new GregorianCalendar();
        int año = fecha.get(Calendar.YEAR);
        int mes = fecha.get(Calendar.MONTH);
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
        fechaSistema = (dia + "/" + (mes + 1) + "/" + año);
        return fechaSistema;
    }

    public void setFechaSistema(String fechaSistema) {
        this.fechaSistema = fechaSistema;
    }
    
    //Metodo Para Invocar El Reporte & Envie Los Parametros
    public void verReporte()throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException{
        
        this.vendedor.setCodigovendedor(loginMB.getUsuario().getVendedor().getCodigovendedor());
        
        int cc = this.cliente.getCodigocliente();
        int cv = this.vendedor.getCodigovendedor();
        int cf = this.factura.getCodigofactura() + 1;
        
        //Invocamos Al metodo Guardar Venta Para Almacenar Ls Ventas En Las Tablas Correspondientes
        this.guardarVenta();
        
        ReporteFactura rf = new ReporteFactura();
        
        FacesContext fc = FacesContext.getCurrentInstance();
        ServletContext sc = (ServletContext) fc.getExternalContext().getContext();
        String ruta = sc.getRealPath("/Reportes/factura.jasper");
        
        System.out.println("Cliente " + cc);
        System.out.println("Vendedor " + cv);
        System.out.println("Factura " + cf);
        
        rf.getReporte(ruta, cc, cv, cf);
        FacesContext.getCurrentInstance().responseComplete();
        
    }
    
}


