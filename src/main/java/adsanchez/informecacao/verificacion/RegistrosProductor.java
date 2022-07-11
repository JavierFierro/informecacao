/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adsanchez.informecacao.verificacion;

import adsanchez.informecacao.extras.DisponibilidadAhorrarEnCuenta;
import lombok.Data;

/**
 *
 * @author Javier
 */
@Data
public class RegistrosProductor {
    
    private DisponibilidadAhorrarEnCuenta disponibilidadAhorrarEnCuenta;
    private String egresoCompraMateriales;
    private String egresoManoObra;
    private String manejoCostosPlanificacionFinanciera;
    private String manejoCuadernilloRegistros;
    private String ventaAnualCacaoQuintales;
    private String ventaAnualCacaoUSD;
}
