package com.example.tp3.Controllers;

import com.example.tp3.Dtos.CityAddDto;
import com.example.tp3.Dtos.CityUpdateDto;
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
    public City save(@RequestBody CityAddDto city){
        return service.save(city);
    }
    
    @PutMapping("/{ID}")
    public City update(@RequestBody CityUpdateDto city, @PathVariable Integer ID){
        return service.update(city,ID);
    }
    
    @DeleteMapping("/{ID}")
    public void delete(@PathVariable Integer ID){
        service.deleteById(ID);
    }
}
