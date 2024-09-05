package com.tapiwanashe.pet.consumer.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
public class PropertiesConfig {


    @Value("${pet.baseUrl}")
    private String baseUrl;

    @Value("${keycloak.auth.server.url}")
    private String authServerUrl;

    @Value("${keycloak.auth.pet.client.id}")
    private String authClientId;

    @Value("${keycloack.password}")
    private String authPassword;

    @Value("${keycloack.username}")
    private String authUsername;



    public String getAuthServerUrl() {

        return authServerUrl;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public String getAuthClientId() {
        return authClientId;
    }

    public String getAuthPassword() {
        return authPassword;
    }

    public String getAuthUsername() {
        return authUsername;
    }
}
