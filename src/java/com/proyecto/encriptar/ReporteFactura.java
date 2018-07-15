/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.encriptar;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;

/**
 *
 * @author DUALPC
 */
public class ReporteFactura {
    
    public void getReporte(String ruta, Integer codC, Integer codV, Integer codF)throws ClassNotFoundException, InstantiationException, SQLException, IllegalAccessException{
        Connection conexion;
        Class.forName("org.postgresql.Driver").newInstance();
        conexion = DriverManager.getConnection("jdbc://localhost:5432/Factura", "postgres", "1234");
        
        //Se Definen Los Parametros Que El Reporte Necesita
        Map parameter = new HashMap();
        parameter.put("codigoCliente", codC);
        parameter.put("codigoVendedor", codV);
        parameter.put("codigoFactura", codF);
        
        try {
            File file = new File(ruta);
            HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
            httpServletResponse.setContentType("aplication/pdf");
            httpServletResponse.addHeader("Content-Type", "aplication/pdf");
            
            JasperReport jasperReport = (JasperReport) JRLoader.loadObjectFromFile(file.getPath());
            
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameter, conexion);
            
            JRExporter jrExporter = null;
            jrExporter = new JRPdfExporter();
            jrExporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            jrExporter.setParameter(JRExporterParameter.OUTPUT_STREAM, httpServletResponse.getOutputStream());
            
            if(jrExporter != null){
                try {
                    jrExporter.exportReport();
                } catch (JRException e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if(conexion != null){
                try {
                    conexion.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        
    }
}
