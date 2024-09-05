package com.tapiwanashe.pet.consumer.service;

import java.util.List;

import com.tapiwanashe.pet.consumer.config.PropertiesConfig;
import jakarta.validation.constraints.Max;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.tapiwanashe.pet.consumer.dto.PetDto;

@Service
@Component
public class PetRestService {
    private final RestClient restClient;


    public PetRestService(RestClient restClient) {
        this.restClient = restClient;
    }

    public PetDto getOnePet(Long petId) {


        return restClient.get().uri("/{id}", petId).retrieve().body(PetDto.class);
    }

    public List<PetDto> getAllPets() {
        return restClient.get().retrieve().body(List.class);

    }

    public PetDto savePetDto(PetDto petDto) {

        return restClient.post().body(petDto).retrieve().body(PetDto.class);
    }


}
