package com.example.tp3.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

import com.example.tp3.Dtos.StudentByCityDto;
import com.example.tp3.Models.Genre;
import com.example.tp3.Models.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    @Query("SELECT s FROM Student s ORDER BY s.name")
    public List<Student> studentSortedByName();

    @Query("SELECT NEW com.example.tp3.Dtos.StudentByCityDto(s.name, s.surname) FROM Student s WHERE s.genre = :genre")
    public List<StudentByCityDto> studentsByGenre(@Param("genre") Genre genre);
}
