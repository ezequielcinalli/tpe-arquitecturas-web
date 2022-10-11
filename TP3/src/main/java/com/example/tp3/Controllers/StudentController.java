package com.example.tp3.Controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tp3.Dtos.StudentAddOrUpdateDto;
import com.example.tp3.Models.Student;
import com.example.tp3.Services.StudentService;

@RestController
@RequestMapping("students")
public class StudentController {
	
	@Autowired
    private final StudentService service;
    
    public StudentController(StudentService service){
       this.service = service; 
    }
    
    @GetMapping("/")
    public Iterable<Student> getAll(){
        return service.findAll();
    }
    
    @GetMapping("/{id}")
    public Optional<Student> getStudentByID(@PathVariable Integer id){
        return service.findById(id);
    }
    
    @PostMapping("/")
    public Student save(@RequestBody StudentAddOrUpdateDto dto){
        return service.save(dto);
    }
    
    @PutMapping("/{id}")
    public Student update(@RequestBody StudentAddOrUpdateDto dto, @PathVariable Integer id){
        return service.update(dto, id);
    }
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        service.deleteById(id);
    }

}
