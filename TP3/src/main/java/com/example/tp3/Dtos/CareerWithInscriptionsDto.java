package com.example.tp3.Dtos;

public class CareerWithInscriptionsDto {
	
    private String name;
    private long inscriptions;

    public CareerWithInscriptionsDto(String name, long inscriptions) {
        super();
        this.name = name;
        this.inscriptions = inscriptions;
    }

	public String getNameCareer() {
		return name;
	}

	public long getQuantityInscriptions() {
		return inscriptions;
	}
    
}
