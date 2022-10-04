package com.example.tp3.Controllers;

import com.example.tp3.Models.City;
import com.example.tp3.Services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("cities")
public class CityController {
    
    @Autowired
    private final CityService service;
    
    public CityController(CityService service){
       this.service = service; 
    }
    
    @GetMapping("/")
    public Iterable<City> getCities(){
        return service.findAll();
    }
    
    @GetMapping("/{ID}")
    public Optional<City> getCityByID(@PathVariable Integer ID){
        return service.findById(ID);
    }
    
    @PostMapping("/")
    public City save(@RequestBody City city){
        return service.save(city);
    }
    
    @PutMapping("/{ID}")
    public Optional<City> update(@RequestBody City city, @PathVariable Integer ID){
        return service.findById(ID)
                .map(oldCity -> {
                    oldCity.setName(city.getName());
                    return service.save(oldCity);
                });
    }
    
    @DeleteMapping("/{ID}")
    public void update(@PathVariable Integer ID){
        service.deleteById(ID);
    }
}
