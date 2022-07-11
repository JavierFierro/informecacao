/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adsanchez.informecacao.controller;

import adsanchez.informecacao.entity.Agricultor;
import adsanchez.informecacao.export.ExcelLineaBase;
import adsanchez.informecacao.export.ExcelVerificacion;
import adsanchez.informecacao.lineaBase.SeccionesLB;
import adsanchez.informecacao.service.AgricultorService;
import adsanchez.informecacao.verificacion.SeccionesVerificacion;
import adsanchez.informecacao.service.FormulariosService;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Javier
 */
@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@RequestMapping("/formulario")
public class FormularioController {
    
    @Autowired
     FormulariosService formularioService;
     
    @Autowired
    AgricultorService agricultorService;
    
     @GetMapping("/verificacion/{id}")
     public SeccionesVerificacion getVerificacionAgricultor(@PathVariable (value="id") String id) throws ExecutionException, InterruptedException{
         return formularioService.getVerificacion(id);
     }
     
     @GetMapping("/lineabase/{id}")
     public SeccionesLB getLineaBaseAgricultor(@PathVariable (value="id") String id) throws ExecutionException, InterruptedException{
         return formularioService.getLineaBase(id);
     }
     
     @GetMapping("/export/verificacion/{id}")
     public void exportarVerficacion(@PathVariable (value="id") String id, HttpServletResponse response){
         
        try {
            Agricultor agricultor = agricultorService.getAgricultor(id);
            
            SeccionesVerificacion seccionesVerificacion = formularioService.getVerificacion(id);
            
            response.setContentType("application/octet-stream");
            String headerKey = "Content-Disposition";

            DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
            String curentDateTime = dateFormatter.format(new Date());

            String filename = "Monitoreo_"+agricultor.getDatosPersonales().getNombre()+"_"+curentDateTime+".xlsx";

            String headerValue = "attachment; filename="+filename;

            response.setHeader(headerKey, headerValue);

            ExcelVerificacion excelExporter = new ExcelVerificacion(agricultor, seccionesVerificacion);
            
            excelExporter.export(response);

        
        } catch (InterruptedException | ExecutionException ex) {
            System.out.println("No se pudo cargar el archivo");
        }

     }
     
     @GetMapping("/export/lineabase/{id}")
     public void exportarLineaBase(@PathVariable (value="id") String id, HttpServletResponse response){
         
        try {
            Agricultor agricultor = agricultorService.getAgricultor(id);
            SeccionesLB seccioneslb = formularioService.getLineaBase(id);
            
            
            response.setContentType("application/octet-stream");
            String headerKey = "Content-Disposition";

            DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
            String curentDateTime = dateFormatter.format(new Date());

            String filename = "LineaBase_"+agricultor.getDatosPersonales().getNombre()+"_"+curentDateTime+".xlsx";

            String headerValue = "attachment; filename="+filename;

            response.setHeader(headerKey, headerValue);

            ExcelLineaBase excelExporter = new ExcelLineaBase(agricultor, seccioneslb);
            
            excelExporter.export(response);

        
        } catch (InterruptedException | ExecutionException ex) {
            System.out.println("No se pudo cargar el archivo");
        }

     }
}
