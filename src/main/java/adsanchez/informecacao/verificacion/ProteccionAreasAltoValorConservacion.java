/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adsanchez.informecacao.verificacion;

import adsanchez.informecacao.extras.ConoceEspeciePeligroExtincionEnFinca;
import adsanchez.informecacao.extras.CuentaConAreaForestales;
import adsanchez.informecacao.extras.FincaConsideradaAltoValor;
import adsanchez.informecacao.extras.NecesitaImplementarPracticasMejoraSuelo;
import adsanchez.informecacao.extras.SueloPresentaProblemaErosion;
import lombok.Data;

/**
 *
 * @author Javier
 */
@Data
public class ProteccionAreasAltoValorConservacion {
    
    private ConoceEspeciePeligroExtincionEnFinca conoceEspeciePeligroExtincionEnFinca;
    private CuentaConAreaForestales cuentaConAreaForestales;
    private FincaConsideradaAltoValor fincaConsideradaAltoValor;
    private String gradoPresentanPendientes;
    private NecesitaImplementarPracticasMejoraSuelo necesitaImplementarPracticasMejoraSuelo;
    private String presentaAnexosAreasAltoValor;
    private String realizaPlanesCorteExtraccionMadera;
    private String realizaPlanesReforestacion;
    private SueloPresentaProblemaErosion sueloPresentaProblemaErosion;
}
