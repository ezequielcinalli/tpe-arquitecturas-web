package Repositories;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;

import Dtos.StudentsByCityDto;
import Interfaces.IStudentRepository;
import Models.City;
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
	public List<StudentsByCityDto> getStudentsByCityOnCareer(int careerId) {
		// TODO Auto-generated method stub
		return null;
	}
}
