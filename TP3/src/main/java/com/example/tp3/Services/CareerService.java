package com.example.tp3.Services;

import com.example.tp3.Models.Career;
import com.example.tp3.Repositories.CareerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CareerService {
    @Autowired
    private final CareerRepository repository;

    public CareerService(CareerRepository repository){
        this.repository = repository;
    }
    
    public Iterable<Career> findAll(){
        return repository.findAll();
    }
    
    public Optional<Career> findById(Integer id){
        return repository.findById(id);
    }
    
    public Career save(Career Career){
        return repository.save(Career);
    }
    
    public Career update(Career Career){
        return repository.save(Career);
    }
    
    public void deleteById(Integer id){
        repository.deleteById(id);
    }
}
