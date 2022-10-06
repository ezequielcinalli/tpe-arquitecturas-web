package com.example.tp3.Repositories;

import com.example.tp3.Models.StudentCareer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentCareerRepository extends JpaRepository<StudentCareer, Integer> {
}
