/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adsanchez.informecacao.lineaBase;

import lombok.Data;

/**
 *
 * @author Javier
 */
@Data
public class SeccionesLB {
    
    private String id;
    private CondicionesLaboralesLB condicionesLaborales;
    private ConservacionRecursosManejoDesechos conservacionRecursosDesechos;
    private CosechaLB cosecha;
    private InformacionFamilia informacionFamilia;
    private NivelAsociatividad nivelAsociatividad;
    private PracticasAgricolas practicasAgricolas;
    private SaludSeguridadOcupacionalLB saludSeguridad;
    private ServiciosBasicos serviciosBasicos;
    private VentaLB venta;
}
