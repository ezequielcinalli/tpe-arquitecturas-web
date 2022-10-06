package com.example.tp3.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.tp3.Models.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
}
