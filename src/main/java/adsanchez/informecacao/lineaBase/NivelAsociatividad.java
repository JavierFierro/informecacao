/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adsanchez.informecacao.lineaBase;

import adsanchez.informecacao.extras.AyudaOtraInstitucion;
import adsanchez.informecacao.extras.PerteneceAsocProgrCertif;
import lombok.Data;

/**
 *
 * @author Javier
 */
@Data
public class NivelAsociatividad {
    
    private AyudaOtraInstitucion ayudaOtraInstitucion;
    private PerteneceAsocProgrCertif perteneceAsocProgrCertif;
}
