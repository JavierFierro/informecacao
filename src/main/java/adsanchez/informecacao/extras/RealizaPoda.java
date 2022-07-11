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
public class RealizaPoda {
    
    private List<?> tipoPoda;
    private String respuesta;
    private RealizaPodaFitosanitaria realizaPodaFitosanitaria;
    private RealizaPodaFormacion realizaPodaFormacion;
    private RealizaPodaMantenimiento realizaPodaMantenimiento;
    private RealizaPodaRehabilitacion realizaPodaRehabilitacion;
}
