package com.example.tp3.Controllers;

import com.example.tp3.Dtos.CareerAddDto;
import com.example.tp3.Dtos.CareerUpdateDto;
import com.example.tp3.Models.Career;
import com.example.tp3.Services.CareerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("careers")
public class CareerController {
    
    @Autowired
    private final CareerService service;
    
    public CareerController(CareerService service){
       this.service = service; 
    }
    
    @GetMapping("/")
    public Iterable<Career> getCarees(){
        return service.findAll();
    }
    
    @GetMapping("/{ID}")
    public Optional<Career> getCareerByID(@PathVariable Integer ID){
        return service.findById(ID);
    }
    
    @PostMapping("/")
    public Career save(@RequestBody CareerAddDto career){
        return service.save(career);
    }
    
    @PutMapping("/{ID}")
    public Career update(@RequestBody CareerUpdateDto career, @PathVariable Integer ID){
    	return service.update(career, ID);                
    }
    
    @DeleteMapping("/{ID}")
    public void delete(@PathVariable Integer ID){
        service.deleteById(ID);
    }
}
