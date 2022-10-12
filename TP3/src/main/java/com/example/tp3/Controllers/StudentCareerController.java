package com.example.tp3.Controllers;

import com.example.tp3.Dtos.CareerReportDto;
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
    public StudentCareer save(@RequestBody StudentCareerAddDto studentCareer){
        return service.save(studentCareer);
    }

    @PutMapping("/{ID}")
    public StudentCareer update(@RequestBody StudentCareerUpdateDto studentCareer, @PathVariable Integer ID){
        return service.update(studentCareer, ID);
    }

    @DeleteMapping("/{ID}")
    public void delete(@PathVariable Integer ID){
        service.deleteById(ID);
    }

    @GetMapping("/service2f")
    public Iterable<CareerWithInscriptionsDto> careersSortedByStudents() {
        return service.careersSortedByStudents();
    }

    @GetMapping("/service2g")
    public Iterable<StudentByCityDto> studentsByCareerFilteredCyCity(@PathVariable int cityId, @PathVariable  int careerId) {
        return service.studentsByCareerFilteredCyCity(cityId,careerId);
    }
    /*
    @GetMapping("/service2h")
    public Iterable<CareerReportDto> careersInformationInscriptionsAndGraduates() {
        return service.careersInformationInscriptionsAndGraduates();
    }*/
}
