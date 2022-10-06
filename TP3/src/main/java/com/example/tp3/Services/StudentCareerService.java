package com.example.tp3.Services;

import com.example.tp3.Models.StudentCareer;
import com.example.tp3.Repositories.StudentCareerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class StudentCareerService {
    @Autowired
    private final StudentCareerRepository repository;

    public StudentCareerService(StudentCareerRepository repository){
        this.repository = repository;
    }

    public Iterable<StudentCareer> findAll(){
        return repository.findAll();
    }

    public Optional<StudentCareer> findById(Integer id){
        return repository.findById(id);
    }

    public StudentCareer save(StudentCareer studentCareer){
        return repository.save(studentCareer);
    }

    public StudentCareer update(StudentCareer studentCareer){
        return repository.save(studentCareer);
    }

    public void deleteById(Integer id){
        repository.deleteById(id);
    }
}
