package com.tapiwanashe.pet.consumer.service;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import com.tapiwanashe.pet.consumer.dto.PetDto;

import lombok.extern.slf4j.Slf4j;


@Slf4j
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
        log.trace("##########################sending_request##############");

        return restClient.get().retrieve().body(List.class);

    }

    public PetDto savePetDto(PetDto petDto) {

        return restClient.post().body(petDto).retrieve().body(PetDto.class);
    }


}
