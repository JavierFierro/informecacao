/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adsanchez.informecacao.lineaBase;

import adsanchez.informecacao.extras.LlevaRegistroPerdidasMazorcasXMonilla;
import java.util.List;
import lombok.Data;

/**
 *
 * @author Javier
 */
@Data
public class PracticasAgricolas {
    
    private List<?> enfermedadesAfectanCultivo;
    private String interesElaborarFertilizanteNaturalOrganico;
    private LlevaRegistroPerdidasMazorcasXMonilla llevaRegistroPerdidasMazorcasXMonilla;
    private List<?> periodoControlMaleza;
    private List<?> periodoCosecha;
    private List<?> periodoFertilizacion;
    private List<?> periodoMIPE;
    private List<?> periodoPoda;
    private List<?> plagasAfectanCultivo;
    private String productoParaEnfermedades;
    private String productoParaPlagas;
}
