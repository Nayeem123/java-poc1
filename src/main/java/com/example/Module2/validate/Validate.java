package com.example.Module2.validate;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class Validate {

    public ResponseEntity<String> validateToken(String authorizationHeader) {
        RestTemplate restTemplate = new RestTemplate();
       // String url = "http://localhost:8080/api/validateToken?authorizationHeader=" + authorizationHeader;
        //String url = "http://localhost:8080/api/validateToken";
        String url = "http://35.154.206.176:8080/api/validateToken";

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Authorization", authorizationHeader);
        HttpEntity<String> httpEntity = new HttpEntity<>(httpHeaders);
        ResponseEntity<String> apiResponse = restTemplate.exchange(url, HttpMethod.GET,httpEntity,String.class);

       // ResponseEntity<String> apiResponse = restTemplate.getForEntity(url, String.class);

        if (apiResponse.getBody().equals("true")){
            System.out.println("apiResponse : true");
        }
        else {
            System.out.println("apiResponse : False");
        }
        return apiResponse;
    }
}
