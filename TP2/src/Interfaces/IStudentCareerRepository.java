package Interfaces;

import java.util.List;

import Dtos.CareerWithInscriptionsDto;
import Models.StudentCareer;

public interface IStudentCareerRepository extends IRepositoryBase<StudentCareer> {

	List<CareerWithInscriptionsDto> careersSortedByStudents();
	
}
