/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adsanchez.informecacao.entity;

import adsanchez.informecacao.extras.NuevosClones;
import adsanchez.informecacao.extras.ViejosInjertados;
import java.util.List;
import lombok.Data;

/**
 *
 * @author Javier
 */
@Data
public class CacaoNacional {
    
    private String arbolesElite;
    private String areaTotalNacional;
    private String areaTotalNacionalViejo;
    private String areaTotalNuevosClones;
    private String areaTotalViejoInjertado;
    private String brotesBasales;
    private String edadCacaoViejo;
    private List<NuevosClones> nuevosClones;
    private String precioPromedioXCacao;
    private String produccionAnioAnteriorCacaoNacional;
    private List<ViejosInjertados> viejosInjertados;
}
