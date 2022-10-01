package Repositories;

import java.util.List;
import javax.persistence.EntityManager;

import Dtos.CareerReportDto;
import Interfaces.ICareerRepository;
import Models.Career;
import Models.StudentCareer;
import com.sun.xml.fastinfoset.util.ValueArray;

public class CareerRepository implements ICareerRepository {

	EntityManager entityManager;
	
	
	public CareerRepository(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public Career get(int id) {
		return entityManager.find(Career.class, id);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Career> getAll() {
		return (List<Career>) entityManager.createQuery("SELECT c FROM Career c").getResultList();
	}


	@Override
	public void save(Career t) {
		entityManager.persist(t);
	
	}

	@Override
	public void update(Career t) {
		entityManager.merge(t);
		
	}

	@Override
	public void delete(Career t) {
		entityManager.remove(entityManager.contains(t) ? t : entityManager.merge(t));
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Career> careersSortedByStudents(){
		return  (List<Career>) entityManager.createQuery("SELECT c FROM Career c JOIN c. GROUP BY sc.career.id ORDER BY count(sc.student.id)").getResultList();
	}
	
	

}
