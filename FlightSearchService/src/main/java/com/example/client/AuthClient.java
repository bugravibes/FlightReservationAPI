package com.example.client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.MediaType;

import java.util.HashMap;
import java.util.Map;

@Component
public class AuthClient {

    private final RestTemplate restTemplate = new RestTemplate();
    private final String authServiceUrl = "http://192.168.1.106:8080/auth/login";

    public boolean authenticate(String clientId, String clientPassword) {
        try {
            // Create the headers
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            // Create the body
            Map<String, String> body = new HashMap<>();
            body.put("username", clientId);
            body.put("password", clientPassword);

            // Create the request
            HttpEntity<Map<String, String>> request = new HttpEntity<>(body, headers);

            // Make the POST request
            ResponseEntity<Map> response = restTemplate.exchange(authServiceUrl, HttpMethod.POST, request, Map.class);

            // Check the response
            Map<String, String> responseBody = response.getBody();
            if (responseBody != null && "Login Successful".equals(responseBody.get("message"))) {
                return true;
            } else {
                return false;
            }
        } catch (HttpClientErrorException e) {
            // Handle the exception if the request failed
            return false;
        }
    }
}
