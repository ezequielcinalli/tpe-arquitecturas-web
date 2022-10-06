package com.example.tp3.Controllers;

import com.example.tp3.Models.Career;
import com.example.tp3.Services.CareerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("carees")
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
    public Career save(@RequestBody Career Career){
        return service.save(Career);
    }
    
    @PutMapping("/{ID}")
    public Optional<Career> update(@RequestBody Career Career, @PathVariable Integer ID){
        return service.findById(ID)
                .map(oldCareer -> {
                    oldCareer.setName(Career.getName());
                    return service.save(oldCareer);
                });
    }
    
    @DeleteMapping("/{ID}")
    public void update(@PathVariable Integer ID){
        service.deleteById(ID);
    }
}
