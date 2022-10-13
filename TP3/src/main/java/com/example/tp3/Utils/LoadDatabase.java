package com.example.tp3.Utils;

import com.example.tp3.Models.Career;
import com.example.tp3.Models.City;
import com.example.tp3.Models.Genre;
import com.example.tp3.Models.Student;
import com.example.tp3.Models.StudentCareer;
import com.example.tp3.Repositories.CareerRepository;
import com.example.tp3.Repositories.CityRepository;
import com.example.tp3.Repositories.StudentCareerRepository;
import com.example.tp3.Repositories.StudentRepository;

import lombok.extern.slf4j.Slf4j;

import java.sql.Date;
import java.text.SimpleDateFormat;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
class LoadDatabase {

	@Bean
    CommandLineRunner initDatabase(CityRepository cityRepository, StudentRepository studentRepository, CareerRepository careerRepository, StudentCareerRepository studentCareerRepository) {
    	return args -> {
    		SimpleDateFormat obj = new SimpleDateFormat("yyyy-MM-dd");
			var city1 = new City("City1");
			var city2 = new City("City2");
			log.info("Preloading " + cityRepository.save(city1));
			log.info("Preloading " + cityRepository.save(city2));
			var student1 = new Student("Student1", "Student1", new Date(obj.parse("2000-1-1").getTime()), Genre.Masculino, 123456, city1);
			var student2 = new Student("Student2", "Student2", new Date(obj.parse("2000-1-1").getTime()), Genre.Femenino, 654321, city2);
			var student3 = new Student("Student3", "Student3", new Date(obj.parse("1995-5-5").getTime()), Genre.Femenino, 555555, city1);
			var student4 = new Student("Student4", "Student4", new Date(obj.parse("1997-2-2").getTime()), Genre.Femenino, 525252, city2);
			var student5 = new Student("Student5", "Student5", new Date(obj.parse("2002-4-5").getTime()), Genre.NosabeNocontesta, 404404, city1);
			var student6 = new Student("Student6", "Student6", new Date(obj.parse("1990-5-9").getTime()), Genre.Femenino, 616161, city2);
			var student7 = new Student("Student7", "Student7", new Date(obj.parse("2005-5-12").getTime()), Genre.Masculino, 747474, city1);
			var student8 = new Student("Student8", "Student8", new Date(obj.parse("1990-3-03").getTime()), Genre.NosabeNocontesta, 101010, city2);
			var student9 = new Student("Student9", "Student9", new Date(obj.parse("1990-1-1").getTime()), Genre.Masculino, 686868, city1);
			var student10 = new Student("Student10", "Student10", new Date(obj.parse("2000-01-01").getTime()), Genre.NosabeNocontesta, 656565, city2);
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
			var studentCareer1 = new StudentCareer(student1, career1, new Date(obj.parse("2015-1-1").getTime()), new Date(obj.parse("2016-1-1").getTime()));
			var studentCareer2 = new StudentCareer(student2, career2, new Date(obj.parse("2013-3-3").getTime()), new Date(obj.parse("2016-1-1").getTime()));
			var studentCareer3 = new StudentCareer(student3, career3, new Date(obj.parse("2014-4-4").getTime()), new Date(obj.parse("2014-1-1").getTime()));
			var studentCareer4 = new StudentCareer(student4, career4, new Date(obj.parse("2012-2-2").getTime()), new Date(obj.parse("2017-1-1").getTime()));
			var studentCareer5 = new StudentCareer(student5, career5, new Date(obj.parse("2009-9-9").getTime()), new Date(obj.parse("2018-1-1").getTime()));
			var studentCareer6 = new StudentCareer(student6, career6, new Date(obj.parse("2016-6-6").getTime()), new Date(obj.parse("2020-1-1").getTime()));
			var studentCareer7 = new StudentCareer(student7, career7, new Date(obj.parse("2016-6-6").getTime()), new Date(obj.parse("2021-1-1").getTime()));
			var studentCareer8 = new StudentCareer(student8, career8, new Date(obj.parse("2017-7-7").getTime()), new Date(obj.parse("2015-1-1").getTime()));
			var studentCareer9 = new StudentCareer(student9, career9, new Date(obj.parse("2012-2-2").getTime()), new Date(obj.parse("2014-1-1").getTime()));
			var studentCareer10 = new StudentCareer(student10, career10, new Date(obj.parse("2015-1-1").getTime()), new Date(obj.parse("2013-3-3").getTime()));
			log.info("Preloading " + studentCareerRepository.save(studentCareer1));
			log.info("Preloading " + studentCareerRepository.save(studentCareer2));
			log.info("Preloading " + studentCareerRepository.save(studentCareer3));
			log.info("Preloading " + studentCareerRepository.save(studentCareer4));
			log.info("Preloading " + studentCareerRepository.save(studentCareer5));
			log.info("Preloading " + studentCareerRepository.save(studentCareer6));
			log.info("Preloading " + studentCareerRepository.save(studentCareer7));
			log.info("Preloading " + studentCareerRepository.save(studentCareer8));
			log.info("Preloading " + studentCareerRepository.save(studentCareer9));
			log.info("Preloading " + studentCareerRepository.save(studentCareer10));
        };
    }
}