/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adsanchez.informecacao.controller;

import adsanchez.informecacao.entity.Agricultor;
import adsanchez.informecacao.entity.Secciones;
import adsanchez.informecacao.service.AgricultorService;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
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
 @RequestMapping("/agricultores")
public class AgricultorController {
     
     @Autowired
     AgricultorService agricultorService;
     
     @GetMapping("/{id}")
     public Agricultor getAgricultor(@PathVariable (value="id") String id) throws ExecutionException, InterruptedException{
         Agricultor agricultor = agricultorService.getAgricultor(id);
         return agricultor;
     }
     
     @GetMapping("/all")
     public List<Object> getAgricultores() throws InterruptedException, ExecutionException, NoSuchFieldException{
         List<Object> agricultores = agricultorService.getAgricultores();
         return agricultores;
     }
    
}
