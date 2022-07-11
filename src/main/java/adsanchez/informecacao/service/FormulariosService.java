/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adsanchez.informecacao.service;

import adsanchez.informecacao.entity.LineaBase;
import adsanchez.informecacao.entity.Verificacion;
import adsanchez.informecacao.extras.AccidentesLaboralesUltimoAnio;
import adsanchez.informecacao.extras.AlmacenaCacaoDespSecado;
import adsanchez.informecacao.extras.AlmacenaSeguridadEnvasesPrevioTraslado;
import adsanchez.informecacao.extras.AnalisisSuelo;
import adsanchez.informecacao.extras.AyudaOtraInstitucion;
import adsanchez.informecacao.extras.BrindaProteccionFuenteHidrica;
import adsanchez.informecacao.extras.ComoControlaMaleza;
import adsanchez.informecacao.extras.CompraProductosMercadoLocales;
import adsanchez.informecacao.extras.ConoceEspeciePeligroExtincionEnFinca;
import adsanchez.informecacao.extras.ConocimientoAreaRecepcioEnvasesProductosQuimicos;
import adsanchez.informecacao.extras.ConocimientoDisposicionMaquinariaAgricola;
import adsanchez.informecacao.extras.ContrataMenoresEdad;
import adsanchez.informecacao.extras.ContrataTrabajadores;
import adsanchez.informecacao.extras.ControlaMalezas;
import adsanchez.informecacao.extras.CuentaConAreaForestales;
import adsanchez.informecacao.extras.DeseoTrabajoMedioTiempoProyectosFuturos;
import adsanchez.informecacao.extras.DisponibilidadAhorrarEnCuenta;
import adsanchez.informecacao.extras.FermentaCacao;
import adsanchez.informecacao.extras.FertilizaCacaotales;
import adsanchez.informecacao.extras.FincaConsideradaAltoValor;
import adsanchez.informecacao.extras.IncrementoHectareajeFinca;
import adsanchez.informecacao.extras.LlevaRegistroPerdidasMazorcasXMonilla;
import adsanchez.informecacao.extras.MalaPodaAlbergaPlagasEnfermedades;
import adsanchez.informecacao.extras.ManeraCorregidoPHSuelo;
import adsanchez.informecacao.extras.NecesitaImplementarPracticasMejoraSuelo;
import adsanchez.informecacao.extras.NombreFuenteHidrica;
import adsanchez.informecacao.extras.OtraActividadFueraFincaConIngreso;
import adsanchez.informecacao.extras.PeriodoIntoxicacionPresente;
import adsanchez.informecacao.extras.PersonaVenderCacao;
import adsanchez.informecacao.extras.PerteneceAsocProgrCertif;
import adsanchez.informecacao.extras.PlantadoArbolesSombrioReciente;
import adsanchez.informecacao.extras.PoseeFuenteHidrica;
import adsanchez.informecacao.extras.PoseeNacientes;
import adsanchez.informecacao.extras.ProductoContaminaEcosistema;
import adsanchez.informecacao.extras.RealizaPoda;
import adsanchez.informecacao.extras.RealizaPodaFitosanitaria;
import adsanchez.informecacao.extras.RealizaPodaFormacion;
import adsanchez.informecacao.extras.RealizaPodaMantenimiento;
import adsanchez.informecacao.extras.RealizaPodaRehabilitacion;
import adsanchez.informecacao.extras.RealizaPracticasMPE;
import adsanchez.informecacao.extras.RealizoInjertosUltimos12Meses;
import adsanchez.informecacao.extras.RecibeBonosEmpresaProgramaLINDT;
import adsanchez.informecacao.extras.RecibidoFertilizanteKits;
import adsanchez.informecacao.extras.SueloPresentaProblemaErosion;
import adsanchez.informecacao.extras.SuelosNivelesAltosAcidez;
import adsanchez.informecacao.extras.TieneDisenioFijo;
import adsanchez.informecacao.extras.TieneDisenioMovible;
import adsanchez.informecacao.extras.TiposBeneficios;
import adsanchez.informecacao.extras.UsaFertilizanteEdafico;
import adsanchez.informecacao.extras.UsaFertilizanteFoliar;
import adsanchez.informecacao.extras.UtilizaFiltroEcologico;
import adsanchez.informecacao.lineaBase.CondicionesLaboralesLB;
import adsanchez.informecacao.lineaBase.ConservacionRecursosManejoDesechos;
import adsanchez.informecacao.lineaBase.CosechaLB;
import adsanchez.informecacao.lineaBase.InformacionFamilia;
import adsanchez.informecacao.lineaBase.NivelAsociatividad;
import adsanchez.informecacao.lineaBase.PracticasAgricolas;
import adsanchez.informecacao.lineaBase.SaludSeguridadOcupacionalLB;
import adsanchez.informecacao.lineaBase.SeccionesLB;
import adsanchez.informecacao.lineaBase.ServiciosBasicos;
import adsanchez.informecacao.lineaBase.VentaLB;
import adsanchez.informecacao.lineaBase.Miembro;
import adsanchez.informecacao.verificacion.Bodega;
import adsanchez.informecacao.verificacion.CondicionesLaborales;
import adsanchez.informecacao.verificacion.ConservacionAguaManejodesechos;
import adsanchez.informecacao.verificacion.ConservacionSuelosBiodiversidad;
import adsanchez.informecacao.verificacion.ControlMalezas;
import adsanchez.informecacao.verificacion.Cosecha;
import adsanchez.informecacao.verificacion.DatosFinca;
import adsanchez.informecacao.verificacion.DiversificacionIngresos;
import adsanchez.informecacao.verificacion.Fermentacion;
import adsanchez.informecacao.verificacion.Fertilizacion;
import adsanchez.informecacao.verificacion.Injertacion;
import adsanchez.informecacao.verificacion.MIPE;
import adsanchez.informecacao.verificacion.ManejoSuelo;
import adsanchez.informecacao.verificacion.Poda;
import adsanchez.informecacao.verificacion.ProteccionAreasAltoValorConservacion;
import adsanchez.informecacao.verificacion.ProteccionAreasRiberenias;
import adsanchez.informecacao.verificacion.RegistrosProductor;
import adsanchez.informecacao.verificacion.SaludSeguridadOcupacional;
import adsanchez.informecacao.verificacion.Secado;
import adsanchez.informecacao.verificacion.SeccionesVerificacion;
import adsanchez.informecacao.verificacion.Venta;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.firebase.cloud.FirestoreClient;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import org.springframework.stereotype.Service;

/**
 *
 * @author Javier
 */
@Service
public class FormulariosService {
    
    public static final String COL_NAME = "formularios";
    
    public SeccionesVerificacion getVerificacion(String id) throws InterruptedException, ExecutionException {
        
        SeccionesVerificacion seccionesVerificacion = new SeccionesVerificacion();
        
        
        Firestore dbFirestore = FirestoreClient.getFirestore();

        ApiFuture<QuerySnapshot> future = dbFirestore.collection(COL_NAME).document("verificacion").collection("estructuras").get();

        List<QueryDocumentSnapshot> documents = future.get().getDocuments();
        
        Verificacion lineaBase = new Verificacion();

        for (QueryDocumentSnapshot document : documents) {
            String idDoc = document.getId();
            
            Secado secado = new Secado();
            
            if(document.getString("agricultorId").equals(id)){
                
                seccionesVerificacion.setId(document.getId());
                
                lineaBase = diccionarioVerificacion(idDoc,"verificacion");

                Verificacion(lineaBase,seccionesVerificacion);
                
            }
            
        }
        
        return seccionesVerificacion;
        
    }
    
    public SeccionesLB getLineaBase(String id) throws InterruptedException, ExecutionException {
        
        SeccionesLB seccionesLb = new SeccionesLB();
        
        Firestore dbFirestore = FirestoreClient.getFirestore();

        ApiFuture<QuerySnapshot> future = dbFirestore.collection(COL_NAME).document("lineaBase").collection("estructuras").get();

        List<QueryDocumentSnapshot> documents = future.get().getDocuments();
        
        LineaBase lineaBase = new LineaBase();

        for (QueryDocumentSnapshot document : documents) {
            String idDoc = document.getId();
            
            Secado secado = new Secado();
            
            if(document.getString("agricultorId").equals(id)){
                
                seccionesLb.setId(document.getId());
                
                lineaBase = diccionarioLineaBase(idDoc,"lineaBase");

                LineaBase(lineaBase,seccionesLb);
                
            }
            
        }
        
        return seccionesLb;
    }
    
    public void LineaBase(LineaBase lineaBase, SeccionesLB seccionesLb){
                
        Miembro miembro = new Miembro();
        
        VentaLB venta = new VentaLB();
        
        ServiciosBasicos serviciosBasicos = new ServiciosBasicos();
        
        SaludSeguridadOcupacionalLB saludSeguridad = new SaludSeguridadOcupacionalLB();
        
        PracticasAgricolas practicasAgricolas = new PracticasAgricolas();
        
        NivelAsociatividad nivelAsociatividad = new NivelAsociatividad();
        
        InformacionFamilia informacionFamilia = new InformacionFamilia();
        
        CosechaLB cosecha = new CosechaLB();
        
        ConservacionRecursosManejoDesechos conservacionRecursosDesechos = new ConservacionRecursosManejoDesechos();
        
        CondicionesLaboralesLB condicionesLaborales = new CondicionesLaboralesLB();
        
        ObjectMapper oMapper = new ObjectMapper();
        
        Map<String, Object> map = lineaBase.getDiccionario();
                
        for(Map.Entry<String, Object> entry : map.entrySet()) {
            String k = entry.getKey();
            Object v = entry.getValue();

            if(k.equals("secciones")){
                Map<String, Object> resultado = oMapper.convertValue(v, Map.class);

                for(Map.Entry<String, Object> entry1 : resultado.entrySet()) {
                    String k1 = entry1.getKey();
                    Object v1 = entry1.getValue();

                    SeccionesLineaBase(k1,v1,oMapper,seccionesLb,condicionesLaborales,
                            conservacionRecursosDesechos,cosecha,informacionFamilia,nivelAsociatividad,
                            practicasAgricolas,saludSeguridad,serviciosBasicos,venta, miembro);

                }

            }
        }
    }
    
    public void SeccionesLineaBase(String registro, Object object, ObjectMapper oMapper,SeccionesLB seccionesLb,
            CondicionesLaboralesLB condicionesLaborales,ConservacionRecursosManejoDesechos conservacionRecursosDesechos,
            CosechaLB cosecha,InformacionFamilia informacionFamilia,NivelAsociatividad nivelAsociatividad,
            PracticasAgricolas practicasAgricolas,SaludSeguridadOcupacionalLB saludSeguridad,
            ServiciosBasicos serviciosBasicos,VentaLB venta, Miembro miembro){
    
        ContrataMenoresEdad contrataMenoresEdad = new ContrataMenoresEdad();
        ContrataTrabajadores contrataTrabajadores = new ContrataTrabajadores();
        CompraProductosMercadoLocales compraProductosMercadoLocales = new CompraProductosMercadoLocales();
        ProductoContaminaEcosistema productoContaminaEcosistema = new ProductoContaminaEcosistema();
        DeseoTrabajoMedioTiempoProyectosFuturos deseoTrabajoMedioTiempoProyectosFuturos = new DeseoTrabajoMedioTiempoProyectosFuturos();
        AyudaOtraInstitucion ayudaOtraInstitucion = new AyudaOtraInstitucion();
        PerteneceAsocProgrCertif perteneceAsocProgrCertif = new PerteneceAsocProgrCertif();
        TiposBeneficios tiposBeneficios = new TiposBeneficios();
        LlevaRegistroPerdidasMazorcasXMonilla llevaRegistroPerdidasMazorcasXMonilla = new LlevaRegistroPerdidasMazorcasXMonilla();
        AccidentesLaboralesUltimoAnio accidentesLaboralesUltimoAnio = new AccidentesLaboralesUltimoAnio();
        PeriodoIntoxicacionPresente periodoIntoxicacionPresente = new PeriodoIntoxicacionPresente(); 
        AlmacenaCacaoDespSecado almacenaCacaoDespSecado = new AlmacenaCacaoDespSecado();
        
        switch(registro){
            case "condicionesLaborales":
                Map<String, Object> resultado1 = oMapper.convertValue(object, Map.class);
                for(Map.Entry<String, Object> entry2 : resultado1.entrySet()) {
                    String k2 = entry2.getKey();
                    Object v2 = entry2.getValue();

                    Map<String, Object> resultado2 = oMapper.convertValue(v2, Map.class);
                    for(Map.Entry<String, Object> entry3 : resultado2.entrySet()) {
                        String k3 = entry3.getKey();
                        Object v3 = entry3.getValue();

                        Map<String, Object> resultado3 = oMapper.convertValue(v3, Map.class);
                        for(Map.Entry<String, Object> entry4 : resultado3.entrySet()) {
                            String k4 = entry4.getKey();
                            Object v4 = entry4.getValue();
                            
                            switch(k3){
                            case "areaInicialContrato":
                                condicionesLaborales.setAreaInicialContrato(v4.toString());
                             break;
                            case "baseContratoAgricola":
                                condicionesLaborales.setBaseContratoAgricola(v4.toString());
                             break;
                            case "contrataMenoresEdad":
                                
                                if(!k4.equals("respuesta")){
                                    Map<String, Object> resultado = oMapper.convertValue(v4, Map.class);
                                    for(Map.Entry<String, Object> entry5 : resultado.entrySet()) {
                                        String k5 = entry5.getKey();
                                        Object v5 = entry5.getValue();
                                        
                                        Map<String, Object> resultado0 = oMapper.convertValue(v5, Map.class);
                                        for(Map.Entry<String, Object> entry6 : resultado0.entrySet()) {
                                            String k6 = entry6.getKey();
                                            Object v6 = entry6.getValue();
                                            
//                                            System.out.println(k6+" "+v6);
                                            contrataMenoresEdad.setPoseePermiso(v6.toString());
                                        }
                                        
                                    }
                                }else{
                                    contrataMenoresEdad.setRespuesta(v4.toString());
                                }
                                
                                condicionesLaborales.setContrataMenoresEdad(contrataMenoresEdad);

                             break;
                            case "contrataTrabajadores":
                                
                                if(!k4.equals("respuesta")){
                                    Map<String, Object> resultado = oMapper.convertValue(v4, Map.class);
                                    for(Map.Entry<String, Object> entry5 : resultado.entrySet()) {
                                        String k5 = entry5.getKey();
                                        Object v5 = entry5.getValue();
                                        
                                        Map<String, Object> resultado0 = oMapper.convertValue(v5, Map.class);
                                        for(Map.Entry<String, Object> entry6 : resultado0.entrySet()) {
                                            String k6 = entry6.getKey();
                                            Object v6 = entry6.getValue();
                                            
//                                            System.out.println(k6+" "+v6);
                                            contrataTrabajadores.setCantidadTrabajadores(v6.toString());
                                        }
                                        
                                    }
                                }else{
                                    contrataTrabajadores.setRespuesta(v4.toString());
                                }
                                
                                condicionesLaborales.setContrataTrabajadores(contrataTrabajadores);
                             break;
                            case "tipoContratoTrabajo":
                                condicionesLaborales.setTipoContratoTrabajo(v4.toString());
                             break;
                            }
                        }
                        
//                        System.out.println(k3+" "+v3);
                    }
                seccionesLb.setCondicionesLaborales(condicionesLaborales);
                }
             break;
            case "conservacionRecursosManejoDesechos":
                Map<String, Object> resultado4 = oMapper.convertValue(object, Map.class);
                for(Map.Entry<String, Object> entry2 : resultado4.entrySet()) {
                    String k2 = entry2.getKey();
                    Object v2 = entry2.getValue();

                    Map<String, Object> resultado2 = oMapper.convertValue(v2, Map.class);
                    for(Map.Entry<String, Object> entry3 : resultado2.entrySet()) {
                        String k3 = entry3.getKey();
                        Object v3 = entry3.getValue();

                        Map<String, Object> resultado3 = oMapper.convertValue(v3, Map.class);
                        for(Map.Entry<String, Object> entry4 : resultado3.entrySet()) {
                            String k4 = entry4.getKey();
                            Object v4 = entry4.getValue();
                            
                            switch(k3){
                            case "compraProductosMercadoLocales":
                                
                                if(!k4.equals("respuesta")){
                                    Map<String, Object> resultado = oMapper.convertValue(v4, Map.class);
                                    for(Map.Entry<String, Object> entry5 : resultado.entrySet()) {
                                        String k5 = entry5.getKey();
                                        Object v5 = entry5.getValue();
                                        
                                        Map<String, Object> resultado0 = oMapper.convertValue(v5, Map.class);
                                        for(Map.Entry<String, Object> entry6 : resultado0.entrySet()) {
                                            String k6 = entry6.getKey();
                                            Object v6 = entry6.getValue();
                                            
//                                            System.out.println(k6+" "+v6);
                                            compraProductosMercadoLocales.setValorPromedioGastado(v6.toString());
                                        }
                                        
                                    }
                                }else{
                                    compraProductosMercadoLocales.setRespuesta(v4.toString());
                                }
                                
                                conservacionRecursosDesechos.setCompraProductosMercadoLocales(compraProductosMercadoLocales);
                                
                             break;
                            case "conocimientoManejoDesechos":
                                conservacionRecursosDesechos.setConocimientoManejoDesechos(v4.toString());
                             break;
                            case "cultivaVegetalesHortalizasFrutas":
                                conservacionRecursosDesechos.setCultivaVegetalesHortalizasFrutas(v4.toString());
                             break;
                            case "productoContaminaEcosistema":
                                
                                if(!k4.equals("respuesta")){
                                    Map<String, Object> resultado = oMapper.convertValue(v4, Map.class);
                                    for(Map.Entry<String, Object> entry5 : resultado.entrySet()) {
                                        String k5 = entry5.getKey();
                                        Object v5 = entry5.getValue();
                                        
                                        Map<String, Object> resultado0 = oMapper.convertValue(v5, Map.class);
                                        for(Map.Entry<String, Object> entry6 : resultado0.entrySet()) {
                                            String k6 = entry6.getKey();
                                            Object v6 = entry6.getValue();
                                            
//                                            System.out.println(k6+" "+v6);
                                            productoContaminaEcosistema.setUbicacionDesechosAguasNegras(convertObjectToList(v6));
                                        }
                                        
                                    }
                                }else{
                                    productoContaminaEcosistema.setRespuesta(v4.toString());
                                }
                                
                                conservacionRecursosDesechos.setProductoContaminaEcosistema(productoContaminaEcosistema);
                             break;
                            case "tieneArbolesSombrio":
                                conservacionRecursosDesechos.setTieneArbolesSombrio(v4.toString());
                             break;
                            }
                        }
                        
//                        System.out.println(k3+" "+v3);
                    }
                seccionesLb.setConservacionRecursosDesechos(conservacionRecursosDesechos);
                }
             break;
            case "cosecha":
                Map<String, Object> resultado5 = oMapper.convertValue(object, Map.class);
                for(Map.Entry<String, Object> entry2 : resultado5.entrySet()) {
                    String k2 = entry2.getKey();
                    Object v2 = entry2.getValue();

                    Map<String, Object> resultado2 = oMapper.convertValue(v2, Map.class);
                    for(Map.Entry<String, Object> entry3 : resultado2.entrySet()) {
                        String k3 = entry3.getKey();
                        Object v3 = entry3.getValue();

                        Map<String, Object> resultado3 = oMapper.convertValue(v3, Map.class);
                        for(Map.Entry<String, Object> entry4 : resultado3.entrySet()) {
                            String k4 = entry4.getKey();
                            Object v4 = entry4.getValue();
                            
                            switch(k3){
                            case "diasFermentadoCacao":
                                cosecha.setDiasFermentadoCacao(v4.toString());
                             break;
                            case "latasCacaoXTumba":
                                cosecha.setLatasCacaoXTumba(v4.toString());
                             break;
                            case "periodoCadaTumba":
                                cosecha.setPeriodoCadaTumba(v4.toString());
                             break;
                            case "realizaEscurridoSecadoCCN51":
                                cosecha.setRealizaEscurridoSecadoCCN51(v4.toString());
                             break;
                            }
                        }
                        
//                        System.out.println(k3+" "+v3);
                    }
                seccionesLb.setCosecha(cosecha);
                }
             break;
            case "informacionFamilia":
                Map<String, Object> resultado6 = oMapper.convertValue(object, Map.class);
                for(Map.Entry<String, Object> entry2 : resultado6.entrySet()) {
                    String k2 = entry2.getKey();
                    Object v2 = entry2.getValue();

                    Map<String, Object> resultado2 = oMapper.convertValue(v2, Map.class);
                    for(Map.Entry<String, Object> entry3 : resultado2.entrySet()) {
                        String k3 = entry3.getKey();
                        Object v3 = entry3.getValue();

                        Map<String, Object> resultado3 = oMapper.convertValue(v3, Map.class);
                        for(Map.Entry<String, Object> entry4 : resultado3.entrySet()) {
                            String k4 = entry4.getKey();
                            Object v4 = entry4.getValue();
                            
                            switch(k3){
                            case "deseoIngresoAdicionalConyuge":
                                informacionFamilia.setDeseoIngresoAdicionalConyuge(v4.toString());
                                break;
                            case "deseoTrabajoMedioTiempoProyectosFuturos":
                                
                                if(!k4.equals("respuesta")){
                                    Map<String, Object> resultado = oMapper.convertValue(v4, Map.class);
                                    for(Map.Entry<String, Object> entry5 : resultado.entrySet()) {
                                        String k5 = entry5.getKey();
                                        Object v5 = entry5.getValue();
                                        
                                        Map<String, Object> resultado0 = oMapper.convertValue(v5, Map.class);
                                        for(Map.Entry<String, Object> entry6 : resultado0.entrySet()) {
                                            String k6 = entry6.getKey();
                                            Object v6 = entry6.getValue();
                                            
//                                            System.out.println(k6+" "+v6);
                                            deseoTrabajoMedioTiempoProyectosFuturos.setComoCual(v6.toString());
                                        }
                                        
                                    }
                                }else{
                                    deseoTrabajoMedioTiempoProyectosFuturos.setRespuesta(v4.toString());
                                }
                                
                                informacionFamilia.setDeseoTrabajoMedioTiempoProyectosFuturos(deseoTrabajoMedioTiempoProyectosFuturos);
                             break;
                            case "esposaInvolucradaEntrevista":
                                informacionFamilia.setEsposaInvolucradaEntrevista(v4.toString());
                             break;
                            case "esposoIncluyeEsposaEntrevista":
                                informacionFamilia.setEsposoIncluyeEsposaEntrevista(v4.toString());
                             break;
                            case "familiarDiscapacitado":
                                informacionFamilia.setFamiliarDiscapacitado(v4.toString());
                             break;
                            case "hijoInteresadoEnProyectosRehabilitacionFinca":
                                informacionFamilia.setHijoInteresadoEnProyectosRehabilitacionFinca(v4.toString());
                             break;
                            case "miembros":
                                List<Miembro> infoFamilia = new ArrayList<>();
                                List<Map> infoFamiliaBase = (List<Map>) convertObjectToList(v4);
                                for(int i = 0; i < infoFamiliaBase.size(); i++){
                                    Map<String, Object> resultado = infoFamiliaBase.get(i);
                                    miembro = new Miembro();
                                    for(Map.Entry<String, Object> entry6 : resultado.entrySet()) {
                                        String k6 = entry6.getKey();
                                        Object v6 = entry6.getValue();
                                        Map<String, Object> resultado0 = oMapper.convertValue(v6, Map.class);
                                        switch (k6){
                                            case "clasificacionMiembroFamiliar":
                                                for(Map.Entry<String, Object> entry7 : resultado0.entrySet()) {
                                                    String k7 = entry7.getKey();
                                                    Object v7 = entry7.getValue();
                                                    miembro.setClasificacionMiembroFamiliar(v7.toString());
                                                }
                                                break;
                                            case "seguridadSocial":
                                                for(Map.Entry<String, Object> entry7 : resultado0.entrySet()) {
                                                    String k7 = entry7.getKey();
                                                    Object v7 = entry7.getValue();
                                                    miembro.setSeguridadSocial(v7.toString());
                                                }
                                                break;
                                            case "tieneOtraFuenteIngreso":
                                                for(Map.Entry<String, Object> entry7 : resultado0.entrySet()) {
                                                    String k7 = entry7.getKey();
                                                    Object v7 = entry7.getValue();
                                                    miembro.setTieneOtraFuenteIngreso(v7.toString());
                                                }
                                                break;
                                            case "horasAlDiaTrabaja":
                                                for(Map.Entry<String, Object> entry7 : resultado0.entrySet()) {
                                                    String k7 = entry7.getKey();
                                                    Object v7 = entry7.getValue();
                                                    miembro.setHorasAlDiaTrabaja(v7.toString());
                                                }
                                                break;
                                            case "genero":
                                                for(Map.Entry<String, Object> entry7 : resultado0.entrySet()) {
                                                    String k7 = entry7.getKey();
                                                    Object v7 = entry7.getValue();
                                                    miembro.setGenero(v7.toString());
                                                }
                                                break;
                                            case "laboraEnFinca":
                                                for(Map.Entry<String, Object> entry7 : resultado0.entrySet()) {
                                                    String k7 = entry7.getKey();
                                                    Object v7 = entry7.getValue();
                                                    miembro.setLaboraEnFinca(v7.toString());
                                                }
                                                break;
                                            case "nivelEduacion":
                                                for(Map.Entry<String, Object> entry7 : resultado0.entrySet()) {
                                                    String k7 = entry7.getKey();
                                                    Object v7 = entry7.getValue();
                                                    miembro.setNivelEducacion(v7.toString());
                                                }
                                                break;
                                            case "laborRealizado":
                                                for(Map.Entry<String, Object> entry7 : resultado0.entrySet()) {
                                                    String k7 = entry7.getKey();
                                                    Object v7 = entry7.getValue();
                                                    miembro.setLaborRealizado(v7.toString());
                                                }
                                                break;
                                            case "sueldoIngresoMensual":
                                                for(Map.Entry<String, Object> entry7 : resultado0.entrySet()) {
                                                    String k7 = entry7.getKey();
                                                    Object v7 = entry7.getValue();
                                                    miembro.setSueldoIngresoMensual(v7.toString());
                                                }
                                                break;
                                            case "edad":
                                                for(Map.Entry<String, Object> entry7 : resultado0.entrySet()) {
                                                    String k7 = entry7.getKey();
                                                    Object v7 = entry7.getValue();
                                                    miembro.setEdad(v7.toString());
                                                }
                                                break;
                                            default:
                                                break;
                                        }
//                                        System.out.println(k6+" "+v6);
                                    }
                                    infoFamilia.add(miembro);
                                    
                                    // System.out.println(infoFamiliaBase.get(i));
                                    // System.out.println(infoFamiliaBase.get(i).getClass());
                                }
//                                System.out.println(infoFamilia);
                                informacionFamilia.setMiembros(infoFamilia);
                                
                             break;
                            }
                        }
                        
//                        System.out.println(k3+" "+v3);
                    }
                seccionesLb.setInformacionFamilia(informacionFamilia);
                }
             break;
            case "nivelAsociatividad":
                Map<String, Object> resultado7 = oMapper.convertValue(object, Map.class);
                for(Map.Entry<String, Object> entry2 : resultado7.entrySet()) {
                    String k2 = entry2.getKey();
                    Object v2 = entry2.getValue();

                    Map<String, Object> resultado2 = oMapper.convertValue(v2, Map.class);
                    for(Map.Entry<String, Object> entry3 : resultado2.entrySet()) {
                        String k3 = entry3.getKey();
                        Object v3 = entry3.getValue();

                        Map<String, Object> resultado3 = oMapper.convertValue(v3, Map.class);
                        for(Map.Entry<String, Object> entry4 : resultado3.entrySet()) {
                            String k4 = entry4.getKey();
                            Object v4 = entry4.getValue();
                            
                            switch(k3){
                            case "ayudaOtraInstitucion":
                                
                                if(!k4.equals("respuesta")){
                                    Map<String, Object> resultado = oMapper.convertValue(v4, Map.class);
                                    for(Map.Entry<String, Object> entry5 : resultado.entrySet()) {
                                        String k5 = entry5.getKey();
                                        Object v5 = entry5.getValue();
                                        
                                        Map<String, Object> resultado0 = oMapper.convertValue(v5, Map.class);
                                        for(Map.Entry<String, Object> entry6 : resultado0.entrySet()) {
                                            String k6 = entry6.getKey();
                                            Object v6 = entry6.getValue();
                                            
                                            if(k5.equals("nombreOtraInstitucion")){
                                                ayudaOtraInstitucion.setNombreOtraInstitucion(v6.toString());
                                            }
                                            if(k5.equals("tipoAyuda")){
                                                ayudaOtraInstitucion.setTipoAyuda(v6.toString());
                                            }
                                            
                                        }
                                        
                                    }
                                }else{
                                    ayudaOtraInstitucion.setRespuesta(v4.toString());
                                }
                                
                                nivelAsociatividad.setAyudaOtraInstitucion(ayudaOtraInstitucion);
                             break;
                            case "perteneceAsocProgrCertif":
                                
                                if(!k4.equals("respuesta")){
                                    Map<String, Object> resultado = oMapper.convertValue(v4, Map.class);
                                    for(Map.Entry<String, Object> entry5 : resultado.entrySet()) {
                                        String k5 = entry5.getKey();
                                        Object v5 = entry5.getValue();
                                        
                                        Map<String, Object> resultado0 = oMapper.convertValue(v5, Map.class);
                                        for(Map.Entry<String, Object> entry6 : resultado0.entrySet()) {
                                            String k6 = entry6.getKey();
                                            Object v6 = entry6.getValue();
                                            
                                            if(k5.equals("cantidadMiembros")){
                                                perteneceAsocProgrCertif.setCantidadMiembros(v6.toString());
                                            }
                                            if(k5.equals("nombreAsociacion")){
                                                perteneceAsocProgrCertif.setNombreAsociacion(v6.toString());
                                            }
                                            if(k5.equals("recibeBeneficios")){
                                                perteneceAsocProgrCertif.setRecibeBeneficios(v6.toString());
                                            }
                                            if(k5.equals("tiposBeneficios")){
                                                
                                                if(!k6.equals("respuesta")){
                                                    Map<String, Object> resultado00 = oMapper.convertValue(v6, Map.class);
                                                    for(Map.Entry<String, Object> entry7 : resultado00.entrySet()) {
                                                        String k7 = entry7.getKey();
                                                        Object v7 = entry7.getValue();
                                                        
                                                        Map<String, Object> resultado01 = oMapper.convertValue(v7, Map.class);
                                                        for(Map.Entry<String, Object> entry8 : resultado01.entrySet()) {
                                                            String k8 = entry8.getKey();
                                                            Object v8 = entry8.getValue();
                                                            
                                                            tiposBeneficios.setOtroTiposBeneficios(v8.toString());

                                                        }
                                                    }
                                                }else{
                                                    tiposBeneficios.setRespuesta(convertObjectToList(v6));
                                                }
                                                
                                                perteneceAsocProgrCertif.setTiposBeneficios(tiposBeneficios);
                                            }
                                        }
                                        
                                    }
                                }else{
                                    perteneceAsocProgrCertif.setRespuesta(v4.toString());
                                }
                                
                                nivelAsociatividad.setPerteneceAsocProgrCertif(perteneceAsocProgrCertif);
                             break;
                            }
                        }
                        
//                        System.out.println(k3+" "+v3);
                    }
                seccionesLb.setNivelAsociatividad(nivelAsociatividad);
                }
             break;
            case "practicasAgricolas":
                Map<String, Object> resultado8 = oMapper.convertValue(object, Map.class);
                for(Map.Entry<String, Object> entry2 : resultado8.entrySet()) {
                    String k2 = entry2.getKey();
                    Object v2 = entry2.getValue();

                    Map<String, Object> resultado2 = oMapper.convertValue(v2, Map.class);
                    for(Map.Entry<String, Object> entry3 : resultado2.entrySet()) {
                        String k3 = entry3.getKey();
                        Object v3 = entry3.getValue();

                        Map<String, Object> resultado3 = oMapper.convertValue(v3, Map.class);
                        for(Map.Entry<String, Object> entry4 : resultado3.entrySet()) {
                            String k4 = entry4.getKey();
                            Object v4 = entry4.getValue();
                            
                            switch(k3){
                            case "enfermedadesAfectanCultivo":
                                practicasAgricolas.setEnfermedadesAfectanCultivo(convertObjectToList(v4));
                             break;
                            case "interesElaborarFertilizanteNaturalOrganico":
                                practicasAgricolas.setInteresElaborarFertilizanteNaturalOrganico(v4.toString());
                             break;
                            case "llevaRegistroPerdidasMazorcasXMonilla":
                                if(!k4.equals("respuesta")){
                                    Map<String, Object> resultado = oMapper.convertValue(v4, Map.class);
                                    for(Map.Entry<String, Object> entry5 : resultado.entrySet()) {
                                        String k5 = entry5.getKey();
                                        Object v5 = entry5.getValue();
                                        
                                        Map<String, Object> resultado0 = oMapper.convertValue(v5, Map.class);
                                        for(Map.Entry<String, Object> entry6 : resultado0.entrySet()) {
                                            String k6 = entry6.getKey();
                                            Object v6 = entry6.getValue();
                                            
                                            if(k5.equals("cantidadPerdidaMazorcas")){
                                                llevaRegistroPerdidasMazorcasXMonilla.setCantidadPerdidaMazorcas(v6.toString());
                                            }
                                            
                                        }
                                        
                                    }
                                }else{
                                    llevaRegistroPerdidasMazorcasXMonilla.setRespuesta(v4.toString());
                                }
                                
                                practicasAgricolas.setLlevaRegistroPerdidasMazorcasXMonilla(llevaRegistroPerdidasMazorcasXMonilla);
                             break;
                            case "periodoControlMaleza":
                                practicasAgricolas.setPeriodoControlMaleza(convertObjectToList(v4));
                             break;
                            case "periodoCosecha":
                                practicasAgricolas.setPeriodoCosecha(convertObjectToList(v4));
                             break;
                            case "periodoFertilizacion":
                                practicasAgricolas.setPeriodoFertilizacion(convertObjectToList(v4));
                             break;
                            case "periodoMIPE":
                                practicasAgricolas.setPeriodoMIPE(convertObjectToList(v4));
                             break;
                            case "periodoPoda":
                                practicasAgricolas.setPeriodoPoda(convertObjectToList(v4));
                             break;
                            case "plagasAfectanCultivo":
                                practicasAgricolas.setPlagasAfectanCultivo(convertObjectToList(v4));
                             break;
                            case "productoParaEnfermedades":
                                practicasAgricolas.setProductoParaEnfermedades(v4.toString());
                             break;
                            case "productoParaPlagas":
                                practicasAgricolas.setProductoParaPlagas(v4.toString());
                             break;
                            }
                        }
                        
//                        System.out.println(k3+" "+v3);
                    }
                seccionesLb.setPracticasAgricolas(practicasAgricolas);
                }
             break;
            case "saludSeguridadOcupacional":
                Map<String, Object> resultado9 = oMapper.convertValue(object, Map.class);
                for(Map.Entry<String, Object> entry2 : resultado9.entrySet()) {
                    String k2 = entry2.getKey();
                    Object v2 = entry2.getValue();

                    Map<String, Object> resultado2 = oMapper.convertValue(v2, Map.class);
                    for(Map.Entry<String, Object> entry3 : resultado2.entrySet()) {
                        String k3 = entry3.getKey();
                        Object v3 = entry3.getValue();

                        Map<String, Object> resultado3 = oMapper.convertValue(v3, Map.class);
                        for(Map.Entry<String, Object> entry4 : resultado3.entrySet()) {
                            String k4 = entry4.getKey();
                            Object v4 = entry4.getValue();
                            
                            switch(k3){
                            case "accidentesLaboralesUltimoAnio":
                                
                                if(!k4.equals("respuesta")){
                                    Map<String, Object> resultado = oMapper.convertValue(v4, Map.class);
                                    for(Map.Entry<String, Object> entry5 : resultado.entrySet()) {
                                        String k5 = entry5.getKey();
                                        Object v5 = entry5.getValue();
                                        
                                        Map<String, Object> resultado0 = oMapper.convertValue(v5, Map.class);
                                        for(Map.Entry<String, Object> entry6 : resultado0.entrySet()) {
                                            String k6 = entry6.getKey();
                                            Object v6 = entry6.getValue();
                                            
                                            if(k5.equals("tipoAccidente")){
                                                accidentesLaboralesUltimoAnio.setTipoAccidente(v6.toString());
                                            }
                                            
                                        }
                                        
                                    }
                                }else{
                                    accidentesLaboralesUltimoAnio.setRespuesta(v4.toString());
                                }
                                
                                saludSeguridad.setAccidentesLaboralesUltimoAnio(accidentesLaboralesUltimoAnio);
                             break;
                            case "centroSaludCercano":
                                saludSeguridad.setCentroSaludCercano(v4.toString());
                             break;
                            case "periodoIntoxicacionPresente":
                                
                                if(!k4.equals("respuesta")){
                                    Map<String, Object> resultado = oMapper.convertValue(v4, Map.class);
                                    for(Map.Entry<String, Object> entry5 : resultado.entrySet()) {
                                        String k5 = entry5.getKey();
                                        Object v5 = entry5.getValue();
                                        
                                        Map<String, Object> resultado0 = oMapper.convertValue(v5, Map.class);
                                        for(Map.Entry<String, Object> entry6 : resultado0.entrySet()) {
                                            String k6 = entry6.getKey();
                                            Object v6 = entry6.getValue();
                                            
                                            if(k5.equals("producto")){
                                                periodoIntoxicacionPresente.setProducto(v6.toString());
                                            }
                                            
                                        }
                                        
                                    }
                                }else{
                                    periodoIntoxicacionPresente.setRespuesta(v4.toString());
                                }
                                
                                saludSeguridad.setPeriodoIntoxicacionPresente(periodoIntoxicacionPresente);
                             break;
                            }
                        }
                        
//                        System.out.println(k3+" "+v3);
                    }
                seccionesLb.setSaludSeguridad(saludSeguridad);
                }
             break;
            case "serviciosBasicos":
                Map<String, Object> resultado10 = oMapper.convertValue(object, Map.class);
                for(Map.Entry<String, Object> entry2 : resultado10.entrySet()) {
                    String k2 = entry2.getKey();
                    Object v2 = entry2.getValue();

                    Map<String, Object> resultado2 = oMapper.convertValue(v2, Map.class);
                    for(Map.Entry<String, Object> entry3 : resultado2.entrySet()) {
                        String k3 = entry3.getKey();
                        Object v3 = entry3.getValue();

                        Map<String, Object> resultado3 = oMapper.convertValue(v3, Map.class);
                        for(Map.Entry<String, Object> entry4 : resultado3.entrySet()) {
                            String k4 = entry4.getKey();
                            Object v4 = entry4.getValue();
                            
                            switch(k3){
                            case "energiaElectrica":
                                serviciosBasicos.setEnergiaElectrica(v4.toString());
                             break;
                            case "tipoAguaConsumoFamiliar":
                                serviciosBasicos.setTipoAguaConsumoFamiliar(v4.toString());
                             break;
                            }
                        }
                        
//                        System.out.println(k3+" "+v3);
                    }
                seccionesLb.setServiciosBasicos(serviciosBasicos);
                }
             break;
            case "venta":
                Map<String, Object> resultado11 = oMapper.convertValue(object, Map.class);
                for(Map.Entry<String, Object> entry2 : resultado11.entrySet()) {
                    String k2 = entry2.getKey();
                    Object v2 = entry2.getValue();

                    Map<String, Object> resultado2 = oMapper.convertValue(v2, Map.class);
                    for(Map.Entry<String, Object> entry3 : resultado2.entrySet()) {
                        String k3 = entry3.getKey();
                        Object v3 = entry3.getValue();

                        Map<String, Object> resultado3 = oMapper.convertValue(v3, Map.class);
                        for(Map.Entry<String, Object> entry4 : resultado3.entrySet()) {
                            String k4 = entry4.getKey();
                            Object v4 = entry4.getValue();
                            
                            switch(k3){
                            case "almacenaCacaoDespSecado":
                                if(!k4.equals("respuesta")){
                                    Map<String, Object> resultado = oMapper.convertValue(v4, Map.class);
                                    for(Map.Entry<String, Object> entry5 : resultado.entrySet()) {
                                        String k5 = entry5.getKey();
                                        Object v5 = entry5.getValue();
                                        
                                        Map<String, Object> resultado0 = oMapper.convertValue(v5, Map.class);
                                        for(Map.Entry<String, Object> entry6 : resultado0.entrySet()) {
                                            String k6 = entry6.getKey();
                                            Object v6 = entry6.getValue();
                                            
                                            if(k5.equals("tiempoAlmacenadoCacao")){
                                                almacenaCacaoDespSecado.setTiempoAlmacenadoCacao(v6.toString());
                                            }
                                            
                                        }
                                        
                                    }
                                }else{
                                    almacenaCacaoDespSecado.setRespuesta(v4.toString());
                                }
                                
                                venta.setAlmacenaCacaoDespSecado(almacenaCacaoDespSecado);
                             break;
                            case "propiedadTransporte":
                                venta.setPropiedadTransporte(v4.toString());
                             break;
                            case "registroFinancieroFinca":
                                venta.setRegistroFinancieroFinca(v4.toString());
                             break;
                            case "tipoRegistrosFinancierosFinca":
                                venta.setTipoRegistrosFinancierosFinca(v4.toString());
                             break;
                            case "tipoTransporte":
                                venta.setTipoTransporte(v4.toString());
                             break;
                            }
                        }
                        
//                        System.out.println(k3+" "+v3);
                    }
                seccionesLb.setVenta(venta);
                }
             break;
        }
    }
    
    public void Verificacion(Verificacion verificacion, SeccionesVerificacion seccionesVerificacion){
        
        Venta venta = new Venta();
        
        SaludSeguridadOcupacional saludSeguridad = new SaludSeguridadOcupacional();
        
        RegistrosProductor registrosProductor = new RegistrosProductor();
        
        ProteccionAreasRiberenias proteccionAreasRiberenias = new ProteccionAreasRiberenias();
        
        ProteccionAreasAltoValorConservacion proteccionAreasAltoValor = new ProteccionAreasAltoValorConservacion();
        
        Poda poda = new Poda();
        
        ManejoSuelo manejoSuelo = new ManejoSuelo();
        
        Injertacion injertacion = new Injertacion();
        
        Fertilizacion fertilizacion = new Fertilizacion();
        
        Fermentacion fermentacion = new Fermentacion();
        
        DiversificacionIngresos diversificacionIngresos = new DiversificacionIngresos();
        
        DatosFinca datosFinca = new DatosFinca();
        
        Cosecha cosecha = new Cosecha();
        
        ControlMalezas controlMalezas = new ControlMalezas();
        
        ConservacionSuelosBiodiversidad conservacionSuelos = new ConservacionSuelosBiodiversidad();
        
        ConservacionAguaManejodesechos conservacionAgua = new ConservacionAguaManejodesechos();
        
        CondicionesLaborales condicionesLaborales = new CondicionesLaborales();
                
        Bodega bodega = new Bodega();
        
        MIPE mipe = new MIPE();
        
        Secado secado = new Secado();
        
        ObjectMapper oMapper = new ObjectMapper();
        
        Map<String, Object> map = verificacion.getDiccionario();
                
        for(Map.Entry<String, Object> entry : map.entrySet()) {
            String k = entry.getKey();
            Object v = entry.getValue();

            if(k.equals("secciones")){
                Map<String, Object> resultado = oMapper.convertValue(v, Map.class);

                for(Map.Entry<String, Object> entry1 : resultado.entrySet()) {
                    String k1 = entry1.getKey();
                    Object v1 = entry1.getValue();

                    SeccionesVerificacion(k1,v1,oMapper,secado,seccionesVerificacion,mipe,bodega,condicionesLaborales,conservacionAgua,
                            conservacionSuelos,controlMalezas,cosecha,datosFinca,diversificacionIngresos,fermentacion,
                            fertilizacion,injertacion,manejoSuelo,poda,proteccionAreasAltoValor,proteccionAreasRiberenias,
                            registrosProductor,saludSeguridad,venta);

                }

            }
        }
        
    }
    
    public void SeccionesVerificacion(String registro, Object object, ObjectMapper oMapper, Secado secado, SeccionesVerificacion seccionesVerificacion, MIPE mipe, 
                    Bodega bodega, CondicionesLaborales condicionesLaborales, ConservacionAguaManejodesechos conservacionAgua, 
                    ConservacionSuelosBiodiversidad conservacionSuelos, ControlMalezas controlMalezas, Cosecha cosecha,
                    DatosFinca datosFinca,DiversificacionIngresos diversificacionIngresos, Fermentacion fermentacion,
                    Fertilizacion fertilizacion,Injertacion injertacion,ManejoSuelo manejoSuelo,Poda poda,
                    ProteccionAreasAltoValorConservacion proteccionAreasAltoValor,ProteccionAreasRiberenias proteccionAreasRiberenias,
                    RegistrosProductor registrosProductor,SaludSeguridadOcupacional saludSeguridad,Venta venta){
        
        RealizaPracticasMPE realizaPracticasMPE = new RealizaPracticasMPE();
        ConocimientoAreaRecepcioEnvasesProductosQuimicos conocimientoAreaRecepcioEnvasesProductosQuimicos = new ConocimientoAreaRecepcioEnvasesProductosQuimicos();
        AlmacenaSeguridadEnvasesPrevioTraslado almacenaSeguridadEnvasesPrevioTraslado = new AlmacenaSeguridadEnvasesPrevioTraslado();
        TieneDisenioFijo tieneDisenoFijo = new TieneDisenioFijo();
        TieneDisenioMovible tieneDisenoMovible = new TieneDisenioMovible();
        UtilizaFiltroEcologico utilizaFiltroEcologico = new UtilizaFiltroEcologico();
        PlantadoArbolesSombrioReciente plantadoArbolesSombrioReciente = new PlantadoArbolesSombrioReciente();
        ConocimientoDisposicionMaquinariaAgricola conocimientoDisposicionMaquinariaAgricola = new ConocimientoDisposicionMaquinariaAgricola();
        ControlaMalezas controlaMalezas = new ControlaMalezas();
        ComoControlaMaleza comoControlaMaleza = new ComoControlaMaleza();
        IncrementoHectareajeFinca incrementoHectareajeFinca = new IncrementoHectareajeFinca();
        OtraActividadFueraFincaConIngreso otraActividadFueraFincaConIngreso = new OtraActividadFueraFincaConIngreso();
        FermentaCacao fermentaCacao = new FermentaCacao();
        FertilizaCacaotales fertilizaCacaotales = new FertilizaCacaotales();
        RecibidoFertilizanteKits recibidoFertilizanteKits = new RecibidoFertilizanteKits();
        UsaFertilizanteEdafico usaFertilizanteEdafico = new UsaFertilizanteEdafico();
        UsaFertilizanteFoliar usaFertilizanteFoliar = new UsaFertilizanteFoliar();
        RealizoInjertosUltimos12Meses realizoInjertosUltimos12Meses = new RealizoInjertosUltimos12Meses();
        AnalisisSuelo analisisSuelo = new AnalisisSuelo();
        ManeraCorregidoPHSuelo maneraCorregidoPHSuelo = new ManeraCorregidoPHSuelo();
        SuelosNivelesAltosAcidez suelosNivelesAltosAcidez = new SuelosNivelesAltosAcidez();
        MalaPodaAlbergaPlagasEnfermedades malaPodaAlbergaPlagasEnfermedades = new MalaPodaAlbergaPlagasEnfermedades();
        RealizaPoda realizaPoda = new RealizaPoda();
        RealizaPodaFitosanitaria realizaPodaFitosanitaria  = new RealizaPodaFitosanitaria();
        RealizaPodaFormacion realizaPodaFormacion = new RealizaPodaFormacion();
        RealizaPodaMantenimiento realizaPodaMantenimiento = new RealizaPodaMantenimiento();
        RealizaPodaRehabilitacion realizaPodaRehabilitacion = new RealizaPodaRehabilitacion();
        ConoceEspeciePeligroExtincionEnFinca conoceEspeciePeligroExtincionEnFinca = new ConoceEspeciePeligroExtincionEnFinca();
        CuentaConAreaForestales cuentaConAreaForestales = new CuentaConAreaForestales();
        FincaConsideradaAltoValor fincaConsideradaAltoValor = new FincaConsideradaAltoValor();
        NecesitaImplementarPracticasMejoraSuelo necesitaImplementarPracticasMejoraSuelo = new NecesitaImplementarPracticasMejoraSuelo();
        SueloPresentaProblemaErosion sueloPresentaProblemaErosion = new SueloPresentaProblemaErosion();
        PoseeFuenteHidrica poseeFuenteHidrica = new PoseeFuenteHidrica();
        BrindaProteccionFuenteHidrica brindaProteccionFuenteHidrica = new BrindaProteccionFuenteHidrica();
        NombreFuenteHidrica nombreFuenteHidrica = new NombreFuenteHidrica();
        PoseeNacientes poseeNacientes= new PoseeNacientes();
        DisponibilidadAhorrarEnCuenta disponibilidadAhorrarEnCuenta = new DisponibilidadAhorrarEnCuenta();
        PersonaVenderCacao personaVenderCacao = new PersonaVenderCacao();
        RecibeBonosEmpresaProgramaLINDT recibeBonosEmpresaProgramaLINDT = new RecibeBonosEmpresaProgramaLINDT();
        
        switch(registro){
            
            case "secado":
                Map<String, Object> resultado1 = oMapper.convertValue(object, Map.class);
                for(Map.Entry<String, Object> entry2 : resultado1.entrySet()) {
                    String k2 = entry2.getKey();
                    Object v2 = entry2.getValue();

                    Map<String, Object> resultado2 = oMapper.convertValue(v2, Map.class);
                    for(Map.Entry<String, Object> entry3 : resultado2.entrySet()) {
                        String k3 = entry3.getKey();
                        Object v3 = entry3.getValue();

                        Map<String, Object> resultado3 = oMapper.convertValue(v3, Map.class);
                        for(Map.Entry<String, Object> entry4 : resultado3.entrySet()) {
                            String k4 = entry4.getKey();
                            Object v4 = entry4.getValue();
                            
                            switch(k3){
                            case "nivelHumedadCacaoVendido":
                                secado.setNivelHumedadCacaoVendido(v4.toString());
                             break;
                            case "mejoraIngresoMejorTratamientoSecadoCacao":
                                secado.setMejoraIngresoMejorTratamientoSecadoCacao(v4.toString());
                             break;
                            case "maneraRealzarSecado":
                                secado.setManeraRealzarSecado(convertObjectToList(v4));
                             break;
                            }
                        }
                        
//                        System.out.println(k3+" "+v3);
                    }
                seccionesVerificacion.setSecado(secado);
                }
                break;
            case "MIPE":
                Map<String, Object> resultado = oMapper.convertValue(object, Map.class);
                for(Map.Entry<String, Object> entry2 : resultado.entrySet()) {
                    String k2 = entry2.getKey();
                    Object v2 = entry2.getValue();

                    Map<String, Object> resultado2 = oMapper.convertValue(v2, Map.class);
                    for(Map.Entry<String, Object> entry3 : resultado2.entrySet()) {
                        String k3 = entry3.getKey();
                        Object v3 = entry3.getValue();

                        Map<String, Object> resultado3 = oMapper.convertValue(v3, Map.class);
                        for(Map.Entry<String, Object> entry4 : resultado3.entrySet()) {
                            String k4 = entry4.getKey();
                            Object v4 = entry4.getValue();

                            switch(k3){
                            case "controlaEnfermedades":
                                mipe.setControlaEnfermedades(v4.toString());
                             break;
                            case "corrigioProblemasMPE":
                                mipe.setCorrigioProblemasMPE(v4.toString());
                             break;
                            case "fincaLibreAplicacionQuimica":
                                mipe.setFincaLibreAplicacionQuimica(v4.toString());
                             break;
                            case "realizaPracticasMPE":
                                if(!k4.equals("respuesta")){
                                    Map<String, Object> resultado4 = oMapper.convertValue(v4, Map.class);
                                    for(Map.Entry<String, Object> entry5 : resultado4.entrySet()) {
                                        String k5 = entry5.getKey();
                                        Object v5 = entry5.getValue();
                                        
                                        Map<String, Object> resultado0 = oMapper.convertValue(v5, Map.class);
                                        for(Map.Entry<String, Object> entry6 : resultado0.entrySet()) {
                                            String k6 = entry6.getKey();
                                            Object v6 = entry6.getValue();
                                            
//                                            System.out.println(k6+" "+v6);
                                            realizaPracticasMPE.setTipoControlMPE(convertObjectToList(v6));
                                        }
                                        
                                    }
                                }else{
                                    realizaPracticasMPE.setRespuesta(v4.toString());
                                }
                                
                                mipe.setRealizaPracticasMPE(realizaPracticasMPE);
                             break;
                            }
                        }

    //                        System.out.println(k3+" "+v3);
                    }
                seccionesVerificacion.setMipe(mipe);
                }
             break;
            case "bodega":
                Map<String, Object> resultado4 = oMapper.convertValue(object, Map.class);
                for(Map.Entry<String, Object> entry2 : resultado4.entrySet()) {
                    String k2 = entry2.getKey();
                    Object v2 = entry2.getValue();

                    Map<String, Object> resultado2 = oMapper.convertValue(v2, Map.class);
                    for(Map.Entry<String, Object> entry3 : resultado2.entrySet()) {
                        String k3 = entry3.getKey();
                        Object v3 = entry3.getValue();

                        Map<String, Object> resultado3 = oMapper.convertValue(v3, Map.class);
                        for(Map.Entry<String, Object> entry4 : resultado3.entrySet()) {
                            String k4 = entry4.getKey();
                            Object v4 = entry4.getValue();

                            switch(k3){
                            case "bodegaOrdenada":
                                bodega.setBodegaOrdenada(v4.toString());
                             break;
                            case "bodegaSegura":
                                bodega.setBodegaSegura(v4.toString());
                             break;
                            case "clasificadaXProducto":
                                bodega.setClasificadaXProducto(v4.toString());
                             break;
                            case "conocimientoProdcutosPermitidosLINDT":
                                bodega.setConocimientoProductosPermitidosLINDT(v4.toString());
                             break;
                            case "cuentaDuchaEmergencia":
                                bodega.setCuentaDuchaEmergencia(v4.toString());
                             break;
                            case "poseeBodega":
                                bodega.setPoseeBodega(v4.toString());
                             break;
                            case "tieneRegistroAlmacena":
                                bodega.setTieneRegistroAlmacena(v4.toString());
                             break;
                            }
                        }

    //                        System.out.println(k3+" "+v3);
                    }
                seccionesVerificacion.setBodega(bodega);
                }
             break;
            case "condicionesLaborales":
                Map<String, Object> resultado5 = oMapper.convertValue(object, Map.class);
                for(Map.Entry<String, Object> entry2 : resultado5.entrySet()) {
                    String k2 = entry2.getKey();
                    Object v2 = entry2.getValue();

                    Map<String, Object> resultado2 = oMapper.convertValue(v2, Map.class);
                    for(Map.Entry<String, Object> entry3 : resultado2.entrySet()) {
                        String k3 = entry3.getKey();
                        Object v3 = entry3.getValue();

                        Map<String, Object> resultado3 = oMapper.convertValue(v3, Map.class);
                        for(Map.Entry<String, Object> entry4 : resultado3.entrySet()) {
                            String k4 = entry4.getKey();
                            Object v4 = entry4.getValue();

                            switch(k3){
                            case "discriminacion":
                                condicionesLaborales.setDiscriminacion(v4.toString());
                             break;
                            case "documentosSoporte":
                                condicionesLaborales.setDocumentosSoporte(v4.toString());
                             break;
                            case "explotacion":
                                condicionesLaborales.setExplotacion(v4.toString());
                             break;
                            case "montoAcuerdoContratoAgricola":
                                condicionesLaborales.setMontoAcuerdoContratoAgricola(v4.toString());
                             break;
                            case "trabajoInfantil":
                                condicionesLaborales.setTrabajoInfantil(v4.toString());
                             break;
                            }
                        }

    //                        System.out.println(k3+" "+v3);
                    }
                seccionesVerificacion.setCondicionesLaborales(condicionesLaborales);
                }
             break;
            case "conservacionAguaManejoDesechos":
                Map<String, Object> resultado6 = oMapper.convertValue(object, Map.class);
                for(Map.Entry<String, Object> entry2 : resultado6.entrySet()) {
                    String k2 = entry2.getKey();
                    Object v2 = entry2.getValue();

                    Map<String, Object> resultado2 = oMapper.convertValue(v2, Map.class);
                    for(Map.Entry<String, Object> entry3 : resultado2.entrySet()) {
                        String k3 = entry3.getKey();
                        Object v3 = entry3.getValue();

                        Map<String, Object> resultado3 = oMapper.convertValue(v3, Map.class);
                        for(Map.Entry<String, Object> entry4 : resultado3.entrySet()) {
                            String k4 = entry4.getKey();
                            Object v4 = entry4.getValue();

                            switch(k3){
                            case "analisisAguaRiego":
                                conservacionAgua.setAnalisisAguaRiego(v4.toString());
                             break;
                            case "areaDeschPlasticos":
                                conservacionAgua.setAreaDeschPlasticos(v4.toString());
                             break;
                            case "clasificaBasuraDomestica":
                                conservacionAgua.setClasificaBasuraDomestica(v4.toString());
                             break;
                            case "conocimientoAreaRecepcioEnvasesProductosQuimicos":
                                
                                if(!k4.equals("respuesta")){
                                    Map<String, Object> resultado00 = oMapper.convertValue(v4, Map.class);
                                    for(Map.Entry<String, Object> entry5 : resultado00.entrySet()) {
                                        String k5 = entry5.getKey();
                                        Object v5 = entry5.getValue();
                                        
                                        Map<String, Object> resultado0 = oMapper.convertValue(v5, Map.class);
                                        for(Map.Entry<String, Object> entry6 : resultado0.entrySet()) {
                                            String k6 = entry6.getKey();
                                            Object v6 = entry6.getValue();
                                            
                                            if(k5.equals("frecuenciaUsoServicioAreaRecepcioEnvasesProductosQuimicos")){
                                                conocimientoAreaRecepcioEnvasesProductosQuimicos.setFrecuenciaUsoServicioAreaRecepcionEnvasesProductosQuimicos(v6.toString());
                                            }
                                            if(k5.equals("usoServicioAreaRecepcioEnvasesProductosQuimicos")){
                                                conocimientoAreaRecepcioEnvasesProductosQuimicos.setUsoServicioAreaRecepcionEnvasesProductosQuimicos(v6.toString());
                                            }
                                            if(k5.equals("almacenaSeguridadEnvasesPrevioTraslado")){
                                                
                                                if(!k6.equals("respuesta")){
                                                    Map<String, Object> resultado01 = oMapper.convertValue(v6, Map.class);
                                                    for(Map.Entry<String, Object> entry7 : resultado01.entrySet()) {
                                                        String k7 = entry7.getKey();
                                                        Object v7 = entry7.getValue();
                                                        
                                                        Map<String, Object> resultado02 = oMapper.convertValue(v7, Map.class);
                                                        for(Map.Entry<String, Object> entry8 : resultado02.entrySet()) {
                                                            String k8 = entry8.getKey();
                                                            Object v8 = entry8.getValue();
                                                            
                                                            almacenaSeguridadEnvasesPrevioTraslado.setLugarAlmacena(v8.toString());

                                                        }
                                                    }
                                                }else{
                                                    almacenaSeguridadEnvasesPrevioTraslado.setRespuesta(v6.toString());
                                                }
                                                
                                                conocimientoAreaRecepcioEnvasesProductosQuimicos.setAlmacenaSeguridadEnvasesPrevioTraslado(almacenaSeguridadEnvasesPrevioTraslado);
                                            }
                                        }
                                        
                                    }
                                }else{
                                    conocimientoAreaRecepcioEnvasesProductosQuimicos.setRespuesta(v4.toString());
                                }
                                
                                conservacionAgua.setConocimientoAreaRecepcioEnvasesProductosQuimicos(conocimientoAreaRecepcioEnvasesProductosQuimicos);
                             break;
                            case "criterioClasificaBasuraDomestica":
                                conservacionAgua.setCriterioClasificaBasuraDomestica(convertObjectToList(v4));
                             break;
                            case "disenioRiego":
                                conservacionAgua.setDisenioRiego(convertObjectToList(v4));
                             break;
                            case "impactoRiego":
                                conservacionAgua.setImpactoRiego(v4.toString());
                             break;
                            case "infraestructuraRiego":
                                conservacionAgua.setInfraestructuraRiego(v4.toString());
                             break;
                            case "permisoExtraerAguaRiego":
                                conservacionAgua.setPermisoExtraerAguaRiego(v4.toString());
                             break;
                            case "practicaReciclajeCompostaje":
                                conservacionAgua.setPracticaReciclajeCompostaje(v4.toString());
                             break;
                            case "presentaAnexos":
                                conservacionAgua.setPresentaAnexos(v4.toString());
                             break;
                            case "tieneDisenoFijo":
                                
                                if(!k4.equals("respuesta")){
                                    Map<String, Object> resultado03 = oMapper.convertValue(v4, Map.class);
                                    for(Map.Entry<String, Object> entry5 : resultado03.entrySet()) {
                                        String k5 = entry5.getKey();
                                        Object v5 = entry5.getValue();
                                        
                                        Map<String, Object> resultado0 = oMapper.convertValue(v5, Map.class);
                                        for(Map.Entry<String, Object> entry6 : resultado0.entrySet()) {
                                            String k6 = entry6.getKey();
                                            Object v6 = entry6.getValue();
                                            
//                                            System.out.println(k6+" "+v6);
                                            tieneDisenoFijo.setHectareasDisenioRiegoFijo(v6.toString());
                                        }
                                        
                                    }
                                }else{
                                    tieneDisenoFijo.setRespuesta(v4.toString());
                                }
                                
                                conservacionAgua.setTieneDisenoFijo(tieneDisenoFijo);
                             break;
                            case "tieneDisenoMovible":
                                
                                if(!k4.equals("respuesta")){
                                    Map<String, Object> resultado04 = oMapper.convertValue(v4, Map.class);
                                    for(Map.Entry<String, Object> entry5 : resultado04.entrySet()) {
                                        String k5 = entry5.getKey();
                                        Object v5 = entry5.getValue();
                                        
                                        Map<String, Object> resultado0 = oMapper.convertValue(v5, Map.class);
                                        for(Map.Entry<String, Object> entry6 : resultado0.entrySet()) {
                                            String k6 = entry6.getKey();
                                            Object v6 = entry6.getValue();
                                            
//                                            System.out.println(k6+" "+v6);
                                            tieneDisenoMovible.setHectareasDisenioRiegoMovible(v6.toString());
                                        }
                                        
                                    }
                                }else{
                                    tieneDisenoMovible.setRespuesta(v4.toString());
                                }
                                
                                conservacionAgua.setTieneDisenoMovible(tieneDisenoMovible);
                             break;
                            case "tipoExtraccion":
                                conservacionAgua.setTipoExtraccion(v4.toString());
                             break;
                            case "tratamientoAguasNegras":
                                conservacionAgua.setTratamientoAguasNegras(v4.toString());
                             break;
                            case "tratamientoBasura":
                                conservacionAgua.setTratamientoBasura(v4.toString());
                             break;
                            case "utilizaFiltroEcologico":
                                
                                if(!k4.equals("respuesta")){
                                    Map<String, Object> resultado04 = oMapper.convertValue(v4, Map.class);
                                    for(Map.Entry<String, Object> entry5 : resultado04.entrySet()) {
                                        String k5 = entry5.getKey();
                                        Object v5 = entry5.getValue();
                                        
                                        Map<String, Object> resultado0 = oMapper.convertValue(v5, Map.class);
                                        for(Map.Entry<String, Object> entry6 : resultado0.entrySet()) {
                                            String k6 = entry6.getKey();
                                            Object v6 = entry6.getValue();
                                            
                                            utilizaFiltroEcologico.setRazonUsoFiltroEcologico(v6.toString());
                                        }
                                        
                                    }
                                }else{
                                    utilizaFiltroEcologico.setRespuesta(v4.toString());
                                }
                                
                                conservacionAgua.setUtilizaFiltroEcologico(utilizaFiltroEcologico);
                             break;
                            }
                        }
                    }
                seccionesVerificacion.setConservacionAgua(conservacionAgua);
                }
             break;
            case "conservacionSuelosBiodiversidad":
                Map<String, Object> resultado7 = oMapper.convertValue(object, Map.class);
                for(Map.Entry<String, Object> entry2 : resultado7.entrySet()) {
                    String k2 = entry2.getKey();
                    Object v2 = entry2.getValue();

                    Map<String, Object> resultado2 = oMapper.convertValue(v2, Map.class);
                    for(Map.Entry<String, Object> entry3 : resultado2.entrySet()) {
                        String k3 = entry3.getKey();
                        Object v3 = entry3.getValue();

                        Map<String, Object> resultado3 = oMapper.convertValue(v3, Map.class);
                        for(Map.Entry<String, Object> entry4 : resultado3.entrySet()) {
                            String k4 = entry4.getKey();
                            Object v4 = entry4.getValue();

                            switch(k3){
                            case "especiesArbolesEnCultivo":
                                conservacionSuelos.setEspeciesArbolesEnCultivo(convertObjectToList(v4));
                             break;
                            case "especiesDiferentesArbolesXHectarea":
                                conservacionSuelos.setEspeciesDiferentesArbolesXHectarea(v4.toString());
                             break;
                            case "plantadoArbolesSombrioRecient":
                                
                                if(!k4.equals("respuesta")){
                                    Map<String, Object> resultado04 = oMapper.convertValue(v4, Map.class);
                                    for(Map.Entry<String, Object> entry5 : resultado04.entrySet()) {
                                        String k5 = entry5.getKey();
                                        Object v5 = entry5.getValue();
                                        
                                        Map<String, Object> resultado0 = oMapper.convertValue(v5, Map.class);
                                        for(Map.Entry<String, Object> entry6 : resultado0.entrySet()) {
                                            String k6 = entry6.getKey();
                                            Object v6 = entry6.getValue();
                                            
                                            if(k5.equals("cuantosArbolesSombrio")){
                                                plantadoArbolesSombrioReciente.setCuantosArbolesSombrio(v6.toString());
                                            }
                                            if(k5.equals("promedioArbolesXHectarea")){
                                                plantadoArbolesSombrioReciente.setPromedioArbolesXHectarea(v6.toString());
                                            }
                                            if(k5.equals("reforestadoOrillas")){
                                                plantadoArbolesSombrioReciente.setReforestadoOrillas(v6.toString());
                                            }
                                            
                                        }
                                        
                                    }
                                }else{
                                    plantadoArbolesSombrioReciente.setRespuesta(v4.toString());
                                }
                                
                                conservacionSuelos.setPlantadoArbolesSombrioReciente(plantadoArbolesSombrioReciente);
                             break;
                            case "practicaDeforestacion":
                                conservacionSuelos.setPracticaDeforestacion(v4.toString());
                             break;
                            case "practicasConservacionSuelos":
                                conservacionSuelos.setPracticasConservacionSuelos(v4.toString());
                             break;
                            case "promedioArbolXHectarea12MAltura":
                                conservacionSuelos.setPromedioArbolXHectarea12MAltura(v4.toString());
                             break;
                            }
                        }

    //                        System.out.println(k3+" "+v3);
                    }
                seccionesVerificacion.setConservacionSuelos(conservacionSuelos);
                }
             break;
            case "controlMalezas":
                Map<String, Object> resultado8 = oMapper.convertValue(object, Map.class);
                for(Map.Entry<String, Object> entry2 : resultado8.entrySet()) {
                    String k2 = entry2.getKey();
                    Object v2 = entry2.getValue();

                    Map<String, Object> resultado2 = oMapper.convertValue(v2, Map.class);
                    for(Map.Entry<String, Object> entry3 : resultado2.entrySet()) {
                        String k3 = entry3.getKey();
                        Object v3 = entry3.getValue();

                        Map<String, Object> resultado3 = oMapper.convertValue(v3, Map.class);
                        for(Map.Entry<String, Object> entry4 : resultado3.entrySet()) {
                            String k4 = entry4.getKey();
                            Object v4 = entry4.getValue();

                            switch(k3){
                            case "conocimientoDisposicionMaquinariaAgricola":
                                
                                if(!k4.equals("respuesta")){
                                    Map<String, Object> resultado05 = oMapper.convertValue(v4, Map.class);
                                    for(Map.Entry<String, Object> entry5 : resultado05.entrySet()) {
                                        String k5 = entry5.getKey();
                                        Object v5 = entry5.getValue();
                                        
                                        Map<String, Object> resultado0 = oMapper.convertValue(v5, Map.class);
                                        for(Map.Entry<String, Object> entry6 : resultado0.entrySet()) {
                                            String k6 = entry6.getKey();
                                            Object v6 = entry6.getValue();
                                            
                                            if(k5.equals("haceUsoMisma")){
                                                conocimientoDisposicionMaquinariaAgricola.setHaceUsoMisma(v6.toString());
                                            }
                                            if(k5.equals("tiempoPromedioUso")){
                                                conocimientoDisposicionMaquinariaAgricola.setTiempoPromedioUso(v6.toString());
                                            }
                                            
                                        }
                                        
                                    }
                                }else{
                                    conocimientoDisposicionMaquinariaAgricola.setRespuesta(v4.toString());
                                }
                                
                                controlMalezas.setConocimientoDisposicionMaquinariaAgricola(conocimientoDisposicionMaquinariaAgricola);
                             break;
                            case "controlaMalezas":
                                
                                if(!k4.equals("respuesta")){
                                    Map<String, Object> resultado06 = oMapper.convertValue(v4, Map.class);
                                    for(Map.Entry<String, Object> entry5 : resultado06.entrySet()) {
                                        String k5 = entry5.getKey();
                                        Object v5 = entry5.getValue();
                                        
                                        Map<String, Object> resultado0 = oMapper.convertValue(v5, Map.class);
                                        for(Map.Entry<String, Object> entry6 : resultado0.entrySet()) {
                                            String k6 = entry6.getKey();
                                            Object v6 = entry6.getValue();
                                            
                                            if(k5.equals("tiposMalezaEncontrada")){
                                                controlaMalezas.setTiposMalezaEncontrada(v6.toString());
                                            }
                                            if(k5.equals("comoControlaMaleza")){
                                                
                                                if(!k6.equals("respuesta")){
                                                    Map<String, Object> resultado01 = oMapper.convertValue(v6, Map.class);
                                                    for(Map.Entry<String, Object> entry7 : resultado01.entrySet()) {
                                                        String k7 = entry7.getKey();
                                                        Object v7 = entry7.getValue();
                                                        
                                                        Map<String, Object> resultado02 = oMapper.convertValue(v7, Map.class);
                                                        for(Map.Entry<String, Object> entry8 : resultado02.entrySet()) {
                                                            String k8 = entry8.getKey();
                                                            Object v8 = entry8.getValue();
                                                            
                                                            if(k7.equals("productoQuimicoUsado")){
                                                                comoControlaMaleza.setProductoQuimicoUsado(v8.toString());
                                                            }
                                                            if(k7.equals("recomendacionSeguidaAplicandoProductoQuimico")){
                                                                comoControlaMaleza.setRecomendacionSeguidaAplicandoProductoQuimico(v8.toString());
                                                            }
                                                            if(k7.equals("regularidadProductoQuimicoUsado")){
                                                                comoControlaMaleza.setRegularidadProductoQuimicoUsado(v8.toString());
                                                            }

                                                        }
                                                    }
                                                }else{
                                                    comoControlaMaleza.setRespuesta(convertObjectToList(v6));
                                                }
                                                
                                                controlaMalezas.setComoControlaMaleza(comoControlaMaleza);
                                            }
                                            
                                        }
                                        
                                    }
                                }else{
                                    controlaMalezas.setRespuesta(v4.toString());
                                }
                                
                                controlMalezas.setControlaMalezas(controlaMalezas);
                             break;
                            }
                        }

    //                        System.out.println(k3+" "+v3);
                    }
                seccionesVerificacion.setControlMalezas(controlMalezas);
                }
             break;
            case "cosecha":
                Map<String, Object> resultado9 = oMapper.convertValue(object, Map.class);
                for(Map.Entry<String, Object> entry2 : resultado9.entrySet()) {
                    String k2 = entry2.getKey();
                    Object v2 = entry2.getValue();

                    Map<String, Object> resultado2 = oMapper.convertValue(v2, Map.class);
                    for(Map.Entry<String, Object> entry3 : resultado2.entrySet()) {
                        String k3 = entry3.getKey();
                        Object v3 = entry3.getValue();

                        Map<String, Object> resultado3 = oMapper.convertValue(v3, Map.class);
                        for(Map.Entry<String, Object> entry4 : resultado3.entrySet()) {
                            String k4 = entry4.getKey();
                            Object v4 = entry4.getValue();

                            switch(k3){
                            case "cosechaSeparadoCacaoNacionalCCN51":
                                cosecha.setCosechaSeparadoCacaoNacionalCCN51(v4.toString());
                             break;
                            case "plantasLaceracionesCicatricesMalaPractica":
                                cosecha.setPlantasLaceracionesCicatricesMalaPractica(v4.toString());
                             break;
                            }
                        }

    //                        System.out.println(k3+" "+v3);
                    }
                seccionesVerificacion.setCosecha(cosecha);
                }
             break;
            case "datosFinca":
                Map<String, Object> resultado10 = oMapper.convertValue(object, Map.class);
                for(Map.Entry<String, Object> entry2 : resultado10.entrySet()) {
                    String k2 = entry2.getKey();
                    Object v2 = entry2.getValue();

                    Map<String, Object> resultado2 = oMapper.convertValue(v2, Map.class);
                    for(Map.Entry<String, Object> entry3 : resultado2.entrySet()) {
                        String k3 = entry3.getKey();
                        Object v3 = entry3.getValue();

                        Map<String, Object> resultado3 = oMapper.convertValue(v3, Map.class);
                        for(Map.Entry<String, Object> entry4 : resultado3.entrySet()) {
                            String k4 = entry4.getKey();
                            Object v4 = entry4.getValue();

                            switch(k3){
                            case "incrementoHectareajeFinca":
                                
                                if(!k4.equals("respuesta")){
                                    Map<String, Object> resultado05 = oMapper.convertValue(v4, Map.class);
                                    for(Map.Entry<String, Object> entry5 : resultado05.entrySet()) {
                                        String k5 = entry5.getKey();
                                        Object v5 = entry5.getValue();
                                        
                                        Map<String, Object> resultado0 = oMapper.convertValue(v5, Map.class);
                                        for(Map.Entry<String, Object> entry6 : resultado0.entrySet()) {
                                            String k6 = entry6.getKey();
                                            Object v6 = entry6.getValue();
                                            
//                                            System.out.println(k6+" "+v6);
                                            if(k5.equals("cantidadAumento")){
                                                incrementoHectareajeFinca.setCantidadAumento(v6.toString());
                                            }
                                            if(k5.equals("incrementoFueraTamanioFinca")){
                                                incrementoHectareajeFinca.setIncrementoFueraTamanioFinca(v6.toString());
                                            }
                                            if(k5.equals("mesIncrementoHectareaje")){
                                                incrementoHectareajeFinca.setMesIncrementoHectareaje(v6.toString());
                                            }
                                            if(k5.equals("motivoAreaNueva")){
                                                incrementoHectareajeFinca.setMotivoAreaNueva(v6.toString());
                                            }
                                            if(k5.equals("usoAreaNueva")){
                                                incrementoHectareajeFinca.setUsoAreaNueva(v6.toString());
                                            }
                                            
                                        }
                                        
                                    }
                                }else{
                                    incrementoHectareajeFinca.setRespuesta(v4.toString());
                                }
                                
                                datosFinca.setIncrementoHectareajeFinca(incrementoHectareajeFinca);
                             break;
                            }
                        }

    //                        System.out.println(k3+" "+v3);
                    }
                seccionesVerificacion.setDatosFinca(datosFinca);
                }
             break;
            case "diversificacionIngresos":
                Map<String, Object> resultado11 = oMapper.convertValue(object, Map.class);
                for(Map.Entry<String, Object> entry2 : resultado11.entrySet()) {
                    String k2 = entry2.getKey();
                    Object v2 = entry2.getValue();

                    Map<String, Object> resultado2 = oMapper.convertValue(v2, Map.class);
                    for(Map.Entry<String, Object> entry3 : resultado2.entrySet()) {
                        String k3 = entry3.getKey();
                        Object v3 = entry3.getValue();

                        Map<String, Object> resultado3 = oMapper.convertValue(v3, Map.class);
                        for(Map.Entry<String, Object> entry4 : resultado3.entrySet()) {
                            String k4 = entry4.getKey();
                            Object v4 = entry4.getValue();

                            switch(k3){
                            case "huertosOrganicosEnFinca":
                                diversificacionIngresos.setHuertosOrganicosEnFinca(v4.toString());
                             break;
                            case "otraActividadDentroFincaConIngreso":
                                diversificacionIngresos.setOtraActividadDentroFincaConIngreso(v4.toString());
                             break;
                            case "otraActividadFueraFincaConIngreso":
                                
                                if(!k4.equals("respuesta")){
                                    Map<String, Object> resultado05 = oMapper.convertValue(v4, Map.class);
                                    for(Map.Entry<String, Object> entry5 : resultado05.entrySet()) {
                                        String k5 = entry5.getKey();
                                        Object v5 = entry5.getValue();
                                        
                                        Map<String, Object> resultado0 = oMapper.convertValue(v5, Map.class);
                                        for(Map.Entry<String, Object> entry6 : resultado0.entrySet()) {
                                            String k6 = entry6.getKey();
                                            Object v6 = entry6.getValue();
                                            
//                                            System.out.println(k6+" "+v6);
                                            if(k5.equals("actividadFueraFincaConIngreso")){
                                                otraActividadFueraFincaConIngreso.setActividadFueraFincaConIngreso(v6.toString());
                                            }
                                            if(k5.equals("realizaActividadFueraFincaConIngreso")){
                                                otraActividadFueraFincaConIngreso.setRealizaActividadFueraFincaConIngreso(v6.toString());
                                            }
                                            
                                        }
                                        
                                    }
                                }else{
                                    otraActividadFueraFincaConIngreso.setRespuesta(v4.toString());
                                }
                                
                                diversificacionIngresos.setOtraActividadFueraFincaConIngreso(otraActividadFueraFincaConIngreso);
                             break;
                            case "usoCultivoDiferenteCacao":
                                diversificacionIngresos.setUsoCultivoDiferenteCacao(v4.toString());
                             break;
                            }
                        }

    //                        System.out.println(k3+" "+v3);
                    }
                seccionesVerificacion.setDiversificacionIngresos(diversificacionIngresos);
                }
             break;
            case "fermentacion":
                Map<String, Object> resultado12 = oMapper.convertValue(object, Map.class);
                for(Map.Entry<String, Object> entry2 : resultado12.entrySet()) {
                    String k2 = entry2.getKey();
                    Object v2 = entry2.getValue();

                    Map<String, Object> resultado2 = oMapper.convertValue(v2, Map.class);
                    for(Map.Entry<String, Object> entry3 : resultado2.entrySet()) {
                        String k3 = entry3.getKey();
                        Object v3 = entry3.getValue();

                        Map<String, Object> resultado3 = oMapper.convertValue(v3, Map.class);
                        for(Map.Entry<String, Object> entry4 : resultado3.entrySet()) {
                            String k4 = entry4.getKey();
                            Object v4 = entry4.getValue();

                            switch(k3){
                            case "fermentaCacao":
                                
                                if(!k4.equals("respuesta")){
                                    Map<String, Object> resultado05 = oMapper.convertValue(v4, Map.class);
                                    for(Map.Entry<String, Object> entry5 : resultado05.entrySet()) {
                                        String k5 = entry5.getKey();
                                        Object v5 = entry5.getValue();
                                        
                                        Map<String, Object> resultado0 = oMapper.convertValue(v5, Map.class);
                                        for(Map.Entry<String, Object> entry6 : resultado0.entrySet()) {
                                            String k6 = entry6.getKey();
                                            Object v6 = entry6.getValue();
                                            
//                                            System.out.println(k6+" "+v6);
                                            if(k5.equals("aumentoIngresoPorFermentacion")){
                                                fermentaCacao.setAumentoIngresoPorFermentacion(v6.toString());
                                            }
                                            if(k5.equals("medidasHigieneFermentacion")){
                                                fermentaCacao.setMedidasHigieneFermentacion(v6.toString());
                                            }
                                            if(k5.equals("modoFermentacion")){
                                                fermentaCacao.setModoFermentacion(v6.toString());
                                            }
                                            if(k5.equals("razonNoFermenta")){
                                                fermentaCacao.setRazonNoFermenta(v6.toString());
                                            }
                                            
                                        }
                                        
                                    }
                                }else{
                                    fermentaCacao.setRespuesta(v4.toString());
                                }
                                
                                fermentacion.setFermentaCacao(fermentaCacao);
                             break;
                            }
                        }

    //                        System.out.println(k3+" "+v3);
                    }
                seccionesVerificacion.setFermentacion(fermentacion);
                }
             break;
            case "fertilizacion":
                Map<String, Object> resultado13 = oMapper.convertValue(object, Map.class);
                for(Map.Entry<String, Object> entry2 : resultado13.entrySet()) {
                    String k2 = entry2.getKey();
                    Object v2 = entry2.getValue();

                    Map<String, Object> resultado2 = oMapper.convertValue(v2, Map.class);
                    for(Map.Entry<String, Object> entry3 : resultado2.entrySet()) {
                        String k3 = entry3.getKey();
                        Object v3 = entry3.getValue();

                        Map<String, Object> resultado3 = oMapper.convertValue(v3, Map.class);
                        for(Map.Entry<String, Object> entry4 : resultado3.entrySet()) {
                            String k4 = entry4.getKey();
                            Object v4 = entry4.getValue();

                            switch(k3){
                            case "disminuidoProductosQuimicosPorOrganicos":
                                fertilizacion.setDisminuidoProductosQuimicosPorOrganicos(v4.toString());
                             break;
                            case "fertilizaCacaotales":
                                
                                if(!k4.equals("respuesta")){
                                    Map<String, Object> resultado05 = oMapper.convertValue(v4, Map.class);
                                    for(Map.Entry<String, Object> entry5 : resultado05.entrySet()) {
                                        String k5 = entry5.getKey();
                                        Object v5 = entry5.getValue();
                                        
                                        Map<String, Object> resultado0 = oMapper.convertValue(v5, Map.class);
                                        for(Map.Entry<String, Object> entry6 : resultado0.entrySet()) {
                                            String k6 = entry6.getKey();
                                            Object v6 = entry6.getValue();
                                            
//                                            System.out.println(k6+" "+v6);
                                            fertilizaCacaotales.setTipoProductoUsado(v6.toString());
                                            
                                        }
                                        
                                    }
                                }else{
                                    fertilizaCacaotales.setRespuesta(v4.toString());
                                }
                                
                                fertilizacion.setFertilizaCacaotales(fertilizaCacaotales);
                             break;
                            case "opinionEfectividadFertilizante":
                                fertilizacion.setOpinionEfectividadFertilizante(v4.toString());
                             break;
                            case "recibidoFertilizanteKits":
                                
                                if(!k4.equals("respuesta")){
                                    Map<String, Object> resultado05 = oMapper.convertValue(v4, Map.class);
                                    for(Map.Entry<String, Object> entry5 : resultado05.entrySet()) {
                                        String k5 = entry5.getKey();
                                        Object v5 = entry5.getValue();
                                        
                                        Map<String, Object> resultado0 = oMapper.convertValue(v5, Map.class);
                                        for(Map.Entry<String, Object> entry6 : resultado0.entrySet()) {
                                            String k6 = entry6.getKey();
                                            Object v6 = entry6.getValue();
                                            
//                                            System.out.println(k6+" "+v6);
                                            recibidoFertilizanteKits.setTipoFertilizanteRecibido(v6.toString());
                                            
                                        }
                                        
                                    }
                                }else{
                                    recibidoFertilizanteKits.setRespuesta(v4.toString());
                                }
                                
                                fertilizacion.setRecibidoFertilizanteKits(recibidoFertilizanteKits);
                             break;
                            case "repetirCompraConDescuento":
                                fertilizacion.setRepetirCompraConDescuento(v4.toString());
                             break;
                            case "usaFertilizanteEdafico":
                                
                                if(!k4.equals("respuesta")){
                                    Map<String, Object> resultado05 = oMapper.convertValue(v4, Map.class);
                                    for(Map.Entry<String, Object> entry5 : resultado05.entrySet()) {
                                        String k5 = entry5.getKey();
                                        Object v5 = entry5.getValue();
                                        
                                        Map<String, Object> resultado0 = oMapper.convertValue(v5, Map.class);
                                        for(Map.Entry<String, Object> entry6 : resultado0.entrySet()) {
                                            String k6 = entry6.getKey();
                                            Object v6 = entry6.getValue();
                                            
//                                            System.out.println(k6+" "+v6);
                                            usaFertilizanteEdafico.setVecesUsadoAlAnioFertilizanteEdafico(v6.toString());
                                            
                                        }
                                        
                                    }
                                }else{
                                    usaFertilizanteEdafico.setRespuesta(v4.toString());
                                }
                                
                                fertilizacion.setUsaFertilizanteEdafico(usaFertilizanteEdafico);
                             break;
                            case "usaFertilizanteFoliar":
                                
                                if(!k4.equals("respuesta")){
                                    Map<String, Object> resultado05 = oMapper.convertValue(v4, Map.class);
                                    for(Map.Entry<String, Object> entry5 : resultado05.entrySet()) {
                                        String k5 = entry5.getKey();
                                        Object v5 = entry5.getValue();
                                        
                                        Map<String, Object> resultado0 = oMapper.convertValue(v5, Map.class);
                                        for(Map.Entry<String, Object> entry6 : resultado0.entrySet()) {
                                            String k6 = entry6.getKey();
                                            Object v6 = entry6.getValue();
                                            
//                                            System.out.println(k6+" "+v6);
                                            usaFertilizanteFoliar.setVecesUsadoAlAnioFertilizanteFoliar(v6.toString());
                                            
                                        }
                                        
                                    }
                                }else{
                                    usaFertilizanteFoliar.setRespuesta(v4.toString());
                                }
                                
                                fertilizacion.setUsaFertilizanteFoliar(usaFertilizanteFoliar);
                             break;
                            }
                        }

    //                        System.out.println(k3+" "+v3);
                    }
                seccionesVerificacion.setFertilizacion(fertilizacion);
                }
             break;
            case "injertacion":
                Map<String, Object> resultado14 = oMapper.convertValue(object, Map.class);
                for(Map.Entry<String, Object> entry2 : resultado14.entrySet()) {
                    String k2 = entry2.getKey();
                    Object v2 = entry2.getValue();

                    Map<String, Object> resultado2 = oMapper.convertValue(v2, Map.class);
                    for(Map.Entry<String, Object> entry3 : resultado2.entrySet()) {
                        String k3 = entry3.getKey();
                        Object v3 = entry3.getValue();

                        Map<String, Object> resultado3 = oMapper.convertValue(v3, Map.class);
                        for(Map.Entry<String, Object> entry4 : resultado3.entrySet()) {
                            String k4 = entry4.getKey();
                            Object v4 = entry4.getValue();

                            switch(k3){
                            case "realizoInjertosUltimos12Meses":
                                
                                if(!k4.equals("respuesta")){
                                    Map<String, Object> resultado05 = oMapper.convertValue(v4, Map.class);
                                    for(Map.Entry<String, Object> entry5 : resultado05.entrySet()) {
                                        String k5 = entry5.getKey();
                                        Object v5 = entry5.getValue();
                                        
                                        Map<String, Object> resultado0 = oMapper.convertValue(v5, Map.class);
                                        for(Map.Entry<String, Object> entry6 : resultado0.entrySet()) {
                                            String k6 = entry6.getKey();
                                            Object v6 = entry6.getValue();
                                            
//                                            System.out.println(k6+" "+v6);
                                            realizoInjertosUltimos12Meses.setMesRealizoInjertos(v6.toString());
                                            
                                        }
                                        
                                    }
                                }else{
                                    realizoInjertosUltimos12Meses.setRespuesta(v4.toString());
                                }
                                
                                injertacion.setRealizoInjertosUltimos12Meses(realizoInjertosUltimos12Meses);
                             break;
                            }
                        }

    //                        System.out.println(k3+" "+v3);
                    }
                seccionesVerificacion.setInjertacion(injertacion);
                }
             break;
            case "manejoSuelo":
                Map<String, Object> resultado15 = oMapper.convertValue(object, Map.class);
                for(Map.Entry<String, Object> entry2 : resultado15.entrySet()) {
                    String k2 = entry2.getKey();
                    Object v2 = entry2.getValue();

                    Map<String, Object> resultado2 = oMapper.convertValue(v2, Map.class);
                    for(Map.Entry<String, Object> entry3 : resultado2.entrySet()) {
                        String k3 = entry3.getKey();
                        Object v3 = entry3.getValue();

                        Map<String, Object> resultado3 = oMapper.convertValue(v3, Map.class);
                        for(Map.Entry<String, Object> entry4 : resultado3.entrySet()) {
                            String k4 = entry4.getKey();
                            Object v4 = entry4.getValue();

                            switch(k3){
                            case "analisisSuelo":
                                
                                if(!k4.equals("respuesta")){
                                    Map<String, Object> resultado05 = oMapper.convertValue(v4, Map.class);
                                    for(Map.Entry<String, Object> entry5 : resultado05.entrySet()) {
                                        String k5 = entry5.getKey();
                                        Object v5 = entry5.getValue();
                                        
                                        Map<String, Object> resultado0 = oMapper.convertValue(v5, Map.class);
                                        for(Map.Entry<String, Object> entry6 : resultado0.entrySet()) {
                                            String k6 = entry6.getKey();
                                            Object v6 = entry6.getValue();
                                            
//                                            System.out.println(k6+" "+v6);
                                            analisisSuelo.setSueloPH(v6.toString());
                                            
                                        }
                                        
                                    }
                                }else{
                                    analisisSuelo.setRespuesta(v4.toString());
                                }
                                
                                manejoSuelo.setAnalisisSuelo(analisisSuelo);
                             break;
                            case "capacitacionTomaMuestrasSuelo":
                               manejoSuelo.setCapacitacionTomaMuestrasSuelo(v4.toString());
                             break;
                            case "maneraCorregidoPHSuelo":
                                
                                if(!k4.equals("respuesta")){
                                    Map<String, Object> resultado05 = oMapper.convertValue(v4, Map.class);
                                    for(Map.Entry<String, Object> entry5 : resultado05.entrySet()) {
                                        String k5 = entry5.getKey();
                                        Object v5 = entry5.getValue();
                                        
                                        Map<String, Object> resultado0 = oMapper.convertValue(v5, Map.class);
                                        for(Map.Entry<String, Object> entry6 : resultado0.entrySet()) {
                                            String k6 = entry6.getKey();
                                            Object v6 = entry6.getValue();
                                            
//                                            System.out.println(k6+" "+v6);
                                            if(k5.equals("tipoProductoNatural")){
                                                maneraCorregidoPHSuelo.setTipoProductoNatural(convertObjectToList(v6));
                                            }
                                            if(k5.equals("tipoProductoQuimico")){
                                                maneraCorregidoPHSuelo.setTipoProductoQuimico(convertObjectToList(v6));
                                            }
                                            
                                        }
                                        
                                    }
                                }else{
                                    maneraCorregidoPHSuelo.setRespuesta(convertObjectToList(v4));
                                }
                                
                                manejoSuelo.setManeraCorregidoPHSuelo(maneraCorregidoPHSuelo);
                             break;
                            case "suelosNivelesAltosAcidez":
                                
                                if(!k4.equals("respuesta")){
                                    Map<String, Object> resultado05 = oMapper.convertValue(v4, Map.class);
                                    for(Map.Entry<String, Object> entry5 : resultado05.entrySet()) {
                                        String k5 = entry5.getKey();
                                        Object v5 = entry5.getValue();
                                        
                                        Map<String, Object> resultado0 = oMapper.convertValue(v5, Map.class);
                                        for(Map.Entry<String, Object> entry6 : resultado0.entrySet()) {
                                            String k6 = entry6.getKey();
                                            Object v6 = entry6.getValue();
                                            
//                                            System.out.println(k6+" "+v6);
                                            suelosNivelesAltosAcidez.setCorregidoPHSueloFinca(v6.toString());
                                            
                                        }
                                        
                                    }
                                }else{
                                    suelosNivelesAltosAcidez.setRespuesta(v4.toString());
                                }
                                
                                manejoSuelo.setSuelosNivelesAltosAcidez(suelosNivelesAltosAcidez);
                             break;
                            case "tipoSuelo":
                                manejoSuelo.setTipoSuelo(convertObjectToList(v4));
                             break;
                            }
                        }

    //                        System.out.println(k3+" "+v3);
                    }
                seccionesVerificacion.setManejoSuelo(manejoSuelo);
                }
             break;
            case "poda":
                Map<String, Object> resultado16 = oMapper.convertValue(object, Map.class);
                for(Map.Entry<String, Object> entry2 : resultado16.entrySet()) {
                    String k2 = entry2.getKey();
                    Object v2 = entry2.getValue();

                    Map<String, Object> resultado2 = oMapper.convertValue(v2, Map.class);
                    for(Map.Entry<String, Object> entry3 : resultado2.entrySet()) {
                        String k3 = entry3.getKey();
                        Object v3 = entry3.getValue();

                        Map<String, Object> resultado3 = oMapper.convertValue(v3, Map.class);
                        for(Map.Entry<String, Object> entry4 : resultado3.entrySet()) {
                            String k4 = entry4.getKey();
                            Object v4 = entry4.getValue();

                            switch(k3){
                            case "cortesLaceracionesPlantaMalaPoda":
                                poda.setCortesLaceracionesPlantaMalaPoda(v4.toString());
                             break;
                            case "malaPodaAlbergaPlagasEnfermedades":
                                
                                if(!k4.equals("respuesta")){
                                    Map<String, Object> resultado05 = oMapper.convertValue(v4, Map.class);
                                    for(Map.Entry<String, Object> entry5 : resultado05.entrySet()) {
                                        String k5 = entry5.getKey();
                                        Object v5 = entry5.getValue();
                                        
                                        Map<String, Object> resultado0 = oMapper.convertValue(v5, Map.class);
                                        for(Map.Entry<String, Object> entry6 : resultado0.entrySet()) {
                                            String k6 = entry6.getKey();
                                            Object v6 = entry6.getValue();
                                            
//                                            System.out.println(k6+" "+v6);
                                            if(k5.equals("enfermedadesMalaPoda")){
                                                malaPodaAlbergaPlagasEnfermedades.setEnfermedadesMalaPoda(convertObjectToList(v6));
                                            }
                                            if(k5.equals("plagasMalaPoda")){
                                                malaPodaAlbergaPlagasEnfermedades.setPlagasMalaPoda(convertObjectToList(v6));
                                            }
                                            
                                        }
                                        
                                    }
                                }else{
                                    malaPodaAlbergaPlagasEnfermedades.setRespuesta(v4.toString());
                                }
                                
                                poda.setMalaPodaAlbergaPlagasEnfermedades(malaPodaAlbergaPlagasEnfermedades);
                             break;
                            case "mazorcasEstadoPudricion":
                                poda.setMazorcasEstadoPudricion(v4.toString());
                             break;
                            case "realizaPoda":
                                
                                if(!k4.equals("respuesta")){
                                    Map<String, Object> resultado05 = oMapper.convertValue(v4, Map.class);
                                    for(Map.Entry<String, Object> entry5 : resultado05.entrySet()) {
                                        String k5 = entry5.getKey();
                                        Object v5 = entry5.getValue();
                                        
                                        Map<String, Object> resultado0 = oMapper.convertValue(v5, Map.class);
                                        for(Map.Entry<String, Object> entry6 : resultado0.entrySet()) {
                                            String k6 = entry6.getKey();
                                            Object v6 = entry6.getValue();
                                            
//                                            System.out.println(k6+" "+v6);
                                            if(k5.equals("tipoPoda")){
                                                realizaPoda.setTipoPoda(convertObjectToList(v6));
                                            }
                                            if(k5.equals("realizaPodaFitosanitaria")){
                                                
                                                if(!k6.equals("respuesta")){
                                                    Map<String, Object> resultado01 = oMapper.convertValue(v6, Map.class);
                                                    for(Map.Entry<String, Object> entry7 : resultado01.entrySet()) {
                                                        String k7 = entry7.getKey();
                                                        Object v7 = entry7.getValue();
                                                        
                                                        Map<String, Object> resultado02 = oMapper.convertValue(v7, Map.class);
                                                        for(Map.Entry<String, Object> entry8 : resultado02.entrySet()) {
                                                            String k8 = entry8.getKey();
                                                            Object v8 = entry8.getValue();
                                                            
                                                            if(k7.equals("podaFitosanitariaEsCorrecta")){
                                                                realizaPodaFitosanitaria.setPodaFitosanitariaEsCorrecta(v8.toString());
                                                            }

                                                        }
                                                    }
                                                }else{
                                                    realizaPodaFitosanitaria.setRespuesta(v6.toString());
                                                }
                                                
                                                realizaPoda.setRealizaPodaFitosanitaria(realizaPodaFitosanitaria);
                                            }
                                            if(k5.equals("realizaPodaFormacion")){
                                                
                                                if(!k6.equals("respuesta")){
                                                    Map<String, Object> resultado01 = oMapper.convertValue(v6, Map.class);
                                                    for(Map.Entry<String, Object> entry7 : resultado01.entrySet()) {
                                                        String k7 = entry7.getKey();
                                                        Object v7 = entry7.getValue();
                                                        
                                                        Map<String, Object> resultado02 = oMapper.convertValue(v7, Map.class);
                                                        for(Map.Entry<String, Object> entry8 : resultado02.entrySet()) {
                                                            String k8 = entry8.getKey();
                                                            Object v8 = entry8.getValue();
                                                            
                                                            if(k7.equals("podaFormacionEsCorrecta")){
                                                                realizaPodaFormacion.setPodaFormacionEsCorrecta(v8.toString());
                                                            }

                                                        }
                                                    }
                                                }else{
                                                    realizaPodaFormacion.setRespuesta(v6.toString());
                                                }
                                                
                                                realizaPoda.setRealizaPodaFormacion(realizaPodaFormacion);
                                            }
                                            if(k5.equals("realizaPodaMantenimiento")){
                                                
                                                if(!k6.equals("respuesta")){
                                                    Map<String, Object> resultado01 = oMapper.convertValue(v6, Map.class);
                                                    for(Map.Entry<String, Object> entry7 : resultado01.entrySet()) {
                                                        String k7 = entry7.getKey();
                                                        Object v7 = entry7.getValue();
                                                        
                                                        Map<String, Object> resultado02 = oMapper.convertValue(v7, Map.class);
                                                        for(Map.Entry<String, Object> entry8 : resultado02.entrySet()) {
                                                            String k8 = entry8.getKey();
                                                            Object v8 = entry8.getValue();
                                                            
                                                            if(k7.equals("podaMantenimientoEsCorrecta")){
                                                                realizaPodaMantenimiento.setPodaMantenimientoEsCorrecta(v8.toString());
                                                            }

                                                        }
                                                    }
                                                }else{
                                                    realizaPodaMantenimiento.setRespuesta(v6.toString());
                                                }
                                                
                                                realizaPoda.setRealizaPodaMantenimiento(realizaPodaMantenimiento);
                                            }
                                            if(k5.equals("realizaPodaRehabilitacion")){
                                                
                                                if(!k6.equals("respuesta")){
                                                    Map<String, Object> resultado01 = oMapper.convertValue(v6, Map.class);
                                                    for(Map.Entry<String, Object> entry7 : resultado01.entrySet()) {
                                                        String k7 = entry7.getKey();
                                                        Object v7 = entry7.getValue();
                                                        
                                                        Map<String, Object> resultado02 = oMapper.convertValue(v7, Map.class);
                                                        for(Map.Entry<String, Object> entry8 : resultado02.entrySet()) {
                                                            String k8 = entry8.getKey();
                                                            Object v8 = entry8.getValue();
                                                            
                                                            if(k7.equals("podaRehabilitacionEsCorrecta")){
                                                                realizaPodaRehabilitacion.setPodaRehabilitacionEsCorrecta(v8.toString());
                                                            }

                                                        }
                                                    }
                                                }else{
                                                    realizaPodaRehabilitacion.setRespuesta(v6.toString());
                                                }
                                                
                                                realizaPoda.setRealizaPodaRehabilitacion(realizaPodaRehabilitacion);
                                            }
                                            
                                        }
                                        
                                    }
                                }else{
                                    realizaPoda.setRespuesta(v4.toString());
                                }
                                
                                poda.setRealizaPoda(realizaPoda);
                             break;
                            }
                        }

    //                        System.out.println(k3+" "+v3);
                    }
                seccionesVerificacion.setPoda(poda);
                }
             break;
            case "proteccionAreasAltoValorConservacion":
                Map<String, Object> resultado17 = oMapper.convertValue(object, Map.class);
                for(Map.Entry<String, Object> entry2 : resultado17.entrySet()) {
                    String k2 = entry2.getKey();
                    Object v2 = entry2.getValue();

                    Map<String, Object> resultado2 = oMapper.convertValue(v2, Map.class);
                    for(Map.Entry<String, Object> entry3 : resultado2.entrySet()) {
                        String k3 = entry3.getKey();
                        Object v3 = entry3.getValue();

                        Map<String, Object> resultado3 = oMapper.convertValue(v3, Map.class);
                        for(Map.Entry<String, Object> entry4 : resultado3.entrySet()) {
                            String k4 = entry4.getKey();
                            Object v4 = entry4.getValue();

                            switch(k3){
                                case "conoceEspeciePeligroExtincionEnFinca":
                                    
                                    if(!k4.equals("respuesta")){
                                    Map<String, Object> resultado05 = oMapper.convertValue(v4, Map.class);
                                    for(Map.Entry<String, Object> entry5 : resultado05.entrySet()) {
                                        String k5 = entry5.getKey();
                                        Object v5 = entry5.getValue();
                                        
                                        Map<String, Object> resultado0 = oMapper.convertValue(v5, Map.class);
                                        for(Map.Entry<String, Object> entry6 : resultado0.entrySet()) {
                                            String k6 = entry6.getKey();
                                            Object v6 = entry6.getValue();
                                            
//                                            System.out.println(k6+" "+v6);
                                            if(k5.equals("cualesEspeciesPeligroExtincion")){
                                                conoceEspeciePeligroExtincionEnFinca.setCualesEspeciesPeligroExtincion(v6.toString());
                                            }
                                            if(k5.equals("especifiqueCualesEspeciesPeligroExtincion")){
                                                conoceEspeciePeligroExtincionEnFinca.setEspecifiqueCualesEspeciesPeligroExtincion(v6.toString());
                                            }
                                            
                                        }
                                        
                                    }
                                }else{
                                    conoceEspeciePeligroExtincionEnFinca.setRespuesta(v4.toString());
                                }
                                
                                proteccionAreasAltoValor.setConoceEspeciePeligroExtincionEnFinca(conoceEspeciePeligroExtincionEnFinca);
                                 break;
                                case "cuentaConAreaForestales":
                                    
                                    if(!k4.equals("respuesta")){
                                    Map<String, Object> resultado05 = oMapper.convertValue(v4, Map.class);
                                    for(Map.Entry<String, Object> entry5 : resultado05.entrySet()) {
                                        String k5 = entry5.getKey();
                                        Object v5 = entry5.getValue();
                                        
                                        Map<String, Object> resultado0 = oMapper.convertValue(v5, Map.class);
                                        for(Map.Entry<String, Object> entry6 : resultado0.entrySet()) {
                                            String k6 = entry6.getKey();
                                            Object v6 = entry6.getValue();
                                            
//                                            System.out.println(k6+" "+v6);
                                            if(k5.equals("tipoAreaForestal")){
                                                cuentaConAreaForestales.setTipoAreaForestal(v6.toString());
                                            }
                                            
                                        }
                                        
                                    }
                                }else{
                                    cuentaConAreaForestales.setRespuesta(v4.toString());
                                }
                                
                                proteccionAreasAltoValor.setCuentaConAreaForestales(cuentaConAreaForestales);
                                 break;
                                case "fincaConsideradaAltoValor":
                                    
                                    if(!k4.equals("respuesta")){
                                    Map<String, Object> resultado05 = oMapper.convertValue(v4, Map.class);
                                    for(Map.Entry<String, Object> entry5 : resultado05.entrySet()) {
                                        String k5 = entry5.getKey();
                                        Object v5 = entry5.getValue();
                                        
                                        Map<String, Object> resultado0 = oMapper.convertValue(v5, Map.class);
                                        for(Map.Entry<String, Object> entry6 : resultado0.entrySet()) {
                                            String k6 = entry6.getKey();
                                            Object v6 = entry6.getValue();
                                            
//                                            System.out.println(k6+" "+v6);
                                            if(k5.equals("tipoAltoValor")){
                                                fincaConsideradaAltoValor.setTipoAltoValor(convertObjectToList(v6));
                                            }
                                            
                                        }
                                        
                                    }
                                }else{
                                    fincaConsideradaAltoValor.setRespuesta(v4.toString());
                                }
                                
                                proteccionAreasAltoValor.setFincaConsideradaAltoValor(fincaConsideradaAltoValor);
                                 break;
                                case "gradoPresentanPendientes":
                                    proteccionAreasAltoValor.setGradoPresentanPendientes(v4.toString());
                                 break;
                                case "necesitaImplementarPracticasMejoraSuelo":
                                    
                                    if(!k4.equals("respuesta")){
                                    Map<String, Object> resultado05 = oMapper.convertValue(v4, Map.class);
                                    for(Map.Entry<String, Object> entry5 : resultado05.entrySet()) {
                                        String k5 = entry5.getKey();
                                        Object v5 = entry5.getValue();
                                        
                                        Map<String, Object> resultado0 = oMapper.convertValue(v5, Map.class);
                                        for(Map.Entry<String, Object> entry6 : resultado0.entrySet()) {
                                            String k6 = entry6.getKey();
                                            Object v6 = entry6.getValue();
                                            
//                                            System.out.println(k6+" "+v6);
                                            if(k5.equals("comoQuePracticas")){
                                                necesitaImplementarPracticasMejoraSuelo.setComoQuePracticas(v6.toString());
                                            }
                                            
                                        }
                                        
                                    }
                                }else{
                                    necesitaImplementarPracticasMejoraSuelo.setRespuesta(v4.toString());
                                }
                                
                                proteccionAreasAltoValor.setNecesitaImplementarPracticasMejoraSuelo(necesitaImplementarPracticasMejoraSuelo);
                                 break;
                                case "presentaAnexosAreasAltoValor":
                                    proteccionAreasAltoValor.setPresentaAnexosAreasAltoValor(v4.toString());
                                 break;
                                case "realizaPlanesCorteExtraccionMadera":
                                    proteccionAreasAltoValor.setRealizaPlanesCorteExtraccionMadera(v4.toString());
                                 break;
                                case "realizaPlanesReforestacion":
                                    proteccionAreasAltoValor.setRealizaPlanesReforestacion(v4.toString());
                                 break;
                                case "sueloPresentaProblemaErosion":
                                    
                                    if(!k4.equals("respuesta")){
                                    Map<String, Object> resultado05 = oMapper.convertValue(v4, Map.class);
                                    for(Map.Entry<String, Object> entry5 : resultado05.entrySet()) {
                                        String k5 = entry5.getKey();
                                        Object v5 = entry5.getValue();
                                        
                                        Map<String, Object> resultado0 = oMapper.convertValue(v5, Map.class);
                                        for(Map.Entry<String, Object> entry6 : resultado0.entrySet()) {
                                            String k6 = entry6.getKey();
                                            Object v6 = entry6.getValue();
                                            
//                                            System.out.println(k6+" "+v6);
                                            if(k5.equals("tipoProblemaErosion")){
                                                sueloPresentaProblemaErosion.setTipoProblemaErosion(v6.toString());
                                            }
                                            
                                        }
                                        
                                    }
                                }else{
                                    sueloPresentaProblemaErosion.setRespuesta(v4.toString());
                                }
                                
                                proteccionAreasAltoValor.setSueloPresentaProblemaErosion(sueloPresentaProblemaErosion);
                                 break;
                            }
                        }

    //                        System.out.println(k3+" "+v3);
                    }
                seccionesVerificacion.setProteccionAreasAltoValor(proteccionAreasAltoValor);
                }
             break;
            case "proteccionAreasRiberenias":
                Map<String, Object> resultado18 = oMapper.convertValue(object, Map.class);
                for(Map.Entry<String, Object> entry2 : resultado18.entrySet()) {
                    String k2 = entry2.getKey();
                    Object v2 = entry2.getValue();

                    Map<String, Object> resultado2 = oMapper.convertValue(v2, Map.class);
                    for(Map.Entry<String, Object> entry3 : resultado2.entrySet()) {
                        String k3 = entry3.getKey();
                        Object v3 = entry3.getValue();

                        Map<String, Object> resultado3 = oMapper.convertValue(v3, Map.class);
                        for(Map.Entry<String, Object> entry4 : resultado3.entrySet()) {
                            String k4 = entry4.getKey();
                            Object v4 = entry4.getValue();

                            switch(k3){
                            case "poseeFuenteHidrica":
                                
                                if(!k4.equals("respuesta")){
                                    Map<String, Object> resultado05 = oMapper.convertValue(v4, Map.class);
                                    for(Map.Entry<String, Object> entry5 : resultado05.entrySet()) {
                                        String k5 = entry5.getKey();
                                        Object v5 = entry5.getValue();
                                        
                                        Map<String, Object> resultado0 = oMapper.convertValue(v5, Map.class);
                                        for(Map.Entry<String, Object> entry6 : resultado0.entrySet()) {
                                            String k6 = entry6.getKey();
                                            Object v6 = entry6.getValue();
                                            
//                                            System.out.println(k6+" "+v6);
                                            if(k5.equals("consideradaFuenteHidrica")){
                                                poseeFuenteHidrica.setConsideradaFuenteHidrica(v6.toString());
                                            }
                                            if(k5.equals("distanciaRequerida")){
                                                poseeFuenteHidrica.setDistanciaRequerida(v6.toString());
                                            }
                                            if(k5.equals("tipoFuenteHidrica")){
                                                poseeFuenteHidrica.setTipoFuenteHidrica(convertObjectToList(v6));
                                            }
                                            if(k5.equals("brindaProteccionFuenteHidrica")){
                                                
                                                if(!k6.equals("respuesta")){
                                                    Map<String, Object> resultado01 = oMapper.convertValue(v6, Map.class);
                                                    for(Map.Entry<String, Object> entry7 : resultado01.entrySet()) {
                                                        String k7 = entry7.getKey();
                                                        Object v7 = entry7.getValue();
                                                        
                                                        Map<String, Object> resultado02 = oMapper.convertValue(v7, Map.class);
                                                        for(Map.Entry<String, Object> entry8 : resultado02.entrySet()) {
                                                            String k8 = entry8.getKey();
                                                            Object v8 = entry8.getValue();
                                                            
                                                            if(k7.equals("comoBrindaProtFuentHidr")){
                                                                brindaProteccionFuenteHidrica.setComoBrindaProtFuentHidr(v8.toString());
                                                            }

                                                        }
                                                    }
                                                }else{
                                                    brindaProteccionFuenteHidrica.setRespuesta(v6.toString());
                                                }
                                                
                                                poseeFuenteHidrica.setBrindaProteccionFuenteHidrica(brindaProteccionFuenteHidrica);
                                            }
                                            if(k5.equals("nombreFuenteHidrica")){
                                                
                                                if(!k6.equals("respuesta")){
                                                    Map<String, Object> resultado01 = oMapper.convertValue(v6, Map.class);
                                                    for(Map.Entry<String, Object> entry7 : resultado01.entrySet()) {
                                                        String k7 = entry7.getKey();
                                                        Object v7 = entry7.getValue();
                                                        
                                                        Map<String, Object> resultado02 = oMapper.convertValue(v7, Map.class);
                                                        for(Map.Entry<String, Object> entry8 : resultado02.entrySet()) {
                                                            String k8 = entry8.getKey();
                                                            Object v8 = entry8.getValue();
                                                            
                                                            if(k7.equals("especifiqueOtros")){
                                                                nombreFuenteHidrica.setEspecifiqueOtros(v8.toString());
                                                            }

                                                        }
                                                    }
                                                }else{
                                                    nombreFuenteHidrica.setRespuesta(convertObjectToList(v6));
                                                }
                                                
                                                poseeFuenteHidrica.setNombreFuenteHidrica(nombreFuenteHidrica);
                                            }
                                            if(k5.equals("poseeNacientes")){
                                                
                                                if(!k6.equals("respuesta")){
                                                    Map<String, Object> resultado01 = oMapper.convertValue(v6, Map.class);
                                                    for(Map.Entry<String, Object> entry7 : resultado01.entrySet()) {
                                                        String k7 = entry7.getKey();
                                                        Object v7 = entry7.getValue();
                                                        
                                                        Map<String, Object> resultado02 = oMapper.convertValue(v7, Map.class);
                                                        for(Map.Entry<String, Object> entry8 : resultado02.entrySet()) {
                                                            String k8 = entry8.getKey();
                                                            Object v8 = entry8.getValue();
                                                            
                                                            if(k7.equals("cuantasNacientes")){
                                                                poseeNacientes.setCuantasNacientes(v8.toString());
                                                            }

                                                        }
                                                    }
                                                }else{
                                                    poseeNacientes.setRespuesta(v6.toString());
                                                }
                                                
                                                poseeFuenteHidrica.setPoseeNacientes(poseeNacientes);
                                            }
                                            
                                        }
                                        
                                    }
                                }else{
                                    poseeFuenteHidrica.setRespuesta(v4.toString());
                                }
                                
                                proteccionAreasRiberenias.setPoseeFuenteHidrica(poseeFuenteHidrica);
                             break;
                            }
                        }

    //                        System.out.println(k3+" "+v3);
                    }
                seccionesVerificacion.setProteccionAreasRiberenias(proteccionAreasRiberenias);
                }
             break;
            case "registrosProductor":
                Map<String, Object> resultado19 = oMapper.convertValue(object, Map.class);
                for(Map.Entry<String, Object> entry2 : resultado19.entrySet()) {
                    String k2 = entry2.getKey();
                    Object v2 = entry2.getValue();

                    Map<String, Object> resultado2 = oMapper.convertValue(v2, Map.class);
                    for(Map.Entry<String, Object> entry3 : resultado2.entrySet()) {
                        String k3 = entry3.getKey();
                        Object v3 = entry3.getValue();

                        Map<String, Object> resultado3 = oMapper.convertValue(v3, Map.class);
                        for(Map.Entry<String, Object> entry4 : resultado3.entrySet()) {
                            String k4 = entry4.getKey();
                            Object v4 = entry4.getValue();

                            switch(k3){
                                case "disponibilidadAhorrarEnCuenta":
                                    
                                    if(!k4.equals("respuesta")){
                                    Map<String, Object> resultado05 = oMapper.convertValue(v4, Map.class);
                                    for(Map.Entry<String, Object> entry5 : resultado05.entrySet()) {
                                        String k5 = entry5.getKey();
                                        Object v5 = entry5.getValue();
                                        
                                        Map<String, Object> resultado0 = oMapper.convertValue(v5, Map.class);
                                        for(Map.Entry<String, Object> entry6 : resultado0.entrySet()) {
                                            String k6 = entry6.getKey();
                                            Object v6 = entry6.getValue();
                                            
//                                            System.out.println(k6+" "+v6);
                                            if(k5.equals("tipoInstitucionAhorroCuenta")){
                                                disponibilidadAhorrarEnCuenta.setTipoInstitucionAhorroCuenta(v6.toString());
                                            }
                                            
                                        }
                                        
                                    }
                                }else{
                                    disponibilidadAhorrarEnCuenta.setRespuesta(v4.toString());
                                }
                                
                                registrosProductor.setDisponibilidadAhorrarEnCuenta(disponibilidadAhorrarEnCuenta);
                                 break;
                                case "egresoCompraMateriales":
                                   registrosProductor.setEgresoCompraMateriales(v4.toString());
                                 break;
                                case "egresoManoObra":
                                    registrosProductor.setEgresoManoObra(v4.toString());
                                 break;
                                case "manejoCostosPlanificacionFinanciera":
                                    registrosProductor.setManejoCostosPlanificacionFinanciera(v4.toString());
                                 break;
                                case "manejoCuadernilloRegistros":
                                    registrosProductor.setManejoCuadernilloRegistros(v4.toString());
                                 break;
                                case "ventaAnualCacaoQuintales":
                                    registrosProductor.setVentaAnualCacaoQuintales(v4.toString());
                                 break;
                                case "ventaAnualCacaoUSD":
                                    registrosProductor.setVentaAnualCacaoUSD(v4.toString());
                                 break;
                                
                            }
                        }

    //                        System.out.println(k3+" "+v3);
                    }
                seccionesVerificacion.setRegistrosProductor(registrosProductor);
                }
             break;
            case "saludSeguridadOcupacional":
                Map<String, Object> resultado20 = oMapper.convertValue(object, Map.class);
                for(Map.Entry<String, Object> entry2 : resultado20.entrySet()) {
                    String k2 = entry2.getKey();
                    Object v2 = entry2.getValue();

                    Map<String, Object> resultado2 = oMapper.convertValue(v2, Map.class);
                    for(Map.Entry<String, Object> entry3 : resultado2.entrySet()) {
                        String k3 = entry3.getKey();
                        Object v3 = entry3.getValue();

                        Map<String, Object> resultado3 = oMapper.convertValue(v3, Map.class);
                        for(Map.Entry<String, Object> entry4 : resultado3.entrySet()) {
                            String k4 = entry4.getKey();
                            Object v4 = entry4.getValue();

                            switch(k3){
                                case "botiquin":
                                   saludSeguridad.setBotiquin(v4.toString());
                                 break;
                                case "buenasPracticasFincaTrabajadores":
                                   saludSeguridad.setBuenasPracticasFincaTrabajadores(v4.toString());
                                 break;
                                case "eppAntesPlaguicida":
                                    saludSeguridad.setEppAntesPlaguicida(v4.toString());
                                 break;
                                case "instruccionesPrimerosAuxilios":
                                    saludSeguridad.setInstruccionesPrimerosAuxilios(v4.toString());
                                 break;
                                case "trabajadoresLlevadosCapacitacionesSSO":
                                    saludSeguridad.setTrabajadoresLlevadosCapacitacionesSSO(v4.toString());
                                 break;
                                case "usoPictograma":
                                    saludSeguridad.setUsoPictograma(v4.toString());
                                 break;
                                
                            }
                        }

    //                        System.out.println(k3+" "+v3);
                    }
                seccionesVerificacion.setSaludSeguridad(saludSeguridad);
                }
             break;
            case "venta":
                Map<String, Object> resultado21 = oMapper.convertValue(object, Map.class);
                for(Map.Entry<String, Object> entry2 : resultado21.entrySet()) {
                    String k2 = entry2.getKey();
                    Object v2 = entry2.getValue();

                    Map<String, Object> resultado2 = oMapper.convertValue(v2, Map.class);
                    for(Map.Entry<String, Object> entry3 : resultado2.entrySet()) {
                        String k3 = entry3.getKey();
                        Object v3 = entry3.getValue();

                        Map<String, Object> resultado3 = oMapper.convertValue(v3, Map.class);
                        for(Map.Entry<String, Object> entry4 : resultado3.entrySet()) {
                            String k4 = entry4.getKey();
                            Object v4 = entry4.getValue();

                            switch(k3){
                            case "personaVenderCacao":
                                
                                if(!k4.equals("respuesta")){
                                    Map<String, Object> resultado05 = oMapper.convertValue(v4, Map.class);
                                    for(Map.Entry<String, Object> entry5 : resultado05.entrySet()) {
                                        String k5 = entry5.getKey();
                                        Object v5 = entry5.getValue();
                                        
                                        Map<String, Object> resultado0 = oMapper.convertValue(v5, Map.class);
                                        for(Map.Entry<String, Object> entry6 : resultado0.entrySet()) {
                                            String k6 = entry6.getKey();
                                            Object v6 = entry6.getValue();
                                            
//                                            System.out.println(k6+" "+v6);
                                            if(k5.equals("razon1")){
                                                personaVenderCacao.setRazon1(v6.toString());
                                            }
                                            if(k5.equals("razon2")){
                                                personaVenderCacao.setRazon2(v6.toString());
                                            }
                                            
                                        }
                                        
                                    }
                                }else{
                                    personaVenderCacao.setRespuesta(v4.toString());
                                }
                                
                                venta.setPersonaVenderCacao(personaVenderCacao);
                             break;
                            case "recibeBonosEmpresaProgramaLINDT":
                                
                                if(!k4.equals("respuesta")){
                                    Map<String, Object> resultado05 = oMapper.convertValue(v4, Map.class);
                                    for(Map.Entry<String, Object> entry5 : resultado05.entrySet()) {
                                        String k5 = entry5.getKey();
                                        Object v5 = entry5.getValue();
                                        
                                        Map<String, Object> resultado0 = oMapper.convertValue(v5, Map.class);
                                        for(Map.Entry<String, Object> entry6 : resultado0.entrySet()) {
                                            String k6 = entry6.getKey();
                                            Object v6 = entry6.getValue();
                                            
//                                            System.out.println(k6+" "+v6);
                                            if(k5.equals("frecuenciaRecibeBono")){
                                                recibeBonosEmpresaProgramaLINDT.setFrecuenciaRecibeBono(v6.toString());
                                            }
                                            
                                        }
                                        
                                    }
                                }else{
                                    recibeBonosEmpresaProgramaLINDT.setRespuesta(v4.toString());
                                }
                                
                                venta.setRecibeBonosEmpresaProgramaLINDT(recibeBonosEmpresaProgramaLINDT);
                             break;
                            }
                        }

    //                        System.out.println(k3+" "+v3);
                    }
                seccionesVerificacion.setVenta(venta);
                }
             break;
        }
    }
    
    
    public Verificacion diccionarioVerificacion(String doc, String form) throws InterruptedException, ExecutionException{
        
        Firestore dbFirestore = FirestoreClient.getFirestore();
        
        DocumentReference documentReference = dbFirestore.collection(COL_NAME).document(form).collection("diccionarios").document(doc);
        
        ApiFuture<DocumentSnapshot> future = documentReference.get();
        
        DocumentSnapshot document = future.get();
        
        Verificacion verificacion = new Verificacion();
        
        verificacion = document.toObject(Verificacion.class);
        
        return verificacion;
    }
    
    public LineaBase diccionarioLineaBase(String doc, String form) throws InterruptedException, ExecutionException{
        
        Firestore dbFirestore = FirestoreClient.getFirestore();
        
        DocumentReference documentReference = dbFirestore.collection(COL_NAME).document(form).collection("diccionarios").document(doc);
        
        ApiFuture<DocumentSnapshot> future = documentReference.get();
        
        DocumentSnapshot document = future.get();
        
        LineaBase lineaBase = new LineaBase();
        
        lineaBase = document.toObject(LineaBase.class);
        
        return lineaBase;
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
    
}
