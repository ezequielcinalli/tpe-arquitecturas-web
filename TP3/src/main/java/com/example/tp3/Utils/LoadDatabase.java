package com.example.tp3.Utils;

import com.example.tp3.Models.City;
import com.example.tp3.Models.Genre;
import com.example.tp3.Models.Student;
import com.example.tp3.Repositories.CityRepository;
import com.example.tp3.Repositories.StudentRepository;

import lombok.extern.slf4j.Slf4j;

import java.sql.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
class LoadDatabase {

    @Bean
        CommandLineRunner initDatabase(CityRepository cityRepository, StudentRepository studentRepository) {
        return args -> {
        	var city1 = new City("City1");
        	var city2 = new City("City2");
            log.info("Preloading " + cityRepository.save(city1));
            log.info("Preloading " + cityRepository.save(city2));
            var student1 = new Student("Student1", "Student1", new Date(2000-01-01), Genre.Masculino, 123456, city1);
            var student2 = new Student("Student2", "Student2", new Date(2000-01-01), Genre.Femenino, 123456, city2);
            log.info("Preloading " + studentRepository.save(student1));
            log.info("Preloading " + studentRepository.save(student2));
        };
    }
}