package com.example.tp3.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tp3.Dtos.StudentAddDto;
import com.example.tp3.Dtos.StudentByCityDto;
import com.example.tp3.Dtos.StudentUpdateDto;
import com.example.tp3.Models.City;
import com.example.tp3.Models.Genre;
import com.example.tp3.Models.Student;
import com.example.tp3.Repositories.CityRepository;
import com.example.tp3.Repositories.StudentRepository;

@Service
public class StudentService {
	
    @Autowired
    private final StudentRepository repository;
    @Autowired
    private final CityRepository cityRepository;

    public StudentService(StudentRepository repository, CityRepository cityRepository){
        this.repository = repository;
        this.cityRepository = cityRepository;
    }
    
    public Iterable<Student> findAll(){
        return repository.findAll();
    }
    
    public Optional<Student> findById(Integer id){
        return repository.findById(id);
    }
    
    public Student save(StudentAddDto dto){
    	City city = cityRepository.getReferenceById(dto.cityId);
    	Student student = new Student(dto.name, dto.surname, dto.birthdate, dto.genre, dto.dni, city);
        return repository.save(student);
    }
    
    public Student update(StudentUpdateDto dto, int id) {
    	
    	Student student = repository.getReferenceById(id);
        City city = cityRepository.getReferenceById(dto.cityId);
        
        student.setName(dto.name);
        student.setSurname(dto.surname);
        student.setBirthdate(dto.birthdate);
        student.setGenre(dto.genre);
        student.setDni(dto.dni);
        student.setcity(city);
        
        return repository.save(student);
    }
    
    public void deleteById(Integer id){
        repository.deleteById(id);
    }

    public Iterable<Student> studentSortedByName() {
        return repository.studentSortedByName();
    }
    
    public Iterable<StudentByCityDto> studentsByGenre(Genre genre) {
        return repository.studentsByGenre(genre);
    }
}
