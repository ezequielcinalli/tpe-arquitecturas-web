package com.example.tp3.Services;

import com.example.tp3.Dtos.CareerReportDto;
import com.example.tp3.Dtos.CareerWithInscriptionsDto;
import com.example.tp3.Dtos.StudentByCityDto;
import com.example.tp3.Dtos.StudentCareerAddDto;
import com.example.tp3.Dtos.StudentCareerUpdateDto;
import com.example.tp3.Models.Career;
import com.example.tp3.Models.Student;
import com.example.tp3.Models.StudentCareer;
import com.example.tp3.Repositories.StudentCareerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentCareerService {
    @Autowired
    private final StudentCareerRepository repository;
    @Autowired
    private final StudentService studentService;
    @Autowired
    private final CareerService careerService;

    public StudentCareerService(StudentCareerRepository repository, StudentService studentService, CareerService careerService){
        this.repository = repository;
        this.studentService = studentService;
        this.careerService = careerService;
    }

    public Iterable<StudentCareer> findAll(){
        return repository.findAll();
    }

    public Optional<StudentCareer> findById(Integer id){
        return repository.findById(id);
    }

    public StudentCareer save(StudentCareerAddDto studentCareerAddDto){
        Student student = studentService.findById(studentCareerAddDto.studentId).get();
        Career career = careerService.findById(studentCareerAddDto.careerId).get();
        StudentCareer newStudentCareer = new StudentCareer(student,career,studentCareerAddDto.graduationDate,studentCareerAddDto.graduationDate);
        return repository.save(newStudentCareer);
    }

    public StudentCareer update(StudentCareerUpdateDto studentCareerUpdateDto, Integer ID){
        StudentCareer oldStudentCareer = findById(ID).get();
        if(oldStudentCareer.student.getId() != studentCareerUpdateDto.studentId) {
            oldStudentCareer.setStudent(studentService.findById(studentCareerUpdateDto.studentId).get());
        }
        if(oldStudentCareer.career.getId() != studentCareerUpdateDto.careerId) {
            oldStudentCareer.setCareer(careerService.findById(studentCareerUpdateDto.careerId).get());
        }
        oldStudentCareer.setSignUpDate(studentCareerUpdateDto.signUpDate);
        oldStudentCareer.setGraduationDate(studentCareerUpdateDto.graduationDate);
        return repository.save(oldStudentCareer);
    }

    public void deleteById(Integer id){
        repository.deleteById(id);
    }

    public Iterable<CareerWithInscriptionsDto> careersSortedByStudents() {
        return repository.careersSortedByStudents();
    }

    public Iterable<StudentByCityDto> studentsByCareerFilteredCyCity(int cityId,int careerId) {
        return repository.studentsByCareerFilteredCyCity(cityId,careerId);
    }
    /*
    public Iterable<CareerReportDto> careersInformationInscriptionsAndGraduates() {
        return repository.careersInformationInscriptionsAndGraduates();
    }*/
}
