package com.escaes.API.service;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.escaes.API.DTO.BoredDTO;

@Service
public class BoredService {

    private final RestTemplate restTemplate;

    public BoredService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public BoredDTO randomBored(){

        try {
            String url = "https://bored-api.appbrewery.com/random";
            
            return  restTemplate.getForObject(url, BoredDTO.class);
            
        } catch (Exception e) {
            return new BoredDTO("Error al obtener actividad", "unknown", 0, 0, "", "", false);
        }
    }

}
