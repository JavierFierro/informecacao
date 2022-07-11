/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adsanchez.informecacao.verificacion;

import adsanchez.informecacao.extras.PlantadoArbolesSombrioReciente;
import java.util.List;
import lombok.Data;

/**
 *
 * @author Javier
 */
@Data
public class ConservacionSuelosBiodiversidad {
    
    private List<?> especiesArbolesEnCultivo;
    private String especiesDiferentesArbolesXHectarea;
    private PlantadoArbolesSombrioReciente plantadoArbolesSombrioReciente;
    private String practicaDeforestacion;
    private String practicasConservacionSuelos;
    private String promedioArbolXHectarea12MAltura;
}
