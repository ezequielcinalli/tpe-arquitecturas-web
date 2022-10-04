package com.example.tp3.Services;

import com.example.tp3.Models.City;
import com.example.tp3.Repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
