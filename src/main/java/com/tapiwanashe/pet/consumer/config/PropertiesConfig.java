package com.tapiwanashe.pet.consumer.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
public class PropertiesConfig {


    @Value("${PET_API_BASE_UR}")
    private String baseUrl;

    @Value("${AUTH_SERVER_URL}")
    private String authServerUrl;

    @Value("${KEY_CLOACK_PET_CLIENT_ID}")
    private String authClientId;

    @Value("${KC_PET_DEV_USER}")
    private String authPassword;

    @Value("${KC_PET_DEV_USER_PWD}")
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
