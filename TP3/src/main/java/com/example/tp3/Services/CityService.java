package com.example.tp3.Services;

import com.example.tp3.Models.City;
import com.example.tp3.Repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CityService {
	
    @Autowired
    private final CityRepository repository;

    public CityService(CityRepository repository){
        this.repository = repository;
    }
    
    public Iterable<City> findAll(){
        return repository.findAll();
    }
    
    public Optional<City> findById(Integer id){
        return repository.findById(id);
    }
    
    public City save(City city){
        return repository.save(city);
    }
    
    public City update(City city){
        return repository.save(city);
    }
    
    public void deleteById(Integer id){
        repository.deleteById(id);
    }
}
