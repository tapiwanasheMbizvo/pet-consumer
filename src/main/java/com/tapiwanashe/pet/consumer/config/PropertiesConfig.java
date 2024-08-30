package com.tapiwanashe.pet.consumer.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
public class PropertiesConfig {

    @Value( "${pet.baseUrl}" )
    private String baseUrl;

    public String getBaseUrl() {
        return baseUrl;
    }
}
