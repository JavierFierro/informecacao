/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adsanchez.informecacao.verificacion;

import adsanchez.informecacao.extras.OtraActividadFueraFincaConIngreso;
import lombok.Data;

/**
 *
 * @author Javier
 */
@Data
public class DiversificacionIngresos {
    
    private String huertosOrganicosEnFinca;
    private String otraActividadDentroFincaConIngreso;
    private OtraActividadFueraFincaConIngreso otraActividadFueraFincaConIngreso;
    private String usoCultivoDiferenteCacao;
}
