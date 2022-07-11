/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adsanchez.informecacao.init;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Service;

/**
 *
 * @author Javier
 */
@Service
public class FbInitialize {
    
    @PostConstruct  
    public void initialize() {  
        try {  
           InputStream serviceAccount =  getClass().getClassLoader().getResourceAsStream("FirebaseKey.json");  
           FirebaseOptions options = new FirebaseOptions.Builder()  
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))  
                .setDatabaseUrl("https://adsanchez.firebaseio.com")  
                .build();  
           
           FirebaseApp.initializeApp(options);  
           
        } catch (Exception e) {  
           e.printStackTrace();  
        }
    }
    
}
