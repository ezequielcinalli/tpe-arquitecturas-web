package Repositories;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import Dtos.StudentDto;
import Interfaces.IStudentRepository;
import Models.Genre;
import Models.Student;

public class StudentRepository implements IStudentRepository{
	EntityManager entityManager;
	
	public StudentRepository(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public Student get(int id) {
		return entityManager.find(Student.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Student> getAll() {
		return (List<Student>) entityManager.createQuery("SELECT s FROM Student s").getResultList();
	}

	@Override
	public void save(Student t) {
		entityManager.persist(t);
	}

	@Override
	public void update(Student t) {
		entityManager.merge(t);
		
	}

	@Override
	public void delete(Student t) {
		entityManager.remove(entityManager.contains(t) ? t : entityManager.merge(t));
	}

	@SuppressWarnings("unchecked")
	public List<Student> getStudentsOrderBySurname() {
		return (List<Student>) entityManager.createQuery("SELECT s FROM Student s ORDER BY s.surname, s.name").getResultList();
	}

	@Override
	public List<StudentDto> getStudentsByCityAndCareer(int careerId, int cityId) {
		TypedQuery<StudentDto> query = entityManager.createQuery("""
			SELECT new Dtos.StudentDto(CONCAT(s.name, ' ', s.surname)) 
			FROM Student s 
			JOIN StudentCareer sc ON s.id = sc.key.studentId 
			WHERE sc.key.careerId = :careerId AND s.city.id = :cityId
		""", StudentDto.class);
		query.setParameter("careerId", careerId);
		query.setParameter("cityId", cityId);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Student> getStudentsByGenre(Genre genre) {
		return (List<Student>) entityManager.createQuery("SELECT s FROM Student s WHERE s.genre = :gen", Student.class).setParameter("gen", Genre.Masculino.ordinal()).getResultList();
	}
}
