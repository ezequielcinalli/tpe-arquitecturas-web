package Repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import Dtos.CareerReportDto;
import Dtos.CareerWithInscriptionsDto;
import Interfaces.IStudentCareerRepository;
import Models.Student;
import Models.StudentCareer;

public class StudentCareerRepository implements IStudentCareerRepository {

	private EntityManager entityManager;
	
	public StudentCareerRepository(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	public StudentCareer get(int id) {
		return entityManager.find(StudentCareer.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<StudentCareer> getAll() {
		return (List<StudentCareer>) entityManager.createQuery("SELECT sc FROM StudentCareer sc").getResultList();
	}

	@Override
	public void save(StudentCareer t) {
		entityManager.persist(t);
	}

	@Override
	public void update(StudentCareer t) {
		entityManager.merge(t);
	}

	@Override
	public void delete(StudentCareer t) {
		entityManager.remove(entityManager.contains(t) ? t : entityManager.merge(t));
	}
	

	public List<CareerWithInscriptionsDto> careersSortedByStudents(){
		TypedQuery<CareerWithInscriptionsDto> result =  entityManager.createQuery("SELECT new Dtos.CareerWithInscriptionsDto(c.name,COUNT(sc.student)) FROM StudentCareer sc JOIN sc.career c GROUP BY sc.career.id ORDER BY count(sc.student.id)",CareerWithInscriptionsDto.class);
		return result.getResultList();
	}

	public List<CareerReportDto> careersInformationInscriptionsAndGraduates(){
		
		List<CareerReportDto> list = entityManager.createQuery("SELECT new Dtos.CareerReportDto(c.career.name, year(c.signUpDate)) FROM StudentCareer c", CareerReportDto.class).getResultList();
		return list;
		
	}
}
