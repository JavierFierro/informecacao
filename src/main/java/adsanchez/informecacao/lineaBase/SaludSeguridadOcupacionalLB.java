/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adsanchez.informecacao.lineaBase;

import adsanchez.informecacao.extras.AccidentesLaboralesUltimoAnio;
import adsanchez.informecacao.extras.PeriodoIntoxicacionPresente;
import lombok.Data;

/**
 *
 * @author Javier
 */
@Data
public class SaludSeguridadOcupacionalLB {
    
    private AccidentesLaboralesUltimoAnio accidentesLaboralesUltimoAnio;
    private String centroSaludCercano;
    private PeriodoIntoxicacionPresente periodoIntoxicacionPresente;
}
