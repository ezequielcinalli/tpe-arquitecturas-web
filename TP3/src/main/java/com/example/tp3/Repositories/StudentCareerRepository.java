package com.example.tp3.Repositories;

import com.example.tp3.Dtos.CareerWithInscriptionsDto;
import com.example.tp3.Models.StudentCareer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentCareerRepository extends JpaRepository<StudentCareer, Integer> {
    //TODO: ver si funciona con o sin el new dto. Con new dto() en intelliJ da error sintaxis
    //@Query("SELECT new Dtos.CareerWithInscriptionsDto(c.name,COUNT(sc.student)) FROM StudentCareer sc JOIN sc.career c GROUP BY sc.career.id ORDER BY count(sc.student.id)")
    @Query("SELECT c.name,COUNT(sc.student) FROM StudentCareer sc JOIN sc.career c GROUP BY sc.career.id ORDER BY count(sc.student.id)")
    public List<CareerWithInscriptionsDto> careersSortedByStudents();
}
