package com.example.tp3.Dtos;

import java.util.ArrayList;
import java.util.List;

public class CareerReportDto {

    private String nameCareer;
    private int year;
    private List<String> enrolled;
    private List<String> graduated;

    public CareerReportDto(String nameCareer, int year) {
        super();
        this.nameCareer = nameCareer;
        this.year = year;
        this.enrolled = new ArrayList<String>();
        this.graduated = new ArrayList<String>();
    }
}