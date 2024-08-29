package com.tapiwanashe.pet.consumer.dto;

public class PetDto {
    private Long id;
       private String petName;
       private String petDescription;
   
   
       public Long getId() {
           return this.id;
       }
   
       public void setId(Long id) {
           this.id = id;
       }
   
       public String getPetName() {
           return this.petName;
       }
   
       public void setPetName(String petName) {
           this.petName = petName;
       }
   
       public String getPetDescription() {
           return this.petDescription;
       }
   
       public void setPetDescription(String petDescription) {
           this.petDescription = petDescription;
       }
   
   
       @Override
       public String toString() {
           return "{" +
               " id='" + getId() + "'" +
               ", petName='" + getPetName() + "'" +
               ", petDescription='" + getPetDescription() + "'" +
               "}";
       }

    public PetDto(String petName, String petDescription) {
        this.petName = petName;
        this.petDescription = petDescription;
    }
   
   
   }
   
