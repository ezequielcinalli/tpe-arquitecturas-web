package com.example.tp3.Utils;

import com.example.tp3.Models.Career;
import com.example.tp3.Models.City;
import com.example.tp3.Models.Genre;
import com.example.tp3.Models.Student;
import com.example.tp3.Repositories.CareerRepository;
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
        CommandLineRunner initDatabase(CityRepository cityRepository, StudentRepository studentRepository, CareerRepository careerRepository) {
        return args -> {
        	var city1 = new City("City1");
        	var city2 = new City("City2");
            log.info("Preloading " + cityRepository.save(city1));
            log.info("Preloading " + cityRepository.save(city2));
            var student1 = new Student("Student1", "Student1", new Date(2000-01-01), Genre.Masculino, 123456, city1);
            var student2 = new Student("Student2", "Student2", new Date(2000-01-01), Genre.Femenino, 123456, city2);
            log.info("Preloading " + studentRepository.save(student1));
            log.info("Preloading " + studentRepository.save(student2));
            var career1 = new Career("Arquitecturas web");
            var career2 = new Career("Quimica");
            var career3 = new Career("Matematicas");
            var career4 = new Career("Programacion");
            var career5 = new Career("Administracion de empresas");
            var career6 = new Career("Desarrrollo web");
            var career7 = new Career("Literatura");
            var career8 = new Career("Profesorado ingles");
            var career9 = new Career("Arte");
            var career10 = new Career("Fisica");
            log.info("Preloading " + careerRepository.save(career1));
            log.info("Preloading " + careerRepository.save(career2));
            log.info("Preloading " + careerRepository.save(career3));
            log.info("Preloading " + careerRepository.save(career4));
            log.info("Preloading " + careerRepository.save(career5));
            log.info("Preloading " + careerRepository.save(career6));
            log.info("Preloading " + careerRepository.save(career7));
            log.info("Preloading " + careerRepository.save(career8));
            log.info("Preloading " + careerRepository.save(career9));
            log.info("Preloading " + careerRepository.save(career10));

        };
    }
}