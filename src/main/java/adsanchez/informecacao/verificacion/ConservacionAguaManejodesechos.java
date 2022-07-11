/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adsanchez.informecacao.verificacion;

import adsanchez.informecacao.extras.ConocimientoAreaRecepcioEnvasesProductosQuimicos;
import adsanchez.informecacao.extras.TieneDisenioFijo;
import adsanchez.informecacao.extras.TieneDisenioMovible;
import adsanchez.informecacao.extras.UtilizaFiltroEcologico;
import java.util.List;
import lombok.Data;

/**
 *
 * @author Javier
 */
@Data
public class ConservacionAguaManejodesechos {
    
    private String analisisAguaRiego;
    private String areaDeschPlasticos;
    private String clasificaBasuraDomestica;
    private ConocimientoAreaRecepcioEnvasesProductosQuimicos conocimientoAreaRecepcioEnvasesProductosQuimicos;
    private List<?> criterioClasificaBasuraDomestica;
    private List<?> disenioRiego;
    private String impactoRiego;
    private String infraestructuraRiego;
    private String permisoExtraerAguaRiego;
    private String practicaReciclajeCompostaje;
    private String presentaAnexos;
    private TieneDisenioFijo tieneDisenoFijo;
    private TieneDisenioMovible tieneDisenoMovible;
    private String tipoExtraccion;
    private String tratamientoAguasNegras;
    private String tratamientoBasura;
    private UtilizaFiltroEcologico utilizaFiltroEcologico;
}
