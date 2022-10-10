package com.example.tp3.Services;

import com.example.tp3.Dtos.CareerAddDto;
import com.example.tp3.Dtos.CareerUpdateDto;
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
    
    public Career save(CareerAddDto career){
        return repository.save(new Career(career.name));
    }
    
    public Career update(CareerUpdateDto career, Integer ID){
        Career oldCareer = findById(ID).get();
        oldCareer.setName(career.name);
        return repository.save(oldCareer);
    }
    
    public void deleteById(Integer id){
        repository.deleteById(id);
    }
}
