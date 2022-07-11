/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adsanchez.informecacao.entity;

import adsanchez.informecacao.extras.NuevosClones;
import adsanchez.informecacao.extras.ViejosInjertados;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import lombok.Data;

/**
 *
 * @author Javier
 */
@Data
public class Campo {
    
    private Map<String, Object> preguntas;
    private String pregunta;
    
    public List<Object> getDatosPersonales(DatosPersonales datosPersonales){
        
        List<Object> respuestas = new LinkedList<>();
        ObjectMapper oMapper = new ObjectMapper();

        for(Map.Entry<String, Object> entry : preguntas.entrySet()) {
            
		String k = entry.getKey();
		Object v = entry.getValue();
                
                Map<String, Object> resultado = oMapper.convertValue(v, Map.class);
                for(Map.Entry<String, Object> entry1 : resultado.entrySet()) {
                    
                    String k1 = entry1.getKey();
                    Object v1 = entry1.getValue();
                    
                    datosPersonales(datosPersonales,k,v1);
                    
                    respuestas.add(v1);
//                    System.out.println("Key: " + k + ", Value: " + v1);
                }
                
        }
        return respuestas;
    }
    
    public List<Object> getCacaoCNN(CacaoCNN cacaocnn){
        
        List<Object> respuestas = new LinkedList<>();
        ObjectMapper oMapper = new ObjectMapper();

        for(Map.Entry<String, Object> entry : preguntas.entrySet()) {
            
		String k = entry.getKey();
		Object v = entry.getValue();
                
                Map<String, Object> resultado = oMapper.convertValue(v, Map.class);
                for(Map.Entry<String, Object> entry1 : resultado.entrySet()) {
                    
                    String k1 = entry1.getKey();
                    Object v1 = entry1.getValue();
                    
                    cacaoCNN(cacaocnn,k,v1);
                    
                    respuestas.add(v1);
//                    System.out.println("Key: " + k + ", Value: " + v1);
                }
                
        }
        return respuestas;
    }
    
    public List<Object> getCacaoNacional(CacaoNacional cacaoNacional){
        
        List<Object> respuestas = new LinkedList<>();
        ObjectMapper oMapper = new ObjectMapper();

        for(Map.Entry<String, Object> entry : preguntas.entrySet()) {
            
		String k = entry.getKey();
		Object v = entry.getValue();
                
                Map<String, Object> resultado = oMapper.convertValue(v, Map.class);
                for(Map.Entry<String, Object> entry1 : resultado.entrySet()) {
                    
                    String k1 = entry1.getKey();
                    Object v1 = entry1.getValue();
                    
                    cacaoNacional(cacaoNacional,k,v1);
                    
                    respuestas.add(v1);
//                    System.out.println("Key: " + k + ", Value: " + v1);
                }
                
        }
        return respuestas;
    }
    
    public List<Object> getCacaoNacionalNC(CacaoNacionalNC cacaoNacionalnc){
        
        List<Object> respuestas = new LinkedList<>();
        ObjectMapper oMapper = new ObjectMapper();

        for(Map.Entry<String, Object> entry : preguntas.entrySet()) {
            
		String k = entry.getKey();
		Object v = entry.getValue();
                
                Map<String, Object> resultado = oMapper.convertValue(v, Map.class);
                for(Map.Entry<String, Object> entry1 : resultado.entrySet()) {
                    
                    String k1 = entry1.getKey();
                    Object v1 = entry1.getValue();
                    
                    cacaoNacionalNC(cacaoNacionalnc,k,v1);
                    
                    respuestas.add(v1);
//                    System.out.println("Key: " + k + ", Value: " + v1);
                }
                
        }
        return respuestas;
    }
    
    public List<Object> getCroquis(Croquis croquis){
        
        List<Object> respuestas = new LinkedList<>();
        ObjectMapper oMapper = new ObjectMapper();

        for(Map.Entry<String, Object> entry : preguntas.entrySet()) {
            
		String k = entry.getKey();
		Object v = entry.getValue();
                
                Map<String, Object> resultado = oMapper.convertValue(v, Map.class);
                for(Map.Entry<String, Object> entry1 : resultado.entrySet()) {
                    
                    String k1 = entry1.getKey();
                    Object v1 = entry1.getValue();
                    
                    Croquis(croquis,k,v1);
                    
                    respuestas.add(v1);
//                    System.out.println("Key: " + k + ", Value: " + v1);
                }
                
        }
        return respuestas;
    }
    
    public List<Object> getHectareaje(Hectareaje hectareaje){
        
        List<Object> respuestas = new LinkedList<>();
        ObjectMapper oMapper = new ObjectMapper();

        for(Map.Entry<String, Object> entry : preguntas.entrySet()) {
            
		String k = entry.getKey();
		Object v = entry.getValue();
                
                Map<String, Object> resultado = oMapper.convertValue(v, Map.class);
                for(Map.Entry<String, Object> entry1 : resultado.entrySet()) {
                    
                    String k1 = entry1.getKey();
                    Object v1 = entry1.getValue();
                    
                    Hectareaje(hectareaje,k,v1);
                    
                    respuestas.add(v1);
//                    System.out.println("Key: " + k + ", Value: " + v1);
                }
                
        }
        return respuestas;
    }
    
    public List<Object> getInformacionFinca(InformacionFinca informacionFinca){
        
        List<Object> respuestas = new LinkedList<>();
        ObjectMapper oMapper = new ObjectMapper();

        for(Map.Entry<String, Object> entry : preguntas.entrySet()) {
            
		String k = entry.getKey();
		Object v = entry.getValue();
                
                Map<String, Object> resultado = oMapper.convertValue(v, Map.class);
                for(Map.Entry<String, Object> entry1 : resultado.entrySet()) {
                    
                    String k1 = entry1.getKey();
                    Object v1 = entry1.getValue();
                    
                    InformacionFinca(informacionFinca,k,v1);
                    
                    respuestas.add(v1);
//                    System.out.println("Key: " + k + ", Value: " + v1);
                }
                
        }
        return respuestas;
    }
    
    public List<Object> getOrigenPlantas(OrigenPlantas origenPlantas){
        
        List<Object> respuestas = new LinkedList<>();
        ObjectMapper oMapper = new ObjectMapper();

        for(Map.Entry<String, Object> entry : preguntas.entrySet()) {
            
		String k = entry.getKey();
		Object v = entry.getValue();
                
                Map<String, Object> resultado = oMapper.convertValue(v, Map.class);
                for(Map.Entry<String, Object> entry1 : resultado.entrySet()) {
                    
                    String k1 = entry1.getKey();
                    Object v1 = entry1.getValue();
                    
                    OrigenPlantas(origenPlantas,k,v1);
                    
                    respuestas.add(v1);
//                    System.out.println("Key: " + k + ", Value: " + v1);
                }
                
        }
        return respuestas;
    }
    
    
    
    public void OrigenPlantas(OrigenPlantas origenPlantas, String registro, Object object){
        
        switch(registro){   
            
            case "cantidadPlantasRecibidas":  
                origenPlantas.setCantidadPlantasRecibidas(object.toString());
             break;
             case "encargadoPropagacion":  
                origenPlantas.setEncargadoPropagacion(object.toString());
             break;
             case "entidadDonacion":  
                origenPlantas.setEntidadDonacion(object.toString());
             break;
             case "nombreVivero":  
                origenPlantas.setNombreVivero(object.toString());
             break;
             case "tipoConocimiento":  
                origenPlantas.setTipoConocimiento(object.toString());
             break;
             case "ubicacionVivero":  
                origenPlantas.setUbicacionVivero(object.toString());
             break;
            
        }
    }
    
    public void InformacionFinca(InformacionFinca informacionFinca, String registro, Object object){
        
        switch(registro){   
            
            case "canton":  
                informacionFinca.setCanton(object.toString());
             break;
            case "descripcionLlegarFinca":  
                informacionFinca.setDescripcionLlegarFinca(object.toString());
             break;
            case "nombreFinca":  
                informacionFinca.setNombreFinca(object.toString());
             break;
            case "parroquia":  
                informacionFinca.setParroquia(object.toString());
             break;
            case "provincia":  
                informacionFinca.setProvincia(object.toString());
             break;
            case "recinto":  
                informacionFinca.setRecinto(object.toString());
             break;
            
            
        }
    }
    
    public void Hectareaje(Hectareaje hectareaje, String registro, Object object){
        
        switch(registro){    
            case "areaNetaCacao":  
                hectareaje.setAreaNetaCacao(object.toString());
             break;
            case "cultivoCacao":  
                hectareaje.setCultivoCacao(object.toString());
             break;
            case "dimensionTotalFinca":  
                hectareaje.setDimensionTotalFinca(object.toString());
             break;
            case "distanciaPlantas":  
                hectareaje.setDistanciaPlantas(object.toString());
             break;
            case "plantasXHectareas":  
                hectareaje.setPlantasXHectareas(object.toString());
             break;
            case "terreno":  
                hectareaje.setTerreno(object.toString());
             break;
            case "tipoUbicacionZona":  
                hectareaje.setTipoUbicacionZona(object.toString());
             break;
            
            
        } 
    }
    
    public void Croquis(Croquis croquis, String registro, Object object){
        
        switch(registro){    
            case "coordenadasX":  
                croquis.setCoordenadasX(object.toString());
             break;
            case "coordenadasY":  
                croquis.setCoordenadasY(object.toString());
             break;
            case "croquisPath":  
                croquis.setCroquisPath(object.toString());
             break;
            case "predio":  
                croquis.setPredio(object.toString());
             break;
            case "productor":  
                croquis.setProductor(object.toString());
             break;
            
        } 
    }
    
    public void cacaoNacionalNC(CacaoNacionalNC cacaoNacionalnc, String registro, Object object){
        
        switch(registro){    
            case "plantulasCondicionesEdafoclimaticas":  
                cacaoNacionalnc.setPlantulasCondicionesEdafoclimaticas(object.toString());
             break;
            case "plantulasRendimiento":  
                cacaoNacionalnc.setPlantulasRendimiento(object.toString());
             break;
            case "plantulasResistenciaEnfermedades":  
                cacaoNacionalnc.setPlantulasResistenciaEnfermedades(object.toString());
             break;
            case "plantulasVigorPlanta":  
                cacaoNacionalnc.setPlantulasVigorPlanta(object.toString());
             break;
            case "tipoVariedad":  
                cacaoNacionalnc.setTipoVariedad(convertObjectToList(object));
             break;
            case "usoAnteriorAreaNueva":  
                cacaoNacionalnc.setUsoAnteriorAreaNueva(object.toString());
             break;
            case "variedadesSembradasCalificacion":  
                cacaoNacionalnc.setVariedadesSembradasCalificacion(object.toString());
             break;
            

        } 
    }
    
    public void cacaoNacional(CacaoNacional cacaoNacional, String registro, Object object){
        
        switch(registro){    
            case "arbolesElite":  
                cacaoNacional.setArbolesElite(object.toString());
             break;
            case "areaTotalNacional":  
                cacaoNacional.setAreaTotalNacional(object.toString());
             break;
            case "areaTotalNacionalViejo":  
                cacaoNacional.setAreaTotalNacionalViejo(object.toString());
             break;
            case "areaTotalNuevosClones":  
                cacaoNacional.setAreaTotalNuevosClones(object.toString());
             break;
            case "areaTotalViejoInjertado":  
                cacaoNacional.setAreaTotalViejoInjertado(object.toString());
             break;
            case "brotesBasales":  
                cacaoNacional.setBrotesBasales(object.toString());
             break;
            case "edadCacaoViejo":  
                cacaoNacional.setEdadCacaoViejo(object.toString());
             break;
            case "nuevosClones":  
                
                ObjectMapper oMapper = new ObjectMapper();
                
                List<?> nc = convertObjectToList(object);
                
                List<NuevosClones> ncList = new LinkedList<>();
                
                for(int i=0; i<nc.size();i++){
                    
                    NuevosClones nuevosClones = new NuevosClones();
                    
                    Map<String, Object> ncmap = (Map<String, Object>) nc.get(i);
                    
                    for(Map.Entry<String, Object> entry : ncmap.entrySet()) {
                        
                        String k = entry.getKey();
                        Object v = entry.getValue();

                        Map<String, Object> resultado = oMapper.convertValue(v, Map.class);
                        for(Map.Entry<String, Object> entry1 : resultado.entrySet()) {
                            
                            String k1 = entry1.getKey();
                            Object v1 = entry1.getValue();

                            if(k.equals("edadNuevosClones")){
                                
                                nuevosClones.setEdadNuevosClones(v1.toString());  
                                
                            }else if(k.equals("areaNuevosClones")){
                                
                                nuevosClones.setAreaNuevosClones(v1.toString());
                                
                            }
                        }
                    }
                    ncList.add(nuevosClones);
                }
                cacaoNacional.setNuevosClones(ncList);
             break;
            case "precioPromedioXCacao":  
                cacaoNacional.setPrecioPromedioXCacao(object.toString());
             break;
            case "produccionAnioAnteriorCacaoNacional":  
                cacaoNacional.setProduccionAnioAnteriorCacaoNacional(object.toString());
             break;
            case "viejosInjertados":  
                
                ObjectMapper oMappervi = new ObjectMapper();
                
                List<?> vi = convertObjectToList(object);
                
                List<ViejosInjertados> viList = new LinkedList<>();
                
                for(int i=0; i<vi.size();i++){
                    
                    ViejosInjertados viejosInjertados = new ViejosInjertados();
                    
                    Map<String, Object> vimap = (Map<String, Object>) vi.get(i);
                    
                    for(Map.Entry<String, Object> entry : vimap.entrySet()) {
                    
                        String k = entry.getKey();
                        Object v = entry.getValue();

                        Map<String, Object> resultado = oMappervi.convertValue(v, Map.class);
                        for(Map.Entry<String, Object> entry1 : resultado.entrySet()) {
                            String k1 = entry1.getKey();
                            Object v1 = entry1.getValue();

                            if(k.equals("edadViejoInjertado")){
                                viejosInjertados.setEdadViejoInjertado(v1.toString());
                            }else if(k.equals("areaViejoInjertado")){
                                viejosInjertados.setAreaViejoInjertado(v1.toString());
                            }
                        }
                    
                    }
                    viList.add(viejosInjertados);
                }
                cacaoNacional.setViejosInjertados(viList);
             break;
            
            

        } 
    }
    
    public void cacaoCNN(CacaoCNN cacaocnn, String registro, Object object){
        
        switch(registro){    
            case "areaProduccion":  
                cacaocnn.setAreaProduccion(object.toString());
             break;
            case "edadCacaoProductivo":  
                cacaocnn.setEdadCacaoProductivo(object.toString());
             break;
            case "produccionAnioAnteriorCacaoCNN":  
                cacaocnn.setProduccionAnioAnteriorCacaoCNN(object.toString());
             break;
            case "areaRecienSembrada":  
                cacaocnn.setAreaRecienSembrada(object.toString());
             break;
            case "edadCacaoReciente":  
                cacaocnn.setEdadCacaoReciente(object.toString());
             break;
            case "precioPromedio":  
                cacaocnn.setPrecioPromedio(object.toString());
             break;
            case "areaTotalCNN":  
                cacaocnn.setAreaTotalCNN(object.toString());
             break;
            

        } 
    }
    
    public void datosPersonales(DatosPersonales datosPersonales, String registro, Object object){
        
        switch(registro){    
            case "cedula":  
                datosPersonales.setCedula(object.toString());
             break;   
            case "genero":  
                datosPersonales.setGenero(object.toString());
             break; 
            case "isDiscapacitado":  
                datosPersonales.setIsDiscapacitado(object.toString());
             break; 
            case "estadoCivil":  
               datosPersonales.setEstadoCivil(object.toString());
             break; 
            case "tecnico":  
               datosPersonales.setTecnico(object.toString());
             break; 
            case "telefono":  
               datosPersonales.setTelefono(object.toString());
             break; 
            case "nombre":  
               datosPersonales.setNombre(object.toString());
             break; 
            case "nivelEducacion":  
               datosPersonales.setNivelEducacion(object.toString());
             break;
            case "celulares":  
              datosPersonales.setCelulares(convertObjectToList(object));
             break;
            case "fechaNacimiento":  
//              String segundosNacimiento = TimestampToString(object);
//              
//              Date dateNacimiento = new Date(Integer.valueOf(segundosNacimiento) * 1000);
//              String fechaNacimiento = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(dateNacimiento);

              datosPersonales.setFechaNacimiento(object.toString());
             break;
            case "fechaVisita":  
//              String segundosVisita = TimestampToString(object);
//              
//              Date dateVisita = new Date(Integer.valueOf(segundosVisita) * 1000);
//              String fechaVisita = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(dateVisita);

              datosPersonales.setFechaVisita(object.toString());
             break;
        }    
    }
    
    
    
    public static List<?> convertObjectToList(Object obj) {
        List<?> list = new ArrayList<>();
        if (obj.getClass().isArray()) {
            list = Arrays.asList((Object[])obj);
        } else if (obj instanceof Collection) {
            list = new ArrayList<>((Collection<?>)obj);
        }
        return list;
    }
    
    public String TimestampToString(Object object){
        
        String seconds = "";
        
        ObjectMapper oMapper = new ObjectMapper();
        
        Map<String, Object> time = oMapper.convertValue(object, Map.class);

        for(Map.Entry<String, Object> entry : time.entrySet()) {
            
            String k = entry.getKey();
            Object v = entry.getValue();
            
            if(k.equals("seconds")){
                seconds = v.toString();
            }
        }
        
        return seconds;
    }
    
}
