package com.tapiwanashe.pet.consumer.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tapiwanashe.pet.consumer.dto.PetDto;
import com.tapiwanashe.pet.consumer.service.PetRestService;

@RestController
@RequestMapping("api/consumer/pets")
public class PetConsumerController {

        private final PetRestService petService;

    public PetConsumerController(PetRestService petService) {
        this.petService = petService;
    }



     @GetMapping
    public ResponseEntity<List<PetDto>> getAllPets(){


        return  ResponseEntity.ok().body(petService.getAllPets());
    }

     @GetMapping("/{id}")
    public  ResponseEntity<PetDto> getOnePet(@PathVariable Long id){


        return  ResponseEntity.ok().body(petService.getOnePet(id));

    }

    @PostMapping
    public  ResponseEntity<PetDto> saveOnePet(@RequestBody PetDto petDto){

        return  ResponseEntity.status(HttpStatus.CREATED).body(petService.savePetDto(petDto));

    }

    @PutMapping
    public  ResponseEntity<PetDto> updateOnePet(@RequestBody PetDto petDto){

        return  ResponseEntity.status(HttpStatus.CREATED).body(petService.savePetDto(petDto));

    }

    
}
