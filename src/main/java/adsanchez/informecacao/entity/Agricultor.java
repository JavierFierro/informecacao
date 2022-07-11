/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adsanchez.informecacao.entity;

import java.util.List;
import lombok.Data;

/**
 *
 * @author Javier
 */
@Data
public class Agricultor {
    
    private String id;
    private DatosPersonales datosPersonales;
    private CacaoCNN cacaoCNN;
    private CacaoNacional cacaoNacional;
    private CacaoNacionalNC cacaoNacionalNuevosClones;
    private Croquis croquis;
    private Hectareaje hectareaje;
    private InformacionFinca informacionFinca;
    private OrigenPlantas origenPlantas;
    
//    private Timestamp fechaNacimiento;
}
