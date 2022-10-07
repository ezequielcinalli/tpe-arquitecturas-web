package com.example.tp3.Dtos;

public class CareerWithInscriptionsDto {
    private String nameCareer;
    private long quantityInscriptions;

    public CareerWithInscriptionsDto(String nameCareer, long quantityInscriptions) {
        super();
        this.nameCareer = nameCareer;
        this.quantityInscriptions = quantityInscriptions;
    }
}
