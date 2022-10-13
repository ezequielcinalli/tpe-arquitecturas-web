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
          var student1 = new Student("Student1", "Student1", new Date(2000-1-1), Genre.Masculino, 123456, city1);
          var student2 = new Student("Student2", "Student2", new Date(2000-1-1), Genre.Femenino, 654321, city2);
          var student3 = new Student("Student3", "Student3", new Date(1995-5-5), Genre.Femenino, 555555, city1);
          var student4 = new Student("Student4", "Student4", new Date(1997-2-2), Genre.Femenino, 525252, city2);
          var student5 = new Student("Student5", "Student5", new Date(2002-4-5), Genre.NosabeNocontesta, 404404, city1);
          var student6 = new Student("Student6", "Student6", new Date(1990-5-9), Genre.Femenino, 616161, city2);
          var student7 = new Student("Student7", "Student7", new Date(2005-5-12), Genre.Masculino, 747474, city1);
          var student8 = new Student("Student8", "Student8", new Date(1990-3-03), Genre.NosabeNocontesta, 101010, city2);
          var student9 = new Student("Student9", "Student9", new Date(1990-1-1), Genre.Masculino, 686868, city1);
          var student10 = new Student("Student10", "Student10", new Date(2000-01-01), Genre.NosabeNocontesta, 656565, city2);
          log.info("Preloading " + studentRepository.save(student1));
          log.info("Preloading " + studentRepository.save(student2));
          log.info("Preloading " + studentRepository.save(student3));
          log.info("Preloading " + studentRepository.save(student4));
          log.info("Preloading " + studentRepository.save(student5));
          log.info("Preloading " + studentRepository.save(student6));
          log.info("Preloading " + studentRepository.save(student7));
          log.info("Preloading " + studentRepository.save(student8));
          log.info("Preloading " + studentRepository.save(student9));
          log.info("Preloading " + studentRepository.save(student10));
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