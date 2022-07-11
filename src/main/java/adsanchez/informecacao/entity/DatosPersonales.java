/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adsanchez.informecacao.entity;

import java.util.List;
import lombok.Data;

/**
 *
 * @author Javier
 */
@Data
public class DatosPersonales {
    
    private String cedula;
    private String genero;
    private String isDiscapacitado;
    private String estadoCivil;
    private String tecnico;
    private String telefono;
    private String nombre;
    private String nivelEducacion;
    private List<?> celulares;
    private String fechaNacimiento;
    private String fechaVisita;
    
}
