/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adsanchez.informecacao.extras;

import java.util.List;
import lombok.Data;

/**
 *
 * @author Javier
 */
@Data
public class PoseeFuenteHidrica {
    
    private String consideradaFuenteHidrica;
    private String distanciaRequerida;
    private List<?> tipoFuenteHidrica;
    private String respuesta;
    private BrindaProteccionFuenteHidrica brindaProteccionFuenteHidrica;
    private NombreFuenteHidrica nombreFuenteHidrica;
    private PoseeNacientes poseeNacientes;
}