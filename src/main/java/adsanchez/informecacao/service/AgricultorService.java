/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adsanchez.informecacao.service;

import adsanchez.informecacao.entity.Agricultor;
import adsanchez.informecacao.entity.CacaoCNN;
import adsanchez.informecacao.entity.CacaoNacional;
import adsanchez.informecacao.entity.CacaoNacionalNC;
import adsanchez.informecacao.entity.Campo;
import adsanchez.informecacao.entity.Croquis;
import adsanchez.informecacao.entity.DatosPersonales;
import adsanchez.informecacao.entity.Hectareaje;
import adsanchez.informecacao.entity.InformacionFinca;
import adsanchez.informecacao.entity.OrigenPlantas;
import adsanchez.informecacao.entity.Secciones;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.firebase.cloud.FirestoreClient;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import org.springframework.stereotype.Service;

/**
 *
 * @author Javier
 */
@Service
public class AgricultorService {
    
    public static final String COL_NAME = "agricultores";

    public Agricultor getAgricultor(String id) throws InterruptedException, ExecutionException {
        Firestore dbFirestore = FirestoreClient.getFirestore();

        DocumentReference documentReference = dbFirestore.collection(COL_NAME).document(id);

        ApiFuture<DocumentSnapshot> future = documentReference.get();
        DocumentSnapshot document = future.get();
        
        
        Secciones seccion = new Secciones();
            
        Agricultor agricultor = new Agricultor();

        DatosPersonales datosPersonales = new DatosPersonales();

        CacaoCNN cacaocnn = new CacaoCNN();

        CacaoNacional cacaonacional = new CacaoNacional();

        CacaoNacionalNC  cacaoNacionalnc = new CacaoNacionalNC();

        Croquis croquis = new Croquis();

        Hectareaje hectareaje = new Hectareaje();

        InformacionFinca informacionFinca = new InformacionFinca();

        OrigenPlantas origenPlantas = new OrigenPlantas();
            
        
        seccion = document.toObject(Secciones.class);
        
//        System.out.println(document.getData());
        
        Map<String, Campo> map = seccion.getSecciones();
        
        agricultor.setId(document.getId());
        
        for(Map.Entry<String, Campo> entry : map.entrySet()) {
            String k = entry.getKey();
            Campo v = entry.getValue();

            SeccionesAgricultor(k, v, agricultor, datosPersonales, cacaocnn, 
                        cacaonacional, cacaoNacionalnc, croquis, hectareaje, informacionFinca, origenPlantas);
            
        }
        return agricultor;
    }
    
    public List<Object> getAgricultores() throws InterruptedException, ExecutionException, NoSuchFieldException {
        Firestore dbFirestore = FirestoreClient.getFirestore();

        ApiFuture<QuerySnapshot> future = dbFirestore.collection(COL_NAME).get();

        List<QueryDocumentSnapshot> documents = future.get().getDocuments();

        List<Object> agricultores = new LinkedList<>();
        
        for (QueryDocumentSnapshot document : documents) {
            
            Secciones seccion = new Secciones();
            
            
            Agricultor agricultor = new Agricultor();
            
            DatosPersonales datosPersonales = new DatosPersonales();
            
            CacaoCNN cacaocnn = new CacaoCNN();
            
            CacaoNacional cacaonacional = new CacaoNacional();
            
            CacaoNacionalNC  cacaoNacionalnc = new CacaoNacionalNC();
            
            Croquis croquis = new Croquis();
            
            Hectareaje hectareaje = new Hectareaje();
            
            InformacionFinca informacionFinca = new InformacionFinca();
            
            OrigenPlantas origenPlantas = new OrigenPlantas();
            
            
            seccion = document.toObject(Secciones.class);
            
            agricultor.setId(document.getId());
            
            Map<String, Campo> map = seccion.getSecciones();            

            for(Map.Entry<String, Campo> entry : map.entrySet()) {
		String k = entry.getKey();
		Campo v = entry.getValue();
                
                SeccionesAgricultores(k, v, agricultor, agricultores, datosPersonales, cacaocnn, 
                        cacaonacional, cacaoNacionalnc, croquis, hectareaje, informacionFinca, origenPlantas);
                                
            }
            
        }
        
        return agricultores;
    }
    
    
    public void SeccionesAgricultores(String registro, Campo campo, Agricultor agricultor, List<Object> agricultores, 
            DatosPersonales datosPersonales, CacaoCNN cacaocnn, CacaoNacional cacaonacional, CacaoNacionalNC  cacaoNacionalnc,
            Croquis croquis, Hectareaje hectareaje, InformacionFinca informacionFinca, OrigenPlantas origenPlantas){

        switch(registro){

            case "datosPersonales":
                campo.getDatosPersonales(datosPersonales);
                agricultor.setDatosPersonales(datosPersonales);
                agricultores.add(agricultor);
             break;
            case "cacaoCNN":
                campo.getCacaoCNN(cacaocnn);
                agricultor.setCacaoCNN(cacaocnn);
             break;
            case "cacaoNacional":
                campo.getCacaoNacional(cacaonacional);
                agricultor.setCacaoNacional(cacaonacional);
             break;
            case "cacaoNacionalNuevosClones":
                campo.getCacaoNacionalNC(cacaoNacionalnc);
                agricultor.setCacaoNacionalNuevosClones(cacaoNacionalnc);

             break;
            case "croquis":
                campo.getCroquis(croquis);
                agricultor.setCroquis(croquis);
             break;
            case "hectareaje":
                campo.getHectareaje(hectareaje);
                agricultor.setHectareaje(hectareaje);
             break;
            case "informacionFinca":
                campo.getInformacionFinca(informacionFinca);
                agricultor.setInformacionFinca(informacionFinca);
             break;
            case "origenPlantas":
                campo.getOrigenPlantas(origenPlantas);
                agricultor.setOrigenPlantas(origenPlantas);
             break;
        
        }

    }
    
    public void SeccionesAgricultor(String registro, Campo campo, Agricultor agricultor, DatosPersonales datosPersonales, 
            CacaoCNN cacaocnn, CacaoNacional cacaonacional, CacaoNacionalNC  cacaoNacionalnc,
            Croquis croquis, Hectareaje hectareaje, InformacionFinca informacionFinca, OrigenPlantas origenPlantas){

        switch(registro){

            case "datosPersonales":
                campo.getDatosPersonales(datosPersonales);
                agricultor.setDatosPersonales(datosPersonales);
             break;
            case "cacaoCNN":
                campo.getCacaoCNN(cacaocnn);
                agricultor.setCacaoCNN(cacaocnn);
             break;
            case "cacaoNacional":
                campo.getCacaoNacional(cacaonacional);
                agricultor.setCacaoNacional(cacaonacional);
             break;
            case "cacaoNacionalNuevosClones":
                campo.getCacaoNacionalNC(cacaoNacionalnc);
                agricultor.setCacaoNacionalNuevosClones(cacaoNacionalnc);

             break;
            case "croquis":
                campo.getCroquis(croquis);
                agricultor.setCroquis(croquis);
             break;
            case "hectareaje":
                campo.getHectareaje(hectareaje);
                agricultor.setHectareaje(hectareaje);
             break;
            case "informacionFinca":
                campo.getInformacionFinca(informacionFinca);
                agricultor.setInformacionFinca(informacionFinca);
             break;
            case "origenPlantas":
                campo.getOrigenPlantas(origenPlantas);
                agricultor.setOrigenPlantas(origenPlantas);
             break;
        
        }

    }


}


