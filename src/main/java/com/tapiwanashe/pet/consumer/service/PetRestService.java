package com.tapiwanashe.pet.consumer.service;

import java.util.List;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.tapiwanashe.pet.consumer.dto.PetDto;

@Service
public class PetRestService {


    private final RestClient restClient;


    public PetRestService( RestClient.Builder restClinetBuilder) {
        this.restClient = restClinetBuilder.baseUrl("http://10.0.21.103:8785/api/v1/pets").build();

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
