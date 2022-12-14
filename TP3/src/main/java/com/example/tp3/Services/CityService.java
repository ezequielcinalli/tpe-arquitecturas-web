package com.example.tp3.Services;

import com.example.tp3.Dtos.CityAddDto;
import com.example.tp3.Dtos.CityUpdateDto;
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
    
    public City save(CityAddDto city){
        return repository.save(new City(city.name));
    }
    
    public City update(CityUpdateDto city, Integer ID){
        City oldCity = findById(ID).get();
        oldCity.setName(city.name);
        return repository.save(oldCity);
    }
    
    public void deleteById(Integer id){
        repository.deleteById(id);
    }
}
