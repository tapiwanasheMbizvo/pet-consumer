package com.tapiwanashe.pet.consumer.service;

import java.util.List;

import com.tapiwanashe.pet.consumer.config.PropertiesConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.tapiwanashe.pet.consumer.dto.PetDto;

@Service
@Component
public class PetRestService {
    private final RestClient restClient;
    private  final PropertiesConfig propertiesConfig;

    public PetRestService(RestClient.Builder restClinetBuilder, PropertiesConfig propertiesConfig) {
        this.propertiesConfig = propertiesConfig;
        this.restClient = restClinetBuilder.baseUrl(propertiesConfig.getBaseUrl()).build();
    }

    public PetDto getOnePet(Long petId){

        return restClient.get().uri("/{id}", petId).retrieve().body(PetDto.class);
    }

    public List<PetDto> getAllPets(){

        return restClient.get().accept(MediaType.APPLICATION_JSON)
        .retrieve()
        .body(List.class);
    }

    public PetDto savePetDto(PetDto petDto){

        return restClient.post().body(petDto).retrieve().body(PetDto.class);
    }
    
}
