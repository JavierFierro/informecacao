/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adsanchez.informecacao.extras;

import lombok.Data;

/**
 *
 * @author Javier
 */
@Data
public class PerteneceAsocProgrCertif {
    
    private String cantidadMiembros;
    private String nombreAsociacion;
    private String recibeBeneficios;
    private TiposBeneficios tiposBeneficios;
    private String respuesta;
}
