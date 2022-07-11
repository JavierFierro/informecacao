/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adsanchez.informecacao.verificacion;

import adsanchez.informecacao.extras.PersonaVenderCacao;
import adsanchez.informecacao.extras.RecibeBonosEmpresaProgramaLINDT;
import lombok.Data;

/**
 *
 * @author Javier
 */
@Data
public class Venta {
    
    private PersonaVenderCacao personaVenderCacao;
    private RecibeBonosEmpresaProgramaLINDT recibeBonosEmpresaProgramaLINDT;
}
