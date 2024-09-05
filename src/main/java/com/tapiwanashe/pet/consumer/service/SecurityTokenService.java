package com.tapiwanashe.pet.consumer.service;


import com.tapiwanashe.pet.consumer.config.PropertiesConfig;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;


@Service

public class SecurityTokenService {

    private final RestTemplate restTemplate;
    private final PropertiesConfig propertiesConfig;

    public SecurityTokenService(RestTemplate restTemplate, PropertiesConfig propertiesConfig) {
        this.restTemplate = restTemplate;

        this.propertiesConfig = propertiesConfig;

    }

    public String getPetAPIToken() {
        String url = propertiesConfig.getAuthServerUrl();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(org.springframework.http.MediaType.APPLICATION_FORM_URLENCODED);


        Map<String, String> bodyMap = new HashMap<>();
        bodyMap.put("grant_type", "password");

        bodyMap.put("client_id", propertiesConfig.getAuthClientId());
        bodyMap.put("username", propertiesConfig.getAuthUsername());
        bodyMap.put("password", propertiesConfig.getAuthPassword());


        StringBuilder bodyBuilder = new StringBuilder();
        bodyMap.forEach((key, value) -> {
            if (bodyBuilder.length() != 0) {
                bodyBuilder.append("&");
            }
            bodyBuilder.append(key).append("=").append(value);
        });

        HttpEntity<String> requestEntity = new HttpEntity<>(bodyBuilder.toString(), headers);

        ResponseEntity<Map> response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, Map.class);

        if (response.getStatusCode().is2xxSuccessful()) {

            return response.getBody().get("access_token").toString();
        } else {

            throw new RuntimeException("user not auth");
        }

    }
}
