package com.tp5.customers.Dtos;

public class CustomerReportDto {

    private String name;
    private float total;
    
    public CustomerReportDto(String name, float total) {
        super();
        this.name = name;
        this.total = total ;
    }

	public String getName() {
		return name;
	}

	public float getTotal() {
		return total;
	}
	
}