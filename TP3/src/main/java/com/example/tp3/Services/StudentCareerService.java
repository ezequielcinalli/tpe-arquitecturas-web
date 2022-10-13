package com.example.tp3.Services;

import com.example.tp3.Dtos.*;
import com.example.tp3.Models.Career;
import com.example.tp3.Models.Student;
import com.example.tp3.Models.StudentCareer;
import com.example.tp3.Models.StudentCareerId;
import com.example.tp3.Repositories.StudentCareerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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

    public Optional<StudentCareer> findById(Integer studentID, Integer careerId){
        return repository.findById(new StudentCareerId(studentID,careerId));
    }

    public StudentCareer save(StudentCareerAddDto studentCareerAddDto){
        Student student = studentService.findById(studentCareerAddDto.studentId).get();
        Career career = careerService.findById(studentCareerAddDto.careerId).get();
        StudentCareer newStudentCareer = new StudentCareer(student,career,studentCareerAddDto.graduationDate,studentCareerAddDto.graduationDate);
        return repository.save(newStudentCareer);
    }

    public StudentCareer update(StudentCareerUpdateDto studentCareerUpdateDto,Integer studentID, Integer careerId){
        StudentCareer oldStudentCareer = findById(studentID,careerId).get();
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

    public void deleteById(Integer studentId, Integer careerId){
        repository.deleteById(new StudentCareerId(studentId, careerId));
    }

    public Iterable<CareerWithInscriptionsDto> careersSortedByStudents() {
        return repository.careersSortedByStudents();
    }

    public Iterable<StudentByCityDto> studentsByCareerFilteredCyCity(int cityId,int careerId) {
        return repository.studentsByCareerFilteredCyCity(cityId,careerId);
    }

    public List<CareerReportDto> careersInformationInscriptionsAndGraduates(){

        List<CareerReportDto> careerReportDtos = new ArrayList<CareerReportDto>();

        HashSet<Integer> yearsSet = repository.getInscriptionYears();
        yearsSet.addAll(repository.getGraduationYears());
        List<Integer> years = new ArrayList<Integer>(yearsSet);
        Collections.sort(years);

        Iterable<Career> careers =  careerService.findAllOrderedByName();

        for(int year: years) {
            for (Career career : careers) {
                CareerReportDto careerReportDto = new CareerReportDto(career.getName(), year);

                List<String> enrolledStudents = repository.getEnrolledStudents(career.getId(), year);

				
                List<String> graduatedStudents = repository.getGraduatedStudents(career.getId(), year);

                if(enrolledStudents.isEmpty() && graduatedStudents.isEmpty())
                    continue;

                careerReportDto.setEnrolled(enrolledStudents);
                careerReportDto.setGraduated(graduatedStudents);

                careerReportDtos.add(careerReportDto);
            }
        }

        return careerReportDtos;
    }
}
