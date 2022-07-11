/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adsanchez.informecacao.verificacion;

import adsanchez.informecacao.extras.AnalisisSuelo;
import adsanchez.informecacao.extras.ManeraCorregidoPHSuelo;
import adsanchez.informecacao.extras.SuelosNivelesAltosAcidez;
import java.util.List;
import lombok.Data;

/**
 *
 * @author Javier
 */
@Data
public class ManejoSuelo {
    
    private AnalisisSuelo analisisSuelo;
    private String capacitacionTomaMuestrasSuelo;
    private ManeraCorregidoPHSuelo maneraCorregidoPHSuelo;
    private SuelosNivelesAltosAcidez suelosNivelesAltosAcidez;
    private List<?> tipoSuelo;
}
