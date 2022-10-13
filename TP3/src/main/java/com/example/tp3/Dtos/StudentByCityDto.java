package com.example.tp3.Dtos;

public class StudentByCityDto {
    private String name;
    private String surname;

    public StudentByCityDto(String name, String surname){
      this.name = name;
      this.surname = surname;
    }

    public String getName() {
      return name;
    }

    public String getSurname() {
      return surname;
    }
}
