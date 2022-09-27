package Interfaces;

import java.util.List;

import Dtos.StudentsByCityDto;
import Models.Student;

public interface IStudentRepository extends IRepositoryBase<Student> {
	
	List<StudentsByCityDto> getStudentsByCityOnCareer(int careerId);

}
