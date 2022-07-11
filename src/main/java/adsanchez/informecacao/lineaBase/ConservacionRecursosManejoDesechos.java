/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adsanchez.informecacao.lineaBase;

import adsanchez.informecacao.extras.CompraProductosMercadoLocales;
import adsanchez.informecacao.extras.ProductoContaminaEcosistema;
import lombok.Data;

/**
 *
 * @author Javier
 */
@Data
public class ConservacionRecursosManejoDesechos {
    
    private CompraProductosMercadoLocales compraProductosMercadoLocales;
    private String conocimientoManejoDesechos;
    private String cultivaVegetalesHortalizasFrutas;
    private ProductoContaminaEcosistema productoContaminaEcosistema;
    private String tieneArbolesSombrio;
}
