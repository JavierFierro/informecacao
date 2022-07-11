/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adsanchez.informecacao.verificacion;

import lombok.Data;

/**
 *
 * @author Javier
 */
@Data
public class SeccionesVerificacion {
    
    private String id;
    private Secado secado;
    private MIPE mipe;
    private Bodega bodega;
    private CondicionesLaborales condicionesLaborales;
    private ConservacionAguaManejodesechos conservacionAgua;
    private ConservacionSuelosBiodiversidad conservacionSuelos;
    private ControlMalezas controlMalezas;
    private Cosecha cosecha;
    private DatosFinca datosFinca;
    private DiversificacionIngresos diversificacionIngresos;
    private Fermentacion fermentacion;
    private Fertilizacion fertilizacion;
    private Injertacion injertacion;
    private ManejoSuelo manejoSuelo;
    private Poda poda;
    private ProteccionAreasAltoValorConservacion proteccionAreasAltoValor;
    private ProteccionAreasRiberenias proteccionAreasRiberenias;
    private RegistrosProductor registrosProductor;
    private SaludSeguridadOcupacional saludSeguridad;
    private Venta venta;
}
