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
public class CacaoNacionalNC {
    
    private String plantulasCondicionesEdafoclimaticas;
    private String plantulasRendimiento;
    private String plantulasResistenciaEnfermedades;
    private String  plantulasVigorPlanta;
    private List<?> tipoVariedad;
    private String usoAnteriorAreaNueva;
    private String variedadesSembradasCalificacion;
}
