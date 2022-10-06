package com.example.tp3.Controllers;

import com.example.tp3.Dtos.StudentCareerAddDto;
import com.example.tp3.Models.StudentCareer;
import com.example.tp3.Services.StudentCareerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("student-career")
public class StudentCareerController {

    @Autowired
    private final StudentCareerService service;

    public StudentCareerController(StudentCareerService service){
        this.service = service;
    }

    @GetMapping("/")
    public Iterable<StudentCareer> getStudentCareers(){
        return service.findAll();
    }

    @GetMapping("/{ID}")
    public Optional<StudentCareer> getStudentCareerByID(@PathVariable Integer ID){
        return service.findById(ID);
    }

    @PostMapping("/")
    public StudentCareer save(@RequestBody StudentCareer studentCareer){
        return service.save(studentCareer);
    }

    @PutMapping("/{ID}")
    public Optional<StudentCareer> update(@RequestBody StudentCareerAddDto studentCareer, @PathVariable Integer ID){
        return service.findById(ID)
                .map(oldStudentCareer -> {
//                    oldStudentCareer.setGraduationDate(studentCareer.getGraduationDate());
//                    oldStudentCareer.setSignUpDate(studentCareer.getSignUpDate());
                    return service.save(oldStudentCareer);
                });
    }

    @DeleteMapping("/{ID}")
    public void delete(@PathVariable Integer ID){
        service.deleteById(ID);
    }
}
