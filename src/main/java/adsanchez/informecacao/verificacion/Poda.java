/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adsanchez.informecacao.verificacion;

import adsanchez.informecacao.extras.MalaPodaAlbergaPlagasEnfermedades;
import adsanchez.informecacao.extras.RealizaPoda;
import lombok.Data;

/**
 *
 * @author Javier
 */
@Data
public class Poda {
    
    private String cortesLaceracionesPlantaMalaPoda;
    private MalaPodaAlbergaPlagasEnfermedades malaPodaAlbergaPlagasEnfermedades;
    private String mazorcasEstadoPudricion;
    private RealizaPoda realizaPoda;
}
