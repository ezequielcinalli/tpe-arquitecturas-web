package com.example.tp3.Controllers;

import com.example.tp3.Models.City;
import com.example.tp3.Repositories.CityRepository;
import com.example.tp3.Services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
