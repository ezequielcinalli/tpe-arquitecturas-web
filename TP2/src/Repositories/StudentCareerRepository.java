package Repositories;

import java.util.List;

import javax.persistence.EntityManager;

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
		List<CareerWithInscriptionsDto> result =  entityManager.createQuery("SELECT new CareerWithInscriptionsDto(c.name,1) FROM Career c",CareerWithInscriptionsDto.class).getResultList();
		return result;
		//return  (List<CareerWithInscriptionsDto>) entityManager.createQuery("SELECT new CareerWithInscriptionsDto(c.name,count(sc.student.id)) FROM StudentCareer sc JOIN sc.career c GROUP BY sc.career.id ORDER BY count(sc.student.id)",CareerWithInscriptionsDto.class).getResultList();
	}

}
