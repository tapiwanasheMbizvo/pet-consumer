package com.tapiwanashe.pet.consumer.config;


import com.tapiwanashe.pet.consumer.service.SecurityTokenService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestClient;

@Configuration
public class RestClientConfig {
    private  final SecurityTokenService tokenService;
    private  final PropertiesConfig propertiesConfig;
    public RestClientConfig(SecurityTokenService tokenService, PropertiesConfig propertiesConfig) {
        this.tokenService = tokenService;
        this.propertiesConfig = propertiesConfig;
    }

    @Bean

    public RestClient restClient(){
        RestClient newClient  = RestClient.builder()
                .baseUrl(propertiesConfig.getBaseUrl())
                .defaultHeader(HttpHeaders.AUTHORIZATION, "Bearer "+ tokenService.getPetAPIToken() )
                .build();
        return  newClient;

    }
}
