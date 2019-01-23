package com.rag.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RestController
@RequestMapping("/service")
public class WeatherService {

    @Value("${service.url}")
    private String url;

    @Value("${api.key}")
    private String apiKey;

    @GetMapping("/city")
    public String getLocation(){
        return "Hello World";
    }

    @PostMapping("/search")
    public String getLocationPost(@RequestBody Map<String, String> body){
        return getCitiesArray(body.get("city"));
    }

    @GetMapping("/search")
    public String getCitiesArray(@RequestParam String city){
        RestTemplate restTemplate = new RestTemplate();
        System.out.println("URL : "+url+"?q="+city+"&apiKey="+apiKey);
//        String response = restTemplate.getForObject(url+"?q="+city+"&apiKey="+apiKey, String.class,new Object());
        return "data returned for "+city;
    }
}
