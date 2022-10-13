package com.example.tp3.Controllers;

import com.example.tp3.Dtos.CareerWithInscriptionsDto;
import com.example.tp3.Dtos.StudentByCityDto;
import com.example.tp3.Dtos.StudentCareerAddDto;
import com.example.tp3.Dtos.StudentCareerUpdateDto;
import com.example.tp3.Models.StudentCareer;
import com.example.tp3.Services.StudentCareerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("student-careers")
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

    @GetMapping("/{studentId}/{careerId}")
    public Optional<StudentCareer> getStudentCareerByID(@PathVariable Integer studentId, @PathVariable Integer careerId){
        return service.findById(studentId, careerId);
    }

    @PostMapping("/")
    public StudentCareer save(@RequestBody StudentCareerAddDto studentCareer){
        return service.save(studentCareer);
    }
    
    @PostMapping("/service-b")
    public StudentCareer save_b(@RequestBody StudentCareerAddDto studentCareer){
        return service.save(studentCareer);
    }

    @PutMapping("/{studentId}/{careerId}")
    public StudentCareer update(@RequestBody StudentCareerUpdateDto studentCareer, @PathVariable Integer studentId,@PathVariable Integer careerId){
        return service.update(studentCareer, studentId, careerId);
    }

    @DeleteMapping("/{studentId}/{careerId}")
    public void delete(@PathVariable Integer studentId, Integer careerId){
        service.deleteById(studentId, careerId);
    }

    @GetMapping("/service-f")
    public Iterable<CareerWithInscriptionsDto> careersSortedByStudents() {
        return service.careersSortedByStudents();
    }

    @GetMapping("/service-g/{cityId}/{careerId}")
    public Iterable<StudentByCityDto> studentsByCareerFilteredCyCity(@PathVariable int cityId, @PathVariable  int careerId) {
        return service.studentsByCareerFilteredCyCity(cityId,careerId);
    }
    /*
    @GetMapping("/service2h")
    public Iterable<CareerReportDto> careersInformationInscriptionsAndGraduates() {
        return service.careersInformationInscriptionsAndGraduates();
    }*/
}
