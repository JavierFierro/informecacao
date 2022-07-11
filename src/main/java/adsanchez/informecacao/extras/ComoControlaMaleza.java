/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adsanchez.informecacao.extras;

import java.util.List;
import lombok.Data;

/**
 *
 * @author Javier
 */
@Data
public class ComoControlaMaleza {
    
    private String productoQuimicoUsado;
    private String recomendacionSeguidaAplicandoProductoQuimico;
    private String regularidadProductoQuimicoUsado;
    private List<?> respuesta;
}
