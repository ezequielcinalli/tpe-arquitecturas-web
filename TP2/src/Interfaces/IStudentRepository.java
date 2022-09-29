package Interfaces;

import java.util.List;

import Dtos.StudentDto;
import Models.Student;

public interface IStudentRepository extends IRepositoryBase<Student> {
	
	List<Student> getStudentsOrderBySurname();
	List<StudentDto> getStudentsByCityAndCareer(int careerId, int cityId);

}
