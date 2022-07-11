/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adsanchez.informecacao.lineaBase;

import adsanchez.informecacao.extras.ContrataMenoresEdad;
import adsanchez.informecacao.extras.ContrataTrabajadores;
import lombok.Data;

/**
 *
 * @author Javier
 */
@Data
public class CondicionesLaboralesLB {
    
    private String areaInicialContrato;
    private String baseContratoAgricola;
    private ContrataMenoresEdad contrataMenoresEdad;
    private ContrataTrabajadores contrataTrabajadores;
    private String tipoContratoTrabajo;
}
