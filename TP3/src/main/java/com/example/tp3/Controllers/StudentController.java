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

import com.example.tp3.Dtos.StudentAddDto;
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
    
    @GetMapping("/{ID}")
    public Optional<Student> getStudentByID(@PathVariable Integer ID){
        return service.findById(ID);
    }
    
    @PostMapping("/")
    public Student save(@RequestBody StudentAddDto dto){
        return service.save(dto);
    }
    
    @PutMapping("/{ID}")
    public Optional<Student> update(@RequestBody Student student, @PathVariable Integer ID){
        return service.findById(ID)
                .map(oldStudent -> {
                    oldStudent.setName(student.getName());
                    return service.update(oldStudent);
                });
    }
    
    @DeleteMapping("/{ID}")
    public void delete(@PathVariable Integer ID){
        service.deleteById(ID);
    }

}
