package Interfaces;

import java.util.List;

import Dtos.StudentDto;
import Models.Genre;
import Models.Student;

public interface IStudentRepository extends IRepositoryBase<Student> {
	
	List<StudentDto> getStudentsByCityAndCareer(int careerId, int cityId);
	
	List<Student> getStudentsByGenre(Genre genre);
}
