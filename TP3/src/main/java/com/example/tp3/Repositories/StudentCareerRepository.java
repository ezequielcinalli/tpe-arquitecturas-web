package com.example.tp3.Repositories;

import com.example.tp3.Dtos.CareerWithInscriptionsDto;
import com.example.tp3.Dtos.StudentByCityDto;
import com.example.tp3.Models.StudentCareer;
import com.example.tp3.Models.StudentCareerId;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentCareerRepository extends JpaRepository<StudentCareer, StudentCareerId> {

    //TODO: ver si funciona con o sin el new dto. Con new dto() en intelliJ da error sintaxis
    //@Query("SELECT new com.example.tp3.Dtos.CareerWithInscriptionsDto(c.name) FROM career c")
    @Query("SELECT new com.example.tp3.Dtos.CareerWithInscriptionsDto(c.name,COUNT(sc.student.id)) FROM StudentCareer sc JOIN sc.career c GROUP BY sc.career.id ORDER BY count(sc.student.id)")
    //@Query("SELECT c.name,COUNT(sc.student) FROM StudentCareer sc JOIN sc.career c GROUP BY sc.career.id ORDER BY count(sc.student.id)")

	
    public List<CareerWithInscriptionsDto> careersSortedByStudents();
    
    
    @Query("SELECT DISTINCT YEAR(graduationDate) FROM StudentCareer WHERE graduationDate is not null")
    public List<Integer> getGraduationYears();
    
    @Query("SELECT DISTINCT YEAR(signUpDate) FROM StudentCareer")
    public List<Integer> getInscriptionYears();
    
    @Query("SELECT CONCAT(s.name, ' ', s.surname) " +
            "FROM Student s " +
            "JOIN StudentCareer sc ON s.id = sc.key.studentId " +
            "WHERE sc.key.careerId = :careerId AND YEAR(sc.signUpDate) = :year")
    public List<String> getEnrolledStudents(@Param("careerId") int careerId, @Param("year") int year);

    @Query("SELECT CONCAT(s.name, ' ', s.surname) " +
            "FROM Student s " +
            "JOIN StudentCareer sc ON s.id = sc.key.studentId " +
            "WHERE sc.key.careerId = :careerId AND YEAR(sc.graduationDate) = :year")
    public List<String> getGraduatedStudents(@Param("careerId") int careerId, @Param("year") int year);
    
    @Query("SELECT NEW com.example.tp3.Dtos.StudentByCityDto(s.name, s.surname) FROM Student s JOIN StudentCareer sc ON s.id = sc.key.studentId WHERE sc.key.careerId = :careerId AND s.city.id = :cityId")
    public List<StudentByCityDto> studentsByCareerFilteredCyCity(@Param ("cityId") int cityId, @Param("careerId") int careerId );
}
