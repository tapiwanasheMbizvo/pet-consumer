package com.tapiwanashe.pet.consumer.service;


import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.tapiwanashe.pet.consumer.config.PropertiesConfig;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
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

        log.trace("##########################GETTING_TOKEN##############");
        StringBuilder bodyBuilder = new StringBuilder();
        bodyMap.forEach((key, value) -> {
            if (bodyBuilder.length() != 0) {
                bodyBuilder.append("&");
            }
            bodyBuilder.append(key).append("=").append(value);
        });
        log.trace("##########################GETTING_TOKEN##############");
        HttpEntity<String> requestEntity = new HttpEntity<>(bodyBuilder.toString(), headers);

        ResponseEntity<Map> response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, Map.class);
        log.trace("##########################RESPONSE##############"+ response);
        if (response.getStatusCode().is2xxSuccessful()) {

            return response.getBody().get("access_token").toString();
        } else {

            throw new RuntimeException("user not auth");
        }

    }
}
