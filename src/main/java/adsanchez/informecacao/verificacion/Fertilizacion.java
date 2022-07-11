/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adsanchez.informecacao.verificacion;

import adsanchez.informecacao.extras.FertilizaCacaotales;
import adsanchez.informecacao.extras.RecibidoFertilizanteKits;
import adsanchez.informecacao.extras.UsaFertilizanteEdafico;
import adsanchez.informecacao.extras.UsaFertilizanteFoliar;
import lombok.Data;

/**
 *
 * @author Javier
 */
@Data
public class Fertilizacion {
    
    private String disminuidoProductosQuimicosPorOrganicos;
    private FertilizaCacaotales fertilizaCacaotales;
    private String opinionEfectividadFertilizante;
    private RecibidoFertilizanteKits recibidoFertilizanteKits;
    private String repetirCompraConDescuento;
    private UsaFertilizanteEdafico usaFertilizanteEdafico;
    private UsaFertilizanteFoliar usaFertilizanteFoliar;
    
}
