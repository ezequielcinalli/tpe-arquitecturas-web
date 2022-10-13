package com.example.tp3.Repositories;

import com.example.tp3.Dtos.CareerReportDto;
import com.example.tp3.Dtos.CareerWithInscriptionsDto;
import com.example.tp3.Dtos.StudentByCityDto;
import com.example.tp3.Models.City;
import com.example.tp3.Models.Genre;
import com.example.tp3.Models.StudentCareer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentCareerRepository extends JpaRepository<StudentCareer, Integer> {
    //TODO: ver si funciona con o sin el new dto. Con new dto() en intelliJ da error sintaxis
    //@Query("SELECT new Dtos.CareerWithInscriptionsDto(c.name,COUNT(sc.student)) FROM StudentCareer sc JOIN sc.career c GROUP BY sc.career.id ORDER BY count(sc.student.id)")
    @Query("SELECT c.name,COUNT(sc.student) FROM StudentCareer sc JOIN sc.career c GROUP BY sc.career.id ORDER BY count(sc.student.id)")
    public List<CareerWithInscriptionsDto> careersSortedByStudents();
    
    @Query("SELECT NEW com.example.tp3.Dtos.StudentByCityDto(s.name, s.surname) FROM Student s JOIN StudentCareer sc ON s.id = sc.key.studentId WHERE sc.key.careerId = :careerId AND s.city.id = :cityId")
    public List<StudentByCityDto> studentsByCareerFilteredCyCity(@Param ("cityId") int cityId, @Param("careerId") int careerId );

    //@Query("") TODO commented because it gives error since the query is not written and can't run the application to continue with other tasks
    //public List<CareerReportDto> careersInformationInscriptionsAndGraduates(); 
}
