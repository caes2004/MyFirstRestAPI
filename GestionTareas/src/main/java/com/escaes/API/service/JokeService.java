package com.escaes.API.service;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import com.escaes.API.DTO.JokeDTO;

@Service
public class JokeService {

    private final RestTemplate restTemplate;

    public JokeService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public JokeDTO randomJoke(){

        try {
            String url = "https://v2.jokeapi.dev/joke/Any?lang=es&type=twopart";
            
            return  restTemplate.getForObject(url, JokeDTO.class);
            
        } catch (Exception e) {
            return new JokeDTO(true, "No category", "No type", "No setup", "No delivery");
        }
    }

}
