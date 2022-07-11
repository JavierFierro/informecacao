/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adsanchez.informecacao.entity;

import java.util.Map;
import lombok.Data;

/**
 *
 * @author Javier
 */
@Data
public class Verificacion {
    
    private String id;
    private Map<String, Object> diccionario;
}
