package com.example.tp3.Dtos;

import java.util.ArrayList;
import java.util.List;

public class CareerReportDto {

    private String name;
    private int year;
    private List<String> enrolled;
    private List<String> graduated;

    public CareerReportDto(String name, int year) {
        super();
        this.name = name;
        this.year = year;
        this.enrolled = new ArrayList<String>();
        this.graduated = new ArrayList<String>();
    }

	public String getName() {
		return name;
	}

	public int getYear() {
		return year;
	}

	public List<String> getEnrolled() {
		return enrolled;
	}

	public List<String> getGraduated() {
		return graduated;
	}
    
}