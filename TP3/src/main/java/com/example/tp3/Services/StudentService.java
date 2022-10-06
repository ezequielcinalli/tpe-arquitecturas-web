package com.example.tp3.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tp3.Models.Student;
import com.example.tp3.Repositories.StudentRepository;

@Service
public class StudentService {
	
    @Autowired
    private final StudentRepository repository;

    public StudentService(StudentRepository repository){
        this.repository = repository;
    }
    
    public Iterable<Student> findAll(){
        return repository.findAll();
    }
    
    public Optional<Student> findById(Integer id){
        return repository.findById(id);
    }
    
    public Student save(Student student){
        return repository.save(student);
    }
    
    public Student update(Student student){
        return repository.save(student);
    }
    
    public void deleteById(Integer id){
        repository.deleteById(id);
    }
}
